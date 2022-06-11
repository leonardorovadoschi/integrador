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
import entidade.cplus.Cliente;
import entidade.cplus.Clienteabc;
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
public class ClienteabcJpaController implements Serializable {

    public ClienteabcJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clienteabc clienteabc) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Cliente clienteOrphanCheck = clienteabc.getCliente();
        if (clienteOrphanCheck != null) {
            Clienteabc oldClienteabcOfCliente = clienteOrphanCheck.getClienteabc();
            if (oldClienteabcOfCliente != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Cliente " + clienteOrphanCheck + " already has an item of type Clienteabc whose cliente column cannot be null. Please make another selection for the cliente field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = clienteabc.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCodcli());
                clienteabc.setCliente(cliente);
            }
            em.persist(clienteabc);
            if (cliente != null) {
                cliente.setClienteabc(clienteabc);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteabc(clienteabc.getCodcli()) != null) {
                throw new PreexistingEntityException("Clienteabc " + clienteabc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clienteabc clienteabc) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clienteabc persistentClienteabc = em.find(Clienteabc.class, clienteabc.getCodcli());
            Cliente clienteOld = persistentClienteabc.getCliente();
            Cliente clienteNew = clienteabc.getCliente();
            List<String> illegalOrphanMessages = null;
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                Clienteabc oldClienteabcOfCliente = clienteNew.getClienteabc();
                if (oldClienteabcOfCliente != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Cliente " + clienteNew + " already has an item of type Clienteabc whose cliente column cannot be null. Please make another selection for the cliente field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCodcli());
                clienteabc.setCliente(clienteNew);
            }
            clienteabc = em.merge(clienteabc);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.setClienteabc(null);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.setClienteabc(clienteabc);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteabc.getCodcli();
                if (findClienteabc(id) == null) {
                    throw new NonexistentEntityException("The clienteabc with id " + id + " no longer exists.");
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
            Clienteabc clienteabc;
            try {
                clienteabc = em.getReference(Clienteabc.class, id);
                clienteabc.getCodcli();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteabc with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = clienteabc.getCliente();
            if (cliente != null) {
                cliente.setClienteabc(null);
                cliente = em.merge(cliente);
            }
            em.remove(clienteabc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clienteabc> findClienteabcEntities() {
        return findClienteabcEntities(true, -1, -1);
    }

    public List<Clienteabc> findClienteabcEntities(int maxResults, int firstResult) {
        return findClienteabcEntities(false, maxResults, firstResult);
    }

    private List<Clienteabc> findClienteabcEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clienteabc.class));
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

    public Clienteabc findClienteabc(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clienteabc.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteabcCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clienteabc> rt = cq.from(Clienteabc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
