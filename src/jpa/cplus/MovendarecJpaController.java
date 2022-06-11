/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movenda;
import entidade.cplus.Movendarec;
import entidade.cplus.Recebimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendarecJpaController implements Serializable {

    public MovendarecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendarec movendarec) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = movendarec.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                movendarec.setCodmovenda(codmovenda);
            }
            Recebimento codrec = movendarec.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                movendarec.setCodrec(codrec);
            }
            em.persist(movendarec);
            if (codmovenda != null) {
                codmovenda.getMovendarecCollection().add(movendarec);
                codmovenda = em.merge(codmovenda);
            }
            if (codrec != null) {
                codrec.getMovendarecCollection().add(movendarec);
                codrec = em.merge(codrec);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendarec(movendarec.getId()) != null) {
                throw new PreexistingEntityException("Movendarec " + movendarec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendarec movendarec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendarec persistentMovendarec = em.find(Movendarec.class, movendarec.getId());
            Movenda codmovendaOld = persistentMovendarec.getCodmovenda();
            Movenda codmovendaNew = movendarec.getCodmovenda();
            Recebimento codrecOld = persistentMovendarec.getCodrec();
            Recebimento codrecNew = movendarec.getCodrec();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                movendarec.setCodmovenda(codmovendaNew);
            }
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                movendarec.setCodrec(codrecNew);
            }
            movendarec = em.merge(movendarec);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMovendarecCollection().remove(movendarec);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMovendarecCollection().add(movendarec);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getMovendarecCollection().remove(movendarec);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getMovendarecCollection().add(movendarec);
                codrecNew = em.merge(codrecNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendarec.getId();
                if (findMovendarec(id) == null) {
                    throw new NonexistentEntityException("The movendarec with id " + id + " no longer exists.");
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
            Movendarec movendarec;
            try {
                movendarec = em.getReference(Movendarec.class, id);
                movendarec.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendarec with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = movendarec.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMovendarecCollection().remove(movendarec);
                codmovenda = em.merge(codmovenda);
            }
            Recebimento codrec = movendarec.getCodrec();
            if (codrec != null) {
                codrec.getMovendarecCollection().remove(movendarec);
                codrec = em.merge(codrec);
            }
            em.remove(movendarec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendarec> findMovendarecEntities() {
        return findMovendarecEntities(true, -1, -1);
    }

    public List<Movendarec> findMovendarecEntities(int maxResults, int firstResult) {
        return findMovendarecEntities(false, maxResults, firstResult);
    }

    private List<Movendarec> findMovendarecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendarec.class));
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

    public Movendarec findMovendarec(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendarec.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendarecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendarec> rt = cq.from(Movendarec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
