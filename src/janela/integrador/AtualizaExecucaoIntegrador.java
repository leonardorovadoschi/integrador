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


/**
 *
 * @author leonardo
 */
public class AtualizaExecucaoIntegrador {

    /**
     * Funï¿½ï¿½o responsavel por atualizar a data na execuï¿½ï¿½o das tarefas
     * @param execucao
     * @param data
     * @param managerIntegrador 
     */
    public void atualizaExecucaoIntegradorData(IntExecucao execucao, Date data, EntityManagerFactory managerIntegrador) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setUltimaExecucao(data);
        try {
            new IntExecucaoJpaController(managerIntegrador).edit(execucao);
            criaLog(managerIntegrador, " Atualização de "+execucao.getIdExecucao()+" Executado com sucesso!!!  ", "EDITAR");
        } catch (Exception ex) {
            criaLog(managerIntegrador, "Erro ao Atualizar a execução " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }
    /**
     * FunÃ§Ã£o responsavel por atualizar a condiÃ§Ã£o em que se encontra 
     * ou se jÃ¡ estÃ¡ sendo executado por outra operaÃ§Ã£o
     * @param execucao
     * @param condicaoExecucao se for 0 false, se for 1 true
     * @param managerIntegrador 
     */
    public void atualizaExecucaoIntegradorCondicao(IntExecucao execucao, int condicaoExecucao, EntityManagerFactory managerIntegrador) {
       // Execucao execucao = new ExecucaoJpaController(managerIntegrador).findExecucao(idExecucao);
        execucao.setCondicao(condicaoExecucao);
        try {
            new IntExecucaoJpaController(managerIntegrador).edit(execucao);
        } catch (Exception ex) {
            criaLog(managerIntegrador, "Erro ao Atualizar a execução " + execucao.getIdExecucao() + "  " + ex, "ERRO EDITAR");
        }
    }

    /**
     * FunÃ§Ã£o para gravar Logs no banco do integrador
     * @param managerIntegracao
     * @param mensagem
     * @param tipoLog 
     */
    private void criaLog(EntityManagerFactory managerIntegrador, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegrador).create(log);
    }
}
