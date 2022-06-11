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
import entidade.cplus.Arquivoregistro;
import entidade.cplus.Lotemontagemarquivo;
import entidade.cplus.Montagemarquivo;
import entidade.cplus.Montagemarquivoitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MontagemarquivoitemJpaController implements Serializable {

    public MontagemarquivoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Montagemarquivoitem montagemarquivoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arquivoregistro codarquivoregistro = montagemarquivoitem.getCodarquivoregistro();
            if (codarquivoregistro != null) {
                codarquivoregistro = em.getReference(codarquivoregistro.getClass(), codarquivoregistro.getCodarquivoregistro());
                montagemarquivoitem.setCodarquivoregistro(codarquivoregistro);
            }
            Lotemontagemarquivo codlotemontagemarquivo = montagemarquivoitem.getCodlotemontagemarquivo();
            if (codlotemontagemarquivo != null) {
                codlotemontagemarquivo = em.getReference(codlotemontagemarquivo.getClass(), codlotemontagemarquivo.getCodlotemontagemarquivo());
                montagemarquivoitem.setCodlotemontagemarquivo(codlotemontagemarquivo);
            }
            Montagemarquivo codmontagemarquivo = montagemarquivoitem.getCodmontagemarquivo();
            if (codmontagemarquivo != null) {
                codmontagemarquivo = em.getReference(codmontagemarquivo.getClass(), codmontagemarquivo.getCodmontagemarquivo());
                montagemarquivoitem.setCodmontagemarquivo(codmontagemarquivo);
            }
            em.persist(montagemarquivoitem);
            if (codarquivoregistro != null) {
                codarquivoregistro.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codarquivoregistro = em.merge(codarquivoregistro);
            }
            if (codlotemontagemarquivo != null) {
                codlotemontagemarquivo.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codlotemontagemarquivo = em.merge(codlotemontagemarquivo);
            }
            if (codmontagemarquivo != null) {
                codmontagemarquivo.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codmontagemarquivo = em.merge(codmontagemarquivo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMontagemarquivoitem(montagemarquivoitem.getCodmontagemarquivoitem()) != null) {
                throw new PreexistingEntityException("Montagemarquivoitem " + montagemarquivoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Montagemarquivoitem montagemarquivoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Montagemarquivoitem persistentMontagemarquivoitem = em.find(Montagemarquivoitem.class, montagemarquivoitem.getCodmontagemarquivoitem());
            Arquivoregistro codarquivoregistroOld = persistentMontagemarquivoitem.getCodarquivoregistro();
            Arquivoregistro codarquivoregistroNew = montagemarquivoitem.getCodarquivoregistro();
            Lotemontagemarquivo codlotemontagemarquivoOld = persistentMontagemarquivoitem.getCodlotemontagemarquivo();
            Lotemontagemarquivo codlotemontagemarquivoNew = montagemarquivoitem.getCodlotemontagemarquivo();
            Montagemarquivo codmontagemarquivoOld = persistentMontagemarquivoitem.getCodmontagemarquivo();
            Montagemarquivo codmontagemarquivoNew = montagemarquivoitem.getCodmontagemarquivo();
            if (codarquivoregistroNew != null) {
                codarquivoregistroNew = em.getReference(codarquivoregistroNew.getClass(), codarquivoregistroNew.getCodarquivoregistro());
                montagemarquivoitem.setCodarquivoregistro(codarquivoregistroNew);
            }
            if (codlotemontagemarquivoNew != null) {
                codlotemontagemarquivoNew = em.getReference(codlotemontagemarquivoNew.getClass(), codlotemontagemarquivoNew.getCodlotemontagemarquivo());
                montagemarquivoitem.setCodlotemontagemarquivo(codlotemontagemarquivoNew);
            }
            if (codmontagemarquivoNew != null) {
                codmontagemarquivoNew = em.getReference(codmontagemarquivoNew.getClass(), codmontagemarquivoNew.getCodmontagemarquivo());
                montagemarquivoitem.setCodmontagemarquivo(codmontagemarquivoNew);
            }
            montagemarquivoitem = em.merge(montagemarquivoitem);
            if (codarquivoregistroOld != null && !codarquivoregistroOld.equals(codarquivoregistroNew)) {
                codarquivoregistroOld.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codarquivoregistroOld = em.merge(codarquivoregistroOld);
            }
            if (codarquivoregistroNew != null && !codarquivoregistroNew.equals(codarquivoregistroOld)) {
                codarquivoregistroNew.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codarquivoregistroNew = em.merge(codarquivoregistroNew);
            }
            if (codlotemontagemarquivoOld != null && !codlotemontagemarquivoOld.equals(codlotemontagemarquivoNew)) {
                codlotemontagemarquivoOld.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codlotemontagemarquivoOld = em.merge(codlotemontagemarquivoOld);
            }
            if (codlotemontagemarquivoNew != null && !codlotemontagemarquivoNew.equals(codlotemontagemarquivoOld)) {
                codlotemontagemarquivoNew.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codlotemontagemarquivoNew = em.merge(codlotemontagemarquivoNew);
            }
            if (codmontagemarquivoOld != null && !codmontagemarquivoOld.equals(codmontagemarquivoNew)) {
                codmontagemarquivoOld.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codmontagemarquivoOld = em.merge(codmontagemarquivoOld);
            }
            if (codmontagemarquivoNew != null && !codmontagemarquivoNew.equals(codmontagemarquivoOld)) {
                codmontagemarquivoNew.getMontagemarquivoitemCollection().add(montagemarquivoitem);
                codmontagemarquivoNew = em.merge(codmontagemarquivoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = montagemarquivoitem.getCodmontagemarquivoitem();
                if (findMontagemarquivoitem(id) == null) {
                    throw new NonexistentEntityException("The montagemarquivoitem with id " + id + " no longer exists.");
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
            Montagemarquivoitem montagemarquivoitem;
            try {
                montagemarquivoitem = em.getReference(Montagemarquivoitem.class, id);
                montagemarquivoitem.getCodmontagemarquivoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The montagemarquivoitem with id " + id + " no longer exists.", enfe);
            }
            Arquivoregistro codarquivoregistro = montagemarquivoitem.getCodarquivoregistro();
            if (codarquivoregistro != null) {
                codarquivoregistro.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codarquivoregistro = em.merge(codarquivoregistro);
            }
            Lotemontagemarquivo codlotemontagemarquivo = montagemarquivoitem.getCodlotemontagemarquivo();
            if (codlotemontagemarquivo != null) {
                codlotemontagemarquivo.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codlotemontagemarquivo = em.merge(codlotemontagemarquivo);
            }
            Montagemarquivo codmontagemarquivo = montagemarquivoitem.getCodmontagemarquivo();
            if (codmontagemarquivo != null) {
                codmontagemarquivo.getMontagemarquivoitemCollection().remove(montagemarquivoitem);
                codmontagemarquivo = em.merge(codmontagemarquivo);
            }
            em.remove(montagemarquivoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Montagemarquivoitem> findMontagemarquivoitemEntities() {
        return findMontagemarquivoitemEntities(true, -1, -1);
    }

    public List<Montagemarquivoitem> findMontagemarquivoitemEntities(int maxResults, int firstResult) {
        return findMontagemarquivoitemEntities(false, maxResults, firstResult);
    }

    private List<Montagemarquivoitem> findMontagemarquivoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Montagemarquivoitem.class));
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

    public Montagemarquivoitem findMontagemarquivoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Montagemarquivoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMontagemarquivoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Montagemarquivoitem> rt = cq.from(Montagemarquivoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
