/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Comissao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movendaprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ComissaoJpaController implements Serializable {

    public ComissaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comissao comissao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = comissao.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                comissao.setCodmovprod(codmovprod);
            }
            em.persist(comissao);
            if (codmovprod != null) {
                codmovprod.getComissaoCollection().add(comissao);
                codmovprod = em.merge(codmovprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComissao(comissao.getCodcomissao()) != null) {
                throw new PreexistingEntityException("Comissao " + comissao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comissao comissao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comissao persistentComissao = em.find(Comissao.class, comissao.getCodcomissao());
            Movendaprod codmovprodOld = persistentComissao.getCodmovprod();
            Movendaprod codmovprodNew = comissao.getCodmovprod();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                comissao.setCodmovprod(codmovprodNew);
            }
            comissao = em.merge(comissao);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getComissaoCollection().remove(comissao);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getComissaoCollection().add(comissao);
                codmovprodNew = em.merge(codmovprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comissao.getCodcomissao();
                if (findComissao(id) == null) {
                    throw new NonexistentEntityException("The comissao with id " + id + " no longer exists.");
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
            Comissao comissao;
            try {
                comissao = em.getReference(Comissao.class, id);
                comissao.getCodcomissao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comissao with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = comissao.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getComissaoCollection().remove(comissao);
                codmovprod = em.merge(codmovprod);
            }
            em.remove(comissao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comissao> findComissaoEntities() {
        return findComissaoEntities(true, -1, -1);
    }

    public List<Comissao> findComissaoEntities(int maxResults, int firstResult) {
        return findComissaoEntities(false, maxResults, firstResult);
    }

    private List<Comissao> findComissaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comissao.class));
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

    public Comissao findComissao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comissao.class, id);
        } finally {
            em.close();
        }
    }

    public int getComissaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comissao> rt = cq.from(Comissao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
