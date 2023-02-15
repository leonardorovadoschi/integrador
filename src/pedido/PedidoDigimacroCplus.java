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
import query.cplus.QueryCplus;
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
                            if (cliente.getCodvended() != null) {
                                orc.setCodvended(new VendedorJpaController(managerCplus).findVendedor(cliente.getCodvended().getCodvended()));
                            }
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
                            orc.setNumeroorcamento(String.valueOf(numOrcamento));
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
                                if (new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CODIGO_PARA_CUPOM").equals(cliente.getCodcli())) {
                                    int cancelar = JOptionPane.showConfirmDialog(null, " Modificar Valor Orçamento?", "Altera Valores", JOptionPane.YES_NO_OPTION);
                                    if (cancelar == JOptionPane.YES_OPTION) {
                                        imprimir = true;
                                    }
                                }
                                for (PsOrderDetail orderItem : new QueryPrestaShop(managerPrestaShop).listPsOrderDetail(order.getIdOrder())) {

                                    if (new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getCacheIsPack()) {
                                        //for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getIdProduct())) {
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
                                            BigDecimal redGrup = G.getReduction().divide(new BigDecimal("100.00"), BigDecimal.ROUND_HALF_UP);
                                            precUni = precUni.multiply(BigDecimal.ONE.subtract(redGrup)); //redução do grupo
                                            precUni = precUni.multiply((BigDecimal.ONE.subtract(descPac))).setScale(2, BigDecimal.ROUND_HALF_UP); //redução do pacote de produto
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
                                    new ImprimeRelatorio().imprimeRelatorio("/integrador/relatorio/Orcamento.jrxml", new ManutencaoVenda().imprimirOrcamento(order, managerCplus, managerPrestaShop));
                                }
                            }//for orçamento
                            lidtOrcamento = new QueryCplus(managerCplus).listOrcamentoEntregaTelefone(order.getReference());
                            for (Orcamento orcamento : lidtOrcamento) {
                                editaOrcamento(imprimir, order, orcamento, managerCplus, managerIntegrador);
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
                    prod.setValorsubsttributaria(orderItem.getEcotax().setScale(2, BigDecimal.ROUND_HALF_UP));
                }

                //double valorUnitario;
                //double valorTotal;
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
                //BigDecimal quanConvertida = new BigDecimal(orderItem.getProductQuantity()).multiply(fatorConversaoBigDecimal(prodCplus, managerCplus));
                BigDecimal quanConvertida = new BigDecimal(orderItem.getProductQuantity());
                BigDecimal valUni;
                prod.setQuantidade(quanConvertida);
                if (alterarValor) {
                    valUni = orderItem.getTotalPriceTaxIncl().divide(quanConvertida, 2, BigDecimal.ROUND_HALF_DOWN);
                    valUni = new ValoresOrder().valorUnitario(valUni.multiply(new BigDecimal("0.90")));
                    valorTotal = new ValoresOrder().valorTotalItem(valUni, quanConvertida.intValue());
                    prod.setValorunitario(valUni);
                } else {
                    valUni = orderItem.getTotalPriceTaxIncl().divide(quanConvertida, 2, BigDecimal.ROUND_HALF_DOWN);
                    valUni = new ValoresOrder().valorUnitario(valUni);
                    valorTotal = new ValoresOrder().valorTotalItem(valUni, quanConvertida.intValue());
                    prod.setValorunitario(new ValoresOrder().valorUnitario(valUni));
                }
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

                    if ("N".equals(cli.getFlagusaaliqicmsdiferenciada().toString())) {
                        // if (cli.getIndiedest().toString() == "1") {                                                 
                        //    prod.setCodcalculoicms(calculoIcmsEstado.getCodcalculoicms().getCodcalculoicms());
                        //     prod.setCodclassificacaofiscal(prodCplus.getCodclassificacaofiscal().getCodclassificacaofiscal());
                        //     prod.setTipotributacao('T');
                        //    prod.setAliqtributacao(new BigDecimal("12.0"));
                        //     prod.setNumeroorcamento(orcamento.getNumeroorcamento());
                        //      prod.setAliqfcp(BigDecimal.ZERO);
                        //     prod.setValorfcpsubsttributaria(BigDecimal.ZERO);
                        //    prod.setAliqfcpStUfDestino(BigDecimal.ZERO);
                        //    prod.setAliqmva(BigDecimal.ZERO);
                        //     prod.setValorfcp(BigDecimal.ZERO);
                        //    prod.setValoricmsoperacao(new BigDecimal(baseIcms * 12.0 / 100));
                        //    prod.setAliqreducaobasesubsttributaria(BigDecimal.ZERO);
                        //    prod.setFlagtipoacrescimoitem('V');

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

    private boolean editaOrcamento(boolean alteraValor, PsOrders psOrders, Orcamento orcamento, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        QueryCplus queryCplus = new QueryCplus(managerCplus);
        //int decimaisArredondamento = Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
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
            double valIcms = 0.00;
            double basIcms = 0.00;
            double basSt = 0.00;
            double valSt = 0.00;
            double valTotalProdutos = 0.00;
            double valIpi = 0.00;
            // double valTotalNota = 0.00;
            double valPis = 0.00;
            //double valFrete = 0.00;
            // double valotrasDespesas = 0.00;
            double valCofins = 0.00;
            for (Orcamentoprod prod : listMovProd) {
                valIcms = valIcms + prod.getValoricms().doubleValue();
                basIcms = basIcms + prod.getBaseicms().doubleValue();
                basSt = basSt + prod.getBasesubsttributaria().doubleValue();
                valSt = valSt + prod.getValorsubsttributaria().doubleValue();
                valTotalProdutos = valTotalProdutos + prod.getValortotal().doubleValue();
                valIpi = valIpi + prod.getValoripi().doubleValue();
                valPis = valPis + prod.getValorpis().doubleValue();
                valCofins = valCofins + prod.getValorcofins().doubleValue();
            }//fim for que soma o total dos valores
            orcamento.setBaseicms(new BigDecimal(basIcms).setScale(2, RoundingMode.HALF_UP));
            orcamento.setValoricms(new BigDecimal(valIcms).setScale(2, RoundingMode.HALF_UP));
            orcamento.setBasesubsttributaria(new BigDecimal(basSt).setScale(2, RoundingMode.HALF_UP));
            orcamento.setValorsubsttributaria(new BigDecimal(valSt).setScale(2, RoundingMode.HALF_UP));

            if (!"RS".equals(orcamento.getCodcli().getEstado())) {
                orcamento.setIdentificadordestino('2');
                if (orcamento.getValoricms().doubleValue() > 0.00) {
                    orcamento.setCodcfop("6102");
                } else {
                    orcamento.setCodcfop("6403");
                }
            }
            double valorDesconto = 0.00;
            double valorTaxa = 0.00;
            if (alteraValor == false) {
                if (psOrders.getTotalDiscountsTaxIncl().doubleValue() > 0.00) {
                    orcamento.setValordesconto(psOrders.getTotalDiscountsTaxIncl());
                    ////////
                    valorDesconto = psOrders.getTotalDiscountsTaxIncl().doubleValue();
                    valorTaxa = (valorDesconto / valTotalProdutos) * 100.00;
                    orcamento.setAliqdesconto(new BigDecimal(valorTaxa).setScale(4, BigDecimal.ROUND_HALF_EVEN));
                    orcamento.setFlagtipodesconto('A');
                    ////////////
                } else if (valTotalProdutos > psOrders.getTotalPaidTaxIncl().setScale(2, RoundingMode.HALF_UP).doubleValue()) {
                    valorDesconto = valTotalProdutos - psOrders.getTotalPaidTaxIncl().doubleValue();
                    valorTaxa = (valorDesconto / valTotalProdutos) * 100.00;
                    orcamento.setAliqdesconto(new BigDecimal(valorTaxa).setScale(4, RoundingMode.HALF_UP));
                    orcamento.setValordesconto(new BigDecimal(valorDesconto).setScale(2, BigDecimal.ROUND_HALF_UP));
                    orcamento.setFlagtipodesconto('A');
                } else if (valTotalProdutos < psOrders.getTotalPaidTaxIncl().setScale(2, RoundingMode.HALF_UP).doubleValue()) {
                    valorDesconto = psOrders.getTotalPaidTaxIncl().doubleValue() - valTotalProdutos;
                    valorTaxa = (valorDesconto / valTotalProdutos) * 100.00;
                    orcamento.setAliqacrescimo(new BigDecimal(valorTaxa).setScale(2, RoundingMode.HALF_UP));
                    orcamento.setValoracrescimo(new BigDecimal(valorDesconto).setScale(2, BigDecimal.ROUND_HALF_UP));
                    orcamento.setFlagtipoacrescimo('A');
                }
            }
            orcamento.setValortotalprodutos(new BigDecimal(valTotalProdutos - valorDesconto).setScale(2, RoundingMode.HALF_UP));
            orcamento.setValortotalcofins(new BigDecimal(valCofins - valorDesconto).setScale(2, RoundingMode.HALF_UP));
            orcamento.setValortotalpis(new BigDecimal(valPis - valorDesconto).setScale(2, RoundingMode.HALF_UP));
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
