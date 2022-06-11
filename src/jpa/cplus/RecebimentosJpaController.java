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
import entidade.cplus.Contareceber;
import entidade.cplus.Recebimentos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RecebimentosJpaController implements Serializable {

    public RecebimentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recebimentos recebimentos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contareceber codcr = recebimentos.getCodcr();
            if (codcr != null) {
                codcr = em.getReference(codcr.getClass(), codcr.getCodcr());
                recebimentos.setCodcr(codcr);
            }
            em.persist(recebimentos);
            if (codcr != null) {
                codcr.getRecebimentosCollection().add(recebimentos);
                codcr = em.merge(codcr);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRecebimentos(recebimentos.getId()) != null) {
                throw new PreexistingEntityException("Recebimentos " + recebimentos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recebimentos recebimentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recebimentos persistentRecebimentos = em.find(Recebimentos.class, recebimentos.getId());
            Contareceber codcrOld = persistentRecebimentos.getCodcr();
            Contareceber codcrNew = recebimentos.getCodcr();
            if (codcrNew != null) {
                codcrNew = em.getReference(codcrNew.getClass(), codcrNew.getCodcr());
                recebimentos.setCodcr(codcrNew);
            }
            recebimentos = em.merge(recebimentos);
            if (codcrOld != null && !codcrOld.equals(codcrNew)) {
                codcrOld.getRecebimentosCollection().remove(recebimentos);
                codcrOld = em.merge(codcrOld);
            }
            if (codcrNew != null && !codcrNew.equals(codcrOld)) {
                codcrNew.getRecebimentosCollection().add(recebimentos);
                codcrNew = em.merge(codcrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recebimentos.getId();
                if (findRecebimentos(id) == null) {
                    throw new NonexistentEntityException("The recebimentos with id " + id + " no longer exists.");
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
            Recebimentos recebimentos;
            try {
                recebimentos = em.getReference(Recebimentos.class, id);
                recebimentos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recebimentos with id " + id + " no longer exists.", enfe);
            }
            Contareceber codcr = recebimentos.getCodcr();
            if (codcr != null) {
                codcr.getRecebimentosCollection().remove(recebimentos);
                codcr = em.merge(codcr);
            }
            em.remove(recebimentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recebimentos> findRecebimentosEntities() {
        return findRecebimentosEntities(true, -1, -1);
    }

    public List<Recebimentos> findRecebimentosEntities(int maxResults, int firstResult) {
        return findRecebimentosEntities(false, maxResults, firstResult);
    }

    private List<Recebimentos> findRecebimentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recebimentos.class));
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

    public Recebimentos findRecebimentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recebimentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecebimentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recebimentos> rt = cq.from(Recebimentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
