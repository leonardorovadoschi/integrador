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
import entidade.cplus.Campocustomlista;
import entidade.cplus.Campocustommaster;
import java.util.ArrayList;
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
public class CampocustomlistaJpaController implements Serializable {

    public CampocustomlistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Campocustomlista campocustomlista) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Campocustomlista campocustomlista1OrphanCheck = campocustomlista.getCampocustomlista1();
        if (campocustomlista1OrphanCheck != null) {
            Campocustomlista oldCampocustomlistaOfCampocustomlista1 = campocustomlista1OrphanCheck.getCampocustomlista();
            if (oldCampocustomlistaOfCampocustomlista1 != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Campocustomlista " + campocustomlista1OrphanCheck + " already has an item of type Campocustomlista whose campocustomlista1 column cannot be null. Please make another selection for the campocustomlista1 field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campocustomlista campocustomlistaRel = campocustomlista.getCampocustomlista();
            if (campocustomlistaRel != null) {
                campocustomlistaRel = em.getReference(campocustomlistaRel.getClass(), campocustomlistaRel.getCodcampocustomlista());
                campocustomlista.setCampocustomlista(campocustomlistaRel);
            }
            Campocustomlista campocustomlista1 = campocustomlista.getCampocustomlista1();
            if (campocustomlista1 != null) {
                campocustomlista1 = em.getReference(campocustomlista1.getClass(), campocustomlista1.getCodcampocustomlista());
                campocustomlista.setCampocustomlista1(campocustomlista1);
            }
            Campocustommaster codcampocustommaster = campocustomlista.getCodcampocustommaster();
            if (codcampocustommaster != null) {
                codcampocustommaster = em.getReference(codcampocustommaster.getClass(), codcampocustommaster.getCodcampocustommaster());
                campocustomlista.setCodcampocustommaster(codcampocustommaster);
            }
            em.persist(campocustomlista);
            if (campocustomlistaRel != null) {
                Campocustomlista oldCampocustomlista1OfCampocustomlistaRel = campocustomlistaRel.getCampocustomlista1();
                if (oldCampocustomlista1OfCampocustomlistaRel != null) {
                    oldCampocustomlista1OfCampocustomlistaRel.setCampocustomlista(null);
                    oldCampocustomlista1OfCampocustomlistaRel = em.merge(oldCampocustomlista1OfCampocustomlistaRel);
                }
                campocustomlistaRel.setCampocustomlista1(campocustomlista);
                campocustomlistaRel = em.merge(campocustomlistaRel);
            }
            if (campocustomlista1 != null) {
                campocustomlista1.setCampocustomlista(campocustomlista);
                campocustomlista1 = em.merge(campocustomlista1);
            }
            if (codcampocustommaster != null) {
                codcampocustommaster.getCampocustomlistaCollection().add(campocustomlista);
                codcampocustommaster = em.merge(codcampocustommaster);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCampocustomlista(campocustomlista.getCodcampocustomlista()) != null) {
                throw new PreexistingEntityException("Campocustomlista " + campocustomlista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Campocustomlista campocustomlista) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campocustomlista persistentCampocustomlista = em.find(Campocustomlista.class, campocustomlista.getCodcampocustomlista());
            Campocustomlista campocustomlistaRelOld = persistentCampocustomlista.getCampocustomlista();
            Campocustomlista campocustomlistaRelNew = campocustomlista.getCampocustomlista();
            Campocustomlista campocustomlista1Old = persistentCampocustomlista.getCampocustomlista1();
            Campocustomlista campocustomlista1New = campocustomlista.getCampocustomlista1();
            Campocustommaster codcampocustommasterOld = persistentCampocustomlista.getCodcampocustommaster();
            Campocustommaster codcampocustommasterNew = campocustomlista.getCodcampocustommaster();
            List<String> illegalOrphanMessages = null;
            if (campocustomlistaRelOld != null && !campocustomlistaRelOld.equals(campocustomlistaRelNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Campocustomlista " + campocustomlistaRelOld + " since its campocustomlista1 field is not nullable.");
            }
            if (campocustomlista1New != null && !campocustomlista1New.equals(campocustomlista1Old)) {
                Campocustomlista oldCampocustomlistaOfCampocustomlista1 = campocustomlista1New.getCampocustomlista();
                if (oldCampocustomlistaOfCampocustomlista1 != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Campocustomlista " + campocustomlista1New + " already has an item of type Campocustomlista whose campocustomlista1 column cannot be null. Please make another selection for the campocustomlista1 field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (campocustomlistaRelNew != null) {
                campocustomlistaRelNew = em.getReference(campocustomlistaRelNew.getClass(), campocustomlistaRelNew.getCodcampocustomlista());
                campocustomlista.setCampocustomlista(campocustomlistaRelNew);
            }
            if (campocustomlista1New != null) {
                campocustomlista1New = em.getReference(campocustomlista1New.getClass(), campocustomlista1New.getCodcampocustomlista());
                campocustomlista.setCampocustomlista1(campocustomlista1New);
            }
            if (codcampocustommasterNew != null) {
                codcampocustommasterNew = em.getReference(codcampocustommasterNew.getClass(), codcampocustommasterNew.getCodcampocustommaster());
                campocustomlista.setCodcampocustommaster(codcampocustommasterNew);
            }
            campocustomlista = em.merge(campocustomlista);
            if (campocustomlistaRelNew != null && !campocustomlistaRelNew.equals(campocustomlistaRelOld)) {
                Campocustomlista oldCampocustomlista1OfCampocustomlistaRel = campocustomlistaRelNew.getCampocustomlista1();
                if (oldCampocustomlista1OfCampocustomlistaRel != null) {
                    oldCampocustomlista1OfCampocustomlistaRel.setCampocustomlista(null);
                    oldCampocustomlista1OfCampocustomlistaRel = em.merge(oldCampocustomlista1OfCampocustomlistaRel);
                }
                campocustomlistaRelNew.setCampocustomlista1(campocustomlista);
                campocustomlistaRelNew = em.merge(campocustomlistaRelNew);
            }
            if (campocustomlista1Old != null && !campocustomlista1Old.equals(campocustomlista1New)) {
                campocustomlista1Old.setCampocustomlista(null);
                campocustomlista1Old = em.merge(campocustomlista1Old);
            }
            if (campocustomlista1New != null && !campocustomlista1New.equals(campocustomlista1Old)) {
                campocustomlista1New.setCampocustomlista(campocustomlista);
                campocustomlista1New = em.merge(campocustomlista1New);
            }
            if (codcampocustommasterOld != null && !codcampocustommasterOld.equals(codcampocustommasterNew)) {
                codcampocustommasterOld.getCampocustomlistaCollection().remove(campocustomlista);
                codcampocustommasterOld = em.merge(codcampocustommasterOld);
            }
            if (codcampocustommasterNew != null && !codcampocustommasterNew.equals(codcampocustommasterOld)) {
                codcampocustommasterNew.getCampocustomlistaCollection().add(campocustomlista);
                codcampocustommasterNew = em.merge(codcampocustommasterNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = campocustomlista.getCodcampocustomlista();
                if (findCampocustomlista(id) == null) {
                    throw new NonexistentEntityException("The campocustomlista with id " + id + " no longer exists.");
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
            Campocustomlista campocustomlista;
            try {
                campocustomlista = em.getReference(Campocustomlista.class, id);
                campocustomlista.getCodcampocustomlista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The campocustomlista with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Campocustomlista campocustomlistaOrphanCheck = campocustomlista.getCampocustomlista();
            if (campocustomlistaOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Campocustomlista (" + campocustomlista + ") cannot be destroyed since the Campocustomlista " + campocustomlistaOrphanCheck + " in its campocustomlista field has a non-nullable campocustomlista1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Campocustomlista campocustomlista1 = campocustomlista.getCampocustomlista1();
            if (campocustomlista1 != null) {
                campocustomlista1.setCampocustomlista(null);
                campocustomlista1 = em.merge(campocustomlista1);
            }
            Campocustommaster codcampocustommaster = campocustomlista.getCodcampocustommaster();
            if (codcampocustommaster != null) {
                codcampocustommaster.getCampocustomlistaCollection().remove(campocustomlista);
                codcampocustommaster = em.merge(codcampocustommaster);
            }
            em.remove(campocustomlista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Campocustomlista> findCampocustomlistaEntities() {
        return findCampocustomlistaEntities(true, -1, -1);
    }

    public List<Campocustomlista> findCampocustomlistaEntities(int maxResults, int firstResult) {
        return findCampocustomlistaEntities(false, maxResults, firstResult);
    }

    private List<Campocustomlista> findCampocustomlistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Campocustomlista.class));
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

    public Campocustomlista findCampocustomlista(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Campocustomlista.class, id);
        } finally {
            em.close();
        }
    }

    public int getCampocustomlistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Campocustomlista> rt = cq.from(Campocustomlista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
