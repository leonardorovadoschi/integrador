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
import entidade.cplus.Cep;
import entidade.cplus.Tipologradouro;
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
public class TipologradouroJpaController implements Serializable {

    public TipologradouroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipologradouro tipologradouro) throws PreexistingEntityException, Exception {
        if (tipologradouro.getCepCollection() == null) {
            tipologradouro.setCepCollection(new ArrayList<Cep>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cep> attachedCepCollection = new ArrayList<Cep>();
            for (Cep cepCollectionCepToAttach : tipologradouro.getCepCollection()) {
                cepCollectionCepToAttach = em.getReference(cepCollectionCepToAttach.getClass(), cepCollectionCepToAttach.getCodcep());
                attachedCepCollection.add(cepCollectionCepToAttach);
            }
            tipologradouro.setCepCollection(attachedCepCollection);
            em.persist(tipologradouro);
            for (Cep cepCollectionCep : tipologradouro.getCepCollection()) {
                Tipologradouro oldCodtipologradouroOfCepCollectionCep = cepCollectionCep.getCodtipologradouro();
                cepCollectionCep.setCodtipologradouro(tipologradouro);
                cepCollectionCep = em.merge(cepCollectionCep);
                if (oldCodtipologradouroOfCepCollectionCep != null) {
                    oldCodtipologradouroOfCepCollectionCep.getCepCollection().remove(cepCollectionCep);
                    oldCodtipologradouroOfCepCollectionCep = em.merge(oldCodtipologradouroOfCepCollectionCep);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipologradouro(tipologradouro.getCodtipologradouro()) != null) {
                throw new PreexistingEntityException("Tipologradouro " + tipologradouro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipologradouro tipologradouro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipologradouro persistentTipologradouro = em.find(Tipologradouro.class, tipologradouro.getCodtipologradouro());
            Collection<Cep> cepCollectionOld = persistentTipologradouro.getCepCollection();
            Collection<Cep> cepCollectionNew = tipologradouro.getCepCollection();
            Collection<Cep> attachedCepCollectionNew = new ArrayList<Cep>();
            for (Cep cepCollectionNewCepToAttach : cepCollectionNew) {
                cepCollectionNewCepToAttach = em.getReference(cepCollectionNewCepToAttach.getClass(), cepCollectionNewCepToAttach.getCodcep());
                attachedCepCollectionNew.add(cepCollectionNewCepToAttach);
            }
            cepCollectionNew = attachedCepCollectionNew;
            tipologradouro.setCepCollection(cepCollectionNew);
            tipologradouro = em.merge(tipologradouro);
            for (Cep cepCollectionOldCep : cepCollectionOld) {
                if (!cepCollectionNew.contains(cepCollectionOldCep)) {
                    cepCollectionOldCep.setCodtipologradouro(null);
                    cepCollectionOldCep = em.merge(cepCollectionOldCep);
                }
            }
            for (Cep cepCollectionNewCep : cepCollectionNew) {
                if (!cepCollectionOld.contains(cepCollectionNewCep)) {
                    Tipologradouro oldCodtipologradouroOfCepCollectionNewCep = cepCollectionNewCep.getCodtipologradouro();
                    cepCollectionNewCep.setCodtipologradouro(tipologradouro);
                    cepCollectionNewCep = em.merge(cepCollectionNewCep);
                    if (oldCodtipologradouroOfCepCollectionNewCep != null && !oldCodtipologradouroOfCepCollectionNewCep.equals(tipologradouro)) {
                        oldCodtipologradouroOfCepCollectionNewCep.getCepCollection().remove(cepCollectionNewCep);
                        oldCodtipologradouroOfCepCollectionNewCep = em.merge(oldCodtipologradouroOfCepCollectionNewCep);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipologradouro.getCodtipologradouro();
                if (findTipologradouro(id) == null) {
                    throw new NonexistentEntityException("The tipologradouro with id " + id + " no longer exists.");
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
            Tipologradouro tipologradouro;
            try {
                tipologradouro = em.getReference(Tipologradouro.class, id);
                tipologradouro.getCodtipologradouro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipologradouro with id " + id + " no longer exists.", enfe);
            }
            Collection<Cep> cepCollection = tipologradouro.getCepCollection();
            for (Cep cepCollectionCep : cepCollection) {
                cepCollectionCep.setCodtipologradouro(null);
                cepCollectionCep = em.merge(cepCollectionCep);
            }
            em.remove(tipologradouro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipologradouro> findTipologradouroEntities() {
        return findTipologradouroEntities(true, -1, -1);
    }

    public List<Tipologradouro> findTipologradouroEntities(int maxResults, int firstResult) {
        return findTipologradouroEntities(false, maxResults, firstResult);
    }

    private List<Tipologradouro> findTipologradouroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipologradouro.class));
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

    public Tipologradouro findTipologradouro(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipologradouro.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipologradouroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipologradouro> rt = cq.from(Tipologradouro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
