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
import entidade.cplus.Contareceber;
import entidade.cplus.Empresa;
import entidade.cplus.Lancacartao;
import entidade.cplus.Movenda;
import entidade.cplus.Tipocartao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class LancacartaoJpaController implements Serializable {

    public LancacartaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lancacartao lancacartao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = lancacartao.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                lancacartao.setCodcli(codcli);
            }
            Contareceber codcr = lancacartao.getCodcr();
            if (codcr != null) {
                codcr = em.getReference(codcr.getClass(), codcr.getCodcr());
                lancacartao.setCodcr(codcr);
            }
            Empresa codempresa = lancacartao.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                lancacartao.setCodempresa(codempresa);
            }
            Movenda codmovenda = lancacartao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                lancacartao.setCodmovenda(codmovenda);
            }
            Tipocartao codcar = lancacartao.getCodcar();
            if (codcar != null) {
                codcar = em.getReference(codcar.getClass(), codcar.getCodcar());
                lancacartao.setCodcar(codcar);
            }
            em.persist(lancacartao);
            if (codcli != null) {
                codcli.getLancacartaoCollection().add(lancacartao);
                codcli = em.merge(codcli);
            }
            if (codcr != null) {
                codcr.getLancacartaoCollection().add(lancacartao);
                codcr = em.merge(codcr);
            }
            if (codempresa != null) {
                codempresa.getLancacartaoCollection().add(lancacartao);
                codempresa = em.merge(codempresa);
            }
            if (codmovenda != null) {
                codmovenda.getLancacartaoCollection().add(lancacartao);
                codmovenda = em.merge(codmovenda);
            }
            if (codcar != null) {
                codcar.getLancacartaoCollection().add(lancacartao);
                codcar = em.merge(codcar);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLancacartao(lancacartao.getCodlcar()) != null) {
                throw new PreexistingEntityException("Lancacartao " + lancacartao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lancacartao lancacartao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lancacartao persistentLancacartao = em.find(Lancacartao.class, lancacartao.getCodlcar());
            Cliente codcliOld = persistentLancacartao.getCodcli();
            Cliente codcliNew = lancacartao.getCodcli();
            Contareceber codcrOld = persistentLancacartao.getCodcr();
            Contareceber codcrNew = lancacartao.getCodcr();
            Empresa codempresaOld = persistentLancacartao.getCodempresa();
            Empresa codempresaNew = lancacartao.getCodempresa();
            Movenda codmovendaOld = persistentLancacartao.getCodmovenda();
            Movenda codmovendaNew = lancacartao.getCodmovenda();
            Tipocartao codcarOld = persistentLancacartao.getCodcar();
            Tipocartao codcarNew = lancacartao.getCodcar();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                lancacartao.setCodcli(codcliNew);
            }
            if (codcrNew != null) {
                codcrNew = em.getReference(codcrNew.getClass(), codcrNew.getCodcr());
                lancacartao.setCodcr(codcrNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                lancacartao.setCodempresa(codempresaNew);
            }
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                lancacartao.setCodmovenda(codmovendaNew);
            }
            if (codcarNew != null) {
                codcarNew = em.getReference(codcarNew.getClass(), codcarNew.getCodcar());
                lancacartao.setCodcar(codcarNew);
            }
            lancacartao = em.merge(lancacartao);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getLancacartaoCollection().remove(lancacartao);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getLancacartaoCollection().add(lancacartao);
                codcliNew = em.merge(codcliNew);
            }
            if (codcrOld != null && !codcrOld.equals(codcrNew)) {
                codcrOld.getLancacartaoCollection().remove(lancacartao);
                codcrOld = em.merge(codcrOld);
            }
            if (codcrNew != null && !codcrNew.equals(codcrOld)) {
                codcrNew.getLancacartaoCollection().add(lancacartao);
                codcrNew = em.merge(codcrNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getLancacartaoCollection().remove(lancacartao);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getLancacartaoCollection().add(lancacartao);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getLancacartaoCollection().remove(lancacartao);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getLancacartaoCollection().add(lancacartao);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codcarOld != null && !codcarOld.equals(codcarNew)) {
                codcarOld.getLancacartaoCollection().remove(lancacartao);
                codcarOld = em.merge(codcarOld);
            }
            if (codcarNew != null && !codcarNew.equals(codcarOld)) {
                codcarNew.getLancacartaoCollection().add(lancacartao);
                codcarNew = em.merge(codcarNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lancacartao.getCodlcar();
                if (findLancacartao(id) == null) {
                    throw new NonexistentEntityException("The lancacartao with id " + id + " no longer exists.");
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
            Lancacartao lancacartao;
            try {
                lancacartao = em.getReference(Lancacartao.class, id);
                lancacartao.getCodlcar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lancacartao with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = lancacartao.getCodcli();
            if (codcli != null) {
                codcli.getLancacartaoCollection().remove(lancacartao);
                codcli = em.merge(codcli);
            }
            Contareceber codcr = lancacartao.getCodcr();
            if (codcr != null) {
                codcr.getLancacartaoCollection().remove(lancacartao);
                codcr = em.merge(codcr);
            }
            Empresa codempresa = lancacartao.getCodempresa();
            if (codempresa != null) {
                codempresa.getLancacartaoCollection().remove(lancacartao);
                codempresa = em.merge(codempresa);
            }
            Movenda codmovenda = lancacartao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getLancacartaoCollection().remove(lancacartao);
                codmovenda = em.merge(codmovenda);
            }
            Tipocartao codcar = lancacartao.getCodcar();
            if (codcar != null) {
                codcar.getLancacartaoCollection().remove(lancacartao);
                codcar = em.merge(codcar);
            }
            em.remove(lancacartao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lancacartao> findLancacartaoEntities() {
        return findLancacartaoEntities(true, -1, -1);
    }

    public List<Lancacartao> findLancacartaoEntities(int maxResults, int firstResult) {
        return findLancacartaoEntities(false, maxResults, firstResult);
    }

    private List<Lancacartao> findLancacartaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lancacartao.class));
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

    public Lancacartao findLancacartao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lancacartao.class, id);
        } finally {
            em.close();
        }
    }

    public int getLancacartaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lancacartao> rt = cq.from(Lancacartao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
