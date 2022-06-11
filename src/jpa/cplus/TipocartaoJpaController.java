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
import entidade.cplus.Lancacartao;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Cliente;
import entidade.cplus.Tipocartao;
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
public class TipocartaoJpaController implements Serializable {

    public TipocartaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipocartao tipocartao) throws PreexistingEntityException, Exception {
        if (tipocartao.getLancacartaoCollection() == null) {
            tipocartao.setLancacartaoCollection(new ArrayList<Lancacartao>());
        }
        if (tipocartao.getClienteCollection() == null) {
            tipocartao.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Lancacartao> attachedLancacartaoCollection = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionLancacartaoToAttach : tipocartao.getLancacartaoCollection()) {
                lancacartaoCollectionLancacartaoToAttach = em.getReference(lancacartaoCollectionLancacartaoToAttach.getClass(), lancacartaoCollectionLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollection.add(lancacartaoCollectionLancacartaoToAttach);
            }
            tipocartao.setLancacartaoCollection(attachedLancacartaoCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : tipocartao.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            tipocartao.setClienteCollection(attachedClienteCollection);
            em.persist(tipocartao);
            for (Lancacartao lancacartaoCollectionLancacartao : tipocartao.getLancacartaoCollection()) {
                Tipocartao oldCodcarOfLancacartaoCollectionLancacartao = lancacartaoCollectionLancacartao.getCodcar();
                lancacartaoCollectionLancacartao.setCodcar(tipocartao);
                lancacartaoCollectionLancacartao = em.merge(lancacartaoCollectionLancacartao);
                if (oldCodcarOfLancacartaoCollectionLancacartao != null) {
                    oldCodcarOfLancacartaoCollectionLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionLancacartao);
                    oldCodcarOfLancacartaoCollectionLancacartao = em.merge(oldCodcarOfLancacartaoCollectionLancacartao);
                }
            }
            for (Cliente clienteCollectionCliente : tipocartao.getClienteCollection()) {
                Tipocartao oldCodcarOfClienteCollectionCliente = clienteCollectionCliente.getCodcar();
                clienteCollectionCliente.setCodcar(tipocartao);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodcarOfClienteCollectionCliente != null) {
                    oldCodcarOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodcarOfClienteCollectionCliente = em.merge(oldCodcarOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipocartao(tipocartao.getCodcar()) != null) {
                throw new PreexistingEntityException("Tipocartao " + tipocartao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipocartao tipocartao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipocartao persistentTipocartao = em.find(Tipocartao.class, tipocartao.getCodcar());
            Collection<Lancacartao> lancacartaoCollectionOld = persistentTipocartao.getLancacartaoCollection();
            Collection<Lancacartao> lancacartaoCollectionNew = tipocartao.getLancacartaoCollection();
            Collection<Cliente> clienteCollectionOld = persistentTipocartao.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = tipocartao.getClienteCollection();
            List<String> illegalOrphanMessages = null;
            for (Lancacartao lancacartaoCollectionOldLancacartao : lancacartaoCollectionOld) {
                if (!lancacartaoCollectionNew.contains(lancacartaoCollectionOldLancacartao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lancacartao " + lancacartaoCollectionOldLancacartao + " since its codcar field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Lancacartao> attachedLancacartaoCollectionNew = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionNewLancacartaoToAttach : lancacartaoCollectionNew) {
                lancacartaoCollectionNewLancacartaoToAttach = em.getReference(lancacartaoCollectionNewLancacartaoToAttach.getClass(), lancacartaoCollectionNewLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollectionNew.add(lancacartaoCollectionNewLancacartaoToAttach);
            }
            lancacartaoCollectionNew = attachedLancacartaoCollectionNew;
            tipocartao.setLancacartaoCollection(lancacartaoCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            tipocartao.setClienteCollection(clienteCollectionNew);
            tipocartao = em.merge(tipocartao);
            for (Lancacartao lancacartaoCollectionNewLancacartao : lancacartaoCollectionNew) {
                if (!lancacartaoCollectionOld.contains(lancacartaoCollectionNewLancacartao)) {
                    Tipocartao oldCodcarOfLancacartaoCollectionNewLancacartao = lancacartaoCollectionNewLancacartao.getCodcar();
                    lancacartaoCollectionNewLancacartao.setCodcar(tipocartao);
                    lancacartaoCollectionNewLancacartao = em.merge(lancacartaoCollectionNewLancacartao);
                    if (oldCodcarOfLancacartaoCollectionNewLancacartao != null && !oldCodcarOfLancacartaoCollectionNewLancacartao.equals(tipocartao)) {
                        oldCodcarOfLancacartaoCollectionNewLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionNewLancacartao);
                        oldCodcarOfLancacartaoCollectionNewLancacartao = em.merge(oldCodcarOfLancacartaoCollectionNewLancacartao);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodcar(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Tipocartao oldCodcarOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodcar();
                    clienteCollectionNewCliente.setCodcar(tipocartao);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodcarOfClienteCollectionNewCliente != null && !oldCodcarOfClienteCollectionNewCliente.equals(tipocartao)) {
                        oldCodcarOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodcarOfClienteCollectionNewCliente = em.merge(oldCodcarOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipocartao.getCodcar();
                if (findTipocartao(id) == null) {
                    throw new NonexistentEntityException("The tipocartao with id " + id + " no longer exists.");
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
            Tipocartao tipocartao;
            try {
                tipocartao = em.getReference(Tipocartao.class, id);
                tipocartao.getCodcar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipocartao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Lancacartao> lancacartaoCollectionOrphanCheck = tipocartao.getLancacartaoCollection();
            for (Lancacartao lancacartaoCollectionOrphanCheckLancacartao : lancacartaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipocartao (" + tipocartao + ") cannot be destroyed since the Lancacartao " + lancacartaoCollectionOrphanCheckLancacartao + " in its lancacartaoCollection field has a non-nullable codcar field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cliente> clienteCollection = tipocartao.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodcar(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(tipocartao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipocartao> findTipocartaoEntities() {
        return findTipocartaoEntities(true, -1, -1);
    }

    public List<Tipocartao> findTipocartaoEntities(int maxResults, int firstResult) {
        return findTipocartaoEntities(false, maxResults, firstResult);
    }

    private List<Tipocartao> findTipocartaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipocartao.class));
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

    public Tipocartao findTipocartao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipocartao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipocartaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipocartao> rt = cq.from(Tipocartao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
