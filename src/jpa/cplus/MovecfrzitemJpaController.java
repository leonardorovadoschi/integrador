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
import entidade.cplus.Empresa;
import entidade.cplus.Movecfrz;
import entidade.cplus.Movecfrzitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovecfrzitemJpaController implements Serializable {

    public MovecfrzitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfrzitem movecfrzitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = movecfrzitem.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                movecfrzitem.setCodempresa(codempresa);
            }
            Movecfrz codmovecfrz = movecfrzitem.getCodmovecfrz();
            if (codmovecfrz != null) {
                codmovecfrz = em.getReference(codmovecfrz.getClass(), codmovecfrz.getCodmovecfrz());
                movecfrzitem.setCodmovecfrz(codmovecfrz);
            }
            em.persist(movecfrzitem);
            if (codempresa != null) {
                codempresa.getMovecfrzitemCollection().add(movecfrzitem);
                codempresa = em.merge(codempresa);
            }
            if (codmovecfrz != null) {
                codmovecfrz.getMovecfrzitemCollection().add(movecfrzitem);
                codmovecfrz = em.merge(codmovecfrz);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfrzitem(movecfrzitem.getCodmovecfrzitem()) != null) {
                throw new PreexistingEntityException("Movecfrzitem " + movecfrzitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfrzitem movecfrzitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfrzitem persistentMovecfrzitem = em.find(Movecfrzitem.class, movecfrzitem.getCodmovecfrzitem());
            Empresa codempresaOld = persistentMovecfrzitem.getCodempresa();
            Empresa codempresaNew = movecfrzitem.getCodempresa();
            Movecfrz codmovecfrzOld = persistentMovecfrzitem.getCodmovecfrz();
            Movecfrz codmovecfrzNew = movecfrzitem.getCodmovecfrz();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                movecfrzitem.setCodempresa(codempresaNew);
            }
            if (codmovecfrzNew != null) {
                codmovecfrzNew = em.getReference(codmovecfrzNew.getClass(), codmovecfrzNew.getCodmovecfrz());
                movecfrzitem.setCodmovecfrz(codmovecfrzNew);
            }
            movecfrzitem = em.merge(movecfrzitem);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getMovecfrzitemCollection().remove(movecfrzitem);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getMovecfrzitemCollection().add(movecfrzitem);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmovecfrzOld != null && !codmovecfrzOld.equals(codmovecfrzNew)) {
                codmovecfrzOld.getMovecfrzitemCollection().remove(movecfrzitem);
                codmovecfrzOld = em.merge(codmovecfrzOld);
            }
            if (codmovecfrzNew != null && !codmovecfrzNew.equals(codmovecfrzOld)) {
                codmovecfrzNew.getMovecfrzitemCollection().add(movecfrzitem);
                codmovecfrzNew = em.merge(codmovecfrzNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfrzitem.getCodmovecfrzitem();
                if (findMovecfrzitem(id) == null) {
                    throw new NonexistentEntityException("The movecfrzitem with id " + id + " no longer exists.");
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
            Movecfrzitem movecfrzitem;
            try {
                movecfrzitem = em.getReference(Movecfrzitem.class, id);
                movecfrzitem.getCodmovecfrzitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfrzitem with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = movecfrzitem.getCodempresa();
            if (codempresa != null) {
                codempresa.getMovecfrzitemCollection().remove(movecfrzitem);
                codempresa = em.merge(codempresa);
            }
            Movecfrz codmovecfrz = movecfrzitem.getCodmovecfrz();
            if (codmovecfrz != null) {
                codmovecfrz.getMovecfrzitemCollection().remove(movecfrzitem);
                codmovecfrz = em.merge(codmovecfrz);
            }
            em.remove(movecfrzitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfrzitem> findMovecfrzitemEntities() {
        return findMovecfrzitemEntities(true, -1, -1);
    }

    public List<Movecfrzitem> findMovecfrzitemEntities(int maxResults, int firstResult) {
        return findMovecfrzitemEntities(false, maxResults, firstResult);
    }

    private List<Movecfrzitem> findMovecfrzitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfrzitem.class));
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

    public Movecfrzitem findMovecfrzitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfrzitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfrzitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfrzitem> rt = cq.from(Movecfrzitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
