/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Caixausuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Recebimento;
import entidade.cplus.Sistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CaixausuarioJpaController implements Serializable {

    public CaixausuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caixausuario caixausuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recebimento codrec = caixausuario.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                caixausuario.setCodrec(codrec);
            }
            Sistema codsistema = caixausuario.getCodsistema();
            if (codsistema != null) {
                codsistema = em.getReference(codsistema.getClass(), codsistema.getCodsistema());
                caixausuario.setCodsistema(codsistema);
            }
            em.persist(caixausuario);
            if (codrec != null) {
                codrec.getCaixausuarioCollection().add(caixausuario);
                codrec = em.merge(codrec);
            }
            if (codsistema != null) {
                codsistema.getCaixausuarioCollection().add(caixausuario);
                codsistema = em.merge(codsistema);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCaixausuario(caixausuario.getCodcaixausuario()) != null) {
                throw new PreexistingEntityException("Caixausuario " + caixausuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caixausuario caixausuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixausuario persistentCaixausuario = em.find(Caixausuario.class, caixausuario.getCodcaixausuario());
            Recebimento codrecOld = persistentCaixausuario.getCodrec();
            Recebimento codrecNew = caixausuario.getCodrec();
            Sistema codsistemaOld = persistentCaixausuario.getCodsistema();
            Sistema codsistemaNew = caixausuario.getCodsistema();
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                caixausuario.setCodrec(codrecNew);
            }
            if (codsistemaNew != null) {
                codsistemaNew = em.getReference(codsistemaNew.getClass(), codsistemaNew.getCodsistema());
                caixausuario.setCodsistema(codsistemaNew);
            }
            caixausuario = em.merge(caixausuario);
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getCaixausuarioCollection().remove(caixausuario);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getCaixausuarioCollection().add(caixausuario);
                codrecNew = em.merge(codrecNew);
            }
            if (codsistemaOld != null && !codsistemaOld.equals(codsistemaNew)) {
                codsistemaOld.getCaixausuarioCollection().remove(caixausuario);
                codsistemaOld = em.merge(codsistemaOld);
            }
            if (codsistemaNew != null && !codsistemaNew.equals(codsistemaOld)) {
                codsistemaNew.getCaixausuarioCollection().add(caixausuario);
                codsistemaNew = em.merge(codsistemaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = caixausuario.getCodcaixausuario();
                if (findCaixausuario(id) == null) {
                    throw new NonexistentEntityException("The caixausuario with id " + id + " no longer exists.");
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
            Caixausuario caixausuario;
            try {
                caixausuario = em.getReference(Caixausuario.class, id);
                caixausuario.getCodcaixausuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caixausuario with id " + id + " no longer exists.", enfe);
            }
            Recebimento codrec = caixausuario.getCodrec();
            if (codrec != null) {
                codrec.getCaixausuarioCollection().remove(caixausuario);
                codrec = em.merge(codrec);
            }
            Sistema codsistema = caixausuario.getCodsistema();
            if (codsistema != null) {
                codsistema.getCaixausuarioCollection().remove(caixausuario);
                codsistema = em.merge(codsistema);
            }
            em.remove(caixausuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caixausuario> findCaixausuarioEntities() {
        return findCaixausuarioEntities(true, -1, -1);
    }

    public List<Caixausuario> findCaixausuarioEntities(int maxResults, int firstResult) {
        return findCaixausuarioEntities(false, maxResults, firstResult);
    }

    private List<Caixausuario> findCaixausuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caixausuario.class));
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

    public Caixausuario findCaixausuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caixausuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getCaixausuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caixausuario> rt = cq.from(Caixausuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
