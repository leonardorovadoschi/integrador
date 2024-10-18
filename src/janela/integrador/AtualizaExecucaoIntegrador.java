/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.integrador;


import entidade.integrador.IntExecucao;
import entidade.integrador.IntLogs;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntExecucaoJpaController;
import jpa.integrador.IntLogsJpaController;
import prestashop.Manager;


/**
 *
 * @author leonardo
 */
public class AtualizaExecucaoIntegrador {

    /**
     * Fun��o responsavel por atualizar a data na execus�o das tarefas
     * @param execucao
     * @param data
     */
    public void atualizaExecucaoIntegradorData(IntExecucao execucao, Date data) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setUltimaExecucao(data);
        try {
            new IntExecucaoJpaController(Manager.getManagerIntegrador()).edit(execucao);
            criaLog( " Atualiza��o de "+execucao.getIdExecucao()+" Executado com sucesso!!!  ", "EDITAR");
        } catch (Exception ex) {
            criaLog( "Erro ao Atualizar a execu��o " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }
    /**
     * Fun��o responsavel por atualizar a condi��o em que se encontra 
     * ou se ja esta sendo executado por outra opera��o
     * @param execucao
     * @param condicaoExecucao se for 0 false, se for 1 true
     */
    public void atualizaExecucaoIntegradorCondicao(IntExecucao execucao, int condicaoExecucao) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setCondicao(condicaoExecucao);
        try {
            new IntExecucaoJpaController(Manager.getManagerIntegrador()).edit(execucao);
        } catch (Exception ex) {
            criaLog("Erro ao Atualizar a execu��o " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }

    /**
     * Função para gravar Logs no banco do integrador
     * @param managerIntegracao
     * @param mensagem
     * @param tipoLog 
     */
    private void criaLog(String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(Manager.getManagerIntegrador()).create(log);
    }
}
