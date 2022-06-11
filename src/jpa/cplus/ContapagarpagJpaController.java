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
import entidade.cplus.Caixa;
import entidade.cplus.Chequesfirma;
import entidade.cplus.Contabancaria;
import entidade.cplus.Contapagar;
import entidade.cplus.Contapagarpag;
import entidade.cplus.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContapagarpagJpaController implements Serializable {

    public ContapagarpagJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contapagarpag contapagarpag) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixa codcaixa = contapagarpag.getCodcaixa();
            if (codcaixa != null) {
                codcaixa = em.getReference(codcaixa.getClass(), codcaixa.getCodcaixa());
                contapagarpag.setCodcaixa(codcaixa);
            }
            Chequesfirma codchequefirma = contapagarpag.getCodchequefirma();
            if (codchequefirma != null) {
                codchequefirma = em.getReference(codchequefirma.getClass(), codchequefirma.getCodchequefirma());
                contapagarpag.setCodchequefirma(codchequefirma);
            }
            Contabancaria codcontabancaria = contapagarpag.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                contapagarpag.setCodcontabancaria(codcontabancaria);
            }
            Contapagar codcp = contapagarpag.getCodcp();
            if (codcp != null) {
                codcp = em.getReference(codcp.getClass(), codcp.getCodcp());
                contapagarpag.setCodcp(codcp);
            }
            Empresa codempresa = contapagarpag.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contapagarpag.setCodempresa(codempresa);
            }
            em.persist(contapagarpag);
            if (codcaixa != null) {
                codcaixa.getContapagarpagCollection().add(contapagarpag);
                codcaixa = em.merge(codcaixa);
            }
            if (codchequefirma != null) {
                codchequefirma.getContapagarpagCollection().add(contapagarpag);
                codchequefirma = em.merge(codchequefirma);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getContapagarpagCollection().add(contapagarpag);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codcp != null) {
                codcp.getContapagarpagCollection().add(contapagarpag);
                codcp = em.merge(codcp);
            }
            if (codempresa != null) {
                codempresa.getContapagarpagCollection().add(contapagarpag);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContapagarpag(contapagarpag.getId()) != null) {
                throw new PreexistingEntityException("Contapagarpag " + contapagarpag + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contapagarpag contapagarpag) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contapagarpag persistentContapagarpag = em.find(Contapagarpag.class, contapagarpag.getId());
            Caixa codcaixaOld = persistentContapagarpag.getCodcaixa();
            Caixa codcaixaNew = contapagarpag.getCodcaixa();
            Chequesfirma codchequefirmaOld = persistentContapagarpag.getCodchequefirma();
            Chequesfirma codchequefirmaNew = contapagarpag.getCodchequefirma();
            Contabancaria codcontabancariaOld = persistentContapagarpag.getCodcontabancaria();
            Contabancaria codcontabancariaNew = contapagarpag.getCodcontabancaria();
            Contapagar codcpOld = persistentContapagarpag.getCodcp();
            Contapagar codcpNew = contapagarpag.getCodcp();
            Empresa codempresaOld = persistentContapagarpag.getCodempresa();
            Empresa codempresaNew = contapagarpag.getCodempresa();
            if (codcaixaNew != null) {
                codcaixaNew = em.getReference(codcaixaNew.getClass(), codcaixaNew.getCodcaixa());
                contapagarpag.setCodcaixa(codcaixaNew);
            }
            if (codchequefirmaNew != null) {
                codchequefirmaNew = em.getReference(codchequefirmaNew.getClass(), codchequefirmaNew.getCodchequefirma());
                contapagarpag.setCodchequefirma(codchequefirmaNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                contapagarpag.setCodcontabancaria(codcontabancariaNew);
            }
            if (codcpNew != null) {
                codcpNew = em.getReference(codcpNew.getClass(), codcpNew.getCodcp());
                contapagarpag.setCodcp(codcpNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contapagarpag.setCodempresa(codempresaNew);
            }
            contapagarpag = em.merge(contapagarpag);
            if (codcaixaOld != null && !codcaixaOld.equals(codcaixaNew)) {
                codcaixaOld.getContapagarpagCollection().remove(contapagarpag);
                codcaixaOld = em.merge(codcaixaOld);
            }
            if (codcaixaNew != null && !codcaixaNew.equals(codcaixaOld)) {
                codcaixaNew.getContapagarpagCollection().add(contapagarpag);
                codcaixaNew = em.merge(codcaixaNew);
            }
            if (codchequefirmaOld != null && !codchequefirmaOld.equals(codchequefirmaNew)) {
                codchequefirmaOld.getContapagarpagCollection().remove(contapagarpag);
                codchequefirmaOld = em.merge(codchequefirmaOld);
            }
            if (codchequefirmaNew != null && !codchequefirmaNew.equals(codchequefirmaOld)) {
                codchequefirmaNew.getContapagarpagCollection().add(contapagarpag);
                codchequefirmaNew = em.merge(codchequefirmaNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getContapagarpagCollection().remove(contapagarpag);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getContapagarpagCollection().add(contapagarpag);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codcpOld != null && !codcpOld.equals(codcpNew)) {
                codcpOld.getContapagarpagCollection().remove(contapagarpag);
                codcpOld = em.merge(codcpOld);
            }
            if (codcpNew != null && !codcpNew.equals(codcpOld)) {
                codcpNew.getContapagarpagCollection().add(contapagarpag);
                codcpNew = em.merge(codcpNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContapagarpagCollection().remove(contapagarpag);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContapagarpagCollection().add(contapagarpag);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contapagarpag.getId();
                if (findContapagarpag(id) == null) {
                    throw new NonexistentEntityException("The contapagarpag with id " + id + " no longer exists.");
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
            Contapagarpag contapagarpag;
            try {
                contapagarpag = em.getReference(Contapagarpag.class, id);
                contapagarpag.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contapagarpag with id " + id + " no longer exists.", enfe);
            }
            Caixa codcaixa = contapagarpag.getCodcaixa();
            if (codcaixa != null) {
                codcaixa.getContapagarpagCollection().remove(contapagarpag);
                codcaixa = em.merge(codcaixa);
            }
            Chequesfirma codchequefirma = contapagarpag.getCodchequefirma();
            if (codchequefirma != null) {
                codchequefirma.getContapagarpagCollection().remove(contapagarpag);
                codchequefirma = em.merge(codchequefirma);
            }
            Contabancaria codcontabancaria = contapagarpag.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getContapagarpagCollection().remove(contapagarpag);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Contapagar codcp = contapagarpag.getCodcp();
            if (codcp != null) {
                codcp.getContapagarpagCollection().remove(contapagarpag);
                codcp = em.merge(codcp);
            }
            Empresa codempresa = contapagarpag.getCodempresa();
            if (codempresa != null) {
                codempresa.getContapagarpagCollection().remove(contapagarpag);
                codempresa = em.merge(codempresa);
            }
            em.remove(contapagarpag);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contapagarpag> findContapagarpagEntities() {
        return findContapagarpagEntities(true, -1, -1);
    }

    public List<Contapagarpag> findContapagarpagEntities(int maxResults, int firstResult) {
        return findContapagarpagEntities(false, maxResults, firstResult);
    }

    private List<Contapagarpag> findContapagarpagEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contapagarpag.class));
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

    public Contapagarpag findContapagarpag(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contapagarpag.class, id);
        } finally {
            em.close();
        }
    }

    public int getContapagarpagCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contapagarpag> rt = cq.from(Contapagarpag.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
