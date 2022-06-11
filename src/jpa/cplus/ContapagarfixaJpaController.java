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
import entidade.cplus.Caixas;
import entidade.cplus.Centrocusto;
import entidade.cplus.Contapagarfixa;
import entidade.cplus.Fornecedor;
import entidade.cplus.Planoconta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContapagarfixaJpaController implements Serializable {

    public ContapagarfixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contapagarfixa contapagarfixa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixas codcaixas = contapagarfixa.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                contapagarfixa.setCodcaixas(codcaixas);
            }
            Centrocusto codcentrocusto = contapagarfixa.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                contapagarfixa.setCodcentrocusto(codcentrocusto);
            }
            Fornecedor codforn = contapagarfixa.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                contapagarfixa.setCodforn(codforn);
            }
            Planoconta codpc = contapagarfixa.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                contapagarfixa.setCodpc(codpc);
            }
            em.persist(contapagarfixa);
            if (codcaixas != null) {
                codcaixas.getContapagarfixaCollection().add(contapagarfixa);
                codcaixas = em.merge(codcaixas);
            }
            if (codcentrocusto != null) {
                codcentrocusto.getContapagarfixaCollection().add(contapagarfixa);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codforn != null) {
                codforn.getContapagarfixaCollection().add(contapagarfixa);
                codforn = em.merge(codforn);
            }
            if (codpc != null) {
                codpc.getContapagarfixaCollection().add(contapagarfixa);
                codpc = em.merge(codpc);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContapagarfixa(contapagarfixa.getCodcpfixa()) != null) {
                throw new PreexistingEntityException("Contapagarfixa " + contapagarfixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contapagarfixa contapagarfixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contapagarfixa persistentContapagarfixa = em.find(Contapagarfixa.class, contapagarfixa.getCodcpfixa());
            Caixas codcaixasOld = persistentContapagarfixa.getCodcaixas();
            Caixas codcaixasNew = contapagarfixa.getCodcaixas();
            Centrocusto codcentrocustoOld = persistentContapagarfixa.getCodcentrocusto();
            Centrocusto codcentrocustoNew = contapagarfixa.getCodcentrocusto();
            Fornecedor codfornOld = persistentContapagarfixa.getCodforn();
            Fornecedor codfornNew = contapagarfixa.getCodforn();
            Planoconta codpcOld = persistentContapagarfixa.getCodpc();
            Planoconta codpcNew = contapagarfixa.getCodpc();
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                contapagarfixa.setCodcaixas(codcaixasNew);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                contapagarfixa.setCodcentrocusto(codcentrocustoNew);
            }
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                contapagarfixa.setCodforn(codfornNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                contapagarfixa.setCodpc(codpcNew);
            }
            contapagarfixa = em.merge(contapagarfixa);
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getContapagarfixaCollection().remove(contapagarfixa);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getContapagarfixaCollection().add(contapagarfixa);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getContapagarfixaCollection().remove(contapagarfixa);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getContapagarfixaCollection().add(contapagarfixa);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getContapagarfixaCollection().remove(contapagarfixa);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getContapagarfixaCollection().add(contapagarfixa);
                codfornNew = em.merge(codfornNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getContapagarfixaCollection().remove(contapagarfixa);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getContapagarfixaCollection().add(contapagarfixa);
                codpcNew = em.merge(codpcNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contapagarfixa.getCodcpfixa();
                if (findContapagarfixa(id) == null) {
                    throw new NonexistentEntityException("The contapagarfixa with id " + id + " no longer exists.");
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
            Contapagarfixa contapagarfixa;
            try {
                contapagarfixa = em.getReference(Contapagarfixa.class, id);
                contapagarfixa.getCodcpfixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contapagarfixa with id " + id + " no longer exists.", enfe);
            }
            Caixas codcaixas = contapagarfixa.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getContapagarfixaCollection().remove(contapagarfixa);
                codcaixas = em.merge(codcaixas);
            }
            Centrocusto codcentrocusto = contapagarfixa.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getContapagarfixaCollection().remove(contapagarfixa);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Fornecedor codforn = contapagarfixa.getCodforn();
            if (codforn != null) {
                codforn.getContapagarfixaCollection().remove(contapagarfixa);
                codforn = em.merge(codforn);
            }
            Planoconta codpc = contapagarfixa.getCodpc();
            if (codpc != null) {
                codpc.getContapagarfixaCollection().remove(contapagarfixa);
                codpc = em.merge(codpc);
            }
            em.remove(contapagarfixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contapagarfixa> findContapagarfixaEntities() {
        return findContapagarfixaEntities(true, -1, -1);
    }

    public List<Contapagarfixa> findContapagarfixaEntities(int maxResults, int firstResult) {
        return findContapagarfixaEntities(false, maxResults, firstResult);
    }

    private List<Contapagarfixa> findContapagarfixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contapagarfixa.class));
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

    public Contapagarfixa findContapagarfixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contapagarfixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getContapagarfixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contapagarfixa> rt = cq.from(Contapagarfixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
