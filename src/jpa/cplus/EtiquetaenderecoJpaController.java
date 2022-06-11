/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Etiquetaendereco;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EtiquetaenderecoJpaController implements Serializable {

    public EtiquetaenderecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Etiquetaendereco etiquetaendereco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario coduser = etiquetaendereco.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                etiquetaendereco.setCoduser(coduser);
            }
            em.persist(etiquetaendereco);
            if (coduser != null) {
                coduser.getEtiquetaenderecoCollection().add(etiquetaendereco);
                coduser = em.merge(coduser);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEtiquetaendereco(etiquetaendereco.getCodetiquetaendereco()) != null) {
                throw new PreexistingEntityException("Etiquetaendereco " + etiquetaendereco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Etiquetaendereco etiquetaendereco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Etiquetaendereco persistentEtiquetaendereco = em.find(Etiquetaendereco.class, etiquetaendereco.getCodetiquetaendereco());
            Usuario coduserOld = persistentEtiquetaendereco.getCoduser();
            Usuario coduserNew = etiquetaendereco.getCoduser();
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                etiquetaendereco.setCoduser(coduserNew);
            }
            etiquetaendereco = em.merge(etiquetaendereco);
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getEtiquetaenderecoCollection().remove(etiquetaendereco);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getEtiquetaenderecoCollection().add(etiquetaendereco);
                coduserNew = em.merge(coduserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = etiquetaendereco.getCodetiquetaendereco();
                if (findEtiquetaendereco(id) == null) {
                    throw new NonexistentEntityException("The etiquetaendereco with id " + id + " no longer exists.");
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
            Etiquetaendereco etiquetaendereco;
            try {
                etiquetaendereco = em.getReference(Etiquetaendereco.class, id);
                etiquetaendereco.getCodetiquetaendereco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The etiquetaendereco with id " + id + " no longer exists.", enfe);
            }
            Usuario coduser = etiquetaendereco.getCoduser();
            if (coduser != null) {
                coduser.getEtiquetaenderecoCollection().remove(etiquetaendereco);
                coduser = em.merge(coduser);
            }
            em.remove(etiquetaendereco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Etiquetaendereco> findEtiquetaenderecoEntities() {
        return findEtiquetaenderecoEntities(true, -1, -1);
    }

    public List<Etiquetaendereco> findEtiquetaenderecoEntities(int maxResults, int firstResult) {
        return findEtiquetaenderecoEntities(false, maxResults, firstResult);
    }

    private List<Etiquetaendereco> findEtiquetaenderecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Etiquetaendereco.class));
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

    public Etiquetaendereco findEtiquetaendereco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Etiquetaendereco.class, id);
        } finally {
            em.close();
        }
    }

    public int getEtiquetaenderecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Etiquetaendereco> rt = cq.from(Etiquetaendereco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
