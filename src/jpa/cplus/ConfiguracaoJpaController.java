/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Configuracao;
import entidade.cplus.ConfiguracaoPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConfiguracaoJpaController implements Serializable {

    public ConfiguracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Configuracao configuracao) throws PreexistingEntityException, Exception {
        if (configuracao.getConfiguracaoPK() == null) {
            configuracao.setConfiguracaoPK(new ConfiguracaoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(configuracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConfiguracao(configuracao.getConfiguracaoPK()) != null) {
                throw new PreexistingEntityException("Configuracao " + configuracao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Configuracao configuracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            configuracao = em.merge(configuracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ConfiguracaoPK id = configuracao.getConfiguracaoPK();
                if (findConfiguracao(id) == null) {
                    throw new NonexistentEntityException("The configuracao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ConfiguracaoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Configuracao configuracao;
            try {
                configuracao = em.getReference(Configuracao.class, id);
                configuracao.getConfiguracaoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The configuracao with id " + id + " no longer exists.", enfe);
            }
            em.remove(configuracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Configuracao> findConfiguracaoEntities() {
        return findConfiguracaoEntities(true, -1, -1);
    }

    public List<Configuracao> findConfiguracaoEntities(int maxResults, int firstResult) {
        return findConfiguracaoEntities(false, maxResults, firstResult);
    }

    private List<Configuracao> findConfiguracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Configuracao.class));
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

    public Configuracao findConfiguracao(ConfiguracaoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Configuracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getConfiguracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Configuracao> rt = cq.from(Configuracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
