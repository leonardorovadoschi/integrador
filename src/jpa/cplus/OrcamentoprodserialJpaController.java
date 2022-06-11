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
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Orcamentoprodserial;
import entidade.cplus.Produtoserial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrcamentoprodserialJpaController implements Serializable {

    public OrcamentoprodserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentoprodserial orcamentoprodserial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprod codorcprod = orcamentoprodserial.getCodorcprod();
            if (codorcprod != null) {
                codorcprod = em.getReference(codorcprod.getClass(), codorcprod.getCodorcprod());
                orcamentoprodserial.setCodorcprod(codorcprod);
            }
            Produtoserial codprodutoserial = orcamentoprodserial.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial = em.getReference(codprodutoserial.getClass(), codprodutoserial.getCodprodutoserial());
                orcamentoprodserial.setCodprodutoserial(codprodutoserial);
            }
            em.persist(orcamentoprodserial);
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodserialCollection().add(orcamentoprodserial);
                codorcprod = em.merge(codorcprod);
            }
            if (codprodutoserial != null) {
                codprodutoserial.getOrcamentoprodserialCollection().add(orcamentoprodserial);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentoprodserial(orcamentoprodserial.getCodorcprodser()) != null) {
                throw new PreexistingEntityException("Orcamentoprodserial " + orcamentoprodserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentoprodserial orcamentoprodserial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprodserial persistentOrcamentoprodserial = em.find(Orcamentoprodserial.class, orcamentoprodserial.getCodorcprodser());
            Orcamentoprod codorcprodOld = persistentOrcamentoprodserial.getCodorcprod();
            Orcamentoprod codorcprodNew = orcamentoprodserial.getCodorcprod();
            Produtoserial codprodutoserialOld = persistentOrcamentoprodserial.getCodprodutoserial();
            Produtoserial codprodutoserialNew = orcamentoprodserial.getCodprodutoserial();
            if (codorcprodNew != null) {
                codorcprodNew = em.getReference(codorcprodNew.getClass(), codorcprodNew.getCodorcprod());
                orcamentoprodserial.setCodorcprod(codorcprodNew);
            }
            if (codprodutoserialNew != null) {
                codprodutoserialNew = em.getReference(codprodutoserialNew.getClass(), codprodutoserialNew.getCodprodutoserial());
                orcamentoprodserial.setCodprodutoserial(codprodutoserialNew);
            }
            orcamentoprodserial = em.merge(orcamentoprodserial);
            if (codorcprodOld != null && !codorcprodOld.equals(codorcprodNew)) {
                codorcprodOld.getOrcamentoprodserialCollection().remove(orcamentoprodserial);
                codorcprodOld = em.merge(codorcprodOld);
            }
            if (codorcprodNew != null && !codorcprodNew.equals(codorcprodOld)) {
                codorcprodNew.getOrcamentoprodserialCollection().add(orcamentoprodserial);
                codorcprodNew = em.merge(codorcprodNew);
            }
            if (codprodutoserialOld != null && !codprodutoserialOld.equals(codprodutoserialNew)) {
                codprodutoserialOld.getOrcamentoprodserialCollection().remove(orcamentoprodserial);
                codprodutoserialOld = em.merge(codprodutoserialOld);
            }
            if (codprodutoserialNew != null && !codprodutoserialNew.equals(codprodutoserialOld)) {
                codprodutoserialNew.getOrcamentoprodserialCollection().add(orcamentoprodserial);
                codprodutoserialNew = em.merge(codprodutoserialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentoprodserial.getCodorcprodser();
                if (findOrcamentoprodserial(id) == null) {
                    throw new NonexistentEntityException("The orcamentoprodserial with id " + id + " no longer exists.");
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
            Orcamentoprodserial orcamentoprodserial;
            try {
                orcamentoprodserial = em.getReference(Orcamentoprodserial.class, id);
                orcamentoprodserial.getCodorcprodser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentoprodserial with id " + id + " no longer exists.", enfe);
            }
            Orcamentoprod codorcprod = orcamentoprodserial.getCodorcprod();
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodserialCollection().remove(orcamentoprodserial);
                codorcprod = em.merge(codorcprod);
            }
            Produtoserial codprodutoserial = orcamentoprodserial.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial.getOrcamentoprodserialCollection().remove(orcamentoprodserial);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.remove(orcamentoprodserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentoprodserial> findOrcamentoprodserialEntities() {
        return findOrcamentoprodserialEntities(true, -1, -1);
    }

    public List<Orcamentoprodserial> findOrcamentoprodserialEntities(int maxResults, int firstResult) {
        return findOrcamentoprodserialEntities(false, maxResults, firstResult);
    }

    private List<Orcamentoprodserial> findOrcamentoprodserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentoprodserial.class));
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

    public Orcamentoprodserial findOrcamentoprodserial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentoprodserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentoprodserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentoprodserial> rt = cq.from(Orcamentoprodserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
