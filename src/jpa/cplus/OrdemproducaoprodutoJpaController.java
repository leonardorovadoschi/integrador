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
import entidade.cplus.Ordemproducao;
import entidade.cplus.Ordemproducaoproduto;
import entidade.cplus.Ordemproducaoprodutoitem;
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
public class OrdemproducaoprodutoJpaController implements Serializable {

    public OrdemproducaoprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemproducaoproduto ordemproducaoproduto) throws PreexistingEntityException, Exception {
        if (ordemproducaoproduto.getOrdemproducaoprodutoitemCollection() == null) {
            ordemproducaoproduto.setOrdemproducaoprodutoitemCollection(new ArrayList<Ordemproducaoprodutoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducao codordemproducao = ordemproducaoproduto.getCodordemproducao();
            if (codordemproducao != null) {
                codordemproducao = em.getReference(codordemproducao.getClass(), codordemproducao.getCodordemproducao());
                ordemproducaoproduto.setCodordemproducao(codordemproducao);
            }
            Collection<Ordemproducaoprodutoitem> attachedOrdemproducaoprodutoitemCollection = new ArrayList<Ordemproducaoprodutoitem>();
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitemToAttach : ordemproducaoproduto.getOrdemproducaoprodutoitemCollection()) {
                ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitemToAttach = em.getReference(ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitemToAttach.getClass(), ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitemToAttach.getCodordemproducaoprodutoitem());
                attachedOrdemproducaoprodutoitemCollection.add(ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitemToAttach);
            }
            ordemproducaoproduto.setOrdemproducaoprodutoitemCollection(attachedOrdemproducaoprodutoitemCollection);
            em.persist(ordemproducaoproduto);
            if (codordemproducao != null) {
                codordemproducao.getOrdemproducaoprodutoCollection().add(ordemproducaoproduto);
                codordemproducao = em.merge(codordemproducao);
            }
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem : ordemproducaoproduto.getOrdemproducaoprodutoitemCollection()) {
                Ordemproducaoproduto oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionOrdemproducaoprodutoitem = ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem.getCodordemproducaoproduto();
                ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem.setCodordemproducaoproduto(ordemproducaoproduto);
                ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem = em.merge(ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem);
                if (oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionOrdemproducaoprodutoitem != null) {
                    oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionOrdemproducaoprodutoitem.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem);
                    oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionOrdemproducaoprodutoitem = em.merge(oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionOrdemproducaoprodutoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemproducaoproduto(ordemproducaoproduto.getCodordemproducaoproduto()) != null) {
                throw new PreexistingEntityException("Ordemproducaoproduto " + ordemproducaoproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemproducaoproduto ordemproducaoproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducaoproduto persistentOrdemproducaoproduto = em.find(Ordemproducaoproduto.class, ordemproducaoproduto.getCodordemproducaoproduto());
            Ordemproducao codordemproducaoOld = persistentOrdemproducaoproduto.getCodordemproducao();
            Ordemproducao codordemproducaoNew = ordemproducaoproduto.getCodordemproducao();
            Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollectionOld = persistentOrdemproducaoproduto.getOrdemproducaoprodutoitemCollection();
            Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollectionNew = ordemproducaoproduto.getOrdemproducaoprodutoitemCollection();
            if (codordemproducaoNew != null) {
                codordemproducaoNew = em.getReference(codordemproducaoNew.getClass(), codordemproducaoNew.getCodordemproducao());
                ordemproducaoproduto.setCodordemproducao(codordemproducaoNew);
            }
            Collection<Ordemproducaoprodutoitem> attachedOrdemproducaoprodutoitemCollectionNew = new ArrayList<Ordemproducaoprodutoitem>();
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitemToAttach : ordemproducaoprodutoitemCollectionNew) {
                ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitemToAttach = em.getReference(ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitemToAttach.getClass(), ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitemToAttach.getCodordemproducaoprodutoitem());
                attachedOrdemproducaoprodutoitemCollectionNew.add(ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitemToAttach);
            }
            ordemproducaoprodutoitemCollectionNew = attachedOrdemproducaoprodutoitemCollectionNew;
            ordemproducaoproduto.setOrdemproducaoprodutoitemCollection(ordemproducaoprodutoitemCollectionNew);
            ordemproducaoproduto = em.merge(ordemproducaoproduto);
            if (codordemproducaoOld != null && !codordemproducaoOld.equals(codordemproducaoNew)) {
                codordemproducaoOld.getOrdemproducaoprodutoCollection().remove(ordemproducaoproduto);
                codordemproducaoOld = em.merge(codordemproducaoOld);
            }
            if (codordemproducaoNew != null && !codordemproducaoNew.equals(codordemproducaoOld)) {
                codordemproducaoNew.getOrdemproducaoprodutoCollection().add(ordemproducaoproduto);
                codordemproducaoNew = em.merge(codordemproducaoNew);
            }
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionOldOrdemproducaoprodutoitem : ordemproducaoprodutoitemCollectionOld) {
                if (!ordemproducaoprodutoitemCollectionNew.contains(ordemproducaoprodutoitemCollectionOldOrdemproducaoprodutoitem)) {
                    ordemproducaoprodutoitemCollectionOldOrdemproducaoprodutoitem.setCodordemproducaoproduto(null);
                    ordemproducaoprodutoitemCollectionOldOrdemproducaoprodutoitem = em.merge(ordemproducaoprodutoitemCollectionOldOrdemproducaoprodutoitem);
                }
            }
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem : ordemproducaoprodutoitemCollectionNew) {
                if (!ordemproducaoprodutoitemCollectionOld.contains(ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem)) {
                    Ordemproducaoproduto oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem = ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem.getCodordemproducaoproduto();
                    ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem.setCodordemproducaoproduto(ordemproducaoproduto);
                    ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem = em.merge(ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem);
                    if (oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem != null && !oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem.equals(ordemproducaoproduto)) {
                        oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem);
                        oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem = em.merge(oldCodordemproducaoprodutoOfOrdemproducaoprodutoitemCollectionNewOrdemproducaoprodutoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemproducaoproduto.getCodordemproducaoproduto();
                if (findOrdemproducaoproduto(id) == null) {
                    throw new NonexistentEntityException("The ordemproducaoproduto with id " + id + " no longer exists.");
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
            Ordemproducaoproduto ordemproducaoproduto;
            try {
                ordemproducaoproduto = em.getReference(Ordemproducaoproduto.class, id);
                ordemproducaoproduto.getCodordemproducaoproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemproducaoproduto with id " + id + " no longer exists.", enfe);
            }
            Ordemproducao codordemproducao = ordemproducaoproduto.getCodordemproducao();
            if (codordemproducao != null) {
                codordemproducao.getOrdemproducaoprodutoCollection().remove(ordemproducaoproduto);
                codordemproducao = em.merge(codordemproducao);
            }
            Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollection = ordemproducaoproduto.getOrdemproducaoprodutoitemCollection();
            for (Ordemproducaoprodutoitem ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem : ordemproducaoprodutoitemCollection) {
                ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem.setCodordemproducaoproduto(null);
                ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem = em.merge(ordemproducaoprodutoitemCollectionOrdemproducaoprodutoitem);
            }
            em.remove(ordemproducaoproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemproducaoproduto> findOrdemproducaoprodutoEntities() {
        return findOrdemproducaoprodutoEntities(true, -1, -1);
    }

    public List<Ordemproducaoproduto> findOrdemproducaoprodutoEntities(int maxResults, int firstResult) {
        return findOrdemproducaoprodutoEntities(false, maxResults, firstResult);
    }

    private List<Ordemproducaoproduto> findOrdemproducaoprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemproducaoproduto.class));
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

    public Ordemproducaoproduto findOrdemproducaoproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemproducaoproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemproducaoprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemproducaoproduto> rt = cq.from(Ordemproducaoproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
