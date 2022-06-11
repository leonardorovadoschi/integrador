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
import entidade.cplus.Clienteendereco;
import entidade.cplus.Tipoendereco;
import entidade.cplus.OsOrdemservico;
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
public class ClienteenderecoJpaController implements Serializable {

    public ClienteenderecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clienteendereco clienteendereco) throws PreexistingEntityException, Exception {
        if (clienteendereco.getOsOrdemservicoCollection() == null) {
            clienteendereco.setOsOrdemservicoCollection(new ArrayList<OsOrdemservico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = clienteendereco.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                clienteendereco.setCodcli(codcli);
            }
            Tipoendereco codtipoendereco = clienteendereco.getCodtipoendereco();
            if (codtipoendereco != null) {
                codtipoendereco = em.getReference(codtipoendereco.getClass(), codtipoendereco.getCodtipoendereco());
                clienteendereco.setCodtipoendereco(codtipoendereco);
            }
            Collection<OsOrdemservico> attachedOsOrdemservicoCollection = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservicoToAttach : clienteendereco.getOsOrdemservicoCollection()) {
                osOrdemservicoCollectionOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollection.add(osOrdemservicoCollectionOsOrdemservicoToAttach);
            }
            clienteendereco.setOsOrdemservicoCollection(attachedOsOrdemservicoCollection);
            em.persist(clienteendereco);
            if (codcli != null) {
                codcli.getClienteenderecoCollection().add(clienteendereco);
                codcli = em.merge(codcli);
            }
            if (codtipoendereco != null) {
                codtipoendereco.getClienteenderecoCollection().add(clienteendereco);
                codtipoendereco = em.merge(codtipoendereco);
            }
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : clienteendereco.getOsOrdemservicoCollection()) {
                Clienteendereco oldCodclienteenderecoOfOsOrdemservicoCollectionOsOrdemservico = osOrdemservicoCollectionOsOrdemservico.getCodclienteendereco();
                osOrdemservicoCollectionOsOrdemservico.setCodclienteendereco(clienteendereco);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
                if (oldCodclienteenderecoOfOsOrdemservicoCollectionOsOrdemservico != null) {
                    oldCodclienteenderecoOfOsOrdemservicoCollectionOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionOsOrdemservico);
                    oldCodclienteenderecoOfOsOrdemservicoCollectionOsOrdemservico = em.merge(oldCodclienteenderecoOfOsOrdemservicoCollectionOsOrdemservico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteendereco(clienteendereco.getCodclienteendereco()) != null) {
                throw new PreexistingEntityException("Clienteendereco " + clienteendereco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clienteendereco clienteendereco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clienteendereco persistentClienteendereco = em.find(Clienteendereco.class, clienteendereco.getCodclienteendereco());
            Cliente codcliOld = persistentClienteendereco.getCodcli();
            Cliente codcliNew = clienteendereco.getCodcli();
            Tipoendereco codtipoenderecoOld = persistentClienteendereco.getCodtipoendereco();
            Tipoendereco codtipoenderecoNew = clienteendereco.getCodtipoendereco();
            Collection<OsOrdemservico> osOrdemservicoCollectionOld = persistentClienteendereco.getOsOrdemservicoCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionNew = clienteendereco.getOsOrdemservicoCollection();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                clienteendereco.setCodcli(codcliNew);
            }
            if (codtipoenderecoNew != null) {
                codtipoenderecoNew = em.getReference(codtipoenderecoNew.getClass(), codtipoenderecoNew.getCodtipoendereco());
                clienteendereco.setCodtipoendereco(codtipoenderecoNew);
            }
            Collection<OsOrdemservico> attachedOsOrdemservicoCollectionNew = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservicoToAttach : osOrdemservicoCollectionNew) {
                osOrdemservicoCollectionNewOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionNewOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionNewOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollectionNew.add(osOrdemservicoCollectionNewOsOrdemservicoToAttach);
            }
            osOrdemservicoCollectionNew = attachedOsOrdemservicoCollectionNew;
            clienteendereco.setOsOrdemservicoCollection(osOrdemservicoCollectionNew);
            clienteendereco = em.merge(clienteendereco);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getClienteenderecoCollection().remove(clienteendereco);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getClienteenderecoCollection().add(clienteendereco);
                codcliNew = em.merge(codcliNew);
            }
            if (codtipoenderecoOld != null && !codtipoenderecoOld.equals(codtipoenderecoNew)) {
                codtipoenderecoOld.getClienteenderecoCollection().remove(clienteendereco);
                codtipoenderecoOld = em.merge(codtipoenderecoOld);
            }
            if (codtipoenderecoNew != null && !codtipoenderecoNew.equals(codtipoenderecoOld)) {
                codtipoenderecoNew.getClienteenderecoCollection().add(clienteendereco);
                codtipoenderecoNew = em.merge(codtipoenderecoNew);
            }
            for (OsOrdemservico osOrdemservicoCollectionOldOsOrdemservico : osOrdemservicoCollectionOld) {
                if (!osOrdemservicoCollectionNew.contains(osOrdemservicoCollectionOldOsOrdemservico)) {
                    osOrdemservicoCollectionOldOsOrdemservico.setCodclienteendereco(null);
                    osOrdemservicoCollectionOldOsOrdemservico = em.merge(osOrdemservicoCollectionOldOsOrdemservico);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservico : osOrdemservicoCollectionNew) {
                if (!osOrdemservicoCollectionOld.contains(osOrdemservicoCollectionNewOsOrdemservico)) {
                    Clienteendereco oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico = osOrdemservicoCollectionNewOsOrdemservico.getCodclienteendereco();
                    osOrdemservicoCollectionNewOsOrdemservico.setCodclienteendereco(clienteendereco);
                    osOrdemservicoCollectionNewOsOrdemservico = em.merge(osOrdemservicoCollectionNewOsOrdemservico);
                    if (oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico != null && !oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico.equals(clienteendereco)) {
                        oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionNewOsOrdemservico);
                        oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico = em.merge(oldCodclienteenderecoOfOsOrdemservicoCollectionNewOsOrdemservico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteendereco.getCodclienteendereco();
                if (findClienteendereco(id) == null) {
                    throw new NonexistentEntityException("The clienteendereco with id " + id + " no longer exists.");
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
            Clienteendereco clienteendereco;
            try {
                clienteendereco = em.getReference(Clienteendereco.class, id);
                clienteendereco.getCodclienteendereco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteendereco with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = clienteendereco.getCodcli();
            if (codcli != null) {
                codcli.getClienteenderecoCollection().remove(clienteendereco);
                codcli = em.merge(codcli);
            }
            Tipoendereco codtipoendereco = clienteendereco.getCodtipoendereco();
            if (codtipoendereco != null) {
                codtipoendereco.getClienteenderecoCollection().remove(clienteendereco);
                codtipoendereco = em.merge(codtipoendereco);
            }
            Collection<OsOrdemservico> osOrdemservicoCollection = clienteendereco.getOsOrdemservicoCollection();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : osOrdemservicoCollection) {
                osOrdemservicoCollectionOsOrdemservico.setCodclienteendereco(null);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
            }
            em.remove(clienteendereco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clienteendereco> findClienteenderecoEntities() {
        return findClienteenderecoEntities(true, -1, -1);
    }

    public List<Clienteendereco> findClienteenderecoEntities(int maxResults, int firstResult) {
        return findClienteenderecoEntities(false, maxResults, firstResult);
    }

    private List<Clienteendereco> findClienteenderecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clienteendereco.class));
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

    public Clienteendereco findClienteendereco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clienteendereco.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteenderecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clienteendereco> rt = cq.from(Clienteendereco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
