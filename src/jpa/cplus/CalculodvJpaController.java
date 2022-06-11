/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Calculodv;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Contabancaria;
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
public class CalculodvJpaController implements Serializable {

    public CalculodvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calculodv calculodv) throws PreexistingEntityException, Exception {
        if (calculodv.getContabancariaCollection() == null) {
            calculodv.setContabancariaCollection(new ArrayList<Contabancaria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Contabancaria> attachedContabancariaCollection = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionContabancariaToAttach : calculodv.getContabancariaCollection()) {
                contabancariaCollectionContabancariaToAttach = em.getReference(contabancariaCollectionContabancariaToAttach.getClass(), contabancariaCollectionContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollection.add(contabancariaCollectionContabancariaToAttach);
            }
            calculodv.setContabancariaCollection(attachedContabancariaCollection);
            em.persist(calculodv);
            for (Contabancaria contabancariaCollectionContabancaria : calculodv.getContabancariaCollection()) {
                Calculodv oldCodcalculodvOfContabancariaCollectionContabancaria = contabancariaCollectionContabancaria.getCodcalculodv();
                contabancariaCollectionContabancaria.setCodcalculodv(calculodv);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
                if (oldCodcalculodvOfContabancariaCollectionContabancaria != null) {
                    oldCodcalculodvOfContabancariaCollectionContabancaria.getContabancariaCollection().remove(contabancariaCollectionContabancaria);
                    oldCodcalculodvOfContabancariaCollectionContabancaria = em.merge(oldCodcalculodvOfContabancariaCollectionContabancaria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalculodv(calculodv.getCodcalculodv()) != null) {
                throw new PreexistingEntityException("Calculodv " + calculodv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calculodv calculodv) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calculodv persistentCalculodv = em.find(Calculodv.class, calculodv.getCodcalculodv());
            Collection<Contabancaria> contabancariaCollectionOld = persistentCalculodv.getContabancariaCollection();
            Collection<Contabancaria> contabancariaCollectionNew = calculodv.getContabancariaCollection();
            Collection<Contabancaria> attachedContabancariaCollectionNew = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionNewContabancariaToAttach : contabancariaCollectionNew) {
                contabancariaCollectionNewContabancariaToAttach = em.getReference(contabancariaCollectionNewContabancariaToAttach.getClass(), contabancariaCollectionNewContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollectionNew.add(contabancariaCollectionNewContabancariaToAttach);
            }
            contabancariaCollectionNew = attachedContabancariaCollectionNew;
            calculodv.setContabancariaCollection(contabancariaCollectionNew);
            calculodv = em.merge(calculodv);
            for (Contabancaria contabancariaCollectionOldContabancaria : contabancariaCollectionOld) {
                if (!contabancariaCollectionNew.contains(contabancariaCollectionOldContabancaria)) {
                    contabancariaCollectionOldContabancaria.setCodcalculodv(null);
                    contabancariaCollectionOldContabancaria = em.merge(contabancariaCollectionOldContabancaria);
                }
            }
            for (Contabancaria contabancariaCollectionNewContabancaria : contabancariaCollectionNew) {
                if (!contabancariaCollectionOld.contains(contabancariaCollectionNewContabancaria)) {
                    Calculodv oldCodcalculodvOfContabancariaCollectionNewContabancaria = contabancariaCollectionNewContabancaria.getCodcalculodv();
                    contabancariaCollectionNewContabancaria.setCodcalculodv(calculodv);
                    contabancariaCollectionNewContabancaria = em.merge(contabancariaCollectionNewContabancaria);
                    if (oldCodcalculodvOfContabancariaCollectionNewContabancaria != null && !oldCodcalculodvOfContabancariaCollectionNewContabancaria.equals(calculodv)) {
                        oldCodcalculodvOfContabancariaCollectionNewContabancaria.getContabancariaCollection().remove(contabancariaCollectionNewContabancaria);
                        oldCodcalculodvOfContabancariaCollectionNewContabancaria = em.merge(oldCodcalculodvOfContabancariaCollectionNewContabancaria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = calculodv.getCodcalculodv();
                if (findCalculodv(id) == null) {
                    throw new NonexistentEntityException("The calculodv with id " + id + " no longer exists.");
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
            Calculodv calculodv;
            try {
                calculodv = em.getReference(Calculodv.class, id);
                calculodv.getCodcalculodv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calculodv with id " + id + " no longer exists.", enfe);
            }
            Collection<Contabancaria> contabancariaCollection = calculodv.getContabancariaCollection();
            for (Contabancaria contabancariaCollectionContabancaria : contabancariaCollection) {
                contabancariaCollectionContabancaria.setCodcalculodv(null);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
            }
            em.remove(calculodv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calculodv> findCalculodvEntities() {
        return findCalculodvEntities(true, -1, -1);
    }

    public List<Calculodv> findCalculodvEntities(int maxResults, int firstResult) {
        return findCalculodvEntities(false, maxResults, firstResult);
    }

    private List<Calculodv> findCalculodvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calculodv.class));
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

    public Calculodv findCalculodv(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calculodv.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalculodvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calculodv> rt = cq.from(Calculodv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
