/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductAttributeImage;
import entidade.prestaShop.PsProductAttributeImagePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsProductAttributeImageJpaController implements Serializable {

    public PsProductAttributeImageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductAttributeImage psProductAttributeImage) throws PreexistingEntityException, Exception {
        if (psProductAttributeImage.getPsProductAttributeImagePK() == null) {
            psProductAttributeImage.setPsProductAttributeImagePK(new PsProductAttributeImagePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductAttributeImage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductAttributeImage(psProductAttributeImage.getPsProductAttributeImagePK()) != null) {
                throw new PreexistingEntityException("PsProductAttributeImage " + psProductAttributeImage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductAttributeImage psProductAttributeImage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductAttributeImage = em.merge(psProductAttributeImage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductAttributeImagePK id = psProductAttributeImage.getPsProductAttributeImagePK();
                if (findPsProductAttributeImage(id) == null) {
                    throw new NonexistentEntityException("The psProductAttributeImage with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductAttributeImagePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductAttributeImage psProductAttributeImage;
            try {
                psProductAttributeImage = em.getReference(PsProductAttributeImage.class, id);
                psProductAttributeImage.getPsProductAttributeImagePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductAttributeImage with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductAttributeImage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductAttributeImage> findPsProductAttributeImageEntities() {
        return findPsProductAttributeImageEntities(true, -1, -1);
    }

    public List<PsProductAttributeImage> findPsProductAttributeImageEntities(int maxResults, int firstResult) {
        return findPsProductAttributeImageEntities(false, maxResults, firstResult);
    }

    private List<PsProductAttributeImage> findPsProductAttributeImageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductAttributeImage.class));
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

    public PsProductAttributeImage findPsProductAttributeImage(PsProductAttributeImagePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductAttributeImage.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductAttributeImageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductAttributeImage> rt = cq.from(PsProductAttributeImage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
