/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.fornecedores;


import entidade.cplus.Campocustomvalor;
import entidade.cplus.Produto;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import query.integrador.QueryIntegrador;

//import integrador.produto.ProdFornecedorLegiao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;
import query.cplus.QueryCplus;


/**
 *
 * @author leonardo
 */
public class IntegracaoAldo {
    
    
    public void integradorAldo(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro){
    
        try {
            lerArquivoAldoTxt(managerIntegrador, managerCplus, managerDigimacro);
        } catch (IOException | ParseException ex) {
            criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro Atualiza Banco na importação da Aldo "  + "  " + ex, "Erro Editar");
        }       
    }
    
    private void lerArquivoAldoTxt(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) throws FileNotFoundException, IOException, ParseException {
        List<EntidadeAldo> listProdAldo = new ArrayList<EntidadeAldo>();      
        Scanner scanner = new Scanner(new FileReader(new query.integrador.QueryIntegrador(managerIntegrador).valorConfiguracao("caminho_ARQUIVO_TXT_ALDO"))).useDelimiter("\\t|\\n");
        while (scanner.hasNext()) {
            EntidadeAldo proAldo = new EntidadeAldo();
            proAldo.setCodigo(scanner.next());
            proAldo.setDisponivel(scanner.next());
            proAldo.setMultiplo(scanner.next());
            proAldo.setUnidade(scanner.next());
            proAldo.setProdutoDescricao(scanner.next());
            proAldo.setFilial(scanner.next());
            proAldo.setPreco(scanner.next());
            proAldo.setNcm(scanner.next());
           // System.err.println(scanner.nextLine());
            if(!"R$ 0,00".equals(proAldo.getPreco())&& "PR".equals(proAldo.getFilial())){
            listProdAldo.add(proAldo);
            }else{
                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Produto sem Preço ou Problema na linha" + proAldo.getCodigo(), "Erro Editar");
            }
        }
        atualizaBanco(listProdAldo, managerIntegrador, managerCplus, managerDigimacro);
        removeProdutosInexistentes(listProdAldo, managerIntegrador, managerDigimacro);
    }
    
    private void removeProdutosInexistentes(List<EntidadeAldo> listProdAldo, EntityManagerFactory managerIntegrador, EntityManagerFactory managerDigimacro) {
        // ManipulaFornecedores utilitario = new ManipulaFornecedores();
        List<ProdFornecedor> listAllIntegrador = new QueryIntegrador(managerIntegrador).listaProdFornecedor("ALDO");
        for (ProdFornecedor proIntegrador : listAllIntegrador) {
            boolean remover = true;
            for (EntidadeAldo produtoAldo : listProdAldo) {
                String codigoAldo =  produtoAldo.getCodigo();
                if (produtoAldo.getCodigo() == null ? proIntegrador.getCodigoFornecedor()== null :codigoAldo.equals(proIntegrador.getCodigoFornecedor())) {
                    remover = false;
                }
            }
            if (remover) {
                if(proIntegrador.getDisponivel() == 1){
                proIntegrador.setDisponivel(0);
                try {
                    new ProdFornecedorJpaController(managerIntegrador).edit(proIntegrador);
                    if (Integer.valueOf(proIntegrador.getEstoque()) < 1) {
                        if (proIntegrador.getAtivo() == 1) {
                           // new ProdutoFornecedorDigimacro().atualizaEstoqueMagento(true, proIntegrador.getIdProduto(), managerDigimacro, managerIntegrador);
                           // System.out.println("Produto Atualizado no site Digimacro: " + proIntegrador.getDescricao());
                           // new ProdutoFornecedorLegiao().atualizaEstoqueMagento(proIntegrador.getIdProduto(), managerLegiao, managerIntegrador);
                           // System.out.println("Produto Atualizado no site Legiao: " + proIntegrador.getDescricao());
                        }
                    }
                   // System.out.println("Nï¿½o existe mais na lista: " + proIntegrador.getDescricao());
                    criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Nï¿½o existe mais na lista Aldo: " + proIntegrador.getDescricao() , "Informaï¿½ï¿½o");
                } catch (Exception ex) {
                    criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Atualiza Banco na importaï¿½ï¿½o da aldo " + proIntegrador.getDescricao() + "  " + ex, "Erro Ediï¿½ï¿½o");
                }
                }
            }
        }
    }
    
