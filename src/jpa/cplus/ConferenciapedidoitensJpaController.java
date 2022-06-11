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
import entidade.cplus.Conferenciapedido;
import entidade.cplus.Conferenciapedidoitens;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConferenciapedidoitensJpaController implements Serializable {

    public ConferenciapedidoitensJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conferenciapedidoitens conferenciapedidoitens) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciapedido codconferenciapedido = conferenciapedidoitens.getCodconferenciapedido();
            if (codconferenciapedido != null) {
                codconferenciapedido = em.getReference(codconferenciapedido.getClass(), codconferenciapedido.getCodconferenciapedido());
                conferenciapedidoitens.setCodconferenciapedido(codconferenciapedido);
            }
            em.persist(conferenciapedidoitens);
            if (codconferenciapedido != null) {
                codconferenciapedido.getConferenciapedidoitensCollection().add(conferenciapedidoitens);
                codconferenciapedido = em.merge(codconferenciapedido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConferenciapedidoitens(conferenciapedidoitens.getCodconferenciapedidoitens()) != null) {
                throw new PreexistingEntityException("Conferenciapedidoitens " + conferenciapedidoitens + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conferenciapedidoitens conferenciapedidoitens) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciapedidoitens persistentConferenciapedidoitens = em.find(Conferenciapedidoitens.class, conferenciapedidoitens.getCodconferenciapedidoitens());
            Conferenciapedido codconferenciapedidoOld = persistentConferenciapedidoitens.getCodconferenciapedido();
            Conferenciapedido codconferenciapedidoNew = conferenciapedidoitens.getCodconferenciapedido();
            if (codconferenciapedidoNew != null) {
                codconferenciapedidoNew = em.getReference(codconferenciapedidoNew.getClass(), codconferenciapedidoNew.getCodconferenciapedido());
                conferenciapedidoitens.setCodconferenciapedido(codconferenciapedidoNew);
            }
            conferenciapedidoitens = em.merge(conferenciapedidoitens);
            if (codconferenciapedidoOld != null && !codconferenciapedidoOld.equals(codconferenciapedidoNew)) {
                codconferenciapedidoOld.getConferenciapedidoitensCollection().remove(conferenciapedidoitens);
                codconferenciapedidoOld = em.merge(codconferenciapedidoOld);
            }
            if (codconferenciapedidoNew != null && !codconferenciapedidoNew.equals(codconferenciapedidoOld)) {
                codconferenciapedidoNew.getConferenciapedidoitensCollection().add(conferenciapedidoitens);
                codconferenciapedidoNew = em.merge(codconferenciapedidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conferenciapedidoitens.getCodconferenciapedidoitens();
                if (findConferenciapedidoitens(id) == null) {
                    throw new NonexistentEntityException("The conferenciapedidoitens with id " + id + " no longer exists.");
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
            Conferenciapedidoitens conferenciapedidoitens;
            try {
                conferenciapedidoitens = em.getReference(Conferenciapedidoitens.class, id);
                conferenciapedidoitens.getCodconferenciapedidoitens();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conferenciapedidoitens with id " + id + " no longer exists.", enfe);
            }
            Conferenciapedido codconferenciapedido = conferenciapedidoitens.getCodconferenciapedido();
            if (codconferenciapedido != null) {
                codconferenciapedido.getConferenciapedidoitensCollection().remove(conferenciapedidoitens);
                codconferenciapedido = em.merge(codconferenciapedido);
            }
            em.remove(conferenciapedidoitens);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conferenciapedidoitens> findConferenciapedidoitensEntities() {
        return findConferenciapedidoitensEntities(true, -1, -1);
    }

    public List<Conferenciapedidoitens> findConferenciapedidoitensEntities(int maxResults, int firstResult) {
        return findConferenciapedidoitensEntities(false, maxResults, firstResult);
    }

    private List<Conferenciapedidoitens> findConferenciapedidoitensEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conferenciapedidoitens.class));
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

    public Conferenciapedidoitens findConferenciapedidoitens(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conferenciapedidoitens.class, id);
        } finally {
            em.close();
        }
    }

    public int getConferenciapedidoitensCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conferenciapedidoitens> rt = cq.from(Conferenciapedidoitens.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
