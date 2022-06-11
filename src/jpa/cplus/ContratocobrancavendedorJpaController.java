/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Contratocobrancavendedor;
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
public class ContratocobrancavendedorJpaController implements Serializable {

    public ContratocobrancavendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contratocobrancavendedor contratocobrancavendedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contratocobrancavendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContratocobrancavendedor(contratocobrancavendedor.getCodcontratocobrancavendedor()) != null) {
                throw new PreexistingEntityException("Contratocobrancavendedor " + contratocobrancavendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contratocobrancavendedor contratocobrancavendedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contratocobrancavendedor = em.merge(contratocobrancavendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = contratocobrancavendedor.getCodcontratocobrancavendedor();
                if (findContratocobrancavendedor(id) == null) {
                    throw new NonexistentEntityException("The contratocobrancavendedor with id " + id + " no longer exists.");
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
            Contratocobrancavendedor contratocobrancavendedor;
            try {
                contratocobrancavendedor = em.getReference(Contratocobrancavendedor.class, id);
                contratocobrancavendedor.getCodcontratocobrancavendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contratocobrancavendedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(contratocobrancavendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contratocobrancavendedor> findContratocobrancavendedorEntities() {
        return findContratocobrancavendedorEntities(true, -1, -1);
    }

    public List<Contratocobrancavendedor> findContratocobrancavendedorEntities(int maxResults, int firstResult) {
        return findContratocobrancavendedorEntities(false, maxResults, firstResult);
    }

    private List<Contratocobrancavendedor> findContratocobrancavendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contratocobrancavendedor.class));
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

    public Contratocobrancavendedor findContratocobrancavendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contratocobrancavendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratocobrancavendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contratocobrancavendedor> rt = cq.from(Contratocobrancavendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
