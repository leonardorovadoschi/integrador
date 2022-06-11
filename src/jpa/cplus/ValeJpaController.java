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
import entidade.cplus.Cliente;
import entidade.cplus.Documentocaixa;
import entidade.cplus.Vale;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ValeJpaController implements Serializable {

    public ValeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vale vale) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = vale.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                vale.setCodcli(codcli);
            }
            Documentocaixa coddocumentocaixa = vale.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa = em.getReference(coddocumentocaixa.getClass(), coddocumentocaixa.getCoddocumentocaixa());
                vale.setCoddocumentocaixa(coddocumentocaixa);
            }
            Documentocaixa coddocumentocaixabaixa = vale.getCoddocumentocaixabaixa();
            if (coddocumentocaixabaixa != null) {
                coddocumentocaixabaixa = em.getReference(coddocumentocaixabaixa.getClass(), coddocumentocaixabaixa.getCoddocumentocaixa());
                vale.setCoddocumentocaixabaixa(coddocumentocaixabaixa);
            }
            em.persist(vale);
            if (codcli != null) {
                codcli.getValeCollection().add(vale);
                codcli = em.merge(codcli);
            }
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getValeCollection().add(vale);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            if (coddocumentocaixabaixa != null) {
                coddocumentocaixabaixa.getValeCollection().add(vale);
                coddocumentocaixabaixa = em.merge(coddocumentocaixabaixa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVale(vale.getCodvale()) != null) {
                throw new PreexistingEntityException("Vale " + vale + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vale vale) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vale persistentVale = em.find(Vale.class, vale.getCodvale());
            Cliente codcliOld = persistentVale.getCodcli();
            Cliente codcliNew = vale.getCodcli();
            Documentocaixa coddocumentocaixaOld = persistentVale.getCoddocumentocaixa();
            Documentocaixa coddocumentocaixaNew = vale.getCoddocumentocaixa();
            Documentocaixa coddocumentocaixabaixaOld = persistentVale.getCoddocumentocaixabaixa();
            Documentocaixa coddocumentocaixabaixaNew = vale.getCoddocumentocaixabaixa();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                vale.setCodcli(codcliNew);
            }
            if (coddocumentocaixaNew != null) {
                coddocumentocaixaNew = em.getReference(coddocumentocaixaNew.getClass(), coddocumentocaixaNew.getCoddocumentocaixa());
                vale.setCoddocumentocaixa(coddocumentocaixaNew);
            }
            if (coddocumentocaixabaixaNew != null) {
                coddocumentocaixabaixaNew = em.getReference(coddocumentocaixabaixaNew.getClass(), coddocumentocaixabaixaNew.getCoddocumentocaixa());
                vale.setCoddocumentocaixabaixa(coddocumentocaixabaixaNew);
            }
            vale = em.merge(vale);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getValeCollection().remove(vale);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getValeCollection().add(vale);
                codcliNew = em.merge(codcliNew);
            }
            if (coddocumentocaixaOld != null && !coddocumentocaixaOld.equals(coddocumentocaixaNew)) {
                coddocumentocaixaOld.getValeCollection().remove(vale);
                coddocumentocaixaOld = em.merge(coddocumentocaixaOld);
            }
            if (coddocumentocaixaNew != null && !coddocumentocaixaNew.equals(coddocumentocaixaOld)) {
                coddocumentocaixaNew.getValeCollection().add(vale);
                coddocumentocaixaNew = em.merge(coddocumentocaixaNew);
            }
            if (coddocumentocaixabaixaOld != null && !coddocumentocaixabaixaOld.equals(coddocumentocaixabaixaNew)) {
                coddocumentocaixabaixaOld.getValeCollection().remove(vale);
                coddocumentocaixabaixaOld = em.merge(coddocumentocaixabaixaOld);
            }
            if (coddocumentocaixabaixaNew != null && !coddocumentocaixabaixaNew.equals(coddocumentocaixabaixaOld)) {
                coddocumentocaixabaixaNew.getValeCollection().add(vale);
                coddocumentocaixabaixaNew = em.merge(coddocumentocaixabaixaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vale.getCodvale();
                if (findVale(id) == null) {
                    throw new NonexistentEntityException("The vale with id " + id + " no longer exists.");
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
            Vale vale;
            try {
                vale = em.getReference(Vale.class, id);
                vale.getCodvale();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vale with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = vale.getCodcli();
            if (codcli != null) {
                codcli.getValeCollection().remove(vale);
                codcli = em.merge(codcli);
            }
            Documentocaixa coddocumentocaixa = vale.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getValeCollection().remove(vale);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            Documentocaixa coddocumentocaixabaixa = vale.getCoddocumentocaixabaixa();
            if (coddocumentocaixabaixa != null) {
                coddocumentocaixabaixa.getValeCollection().remove(vale);
                coddocumentocaixabaixa = em.merge(coddocumentocaixabaixa);
            }
            em.remove(vale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vale> findValeEntities() {
        return findValeEntities(true, -1, -1);
    }

    public List<Vale> findValeEntities(int maxResults, int firstResult) {
        return findValeEntities(false, maxResults, firstResult);
    }

    private List<Vale> findValeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vale.class));
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

    public Vale findVale(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vale.class, id);
        } finally {
            em.close();
        }
    }

    public int getValeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vale> rt = cq.from(Vale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
