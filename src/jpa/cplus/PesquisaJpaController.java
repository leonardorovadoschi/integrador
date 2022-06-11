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
import entidade.cplus.Pesquisapergunta;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Perguntaresposta;
import entidade.cplus.Pesquisa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PesquisaJpaController implements Serializable {

    public PesquisaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pesquisa pesquisa) throws PreexistingEntityException, Exception {
        if (pesquisa.getPesquisaperguntaCollection() == null) {
            pesquisa.setPesquisaperguntaCollection(new ArrayList<Pesquisapergunta>());
        }
        if (pesquisa.getPerguntarespostaCollection() == null) {
            pesquisa.setPerguntarespostaCollection(new ArrayList<Perguntaresposta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pesquisapergunta> attachedPesquisaperguntaCollection = new ArrayList<Pesquisapergunta>();
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisaperguntaToAttach : pesquisa.getPesquisaperguntaCollection()) {
                pesquisaperguntaCollectionPesquisaperguntaToAttach = em.getReference(pesquisaperguntaCollectionPesquisaperguntaToAttach.getClass(), pesquisaperguntaCollectionPesquisaperguntaToAttach.getCodpesquisapergunta());
                attachedPesquisaperguntaCollection.add(pesquisaperguntaCollectionPesquisaperguntaToAttach);
            }
            pesquisa.setPesquisaperguntaCollection(attachedPesquisaperguntaCollection);
            Collection<Perguntaresposta> attachedPerguntarespostaCollection = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionPerguntarespostaToAttach : pesquisa.getPerguntarespostaCollection()) {
                perguntarespostaCollectionPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionPerguntarespostaToAttach.getClass(), perguntarespostaCollectionPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollection.add(perguntarespostaCollectionPerguntarespostaToAttach);
            }
            pesquisa.setPerguntarespostaCollection(attachedPerguntarespostaCollection);
            em.persist(pesquisa);
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisapergunta : pesquisa.getPesquisaperguntaCollection()) {
                Pesquisa oldCodpesquisaOfPesquisaperguntaCollectionPesquisapergunta = pesquisaperguntaCollectionPesquisapergunta.getCodpesquisa();
                pesquisaperguntaCollectionPesquisapergunta.setCodpesquisa(pesquisa);
                pesquisaperguntaCollectionPesquisapergunta = em.merge(pesquisaperguntaCollectionPesquisapergunta);
                if (oldCodpesquisaOfPesquisaperguntaCollectionPesquisapergunta != null) {
                    oldCodpesquisaOfPesquisaperguntaCollectionPesquisapergunta.getPesquisaperguntaCollection().remove(pesquisaperguntaCollectionPesquisapergunta);
                    oldCodpesquisaOfPesquisaperguntaCollectionPesquisapergunta = em.merge(oldCodpesquisaOfPesquisaperguntaCollectionPesquisapergunta);
                }
            }
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : pesquisa.getPerguntarespostaCollection()) {
                Pesquisa oldCodpesquisaOfPerguntarespostaCollectionPerguntaresposta = perguntarespostaCollectionPerguntaresposta.getCodpesquisa();
                perguntarespostaCollectionPerguntaresposta.setCodpesquisa(pesquisa);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
                if (oldCodpesquisaOfPerguntarespostaCollectionPerguntaresposta != null) {
                    oldCodpesquisaOfPerguntarespostaCollectionPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionPerguntaresposta);
                    oldCodpesquisaOfPerguntarespostaCollectionPerguntaresposta = em.merge(oldCodpesquisaOfPerguntarespostaCollectionPerguntaresposta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPesquisa(pesquisa.getCodpesquisa()) != null) {
                throw new PreexistingEntityException("Pesquisa " + pesquisa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pesquisa pesquisa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pesquisa persistentPesquisa = em.find(Pesquisa.class, pesquisa.getCodpesquisa());
            Collection<Pesquisapergunta> pesquisaperguntaCollectionOld = persistentPesquisa.getPesquisaperguntaCollection();
            Collection<Pesquisapergunta> pesquisaperguntaCollectionNew = pesquisa.getPesquisaperguntaCollection();
            Collection<Perguntaresposta> perguntarespostaCollectionOld = persistentPesquisa.getPerguntarespostaCollection();
            Collection<Perguntaresposta> perguntarespostaCollectionNew = pesquisa.getPerguntarespostaCollection();
            Collection<Pesquisapergunta> attachedPesquisaperguntaCollectionNew = new ArrayList<Pesquisapergunta>();
            for (Pesquisapergunta pesquisaperguntaCollectionNewPesquisaperguntaToAttach : pesquisaperguntaCollectionNew) {
                pesquisaperguntaCollectionNewPesquisaperguntaToAttach = em.getReference(pesquisaperguntaCollectionNewPesquisaperguntaToAttach.getClass(), pesquisaperguntaCollectionNewPesquisaperguntaToAttach.getCodpesquisapergunta());
                attachedPesquisaperguntaCollectionNew.add(pesquisaperguntaCollectionNewPesquisaperguntaToAttach);
            }
            pesquisaperguntaCollectionNew = attachedPesquisaperguntaCollectionNew;
            pesquisa.setPesquisaperguntaCollection(pesquisaperguntaCollectionNew);
            Collection<Perguntaresposta> attachedPerguntarespostaCollectionNew = new ArrayList<Perguntaresposta>();
            for (Perguntaresposta perguntarespostaCollectionNewPerguntarespostaToAttach : perguntarespostaCollectionNew) {
                perguntarespostaCollectionNewPerguntarespostaToAttach = em.getReference(perguntarespostaCollectionNewPerguntarespostaToAttach.getClass(), perguntarespostaCollectionNewPerguntarespostaToAttach.getCodperguntaresposta());
                attachedPerguntarespostaCollectionNew.add(perguntarespostaCollectionNewPerguntarespostaToAttach);
            }
            perguntarespostaCollectionNew = attachedPerguntarespostaCollectionNew;
            pesquisa.setPerguntarespostaCollection(perguntarespostaCollectionNew);
            pesquisa = em.merge(pesquisa);
            for (Pesquisapergunta pesquisaperguntaCollectionOldPesquisapergunta : pesquisaperguntaCollectionOld) {
                if (!pesquisaperguntaCollectionNew.contains(pesquisaperguntaCollectionOldPesquisapergunta)) {
                    pesquisaperguntaCollectionOldPesquisapergunta.setCodpesquisa(null);
                    pesquisaperguntaCollectionOldPesquisapergunta = em.merge(pesquisaperguntaCollectionOldPesquisapergunta);
                }
            }
            for (Pesquisapergunta pesquisaperguntaCollectionNewPesquisapergunta : pesquisaperguntaCollectionNew) {
                if (!pesquisaperguntaCollectionOld.contains(pesquisaperguntaCollectionNewPesquisapergunta)) {
                    Pesquisa oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta = pesquisaperguntaCollectionNewPesquisapergunta.getCodpesquisa();
                    pesquisaperguntaCollectionNewPesquisapergunta.setCodpesquisa(pesquisa);
                    pesquisaperguntaCollectionNewPesquisapergunta = em.merge(pesquisaperguntaCollectionNewPesquisapergunta);
                    if (oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta != null && !oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta.equals(pesquisa)) {
                        oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta.getPesquisaperguntaCollection().remove(pesquisaperguntaCollectionNewPesquisapergunta);
                        oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta = em.merge(oldCodpesquisaOfPesquisaperguntaCollectionNewPesquisapergunta);
                    }
                }
            }
            for (Perguntaresposta perguntarespostaCollectionOldPerguntaresposta : perguntarespostaCollectionOld) {
                if (!perguntarespostaCollectionNew.contains(perguntarespostaCollectionOldPerguntaresposta)) {
                    perguntarespostaCollectionOldPerguntaresposta.setCodpesquisa(null);
                    perguntarespostaCollectionOldPerguntaresposta = em.merge(perguntarespostaCollectionOldPerguntaresposta);
                }
            }
            for (Perguntaresposta perguntarespostaCollectionNewPerguntaresposta : perguntarespostaCollectionNew) {
                if (!perguntarespostaCollectionOld.contains(perguntarespostaCollectionNewPerguntaresposta)) {
                    Pesquisa oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta = perguntarespostaCollectionNewPerguntaresposta.getCodpesquisa();
                    perguntarespostaCollectionNewPerguntaresposta.setCodpesquisa(pesquisa);
                    perguntarespostaCollectionNewPerguntaresposta = em.merge(perguntarespostaCollectionNewPerguntaresposta);
                    if (oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta != null && !oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta.equals(pesquisa)) {
                        oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta.getPerguntarespostaCollection().remove(perguntarespostaCollectionNewPerguntaresposta);
                        oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta = em.merge(oldCodpesquisaOfPerguntarespostaCollectionNewPerguntaresposta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pesquisa.getCodpesquisa();
                if (findPesquisa(id) == null) {
                    throw new NonexistentEntityException("The pesquisa with id " + id + " no longer exists.");
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
            Pesquisa pesquisa;
            try {
                pesquisa = em.getReference(Pesquisa.class, id);
                pesquisa.getCodpesquisa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pesquisa with id " + id + " no longer exists.", enfe);
            }
            Collection<Pesquisapergunta> pesquisaperguntaCollection = pesquisa.getPesquisaperguntaCollection();
            for (Pesquisapergunta pesquisaperguntaCollectionPesquisapergunta : pesquisaperguntaCollection) {
                pesquisaperguntaCollectionPesquisapergunta.setCodpesquisa(null);
                pesquisaperguntaCollectionPesquisapergunta = em.merge(pesquisaperguntaCollectionPesquisapergunta);
            }
            Collection<Perguntaresposta> perguntarespostaCollection = pesquisa.getPerguntarespostaCollection();
            for (Perguntaresposta perguntarespostaCollectionPerguntaresposta : perguntarespostaCollection) {
                perguntarespostaCollectionPerguntaresposta.setCodpesquisa(null);
                perguntarespostaCollectionPerguntaresposta = em.merge(perguntarespostaCollectionPerguntaresposta);
            }
            em.remove(pesquisa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pesquisa> findPesquisaEntities() {
        return findPesquisaEntities(true, -1, -1);
    }

    public List<Pesquisa> findPesquisaEntities(int maxResults, int firstResult) {
        return findPesquisaEntities(false, maxResults, firstResult);
    }

    private List<Pesquisa> findPesquisaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pesquisa.class));
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

    public Pesquisa findPesquisa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pesquisa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPesquisaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pesquisa> rt = cq.from(Pesquisa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
