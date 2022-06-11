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
import entidade.cplus.OsPesquisaresposta;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsPesquisa;
import entidade.cplus.OsPesquisapergunta;
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
public class OsPesquisaperguntaJpaController implements Serializable {

    public OsPesquisaperguntaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsPesquisapergunta osPesquisapergunta) throws PreexistingEntityException, Exception {
        if (osPesquisapergunta.getOsPesquisarespostaCollection() == null) {
            osPesquisapergunta.setOsPesquisarespostaCollection(new ArrayList<OsPesquisaresposta>());
        }
        if (osPesquisapergunta.getOsPesquisaCollection() == null) {
            osPesquisapergunta.setOsPesquisaCollection(new ArrayList<OsPesquisa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<OsPesquisaresposta> attachedOsPesquisarespostaCollection = new ArrayList<OsPesquisaresposta>();
            for (OsPesquisaresposta osPesquisarespostaCollectionOsPesquisarespostaToAttach : osPesquisapergunta.getOsPesquisarespostaCollection()) {
                osPesquisarespostaCollectionOsPesquisarespostaToAttach = em.getReference(osPesquisarespostaCollectionOsPesquisarespostaToAttach.getClass(), osPesquisarespostaCollectionOsPesquisarespostaToAttach.getCodpesquisaresposta());
                attachedOsPesquisarespostaCollection.add(osPesquisarespostaCollectionOsPesquisarespostaToAttach);
            }
            osPesquisapergunta.setOsPesquisarespostaCollection(attachedOsPesquisarespostaCollection);
            Collection<OsPesquisa> attachedOsPesquisaCollection = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionOsPesquisaToAttach : osPesquisapergunta.getOsPesquisaCollection()) {
                osPesquisaCollectionOsPesquisaToAttach = em.getReference(osPesquisaCollectionOsPesquisaToAttach.getClass(), osPesquisaCollectionOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollection.add(osPesquisaCollectionOsPesquisaToAttach);
            }
            osPesquisapergunta.setOsPesquisaCollection(attachedOsPesquisaCollection);
            em.persist(osPesquisapergunta);
            for (OsPesquisaresposta osPesquisarespostaCollectionOsPesquisaresposta : osPesquisapergunta.getOsPesquisarespostaCollection()) {
                OsPesquisapergunta oldCodpesquisaperguntaOfOsPesquisarespostaCollectionOsPesquisaresposta = osPesquisarespostaCollectionOsPesquisaresposta.getCodpesquisapergunta();
                osPesquisarespostaCollectionOsPesquisaresposta.setCodpesquisapergunta(osPesquisapergunta);
                osPesquisarespostaCollectionOsPesquisaresposta = em.merge(osPesquisarespostaCollectionOsPesquisaresposta);
                if (oldCodpesquisaperguntaOfOsPesquisarespostaCollectionOsPesquisaresposta != null) {
                    oldCodpesquisaperguntaOfOsPesquisarespostaCollectionOsPesquisaresposta.getOsPesquisarespostaCollection().remove(osPesquisarespostaCollectionOsPesquisaresposta);
                    oldCodpesquisaperguntaOfOsPesquisarespostaCollectionOsPesquisaresposta = em.merge(oldCodpesquisaperguntaOfOsPesquisarespostaCollectionOsPesquisaresposta);
                }
            }
            for (OsPesquisa osPesquisaCollectionOsPesquisa : osPesquisapergunta.getOsPesquisaCollection()) {
                OsPesquisapergunta oldCodpesquisaperguntaOfOsPesquisaCollectionOsPesquisa = osPesquisaCollectionOsPesquisa.getCodpesquisapergunta();
                osPesquisaCollectionOsPesquisa.setCodpesquisapergunta(osPesquisapergunta);
                osPesquisaCollectionOsPesquisa = em.merge(osPesquisaCollectionOsPesquisa);
                if (oldCodpesquisaperguntaOfOsPesquisaCollectionOsPesquisa != null) {
                    oldCodpesquisaperguntaOfOsPesquisaCollectionOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionOsPesquisa);
                    oldCodpesquisaperguntaOfOsPesquisaCollectionOsPesquisa = em.merge(oldCodpesquisaperguntaOfOsPesquisaCollectionOsPesquisa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsPesquisapergunta(osPesquisapergunta.getCodpesquisapergunta()) != null) {
                throw new PreexistingEntityException("OsPesquisapergunta " + osPesquisapergunta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsPesquisapergunta osPesquisapergunta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsPesquisapergunta persistentOsPesquisapergunta = em.find(OsPesquisapergunta.class, osPesquisapergunta.getCodpesquisapergunta());
            Collection<OsPesquisaresposta> osPesquisarespostaCollectionOld = persistentOsPesquisapergunta.getOsPesquisarespostaCollection();
            Collection<OsPesquisaresposta> osPesquisarespostaCollectionNew = osPesquisapergunta.getOsPesquisarespostaCollection();
            Collection<OsPesquisa> osPesquisaCollectionOld = persistentOsPesquisapergunta.getOsPesquisaCollection();
            Collection<OsPesquisa> osPesquisaCollectionNew = osPesquisapergunta.getOsPesquisaCollection();
            List<String> illegalOrphanMessages = null;
            for (OsPesquisa osPesquisaCollectionOldOsPesquisa : osPesquisaCollectionOld) {
                if (!osPesquisaCollectionNew.contains(osPesquisaCollectionOldOsPesquisa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsPesquisa " + osPesquisaCollectionOldOsPesquisa + " since its codpesquisapergunta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<OsPesquisaresposta> attachedOsPesquisarespostaCollectionNew = new ArrayList<OsPesquisaresposta>();
            for (OsPesquisaresposta osPesquisarespostaCollectionNewOsPesquisarespostaToAttach : osPesquisarespostaCollectionNew) {
                osPesquisarespostaCollectionNewOsPesquisarespostaToAttach = em.getReference(osPesquisarespostaCollectionNewOsPesquisarespostaToAttach.getClass(), osPesquisarespostaCollectionNewOsPesquisarespostaToAttach.getCodpesquisaresposta());
                attachedOsPesquisarespostaCollectionNew.add(osPesquisarespostaCollectionNewOsPesquisarespostaToAttach);
            }
            osPesquisarespostaCollectionNew = attachedOsPesquisarespostaCollectionNew;
            osPesquisapergunta.setOsPesquisarespostaCollection(osPesquisarespostaCollectionNew);
            Collection<OsPesquisa> attachedOsPesquisaCollectionNew = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionNewOsPesquisaToAttach : osPesquisaCollectionNew) {
                osPesquisaCollectionNewOsPesquisaToAttach = em.getReference(osPesquisaCollectionNewOsPesquisaToAttach.getClass(), osPesquisaCollectionNewOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollectionNew.add(osPesquisaCollectionNewOsPesquisaToAttach);
            }
            osPesquisaCollectionNew = attachedOsPesquisaCollectionNew;
            osPesquisapergunta.setOsPesquisaCollection(osPesquisaCollectionNew);
            osPesquisapergunta = em.merge(osPesquisapergunta);
            for (OsPesquisaresposta osPesquisarespostaCollectionOldOsPesquisaresposta : osPesquisarespostaCollectionOld) {
                if (!osPesquisarespostaCollectionNew.contains(osPesquisarespostaCollectionOldOsPesquisaresposta)) {
                    osPesquisarespostaCollectionOldOsPesquisaresposta.setCodpesquisapergunta(null);
                    osPesquisarespostaCollectionOldOsPesquisaresposta = em.merge(osPesquisarespostaCollectionOldOsPesquisaresposta);
                }
            }
            for (OsPesquisaresposta osPesquisarespostaCollectionNewOsPesquisaresposta : osPesquisarespostaCollectionNew) {
                if (!osPesquisarespostaCollectionOld.contains(osPesquisarespostaCollectionNewOsPesquisaresposta)) {
                    OsPesquisapergunta oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta = osPesquisarespostaCollectionNewOsPesquisaresposta.getCodpesquisapergunta();
                    osPesquisarespostaCollectionNewOsPesquisaresposta.setCodpesquisapergunta(osPesquisapergunta);
                    osPesquisarespostaCollectionNewOsPesquisaresposta = em.merge(osPesquisarespostaCollectionNewOsPesquisaresposta);
                    if (oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta != null && !oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta.equals(osPesquisapergunta)) {
                        oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta.getOsPesquisarespostaCollection().remove(osPesquisarespostaCollectionNewOsPesquisaresposta);
                        oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta = em.merge(oldCodpesquisaperguntaOfOsPesquisarespostaCollectionNewOsPesquisaresposta);
                    }
                }
            }
            for (OsPesquisa osPesquisaCollectionNewOsPesquisa : osPesquisaCollectionNew) {
                if (!osPesquisaCollectionOld.contains(osPesquisaCollectionNewOsPesquisa)) {
                    OsPesquisapergunta oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa = osPesquisaCollectionNewOsPesquisa.getCodpesquisapergunta();
                    osPesquisaCollectionNewOsPesquisa.setCodpesquisapergunta(osPesquisapergunta);
                    osPesquisaCollectionNewOsPesquisa = em.merge(osPesquisaCollectionNewOsPesquisa);
                    if (oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa != null && !oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa.equals(osPesquisapergunta)) {
                        oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionNewOsPesquisa);
                        oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa = em.merge(oldCodpesquisaperguntaOfOsPesquisaCollectionNewOsPesquisa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osPesquisapergunta.getCodpesquisapergunta();
                if (findOsPesquisapergunta(id) == null) {
                    throw new NonexistentEntityException("The osPesquisapergunta with id " + id + " no longer exists.");
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
            OsPesquisapergunta osPesquisapergunta;
            try {
                osPesquisapergunta = em.getReference(OsPesquisapergunta.class, id);
                osPesquisapergunta.getCodpesquisapergunta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osPesquisapergunta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<OsPesquisa> osPesquisaCollectionOrphanCheck = osPesquisapergunta.getOsPesquisaCollection();
            for (OsPesquisa osPesquisaCollectionOrphanCheckOsPesquisa : osPesquisaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsPesquisapergunta (" + osPesquisapergunta + ") cannot be destroyed since the OsPesquisa " + osPesquisaCollectionOrphanCheckOsPesquisa + " in its osPesquisaCollection field has a non-nullable codpesquisapergunta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<OsPesquisaresposta> osPesquisarespostaCollection = osPesquisapergunta.getOsPesquisarespostaCollection();
            for (OsPesquisaresposta osPesquisarespostaCollectionOsPesquisaresposta : osPesquisarespostaCollection) {
                osPesquisarespostaCollectionOsPesquisaresposta.setCodpesquisapergunta(null);
                osPesquisarespostaCollectionOsPesquisaresposta = em.merge(osPesquisarespostaCollectionOsPesquisaresposta);
            }
            em.remove(osPesquisapergunta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsPesquisapergunta> findOsPesquisaperguntaEntities() {
        return findOsPesquisaperguntaEntities(true, -1, -1);
    }

    public List<OsPesquisapergunta> findOsPesquisaperguntaEntities(int maxResults, int firstResult) {
        return findOsPesquisaperguntaEntities(false, maxResults, firstResult);
    }

    private List<OsPesquisapergunta> findOsPesquisaperguntaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsPesquisapergunta.class));
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

    public OsPesquisapergunta findOsPesquisapergunta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsPesquisapergunta.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsPesquisaperguntaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsPesquisapergunta> rt = cq.from(OsPesquisapergunta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
