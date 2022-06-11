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
import entidade.cplus.Nfceletronicapafecf;
import entidade.cplus.Nfceletronicapafecfprod;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class NfceletronicapafecfprodJpaController implements Serializable {

    public NfceletronicapafecfprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfceletronicapafecfprod nfceletronicapafecfprod) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfceletronicapafecf codnfceletronicapafecf = nfceletronicapafecfprod.getCodnfceletronicapafecf();
            if (codnfceletronicapafecf != null) {
                codnfceletronicapafecf = em.getReference(codnfceletronicapafecf.getClass(), codnfceletronicapafecf.getCodnfceletronicapafecf());
                nfceletronicapafecfprod.setCodnfceletronicapafecf(codnfceletronicapafecf);
            }
            Produto codprod = nfceletronicapafecfprod.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                nfceletronicapafecfprod.setCodprod(codprod);
            }
            em.persist(nfceletronicapafecfprod);
            if (codnfceletronicapafecf != null) {
                codnfceletronicapafecf.getNfceletronicapafecfprodCollection().add(nfceletronicapafecfprod);
                codnfceletronicapafecf = em.merge(codnfceletronicapafecf);
            }
            if (codprod != null) {
                codprod.getNfceletronicapafecfprodCollection().add(nfceletronicapafecfprod);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfceletronicapafecfprod(nfceletronicapafecfprod.getCodnfceletronicapafecfprod()) != null) {
                throw new PreexistingEntityException("Nfceletronicapafecfprod " + nfceletronicapafecfprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfceletronicapafecfprod nfceletronicapafecfprod) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfceletronicapafecfprod persistentNfceletronicapafecfprod = em.find(Nfceletronicapafecfprod.class, nfceletronicapafecfprod.getCodnfceletronicapafecfprod());
            Nfceletronicapafecf codnfceletronicapafecfOld = persistentNfceletronicapafecfprod.getCodnfceletronicapafecf();
            Nfceletronicapafecf codnfceletronicapafecfNew = nfceletronicapafecfprod.getCodnfceletronicapafecf();
            Produto codprodOld = persistentNfceletronicapafecfprod.getCodprod();
            Produto codprodNew = nfceletronicapafecfprod.getCodprod();
            if (codnfceletronicapafecfNew != null) {
                codnfceletronicapafecfNew = em.getReference(codnfceletronicapafecfNew.getClass(), codnfceletronicapafecfNew.getCodnfceletronicapafecf());
                nfceletronicapafecfprod.setCodnfceletronicapafecf(codnfceletronicapafecfNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                nfceletronicapafecfprod.setCodprod(codprodNew);
            }
            nfceletronicapafecfprod = em.merge(nfceletronicapafecfprod);
            if (codnfceletronicapafecfOld != null && !codnfceletronicapafecfOld.equals(codnfceletronicapafecfNew)) {
                codnfceletronicapafecfOld.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprod);
                codnfceletronicapafecfOld = em.merge(codnfceletronicapafecfOld);
            }
            if (codnfceletronicapafecfNew != null && !codnfceletronicapafecfNew.equals(codnfceletronicapafecfOld)) {
                codnfceletronicapafecfNew.getNfceletronicapafecfprodCollection().add(nfceletronicapafecfprod);
                codnfceletronicapafecfNew = em.merge(codnfceletronicapafecfNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprod);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getNfceletronicapafecfprodCollection().add(nfceletronicapafecfprod);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfceletronicapafecfprod.getCodnfceletronicapafecfprod();
                if (findNfceletronicapafecfprod(id) == null) {
                    throw new NonexistentEntityException("The nfceletronicapafecfprod with id " + id + " no longer exists.");
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
            Nfceletronicapafecfprod nfceletronicapafecfprod;
            try {
                nfceletronicapafecfprod = em.getReference(Nfceletronicapafecfprod.class, id);
                nfceletronicapafecfprod.getCodnfceletronicapafecfprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfceletronicapafecfprod with id " + id + " no longer exists.", enfe);
            }
            Nfceletronicapafecf codnfceletronicapafecf = nfceletronicapafecfprod.getCodnfceletronicapafecf();
            if (codnfceletronicapafecf != null) {
                codnfceletronicapafecf.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprod);
                codnfceletronicapafecf = em.merge(codnfceletronicapafecf);
            }
            Produto codprod = nfceletronicapafecfprod.getCodprod();
            if (codprod != null) {
                codprod.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprod);
                codprod = em.merge(codprod);
            }
            em.remove(nfceletronicapafecfprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfceletronicapafecfprod> findNfceletronicapafecfprodEntities() {
        return findNfceletronicapafecfprodEntities(true, -1, -1);
    }

    public List<Nfceletronicapafecfprod> findNfceletronicapafecfprodEntities(int maxResults, int firstResult) {
        return findNfceletronicapafecfprodEntities(false, maxResults, firstResult);
    }

    private List<Nfceletronicapafecfprod> findNfceletronicapafecfprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfceletronicapafecfprod.class));
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

    public Nfceletronicapafecfprod findNfceletronicapafecfprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfceletronicapafecfprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfceletronicapafecfprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfceletronicapafecfprod> rt = cq.from(Nfceletronicapafecfprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
