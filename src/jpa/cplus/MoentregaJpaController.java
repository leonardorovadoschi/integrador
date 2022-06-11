/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentrega;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movenda;
import entidade.cplus.Transportadora;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoentregaJpaController implements Serializable {

    public MoentregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentrega moentrega) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Movenda movendaOrphanCheck = moentrega.getMovenda();
        if (movendaOrphanCheck != null) {
            Moentrega oldMoentregaOfMovenda = movendaOrphanCheck.getMoentrega();
            if (oldMoentregaOfMovenda != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Movenda " + movendaOrphanCheck + " already has an item of type Moentrega whose movenda column cannot be null. Please make another selection for the movenda field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda movenda = moentrega.getMovenda();
            if (movenda != null) {
                movenda = em.getReference(movenda.getClass(), movenda.getCodmovenda());
                moentrega.setMovenda(movenda);
            }
            Transportadora codtrans = moentrega.getCodtrans();
            if (codtrans != null) {
                codtrans = em.getReference(codtrans.getClass(), codtrans.getCodtrans());
                moentrega.setCodtrans(codtrans);
            }
            em.persist(moentrega);
            if (movenda != null) {
                movenda.setMoentrega(moentrega);
                movenda = em.merge(movenda);
            }
            if (codtrans != null) {
                codtrans.getMoentregaCollection().add(moentrega);
                codtrans = em.merge(codtrans);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentrega(moentrega.getCodmovenda()) != null) {
                throw new PreexistingEntityException("Moentrega " + moentrega + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentrega moentrega) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moentrega persistentMoentrega = em.find(Moentrega.class, moentrega.getCodmovenda());
            Movenda movendaOld = persistentMoentrega.getMovenda();
            Movenda movendaNew = moentrega.getMovenda();
            Transportadora codtransOld = persistentMoentrega.getCodtrans();
            Transportadora codtransNew = moentrega.getCodtrans();
            List<String> illegalOrphanMessages = null;
            if (movendaNew != null && !movendaNew.equals(movendaOld)) {
                Moentrega oldMoentregaOfMovenda = movendaNew.getMoentrega();
                if (oldMoentregaOfMovenda != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Movenda " + movendaNew + " already has an item of type Moentrega whose movenda column cannot be null. Please make another selection for the movenda field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (movendaNew != null) {
                movendaNew = em.getReference(movendaNew.getClass(), movendaNew.getCodmovenda());
                moentrega.setMovenda(movendaNew);
            }
            if (codtransNew != null) {
                codtransNew = em.getReference(codtransNew.getClass(), codtransNew.getCodtrans());
                moentrega.setCodtrans(codtransNew);
            }
            moentrega = em.merge(moentrega);
            if (movendaOld != null && !movendaOld.equals(movendaNew)) {
                movendaOld.setMoentrega(null);
                movendaOld = em.merge(movendaOld);
            }
            if (movendaNew != null && !movendaNew.equals(movendaOld)) {
                movendaNew.setMoentrega(moentrega);
                movendaNew = em.merge(movendaNew);
            }
            if (codtransOld != null && !codtransOld.equals(codtransNew)) {
                codtransOld.getMoentregaCollection().remove(moentrega);
                codtransOld = em.merge(codtransOld);
            }
            if (codtransNew != null && !codtransNew.equals(codtransOld)) {
                codtransNew.getMoentregaCollection().add(moentrega);
                codtransNew = em.merge(codtransNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moentrega.getCodmovenda();
                if (findMoentrega(id) == null) {
                    throw new NonexistentEntityException("The moentrega with id " + id + " no longer exists.");
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
            Moentrega moentrega;
            try {
                moentrega = em.getReference(Moentrega.class, id);
                moentrega.getCodmovenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentrega with id " + id + " no longer exists.", enfe);
            }
            Movenda movenda = moentrega.getMovenda();
            if (movenda != null) {
                movenda.setMoentrega(null);
                movenda = em.merge(movenda);
            }
            Transportadora codtrans = moentrega.getCodtrans();
            if (codtrans != null) {
                codtrans.getMoentregaCollection().remove(moentrega);
                codtrans = em.merge(codtrans);
            }
            em.remove(moentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentrega> findMoentregaEntities() {
        return findMoentregaEntities(true, -1, -1);
    }

    public List<Moentrega> findMoentregaEntities(int maxResults, int firstResult) {
        return findMoentregaEntities(false, maxResults, firstResult);
    }

    private List<Moentrega> findMoentregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentrega.class));
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

    public Moentrega findMoentrega(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentrega> rt = cq.from(Moentrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
