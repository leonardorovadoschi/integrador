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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;


/**
 *
 * @author leonardo
 */
public class IntegracaoAgis {
    
    public void integracaoAgis(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        try {
            lerArquivoAgisTxt(managerIntegrador, managerCplus, managerDigimacro);
        } catch (FileNotFoundException ex) {
            criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro Atualiza Banco na importa��o da Agis " + "  " + ex, "Erro Edi��o");
        }
    }
    
    private void criaLog(EntityManagerFactory managerIntegracao, Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
       // log.setDataExecao(new Date(System.currentTimeMillis()));
        log.setDataExecucao(dataExecucao);
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }

    private void lerArquivoAgisTxt(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) throws FileNotFoundException {
        List<EntidadeAgis> listProd = new ArrayList<>();
        
        Scanner scanner = new Scanner(new FileReader(new QueryIntegrador(managerIntegrador).valorConfiguracao("caminho_ARQUIVO_TXT_AGIS"))).useDelimiter("\\t|\\n");
        while (scanner.hasNext()) {
            EntidadeAgis proAllnations = new EntidadeAgis();         
            proAllnations.setPartNumber(scanner.next().trim());
            proAllnations.setDescricao(scanner.next());          
            proAllnations.setPrecoSP(scanner.next());
            proAllnations.setPrecoES(scanner.next());
            proAllnations.setPrecoRJ(scanner.next().replaceAll("\\/r", "").trim());                     
            listProd.add(proAllnations);          
        }
        atualizaProdutosAgis(listProd, managerIntegrador, managerCplus, managerDigimacro);
        //removeProdutosInexistentes(listProd, managerIntegrador, managerDigimacro);
    }

    private void atualizaProdutosAgis(List<EntidadeAgis> listProd, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        List<ProdFornecedor> listProdIntegrador;
        for (EntidadeAgis prodList : listProd) {
            if (!"".equals(prodList.getPrecoSP())) {
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "SP");
                if (listProdIntegrador.isEmpty()) {
                   // criarProdutosAllnationsIntegrador("SP", prodList.getPrecoSP(), prodList, managerIntegrador, managerCplus);
                } else if (listProdIntegrador.size() == 1) {
                    for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
                     //   editaProdutosAllnationsIntegrador(1, "SP", prodList.getPrecoSP(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
                    }
                }
            }else{//fim if que verifica estado de ES
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "SP");
                for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
               // editaProdutosAllnationsIntegrador(0, "SP", prodList.getPrecoES(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
            }
            }
            
            if (!"".equals(prodList.getPrecoRJ())) {
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "RJ");
                if (listProdIntegrador.isEmpty()) {
              //      criarProdutosAllnationsIntegrador("RJ", prodList.getPrecoRJ(), prodList, managerIntegrador, managerCplus);
                } else if (listProdIntegrador.size() == 1) {
                    for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
                //        editaProdutosAllnationsIntegrador(1, "RJ", prodList.getPrecoRJ(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
                    }
                }
            }else{//fim if que verifica estado de ES
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "RJ");
                for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
             //   editaProdutosAllnationsIntegrador(0, "RJ", prodList.getPrecoES(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
            }
            }
            
            if (!"".equals(prodList.getPrecoES())) {
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "ES");
                if (listProdIntegrador.isEmpty()) {
                 //   criarProdutosAllnationsIntegrador("ES", prodList.getPrecoES(), prodList, managerIntegrador, managerCplus);
                } else if (listProdIntegrador.size() == 1) {
                    for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
                   //     editaProdutosAllnationsIntegrador(1, "ES", prodList.getPrecoES(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
                    }
                }
            }else{//fim if que verifica estado de ES
                listProdIntegrador = new QueryIntegrador(managerIntegrador).resultPartNumberSnd(prodList.getPartNumber(), "AGIS", "ES");
                for (ProdFornecedor proAllIntegrador : listProdIntegrador) {
              //  editaProdutosAllnationsIntegrador(0, "ES", prodList.getPrecoES(), proAllIntegrador, prodList, managerIntegrador, managerCplus, managerDigimacro);
            }
            }
        }
    }
}


   

