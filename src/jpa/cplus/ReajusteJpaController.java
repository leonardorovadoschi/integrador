/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Reajuste;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Reajusteproduto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ReajusteJpaController implements Serializable {

    public ReajusteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reajuste reajuste) throws PreexistingEntityException, Exception {
        if (reajuste.getReajusteprodutoCollection() == null) {
            reajuste.setReajusteprodutoCollection(new ArrayList<Reajusteproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Reajusteproduto> attachedReajusteprodutoCollection = new ArrayList<Reajusteproduto>();
            for (Reajusteproduto reajusteprodutoCollectionReajusteprodutoToAttach : reajuste.getReajusteprodutoCollection()) {
                reajusteprodutoCollectionReajusteprodutoToAttach = em.getReference(reajusteprodutoCollectionReajusteprodutoToAttach.getClass(), reajusteprodutoCollectionReajusteprodutoToAttach.getCodreajusteproduto());
                attachedReajusteprodutoCollection.add(reajusteprodutoCollectionReajusteprodutoToAttach);
            }
            reajuste.setReajusteprodutoCollection(attachedReajusteprodutoCollection);
            em.persist(reajuste);
            for (Reajusteproduto reajusteprodutoCollectionReajusteproduto : reajuste.getReajusteprodutoCollection()) {
                Reajuste oldCodreajusteOfReajusteprodutoCollectionReajusteproduto = reajusteprodutoCollectionReajusteproduto.getCodreajuste();
                reajusteprodutoCollectionReajusteproduto.setCodreajuste(reajuste);
                reajusteprodutoCollectionReajusteproduto = em.merge(reajusteprodutoCollectionReajusteproduto);
                if (oldCodreajusteOfReajusteprodutoCollectionReajusteproduto != null) {
                    oldCodreajusteOfReajusteprodutoCollectionReajusteproduto.getReajusteprodutoCollection().remove(reajusteprodutoCollectionReajusteproduto);
                    oldCodreajusteOfReajusteprodutoCollectionReajusteproduto = em.merge(oldCodreajusteOfReajusteprodutoCollectionReajusteproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReajuste(reajuste.getCodreajuste()) != null) {
                throw new PreexistingEntityException("Reajuste " + reajuste + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reajuste reajuste) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reajuste persistentReajuste = em.find(Reajuste.class, reajuste.getCodreajuste());
            Collection<Reajusteproduto> reajusteprodutoCollectionOld = persistentReajuste.getReajusteprodutoCollection();
            Collection<Reajusteproduto> reajusteprodutoCollectionNew = reajuste.getReajusteprodutoCollection();
            Collection<Reajusteproduto> attachedReajusteprodutoCollectionNew = new ArrayList<Reajusteproduto>();
            for (Reajusteproduto reajusteprodutoCollectionNewReajusteprodutoToAttach : reajusteprodutoCollectionNew) {
                reajusteprodutoCollectionNewReajusteprodutoToAttach = em.getReference(reajusteprodutoCollectionNewReajusteprodutoToAttach.getClass(), reajusteprodutoCollectionNewReajusteprodutoToAttach.getCodreajusteproduto());
                attachedReajusteprodutoCollectionNew.add(reajusteprodutoCollectionNewReajusteprodutoToAttach);
            }
            reajusteprodutoCollectionNew = attachedReajusteprodutoCollectionNew;
            reajuste.setReajusteprodutoCollection(reajusteprodutoCollectionNew);
            reajuste = em.merge(reajuste);
            for (Reajusteproduto reajusteprodutoCollectionOldReajusteproduto : reajusteprodutoCollectionOld) {
                if (!reajusteprodutoCollectionNew.contains(reajusteprodutoCollectionOldReajusteproduto)) {
                    reajusteprodutoCollectionOldReajusteproduto.setCodreajuste(null);
                    reajusteprodutoCollectionOldReajusteproduto = em.merge(reajusteprodutoCollectionOldReajusteproduto);
                }
            }
            for (Reajusteproduto reajusteprodutoCollectionNewReajusteproduto : reajusteprodutoCollectionNew) {
                if (!reajusteprodutoCollectionOld.contains(reajusteprodutoCollectionNewReajusteproduto)) {
                    Reajuste oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto = reajusteprodutoCollectionNewReajusteproduto.getCodreajuste();
                    reajusteprodutoCollectionNewReajusteproduto.setCodreajuste(reajuste);
                    reajusteprodutoCollectionNewReajusteproduto = em.merge(reajusteprodutoCollectionNewReajusteproduto);
                    if (oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto != null && !oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto.equals(reajuste)) {
                        oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto.getReajusteprodutoCollection().remove(reajusteprodutoCollectionNewReajusteproduto);
                        oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto = em.merge(oldCodreajusteOfReajusteprodutoCollectionNewReajusteproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reajuste.getCodreajuste();
                if (findReajuste(id) == null) {
                    throw new NonexistentEntityException("The reajuste with id " + id + " no longer exists.");
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
            Reajuste reajuste;
            try {
                reajuste = em.getReference(Reajuste.class, id);
                reajuste.getCodreajuste();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reajuste with id " + id + " no longer exists.", enfe);
            }
            Collection<Reajusteproduto> reajusteprodutoCollection = reajuste.getReajusteprodutoCollection();
            for (Reajusteproduto reajusteprodutoCollectionReajusteproduto : reajusteprodutoCollection) {
                reajusteprodutoCollectionReajusteproduto.setCodreajuste(null);
                reajusteprodutoCollectionReajusteproduto = em.merge(reajusteprodutoCollectionReajusteproduto);
            }
            em.remove(reajuste);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reajuste> findReajusteEntities() {
        return findReajusteEntities(true, -1, -1);
    }

    public List<Reajuste> findReajusteEntities(int maxResults, int firstResult) {
        return findReajusteEntities(false, maxResults, firstResult);
    }

    private List<Reajuste> findReajusteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reajuste.class));
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

    public Reajuste findReajuste(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reajuste.class, id);
        } finally {
            em.close();
        }
    }

    public int getReajusteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reajuste> rt = cq.from(Reajuste.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
