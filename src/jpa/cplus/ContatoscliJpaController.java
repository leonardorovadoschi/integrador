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
import entidade.cplus.Contatoscli;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContatoscliJpaController implements Serializable {

    public ContatoscliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contatoscli contatoscli) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = contatoscli.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                contatoscli.setCodcli(codcli);
            }
            em.persist(contatoscli);
            if (codcli != null) {
                codcli.getContatoscliCollection().add(contatoscli);
                codcli = em.merge(codcli);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContatoscli(contatoscli.getCodctc()) != null) {
                throw new PreexistingEntityException("Contatoscli " + contatoscli + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contatoscli contatoscli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contatoscli persistentContatoscli = em.find(Contatoscli.class, contatoscli.getCodctc());
            Cliente codcliOld = persistentContatoscli.getCodcli();
            Cliente codcliNew = contatoscli.getCodcli();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                contatoscli.setCodcli(codcliNew);
            }
            contatoscli = em.merge(contatoscli);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getContatoscliCollection().remove(contatoscli);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getContatoscliCollection().add(contatoscli);
                codcliNew = em.merge(codcliNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contatoscli.getCodctc();
                if (findContatoscli(id) == null) {
                    throw new NonexistentEntityException("The contatoscli with id " + id + " no longer exists.");
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
            Contatoscli contatoscli;
            try {
                contatoscli = em.getReference(Contatoscli.class, id);
                contatoscli.getCodctc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contatoscli with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = contatoscli.getCodcli();
            if (codcli != null) {
                codcli.getContatoscliCollection().remove(contatoscli);
                codcli = em.merge(codcli);
            }
            em.remove(contatoscli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contatoscli> findContatoscliEntities() {
        return findContatoscliEntities(true, -1, -1);
    }

    public List<Contatoscli> findContatoscliEntities(int maxResults, int firstResult) {
        return findContatoscliEntities(false, maxResults, firstResult);
    }

    private List<Contatoscli> findContatoscliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contatoscli.class));
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

    public Contatoscli findContatoscli(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contatoscli.class, id);
        } finally {
            em.close();
        }
    }

    public int getContatoscliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contatoscli> rt = cq.from(Contatoscli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
