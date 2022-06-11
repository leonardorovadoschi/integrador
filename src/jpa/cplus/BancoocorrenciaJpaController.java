/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Bancoocorrencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Contareceberrec;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Bancoocorrenciamotivo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class BancoocorrenciaJpaController implements Serializable {

    public BancoocorrenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bancoocorrencia bancoocorrencia) throws PreexistingEntityException, Exception {
        if (bancoocorrencia.getContareceberrecCollection() == null) {
            bancoocorrencia.setContareceberrecCollection(new ArrayList<Contareceberrec>());
        }
        if (bancoocorrencia.getBancoocorrenciamotivoCollection() == null) {
            bancoocorrencia.setBancoocorrenciamotivoCollection(new ArrayList<Bancoocorrenciamotivo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Contareceberrec> attachedContareceberrecCollection = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionContareceberrecToAttach : bancoocorrencia.getContareceberrecCollection()) {
                contareceberrecCollectionContareceberrecToAttach = em.getReference(contareceberrecCollectionContareceberrecToAttach.getClass(), contareceberrecCollectionContareceberrecToAttach.getId());
                attachedContareceberrecCollection.add(contareceberrecCollectionContareceberrecToAttach);
            }
            bancoocorrencia.setContareceberrecCollection(attachedContareceberrecCollection);
            Collection<Bancoocorrenciamotivo> attachedBancoocorrenciamotivoCollection = new ArrayList<Bancoocorrenciamotivo>();
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionBancoocorrenciamotivoToAttach : bancoocorrencia.getBancoocorrenciamotivoCollection()) {
                bancoocorrenciamotivoCollectionBancoocorrenciamotivoToAttach = em.getReference(bancoocorrenciamotivoCollectionBancoocorrenciamotivoToAttach.getClass(), bancoocorrenciamotivoCollectionBancoocorrenciamotivoToAttach.getCodbancoocorrenciamotivo());
                attachedBancoocorrenciamotivoCollection.add(bancoocorrenciamotivoCollectionBancoocorrenciamotivoToAttach);
            }
            bancoocorrencia.setBancoocorrenciamotivoCollection(attachedBancoocorrenciamotivoCollection);
            em.persist(bancoocorrencia);
            for (Contareceberrec contareceberrecCollectionContareceberrec : bancoocorrencia.getContareceberrecCollection()) {
                Bancoocorrencia oldCodbancoocorrenciaOfContareceberrecCollectionContareceberrec = contareceberrecCollectionContareceberrec.getCodbancoocorrencia();
                contareceberrecCollectionContareceberrec.setCodbancoocorrencia(bancoocorrencia);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
                if (oldCodbancoocorrenciaOfContareceberrecCollectionContareceberrec != null) {
                    oldCodbancoocorrenciaOfContareceberrecCollectionContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionContareceberrec);
                    oldCodbancoocorrenciaOfContareceberrecCollectionContareceberrec = em.merge(oldCodbancoocorrenciaOfContareceberrecCollectionContareceberrec);
                }
            }
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionBancoocorrenciamotivo : bancoocorrencia.getBancoocorrenciamotivoCollection()) {
                Bancoocorrencia oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionBancoocorrenciamotivo = bancoocorrenciamotivoCollectionBancoocorrenciamotivo.getCodbancoocorrencia();
                bancoocorrenciamotivoCollectionBancoocorrenciamotivo.setCodbancoocorrencia(bancoocorrencia);
                bancoocorrenciamotivoCollectionBancoocorrenciamotivo = em.merge(bancoocorrenciamotivoCollectionBancoocorrenciamotivo);
                if (oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionBancoocorrenciamotivo != null) {
                    oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionBancoocorrenciamotivo.getBancoocorrenciamotivoCollection().remove(bancoocorrenciamotivoCollectionBancoocorrenciamotivo);
                    oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionBancoocorrenciamotivo = em.merge(oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionBancoocorrenciamotivo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBancoocorrencia(bancoocorrencia.getCodbancoocorrencia()) != null) {
                throw new PreexistingEntityException("Bancoocorrencia " + bancoocorrencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bancoocorrencia bancoocorrencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancoocorrencia persistentBancoocorrencia = em.find(Bancoocorrencia.class, bancoocorrencia.getCodbancoocorrencia());
            Collection<Contareceberrec> contareceberrecCollectionOld = persistentBancoocorrencia.getContareceberrecCollection();
            Collection<Contareceberrec> contareceberrecCollectionNew = bancoocorrencia.getContareceberrecCollection();
            Collection<Bancoocorrenciamotivo> bancoocorrenciamotivoCollectionOld = persistentBancoocorrencia.getBancoocorrenciamotivoCollection();
            Collection<Bancoocorrenciamotivo> bancoocorrenciamotivoCollectionNew = bancoocorrencia.getBancoocorrenciamotivoCollection();
            Collection<Contareceberrec> attachedContareceberrecCollectionNew = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionNewContareceberrecToAttach : contareceberrecCollectionNew) {
                contareceberrecCollectionNewContareceberrecToAttach = em.getReference(contareceberrecCollectionNewContareceberrecToAttach.getClass(), contareceberrecCollectionNewContareceberrecToAttach.getId());
                attachedContareceberrecCollectionNew.add(contareceberrecCollectionNewContareceberrecToAttach);
            }
            contareceberrecCollectionNew = attachedContareceberrecCollectionNew;
            bancoocorrencia.setContareceberrecCollection(contareceberrecCollectionNew);
            Collection<Bancoocorrenciamotivo> attachedBancoocorrenciamotivoCollectionNew = new ArrayList<Bancoocorrenciamotivo>();
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionNewBancoocorrenciamotivoToAttach : bancoocorrenciamotivoCollectionNew) {
                bancoocorrenciamotivoCollectionNewBancoocorrenciamotivoToAttach = em.getReference(bancoocorrenciamotivoCollectionNewBancoocorrenciamotivoToAttach.getClass(), bancoocorrenciamotivoCollectionNewBancoocorrenciamotivoToAttach.getCodbancoocorrenciamotivo());
                attachedBancoocorrenciamotivoCollectionNew.add(bancoocorrenciamotivoCollectionNewBancoocorrenciamotivoToAttach);
            }
            bancoocorrenciamotivoCollectionNew = attachedBancoocorrenciamotivoCollectionNew;
            bancoocorrencia.setBancoocorrenciamotivoCollection(bancoocorrenciamotivoCollectionNew);
            bancoocorrencia = em.merge(bancoocorrencia);
            for (Contareceberrec contareceberrecCollectionOldContareceberrec : contareceberrecCollectionOld) {
                if (!contareceberrecCollectionNew.contains(contareceberrecCollectionOldContareceberrec)) {
                    contareceberrecCollectionOldContareceberrec.setCodbancoocorrencia(null);
                    contareceberrecCollectionOldContareceberrec = em.merge(contareceberrecCollectionOldContareceberrec);
                }
            }
            for (Contareceberrec contareceberrecCollectionNewContareceberrec : contareceberrecCollectionNew) {
                if (!contareceberrecCollectionOld.contains(contareceberrecCollectionNewContareceberrec)) {
                    Bancoocorrencia oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec = contareceberrecCollectionNewContareceberrec.getCodbancoocorrencia();
                    contareceberrecCollectionNewContareceberrec.setCodbancoocorrencia(bancoocorrencia);
                    contareceberrecCollectionNewContareceberrec = em.merge(contareceberrecCollectionNewContareceberrec);
                    if (oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec != null && !oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec.equals(bancoocorrencia)) {
                        oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionNewContareceberrec);
                        oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec = em.merge(oldCodbancoocorrenciaOfContareceberrecCollectionNewContareceberrec);
                    }
                }
            }
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionOldBancoocorrenciamotivo : bancoocorrenciamotivoCollectionOld) {
                if (!bancoocorrenciamotivoCollectionNew.contains(bancoocorrenciamotivoCollectionOldBancoocorrenciamotivo)) {
                    bancoocorrenciamotivoCollectionOldBancoocorrenciamotivo.setCodbancoocorrencia(null);
                    bancoocorrenciamotivoCollectionOldBancoocorrenciamotivo = em.merge(bancoocorrenciamotivoCollectionOldBancoocorrenciamotivo);
                }
            }
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo : bancoocorrenciamotivoCollectionNew) {
                if (!bancoocorrenciamotivoCollectionOld.contains(bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo)) {
                    Bancoocorrencia oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo = bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo.getCodbancoocorrencia();
                    bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo.setCodbancoocorrencia(bancoocorrencia);
                    bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo = em.merge(bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo);
                    if (oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo != null && !oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo.equals(bancoocorrencia)) {
                        oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo.getBancoocorrenciamotivoCollection().remove(bancoocorrenciamotivoCollectionNewBancoocorrenciamotivo);
                        oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo = em.merge(oldCodbancoocorrenciaOfBancoocorrenciamotivoCollectionNewBancoocorrenciamotivo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bancoocorrencia.getCodbancoocorrencia();
                if (findBancoocorrencia(id) == null) {
                    throw new NonexistentEntityException("The bancoocorrencia with id " + id + " no longer exists.");
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
            Bancoocorrencia bancoocorrencia;
            try {
                bancoocorrencia = em.getReference(Bancoocorrencia.class, id);
                bancoocorrencia.getCodbancoocorrencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bancoocorrencia with id " + id + " no longer exists.", enfe);
            }
            Collection<Contareceberrec> contareceberrecCollection = bancoocorrencia.getContareceberrecCollection();
            for (Contareceberrec contareceberrecCollectionContareceberrec : contareceberrecCollection) {
                contareceberrecCollectionContareceberrec.setCodbancoocorrencia(null);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
            }
            Collection<Bancoocorrenciamotivo> bancoocorrenciamotivoCollection = bancoocorrencia.getBancoocorrenciamotivoCollection();
            for (Bancoocorrenciamotivo bancoocorrenciamotivoCollectionBancoocorrenciamotivo : bancoocorrenciamotivoCollection) {
                bancoocorrenciamotivoCollectionBancoocorrenciamotivo.setCodbancoocorrencia(null);
                bancoocorrenciamotivoCollectionBancoocorrenciamotivo = em.merge(bancoocorrenciamotivoCollectionBancoocorrenciamotivo);
            }
            em.remove(bancoocorrencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bancoocorrencia> findBancoocorrenciaEntities() {
        return findBancoocorrenciaEntities(true, -1, -1);
    }

    public List<Bancoocorrencia> findBancoocorrenciaEntities(int maxResults, int firstResult) {
        return findBancoocorrenciaEntities(false, maxResults, firstResult);
    }

    private List<Bancoocorrencia> findBancoocorrenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bancoocorrencia.class));
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

    public Bancoocorrencia findBancoocorrencia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bancoocorrencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getBancoocorrenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bancoocorrencia> rt = cq.from(Bancoocorrencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
