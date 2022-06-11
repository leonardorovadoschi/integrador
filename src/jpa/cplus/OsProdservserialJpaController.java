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
import entidade.cplus.OsProdservserial;
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
public class OsProdservserialJpaController implements Serializable {

    public OsProdservserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsProdservserial osProdservserial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsProdserv codprodserv = osProdservserial.getCodprodserv();
            if (codprodserv != null) {
                codprodserv = em.getReference(codprodserv.getClass(), codprodserv.getCodprodserv());
                osProdservserial.setCodprodserv(codprodserv);
            }
            Produtoserial codprodutoserial = osProdservserial.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial = em.getReference(codprodutoserial.getClass(), codprodutoserial.getCodprodutoserial());
                osProdservserial.setCodprodutoserial(codprodutoserial);
            }
            em.persist(osProdservserial);
            if (codprodserv != null) {
                codprodserv.getOsProdservserialCollection().add(osProdservserial);
                codprodserv = em.merge(codprodserv);
            }
            if (codprodutoserial != null) {
                codprodutoserial.getOsProdservserialCollection().add(osProdservserial);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsProdservserial(osProdservserial.getCodprodservserial()) != null) {
                throw new PreexistingEntityException("OsProdservserial " + osProdservserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsProdservserial osProdservserial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsProdservserial persistentOsProdservserial = em.find(OsProdservserial.class, osProdservserial.getCodprodservserial());
            OsProdserv codprodservOld = persistentOsProdservserial.getCodprodserv();
            OsProdserv codprodservNew = osProdservserial.getCodprodserv();
            Produtoserial codprodutoserialOld = persistentOsProdservserial.getCodprodutoserial();
            Produtoserial codprodutoserialNew = osProdservserial.getCodprodutoserial();
            if (codprodservNew != null) {
                codprodservNew = em.getReference(codprodservNew.getClass(), codprodservNew.getCodprodserv());
                osProdservserial.setCodprodserv(codprodservNew);
            }
            if (codprodutoserialNew != null) {
                codprodutoserialNew = em.getReference(codprodutoserialNew.getClass(), codprodutoserialNew.getCodprodutoserial());
                osProdservserial.setCodprodutoserial(codprodutoserialNew);
            }
            osProdservserial = em.merge(osProdservserial);
            if (codprodservOld != null && !codprodservOld.equals(codprodservNew)) {
                codprodservOld.getOsProdservserialCollection().remove(osProdservserial);
                codprodservOld = em.merge(codprodservOld);
            }
            if (codprodservNew != null && !codprodservNew.equals(codprodservOld)) {
                codprodservNew.getOsProdservserialCollection().add(osProdservserial);
                codprodservNew = em.merge(codprodservNew);
            }
            if (codprodutoserialOld != null && !codprodutoserialOld.equals(codprodutoserialNew)) {
                codprodutoserialOld.getOsProdservserialCollection().remove(osProdservserial);
                codprodutoserialOld = em.merge(codprodutoserialOld);
            }
            if (codprodutoserialNew != null && !codprodutoserialNew.equals(codprodutoserialOld)) {
                codprodutoserialNew.getOsProdservserialCollection().add(osProdservserial);
                codprodutoserialNew = em.merge(codprodutoserialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osProdservserial.getCodprodservserial();
                if (findOsProdservserial(id) == null) {
                    throw new NonexistentEntityException("The osProdservserial with id " + id + " no longer exists.");
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
            OsProdservserial osProdservserial;
            try {
                osProdservserial = em.getReference(OsProdservserial.class, id);
                osProdservserial.getCodprodservserial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osProdservserial with id " + id + " no longer exists.", enfe);
            }
            OsProdserv codprodserv = osProdservserial.getCodprodserv();
            if (codprodserv != null) {
                codprodserv.getOsProdservserialCollection().remove(osProdservserial);
                codprodserv = em.merge(codprodserv);
            }
            Produtoserial codprodutoserial = osProdservserial.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial.getOsProdservserialCollection().remove(osProdservserial);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.remove(osProdservserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsProdservserial> findOsProdservserialEntities() {
        return findOsProdservserialEntities(true, -1, -1);
    }

    public List<OsProdservserial> findOsProdservserialEntities(int maxResults, int firstResult) {
        return findOsProdservserialEntities(false, maxResults, firstResult);
    }

    private List<OsProdservserial> findOsProdservserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsProdservserial.class));
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

    public OsProdservserial findOsProdservserial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsProdservserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsProdservserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsProdservserial> rt = cq.from(OsProdservserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
