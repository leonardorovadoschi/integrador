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
import entidade.cplus.Funcionario;
import entidade.cplus.Funcionariodesconto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class FuncionariodescontoJpaController implements Serializable {

    public FuncionariodescontoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionariodesconto funcionariodesconto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario codfuncionario = funcionariodesconto.getCodfuncionario();
            if (codfuncionario != null) {
                codfuncionario = em.getReference(codfuncionario.getClass(), codfuncionario.getCodfuncionario());
                funcionariodesconto.setCodfuncionario(codfuncionario);
            }
            em.persist(funcionariodesconto);
            if (codfuncionario != null) {
                codfuncionario.getFuncionariodescontoCollection().add(funcionariodesconto);
                codfuncionario = em.merge(codfuncionario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionariodesconto(funcionariodesconto.getCodfuncionariodesconto()) != null) {
                throw new PreexistingEntityException("Funcionariodesconto " + funcionariodesconto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionariodesconto funcionariodesconto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionariodesconto persistentFuncionariodesconto = em.find(Funcionariodesconto.class, funcionariodesconto.getCodfuncionariodesconto());
            Funcionario codfuncionarioOld = persistentFuncionariodesconto.getCodfuncionario();
            Funcionario codfuncionarioNew = funcionariodesconto.getCodfuncionario();
            if (codfuncionarioNew != null) {
                codfuncionarioNew = em.getReference(codfuncionarioNew.getClass(), codfuncionarioNew.getCodfuncionario());
                funcionariodesconto.setCodfuncionario(codfuncionarioNew);
            }
            funcionariodesconto = em.merge(funcionariodesconto);
            if (codfuncionarioOld != null && !codfuncionarioOld.equals(codfuncionarioNew)) {
                codfuncionarioOld.getFuncionariodescontoCollection().remove(funcionariodesconto);
                codfuncionarioOld = em.merge(codfuncionarioOld);
            }
            if (codfuncionarioNew != null && !codfuncionarioNew.equals(codfuncionarioOld)) {
                codfuncionarioNew.getFuncionariodescontoCollection().add(funcionariodesconto);
                codfuncionarioNew = em.merge(codfuncionarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funcionariodesconto.getCodfuncionariodesconto();
                if (findFuncionariodesconto(id) == null) {
                    throw new NonexistentEntityException("The funcionariodesconto with id " + id + " no longer exists.");
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
            Funcionariodesconto funcionariodesconto;
            try {
                funcionariodesconto = em.getReference(Funcionariodesconto.class, id);
                funcionariodesconto.getCodfuncionariodesconto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionariodesconto with id " + id + " no longer exists.", enfe);
            }
            Funcionario codfuncionario = funcionariodesconto.getCodfuncionario();
            if (codfuncionario != null) {
                codfuncionario.getFuncionariodescontoCollection().remove(funcionariodesconto);
                codfuncionario = em.merge(codfuncionario);
            }
            em.remove(funcionariodesconto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionariodesconto> findFuncionariodescontoEntities() {
        return findFuncionariodescontoEntities(true, -1, -1);
    }

    public List<Funcionariodesconto> findFuncionariodescontoEntities(int maxResults, int firstResult) {
        return findFuncionariodescontoEntities(false, maxResults, firstResult);
    }

    private List<Funcionariodesconto> findFuncionariodescontoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionariodesconto.class));
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

    public Funcionariodesconto findFuncionariodesconto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionariodesconto.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionariodescontoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionariodesconto> rt = cq.from(Funcionariodesconto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
