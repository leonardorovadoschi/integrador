/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.rma;

import acesso.ConexaoDB;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Cfop;
import entidade.cplus.Empresa;
import entidade.cplus.Fornecedor;
import entidade.cplus.Movdocreferenciado;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaproddevolucaocompra;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Setorestoque;
import entidade.cplus.Tipomovimento;
import entidade.cplus.Unidade;
import entidade.cplus.Usuario;
import janela.cplus.FormatacaoDeCampos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.MovdocreferenciadoJpaController;
import jpa.cplus.MovendaJpaController;
import jpa.cplus.MovendaprodJpaController;
import jpa.cplus.MovendaproddevolucaocompraJpaController;
import jpa.cplus.MovendaprodserialJpaController;
import jpa.cplus.PrecoJpaController;
import jpa.cplus.ProdutoestoqueJpaController;
import jpa.cplus.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leonardo
 */
public class SaidaFornecedorCplus {
    //Tipomovimento movimento;
   // Calculoicmsestado calculoIcmsEstado;
    QueryCplus queryCplus;

    /**
     * Funï¿½ï¿½o que trada de uma saida de cliente
     *
     * @param controlaEstoque
     * @param movimentoSaidaFornecedor
     * @param calculoIcmsEstado
     * @param fornecedor
     * @param movEntradaProd
     * @param serial
     * @param usuario
     * @param managerCplus
     * @param managerIntegrador
     * @return false se houver erro
     */
    public boolean saidaFornecedorCplus(boolean controlaEstoque, Tipomovimento movimentoSaidaFornecedor, Calculoicmsestado calculoIcmsEstado, Fornecedor fornecedor, Moventradaprod movEntradaProd,
            String serial, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        queryCplus = new QueryCplus(managerCplus);
        boolean condicao = true;           
            List<Movenda> listMovenda = queryCplus.listagemMovendaFornecedor(movimentoSaidaFornecedor.getCodigo(), fornecedor.getCodforn());
            if (listMovenda.isEmpty()) {               
                if(criarSaida(movimentoSaidaFornecedor, fornecedor, usuario, managerCplus, managerIntegrador)){               
                List<Movenda> listSaida = queryCplus.listagemMovendaFornecedor(movimentoSaidaFornecedor.getCodigo(), fornecedor.getCodforn());
                if (listSaida.size() == 1) {
                    for (Movenda saida : listSaida) {
                        if(criaSaidaProd(controlaEstoque, fornecedor, movimentoSaidaFornecedor, calculoIcmsEstado, saida, movEntradaProd, serial, managerIntegrador, managerCplus) == false){
                            condicao = false;
                        }
                    }
                }
                }else{
                    condicao = false;
                }
            } else if (listMovenda.size() == 1) {
                List<Movenda> listSaida = queryCplus.listagemMovendaFornecedor(movimentoSaidaFornecedor.getCodigo(), fornecedor.getCodforn());
                if (listSaida.size() == 1) {
                    for (Movenda saida : listSaida) {
                        List<Movendaprod> listMovSaidaProd = queryCplus.listagemMovSaidaProd(saida.getCodmovenda(), movEntradaProd.getCodprod().getCodprod(), movEntradaProd.getValorunitario());
                        if (listMovSaidaProd.isEmpty()) {
                            if(criaSaidaProd(controlaEstoque, fornecedor, movimentoSaidaFornecedor, calculoIcmsEstado, saida, movEntradaProd, serial, managerIntegrador, managerCplus) ==false){
                                condicao = false;
                            }
                        } else {
                            for (Movendaprod prod : listMovSaidaProd) {
                                if(editaSaidaProd(controlaEstoque, fornecedor, movimentoSaidaFornecedor, calculoIcmsEstado, prod, saida, movEntradaProd, serial, managerCplus, managerIntegrador) == false){
                                    condicao = false;
                                }
                            }
                        }//fim else com lista maior que zero
                    }                }
            } else if (listMovenda.size() > 1) {
                JOptionPane.showMessageDialog(null, "O Sistema acho mais que um resultado para essa transação!!!");
                condicao = false;
            }
        return condicao;
    }

