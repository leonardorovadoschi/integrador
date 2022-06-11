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
import entidade.cplus.Movendaprod;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Orcamentovenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrcamentovendaJpaController implements Serializable {

    public OrcamentovendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentovenda orcamentovenda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = orcamentovenda.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                orcamentovenda.setCodmovprod(codmovprod);
            }
            Orcamentoprod codorcprod = orcamentovenda.getCodorcprod();
            if (codorcprod != null) {
                codorcprod = em.getReference(codorcprod.getClass(), codorcprod.getCodorcprod());
                orcamentovenda.setCodorcprod(codorcprod);
            }
            em.persist(orcamentovenda);
            if (codmovprod != null) {
                codmovprod.getOrcamentovendaCollection().add(orcamentovenda);
                codmovprod = em.merge(codmovprod);
            }
            if (codorcprod != null) {
                codorcprod.getOrcamentovendaCollection().add(orcamentovenda);
                codorcprod = em.merge(codorcprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentovenda(orcamentovenda.getCodorcamentovenda()) != null) {
                throw new PreexistingEntityException("Orcamentovenda " + orcamentovenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentovenda orcamentovenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentovenda persistentOrcamentovenda = em.find(Orcamentovenda.class, orcamentovenda.getCodorcamentovenda());
            Movendaprod codmovprodOld = persistentOrcamentovenda.getCodmovprod();
            Movendaprod codmovprodNew = orcamentovenda.getCodmovprod();
            Orcamentoprod codorcprodOld = persistentOrcamentovenda.getCodorcprod();
            Orcamentoprod codorcprodNew = orcamentovenda.getCodorcprod();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                orcamentovenda.setCodmovprod(codmovprodNew);
            }
            if (codorcprodNew != null) {
                codorcprodNew = em.getReference(codorcprodNew.getClass(), codorcprodNew.getCodorcprod());
                orcamentovenda.setCodorcprod(codorcprodNew);
            }
            orcamentovenda = em.merge(orcamentovenda);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getOrcamentovendaCollection().remove(orcamentovenda);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getOrcamentovendaCollection().add(orcamentovenda);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codorcprodOld != null && !codorcprodOld.equals(codorcprodNew)) {
                codorcprodOld.getOrcamentovendaCollection().remove(orcamentovenda);
                codorcprodOld = em.merge(codorcprodOld);
            }
            if (codorcprodNew != null && !codorcprodNew.equals(codorcprodOld)) {
                codorcprodNew.getOrcamentovendaCollection().add(orcamentovenda);
                codorcprodNew = em.merge(codorcprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentovenda.getCodorcamentovenda();
                if (findOrcamentovenda(id) == null) {
                    throw new NonexistentEntityException("The orcamentovenda with id " + id + " no longer exists.");
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
            Orcamentovenda orcamentovenda;
            try {
                orcamentovenda = em.getReference(Orcamentovenda.class, id);
                orcamentovenda.getCodorcamentovenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentovenda with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = orcamentovenda.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getOrcamentovendaCollection().remove(orcamentovenda);
                codmovprod = em.merge(codmovprod);
            }
            Orcamentoprod codorcprod = orcamentovenda.getCodorcprod();
            if (codorcprod != null) {
                codorcprod.getOrcamentovendaCollection().remove(orcamentovenda);
                codorcprod = em.merge(codorcprod);
            }
            em.remove(orcamentovenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentovenda> findOrcamentovendaEntities() {
        return findOrcamentovendaEntities(true, -1, -1);
    }

    public List<Orcamentovenda> findOrcamentovendaEntities(int maxResults, int firstResult) {
        return findOrcamentovendaEntities(false, maxResults, firstResult);
    }

    private List<Orcamentovenda> findOrcamentovendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentovenda.class));
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

    public Orcamentovenda findOrcamentovenda(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentovenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentovendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentovenda> rt = cq.from(Orcamentovenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
