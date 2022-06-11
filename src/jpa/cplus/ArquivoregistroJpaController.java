/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Arquivoregistro;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Arquivovariavel;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Montagemarquivoitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ArquivoregistroJpaController implements Serializable {

    public ArquivoregistroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Arquivoregistro arquivoregistro) throws PreexistingEntityException, Exception {
        if (arquivoregistro.getArquivovariavelCollection() == null) {
            arquivoregistro.setArquivovariavelCollection(new ArrayList<Arquivovariavel>());
        }
        if (arquivoregistro.getMontagemarquivoitemCollection() == null) {
            arquivoregistro.setMontagemarquivoitemCollection(new ArrayList<Montagemarquivoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Arquivovariavel> attachedArquivovariavelCollection = new ArrayList<Arquivovariavel>();
            for (Arquivovariavel arquivovariavelCollectionArquivovariavelToAttach : arquivoregistro.getArquivovariavelCollection()) {
                arquivovariavelCollectionArquivovariavelToAttach = em.getReference(arquivovariavelCollectionArquivovariavelToAttach.getClass(), arquivovariavelCollectionArquivovariavelToAttach.getCodarquivovariavel());
                attachedArquivovariavelCollection.add(arquivovariavelCollectionArquivovariavelToAttach);
            }
            arquivoregistro.setArquivovariavelCollection(attachedArquivovariavelCollection);
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollection = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitemToAttach : arquivoregistro.getMontagemarquivoitemCollection()) {
                montagemarquivoitemCollectionMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollection.add(montagemarquivoitemCollectionMontagemarquivoitemToAttach);
            }
            arquivoregistro.setMontagemarquivoitemCollection(attachedMontagemarquivoitemCollection);
            em.persist(arquivoregistro);
            for (Arquivovariavel arquivovariavelCollectionArquivovariavel : arquivoregistro.getArquivovariavelCollection()) {
                Arquivoregistro oldCodarquivoregistroOfArquivovariavelCollectionArquivovariavel = arquivovariavelCollectionArquivovariavel.getCodarquivoregistro();
                arquivovariavelCollectionArquivovariavel.setCodarquivoregistro(arquivoregistro);
                arquivovariavelCollectionArquivovariavel = em.merge(arquivovariavelCollectionArquivovariavel);
                if (oldCodarquivoregistroOfArquivovariavelCollectionArquivovariavel != null) {
                    oldCodarquivoregistroOfArquivovariavelCollectionArquivovariavel.getArquivovariavelCollection().remove(arquivovariavelCollectionArquivovariavel);
                    oldCodarquivoregistroOfArquivovariavelCollectionArquivovariavel = em.merge(oldCodarquivoregistroOfArquivovariavelCollectionArquivovariavel);
                }
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : arquivoregistro.getMontagemarquivoitemCollection()) {
                Arquivoregistro oldCodarquivoregistroOfMontagemarquivoitemCollectionMontagemarquivoitem = montagemarquivoitemCollectionMontagemarquivoitem.getCodarquivoregistro();
                montagemarquivoitemCollectionMontagemarquivoitem.setCodarquivoregistro(arquivoregistro);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
                if (oldCodarquivoregistroOfMontagemarquivoitemCollectionMontagemarquivoitem != null) {
                    oldCodarquivoregistroOfMontagemarquivoitemCollectionMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionMontagemarquivoitem);
                    oldCodarquivoregistroOfMontagemarquivoitemCollectionMontagemarquivoitem = em.merge(oldCodarquivoregistroOfMontagemarquivoitemCollectionMontagemarquivoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArquivoregistro(arquivoregistro.getCodarquivoregistro()) != null) {
                throw new PreexistingEntityException("Arquivoregistro " + arquivoregistro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Arquivoregistro arquivoregistro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arquivoregistro persistentArquivoregistro = em.find(Arquivoregistro.class, arquivoregistro.getCodarquivoregistro());
            Collection<Arquivovariavel> arquivovariavelCollectionOld = persistentArquivoregistro.getArquivovariavelCollection();
            Collection<Arquivovariavel> arquivovariavelCollectionNew = arquivoregistro.getArquivovariavelCollection();
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionOld = persistentArquivoregistro.getMontagemarquivoitemCollection();
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionNew = arquivoregistro.getMontagemarquivoitemCollection();
            List<String> illegalOrphanMessages = null;
            for (Arquivovariavel arquivovariavelCollectionOldArquivovariavel : arquivovariavelCollectionOld) {
                if (!arquivovariavelCollectionNew.contains(arquivovariavelCollectionOldArquivovariavel)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Arquivovariavel " + arquivovariavelCollectionOldArquivovariavel + " since its codarquivoregistro field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Arquivovariavel> attachedArquivovariavelCollectionNew = new ArrayList<Arquivovariavel>();
            for (Arquivovariavel arquivovariavelCollectionNewArquivovariavelToAttach : arquivovariavelCollectionNew) {
                arquivovariavelCollectionNewArquivovariavelToAttach = em.getReference(arquivovariavelCollectionNewArquivovariavelToAttach.getClass(), arquivovariavelCollectionNewArquivovariavelToAttach.getCodarquivovariavel());
                attachedArquivovariavelCollectionNew.add(arquivovariavelCollectionNewArquivovariavelToAttach);
            }
            arquivovariavelCollectionNew = attachedArquivovariavelCollectionNew;
            arquivoregistro.setArquivovariavelCollection(arquivovariavelCollectionNew);
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollectionNew = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitemToAttach : montagemarquivoitemCollectionNew) {
                montagemarquivoitemCollectionNewMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollectionNew.add(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach);
            }
            montagemarquivoitemCollectionNew = attachedMontagemarquivoitemCollectionNew;
            arquivoregistro.setMontagemarquivoitemCollection(montagemarquivoitemCollectionNew);
            arquivoregistro = em.merge(arquivoregistro);
            for (Arquivovariavel arquivovariavelCollectionNewArquivovariavel : arquivovariavelCollectionNew) {
                if (!arquivovariavelCollectionOld.contains(arquivovariavelCollectionNewArquivovariavel)) {
                    Arquivoregistro oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel = arquivovariavelCollectionNewArquivovariavel.getCodarquivoregistro();
                    arquivovariavelCollectionNewArquivovariavel.setCodarquivoregistro(arquivoregistro);
                    arquivovariavelCollectionNewArquivovariavel = em.merge(arquivovariavelCollectionNewArquivovariavel);
                    if (oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel != null && !oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel.equals(arquivoregistro)) {
                        oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel.getArquivovariavelCollection().remove(arquivovariavelCollectionNewArquivovariavel);
                        oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel = em.merge(oldCodarquivoregistroOfArquivovariavelCollectionNewArquivovariavel);
                    }
                }
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionOldMontagemarquivoitem : montagemarquivoitemCollectionOld) {
                if (!montagemarquivoitemCollectionNew.contains(montagemarquivoitemCollectionOldMontagemarquivoitem)) {
                    montagemarquivoitemCollectionOldMontagemarquivoitem.setCodarquivoregistro(null);
                    montagemarquivoitemCollectionOldMontagemarquivoitem = em.merge(montagemarquivoitemCollectionOldMontagemarquivoitem);
                }
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitem : montagemarquivoitemCollectionNew) {
                if (!montagemarquivoitemCollectionOld.contains(montagemarquivoitemCollectionNewMontagemarquivoitem)) {
                    Arquivoregistro oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem = montagemarquivoitemCollectionNewMontagemarquivoitem.getCodarquivoregistro();
                    montagemarquivoitemCollectionNewMontagemarquivoitem.setCodarquivoregistro(arquivoregistro);
                    montagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(montagemarquivoitemCollectionNewMontagemarquivoitem);
                    if (oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem != null && !oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem.equals(arquivoregistro)) {
                        oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionNewMontagemarquivoitem);
                        oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(oldCodarquivoregistroOfMontagemarquivoitemCollectionNewMontagemarquivoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = arquivoregistro.getCodarquivoregistro();
                if (findArquivoregistro(id) == null) {
                    throw new NonexistentEntityException("The arquivoregistro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arquivoregistro arquivoregistro;
            try {
                arquivoregistro = em.getReference(Arquivoregistro.class, id);
                arquivoregistro.getCodarquivoregistro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arquivoregistro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Arquivovariavel> arquivovariavelCollectionOrphanCheck = arquivoregistro.getArquivovariavelCollection();
            for (Arquivovariavel arquivovariavelCollectionOrphanCheckArquivovariavel : arquivovariavelCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Arquivoregistro (" + arquivoregistro + ") cannot be destroyed since the Arquivovariavel " + arquivovariavelCollectionOrphanCheckArquivovariavel + " in its arquivovariavelCollection field has a non-nullable codarquivoregistro field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Montagemarquivoitem> montagemarquivoitemCollection = arquivoregistro.getMontagemarquivoitemCollection();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : montagemarquivoitemCollection) {
                montagemarquivoitemCollectionMontagemarquivoitem.setCodarquivoregistro(null);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
            }
            em.remove(arquivoregistro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Arquivoregistro> findArquivoregistroEntities() {
        return findArquivoregistroEntities(true, -1, -1);
    }

    public List<Arquivoregistro> findArquivoregistroEntities(int maxResults, int firstResult) {
        return findArquivoregistroEntities(false, maxResults, firstResult);
    }

    private List<Arquivoregistro> findArquivoregistroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Arquivoregistro.class));
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

    public Arquivoregistro findArquivoregistro(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Arquivoregistro.class, id);
        } finally {
            em.close();
        }
    }

    public int getArquivoregistroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Arquivoregistro> rt = cq.from(Arquivoregistro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
