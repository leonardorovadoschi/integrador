/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Calculoicms;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Calculoicmsestado;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Produto;
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
public class CalculoicmsJpaController implements Serializable {

    public CalculoicmsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calculoicms calculoicms) throws PreexistingEntityException, Exception {
        if (calculoicms.getCalculoicmsestadoCollection() == null) {
            calculoicms.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (calculoicms.getProdutoCollection() == null) {
            calculoicms.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : calculoicms.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            calculoicms.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : calculoicms.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            calculoicms.setProdutoCollection(attachedProdutoCollection);
            em.persist(calculoicms);
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : calculoicms.getCalculoicmsestadoCollection()) {
                Calculoicms oldCodcalculoicmsOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodcalculoicms();
                calculoicmsestadoCollectionCalculoicmsestado.setCodcalculoicms(calculoicms);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodcalculoicmsOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodcalculoicmsOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodcalculoicmsOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodcalculoicmsOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Produto produtoCollectionProduto : calculoicms.getProdutoCollection()) {
                Calculoicms oldCodcalculoicmsOfProdutoCollectionProduto = produtoCollectionProduto.getCodcalculoicms();
                produtoCollectionProduto.setCodcalculoicms(calculoicms);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodcalculoicmsOfProdutoCollectionProduto != null) {
                    oldCodcalculoicmsOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodcalculoicmsOfProdutoCollectionProduto = em.merge(oldCodcalculoicmsOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalculoicms(calculoicms.getCodcalculoicms()) != null) {
                throw new PreexistingEntityException("Calculoicms " + calculoicms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calculoicms calculoicms) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calculoicms persistentCalculoicms = em.find(Calculoicms.class, calculoicms.getCodcalculoicms());
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentCalculoicms.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = calculoicms.getCalculoicmsestadoCollection();
            Collection<Produto> produtoCollectionOld = persistentCalculoicms.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = calculoicms.getProdutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calculoicmsestado " + calculoicmsestadoCollectionOldCalculoicmsestado + " since its codcalculoicms field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            calculoicms.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            calculoicms.setProdutoCollection(produtoCollectionNew);
            calculoicms = em.merge(calculoicms);
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Calculoicms oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodcalculoicms();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodcalculoicms(calculoicms);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(calculoicms)) {
                        oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodcalculoicmsOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodcalculoicms(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Calculoicms oldCodcalculoicmsOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodcalculoicms();
                    produtoCollectionNewProduto.setCodcalculoicms(calculoicms);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodcalculoicmsOfProdutoCollectionNewProduto != null && !oldCodcalculoicmsOfProdutoCollectionNewProduto.equals(calculoicms)) {
                        oldCodcalculoicmsOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodcalculoicmsOfProdutoCollectionNewProduto = em.merge(oldCodcalculoicmsOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = calculoicms.getCodcalculoicms();
                if (findCalculoicms(id) == null) {
                    throw new NonexistentEntityException("The calculoicms with id " + id + " no longer exists.");
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
            Calculoicms calculoicms;
            try {
                calculoicms = em.getReference(Calculoicms.class, id);
                calculoicms.getCodcalculoicms();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calculoicms with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOrphanCheck = calculoicms.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionOrphanCheckCalculoicmsestado : calculoicmsestadoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Calculoicms (" + calculoicms + ") cannot be destroyed since the Calculoicmsestado " + calculoicmsestadoCollectionOrphanCheckCalculoicmsestado + " in its calculoicmsestadoCollection field has a non-nullable codcalculoicms field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Produto> produtoCollection = calculoicms.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodcalculoicms(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(calculoicms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calculoicms> findCalculoicmsEntities() {
        return findCalculoicmsEntities(true, -1, -1);
    }

    public List<Calculoicms> findCalculoicmsEntities(int maxResults, int firstResult) {
        return findCalculoicmsEntities(false, maxResults, firstResult);
    }

    private List<Calculoicms> findCalculoicmsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calculoicms.class));
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

    public Calculoicms findCalculoicms(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calculoicms.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalculoicmsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calculoicms> rt = cq.from(Calculoicms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
