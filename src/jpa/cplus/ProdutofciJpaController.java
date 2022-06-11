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
import entidade.cplus.Movendaprodfci;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprodfci;
import entidade.cplus.Produtofci;
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
public class ProdutofciJpaController implements Serializable {

    public ProdutofciJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtofci produtofci) throws PreexistingEntityException, Exception {
        if (produtofci.getMovendaprodfciCollection() == null) {
            produtofci.setMovendaprodfciCollection(new ArrayList<Movendaprodfci>());
        }
        if (produtofci.getMoventradaprodfciCollection() == null) {
            produtofci.setMoventradaprodfciCollection(new ArrayList<Moventradaprodfci>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtofci.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtofci.setCodprod(codprod);
            }
            Collection<Movendaprodfci> attachedMovendaprodfciCollection = new ArrayList<Movendaprodfci>();
            for (Movendaprodfci movendaprodfciCollectionMovendaprodfciToAttach : produtofci.getMovendaprodfciCollection()) {
                movendaprodfciCollectionMovendaprodfciToAttach = em.getReference(movendaprodfciCollectionMovendaprodfciToAttach.getClass(), movendaprodfciCollectionMovendaprodfciToAttach.getCodmovendaprodfci());
                attachedMovendaprodfciCollection.add(movendaprodfciCollectionMovendaprodfciToAttach);
            }
            produtofci.setMovendaprodfciCollection(attachedMovendaprodfciCollection);
            Collection<Moventradaprodfci> attachedMoventradaprodfciCollection = new ArrayList<Moventradaprodfci>();
            for (Moventradaprodfci moventradaprodfciCollectionMoventradaprodfciToAttach : produtofci.getMoventradaprodfciCollection()) {
                moventradaprodfciCollectionMoventradaprodfciToAttach = em.getReference(moventradaprodfciCollectionMoventradaprodfciToAttach.getClass(), moventradaprodfciCollectionMoventradaprodfciToAttach.getCodmoventradaprodfci());
                attachedMoventradaprodfciCollection.add(moventradaprodfciCollectionMoventradaprodfciToAttach);
            }
            produtofci.setMoventradaprodfciCollection(attachedMoventradaprodfciCollection);
            em.persist(produtofci);
            if (codprod != null) {
                codprod.getProdutofciCollection().add(produtofci);
                codprod = em.merge(codprod);
            }
            for (Movendaprodfci movendaprodfciCollectionMovendaprodfci : produtofci.getMovendaprodfciCollection()) {
                Produtofci oldCodprodutofciOfMovendaprodfciCollectionMovendaprodfci = movendaprodfciCollectionMovendaprodfci.getCodprodutofci();
                movendaprodfciCollectionMovendaprodfci.setCodprodutofci(produtofci);
                movendaprodfciCollectionMovendaprodfci = em.merge(movendaprodfciCollectionMovendaprodfci);
                if (oldCodprodutofciOfMovendaprodfciCollectionMovendaprodfci != null) {
                    oldCodprodutofciOfMovendaprodfciCollectionMovendaprodfci.getMovendaprodfciCollection().remove(movendaprodfciCollectionMovendaprodfci);
                    oldCodprodutofciOfMovendaprodfciCollectionMovendaprodfci = em.merge(oldCodprodutofciOfMovendaprodfciCollectionMovendaprodfci);
                }
            }
            for (Moventradaprodfci moventradaprodfciCollectionMoventradaprodfci : produtofci.getMoventradaprodfciCollection()) {
                Produtofci oldCodprodutofciOfMoventradaprodfciCollectionMoventradaprodfci = moventradaprodfciCollectionMoventradaprodfci.getCodprodutofci();
                moventradaprodfciCollectionMoventradaprodfci.setCodprodutofci(produtofci);
                moventradaprodfciCollectionMoventradaprodfci = em.merge(moventradaprodfciCollectionMoventradaprodfci);
                if (oldCodprodutofciOfMoventradaprodfciCollectionMoventradaprodfci != null) {
                    oldCodprodutofciOfMoventradaprodfciCollectionMoventradaprodfci.getMoventradaprodfciCollection().remove(moventradaprodfciCollectionMoventradaprodfci);
                    oldCodprodutofciOfMoventradaprodfciCollectionMoventradaprodfci = em.merge(oldCodprodutofciOfMoventradaprodfciCollectionMoventradaprodfci);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutofci(produtofci.getCodprodutofci()) != null) {
                throw new PreexistingEntityException("Produtofci " + produtofci + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtofci produtofci) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtofci persistentProdutofci = em.find(Produtofci.class, produtofci.getCodprodutofci());
            Produto codprodOld = persistentProdutofci.getCodprod();
            Produto codprodNew = produtofci.getCodprod();
            Collection<Movendaprodfci> movendaprodfciCollectionOld = persistentProdutofci.getMovendaprodfciCollection();
            Collection<Movendaprodfci> movendaprodfciCollectionNew = produtofci.getMovendaprodfciCollection();
            Collection<Moventradaprodfci> moventradaprodfciCollectionOld = persistentProdutofci.getMoventradaprodfciCollection();
            Collection<Moventradaprodfci> moventradaprodfciCollectionNew = produtofci.getMoventradaprodfciCollection();
            List<String> illegalOrphanMessages = null;
            for (Movendaprodfci movendaprodfciCollectionOldMovendaprodfci : movendaprodfciCollectionOld) {
                if (!movendaprodfciCollectionNew.contains(movendaprodfciCollectionOldMovendaprodfci)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movendaprodfci " + movendaprodfciCollectionOldMovendaprodfci + " since its codprodutofci field is not nullable.");
                }
            }
            for (Moventradaprodfci moventradaprodfciCollectionOldMoventradaprodfci : moventradaprodfciCollectionOld) {
                if (!moventradaprodfciCollectionNew.contains(moventradaprodfciCollectionOldMoventradaprodfci)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventradaprodfci " + moventradaprodfciCollectionOldMoventradaprodfci + " since its codprodutofci field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtofci.setCodprod(codprodNew);
            }
            Collection<Movendaprodfci> attachedMovendaprodfciCollectionNew = new ArrayList<Movendaprodfci>();
            for (Movendaprodfci movendaprodfciCollectionNewMovendaprodfciToAttach : movendaprodfciCollectionNew) {
                movendaprodfciCollectionNewMovendaprodfciToAttach = em.getReference(movendaprodfciCollectionNewMovendaprodfciToAttach.getClass(), movendaprodfciCollectionNewMovendaprodfciToAttach.getCodmovendaprodfci());
                attachedMovendaprodfciCollectionNew.add(movendaprodfciCollectionNewMovendaprodfciToAttach);
            }
            movendaprodfciCollectionNew = attachedMovendaprodfciCollectionNew;
            produtofci.setMovendaprodfciCollection(movendaprodfciCollectionNew);
            Collection<Moventradaprodfci> attachedMoventradaprodfciCollectionNew = new ArrayList<Moventradaprodfci>();
            for (Moventradaprodfci moventradaprodfciCollectionNewMoventradaprodfciToAttach : moventradaprodfciCollectionNew) {
                moventradaprodfciCollectionNewMoventradaprodfciToAttach = em.getReference(moventradaprodfciCollectionNewMoventradaprodfciToAttach.getClass(), moventradaprodfciCollectionNewMoventradaprodfciToAttach.getCodmoventradaprodfci());
                attachedMoventradaprodfciCollectionNew.add(moventradaprodfciCollectionNewMoventradaprodfciToAttach);
            }
            moventradaprodfciCollectionNew = attachedMoventradaprodfciCollectionNew;
            produtofci.setMoventradaprodfciCollection(moventradaprodfciCollectionNew);
            produtofci = em.merge(produtofci);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutofciCollection().remove(produtofci);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutofciCollection().add(produtofci);
                codprodNew = em.merge(codprodNew);
            }
            for (Movendaprodfci movendaprodfciCollectionNewMovendaprodfci : movendaprodfciCollectionNew) {
                if (!movendaprodfciCollectionOld.contains(movendaprodfciCollectionNewMovendaprodfci)) {
                    Produtofci oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci = movendaprodfciCollectionNewMovendaprodfci.getCodprodutofci();
                    movendaprodfciCollectionNewMovendaprodfci.setCodprodutofci(produtofci);
                    movendaprodfciCollectionNewMovendaprodfci = em.merge(movendaprodfciCollectionNewMovendaprodfci);
                    if (oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci != null && !oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci.equals(produtofci)) {
                        oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci.getMovendaprodfciCollection().remove(movendaprodfciCollectionNewMovendaprodfci);
                        oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci = em.merge(oldCodprodutofciOfMovendaprodfciCollectionNewMovendaprodfci);
                    }
                }
            }
            for (Moventradaprodfci moventradaprodfciCollectionNewMoventradaprodfci : moventradaprodfciCollectionNew) {
                if (!moventradaprodfciCollectionOld.contains(moventradaprodfciCollectionNewMoventradaprodfci)) {
                    Produtofci oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci = moventradaprodfciCollectionNewMoventradaprodfci.getCodprodutofci();
                    moventradaprodfciCollectionNewMoventradaprodfci.setCodprodutofci(produtofci);
                    moventradaprodfciCollectionNewMoventradaprodfci = em.merge(moventradaprodfciCollectionNewMoventradaprodfci);
                    if (oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci != null && !oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci.equals(produtofci)) {
                        oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci.getMoventradaprodfciCollection().remove(moventradaprodfciCollectionNewMoventradaprodfci);
                        oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci = em.merge(oldCodprodutofciOfMoventradaprodfciCollectionNewMoventradaprodfci);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtofci.getCodprodutofci();
                if (findProdutofci(id) == null) {
                    throw new NonexistentEntityException("The produtofci with id " + id + " no longer exists.");
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
            Produtofci produtofci;
            try {
                produtofci = em.getReference(Produtofci.class, id);
                produtofci.getCodprodutofci();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtofci with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Movendaprodfci> movendaprodfciCollectionOrphanCheck = produtofci.getMovendaprodfciCollection();
            for (Movendaprodfci movendaprodfciCollectionOrphanCheckMovendaprodfci : movendaprodfciCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtofci (" + produtofci + ") cannot be destroyed since the Movendaprodfci " + movendaprodfciCollectionOrphanCheckMovendaprodfci + " in its movendaprodfciCollection field has a non-nullable codprodutofci field.");
            }
            Collection<Moventradaprodfci> moventradaprodfciCollectionOrphanCheck = produtofci.getMoventradaprodfciCollection();
            for (Moventradaprodfci moventradaprodfciCollectionOrphanCheckMoventradaprodfci : moventradaprodfciCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtofci (" + produtofci + ") cannot be destroyed since the Moventradaprodfci " + moventradaprodfciCollectionOrphanCheckMoventradaprodfci + " in its moventradaprodfciCollection field has a non-nullable codprodutofci field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Produto codprod = produtofci.getCodprod();
            if (codprod != null) {
                codprod.getProdutofciCollection().remove(produtofci);
                codprod = em.merge(codprod);
            }
            em.remove(produtofci);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtofci> findProdutofciEntities() {
        return findProdutofciEntities(true, -1, -1);
    }

    public List<Produtofci> findProdutofciEntities(int maxResults, int firstResult) {
        return findProdutofciEntities(false, maxResults, firstResult);
    }

    private List<Produtofci> findProdutofciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtofci.class));
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

    public Produtofci findProdutofci(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtofci.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutofciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtofci> rt = cq.from(Produtofci.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
