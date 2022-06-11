/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Conferenciaseparacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConferenciaseparacaoJpaController implements Serializable {

    public ConferenciaseparacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conferenciaseparacao conferenciaseparacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = conferenciaseparacao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                conferenciaseparacao.setCodmovenda(codmovenda);
            }
            em.persist(conferenciaseparacao);
            if (codmovenda != null) {
                codmovenda.getConferenciaseparacaoCollection().add(conferenciaseparacao);
                codmovenda = em.merge(codmovenda);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConferenciaseparacao(conferenciaseparacao.getCodconferenciaseparacao()) != null) {
                throw new PreexistingEntityException("Conferenciaseparacao " + conferenciaseparacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conferenciaseparacao conferenciaseparacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciaseparacao persistentConferenciaseparacao = em.find(Conferenciaseparacao.class, conferenciaseparacao.getCodconferenciaseparacao());
            Movenda codmovendaOld = persistentConferenciaseparacao.getCodmovenda();
            Movenda codmovendaNew = conferenciaseparacao.getCodmovenda();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                conferenciaseparacao.setCodmovenda(codmovendaNew);
            }
            conferenciaseparacao = em.merge(conferenciaseparacao);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getConferenciaseparacaoCollection().remove(conferenciaseparacao);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getConferenciaseparacaoCollection().add(conferenciaseparacao);
                codmovendaNew = em.merge(codmovendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conferenciaseparacao.getCodconferenciaseparacao();
                if (findConferenciaseparacao(id) == null) {
                    throw new NonexistentEntityException("The conferenciaseparacao with id " + id + " no longer exists.");
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
            Conferenciaseparacao conferenciaseparacao;
            try {
                conferenciaseparacao = em.getReference(Conferenciaseparacao.class, id);
                conferenciaseparacao.getCodconferenciaseparacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conferenciaseparacao with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = conferenciaseparacao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getConferenciaseparacaoCollection().remove(conferenciaseparacao);
                codmovenda = em.merge(codmovenda);
            }
            em.remove(conferenciaseparacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conferenciaseparacao> findConferenciaseparacaoEntities() {
        return findConferenciaseparacaoEntities(true, -1, -1);
    }

    public List<Conferenciaseparacao> findConferenciaseparacaoEntities(int maxResults, int firstResult) {
        return findConferenciaseparacaoEntities(false, maxResults, firstResult);
    }

    private List<Conferenciaseparacao> findConferenciaseparacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conferenciaseparacao.class));
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

    public Conferenciaseparacao findConferenciaseparacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conferenciaseparacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getConferenciaseparacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conferenciaseparacao> rt = cq.from(Conferenciaseparacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
