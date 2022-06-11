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
import entidade.cplus.Email;
import entidade.cplus.Emailanexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EmailanexoJpaController implements Serializable {

    public EmailanexoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Emailanexo emailanexo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Email codemail = emailanexo.getCodemail();
            if (codemail != null) {
                codemail = em.getReference(codemail.getClass(), codemail.getCodemail());
                emailanexo.setCodemail(codemail);
            }
            em.persist(emailanexo);
            if (codemail != null) {
                codemail.getEmailanexoCollection().add(emailanexo);
                codemail = em.merge(codemail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmailanexo(emailanexo.getCodemailanexo()) != null) {
                throw new PreexistingEntityException("Emailanexo " + emailanexo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Emailanexo emailanexo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Emailanexo persistentEmailanexo = em.find(Emailanexo.class, emailanexo.getCodemailanexo());
            Email codemailOld = persistentEmailanexo.getCodemail();
            Email codemailNew = emailanexo.getCodemail();
            if (codemailNew != null) {
                codemailNew = em.getReference(codemailNew.getClass(), codemailNew.getCodemail());
                emailanexo.setCodemail(codemailNew);
            }
            emailanexo = em.merge(emailanexo);
            if (codemailOld != null && !codemailOld.equals(codemailNew)) {
                codemailOld.getEmailanexoCollection().remove(emailanexo);
                codemailOld = em.merge(codemailOld);
            }
            if (codemailNew != null && !codemailNew.equals(codemailOld)) {
                codemailNew.getEmailanexoCollection().add(emailanexo);
                codemailNew = em.merge(codemailNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = emailanexo.getCodemailanexo();
                if (findEmailanexo(id) == null) {
                    throw new NonexistentEntityException("The emailanexo with id " + id + " no longer exists.");
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
            Emailanexo emailanexo;
            try {
                emailanexo = em.getReference(Emailanexo.class, id);
                emailanexo.getCodemailanexo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The emailanexo with id " + id + " no longer exists.", enfe);
            }
            Email codemail = emailanexo.getCodemail();
            if (codemail != null) {
                codemail.getEmailanexoCollection().remove(emailanexo);
                codemail = em.merge(codemail);
            }
            em.remove(emailanexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Emailanexo> findEmailanexoEntities() {
        return findEmailanexoEntities(true, -1, -1);
    }

    public List<Emailanexo> findEmailanexoEntities(int maxResults, int firstResult) {
        return findEmailanexoEntities(false, maxResults, firstResult);
    }

    private List<Emailanexo> findEmailanexoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Emailanexo.class));
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

    public Emailanexo findEmailanexo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Emailanexo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmailanexoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Emailanexo> rt = cq.from(Emailanexo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
