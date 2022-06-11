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
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicoevento;
import entidade.cplus.Mdfeletronicotipoevento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletronicoeventoJpaController implements Serializable {

    public MdfeletronicoeventoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicoevento mdfeletronicoevento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicoevento.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicoevento.setCodmdfeletronico(codmdfeletronico);
            }
            Mdfeletronicotipoevento codmdfeletronicotipoevento = mdfeletronicoevento.getCodmdfeletronicotipoevento();
            if (codmdfeletronicotipoevento != null) {
                codmdfeletronicotipoevento = em.getReference(codmdfeletronicotipoevento.getClass(), codmdfeletronicotipoevento.getCodmdfeletronicotipoevento());
                mdfeletronicoevento.setCodmdfeletronicotipoevento(codmdfeletronicotipoevento);
            }
            em.persist(mdfeletronicoevento);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoeventoCollection().add(mdfeletronicoevento);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            if (codmdfeletronicotipoevento != null) {
                codmdfeletronicotipoevento.getMdfeletronicoeventoCollection().add(mdfeletronicoevento);
                codmdfeletronicotipoevento = em.merge(codmdfeletronicotipoevento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicoevento(mdfeletronicoevento.getCodmdfeletronicoevento()) != null) {
                throw new PreexistingEntityException("Mdfeletronicoevento " + mdfeletronicoevento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicoevento mdfeletronicoevento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicoevento persistentMdfeletronicoevento = em.find(Mdfeletronicoevento.class, mdfeletronicoevento.getCodmdfeletronicoevento());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicoevento.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicoevento.getCodmdfeletronico();
            Mdfeletronicotipoevento codmdfeletronicotipoeventoOld = persistentMdfeletronicoevento.getCodmdfeletronicotipoevento();
            Mdfeletronicotipoevento codmdfeletronicotipoeventoNew = mdfeletronicoevento.getCodmdfeletronicotipoevento();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicoevento.setCodmdfeletronico(codmdfeletronicoNew);
            }
            if (codmdfeletronicotipoeventoNew != null) {
                codmdfeletronicotipoeventoNew = em.getReference(codmdfeletronicotipoeventoNew.getClass(), codmdfeletronicotipoeventoNew.getCodmdfeletronicotipoevento());
                mdfeletronicoevento.setCodmdfeletronicotipoevento(codmdfeletronicotipoeventoNew);
            }
            mdfeletronicoevento = em.merge(mdfeletronicoevento);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicoeventoCollection().remove(mdfeletronicoevento);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicoeventoCollection().add(mdfeletronicoevento);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            if (codmdfeletronicotipoeventoOld != null && !codmdfeletronicotipoeventoOld.equals(codmdfeletronicotipoeventoNew)) {
                codmdfeletronicotipoeventoOld.getMdfeletronicoeventoCollection().remove(mdfeletronicoevento);
                codmdfeletronicotipoeventoOld = em.merge(codmdfeletronicotipoeventoOld);
            }
            if (codmdfeletronicotipoeventoNew != null && !codmdfeletronicotipoeventoNew.equals(codmdfeletronicotipoeventoOld)) {
                codmdfeletronicotipoeventoNew.getMdfeletronicoeventoCollection().add(mdfeletronicoevento);
                codmdfeletronicotipoeventoNew = em.merge(codmdfeletronicotipoeventoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mdfeletronicoevento.getCodmdfeletronicoevento();
                if (findMdfeletronicoevento(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicoevento with id " + id + " no longer exists.");
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
            Mdfeletronicoevento mdfeletronicoevento;
            try {
                mdfeletronicoevento = em.getReference(Mdfeletronicoevento.class, id);
                mdfeletronicoevento.getCodmdfeletronicoevento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicoevento with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicoevento.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoeventoCollection().remove(mdfeletronicoevento);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Mdfeletronicotipoevento codmdfeletronicotipoevento = mdfeletronicoevento.getCodmdfeletronicotipoevento();
            if (codmdfeletronicotipoevento != null) {
                codmdfeletronicotipoevento.getMdfeletronicoeventoCollection().remove(mdfeletronicoevento);
                codmdfeletronicotipoevento = em.merge(codmdfeletronicotipoevento);
            }
            em.remove(mdfeletronicoevento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicoevento> findMdfeletronicoeventoEntities() {
        return findMdfeletronicoeventoEntities(true, -1, -1);
    }

    public List<Mdfeletronicoevento> findMdfeletronicoeventoEntities(int maxResults, int firstResult) {
        return findMdfeletronicoeventoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicoevento> findMdfeletronicoeventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicoevento.class));
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

    public Mdfeletronicoevento findMdfeletronicoevento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicoevento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicoeventoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicoevento> rt = cq.from(Mdfeletronicoevento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
