/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Ordemproducao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Setorestoque;
import entidade.cplus.Producaohistorico;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Ordemproducaoproduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrdemproducaoJpaController implements Serializable {

    public OrdemproducaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemproducao ordemproducao) throws PreexistingEntityException, Exception {
        if (ordemproducao.getProducaohistoricoCollection() == null) {
            ordemproducao.setProducaohistoricoCollection(new ArrayList<Producaohistorico>());
        }
        if (ordemproducao.getOrdemproducaoprodutoCollection() == null) {
            ordemproducao.setOrdemproducaoprodutoCollection(new ArrayList<Ordemproducaoproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setorestoque codsetorestoqueentrada = ordemproducao.getCodsetorestoqueentrada();
            if (codsetorestoqueentrada != null) {
                codsetorestoqueentrada = em.getReference(codsetorestoqueentrada.getClass(), codsetorestoqueentrada.getCodsetorestoque());
                ordemproducao.setCodsetorestoqueentrada(codsetorestoqueentrada);
            }
            Collection<Producaohistorico> attachedProducaohistoricoCollection = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionProducaohistoricoToAttach : ordemproducao.getProducaohistoricoCollection()) {
                producaohistoricoCollectionProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionProducaohistoricoToAttach.getClass(), producaohistoricoCollectionProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollection.add(producaohistoricoCollectionProducaohistoricoToAttach);
            }
            ordemproducao.setProducaohistoricoCollection(attachedProducaohistoricoCollection);
            Collection<Ordemproducaoproduto> attachedOrdemproducaoprodutoCollection = new ArrayList<Ordemproducaoproduto>();
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionOrdemproducaoprodutoToAttach : ordemproducao.getOrdemproducaoprodutoCollection()) {
                ordemproducaoprodutoCollectionOrdemproducaoprodutoToAttach = em.getReference(ordemproducaoprodutoCollectionOrdemproducaoprodutoToAttach.getClass(), ordemproducaoprodutoCollectionOrdemproducaoprodutoToAttach.getCodordemproducaoproduto());
                attachedOrdemproducaoprodutoCollection.add(ordemproducaoprodutoCollectionOrdemproducaoprodutoToAttach);
            }
            ordemproducao.setOrdemproducaoprodutoCollection(attachedOrdemproducaoprodutoCollection);
            em.persist(ordemproducao);
            if (codsetorestoqueentrada != null) {
                codsetorestoqueentrada.getOrdemproducaoCollection().add(ordemproducao);
                codsetorestoqueentrada = em.merge(codsetorestoqueentrada);
            }
            for (Producaohistorico producaohistoricoCollectionProducaohistorico : ordemproducao.getProducaohistoricoCollection()) {
                Ordemproducao oldCodordemproducaoOfProducaohistoricoCollectionProducaohistorico = producaohistoricoCollectionProducaohistorico.getCodordemproducao();
                producaohistoricoCollectionProducaohistorico.setCodordemproducao(ordemproducao);
                producaohistoricoCollectionProducaohistorico = em.merge(producaohistoricoCollectionProducaohistorico);
                if (oldCodordemproducaoOfProducaohistoricoCollectionProducaohistorico != null) {
                    oldCodordemproducaoOfProducaohistoricoCollectionProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionProducaohistorico);
                    oldCodordemproducaoOfProducaohistoricoCollectionProducaohistorico = em.merge(oldCodordemproducaoOfProducaohistoricoCollectionProducaohistorico);
                }
            }
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionOrdemproducaoproduto : ordemproducao.getOrdemproducaoprodutoCollection()) {
                Ordemproducao oldCodordemproducaoOfOrdemproducaoprodutoCollectionOrdemproducaoproduto = ordemproducaoprodutoCollectionOrdemproducaoproduto.getCodordemproducao();
                ordemproducaoprodutoCollectionOrdemproducaoproduto.setCodordemproducao(ordemproducao);
                ordemproducaoprodutoCollectionOrdemproducaoproduto = em.merge(ordemproducaoprodutoCollectionOrdemproducaoproduto);
                if (oldCodordemproducaoOfOrdemproducaoprodutoCollectionOrdemproducaoproduto != null) {
                    oldCodordemproducaoOfOrdemproducaoprodutoCollectionOrdemproducaoproduto.getOrdemproducaoprodutoCollection().remove(ordemproducaoprodutoCollectionOrdemproducaoproduto);
                    oldCodordemproducaoOfOrdemproducaoprodutoCollectionOrdemproducaoproduto = em.merge(oldCodordemproducaoOfOrdemproducaoprodutoCollectionOrdemproducaoproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemproducao(ordemproducao.getCodordemproducao()) != null) {
                throw new PreexistingEntityException("Ordemproducao " + ordemproducao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemproducao ordemproducao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducao persistentOrdemproducao = em.find(Ordemproducao.class, ordemproducao.getCodordemproducao());
            Setorestoque codsetorestoqueentradaOld = persistentOrdemproducao.getCodsetorestoqueentrada();
            Setorestoque codsetorestoqueentradaNew = ordemproducao.getCodsetorestoqueentrada();
            Collection<Producaohistorico> producaohistoricoCollectionOld = persistentOrdemproducao.getProducaohistoricoCollection();
            Collection<Producaohistorico> producaohistoricoCollectionNew = ordemproducao.getProducaohistoricoCollection();
            Collection<Ordemproducaoproduto> ordemproducaoprodutoCollectionOld = persistentOrdemproducao.getOrdemproducaoprodutoCollection();
            Collection<Ordemproducaoproduto> ordemproducaoprodutoCollectionNew = ordemproducao.getOrdemproducaoprodutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Producaohistorico producaohistoricoCollectionOldProducaohistorico : producaohistoricoCollectionOld) {
                if (!producaohistoricoCollectionNew.contains(producaohistoricoCollectionOldProducaohistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producaohistorico " + producaohistoricoCollectionOldProducaohistorico + " since its codordemproducao field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codsetorestoqueentradaNew != null) {
                codsetorestoqueentradaNew = em.getReference(codsetorestoqueentradaNew.getClass(), codsetorestoqueentradaNew.getCodsetorestoque());
                ordemproducao.setCodsetorestoqueentrada(codsetorestoqueentradaNew);
            }
            Collection<Producaohistorico> attachedProducaohistoricoCollectionNew = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionNewProducaohistoricoToAttach : producaohistoricoCollectionNew) {
                producaohistoricoCollectionNewProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionNewProducaohistoricoToAttach.getClass(), producaohistoricoCollectionNewProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollectionNew.add(producaohistoricoCollectionNewProducaohistoricoToAttach);
            }
            producaohistoricoCollectionNew = attachedProducaohistoricoCollectionNew;
            ordemproducao.setProducaohistoricoCollection(producaohistoricoCollectionNew);
            Collection<Ordemproducaoproduto> attachedOrdemproducaoprodutoCollectionNew = new ArrayList<Ordemproducaoproduto>();
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionNewOrdemproducaoprodutoToAttach : ordemproducaoprodutoCollectionNew) {
                ordemproducaoprodutoCollectionNewOrdemproducaoprodutoToAttach = em.getReference(ordemproducaoprodutoCollectionNewOrdemproducaoprodutoToAttach.getClass(), ordemproducaoprodutoCollectionNewOrdemproducaoprodutoToAttach.getCodordemproducaoproduto());
                attachedOrdemproducaoprodutoCollectionNew.add(ordemproducaoprodutoCollectionNewOrdemproducaoprodutoToAttach);
            }
            ordemproducaoprodutoCollectionNew = attachedOrdemproducaoprodutoCollectionNew;
            ordemproducao.setOrdemproducaoprodutoCollection(ordemproducaoprodutoCollectionNew);
            ordemproducao = em.merge(ordemproducao);
            if (codsetorestoqueentradaOld != null && !codsetorestoqueentradaOld.equals(codsetorestoqueentradaNew)) {
                codsetorestoqueentradaOld.getOrdemproducaoCollection().remove(ordemproducao);
                codsetorestoqueentradaOld = em.merge(codsetorestoqueentradaOld);
            }
            if (codsetorestoqueentradaNew != null && !codsetorestoqueentradaNew.equals(codsetorestoqueentradaOld)) {
                codsetorestoqueentradaNew.getOrdemproducaoCollection().add(ordemproducao);
                codsetorestoqueentradaNew = em.merge(codsetorestoqueentradaNew);
            }
            for (Producaohistorico producaohistoricoCollectionNewProducaohistorico : producaohistoricoCollectionNew) {
                if (!producaohistoricoCollectionOld.contains(producaohistoricoCollectionNewProducaohistorico)) {
                    Ordemproducao oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico = producaohistoricoCollectionNewProducaohistorico.getCodordemproducao();
                    producaohistoricoCollectionNewProducaohistorico.setCodordemproducao(ordemproducao);
                    producaohistoricoCollectionNewProducaohistorico = em.merge(producaohistoricoCollectionNewProducaohistorico);
                    if (oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico != null && !oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico.equals(ordemproducao)) {
                        oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionNewProducaohistorico);
                        oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico = em.merge(oldCodordemproducaoOfProducaohistoricoCollectionNewProducaohistorico);
                    }
                }
            }
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionOldOrdemproducaoproduto : ordemproducaoprodutoCollectionOld) {
                if (!ordemproducaoprodutoCollectionNew.contains(ordemproducaoprodutoCollectionOldOrdemproducaoproduto)) {
                    ordemproducaoprodutoCollectionOldOrdemproducaoproduto.setCodordemproducao(null);
                    ordemproducaoprodutoCollectionOldOrdemproducaoproduto = em.merge(ordemproducaoprodutoCollectionOldOrdemproducaoproduto);
                }
            }
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionNewOrdemproducaoproduto : ordemproducaoprodutoCollectionNew) {
                if (!ordemproducaoprodutoCollectionOld.contains(ordemproducaoprodutoCollectionNewOrdemproducaoproduto)) {
                    Ordemproducao oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto = ordemproducaoprodutoCollectionNewOrdemproducaoproduto.getCodordemproducao();
                    ordemproducaoprodutoCollectionNewOrdemproducaoproduto.setCodordemproducao(ordemproducao);
                    ordemproducaoprodutoCollectionNewOrdemproducaoproduto = em.merge(ordemproducaoprodutoCollectionNewOrdemproducaoproduto);
                    if (oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto != null && !oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto.equals(ordemproducao)) {
                        oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto.getOrdemproducaoprodutoCollection().remove(ordemproducaoprodutoCollectionNewOrdemproducaoproduto);
                        oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto = em.merge(oldCodordemproducaoOfOrdemproducaoprodutoCollectionNewOrdemproducaoproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemproducao.getCodordemproducao();
                if (findOrdemproducao(id) == null) {
                    throw new NonexistentEntityException("The ordemproducao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducao ordemproducao;
            try {
                ordemproducao = em.getReference(Ordemproducao.class, id);
                ordemproducao.getCodordemproducao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemproducao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Producaohistorico> producaohistoricoCollectionOrphanCheck = ordemproducao.getProducaohistoricoCollection();
            for (Producaohistorico producaohistoricoCollectionOrphanCheckProducaohistorico : producaohistoricoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordemproducao (" + ordemproducao + ") cannot be destroyed since the Producaohistorico " + producaohistoricoCollectionOrphanCheckProducaohistorico + " in its producaohistoricoCollection field has a non-nullable codordemproducao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Setorestoque codsetorestoqueentrada = ordemproducao.getCodsetorestoqueentrada();
            if (codsetorestoqueentrada != null) {
                codsetorestoqueentrada.getOrdemproducaoCollection().remove(ordemproducao);
                codsetorestoqueentrada = em.merge(codsetorestoqueentrada);
            }
            Collection<Ordemproducaoproduto> ordemproducaoprodutoCollection = ordemproducao.getOrdemproducaoprodutoCollection();
            for (Ordemproducaoproduto ordemproducaoprodutoCollectionOrdemproducaoproduto : ordemproducaoprodutoCollection) {
                ordemproducaoprodutoCollectionOrdemproducaoproduto.setCodordemproducao(null);
                ordemproducaoprodutoCollectionOrdemproducaoproduto = em.merge(ordemproducaoprodutoCollectionOrdemproducaoproduto);
            }
            em.remove(ordemproducao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemproducao> findOrdemproducaoEntities() {
        return findOrdemproducaoEntities(true, -1, -1);
    }

    public List<Ordemproducao> findOrdemproducaoEntities(int maxResults, int firstResult) {
        return findOrdemproducaoEntities(false, maxResults, firstResult);
    }

    private List<Ordemproducao> findOrdemproducaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemproducao.class));
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

    public Ordemproducao findOrdemproducao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemproducao.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemproducaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemproducao> rt = cq.from(Ordemproducao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
