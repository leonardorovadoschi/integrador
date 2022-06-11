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
import entidade.cplus.Contabancaria;
import entidade.cplus.Contratocobranca;
import entidade.cplus.Empresa;
import entidade.cplus.Formapag;
import entidade.cplus.Contratocobrancaproduto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContratocobrancaJpaController implements Serializable {

    public ContratocobrancaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contratocobranca contratocobranca) throws PreexistingEntityException, Exception {
        if (contratocobranca.getContratocobrancaprodutoCollection() == null) {
            contratocobranca.setContratocobrancaprodutoCollection(new ArrayList<Contratocobrancaproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = contratocobranca.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                contratocobranca.setCodcli(codcli);
            }
            Contabancaria codcontabancaria = contratocobranca.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                contratocobranca.setCodcontabancaria(codcontabancaria);
            }
            Empresa codempresa = contratocobranca.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contratocobranca.setCodempresa(codempresa);
            }
            Formapag codfp = contratocobranca.getCodfp();
            if (codfp != null) {
                codfp = em.getReference(codfp.getClass(), codfp.getCodfp());
                contratocobranca.setCodfp(codfp);
            }
            Collection<Contratocobrancaproduto> attachedContratocobrancaprodutoCollection = new ArrayList<Contratocobrancaproduto>();
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionContratocobrancaprodutoToAttach : contratocobranca.getContratocobrancaprodutoCollection()) {
                contratocobrancaprodutoCollectionContratocobrancaprodutoToAttach = em.getReference(contratocobrancaprodutoCollectionContratocobrancaprodutoToAttach.getClass(), contratocobrancaprodutoCollectionContratocobrancaprodutoToAttach.getCodcontratocobrancaproduto());
                attachedContratocobrancaprodutoCollection.add(contratocobrancaprodutoCollectionContratocobrancaprodutoToAttach);
            }
            contratocobranca.setContratocobrancaprodutoCollection(attachedContratocobrancaprodutoCollection);
            em.persist(contratocobranca);
            if (codcli != null) {
                codcli.getContratocobrancaCollection().add(contratocobranca);
                codcli = em.merge(codcli);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getContratocobrancaCollection().add(contratocobranca);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codempresa != null) {
                codempresa.getContratocobrancaCollection().add(contratocobranca);
                codempresa = em.merge(codempresa);
            }
            if (codfp != null) {
                codfp.getContratocobrancaCollection().add(contratocobranca);
                codfp = em.merge(codfp);
            }
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionContratocobrancaproduto : contratocobranca.getContratocobrancaprodutoCollection()) {
                Contratocobranca oldCodcontratocobrancaOfContratocobrancaprodutoCollectionContratocobrancaproduto = contratocobrancaprodutoCollectionContratocobrancaproduto.getCodcontratocobranca();
                contratocobrancaprodutoCollectionContratocobrancaproduto.setCodcontratocobranca(contratocobranca);
                contratocobrancaprodutoCollectionContratocobrancaproduto = em.merge(contratocobrancaprodutoCollectionContratocobrancaproduto);
                if (oldCodcontratocobrancaOfContratocobrancaprodutoCollectionContratocobrancaproduto != null) {
                    oldCodcontratocobrancaOfContratocobrancaprodutoCollectionContratocobrancaproduto.getContratocobrancaprodutoCollection().remove(contratocobrancaprodutoCollectionContratocobrancaproduto);
                    oldCodcontratocobrancaOfContratocobrancaprodutoCollectionContratocobrancaproduto = em.merge(oldCodcontratocobrancaOfContratocobrancaprodutoCollectionContratocobrancaproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContratocobranca(contratocobranca.getCodcontratocobranca()) != null) {
                throw new PreexistingEntityException("Contratocobranca " + contratocobranca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contratocobranca contratocobranca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratocobranca persistentContratocobranca = em.find(Contratocobranca.class, contratocobranca.getCodcontratocobranca());
            Cliente codcliOld = persistentContratocobranca.getCodcli();
            Cliente codcliNew = contratocobranca.getCodcli();
            Contabancaria codcontabancariaOld = persistentContratocobranca.getCodcontabancaria();
            Contabancaria codcontabancariaNew = contratocobranca.getCodcontabancaria();
            Empresa codempresaOld = persistentContratocobranca.getCodempresa();
            Empresa codempresaNew = contratocobranca.getCodempresa();
            Formapag codfpOld = persistentContratocobranca.getCodfp();
            Formapag codfpNew = contratocobranca.getCodfp();
            Collection<Contratocobrancaproduto> contratocobrancaprodutoCollectionOld = persistentContratocobranca.getContratocobrancaprodutoCollection();
            Collection<Contratocobrancaproduto> contratocobrancaprodutoCollectionNew = contratocobranca.getContratocobrancaprodutoCollection();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                contratocobranca.setCodcli(codcliNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                contratocobranca.setCodcontabancaria(codcontabancariaNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contratocobranca.setCodempresa(codempresaNew);
            }
            if (codfpNew != null) {
                codfpNew = em.getReference(codfpNew.getClass(), codfpNew.getCodfp());
                contratocobranca.setCodfp(codfpNew);
            }
            Collection<Contratocobrancaproduto> attachedContratocobrancaprodutoCollectionNew = new ArrayList<Contratocobrancaproduto>();
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionNewContratocobrancaprodutoToAttach : contratocobrancaprodutoCollectionNew) {
                contratocobrancaprodutoCollectionNewContratocobrancaprodutoToAttach = em.getReference(contratocobrancaprodutoCollectionNewContratocobrancaprodutoToAttach.getClass(), contratocobrancaprodutoCollectionNewContratocobrancaprodutoToAttach.getCodcontratocobrancaproduto());
                attachedContratocobrancaprodutoCollectionNew.add(contratocobrancaprodutoCollectionNewContratocobrancaprodutoToAttach);
            }
            contratocobrancaprodutoCollectionNew = attachedContratocobrancaprodutoCollectionNew;
            contratocobranca.setContratocobrancaprodutoCollection(contratocobrancaprodutoCollectionNew);
            contratocobranca = em.merge(contratocobranca);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getContratocobrancaCollection().remove(contratocobranca);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getContratocobrancaCollection().add(contratocobranca);
                codcliNew = em.merge(codcliNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getContratocobrancaCollection().remove(contratocobranca);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getContratocobrancaCollection().add(contratocobranca);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContratocobrancaCollection().remove(contratocobranca);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContratocobrancaCollection().add(contratocobranca);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfpOld != null && !codfpOld.equals(codfpNew)) {
                codfpOld.getContratocobrancaCollection().remove(contratocobranca);
                codfpOld = em.merge(codfpOld);
            }
            if (codfpNew != null && !codfpNew.equals(codfpOld)) {
                codfpNew.getContratocobrancaCollection().add(contratocobranca);
                codfpNew = em.merge(codfpNew);
            }
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionOldContratocobrancaproduto : contratocobrancaprodutoCollectionOld) {
                if (!contratocobrancaprodutoCollectionNew.contains(contratocobrancaprodutoCollectionOldContratocobrancaproduto)) {
                    contratocobrancaprodutoCollectionOldContratocobrancaproduto.setCodcontratocobranca(null);
                    contratocobrancaprodutoCollectionOldContratocobrancaproduto = em.merge(contratocobrancaprodutoCollectionOldContratocobrancaproduto);
                }
            }
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionNewContratocobrancaproduto : contratocobrancaprodutoCollectionNew) {
                if (!contratocobrancaprodutoCollectionOld.contains(contratocobrancaprodutoCollectionNewContratocobrancaproduto)) {
                    Contratocobranca oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto = contratocobrancaprodutoCollectionNewContratocobrancaproduto.getCodcontratocobranca();
                    contratocobrancaprodutoCollectionNewContratocobrancaproduto.setCodcontratocobranca(contratocobranca);
                    contratocobrancaprodutoCollectionNewContratocobrancaproduto = em.merge(contratocobrancaprodutoCollectionNewContratocobrancaproduto);
                    if (oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto != null && !oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto.equals(contratocobranca)) {
                        oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto.getContratocobrancaprodutoCollection().remove(contratocobrancaprodutoCollectionNewContratocobrancaproduto);
                        oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto = em.merge(oldCodcontratocobrancaOfContratocobrancaprodutoCollectionNewContratocobrancaproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contratocobranca.getCodcontratocobranca();
                if (findContratocobranca(id) == null) {
                    throw new NonexistentEntityException("The contratocobranca with id " + id + " no longer exists.");
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
            Contratocobranca contratocobranca;
            try {
                contratocobranca = em.getReference(Contratocobranca.class, id);
                contratocobranca.getCodcontratocobranca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contratocobranca with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = contratocobranca.getCodcli();
            if (codcli != null) {
                codcli.getContratocobrancaCollection().remove(contratocobranca);
                codcli = em.merge(codcli);
            }
            Contabancaria codcontabancaria = contratocobranca.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getContratocobrancaCollection().remove(contratocobranca);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Empresa codempresa = contratocobranca.getCodempresa();
            if (codempresa != null) {
                codempresa.getContratocobrancaCollection().remove(contratocobranca);
                codempresa = em.merge(codempresa);
            }
            Formapag codfp = contratocobranca.getCodfp();
            if (codfp != null) {
                codfp.getContratocobrancaCollection().remove(contratocobranca);
                codfp = em.merge(codfp);
            }
            Collection<Contratocobrancaproduto> contratocobrancaprodutoCollection = contratocobranca.getContratocobrancaprodutoCollection();
            for (Contratocobrancaproduto contratocobrancaprodutoCollectionContratocobrancaproduto : contratocobrancaprodutoCollection) {
                contratocobrancaprodutoCollectionContratocobrancaproduto.setCodcontratocobranca(null);
                contratocobrancaprodutoCollectionContratocobrancaproduto = em.merge(contratocobrancaprodutoCollectionContratocobrancaproduto);
            }
            em.remove(contratocobranca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contratocobranca> findContratocobrancaEntities() {
        return findContratocobrancaEntities(true, -1, -1);
    }

    public List<Contratocobranca> findContratocobrancaEntities(int maxResults, int firstResult) {
        return findContratocobrancaEntities(false, maxResults, firstResult);
    }

    private List<Contratocobranca> findContratocobrancaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contratocobranca.class));
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

    public Contratocobranca findContratocobranca(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contratocobranca.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratocobrancaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contratocobranca> rt = cq.from(Contratocobranca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
