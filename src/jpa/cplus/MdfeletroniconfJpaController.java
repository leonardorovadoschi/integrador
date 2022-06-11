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
import entidade.cplus.Documento;
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicolocal;
import entidade.cplus.Mdfeletroniconf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletroniconfJpaController implements Serializable {

    public MdfeletroniconfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletroniconf mdfeletroniconf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = mdfeletroniconf.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                mdfeletroniconf.setCoddocumento(coddocumento);
            }
            Mdfeletronico codmdfeletronico = mdfeletroniconf.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletroniconf.setCodmdfeletronico(codmdfeletronico);
            }
            Mdfeletronicolocal codmdfeletronicolocal = mdfeletroniconf.getCodmdfeletronicolocal();
            if (codmdfeletronicolocal != null) {
                codmdfeletronicolocal = em.getReference(codmdfeletronicolocal.getClass(), codmdfeletronicolocal.getCodmdfeletronicolocal());
                mdfeletroniconf.setCodmdfeletronicolocal(codmdfeletronicolocal);
            }
            em.persist(mdfeletroniconf);
            if (coddocumento != null) {
                coddocumento.getMdfeletroniconfCollection().add(mdfeletroniconf);
                coddocumento = em.merge(coddocumento);
            }
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletroniconfCollection().add(mdfeletroniconf);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            if (codmdfeletronicolocal != null) {
                codmdfeletronicolocal.getMdfeletroniconfCollection().add(mdfeletroniconf);
                codmdfeletronicolocal = em.merge(codmdfeletronicolocal);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletroniconf(mdfeletroniconf.getCodmdfeletroniconf()) != null) {
                throw new PreexistingEntityException("Mdfeletroniconf " + mdfeletroniconf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletroniconf mdfeletroniconf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletroniconf persistentMdfeletroniconf = em.find(Mdfeletroniconf.class, mdfeletroniconf.getCodmdfeletroniconf());
            Documento coddocumentoOld = persistentMdfeletroniconf.getCoddocumento();
            Documento coddocumentoNew = mdfeletroniconf.getCoddocumento();
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletroniconf.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletroniconf.getCodmdfeletronico();
            Mdfeletronicolocal codmdfeletronicolocalOld = persistentMdfeletroniconf.getCodmdfeletronicolocal();
            Mdfeletronicolocal codmdfeletronicolocalNew = mdfeletroniconf.getCodmdfeletronicolocal();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                mdfeletroniconf.setCoddocumento(coddocumentoNew);
            }
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletroniconf.setCodmdfeletronico(codmdfeletronicoNew);
            }
            if (codmdfeletronicolocalNew != null) {
                codmdfeletronicolocalNew = em.getReference(codmdfeletronicolocalNew.getClass(), codmdfeletronicolocalNew.getCodmdfeletronicolocal());
                mdfeletroniconf.setCodmdfeletronicolocal(codmdfeletronicolocalNew);
            }
            mdfeletroniconf = em.merge(mdfeletroniconf);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getMdfeletroniconfCollection().add(mdfeletroniconf);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletroniconfCollection().add(mdfeletroniconf);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            if (codmdfeletronicolocalOld != null && !codmdfeletronicolocalOld.equals(codmdfeletronicolocalNew)) {
                codmdfeletronicolocalOld.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                codmdfeletronicolocalOld = em.merge(codmdfeletronicolocalOld);
            }
            if (codmdfeletronicolocalNew != null && !codmdfeletronicolocalNew.equals(codmdfeletronicolocalOld)) {
                codmdfeletronicolocalNew.getMdfeletroniconfCollection().add(mdfeletroniconf);
                codmdfeletronicolocalNew = em.merge(codmdfeletronicolocalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletroniconf.getCodmdfeletroniconf();
                if (findMdfeletroniconf(id) == null) {
                    throw new NonexistentEntityException("The mdfeletroniconf with id " + id + " no longer exists.");
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
            Mdfeletroniconf mdfeletroniconf;
            try {
                mdfeletroniconf = em.getReference(Mdfeletroniconf.class, id);
                mdfeletroniconf.getCodmdfeletroniconf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletroniconf with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = mdfeletroniconf.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                coddocumento = em.merge(coddocumento);
            }
            Mdfeletronico codmdfeletronico = mdfeletroniconf.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Mdfeletronicolocal codmdfeletronicolocal = mdfeletroniconf.getCodmdfeletronicolocal();
            if (codmdfeletronicolocal != null) {
                codmdfeletronicolocal.getMdfeletroniconfCollection().remove(mdfeletroniconf);
                codmdfeletronicolocal = em.merge(codmdfeletronicolocal);
            }
            em.remove(mdfeletroniconf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletroniconf> findMdfeletroniconfEntities() {
        return findMdfeletroniconfEntities(true, -1, -1);
    }

    public List<Mdfeletroniconf> findMdfeletroniconfEntities(int maxResults, int firstResult) {
        return findMdfeletroniconfEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletroniconf> findMdfeletroniconfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletroniconf.class));
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

    public Mdfeletroniconf findMdfeletroniconf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletroniconf.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletroniconfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletroniconf> rt = cq.from(Mdfeletroniconf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
