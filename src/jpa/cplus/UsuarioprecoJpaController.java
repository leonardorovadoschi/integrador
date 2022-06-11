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
import entidade.cplus.Preco;
import entidade.cplus.Usuario;
import entidade.cplus.Usuariopreco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class UsuarioprecoJpaController implements Serializable {

    public UsuarioprecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuariopreco usuariopreco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preco codpreco = usuariopreco.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                usuariopreco.setCodpreco(codpreco);
            }
            Usuario coduser = usuariopreco.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                usuariopreco.setCoduser(coduser);
            }
            em.persist(usuariopreco);
            if (codpreco != null) {
                codpreco.getUsuarioprecoCollection().add(usuariopreco);
                codpreco = em.merge(codpreco);
            }
            if (coduser != null) {
                coduser.getUsuarioprecoCollection().add(usuariopreco);
                coduser = em.merge(coduser);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuariopreco(usuariopreco.getCodusuariopreco()) != null) {
                throw new PreexistingEntityException("Usuariopreco " + usuariopreco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuariopreco usuariopreco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuariopreco persistentUsuariopreco = em.find(Usuariopreco.class, usuariopreco.getCodusuariopreco());
            Preco codprecoOld = persistentUsuariopreco.getCodpreco();
            Preco codprecoNew = usuariopreco.getCodpreco();
            Usuario coduserOld = persistentUsuariopreco.getCoduser();
            Usuario coduserNew = usuariopreco.getCoduser();
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                usuariopreco.setCodpreco(codprecoNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                usuariopreco.setCoduser(coduserNew);
            }
            usuariopreco = em.merge(usuariopreco);
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getUsuarioprecoCollection().remove(usuariopreco);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getUsuarioprecoCollection().add(usuariopreco);
                codprecoNew = em.merge(codprecoNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getUsuarioprecoCollection().remove(usuariopreco);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getUsuarioprecoCollection().add(usuariopreco);
                coduserNew = em.merge(coduserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuariopreco.getCodusuariopreco();
                if (findUsuariopreco(id) == null) {
                    throw new NonexistentEntityException("The usuariopreco with id " + id + " no longer exists.");
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
            Usuariopreco usuariopreco;
            try {
                usuariopreco = em.getReference(Usuariopreco.class, id);
                usuariopreco.getCodusuariopreco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuariopreco with id " + id + " no longer exists.", enfe);
            }
            Preco codpreco = usuariopreco.getCodpreco();
            if (codpreco != null) {
                codpreco.getUsuarioprecoCollection().remove(usuariopreco);
                codpreco = em.merge(codpreco);
            }
            Usuario coduser = usuariopreco.getCoduser();
            if (coduser != null) {
                coduser.getUsuarioprecoCollection().remove(usuariopreco);
                coduser = em.merge(coduser);
            }
            em.remove(usuariopreco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuariopreco> findUsuarioprecoEntities() {
        return findUsuarioprecoEntities(true, -1, -1);
    }

    public List<Usuariopreco> findUsuarioprecoEntities(int maxResults, int firstResult) {
        return findUsuarioprecoEntities(false, maxResults, firstResult);
    }

    private List<Usuariopreco> findUsuarioprecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuariopreco.class));
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

    public Usuariopreco findUsuariopreco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuariopreco.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioprecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuariopreco> rt = cq.from(Usuariopreco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
