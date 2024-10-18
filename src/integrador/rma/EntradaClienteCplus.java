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
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.CfopJpaController;
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
    //private int decimaisArredondamento;

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
        queryIntegrador = new QueryIntegrador();
       // decimaisArredondamento = Integer.valueOf(queryIntegrador.valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        boolean condicao = true;
        List<Moventrada> listMoventrada = queryCplus.listagemMoventradaCliente(movimento.getCodigo(), cliente.getCodcli());
        if (listMoventrada.isEmpty()) {
            if (criarEntrada(movimento, cliente, movendaProd.getCodmovenda(), usuario, managerCplus, managerIntegrador)) {
                List<Moventrada> listEntrada = queryCplus.listagemMoventradaCliente(movimento.getCodigo(), cliente.getCodcli());
                if (listEntrada.size() == 1) {
                    for (Moventrada entrada : listEntrada) {
                        if (criaEntradaProd(cliente, usuario, movimento, calculoIcmsEstado, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
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
                        if (criaEntradaProd(cliente, usuario, movimento, calculoIcmsEstado, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
                            condicao = false;
                        }
                    } else {
                        for (Moventradaprod prod : listMovEntradaProd) {
                            if (editaEntradaProd(cliente, usuario, movimento, calculoIcmsEstado, prod, entrada, movendaProd, serial, managerCplus, managerIntegrador) == false) {
                                condicao = false;
                            }
                        }
                    }//fim else com lista maior que zero
                }//fim for Mov Entrada Prod
            } else {
                condicao = false;
            }
        } else if (listMoventrada.size() > 1) {
            JOptionPane.showMessageDialog(null, "O Sistema achou mais que um resultado para essa transação!!!");
            condicao = false;
        }
        return condicao;
    }

    private BigDecimal valorUnitarioVenda(Movendaprod prod) {
        BigDecimal val = prod.getValortotal().subtract(prod.getValordescontorateado());
        val = val.divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        return val;
    }

    private BigDecimal valorSTEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
         val = prod.getValorsubsttributaria().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorBaseSTEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
        val = prod.getBasesubsttributaria().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorBaseCofinsEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
        val = prod.getBasecofins().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorBasePisEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
        val = prod.getBasepis().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorCofinsEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
        val = prod.getValorcofins().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorPisEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
        val = prod.getValorpis().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorBaseIpiEntrada(Movendaprod prod, BigDecimal quantidadeEspelho) {
        BigDecimal val = BigDecimal.ZERO;
        if (prod.getBaseipi() != null) {
            val = prod.getBaseipi().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
            val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorIpiEntrada(Movendaprod prod, BigDecimal quantidadeEspelho) {
        BigDecimal val = BigDecimal.ZERO;
        if (prod.getBaseipi() != null) {
            val = prod.getValoripi().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
            val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorBaseIcmsEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
         val = prod.getBaseicms().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
        val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorIcmsEntrada(Movendaprod prod, BigDecimal quantidadeEspelho, Tipomovimento movimento) {
        String devolucao = movimento.getFlagdevolucao().toString();
        BigDecimal val = BigDecimal.ZERO;
        if ("Y".equals(devolucao)) {
            val = prod.getValoricms().divide(prod.getQuantidade(), 4, RoundingMode.HALF_UP);
            val = val.multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        }
        return val;
    }

    private BigDecimal valorTotalProdutoEntradao(Movendaprod prod, BigDecimal quantidadeEspelho) {
        BigDecimal val = valorUnitarioVenda(prod).multiply(quantidadeEspelho).setScale(2, RoundingMode.HALF_UP);
        return val;
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
    private boolean criaEntradaProd(Cliente cliente, Usuario usuario, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Moventrada movEntrada, Movendaprod movendaProd,
            String serial, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        Moventradaprod entradaProd = new Moventradaprod();
        Integer configCont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_moventrada_prod"));
        //double quant = 1.00;
        BigDecimal quant = quantidadeConversaoEntrada(movendaProd);        
        if ("RS".equals(cliente.getEstado())) {           
            if ("5405".equals(movendaProd.getCodcfop().getCodcfop())) {
                entradaProd.setCodcfop(new CfopJpaController(managerCplus).findCfop("1411"));
            } else {              
                entradaProd.setCodcfop(new CfopJpaController(managerCplus).findCfop("1202"));
            }
        } else {
            entradaProd.setCodcfop(new CfopJpaController(managerCplus).findCfop("2202"));
        }      
        String configString = String.format("%09d", configCont);
        entradaProd.setCodmoveprod(configString);
        entradaProd.setCodmoventr(movEntrada);
        entradaProd.setCodprod(movendaProd.getCodprod());
        entradaProd.setQuantidade(quant);
        entradaProd.setQuantidadeembalagem(movendaProd.getCodprod().getQuantidadeembalagem());
        entradaProd.setValorunitario(valorUnitarioVenda(movendaProd));
        entradaProd.setFlagtipoacrescimoitem(movendaProd.getFlagtipoacrescimoitem());
        entradaProd.setAliqacrescimoitem(BigDecimal.ZERO);
        entradaProd.setValoracrescimoitem(BigDecimal.ZERO);
        entradaProd.setFlagtipodescontoitem(movendaProd.getFlagtipodescontoitem());
        entradaProd.setAliqdescontoitem(BigDecimal.ZERO);
        entradaProd.setValordescontoitem(BigDecimal.ZERO);
        entradaProd.setValortotal(valorTotalProdutoEntradao(movendaProd, quant));
        entradaProd.setBaseipi(valorBaseIpiEntrada(movendaProd, quant));
        entradaProd.setAliqipi(movendaProd.getAliqipi());
        entradaProd.setValoripi(valorIpiEntrada(movendaProd, quant));
        entradaProd.setBaseicms(valorBaseIcmsEntrada(movendaProd, quant, movimento));
        entradaProd.setAliqicms(movendaProd.getAliqicms());
        entradaProd.setValoricms(valorIcmsEntrada(movendaProd, quant, movimento));
        entradaProd.setBasesubsttributaria(valorBaseSTEntrada(movendaProd, quant, movimento));
        entradaProd.setValorsubsttributaria(valorSTEntrada(movendaProd, quant, movimento));
        entradaProd.setFlagorigemproduto(movendaProd.getFlagorigemproduto());
        entradaProd.setCodsituacaotributaria(movendaProd.getCodsituacaotributaria());
        entradaProd.setFlagcomposto(movendaProd.getFlagcomposto());
        entradaProd.setDatavalidade(movendaProd.getDatavalidade());
        entradaProd.setCodclassificacaofiscal(movendaProd.getCodclassificacaofiscal());
        entradaProd.setValorfreterateado(movendaProd.getValorfreterateado());
        entradaProd.setValoracrescimorateado(movendaProd.getValoracrescimorateado());
        //
        entradaProd.setValordescontorateado(BigDecimal.ZERO);

        entradaProd.setValorsegurorateado(movendaProd.getValorsegurorateado());
        entradaProd.setValoroutrasdesprateado(movendaProd.getValoroutrasdesprateado());
        entradaProd.setCodsetorestoque(new Setorestoque("000000001"));
        entradaProd.setBaseii(movendaProd.getBaseii());
        entradaProd.setAliqii(movendaProd.getAliqii());
        entradaProd.setValorii(movendaProd.getValorii());
        entradaProd.setCodmovproddevolucao(movendaProd.getCodmovprod());
        entradaProd.setBasecofins(valorBaseCofinsEntrada(movendaProd, quant, movimento));
        entradaProd.setAliqcofins(movendaProd.getAliqcofins());
        entradaProd.setValorcofins(valorCofinsEntrada(movendaProd, quant, movimento));
        entradaProd.setBasepis(valorBasePisEntrada(movendaProd, quant, movimento));
        entradaProd.setAliqpis(movendaProd.getAliqpis());
        entradaProd.setValorpis(valorPisEntrada(movendaProd, quant, movimento));
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
                new LancamentoVale().lancamentoVale(usuario, movEntrada.getCodcli(), movendaProd.getCodmovenda(), movEntrada, managerCplus);
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
     * Função que preenche a tabela Movendadevolucao, e complementa a venda com
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
            Integer configCont = new ConexaoDB().ultimoCodigo("MOVENDADEVOLUCAO", "CODMOVENDADEVOLUCAO");
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
    private boolean editaEntradaProd(Cliente cliente, Usuario usuario, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Moventradaprod movEntradaProd,
            Moventrada movEntrada, Movendaprod movendaProd, String serial, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        BigDecimal quant = movEntradaProd.getQuantidade();
        //quant = quant + 1.00;
        quant = quant.add(quantidadeConversaoEntrada(movendaProd));
        movEntradaProd.setQuantidade(quant);
        movEntradaProd.setValorunitario(valorUnitarioVenda(movendaProd));
        movEntradaProd.setValortotal(valorTotalProdutoEntradao(movendaProd, quant));
        movEntradaProd.setBaseipi(valorBaseIpiEntrada(movendaProd, quant));
        movEntradaProd.setAliqipi(movendaProd.getAliqipi());
        movEntradaProd.setValoripi(valorIpiEntrada(movendaProd, quant));
        movEntradaProd.setBaseicms(valorBaseIcmsEntrada(movendaProd, quant, movimento));
        movEntradaProd.setAliqicms(movendaProd.getAliqicms());
        movEntradaProd.setValoricms(valorIcmsEntrada(movendaProd, quant, movimento));
        movEntradaProd.setBasesubsttributaria(valorBaseSTEntrada(movendaProd, quant, movimento));
        movEntradaProd.setValorsubsttributaria(valorSTEntrada(movendaProd, quant, movimento));
        movEntradaProd.setBasecofins(valorBaseCofinsEntrada(movendaProd, quant, movimento));
        movEntradaProd.setAliqcofins(movendaProd.getAliqcofins());
        movEntradaProd.setValorcofins(valorCofinsEntrada(movendaProd, quant, movimento));
        movEntradaProd.setBasepis(valorBasePisEntrada(movendaProd, quant, movimento));
        movEntradaProd.setAliqpis(movendaProd.getAliqpis());
        movEntradaProd.setValorpis(valorPisEntrada(movendaProd, quant, movimento));

        movEntradaProd.setValordescontorateado(BigDecimal.ZERO);
        try {
            new MoventradaprodJpaController(managerCplus).edit(movEntradaProd);
            Moventrada entrada = new MoventradaJpaController(managerCplus).findMoventrada(movEntrada.getCodmoventr());
            editaEntrada(entrada, managerCplus);
            mensagemEntrada(movendaProd, serial, entrada, managerCplus);
            mensagemNotaFiscal(new MovendaJpaController(managerCplus).findMovenda(movendaProd.getCodmovenda().getCodmovenda()), entrada, managerCplus);
            String devolucao = movimento.getFlagdevolucao().toString();
            if ("Y".equals(devolucao)) {
                new LancamentoVale().lancamentoVale(usuario, movEntrada.getCodcli(), movendaProd.getCodmovenda(), entrada, managerCplus);
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
     *
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
        Integer configCont = new ConexaoDB().ultimoCodigo("MOVENTRADA", "CODMOVENTR");
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

            entrada.setValortotalprodutos(new BigDecimal(valTotalProdutos).setScale(4, RoundingMode.HALF_UP));
            entrada.setValortotalnota(new BigDecimal(valTotalNota).setScale(4, RoundingMode.HALF_UP));
            entrada.setValortotalipi(new BigDecimal(valIpi).setScale(4, RoundingMode.HALF_UP));
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
                }//fim if que verifica se a nota já está na observação
            }//fim for que verifica paavras           
        }
        if (notaExistente == false && movenda.getNumnota() != null) {
            String mens;
            if (movEntrada.getObsnotafiscal() == null) {
                mens = "";
            } else {
                mens = movEntrada.getObsnotafiscal();
            }
            mens = mens + "referente a Nota Nº: " + movenda.getNumnota().toString() + " Data: " + new FormataCampos().dataStringSoData(movenda.getData(), 0) + "\n";
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
     * função que traz o fator de conversão especificado na unidade do produto
     */
    private BigDecimal quantidadeConversaoEntrada(Movendaprod movEntradaProd) {
        BigDecimal quantidade = BigDecimal.ONE;
        for (Unidade un : queryCplus.resultPorUnidadeProduto(movEntradaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao();
            }
        }
        return quantidade;
    }
}
