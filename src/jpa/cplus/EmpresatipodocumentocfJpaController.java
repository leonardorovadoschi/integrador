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
import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Empresatipodocumento;
import entidade.cplus.Empresatipodocumentocf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EmpresatipodocumentocfJpaController implements Serializable {

    public EmpresatipodocumentocfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresatipodocumentocf empresatipodocumentocf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classificacaofiscal codclassificacaofiscal = empresatipodocumentocf.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal = em.getReference(codclassificacaofiscal.getClass(), codclassificacaofiscal.getCodclassificacaofiscal());
                empresatipodocumentocf.setCodclassificacaofiscal(codclassificacaofiscal);
            }
            Empresatipodocumento codempresatipodocumento = empresatipodocumentocf.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento = em.getReference(codempresatipodocumento.getClass(), codempresatipodocumento.getCodempresatipodocumento());
                empresatipodocumentocf.setCodempresatipodocumento(codempresatipodocumento);
            }
            em.persist(empresatipodocumentocf);
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getEmpresatipodocumentocfCollection().add(empresatipodocumentocf);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getEmpresatipodocumentocfCollection().add(empresatipodocumentocf);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresatipodocumentocf(empresatipodocumentocf.getCodempresatipodocumentocf()) != null) {
                throw new PreexistingEntityException("Empresatipodocumentocf " + empresatipodocumentocf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresatipodocumentocf empresatipodocumentocf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresatipodocumentocf persistentEmpresatipodocumentocf = em.find(Empresatipodocumentocf.class, empresatipodocumentocf.getCodempresatipodocumentocf());
            Classificacaofiscal codclassificacaofiscalOld = persistentEmpresatipodocumentocf.getCodclassificacaofiscal();
            Classificacaofiscal codclassificacaofiscalNew = empresatipodocumentocf.getCodclassificacaofiscal();
            Empresatipodocumento codempresatipodocumentoOld = persistentEmpresatipodocumentocf.getCodempresatipodocumento();
            Empresatipodocumento codempresatipodocumentoNew = empresatipodocumentocf.getCodempresatipodocumento();
            if (codclassificacaofiscalNew != null) {
                codclassificacaofiscalNew = em.getReference(codclassificacaofiscalNew.getClass(), codclassificacaofiscalNew.getCodclassificacaofiscal());
                empresatipodocumentocf.setCodclassificacaofiscal(codclassificacaofiscalNew);
            }
            if (codempresatipodocumentoNew != null) {
                codempresatipodocumentoNew = em.getReference(codempresatipodocumentoNew.getClass(), codempresatipodocumentoNew.getCodempresatipodocumento());
                empresatipodocumentocf.setCodempresatipodocumento(codempresatipodocumentoNew);
            }
            empresatipodocumentocf = em.merge(empresatipodocumentocf);
            if (codclassificacaofiscalOld != null && !codclassificacaofiscalOld.equals(codclassificacaofiscalNew)) {
                codclassificacaofiscalOld.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocf);
                codclassificacaofiscalOld = em.merge(codclassificacaofiscalOld);
            }
            if (codclassificacaofiscalNew != null && !codclassificacaofiscalNew.equals(codclassificacaofiscalOld)) {
                codclassificacaofiscalNew.getEmpresatipodocumentocfCollection().add(empresatipodocumentocf);
                codclassificacaofiscalNew = em.merge(codclassificacaofiscalNew);
            }
            if (codempresatipodocumentoOld != null && !codempresatipodocumentoOld.equals(codempresatipodocumentoNew)) {
                codempresatipodocumentoOld.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocf);
                codempresatipodocumentoOld = em.merge(codempresatipodocumentoOld);
            }
            if (codempresatipodocumentoNew != null && !codempresatipodocumentoNew.equals(codempresatipodocumentoOld)) {
                codempresatipodocumentoNew.getEmpresatipodocumentocfCollection().add(empresatipodocumentocf);
                codempresatipodocumentoNew = em.merge(codempresatipodocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresatipodocumentocf.getCodempresatipodocumentocf();
                if (findEmpresatipodocumentocf(id) == null) {
                    throw new NonexistentEntityException("The empresatipodocumentocf with id " + id + " no longer exists.");
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
            Empresatipodocumentocf empresatipodocumentocf;
            try {
                empresatipodocumentocf = em.getReference(Empresatipodocumentocf.class, id);
                empresatipodocumentocf.getCodempresatipodocumentocf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresatipodocumentocf with id " + id + " no longer exists.", enfe);
            }
            Classificacaofiscal codclassificacaofiscal = empresatipodocumentocf.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocf);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            Empresatipodocumento codempresatipodocumento = empresatipodocumentocf.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocf);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            em.remove(empresatipodocumentocf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresatipodocumentocf> findEmpresatipodocumentocfEntities() {
        return findEmpresatipodocumentocfEntities(true, -1, -1);
    }

    public List<Empresatipodocumentocf> findEmpresatipodocumentocfEntities(int maxResults, int firstResult) {
        return findEmpresatipodocumentocfEntities(false, maxResults, firstResult);
    }

    private List<Empresatipodocumentocf> findEmpresatipodocumentocfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresatipodocumentocf.class));
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

    public Empresatipodocumentocf findEmpresatipodocumentocf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresatipodocumentocf.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresatipodocumentocfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresatipodocumentocf> rt = cq.from(Empresatipodocumentocf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
