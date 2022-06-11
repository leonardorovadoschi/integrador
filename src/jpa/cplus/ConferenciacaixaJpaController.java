/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Conferenciacaixa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Conferenciacaixaitem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConferenciacaixaJpaController implements Serializable {

    public ConferenciacaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conferenciacaixa conferenciacaixa) throws PreexistingEntityException, Exception {
        if (conferenciacaixa.getConferenciacaixaitemCollection() == null) {
            conferenciacaixa.setConferenciacaixaitemCollection(new ArrayList<Conferenciacaixaitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Conferenciacaixaitem> attachedConferenciacaixaitemCollection = new ArrayList<Conferenciacaixaitem>();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitemToAttach : conferenciacaixa.getConferenciacaixaitemCollection()) {
                conferenciacaixaitemCollectionConferenciacaixaitemToAttach = em.getReference(conferenciacaixaitemCollectionConferenciacaixaitemToAttach.getClass(), conferenciacaixaitemCollectionConferenciacaixaitemToAttach.getCodconferenciacaixaitem());
                attachedConferenciacaixaitemCollection.add(conferenciacaixaitemCollectionConferenciacaixaitemToAttach);
            }
            conferenciacaixa.setConferenciacaixaitemCollection(attachedConferenciacaixaitemCollection);
            em.persist(conferenciacaixa);
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitem : conferenciacaixa.getConferenciacaixaitemCollection()) {
                Conferenciacaixa oldCodconferenciacaixaOfConferenciacaixaitemCollectionConferenciacaixaitem = conferenciacaixaitemCollectionConferenciacaixaitem.getCodconferenciacaixa();
                conferenciacaixaitemCollectionConferenciacaixaitem.setCodconferenciacaixa(conferenciacaixa);
                conferenciacaixaitemCollectionConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionConferenciacaixaitem);
                if (oldCodconferenciacaixaOfConferenciacaixaitemCollectionConferenciacaixaitem != null) {
                    oldCodconferenciacaixaOfConferenciacaixaitemCollectionConferenciacaixaitem.getConferenciacaixaitemCollection().remove(conferenciacaixaitemCollectionConferenciacaixaitem);
                    oldCodconferenciacaixaOfConferenciacaixaitemCollectionConferenciacaixaitem = em.merge(oldCodconferenciacaixaOfConferenciacaixaitemCollectionConferenciacaixaitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConferenciacaixa(conferenciacaixa.getCodconferenciacaixa()) != null) {
                throw new PreexistingEntityException("Conferenciacaixa " + conferenciacaixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conferenciacaixa conferenciacaixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciacaixa persistentConferenciacaixa = em.find(Conferenciacaixa.class, conferenciacaixa.getCodconferenciacaixa());
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollectionOld = persistentConferenciacaixa.getConferenciacaixaitemCollection();
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollectionNew = conferenciacaixa.getConferenciacaixaitemCollection();
            Collection<Conferenciacaixaitem> attachedConferenciacaixaitemCollectionNew = new ArrayList<Conferenciacaixaitem>();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach : conferenciacaixaitemCollectionNew) {
                conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach = em.getReference(conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach.getClass(), conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach.getCodconferenciacaixaitem());
                attachedConferenciacaixaitemCollectionNew.add(conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach);
            }
            conferenciacaixaitemCollectionNew = attachedConferenciacaixaitemCollectionNew;
            conferenciacaixa.setConferenciacaixaitemCollection(conferenciacaixaitemCollectionNew);
            conferenciacaixa = em.merge(conferenciacaixa);
            for (Conferenciacaixaitem conferenciacaixaitemCollectionOldConferenciacaixaitem : conferenciacaixaitemCollectionOld) {
                if (!conferenciacaixaitemCollectionNew.contains(conferenciacaixaitemCollectionOldConferenciacaixaitem)) {
                    conferenciacaixaitemCollectionOldConferenciacaixaitem.setCodconferenciacaixa(null);
                    conferenciacaixaitemCollectionOldConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionOldConferenciacaixaitem);
                }
            }
            for (Conferenciacaixaitem conferenciacaixaitemCollectionNewConferenciacaixaitem : conferenciacaixaitemCollectionNew) {
                if (!conferenciacaixaitemCollectionOld.contains(conferenciacaixaitemCollectionNewConferenciacaixaitem)) {
                    Conferenciacaixa oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem = conferenciacaixaitemCollectionNewConferenciacaixaitem.getCodconferenciacaixa();
                    conferenciacaixaitemCollectionNewConferenciacaixaitem.setCodconferenciacaixa(conferenciacaixa);
                    conferenciacaixaitemCollectionNewConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionNewConferenciacaixaitem);
                    if (oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem != null && !oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem.equals(conferenciacaixa)) {
                        oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem.getConferenciacaixaitemCollection().remove(conferenciacaixaitemCollectionNewConferenciacaixaitem);
                        oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem = em.merge(oldCodconferenciacaixaOfConferenciacaixaitemCollectionNewConferenciacaixaitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conferenciacaixa.getCodconferenciacaixa();
                if (findConferenciacaixa(id) == null) {
                    throw new NonexistentEntityException("The conferenciacaixa with id " + id + " no longer exists.");
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
            Conferenciacaixa conferenciacaixa;
            try {
                conferenciacaixa = em.getReference(Conferenciacaixa.class, id);
                conferenciacaixa.getCodconferenciacaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conferenciacaixa with id " + id + " no longer exists.", enfe);
            }
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollection = conferenciacaixa.getConferenciacaixaitemCollection();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitem : conferenciacaixaitemCollection) {
                conferenciacaixaitemCollectionConferenciacaixaitem.setCodconferenciacaixa(null);
                conferenciacaixaitemCollectionConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionConferenciacaixaitem);
            }
            em.remove(conferenciacaixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conferenciacaixa> findConferenciacaixaEntities() {
        return findConferenciacaixaEntities(true, -1, -1);
    }

    public List<Conferenciacaixa> findConferenciacaixaEntities(int maxResults, int firstResult) {
        return findConferenciacaixaEntities(false, maxResults, firstResult);
    }

    private List<Conferenciacaixa> findConferenciacaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conferenciacaixa.class));
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

    public Conferenciacaixa findConferenciacaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conferenciacaixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getConferenciacaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conferenciacaixa> rt = cq.from(Conferenciacaixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
