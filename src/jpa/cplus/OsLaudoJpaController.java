/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsLaudo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.OsOrdemservico;
import entidade.cplus.OsStatus;
import entidade.cplus.OsTecnico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsLaudoJpaController implements Serializable {

    public OsLaudoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsLaudo osLaudo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico codos = osLaudo.getCodos();
            if (codos != null) {
                codos = em.getReference(codos.getClass(), codos.getCodos());
                osLaudo.setCodos(codos);
            }
            OsStatus codstatus = osLaudo.getCodstatus();
            if (codstatus != null) {
                codstatus = em.getReference(codstatus.getClass(), codstatus.getCodstatus());
                osLaudo.setCodstatus(codstatus);
            }
            OsTecnico codtec = osLaudo.getCodtec();
            if (codtec != null) {
                codtec = em.getReference(codtec.getClass(), codtec.getCodtec());
                osLaudo.setCodtec(codtec);
            }
            em.persist(osLaudo);
            if (codos != null) {
                codos.getOsLaudoCollection().add(osLaudo);
                codos = em.merge(codos);
            }
            if (codstatus != null) {
                codstatus.getOsLaudoCollection().add(osLaudo);
                codstatus = em.merge(codstatus);
            }
            if (codtec != null) {
                codtec.getOsLaudoCollection().add(osLaudo);
                codtec = em.merge(codtec);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsLaudo(osLaudo.getCodlaudo()) != null) {
                throw new PreexistingEntityException("OsLaudo " + osLaudo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsLaudo osLaudo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsLaudo persistentOsLaudo = em.find(OsLaudo.class, osLaudo.getCodlaudo());
            OsOrdemservico codosOld = persistentOsLaudo.getCodos();
            OsOrdemservico codosNew = osLaudo.getCodos();
            OsStatus codstatusOld = persistentOsLaudo.getCodstatus();
            OsStatus codstatusNew = osLaudo.getCodstatus();
            OsTecnico codtecOld = persistentOsLaudo.getCodtec();
            OsTecnico codtecNew = osLaudo.getCodtec();
            if (codosNew != null) {
                codosNew = em.getReference(codosNew.getClass(), codosNew.getCodos());
                osLaudo.setCodos(codosNew);
            }
            if (codstatusNew != null) {
                codstatusNew = em.getReference(codstatusNew.getClass(), codstatusNew.getCodstatus());
                osLaudo.setCodstatus(codstatusNew);
            }
            if (codtecNew != null) {
                codtecNew = em.getReference(codtecNew.getClass(), codtecNew.getCodtec());
                osLaudo.setCodtec(codtecNew);
            }
            osLaudo = em.merge(osLaudo);
            if (codosOld != null && !codosOld.equals(codosNew)) {
                codosOld.getOsLaudoCollection().remove(osLaudo);
                codosOld = em.merge(codosOld);
            }
            if (codosNew != null && !codosNew.equals(codosOld)) {
                codosNew.getOsLaudoCollection().add(osLaudo);
                codosNew = em.merge(codosNew);
            }
            if (codstatusOld != null && !codstatusOld.equals(codstatusNew)) {
                codstatusOld.getOsLaudoCollection().remove(osLaudo);
                codstatusOld = em.merge(codstatusOld);
            }
            if (codstatusNew != null && !codstatusNew.equals(codstatusOld)) {
                codstatusNew.getOsLaudoCollection().add(osLaudo);
                codstatusNew = em.merge(codstatusNew);
            }
            if (codtecOld != null && !codtecOld.equals(codtecNew)) {
                codtecOld.getOsLaudoCollection().remove(osLaudo);
                codtecOld = em.merge(codtecOld);
            }
            if (codtecNew != null && !codtecNew.equals(codtecOld)) {
                codtecNew.getOsLaudoCollection().add(osLaudo);
                codtecNew = em.merge(codtecNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osLaudo.getCodlaudo();
                if (findOsLaudo(id) == null) {
                    throw new NonexistentEntityException("The osLaudo with id " + id + " no longer exists.");
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
            OsLaudo osLaudo;
            try {
                osLaudo = em.getReference(OsLaudo.class, id);
                osLaudo.getCodlaudo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osLaudo with id " + id + " no longer exists.", enfe);
            }
            OsOrdemservico codos = osLaudo.getCodos();
            if (codos != null) {
                codos.getOsLaudoCollection().remove(osLaudo);
                codos = em.merge(codos);
            }
            OsStatus codstatus = osLaudo.getCodstatus();
            if (codstatus != null) {
                codstatus.getOsLaudoCollection().remove(osLaudo);
                codstatus = em.merge(codstatus);
            }
            OsTecnico codtec = osLaudo.getCodtec();
            if (codtec != null) {
                codtec.getOsLaudoCollection().remove(osLaudo);
                codtec = em.merge(codtec);
            }
            em.remove(osLaudo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsLaudo> findOsLaudoEntities() {
        return findOsLaudoEntities(true, -1, -1);
    }

    public List<OsLaudo> findOsLaudoEntities(int maxResults, int firstResult) {
        return findOsLaudoEntities(false, maxResults, firstResult);
    }

    private List<OsLaudo> findOsLaudoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsLaudo.class));
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

    public OsLaudo findOsLaudo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsLaudo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsLaudoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsLaudo> rt = cq.from(OsLaudo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
