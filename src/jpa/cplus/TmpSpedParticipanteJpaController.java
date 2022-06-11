/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedParticipante;
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
public class TmpSpedParticipanteJpaController implements Serializable {

    public TmpSpedParticipanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedParticipante tmpSpedParticipante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedParticipante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedParticipante(tmpSpedParticipante.getCodtmpSpedParticipante()) != null) {
                throw new PreexistingEntityException("TmpSpedParticipante " + tmpSpedParticipante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedParticipante tmpSpedParticipante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedParticipante = em.merge(tmpSpedParticipante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedParticipante.getCodtmpSpedParticipante();
                if (findTmpSpedParticipante(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedParticipante with id " + id + " no longer exists.");
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
            TmpSpedParticipante tmpSpedParticipante;
            try {
                tmpSpedParticipante = em.getReference(TmpSpedParticipante.class, id);
                tmpSpedParticipante.getCodtmpSpedParticipante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedParticipante with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedParticipante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedParticipante> findTmpSpedParticipanteEntities() {
        return findTmpSpedParticipanteEntities(true, -1, -1);
    }

    public List<TmpSpedParticipante> findTmpSpedParticipanteEntities(int maxResults, int firstResult) {
        return findTmpSpedParticipanteEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedParticipante> findTmpSpedParticipanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedParticipante.class));
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

    public TmpSpedParticipante findTmpSpedParticipante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedParticipante.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedParticipanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedParticipante> rt = cq.from(TmpSpedParticipante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
