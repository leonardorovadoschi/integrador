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
import entidade.cplus.Empresatipodocumento;
import entidade.cplus.Tipodocumento;
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
public class TipodocumentoJpaController implements Serializable {

    public TipodocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipodocumento tipodocumento) throws PreexistingEntityException, Exception {
        if (tipodocumento.getEmpresatipodocumentoCollection() == null) {
            tipodocumento.setEmpresatipodocumentoCollection(new ArrayList<Empresatipodocumento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Empresatipodocumento> attachedEmpresatipodocumentoCollection = new ArrayList<Empresatipodocumento>();
            for (Empresatipodocumento empresatipodocumentoCollectionEmpresatipodocumentoToAttach : tipodocumento.getEmpresatipodocumentoCollection()) {
                empresatipodocumentoCollectionEmpresatipodocumentoToAttach = em.getReference(empresatipodocumentoCollectionEmpresatipodocumentoToAttach.getClass(), empresatipodocumentoCollectionEmpresatipodocumentoToAttach.getCodempresatipodocumento());
                attachedEmpresatipodocumentoCollection.add(empresatipodocumentoCollectionEmpresatipodocumentoToAttach);
            }
            tipodocumento.setEmpresatipodocumentoCollection(attachedEmpresatipodocumentoCollection);
            em.persist(tipodocumento);
            for (Empresatipodocumento empresatipodocumentoCollectionEmpresatipodocumento : tipodocumento.getEmpresatipodocumentoCollection()) {
                Tipodocumento oldCodtipodocumentoOfEmpresatipodocumentoCollectionEmpresatipodocumento = empresatipodocumentoCollectionEmpresatipodocumento.getCodtipodocumento();
                empresatipodocumentoCollectionEmpresatipodocumento.setCodtipodocumento(tipodocumento);
                empresatipodocumentoCollectionEmpresatipodocumento = em.merge(empresatipodocumentoCollectionEmpresatipodocumento);
                if (oldCodtipodocumentoOfEmpresatipodocumentoCollectionEmpresatipodocumento != null) {
                    oldCodtipodocumentoOfEmpresatipodocumentoCollectionEmpresatipodocumento.getEmpresatipodocumentoCollection().remove(empresatipodocumentoCollectionEmpresatipodocumento);
                    oldCodtipodocumentoOfEmpresatipodocumentoCollectionEmpresatipodocumento = em.merge(oldCodtipodocumentoOfEmpresatipodocumentoCollectionEmpresatipodocumento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipodocumento(tipodocumento.getCodtipodocumento()) != null) {
                throw new PreexistingEntityException("Tipodocumento " + tipodocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipodocumento tipodocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipodocumento persistentTipodocumento = em.find(Tipodocumento.class, tipodocumento.getCodtipodocumento());
            Collection<Empresatipodocumento> empresatipodocumentoCollectionOld = persistentTipodocumento.getEmpresatipodocumentoCollection();
            Collection<Empresatipodocumento> empresatipodocumentoCollectionNew = tipodocumento.getEmpresatipodocumentoCollection();
            Collection<Empresatipodocumento> attachedEmpresatipodocumentoCollectionNew = new ArrayList<Empresatipodocumento>();
            for (Empresatipodocumento empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach : empresatipodocumentoCollectionNew) {
                empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach = em.getReference(empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach.getClass(), empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach.getCodempresatipodocumento());
                attachedEmpresatipodocumentoCollectionNew.add(empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach);
            }
            empresatipodocumentoCollectionNew = attachedEmpresatipodocumentoCollectionNew;
            tipodocumento.setEmpresatipodocumentoCollection(empresatipodocumentoCollectionNew);
            tipodocumento = em.merge(tipodocumento);
            for (Empresatipodocumento empresatipodocumentoCollectionOldEmpresatipodocumento : empresatipodocumentoCollectionOld) {
                if (!empresatipodocumentoCollectionNew.contains(empresatipodocumentoCollectionOldEmpresatipodocumento)) {
                    empresatipodocumentoCollectionOldEmpresatipodocumento.setCodtipodocumento(null);
                    empresatipodocumentoCollectionOldEmpresatipodocumento = em.merge(empresatipodocumentoCollectionOldEmpresatipodocumento);
                }
            }
            for (Empresatipodocumento empresatipodocumentoCollectionNewEmpresatipodocumento : empresatipodocumentoCollectionNew) {
                if (!empresatipodocumentoCollectionOld.contains(empresatipodocumentoCollectionNewEmpresatipodocumento)) {
                    Tipodocumento oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento = empresatipodocumentoCollectionNewEmpresatipodocumento.getCodtipodocumento();
                    empresatipodocumentoCollectionNewEmpresatipodocumento.setCodtipodocumento(tipodocumento);
                    empresatipodocumentoCollectionNewEmpresatipodocumento = em.merge(empresatipodocumentoCollectionNewEmpresatipodocumento);
                    if (oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento != null && !oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento.equals(tipodocumento)) {
                        oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento.getEmpresatipodocumentoCollection().remove(empresatipodocumentoCollectionNewEmpresatipodocumento);
                        oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento = em.merge(oldCodtipodocumentoOfEmpresatipodocumentoCollectionNewEmpresatipodocumento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipodocumento.getCodtipodocumento();
                if (findTipodocumento(id) == null) {
                    throw new NonexistentEntityException("The tipodocumento with id " + id + " no longer exists.");
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
            Tipodocumento tipodocumento;
            try {
                tipodocumento = em.getReference(Tipodocumento.class, id);
                tipodocumento.getCodtipodocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipodocumento with id " + id + " no longer exists.", enfe);
            }
            Collection<Empresatipodocumento> empresatipodocumentoCollection = tipodocumento.getEmpresatipodocumentoCollection();
            for (Empresatipodocumento empresatipodocumentoCollectionEmpresatipodocumento : empresatipodocumentoCollection) {
                empresatipodocumentoCollectionEmpresatipodocumento.setCodtipodocumento(null);
                empresatipodocumentoCollectionEmpresatipodocumento = em.merge(empresatipodocumentoCollectionEmpresatipodocumento);
            }
            em.remove(tipodocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipodocumento> findTipodocumentoEntities() {
        return findTipodocumentoEntities(true, -1, -1);
    }

    public List<Tipodocumento> findTipodocumentoEntities(int maxResults, int firstResult) {
        return findTipodocumentoEntities(false, maxResults, firstResult);
    }

    private List<Tipodocumento> findTipodocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipodocumento.class));
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

    public Tipodocumento findTipodocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipodocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipodocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipodocumento> rt = cq.from(Tipodocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
