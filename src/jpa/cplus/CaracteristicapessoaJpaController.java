/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Caracteristicapessoa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Clientecaracteristica;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Vendedorcaracteristica;
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
public class CaracteristicapessoaJpaController implements Serializable {

    public CaracteristicapessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caracteristicapessoa caracteristicapessoa) throws PreexistingEntityException, Exception {
        if (caracteristicapessoa.getClientecaracteristicaCollection() == null) {
            caracteristicapessoa.setClientecaracteristicaCollection(new ArrayList<Clientecaracteristica>());
        }
        if (caracteristicapessoa.getVendedorcaracteristicaCollection() == null) {
            caracteristicapessoa.setVendedorcaracteristicaCollection(new ArrayList<Vendedorcaracteristica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Clientecaracteristica> attachedClientecaracteristicaCollection = new ArrayList<Clientecaracteristica>();
            for (Clientecaracteristica clientecaracteristicaCollectionClientecaracteristicaToAttach : caracteristicapessoa.getClientecaracteristicaCollection()) {
                clientecaracteristicaCollectionClientecaracteristicaToAttach = em.getReference(clientecaracteristicaCollectionClientecaracteristicaToAttach.getClass(), clientecaracteristicaCollectionClientecaracteristicaToAttach.getCodclientecaracteristica());
                attachedClientecaracteristicaCollection.add(clientecaracteristicaCollectionClientecaracteristicaToAttach);
            }
            caracteristicapessoa.setClientecaracteristicaCollection(attachedClientecaracteristicaCollection);
            Collection<Vendedorcaracteristica> attachedVendedorcaracteristicaCollection = new ArrayList<Vendedorcaracteristica>();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach : caracteristicapessoa.getVendedorcaracteristicaCollection()) {
                vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach = em.getReference(vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach.getClass(), vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach.getCodvendedorcaracteristica());
                attachedVendedorcaracteristicaCollection.add(vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach);
            }
            caracteristicapessoa.setVendedorcaracteristicaCollection(attachedVendedorcaracteristicaCollection);
            em.persist(caracteristicapessoa);
            for (Clientecaracteristica clientecaracteristicaCollectionClientecaracteristica : caracteristicapessoa.getClientecaracteristicaCollection()) {
                Caracteristicapessoa oldCodcaracteristicapessoaOfClientecaracteristicaCollectionClientecaracteristica = clientecaracteristicaCollectionClientecaracteristica.getCodcaracteristicapessoa();
                clientecaracteristicaCollectionClientecaracteristica.setCodcaracteristicapessoa(caracteristicapessoa);
                clientecaracteristicaCollectionClientecaracteristica = em.merge(clientecaracteristicaCollectionClientecaracteristica);
                if (oldCodcaracteristicapessoaOfClientecaracteristicaCollectionClientecaracteristica != null) {
                    oldCodcaracteristicapessoaOfClientecaracteristicaCollectionClientecaracteristica.getClientecaracteristicaCollection().remove(clientecaracteristicaCollectionClientecaracteristica);
                    oldCodcaracteristicapessoaOfClientecaracteristicaCollectionClientecaracteristica = em.merge(oldCodcaracteristicapessoaOfClientecaracteristicaCollectionClientecaracteristica);
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionVendedorcaracteristica : caracteristicapessoa.getVendedorcaracteristicaCollection()) {
                Caracteristicapessoa oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionVendedorcaracteristica = vendedorcaracteristicaCollectionVendedorcaracteristica.getCodcaracteristicapessoa();
                vendedorcaracteristicaCollectionVendedorcaracteristica.setCodcaracteristicapessoa(caracteristicapessoa);
                vendedorcaracteristicaCollectionVendedorcaracteristica = em.merge(vendedorcaracteristicaCollectionVendedorcaracteristica);
                if (oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionVendedorcaracteristica != null) {
                    oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionVendedorcaracteristica.getVendedorcaracteristicaCollection().remove(vendedorcaracteristicaCollectionVendedorcaracteristica);
                    oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionVendedorcaracteristica = em.merge(oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionVendedorcaracteristica);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCaracteristicapessoa(caracteristicapessoa.getCodcaracteristicapessoa()) != null) {
                throw new PreexistingEntityException("Caracteristicapessoa " + caracteristicapessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caracteristicapessoa caracteristicapessoa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caracteristicapessoa persistentCaracteristicapessoa = em.find(Caracteristicapessoa.class, caracteristicapessoa.getCodcaracteristicapessoa());
            Collection<Clientecaracteristica> clientecaracteristicaCollectionOld = persistentCaracteristicapessoa.getClientecaracteristicaCollection();
            Collection<Clientecaracteristica> clientecaracteristicaCollectionNew = caracteristicapessoa.getClientecaracteristicaCollection();
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionOld = persistentCaracteristicapessoa.getVendedorcaracteristicaCollection();
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionNew = caracteristicapessoa.getVendedorcaracteristicaCollection();
            List<String> illegalOrphanMessages = null;
            for (Clientecaracteristica clientecaracteristicaCollectionOldClientecaracteristica : clientecaracteristicaCollectionOld) {
                if (!clientecaracteristicaCollectionNew.contains(clientecaracteristicaCollectionOldClientecaracteristica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Clientecaracteristica " + clientecaracteristicaCollectionOldClientecaracteristica + " since its codcaracteristicapessoa field is not nullable.");
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionOldVendedorcaracteristica : vendedorcaracteristicaCollectionOld) {
                if (!vendedorcaracteristicaCollectionNew.contains(vendedorcaracteristicaCollectionOldVendedorcaracteristica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendedorcaracteristica " + vendedorcaracteristicaCollectionOldVendedorcaracteristica + " since its codcaracteristicapessoa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Clientecaracteristica> attachedClientecaracteristicaCollectionNew = new ArrayList<Clientecaracteristica>();
            for (Clientecaracteristica clientecaracteristicaCollectionNewClientecaracteristicaToAttach : clientecaracteristicaCollectionNew) {
                clientecaracteristicaCollectionNewClientecaracteristicaToAttach = em.getReference(clientecaracteristicaCollectionNewClientecaracteristicaToAttach.getClass(), clientecaracteristicaCollectionNewClientecaracteristicaToAttach.getCodclientecaracteristica());
                attachedClientecaracteristicaCollectionNew.add(clientecaracteristicaCollectionNewClientecaracteristicaToAttach);
            }
            clientecaracteristicaCollectionNew = attachedClientecaracteristicaCollectionNew;
            caracteristicapessoa.setClientecaracteristicaCollection(clientecaracteristicaCollectionNew);
            Collection<Vendedorcaracteristica> attachedVendedorcaracteristicaCollectionNew = new ArrayList<Vendedorcaracteristica>();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach : vendedorcaracteristicaCollectionNew) {
                vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach = em.getReference(vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach.getClass(), vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach.getCodvendedorcaracteristica());
                attachedVendedorcaracteristicaCollectionNew.add(vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach);
            }
            vendedorcaracteristicaCollectionNew = attachedVendedorcaracteristicaCollectionNew;
            caracteristicapessoa.setVendedorcaracteristicaCollection(vendedorcaracteristicaCollectionNew);
            caracteristicapessoa = em.merge(caracteristicapessoa);
            for (Clientecaracteristica clientecaracteristicaCollectionNewClientecaracteristica : clientecaracteristicaCollectionNew) {
                if (!clientecaracteristicaCollectionOld.contains(clientecaracteristicaCollectionNewClientecaracteristica)) {
                    Caracteristicapessoa oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica = clientecaracteristicaCollectionNewClientecaracteristica.getCodcaracteristicapessoa();
                    clientecaracteristicaCollectionNewClientecaracteristica.setCodcaracteristicapessoa(caracteristicapessoa);
                    clientecaracteristicaCollectionNewClientecaracteristica = em.merge(clientecaracteristicaCollectionNewClientecaracteristica);
                    if (oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica != null && !oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica.equals(caracteristicapessoa)) {
                        oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica.getClientecaracteristicaCollection().remove(clientecaracteristicaCollectionNewClientecaracteristica);
                        oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica = em.merge(oldCodcaracteristicapessoaOfClientecaracteristicaCollectionNewClientecaracteristica);
                    }
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionNewVendedorcaracteristica : vendedorcaracteristicaCollectionNew) {
                if (!vendedorcaracteristicaCollectionOld.contains(vendedorcaracteristicaCollectionNewVendedorcaracteristica)) {
                    Caracteristicapessoa oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica = vendedorcaracteristicaCollectionNewVendedorcaracteristica.getCodcaracteristicapessoa();
                    vendedorcaracteristicaCollectionNewVendedorcaracteristica.setCodcaracteristicapessoa(caracteristicapessoa);
                    vendedorcaracteristicaCollectionNewVendedorcaracteristica = em.merge(vendedorcaracteristicaCollectionNewVendedorcaracteristica);
                    if (oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica != null && !oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica.equals(caracteristicapessoa)) {
                        oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica.getVendedorcaracteristicaCollection().remove(vendedorcaracteristicaCollectionNewVendedorcaracteristica);
                        oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica = em.merge(oldCodcaracteristicapessoaOfVendedorcaracteristicaCollectionNewVendedorcaracteristica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = caracteristicapessoa.getCodcaracteristicapessoa();
                if (findCaracteristicapessoa(id) == null) {
                    throw new NonexistentEntityException("The caracteristicapessoa with id " + id + " no longer exists.");
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
            Caracteristicapessoa caracteristicapessoa;
            try {
                caracteristicapessoa = em.getReference(Caracteristicapessoa.class, id);
                caracteristicapessoa.getCodcaracteristicapessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caracteristicapessoa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Clientecaracteristica> clientecaracteristicaCollectionOrphanCheck = caracteristicapessoa.getClientecaracteristicaCollection();
            for (Clientecaracteristica clientecaracteristicaCollectionOrphanCheckClientecaracteristica : clientecaracteristicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Caracteristicapessoa (" + caracteristicapessoa + ") cannot be destroyed since the Clientecaracteristica " + clientecaracteristicaCollectionOrphanCheckClientecaracteristica + " in its clientecaracteristicaCollection field has a non-nullable codcaracteristicapessoa field.");
            }
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionOrphanCheck = caracteristicapessoa.getVendedorcaracteristicaCollection();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionOrphanCheckVendedorcaracteristica : vendedorcaracteristicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Caracteristicapessoa (" + caracteristicapessoa + ") cannot be destroyed since the Vendedorcaracteristica " + vendedorcaracteristicaCollectionOrphanCheckVendedorcaracteristica + " in its vendedorcaracteristicaCollection field has a non-nullable codcaracteristicapessoa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(caracteristicapessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caracteristicapessoa> findCaracteristicapessoaEntities() {
        return findCaracteristicapessoaEntities(true, -1, -1);
    }

    public List<Caracteristicapessoa> findCaracteristicapessoaEntities(int maxResults, int firstResult) {
        return findCaracteristicapessoaEntities(false, maxResults, firstResult);
    }

    private List<Caracteristicapessoa> findCaracteristicapessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caracteristicapessoa.class));
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

    public Caracteristicapessoa findCaracteristicapessoa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caracteristicapessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getCaracteristicapessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caracteristicapessoa> rt = cq.from(Caracteristicapessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
