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
import entidade.cplus.Relatorio;
import entidade.cplus.Relatorioacesso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RelatorioacessoJpaController implements Serializable {

    public RelatorioacessoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatorioacesso relatorioacesso) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatorio idrelatorio = relatorioacesso.getIdrelatorio();
            if (idrelatorio != null) {
                idrelatorio = em.getReference(idrelatorio.getClass(), idrelatorio.getId());
                relatorioacesso.setIdrelatorio(idrelatorio);
            }
            em.persist(relatorioacesso);
            if (idrelatorio != null) {
                idrelatorio.getRelatorioacessoCollection().add(relatorioacesso);
                idrelatorio = em.merge(idrelatorio);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatorioacesso(relatorioacesso.getId()) != null) {
                throw new PreexistingEntityException("Relatorioacesso " + relatorioacesso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatorioacesso relatorioacesso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatorioacesso persistentRelatorioacesso = em.find(Relatorioacesso.class, relatorioacesso.getId());
            Relatorio idrelatorioOld = persistentRelatorioacesso.getIdrelatorio();
            Relatorio idrelatorioNew = relatorioacesso.getIdrelatorio();
            if (idrelatorioNew != null) {
                idrelatorioNew = em.getReference(idrelatorioNew.getClass(), idrelatorioNew.getId());
                relatorioacesso.setIdrelatorio(idrelatorioNew);
            }
            relatorioacesso = em.merge(relatorioacesso);
            if (idrelatorioOld != null && !idrelatorioOld.equals(idrelatorioNew)) {
                idrelatorioOld.getRelatorioacessoCollection().remove(relatorioacesso);
                idrelatorioOld = em.merge(idrelatorioOld);
            }
            if (idrelatorioNew != null && !idrelatorioNew.equals(idrelatorioOld)) {
                idrelatorioNew.getRelatorioacessoCollection().add(relatorioacesso);
                idrelatorioNew = em.merge(idrelatorioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relatorioacesso.getId();
                if (findRelatorioacesso(id) == null) {
                    throw new NonexistentEntityException("The relatorioacesso with id " + id + " no longer exists.");
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
            Relatorioacesso relatorioacesso;
            try {
                relatorioacesso = em.getReference(Relatorioacesso.class, id);
                relatorioacesso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatorioacesso with id " + id + " no longer exists.", enfe);
            }
            Relatorio idrelatorio = relatorioacesso.getIdrelatorio();
            if (idrelatorio != null) {
                idrelatorio.getRelatorioacessoCollection().remove(relatorioacesso);
                idrelatorio = em.merge(idrelatorio);
            }
            em.remove(relatorioacesso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatorioacesso> findRelatorioacessoEntities() {
        return findRelatorioacessoEntities(true, -1, -1);
    }

    public List<Relatorioacesso> findRelatorioacessoEntities(int maxResults, int firstResult) {
        return findRelatorioacessoEntities(false, maxResults, firstResult);
    }

    private List<Relatorioacesso> findRelatorioacessoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatorioacesso.class));
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

    public Relatorioacesso findRelatorioacesso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatorioacesso.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatorioacessoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatorioacesso> rt = cq.from(Relatorioacesso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
