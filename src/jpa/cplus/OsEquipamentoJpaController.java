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
import entidade.cplus.Cliente;
import entidade.cplus.OsEquipamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsEquipamentoJpaController implements Serializable {

    public OsEquipamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsEquipamento osEquipamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = osEquipamento.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                osEquipamento.setCodcli(codcli);
            }
            em.persist(osEquipamento);
            if (codcli != null) {
                codcli.getOsEquipamentoCollection().add(osEquipamento);
                codcli = em.merge(codcli);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsEquipamento(osEquipamento.getCodequip()) != null) {
                throw new PreexistingEntityException("OsEquipamento " + osEquipamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsEquipamento osEquipamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsEquipamento persistentOsEquipamento = em.find(OsEquipamento.class, osEquipamento.getCodequip());
            Cliente codcliOld = persistentOsEquipamento.getCodcli();
            Cliente codcliNew = osEquipamento.getCodcli();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                osEquipamento.setCodcli(codcliNew);
            }
            osEquipamento = em.merge(osEquipamento);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getOsEquipamentoCollection().remove(osEquipamento);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getOsEquipamentoCollection().add(osEquipamento);
                codcliNew = em.merge(codcliNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osEquipamento.getCodequip();
                if (findOsEquipamento(id) == null) {
                    throw new NonexistentEntityException("The osEquipamento with id " + id + " no longer exists.");
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
            OsEquipamento osEquipamento;
            try {
                osEquipamento = em.getReference(OsEquipamento.class, id);
                osEquipamento.getCodequip();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osEquipamento with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = osEquipamento.getCodcli();
            if (codcli != null) {
                codcli.getOsEquipamentoCollection().remove(osEquipamento);
                codcli = em.merge(codcli);
            }
            em.remove(osEquipamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsEquipamento> findOsEquipamentoEntities() {
        return findOsEquipamentoEntities(true, -1, -1);
    }

    public List<OsEquipamento> findOsEquipamentoEntities(int maxResults, int firstResult) {
        return findOsEquipamentoEntities(false, maxResults, firstResult);
    }

    private List<OsEquipamento> findOsEquipamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsEquipamento.class));
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

    public OsEquipamento findOsEquipamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsEquipamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsEquipamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsEquipamento> rt = cq.from(OsEquipamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
