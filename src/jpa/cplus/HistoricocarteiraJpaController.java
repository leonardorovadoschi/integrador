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
import entidade.cplus.Contabancaria;
import entidade.cplus.Contareceber;
import entidade.cplus.Historicocarteira;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class HistoricocarteiraJpaController implements Serializable {

    public HistoricocarteiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historicocarteira historicocarteira) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contabancaria codcontabancaria = historicocarteira.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                historicocarteira.setCodcontabancaria(codcontabancaria);
            }
            Contareceber codcr = historicocarteira.getCodcr();
            if (codcr != null) {
                codcr = em.getReference(codcr.getClass(), codcr.getCodcr());
                historicocarteira.setCodcr(codcr);
            }
            em.persist(historicocarteira);
            if (codcontabancaria != null) {
                codcontabancaria.getHistoricocarteiraCollection().add(historicocarteira);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codcr != null) {
                codcr.getHistoricocarteiraCollection().add(historicocarteira);
                codcr = em.merge(codcr);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricocarteira(historicocarteira.getCodhistoricocarteira()) != null) {
                throw new PreexistingEntityException("Historicocarteira " + historicocarteira + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historicocarteira historicocarteira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historicocarteira persistentHistoricocarteira = em.find(Historicocarteira.class, historicocarteira.getCodhistoricocarteira());
            Contabancaria codcontabancariaOld = persistentHistoricocarteira.getCodcontabancaria();
            Contabancaria codcontabancariaNew = historicocarteira.getCodcontabancaria();
            Contareceber codcrOld = persistentHistoricocarteira.getCodcr();
            Contareceber codcrNew = historicocarteira.getCodcr();
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                historicocarteira.setCodcontabancaria(codcontabancariaNew);
            }
            if (codcrNew != null) {
                codcrNew = em.getReference(codcrNew.getClass(), codcrNew.getCodcr());
                historicocarteira.setCodcr(codcrNew);
            }
            historicocarteira = em.merge(historicocarteira);
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getHistoricocarteiraCollection().remove(historicocarteira);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getHistoricocarteiraCollection().add(historicocarteira);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codcrOld != null && !codcrOld.equals(codcrNew)) {
                codcrOld.getHistoricocarteiraCollection().remove(historicocarteira);
                codcrOld = em.merge(codcrOld);
            }
            if (codcrNew != null && !codcrNew.equals(codcrOld)) {
                codcrNew.getHistoricocarteiraCollection().add(historicocarteira);
                codcrNew = em.merge(codcrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = historicocarteira.getCodhistoricocarteira();
                if (findHistoricocarteira(id) == null) {
                    throw new NonexistentEntityException("The historicocarteira with id " + id + " no longer exists.");
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
            Historicocarteira historicocarteira;
            try {
                historicocarteira = em.getReference(Historicocarteira.class, id);
                historicocarteira.getCodhistoricocarteira();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicocarteira with id " + id + " no longer exists.", enfe);
            }
            Contabancaria codcontabancaria = historicocarteira.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getHistoricocarteiraCollection().remove(historicocarteira);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Contareceber codcr = historicocarteira.getCodcr();
            if (codcr != null) {
                codcr.getHistoricocarteiraCollection().remove(historicocarteira);
                codcr = em.merge(codcr);
            }
            em.remove(historicocarteira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historicocarteira> findHistoricocarteiraEntities() {
        return findHistoricocarteiraEntities(true, -1, -1);
    }

    public List<Historicocarteira> findHistoricocarteiraEntities(int maxResults, int firstResult) {
        return findHistoricocarteiraEntities(false, maxResults, firstResult);
    }

    private List<Historicocarteira> findHistoricocarteiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historicocarteira.class));
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

    public Historicocarteira findHistoricocarteira(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historicocarteira.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricocarteiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historicocarteira> rt = cq.from(Historicocarteira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
