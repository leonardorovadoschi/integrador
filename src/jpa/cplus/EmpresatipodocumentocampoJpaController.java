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
import entidade.cplus.Empresatipodocumentocampo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EmpresatipodocumentocampoJpaController implements Serializable {

    public EmpresatipodocumentocampoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresatipodocumentocampo empresatipodocumentocampo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresatipodocumento codempresatipodocumento = empresatipodocumentocampo.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento = em.getReference(codempresatipodocumento.getClass(), codempresatipodocumento.getCodempresatipodocumento());
                empresatipodocumentocampo.setCodempresatipodocumento(codempresatipodocumento);
            }
            em.persist(empresatipodocumentocampo);
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getEmpresatipodocumentocampoCollection().add(empresatipodocumentocampo);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresatipodocumentocampo(empresatipodocumentocampo.getCodempresatipodocumentocampo()) != null) {
                throw new PreexistingEntityException("Empresatipodocumentocampo " + empresatipodocumentocampo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresatipodocumentocampo empresatipodocumentocampo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresatipodocumentocampo persistentEmpresatipodocumentocampo = em.find(Empresatipodocumentocampo.class, empresatipodocumentocampo.getCodempresatipodocumentocampo());
            Empresatipodocumento codempresatipodocumentoOld = persistentEmpresatipodocumentocampo.getCodempresatipodocumento();
            Empresatipodocumento codempresatipodocumentoNew = empresatipodocumentocampo.getCodempresatipodocumento();
            if (codempresatipodocumentoNew != null) {
                codempresatipodocumentoNew = em.getReference(codempresatipodocumentoNew.getClass(), codempresatipodocumentoNew.getCodempresatipodocumento());
                empresatipodocumentocampo.setCodempresatipodocumento(codempresatipodocumentoNew);
            }
            empresatipodocumentocampo = em.merge(empresatipodocumentocampo);
            if (codempresatipodocumentoOld != null && !codempresatipodocumentoOld.equals(codempresatipodocumentoNew)) {
                codempresatipodocumentoOld.getEmpresatipodocumentocampoCollection().remove(empresatipodocumentocampo);
                codempresatipodocumentoOld = em.merge(codempresatipodocumentoOld);
            }
            if (codempresatipodocumentoNew != null && !codempresatipodocumentoNew.equals(codempresatipodocumentoOld)) {
                codempresatipodocumentoNew.getEmpresatipodocumentocampoCollection().add(empresatipodocumentocampo);
                codempresatipodocumentoNew = em.merge(codempresatipodocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresatipodocumentocampo.getCodempresatipodocumentocampo();
                if (findEmpresatipodocumentocampo(id) == null) {
                    throw new NonexistentEntityException("The empresatipodocumentocampo with id " + id + " no longer exists.");
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
            Empresatipodocumentocampo empresatipodocumentocampo;
            try {
                empresatipodocumentocampo = em.getReference(Empresatipodocumentocampo.class, id);
                empresatipodocumentocampo.getCodempresatipodocumentocampo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresatipodocumentocampo with id " + id + " no longer exists.", enfe);
            }
            Empresatipodocumento codempresatipodocumento = empresatipodocumentocampo.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getEmpresatipodocumentocampoCollection().remove(empresatipodocumentocampo);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            em.remove(empresatipodocumentocampo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresatipodocumentocampo> findEmpresatipodocumentocampoEntities() {
        return findEmpresatipodocumentocampoEntities(true, -1, -1);
    }

    public List<Empresatipodocumentocampo> findEmpresatipodocumentocampoEntities(int maxResults, int firstResult) {
        return findEmpresatipodocumentocampoEntities(false, maxResults, firstResult);
    }

    private List<Empresatipodocumentocampo> findEmpresatipodocumentocampoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresatipodocumentocampo.class));
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

    public Empresatipodocumentocampo findEmpresatipodocumentocampo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresatipodocumentocampo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresatipodocumentocampoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresatipodocumentocampo> rt = cq.from(Empresatipodocumentocampo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
