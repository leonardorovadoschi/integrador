/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Campousuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.ClienteequipCampousuario;
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
public class CampousuarioJpaController implements Serializable {

    public CampousuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Campousuario campousuario) throws PreexistingEntityException, Exception {
        if (campousuario.getClienteequipCampousuarioCollection() == null) {
            campousuario.setClienteequipCampousuarioCollection(new ArrayList<ClienteequipCampousuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ClienteequipCampousuario> attachedClienteequipCampousuarioCollection = new ArrayList<ClienteequipCampousuario>();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach : campousuario.getClienteequipCampousuarioCollection()) {
                clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach = em.getReference(clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach.getClass(), clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach.getCodclienteequipCampousuario());
                attachedClienteequipCampousuarioCollection.add(clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach);
            }
            campousuario.setClienteequipCampousuarioCollection(attachedClienteequipCampousuarioCollection);
            em.persist(campousuario);
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionClienteequipCampousuario : campousuario.getClienteequipCampousuarioCollection()) {
                Campousuario oldCodcampousuarioOfClienteequipCampousuarioCollectionClienteequipCampousuario = clienteequipCampousuarioCollectionClienteequipCampousuario.getCodcampousuario();
                clienteequipCampousuarioCollectionClienteequipCampousuario.setCodcampousuario(campousuario);
                clienteequipCampousuarioCollectionClienteequipCampousuario = em.merge(clienteequipCampousuarioCollectionClienteequipCampousuario);
                if (oldCodcampousuarioOfClienteequipCampousuarioCollectionClienteequipCampousuario != null) {
                    oldCodcampousuarioOfClienteequipCampousuarioCollectionClienteequipCampousuario.getClienteequipCampousuarioCollection().remove(clienteequipCampousuarioCollectionClienteequipCampousuario);
                    oldCodcampousuarioOfClienteequipCampousuarioCollectionClienteequipCampousuario = em.merge(oldCodcampousuarioOfClienteequipCampousuarioCollectionClienteequipCampousuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCampousuario(campousuario.getCodcampousuario()) != null) {
                throw new PreexistingEntityException("Campousuario " + campousuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Campousuario campousuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campousuario persistentCampousuario = em.find(Campousuario.class, campousuario.getCodcampousuario());
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionOld = persistentCampousuario.getClienteequipCampousuarioCollection();
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionNew = campousuario.getClienteequipCampousuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionOldClienteequipCampousuario : clienteequipCampousuarioCollectionOld) {
                if (!clienteequipCampousuarioCollectionNew.contains(clienteequipCampousuarioCollectionOldClienteequipCampousuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ClienteequipCampousuario " + clienteequipCampousuarioCollectionOldClienteequipCampousuario + " since its codcampousuario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ClienteequipCampousuario> attachedClienteequipCampousuarioCollectionNew = new ArrayList<ClienteequipCampousuario>();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach : clienteequipCampousuarioCollectionNew) {
                clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach = em.getReference(clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach.getClass(), clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach.getCodclienteequipCampousuario());
                attachedClienteequipCampousuarioCollectionNew.add(clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach);
            }
            clienteequipCampousuarioCollectionNew = attachedClienteequipCampousuarioCollectionNew;
            campousuario.setClienteequipCampousuarioCollection(clienteequipCampousuarioCollectionNew);
            campousuario = em.merge(campousuario);
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionNewClienteequipCampousuario : clienteequipCampousuarioCollectionNew) {
                if (!clienteequipCampousuarioCollectionOld.contains(clienteequipCampousuarioCollectionNewClienteequipCampousuario)) {
                    Campousuario oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario = clienteequipCampousuarioCollectionNewClienteequipCampousuario.getCodcampousuario();
                    clienteequipCampousuarioCollectionNewClienteequipCampousuario.setCodcampousuario(campousuario);
                    clienteequipCampousuarioCollectionNewClienteequipCampousuario = em.merge(clienteequipCampousuarioCollectionNewClienteequipCampousuario);
                    if (oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario != null && !oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario.equals(campousuario)) {
                        oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario.getClienteequipCampousuarioCollection().remove(clienteequipCampousuarioCollectionNewClienteequipCampousuario);
                        oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario = em.merge(oldCodcampousuarioOfClienteequipCampousuarioCollectionNewClienteequipCampousuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = campousuario.getCodcampousuario();
                if (findCampousuario(id) == null) {
                    throw new NonexistentEntityException("The campousuario with id " + id + " no longer exists.");
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
            Campousuario campousuario;
            try {
                campousuario = em.getReference(Campousuario.class, id);
                campousuario.getCodcampousuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The campousuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionOrphanCheck = campousuario.getClienteequipCampousuarioCollection();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionOrphanCheckClienteequipCampousuario : clienteequipCampousuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Campousuario (" + campousuario + ") cannot be destroyed since the ClienteequipCampousuario " + clienteequipCampousuarioCollectionOrphanCheckClienteequipCampousuario + " in its clienteequipCampousuarioCollection field has a non-nullable codcampousuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(campousuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Campousuario> findCampousuarioEntities() {
        return findCampousuarioEntities(true, -1, -1);
    }

    public List<Campousuario> findCampousuarioEntities(int maxResults, int firstResult) {
        return findCampousuarioEntities(false, maxResults, firstResult);
    }

    private List<Campousuario> findCampousuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Campousuario.class));
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

    public Campousuario findCampousuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Campousuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getCampousuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Campousuario> rt = cq.from(Campousuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
