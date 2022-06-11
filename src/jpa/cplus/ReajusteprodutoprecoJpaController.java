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
import entidade.cplus.Preco;
import entidade.cplus.Reajusteproduto;
import entidade.cplus.Reajusteprodutopreco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ReajusteprodutoprecoJpaController implements Serializable {

    public ReajusteprodutoprecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reajusteprodutopreco reajusteprodutopreco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preco codpreco = reajusteprodutopreco.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                reajusteprodutopreco.setCodpreco(codpreco);
            }
            Reajusteproduto codreajusteproduto = reajusteprodutopreco.getCodreajusteproduto();
            if (codreajusteproduto != null) {
                codreajusteproduto = em.getReference(codreajusteproduto.getClass(), codreajusteproduto.getCodreajusteproduto());
                reajusteprodutopreco.setCodreajusteproduto(codreajusteproduto);
            }
            em.persist(reajusteprodutopreco);
            if (codpreco != null) {
                codpreco.getReajusteprodutoprecoCollection().add(reajusteprodutopreco);
                codpreco = em.merge(codpreco);
            }
            if (codreajusteproduto != null) {
                codreajusteproduto.getReajusteprodutoprecoCollection().add(reajusteprodutopreco);
                codreajusteproduto = em.merge(codreajusteproduto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReajusteprodutopreco(reajusteprodutopreco.getCodreajusteprodutopreco()) != null) {
                throw new PreexistingEntityException("Reajusteprodutopreco " + reajusteprodutopreco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reajusteprodutopreco reajusteprodutopreco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reajusteprodutopreco persistentReajusteprodutopreco = em.find(Reajusteprodutopreco.class, reajusteprodutopreco.getCodreajusteprodutopreco());
            Preco codprecoOld = persistentReajusteprodutopreco.getCodpreco();
            Preco codprecoNew = reajusteprodutopreco.getCodpreco();
            Reajusteproduto codreajusteprodutoOld = persistentReajusteprodutopreco.getCodreajusteproduto();
            Reajusteproduto codreajusteprodutoNew = reajusteprodutopreco.getCodreajusteproduto();
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                reajusteprodutopreco.setCodpreco(codprecoNew);
            }
            if (codreajusteprodutoNew != null) {
                codreajusteprodutoNew = em.getReference(codreajusteprodutoNew.getClass(), codreajusteprodutoNew.getCodreajusteproduto());
                reajusteprodutopreco.setCodreajusteproduto(codreajusteprodutoNew);
            }
            reajusteprodutopreco = em.merge(reajusteprodutopreco);
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getReajusteprodutoprecoCollection().remove(reajusteprodutopreco);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getReajusteprodutoprecoCollection().add(reajusteprodutopreco);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codreajusteprodutoOld != null && !codreajusteprodutoOld.equals(codreajusteprodutoNew)) {
                codreajusteprodutoOld.getReajusteprodutoprecoCollection().remove(reajusteprodutopreco);
                codreajusteprodutoOld = em.merge(codreajusteprodutoOld);
            }
            if (codreajusteprodutoNew != null && !codreajusteprodutoNew.equals(codreajusteprodutoOld)) {
                codreajusteprodutoNew.getReajusteprodutoprecoCollection().add(reajusteprodutopreco);
                codreajusteprodutoNew = em.merge(codreajusteprodutoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reajusteprodutopreco.getCodreajusteprodutopreco();
                if (findReajusteprodutopreco(id) == null) {
                    throw new NonexistentEntityException("The reajusteprodutopreco with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reajusteprodutopreco reajusteprodutopreco;
            try {
                reajusteprodutopreco = em.getReference(Reajusteprodutopreco.class, id);
                reajusteprodutopreco.getCodreajusteprodutopreco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reajusteprodutopreco with id " + id + " no longer exists.", enfe);
            }
            Preco codpreco = reajusteprodutopreco.getCodpreco();
            if (codpreco != null) {
                codpreco.getReajusteprodutoprecoCollection().remove(reajusteprodutopreco);
                codpreco = em.merge(codpreco);
            }
            Reajusteproduto codreajusteproduto = reajusteprodutopreco.getCodreajusteproduto();
            if (codreajusteproduto != null) {
                codreajusteproduto.getReajusteprodutoprecoCollection().remove(reajusteprodutopreco);
                codreajusteproduto = em.merge(codreajusteproduto);
            }
            em.remove(reajusteprodutopreco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reajusteprodutopreco> findReajusteprodutoprecoEntities() {
        return findReajusteprodutoprecoEntities(true, -1, -1);
    }

    public List<Reajusteprodutopreco> findReajusteprodutoprecoEntities(int maxResults, int firstResult) {
        return findReajusteprodutoprecoEntities(false, maxResults, firstResult);
    }

    private List<Reajusteprodutopreco> findReajusteprodutoprecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reajusteprodutopreco.class));
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

    public Reajusteprodutopreco findReajusteprodutopreco(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reajusteprodutopreco.class, id);
        } finally {
            em.close();
        }
    }

    public int getReajusteprodutoprecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reajusteprodutopreco> rt = cq.from(Reajusteprodutopreco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
