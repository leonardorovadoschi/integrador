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
import entidade.cplus.Movecfdocumento;
import entidade.cplus.Movecfdocumentoitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovecfdocumentoitemJpaController implements Serializable {

    public MovecfdocumentoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfdocumentoitem movecfdocumentoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfdocumento codmovecfdocumento = movecfdocumentoitem.getCodmovecfdocumento();
            if (codmovecfdocumento != null) {
                codmovecfdocumento = em.getReference(codmovecfdocumento.getClass(), codmovecfdocumento.getCodmovecfdocumento());
                movecfdocumentoitem.setCodmovecfdocumento(codmovecfdocumento);
            }
            em.persist(movecfdocumentoitem);
            if (codmovecfdocumento != null) {
                codmovecfdocumento.getMovecfdocumentoitemCollection().add(movecfdocumentoitem);
                codmovecfdocumento = em.merge(codmovecfdocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfdocumentoitem(movecfdocumentoitem.getCodmovecfdocumentoitem()) != null) {
                throw new PreexistingEntityException("Movecfdocumentoitem " + movecfdocumentoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfdocumentoitem movecfdocumentoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfdocumentoitem persistentMovecfdocumentoitem = em.find(Movecfdocumentoitem.class, movecfdocumentoitem.getCodmovecfdocumentoitem());
            Movecfdocumento codmovecfdocumentoOld = persistentMovecfdocumentoitem.getCodmovecfdocumento();
            Movecfdocumento codmovecfdocumentoNew = movecfdocumentoitem.getCodmovecfdocumento();
            if (codmovecfdocumentoNew != null) {
                codmovecfdocumentoNew = em.getReference(codmovecfdocumentoNew.getClass(), codmovecfdocumentoNew.getCodmovecfdocumento());
                movecfdocumentoitem.setCodmovecfdocumento(codmovecfdocumentoNew);
            }
            movecfdocumentoitem = em.merge(movecfdocumentoitem);
            if (codmovecfdocumentoOld != null && !codmovecfdocumentoOld.equals(codmovecfdocumentoNew)) {
                codmovecfdocumentoOld.getMovecfdocumentoitemCollection().remove(movecfdocumentoitem);
                codmovecfdocumentoOld = em.merge(codmovecfdocumentoOld);
            }
            if (codmovecfdocumentoNew != null && !codmovecfdocumentoNew.equals(codmovecfdocumentoOld)) {
                codmovecfdocumentoNew.getMovecfdocumentoitemCollection().add(movecfdocumentoitem);
                codmovecfdocumentoNew = em.merge(codmovecfdocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfdocumentoitem.getCodmovecfdocumentoitem();
                if (findMovecfdocumentoitem(id) == null) {
                    throw new NonexistentEntityException("The movecfdocumentoitem with id " + id + " no longer exists.");
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
            Movecfdocumentoitem movecfdocumentoitem;
            try {
                movecfdocumentoitem = em.getReference(Movecfdocumentoitem.class, id);
                movecfdocumentoitem.getCodmovecfdocumentoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfdocumentoitem with id " + id + " no longer exists.", enfe);
            }
            Movecfdocumento codmovecfdocumento = movecfdocumentoitem.getCodmovecfdocumento();
            if (codmovecfdocumento != null) {
                codmovecfdocumento.getMovecfdocumentoitemCollection().remove(movecfdocumentoitem);
                codmovecfdocumento = em.merge(codmovecfdocumento);
            }
            em.remove(movecfdocumentoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfdocumentoitem> findMovecfdocumentoitemEntities() {
        return findMovecfdocumentoitemEntities(true, -1, -1);
    }

    public List<Movecfdocumentoitem> findMovecfdocumentoitemEntities(int maxResults, int firstResult) {
        return findMovecfdocumentoitemEntities(false, maxResults, firstResult);
    }

    private List<Movecfdocumentoitem> findMovecfdocumentoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfdocumentoitem.class));
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

    public Movecfdocumentoitem findMovecfdocumentoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfdocumentoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfdocumentoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfdocumentoitem> rt = cq.from(Movecfdocumentoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
