/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acesso;

import entidade.cplus.Sistemaacesso;
import entidade.cplus.Usuario;
import entidade.cplus.Usuarioacesso;
import query.cplus.QueryCplus;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import prestashop.Manager;

/**
 *
 * @author leonardo
 */
public class ControleAcesso implements Serializable{
     public ControleAcesso () {
        this.managerCplus = Manager.getManagerCplus();
    }
    private EntityManagerFactory managerCplus = null;

    public EntityManager getEntityManager() {
        return managerCplus.createEntityManager();
    }
    /**
     * Função vai retornar True se Usuario tiver acesso
     * @param usuario
     * @param descricaoAcesso
     * @return 
     */
    public boolean verificaAcessoUsuario(Usuario usuario, String descricaoAcesso){
        QueryCplus queryCplus = new QueryCplus(); 
        boolean condicao = true;
        List<Sistemaacesso> listSistemaAcesso = queryCplus.listagemSistemaAcesso(descricaoAcesso);
        for(Sistemaacesso acess : listSistemaAcesso){
            List<Usuarioacesso> listUsuarioAcesso = queryCplus.listagemUsuarioAcesso(usuario.getCoduser(), acess.getCodsistemaacesso());
            for(Usuarioacesso usrAcess: listUsuarioAcesso){
                if(!"H".equals(usrAcess.getFlagacesso().toString())){
                    condicao = false;
                }
            }
        }
        return condicao;
    }
}
