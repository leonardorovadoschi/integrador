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
import entidade.cplus.Movendaprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtoestoque;
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
import jpa.cplus.MovendaprodJpaController;
import jpa.cplus.ProdutoestoqueJpaController;
import jpa.cplus.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leonardo
 */
public class SaidaClienteCplus {
    private QueryCplus queryCplus;
    private QueryIntegrador queryIntegrador;
    //private int decimaisArredondamento;
    public boolean saidaClienteCplus(boolean controlaEstoque, Tipomovimento movimentoSaidaCliente, Calculoicmsestado calculoIcmsEstado, Cliente cliente, Movendaprod movSaidaProd,
            String serial, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        queryCplus = new QueryCplus(managerCplus);
        queryIntegrador = new QueryIntegrador(managerIntegrador);
        //decimaisArredondamento =  Integer.valueOf(queryIntegrador.valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        boolean condicao = true;           
        if (condicao) {
            List<Movenda> listMovenda = queryCplus.listagemMovendaCliente(movimentoSaidaCliente.getCodigo(), cliente.getCodcli());
            if (listMovenda.isEmpty()) {               
                if(criarSaida(movimentoSaidaCliente, cliente, usuario, managerCplus, managerIntegrador)){               
                List<Movenda> listSaida = queryCplus.listagemMovendaCliente(movimentoSaidaCliente.getCodigo(), cliente.getCodcli());
                if (listSaida.size() == 1) {
                    for (Movenda saida : listSaida) {
                        if(criaSaidaProd(controlaEstoque, calculoIcmsEstado, saida, movSaidaProd, serial, managerCplus) == false){
                            condicao = false;
                        }
                    }
                }
                }else{
                    condicao = false;
                }
            } else if (listMovenda.size() == 1) {
                List<Movenda> listSaida = queryCplus.listagemMovendaCliente(movimentoSaidaCliente.getCodigo(), cliente.getCodcli());
                if (listSaida.size() == 1) {
                    for (Movenda saida : listSaida) {
                        List<Movendaprod> listMovSaidaProd = queryCplus.listagemMovSaidaProd(saida.getCodmovenda(), movSaidaProd.getCodprod().getCodprod(), movSaidaProd.getValorunitario());
                        if (listMovSaidaProd.isEmpty()) {
                            if(criaSaidaProd(controlaEstoque, calculoIcmsEstado, saida, movSaidaProd, serial, managerCplus) == false){
                                condicao = false;
                            }
                        } else {
                            for (Movendaprod prod : listMovSaidaProd) {
                                if(editaSaidaProd(controlaEstoque, movSaidaProd, saida, prod , serial, managerCplus) == false){
                                    condicao = false;
                                }
                            }
                        }//fim else com lista maior que zero
                    }                }
            } else if (listMovenda.size() > 1) {
                JOptionPane.showMessageDialog(null, "O Sistema acho mais que um resultado para essa transação!!!");
                condicao = false;
            }
        }//if que verifica se localizou operação
        return condicao;
    }

    private boolean criarSaida(Tipomovimento movimento, Cliente cliente, Usuario usuario, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = true;
        Movenda saida = new Movenda();
        //decrement para tabela MovEntrada
        
        Integer numPedido = new ConexaoDB().ultimoCodigo("MOVENDA", "NUMPED");
        Integer numCodMovenda = new ConexaoDB().ultimoCodigo("MOVENDA", "CODMOVENDA");                   
            saida.setCodmovenda(String.format("%09d", numCodMovenda));
            saida.setFlagcli('Y');
            saida.setCoduser(usuario.getCoduser());
            saida.setCodcli(cliente);
            //saida.setCodForn(fornecedor);
            
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
            if ("RS".equals(cliente.getEstado())) {
                saida.setCodcfop(new Cfop(movimento.getCodcfopdentrouf()));
            } else {
                saida.setCodcfop(new Cfop(movimento.getCodcfopforauf()));
            }
            saida.setPerccomissao(new BigDecimal(-1));
            saida.setFlagforncli('C');
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
        return condicao;
    }
    
     private BigDecimal valorUnitario(Movendaprod prod) {
        BigDecimal val = prod.getValortotal().subtract(prod.getValordescontorateado());
        val = val.divide(prod.getQuantidade(), 4, BigDecimal.ROUND_HALF_UP);
        return val;
    }
     
      private BigDecimal valorTotalProduto(Movendaprod prod, BigDecimal quantidadeEspelho) {
        BigDecimal val = valorUnitario(prod).multiply(quantidadeEspelho).setScale(2, BigDecimal.ROUND_HALF_UP);
        return val;
    }

