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
import entidade.cplus.Ordemproducao;
import entidade.cplus.Producaohistorico;
import entidade.cplus.Producaostatus;
import entidade.cplus.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProducaohistoricoJpaController implements Serializable {

    public ProducaohistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producaohistorico producaohistorico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducao codordemproducao = producaohistorico.getCodordemproducao();
            if (codordemproducao != null) {
                codordemproducao = em.getReference(codordemproducao.getClass(), codordemproducao.getCodordemproducao());
                producaohistorico.setCodordemproducao(codordemproducao);
            }
            Producaostatus codproducaostatus = producaohistorico.getCodproducaostatus();
            if (codproducaostatus != null) {
                codproducaostatus = em.getReference(codproducaostatus.getClass(), codproducaostatus.getCodproducaostatus());
                producaohistorico.setCodproducaostatus(codproducaostatus);
            }
            Usuario coduser = producaohistorico.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                producaohistorico.setCoduser(coduser);
            }
            em.persist(producaohistorico);
            if (codordemproducao != null) {
                codordemproducao.getProducaohistoricoCollection().add(producaohistorico);
                codordemproducao = em.merge(codordemproducao);
            }
            if (codproducaostatus != null) {
                codproducaostatus.getProducaohistoricoCollection().add(producaohistorico);
                codproducaostatus = em.merge(codproducaostatus);
            }
            if (coduser != null) {
                coduser.getProducaohistoricoCollection().add(producaohistorico);
                coduser = em.merge(coduser);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducaohistorico(producaohistorico.getCodproducaohistorico()) != null) {
                throw new PreexistingEntityException("Producaohistorico " + producaohistorico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producaohistorico producaohistorico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producaohistorico persistentProducaohistorico = em.find(Producaohistorico.class, producaohistorico.getCodproducaohistorico());
            Ordemproducao codordemproducaoOld = persistentProducaohistorico.getCodordemproducao();
            Ordemproducao codordemproducaoNew = producaohistorico.getCodordemproducao();
            Producaostatus codproducaostatusOld = persistentProducaohistorico.getCodproducaostatus();
            Producaostatus codproducaostatusNew = producaohistorico.getCodproducaostatus();
            Usuario coduserOld = persistentProducaohistorico.getCoduser();
            Usuario coduserNew = producaohistorico.getCoduser();
            if (codordemproducaoNew != null) {
                codordemproducaoNew = em.getReference(codordemproducaoNew.getClass(), codordemproducaoNew.getCodordemproducao());
                producaohistorico.setCodordemproducao(codordemproducaoNew);
            }
            if (codproducaostatusNew != null) {
                codproducaostatusNew = em.getReference(codproducaostatusNew.getClass(), codproducaostatusNew.getCodproducaostatus());
                producaohistorico.setCodproducaostatus(codproducaostatusNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                producaohistorico.setCoduser(coduserNew);
            }
            producaohistorico = em.merge(producaohistorico);
            if (codordemproducaoOld != null && !codordemproducaoOld.equals(codordemproducaoNew)) {
                codordemproducaoOld.getProducaohistoricoCollection().remove(producaohistorico);
                codordemproducaoOld = em.merge(codordemproducaoOld);
            }
            if (codordemproducaoNew != null && !codordemproducaoNew.equals(codordemproducaoOld)) {
                codordemproducaoNew.getProducaohistoricoCollection().add(producaohistorico);
                codordemproducaoNew = em.merge(codordemproducaoNew);
            }
            if (codproducaostatusOld != null && !codproducaostatusOld.equals(codproducaostatusNew)) {
                codproducaostatusOld.getProducaohistoricoCollection().remove(producaohistorico);
                codproducaostatusOld = em.merge(codproducaostatusOld);
            }
            if (codproducaostatusNew != null && !codproducaostatusNew.equals(codproducaostatusOld)) {
                codproducaostatusNew.getProducaohistoricoCollection().add(producaohistorico);
                codproducaostatusNew = em.merge(codproducaostatusNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getProducaohistoricoCollection().remove(producaohistorico);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getProducaohistoricoCollection().add(producaohistorico);
                coduserNew = em.merge(coduserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = producaohistorico.getCodproducaohistorico();
                if (findProducaohistorico(id) == null) {
                    throw new NonexistentEntityException("The producaohistorico with id " + id + " no longer exists.");
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
            Producaohistorico producaohistorico;
            try {
                producaohistorico = em.getReference(Producaohistorico.class, id);
                producaohistorico.getCodproducaohistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producaohistorico with id " + id + " no longer exists.", enfe);
            }
            Ordemproducao codordemproducao = producaohistorico.getCodordemproducao();
            if (codordemproducao != null) {
                codordemproducao.getProducaohistoricoCollection().remove(producaohistorico);
                codordemproducao = em.merge(codordemproducao);
            }
            Producaostatus codproducaostatus = producaohistorico.getCodproducaostatus();
            if (codproducaostatus != null) {
                codproducaostatus.getProducaohistoricoCollection().remove(producaohistorico);
                codproducaostatus = em.merge(codproducaostatus);
            }
            Usuario coduser = producaohistorico.getCoduser();
            if (coduser != null) {
                coduser.getProducaohistoricoCollection().remove(producaohistorico);
                coduser = em.merge(coduser);
            }
            em.remove(producaohistorico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producaohistorico> findProducaohistoricoEntities() {
        return findProducaohistoricoEntities(true, -1, -1);
    }

    public List<Producaohistorico> findProducaohistoricoEntities(int maxResults, int firstResult) {
        return findProducaohistoricoEntities(false, maxResults, firstResult);
    }

    private List<Producaohistorico> findProducaohistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producaohistorico.class));
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

    public Producaohistorico findProducaohistorico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producaohistorico.class, id);
        } finally {
            em.close();
        }
    }

    public int getProducaohistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producaohistorico> rt = cq.from(Producaohistorico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
