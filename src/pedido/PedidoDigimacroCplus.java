/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import acesso.ConexaoDB;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Campocustomvalor;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.cplus.Gtintributavel;
import entidade.cplus.Orcamento;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Produto;
import entidade.cplus.Transportadora;
import entidade.cplus.Unidade;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCarrier;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsGroup;
import entidade.prestaShop.PsMessage;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsSpecificPrice;
import integrador.relatorio.ImprimeRelatorio;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.EmpresaJpaController;
import jpa.cplus.FormapagJpaController;
import jpa.cplus.OrcamentoJpaController;
import jpa.cplus.OrcamentoprodJpaController;
import jpa.cplus.OrcamentostatusJpaController;
import jpa.cplus.PrecoJpaController;
import jpa.cplus.SetorestoqueJpaController;
import jpa.cplus.TipomovimentoJpaController;
import jpa.cplus.TransportadoraJpaController;
import jpa.cplus.VendedorJpaController;
import jpa.prestaShop.PsCustomerJpaController;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsProductJpaController;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class PedidoDigimacroCplus {

    public void criaPedidoCplus(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, PsOrders order, EntityManagerFactory managerPrestaShop) {
        List<Cliente> listCliente = null;
        List<Orcamento> lidtOrcamento = new QueryCplus(managerCplus).listOrcamentoEntregaTelefone(order.getReference());
        boolean condicao = true;
        if (lidtOrcamento.size() > 0) {
            int cancelar = JOptionPane.showConfirmDialog(null, " Deseja Importar novamente o Orçamento? \n O Orçamento no C-Plus Será Excluido!!", "Importar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                for (Orcamento orc : lidtOrcamento) {
                    for (Orcamentoprod prod : orc.getOrcamentoprodCollection()) {
                        try {
                            new OrcamentoprodJpaController(managerCplus).destroy(prod.getCodorcprod());
                        } catch (jpa.cplus.exceptions.IllegalOrphanException | jpa.cplus.exceptions.NonexistentEntityException ex) {
                            JOptionPane.showMessageDialog(null, "Houve um Erro ao Excluir o Orçamento \n" + ex);
                        }
                    }
                    try {
                        new OrcamentoJpaController(managerCplus).destroy(orc.getCodorc());
                    } catch (jpa.cplus.exceptions.IllegalOrphanException | jpa.cplus.exceptions.NonexistentEntityException ex) {
                        JOptionPane.showMessageDialog(null, "Houve um Erro ao Excluir o Orçamento \n" + ex);
                    }
                }
            } else {
                condicao = false;
            }
        }
        if (condicao) {
            if (order.getModule().equals("custompaymentmethod_1")) {
                listCliente = new QueryCplus(managerCplus).listCliente(new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CODIGO_PARA_CUPOM"));
            } else {
                listCliente = new QueryCplus(managerCplus).listClientCpfCnpj(new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer()).getSiret().replaceAll("[^0-9]", ""));
            }//fim else que verifica se cliente não é cupom
            // }//fim for orderPayment
            if (listCliente.isEmpty()) {//if lista cliente
                JOptionPane.showMessageDialog(null, "não foi possivel localizar o cliente, Verifique!!! \n Código Cliente Site é: " + new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdOrder()).getLastname());
            } else {
                for (Cliente cliente : listCliente) {
                    List<Clientecaracteristica> listCarac = new QueryCplus(managerCplus).listClienteCaracteristica(new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO"), cliente.getCodcli());
                    if (listCarac.size() == 1) {

                        if (verificaEndereco(managerIntegrador, managerPrestaShop, cliente, order) == false) {
                            int cancelar = JOptionPane.showConfirmDialog(null, " O endereço do C-plus está diferente do entereço do Site "
                                    + "\n Cliente: " + cliente.getNomecli()
                                    + "\n Cpf/Cnpj: " + cpfCnpj(cliente)
                                    + "\n ATUALIZAR O ENDEREÇO??? "
                                    + "\n Data Atualização Cplus: "
                                    + new FormataCampos().dataStringDataCompleta(cliente.getLastChange(), 0) + "\n Data Atualização Site: "
                                    + new FormataCampos().dataStringDataCompleta(new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer()).getDateUpd(), 0), "Atualizar", JOptionPane.YES_NO_CANCEL_OPTION);
                            if (cancelar == JOptionPane.NO_OPTION) {
                                condicao = false;
                            }
                        }
                        if (condicao) {
                            Integer configCont = new ConexaoDB().ultimoCodigo("ORCAMENTO", "CODORC");
                            Orcamento orc = new Orcamento();
                            orc.setCodorc(String.format("%09d", configCont));
                            orc.setCodcli(cliente);
                            //if (cliente.getCodvended() != null) {
                            //   orc.setCodvended(new VendedorJpaController(managerCplus).findVendedor(cliente.getCodvended().getCodvended()));
                            //}
                            orc.setCodvended(null);
                            orc.setFlagdelivery('N');
                            orc.setFlagprevenda('N');
                            orc.setDatacadastro(new Date(System.currentTimeMillis()));
                            orc.setTempo(new Date(System.currentTimeMillis()));
                            orc.setValorentrada(BigDecimal.ZERO);
                            orc.setIndpresenca('1');
                            orc.setIdentificadordestino('1');
                            orc.setValoricmsstdesonerado(BigDecimal.ZERO);
                            orc.setValorfcp(BigDecimal.ZERO);
                            orc.setValorfcpsubsttributaria(BigDecimal.ZERO);
                            orc.setValoricmsdesonerado(BigDecimal.ZERO);

                            orc.setCodpreco(new PrecoJpaController(managerCplus).findPreco("000000001"));
                            if (cliente.getCodtrans() != null) {
                                orc.setCodtrans(new TransportadoraJpaController(managerCplus).findTransportadora(cliente.getCodtrans().getCodtrans()));
                            }
                            if (cliente.getCodfp() != null) {
                                orc.setCodfp(new FormapagJpaController(managerCplus).findFormapag(cliente.getCodfp().getCodfp()));
                            }
                            orc.setData(new Date(System.currentTimeMillis()));
                            orc.setFlagcli('Y');
                            orc.setNomecli(cliente.getNomecli());
                            orc.setObs(observacao(cliente, order, managerIntegrador, managerPrestaShop));
                            orc.setFlagreservado('N');
                            orc.setFlagpalm((short) 0);
                            orc.setCodempresa(new EmpresaJpaController(managerCplus).findEmpresa(1));
                            orc.setFlagstatus('O');
                            //orc.setValorfrete(order.getTotalShippingTaxIncl().setScale(2, RoundingMode.HALF_UP));
                            orc.setValorfrete(BigDecimal.ZERO);
                            orc.setEntregatelefone(order.getReference());
                            orc.setValoracrescimo(BigDecimal.ZERO);
                            orc.setHora(new Date(System.currentTimeMillis()));
                            orc.setCoduser("000000003");
                            if ("RS".equals(cliente.getEstado())) {
                                orc.setCodcfop(cliente.getCodtipomovimento().getCodcfopdentrouf());
                            } else {
                                orc.setCodcfop(cliente.getCodtipomovimento().getCodcfopforauf());
                            }
                            orc.setCodsetorestoque(new SetorestoqueJpaController(managerCplus).findSetorestoque("000000001"));
                            orc.setValorseguro(BigDecimal.ZERO);
                            orc.setBasesubsttributaria(BigDecimal.ZERO);
                            orc.setValorsubsttributaria(BigDecimal.ZERO);
                            orc.setValoroutrasdespesas(BigDecimal.ZERO);
                            orc.setBaseicms(BigDecimal.ZERO);
                            orc.setValoricms(BigDecimal.ZERO);
                            orc.setAliqacrescimo(BigDecimal.ZERO);
                            if (order.getTotalShippingTaxIncl().doubleValue() < 1800.00) {
                                if (order.getTotalShippingTaxIncl().doubleValue() < 1.00) {
                                    orc.setFlagfrete('D');
                                } else {
                                    orc.setFlagfrete('E');
                                }
                            } else {
                                orc.setFlagfrete('E');
                            }
                            // orc.setCodtrans(transportadora(managerPrestaShop, managerCplus, order, cliente));
                            orc.setValortotal(BigDecimal.ZERO);
                            orc.setValortotalipi(BigDecimal.ZERO);
                            orc.setValortotalprodutos(BigDecimal.ZERO);
                            if (cliente.getCodtipomovimento() != null) {
                                orc.setCodtipomovimento(new TipomovimentoJpaController(managerCplus).findTipomovimento(cliente.getCodtipomovimento().getCodtipomovimento()));
                            }
                            orc.setCampovalor1(new BigDecimal(100.0000));
                            orc.setCodorcamentostatus(new OrcamentostatusJpaController(managerCplus).findOrcamentostatus("000000001"));
                            orc.setFlagaltpaf('N');
                            int numOrcamento = new ConexaoDB().ultimoCodigo("ORCAMENTO", "NUMEROORCAMENTO");
                            orc.setNumeroorcamento(String.format("%09d", numOrcamento));
                            orc.setFlagestoqueliberado('Y');
                            orc.setValortotalcofins(BigDecimal.ZERO);
                            orc.setValortotalpis(BigDecimal.ZERO);
                            orc.setValortotalservicos(BigDecimal.ZERO);
                            orc.setValortotalservicos(BigDecimal.ZERO);
                            orc.setValortotaliss(BigDecimal.ZERO);
                            orc.setRentabilidade(BigDecimal.ZERO);
                            orc.setFlagimpresso('N');
                            orc.setQuantidadevolumes(1);
                            orc.setFlagdescautorizado('N');

                            configCont++;
                            new ConexaoDB().atualizarCodigo("ORCAMENTO", "CODORC", configCont);
                            numOrcamento++;
                            new ConexaoDB().atualizarCodigo("ORCAMENTO", "NUMEROORCAMENTO", numOrcamento);

                            try {
                                new OrcamentoJpaController(managerCplus).create(orc);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Houve um erro ao Importar Pedido!!! \n" + ex);
                            }
                            //List<PedidoProdutoIntegrador> listProduto = new PedidoProdutoIntegradorJpaController(managerIntegracao).codigoPedido(pedidoIntegrador.getIdPedido());                        
                            // for (PedidoProdutoIntegrador produto : listProduto) {
                            lidtOrcamento = new QueryCplus(managerCplus).listOrcamentoEntregaTelefone(order.getReference());
                            boolean imprimir = false;
                            for (Orcamento orcamento : lidtOrcamento) {
                                for (PsOrderDetail orderItem : new QueryPrestaShop(managerPrestaShop).listPsOrderDetail(order.getIdOrder())) {
                                    if (new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getCacheIsPack()) {
                                        PsCustomer C = new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer());
                                        PsGroup G = new PsGroupJpaController(managerPrestaShop).findPsGroup(C.getIdDefaultGroup());
                                        BigDecimal descPac = BigDecimal.ZERO;
                                        List<PsSpecificPrice> listPric = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(orderItem.getProductId(), G.getIdGroup());
                                        if (listPric.isEmpty()) {
                                            listPric = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(orderItem.getProductId(), 0);// para todos os grupos
                                        }
                                        for (PsSpecificPrice specificPrice : listPric) {
                                            if ("percentage".equals(specificPrice.getReductionType())) {
                                                descPac = specificPrice.getReduction();
                                            }
                                        }
                                        int quantPack = orderItem.getProductQuantity();// tem que receber o valor fora do pacote
                                        for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(orderItem.getProductId())) {
                                            PsProduct P = new PsProductJpaController(managerPrestaShop).findPsProduct(psP.getPsPackPK().getIdProductItem());
                                            BigDecimal precUni = P.getPrice();
                                            int quanProdutosPack = psP.getQuantity();//quantidade de produtos que tem no pacote
                                            BigDecimal quantidade = new BigDecimal(quantPack * quanProdutosPack);//é a quantidade do pacote x quantidade de pacote comprado
                                            BigDecimal redGrup = G.getReduction().divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
                                            precUni = precUni.multiply(BigDecimal.ONE.subtract(redGrup)); //redução do grupo
                                            precUni = precUni.multiply((BigDecimal.ONE.subtract(descPac))).setScale(2, RoundingMode.HALF_UP); //redução do pacote de produto
                                            orderItem.setProductId(psP.getPsPackPK().getIdProductItem());
                                            orderItem.setEcotax(BigDecimal.ZERO);
                                            orderItem.setProductQuantity(quantidade.intValue());
                                            orderItem.setUnitPriceTaxIncl(precUni);
                                            orderItem.setTotalPriceTaxIncl(precUni.multiply(quantidade));
                                            if (imprimir) {
                                                criaPedidoProdutoCplus(true, managerIntegrador, managerCplus, managerPrestaShop, orderItem, orcamento, cliente);
                                            } else {
                                                criaPedidoProdutoCplus(false, managerIntegrador, managerCplus, managerPrestaShop, orderItem, orcamento, cliente);
                                            }
                                        }
                                    } else {
                                        if (imprimir) {
                                            criaPedidoProdutoCplus(true, managerIntegrador, managerCplus, managerPrestaShop, orderItem, orcamento, cliente);
                                        } else {
                                            criaPedidoProdutoCplus(false, managerIntegrador, managerCplus, managerPrestaShop, orderItem, orcamento, cliente);
                                        }
                                    }
                                }//for order item
                                if (imprimir) {
                                    new ImprimeRelatorio().imprimeRelatorioPeloJar("/integrador/relatorio/Orcamento.jrxml", new ManutencaoVenda().imprimirOrcamento(order, managerCplus, managerPrestaShop));
                                }
                            }//for orçamento
                            lidtOrcamento = new QueryCplus(managerCplus).listOrcamentoEntregaTelefone(order.getReference());
                            for (Orcamento orcamento : lidtOrcamento) {
                                editaOrcamento(imprimir, order, orcamento, managerCplus);
                            }
                        }//if  que verifica alteração de endereço pelo cliente  
                    }
                }// for cliente
            }//fim else que verifica cliente existente
        }//if condição para importar pedido
    }

    private String cpfCnpj(Cliente clienteCplus) {
        String str;
        if ("N".equals(clienteCplus.getFlagfisica().toString())) {
            str = clienteCplus.getCnpj();
            //  str = new FormataCampos().mascaraCNPJ(clienteCplus.getCnpj());
        } else {
            //  str = new FormataCampos().mascaraCPF(clienteCplus.getCpf());
            str = clienteCplus.getCpf();
        }
        return str;
    }

    private String observacao(Cliente cli, PsOrders order, EntityManagerFactory managerIntegrador, EntityManagerFactory managerPrestaShop) {
        String obs = "";
        if (new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CODIGO_PARA_CUPOM").equals(cli.getCodcli())) {
            obs = "Nome: " + new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer()).getFirstname() + " "
                    + new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer()).getLastname() + " \n"
                    + "CNPJ/CPF: " + new FormataCampos().mascaraCNPJouCPF(new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer()).getSiret()) + "\n";
        }
        for (PsMessage mens : new QueryPrestaShop(managerPrestaShop).listPsMessage(order.getIdOrder())) {
            obs = obs + mens.getMessage() + "\n";
        }
        return obs;
    }

    private boolean verificaEndereco(EntityManagerFactory managerIntegrador, EntityManagerFactory managerPrestaShop, Cliente cliente, PsOrders po) {
        boolean condicao = false;
        String ende = cliente.getEndereco();
        //String bairro = cliente.getBairro();
        String numero;
        if (cliente.getNumerologradouro() == null) {
            numero = "";
        } else {
            numero = cliente.getNumerologradouro();
        }
        String complemento;
        if (cliente.getComplementologradouro() == null) {
            complemento = "";
        } else {
            complemento = cliente.getComplementologradouro();
        }
        List<PsAddress> listText = new QueryPrestaShop(managerPrestaShop).listEndereco(false, po.getIdCustomer(), endereco(ende, numero, complemento));
        if (listText.size() > 0) {
            condicao = true;
        } else {
            //JOptionPane.showMessageDialog(null, "ENDEREÇO DO SITE DIFERENTE DO C-PLUS, Verifique!!! \n Cliente: " + cliente.getNomecli());
        }
        if (listText.size() > 0 || new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CODIGO_PARA_CUPOM").equals(cliente.getCodcli())) {
            condicao = true;
        }
        return condicao;
    }

    private String endereco(String nomeRua, String numeroRua, String complemento) {
        String stringSeparada = nomeRua + " " + numeroRua + " " + complemento;
        return stringSeparada;
    }

    private void criaPedidoProdutoCplus(boolean alterarValor, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, PsOrderDetail orderItem, Orcamento orcamento, Cliente cli) {
        QueryCplus queryCplus = new QueryCplus(managerCplus);
        //int decimaisArredondamento = Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        Calculoicmsestado calculoIcmsEstado = null;
        String cfop;
        String cfopSecundaria;
        List<Produto> listProduto = queryCplus.listProduto(new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getReference());
        int count = 0;
        for (Produto prodCplus : listProduto) {
            if ("RS".equals(cli.getEstado())) {
                cfop = "5405";
                cfopSecundaria = "5102";
            } else {
                cfop = "6403";
                cfopSecundaria = "6102";
            }
            List<Calculoicmsestado> listCalculoIcmsEstado;
            listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", cli.getEstado(), cfop, prodCplus.getCodcalculoicms().getCodcalculoicms());
            if (listCalculoIcmsEstado.isEmpty()) {
                listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", cli.getEstado(), cfopSecundaria, prodCplus.getCodcalculoicms().getCodcalculoicms());
            }
            if (listCalculoIcmsEstado.size() == 1) {
                for (Calculoicmsestado icms : listCalculoIcmsEstado) {
                    calculoIcmsEstado = icms;
                }
                Orcamentoprod prod = new Orcamentoprod();
                prod.setCodorc(orcamento);
                prod.setCodprod(prodCplus);
                prod.setCodorcprod(new QueryCplus(managerCplus).incrementOrcProd());

                //prod.setCodorcprod(String.format("%06d", orderItem.getIdOrderDetail()));                            
                prod.setCodempresa(new EmpresaJpaController(managerCplus).findEmpresa(1));
                prod.setCodpreco(new PrecoJpaController(managerCplus).findPreco("000000001"));
                boolean cliRuim = false;
                for (Clientecaracteristica cliCaract : orcamento.getCodcli().getClientecaracteristicaCollection()) {
                    if (cliCaract.getCodcli().getCodcli() == null ? new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO_RUIM") == null : cliCaract.getCodcli().getCodcli().equals(new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO_RUIM"))) {
                        cliRuim = true;
                    }
                }
                if (cliRuim) {
                    prod.setValorsubsttributaria(BigDecimal.ZERO);
                } else {
                    prod.setValorsubsttributaria(orderItem.getEcotax().setScale(2, RoundingMode.HALF_UP));
                }
                double aliqIcms;
                double baseIcms;
                double valorIcms;
                double aliqReducaoIcms;
                double baseCofins;
                double aliqCofins;
                double basePis;
                double aliqPis;
                double valorCofins;
                double valorPis;
                BigDecimal valorTotal;
                BigDecimal valUni;
                prod.setQuantidade(new BigDecimal(orderItem.getProductQuantity()));
                valUni = orderItem.getUnitPriceTaxIncl().setScale(2, RoundingMode.HALF_UP);
                valorTotal = valUni.multiply(prod.getQuantidade());
                prod.setValorunitario(valUni);

                prod.setValortotal(valorTotal);
                prod.setFlagtipoacrescimoitem('V');
                //double valorTotalProduto = pedidoProdIntegrador.getPrecoTotal().doubleValue();
                List<Campocustomvalor> lisCustom = queryCplus.resultCampoPersonalisado(prodCplus.getCodprod());
                String text = "";
                for (Campocustomvalor cus : lisCustom) {
                    if ("000000003".equals(cus.getCodcampocustommaster().getCodcampocustommaster())) {
                        if (cus.getValor() != null) {
                            text = text + cus.getValor() + " ";
                        }
                    }
                }

                if (calculoIcmsEstado.getAliqicms() == null) {
                    aliqIcms = 0.00;
                } else {
                    aliqIcms = calculoIcmsEstado.getAliqicms().doubleValue();
                }
                if (aliqIcms > 0.00) {
                    if (calculoIcmsEstado.getAliqreducaobaseicms() == null) {
                        aliqReducaoIcms = 0.00;
                    } else {
                        aliqReducaoIcms = calculoIcmsEstado.getAliqreducaobaseicms().doubleValue();
                    }
                    baseIcms = (100 - aliqReducaoIcms) * valorTotal.doubleValue() / 100;


                    //if ("N".equals(cli.getFlagusaaliqicmsdiferenciada().toString())) {

                    if ("N".equals(cli.getFlagusaaliqicmsdiferenciada().toString()) && "RS".equals(calculoIcmsEstado.getCodufdestino().getCoduf())) {                      

                        valorIcms = baseIcms * 12.0 / 100;
                        double aliqDeferimento = 0.0;
                        if (calculoIcmsEstado.getAliqdiferimento() == null) {
                            aliqDeferimento = calculoIcmsEstado.getAliqdiferimento().doubleValue(); //ex 29.412
                        }
                        prod.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributaria());
                        if (aliqDeferimento > 0.0) {
                            double valorIcmsOperacao = (calculoIcmsEstado.getAliqicms().doubleValue() * baseIcms) / 100;
                            prod.setValoricmsoperacao(new BigDecimal(valorIcmsOperacao).setScale(2, RoundingMode.HALF_EVEN));
                            prod.setValoricmsdiferimento(new BigDecimal(valorIcmsOperacao - valorIcms).setScale(2, RoundingMode.HALF_EVEN));
                            text = "Diferimento parcial do ICMS conforme Art. 1º-K do Livro III do RICMS/RS";
                        }
                    } else {
                        valorIcms = baseIcms * aliqIcms / 100;
                        prod.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributariadif());
                    }
                } else {
                    aliqIcms = 0.00;
                    baseIcms = 0.00;
                    valorIcms = 0.00;
                }

                prod.setComplemento(text);

                prod.setBaseicms(new BigDecimal(baseIcms).setScale(2, RoundingMode.HALF_EVEN));
                prod.setAliqicms(new BigDecimal(aliqIcms).setScale(2, RoundingMode.HALF_EVEN));
                prod.setValoricms(new BigDecimal(valorIcms).setScale(2, RoundingMode.HALF_EVEN));
                prod.setBaseipi(BigDecimal.ZERO);
                prod.setAliqipi(BigDecimal.ZERO);
                prod.setValoripi(BigDecimal.ZERO);
                prod.setBasesubsttributaria(BigDecimal.ZERO);
                prod.setFlag1('Y');
                prod.setFlag2('Y');
                prod.setFlag3('N');
                prod.setDatainclusao(new Date(System.currentTimeMillis()));
                //prod.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributaria());
                prod.setCodcfop(calculoIcmsEstado.getCodcfop().getCodcfop());
                if (calculoIcmsEstado.getAliqcofins() == null) {
                    aliqCofins = 0.00;
                    baseCofins = 0.00;
                } else {
                    baseCofins = valorTotal.doubleValue() - valorIcms;
                    aliqCofins = calculoIcmsEstado.getAliqcofins().doubleValue();
                }
                valorCofins = baseCofins * aliqCofins / 100;
                prod.setBasecofins(new BigDecimal(baseCofins).setScale(2, RoundingMode.HALF_EVEN));
                prod.setAliqcofins(new BigDecimal(aliqCofins).setScale(2, RoundingMode.HALF_EVEN));
                prod.setValorcofins(new BigDecimal(valorCofins).setScale(2, RoundingMode.HALF_EVEN));

                if (calculoIcmsEstado.getAliqpis() == null) {
                    aliqPis = 0.00;
                    basePis = 0.00;
                } else {
                    basePis = valorTotal.doubleValue() - valorIcms;
                    aliqPis = calculoIcmsEstado.getAliqpis().doubleValue();
                }
                valorPis = basePis * aliqPis / 100;
                prod.setBasepis(new BigDecimal(basePis).setScale(2, RoundingMode.HALF_EVEN));
                prod.setAliqpis(new BigDecimal(aliqPis).setScale(2, RoundingMode.HALF_EVEN));
                prod.setValorpis(new BigDecimal(valorPis).setScale(2, RoundingMode.HALF_EVEN));
                prod.setCstpis(calculoIcmsEstado.getCstpis());
                prod.setCstcofins(calculoIcmsEstado.getCstcofins());
                prod.setFlagitemcancelado('N');
                prod.setFlagcancelado('N');
                prod.setFlagaltpaf('N');

                prod.setFlagtipodescontoitem('V');
                prod.setAliqdescontoitem(BigDecimal.ZERO);
                prod.setValordescontoitem(BigDecimal.ZERO);
                prod.setAliqacrescimoitem(BigDecimal.ZERO);
                prod.setValoracrescimoitem(BigDecimal.ZERO);
                prod.setAliqiss(BigDecimal.ZERO);
                prod.setValoriss(BigDecimal.ZERO);
                prod.setDescricaoproduto(prodCplus.getNomeprod());
                prod.setPrecotabela(valUni);
                short sh = (short) count++;
                prod.setNumeroitem(sh);
                prod.setCodcalculoicms(calculoIcmsEstado.getCodcalculoicms().getCodcalculoicms());
                prod.setCodclassificacaofiscal(prodCplus.getCodclassificacaofiscal().getCodclassificacaofiscal());
                prod.setCodigoproduto(prodCplus.getCodigo());
                for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(prodCplus.getUnidade())) {
                    prod.setUnidade(un.getCodunidade());
                }
                prod.setTipotributacao('T');
                prod.setAliqtributacao(calculoIcmsEstado.getAliqicms());
                prod.setNumeroorcamento(orcamento.getNumeroorcamento());
                prod.setAliqfcpStUfDestino(BigDecimal.ZERO);
                prod.setAliqmva(BigDecimal.ZERO);
                if(prodCplus.getCodgtintributavel() != null){
                    prod.setGtin(prodCplus.getCodgtintributavel().getGtin());
                }
                prod.setGtintrib("");
                prod.setUnidadetrib("");
                prod.setQuantidadeembalagem(BigDecimal.ZERO);
                prod.setCodigomotivodeso("");
                prod.setAliqreducaobaseicms(BigDecimal.ZERO);
                prod.setValorfreterateado(BigDecimal.ZERO);
                prod.setValorsegurorateado(BigDecimal.ZERO);
                prod.setValoroutrasdesprateado(BigDecimal.ZERO);
                prod.setValoracrescimorateado(BigDecimal.ZERO);
                prod.setValordescontorateado(BigDecimal.ZERO);
                prod.setAliqreducaobasesubsttributaria(BigDecimal.ZERO);
                prod.setCustoreal(prodCplus.getCustoreal());
                prod.setAliqfcp(BigDecimal.ZERO);
                prod.setValorfcp(BigDecimal.ZERO);
                prod.setValorfcpsubsttributaria(BigDecimal.ZERO);
                prod.setAliqdiferimento(BigDecimal.ZERO);
                prod.setAliqfcpdiferimento(BigDecimal.ZERO);
               

                try {
                    new OrcamentoprodJpaController(managerCplus).create(prod);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao Importar Produto do Pedido!!! \n" + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o calculo de ICMS do Produto: \n" + prodCplus.getNomeprod() + " verifique o cadastro no C-Plus!!! \n");
                List<Orcamentoprod> listOrcProd = queryCplus.listProdutosOrcemanto(orcamento.getCodorc());
                for (Orcamentoprod prod : listOrcProd) {
                    try {
                        new OrcamentoprodJpaController(managerCplus).destroy(prod.getCodorcprod());
                    } catch (jpa.cplus.exceptions.IllegalOrphanException | jpa.cplus.exceptions.NonexistentEntityException ex) {
                        JOptionPane.showMessageDialog(null, "Houve um erro ao Deletar produto do pedido no Integrador!!! \n" + ex);
                    }
                }//fim for que deleta produto do pedido integrador
                try {
                    new OrcamentoJpaController(managerCplus).destroy(orcamento.getCodorc());
                } catch (jpa.cplus.exceptions.IllegalOrphanException | jpa.cplus.exceptions.NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao Deletar pedido no Integrador!!! \n" + ex);
                }
            }
        }//for produto
    }

    private boolean editaOrcamento(boolean alteraValor, PsOrders psOrders, Orcamento orcamento, EntityManagerFactory managerCplus) {
        boolean condicao = true;
        QueryCplus queryCplus = new QueryCplus(managerCplus);
        List<Orcamentoprod> listMovProd = queryCplus.listProdutosOrcemanto(orcamento.getCodorc());
        if (listMovProd.isEmpty()) {
            orcamento.setBaseicms(BigDecimal.ZERO);
            orcamento.setValoricms(BigDecimal.ZERO);
            orcamento.setBasesubsttributaria(BigDecimal.ZERO);
            orcamento.setValorsubsttributaria(BigDecimal.ZERO);
            // orcamento.setValorfrete(psOrders.getTotalShippingTaxIncl().setScale(2, RoundingMode.HALF_UP));
            orcamento.setValorfrete(BigDecimal.ZERO);
            orcamento.setValoroutrasdespesas(BigDecimal.ZERO);
            orcamento.setValortotalprodutos(BigDecimal.ZERO);
            //saida.setValortotalnota(BigDecimal.ZERO);
            orcamento.setValortotalipi(BigDecimal.ZERO);
            orcamento.setValortotalcofins(BigDecimal.ZERO);
            orcamento.setValortotalpis(BigDecimal.ZERO);
        } else {
            BigDecimal valIcms = BigDecimal.ZERO;
            BigDecimal basIcms = BigDecimal.ZERO;
            BigDecimal basSt = BigDecimal.ZERO;
            BigDecimal valSt = BigDecimal.ZERO;
            BigDecimal valTotalProdutos = BigDecimal.ZERO;
            BigDecimal valIpi = BigDecimal.ZERO;
            BigDecimal valPis = BigDecimal.ZERO;
            BigDecimal valCofins = BigDecimal.ZERO;
            for (Orcamentoprod prod : listMovProd) {
                valIcms = valIcms.add(prod.getValoricms());
                basIcms = basIcms.add(prod.getBaseicms());
                basSt = basSt.add(prod.getBasesubsttributaria());
                valSt = valSt.add(prod.getValorsubsttributaria());
                valTotalProdutos = valTotalProdutos.add(prod.getValortotal());
                valIpi = valIpi.add(prod.getValoripi());
                valPis =  valPis.add(prod.getValorpis());
                valCofins = valCofins.add(prod.getValorcofins());
            }//fim for que soma o total dos valores
            orcamento.setBaseicms(basIcms.setScale(2, RoundingMode.HALF_UP));
            orcamento.setValoricms(valIcms.setScale(2, RoundingMode.HALF_UP));
            orcamento.setBasesubsttributaria(basSt.setScale(2, RoundingMode.HALF_UP));
            orcamento.setValorsubsttributaria(valSt.setScale(2, RoundingMode.HALF_UP));

            if (!"RS".equals(orcamento.getCodcli().getEstado())) {
                orcamento.setIdentificadordestino('2');
                if (orcamento.getValoricms().doubleValue() > 0.00) {
                    orcamento.setCodcfop("6102");
                } else {
                    orcamento.setCodcfop("6403");
                }
            }       
            BigDecimal valorDesconto = valTotalProdutos.subtract(psOrders.getTotalPaidTaxIncl());
            BigDecimal valorTaxa = BigDecimal.ZERO;
            if (alteraValor == false) {
                if (valorDesconto.doubleValue() == 0.00) { //quando valor dos produtos for igual ao total
                    orcamento.setAliqdesconto(BigDecimal.ZERO);
                    orcamento.setValordesconto(BigDecimal.ZERO);
                } else if (valorDesconto.doubleValue() > 0) {//quando for desconto
                    valorTaxa = valorDesconto.divide(valTotalProdutos, 6, RoundingMode.HALF_UP).multiply(new BigDecimal("100.00"));
                    orcamento.setAliqdesconto(valorTaxa);
                    orcamento.setValordesconto(valorDesconto.setScale(2, RoundingMode.HALF_UP));
                    orcamento.setFlagtipodesconto('A');
                } else {//quando passar a ser acréscimo
                    valorDesconto = psOrders.getTotalPaidTaxIncl().subtract(valTotalProdutos);
                    valorTaxa = valorDesconto.divide(valTotalProdutos, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100.00"));
                    orcamento.setAliqacrescimo(valorTaxa);
                    orcamento.setValoracrescimo(valorDesconto.setScale(2, RoundingMode.HALF_UP));
                    orcamento.setFlagtipoacrescimo('A');
                }
            }
            // orcamento.setValortotalprodutos(new BigDecimal(valTotalProdutos - valorDesconto).setScale(2, RoundingMode.HALF_UP));
            orcamento.setValortotalprodutos(valTotalProdutos);
            orcamento.setValortotalcofins(valCofins.setScale(2, RoundingMode.HALF_UP));
            orcamento.setValortotalpis(valPis.setScale(2, RoundingMode.HALF_UP));           
            orcamento.setBaseicms(basIcms.setScale(2, RoundingMode.HALF_UP));
            orcamento.setValoricms(valIcms.setScale(2, RoundingMode.HALF_UP));
            orcamento.setValortotalorcamento(valTotalProdutos.subtract(valorDesconto));
        }

        try {
            new OrcamentoJpaController(managerCplus).edit(orcamento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Orçamento!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }

    private Transportadora transportadora(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerCplus, PsOrders order, Cliente cliente) {
        String codTrans = "000000054";
        for (PsCarrier psCarrier : new QueryPrestaShop(managerPrestaShop).listPsCarrier(order.getIdCarrier())) {
            if ("Leomar".equals(psCarrier.getName())) {
                //leomar "000000007";
                codTrans = "000000007";
            } else if ("Santa Cruz".equals(psCarrier.getName())) {
                //Santa Cruz "004"
                codTrans = "004";
            } else if ("Retirada na Loja".equals(psCarrier.getName())) {
                //Retira na loja "000000054"
                codTrans = "000000054";
            } else if ("Outras".equals(psCarrier.getName())) {
                if (cliente.getCodtrans() != null) {
                    codTrans = cliente.getCodtrans().getCodtrans();
                }
            }
        }
        return new TransportadoraJpaController(managerCplus).findTransportadora(codTrans);
    }

    private BigDecimal fatorConversaoBigDecimal(Produto prodCplus, EntityManagerFactory managerCplus) {
        BigDecimal quantidade = BigDecimal.ONE;
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao();
            }
        }
        return quantidade;
    }
}
