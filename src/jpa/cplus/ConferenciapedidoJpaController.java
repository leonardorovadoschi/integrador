/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Conferenciapedido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Conferenciapedidoitens;
import java.util.ArrayList;
import java.util.Collection;
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
public class ConferenciapedidoJpaController implements Serializable {

    public ConferenciapedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conferenciapedido conferenciapedido) throws PreexistingEntityException, Exception {
        if (conferenciapedido.getConferenciapedidoitensCollection() == null) {
            conferenciapedido.setConferenciapedidoitensCollection(new ArrayList<Conferenciapedidoitens>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Conferenciapedidoitens> attachedConferenciapedidoitensCollection = new ArrayList<Conferenciapedidoitens>();
            for (Conferenciapedidoitens conferenciapedidoitensCollectionConferenciapedidoitensToAttach : conferenciapedido.getConferenciapedidoitensCollection()) {
                conferenciapedidoitensCollectionConferenciapedidoitensToAttach = em.getReference(conferenciapedidoitensCollectionConferenciapedidoitensToAttach.getClass(), conferenciapedidoitensCollectionConferenciapedidoitensToAttach.getCodconferenciapedidoitens());
                attachedConferenciapedidoitensCollection.add(conferenciapedidoitensCollectionConferenciapedidoitensToAttach);
            }
            conferenciapedido.setConferenciapedidoitensCollection(attachedConferenciapedidoitensCollection);
            em.persist(conferenciapedido);
            for (Conferenciapedidoitens conferenciapedidoitensCollectionConferenciapedidoitens : conferenciapedido.getConferenciapedidoitensCollection()) {
                Conferenciapedido oldCodconferenciapedidoOfConferenciapedidoitensCollectionConferenciapedidoitens = conferenciapedidoitensCollectionConferenciapedidoitens.getCodconferenciapedido();
                conferenciapedidoitensCollectionConferenciapedidoitens.setCodconferenciapedido(conferenciapedido);
                conferenciapedidoitensCollectionConferenciapedidoitens = em.merge(conferenciapedidoitensCollectionConferenciapedidoitens);
                if (oldCodconferenciapedidoOfConferenciapedidoitensCollectionConferenciapedidoitens != null) {
                    oldCodconferenciapedidoOfConferenciapedidoitensCollectionConferenciapedidoitens.getConferenciapedidoitensCollection().remove(conferenciapedidoitensCollectionConferenciapedidoitens);
                    oldCodconferenciapedidoOfConferenciapedidoitensCollectionConferenciapedidoitens = em.merge(oldCodconferenciapedidoOfConferenciapedidoitensCollectionConferenciapedidoitens);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConferenciapedido(conferenciapedido.getCodconferenciapedido()) != null) {
                throw new PreexistingEntityException("Conferenciapedido " + conferenciapedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conferenciapedido conferenciapedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciapedido persistentConferenciapedido = em.find(Conferenciapedido.class, conferenciapedido.getCodconferenciapedido());
            Collection<Conferenciapedidoitens> conferenciapedidoitensCollectionOld = persistentConferenciapedido.getConferenciapedidoitensCollection();
            Collection<Conferenciapedidoitens> conferenciapedidoitensCollectionNew = conferenciapedido.getConferenciapedidoitensCollection();
            List<String> illegalOrphanMessages = null;
            for (Conferenciapedidoitens conferenciapedidoitensCollectionOldConferenciapedidoitens : conferenciapedidoitensCollectionOld) {
                if (!conferenciapedidoitensCollectionNew.contains(conferenciapedidoitensCollectionOldConferenciapedidoitens)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Conferenciapedidoitens " + conferenciapedidoitensCollectionOldConferenciapedidoitens + " since its codconferenciapedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Conferenciapedidoitens> attachedConferenciapedidoitensCollectionNew = new ArrayList<Conferenciapedidoitens>();
            for (Conferenciapedidoitens conferenciapedidoitensCollectionNewConferenciapedidoitensToAttach : conferenciapedidoitensCollectionNew) {
                conferenciapedidoitensCollectionNewConferenciapedidoitensToAttach = em.getReference(conferenciapedidoitensCollectionNewConferenciapedidoitensToAttach.getClass(), conferenciapedidoitensCollectionNewConferenciapedidoitensToAttach.getCodconferenciapedidoitens());
                attachedConferenciapedidoitensCollectionNew.add(conferenciapedidoitensCollectionNewConferenciapedidoitensToAttach);
            }
            conferenciapedidoitensCollectionNew = attachedConferenciapedidoitensCollectionNew;
            conferenciapedido.setConferenciapedidoitensCollection(conferenciapedidoitensCollectionNew);
            conferenciapedido = em.merge(conferenciapedido);
            for (Conferenciapedidoitens conferenciapedidoitensCollectionNewConferenciapedidoitens : conferenciapedidoitensCollectionNew) {
                if (!conferenciapedidoitensCollectionOld.contains(conferenciapedidoitensCollectionNewConferenciapedidoitens)) {
                    Conferenciapedido oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens = conferenciapedidoitensCollectionNewConferenciapedidoitens.getCodconferenciapedido();
                    conferenciapedidoitensCollectionNewConferenciapedidoitens.setCodconferenciapedido(conferenciapedido);
                    conferenciapedidoitensCollectionNewConferenciapedidoitens = em.merge(conferenciapedidoitensCollectionNewConferenciapedidoitens);
                    if (oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens != null && !oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens.equals(conferenciapedido)) {
                        oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens.getConferenciapedidoitensCollection().remove(conferenciapedidoitensCollectionNewConferenciapedidoitens);
                        oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens = em.merge(oldCodconferenciapedidoOfConferenciapedidoitensCollectionNewConferenciapedidoitens);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conferenciapedido.getCodconferenciapedido();
                if (findConferenciapedido(id) == null) {
                    throw new NonexistentEntityException("The conferenciapedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciapedido conferenciapedido;
            try {
                conferenciapedido = em.getReference(Conferenciapedido.class, id);
                conferenciapedido.getCodconferenciapedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conferenciapedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Conferenciapedidoitens> conferenciapedidoitensCollectionOrphanCheck = conferenciapedido.getConferenciapedidoitensCollection();
            for (Conferenciapedidoitens conferenciapedidoitensCollectionOrphanCheckConferenciapedidoitens : conferenciapedidoitensCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Conferenciapedido (" + conferenciapedido + ") cannot be destroyed since the Conferenciapedidoitens " + conferenciapedidoitensCollectionOrphanCheckConferenciapedidoitens + " in its conferenciapedidoitensCollection field has a non-nullable codconferenciapedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(conferenciapedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conferenciapedido> findConferenciapedidoEntities() {
        return findConferenciapedidoEntities(true, -1, -1);
    }

    public List<Conferenciapedido> findConferenciapedidoEntities(int maxResults, int firstResult) {
        return findConferenciapedidoEntities(false, maxResults, firstResult);
    }

    private List<Conferenciapedido> findConferenciapedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conferenciapedido.class));
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

    public Conferenciapedido findConferenciapedido(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conferenciapedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getConferenciapedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conferenciapedido> rt = cq.from(Conferenciapedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
