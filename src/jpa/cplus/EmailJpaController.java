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
import entidade.cplus.Email;
import entidade.cplus.Emailanexo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EmailJpaController implements Serializable {

    public EmailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Email email) throws PreexistingEntityException, Exception {
        if (email.getEmailanexoCollection() == null) {
            email.setEmailanexoCollection(new ArrayList<Emailanexo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = email.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                email.setCodcli(codcli);
            }
            Collection<Emailanexo> attachedEmailanexoCollection = new ArrayList<Emailanexo>();
            for (Emailanexo emailanexoCollectionEmailanexoToAttach : email.getEmailanexoCollection()) {
                emailanexoCollectionEmailanexoToAttach = em.getReference(emailanexoCollectionEmailanexoToAttach.getClass(), emailanexoCollectionEmailanexoToAttach.getCodemailanexo());
                attachedEmailanexoCollection.add(emailanexoCollectionEmailanexoToAttach);
            }
            email.setEmailanexoCollection(attachedEmailanexoCollection);
            em.persist(email);
            if (codcli != null) {
                codcli.getEmailCollection().add(email);
                codcli = em.merge(codcli);
            }
            for (Emailanexo emailanexoCollectionEmailanexo : email.getEmailanexoCollection()) {
                Email oldCodemailOfEmailanexoCollectionEmailanexo = emailanexoCollectionEmailanexo.getCodemail();
                emailanexoCollectionEmailanexo.setCodemail(email);
                emailanexoCollectionEmailanexo = em.merge(emailanexoCollectionEmailanexo);
                if (oldCodemailOfEmailanexoCollectionEmailanexo != null) {
                    oldCodemailOfEmailanexoCollectionEmailanexo.getEmailanexoCollection().remove(emailanexoCollectionEmailanexo);
                    oldCodemailOfEmailanexoCollectionEmailanexo = em.merge(oldCodemailOfEmailanexoCollectionEmailanexo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmail(email.getCodemail()) != null) {
                throw new PreexistingEntityException("Email " + email + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Email email) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Email persistentEmail = em.find(Email.class, email.getCodemail());
            Cliente codcliOld = persistentEmail.getCodcli();
            Cliente codcliNew = email.getCodcli();
            Collection<Emailanexo> emailanexoCollectionOld = persistentEmail.getEmailanexoCollection();
            Collection<Emailanexo> emailanexoCollectionNew = email.getEmailanexoCollection();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                email.setCodcli(codcliNew);
            }
            Collection<Emailanexo> attachedEmailanexoCollectionNew = new ArrayList<Emailanexo>();
            for (Emailanexo emailanexoCollectionNewEmailanexoToAttach : emailanexoCollectionNew) {
                emailanexoCollectionNewEmailanexoToAttach = em.getReference(emailanexoCollectionNewEmailanexoToAttach.getClass(), emailanexoCollectionNewEmailanexoToAttach.getCodemailanexo());
                attachedEmailanexoCollectionNew.add(emailanexoCollectionNewEmailanexoToAttach);
            }
            emailanexoCollectionNew = attachedEmailanexoCollectionNew;
            email.setEmailanexoCollection(emailanexoCollectionNew);
            email = em.merge(email);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getEmailCollection().remove(email);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getEmailCollection().add(email);
                codcliNew = em.merge(codcliNew);
            }
            for (Emailanexo emailanexoCollectionOldEmailanexo : emailanexoCollectionOld) {
                if (!emailanexoCollectionNew.contains(emailanexoCollectionOldEmailanexo)) {
                    emailanexoCollectionOldEmailanexo.setCodemail(null);
                    emailanexoCollectionOldEmailanexo = em.merge(emailanexoCollectionOldEmailanexo);
                }
            }
            for (Emailanexo emailanexoCollectionNewEmailanexo : emailanexoCollectionNew) {
                if (!emailanexoCollectionOld.contains(emailanexoCollectionNewEmailanexo)) {
                    Email oldCodemailOfEmailanexoCollectionNewEmailanexo = emailanexoCollectionNewEmailanexo.getCodemail();
                    emailanexoCollectionNewEmailanexo.setCodemail(email);
                    emailanexoCollectionNewEmailanexo = em.merge(emailanexoCollectionNewEmailanexo);
                    if (oldCodemailOfEmailanexoCollectionNewEmailanexo != null && !oldCodemailOfEmailanexoCollectionNewEmailanexo.equals(email)) {
                        oldCodemailOfEmailanexoCollectionNewEmailanexo.getEmailanexoCollection().remove(emailanexoCollectionNewEmailanexo);
                        oldCodemailOfEmailanexoCollectionNewEmailanexo = em.merge(oldCodemailOfEmailanexoCollectionNewEmailanexo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = email.getCodemail();
                if (findEmail(id) == null) {
                    throw new NonexistentEntityException("The email with id " + id + " no longer exists.");
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
            Email email;
            try {
                email = em.getReference(Email.class, id);
                email.getCodemail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The email with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = email.getCodcli();
            if (codcli != null) {
                codcli.getEmailCollection().remove(email);
                codcli = em.merge(codcli);
            }
            Collection<Emailanexo> emailanexoCollection = email.getEmailanexoCollection();
            for (Emailanexo emailanexoCollectionEmailanexo : emailanexoCollection) {
                emailanexoCollectionEmailanexo.setCodemail(null);
                emailanexoCollectionEmailanexo = em.merge(emailanexoCollectionEmailanexo);
            }
            em.remove(email);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Email> findEmailEntities() {
        return findEmailEntities(true, -1, -1);
    }

    public List<Email> findEmailEntities(int maxResults, int firstResult) {
        return findEmailEntities(false, maxResults, firstResult);
    }

    private List<Email> findEmailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Email.class));
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

    public Email findEmail(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Email.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Email> rt = cq.from(Email.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
