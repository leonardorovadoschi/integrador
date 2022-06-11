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
import entidade.cplus.Contapagar;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Usuario;
import entidade.cplus.Contareceber;
import entidade.cplus.Situacaoadministrativa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class SituacaoadministrativaJpaController implements Serializable {

    public SituacaoadministrativaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Situacaoadministrativa situacaoadministrativa) throws PreexistingEntityException, Exception {
        if (situacaoadministrativa.getContapagarCollection() == null) {
            situacaoadministrativa.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (situacaoadministrativa.getUsuarioCollection() == null) {
            situacaoadministrativa.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (situacaoadministrativa.getContareceberCollection() == null) {
            situacaoadministrativa.setContareceberCollection(new ArrayList<Contareceber>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : situacaoadministrativa.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            situacaoadministrativa.setContapagarCollection(attachedContapagarCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : situacaoadministrativa.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getCoduser());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            situacaoadministrativa.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : situacaoadministrativa.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            situacaoadministrativa.setContareceberCollection(attachedContareceberCollection);
            em.persist(situacaoadministrativa);
            for (Contapagar contapagarCollectionContapagar : situacaoadministrativa.getContapagarCollection()) {
                Situacaoadministrativa oldCodsituacaoadministrativaOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodsituacaoadministrativa();
                contapagarCollectionContapagar.setCodsituacaoadministrativa(situacaoadministrativa);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodsituacaoadministrativaOfContapagarCollectionContapagar != null) {
                    oldCodsituacaoadministrativaOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodsituacaoadministrativaOfContapagarCollectionContapagar = em.merge(oldCodsituacaoadministrativaOfContapagarCollectionContapagar);
                }
            }
            for (Usuario usuarioCollectionUsuario : situacaoadministrativa.getUsuarioCollection()) {
                Situacaoadministrativa oldCodsituacaoadministrativaOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getCodsituacaoadministrativa();
                usuarioCollectionUsuario.setCodsituacaoadministrativa(situacaoadministrativa);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldCodsituacaoadministrativaOfUsuarioCollectionUsuario != null) {
                    oldCodsituacaoadministrativaOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldCodsituacaoadministrativaOfUsuarioCollectionUsuario = em.merge(oldCodsituacaoadministrativaOfUsuarioCollectionUsuario);
                }
            }
            for (Contareceber contareceberCollectionContareceber : situacaoadministrativa.getContareceberCollection()) {
                Situacaoadministrativa oldCodsituacaoadministrativaOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodsituacaoadministrativa();
                contareceberCollectionContareceber.setCodsituacaoadministrativa(situacaoadministrativa);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodsituacaoadministrativaOfContareceberCollectionContareceber != null) {
                    oldCodsituacaoadministrativaOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodsituacaoadministrativaOfContareceberCollectionContareceber = em.merge(oldCodsituacaoadministrativaOfContareceberCollectionContareceber);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSituacaoadministrativa(situacaoadministrativa.getCodsituacaoadministrativa()) != null) {
                throw new PreexistingEntityException("Situacaoadministrativa " + situacaoadministrativa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Situacaoadministrativa situacaoadministrativa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Situacaoadministrativa persistentSituacaoadministrativa = em.find(Situacaoadministrativa.class, situacaoadministrativa.getCodsituacaoadministrativa());
            Collection<Contapagar> contapagarCollectionOld = persistentSituacaoadministrativa.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = situacaoadministrativa.getContapagarCollection();
            Collection<Usuario> usuarioCollectionOld = persistentSituacaoadministrativa.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = situacaoadministrativa.getUsuarioCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentSituacaoadministrativa.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = situacaoadministrativa.getContareceberCollection();
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            situacaoadministrativa.setContapagarCollection(contapagarCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getCoduser());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            situacaoadministrativa.setUsuarioCollection(usuarioCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            situacaoadministrativa.setContareceberCollection(contareceberCollectionNew);
            situacaoadministrativa = em.merge(situacaoadministrativa);
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodsituacaoadministrativa(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Situacaoadministrativa oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodsituacaoadministrativa();
                    contapagarCollectionNewContapagar.setCodsituacaoadministrativa(situacaoadministrativa);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar != null && !oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar.equals(situacaoadministrativa)) {
                        oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar = em.merge(oldCodsituacaoadministrativaOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setCodsituacaoadministrativa(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Situacaoadministrativa oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getCodsituacaoadministrativa();
                    usuarioCollectionNewUsuario.setCodsituacaoadministrativa(situacaoadministrativa);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario != null && !oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario.equals(situacaoadministrativa)) {
                        oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario = em.merge(oldCodsituacaoadministrativaOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodsituacaoadministrativa(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Situacaoadministrativa oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodsituacaoadministrativa();
                    contareceberCollectionNewContareceber.setCodsituacaoadministrativa(situacaoadministrativa);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber != null && !oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber.equals(situacaoadministrativa)) {
                        oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber = em.merge(oldCodsituacaoadministrativaOfContareceberCollectionNewContareceber);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = situacaoadministrativa.getCodsituacaoadministrativa();
                if (findSituacaoadministrativa(id) == null) {
                    throw new NonexistentEntityException("The situacaoadministrativa with id " + id + " no longer exists.");
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
            Situacaoadministrativa situacaoadministrativa;
            try {
                situacaoadministrativa = em.getReference(Situacaoadministrativa.class, id);
                situacaoadministrativa.getCodsituacaoadministrativa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The situacaoadministrativa with id " + id + " no longer exists.", enfe);
            }
            Collection<Contapagar> contapagarCollection = situacaoadministrativa.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodsituacaoadministrativa(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Usuario> usuarioCollection = situacaoadministrativa.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setCodsituacaoadministrativa(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            Collection<Contareceber> contareceberCollection = situacaoadministrativa.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodsituacaoadministrativa(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            em.remove(situacaoadministrativa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Situacaoadministrativa> findSituacaoadministrativaEntities() {
        return findSituacaoadministrativaEntities(true, -1, -1);
    }

    public List<Situacaoadministrativa> findSituacaoadministrativaEntities(int maxResults, int firstResult) {
        return findSituacaoadministrativaEntities(false, maxResults, firstResult);
    }

    private List<Situacaoadministrativa> findSituacaoadministrativaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Situacaoadministrativa.class));
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

    public Situacaoadministrativa findSituacaoadministrativa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Situacaoadministrativa.class, id);
        } finally {
            em.close();
        }
    }

    public int getSituacaoadministrativaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Situacaoadministrativa> rt = cq.from(Situacaoadministrativa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
