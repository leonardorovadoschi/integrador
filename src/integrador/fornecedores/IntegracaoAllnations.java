/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;

import entidade.cplus.Produto;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import query.integrador.QueryIntegrador;

//import integrador.produto.ProdutoFornecedorLegiao;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;
import jpa.integrador.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class IntegracaoAllnations {

    public void integracaoAllnations(List<ProdutoAll> listProdAll, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        deletarProdutos(managerIntegrador);
        atualizaProdutosAllnations(listProdAll, managerIntegrador, managerCplus, managerDigimacro);
    }

    private void deletarProdutos(EntityManagerFactory managerIntegrador) {
        // ManipulaFornecedores utilitario = new ManipulaFornecedores();
        List<ProdFornecedor> listProdFornecedor = new QueryIntegrador().listaProdFornecedor("ALL NATIONS");
        for (ProdFornecedor proForn : listProdFornecedor) {
            try {
                new ProdFornecedorJpaController(managerIntegrador).destroy(proForn.getIdProdutos());
            } catch (NonexistentEntityException ex) {
                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro ao Excluir Produto All Nations " + proForn.getDescricao() + "  " + ex, "Erro Excluir");
            }
        }
    }

    private void atualizaProdutosAllnations(List<ProdutoAll> listProdAll, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        for (ProdutoAll prodAll : listProdAll) {
            if (prodAll.getPRECOREVENDA().doubleValue() > 0.00 && prodAll.getATIVO() == 1 && prodAll.getDISPONIVEL() == 1) {
                criarProdutosAllnationsIntegrador(prodAll, managerIntegrador, managerCplus, managerDigimacro);
            }
        }
    }

    private void criarProdutosAllnationsIntegrador(ProdutoAll prodAll, EntityManagerFactory managerIntegracao, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        ManipulaFornecedores utilitario = new ManipulaFornecedores();
        List<Produto> listProdIntegracao = new QueryCplus(managerCplus).listProdutoCodigoPrincipal(prodAll.getEAN().trim());
        for (Produto produto : listProdIntegracao) {
            ProdFornecedor proForn = new ProdFornecedor();
            proForn.setCodigoFornecedor(prodAll.getCODIGO());
            proForn.setReferenceCplus(produto.getCodprod());
            proForn.setNomeFornecedor("ALL NATIONS");
            proForn.setDescricao(prodAll.getDESCRICAO());
            // proForn.setIdProduto(prod);
            proForn.setAtivo(1);
            proForn.setOrigemProduto(prodAll.getORIGEMPRODUTO());
            proForn.setDisponivel(1);
            proForn.setEstoque(prodAll.getESTOQUE());
            //proForn.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proForn, managerCplus));
            proForn.setPorcentagemStRs(new BigDecimal(BigInteger.ZERO));
            // BigDecimal precoCusto = prodAll.getPRECOSEMST();
            proForn.setPrecoCusto(prodAll.getPRECOSEMST());
            //proForn.setPrecoCustoComSt(utilitario.precoSemStParaComSt(proForn.getPorcentagemStRs(), precoCusto));
            proForn.setPrecoCustoComSt(new BigDecimal(BigInteger.ZERO));
            //proForn.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(precoCusto, proForn, managerCplus));
            proForn.setPorcentagemOutrosCustos(new BigDecimal(BigInteger.ZERO));
            //proForn.setValorStRs(proForn.getPrecoCustoComSt().subtract(precoCusto));
            proForn.setValorStRs(new BigDecimal(BigInteger.ZERO));
            proForn.setValorCustoRs(utilitario.precoCustoRs(proForn));
            proForn.setSubcategoria(utilitario.previsaoEntrega(prodAll.getESTOQUE()));
            proForn.setEan(prodAll.getEAN());
            proForn.setFabricante(prodAll.getFABRICANTE());
            proForn.setUltimaImportacao(new Date(System.currentTimeMillis()));
            proForn.setNcm(prodAll.getNCM());
            try {
                new ProdFornecedorJpaController(managerIntegracao).create(proForn);
            } catch (Exception ex) {
                criaLog(managerIntegracao, new Date(System.currentTimeMillis()), ", Erro na tabela ProdFornecedor no integrador " + prodAll.getDESCRICAO() + "  " + ex, "Erro Edição");
            }
        }
    }

    private void criaLog(EntityManagerFactory managerIntegracao, Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }
}