    private void atualizaBanco(List<EntidadeAldo> listProdAldo, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        ManipulaFornecedores utilitario = new ManipulaFornecedores();
        for (EntidadeAldo prodAldo : listProdAldo) {
            List<ProdFornecedor> listProdAll = new QueryIntegrador(managerIntegrador).listProdFornecedor(prodAldo.getCodigo(), "ALDO");
            if (listProdAll.isEmpty()) {
               criarProdutoAldo(prodAldo, managerIntegrador, managerCplus);
            } else {
                for (ProdFornecedor proAllIntegrador : listProdAll) {
                    boolean condicaoGravar = true;
                    proAllIntegrador.setCodigoFornecedor(prodAldo.getCodigo());
                    proAllIntegrador.setNomeFornecedor("ALDO");
                    proAllIntegrador.setDescricao(prodAldo.getProdutoDescricao());
                    if ("sim".equals(prodAldo.getDisponivel())) {
                        proAllIntegrador.setDisponivel(1);
                        
                            //System.out.println("Nome produto: "+ prodAldo.getProdutoDescricao()+ "preï¿½o: "+ prodAldo.getPreco());
                            proAllIntegrador.setEstoque(prodAldo.getFilial());
                            proAllIntegrador.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proAllIntegrador, managerCplus));
                            proAllIntegrador.setPrecoCustoComSt(utilitario.ajustaPrecoString(prodAldo.getPreco()));
                            proAllIntegrador.setPrecoCusto(utilitario.precoComStParaSemSt(proAllIntegrador.getPorcentagemStRs(), proAllIntegrador.getPrecoCustoComSt()));
                            proAllIntegrador.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(proAllIntegrador.getPrecoCusto(), proAllIntegrador, managerCplus));
                            proAllIntegrador.setValorStRs(proAllIntegrador.getPrecoCustoComSt().subtract(proAllIntegrador.getPrecoCusto()));
                            proAllIntegrador.setValorCustoRs(utilitario.precoCustoRs(proAllIntegrador));
                            proAllIntegrador.setSubcategoria(utilitario.previsaoEntrega(prodAldo.getFilial()));
                       
                    } else {
                        proAllIntegrador.setDisponivel(0);
                        condicaoGravar = false;
                    }
                    proAllIntegrador.setNcm(prodAldo.getNcm());
                    proAllIntegrador.setUltimaImportacao(new Date(System.currentTimeMillis()));
                    if (condicaoGravar) {
                        try {
                            new ProdFornecedorJpaController(managerIntegrador).edit(proAllIntegrador);
                            if (Integer.valueOf(proAllIntegrador.getEstoque()) < 1) {
                                if (proAllIntegrador.getAtivo() == 1) {
                                  //  new ProdutoFornecedorDigimacro().atualizaEstoqueMagento(true, prodForn.getIdProduto(), managerDigimacro, managerIntegrador);
                                   // System.out.println("Produto Atualizado no site Digimacro: " + prodForn.getDescricao());
                                   // new ProdutoFornecedorLegiao().atualizaEstoqueMagento(prodForn.getIdProduto(), managerLegiao, managerIntegrador);
                                    //System.out.println("Produto Atualizado no site Legiao: " + prodForn.getDescricao());
                                }else{
                                    criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Produto Não ativado Aldo: " + prodAldo.getProdutoDescricao() , "Informar");
                                     //System.out.println("Produto Nï¿½o ativado: " + prodAldo.getProdutoDescricao());
                                }
                            }
                        } catch (Exception ex) {
                            criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Atualiza Banco na importação da aldo " + prodAldo.getProdutoDescricao() + "  " + ex, "Erro Editar");
                        }
                    }
                }//for prodAll
            }//fim else da lista
        }//fim for
    }
    
     private String partNumber(String valor, EntityManagerFactory managerCplus) {
        //part Number 000000004
        //complemento Fiscal 000000003
        String codCampoCustomMaster = "000000004";
        String retorno = "";
        for (Campocustomvalor campo : new QueryCplus(managerCplus).listCampoMasterValor(valor, codCampoCustomMaster)) {
            if (campo.getValor() != null) {
                retorno = campo.getIdentidadeorigem();
            }
        }
        return retorno;
    }
    
    private void criarProdutoAldo(EntidadeAldo prodAldo, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        ManipulaFornecedores utilitario = new ManipulaFornecedores();
        String[] listaDePalavras = prodAldo.getProdutoDescricao().split(" ");
        for (int cont = 0; listaDePalavras.length > cont; cont++) {
            if (!"".equals(listaDePalavras[cont])) {
                String partNu = partNumber(listaDePalavras[cont], managerCplus);
                if(!"".equals(partNu)){
                List<Produto> listProdIntegracao = new QueryCplus(managerCplus).listProduto(partNu);
                if (listProdIntegracao.size() == 1) {
                    for (Produto prodCplus : listProdIntegracao) {
                        boolean condicaoGravar = true;
                        ProdFornecedor prodForn = new ProdFornecedor();
                        prodForn.setReferenceCplus(prodCplus.getCodprod());
                        prodForn.setAtivo(0);
                        prodForn.setCodigoFornecedor(prodAldo.getCodigo());
                        prodForn.setNomeFornecedor("ALDO");
                        prodForn.setDescricao(prodAldo.getProdutoDescricao());
                        if ("sim".equals(prodAldo.getDisponivel())) {
                            prodForn.setDisponivel(1);                            
                                prodForn.setEstoque(prodAldo.getFilial());
                                prodForn.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(prodForn, managerCplus));
                                prodForn.setPrecoCustoComSt(utilitario.ajustaPrecoString(prodAldo.getPreco()));
                                prodForn.setPrecoCusto(utilitario.precoComStParaSemSt(prodForn.getPorcentagemStRs(), prodForn.getPrecoCustoComSt()));
                                prodForn.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(prodForn.getPrecoCusto(), prodForn, managerCplus));
                                prodForn.setValorStRs(prodForn.getPrecoCustoComSt().subtract(prodForn.getPrecoCusto()));
                                prodForn.setValorCustoRs(utilitario.precoCustoRs(prodForn));
                                prodForn.setSubcategoria(utilitario.previsaoEntrega(prodAldo.getFilial()));
                            
                        } else {
                            prodForn.setDisponivel(0);
                            condicaoGravar = false;
                        }
                        prodForn.setEan(prodCplus.getCodigo());
                        prodForn.setFabricante(prodCplus.getCodfabricante().getNomefabricante());
                        prodForn.setNcm(prodAldo.getNcm());
                        //prodForn.setOrigemProduto(prodCplus.geto);
                        prodForn.setPartNumber(listaDePalavras[cont]);
                        prodForn.setUltimaImportacao(new Date(System.currentTimeMillis()));
                        if (condicaoGravar) {
                            try {
                                new ProdFornecedorJpaController(managerIntegrador).create(prodForn);
                                //System.out.println("Produto adicionado com sucesso: " + prodAldo.getProdutoDescricao());
                                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Produto adicionado com sucesso Aldo: " + prodAldo.getProdutoDescricao() , "Informação");
                            } catch (Exception ex) {
                                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + prodAldo.getProdutoDescricao() + "  " + ex, "Erro Criação");
                            }
                        }
                    }
                }//fim if que verifica se ha um item no banco
            }
            }//fi que verifica se a palavra é nulla
        }//for da lista de palavras da descricao aldo
    }
   
    private void criaLog(EntityManagerFactory managerIntegracao, Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }
}