    private boolean criaSaidaProd(Boolean controlaEstoque, Calculoicmsestado calculoIcmsEstado, Movenda saida, Movendaprod movSaidaProd, 
            String serial, EntityManagerFactory managerCplus) {
        boolean condicao = true;
        Movendaprod saidaProd = new Movendaprod();
        //IntConfiguracao configuracao = Integer.valueOf(queryIntegrador.valorCinfiguracao("increment_tabela_movenda_prod"));
        Integer configCont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_movenda_prod"));
        configCont--;
        try {
            queryIntegrador.atualizaValorConfiguracao("increment_tabela_movenda_prod", String.valueOf(configCont));
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar CodMovPro na Tabela Configuracao no Integrador!!!\n " + ex);
           condicao = false;
        }
       if(condicao){
            //double quant = 1.00;
            BigDecimal quant = quantidadeConversaoSaida(movSaidaProd.getCodprod());
           /*
           
            double valorUnitario = movSaidaProd.getValorunitario().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
            double valorTotal = valorUnitario * quant;
            double aliqIpi;
            if(movSaidaProd.getAliqipi() == null){
                aliqIpi = 0.00;
            }else{
            aliqIpi = movSaidaProd.getAliqipi().doubleValue();
            }
            double quantidadeMovEntrada = movSaidaProd.getQuantidade().doubleValue();
            double baseIpiMovEntrada;
            double baseIpi = 0.00;
            if(movSaidaProd.getBaseipi() == null){
                baseIpiMovEntrada = 0.00;
            }else{
            baseIpiMovEntrada = movSaidaProd.getBaseipi().doubleValue();
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
                if(movSaidaProd.getAliqicms() == null){
                    aliqIcms = 0.00;
                }else{
                aliqIcms = movSaidaProd.getAliqicms().doubleValue();
                }
                double baseIcmsMovenda;
                if(movSaidaProd.getBaseicms() == null){
                    baseIcmsMovenda =0.00;
                }else{
                baseIcmsMovenda = movSaidaProd.getBaseicms().doubleValue();
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
                if(movSaidaProd.getBasesubsttributaria() == null){
                   baseSTMovenda = 0.00; 
                }else{
                baseSTMovenda = movSaidaProd.getBasesubsttributaria().doubleValue();
                }
                baseSt = baseSTMovenda / quantidadeMovEntrada * quant;
                double valorSTMovenda;
                if(movSaidaProd.getValorsubsttributaria() == null){
                    valorSTMovenda = 0.00;
                }else{
                     valorSTMovenda  = movSaidaProd.getValorsubsttributaria().doubleValue();
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
                        if(movSaidaProd.getBasecofins() == null){
                            baseCofinsMovenda = 0.00;
                        }else{
                       baseCofinsMovenda = movSaidaProd.getBasecofins().doubleValue();
                        }
                baseCofins = baseCofinsMovenda / quantidadeMovEntrada * quant;
                if(movSaidaProd.getAliqcofins() == null){
                    aliqCofins = 0.00;
                }else{
                aliqCofins = movSaidaProd.getAliqcofins().doubleValue();
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
                if(movSaidaProd.getBasepis() == null){
                    basePisMovenda = 0.00;
                }else{
                      basePisMovenda = movSaidaProd.getBasepis().doubleValue();
                }
                basePis = basePisMovenda / quantidadeMovEntrada * quant;
                if(movSaidaProd.getAliqpis() == null){
                    aliqPis = 0.00;
                }else{
                aliqPis = movSaidaProd.getAliqpis().doubleValue();
                }
                valorPis = basePis * aliqPis / 100;
            } else {
                basePis = 0.00;
                aliqPis = 0.00;
                valorPis = 0.00;
            }
            */
            String configString = String.format("%09d", configCont);
            saidaProd.setCodmovprod(configString);
            saidaProd.setCodmovenda(saida);
            saidaProd.setCodprod(movSaidaProd.getCodprod());
            saidaProd.setQuantidade(quant);
            saidaProd.setValorunitario(valorUnitario(saidaProd));
            saidaProd.setFlagtipoacrescimoitem(movSaidaProd.getFlagtipoacrescimoitem());
            saidaProd.setAliqacrescimoitem(BigDecimal.ZERO);
            saidaProd.setValoracrescimoitem(BigDecimal.ZERO);
            saidaProd.setFlagtipodescontoitem(movSaidaProd.getFlagtipodescontoitem());
            saidaProd.setAliqdescontoitem(BigDecimal.ZERO);
            saidaProd.setValordescontoitem(BigDecimal.ZERO);
            saidaProd.setValortotal(valorTotalProduto(saidaProd, quant));
            saidaProd.setBaseipi(BigDecimal.ZERO);
            saidaProd.setAliqipi(movSaidaProd.getAliqipi());
            saidaProd.setValoripi(BigDecimal.ZERO);
            saidaProd.setBaseicms(BigDecimal.ZERO);
            saidaProd.setAliqicms(movSaidaProd.getAliqicms());
            saidaProd.setValoricms(BigDecimal.ZERO);
            saidaProd.setBasesubsttributaria(BigDecimal.ZERO);
            saidaProd.setValorsubsttributaria(BigDecimal.ZERO);
            saidaProd.setCodcfop(calculoIcmsEstado.getCodcfop());
            saidaProd.setFlagorigemproduto(movSaidaProd.getFlagorigemproduto());
            saidaProd.setCodsituacaotributaria(calculoIcmsEstado.getCodsituacaotributaria());
            saidaProd.setFlagcomposto(movSaidaProd.getFlagcomposto());
            
            saidaProd.setFlag1('Y');
            saidaProd.setFlag2('Y');
            saidaProd.setFlag3('N');
                       
            saidaProd.setDatavalidade(movSaidaProd.getDatavalidade());
            saidaProd.setCodclassificacaofiscal(movSaidaProd.getCodclassificacaofiscal());
            saidaProd.setValorfreterateado(movSaidaProd.getValorfreterateado());
            saidaProd.setValoracrescimorateado(movSaidaProd.getValoracrescimorateado());
            saidaProd.setValordescontorateado(movSaidaProd.getValordescontorateado());
            saidaProd.setValorsegurorateado(movSaidaProd.getValorsegurorateado());
            saidaProd.setValoroutrasdesprateado(movSaidaProd.getValoroutrasdesprateado());
            saidaProd.setCodsetorestoque("000000001");
            saidaProd.setBaseii(BigDecimal.ZERO);
            saidaProd.setAliqii(BigDecimal.ZERO);
            saidaProd.setValorii(BigDecimal.ZERO);
            saidaProd.setBasecofins(BigDecimal.ZERO);
            saidaProd.setAliqcofins(movSaidaProd.getAliqcofins());
            saidaProd.setValorcofins(BigDecimal.ZERO);
            saidaProd.setBasepis(BigDecimal.ZERO);
            saidaProd.setAliqpis(movSaidaProd.getAliqpis());
            saidaProd.setValorpis(BigDecimal.ZERO);
            saidaProd.setCstpis(calculoIcmsEstado.getCstpis());
            saidaProd.setCstcofins(calculoIcmsEstado.getCstcofins());
            try {
                new MovendaprodJpaController(managerCplus).create(saidaProd);
                               
            if(controlaEstoque){
                atualizaEstoque(movSaidaProd.getCodprod(), managerCplus);
            }
                
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada Produto!!!\n " + ex);
               condicao = false;
            }
            editaSaida(saida, managerCplus);
            mensagemEntrada(movSaidaProd, serial, saida, managerCplus);
       }
        return condicao;
    }

