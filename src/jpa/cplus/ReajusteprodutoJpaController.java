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
import entidade.cplus.Produto;
import entidade.cplus.Reajuste;
import entidade.cplus.Reajusteproduto;
import entidade.cplus.Reajusteprodutopreco;
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
public class ReajusteprodutoJpaController implements Serializable {

    public ReajusteprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reajusteproduto reajusteproduto) throws PreexistingEntityException, Exception {
        if (reajusteproduto.getReajusteprodutoprecoCollection() == null) {
            reajusteproduto.setReajusteprodutoprecoCollection(new ArrayList<Reajusteprodutopreco>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = reajusteproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                reajusteproduto.setCodprod(codprod);
            }
            Reajuste codreajuste = reajusteproduto.getCodreajuste();
            if (codreajuste != null) {
                codreajuste = em.getReference(codreajuste.getClass(), codreajuste.getCodreajuste());
                reajusteproduto.setCodreajuste(codreajuste);
            }
            Collection<Reajusteprodutopreco> attachedReajusteprodutoprecoCollection = new ArrayList<Reajusteprodutopreco>();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach : reajusteproduto.getReajusteprodutoprecoCollection()) {
                reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach = em.getReference(reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach.getClass(), reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach.getCodreajusteprodutopreco());
                attachedReajusteprodutoprecoCollection.add(reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach);
            }
            reajusteproduto.setReajusteprodutoprecoCollection(attachedReajusteprodutoprecoCollection);
            em.persist(reajusteproduto);
            if (codprod != null) {
                codprod.getReajusteprodutoCollection().add(reajusteproduto);
                codprod = em.merge(codprod);
            }
            if (codreajuste != null) {
                codreajuste.getReajusteprodutoCollection().add(reajusteproduto);
                codreajuste = em.merge(codreajuste);
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutopreco : reajusteproduto.getReajusteprodutoprecoCollection()) {
                Reajusteproduto oldCodreajusteprodutoOfReajusteprodutoprecoCollectionReajusteprodutopreco = reajusteprodutoprecoCollectionReajusteprodutopreco.getCodreajusteproduto();
                reajusteprodutoprecoCollectionReajusteprodutopreco.setCodreajusteproduto(reajusteproduto);
                reajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionReajusteprodutopreco);
                if (oldCodreajusteprodutoOfReajusteprodutoprecoCollectionReajusteprodutopreco != null) {
                    oldCodreajusteprodutoOfReajusteprodutoprecoCollectionReajusteprodutopreco.getReajusteprodutoprecoCollection().remove(reajusteprodutoprecoCollectionReajusteprodutopreco);
                    oldCodreajusteprodutoOfReajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(oldCodreajusteprodutoOfReajusteprodutoprecoCollectionReajusteprodutopreco);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReajusteproduto(reajusteproduto.getCodreajusteproduto()) != null) {
                throw new PreexistingEntityException("Reajusteproduto " + reajusteproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reajusteproduto reajusteproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reajusteproduto persistentReajusteproduto = em.find(Reajusteproduto.class, reajusteproduto.getCodreajusteproduto());
            Produto codprodOld = persistentReajusteproduto.getCodprod();
            Produto codprodNew = reajusteproduto.getCodprod();
            Reajuste codreajusteOld = persistentReajusteproduto.getCodreajuste();
            Reajuste codreajusteNew = reajusteproduto.getCodreajuste();
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollectionOld = persistentReajusteproduto.getReajusteprodutoprecoCollection();
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollectionNew = reajusteproduto.getReajusteprodutoprecoCollection();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                reajusteproduto.setCodprod(codprodNew);
            }
            if (codreajusteNew != null) {
                codreajusteNew = em.getReference(codreajusteNew.getClass(), codreajusteNew.getCodreajuste());
                reajusteproduto.setCodreajuste(codreajusteNew);
            }
            Collection<Reajusteprodutopreco> attachedReajusteprodutoprecoCollectionNew = new ArrayList<Reajusteprodutopreco>();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach : reajusteprodutoprecoCollectionNew) {
                reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach = em.getReference(reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach.getClass(), reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach.getCodreajusteprodutopreco());
                attachedReajusteprodutoprecoCollectionNew.add(reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach);
            }
            reajusteprodutoprecoCollectionNew = attachedReajusteprodutoprecoCollectionNew;
            reajusteproduto.setReajusteprodutoprecoCollection(reajusteprodutoprecoCollectionNew);
            reajusteproduto = em.merge(reajusteproduto);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getReajusteprodutoCollection().remove(reajusteproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getReajusteprodutoCollection().add(reajusteproduto);
                codprodNew = em.merge(codprodNew);
            }
            if (codreajusteOld != null && !codreajusteOld.equals(codreajusteNew)) {
                codreajusteOld.getReajusteprodutoCollection().remove(reajusteproduto);
                codreajusteOld = em.merge(codreajusteOld);
            }
            if (codreajusteNew != null && !codreajusteNew.equals(codreajusteOld)) {
                codreajusteNew.getReajusteprodutoCollection().add(reajusteproduto);
                codreajusteNew = em.merge(codreajusteNew);
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionOldReajusteprodutopreco : reajusteprodutoprecoCollectionOld) {
                if (!reajusteprodutoprecoCollectionNew.contains(reajusteprodutoprecoCollectionOldReajusteprodutopreco)) {
                    reajusteprodutoprecoCollectionOldReajusteprodutopreco.setCodreajusteproduto(null);
                    reajusteprodutoprecoCollectionOldReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionOldReajusteprodutopreco);
                }
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionNewReajusteprodutopreco : reajusteprodutoprecoCollectionNew) {
                if (!reajusteprodutoprecoCollectionOld.contains(reajusteprodutoprecoCollectionNewReajusteprodutopreco)) {
                    Reajusteproduto oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco = reajusteprodutoprecoCollectionNewReajusteprodutopreco.getCodreajusteproduto();
                    reajusteprodutoprecoCollectionNewReajusteprodutopreco.setCodreajusteproduto(reajusteproduto);
                    reajusteprodutoprecoCollectionNewReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionNewReajusteprodutopreco);
                    if (oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco != null && !oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco.equals(reajusteproduto)) {
                        oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco.getReajusteprodutoprecoCollection().remove(reajusteprodutoprecoCollectionNewReajusteprodutopreco);
                        oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco = em.merge(oldCodreajusteprodutoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reajusteproduto.getCodreajusteproduto();
                if (findReajusteproduto(id) == null) {
                    throw new NonexistentEntityException("The reajusteproduto with id " + id + " no longer exists.");
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
            Reajusteproduto reajusteproduto;
            try {
                reajusteproduto = em.getReference(Reajusteproduto.class, id);
                reajusteproduto.getCodreajusteproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reajusteproduto with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = reajusteproduto.getCodprod();
            if (codprod != null) {
                codprod.getReajusteprodutoCollection().remove(reajusteproduto);
                codprod = em.merge(codprod);
            }
            Reajuste codreajuste = reajusteproduto.getCodreajuste();
            if (codreajuste != null) {
                codreajuste.getReajusteprodutoCollection().remove(reajusteproduto);
                codreajuste = em.merge(codreajuste);
            }
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection = reajusteproduto.getReajusteprodutoprecoCollection();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutopreco : reajusteprodutoprecoCollection) {
                reajusteprodutoprecoCollectionReajusteprodutopreco.setCodreajusteproduto(null);
                reajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionReajusteprodutopreco);
            }
            em.remove(reajusteproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reajusteproduto> findReajusteprodutoEntities() {
        return findReajusteprodutoEntities(true, -1, -1);
    }

    public List<Reajusteproduto> findReajusteprodutoEntities(int maxResults, int firstResult) {
        return findReajusteprodutoEntities(false, maxResults, firstResult);
    }

    private List<Reajusteproduto> findReajusteprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reajusteproduto.class));
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

    public Reajusteproduto findReajusteproduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reajusteproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getReajusteprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reajusteproduto> rt = cq.from(Reajusteproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
