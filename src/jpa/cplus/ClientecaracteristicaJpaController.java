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
import entidade.cplus.Caracteristicapessoa;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ClientecaracteristicaJpaController implements Serializable {

    public ClientecaracteristicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientecaracteristica clientecaracteristica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caracteristicapessoa codcaracteristicapessoa = clientecaracteristica.getCodcaracteristicapessoa();
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa = em.getReference(codcaracteristicapessoa.getClass(), codcaracteristicapessoa.getCodcaracteristicapessoa());
                clientecaracteristica.setCodcaracteristicapessoa(codcaracteristicapessoa);
            }
            Cliente codcli = clientecaracteristica.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                clientecaracteristica.setCodcli(codcli);
            }
            em.persist(clientecaracteristica);
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa.getClientecaracteristicaCollection().add(clientecaracteristica);
                codcaracteristicapessoa = em.merge(codcaracteristicapessoa);
            }
            if (codcli != null) {
                codcli.getClientecaracteristicaCollection().add(clientecaracteristica);
                codcli = em.merge(codcli);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientecaracteristica(clientecaracteristica.getCodclientecaracteristica()) != null) {
                throw new PreexistingEntityException("Clientecaracteristica " + clientecaracteristica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientecaracteristica clientecaracteristica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientecaracteristica persistentClientecaracteristica = em.find(Clientecaracteristica.class, clientecaracteristica.getCodclientecaracteristica());
            Caracteristicapessoa codcaracteristicapessoaOld = persistentClientecaracteristica.getCodcaracteristicapessoa();
            Caracteristicapessoa codcaracteristicapessoaNew = clientecaracteristica.getCodcaracteristicapessoa();
            Cliente codcliOld = persistentClientecaracteristica.getCodcli();
            Cliente codcliNew = clientecaracteristica.getCodcli();
            if (codcaracteristicapessoaNew != null) {
                codcaracteristicapessoaNew = em.getReference(codcaracteristicapessoaNew.getClass(), codcaracteristicapessoaNew.getCodcaracteristicapessoa());
                clientecaracteristica.setCodcaracteristicapessoa(codcaracteristicapessoaNew);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                clientecaracteristica.setCodcli(codcliNew);
            }
            clientecaracteristica = em.merge(clientecaracteristica);
            if (codcaracteristicapessoaOld != null && !codcaracteristicapessoaOld.equals(codcaracteristicapessoaNew)) {
                codcaracteristicapessoaOld.getClientecaracteristicaCollection().remove(clientecaracteristica);
                codcaracteristicapessoaOld = em.merge(codcaracteristicapessoaOld);
            }
            if (codcaracteristicapessoaNew != null && !codcaracteristicapessoaNew.equals(codcaracteristicapessoaOld)) {
                codcaracteristicapessoaNew.getClientecaracteristicaCollection().add(clientecaracteristica);
                codcaracteristicapessoaNew = em.merge(codcaracteristicapessoaNew);
            }
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getClientecaracteristicaCollection().remove(clientecaracteristica);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getClientecaracteristicaCollection().add(clientecaracteristica);
                codcliNew = em.merge(codcliNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clientecaracteristica.getCodclientecaracteristica();
                if (findClientecaracteristica(id) == null) {
                    throw new NonexistentEntityException("The clientecaracteristica with id " + id + " no longer exists.");
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
            Clientecaracteristica clientecaracteristica;
            try {
                clientecaracteristica = em.getReference(Clientecaracteristica.class, id);
                clientecaracteristica.getCodclientecaracteristica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientecaracteristica with id " + id + " no longer exists.", enfe);
            }
            Caracteristicapessoa codcaracteristicapessoa = clientecaracteristica.getCodcaracteristicapessoa();
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa.getClientecaracteristicaCollection().remove(clientecaracteristica);
                codcaracteristicapessoa = em.merge(codcaracteristicapessoa);
            }
            Cliente codcli = clientecaracteristica.getCodcli();
            if (codcli != null) {
                codcli.getClientecaracteristicaCollection().remove(clientecaracteristica);
                codcli = em.merge(codcli);
            }
            em.remove(clientecaracteristica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientecaracteristica> findClientecaracteristicaEntities() {
        return findClientecaracteristicaEntities(true, -1, -1);
    }

    public List<Clientecaracteristica> findClientecaracteristicaEntities(int maxResults, int firstResult) {
        return findClientecaracteristicaEntities(false, maxResults, firstResult);
    }

    private List<Clientecaracteristica> findClientecaracteristicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientecaracteristica.class));
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

    public Clientecaracteristica findClientecaracteristica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientecaracteristica.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientecaracteristicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientecaracteristica> rt = cq.from(Clientecaracteristica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
