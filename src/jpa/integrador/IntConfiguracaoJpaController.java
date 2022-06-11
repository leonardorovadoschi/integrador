/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.integrador;

import entidade.integrador.IntConfiguracao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class IntConfiguracaoJpaController implements Serializable {

    public IntConfiguracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
   /**  public String valor(String tipoConfiguracao) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM IntConfiguracao p WHERE p.tipo =:tipoConfiguracao");       
        query.setParameter("tipoConfiguracao", "tipoConfiguracao");//primeiro parametro
        List<IntConfiguracao> listIC = query.getResultList();
        String text = "";
        for(IntConfiguracao ic : listIC){
            text = ic.getValor();
        }       
        return text;
    }
     
     public List<IntConfiguracao> listagemConfiguracaoproTipoConfiguracao(String tipoConfiguracao){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM IntConfiguracao c WHERE c.tipo =:tipoConfiguracao");
        query.setParameter("tipoConfiguracao", tipoConfiguracao);//primeiro parametro 
        return query.getResultList();
    }
     
     public List<IntConfiguracao> listagemConfiguracaoPorValor(String valorConfiguracao){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM IntConfiguracao c WHERE c.valor =:valorConfiguracao");
        query.setParameter("valorConfiguracao", valorConfiguracao);
        return query.getResultList();
    }
     * @param intConfiguracao
*/
    public void create(IntConfiguracao intConfiguracao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intConfiguracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IntConfiguracao intConfiguracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            intConfiguracao = em.merge(intConfiguracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = intConfiguracao.getEntityId();
                if (findIntConfiguracao(id) == null) {
                    throw new NonexistentEntityException("The intConfiguracao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IntConfiguracao intConfiguracao;
            try {
                intConfiguracao = em.getReference(IntConfiguracao.class, id);
                intConfiguracao.getEntityId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intConfiguracao with id " + id + " no longer exists.", enfe);
            }
            em.remove(intConfiguracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntConfiguracao> findIntConfiguracaoEntities() {
        return findIntConfiguracaoEntities(true, -1, -1);
    }

    public List<IntConfiguracao> findIntConfiguracaoEntities(int maxResults, int firstResult) {
        return findIntConfiguracaoEntities(false, maxResults, firstResult);
    }

    private List<IntConfiguracao> findIntConfiguracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntConfiguracao.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public IntConfiguracao findIntConfiguracao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntConfiguracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntConfiguracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntConfiguracao> rt = cq.from(IntConfiguracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
