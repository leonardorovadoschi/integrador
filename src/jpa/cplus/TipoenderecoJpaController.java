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
import entidade.cplus.Clienteendereco;
import entidade.cplus.Tipoendereco;
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
public class TipoenderecoJpaController implements Serializable {

    public TipoenderecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoendereco tipoendereco) throws PreexistingEntityException, Exception {
        if (tipoendereco.getClienteenderecoCollection() == null) {
            tipoendereco.setClienteenderecoCollection(new ArrayList<Clienteendereco>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Clienteendereco> attachedClienteenderecoCollection = new ArrayList<Clienteendereco>();
            for (Clienteendereco clienteenderecoCollectionClienteenderecoToAttach : tipoendereco.getClienteenderecoCollection()) {
                clienteenderecoCollectionClienteenderecoToAttach = em.getReference(clienteenderecoCollectionClienteenderecoToAttach.getClass(), clienteenderecoCollectionClienteenderecoToAttach.getCodclienteendereco());
                attachedClienteenderecoCollection.add(clienteenderecoCollectionClienteenderecoToAttach);
            }
            tipoendereco.setClienteenderecoCollection(attachedClienteenderecoCollection);
            em.persist(tipoendereco);
            for (Clienteendereco clienteenderecoCollectionClienteendereco : tipoendereco.getClienteenderecoCollection()) {
                Tipoendereco oldCodtipoenderecoOfClienteenderecoCollectionClienteendereco = clienteenderecoCollectionClienteendereco.getCodtipoendereco();
                clienteenderecoCollectionClienteendereco.setCodtipoendereco(tipoendereco);
                clienteenderecoCollectionClienteendereco = em.merge(clienteenderecoCollectionClienteendereco);
                if (oldCodtipoenderecoOfClienteenderecoCollectionClienteendereco != null) {
                    oldCodtipoenderecoOfClienteenderecoCollectionClienteendereco.getClienteenderecoCollection().remove(clienteenderecoCollectionClienteendereco);
                    oldCodtipoenderecoOfClienteenderecoCollectionClienteendereco = em.merge(oldCodtipoenderecoOfClienteenderecoCollectionClienteendereco);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoendereco(tipoendereco.getCodtipoendereco()) != null) {
                throw new PreexistingEntityException("Tipoendereco " + tipoendereco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoendereco tipoendereco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoendereco persistentTipoendereco = em.find(Tipoendereco.class, tipoendereco.getCodtipoendereco());
            Collection<Clienteendereco> clienteenderecoCollectionOld = persistentTipoendereco.getClienteenderecoCollection();
            Collection<Clienteendereco> clienteenderecoCollectionNew = tipoendereco.getClienteenderecoCollection();
            Collection<Clienteendereco> attachedClienteenderecoCollectionNew = new ArrayList<Clienteendereco>();
            for (Clienteendereco clienteenderecoCollectionNewClienteenderecoToAttach : clienteenderecoCollectionNew) {
                clienteenderecoCollectionNewClienteenderecoToAttach = em.getReference(clienteenderecoCollectionNewClienteenderecoToAttach.getClass(), clienteenderecoCollectionNewClienteenderecoToAttach.getCodclienteendereco());
                attachedClienteenderecoCollectionNew.add(clienteenderecoCollectionNewClienteenderecoToAttach);
            }
            clienteenderecoCollectionNew = attachedClienteenderecoCollectionNew;
            tipoendereco.setClienteenderecoCollection(clienteenderecoCollectionNew);
            tipoendereco = em.merge(tipoendereco);
            for (Clienteendereco clienteenderecoCollectionOldClienteendereco : clienteenderecoCollectionOld) {
                if (!clienteenderecoCollectionNew.contains(clienteenderecoCollectionOldClienteendereco)) {
                    clienteenderecoCollectionOldClienteendereco.setCodtipoendereco(null);
                    clienteenderecoCollectionOldClienteendereco = em.merge(clienteenderecoCollectionOldClienteendereco);
                }
            }
            for (Clienteendereco clienteenderecoCollectionNewClienteendereco : clienteenderecoCollectionNew) {
                if (!clienteenderecoCollectionOld.contains(clienteenderecoCollectionNewClienteendereco)) {
                    Tipoendereco oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco = clienteenderecoCollectionNewClienteendereco.getCodtipoendereco();
                    clienteenderecoCollectionNewClienteendereco.setCodtipoendereco(tipoendereco);
                    clienteenderecoCollectionNewClienteendereco = em.merge(clienteenderecoCollectionNewClienteendereco);
                    if (oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco != null && !oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco.equals(tipoendereco)) {
                        oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco.getClienteenderecoCollection().remove(clienteenderecoCollectionNewClienteendereco);
                        oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco = em.merge(oldCodtipoenderecoOfClienteenderecoCollectionNewClienteendereco);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoendereco.getCodtipoendereco();
                if (findTipoendereco(id) == null) {
                    throw new NonexistentEntityException("The tipoendereco with id " + id + " no longer exists.");
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
            Tipoendereco tipoendereco;
            try {
                tipoendereco = em.getReference(Tipoendereco.class, id);
                tipoendereco.getCodtipoendereco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoendereco with id " + id + " no longer exists.", enfe);
            }
            Collection<Clienteendereco> clienteenderecoCollection = tipoendereco.getClienteenderecoCollection();
            for (Clienteendereco clienteenderecoCollectionClienteendereco : clienteenderecoCollection) {
                clienteenderecoCollectionClienteendereco.setCodtipoendereco(null);
                clienteenderecoCollectionClienteendereco = em.merge(clienteenderecoCollectionClienteendereco);
            }
            em.remove(tipoendereco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoendereco> findTipoenderecoEntities() {
        return findTipoenderecoEntities(true, -1, -1);
    }

    public List<Tipoendereco> findTipoenderecoEntities(int maxResults, int firstResult) {
        return findTipoenderecoEntities(false, maxResults, firstResult);
    }

    private List<Tipoendereco> findTipoenderecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoendereco.class));
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

    public Tipoendereco findTipoendereco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoendereco.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoenderecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoendereco> rt = cq.from(Tipoendereco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
