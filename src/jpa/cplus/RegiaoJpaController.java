/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Regiao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Regiaocidade;
import java.util.ArrayList;
import java.util.Collection;
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
public class RegiaoJpaController implements Serializable {

    public RegiaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Regiao regiao) throws PreexistingEntityException, Exception {
        if (regiao.getRegiaocidadeCollection() == null) {
            regiao.setRegiaocidadeCollection(new ArrayList<Regiaocidade>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Regiaocidade> attachedRegiaocidadeCollection = new ArrayList<Regiaocidade>();
            for (Regiaocidade regiaocidadeCollectionRegiaocidadeToAttach : regiao.getRegiaocidadeCollection()) {
                regiaocidadeCollectionRegiaocidadeToAttach = em.getReference(regiaocidadeCollectionRegiaocidadeToAttach.getClass(), regiaocidadeCollectionRegiaocidadeToAttach.getCodregiaocidade());
                attachedRegiaocidadeCollection.add(regiaocidadeCollectionRegiaocidadeToAttach);
            }
            regiao.setRegiaocidadeCollection(attachedRegiaocidadeCollection);
            em.persist(regiao);
            for (Regiaocidade regiaocidadeCollectionRegiaocidade : regiao.getRegiaocidadeCollection()) {
                Regiao oldCodregiaoOfRegiaocidadeCollectionRegiaocidade = regiaocidadeCollectionRegiaocidade.getCodregiao();
                regiaocidadeCollectionRegiaocidade.setCodregiao(regiao);
                regiaocidadeCollectionRegiaocidade = em.merge(regiaocidadeCollectionRegiaocidade);
                if (oldCodregiaoOfRegiaocidadeCollectionRegiaocidade != null) {
                    oldCodregiaoOfRegiaocidadeCollectionRegiaocidade.getRegiaocidadeCollection().remove(regiaocidadeCollectionRegiaocidade);
                    oldCodregiaoOfRegiaocidadeCollectionRegiaocidade = em.merge(oldCodregiaoOfRegiaocidadeCollectionRegiaocidade);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegiao(regiao.getCodregiao()) != null) {
                throw new PreexistingEntityException("Regiao " + regiao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Regiao regiao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Regiao persistentRegiao = em.find(Regiao.class, regiao.getCodregiao());
            Collection<Regiaocidade> regiaocidadeCollectionOld = persistentRegiao.getRegiaocidadeCollection();
            Collection<Regiaocidade> regiaocidadeCollectionNew = regiao.getRegiaocidadeCollection();
            List<String> illegalOrphanMessages = null;
            for (Regiaocidade regiaocidadeCollectionOldRegiaocidade : regiaocidadeCollectionOld) {
                if (!regiaocidadeCollectionNew.contains(regiaocidadeCollectionOldRegiaocidade)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Regiaocidade " + regiaocidadeCollectionOldRegiaocidade + " since its codregiao field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Regiaocidade> attachedRegiaocidadeCollectionNew = new ArrayList<Regiaocidade>();
            for (Regiaocidade regiaocidadeCollectionNewRegiaocidadeToAttach : regiaocidadeCollectionNew) {
                regiaocidadeCollectionNewRegiaocidadeToAttach = em.getReference(regiaocidadeCollectionNewRegiaocidadeToAttach.getClass(), regiaocidadeCollectionNewRegiaocidadeToAttach.getCodregiaocidade());
                attachedRegiaocidadeCollectionNew.add(regiaocidadeCollectionNewRegiaocidadeToAttach);
            }
            regiaocidadeCollectionNew = attachedRegiaocidadeCollectionNew;
            regiao.setRegiaocidadeCollection(regiaocidadeCollectionNew);
            regiao = em.merge(regiao);
            for (Regiaocidade regiaocidadeCollectionNewRegiaocidade : regiaocidadeCollectionNew) {
                if (!regiaocidadeCollectionOld.contains(regiaocidadeCollectionNewRegiaocidade)) {
                    Regiao oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade = regiaocidadeCollectionNewRegiaocidade.getCodregiao();
                    regiaocidadeCollectionNewRegiaocidade.setCodregiao(regiao);
                    regiaocidadeCollectionNewRegiaocidade = em.merge(regiaocidadeCollectionNewRegiaocidade);
                    if (oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade != null && !oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade.equals(regiao)) {
                        oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade.getRegiaocidadeCollection().remove(regiaocidadeCollectionNewRegiaocidade);
                        oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade = em.merge(oldCodregiaoOfRegiaocidadeCollectionNewRegiaocidade);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = regiao.getCodregiao();
                if (findRegiao(id) == null) {
                    throw new NonexistentEntityException("The regiao with id " + id + " no longer exists.");
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
            Regiao regiao;
            try {
                regiao = em.getReference(Regiao.class, id);
                regiao.getCodregiao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The regiao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Regiaocidade> regiaocidadeCollectionOrphanCheck = regiao.getRegiaocidadeCollection();
            for (Regiaocidade regiaocidadeCollectionOrphanCheckRegiaocidade : regiaocidadeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Regiao (" + regiao + ") cannot be destroyed since the Regiaocidade " + regiaocidadeCollectionOrphanCheckRegiaocidade + " in its regiaocidadeCollection field has a non-nullable codregiao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(regiao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Regiao> findRegiaoEntities() {
        return findRegiaoEntities(true, -1, -1);
    }

    public List<Regiao> findRegiaoEntities(int maxResults, int firstResult) {
        return findRegiaoEntities(false, maxResults, firstResult);
    }

    private List<Regiao> findRegiaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Regiao.class));
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

    public Regiao findRegiao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Regiao.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegiaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Regiao> rt = cq.from(Regiao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
