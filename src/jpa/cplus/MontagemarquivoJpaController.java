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
import entidade.cplus.Banco;
import entidade.cplus.Montagemarquivo;
import entidade.cplus.Montagemarquivoitem;
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
public class MontagemarquivoJpaController implements Serializable {

    public MontagemarquivoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Montagemarquivo montagemarquivo) throws PreexistingEntityException, Exception {
        if (montagemarquivo.getMontagemarquivoitemCollection() == null) {
            montagemarquivo.setMontagemarquivoitemCollection(new ArrayList<Montagemarquivoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco codbanco = montagemarquivo.getCodbanco();
            if (codbanco != null) {
                codbanco = em.getReference(codbanco.getClass(), codbanco.getCodbanco());
                montagemarquivo.setCodbanco(codbanco);
            }
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollection = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitemToAttach : montagemarquivo.getMontagemarquivoitemCollection()) {
                montagemarquivoitemCollectionMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollection.add(montagemarquivoitemCollectionMontagemarquivoitemToAttach);
            }
            montagemarquivo.setMontagemarquivoitemCollection(attachedMontagemarquivoitemCollection);
            em.persist(montagemarquivo);
            if (codbanco != null) {
                codbanco.getMontagemarquivoCollection().add(montagemarquivo);
                codbanco = em.merge(codbanco);
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : montagemarquivo.getMontagemarquivoitemCollection()) {
                Montagemarquivo oldCodmontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem = montagemarquivoitemCollectionMontagemarquivoitem.getCodmontagemarquivo();
                montagemarquivoitemCollectionMontagemarquivoitem.setCodmontagemarquivo(montagemarquivo);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
                if (oldCodmontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem != null) {
                    oldCodmontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionMontagemarquivoitem);
                    oldCodmontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem = em.merge(oldCodmontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMontagemarquivo(montagemarquivo.getCodmontagemarquivo()) != null) {
                throw new PreexistingEntityException("Montagemarquivo " + montagemarquivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Montagemarquivo montagemarquivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Montagemarquivo persistentMontagemarquivo = em.find(Montagemarquivo.class, montagemarquivo.getCodmontagemarquivo());
            Banco codbancoOld = persistentMontagemarquivo.getCodbanco();
            Banco codbancoNew = montagemarquivo.getCodbanco();
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionOld = persistentMontagemarquivo.getMontagemarquivoitemCollection();
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionNew = montagemarquivo.getMontagemarquivoitemCollection();
            if (codbancoNew != null) {
                codbancoNew = em.getReference(codbancoNew.getClass(), codbancoNew.getCodbanco());
                montagemarquivo.setCodbanco(codbancoNew);
            }
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollectionNew = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitemToAttach : montagemarquivoitemCollectionNew) {
                montagemarquivoitemCollectionNewMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollectionNew.add(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach);
            }
            montagemarquivoitemCollectionNew = attachedMontagemarquivoitemCollectionNew;
            montagemarquivo.setMontagemarquivoitemCollection(montagemarquivoitemCollectionNew);
            montagemarquivo = em.merge(montagemarquivo);
            if (codbancoOld != null && !codbancoOld.equals(codbancoNew)) {
                codbancoOld.getMontagemarquivoCollection().remove(montagemarquivo);
                codbancoOld = em.merge(codbancoOld);
            }
            if (codbancoNew != null && !codbancoNew.equals(codbancoOld)) {
                codbancoNew.getMontagemarquivoCollection().add(montagemarquivo);
                codbancoNew = em.merge(codbancoNew);
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionOldMontagemarquivoitem : montagemarquivoitemCollectionOld) {
                if (!montagemarquivoitemCollectionNew.contains(montagemarquivoitemCollectionOldMontagemarquivoitem)) {
                    montagemarquivoitemCollectionOldMontagemarquivoitem.setCodmontagemarquivo(null);
                    montagemarquivoitemCollectionOldMontagemarquivoitem = em.merge(montagemarquivoitemCollectionOldMontagemarquivoitem);
                }
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitem : montagemarquivoitemCollectionNew) {
                if (!montagemarquivoitemCollectionOld.contains(montagemarquivoitemCollectionNewMontagemarquivoitem)) {
                    Montagemarquivo oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem = montagemarquivoitemCollectionNewMontagemarquivoitem.getCodmontagemarquivo();
                    montagemarquivoitemCollectionNewMontagemarquivoitem.setCodmontagemarquivo(montagemarquivo);
                    montagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(montagemarquivoitemCollectionNewMontagemarquivoitem);
                    if (oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem != null && !oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem.equals(montagemarquivo)) {
                        oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionNewMontagemarquivoitem);
                        oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(oldCodmontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = montagemarquivo.getCodmontagemarquivo();
                if (findMontagemarquivo(id) == null) {
                    throw new NonexistentEntityException("The montagemarquivo with id " + id + " no longer exists.");
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
            Montagemarquivo montagemarquivo;
            try {
                montagemarquivo = em.getReference(Montagemarquivo.class, id);
                montagemarquivo.getCodmontagemarquivo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The montagemarquivo with id " + id + " no longer exists.", enfe);
            }
            Banco codbanco = montagemarquivo.getCodbanco();
            if (codbanco != null) {
                codbanco.getMontagemarquivoCollection().remove(montagemarquivo);
                codbanco = em.merge(codbanco);
            }
            Collection<Montagemarquivoitem> montagemarquivoitemCollection = montagemarquivo.getMontagemarquivoitemCollection();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : montagemarquivoitemCollection) {
                montagemarquivoitemCollectionMontagemarquivoitem.setCodmontagemarquivo(null);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
            }
            em.remove(montagemarquivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Montagemarquivo> findMontagemarquivoEntities() {
        return findMontagemarquivoEntities(true, -1, -1);
    }

    public List<Montagemarquivo> findMontagemarquivoEntities(int maxResults, int firstResult) {
        return findMontagemarquivoEntities(false, maxResults, firstResult);
    }

    private List<Montagemarquivo> findMontagemarquivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Montagemarquivo.class));
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

    public Montagemarquivo findMontagemarquivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Montagemarquivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getMontagemarquivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Montagemarquivo> rt = cq.from(Montagemarquivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
