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
import entidade.cplus.Itemgrade;
import entidade.cplus.Itemgradedetalhe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ItemgradedetalheJpaController implements Serializable {

    public ItemgradedetalheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemgradedetalhe itemgradedetalhe) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemgrade coditemgrade = itemgradedetalhe.getCoditemgrade();
            if (coditemgrade != null) {
                coditemgrade = em.getReference(coditemgrade.getClass(), coditemgrade.getCoditemgrade());
                itemgradedetalhe.setCoditemgrade(coditemgrade);
            }
            em.persist(itemgradedetalhe);
            if (coditemgrade != null) {
                coditemgrade.getItemgradedetalheCollection().add(itemgradedetalhe);
                coditemgrade = em.merge(coditemgrade);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemgradedetalhe(itemgradedetalhe.getCoditemgradedetalhe()) != null) {
                throw new PreexistingEntityException("Itemgradedetalhe " + itemgradedetalhe + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itemgradedetalhe itemgradedetalhe) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemgradedetalhe persistentItemgradedetalhe = em.find(Itemgradedetalhe.class, itemgradedetalhe.getCoditemgradedetalhe());
            Itemgrade coditemgradeOld = persistentItemgradedetalhe.getCoditemgrade();
            Itemgrade coditemgradeNew = itemgradedetalhe.getCoditemgrade();
            if (coditemgradeNew != null) {
                coditemgradeNew = em.getReference(coditemgradeNew.getClass(), coditemgradeNew.getCoditemgrade());
                itemgradedetalhe.setCoditemgrade(coditemgradeNew);
            }
            itemgradedetalhe = em.merge(itemgradedetalhe);
            if (coditemgradeOld != null && !coditemgradeOld.equals(coditemgradeNew)) {
                coditemgradeOld.getItemgradedetalheCollection().remove(itemgradedetalhe);
                coditemgradeOld = em.merge(coditemgradeOld);
            }
            if (coditemgradeNew != null && !coditemgradeNew.equals(coditemgradeOld)) {
                coditemgradeNew.getItemgradedetalheCollection().add(itemgradedetalhe);
                coditemgradeNew = em.merge(coditemgradeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = itemgradedetalhe.getCoditemgradedetalhe();
                if (findItemgradedetalhe(id) == null) {
                    throw new NonexistentEntityException("The itemgradedetalhe with id " + id + " no longer exists.");
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
            Itemgradedetalhe itemgradedetalhe;
            try {
                itemgradedetalhe = em.getReference(Itemgradedetalhe.class, id);
                itemgradedetalhe.getCoditemgradedetalhe();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemgradedetalhe with id " + id + " no longer exists.", enfe);
            }
            Itemgrade coditemgrade = itemgradedetalhe.getCoditemgrade();
            if (coditemgrade != null) {
                coditemgrade.getItemgradedetalheCollection().remove(itemgradedetalhe);
                coditemgrade = em.merge(coditemgrade);
            }
            em.remove(itemgradedetalhe);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itemgradedetalhe> findItemgradedetalheEntities() {
        return findItemgradedetalheEntities(true, -1, -1);
    }

    public List<Itemgradedetalhe> findItemgradedetalheEntities(int maxResults, int firstResult) {
        return findItemgradedetalheEntities(false, maxResults, firstResult);
    }

    private List<Itemgradedetalhe> findItemgradedetalheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemgradedetalhe.class));
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

    public Itemgradedetalhe findItemgradedetalhe(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itemgradedetalhe.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemgradedetalheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemgradedetalhe> rt = cq.from(Itemgradedetalhe.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
