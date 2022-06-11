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
import entidade.cplus.Contareceberrec;
import entidade.cplus.Documentocaixa;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Vale;
import entidade.cplus.Movimentocaixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentocaixaJpaController implements Serializable {

    public DocumentocaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentocaixa documentocaixa) throws PreexistingEntityException, Exception {
        if (documentocaixa.getContareceberrecCollection() == null) {
            documentocaixa.setContareceberrecCollection(new ArrayList<Contareceberrec>());
        }
        if (documentocaixa.getValeCollection() == null) {
            documentocaixa.setValeCollection(new ArrayList<Vale>());
        }
        if (documentocaixa.getValeCollection1() == null) {
            documentocaixa.setValeCollection1(new ArrayList<Vale>());
        }
        if (documentocaixa.getMovimentocaixaCollection() == null) {
            documentocaixa.setMovimentocaixaCollection(new ArrayList<Movimentocaixa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Contareceberrec> attachedContareceberrecCollection = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionContareceberrecToAttach : documentocaixa.getContareceberrecCollection()) {
                contareceberrecCollectionContareceberrecToAttach = em.getReference(contareceberrecCollectionContareceberrecToAttach.getClass(), contareceberrecCollectionContareceberrecToAttach.getId());
                attachedContareceberrecCollection.add(contareceberrecCollectionContareceberrecToAttach);
            }
            documentocaixa.setContareceberrecCollection(attachedContareceberrecCollection);
            Collection<Vale> attachedValeCollection = new ArrayList<Vale>();
            for (Vale valeCollectionValeToAttach : documentocaixa.getValeCollection()) {
                valeCollectionValeToAttach = em.getReference(valeCollectionValeToAttach.getClass(), valeCollectionValeToAttach.getCodvale());
                attachedValeCollection.add(valeCollectionValeToAttach);
            }
            documentocaixa.setValeCollection(attachedValeCollection);
            Collection<Vale> attachedValeCollection1 = new ArrayList<Vale>();
            for (Vale valeCollection1ValeToAttach : documentocaixa.getValeCollection1()) {
                valeCollection1ValeToAttach = em.getReference(valeCollection1ValeToAttach.getClass(), valeCollection1ValeToAttach.getCodvale());
                attachedValeCollection1.add(valeCollection1ValeToAttach);
            }
            documentocaixa.setValeCollection1(attachedValeCollection1);
            Collection<Movimentocaixa> attachedMovimentocaixaCollection = new ArrayList<Movimentocaixa>();
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixaToAttach : documentocaixa.getMovimentocaixaCollection()) {
                movimentocaixaCollectionMovimentocaixaToAttach = em.getReference(movimentocaixaCollectionMovimentocaixaToAttach.getClass(), movimentocaixaCollectionMovimentocaixaToAttach.getCodmovimentocaixa());
                attachedMovimentocaixaCollection.add(movimentocaixaCollectionMovimentocaixaToAttach);
            }
            documentocaixa.setMovimentocaixaCollection(attachedMovimentocaixaCollection);
            em.persist(documentocaixa);
            for (Contareceberrec contareceberrecCollectionContareceberrec : documentocaixa.getContareceberrecCollection()) {
                Documentocaixa oldCoddocumentocaixaOfContareceberrecCollectionContareceberrec = contareceberrecCollectionContareceberrec.getCoddocumentocaixa();
                contareceberrecCollectionContareceberrec.setCoddocumentocaixa(documentocaixa);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
                if (oldCoddocumentocaixaOfContareceberrecCollectionContareceberrec != null) {
                    oldCoddocumentocaixaOfContareceberrecCollectionContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionContareceberrec);
                    oldCoddocumentocaixaOfContareceberrecCollectionContareceberrec = em.merge(oldCoddocumentocaixaOfContareceberrecCollectionContareceberrec);
                }
            }
            for (Vale valeCollectionVale : documentocaixa.getValeCollection()) {
                Documentocaixa oldCoddocumentocaixaOfValeCollectionVale = valeCollectionVale.getCoddocumentocaixa();
                valeCollectionVale.setCoddocumentocaixa(documentocaixa);
                valeCollectionVale = em.merge(valeCollectionVale);
                if (oldCoddocumentocaixaOfValeCollectionVale != null) {
                    oldCoddocumentocaixaOfValeCollectionVale.getValeCollection().remove(valeCollectionVale);
                    oldCoddocumentocaixaOfValeCollectionVale = em.merge(oldCoddocumentocaixaOfValeCollectionVale);
                }
            }
            for (Vale valeCollection1Vale : documentocaixa.getValeCollection1()) {
                Documentocaixa oldCoddocumentocaixabaixaOfValeCollection1Vale = valeCollection1Vale.getCoddocumentocaixabaixa();
                valeCollection1Vale.setCoddocumentocaixabaixa(documentocaixa);
                valeCollection1Vale = em.merge(valeCollection1Vale);
                if (oldCoddocumentocaixabaixaOfValeCollection1Vale != null) {
                    oldCoddocumentocaixabaixaOfValeCollection1Vale.getValeCollection1().remove(valeCollection1Vale);
                    oldCoddocumentocaixabaixaOfValeCollection1Vale = em.merge(oldCoddocumentocaixabaixaOfValeCollection1Vale);
                }
            }
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixa : documentocaixa.getMovimentocaixaCollection()) {
                Documentocaixa oldCoddocumentocaixaOfMovimentocaixaCollectionMovimentocaixa = movimentocaixaCollectionMovimentocaixa.getCoddocumentocaixa();
                movimentocaixaCollectionMovimentocaixa.setCoddocumentocaixa(documentocaixa);
                movimentocaixaCollectionMovimentocaixa = em.merge(movimentocaixaCollectionMovimentocaixa);
                if (oldCoddocumentocaixaOfMovimentocaixaCollectionMovimentocaixa != null) {
                    oldCoddocumentocaixaOfMovimentocaixaCollectionMovimentocaixa.getMovimentocaixaCollection().remove(movimentocaixaCollectionMovimentocaixa);
                    oldCoddocumentocaixaOfMovimentocaixaCollectionMovimentocaixa = em.merge(oldCoddocumentocaixaOfMovimentocaixaCollectionMovimentocaixa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentocaixa(documentocaixa.getCoddocumentocaixa()) != null) {
                throw new PreexistingEntityException("Documentocaixa " + documentocaixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentocaixa documentocaixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentocaixa persistentDocumentocaixa = em.find(Documentocaixa.class, documentocaixa.getCoddocumentocaixa());
            Collection<Contareceberrec> contareceberrecCollectionOld = persistentDocumentocaixa.getContareceberrecCollection();
            Collection<Contareceberrec> contareceberrecCollectionNew = documentocaixa.getContareceberrecCollection();
            Collection<Vale> valeCollectionOld = persistentDocumentocaixa.getValeCollection();
            Collection<Vale> valeCollectionNew = documentocaixa.getValeCollection();
            Collection<Vale> valeCollection1Old = persistentDocumentocaixa.getValeCollection1();
            Collection<Vale> valeCollection1New = documentocaixa.getValeCollection1();
            Collection<Movimentocaixa> movimentocaixaCollectionOld = persistentDocumentocaixa.getMovimentocaixaCollection();
            Collection<Movimentocaixa> movimentocaixaCollectionNew = documentocaixa.getMovimentocaixaCollection();
            Collection<Contareceberrec> attachedContareceberrecCollectionNew = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionNewContareceberrecToAttach : contareceberrecCollectionNew) {
                contareceberrecCollectionNewContareceberrecToAttach = em.getReference(contareceberrecCollectionNewContareceberrecToAttach.getClass(), contareceberrecCollectionNewContareceberrecToAttach.getId());
                attachedContareceberrecCollectionNew.add(contareceberrecCollectionNewContareceberrecToAttach);
            }
            contareceberrecCollectionNew = attachedContareceberrecCollectionNew;
            documentocaixa.setContareceberrecCollection(contareceberrecCollectionNew);
            Collection<Vale> attachedValeCollectionNew = new ArrayList<Vale>();
            for (Vale valeCollectionNewValeToAttach : valeCollectionNew) {
                valeCollectionNewValeToAttach = em.getReference(valeCollectionNewValeToAttach.getClass(), valeCollectionNewValeToAttach.getCodvale());
                attachedValeCollectionNew.add(valeCollectionNewValeToAttach);
            }
            valeCollectionNew = attachedValeCollectionNew;
            documentocaixa.setValeCollection(valeCollectionNew);
            Collection<Vale> attachedValeCollection1New = new ArrayList<Vale>();
            for (Vale valeCollection1NewValeToAttach : valeCollection1New) {
                valeCollection1NewValeToAttach = em.getReference(valeCollection1NewValeToAttach.getClass(), valeCollection1NewValeToAttach.getCodvale());
                attachedValeCollection1New.add(valeCollection1NewValeToAttach);
            }
            valeCollection1New = attachedValeCollection1New;
            documentocaixa.setValeCollection1(valeCollection1New);
            Collection<Movimentocaixa> attachedMovimentocaixaCollectionNew = new ArrayList<Movimentocaixa>();
            for (Movimentocaixa movimentocaixaCollectionNewMovimentocaixaToAttach : movimentocaixaCollectionNew) {
                movimentocaixaCollectionNewMovimentocaixaToAttach = em.getReference(movimentocaixaCollectionNewMovimentocaixaToAttach.getClass(), movimentocaixaCollectionNewMovimentocaixaToAttach.getCodmovimentocaixa());
                attachedMovimentocaixaCollectionNew.add(movimentocaixaCollectionNewMovimentocaixaToAttach);
            }
            movimentocaixaCollectionNew = attachedMovimentocaixaCollectionNew;
            documentocaixa.setMovimentocaixaCollection(movimentocaixaCollectionNew);
            documentocaixa = em.merge(documentocaixa);
            for (Contareceberrec contareceberrecCollectionOldContareceberrec : contareceberrecCollectionOld) {
                if (!contareceberrecCollectionNew.contains(contareceberrecCollectionOldContareceberrec)) {
                    contareceberrecCollectionOldContareceberrec.setCoddocumentocaixa(null);
                    contareceberrecCollectionOldContareceberrec = em.merge(contareceberrecCollectionOldContareceberrec);
                }
            }
            for (Contareceberrec contareceberrecCollectionNewContareceberrec : contareceberrecCollectionNew) {
                if (!contareceberrecCollectionOld.contains(contareceberrecCollectionNewContareceberrec)) {
                    Documentocaixa oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec = contareceberrecCollectionNewContareceberrec.getCoddocumentocaixa();
                    contareceberrecCollectionNewContareceberrec.setCoddocumentocaixa(documentocaixa);
                    contareceberrecCollectionNewContareceberrec = em.merge(contareceberrecCollectionNewContareceberrec);
                    if (oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec != null && !oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec.equals(documentocaixa)) {
                        oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionNewContareceberrec);
                        oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec = em.merge(oldCoddocumentocaixaOfContareceberrecCollectionNewContareceberrec);
                    }
                }
            }
            for (Vale valeCollectionOldVale : valeCollectionOld) {
                if (!valeCollectionNew.contains(valeCollectionOldVale)) {
                    valeCollectionOldVale.setCoddocumentocaixa(null);
                    valeCollectionOldVale = em.merge(valeCollectionOldVale);
                }
            }
            for (Vale valeCollectionNewVale : valeCollectionNew) {
                if (!valeCollectionOld.contains(valeCollectionNewVale)) {
                    Documentocaixa oldCoddocumentocaixaOfValeCollectionNewVale = valeCollectionNewVale.getCoddocumentocaixa();
                    valeCollectionNewVale.setCoddocumentocaixa(documentocaixa);
                    valeCollectionNewVale = em.merge(valeCollectionNewVale);
                    if (oldCoddocumentocaixaOfValeCollectionNewVale != null && !oldCoddocumentocaixaOfValeCollectionNewVale.equals(documentocaixa)) {
                        oldCoddocumentocaixaOfValeCollectionNewVale.getValeCollection().remove(valeCollectionNewVale);
                        oldCoddocumentocaixaOfValeCollectionNewVale = em.merge(oldCoddocumentocaixaOfValeCollectionNewVale);
                    }
                }
            }
            for (Vale valeCollection1OldVale : valeCollection1Old) {
                if (!valeCollection1New.contains(valeCollection1OldVale)) {
                    valeCollection1OldVale.setCoddocumentocaixabaixa(null);
                    valeCollection1OldVale = em.merge(valeCollection1OldVale);
                }
            }
            for (Vale valeCollection1NewVale : valeCollection1New) {
                if (!valeCollection1Old.contains(valeCollection1NewVale)) {
                    Documentocaixa oldCoddocumentocaixabaixaOfValeCollection1NewVale = valeCollection1NewVale.getCoddocumentocaixabaixa();
                    valeCollection1NewVale.setCoddocumentocaixabaixa(documentocaixa);
                    valeCollection1NewVale = em.merge(valeCollection1NewVale);
                    if (oldCoddocumentocaixabaixaOfValeCollection1NewVale != null && !oldCoddocumentocaixabaixaOfValeCollection1NewVale.equals(documentocaixa)) {
                        oldCoddocumentocaixabaixaOfValeCollection1NewVale.getValeCollection1().remove(valeCollection1NewVale);
                        oldCoddocumentocaixabaixaOfValeCollection1NewVale = em.merge(oldCoddocumentocaixabaixaOfValeCollection1NewVale);
                    }
                }
            }
            for (Movimentocaixa movimentocaixaCollectionOldMovimentocaixa : movimentocaixaCollectionOld) {
                if (!movimentocaixaCollectionNew.contains(movimentocaixaCollectionOldMovimentocaixa)) {
                    movimentocaixaCollectionOldMovimentocaixa.setCoddocumentocaixa(null);
                    movimentocaixaCollectionOldMovimentocaixa = em.merge(movimentocaixaCollectionOldMovimentocaixa);
                }
            }
            for (Movimentocaixa movimentocaixaCollectionNewMovimentocaixa : movimentocaixaCollectionNew) {
                if (!movimentocaixaCollectionOld.contains(movimentocaixaCollectionNewMovimentocaixa)) {
                    Documentocaixa oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa = movimentocaixaCollectionNewMovimentocaixa.getCoddocumentocaixa();
                    movimentocaixaCollectionNewMovimentocaixa.setCoddocumentocaixa(documentocaixa);
                    movimentocaixaCollectionNewMovimentocaixa = em.merge(movimentocaixaCollectionNewMovimentocaixa);
                    if (oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa != null && !oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa.equals(documentocaixa)) {
                        oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa.getMovimentocaixaCollection().remove(movimentocaixaCollectionNewMovimentocaixa);
                        oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa = em.merge(oldCoddocumentocaixaOfMovimentocaixaCollectionNewMovimentocaixa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentocaixa.getCoddocumentocaixa();
                if (findDocumentocaixa(id) == null) {
                    throw new NonexistentEntityException("The documentocaixa with id " + id + " no longer exists.");
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
            Documentocaixa documentocaixa;
            try {
                documentocaixa = em.getReference(Documentocaixa.class, id);
                documentocaixa.getCoddocumentocaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentocaixa with id " + id + " no longer exists.", enfe);
            }
            Collection<Contareceberrec> contareceberrecCollection = documentocaixa.getContareceberrecCollection();
            for (Contareceberrec contareceberrecCollectionContareceberrec : contareceberrecCollection) {
                contareceberrecCollectionContareceberrec.setCoddocumentocaixa(null);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
            }
            Collection<Vale> valeCollection = documentocaixa.getValeCollection();
            for (Vale valeCollectionVale : valeCollection) {
                valeCollectionVale.setCoddocumentocaixa(null);
                valeCollectionVale = em.merge(valeCollectionVale);
            }
            Collection<Vale> valeCollection1 = documentocaixa.getValeCollection1();
            for (Vale valeCollection1Vale : valeCollection1) {
                valeCollection1Vale.setCoddocumentocaixabaixa(null);
                valeCollection1Vale = em.merge(valeCollection1Vale);
            }
            Collection<Movimentocaixa> movimentocaixaCollection = documentocaixa.getMovimentocaixaCollection();
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixa : movimentocaixaCollection) {
                movimentocaixaCollectionMovimentocaixa.setCoddocumentocaixa(null);
                movimentocaixaCollectionMovimentocaixa = em.merge(movimentocaixaCollectionMovimentocaixa);
            }
            em.remove(documentocaixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentocaixa> findDocumentocaixaEntities() {
        return findDocumentocaixaEntities(true, -1, -1);
    }

    public List<Documentocaixa> findDocumentocaixaEntities(int maxResults, int firstResult) {
        return findDocumentocaixaEntities(false, maxResults, firstResult);
    }

    private List<Documentocaixa> findDocumentocaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentocaixa.class));
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

    public Documentocaixa findDocumentocaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentocaixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentocaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentocaixa> rt = cq.from(Documentocaixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
