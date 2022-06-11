/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsRequisicao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class OsRequisicaoJpaController implements Serializable {

    public OsRequisicaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsRequisicao osRequisicao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = osRequisicao.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                osRequisicao.setCodprod(codprod);
            }
            em.persist(osRequisicao);
            if (codprod != null) {
                codprod.getOsRequisicaoCollection().add(osRequisicao);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsRequisicao(osRequisicao.getCodrequisicao()) != null) {
                throw new PreexistingEntityException("OsRequisicao " + osRequisicao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsRequisicao osRequisicao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsRequisicao persistentOsRequisicao = em.find(OsRequisicao.class, osRequisicao.getCodrequisicao());
            Produto codprodOld = persistentOsRequisicao.getCodprod();
            Produto codprodNew = osRequisicao.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                osRequisicao.setCodprod(codprodNew);
            }
            osRequisicao = em.merge(osRequisicao);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getOsRequisicaoCollection().remove(osRequisicao);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getOsRequisicaoCollection().add(osRequisicao);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osRequisicao.getCodrequisicao();
                if (findOsRequisicao(id) == null) {
                    throw new NonexistentEntityException("The osRequisicao with id " + id + " no longer exists.");
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
            OsRequisicao osRequisicao;
            try {
                osRequisicao = em.getReference(OsRequisicao.class, id);
                osRequisicao.getCodrequisicao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osRequisicao with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = osRequisicao.getCodprod();
            if (codprod != null) {
                codprod.getOsRequisicaoCollection().remove(osRequisicao);
                codprod = em.merge(codprod);
            }
            em.remove(osRequisicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsRequisicao> findOsRequisicaoEntities() {
        return findOsRequisicaoEntities(true, -1, -1);
    }

    public List<OsRequisicao> findOsRequisicaoEntities(int maxResults, int firstResult) {
        return findOsRequisicaoEntities(false, maxResults, firstResult);
    }

    private List<OsRequisicao> findOsRequisicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsRequisicao.class));
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

    public OsRequisicao findOsRequisicao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsRequisicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsRequisicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsRequisicao> rt = cq.from(OsRequisicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
