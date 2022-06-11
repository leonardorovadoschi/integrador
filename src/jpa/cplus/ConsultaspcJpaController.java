/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Consultaspc;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Consultaspcnaturezaoperacao;
import entidade.cplus.Consultaspctipodocumento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConsultaspcJpaController implements Serializable {

    public ConsultaspcJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultaspc consultaspc) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaspcnaturezaoperacao codconsspcnaturezaop = consultaspc.getCodconsspcnaturezaop();
            if (codconsspcnaturezaop != null) {
                codconsspcnaturezaop = em.getReference(codconsspcnaturezaop.getClass(), codconsspcnaturezaop.getCodconsspcnaturezaop());
                consultaspc.setCodconsspcnaturezaop(codconsspcnaturezaop);
            }
            Consultaspctipodocumento codconsultpdoc = consultaspc.getCodconsultpdoc();
            if (codconsultpdoc != null) {
                codconsultpdoc = em.getReference(codconsultpdoc.getClass(), codconsultpdoc.getCodconsultpdoc());
                consultaspc.setCodconsultpdoc(codconsultpdoc);
            }
            em.persist(consultaspc);
            if (codconsspcnaturezaop != null) {
                codconsspcnaturezaop.getConsultaspcCollection().add(consultaspc);
                codconsspcnaturezaop = em.merge(codconsspcnaturezaop);
            }
            if (codconsultpdoc != null) {
                codconsultpdoc.getConsultaspcCollection().add(consultaspc);
                codconsultpdoc = em.merge(codconsultpdoc);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsultaspc(consultaspc.getCodconsultaspc()) != null) {
                throw new PreexistingEntityException("Consultaspc " + consultaspc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultaspc consultaspc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaspc persistentConsultaspc = em.find(Consultaspc.class, consultaspc.getCodconsultaspc());
            Consultaspcnaturezaoperacao codconsspcnaturezaopOld = persistentConsultaspc.getCodconsspcnaturezaop();
            Consultaspcnaturezaoperacao codconsspcnaturezaopNew = consultaspc.getCodconsspcnaturezaop();
            Consultaspctipodocumento codconsultpdocOld = persistentConsultaspc.getCodconsultpdoc();
            Consultaspctipodocumento codconsultpdocNew = consultaspc.getCodconsultpdoc();
            if (codconsspcnaturezaopNew != null) {
                codconsspcnaturezaopNew = em.getReference(codconsspcnaturezaopNew.getClass(), codconsspcnaturezaopNew.getCodconsspcnaturezaop());
                consultaspc.setCodconsspcnaturezaop(codconsspcnaturezaopNew);
            }
            if (codconsultpdocNew != null) {
                codconsultpdocNew = em.getReference(codconsultpdocNew.getClass(), codconsultpdocNew.getCodconsultpdoc());
                consultaspc.setCodconsultpdoc(codconsultpdocNew);
            }
            consultaspc = em.merge(consultaspc);
            if (codconsspcnaturezaopOld != null && !codconsspcnaturezaopOld.equals(codconsspcnaturezaopNew)) {
                codconsspcnaturezaopOld.getConsultaspcCollection().remove(consultaspc);
                codconsspcnaturezaopOld = em.merge(codconsspcnaturezaopOld);
            }
            if (codconsspcnaturezaopNew != null && !codconsspcnaturezaopNew.equals(codconsspcnaturezaopOld)) {
                codconsspcnaturezaopNew.getConsultaspcCollection().add(consultaspc);
                codconsspcnaturezaopNew = em.merge(codconsspcnaturezaopNew);
            }
            if (codconsultpdocOld != null && !codconsultpdocOld.equals(codconsultpdocNew)) {
                codconsultpdocOld.getConsultaspcCollection().remove(consultaspc);
                codconsultpdocOld = em.merge(codconsultpdocOld);
            }
            if (codconsultpdocNew != null && !codconsultpdocNew.equals(codconsultpdocOld)) {
                codconsultpdocNew.getConsultaspcCollection().add(consultaspc);
                codconsultpdocNew = em.merge(codconsultpdocNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consultaspc.getCodconsultaspc();
                if (findConsultaspc(id) == null) {
                    throw new NonexistentEntityException("The consultaspc with id " + id + " no longer exists.");
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
            Consultaspc consultaspc;
            try {
                consultaspc = em.getReference(Consultaspc.class, id);
                consultaspc.getCodconsultaspc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaspc with id " + id + " no longer exists.", enfe);
            }
            Consultaspcnaturezaoperacao codconsspcnaturezaop = consultaspc.getCodconsspcnaturezaop();
            if (codconsspcnaturezaop != null) {
                codconsspcnaturezaop.getConsultaspcCollection().remove(consultaspc);
                codconsspcnaturezaop = em.merge(codconsspcnaturezaop);
            }
            Consultaspctipodocumento codconsultpdoc = consultaspc.getCodconsultpdoc();
            if (codconsultpdoc != null) {
                codconsultpdoc.getConsultaspcCollection().remove(consultaspc);
                codconsultpdoc = em.merge(codconsultpdoc);
            }
            em.remove(consultaspc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultaspc> findConsultaspcEntities() {
        return findConsultaspcEntities(true, -1, -1);
    }

    public List<Consultaspc> findConsultaspcEntities(int maxResults, int firstResult) {
        return findConsultaspcEntities(false, maxResults, firstResult);
    }

    private List<Consultaspc> findConsultaspcEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultaspc.class));
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

    public Consultaspc findConsultaspc(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultaspc.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaspcCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultaspc> rt = cq.from(Consultaspc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
