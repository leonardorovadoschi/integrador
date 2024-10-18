/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;


import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import query.integrador.QueryIntegrador;

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


/**
 *
 * @author leo
 */
public class IntegracaoNhs {
    
    public void integradorNhs(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro){
    
        try {
            lerArquivoNhsTxt(managerIntegrador, managerCplus, managerDigimacro);
        } catch (IOException | ParseException ex) {
            criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro Atualiza Banco na importa��o da Nhs "  + "  " + ex, "Erro Edi��o");
        }       
    }
    
    private void lerArquivoNhsTxt(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) throws FileNotFoundException, IOException, ParseException {
        List<EntidadeNhs> listScannerNhs = new ArrayList<EntidadeNhs>();     
        Scanner scanner = new Scanner(new FileReader(new QueryIntegrador().valorConfiguracao("caminho_ARQUIVO_TXT_NHS"))).useDelimiter("\\t|\\n");
        while (scanner.hasNext()) {
            EntidadeNhs proNhs = new EntidadeNhs();
            proNhs.setEan(scanner.next());
            proNhs.setPartNumber(scanner.next());
            proNhs.setDescricao(scanner.next());
            proNhs.setValorComSt(scanner.next());
            
            if(!"R$ 0,00".equals(proNhs.getValorComSt())){
            listScannerNhs.add(proNhs);
            }
        }
        atualizaBanco(listScannerNhs, managerIntegrador, managerCplus, managerDigimacro);
        //removeProdutosInexistentes(listScannerNhs, managerIntegrador, managerDigimacro, managerLegiao);
    }
    
    private void atualizaBanco(List<EntidadeNhs> listProdNhs, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        ManipulaFornecedores utilitario = new ManipulaFornecedores();
        for (EntidadeNhs prodNhs : listProdNhs) {
            List<ProdFornecedor> listProdAll = new QueryIntegrador().resultEanEEstoque(prodNhs.getEan(), "PR", "NHS");
            if (listProdAll.isEmpty()) {
  //              criarProdutoAldo(prodNhs, managerIntegrador, managerCplus);
            } else {
                for (ProdFornecedor proAllIntegrador : listProdAll) {
                    boolean condicaoGravar = true;
                    proAllIntegrador.setCodigoFornecedor("00000");
                    proAllIntegrador.setNomeFornecedor("NHS");
                    proAllIntegrador.setDescricao(prodNhs.getDescricao());
                   // if ("sim".equals(prodNhs.getDisponivel())) {
                        proAllIntegrador.setDisponivel(1);
                        
                            //System.out.println("Nome produto: "+ prodAldo.getProdutoDescricao()+ "pre�o: "+ prodAldo.getPreco());
                            proAllIntegrador.setEstoque("PR");
                            proAllIntegrador.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proAllIntegrador, managerCplus));
                            proAllIntegrador.setPrecoCustoComSt(utilitario.ajustaPrecoString(prodNhs.getValorComSt()));
                            proAllIntegrador.setPrecoCusto(utilitario.precoComStParaSemSt(proAllIntegrador.getPorcentagemStRs(), proAllIntegrador.getPrecoCustoComSt()));
                            proAllIntegrador.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(proAllIntegrador.getPrecoCusto(), proAllIntegrador, managerCplus));
                            proAllIntegrador.setValorStRs(proAllIntegrador.getPrecoCustoComSt().subtract(proAllIntegrador.getPrecoCusto()));
                            proAllIntegrador.setValorCustoRs(utilitario.precoCustoRs(proAllIntegrador));
                            proAllIntegrador.setSubcategoria(utilitario.previsaoEntrega("PR"));
                       
                   // } else {
                     //   proAllIntegrador.setDisponivel(0);
                     //   condicaoGravar = false;
                   // }
                    //proAllIntegrador.setNcm(prodNhs.getNcm());
                    proAllIntegrador.setUltimaImportacao(new Date(System.currentTimeMillis()));
                    if (condicaoGravar) {
                        try {
                            new ProdFornecedorJpaController(managerIntegrador).edit(proAllIntegrador);
                            if (Integer.valueOf(proAllIntegrador.getEstoque()) < 1) {
                                if (proAllIntegrador.getAtivo() == 1) {
                                //   new ProdutoFornecedorDigimacro().atualizaEstoqueMagento(true, proAllIntegrador.getIdProduto(), managerDigimacro, managerIntegrador);
                                   // System.out.println("Produto Atualizado no site Digimacro: " + proAllIntegrador.getDescricao());
                                    //new ProdutoFornecedorLegiao().atualizaEstoqueMagento(proAllIntegrador.getIdProduto(), managerIntegrador);
                                    //System.out.println("Produto Atualizado no site Legiao: " + proAllIntegrador.getDescricao());
                                }else{
                                    criaLog(managerIntegrador, new Date(System.currentTimeMillis()), "Produto N�o ativado NHS: " + prodNhs.getDescricao() , "Informa��o");
                                     //System.out.println("Produto N�o ativado: " + prodAldo.getProdutoDescricao());
                                }
                            }
                        } catch (Exception ex) {
                            criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Atualiza Banco na importa��o da NHS " + prodNhs.getDescricao() + "  " + ex, "Erro Edi��o");
                        }
                    }
                }//for prodAll
            }//fim else da lista
        }//fim for
    }
    
    private void criaLog(EntityManagerFactory managerIntegracao, Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }
}
