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
import entidade.cplus.Empresa;
import entidade.cplus.Lancafinanceira;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class LancafinanceiraJpaController implements Serializable {

    public LancafinanceiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lancafinanceira lancafinanceira) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = lancafinanceira.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                lancafinanceira.setCodcli(codcli);
            }
            Empresa codempresa = lancafinanceira.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                lancafinanceira.setCodempresa(codempresa);
            }
            em.persist(lancafinanceira);
            if (codcli != null) {
                codcli.getLancafinanceiraCollection().add(lancafinanceira);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getLancafinanceiraCollection().add(lancafinanceira);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLancafinanceira(lancafinanceira.getCodlfin()) != null) {
                throw new PreexistingEntityException("Lancafinanceira " + lancafinanceira + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lancafinanceira lancafinanceira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lancafinanceira persistentLancafinanceira = em.find(Lancafinanceira.class, lancafinanceira.getCodlfin());
            Cliente codcliOld = persistentLancafinanceira.getCodcli();
            Cliente codcliNew = lancafinanceira.getCodcli();
            Empresa codempresaOld = persistentLancafinanceira.getCodempresa();
            Empresa codempresaNew = lancafinanceira.getCodempresa();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                lancafinanceira.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                lancafinanceira.setCodempresa(codempresaNew);
            }
            lancafinanceira = em.merge(lancafinanceira);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getLancafinanceiraCollection().remove(lancafinanceira);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getLancafinanceiraCollection().add(lancafinanceira);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getLancafinanceiraCollection().remove(lancafinanceira);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getLancafinanceiraCollection().add(lancafinanceira);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lancafinanceira.getCodlfin();
                if (findLancafinanceira(id) == null) {
                    throw new NonexistentEntityException("The lancafinanceira with id " + id + " no longer exists.");
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
            Lancafinanceira lancafinanceira;
            try {
                lancafinanceira = em.getReference(Lancafinanceira.class, id);
                lancafinanceira.getCodlfin();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lancafinanceira with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = lancafinanceira.getCodcli();
            if (codcli != null) {
                codcli.getLancafinanceiraCollection().remove(lancafinanceira);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = lancafinanceira.getCodempresa();
            if (codempresa != null) {
                codempresa.getLancafinanceiraCollection().remove(lancafinanceira);
                codempresa = em.merge(codempresa);
            }
            em.remove(lancafinanceira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lancafinanceira> findLancafinanceiraEntities() {
        return findLancafinanceiraEntities(true, -1, -1);
    }

    public List<Lancafinanceira> findLancafinanceiraEntities(int maxResults, int firstResult) {
        return findLancafinanceiraEntities(false, maxResults, firstResult);
    }

    private List<Lancafinanceira> findLancafinanceiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lancafinanceira.class));
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

    public Lancafinanceira findLancafinanceira(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lancafinanceira.class, id);
        } finally {
            em.close();
        }
    }

    public int getLancafinanceiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lancafinanceira> rt = cq.from(Lancafinanceira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
