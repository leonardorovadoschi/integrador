/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Advertencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Funcionario;
import entidade.cplus.Tipoadvertencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class AdvertenciaJpaController implements Serializable {

    public AdvertenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Advertencia advertencia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario codfunc = advertencia.getCodfunc();
            if (codfunc != null) {
                codfunc = em.getReference(codfunc.getClass(), codfunc.getCodfuncionario());
                advertencia.setCodfunc(codfunc);
            }
            Funcionario codfuncadvertencia = advertencia.getCodfuncadvertencia();
            if (codfuncadvertencia != null) {
                codfuncadvertencia = em.getReference(codfuncadvertencia.getClass(), codfuncadvertencia.getCodfuncionario());
                advertencia.setCodfuncadvertencia(codfuncadvertencia);
            }
            Tipoadvertencia codtipoadvertencia = advertencia.getCodtipoadvertencia();
            if (codtipoadvertencia != null) {
                codtipoadvertencia = em.getReference(codtipoadvertencia.getClass(), codtipoadvertencia.getCodtipoadvertencia());
                advertencia.setCodtipoadvertencia(codtipoadvertencia);
            }
            em.persist(advertencia);
            if (codfunc != null) {
                codfunc.getAdvertenciaCollection().add(advertencia);
                codfunc = em.merge(codfunc);
            }
            if (codfuncadvertencia != null) {
                codfuncadvertencia.getAdvertenciaCollection().add(advertencia);
                codfuncadvertencia = em.merge(codfuncadvertencia);
            }
            if (codtipoadvertencia != null) {
                codtipoadvertencia.getAdvertenciaCollection().add(advertencia);
                codtipoadvertencia = em.merge(codtipoadvertencia);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdvertencia(advertencia.getCodadvertencia()) != null) {
                throw new PreexistingEntityException("Advertencia " + advertencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Advertencia advertencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Advertencia persistentAdvertencia = em.find(Advertencia.class, advertencia.getCodadvertencia());
            Funcionario codfuncOld = persistentAdvertencia.getCodfunc();
            Funcionario codfuncNew = advertencia.getCodfunc();
            Funcionario codfuncadvertenciaOld = persistentAdvertencia.getCodfuncadvertencia();
            Funcionario codfuncadvertenciaNew = advertencia.getCodfuncadvertencia();
            Tipoadvertencia codtipoadvertenciaOld = persistentAdvertencia.getCodtipoadvertencia();
            Tipoadvertencia codtipoadvertenciaNew = advertencia.getCodtipoadvertencia();
            if (codfuncNew != null) {
                codfuncNew = em.getReference(codfuncNew.getClass(), codfuncNew.getCodfuncionario());
                advertencia.setCodfunc(codfuncNew);
            }
            if (codfuncadvertenciaNew != null) {
                codfuncadvertenciaNew = em.getReference(codfuncadvertenciaNew.getClass(), codfuncadvertenciaNew.getCodfuncionario());
                advertencia.setCodfuncadvertencia(codfuncadvertenciaNew);
            }
            if (codtipoadvertenciaNew != null) {
                codtipoadvertenciaNew = em.getReference(codtipoadvertenciaNew.getClass(), codtipoadvertenciaNew.getCodtipoadvertencia());
                advertencia.setCodtipoadvertencia(codtipoadvertenciaNew);
            }
            advertencia = em.merge(advertencia);
            if (codfuncOld != null && !codfuncOld.equals(codfuncNew)) {
                codfuncOld.getAdvertenciaCollection().remove(advertencia);
                codfuncOld = em.merge(codfuncOld);
            }
            if (codfuncNew != null && !codfuncNew.equals(codfuncOld)) {
                codfuncNew.getAdvertenciaCollection().add(advertencia);
                codfuncNew = em.merge(codfuncNew);
            }
            if (codfuncadvertenciaOld != null && !codfuncadvertenciaOld.equals(codfuncadvertenciaNew)) {
                codfuncadvertenciaOld.getAdvertenciaCollection().remove(advertencia);
                codfuncadvertenciaOld = em.merge(codfuncadvertenciaOld);
            }
            if (codfuncadvertenciaNew != null && !codfuncadvertenciaNew.equals(codfuncadvertenciaOld)) {
                codfuncadvertenciaNew.getAdvertenciaCollection().add(advertencia);
                codfuncadvertenciaNew = em.merge(codfuncadvertenciaNew);
            }
            if (codtipoadvertenciaOld != null && !codtipoadvertenciaOld.equals(codtipoadvertenciaNew)) {
                codtipoadvertenciaOld.getAdvertenciaCollection().remove(advertencia);
                codtipoadvertenciaOld = em.merge(codtipoadvertenciaOld);
            }
            if (codtipoadvertenciaNew != null && !codtipoadvertenciaNew.equals(codtipoadvertenciaOld)) {
                codtipoadvertenciaNew.getAdvertenciaCollection().add(advertencia);
                codtipoadvertenciaNew = em.merge(codtipoadvertenciaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = advertencia.getCodadvertencia();
                if (findAdvertencia(id) == null) {
                    throw new NonexistentEntityException("The advertencia with id " + id + " no longer exists.");
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
            Advertencia advertencia;
            try {
                advertencia = em.getReference(Advertencia.class, id);
                advertencia.getCodadvertencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The advertencia with id " + id + " no longer exists.", enfe);
            }
            Funcionario codfunc = advertencia.getCodfunc();
            if (codfunc != null) {
                codfunc.getAdvertenciaCollection().remove(advertencia);
                codfunc = em.merge(codfunc);
            }
            Funcionario codfuncadvertencia = advertencia.getCodfuncadvertencia();
            if (codfuncadvertencia != null) {
                codfuncadvertencia.getAdvertenciaCollection().remove(advertencia);
                codfuncadvertencia = em.merge(codfuncadvertencia);
            }
            Tipoadvertencia codtipoadvertencia = advertencia.getCodtipoadvertencia();
            if (codtipoadvertencia != null) {
                codtipoadvertencia.getAdvertenciaCollection().remove(advertencia);
                codtipoadvertencia = em.merge(codtipoadvertencia);
            }
            em.remove(advertencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Advertencia> findAdvertenciaEntities() {
        return findAdvertenciaEntities(true, -1, -1);
    }

    public List<Advertencia> findAdvertenciaEntities(int maxResults, int firstResult) {
        return findAdvertenciaEntities(false, maxResults, firstResult);
    }

    private List<Advertencia> findAdvertenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Advertencia.class));
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

    public Advertencia findAdvertencia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Advertencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdvertenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Advertencia> rt = cq.from(Advertencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