    private boolean editaSaidaProd(Boolean controlaEstoque, Movendaprod movSaidaProdVenda, Movenda saida, 
            Movendaprod movSaidaProdNovo, String serial, EntityManagerFactory managerCplus) {
        boolean condicao = true;
        BigDecimal quant = movSaidaProdNovo.getQuantidade();
       // quant = quant + 1.00;
        quant = quant.add(quantidadeConversaoSaida(movSaidaProdNovo.getCodprod()));
        /*
        double valorUnitario = movSaidaProdVenda.getValorunitario().setScale(decimaisArredondamento, BigDecimal.ROUND_HALF_UP).doubleValue();
        double valorTotal = valorUnitario * quant;
        double aliqIpi = movSaidaProdVenda.getAliqipi().doubleValue();
        double quantidadeMovEntrada = movSaidaProdVenda.getQuantidade().doubleValue();
        double baseIpiMovEntrada = movSaidaProdVenda.getBaseipi().doubleValue();
        if(baseIpiMovEntrada == 0.00 && aliqIpi > 0.00){
                baseIpiMovEntrada = valorTotal;
            }
        double baseIpi = 0.00;
            if(movSaidaProdVenda.getBaseipi() == null){
                baseIpiMovEntrada = 0.00;
            }else{
            baseIpiMovEntrada = movSaidaProdVenda.getBaseipi().doubleValue();
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
            aliqIcms = movSaidaProdVenda.getAliqicms().doubleValue();
            double baseIcmsMovenda = movSaidaProdVenda.getBaseicms().doubleValue();
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
            double baseSTMovenda = movSaidaProdVenda.getBasesubsttributaria().doubleValue();
            baseSt = baseSTMovenda / quantidadeMovEntrada * quant;
            double valorSTMovenda = movSaidaProdVenda.getValorsubsttributaria().doubleValue();
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
            double baseCofinsMovenda = movSaidaProdVenda.getBasecofins().doubleValue();
            baseCofins = baseCofinsMovenda / quantidadeMovEntrada * quant;
            aliqCofins = movSaidaProdVenda.getAliqcofins().doubleValue();
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
            double basePisMovenda = movSaidaProdVenda.getBasepis().doubleValue();
            basePis = basePisMovenda / quantidadeMovEntrada * quant;
            aliqPis = movSaidaProdVenda.getAliqpis().doubleValue();
            valorPis = basePis * aliqPis / 100;
        } else {
            basePis = 0.00;
            aliqPis = 0.00;
            valorPis = 0.00;
        }  
        */
        movSaidaProdNovo.setQuantidade(quant);       
        movSaidaProdNovo.setValorunitario(valorUnitario(movSaidaProdVenda));       
        movSaidaProdNovo.setValortotal(valorTotalProduto(movSaidaProdVenda, quant));
        movSaidaProdNovo.setBaseipi(BigDecimal.ZERO);
        movSaidaProdNovo.setAliqipi(movSaidaProdVenda.getAliqipi());
        movSaidaProdNovo.setValoripi(BigDecimal.ZERO);
        movSaidaProdNovo.setBaseicms(BigDecimal.ZERO);
        movSaidaProdNovo.setAliqicms(movSaidaProdVenda.getAliqicms());
        movSaidaProdNovo.setValoricms(BigDecimal.ZERO);
        movSaidaProdNovo.setBasesubsttributaria(BigDecimal.ZERO);
        movSaidaProdNovo.setValorsubsttributaria(BigDecimal.ZERO);     
        movSaidaProdNovo.setBasecofins(BigDecimal.ZERO);
        movSaidaProdNovo.setAliqcofins(movSaidaProdVenda.getAliqcofins());
        movSaidaProdNovo.setValorcofins(BigDecimal.ZERO);
        movSaidaProdNovo.setBasepis(BigDecimal.ZERO);
        movSaidaProdNovo.setAliqpis(movSaidaProdVenda.getAliqpis());
        movSaidaProdNovo.setValorpis(BigDecimal.ZERO);         
        try {
            new MovendaprodJpaController(managerCplus).edit(movSaidaProdNovo);
            editaSaida(saida, managerCplus);          
            if(controlaEstoque){
                atualizaEstoque(movSaidaProdVenda.getCodprod(), managerCplus);
            }
            mensagemEntrada(movSaidaProdVenda, serial, saida, managerCplus);                                     
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
            estoqueNovo.subtract(quantidadeConversaoSaida(produto));
            estoque.setEstatu(estoqueNovo);
            estoque.setLastChange(new Date(System.currentTimeMillis()));
            try {
                new ProdutoestoqueJpaController(managerCplus).edit(estoque);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar Estoque Produto!!!\n " + ex);
            }
        }
    }
    
