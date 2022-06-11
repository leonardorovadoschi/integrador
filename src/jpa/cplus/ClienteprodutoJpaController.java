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
import entidade.cplus.Clienteproduto;
import entidade.cplus.OsModalidade;
import entidade.cplus.Preco;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ClienteprodutoJpaController implements Serializable {

    public ClienteprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clienteproduto clienteproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = clienteproduto.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                clienteproduto.setCodcli(codcli);
            }
            OsModalidade codmod = clienteproduto.getCodmod();
            if (codmod != null) {
                codmod = em.getReference(codmod.getClass(), codmod.getCodmod());
                clienteproduto.setCodmod(codmod);
            }
            Preco codpreco = clienteproduto.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                clienteproduto.setCodpreco(codpreco);
            }
            Produto codprod = clienteproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                clienteproduto.setCodprod(codprod);
            }
            em.persist(clienteproduto);
            if (codcli != null) {
                codcli.getClienteprodutoCollection().add(clienteproduto);
                codcli = em.merge(codcli);
            }
            if (codmod != null) {
                codmod.getClienteprodutoCollection().add(clienteproduto);
                codmod = em.merge(codmod);
            }
            if (codpreco != null) {
                codpreco.getClienteprodutoCollection().add(clienteproduto);
                codpreco = em.merge(codpreco);
            }
            if (codprod != null) {
                codprod.getClienteprodutoCollection().add(clienteproduto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClienteproduto(clienteproduto.getCodcliprod()) != null) {
                throw new PreexistingEntityException("Clienteproduto " + clienteproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clienteproduto clienteproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clienteproduto persistentClienteproduto = em.find(Clienteproduto.class, clienteproduto.getCodcliprod());
            Cliente codcliOld = persistentClienteproduto.getCodcli();
            Cliente codcliNew = clienteproduto.getCodcli();
            OsModalidade codmodOld = persistentClienteproduto.getCodmod();
            OsModalidade codmodNew = clienteproduto.getCodmod();
            Preco codprecoOld = persistentClienteproduto.getCodpreco();
            Preco codprecoNew = clienteproduto.getCodpreco();
            Produto codprodOld = persistentClienteproduto.getCodprod();
            Produto codprodNew = clienteproduto.getCodprod();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                clienteproduto.setCodcli(codcliNew);
            }
            if (codmodNew != null) {
                codmodNew = em.getReference(codmodNew.getClass(), codmodNew.getCodmod());
                clienteproduto.setCodmod(codmodNew);
            }
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                clienteproduto.setCodpreco(codprecoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                clienteproduto.setCodprod(codprodNew);
            }
            clienteproduto = em.merge(clienteproduto);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getClienteprodutoCollection().remove(clienteproduto);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getClienteprodutoCollection().add(clienteproduto);
                codcliNew = em.merge(codcliNew);
            }
            if (codmodOld != null && !codmodOld.equals(codmodNew)) {
                codmodOld.getClienteprodutoCollection().remove(clienteproduto);
                codmodOld = em.merge(codmodOld);
            }
            if (codmodNew != null && !codmodNew.equals(codmodOld)) {
                codmodNew.getClienteprodutoCollection().add(clienteproduto);
                codmodNew = em.merge(codmodNew);
            }
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getClienteprodutoCollection().remove(clienteproduto);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getClienteprodutoCollection().add(clienteproduto);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getClienteprodutoCollection().remove(clienteproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getClienteprodutoCollection().add(clienteproduto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clienteproduto.getCodcliprod();
                if (findClienteproduto(id) == null) {
                    throw new NonexistentEntityException("The clienteproduto with id " + id + " no longer exists.");
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
            Clienteproduto clienteproduto;
            try {
                clienteproduto = em.getReference(Clienteproduto.class, id);
                clienteproduto.getCodcliprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteproduto with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = clienteproduto.getCodcli();
            if (codcli != null) {
                codcli.getClienteprodutoCollection().remove(clienteproduto);
                codcli = em.merge(codcli);
            }
            OsModalidade codmod = clienteproduto.getCodmod();
            if (codmod != null) {
                codmod.getClienteprodutoCollection().remove(clienteproduto);
                codmod = em.merge(codmod);
            }
            Preco codpreco = clienteproduto.getCodpreco();
            if (codpreco != null) {
                codpreco.getClienteprodutoCollection().remove(clienteproduto);
                codpreco = em.merge(codpreco);
            }
            Produto codprod = clienteproduto.getCodprod();
            if (codprod != null) {
                codprod.getClienteprodutoCollection().remove(clienteproduto);
                codprod = em.merge(codprod);
            }
            em.remove(clienteproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clienteproduto> findClienteprodutoEntities() {
        return findClienteprodutoEntities(true, -1, -1);
    }

    public List<Clienteproduto> findClienteprodutoEntities(int maxResults, int firstResult) {
        return findClienteprodutoEntities(false, maxResults, firstResult);
    }

    private List<Clienteproduto> findClienteprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clienteproduto.class));
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

    public Clienteproduto findClienteproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clienteproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clienteproduto> rt = cq.from(Clienteproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
