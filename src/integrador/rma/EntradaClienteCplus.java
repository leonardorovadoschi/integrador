/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rma;

import acesso.ConexaoDB;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Cfop;
import entidade.cplus.Cliente;
import entidade.cplus.Empresa;
import entidade.cplus.Movenda;
import entidade.cplus.Movendadevolucao;
import entidade.cplus.Movendaprod;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Setorestoque;
import entidade.cplus.Tipomovimento;
import entidade.cplus.Unidade;
import entidade.cplus.Usuario;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.MovendaJpaController;
import jpa.cplus.MovendadevolucaoJpaController;
import jpa.cplus.MovendaprodJpaController;
import jpa.cplus.MoventradaJpaController;
import jpa.cplus.MoventradaprodJpaController;
import jpa.cplus.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leonardo
 */
public class EntradaClienteCplus {

    private QueryCplus queryCplus;
    private QueryIntegrador queryIntegrador;
    private int decimaisArredondamento;

    /**
     * Função que trada de uma entrada de cliente
     *
     * @param movimento
     * @param calculoIcmsEstado
     * @param cliente
     * @param movendaProd
     * @param serial
     * @param usuario
     * @param managerCplus
     * @param managerIntegrador
     * @return false se houver erro
     */
    public boolean entradaClienteCplus(Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Cliente cliente, Movendaprod movendaProd,
            String serial, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        queryCplus = new QueryCplus(managerCplus);
        queryIntegrador = new QueryIntegrador(managerIntegrador);
        decimaisArredondamento = Integer.valueOf(queryIntegrador.valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        boolean condicao = true;
        List<Moventrada> listMoventrada = queryCplus.listagemMoventradaCliente(movimento.getCodigo(), cliente.getCodcli());
        if (listMoventrada.isEmpty()) {
            if (criarEntrada(movimento, cliente, movendaProd.getCodmovenda(), usuario, managerCplus, managerIntegrador)) {
                List<Moventrada> listEntrada = queryCplus.listagemMoventradaCliente(movimento.getCodigo(), cliente.getCodcli());
                if (listEntrada.size() == 1) {
                    for (Moventrada entrada : listEntrada) {
                        if (criaEntradaProd(usuario, movimento, calculoIcmsEstado, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
                            condicao = false;
                        }
                    }
                }
            } else {
                condicao = false;
            }
        } else if (listMoventrada.size() == 1) {
            int cancelar = JOptionPane.showConfirmDialog(null, "Já existe uma entrada para esse cliente com essa operação sem Numero de Nota! \n"
                    + "Deseja incluir esse item nessa Entrada?", "Listagem de Entradas", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                for (Moventrada entrada : listMoventrada) {
                    List<Moventradaprod> listMovEntradaProd = queryCplus.listagemMovEntradaProd(entrada.getCodmoventr(), movendaProd.getCodprod().getCodprod(), movendaProd.getValorunitario());
                    if (listMovEntradaProd.isEmpty()) {
                        if (criaEntradaProd(usuario, movimento, calculoIcmsEstado, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
                            condicao = false;
                        }
                    } else {
                        for (Moventradaprod prod : listMovEntradaProd) {
                            if (editaEntradaProd(usuario, movimento, calculoIcmsEstado, prod, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
                                condicao = false;
                            }
                        }
                    }//fim else com lista maior que zero
                }//fim for Mov Entrada Prod
            } else {
                condicao = false;
            }
        } else if (listMoventrada.size() > 1) {
            JOptionPane.showMessageDialog(null, "O Sistema acho mais que um resultado para essa transação!!!");
            condicao = false;
        }
        return condicao;
    }

    /**
     * Cria entrada de produto somente uma unidade se vor de diferentes valores
     * vai criar outro entrada de Produto
     *
     * @param movEntrada
     * @param movendaProd
     * @param serial
     * @param managerIntegrador
     * @param managerCplus
     */
    private boolean criaEntradaProd(Usuario usuario, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Moventrada movEntrada, Movendaprod movendaProd,
            String serial, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
       boolean condicao = true;
        Moventradaprod entradaProd = new Moventradaprod();
        // Configuracao configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_moventrada_prod");
        Integer configCont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_moventrada_prod"));
                
            //double quant = 1.00;
            double quant = quantidadeConversaoEntrada(movendaProd);
            BigDecimal descRateadoUnitario = movendaProd.getValordescontorateado().divide(movendaProd.getQuantidade(), 3 ,BigDecimal.ROUND_HALF_UP);
            double valorUnitario = (movendaProd.getValorunitario().subtract(descRateadoUnitario)).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            
            double valorTotal = valorUnitario * quant;
            double aliqIpi;
            if (movendaProd.getAliqipi() == null) {
                aliqIpi = 0.00;
            } else {
                aliqIpi = movendaProd.getAliqipi().doubleValue();
            }
            double quantidadeMovenda = movendaProd.getQuantidade().doubleValue();
            double baseIpiMovenda;
            if (movendaProd.getBaseipi() == null) {
                baseIpiMovenda = 0.00;
            } else {
                baseIpiMovenda = movendaProd.getBaseipi().doubleValue();
            }
            double baseIpi = baseIpiMovenda / quantidadeMovenda * quant;
            double valorIpi = baseIpi * aliqIpi / 100;
            double icmsAliqEstado;
            if (calculoIcmsEstado.getAliqicms() == null) {
                icmsAliqEstado = 0.00;
            } else {
                icmsAliqEstado = calculoIcmsEstado.getAliqicms().doubleValue();
            }
            double aliqIcms;
            double baseIcms;
            double valorIcms;
            if (icmsAliqEstado > 0.00) {
                if (movendaProd.getAliqicms() == null) {
                    aliqIcms = 0.00;
                } else {
                    aliqIcms = movendaProd.getAliqicms().doubleValue();
                }
                double baseIcmsMovenda;
                if (movendaProd.getBaseicms() == null) {
                    baseIcmsMovenda = 0.00;
                } else {
                    baseIcmsMovenda = movendaProd.getBaseicms().doubleValue();
                }
                baseIcms = baseIcmsMovenda / quantidadeMovenda * quant;
                valorIcms = baseIcms * aliqIcms / 100;
            } else {
                aliqIcms = 0.00;
                baseIcms = 0.00;
                valorIcms = 0.00;
            }
            double baseSt;
            double valorST;
            if (calculoIcmsEstado.getFlagcalculasubsttributaria() == 'Y') {
                double baseSTMovenda;
                if (movendaProd.getBasesubsttributaria() == null) {
                    baseSTMovenda = 0.00;
                } else {
                    baseSTMovenda = movendaProd.getBasesubsttributaria().doubleValue();
                }
                baseSt = baseSTMovenda / quantidadeMovenda * quant;
                double valorSTMovenda;
                if (movendaProd.getValorsubsttributaria() == null) {
                    valorSTMovenda = 0.00;
                } else {
                    valorSTMovenda = movendaProd.getValorsubsttributaria().doubleValue();
                }
                valorST = valorSTMovenda / quantidadeMovenda * quant;
            } else {
                baseSt = 0.00;
                valorST = 0.00;
            }
            double cofinsIcmsEstado;
            if (calculoIcmsEstado.getAliqcofins() == null) {
                cofinsIcmsEstado = 0.00;
            } else {
                cofinsIcmsEstado = calculoIcmsEstado.getAliqcofins().doubleValue();
            }
            double baseCofins;
            double aliqCofins;
            double valorCofins;
            if (cofinsIcmsEstado > 0.00) {
                double baseCofinsMovenda;
                if (movendaProd.getBasecofins() == null) {
                    baseCofinsMovenda = 0.00;
                } else {
                    baseCofinsMovenda = movendaProd.getBasecofins().doubleValue();
                }
                baseCofins = baseCofinsMovenda / quantidadeMovenda * quant;
                if (movendaProd.getAliqcofins() == null) {
                    aliqCofins = 0.00;
                } else {
                    aliqCofins = movendaProd.getAliqcofins().doubleValue();
                }
                valorCofins = baseCofins * aliqCofins / 100;
            } else {
                baseCofins = 0.00;
                aliqCofins = 0.00;
                valorCofins = 0.00;
            }
            double pisIcmsEstado;
            if (calculoIcmsEstado.getAliqpis() == null) {
                pisIcmsEstado = 0.00;
            } else {
                pisIcmsEstado = calculoIcmsEstado.getAliqpis().doubleValue();
            }
            double basePis;
            double aliqPis;
            double valorPis;
            if (pisIcmsEstado > 0.00) {
                double basePisMovenda;
                if (movendaProd.getBasepis() == null) {
                    basePisMovenda = 0.00;
                } else {
                    basePisMovenda = movendaProd.getBasepis().doubleValue();
                }
                basePis = basePisMovenda / quantidadeMovenda * quant;
                if (movendaProd.getAliqpis() == null) {
                    aliqPis = 0.00;
                } else {
                    aliqPis = movendaProd.getAliqpis().doubleValue();
                }
                valorPis = basePis * aliqPis / 100;
            } else {
                basePis = 0.00;
                aliqPis = 0.00;
                valorPis = 0.00;
            }
            String configString = String.format("%09d", configCont);
            entradaProd.setCodmoveprod(configString);
            entradaProd.setCodmoventr(movEntrada);
            entradaProd.setCodprod(movendaProd.getCodprod());
            entradaProd.setQuantidade(new BigDecimal(quant));
            entradaProd.setQuantidadeembalagem(movendaProd.getCodprod().getQuantidadeembalagem());
            entradaProd.setValorunitario(movendaProd.getValorunitario());
            entradaProd.setFlagtipoacrescimoitem(movendaProd.getFlagtipoacrescimoitem());
            entradaProd.setAliqacrescimoitem(movendaProd.getAliqacrescimoitem());
            entradaProd.setValoracrescimoitem(movendaProd.getValoracrescimoitem());
            entradaProd.setFlagtipodescontoitem(movendaProd.getFlagtipodescontoitem());
            entradaProd.setAliqdescontoitem(movendaProd.getAliqdescontoitem());
            entradaProd.setValordescontoitem(movendaProd.getValordescontoitem());
            entradaProd.setValortotal(new BigDecimal(valorTotal));
            entradaProd.setBaseipi(new BigDecimal(baseIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setAliqipi(movendaProd.getAliqipi());
            entradaProd.setValoripi(new BigDecimal(valorIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setBaseicms(new BigDecimal(baseIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setAliqicms(new BigDecimal(aliqIcms));
            entradaProd.setValoricms(new BigDecimal(valorIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setBasesubsttributaria(new BigDecimal(baseSt).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setValorsubsttributaria(new BigDecimal(valorST).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setCodcfop(calculoIcmsEstado.getCodcfop());
            entradaProd.setFlagorigemproduto(movendaProd.getFlagorigemproduto());
            entradaProd.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributaria());
            entradaProd.setFlagcomposto(movendaProd.getFlagcomposto());
            entradaProd.setDatavalidade(movendaProd.getDatavalidade());
            entradaProd.setCodclassificacaofiscal(movendaProd.getCodclassificacaofiscal());
            entradaProd.setValorfreterateado(movendaProd.getValorfreterateado());
            entradaProd.setValoracrescimorateado(movendaProd.getValoracrescimorateado());
            //
            entradaProd.setValordescontorateado(descRateadoUnitario.multiply(new BigDecimal(quant)));
            
            entradaProd.setValorsegurorateado(movendaProd.getValorsegurorateado());
            entradaProd.setValoroutrasdesprateado(movendaProd.getValoroutrasdesprateado());
            entradaProd.setCodsetorestoque(new Setorestoque("000000001"));
            entradaProd.setBaseii(movendaProd.getBaseii());
            entradaProd.setAliqii(movendaProd.getAliqii());
            entradaProd.setValorii(movendaProd.getValorii());
            entradaProd.setCodmovproddevolucao(movendaProd.getCodmovprod());
            entradaProd.setBasecofins(new BigDecimal(baseCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setAliqcofins(new BigDecimal(aliqCofins));
            entradaProd.setValorcofins(new BigDecimal(valorCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setBasepis(new BigDecimal(basePis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setAliqpis(new BigDecimal(aliqPis));
            entradaProd.setValorpis(new BigDecimal(valorPis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            entradaProd.setFatorconversao(BigDecimal.ONE);
            entradaProd.setCstpis(calculoIcmsEstado.getCstpis());
            entradaProd.setCstcofins(calculoIcmsEstado.getCstcofins());
            try {
                new MoventradaprodJpaController(managerCplus).create(entradaProd);
                
                editaEntrada(movEntrada, managerCplus);
                mensagemEntrada(movendaProd, serial, movEntrada, managerCplus);
                mensagemNotaFiscal(new MovendaJpaController(managerCplus).findMovenda(movendaProd.getCodmovenda().getCodmovenda()), movEntrada, managerCplus);
                String devolucao = movimento.getFlagdevolucao().toString();
                if ("Y".equals(devolucao)) {
                    Moventradaprod entPro = new MoventradaprodJpaController(managerCplus).findMoventradaprod(String.format("%09d", configCont));
                    new LancamentoVale().lancamentoVale(usuario, movEntrada.getCodcli(), movendaProd.getCodmovenda(), new MoventradaJpaController(managerCplus).findMoventrada(entPro.getCodmoventr().getCodmoventr()), new BigDecimal(valorTotal).setScale(2, BigDecimal.ROUND_HALF_UP), managerCplus, managerIntegrador);
                    devolucaoCliente(usuario, entPro, movendaProd, managerCplus, managerIntegrador);
                }
                /////////////////////////////////////////////////////////////
                configCont--;
                queryIntegrador.atualizaValorConfiguracao("increment_tabela_moventrada_prod", String.valueOf(configCont));
                ///////////////////////////////////////////////////////////////////////////////////////
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada Produto!!!\n " + ex);
                condicao = false;
            }
        
        return condicao;
    }

    /**
     * Funï¿½ï¿½o que preenche a tabela Movendadevolucao, e complementa a venda com
     * quantidade devolvida
     *
     * @param usuario
     * @param entradaProd
     * @param vendaProd
     * @param managerCplus
     * @param managerIntegrador
     */
    private void devolucaoCliente(Usuario usuario, Moventradaprod entradaProd, Movendaprod vendaProd, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        List<Movendadevolucao> listDevCliente = queryCplus.listagemMoVendaDevolucaoCliente(entradaProd.getCodmoveprod(), vendaProd.getCodmovprod());
        if (listDevCliente.isEmpty()) {
            Integer configCont = Integer.valueOf(new ConexaoDB().ultimoCodigo("MOVENDADEVOLUCAO", "CODMOVENDADEVOLUCAO"));
            Movendadevolucao dev = new Movendadevolucao();
            dev.setCodmovendadevolucao(String.format("%09d", configCont));
            dev.setCodmoveprod(entradaProd.getCodmoveprod());
            dev.setCodmovprod(vendaProd.getCodmovprod());
            dev.setQuantidadedevolucao(entradaProd.getQuantidade());
            dev.setData(new Date(System.currentTimeMillis()));
            dev.setCoduser(usuario.getCoduser());
            try {
                new MovendadevolucaoJpaController(managerCplus).create(dev);
                vendaProd.setQuantidadedevolvida(entradaProd.getQuantidade());
                new MovendaprodJpaController(managerCplus).edit(vendaProd);
                configCont++;
                new ConexaoDB().atualizarCodigo("MOVENDADEVOLUCAO", "CODMOVENDADEVOLUCAO", configCont);
            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de devolução cliente!!!\n " + ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de devolução cliente!!!\n " + ex);
            }
        } else if (listDevCliente.size() == 1) {
            for (Movendadevolucao dev : listDevCliente) {
                dev.setQuantidadedevolucao(entradaProd.getQuantidade());
                dev.setData(new Date(System.currentTimeMillis()));
                try {
                    new MovendadevolucaoJpaController(managerCplus).edit(dev);
                    vendaProd.setQuantidadedevolvida(entradaProd.getQuantidade());
                    new MovendaprodJpaController(managerCplus).edit(vendaProd);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de devolução cliente!!!\n " + ex);
                }
            }
        }
    }

    /**
     * Edita a entrada de Produtos incrementa mais um
     *
     * @param movEntradaProd
     * @param movEntrada
     * @param movendaProd
     * @param serial
     * @param managerCplus
     */
    private boolean editaEntradaProd(Usuario usuario, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Moventradaprod movEntradaProd,
            Moventrada movEntrada, Movendaprod movendaProd, String serial, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        double quant = movEntradaProd.getQuantidade().doubleValue();
        //quant = quant + 1.00;
        quant = quant + quantidadeConversaoEntrada(movendaProd);

        //double valorUnitario = movendaProd.getValorunitario().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();        
        BigDecimal descRateadoUnitario = movendaProd.getValordescontorateado().divide(movendaProd.getQuantidade(), 3 ,BigDecimal.ROUND_HALF_UP);
        double valorUnitario = (movendaProd.getValorunitario().subtract(descRateadoUnitario)).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            
        double valorTotal = valorUnitario * quant;
        double aliqIpi = movendaProd.getAliqipi().doubleValue();
        double quantidadeMovenda = movendaProd.getQuantidade().doubleValue();
        double baseIpiMovenda = movendaProd.getBaseipi().doubleValue();
        double baseIpi = baseIpiMovenda / quantidadeMovenda * quant;
        double valorIpi = baseIpi * aliqIpi / 100;
        double icmsAliqEstado = calculoIcmsEstado.getAliqicms().doubleValue();
        double aliqIcms;
        double baseIcms;
        double valorIcms;
        if (icmsAliqEstado > 0.00) {
            aliqIcms = movendaProd.getAliqicms().doubleValue();
            double baseIcmsMovenda = movendaProd.getBaseicms().doubleValue();
            baseIcms = baseIcmsMovenda / quantidadeMovenda * quant;
            valorIcms = baseIcms * aliqIcms / 100;
        } else {
            aliqIcms = 0.00;
            baseIcms = 0.00;
            valorIcms = 0.00;
        }
        double baseSt;
        double valorST;
        if (calculoIcmsEstado.getFlagcalculasubsttributaria() == 'Y') {
            double baseSTMovenda = movendaProd.getBasesubsttributaria().doubleValue();
            baseSt = baseSTMovenda / quantidadeMovenda * quant;
            double valorSTMovenda = movendaProd.getValorsubsttributaria().doubleValue();
            valorST = valorSTMovenda / quantidadeMovenda * quant;
        } else {
            baseSt = 0.00;
            valorST = 0.00;
        }
        double cofinsIcmsEstado = calculoIcmsEstado.getAliqcofins().doubleValue();
        double baseCofins;
        double aliqCofins;
        double valorCofins;
        if (cofinsIcmsEstado > 0.00) {
            double baseCofinsMovenda = movendaProd.getBasecofins().doubleValue();
            baseCofins = baseCofinsMovenda / quantidadeMovenda * quant;
            aliqCofins = movendaProd.getAliqcofins().doubleValue();
            valorCofins = baseCofins * aliqCofins / 100;
        } else {
            baseCofins = 0.00;
            aliqCofins = 0.00;
            valorCofins = 0.00;
        }
        double pisIcmsEstado = calculoIcmsEstado.getAliqpis().doubleValue();
        double basePis;
        double aliqPis;
        double valorPis;
        if (pisIcmsEstado > 0.00) {
            double basePisMovenda = movendaProd.getBasepis().doubleValue();
            basePis = basePisMovenda / quantidadeMovenda * quant;
            aliqPis = movendaProd.getAliqpis().doubleValue();
            valorPis = basePis * aliqPis / 100;
        } else {
            basePis = 0.00;
            aliqPis = 0.00;
            valorPis = 0.00;
        }
        movEntradaProd.setQuantidade(new BigDecimal(quant));
        movEntradaProd.setValorunitario(movendaProd.getValorunitario());
        movEntradaProd.setValortotal(new BigDecimal(valorTotal));
        movEntradaProd.setBaseipi(new BigDecimal(baseIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setAliqipi(movendaProd.getAliqipi());
        movEntradaProd.setValoripi(new BigDecimal(valorIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setBaseicms(new BigDecimal(baseIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setAliqicms(new BigDecimal(aliqIcms));
        movEntradaProd.setValoricms(new BigDecimal(valorIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setBasesubsttributaria(new BigDecimal(baseSt).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setValorsubsttributaria(new BigDecimal(valorST).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setBasecofins(new BigDecimal(baseCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setAliqcofins(new BigDecimal(aliqCofins));
        movEntradaProd.setValorcofins(new BigDecimal(valorCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setBasepis(new BigDecimal(basePis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movEntradaProd.setAliqpis(new BigDecimal(aliqPis));
        movEntradaProd.setValorpis(new BigDecimal(valorPis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        
        movEntradaProd.setValordescontorateado(descRateadoUnitario.multiply(new BigDecimal(quant)));
        try {
            new MoventradaprodJpaController(managerCplus).edit(movEntradaProd);
            Moventrada entrada = new MoventradaJpaController(managerCplus).findMoventrada(movEntrada.getCodmoventr());
            editaEntrada(entrada, managerCplus);
            mensagemEntrada(movendaProd, serial, entrada, managerCplus);
            mensagemNotaFiscal(new MovendaJpaController(managerCplus).findMovenda(movendaProd.getCodmovenda().getCodmovenda()), entrada, managerCplus);
            String devolucao = movimento.getFlagdevolucao().toString();
            if ("Y".equals(devolucao)) {
                new LancamentoVale().lancamentoVale(usuario, movEntrada.getCodcli(), movendaProd.getCodmovenda(), entrada, new BigDecimal(valorTotal).setScale(2, BigDecimal.ROUND_HALF_UP), managerCplus, managerIntegrador);
                devolucaoCliente(usuario, movEntradaProd, movendaProd, managerCplus, managerIntegrador);
            }
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Entrada Produto!!!\n " + ex);
            condicao = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Entrada Produto!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }
    /**
     * Cria entrada para cliente nas funções de devolução e remessa somente
     * @param cliente
     * @param movenda
     * @param usuario
     * @param numNota
     * @param managerCplus
     * @param managerIntegrador
     */
    private boolean criarEntrada(Tipomovimento movimento, Cliente cliente, Movenda movenda, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        Moventrada entrada = new Moventrada();       
        Integer configCont = Integer.valueOf(new ConexaoDB().ultimoCodigo("MOVENTRADA", "CODMOVENTR"));       
        entrada.setCodmoventr(String.format("%09d", configCont));
        entrada.setCoduser(usuario.getCoduser());
        entrada.setCodcli(cliente);
        entrada.setCodmovenda(movenda.getCodmovenda());
        entrada.setCodempresa(new Empresa(1));
        entrada.setCodsetorestoque(new Setorestoque("000000001"));
        entrada.setData(new Date(System.currentTimeMillis()));
        entrada.setModelonota("55");
        //entrada.setObs(obs);
        entrada.setBaseicms(BigDecimal.ZERO);
        entrada.setValoricms(BigDecimal.ZERO);
        entrada.setBasesubsttributaria(BigDecimal.ZERO);
        entrada.setValorsubsttributaria(BigDecimal.ZERO);
        entrada.setValorfrete(BigDecimal.ZERO);
        entrada.setValoroutrasdespesas(BigDecimal.ZERO);
        if ("RS".equals(cliente.getEstado())) {
            entrada.setCodcfop(new Cfop(movimento.getCodcfopdentrouf()));
        } else {
            entrada.setCodcfop(new Cfop(movimento.getCodcfopforauf()));
        }
        entrada.setFlagforncli('C');
        entrada.setCodtipomovimento(movimento);
        entrada.setHora(new Date(System.currentTimeMillis()));
        entrada.setFlagcancelada('N');
        entrada.setFlagemissaopropria('N');
        entrada.setValortotalprodutos(BigDecimal.ZERO);
        entrada.setValortotalnota(BigDecimal.ZERO);
        entrada.setValortotalipi(BigDecimal.ZERO);
        entrada.setFlagfrete('E');
        entrada.setValortotalcofins(BigDecimal.ZERO);
        entrada.setValortotalpis(BigDecimal.ZERO);
        entrada.setValortotaliss(BigDecimal.ZERO);
        entrada.setFlagestoqueliberado('Y');
        entrada.setValortotalii(BigDecimal.ZERO);
        entrada.setValoricmsincentfiscal(BigDecimal.ZERO);
        try {
            new MoventradaJpaController(managerCplus).create(entrada);
            configCont++;
            new ConexaoDB().atualizarCodigo("MOVENTRADA", "CODMOVENTR", configCont);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }

    /**
     * Atualiza totais da nota fiscal
     *
     * @param entrada
     * @param managerCplus
     */
    private boolean editaEntrada(Moventrada entrada, EntityManagerFactory managerCplus) {
        boolean condicao = true;
        List<Moventradaprod> listMovProd = queryCplus.listagemMovEntradaProdPorEntrada(entrada.getCodmoventr());
        if (listMovProd.isEmpty()) {
            entrada.setBaseicms(BigDecimal.ZERO);
            entrada.setValoricms(BigDecimal.ZERO);
            entrada.setBasesubsttributaria(BigDecimal.ZERO);
            entrada.setValorsubsttributaria(BigDecimal.ZERO);
            entrada.setValorfrete(BigDecimal.ZERO);
            entrada.setValoroutrasdespesas(BigDecimal.ZERO);
            entrada.setValortotalprodutos(BigDecimal.ZERO);
            entrada.setValortotalnota(BigDecimal.ZERO);
            entrada.setValortotalipi(BigDecimal.ZERO);
            entrada.setValortotalcofins(BigDecimal.ZERO);
            entrada.setValortotalpis(BigDecimal.ZERO);
        } else {
            double valIcms = 0.00;
            double basIcms = 0.00;
            double basSt = 0.00;
            double valSt = 0.00;
            double valTotalProdutos = 0.00;
            double valIpi = 0.00;
            double valTotalNota;
            double valPis = 0.00;
            double valFrete = 0.00;
            double valotrasDespesas = 0.00;
            double valCofins = 0.00;
            for (Moventradaprod prod : listMovProd) {
                valIcms = valIcms + prod.getValoricms().doubleValue();
                basIcms = basIcms + prod.getBaseicms().doubleValue();
                basSt = basSt + prod.getBasesubsttributaria().doubleValue();
                valSt = valSt + prod.getValorsubsttributaria().doubleValue();
                valTotalProdutos = valTotalProdutos + prod.getValortotal().doubleValue();
                valIpi = valIpi + prod.getValoripi().doubleValue();
                valPis = valPis + prod.getValorpis().doubleValue();
                valCofins = valCofins + prod.getValorcofins().doubleValue();
            }//fim for que soma o total dos valores
            entrada.setBaseicms(new BigDecimal(basIcms));
            entrada.setValoricms(new BigDecimal(valIcms));
            entrada.setBasesubsttributaria(new BigDecimal(basSt));
            entrada.setValorsubsttributaria(new BigDecimal(valSt));
            entrada.setValortotalcofins(new BigDecimal(valCofins));
            entrada.setValortotalpis(new BigDecimal(valPis));

            valTotalNota = valFrete + valotrasDespesas + valSt + valIpi;

            entrada.setValortotalprodutos(new BigDecimal(valTotalProdutos).setScale(4, BigDecimal.ROUND_HALF_UP));
            entrada.setValortotalnota(new BigDecimal(valTotalNota).setScale(4, BigDecimal.ROUND_HALF_UP));
            entrada.setValortotalipi(new BigDecimal(valIpi).setScale(4, BigDecimal.ROUND_HALF_UP));
        }
        try {
            new MoventradaJpaController(managerCplus).edit(entrada);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }

    /**
     * Cria mensagem para Entrada
     *
     * @param movendaProd
     * @param serial
     * @param movEntrada
     */
    private void mensagemEntrada(Movendaprod movendaProd, String serial, Moventrada movEntrada, EntityManagerFactory managerCplus) {
        String mensagem;
        if (movEntrada.getObs() == null) {
            mensagem = "";
        } else {
            mensagem = movEntrada.getObs();
        }
        mensagem = mensagem + "Entrada ref. Pedido " + movendaProd.getCodmovenda().getNumped() + ", Data Lançamento: " + new FormataCampos().dataStringSoData(new Date(System.currentTimeMillis()), 0) + " produto " + movendaProd.getCodprod().getNomeprod() + " com serial " + serial + "\n";
        movEntrada.setObs(mensagem);
        try {
            new MoventradaJpaController(managerCplus).edit(movEntrada);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem de entrada!!!\n " + ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem de entrada!!!\n " + ex);
        }
    }

    private void mensagemNotaFiscal(Movenda movenda, Moventrada movEntrada, EntityManagerFactory managerCplus) {
        boolean notaExistente = false;
        if (movEntrada.getObsnotafiscal() != null && movenda.getNumnota() != null) {
            String[] mensagemEntrada = movEntrada.getObsnotafiscal().split(" ");
            String numNota = movenda.getNumnota().toString();
            for (int cont = 0; mensagemEntrada.length > cont; cont++) {
                if (mensagemEntrada[cont] == null ? numNota == null : mensagemEntrada[cont].equals(numNota)) {
                    notaExistente = true;
                }//fim if que verifica se a nota jï¿½ estï¿½ na observaï¿½ï¿½o
            }//fim for que verifica paavras           
        }
        if (notaExistente == false && movenda.getNumnota() != null) {
            String mens;
            if (movEntrada.getObsnotafiscal() == null) {
                mens = "";
            } else {
                mens = movEntrada.getObsnotafiscal();
            }
            mens = mens + "referente a Nota Nï¿½: " + movenda.getNumnota().toString() + " Data: " + new FormataCampos().dataStringSoData(movenda.getData(), 0) + "\n";
            movEntrada.setObsnotafiscal(mens);
            try {
                new MoventradaJpaController(managerCplus).edit(movEntrada);
            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem da Nota!!!\n " + ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem da Nota!!!\n " + ex);
            }
        }
    }

    /**
     * funï¿½ï¿½o que traz o fator de converï¿½ï¿½o especificado na unidade do produto
     */
    private double quantidadeConversaoEntrada(Movendaprod movEntradaProd) {
        double quantidade = 1.00;
        for (Unidade un : queryCplus.resultPorUnidadeProduto(movEntradaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().doubleValue();
            }
        }
        return quantidade;
    }
}
