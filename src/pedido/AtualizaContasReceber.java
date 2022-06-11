/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.cplus.Contareceber;
import entidade.integrador.IntLogs;
//import entidade.magento.SalesFlatInvoice;
//import entidade.magento.SalesFlatInvoiceComment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;


/**
 *
 * @author leo
 */
public class AtualizaContasReceber {
    
     public void atualizaContasReceber(EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, Contareceber contaCplus) {                                       
                    if (contaCplus.getCodcr() != null && "N".equals(contaCplus.getFlagcancelada().toString())) {
                       // List<SalesFlatInvoice> listOrder = new SalesFlatInvoiceJpaController(managerDigimacro).resulPorIncremtId(contaCplus.getCodcr());                      
                         //   for (SalesFlatInvoice invoice : listOrder) {
                           //     criarSalesFlatInvoiceComment(managerIntegracao, managerDigimacro, invoice, contaCplus);
                           // }                        
                    }                              
    }
    
     
     
     private void criaLog(Date dataExecucao, String mensagem, String tipoLog, EntityManagerFactory managerIntegrador){      
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
  
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegrador).create(log);
    }
}
