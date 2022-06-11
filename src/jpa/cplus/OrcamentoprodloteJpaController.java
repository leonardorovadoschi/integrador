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
import entidade.cplus.Orcamentoprodlote;
import entidade.cplus.Produtolote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrcamentoprodloteJpaController implements Serializable {

    public OrcamentoprodloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentoprodlote orcamentoprodlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprod codorcprod = orcamentoprodlote.getCodorcprod();
            if (codorcprod != null) {
                codorcprod = em.getReference(codorcprod.getClass(), codorcprod.getCodorcprod());
                orcamentoprodlote.setCodorcprod(codorcprod);
            }
            Produtolote codprodutolote = orcamentoprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                orcamentoprodlote.setCodprodutolote(codprodutolote);
            }
            em.persist(orcamentoprodlote);
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodloteCollection().add(orcamentoprodlote);
                codorcprod = em.merge(codorcprod);
            }
            if (codprodutolote != null) {
                codprodutolote.getOrcamentoprodloteCollection().add(orcamentoprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentoprodlote(orcamentoprodlote.getCodorcamentoprodlote()) != null) {
                throw new PreexistingEntityException("Orcamentoprodlote " + orcamentoprodlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentoprodlote orcamentoprodlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprodlote persistentOrcamentoprodlote = em.find(Orcamentoprodlote.class, orcamentoprodlote.getCodorcamentoprodlote());
            Orcamentoprod codorcprodOld = persistentOrcamentoprodlote.getCodorcprod();
            Orcamentoprod codorcprodNew = orcamentoprodlote.getCodorcprod();
            Produtolote codprodutoloteOld = persistentOrcamentoprodlote.getCodprodutolote();
            Produtolote codprodutoloteNew = orcamentoprodlote.getCodprodutolote();
            if (codorcprodNew != null) {
                codorcprodNew = em.getReference(codorcprodNew.getClass(), codorcprodNew.getCodorcprod());
                orcamentoprodlote.setCodorcprod(codorcprodNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                orcamentoprodlote.setCodprodutolote(codprodutoloteNew);
            }
            orcamentoprodlote = em.merge(orcamentoprodlote);
            if (codorcprodOld != null && !codorcprodOld.equals(codorcprodNew)) {
                codorcprodOld.getOrcamentoprodloteCollection().remove(orcamentoprodlote);
                codorcprodOld = em.merge(codorcprodOld);
            }
            if (codorcprodNew != null && !codorcprodNew.equals(codorcprodOld)) {
                codorcprodNew.getOrcamentoprodloteCollection().add(orcamentoprodlote);
                codorcprodNew = em.merge(codorcprodNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getOrcamentoprodloteCollection().remove(orcamentoprodlote);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getOrcamentoprodloteCollection().add(orcamentoprodlote);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentoprodlote.getCodorcamentoprodlote();
                if (findOrcamentoprodlote(id) == null) {
                    throw new NonexistentEntityException("The orcamentoprodlote with id " + id + " no longer exists.");
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
            Orcamentoprodlote orcamentoprodlote;
            try {
                orcamentoprodlote = em.getReference(Orcamentoprodlote.class, id);
                orcamentoprodlote.getCodorcamentoprodlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentoprodlote with id " + id + " no longer exists.", enfe);
            }
            Orcamentoprod codorcprod = orcamentoprodlote.getCodorcprod();
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodloteCollection().remove(orcamentoprodlote);
                codorcprod = em.merge(codorcprod);
            }
            Produtolote codprodutolote = orcamentoprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getOrcamentoprodloteCollection().remove(orcamentoprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.remove(orcamentoprodlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentoprodlote> findOrcamentoprodloteEntities() {
        return findOrcamentoprodloteEntities(true, -1, -1);
    }

    public List<Orcamentoprodlote> findOrcamentoprodloteEntities(int maxResults, int firstResult) {
        return findOrcamentoprodloteEntities(false, maxResults, firstResult);
    }

    private List<Orcamentoprodlote> findOrcamentoprodloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentoprodlote.class));
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

    public Orcamentoprodlote findOrcamentoprodlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentoprodlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentoprodloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentoprodlote> rt = cq.from(Orcamentoprodlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
