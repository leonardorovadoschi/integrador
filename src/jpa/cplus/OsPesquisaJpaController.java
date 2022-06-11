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
import entidade.cplus.OsOrdemservico;
import entidade.cplus.OsPesquisa;
import entidade.cplus.OsPesquisapergunta;
import entidade.cplus.OsPesquisaresposta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsPesquisaJpaController implements Serializable {

    public OsPesquisaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsPesquisa osPesquisa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico codos = osPesquisa.getCodos();
            if (codos != null) {
                codos = em.getReference(codos.getClass(), codos.getCodos());
                osPesquisa.setCodos(codos);
            }
            OsPesquisapergunta codpesquisapergunta = osPesquisa.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta = em.getReference(codpesquisapergunta.getClass(), codpesquisapergunta.getCodpesquisapergunta());
                osPesquisa.setCodpesquisapergunta(codpesquisapergunta);
            }
            OsPesquisaresposta codpesquisaresposta = osPesquisa.getCodpesquisaresposta();
            if (codpesquisaresposta != null) {
                codpesquisaresposta = em.getReference(codpesquisaresposta.getClass(), codpesquisaresposta.getCodpesquisaresposta());
                osPesquisa.setCodpesquisaresposta(codpesquisaresposta);
            }
            em.persist(osPesquisa);
            if (codos != null) {
                codos.getOsPesquisaCollection().add(osPesquisa);
                codos = em.merge(codos);
            }
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getOsPesquisaCollection().add(osPesquisa);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            if (codpesquisaresposta != null) {
                codpesquisaresposta.getOsPesquisaCollection().add(osPesquisa);
                codpesquisaresposta = em.merge(codpesquisaresposta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsPesquisa(osPesquisa.getCodospesquisa()) != null) {
                throw new PreexistingEntityException("OsPesquisa " + osPesquisa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsPesquisa osPesquisa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsPesquisa persistentOsPesquisa = em.find(OsPesquisa.class, osPesquisa.getCodospesquisa());
            OsOrdemservico codosOld = persistentOsPesquisa.getCodos();
            OsOrdemservico codosNew = osPesquisa.getCodos();
            OsPesquisapergunta codpesquisaperguntaOld = persistentOsPesquisa.getCodpesquisapergunta();
            OsPesquisapergunta codpesquisaperguntaNew = osPesquisa.getCodpesquisapergunta();
            OsPesquisaresposta codpesquisarespostaOld = persistentOsPesquisa.getCodpesquisaresposta();
            OsPesquisaresposta codpesquisarespostaNew = osPesquisa.getCodpesquisaresposta();
            if (codosNew != null) {
                codosNew = em.getReference(codosNew.getClass(), codosNew.getCodos());
                osPesquisa.setCodos(codosNew);
            }
            if (codpesquisaperguntaNew != null) {
                codpesquisaperguntaNew = em.getReference(codpesquisaperguntaNew.getClass(), codpesquisaperguntaNew.getCodpesquisapergunta());
                osPesquisa.setCodpesquisapergunta(codpesquisaperguntaNew);
            }
            if (codpesquisarespostaNew != null) {
                codpesquisarespostaNew = em.getReference(codpesquisarespostaNew.getClass(), codpesquisarespostaNew.getCodpesquisaresposta());
                osPesquisa.setCodpesquisaresposta(codpesquisarespostaNew);
            }
            osPesquisa = em.merge(osPesquisa);
            if (codosOld != null && !codosOld.equals(codosNew)) {
                codosOld.getOsPesquisaCollection().remove(osPesquisa);
                codosOld = em.merge(codosOld);
            }
            if (codosNew != null && !codosNew.equals(codosOld)) {
                codosNew.getOsPesquisaCollection().add(osPesquisa);
                codosNew = em.merge(codosNew);
            }
            if (codpesquisaperguntaOld != null && !codpesquisaperguntaOld.equals(codpesquisaperguntaNew)) {
                codpesquisaperguntaOld.getOsPesquisaCollection().remove(osPesquisa);
                codpesquisaperguntaOld = em.merge(codpesquisaperguntaOld);
            }
            if (codpesquisaperguntaNew != null && !codpesquisaperguntaNew.equals(codpesquisaperguntaOld)) {
                codpesquisaperguntaNew.getOsPesquisaCollection().add(osPesquisa);
                codpesquisaperguntaNew = em.merge(codpesquisaperguntaNew);
            }
            if (codpesquisarespostaOld != null && !codpesquisarespostaOld.equals(codpesquisarespostaNew)) {
                codpesquisarespostaOld.getOsPesquisaCollection().remove(osPesquisa);
                codpesquisarespostaOld = em.merge(codpesquisarespostaOld);
            }
            if (codpesquisarespostaNew != null && !codpesquisarespostaNew.equals(codpesquisarespostaOld)) {
                codpesquisarespostaNew.getOsPesquisaCollection().add(osPesquisa);
                codpesquisarespostaNew = em.merge(codpesquisarespostaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osPesquisa.getCodospesquisa();
                if (findOsPesquisa(id) == null) {
                    throw new NonexistentEntityException("The osPesquisa with id " + id + " no longer exists.");
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
            OsPesquisa osPesquisa;
            try {
                osPesquisa = em.getReference(OsPesquisa.class, id);
                osPesquisa.getCodospesquisa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osPesquisa with id " + id + " no longer exists.", enfe);
            }
            OsOrdemservico codos = osPesquisa.getCodos();
            if (codos != null) {
                codos.getOsPesquisaCollection().remove(osPesquisa);
                codos = em.merge(codos);
            }
            OsPesquisapergunta codpesquisapergunta = osPesquisa.getCodpesquisapergunta();
            if (codpesquisapergunta != null) {
                codpesquisapergunta.getOsPesquisaCollection().remove(osPesquisa);
                codpesquisapergunta = em.merge(codpesquisapergunta);
            }
            OsPesquisaresposta codpesquisaresposta = osPesquisa.getCodpesquisaresposta();
            if (codpesquisaresposta != null) {
                codpesquisaresposta.getOsPesquisaCollection().remove(osPesquisa);
                codpesquisaresposta = em.merge(codpesquisaresposta);
            }
            em.remove(osPesquisa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsPesquisa> findOsPesquisaEntities() {
        return findOsPesquisaEntities(true, -1, -1);
    }

    public List<OsPesquisa> findOsPesquisaEntities(int maxResults, int firstResult) {
        return findOsPesquisaEntities(false, maxResults, firstResult);
    }

    private List<OsPesquisa> findOsPesquisaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsPesquisa.class));
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

    public OsPesquisa findOsPesquisa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsPesquisa.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsPesquisaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsPesquisa> rt = cq.from(OsPesquisa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
