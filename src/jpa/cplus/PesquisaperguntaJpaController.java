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
import entidade.cplus.Pesquisa;
import entidade.cplus.Pesquisapergunta;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Perguntaresposta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PesquisaperguntaJpaController implements Serializable {

    public PesquisaperguntaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pesquisapergunta pesquisapergunta) throws PreexistingEntityException, Exception {
        if (pesquisapergunta.getPesquisaperguntaCollection() == null) {
            pesquisapergunta.setPesquisaperguntaCollection(new ArrayList<Pesquisapergunta>());
        }
        if (pesquisapergunta.getPerguntarespostaCollection() == null) {
            pesquisapergunta.setPerguntarespostaCollection(new ArrayList<Perguntaresposta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pesquisa codpesquisa = pesquisapergunta.getCodpesquisa();
            if (codpesquisa != null) {
                codpesquisa = em.getReference(codpesquisa.getClass(), codpesquisa.getCodpesquisa());
                pesquisapergunta.setCodpesquisa(codpesquisa);
            }
            Pesquisapergunta codproximapergunta = pesquisapergunta.getCodproximapergunta();
            if (codproximapergunta != null) {
                codproximapergunta = em.getReference(codproximapergunta.getClass(), codproximapergunta.getCodpesquisapergunta());
                pesquisapergunta.setCodproximapergunta(codproximapergunta);
            }
            Collection<Pesquisapergunta> attachedPesquisaperguntaCollection = new ArrayList<Pesquisapergunta>();
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisaperguntaToAttach : pesquisapergunta.getPesquisaperguntaCollection()) {
                pesquisaperguntaCollectionPesquisaperguntaToAttach = em.getReference(pesquisaperguntaCollectionPesquisaperguntaToAttach.getClass(), pesquisaperguntaCollectionPesquisaperguntaToAttach.getCodpesquisapergunta());
                attachedPesquisaperguntaCollection.add(pesquisaperguntaCollectionPesquisaperguntaToAttach);
            }
            pesquisapergunta.setPesquisaperguntaCollection(attachedPesquisaperguntaCollection);
            Collection<Perguntaresposta> attachedPerguntarespostaCollection = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionPerguntarespostaToAttach : pesquisapergunta.getPerguntarespostaCollection()) {
                perguntarespostaCollectionPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionPerguntarespostaToAttach.getClass(), perguntarespostaCollectionPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollection.add(perguntarespostaCollectionPerguntarespostaToAttach);
            }
            pesquisapergunta.setPerguntarespostaCollection(attachedPerguntarespostaCollection);
            em.persist(pesquisapergunta);
            if (codpesquisa != null) {
                codpesquisa.getPesquisaperguntaCollection().add(pesquisapergunta);
                codpesquisa = em.merge(codpesquisa);
            }
            if (codproximapergunta != null) {
                codproximapergunta.getPesquisaperguntaCollection().add(pesquisapergunta);
                codproximapergunta = em.merge(codproximapergunta);
            }
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisapergunta : pesquisapergunta.getPesquisaperguntaCollection()) {
                Pesquisapergunta oldCodproximaperguntaOfPesquisaperguntaCollectionPesquisapergunta = pesquisaperguntaCollectionPesquisapergunta.getCodproximapergunta();
                pesquisaperguntaCollectionPesquisapergunta.setCodproximapergunta(pesquisapergunta);
                pesquisaperguntaCollectionPesquisapergunta = em.merge(pesquisaperguntaCollectionPesquisapergunta);
                if (oldCodproximaperguntaOfPesquisaperguntaCollectionPesquisapergunta != null) {
                    oldCodproximaperguntaOfPesquisaperguntaCollectionPesquisapergunta.getPesquisaperguntaCollection().remove(pesquisaperguntaCollectionPesquisapergunta);
                    oldCodproximaperguntaOfPesquisaperguntaCollectionPesquisapergunta = em.merge(oldCodproximaperguntaOfPesquisaperguntaCollectionPesquisapergunta);
                }
            }
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : pesquisapergunta.getPerguntarespostaCollection()) {
                Pesquisapergunta oldCodpesquisaperguntaOfPerguntarespostaCollectionPerguntaresposta = perguntarespostaCollectionPerguntaresposta.getCodpesquisapergunta();
                perguntarespostaCollectionPerguntaresposta.setCodpesquisapergunta(pesquisapergunta);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
                if (oldCodpesquisaperguntaOfPerguntarespostaCollectionPerguntaresposta != null) {
                    oldCodpesquisaperguntaOfPerguntarespostaCollectionPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionPerguntaresposta);
                    oldCodpesquisaperguntaOfPerguntarespostaCollectionPerguntaresposta = em.merge(oldCodpesquisaperguntaOfPerguntarespostaCollectionPerguntaresposta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPesquisapergunta(pesquisapergunta.getCodpesquisapergunta()) != null) {
                throw new PreexistingEntityException("Pesquisapergunta " + pesquisapergunta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pesquisapergunta pesquisapergunta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pesquisapergunta persistentPesquisapergunta = em.find(Pesquisapergunta.class, pesquisapergunta.getCodpesquisapergunta());
            Pesquisa codpesquisaOld = persistentPesquisapergunta.getCodpesquisa();
            Pesquisa codpesquisaNew = pesquisapergunta.getCodpesquisa();
            Pesquisapergunta codproximaperguntaOld = persistentPesquisapergunta.getCodproximapergunta();
            Pesquisapergunta codproximaperguntaNew = pesquisapergunta.getCodproximapergunta();
            Collection<Pesquisapergunta> pesquisaperguntaCollectionOld = persistentPesquisapergunta.getPesquisaperguntaCollection();
            Collection<Pesquisapergunta> pesquisaperguntaCollectionNew = pesquisapergunta.getPesquisaperguntaCollection();
            Collection<Perguntaresposta> perguntarespostaCollectionOld = persistentPesquisapergunta.getPerguntarespostaCollection();
            Collection<Perguntaresposta> perguntarespostaCollectionNew = pesquisapergunta.getPerguntarespostaCollection();
            if (codpesquisaNew != null) {
                codpesquisaNew = em.getReference(codpesquisaNew.getClass(), codpesquisaNew.getCodpesquisa());
                pesquisapergunta.setCodpesquisa(codpesquisaNew);
            }
            if (codproximaperguntaNew != null) {
                codproximaperguntaNew = em.getReference(codproximaperguntaNew.getClass(), codproximaperguntaNew.getCodpesquisapergunta());
                pesquisapergunta.setCodproximapergunta(codproximaperguntaNew);
            }
            Collection<Pesquisapergunta> attachedPesquisaperguntaCollectionNew = new ArrayList<Pesquisapergunta>();
            for (Pesquisapergunta pesquisaperguntaCollectionNewPesquisaperguntaToAttach : pesquisaperguntaCollectionNew) {
                pesquisaperguntaCollectionNewPesquisaperguntaToAttach = em.getReference(pesquisaperguntaCollectionNewPesquisaperguntaToAttach.getClass(), pesquisaperguntaCollectionNewPesquisaperguntaToAttach.getCodpesquisapergunta());
                attachedPesquisaperguntaCollectionNew.add(pesquisaperguntaCollectionNewPesquisaperguntaToAttach);
            }
            pesquisaperguntaCollectionNew = attachedPesquisaperguntaCollectionNew;
            pesquisapergunta.setPesquisaperguntaCollection(pesquisaperguntaCollectionNew);
            Collection<Perguntaresposta> attachedPerguntarespostaCollectionNew = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionNewPerguntarespostaToAttach : perguntarespostaCollectionNew) {
                perguntarespostaCollectionNewPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionNewPerguntarespostaToAttach.getClass(), perguntarespostaCollectionNewPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollectionNew.add(perguntarespostaCollectionNewPerguntarespostaToAttach);
            }
            perguntarespostaCollectionNew = attachedPerguntarespostaCollectionNew;
            pesquisapergunta.setPerguntarespostaCollection(perguntarespostaCollectionNew);
            pesquisapergunta = em.merge(pesquisapergunta);
            if (codpesquisaOld != null && !codpesquisaOld.equals(codpesquisaNew)) {
                codpesquisaOld.getPesquisaperguntaCollection().remove(pesquisapergunta);
                codpesquisaOld = em.merge(codpesquisaOld);
            }
            if (codpesquisaNew != null && !codpesquisaNew.equals(codpesquisaOld)) {
                codpesquisaNew.getPesquisaperguntaCollection().add(pesquisapergunta);
                codpesquisaNew = em.merge(codpesquisaNew);
            }
            if (codproximaperguntaOld != null && !codproximaperguntaOld.equals(codproximaperguntaNew)) {
                codproximaperguntaOld.getPesquisaperguntaCollection().remove(pesquisapergunta);
                codproximaperguntaOld = em.merge(codproximaperguntaOld);
            }
            if (codproximaperguntaNew != null && !codproximaperguntaNew.equals(codproximaperguntaOld)) {
                codproximaperguntaNew.getPesquisaperguntaCollection().add(pesquisapergunta);
                codproximaperguntaNew = em.merge(codproximaperguntaNew);
            }
            for (Pesquisapergunta pesquisaperguntaCollectionOldPesquisapergunta : pesquisaperguntaCollectionOld) {
                if (!pesquisaperguntaCollectionNew.contains(pesquisaperguntaCollectionOldPesquisapergunta)) {
                    pesquisaperguntaCollectionOldPesquisapergunta.setCodproximapergunta(null);
                    pesquisaperguntaCollectionOldPesquisapergunta = em.merge(pesquisaperguntaCollectionOldPesquisapergunta);
                }
            }
            for (Pesquisapergunta pesquisaperguntaCollectionNewPesquisapergunta : pesquisaperguntaCollectionNew) {
                if (!pesquisaperguntaCollectionOld.contains(pesquisaperguntaCollectionNewPesquisapergunta)) {
                    Pesquisapergunta oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta = pesquisaperguntaCollectionNewPesquisapergunta.getCodproximapergunta();
                    pesquisaperguntaCollectionNewPesquisapergunta.setCodproximapergunta(pesquisapergunta);
                    pesquisaperguntaCollectionNewPesquisapergunta = em.merge(pesquisaperguntaCollectionNewPesquisapergunta);
                    if (oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta != null && !oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta.equals(pesquisapergunta)) {
                        oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta.getPesquisaperguntaCollection().remove(pesquisaperguntaCollectionNewPesquisapergunta);
                        oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta = em.merge(oldCodproximaperguntaOfPesquisaperguntaCollectionNewPesquisapergunta);
                    }
                }
            }
            for (Perguntaresposta perguntarespostaCollectionOldPerguntaresposta : perguntarespostaCollectionOld) {
                if (!perguntarespostaCollectionNew.contains(perguntarespostaCollectionOldPerguntaresposta)) {
                    perguntarespostaCollectionOldPerguntaresposta.setCodpesquisapergunta(null);
                    perguntarespostaCollectionOldPerguntaresposta = em.merge(perguntarespostaCollectionOldPerguntaresposta);
                }
            }
            for (Perguntaresposta perguntarespostaCollectionNewPerguntaresposta : perguntarespostaCollectionNew) {
                if (!perguntarespostaCollectionOld.contains(perguntarespostaCollectionNewPerguntaresposta)) {
                    Pesquisapergunta oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta = perguntarespostaCollectionNewPerguntaresposta.getCodpesquisapergunta();
                    perguntarespostaCollectionNewPerguntaresposta.setCodpesquisapergunta(pesquisapergunta);
                    perguntarespostaCollectionNewPerguntaresposta = em.merge(perguntarespostaCollectionNewPerguntaresposta);
                    if (oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta != null && !oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta.equals(pesquisapergunta)) {
                        oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionNewPerguntaresposta);
                        oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta = em.merge(oldCodpesquisaperguntaOfPerguntarespostaCollectionNewPerguntaresposta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pesquisapergunta.getCodpesquisapergunta();
                if (findPesquisapergunta(id) == null) {
                    throw new NonexistentEntityException("The pesquisapergunta with id " + id + " no longer exists.");
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
            Pesquisapergunta pesquisapergunta;
            try {
                pesquisapergunta = em.getReference(Pesquisapergunta.class, id);
                pesquisapergunta.getCodpesquisapergunta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pesquisapergunta with id " + id + " no longer exists.", enfe);
            }
            Pesquisa codpesquisa = pesquisapergunta.getCodpesquisa();
            if (codpesquisa != null) {
                codpesquisa.getPesquisaperguntaCollection().remove(pesquisapergunta);
                codpesquisa = em.merge(codpesquisa);
            }
            Pesquisapergunta codproximapergunta = pesquisapergunta.getCodproximapergunta();
            if (codproximapergunta != null) {
                codproximapergunta.getPesquisaperguntaCollection().remove(pesquisapergunta);
                codproximapergunta = em.merge(codproximapergunta);
            }
            Collection<Pesquisapergunta> pesquisaperguntaCollection = pesquisapergunta.getPesquisaperguntaCollection();
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisapergunta : pesquisaperguntaCollection) {
                pesquisaperguntaCollectionPesquisapergunta.setCodproximapergunta(null);
                pesquisaperguntaCollectionPesquisapergunta = em.merge(pesquisaperguntaCollectionPesquisapergunta);
            }
            Collection<Perguntaresposta> perguntarespostaCollection = pesquisapergunta.getPerguntarespostaCollection();
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : perguntarespostaCollection) {
                perguntarespostaCollectionPerguntaresposta.setCodpesquisapergunta(null);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
            }
            em.remove(pesquisapergunta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pesquisapergunta> findPesquisaperguntaEntities() {
        return findPesquisaperguntaEntities(true, -1, -1);
    }

    public List<Pesquisapergunta> findPesquisaperguntaEntities(int maxResults, int firstResult) {
        return findPesquisaperguntaEntities(false, maxResults, firstResult);
    }

    private List<Pesquisapergunta> findPesquisaperguntaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pesquisapergunta.class));
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

    public Pesquisapergunta findPesquisapergunta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pesquisapergunta.class, id);
        } finally {
            em.close();
        }
    }

    public int getPesquisaperguntaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pesquisapergunta> rt = cq.from(Pesquisapergunta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
