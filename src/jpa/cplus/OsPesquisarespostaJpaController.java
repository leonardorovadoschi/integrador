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
import entidade.cplus.OsPesquisapergunta;
import entidade.cplus.OsPesquisa;
import entidade.cplus.OsPesquisaresposta;
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
public class OsPesquisarespostaJpaController implements Serializable {

    public OsPesquisarespostaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsPesquisaresposta osPesquisaresposta) throws PreexistingEntityException, Exception {
        if (osPesquisaresposta.getOsPesquisaCollection() == null) {
            osPesquisaresposta.setOsPesquisaCollection(new ArrayList<OsPesquisa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsPesquisapergunta codpesquisapergunta = osPesquisaresposta.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta = em.getReference(codpesquisapergunta.getClass(), codpesquisapergunta.getCodpesquisapergunta());
                osPesquisaresposta.setCodpesquisapergunta(codpesquisapergunta);
            }
            Collection<OsPesquisa> attachedOsPesquisaCollection = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionOsPesquisaToAttach : osPesquisaresposta.getOsPesquisaCollection()) {
                osPesquisaCollectionOsPesquisaToAttach = em.getReference(osPesquisaCollectionOsPesquisaToAttach.getClass(), osPesquisaCollectionOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollection.add(osPesquisaCollectionOsPesquisaToAttach);
            }
            osPesquisaresposta.setOsPesquisaCollection(attachedOsPesquisaCollection);
            em.persist(osPesquisaresposta);
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getOsPesquisarespostaCollection().add(osPesquisaresposta);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            for (OsPesquisa osPesquisaCollectionOsPesquisa : osPesquisaresposta.getOsPesquisaCollection()) {
                OsPesquisaresposta oldCodpesquisarespostaOfOsPesquisaCollectionOsPesquisa = osPesquisaCollectionOsPesquisa.getCodpesquisaresposta();
                osPesquisaCollectionOsPesquisa.setCodpesquisaresposta(osPesquisaresposta);
                osPesquisaCollectionOsPesquisa = em.merge(osPesquisaCollectionOsPesquisa);
                if (oldCodpesquisarespostaOfOsPesquisaCollectionOsPesquisa != null) {
                    oldCodpesquisarespostaOfOsPesquisaCollectionOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionOsPesquisa);
                    oldCodpesquisarespostaOfOsPesquisaCollectionOsPesquisa = em.merge(oldCodpesquisarespostaOfOsPesquisaCollectionOsPesquisa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsPesquisaresposta(osPesquisaresposta.getCodpesquisaresposta()) != null) {
                throw new PreexistingEntityException("OsPesquisaresposta " + osPesquisaresposta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsPesquisaresposta osPesquisaresposta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsPesquisaresposta persistentOsPesquisaresposta = em.find(OsPesquisaresposta.class, osPesquisaresposta.getCodpesquisaresposta());
            OsPesquisapergunta codpesquisaperguntaOld = persistentOsPesquisaresposta.getCodpesquisapergunta();
            OsPesquisapergunta codpesquisaperguntaNew = osPesquisaresposta.getCodpesquisapergunta();
            Collection<OsPesquisa> osPesquisaCollectionOld = persistentOsPesquisaresposta.getOsPesquisaCollection();
            Collection<OsPesquisa> osPesquisaCollectionNew = osPesquisaresposta.getOsPesquisaCollection();
            if (codpesquisaperguntaNew != null) {
                codpesquisaperguntaNew = em.getReference(codpesquisaperguntaNew.getClass(), codpesquisaperguntaNew.getCodpesquisapergunta());
                osPesquisaresposta.setCodpesquisapergunta(codpesquisaperguntaNew);
            }
            Collection<OsPesquisa> attachedOsPesquisaCollectionNew = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionNewOsPesquisaToAttach : osPesquisaCollectionNew) {
                osPesquisaCollectionNewOsPesquisaToAttach = em.getReference(osPesquisaCollectionNewOsPesquisaToAttach.getClass(), osPesquisaCollectionNewOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollectionNew.add(osPesquisaCollectionNewOsPesquisaToAttach);
            }
            osPesquisaCollectionNew = attachedOsPesquisaCollectionNew;
            osPesquisaresposta.setOsPesquisaCollection(osPesquisaCollectionNew);
            osPesquisaresposta = em.merge(osPesquisaresposta);
            if (codpesquisaperguntaOld != null && !codpesquisaperguntaOld.equals(codpesquisaperguntaNew)) {
                codpesquisaperguntaOld.getOsPesquisarespostaCollection().remove(osPesquisaresposta);
                codpesquisaperguntaOld = em.merge(codpesquisaperguntaOld);
            }
            if (codpesquisaperguntaNew != null && !codpesquisaperguntaNew.equals(codpesquisaperguntaOld)) {
                codpesquisaperguntaNew.getOsPesquisarespostaCollection().add(osPesquisaresposta);
                codpesquisaperguntaNew = em.merge(codpesquisaperguntaNew);
            }
            for (OsPesquisa osPesquisaCollectionOldOsPesquisa : osPesquisaCollectionOld) {
                if (!osPesquisaCollectionNew.contains(osPesquisaCollectionOldOsPesquisa)) {
                    osPesquisaCollectionOldOsPesquisa.setCodpesquisaresposta(null);
                    osPesquisaCollectionOldOsPesquisa = em.merge(osPesquisaCollectionOldOsPesquisa);
                }
            }
            for (OsPesquisa osPesquisaCollectionNewOsPesquisa : osPesquisaCollectionNew) {
                if (!osPesquisaCollectionOld.contains(osPesquisaCollectionNewOsPesquisa)) {
                    OsPesquisaresposta oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa = osPesquisaCollectionNewOsPesquisa.getCodpesquisaresposta();
                    osPesquisaCollectionNewOsPesquisa.setCodpesquisaresposta(osPesquisaresposta);
                    osPesquisaCollectionNewOsPesquisa = em.merge(osPesquisaCollectionNewOsPesquisa);
                    if (oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa != null && !oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa.equals(osPesquisaresposta)) {
                        oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionNewOsPesquisa);
                        oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa = em.merge(oldCodpesquisarespostaOfOsPesquisaCollectionNewOsPesquisa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osPesquisaresposta.getCodpesquisaresposta();
                if (findOsPesquisaresposta(id) == null) {
                    throw new NonexistentEntityException("The osPesquisaresposta with id " + id + " no longer exists.");
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
            OsPesquisaresposta osPesquisaresposta;
            try {
                osPesquisaresposta = em.getReference(OsPesquisaresposta.class, id);
                osPesquisaresposta.getCodpesquisaresposta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osPesquisaresposta with id " + id + " no longer exists.", enfe);
            }
            OsPesquisapergunta codpesquisapergunta = osPesquisaresposta.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getOsPesquisarespostaCollection().remove(osPesquisaresposta);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            Collection<OsPesquisa> osPesquisaCollection = osPesquisaresposta.getOsPesquisaCollection();
            for (OsPesquisa osPesquisaCollectionOsPesquisa : osPesquisaCollection) {
                osPesquisaCollectionOsPesquisa.setCodpesquisaresposta(null);
                osPesquisaCollectionOsPesquisa = em.merge(osPesquisaCollectionOsPesquisa);
            }
            em.remove(osPesquisaresposta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsPesquisaresposta> findOsPesquisarespostaEntities() {
        return findOsPesquisarespostaEntities(true, -1, -1);
    }

    public List<OsPesquisaresposta> findOsPesquisarespostaEntities(int maxResults, int firstResult) {
        return findOsPesquisarespostaEntities(false, maxResults, firstResult);
    }

    private List<OsPesquisaresposta> findOsPesquisarespostaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsPesquisaresposta.class));
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

    public OsPesquisaresposta findOsPesquisaresposta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsPesquisaresposta.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsPesquisarespostaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsPesquisaresposta> rt = cq.from(OsPesquisaresposta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
