/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Especializacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Funcionario;
import entidade.cplus.Tipoespecializacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EspecializacaoJpaController implements Serializable {

    public EspecializacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especializacao especializacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario codfunc = especializacao.getCodfunc();
            if (codfunc != null) {
                codfunc = em.getReference(codfunc.getClass(), codfunc.getCodfuncionario());
                especializacao.setCodfunc(codfunc);
            }
            Tipoespecializacao codtipoespecializacao = especializacao.getCodtipoespecializacao();
            if (codtipoespecializacao != null) {
                codtipoespecializacao = em.getReference(codtipoespecializacao.getClass(), codtipoespecializacao.getCodtipoespecializacao());
                especializacao.setCodtipoespecializacao(codtipoespecializacao);
            }
            em.persist(especializacao);
            if (codfunc != null) {
                codfunc.getEspecializacaoCollection().add(especializacao);
                codfunc = em.merge(codfunc);
            }
            if (codtipoespecializacao != null) {
                codtipoespecializacao.getEspecializacaoCollection().add(especializacao);
                codtipoespecializacao = em.merge(codtipoespecializacao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspecializacao(especializacao.getCodespecializacao()) != null) {
                throw new PreexistingEntityException("Especializacao " + especializacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especializacao especializacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especializacao persistentEspecializacao = em.find(Especializacao.class, especializacao.getCodespecializacao());
            Funcionario codfuncOld = persistentEspecializacao.getCodfunc();
            Funcionario codfuncNew = especializacao.getCodfunc();
            Tipoespecializacao codtipoespecializacaoOld = persistentEspecializacao.getCodtipoespecializacao();
            Tipoespecializacao codtipoespecializacaoNew = especializacao.getCodtipoespecializacao();
            if (codfuncNew != null) {
                codfuncNew = em.getReference(codfuncNew.getClass(), codfuncNew.getCodfuncionario());
                especializacao.setCodfunc(codfuncNew);
            }
            if (codtipoespecializacaoNew != null) {
                codtipoespecializacaoNew = em.getReference(codtipoespecializacaoNew.getClass(), codtipoespecializacaoNew.getCodtipoespecializacao());
                especializacao.setCodtipoespecializacao(codtipoespecializacaoNew);
            }
            especializacao = em.merge(especializacao);
            if (codfuncOld != null && !codfuncOld.equals(codfuncNew)) {
                codfuncOld.getEspecializacaoCollection().remove(especializacao);
                codfuncOld = em.merge(codfuncOld);
            }
            if (codfuncNew != null && !codfuncNew.equals(codfuncOld)) {
                codfuncNew.getEspecializacaoCollection().add(especializacao);
                codfuncNew = em.merge(codfuncNew);
            }
            if (codtipoespecializacaoOld != null && !codtipoespecializacaoOld.equals(codtipoespecializacaoNew)) {
                codtipoespecializacaoOld.getEspecializacaoCollection().remove(especializacao);
                codtipoespecializacaoOld = em.merge(codtipoespecializacaoOld);
            }
            if (codtipoespecializacaoNew != null && !codtipoespecializacaoNew.equals(codtipoespecializacaoOld)) {
                codtipoespecializacaoNew.getEspecializacaoCollection().add(especializacao);
                codtipoespecializacaoNew = em.merge(codtipoespecializacaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = especializacao.getCodespecializacao();
                if (findEspecializacao(id) == null) {
                    throw new NonexistentEntityException("The especializacao with id " + id + " no longer exists.");
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
            Especializacao especializacao;
            try {
                especializacao = em.getReference(Especializacao.class, id);
                especializacao.getCodespecializacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especializacao with id " + id + " no longer exists.", enfe);
            }
            Funcionario codfunc = especializacao.getCodfunc();
            if (codfunc != null) {
                codfunc.getEspecializacaoCollection().remove(especializacao);
                codfunc = em.merge(codfunc);
            }
            Tipoespecializacao codtipoespecializacao = especializacao.getCodtipoespecializacao();
            if (codtipoespecializacao != null) {
                codtipoespecializacao.getEspecializacaoCollection().remove(especializacao);
                codtipoespecializacao = em.merge(codtipoespecializacao);
            }
            em.remove(especializacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especializacao> findEspecializacaoEntities() {
        return findEspecializacaoEntities(true, -1, -1);
    }

    public List<Especializacao> findEspecializacaoEntities(int maxResults, int firstResult) {
        return findEspecializacaoEntities(false, maxResults, firstResult);
    }

    private List<Especializacao> findEspecializacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especializacao.class));
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

    public Especializacao findEspecializacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especializacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecializacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especializacao> rt = cq.from(Especializacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
