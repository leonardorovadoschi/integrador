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
import entidade.cplus.Arquivoregistro;
import entidade.cplus.Arquivovariavel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ArquivovariavelJpaController implements Serializable {

    public ArquivovariavelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Arquivovariavel arquivovariavel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arquivoregistro codarquivoregistro = arquivovariavel.getCodarquivoregistro();
            if (codarquivoregistro != null) {
                codarquivoregistro = em.getReference(codarquivoregistro.getClass(), codarquivoregistro.getCodarquivoregistro());
                arquivovariavel.setCodarquivoregistro(codarquivoregistro);
            }
            em.persist(arquivovariavel);
            if (codarquivoregistro != null) {
                codarquivoregistro.getArquivovariavelCollection().add(arquivovariavel);
                codarquivoregistro = em.merge(codarquivoregistro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArquivovariavel(arquivovariavel.getCodarquivovariavel()) != null) {
                throw new PreexistingEntityException("Arquivovariavel " + arquivovariavel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Arquivovariavel arquivovariavel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arquivovariavel persistentArquivovariavel = em.find(Arquivovariavel.class, arquivovariavel.getCodarquivovariavel());
            Arquivoregistro codarquivoregistroOld = persistentArquivovariavel.getCodarquivoregistro();
            Arquivoregistro codarquivoregistroNew = arquivovariavel.getCodarquivoregistro();
            if (codarquivoregistroNew != null) {
                codarquivoregistroNew = em.getReference(codarquivoregistroNew.getClass(), codarquivoregistroNew.getCodarquivoregistro());
                arquivovariavel.setCodarquivoregistro(codarquivoregistroNew);
            }
            arquivovariavel = em.merge(arquivovariavel);
            if (codarquivoregistroOld != null && !codarquivoregistroOld.equals(codarquivoregistroNew)) {
                codarquivoregistroOld.getArquivovariavelCollection().remove(arquivovariavel);
                codarquivoregistroOld = em.merge(codarquivoregistroOld);
            }
            if (codarquivoregistroNew != null && !codarquivoregistroNew.equals(codarquivoregistroOld)) {
                codarquivoregistroNew.getArquivovariavelCollection().add(arquivovariavel);
                codarquivoregistroNew = em.merge(codarquivoregistroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = arquivovariavel.getCodarquivovariavel();
                if (findArquivovariavel(id) == null) {
                    throw new NonexistentEntityException("The arquivovariavel with id " + id + " no longer exists.");
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
            Arquivovariavel arquivovariavel;
            try {
                arquivovariavel = em.getReference(Arquivovariavel.class, id);
                arquivovariavel.getCodarquivovariavel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arquivovariavel with id " + id + " no longer exists.", enfe);
            }
            Arquivoregistro codarquivoregistro = arquivovariavel.getCodarquivoregistro();
            if (codarquivoregistro != null) {
                codarquivoregistro.getArquivovariavelCollection().remove(arquivovariavel);
                codarquivoregistro = em.merge(codarquivoregistro);
            }
            em.remove(arquivovariavel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Arquivovariavel> findArquivovariavelEntities() {
        return findArquivovariavelEntities(true, -1, -1);
    }

    public List<Arquivovariavel> findArquivovariavelEntities(int maxResults, int firstResult) {
        return findArquivovariavelEntities(false, maxResults, firstResult);
    }

    private List<Arquivovariavel> findArquivovariavelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Arquivovariavel.class));
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

    public Arquivovariavel findArquivovariavel(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Arquivovariavel.class, id);
        } finally {
            em.close();
        }
    }

    public int getArquivovariavelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Arquivovariavel> rt = cq.from(Arquivovariavel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
