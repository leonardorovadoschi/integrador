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
import entidade.cplus.Campousuario;
import entidade.cplus.ClienteequipCampousuario;
import entidade.cplus.Clienteequipamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ClienteequipCampousuarioJpaController implements Serializable {

    public ClienteequipCampousuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteequipCampousuario clienteequipCampousuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campousuario codcampousuario = clienteequipCampousuario.getCodcampousuario();
            if (codcampousuario != null) {
                codcampousuario = em.getReference(codcampousuario.getClass(), codcampousuario.getCodcampousuario());
                clienteequipCampousuario.setCodcampousuario(codcampousuario);
            }
            Clienteequipamento codclienteequipamento = clienteequipCampousuario.getCodclienteequipamento();
            if (codclienteequipamento != null) {
                codclienteequipamento = em.getReference(codclienteequipamento.getClass(), codclienteequipamento.getCodclienteequipamento());
                clienteequipCampousuario.setCodclienteequipamento(codclienteequipamento);
            }
            em.persist(clienteequipCampousuario);
            if (codcampousuario != null) {
                codcampousuario.getClienteequipCampousuarioCollection().add(clienteequipCampousuario);
                codcampousuario = em.merge(codcampousuario);
            }
            if (codclienteequipamento != null) {
                codclienteequipamento.getClienteequipCampousuarioCollection().add(clienteequipCampousuario);
                codclienteequipamento = em.merge(codclienteequipamento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteequipCampousuario(clienteequipCampousuario.getCodclienteequipCampousuario()) != null) {
                throw new PreexistingEntityException("ClienteequipCampousuario " + clienteequipCampousuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteequipCampousuario clienteequipCampousuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClienteequipCampousuario persistentClienteequipCampousuario = em.find(ClienteequipCampousuario.class, clienteequipCampousuario.getCodclienteequipCampousuario());
            Campousuario codcampousuarioOld = persistentClienteequipCampousuario.getCodcampousuario();
            Campousuario codcampousuarioNew = clienteequipCampousuario.getCodcampousuario();
            Clienteequipamento codclienteequipamentoOld = persistentClienteequipCampousuario.getCodclienteequipamento();
            Clienteequipamento codclienteequipamentoNew = clienteequipCampousuario.getCodclienteequipamento();
            if (codcampousuarioNew != null) {
                codcampousuarioNew = em.getReference(codcampousuarioNew.getClass(), codcampousuarioNew.getCodcampousuario());
                clienteequipCampousuario.setCodcampousuario(codcampousuarioNew);
            }
            if (codclienteequipamentoNew != null) {
                codclienteequipamentoNew = em.getReference(codclienteequipamentoNew.getClass(), codclienteequipamentoNew.getCodclienteequipamento());
                clienteequipCampousuario.setCodclienteequipamento(codclienteequipamentoNew);
            }
            clienteequipCampousuario = em.merge(clienteequipCampousuario);
            if (codcampousuarioOld != null && !codcampousuarioOld.equals(codcampousuarioNew)) {
                codcampousuarioOld.getClienteequipCampousuarioCollection().remove(clienteequipCampousuario);
                codcampousuarioOld = em.merge(codcampousuarioOld);
            }
            if (codcampousuarioNew != null && !codcampousuarioNew.equals(codcampousuarioOld)) {
                codcampousuarioNew.getClienteequipCampousuarioCollection().add(clienteequipCampousuario);
                codcampousuarioNew = em.merge(codcampousuarioNew);
            }
            if (codclienteequipamentoOld != null && !codclienteequipamentoOld.equals(codclienteequipamentoNew)) {
                codclienteequipamentoOld.getClienteequipCampousuarioCollection().remove(clienteequipCampousuario);
                codclienteequipamentoOld = em.merge(codclienteequipamentoOld);
            }
            if (codclienteequipamentoNew != null && !codclienteequipamentoNew.equals(codclienteequipamentoOld)) {
                codclienteequipamentoNew.getClienteequipCampousuarioCollection().add(clienteequipCampousuario);
                codclienteequipamentoNew = em.merge(codclienteequipamentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteequipCampousuario.getCodclienteequipCampousuario();
                if (findClienteequipCampousuario(id) == null) {
                    throw new NonexistentEntityException("The clienteequipCampousuario with id " + id + " no longer exists.");
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
            ClienteequipCampousuario clienteequipCampousuario;
            try {
                clienteequipCampousuario = em.getReference(ClienteequipCampousuario.class, id);
                clienteequipCampousuario.getCodclienteequipCampousuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteequipCampousuario with id " + id + " no longer exists.", enfe);
            }
            Campousuario codcampousuario = clienteequipCampousuario.getCodcampousuario();
            if (codcampousuario != null) {
                codcampousuario.getClienteequipCampousuarioCollection().remove(clienteequipCampousuario);
                codcampousuario = em.merge(codcampousuario);
            }
            Clienteequipamento codclienteequipamento = clienteequipCampousuario.getCodclienteequipamento();
            if (codclienteequipamento != null) {
                codclienteequipamento.getClienteequipCampousuarioCollection().remove(clienteequipCampousuario);
                codclienteequipamento = em.merge(codclienteequipamento);
            }
            em.remove(clienteequipCampousuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteequipCampousuario> findClienteequipCampousuarioEntities() {
        return findClienteequipCampousuarioEntities(true, -1, -1);
    }

    public List<ClienteequipCampousuario> findClienteequipCampousuarioEntities(int maxResults, int firstResult) {
        return findClienteequipCampousuarioEntities(false, maxResults, firstResult);
    }

    private List<ClienteequipCampousuario> findClienteequipCampousuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteequipCampousuario.class));
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

    public ClienteequipCampousuario findClienteequipCampousuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteequipCampousuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteequipCampousuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteequipCampousuario> rt = cq.from(ClienteequipCampousuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
