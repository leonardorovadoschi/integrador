/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpListaclassificacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpListaclassificacaoJpaController implements Serializable {

    public TmpListaclassificacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpListaclassificacao tmpListaclassificacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpListaclassificacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpListaclassificacao(tmpListaclassificacao.getCodtmpListaclassificacao()) != null) {
                throw new PreexistingEntityException("TmpListaclassificacao " + tmpListaclassificacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpListaclassificacao tmpListaclassificacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpListaclassificacao = em.merge(tmpListaclassificacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpListaclassificacao.getCodtmpListaclassificacao();
                if (findTmpListaclassificacao(id) == null) {
                    throw new NonexistentEntityException("The tmpListaclassificacao with id " + id + " no longer exists.");
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
            TmpListaclassificacao tmpListaclassificacao;
            try {
                tmpListaclassificacao = em.getReference(TmpListaclassificacao.class, id);
                tmpListaclassificacao.getCodtmpListaclassificacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpListaclassificacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpListaclassificacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpListaclassificacao> findTmpListaclassificacaoEntities() {
        return findTmpListaclassificacaoEntities(true, -1, -1);
    }

    public List<TmpListaclassificacao> findTmpListaclassificacaoEntities(int maxResults, int firstResult) {
        return findTmpListaclassificacaoEntities(false, maxResults, firstResult);
    }

    private List<TmpListaclassificacao> findTmpListaclassificacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpListaclassificacao.class));
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

    public TmpListaclassificacao findTmpListaclassificacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpListaclassificacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpListaclassificacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpListaclassificacao> rt = cq.from(TmpListaclassificacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
