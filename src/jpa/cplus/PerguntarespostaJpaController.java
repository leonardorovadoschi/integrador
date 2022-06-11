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
import entidade.cplus.Perguntaresposta;
import entidade.cplus.Pesquisa;
import entidade.cplus.Pesquisapergunta;
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
public class PerguntarespostaJpaController implements Serializable {

    public PerguntarespostaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perguntaresposta perguntaresposta) throws PreexistingEntityException, Exception {
        if (perguntaresposta.getPerguntarespostaCollection() == null) {
            perguntaresposta.setPerguntarespostaCollection(new ArrayList<Perguntaresposta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perguntaresposta codproximapergunta = perguntaresposta.getCodproximapergunta();
            if (codproximapergunta != null) {
                codproximapergunta = em.getReference(codproximapergunta.getClass(), codproximapergunta.getCodperguntaresposta());
                perguntaresposta.setCodproximapergunta(codproximapergunta);
            }
            Pesquisa codpesquisa = perguntaresposta.getCodpesquisa();
            if (codpesquisa != null) {
                codpesquisa = em.getReference(codpesquisa.getClass(), codpesquisa.getCodpesquisa());
                perguntaresposta.setCodpesquisa(codpesquisa);
            }
            Pesquisapergunta codpesquisapergunta = perguntaresposta.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta = em.getReference(codpesquisapergunta.getClass(), codpesquisapergunta.getCodpesquisapergunta());
                perguntaresposta.setCodpesquisapergunta(codpesquisapergunta);
            }
            Collection<Perguntaresposta> attachedPerguntarespostaCollection = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionPerguntarespostaToAttach : perguntaresposta.getPerguntarespostaCollection()) {
                perguntarespostaCollectionPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionPerguntarespostaToAttach.getClass(), perguntarespostaCollectionPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollection.add(perguntarespostaCollectionPerguntarespostaToAttach);
            }
            perguntaresposta.setPerguntarespostaCollection(attachedPerguntarespostaCollection);
            em.persist(perguntaresposta);
            if (codproximapergunta != null) {
                codproximapergunta.getPerguntarespostaCollection().add(perguntaresposta);
                codproximapergunta = em.merge(codproximapergunta);
            }
            if (codpesquisa != null) {
                codpesquisa.getPerguntarespostaCollection().add(perguntaresposta);
                codpesquisa = em.merge(codpesquisa);
            }
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getPerguntarespostaCollection().add(perguntaresposta);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : perguntaresposta.getPerguntarespostaCollection()) {
                Perguntaresposta oldCodproximaperguntaOfPerguntarespostaCollectionPerguntaresposta = perguntarespostaCollectionPerguntaresposta.getCodproximapergunta();
                perguntarespostaCollectionPerguntaresposta.setCodproximapergunta(perguntaresposta);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
                if (oldCodproximaperguntaOfPerguntarespostaCollectionPerguntaresposta != null) {
                    oldCodproximaperguntaOfPerguntarespostaCollectionPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionPerguntaresposta);
                    oldCodproximaperguntaOfPerguntarespostaCollectionPerguntaresposta = em.merge(oldCodproximaperguntaOfPerguntarespostaCollectionPerguntaresposta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPerguntaresposta(perguntaresposta.getCodperguntaresposta()) != null) {
                throw new PreexistingEntityException("Perguntaresposta " + perguntaresposta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perguntaresposta perguntaresposta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perguntaresposta persistentPerguntaresposta = em.find(Perguntaresposta.class, perguntaresposta.getCodperguntaresposta());
            Perguntaresposta codproximaperguntaOld = persistentPerguntaresposta.getCodproximapergunta();
            Perguntaresposta codproximaperguntaNew = perguntaresposta.getCodproximapergunta();
            Pesquisa codpesquisaOld = persistentPerguntaresposta.getCodpesquisa();
            Pesquisa codpesquisaNew = perguntaresposta.getCodpesquisa();
            Pesquisapergunta codpesquisaperguntaOld = persistentPerguntaresposta.getCodpesquisapergunta();
            Pesquisapergunta codpesquisaperguntaNew = perguntaresposta.getCodpesquisapergunta();
            Collection<Perguntaresposta> perguntarespostaCollectionOld = persistentPerguntaresposta.getPerguntarespostaCollection();
            Collection<Perguntaresposta> perguntarespostaCollectionNew = perguntaresposta.getPerguntarespostaCollection();
            if (codproximaperguntaNew != null) {
                codproximaperguntaNew = em.getReference(codproximaperguntaNew.getClass(), codproximaperguntaNew.getCodperguntaresposta());
                perguntaresposta.setCodproximapergunta(codproximaperguntaNew);
            }
            if (codpesquisaNew != null) {
                codpesquisaNew = em.getReference(codpesquisaNew.getClass(), codpesquisaNew.getCodpesquisa());
                perguntaresposta.setCodpesquisa(codpesquisaNew);
            }
            if (codpesquisaperguntaNew != null) {
                codpesquisaperguntaNew = em.getReference(codpesquisaperguntaNew.getClass(), codpesquisaperguntaNew.getCodpesquisapergunta());
                perguntaresposta.setCodpesquisapergunta(codpesquisaperguntaNew);
            }
            Collection<Perguntaresposta> attachedPerguntarespostaCollectionNew = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionNewPerguntarespostaToAttach : perguntarespostaCollectionNew) {
                perguntarespostaCollectionNewPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionNewPerguntarespostaToAttach.getClass(), perguntarespostaCollectionNewPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollectionNew.add(perguntarespostaCollectionNewPerguntarespostaToAttach);
            }
            perguntarespostaCollectionNew = attachedPerguntarespostaCollectionNew;
            perguntaresposta.setPerguntarespostaCollection(perguntarespostaCollectionNew);
            perguntaresposta = em.merge(perguntaresposta);
            if (codproximaperguntaOld != null && !codproximaperguntaOld.equals(codproximaperguntaNew)) {
                codproximaperguntaOld.getPerguntarespostaCollection().remove(perguntaresposta);
                codproximaperguntaOld = em.merge(codproximaperguntaOld);
            }
            if (codproximaperguntaNew != null && !codproximaperguntaNew.equals(codproximaperguntaOld)) {
                codproximaperguntaNew.getPerguntarespostaCollection().add(perguntaresposta);
                codproximaperguntaNew = em.merge(codproximaperguntaNew);
            }
            if (codpesquisaOld != null && !codpesquisaOld.equals(codpesquisaNew)) {
                codpesquisaOld.getPerguntarespostaCollection().remove(perguntaresposta);
                codpesquisaOld = em.merge(codpesquisaOld);
            }
            if (codpesquisaNew != null && !codpesquisaNew.equals(codpesquisaOld)) {
                codpesquisaNew.getPerguntarespostaCollection().add(perguntaresposta);
                codpesquisaNew = em.merge(codpesquisaNew);
            }
            if (codpesquisaperguntaOld != null && !codpesquisaperguntaOld.equals(codpesquisaperguntaNew)) {
                codpesquisaperguntaOld.getPerguntarespostaCollection().remove(perguntaresposta);
                codpesquisaperguntaOld = em.merge(codpesquisaperguntaOld);
            }
            if (codpesquisaperguntaNew != null && !codpesquisaperguntaNew.equals(codpesquisaperguntaOld)) {
                codpesquisaperguntaNew.getPerguntarespostaCollection().add(perguntaresposta);
                codpesquisaperguntaNew = em.merge(codpesquisaperguntaNew);
            }
            for (Perguntaresposta perguntarespostaCollectionOldPerguntaresposta : perguntarespostaCollectionOld) {
                if (!perguntarespostaCollectionNew.contains(perguntarespostaCollectionOldPerguntaresposta)) {
                    perguntarespostaCollectionOldPerguntaresposta.setCodproximapergunta(null);
                    perguntarespostaCollectionOldPerguntaresposta = em.merge(perguntarespostaCollectionOldPerguntaresposta);
                }
            }
            for (Perguntaresposta perguntarespostaCollectionNewPerguntaresposta : perguntarespostaCollectionNew) {
                if (!perguntarespostaCollectionOld.contains(perguntarespostaCollectionNewPerguntaresposta)) {
                    Perguntaresposta oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta = perguntarespostaCollectionNewPerguntaresposta.getCodproximapergunta();
                    perguntarespostaCollectionNewPerguntaresposta.setCodproximapergunta(perguntaresposta);
                    perguntarespostaCollectionNewPerguntaresposta = em.merge(perguntarespostaCollectionNewPerguntaresposta);
                    if (oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta != null && !oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta.equals(perguntaresposta)) {
                        oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionNewPerguntaresposta);
                        oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta = em.merge(oldCodproximaperguntaOfPerguntarespostaCollectionNewPerguntaresposta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = perguntaresposta.getCodperguntaresposta();
                if (findPerguntaresposta(id) == null) {
                    throw new NonexistentEntityException("The perguntaresposta with id " + id + " no longer exists.");
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
            Perguntaresposta perguntaresposta;
            try {
                perguntaresposta = em.getReference(Perguntaresposta.class, id);
                perguntaresposta.getCodperguntaresposta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perguntaresposta with id " + id + " no longer exists.", enfe);
            }
            Perguntaresposta codproximapergunta = perguntaresposta.getCodproximapergunta();
            if (codproximapergunta != null) {
                codproximapergunta.getPerguntarespostaCollection().remove(perguntaresposta);
                codproximapergunta = em.merge(codproximapergunta);
            }
            Pesquisa codpesquisa = perguntaresposta.getCodpesquisa();
            if (codpesquisa != null) {
                codpesquisa.getPerguntarespostaCollection().remove(perguntaresposta);
                codpesquisa = em.merge(codpesquisa);
            }
            Pesquisapergunta codpesquisapergunta = perguntaresposta.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getPerguntarespostaCollection().remove(perguntaresposta);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            Collection<Perguntaresposta> perguntarespostaCollection = perguntaresposta.getPerguntarespostaCollection();
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : perguntarespostaCollection) {
                perguntarespostaCollectionPerguntaresposta.setCodproximapergunta(null);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
            }
            em.remove(perguntaresposta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perguntaresposta> findPerguntarespostaEntities() {
        return findPerguntarespostaEntities(true, -1, -1);
    }

    public List<Perguntaresposta> findPerguntarespostaEntities(int maxResults, int firstResult) {
        return findPerguntarespostaEntities(false, maxResults, firstResult);
    }

    private List<Perguntaresposta> findPerguntarespostaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perguntaresposta.class));
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

    public Perguntaresposta findPerguntaresposta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perguntaresposta.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerguntarespostaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perguntaresposta> rt = cq.from(Perguntaresposta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
