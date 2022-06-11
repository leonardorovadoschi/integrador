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
import entidade.cplus.Cfop;
import entidade.cplus.Planocontacfop;
import entidade.cplus.Tipomovimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PlanocontacfopJpaController implements Serializable {

    public PlanocontacfopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Planocontacfop planocontacfop) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop codcfop = planocontacfop.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                planocontacfop.setCodcfop(codcfop);
            }
            Tipomovimento codtipomovimento = planocontacfop.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento = em.getReference(codtipomovimento.getClass(), codtipomovimento.getCodtipomovimento());
                planocontacfop.setCodtipomovimento(codtipomovimento);
            }
            em.persist(planocontacfop);
            if (codcfop != null) {
                codcfop.getPlanocontacfopCollection().add(planocontacfop);
                codcfop = em.merge(codcfop);
            }
            if (codtipomovimento != null) {
                codtipomovimento.getPlanocontacfopCollection().add(planocontacfop);
                codtipomovimento = em.merge(codtipomovimento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPlanocontacfop(planocontacfop.getCodplanocontacfop()) != null) {
                throw new PreexistingEntityException("Planocontacfop " + planocontacfop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Planocontacfop planocontacfop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Planocontacfop persistentPlanocontacfop = em.find(Planocontacfop.class, planocontacfop.getCodplanocontacfop());
            Cfop codcfopOld = persistentPlanocontacfop.getCodcfop();
            Cfop codcfopNew = planocontacfop.getCodcfop();
            Tipomovimento codtipomovimentoOld = persistentPlanocontacfop.getCodtipomovimento();
            Tipomovimento codtipomovimentoNew = planocontacfop.getCodtipomovimento();
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                planocontacfop.setCodcfop(codcfopNew);
            }
            if (codtipomovimentoNew != null) {
                codtipomovimentoNew = em.getReference(codtipomovimentoNew.getClass(), codtipomovimentoNew.getCodtipomovimento());
                planocontacfop.setCodtipomovimento(codtipomovimentoNew);
            }
            planocontacfop = em.merge(planocontacfop);
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getPlanocontacfopCollection().remove(planocontacfop);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getPlanocontacfopCollection().add(planocontacfop);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codtipomovimentoOld != null && !codtipomovimentoOld.equals(codtipomovimentoNew)) {
                codtipomovimentoOld.getPlanocontacfopCollection().remove(planocontacfop);
                codtipomovimentoOld = em.merge(codtipomovimentoOld);
            }
            if (codtipomovimentoNew != null && !codtipomovimentoNew.equals(codtipomovimentoOld)) {
                codtipomovimentoNew.getPlanocontacfopCollection().add(planocontacfop);
                codtipomovimentoNew = em.merge(codtipomovimentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = planocontacfop.getCodplanocontacfop();
                if (findPlanocontacfop(id) == null) {
                    throw new NonexistentEntityException("The planocontacfop with id " + id + " no longer exists.");
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
            Planocontacfop planocontacfop;
            try {
                planocontacfop = em.getReference(Planocontacfop.class, id);
                planocontacfop.getCodplanocontacfop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The planocontacfop with id " + id + " no longer exists.", enfe);
            }
            Cfop codcfop = planocontacfop.getCodcfop();
            if (codcfop != null) {
                codcfop.getPlanocontacfopCollection().remove(planocontacfop);
                codcfop = em.merge(codcfop);
            }
            Tipomovimento codtipomovimento = planocontacfop.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento.getPlanocontacfopCollection().remove(planocontacfop);
                codtipomovimento = em.merge(codtipomovimento);
            }
            em.remove(planocontacfop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Planocontacfop> findPlanocontacfopEntities() {
        return findPlanocontacfopEntities(true, -1, -1);
    }

    public List<Planocontacfop> findPlanocontacfopEntities(int maxResults, int firstResult) {
        return findPlanocontacfopEntities(false, maxResults, firstResult);
    }

    private List<Planocontacfop> findPlanocontacfopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Planocontacfop.class));
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

    public Planocontacfop findPlanocontacfop(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Planocontacfop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlanocontacfopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Planocontacfop> rt = cq.from(Planocontacfop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
