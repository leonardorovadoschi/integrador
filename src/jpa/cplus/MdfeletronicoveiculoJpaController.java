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
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicoveiculo;
import entidade.cplus.Veiculos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletronicoveiculoJpaController implements Serializable {

    public MdfeletronicoveiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicoveiculo mdfeletronicoveiculo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicoveiculo.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicoveiculo.setCodmdfeletronico(codmdfeletronico);
            }
            Veiculos codveiculo = mdfeletronicoveiculo.getCodveiculo();
            if (codveiculo != null) {
                codveiculo = em.getReference(codveiculo.getClass(), codveiculo.getCodveiculo());
                mdfeletronicoveiculo.setCodveiculo(codveiculo);
            }
            em.persist(mdfeletronicoveiculo);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoveiculoCollection().add(mdfeletronicoveiculo);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            if (codveiculo != null) {
                codveiculo.getMdfeletronicoveiculoCollection().add(mdfeletronicoveiculo);
                codveiculo = em.merge(codveiculo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicoveiculo(mdfeletronicoveiculo.getCodmdfeletronicoveiculo()) != null) {
                throw new PreexistingEntityException("Mdfeletronicoveiculo " + mdfeletronicoveiculo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicoveiculo mdfeletronicoveiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicoveiculo persistentMdfeletronicoveiculo = em.find(Mdfeletronicoveiculo.class, mdfeletronicoveiculo.getCodmdfeletronicoveiculo());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicoveiculo.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicoveiculo.getCodmdfeletronico();
            Veiculos codveiculoOld = persistentMdfeletronicoveiculo.getCodveiculo();
            Veiculos codveiculoNew = mdfeletronicoveiculo.getCodveiculo();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicoveiculo.setCodmdfeletronico(codmdfeletronicoNew);
            }
            if (codveiculoNew != null) {
                codveiculoNew = em.getReference(codveiculoNew.getClass(), codveiculoNew.getCodveiculo());
                mdfeletronicoveiculo.setCodveiculo(codveiculoNew);
            }
            mdfeletronicoveiculo = em.merge(mdfeletronicoveiculo);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculo);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicoveiculoCollection().add(mdfeletronicoveiculo);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            if (codveiculoOld != null && !codveiculoOld.equals(codveiculoNew)) {
                codveiculoOld.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculo);
                codveiculoOld = em.merge(codveiculoOld);
            }
            if (codveiculoNew != null && !codveiculoNew.equals(codveiculoOld)) {
                codveiculoNew.getMdfeletronicoveiculoCollection().add(mdfeletronicoveiculo);
                codveiculoNew = em.merge(codveiculoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicoveiculo.getCodmdfeletronicoveiculo();
                if (findMdfeletronicoveiculo(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicoveiculo with id " + id + " no longer exists.");
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
            Mdfeletronicoveiculo mdfeletronicoveiculo;
            try {
                mdfeletronicoveiculo = em.getReference(Mdfeletronicoveiculo.class, id);
                mdfeletronicoveiculo.getCodmdfeletronicoveiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicoveiculo with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicoveiculo.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculo);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Veiculos codveiculo = mdfeletronicoveiculo.getCodveiculo();
            if (codveiculo != null) {
                codveiculo.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculo);
                codveiculo = em.merge(codveiculo);
            }
            em.remove(mdfeletronicoveiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicoveiculo> findMdfeletronicoveiculoEntities() {
        return findMdfeletronicoveiculoEntities(true, -1, -1);
    }

    public List<Mdfeletronicoveiculo> findMdfeletronicoveiculoEntities(int maxResults, int firstResult) {
        return findMdfeletronicoveiculoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicoveiculo> findMdfeletronicoveiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicoveiculo.class));
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

    public Mdfeletronicoveiculo findMdfeletronicoveiculo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicoveiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicoveiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicoveiculo> rt = cq.from(Mdfeletronicoveiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
