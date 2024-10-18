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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class IntegracaoColecao {

    public void integradorColecao(List<EntidadeColecao> listProdCole, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {

       // try {
            lerArquivoColecaoTxt(listProdCole, managerIntegrador, managerCplus);
       // } catch (IOException | ParseException ex) {
       //     criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro Atualiza Banco na importação da Coleção " + "  " + ex, "Erro Editar");
       // }
    }

    private void lerArquivoColecaoTxt(List<EntidadeColecao> listProdCole, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
       
        List<ProdFornecedor> listAllIntegrador = new QueryIntegrador().listaProdFornecedor("COLECAO");
        for (ProdFornecedor proIntegrador : listAllIntegrador) {
            try {
                new ProdFornecedorJpaController(managerIntegrador).destroy(proIntegrador.getIdProdutos());
                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Não existe mais na lista Coleção: " + proIntegrador.getDescricao(), "Informar");
            } catch (Exception ex) {
                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + proIntegrador.getDescricao() + "  " + ex, "Erro Excluir");
            }
        }
        atualizaBanco(listProdCole, managerIntegrador, managerCplus);
        removeProdutosInexistentes(listProdCole, managerIntegrador);
    }

    private void removeProdutosInexistentes(List<EntidadeColecao> listProdAldo, EntityManagerFactory managerIntegrador) {
        // ManipulaFornecedores utilitario = new ManipulaFornecedores();
        List<ProdFornecedor> listAllIntegrador = new QueryIntegrador().listaProdFornecedor("COLECAO");
        for (ProdFornecedor proIntegrador : listAllIntegrador) {
            boolean remover = true;
            for (EntidadeColecao produtoColecao : listProdAldo) {
               // if (proIntegrador.getCodigoFornecedor() == null ? produtoColecao.getReferencia() == null : proIntegrador.getCodigoFornecedor().equals(produtoColecao.getReferencia())) {
                  if (proIntegrador.getEan().equals(produtoColecao.getEan())) {
                    remover = false;
                }
            }
            if (remover) {
                if (proIntegrador.getDisponivel() == 1) {
                    proIntegrador.setDisponivel(0);
                    try {
                        new ProdFornecedorJpaController(managerIntegrador).edit(proIntegrador);
                        criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Não existe mais na lista Coleção: " + proIntegrador.getDescricao(), "Informar");
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + proIntegrador.getDescricao() + "  " + ex, "Erro Excluir");
                    }
                }
            }
        }
    }

    private void atualizaBanco(List<EntidadeColecao> listProdCole, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        //ManipulaFornecedores utilitario = new ManipulaFornecedores();
        for (EntidadeColecao proCol : listProdCole) {
           // List<ProdFornecedor> listProdAll = new QueryIntegrador(managerIntegrador).resultCodigoFornecedor(proCol.getReferencia(), "COLECAO");
            List<ProdFornecedor> listProdAll = new QueryIntegrador().resultCodigoFornecedor(proCol.getEan(), "COLECAO");
            if (listProdAll.isEmpty()) {
                criarProdutoColecao(proCol, managerIntegrador, managerCplus);
            } else {
                for (ProdFornecedor proFornecedor : listProdAll) {
                    proFornecedor.setCodigoFornecedor(proCol.getReferencia());
                    proFornecedor.setNomeFornecedor("COLECAO");
                    proFornecedor.setEan(proCol.getEan());
                    proFornecedor.setDescricao(proCol.getDescricao());
                    int quantidade = Integer.valueOf(proCol.getQuantidade());
                    if (quantidade > 1) {
                        proFornecedor.setDisponivel(1);
                        proFornecedor.setPorcentagemStRs(BigDecimal.ONE);
                        proFornecedor.setPrecoCusto(new BigDecimal(proCol.getPrecoComIPI()));
                        proFornecedor.setPrecoCustoComSt(new BigDecimal(proCol.getPrecoComIPI()));
                        // prodForn.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(prodForn.getPrecoCusto(), prodForn, managerCplus));
                        //proFornecedor.setValorStRs(new BigDecimal(proCol.getStRs()));
                        proFornecedor.setValorStRs(new BigDecimal(proCol.getPrecoComIPI()));
                        proFornecedor.setValorCustoRs(new BigDecimal(proCol.getPrecoComIPI()));
                    } else {
                        proFornecedor.setDisponivel(0);
                    }
                    proFornecedor.setEstoque("ES");
                    proFornecedor.setUltimaImportacao(new Date(System.currentTimeMillis()));
                    try {
                        new ProdFornecedorJpaController(managerIntegrador).edit(proFornecedor);
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro ao editar tabela produtoFornecedor " + proCol.getDescricao() + "  " + ex, "Erro Editar");
                    }
                }//for da tabela produtosAllnations
            }//fim else que verifica se tem resultado pelo codigo
        }//for lista de importacao da planilha
    }

    private void criarProdutoColecao(EntidadeColecao proCol, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        // utilitario = new ManipulaFornecedores();
       // List<Produto> listProdIntegracao = new QueryCplus(managerCplus).listProdutoEan(proCol.getEan().trim());
         List<Produto> listProdIntegracao = new QueryCplus().listProdutoCodigoPrincipal(proCol.getEan().trim());
        for (Produto produto : listProdIntegracao) {
            boolean condicaoSalvar = true;
            ProdFornecedor prodForn = new ProdFornecedor();
            //proAllIntegrador.setIdProduto(produto);
            prodForn.setAtivo(0);
            prodForn.setReferenceCplus(produto.getCodprod());
            prodForn.setNomeFornecedor("COLECAO");
            prodForn.setDescricao(proCol.getDescricao());
            int quantidade = Integer.valueOf(proCol.getQuantidade());
            prodForn.setCodigoFornecedor(proCol.getReferencia());
            if (quantidade > 1) {
                prodForn.setDisponivel(1);
                // prodForn.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(prodForn, managerCplus));
                // prodForn.setPrecoCusto(utilitario.ajustaPrecoString(proCol.getPrecoComIPI()));
                // prodForn.setPrecoCustoComSt(utilitario.precoSemStParaComSt(prodForn.getPorcentagemStRs(), prodForn.getPrecoCusto()));
                // prodForn.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(prodForn.getPrecoCusto(), prodForn, managerCplus));
                // prodForn.setValorStRs(prodForn.getPrecoCustoComSt().subtract(prodForn.getPrecoCusto()));
                // prodForn.setValorCustoRs(utilitario.precoCustoRs(prodForn));

                prodForn.setPorcentagemStRs(BigDecimal.ONE);
                prodForn.setPrecoCusto(new BigDecimal(proCol.getPrecoComIPI()));
               prodForn.setPrecoCustoComSt(new BigDecimal(proCol.getPrecoComIPI()));
               
                // prodForn.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(prodForn.getPrecoCusto(), prodForn, managerCplus));
                prodForn.setValorStRs(new BigDecimal(proCol.getPrecoComIPI()));
                prodForn.setValorCustoRs(new BigDecimal(proCol.getPrecoComIPI()));

            } else {
                condicaoSalvar = false;
                prodForn.setDisponivel(0);
            }
            prodForn.setEan(proCol.getEan().trim());
            prodForn.setEstoque("ES");
            prodForn.setFabricante(produto.getCodfabricante().getNomefabricante());
            prodForn.setNcm(proCol.getNcm());
            //proAllIntegrador.setOrigemProduto(produto.getOrigemProduto());
            prodForn.setPartNumber(proCol.getModelo_comercial());
            prodForn.setUltimaImportacao(new Date(System.currentTimeMillis()));
            if (condicaoSalvar) {
                try {
                    new ProdFornecedorJpaController(managerIntegrador).create(prodForn);
                    // System.out.println("Produto adicionado com sucesso: " + proCol.getDescricao());
                } catch (Exception ex) {
                    criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ",Erro ao criar ProdutosAllnationsIntegrador " + proCol.getDescricao() + "  " + ex, "Erro Criação");
                }
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
