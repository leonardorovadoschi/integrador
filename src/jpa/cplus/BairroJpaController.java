/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Bairro;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Cep;
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
public class BairroJpaController implements Serializable {

    public BairroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bairro bairro) throws PreexistingEntityException, Exception {
        if (bairro.getCepCollection() == null) {
            bairro.setCepCollection(new ArrayList<Cep>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cep> attachedCepCollection = new ArrayList<Cep>();
            for (Cep cepCollectionCepToAttach : bairro.getCepCollection()) {
                cepCollectionCepToAttach = em.getReference(cepCollectionCepToAttach.getClass(), cepCollectionCepToAttach.getCodcep());
                attachedCepCollection.add(cepCollectionCepToAttach);
            }
            bairro.setCepCollection(attachedCepCollection);
            em.persist(bairro);
            for (Cep cepCollectionCep : bairro.getCepCollection()) {
                Bairro oldCodbairroOfCepCollectionCep = cepCollectionCep.getCodbairro();
                cepCollectionCep.setCodbairro(bairro);
                cepCollectionCep = em.merge(cepCollectionCep);
                if (oldCodbairroOfCepCollectionCep != null) {
                    oldCodbairroOfCepCollectionCep.getCepCollection().remove(cepCollectionCep);
                    oldCodbairroOfCepCollectionCep = em.merge(oldCodbairroOfCepCollectionCep);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBairro(bairro.getCodbairro()) != null) {
                throw new PreexistingEntityException("Bairro " + bairro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bairro bairro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bairro persistentBairro = em.find(Bairro.class, bairro.getCodbairro());
            Collection<Cep> cepCollectionOld = persistentBairro.getCepCollection();
            Collection<Cep> cepCollectionNew = bairro.getCepCollection();
            Collection<Cep> attachedCepCollectionNew = new ArrayList<Cep>();
            for (Cep cepCollectionNewCepToAttach : cepCollectionNew) {
                cepCollectionNewCepToAttach = em.getReference(cepCollectionNewCepToAttach.getClass(), cepCollectionNewCepToAttach.getCodcep());
                attachedCepCollectionNew.add(cepCollectionNewCepToAttach);
            }
            cepCollectionNew = attachedCepCollectionNew;
            bairro.setCepCollection(cepCollectionNew);
            bairro = em.merge(bairro);
            for (Cep cepCollectionOldCep : cepCollectionOld) {
                if (!cepCollectionNew.contains(cepCollectionOldCep)) {
                    cepCollectionOldCep.setCodbairro(null);
                    cepCollectionOldCep = em.merge(cepCollectionOldCep);
                }
            }
            for (Cep cepCollectionNewCep : cepCollectionNew) {
                if (!cepCollectionOld.contains(cepCollectionNewCep)) {
                    Bairro oldCodbairroOfCepCollectionNewCep = cepCollectionNewCep.getCodbairro();
                    cepCollectionNewCep.setCodbairro(bairro);
                    cepCollectionNewCep = em.merge(cepCollectionNewCep);
                    if (oldCodbairroOfCepCollectionNewCep != null && !oldCodbairroOfCepCollectionNewCep.equals(bairro)) {
                        oldCodbairroOfCepCollectionNewCep.getCepCollection().remove(cepCollectionNewCep);
                        oldCodbairroOfCepCollectionNewCep = em.merge(oldCodbairroOfCepCollectionNewCep);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bairro.getCodbairro();
                if (findBairro(id) == null) {
                    throw new NonexistentEntityException("The bairro with id " + id + " no longer exists.");
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
            Bairro bairro;
            try {
                bairro = em.getReference(Bairro.class, id);
                bairro.getCodbairro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bairro with id " + id + " no longer exists.", enfe);
            }
            Collection<Cep> cepCollection = bairro.getCepCollection();
            for (Cep cepCollectionCep : cepCollection) {
                cepCollectionCep.setCodbairro(null);
                cepCollectionCep = em.merge(cepCollectionCep);
            }
            em.remove(bairro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bairro> findBairroEntities() {
        return findBairroEntities(true, -1, -1);
    }

    public List<Bairro> findBairroEntities(int maxResults, int firstResult) {
        return findBairroEntities(false, maxResults, firstResult);
    }

    private List<Bairro> findBairroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bairro.class));
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

    public Bairro findBairro(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bairro.class, id);
        } finally {
            em.close();
        }
    }

    public int getBairroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bairro> rt = cq.from(Bairro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
