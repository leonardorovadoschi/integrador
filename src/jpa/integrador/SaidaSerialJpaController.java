/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.integrador;

import entidade.integrador.SaidaSerial;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.integrador.SerialProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leonardo
 */
public class SaidaSerialJpaController implements Serializable {

    public SaidaSerialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SaidaSerial saidaSerial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SerialProduto idSerial = saidaSerial.getIdSerial();
            if (idSerial != null) {
                idSerial = em.getReference(idSerial.getClass(), idSerial.getIdSerial());
                saidaSerial.setIdSerial(idSerial);
            }
            em.persist(saidaSerial);
            if (idSerial != null) {
                idSerial.getSaidaSerialCollection().add(saidaSerial);
                idSerial = em.merge(idSerial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SaidaSerial saidaSerial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SaidaSerial persistentSaidaSerial = em.find(SaidaSerial.class, saidaSerial.getIdSaidaSerial());
            SerialProduto idSerialOld = persistentSaidaSerial.getIdSerial();
            SerialProduto idSerialNew = saidaSerial.getIdSerial();
            if (idSerialNew != null) {
                idSerialNew = em.getReference(idSerialNew.getClass(), idSerialNew.getIdSerial());
                saidaSerial.setIdSerial(idSerialNew);
            }
            saidaSerial = em.merge(saidaSerial);
            if (idSerialOld != null && !idSerialOld.equals(idSerialNew)) {
                idSerialOld.getSaidaSerialCollection().remove(saidaSerial);
                idSerialOld = em.merge(idSerialOld);
            }
            if (idSerialNew != null && !idSerialNew.equals(idSerialOld)) {
                idSerialNew.getSaidaSerialCollection().add(saidaSerial);
                idSerialNew = em.merge(idSerialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = saidaSerial.getIdSaidaSerial();
                if (findSaidaSerial(id) == null) {
                    throw new NonexistentEntityException("The saidaSerial with id " + id + " no longer exists.");
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
            SaidaSerial saidaSerial;
            try {
                saidaSerial = em.getReference(SaidaSerial.class, id);
                saidaSerial.getIdSaidaSerial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The saidaSerial with id " + id + " no longer exists.", enfe);
            }
            SerialProduto idSerial = saidaSerial.getIdSerial();
            if (idSerial != null) {
                idSerial.getSaidaSerialCollection().remove(saidaSerial);
                idSerial = em.merge(idSerial);
            }
            em.remove(saidaSerial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SaidaSerial> findSaidaSerialEntities() {
        return findSaidaSerialEntities(true, -1, -1);
    }

    public List<SaidaSerial> findSaidaSerialEntities(int maxResults, int firstResult) {
        return findSaidaSerialEntities(false, maxResults, firstResult);
    }

    private List<SaidaSerial> findSaidaSerialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SaidaSerial.class));
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

    public SaidaSerial findSaidaSerial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SaidaSerial.class, id);
        } finally {
            em.close();
        }
    }

    public int getSaidaSerialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SaidaSerial> rt = cq.from(SaidaSerial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
