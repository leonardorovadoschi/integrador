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
import entidade.cplus.Documentocaixa;
import entidade.cplus.Movimentocaixa;
import entidade.cplus.Recebimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovimentocaixaJpaController implements Serializable {

    public MovimentocaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimentocaixa movimentocaixa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentocaixa coddocumentocaixa = movimentocaixa.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa = em.getReference(coddocumentocaixa.getClass(), coddocumentocaixa.getCoddocumentocaixa());
                movimentocaixa.setCoddocumentocaixa(coddocumentocaixa);
            }
            Recebimento codrec = movimentocaixa.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                movimentocaixa.setCodrec(codrec);
            }
            em.persist(movimentocaixa);
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getMovimentocaixaCollection().add(movimentocaixa);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            if (codrec != null) {
                codrec.getMovimentocaixaCollection().add(movimentocaixa);
                codrec = em.merge(codrec);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentocaixa(movimentocaixa.getCodmovimentocaixa()) != null) {
                throw new PreexistingEntityException("Movimentocaixa " + movimentocaixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimentocaixa movimentocaixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movimentocaixa persistentMovimentocaixa = em.find(Movimentocaixa.class, movimentocaixa.getCodmovimentocaixa());
            Documentocaixa coddocumentocaixaOld = persistentMovimentocaixa.getCoddocumentocaixa();
            Documentocaixa coddocumentocaixaNew = movimentocaixa.getCoddocumentocaixa();
            Recebimento codrecOld = persistentMovimentocaixa.getCodrec();
            Recebimento codrecNew = movimentocaixa.getCodrec();
            if (coddocumentocaixaNew != null) {
                coddocumentocaixaNew = em.getReference(coddocumentocaixaNew.getClass(), coddocumentocaixaNew.getCoddocumentocaixa());
                movimentocaixa.setCoddocumentocaixa(coddocumentocaixaNew);
            }
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                movimentocaixa.setCodrec(codrecNew);
            }
            movimentocaixa = em.merge(movimentocaixa);
            if (coddocumentocaixaOld != null && !coddocumentocaixaOld.equals(coddocumentocaixaNew)) {
                coddocumentocaixaOld.getMovimentocaixaCollection().remove(movimentocaixa);
                coddocumentocaixaOld = em.merge(coddocumentocaixaOld);
            }
            if (coddocumentocaixaNew != null && !coddocumentocaixaNew.equals(coddocumentocaixaOld)) {
                coddocumentocaixaNew.getMovimentocaixaCollection().add(movimentocaixa);
                coddocumentocaixaNew = em.merge(coddocumentocaixaNew);
            }
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getMovimentocaixaCollection().remove(movimentocaixa);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getMovimentocaixaCollection().add(movimentocaixa);
                codrecNew = em.merge(codrecNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movimentocaixa.getCodmovimentocaixa();
                if (findMovimentocaixa(id) == null) {
                    throw new NonexistentEntityException("The movimentocaixa with id " + id + " no longer exists.");
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
            Movimentocaixa movimentocaixa;
            try {
                movimentocaixa = em.getReference(Movimentocaixa.class, id);
                movimentocaixa.getCodmovimentocaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentocaixa with id " + id + " no longer exists.", enfe);
            }
            Documentocaixa coddocumentocaixa = movimentocaixa.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getMovimentocaixaCollection().remove(movimentocaixa);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            Recebimento codrec = movimentocaixa.getCodrec();
            if (codrec != null) {
                codrec.getMovimentocaixaCollection().remove(movimentocaixa);
                codrec = em.merge(codrec);
            }
            em.remove(movimentocaixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimentocaixa> findMovimentocaixaEntities() {
        return findMovimentocaixaEntities(true, -1, -1);
    }

    public List<Movimentocaixa> findMovimentocaixaEntities(int maxResults, int firstResult) {
        return findMovimentocaixaEntities(false, maxResults, firstResult);
    }

    private List<Movimentocaixa> findMovimentocaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimentocaixa.class));
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

    public Movimentocaixa findMovimentocaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimentocaixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentocaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimentocaixa> rt = cq.from(Movimentocaixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
