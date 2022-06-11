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
import entidade.cplus.Clienteequipamento;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Clienteproduto;
import entidade.cplus.OsModalidade;
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
public class OsModalidadeJpaController implements Serializable {

    public OsModalidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsModalidade osModalidade) throws PreexistingEntityException, Exception {
        if (osModalidade.getClienteequipamentoCollection() == null) {
            osModalidade.setClienteequipamentoCollection(new ArrayList<Clienteequipamento>());
        }
        if (osModalidade.getClienteprodutoCollection() == null) {
            osModalidade.setClienteprodutoCollection(new ArrayList<Clienteproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Clienteequipamento> attachedClienteequipamentoCollection = new ArrayList<Clienteequipamento>();
            for (Clienteequipamento clienteequipamentoCollectionClienteequipamentoToAttach : osModalidade.getClienteequipamentoCollection()) {
                clienteequipamentoCollectionClienteequipamentoToAttach = em.getReference(clienteequipamentoCollectionClienteequipamentoToAttach.getClass(), clienteequipamentoCollectionClienteequipamentoToAttach.getCodclienteequipamento());
                attachedClienteequipamentoCollection.add(clienteequipamentoCollectionClienteequipamentoToAttach);
            }
            osModalidade.setClienteequipamentoCollection(attachedClienteequipamentoCollection);
            Collection<Clienteproduto> attachedClienteprodutoCollection = new ArrayList<Clienteproduto>();
            for (Clienteproduto clienteprodutoCollectionClienteprodutoToAttach : osModalidade.getClienteprodutoCollection()) {
                clienteprodutoCollectionClienteprodutoToAttach = em.getReference(clienteprodutoCollectionClienteprodutoToAttach.getClass(), clienteprodutoCollectionClienteprodutoToAttach.getCodcliprod());
                attachedClienteprodutoCollection.add(clienteprodutoCollectionClienteprodutoToAttach);
            }
            osModalidade.setClienteprodutoCollection(attachedClienteprodutoCollection);
            em.persist(osModalidade);
            for (Clienteequipamento clienteequipamentoCollectionClienteequipamento : osModalidade.getClienteequipamentoCollection()) {
                OsModalidade oldCodmodOfClienteequipamentoCollectionClienteequipamento = clienteequipamentoCollectionClienteequipamento.getCodmod();
                clienteequipamentoCollectionClienteequipamento.setCodmod(osModalidade);
                clienteequipamentoCollectionClienteequipamento = em.merge(clienteequipamentoCollectionClienteequipamento);
                if (oldCodmodOfClienteequipamentoCollectionClienteequipamento != null) {
                    oldCodmodOfClienteequipamentoCollectionClienteequipamento.getClienteequipamentoCollection().remove(clienteequipamentoCollectionClienteequipamento);
                    oldCodmodOfClienteequipamentoCollectionClienteequipamento = em.merge(oldCodmodOfClienteequipamentoCollectionClienteequipamento);
                }
            }
            for (Clienteproduto clienteprodutoCollectionClienteproduto : osModalidade.getClienteprodutoCollection()) {
                OsModalidade oldCodmodOfClienteprodutoCollectionClienteproduto = clienteprodutoCollectionClienteproduto.getCodmod();
                clienteprodutoCollectionClienteproduto.setCodmod(osModalidade);
                clienteprodutoCollectionClienteproduto = em.merge(clienteprodutoCollectionClienteproduto);
                if (oldCodmodOfClienteprodutoCollectionClienteproduto != null) {
                    oldCodmodOfClienteprodutoCollectionClienteproduto.getClienteprodutoCollection().remove(clienteprodutoCollectionClienteproduto);
                    oldCodmodOfClienteprodutoCollectionClienteproduto = em.merge(oldCodmodOfClienteprodutoCollectionClienteproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsModalidade(osModalidade.getCodmod()) != null) {
                throw new PreexistingEntityException("OsModalidade " + osModalidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsModalidade osModalidade) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsModalidade persistentOsModalidade = em.find(OsModalidade.class, osModalidade.getCodmod());
            Collection<Clienteequipamento> clienteequipamentoCollectionOld = persistentOsModalidade.getClienteequipamentoCollection();
            Collection<Clienteequipamento> clienteequipamentoCollectionNew = osModalidade.getClienteequipamentoCollection();
            Collection<Clienteproduto> clienteprodutoCollectionOld = persistentOsModalidade.getClienteprodutoCollection();
            Collection<Clienteproduto> clienteprodutoCollectionNew = osModalidade.getClienteprodutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Clienteproduto clienteprodutoCollectionOldClienteproduto : clienteprodutoCollectionOld) {
                if (!clienteprodutoCollectionNew.contains(clienteprodutoCollectionOldClienteproduto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Clienteproduto " + clienteprodutoCollectionOldClienteproduto + " since its codmod field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Clienteequipamento> attachedClienteequipamentoCollectionNew = new ArrayList<Clienteequipamento>();
            for (Clienteequipamento clienteequipamentoCollectionNewClienteequipamentoToAttach : clienteequipamentoCollectionNew) {
                clienteequipamentoCollectionNewClienteequipamentoToAttach = em.getReference(clienteequipamentoCollectionNewClienteequipamentoToAttach.getClass(), clienteequipamentoCollectionNewClienteequipamentoToAttach.getCodclienteequipamento());
                attachedClienteequipamentoCollectionNew.add(clienteequipamentoCollectionNewClienteequipamentoToAttach);
            }
            clienteequipamentoCollectionNew = attachedClienteequipamentoCollectionNew;
            osModalidade.setClienteequipamentoCollection(clienteequipamentoCollectionNew);
            Collection<Clienteproduto> attachedClienteprodutoCollectionNew = new ArrayList<Clienteproduto>();
            for (Clienteproduto clienteprodutoCollectionNewClienteprodutoToAttach : clienteprodutoCollectionNew) {
                clienteprodutoCollectionNewClienteprodutoToAttach = em.getReference(clienteprodutoCollectionNewClienteprodutoToAttach.getClass(), clienteprodutoCollectionNewClienteprodutoToAttach.getCodcliprod());
                attachedClienteprodutoCollectionNew.add(clienteprodutoCollectionNewClienteprodutoToAttach);
            }
            clienteprodutoCollectionNew = attachedClienteprodutoCollectionNew;
            osModalidade.setClienteprodutoCollection(clienteprodutoCollectionNew);
            osModalidade = em.merge(osModalidade);
            for (Clienteequipamento clienteequipamentoCollectionOldClienteequipamento : clienteequipamentoCollectionOld) {
                if (!clienteequipamentoCollectionNew.contains(clienteequipamentoCollectionOldClienteequipamento)) {
                    clienteequipamentoCollectionOldClienteequipamento.setCodmod(null);
                    clienteequipamentoCollectionOldClienteequipamento = em.merge(clienteequipamentoCollectionOldClienteequipamento);
                }
            }
            for (Clienteequipamento clienteequipamentoCollectionNewClienteequipamento : clienteequipamentoCollectionNew) {
                if (!clienteequipamentoCollectionOld.contains(clienteequipamentoCollectionNewClienteequipamento)) {
                    OsModalidade oldCodmodOfClienteequipamentoCollectionNewClienteequipamento = clienteequipamentoCollectionNewClienteequipamento.getCodmod();
                    clienteequipamentoCollectionNewClienteequipamento.setCodmod(osModalidade);
                    clienteequipamentoCollectionNewClienteequipamento = em.merge(clienteequipamentoCollectionNewClienteequipamento);
                    if (oldCodmodOfClienteequipamentoCollectionNewClienteequipamento != null && !oldCodmodOfClienteequipamentoCollectionNewClienteequipamento.equals(osModalidade)) {
                        oldCodmodOfClienteequipamentoCollectionNewClienteequipamento.getClienteequipamentoCollection().remove(clienteequipamentoCollectionNewClienteequipamento);
                        oldCodmodOfClienteequipamentoCollectionNewClienteequipamento = em.merge(oldCodmodOfClienteequipamentoCollectionNewClienteequipamento);
                    }
                }
            }
            for (Clienteproduto clienteprodutoCollectionNewClienteproduto : clienteprodutoCollectionNew) {
                if (!clienteprodutoCollectionOld.contains(clienteprodutoCollectionNewClienteproduto)) {
                    OsModalidade oldCodmodOfClienteprodutoCollectionNewClienteproduto = clienteprodutoCollectionNewClienteproduto.getCodmod();
                    clienteprodutoCollectionNewClienteproduto.setCodmod(osModalidade);
                    clienteprodutoCollectionNewClienteproduto = em.merge(clienteprodutoCollectionNewClienteproduto);
                    if (oldCodmodOfClienteprodutoCollectionNewClienteproduto != null && !oldCodmodOfClienteprodutoCollectionNewClienteproduto.equals(osModalidade)) {
                        oldCodmodOfClienteprodutoCollectionNewClienteproduto.getClienteprodutoCollection().remove(clienteprodutoCollectionNewClienteproduto);
                        oldCodmodOfClienteprodutoCollectionNewClienteproduto = em.merge(oldCodmodOfClienteprodutoCollectionNewClienteproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osModalidade.getCodmod();
                if (findOsModalidade(id) == null) {
                    throw new NonexistentEntityException("The osModalidade with id " + id + " no longer exists.");
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
            OsModalidade osModalidade;
            try {
                osModalidade = em.getReference(OsModalidade.class, id);
                osModalidade.getCodmod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osModalidade with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Clienteproduto> clienteprodutoCollectionOrphanCheck = osModalidade.getClienteprodutoCollection();
            for (Clienteproduto clienteprodutoCollectionOrphanCheckClienteproduto : clienteprodutoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsModalidade (" + osModalidade + ") cannot be destroyed since the Clienteproduto " + clienteprodutoCollectionOrphanCheckClienteproduto + " in its clienteprodutoCollection field has a non-nullable codmod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Clienteequipamento> clienteequipamentoCollection = osModalidade.getClienteequipamentoCollection();
            for (Clienteequipamento clienteequipamentoCollectionClienteequipamento : clienteequipamentoCollection) {
                clienteequipamentoCollectionClienteequipamento.setCodmod(null);
                clienteequipamentoCollectionClienteequipamento = em.merge(clienteequipamentoCollectionClienteequipamento);
            }
            em.remove(osModalidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsModalidade> findOsModalidadeEntities() {
        return findOsModalidadeEntities(true, -1, -1);
    }

    public List<OsModalidade> findOsModalidadeEntities(int maxResults, int firstResult) {
        return findOsModalidadeEntities(false, maxResults, firstResult);
    }

    private List<OsModalidade> findOsModalidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsModalidade.class));
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

    public OsModalidade findOsModalidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsModalidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsModalidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsModalidade> rt = cq.from(OsModalidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
