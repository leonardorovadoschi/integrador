/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsTipoatendimento;
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
public class OsTipoatendimentoJpaController implements Serializable {

    public OsTipoatendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsTipoatendimento osTipoatendimento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(osTipoatendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsTipoatendimento(osTipoatendimento.getCodta()) != null) {
                throw new PreexistingEntityException("OsTipoatendimento " + osTipoatendimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsTipoatendimento osTipoatendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            osTipoatendimento = em.merge(osTipoatendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osTipoatendimento.getCodta();
                if (findOsTipoatendimento(id) == null) {
                    throw new NonexistentEntityException("The osTipoatendimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsTipoatendimento osTipoatendimento;
            try {
                osTipoatendimento = em.getReference(OsTipoatendimento.class, id);
                osTipoatendimento.getCodta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osTipoatendimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(osTipoatendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsTipoatendimento> findOsTipoatendimentoEntities() {
        return findOsTipoatendimentoEntities(true, -1, -1);
    }

    public List<OsTipoatendimento> findOsTipoatendimentoEntities(int maxResults, int firstResult) {
        return findOsTipoatendimentoEntities(false, maxResults, firstResult);
    }

    private List<OsTipoatendimento> findOsTipoatendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsTipoatendimento.class));
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

    public OsTipoatendimento findOsTipoatendimento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsTipoatendimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsTipoatendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsTipoatendimento> rt = cq.from(OsTipoatendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
