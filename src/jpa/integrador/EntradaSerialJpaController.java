/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.integrador;

import entidade.integrador.EntradaSerial;
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
public class EntradaSerialJpaController implements Serializable {

    public EntradaSerialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EntradaSerial entradaSerial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SerialProduto idSerial = entradaSerial.getIdSerial();
            if (idSerial != null) {
                idSerial = em.getReference(idSerial.getClass(), idSerial.getIdSerial());
                entradaSerial.setIdSerial(idSerial);
            }
            em.persist(entradaSerial);
            if (idSerial != null) {
                idSerial.getEntradaSerialCollection().add(entradaSerial);
                idSerial = em.merge(idSerial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EntradaSerial entradaSerial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EntradaSerial persistentEntradaSerial = em.find(EntradaSerial.class, entradaSerial.getIdEntradaSerial());
            SerialProduto idSerialOld = persistentEntradaSerial.getIdSerial();
            SerialProduto idSerialNew = entradaSerial.getIdSerial();
            if (idSerialNew != null) {
                idSerialNew = em.getReference(idSerialNew.getClass(), idSerialNew.getIdSerial());
                entradaSerial.setIdSerial(idSerialNew);
            }
            entradaSerial = em.merge(entradaSerial);
            if (idSerialOld != null && !idSerialOld.equals(idSerialNew)) {
                idSerialOld.getEntradaSerialCollection().remove(entradaSerial);
                idSerialOld = em.merge(idSerialOld);
            }
            if (idSerialNew != null && !idSerialNew.equals(idSerialOld)) {
                idSerialNew.getEntradaSerialCollection().add(entradaSerial);
                idSerialNew = em.merge(idSerialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entradaSerial.getIdEntradaSerial();
                if (findEntradaSerial(id) == null) {
                    throw new NonexistentEntityException("The entradaSerial with id " + id + " no longer exists.");
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
            EntradaSerial entradaSerial;
            try {
                entradaSerial = em.getReference(EntradaSerial.class, id);
                entradaSerial.getIdEntradaSerial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entradaSerial with id " + id + " no longer exists.", enfe);
            }
            SerialProduto idSerial = entradaSerial.getIdSerial();
            if (idSerial != null) {
                idSerial.getEntradaSerialCollection().remove(entradaSerial);
                idSerial = em.merge(idSerial);
            }
            em.remove(entradaSerial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EntradaSerial> findEntradaSerialEntities() {
        return findEntradaSerialEntities(true, -1, -1);
    }

    public List<EntradaSerial> findEntradaSerialEntities(int maxResults, int firstResult) {
        return findEntradaSerialEntities(false, maxResults, firstResult);
    }

    private List<EntradaSerial> findEntradaSerialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EntradaSerial.class));
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

    public EntradaSerial findEntradaSerial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EntradaSerial.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntradaSerialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EntradaSerial> rt = cq.from(EntradaSerial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
