/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Icmsestado;
import entidade.cplus.IcmsestadoPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class IcmsestadoJpaController implements Serializable {

    public IcmsestadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Icmsestado icmsestado) throws PreexistingEntityException, Exception {
        if (icmsestado.getIcmsestadoPK() == null) {
            icmsestado.setIcmsestadoPK(new IcmsestadoPK());
        }
        icmsestado.getIcmsestadoPK().setUforigem(icmsestado.getUf().getCoduf());
        icmsestado.getIcmsestadoPK().setUfdestino(icmsestado.getUf1().getCoduf());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf uf = icmsestado.getUf();
            if (uf != null) {
                uf = em.getReference(uf.getClass(), uf.getCoduf());
                icmsestado.setUf(uf);
            }
            Uf uf1 = icmsestado.getUf1();
            if (uf1 != null) {
                uf1 = em.getReference(uf1.getClass(), uf1.getCoduf());
                icmsestado.setUf1(uf1);
            }
            em.persist(icmsestado);
            if (uf != null) {
                uf.getIcmsestadoCollection().add(icmsestado);
                uf = em.merge(uf);
            }
            if (uf1 != null) {
                uf1.getIcmsestadoCollection().add(icmsestado);
                uf1 = em.merge(uf1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIcmsestado(icmsestado.getIcmsestadoPK()) != null) {
                throw new PreexistingEntityException("Icmsestado " + icmsestado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Icmsestado icmsestado) throws NonexistentEntityException, Exception {
        icmsestado.getIcmsestadoPK().setUforigem(icmsestado.getUf().getCoduf());
        icmsestado.getIcmsestadoPK().setUfdestino(icmsestado.getUf1().getCoduf());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Icmsestado persistentIcmsestado = em.find(Icmsestado.class, icmsestado.getIcmsestadoPK());
            Uf ufOld = persistentIcmsestado.getUf();
            Uf ufNew = icmsestado.getUf();
            Uf uf1Old = persistentIcmsestado.getUf1();
            Uf uf1New = icmsestado.getUf1();
            if (ufNew != null) {
                ufNew = em.getReference(ufNew.getClass(), ufNew.getCoduf());
                icmsestado.setUf(ufNew);
            }
            if (uf1New != null) {
                uf1New = em.getReference(uf1New.getClass(), uf1New.getCoduf());
                icmsestado.setUf1(uf1New);
            }
            icmsestado = em.merge(icmsestado);
            if (ufOld != null && !ufOld.equals(ufNew)) {
                ufOld.getIcmsestadoCollection().remove(icmsestado);
                ufOld = em.merge(ufOld);
            }
            if (ufNew != null && !ufNew.equals(ufOld)) {
                ufNew.getIcmsestadoCollection().add(icmsestado);
                ufNew = em.merge(ufNew);
            }
            if (uf1Old != null && !uf1Old.equals(uf1New)) {
                uf1Old.getIcmsestadoCollection().remove(icmsestado);
                uf1Old = em.merge(uf1Old);
            }
            if (uf1New != null && !uf1New.equals(uf1Old)) {
                uf1New.getIcmsestadoCollection().add(icmsestado);
                uf1New = em.merge(uf1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                IcmsestadoPK id = icmsestado.getIcmsestadoPK();
                if (findIcmsestado(id) == null) {
                    throw new NonexistentEntityException("The icmsestado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(IcmsestadoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Icmsestado icmsestado;
            try {
                icmsestado = em.getReference(Icmsestado.class, id);
                icmsestado.getIcmsestadoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The icmsestado with id " + id + " no longer exists.", enfe);
            }
            Uf uf = icmsestado.getUf();
            if (uf != null) {
                uf.getIcmsestadoCollection().remove(icmsestado);
                uf = em.merge(uf);
            }
            Uf uf1 = icmsestado.getUf1();
            if (uf1 != null) {
                uf1.getIcmsestadoCollection().remove(icmsestado);
                uf1 = em.merge(uf1);
            }
            em.remove(icmsestado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Icmsestado> findIcmsestadoEntities() {
        return findIcmsestadoEntities(true, -1, -1);
    }

    public List<Icmsestado> findIcmsestadoEntities(int maxResults, int firstResult) {
        return findIcmsestadoEntities(false, maxResults, firstResult);
    }

    private List<Icmsestado> findIcmsestadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Icmsestado.class));
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

    public Icmsestado findIcmsestado(IcmsestadoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Icmsestado.class, id);
        } finally {
            em.close();
        }
    }

    public int getIcmsestadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Icmsestado> rt = cq.from(Icmsestado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