    private boolean editaSaida(Movenda saida, EntityManagerFactory managerCplus) {
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
            double valTotalNota;
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

            valTotalNota = valFrete + valotrasDespesas + valSt + valIpi;

            saida.setValortotalprodutos(new BigDecimal(valTotalProdutos));
            saida.setValortotalnota(new BigDecimal(valTotalNota));
            saida.setValortotalipi(new BigDecimal(valIpi));
        
        }
        try {
            new MovendaJpaController(managerCplus).edit(saida);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Entrada!!!\n " + ex);
            condicao = false;
        }
        return condicao;
    }

    private void mensagemEntrada(Movendaprod movSaidaProd, String serial, Movenda movSaida, EntityManagerFactory managerCplus) {
        String mensagem;
        if (movSaida.getObs() == null) {
            mensagem = "";
        } else {
            mensagem = movSaida.getObs();
        }
        mensagem = mensagem + "Saida ref. Pedido de Venda: " + movSaidaProd.getCodmovenda().getNumped() + ", Data Lanï¿½amento: " + new FormataCampos().dataStringSoData(new Date(System.currentTimeMillis()), 0) + ", produto " + movSaidaProd.getCodprod().getNomeprod() + " com serial " + serial + "\n";
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
     * função que traz o fator de conversão especificado na unidade do produto
     */
    private BigDecimal quantidadeConversaoSaida(Produto produto) {
        BigDecimal quantidade = BigDecimal.ONE;
        for (Unidade un : queryCplus.resultPorUnidadeProduto(produto.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao();
            }
        }
        return quantidade;
    }
    }

   