    /**
     * Cria saida de produto somente uma unidade se vor de diferentes valores vai criar outro saida de Produto
     * @param movSaida
     * @param movEntradaProd
     * @param serial
     * @param managerIntegrador
     * @param managerCplus 
     */
    private boolean criaSaidaProd(boolean controlaEstoque, Fornecedor fornecedor, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado, Movenda movSaida, Moventradaprod movEntradaProd, 
                                  String serial, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        int decimaisArredondamento =  Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        boolean condicao = true;
        Movendaprod saidaProd = new Movendaprod();
        //IntConfiguracao configuracao = new QueryIntegrador(managerIntegrador).valorConfiguracao("increment_tabela_movenda_prod");
        Integer configCont = Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("increment_tabela_movenda_prod"));
        configCont--;
        //configuracao.setValorConfiguracao(Integer.toString(configCont));
        try {
           // new ConfiguracaoJpaController(managerIntegrador).edit(configuracao);
           new QueryIntegrador(managerIntegrador).atualizaValorConfiguracao("increment_tabela_movenda_prod", String.valueOf(configCont));
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuraçãode Entrada Produto!!!\n " + ex);
            condicao = false;
        }
        if(condicao){
            //double quant = 1.00;
            double quant = quantidadeConversaoSaida(movEntradaProd);
            double valorUnitario = movEntradaProd.getValorunitario().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            double valorTotal = valorUnitario * quant;
            double aliqIpi;
            if(movEntradaProd.getAliqipi() == null){
                aliqIpi = 0.00;
            }else{
            aliqIpi = movEntradaProd.getAliqipi().doubleValue();
            }
            double quantidadeMovEntrada = movEntradaProd.getQuantidade().doubleValue();
            double baseIpiMovEntrada;
            double baseIpi = 0.00;
            if(movEntradaProd.getBaseipi() == null){
                baseIpiMovEntrada = 0.00;
            }else{
            baseIpiMovEntrada = movEntradaProd.getBaseipi().doubleValue();
            if(baseIpiMovEntrada == 0.00 && aliqIpi > 0.00){
                baseIpiMovEntrada = valorTotal;
                baseIpi = baseIpiMovEntrada;
            }else{
                baseIpi = baseIpiMovEntrada / quantidadeMovEntrada * quant;
            }
            }
            
            double valorIpi = baseIpi * aliqIpi / 100;
            double icmsAliqEstado;
            if(calculoIcmsEstado.getAliqicms() == null){
                icmsAliqEstado = 0.00;
            }else{
            icmsAliqEstado = calculoIcmsEstado.getAliqicms().doubleValue();
            }
            double aliqIcms;
            double baseIcms;
            double valorIcms;
            if (icmsAliqEstado > 0.00) {
                if(movEntradaProd.getAliqicms() == null){
                    aliqIcms = 0.00;
                }else{
                aliqIcms = movEntradaProd.getAliqicms().doubleValue();
                }
                double baseIcmsMovenda;
                if(movEntradaProd.getBaseicms() == null){
                    baseIcmsMovenda =0.00;
                }else{
                baseIcmsMovenda = movEntradaProd.getBaseicms().doubleValue();
                }
                baseIcms = baseIcmsMovenda / quantidadeMovEntrada * quant;
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
                if(movEntradaProd.getBasesubsttributaria() == null){
                   baseSTMovenda = 0.00; 
                }else{
                baseSTMovenda = movEntradaProd.getBasesubsttributaria().doubleValue();
                }
                baseSt = baseSTMovenda / quantidadeMovEntrada * quant;
                double valorSTMovenda;
                if(movEntradaProd.getValorsubsttributaria() == null){
                    valorSTMovenda = 0.00;
                }else{
                     valorSTMovenda  = movEntradaProd.getValorsubsttributaria().doubleValue();
                }
                valorST = valorSTMovenda / quantidadeMovEntrada * quant;
            } else {
                baseSt = 0.00;
                valorST = 0.00;
            }
            double cofinsIcmsEstado;
            if(calculoIcmsEstado.getAliqcofins() == null){
                cofinsIcmsEstado = 0.00;
            }else{
                  cofinsIcmsEstado  = calculoIcmsEstado.getAliqcofins().doubleValue();
            }
            double baseCofins;
            double aliqCofins;
            double valorCofins;
            if (cofinsIcmsEstado > 0.00) {
                double baseCofinsMovenda; 
                        if(movEntradaProd.getBasecofins() == null){
                            baseCofinsMovenda = 0.00;
                        }else{
                       baseCofinsMovenda = movEntradaProd.getBasecofins().doubleValue();
                        }
                baseCofins = baseCofinsMovenda / quantidadeMovEntrada * quant;
                if(movEntradaProd.getAliqcofins() == null){
                    aliqCofins = 0.00;
                }else{
                aliqCofins = movEntradaProd.getAliqcofins().doubleValue();
                }
                valorCofins = baseCofins * aliqCofins / 100;
            } else {
                baseCofins = 0.00;
                aliqCofins = 0.00;
                valorCofins = 0.00;
            }
            double pisIcmsEstado;
            if(calculoIcmsEstado.getAliqpis() == null){
                pisIcmsEstado = 0.00;
            }else{
                pisIcmsEstado = calculoIcmsEstado.getAliqpis().doubleValue();
            }
            double basePis;
            double aliqPis;
            double valorPis;
            if (pisIcmsEstado > 0.00) {
                double basePisMovenda;
                if(movEntradaProd.getBasepis() == null){
                    basePisMovenda = 0.00;
                }else{
                      basePisMovenda = movEntradaProd.getBasepis().doubleValue();
                }
                basePis = basePisMovenda / quantidadeMovEntrada * quant;
                if(movEntradaProd.getAliqpis() == null){
                    aliqPis = 0.00;
                }else{
                aliqPis = movEntradaProd.getAliqpis().doubleValue();
                }
                valorPis = basePis * aliqPis / 100;
            } else {
                basePis = 0.00;
                aliqPis = 0.00;
                valorPis = 0.00;
            }
            String configString = String.format("%09d", configCont);
            saidaProd.setCodmovprod(configString);
            saidaProd.setCodmovenda(movSaida);
            saidaProd.setCodprod(movEntradaProd.getCodprod());
            saidaProd.setQuantidade(new BigDecimal(quant));
            //saidaProd.setQuantidadeembalagem(movEntradaProd.getCodprod().getQuantidadeembalagem());
            saidaProd.setValorunitario(movEntradaProd.getValorunitario());
            saidaProd.setFlagtipoacrescimoitem('V');
            saidaProd.setAliqacrescimoitem(BigDecimal.ZERO);
            saidaProd.setValoracrescimoitem(BigDecimal.ZERO);
            saidaProd.setFlagtipodescontoitem('V');
            saidaProd.setAliqdescontoitem(movEntradaProd.getAliqdescontoitem());
            saidaProd.setValordescontoitem(movEntradaProd.getValordescontoitem());
            saidaProd.setValortotal(new BigDecimal(valorTotal));
            saidaProd.setBaseipi(new BigDecimal(baseIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setAliqipi(movEntradaProd.getAliqipi());
            saidaProd.setValoripi(new BigDecimal(valorIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setBaseicms(new BigDecimal(baseIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setAliqicms(new BigDecimal(aliqIcms));
            saidaProd.setValoricms(new BigDecimal(valorIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setBasesubsttributaria(new BigDecimal(baseSt).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setValorsubsttributaria(new BigDecimal(valorST).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setCodcfop(calculoIcmsEstado.getCodcfop());
           
            saidaProd.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributaria());
            saidaProd.setFlagcomposto(movEntradaProd.getFlagcomposto());
            
            saidaProd.setFlag1('Y');
            saidaProd.setFlag2('Y');
            saidaProd.setFlag3('N');
            saidaProd.setValoriss(BigDecimal.ZERO);
            saidaProd.setCodpreco(new PrecoJpaController(managerCplus).findPreco("000000001"));
            saidaProd.setPrecotabela(movEntradaProd.getValorunitario());
            saidaProd.setCustoreal(movEntradaProd.getValorunitario());
            saidaProd.setCustomedio(movEntradaProd.getValorunitario());
            saidaProd.setAliqreducaobasesubsttributaria(movEntradaProd.getAliqreducaobasesubsttributaria());
            saidaProd.setValorrevenda(BigDecimal.ZERO);
            saidaProd.setAliqcreditosimplesnacional(BigDecimal.ZERO);
            saidaProd.setValorcreditosimplesnacional(BigDecimal.ZERO);
            saidaProd.setAliqicmsStUfDestino(movEntradaProd.getAliqicmsStUfDestino());
            saidaProd.setFlagtipoipi('A');
            saidaProd.setQuantidadeipi(BigDecimal.ZERO);
            saidaProd.setValorunidadeipi(BigDecimal.ZERO);
            saidaProd.setCodcalculoicms(movEntradaProd.getCodprod().getCodcalculoicms().getCodcalculoicms());
            if("1".equals(movEntradaProd.getFlagorigemproduto().toString()) || "2".equals(movEntradaProd.getFlagorigemproduto().toString()) ||
                    "6".equals(movEntradaProd.getFlagorigemproduto().toString()) || "7".equals(movEntradaProd.getFlagorigemproduto().toString())){
             saidaProd.setFlagorigemproduto('2');
            }else{
              saidaProd.setFlagorigemproduto('0');  
            }          
            saidaProd.setDatavalidade(movEntradaProd.getDatavalidade());
            saidaProd.setCodclassificacaofiscal(movEntradaProd.getCodclassificacaofiscal());
            saidaProd.setValorfreterateado(BigDecimal.ZERO);
            saidaProd.setValoracrescimorateado(BigDecimal.ZERO);
            saidaProd.setValordescontorateado(BigDecimal.ZERO);
            saidaProd.setValorsegurorateado(BigDecimal.ZERO);
            saidaProd.setValoroutrasdesprateado(BigDecimal.ZERO);
            saidaProd.setCodsetorestoque("000000001");
            saidaProd.setBaseii(BigDecimal.ZERO);
            saidaProd.setAliqii(BigDecimal.ZERO);
            saidaProd.setValorii(BigDecimal.ZERO);
            //saidaProd.setCodmovproddevolucao(movEntradaProd.getCodmovprod());
            saidaProd.setBasecofins(new BigDecimal(baseCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setAliqcofins(new BigDecimal(aliqCofins));
            saidaProd.setValorcofins(new BigDecimal(valorCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setBasepis(new BigDecimal(basePis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            saidaProd.setAliqpis(new BigDecimal(aliqPis));
            saidaProd.setValorpis(new BigDecimal(valorPis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
            //saidaProd.setFatorconversao(BigDecimal.ONE);
            saidaProd.setCstpis(calculoIcmsEstado.getCstpis());
            saidaProd.setCstcofins(calculoIcmsEstado.getCstcofins());
            try {
                new MovendaprodJpaController(managerCplus).create(saidaProd);
              //  editaSeriaSaida(serial, new MovendaprodJpaController(managerCplus).findMovendaprod(configString), managerCplus);
               // String devolucao = movimento.getFlagdevolucao().toString();
               // if("Y".equals(devolucao)){
               // relacaoNotaParaDevolucaoFornecedor(movSaida, movEntradaProd.getCodmoventr(), managerCplus, managerIntegrador);
               // }
                String controlaDevolucao = movimento.getFlagdevolucaocompra().toString();
                if("Y".equals(controlaDevolucao) ){
                    controleDevolucaofornecedor(fornecedor, new MovendaprodJpaController(managerCplus).findMovendaprod(configString), managerCplus, managerIntegrador);
                }
                 if(controlaEstoque){
                    atualizaEstoque(movEntradaProd.getCodprod(), managerCplus);
                }
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada Produto!!!\n " + ex);
               condicao = false;
            }
            editaSaida(movimento, movSaida, managerCplus);
            mensagemEntrada(movEntradaProd, serial, movSaida, managerCplus);
        }
        return condicao;
    }
    /**
     * Funï¿½ï¿½o que cria ou edita o controle para devoluï¿½ï¿½od e compra
     * @param fornecedor
     * @param saidaProd
     * @param managerCplus
     * @param managerIntegrador 
     */
    private void controleDevolucaofornecedor(Fornecedor fornecedor, Movendaprod saidaProd, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        List<Movendaproddevolucaocompra> listDevProd = queryCplus.listagemControlaDevolucaoPorSaidaProd(saidaProd.getCodmovprod());
        if (listDevProd.isEmpty()) {
            //Configuracao configuracao = new QueryIntegrador(managerIntegrador).valorConfiguracao("increment_tabela_movenda_controla_devolucao");
            Integer configCont = Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("increment_tabela_movenda_controla_devolucao"));
            configCont--;
            //configuracao.setValorConfiguracao(Integer.toString(configCont));
            try {
               // new ConfiguracaoJpaController(managerIntegrador).edit(configuracao);
               new QueryIntegrador(managerIntegrador).atualizaValorConfiguracao("increment_tabela_movenda_controla_devolucao", String.valueOf(configCont));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de Entrada Produto!!!\n " + ex);
            }
            Movendaproddevolucaocompra devProd = new Movendaproddevolucaocompra();
            devProd.setCodmovendaproddevolucaocompra(String.format("%09d", configCont));
            devProd.setCodprod(saidaProd.getCodprod());
            devProd.setCodforn(fornecedor);
            devProd.setCodmovprod(saidaProd);
            devProd.setQuantidade(saidaProd.getQuantidade());
            devProd.setValorcusto(saidaProd.getValortotal().add(saidaProd.getValorsubsttributaria().add(saidaProd.getValoripi())));
            devProd.setDatasaida(new Date(System.currentTimeMillis()));
            devProd.setQuantidaderetornada(BigDecimal.ZERO);
            devProd.setDataprevistadevolucao(new Date(System.currentTimeMillis()));
            devProd.setValorretornado(BigDecimal.ZERO);

            try {
                new MovendaproddevolucaocompraJpaController(managerCplus).create(devProd);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Controle de devoluï¿½ï¿½o!!!\n " + ex);
            }
        } else if (listDevProd.size() == 1) {
            for (Movendaproddevolucaocompra dev : listDevProd) {
                dev.setQuantidade(saidaProd.getQuantidade());
                dev.setValorcusto(saidaProd.getValortotal().add(saidaProd.getValorsubsttributaria().add(saidaProd.getValoripi())));
                dev.setDatasaida(new Date(System.currentTimeMillis()));
                try {
                    new MovendaproddevolucaocompraJpaController(managerCplus).edit(dev);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Controle de devoluï¿½ï¿½o!!!\n " + ex);
                }
            }
        }
    }   
    /**
     * Funï¿½ï¿½o que relaciona a nota de compra com a devoluï¿½ï¿½o para fornecedor
     * @param movSaida
     * @param movEntrada
     * @param managerCplus
     * @param managerIntegrador 
     */
    private void relacaoNotaParaDevolucaoFornecedor(Movenda movSaida, Moventrada movEntrada, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        List<Movdocreferenciado> lisNota = queryCplus.relacaoNotaDevolucaoFornecedor(movEntrada.getCodmoventr(), movSaida.getCodmovenda());
        if (lisNota.isEmpty()) {
            //Configuracao configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_movenda_doc_referencia");
            Integer configCont = Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("increment_tabela_movenda_doc_referencia"));
            configCont--;
           // configuracao.setValorConfiguracao(Integer.toString(configCont));
            try {
                new QueryIntegrador(managerIntegrador).atualizaValorConfiguracao("increment_tabela_movenda_doc_referencia", String.valueOf(configCont));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de Entrada Produto!!!\n " + ex);
            }
            Movdocreferenciado refNota = new Movdocreferenciado();
            refNota.setCodmovdocreferenciado(String.format("%09d", configCont)); 
            refNota.setModelonota(movEntrada.getModelonota());
            refNota.setNumdoc(movEntrada.getNumnota());
            refNota.setSerie(movEntrada.getSerienota());
            refNota.setChaveacessonfeletronica(movEntrada.getNumerochavenfe());
            refNota.setDataemissao(movEntrada.getDataemissao());
            refNota.setNomeentidadeorigem("MOVENDA");
            refNota.setNomeentidadeorigemref("MOVENTRADA");
            refNota.setIdentidadeorigem(movSaida.getCodmovenda());
            refNota.setIdentidadeorigemref(movEntrada.getCodmoventr());                  
            try {
                new MovdocreferenciadoJpaController(managerCplus).create(refNota);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Referencia de Nota de compra!!!\n " + ex);
            }
        }
    }
    /**
     * Edita a saida de Produtos incrementa mais um
     * @param movSaidaProd
     * @param movSaida
     * @param movEntradaProd
     * @param serial
     * @param managerCplus 
     */
    private boolean editaSaidaProd(boolean controlaEstoque, Fornecedor fornecedor, Tipomovimento movimento, Calculoicmsestado calculoIcmsEstado,Movendaprod movSaidaProd, Movenda movSaida, 
            Moventradaprod movEntradaProd, String serial, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        int decimaisArredondamento =  Integer.valueOf(new QueryIntegrador(managerIntegrador).valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        double quant = movSaidaProd.getQuantidade().doubleValue();
        //quant = quant + 1.00;
        quant = quant + quantidadeConversaoSaida(movEntradaProd);
        double valorUnitario = movEntradaProd.getValorunitario().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
        double valorTotal = valorUnitario * quant;
        double aliqIpi = movEntradaProd.getAliqipi().doubleValue();
        double quantidadeMovEntrada = movEntradaProd.getQuantidade().doubleValue();
        double baseIpiMovEntrada = movEntradaProd.getBaseipi().doubleValue();
        if(baseIpiMovEntrada == 0.00 && aliqIpi > 0.00){
                baseIpiMovEntrada = valorTotal;
            }
        double baseIpi = 0.00;
            if(movEntradaProd.getBaseipi() == null){
                baseIpiMovEntrada = 0.00;
            }else{
            baseIpiMovEntrada = movEntradaProd.getBaseipi().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            if(baseIpiMovEntrada == 0.00 && aliqIpi > 0.00){
                baseIpiMovEntrada = valorTotal;
                baseIpi = baseIpiMovEntrada;
            }else{
                baseIpi = baseIpiMovEntrada / quantidadeMovEntrada * quant;
            }
            }
        
        double valorIpi = baseIpi * aliqIpi / 100;
        double icmsAliqEstado = calculoIcmsEstado.getAliqicms().doubleValue();
        double aliqIcms;
        double baseIcms;
        double valorIcms;
        if (icmsAliqEstado > 0.00) {
            aliqIcms = movEntradaProd.getAliqicms().doubleValue();
            double baseIcmsMovenda = movEntradaProd.getBaseicms().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            baseIcms = baseIcmsMovenda / quantidadeMovEntrada * quant;
            valorIcms = baseIcms * aliqIcms / 100;
        } else {
            aliqIcms = 0.00;
            baseIcms = 0.00;
            valorIcms = 0.00;
        }
        double baseSt;
        double valorST;
        if (calculoIcmsEstado.getFlagcalculasubsttributaria() == 'Y') {
            double baseSTMovenda = movEntradaProd.getBasesubsttributaria().doubleValue();
            baseSt = baseSTMovenda / quantidadeMovEntrada * quant;
            double valorSTMovenda = movEntradaProd.getValorsubsttributaria().doubleValue();
            valorST = valorSTMovenda / quantidadeMovEntrada * quant;
        } else {
            baseSt = 0.00;
            valorST = 0.00;
        }
        double cofinsIcmsEstado;
            if(calculoIcmsEstado.getAliqcofins() == null){
                cofinsIcmsEstado = 0.00;
            }else{
                  cofinsIcmsEstado  = calculoIcmsEstado.getAliqcofins().doubleValue();
            }
        double baseCofins;
        double aliqCofins;
        double valorCofins;
        if (cofinsIcmsEstado > 0.00) {
            double baseCofinsMovenda = movEntradaProd.getBasecofins().doubleValue();
            baseCofins = baseCofinsMovenda / quantidadeMovEntrada * quant;
            aliqCofins = movEntradaProd.getAliqcofins().doubleValue();
            valorCofins = baseCofins * aliqCofins / 100;
        } else {
            baseCofins = 0.00;
            aliqCofins = 0.00;
            valorCofins = 0.00;
        }
        double pisIcmsEstado;
            if(calculoIcmsEstado.getAliqpis() == null){
                pisIcmsEstado = 0.00;
            }else{
                pisIcmsEstado = calculoIcmsEstado.getAliqpis().doubleValue();
            }
        double basePis;
        double aliqPis;
        double valorPis;
        if (pisIcmsEstado > 0.00) {
            double basePisMovenda = movEntradaProd.getBasepis().doubleValue();
            basePis = basePisMovenda / quantidadeMovEntrada * quant;
            aliqPis = movEntradaProd.getAliqpis().doubleValue();
            valorPis = basePis * aliqPis / 100;
        } else {
            basePis = 0.00;
            aliqPis = 0.00;
            valorPis = 0.00;
        }           
        movSaidaProd.setQuantidade(new BigDecimal(quant));       
        movSaidaProd.setValorunitario(movEntradaProd.getValorunitario());       
        movSaidaProd.setValortotal(new BigDecimal(valorTotal));
        movSaidaProd.setBaseipi(new BigDecimal(baseIpi));
        movSaidaProd.setAliqipi(movEntradaProd.getAliqipi());
        movSaidaProd.setValoripi(new BigDecimal(valorIpi).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setBaseicms(new BigDecimal(baseIcms));
        movSaidaProd.setAliqicms(new BigDecimal(aliqIcms));
        movSaidaProd.setValoricms(new BigDecimal(valorIcms).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setBasesubsttributaria(new BigDecimal(baseSt).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setValorsubsttributaria(new BigDecimal(valorST).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));     
        movSaidaProd.setBasecofins(new BigDecimal(baseCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setAliqcofins(new BigDecimal(aliqCofins));
        movSaidaProd.setValorcofins(new BigDecimal(valorCofins).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setBasepis(new BigDecimal(basePis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));
        movSaidaProd.setAliqpis(new BigDecimal(aliqPis));
        movSaidaProd.setValorpis(new BigDecimal(valorPis).setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP));         
        try {
            new MovendaprodJpaController(managerCplus).edit(movSaidaProd);
            editaSaida(movimento, movSaida, managerCplus);
            mensagemEntrada(movEntradaProd, serial, movSaida, managerCplus);
            String devolucao = movimento.getFlagdevolucao().toString();
                if("Y".equals(devolucao)){
                relacaoNotaParaDevolucaoFornecedor(movSaida, movEntradaProd.getCodmoventr(), managerCplus, managerIntegrador);
                }
                
                String controlaDevolucao = movimento.getFlagdevolucaocompra().toString();
                if("Y".equals(controlaDevolucao) ){
                    controleDevolucaofornecedor(fornecedor, movSaidaProd, managerCplus, managerIntegrador);
                }
                if(controlaEstoque){
                    atualizaEstoque(movEntradaProd.getCodprod(), managerCplus);
                }
               // editaSeriaSaida(serial, movSaidaProd, managerCplus);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Entrada Produto!!!\n " + ex);
            condicao = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Entrada Produto!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }
    
    private void atualizaEstoque(Produto produto, EntityManagerFactory managerCplus){
        List<Produtoestoque> listestoque = queryCplus.listagemProdutoEstoque(produto.getCodprod());
        for(Produtoestoque estoque : listestoque){
            BigDecimal estoqueNovo = estoque.getEstatu();
            estoqueNovo.subtract(new BigDecimal(quantidadeConversaoSaida(produto)));
            estoque.setEstatu(estoqueNovo);
            estoque.setLastChange(new Date(System.currentTimeMillis()));
            try {
                new ProdutoestoqueJpaController(managerCplus).edit(estoque);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar Estoque Produto!!!\n " + ex);
            }
        }
    }

    /**
     * Cria saida para cliente nas funï¿½ï¿½es de devoluï¿½ï¿½o e remessa somente
     * @param cliente
     * @param movenda
     * @param usuario
     * @param numNota
     * @param managerCplus
     * @param managerIntegrador 
     */
    private boolean criarSaida(Tipomovimento movimento, Fornecedor fornecedor, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        Movenda saida = new Movenda();
        //decrement para tabela MovEntrada
        /**
        Configuracao configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_movenda");
        Integer configCont = Integer.valueOf(configuracao.getValorConfiguracao());
        configCont--;
        configuracao.setValorConfiguracao(Integer.toString(configCont));
        try {
            new ConfiguracaoJpaController(managerIntegrador).edit(configuracao);
            } catch (Exception ex) {//fim catch da tabela configuraï¿½ï¿½o
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuraï¿½ï¿½o de entrada!!!\n " + ex);
            condicao = false;
        }
        
        configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_movenda_numero_pedido");
        Integer numPedido= Integer.valueOf(configuracao.getValorConfiguracao());
        numPedido--;
        configuracao.setValorConfiguracao(Integer.toString(numPedido));
        try {
            new ConfiguracaoJpaController(managerIntegrador).edit(configuracao);
            } catch (Exception ex) {//fim catch da tabela configuraï¿½ï¿½o
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuraï¿½ï¿½o de entrada!!!\n " + ex);
            condicao = false;
        }
        */
       // if(condicao){
       Integer numPedido = new ConexaoDB().ultimoCodigo("MOVENDA", "NUMPED");
        Integer numCodMovenda = new ConexaoDB().ultimoCodigo("MOVENDA", "CODMOVENDA"); 
           // String configString = String.format("%09d", configCont);
            saida.setCodmovenda(String.format("%09d", numCodMovenda));
            saida.setFlagcli('N');
            saida.setCoduser(usuario.getCoduser());
            //saida.setCodcli(cliente);
            saida.setCodForn(fornecedor);
            
            saida.setCodempresa(new Empresa(1));
            saida.setCodsetorestoque(new Setorestoque("000000001"));
            saida.setData(new Date(System.currentTimeMillis()));
            saida.setNumped(numPedido);
            saida.setModelonota("55");
            saida.setFlagvenda('N');
            //entrada.setObs(obs);
            saida.setBaseicms(BigDecimal.ZERO);
            saida.setValoricms(BigDecimal.ZERO);
            saida.setBasesubsttributaria(BigDecimal.ZERO);
            saida.setValorsubsttributaria(BigDecimal.ZERO);
            saida.setValorfrete(BigDecimal.ZERO);
            saida.setValoroutrasdespesas(BigDecimal.ZERO);
            if ("RS".equals(fornecedor.getEstado())) {
                saida.setCodcfop(new Cfop(movimento.getCodcfopdentrouf()));
            } else {
                saida.setCodcfop(new Cfop(movimento.getCodcfopforauf()));
            }
            saida.setPerccomissao(new BigDecimal(-1));
            saida.setFlagforncli('F');
            saida.setCodtipomovimento(movimento);
            saida.setHora(new Date(System.currentTimeMillis()));
            saida.setFlagcancelada('N');
           // saida.setFlagemissaopropria('N');
            
            saida.setValorseguro(BigDecimal.ZERO);
            saida.setValordesconto(BigDecimal.ZERO);
            saida.setValoracrescimo(BigDecimal.ZERO);
            saida.setAliqacrescimo(BigDecimal.ZERO);
            saida.setAliqdesconto(BigDecimal.ZERO);
            saida.setDatalancamento(new Date(System.currentTimeMillis()));
            saida.setPesoadicionalembalagem(BigDecimal.ZERO);
            saida.setPesoliquido(BigDecimal.ZERO);
            saida.setPesobruto(BigDecimal.ZERO);
            saida.setFlagaltpaf('N');
            saida.setFlagcontroleentrega('N');
            saida.setFlagnfcomplementar('N');
            saida.setValortotalservicos(BigDecimal.ZERO);
            saida.setValortotalrevenda(BigDecimal.ZERO);
            
            saida.setValortotalprodutos(BigDecimal.ZERO);
            saida.setValortotalnota(BigDecimal.ZERO);
            saida.setValortotalipi(BigDecimal.ZERO);
            saida.setFlagfrete('E');
            saida.setValortotalcofins(BigDecimal.ZERO);
            saida.setValortotalpis(BigDecimal.ZERO);
            saida.setValortotaliss(BigDecimal.ZERO);
            saida.setFlagestoqueliberado('Y');
            
            saida.setIndpresenca('0');
            saida.setIndoperacao('0');
            saida.setFlagenviowms('N');
            saida.setFlagreservado('N');
            saida.setFlagnfajuste('N');
            saida.setRentabilidade(BigDecimal.ZERO);
            saida.setFlagdelivery('N');
            if("Y".equals(movimento.getFlagdevolucao().toString())){
            saida.setFlagdocreferenciado('Y');
            saida.setFlagnfdevolucao('Y');
            }else{
                saida.setFlagdocreferenciado('N');
                saida.setFlagnfdevolucao('N');
            }
           // saida.setValoricmsincentfiscal(BigDecimal.ZERO);
            try {
                new MovendaJpaController(managerCplus).create(saida);
                numPedido ++;
                new ConexaoDB().atualizarCodigo("MOVENDA", "NUMPED", numPedido);
                numCodMovenda ++;
                new ConexaoDB().atualizarCodigo("MOVENDA", "CODMOVENDA", numCodMovenda);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada!!!\n " + ex);
                condicao = false;
            }
      //  }
        return condicao;
    }
    /**
     * Atualiza totais da nota fiscal
     * @param saida
     * @param managerCplus
     */
    private boolean editaSaida(Tipomovimento movimento, Movenda saida, EntityManagerFactory managerCplus) {
       boolean condicao = true;
        List<Movendaprod> listMovProd = queryCplus.listMovendaProd(saida.getCodmovenda());
        if (listMovProd.isEmpty()) {
            saida.setBaseicms(BigDecimal.ZERO);
            saida.setValoricms(BigDecimal.ZERO);
            saida.setBasesubsttributaria(BigDecimal.ZERO);
            saida.setValorsubsttributaria(BigDecimal.ZERO);
            saida.setValorfrete(BigDecimal.ZERO);
            saida.setValoroutrasdespesas(BigDecimal.ZERO);
            saida.setValortotalprodutos(BigDecimal.ZERO);
            saida.setValortotalnota(BigDecimal.ZERO);
            saida.setValortotalipi(BigDecimal.ZERO);
            saida.setValortotalcofins(BigDecimal.ZERO);
            saida.setValortotalpis(BigDecimal.ZERO);
        } else {
            double valIcms = 0.00;
            double basIcms = 0.00;
            double basSt = 0.00;
            double valSt = 0.00;
            double valTotalProdutos = 0.00;
            double valIpi = 0.00;
            double valTotalNota = 0.00;
            double valPis = 0.00;
            double valFrete = 0.00;
            double valotrasDespesas = 0.00;
            double valCofins = 0.00;
            for (Movendaprod prod : listMovProd) {
                valIcms = valIcms + prod.getValoricms().doubleValue();
                basIcms = basIcms + prod.getBaseicms().doubleValue();
                basSt = basSt + prod.getBasesubsttributaria().doubleValue();
                valSt = valSt + prod.getValorsubsttributaria().doubleValue();
                valTotalProdutos = valTotalProdutos + prod.getValortotal().doubleValue();
                valIpi = valIpi + prod.getValoripi().doubleValue();
                valPis = valPis + prod.getValorpis().doubleValue();
                valCofins = valCofins + prod.getValorcofins().doubleValue();
            }//fim for que soma o total dos valores
            saida.setBaseicms(new BigDecimal(basIcms));
            saida.setValoricms(new BigDecimal(valIcms));
            saida.setBasesubsttributaria(new BigDecimal(basSt));
            saida.setValorsubsttributaria(new BigDecimal(valSt));
            saida.setValortotalcofins(new BigDecimal(valCofins));
            saida.setValortotalpis(new BigDecimal(valPis));
            saida.setData(new Date(System.currentTimeMillis()));

            valTotalNota = valFrete + valotrasDespesas + valSt + valIpi;

            saida.setValortotalprodutos(new BigDecimal(valTotalProdutos));
            saida.setValortotalnota(new BigDecimal(valTotalNota));
            saida.setValortotalipi(new BigDecimal(valIpi));
            
            saida.setIndpresenca('0');
            saida.setIndoperacao('0');
            saida.setFlagenviowms('N');
            saida.setFlagreservado('N');
            saida.setFlagnfajuste('N');
            saida.setRentabilidade(BigDecimal.ZERO);
            saida.setFlagdelivery('N');
            if("Y".equals(movimento.getFlagdevolucao().toString())){
            saida.setFlagdocreferenciado('Y');
            saida.setFlagnfdevolucao('Y');
            }else{
                saida.setFlagdocreferenciado('N');
                saida.setFlagnfdevolucao('N');
            }
        }
        try {
            new MovendaJpaController(managerCplus).edit(saida);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }
    /**
     * Cria mensagem para Entrada
     *
     * @param movEntradaProd
     * @param serial
     * @param movSaida
     */
    private void editaSeriaSaida(String serial, Movendaprod saidaProd, EntityManagerFactory managerCplus){
        List<Movendaprodserial> listSaidaSerial = queryCplus.listagemSaidaSerialExato(serial);
        if(listSaidaSerial.size() == 1){
            for(Movendaprodserial ser : listSaidaSerial){
                ser.setCodmovprod(saidaProd);
                try {
                    new MovendaprodserialJpaController(managerCplus).edit(ser);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao editar serial na saida!!!\n " +ex );
                }
            }
        }else{
             JOptionPane.showMessageDialog(null, "Não foi possivel editar a saida do Serial!!!\n " );
        }
    }
    private void mensagemEntrada(Moventradaprod movEntradaProd, String serial, Movenda movSaida, EntityManagerFactory managerCplus) {
        String mensagem;
        if(movSaida.getObs() == null){
            mensagem = "";
        }else{
        mensagem = movSaida.getObs();
        }
        mensagem = mensagem + "Saida ref. Nota de Compra: " + movEntradaProd.getCodmoventr().getNumnota() + ", Data Lançamento: "+new FormatacaoDeCampos().dataStringSoData(new Date(System.currentTimeMillis()), 0)+ " produto " + movEntradaProd.getCodprod().getNomeprod() + " com serial " + serial + "\n";
        movSaida.setObs(mensagem);
        try {
            new MovendaJpaController(managerCplus).edit(movSaida);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem de entrada!!!\n " + ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Criar Mensagem de entrada!!!\n " + ex);
        }
    }
     /**
     * funï¿½ï¿½o que traz o fator de converï¿½ï¿½o especificado na unidade do produto
     */
    private double quantidadeConversaoSaida(Moventradaprod movEntradaProd) {
        double quantidade = 1.00;
        for (Unidade un : queryCplus.resultPorUnidadeProduto(movEntradaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().doubleValue();
            }
        }
        return quantidade;
    }
    
    /**
     * funï¿½ï¿½o que traz o fator de converï¿½ï¿½o especificado na unidade do produto
     */
    private double quantidadeConversaoSaida(Produto produto) {
        double quantidade = 1.00;
        for (Unidade un : queryCplus.resultPorUnidadeProduto(produto.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().doubleValue();
            }
        }
        return quantidade;
    }
}
