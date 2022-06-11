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
import entidade.cplus.OsProdserv;
import entidade.cplus.OsProdservlote;
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
public class OsProdservloteJpaController implements Serializable {

    public OsProdservloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsProdservlote osProdservlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsProdserv codprodserv = osProdservlote.getCodprodserv();
            if (codprodserv != null) {
                codprodserv = em.getReference(codprodserv.getClass(), codprodserv.getCodprodserv());
                osProdservlote.setCodprodserv(codprodserv);
            }
            Produtolote codprodutolote = osProdservlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                osProdservlote.setCodprodutolote(codprodutolote);
            }
            em.persist(osProdservlote);
            if (codprodserv != null) {
                codprodserv.getOsProdservloteCollection().add(osProdservlote);
                codprodserv = em.merge(codprodserv);
            }
            if (codprodutolote != null) {
                codprodutolote.getOsProdservloteCollection().add(osProdservlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsProdservlote(osProdservlote.getCodprodservlote()) != null) {
                throw new PreexistingEntityException("OsProdservlote " + osProdservlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsProdservlote osProdservlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsProdservlote persistentOsProdservlote = em.find(OsProdservlote.class, osProdservlote.getCodprodservlote());
            OsProdserv codprodservOld = persistentOsProdservlote.getCodprodserv();
            OsProdserv codprodservNew = osProdservlote.getCodprodserv();
            Produtolote codprodutoloteOld = persistentOsProdservlote.getCodprodutolote();
            Produtolote codprodutoloteNew = osProdservlote.getCodprodutolote();
            if (codprodservNew != null) {
                codprodservNew = em.getReference(codprodservNew.getClass(), codprodservNew.getCodprodserv());
                osProdservlote.setCodprodserv(codprodservNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                osProdservlote.setCodprodutolote(codprodutoloteNew);
            }
            osProdservlote = em.merge(osProdservlote);
            if (codprodservOld != null && !codprodservOld.equals(codprodservNew)) {
                codprodservOld.getOsProdservloteCollection().remove(osProdservlote);
                codprodservOld = em.merge(codprodservOld);
            }
            if (codprodservNew != null && !codprodservNew.equals(codprodservOld)) {
                codprodservNew.getOsProdservloteCollection().add(osProdservlote);
                codprodservNew = em.merge(codprodservNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getOsProdservloteCollection().remove(osProdservlote);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getOsProdservloteCollection().add(osProdservlote);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osProdservlote.getCodprodservlote();
                if (findOsProdservlote(id) == null) {
                    throw new NonexistentEntityException("The osProdservlote with id " + id + " no longer exists.");
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
            OsProdservlote osProdservlote;
            try {
                osProdservlote = em.getReference(OsProdservlote.class, id);
                osProdservlote.getCodprodservlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osProdservlote with id " + id + " no longer exists.", enfe);
            }
            OsProdserv codprodserv = osProdservlote.getCodprodserv();
            if (codprodserv != null) {
                codprodserv.getOsProdservloteCollection().remove(osProdservlote);
                codprodserv = em.merge(codprodserv);
            }
            Produtolote codprodutolote = osProdservlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getOsProdservloteCollection().remove(osProdservlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.remove(osProdservlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsProdservlote> findOsProdservloteEntities() {
        return findOsProdservloteEntities(true, -1, -1);
    }

    public List<OsProdservlote> findOsProdservloteEntities(int maxResults, int firstResult) {
        return findOsProdservloteEntities(false, maxResults, firstResult);
    }

    private List<OsProdservlote> findOsProdservloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsProdservlote.class));
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

    public OsProdservlote findOsProdservlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsProdservlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsProdservloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsProdservlote> rt = cq.from(OsProdservlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
