/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Consignacaobaixa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movendaprod;
import entidade.cplus.Moventrada;
import entidade.cplus.Produtolote;
import entidade.cplus.Produtoserial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConsignacaobaixaJpaController implements Serializable {

    public ConsignacaobaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consignacaobaixa consignacaobaixa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = consignacaobaixa.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                consignacaobaixa.setCodmovprod(codmovprod);
            }
            Moventrada codmoventrdevolucao = consignacaobaixa.getCodmoventrdevolucao();
            if (codmoventrdevolucao != null) {
                codmoventrdevolucao = em.getReference(codmoventrdevolucao.getClass(), codmoventrdevolucao.getCodmoventr());
                consignacaobaixa.setCodmoventrdevolucao(codmoventrdevolucao);
            }
            Produtolote codprodutolote = consignacaobaixa.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                consignacaobaixa.setCodprodutolote(codprodutolote);
            }
            Produtoserial codprodutoserial = consignacaobaixa.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial = em.getReference(codprodutoserial.getClass(), codprodutoserial.getCodprodutoserial());
                consignacaobaixa.setCodprodutoserial(codprodutoserial);
            }
            em.persist(consignacaobaixa);
            if (codmovprod != null) {
                codmovprod.getConsignacaobaixaCollection().add(consignacaobaixa);
                codmovprod = em.merge(codmovprod);
            }
            if (codmoventrdevolucao != null) {
                codmoventrdevolucao.getConsignacaobaixaCollection().add(consignacaobaixa);
                codmoventrdevolucao = em.merge(codmoventrdevolucao);
            }
            if (codprodutolote != null) {
                codprodutolote.getConsignacaobaixaCollection().add(consignacaobaixa);
                codprodutolote = em.merge(codprodutolote);
            }
            if (codprodutoserial != null) {
                codprodutoserial.getConsignacaobaixaCollection().add(consignacaobaixa);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsignacaobaixa(consignacaobaixa.getCodconsignacaobaixa()) != null) {
                throw new PreexistingEntityException("Consignacaobaixa " + consignacaobaixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consignacaobaixa consignacaobaixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consignacaobaixa persistentConsignacaobaixa = em.find(Consignacaobaixa.class, consignacaobaixa.getCodconsignacaobaixa());
            Movendaprod codmovprodOld = persistentConsignacaobaixa.getCodmovprod();
            Movendaprod codmovprodNew = consignacaobaixa.getCodmovprod();
            Moventrada codmoventrdevolucaoOld = persistentConsignacaobaixa.getCodmoventrdevolucao();
            Moventrada codmoventrdevolucaoNew = consignacaobaixa.getCodmoventrdevolucao();
            Produtolote codprodutoloteOld = persistentConsignacaobaixa.getCodprodutolote();
            Produtolote codprodutoloteNew = consignacaobaixa.getCodprodutolote();
            Produtoserial codprodutoserialOld = persistentConsignacaobaixa.getCodprodutoserial();
            Produtoserial codprodutoserialNew = consignacaobaixa.getCodprodutoserial();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                consignacaobaixa.setCodmovprod(codmovprodNew);
            }
            if (codmoventrdevolucaoNew != null) {
                codmoventrdevolucaoNew = em.getReference(codmoventrdevolucaoNew.getClass(), codmoventrdevolucaoNew.getCodmoventr());
                consignacaobaixa.setCodmoventrdevolucao(codmoventrdevolucaoNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                consignacaobaixa.setCodprodutolote(codprodutoloteNew);
            }
            if (codprodutoserialNew != null) {
                codprodutoserialNew = em.getReference(codprodutoserialNew.getClass(), codprodutoserialNew.getCodprodutoserial());
                consignacaobaixa.setCodprodutoserial(codprodutoserialNew);
            }
            consignacaobaixa = em.merge(consignacaobaixa);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getConsignacaobaixaCollection().add(consignacaobaixa);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codmoventrdevolucaoOld != null && !codmoventrdevolucaoOld.equals(codmoventrdevolucaoNew)) {
                codmoventrdevolucaoOld.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codmoventrdevolucaoOld = em.merge(codmoventrdevolucaoOld);
            }
            if (codmoventrdevolucaoNew != null && !codmoventrdevolucaoNew.equals(codmoventrdevolucaoOld)) {
                codmoventrdevolucaoNew.getConsignacaobaixaCollection().add(consignacaobaixa);
                codmoventrdevolucaoNew = em.merge(codmoventrdevolucaoNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getConsignacaobaixaCollection().add(consignacaobaixa);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            if (codprodutoserialOld != null && !codprodutoserialOld.equals(codprodutoserialNew)) {
                codprodutoserialOld.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codprodutoserialOld = em.merge(codprodutoserialOld);
            }
            if (codprodutoserialNew != null && !codprodutoserialNew.equals(codprodutoserialOld)) {
                codprodutoserialNew.getConsignacaobaixaCollection().add(consignacaobaixa);
                codprodutoserialNew = em.merge(codprodutoserialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consignacaobaixa.getCodconsignacaobaixa();
                if (findConsignacaobaixa(id) == null) {
                    throw new NonexistentEntityException("The consignacaobaixa with id " + id + " no longer exists.");
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
            Consignacaobaixa consignacaobaixa;
            try {
                consignacaobaixa = em.getReference(Consignacaobaixa.class, id);
                consignacaobaixa.getCodconsignacaobaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consignacaobaixa with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = consignacaobaixa.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codmovprod = em.merge(codmovprod);
            }
            Moventrada codmoventrdevolucao = consignacaobaixa.getCodmoventrdevolucao();
            if (codmoventrdevolucao != null) {
                codmoventrdevolucao.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codmoventrdevolucao = em.merge(codmoventrdevolucao);
            }
            Produtolote codprodutolote = consignacaobaixa.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codprodutolote = em.merge(codprodutolote);
            }
            Produtoserial codprodutoserial = consignacaobaixa.getCodprodutoserial();
            if (codprodutoserial != null) {
                codprodutoserial.getConsignacaobaixaCollection().remove(consignacaobaixa);
                codprodutoserial = em.merge(codprodutoserial);
            }
            em.remove(consignacaobaixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consignacaobaixa> findConsignacaobaixaEntities() {
        return findConsignacaobaixaEntities(true, -1, -1);
    }

    public List<Consignacaobaixa> findConsignacaobaixaEntities(int maxResults, int firstResult) {
        return findConsignacaobaixaEntities(false, maxResults, firstResult);
    }

    private List<Consignacaobaixa> findConsignacaobaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consignacaobaixa.class));
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

    public Consignacaobaixa findConsignacaobaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consignacaobaixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsignacaobaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consignacaobaixa> rt = cq.from(Consignacaobaixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
