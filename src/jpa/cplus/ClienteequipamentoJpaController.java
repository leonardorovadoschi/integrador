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
import entidade.cplus.OsModalidade;
import entidade.cplus.ClienteequipCampousuario;
import entidade.cplus.Clienteequipamento;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsOrdemservico;
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
public class ClienteequipamentoJpaController implements Serializable {

    public ClienteequipamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clienteequipamento clienteequipamento) throws PreexistingEntityException, Exception {
        if (clienteequipamento.getClienteequipCampousuarioCollection() == null) {
            clienteequipamento.setClienteequipCampousuarioCollection(new ArrayList<ClienteequipCampousuario>());
        }
        if (clienteequipamento.getOsOrdemservicoCollection() == null) {
            clienteequipamento.setOsOrdemservicoCollection(new ArrayList<OsOrdemservico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = clienteequipamento.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                clienteequipamento.setCodcli(codcli);
            }
            OsModalidade codmod = clienteequipamento.getCodmod();
            if (codmod != null) {
                codmod = em.getReference(codmod.getClass(), codmod.getCodmod());
                clienteequipamento.setCodmod(codmod);
            }
            Collection<ClienteequipCampousuario> attachedClienteequipCampousuarioCollection = new ArrayList<ClienteequipCampousuario>();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach : clienteequipamento.getClienteequipCampousuarioCollection()) {
                clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach = em.getReference(clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach.getClass(), clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach.getCodclienteequipCampousuario());
                attachedClienteequipCampousuarioCollection.add(clienteequipCampousuarioCollectionClienteequipCampousuarioToAttach);
            }
            clienteequipamento.setClienteequipCampousuarioCollection(attachedClienteequipCampousuarioCollection);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollection = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservicoToAttach : clienteequipamento.getOsOrdemservicoCollection()) {
                osOrdemservicoCollectionOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollection.add(osOrdemservicoCollectionOsOrdemservicoToAttach);
            }
            clienteequipamento.setOsOrdemservicoCollection(attachedOsOrdemservicoCollection);
            em.persist(clienteequipamento);
            if (codcli != null) {
                codcli.getClienteequipamentoCollection().add(clienteequipamento);
                codcli = em.merge(codcli);
            }
            if (codmod != null) {
                codmod.getClienteequipamentoCollection().add(clienteequipamento);
                codmod = em.merge(codmod);
            }
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionClienteequipCampousuario : clienteequipamento.getClienteequipCampousuarioCollection()) {
                Clienteequipamento oldCodclienteequipamentoOfClienteequipCampousuarioCollectionClienteequipCampousuario = clienteequipCampousuarioCollectionClienteequipCampousuario.getCodclienteequipamento();
                clienteequipCampousuarioCollectionClienteequipCampousuario.setCodclienteequipamento(clienteequipamento);
                clienteequipCampousuarioCollectionClienteequipCampousuario = em.merge(clienteequipCampousuarioCollectionClienteequipCampousuario);
                if (oldCodclienteequipamentoOfClienteequipCampousuarioCollectionClienteequipCampousuario != null) {
                    oldCodclienteequipamentoOfClienteequipCampousuarioCollectionClienteequipCampousuario.getClienteequipCampousuarioCollection().remove(clienteequipCampousuarioCollectionClienteequipCampousuario);
                    oldCodclienteequipamentoOfClienteequipCampousuarioCollectionClienteequipCampousuario = em.merge(oldCodclienteequipamentoOfClienteequipCampousuarioCollectionClienteequipCampousuario);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : clienteequipamento.getOsOrdemservicoCollection()) {
                Clienteequipamento oldCodclienteequipamentoOfOsOrdemservicoCollectionOsOrdemservico = osOrdemservicoCollectionOsOrdemservico.getCodclienteequipamento();
                osOrdemservicoCollectionOsOrdemservico.setCodclienteequipamento(clienteequipamento);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
                if (oldCodclienteequipamentoOfOsOrdemservicoCollectionOsOrdemservico != null) {
                    oldCodclienteequipamentoOfOsOrdemservicoCollectionOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionOsOrdemservico);
                    oldCodclienteequipamentoOfOsOrdemservicoCollectionOsOrdemservico = em.merge(oldCodclienteequipamentoOfOsOrdemservicoCollectionOsOrdemservico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteequipamento(clienteequipamento.getCodclienteequipamento()) != null) {
                throw new PreexistingEntityException("Clienteequipamento " + clienteequipamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clienteequipamento clienteequipamento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clienteequipamento persistentClienteequipamento = em.find(Clienteequipamento.class, clienteequipamento.getCodclienteequipamento());
            Cliente codcliOld = persistentClienteequipamento.getCodcli();
            Cliente codcliNew = clienteequipamento.getCodcli();
            OsModalidade codmodOld = persistentClienteequipamento.getCodmod();
            OsModalidade codmodNew = clienteequipamento.getCodmod();
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionOld = persistentClienteequipamento.getClienteequipCampousuarioCollection();
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionNew = clienteequipamento.getClienteequipCampousuarioCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionOld = persistentClienteequipamento.getOsOrdemservicoCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionNew = clienteequipamento.getOsOrdemservicoCollection();
            List<String> illegalOrphanMessages = null;
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionOldClienteequipCampousuario : clienteequipCampousuarioCollectionOld) {
                if (!clienteequipCampousuarioCollectionNew.contains(clienteequipCampousuarioCollectionOldClienteequipCampousuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ClienteequipCampousuario " + clienteequipCampousuarioCollectionOldClienteequipCampousuario + " since its codclienteequipamento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                clienteequipamento.setCodcli(codcliNew);
            }
            if (codmodNew != null) {
                codmodNew = em.getReference(codmodNew.getClass(), codmodNew.getCodmod());
                clienteequipamento.setCodmod(codmodNew);
            }
            Collection<ClienteequipCampousuario> attachedClienteequipCampousuarioCollectionNew = new ArrayList<ClienteequipCampousuario>();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach : clienteequipCampousuarioCollectionNew) {
                clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach = em.getReference(clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach.getClass(), clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach.getCodclienteequipCampousuario());
                attachedClienteequipCampousuarioCollectionNew.add(clienteequipCampousuarioCollectionNewClienteequipCampousuarioToAttach);
            }
            clienteequipCampousuarioCollectionNew = attachedClienteequipCampousuarioCollectionNew;
            clienteequipamento.setClienteequipCampousuarioCollection(clienteequipCampousuarioCollectionNew);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollectionNew = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservicoToAttach : osOrdemservicoCollectionNew) {
                osOrdemservicoCollectionNewOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionNewOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionNewOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollectionNew.add(osOrdemservicoCollectionNewOsOrdemservicoToAttach);
            }
            osOrdemservicoCollectionNew = attachedOsOrdemservicoCollectionNew;
            clienteequipamento.setOsOrdemservicoCollection(osOrdemservicoCollectionNew);
            clienteequipamento = em.merge(clienteequipamento);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getClienteequipamentoCollection().remove(clienteequipamento);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getClienteequipamentoCollection().add(clienteequipamento);
                codcliNew = em.merge(codcliNew);
            }
            if (codmodOld != null && !codmodOld.equals(codmodNew)) {
                codmodOld.getClienteequipamentoCollection().remove(clienteequipamento);
                codmodOld = em.merge(codmodOld);
            }
            if (codmodNew != null && !codmodNew.equals(codmodOld)) {
                codmodNew.getClienteequipamentoCollection().add(clienteequipamento);
                codmodNew = em.merge(codmodNew);
            }
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionNewClienteequipCampousuario : clienteequipCampousuarioCollectionNew) {
                if (!clienteequipCampousuarioCollectionOld.contains(clienteequipCampousuarioCollectionNewClienteequipCampousuario)) {
                    Clienteequipamento oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario = clienteequipCampousuarioCollectionNewClienteequipCampousuario.getCodclienteequipamento();
                    clienteequipCampousuarioCollectionNewClienteequipCampousuario.setCodclienteequipamento(clienteequipamento);
                    clienteequipCampousuarioCollectionNewClienteequipCampousuario = em.merge(clienteequipCampousuarioCollectionNewClienteequipCampousuario);
                    if (oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario != null && !oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario.equals(clienteequipamento)) {
                        oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario.getClienteequipCampousuarioCollection().remove(clienteequipCampousuarioCollectionNewClienteequipCampousuario);
                        oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario = em.merge(oldCodclienteequipamentoOfClienteequipCampousuarioCollectionNewClienteequipCampousuario);
                    }
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOldOsOrdemservico : osOrdemservicoCollectionOld) {
                if (!osOrdemservicoCollectionNew.contains(osOrdemservicoCollectionOldOsOrdemservico)) {
                    osOrdemservicoCollectionOldOsOrdemservico.setCodclienteequipamento(null);
                    osOrdemservicoCollectionOldOsOrdemservico = em.merge(osOrdemservicoCollectionOldOsOrdemservico);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservico : osOrdemservicoCollectionNew) {
                if (!osOrdemservicoCollectionOld.contains(osOrdemservicoCollectionNewOsOrdemservico)) {
                    Clienteequipamento oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico = osOrdemservicoCollectionNewOsOrdemservico.getCodclienteequipamento();
                    osOrdemservicoCollectionNewOsOrdemservico.setCodclienteequipamento(clienteequipamento);
                    osOrdemservicoCollectionNewOsOrdemservico = em.merge(osOrdemservicoCollectionNewOsOrdemservico);
                    if (oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico != null && !oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico.equals(clienteequipamento)) {
                        oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionNewOsOrdemservico);
                        oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico = em.merge(oldCodclienteequipamentoOfOsOrdemservicoCollectionNewOsOrdemservico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteequipamento.getCodclienteequipamento();
                if (findClienteequipamento(id) == null) {
                    throw new NonexistentEntityException("The clienteequipamento with id " + id + " no longer exists.");
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
            Clienteequipamento clienteequipamento;
            try {
                clienteequipamento = em.getReference(Clienteequipamento.class, id);
                clienteequipamento.getCodclienteequipamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteequipamento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ClienteequipCampousuario> clienteequipCampousuarioCollectionOrphanCheck = clienteequipamento.getClienteequipCampousuarioCollection();
            for (ClienteequipCampousuario clienteequipCampousuarioCollectionOrphanCheckClienteequipCampousuario : clienteequipCampousuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clienteequipamento (" + clienteequipamento + ") cannot be destroyed since the ClienteequipCampousuario " + clienteequipCampousuarioCollectionOrphanCheckClienteequipCampousuario + " in its clienteequipCampousuarioCollection field has a non-nullable codclienteequipamento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente codcli = clienteequipamento.getCodcli();
            if (codcli != null) {
                codcli.getClienteequipamentoCollection().remove(clienteequipamento);
                codcli = em.merge(codcli);
            }
            OsModalidade codmod = clienteequipamento.getCodmod();
            if (codmod != null) {
                codmod.getClienteequipamentoCollection().remove(clienteequipamento);
                codmod = em.merge(codmod);
            }
            Collection<OsOrdemservico> osOrdemservicoCollection = clienteequipamento.getOsOrdemservicoCollection();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : osOrdemservicoCollection) {
                osOrdemservicoCollectionOsOrdemservico.setCodclienteequipamento(null);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
            }
            em.remove(clienteequipamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clienteequipamento> findClienteequipamentoEntities() {
        return findClienteequipamentoEntities(true, -1, -1);
    }

    public List<Clienteequipamento> findClienteequipamentoEntities(int maxResults, int firstResult) {
        return findClienteequipamentoEntities(false, maxResults, firstResult);
    }

    private List<Clienteequipamento> findClienteequipamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clienteequipamento.class));
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

    public Clienteequipamento findClienteequipamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clienteequipamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteequipamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clienteequipamento> rt = cq.from(Clienteequipamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
