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
     * Função responsavel por atualizar a data na execusão das tarefas
     * @param execucao
     * @param data
     */
    public void atualizaExecucaoIntegradorData(IntExecucao execucao, Date data) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setUltimaExecucao(data);
        try {
            new IntExecucaoJpaController(Manager.getManagerIntegrador()).edit(execucao);
            criaLog( " Atualização de "+execucao.getIdExecucao()+" Executado com sucesso!!!  ", "EDITAR");
        } catch (Exception ex) {
            criaLog( "Erro ao Atualizar a execução " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }
    /**
     * Função responsavel por atualizar a condição em que se encontra 
     * ou se ja esta sendo executado por outra operação
     * @param execucao
     * @param condicaoExecucao se for 0 false, se for 1 true
     */
    public void atualizaExecucaoIntegradorCondicao(IntExecucao execucao, int condicaoExecucao) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setCondicao(condicaoExecucao);
        try {
            new IntExecucaoJpaController(Manager.getManagerIntegrador()).edit(execucao);
        } catch (Exception ex) {
            criaLog("Erro ao Atualizar a execução " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }

    /**
     * FunÃ§Ã£o para gravar Logs no banco do integrador
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
