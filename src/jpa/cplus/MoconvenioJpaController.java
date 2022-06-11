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
import entidade.cplus.Empresa;
import entidade.cplus.Moconvenio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoconvenioJpaController implements Serializable {

    public MoconvenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moconvenio moconvenio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = moconvenio.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                moconvenio.setCodempresa(codempresa);
            }
            em.persist(moconvenio);
            if (codempresa != null) {
                codempresa.getMoconvenioCollection().add(moconvenio);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoconvenio(moconvenio.getCodmoconvenio()) != null) {
                throw new PreexistingEntityException("Moconvenio " + moconvenio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moconvenio moconvenio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moconvenio persistentMoconvenio = em.find(Moconvenio.class, moconvenio.getCodmoconvenio());
            Empresa codempresaOld = persistentMoconvenio.getCodempresa();
            Empresa codempresaNew = moconvenio.getCodempresa();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                moconvenio.setCodempresa(codempresaNew);
            }
            moconvenio = em.merge(moconvenio);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getMoconvenioCollection().remove(moconvenio);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getMoconvenioCollection().add(moconvenio);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moconvenio.getCodmoconvenio();
                if (findMoconvenio(id) == null) {
                    throw new NonexistentEntityException("The moconvenio with id " + id + " no longer exists.");
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
            Moconvenio moconvenio;
            try {
                moconvenio = em.getReference(Moconvenio.class, id);
                moconvenio.getCodmoconvenio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moconvenio with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = moconvenio.getCodempresa();
            if (codempresa != null) {
                codempresa.getMoconvenioCollection().remove(moconvenio);
                codempresa = em.merge(codempresa);
            }
            em.remove(moconvenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moconvenio> findMoconvenioEntities() {
        return findMoconvenioEntities(true, -1, -1);
    }

    public List<Moconvenio> findMoconvenioEntities(int maxResults, int firstResult) {
        return findMoconvenioEntities(false, maxResults, firstResult);
    }

    private List<Moconvenio> findMoconvenioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moconvenio.class));
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

    public Moconvenio findMoconvenio(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moconvenio.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoconvenioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moconvenio> rt = cq.from(Moconvenio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
