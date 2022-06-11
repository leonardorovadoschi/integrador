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
import entidade.cplus.Bancoocorrencia;
import entidade.cplus.Caixa;
import entidade.cplus.Contareceber;
import entidade.cplus.Contareceberrec;
import entidade.cplus.Documentocaixa;
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
public class ContareceberrecJpaController implements Serializable {

    public ContareceberrecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contareceberrec contareceberrec) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancoocorrencia codbancoocorrencia = contareceberrec.getCodbancoocorrencia();
            if (codbancoocorrencia != null) {
                codbancoocorrencia = em.getReference(codbancoocorrencia.getClass(), codbancoocorrencia.getCodbancoocorrencia());
                contareceberrec.setCodbancoocorrencia(codbancoocorrencia);
            }
            Caixa codcaixa = contareceberrec.getCodcaixa();
            if (codcaixa != null) {
                codcaixa = em.getReference(codcaixa.getClass(), codcaixa.getCodcaixa());
                contareceberrec.setCodcaixa(codcaixa);
            }
            Contareceber codcr = contareceberrec.getCodcr();
            if (codcr != null) {
                codcr = em.getReference(codcr.getClass(), codcr.getCodcr());
                contareceberrec.setCodcr(codcr);
            }
            Documentocaixa coddocumentocaixa = contareceberrec.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa = em.getReference(coddocumentocaixa.getClass(), coddocumentocaixa.getCoddocumentocaixa());
                contareceberrec.setCoddocumentocaixa(coddocumentocaixa);
            }
            Empresa codempresa = contareceberrec.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contareceberrec.setCodempresa(codempresa);
            }
            em.persist(contareceberrec);
            if (codbancoocorrencia != null) {
                codbancoocorrencia.getContareceberrecCollection().add(contareceberrec);
                codbancoocorrencia = em.merge(codbancoocorrencia);
            }
            if (codcaixa != null) {
                codcaixa.getContareceberrecCollection().add(contareceberrec);
                codcaixa = em.merge(codcaixa);
            }
            if (codcr != null) {
                codcr.getContareceberrecCollection().add(contareceberrec);
                codcr = em.merge(codcr);
            }
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getContareceberrecCollection().add(contareceberrec);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            if (codempresa != null) {
                codempresa.getContareceberrecCollection().add(contareceberrec);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContareceberrec(contareceberrec.getId()) != null) {
                throw new PreexistingEntityException("Contareceberrec " + contareceberrec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contareceberrec contareceberrec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contareceberrec persistentContareceberrec = em.find(Contareceberrec.class, contareceberrec.getId());
            Bancoocorrencia codbancoocorrenciaOld = persistentContareceberrec.getCodbancoocorrencia();
            Bancoocorrencia codbancoocorrenciaNew = contareceberrec.getCodbancoocorrencia();
            Caixa codcaixaOld = persistentContareceberrec.getCodcaixa();
            Caixa codcaixaNew = contareceberrec.getCodcaixa();
            Contareceber codcrOld = persistentContareceberrec.getCodcr();
            Contareceber codcrNew = contareceberrec.getCodcr();
            Documentocaixa coddocumentocaixaOld = persistentContareceberrec.getCoddocumentocaixa();
            Documentocaixa coddocumentocaixaNew = contareceberrec.getCoddocumentocaixa();
            Empresa codempresaOld = persistentContareceberrec.getCodempresa();
            Empresa codempresaNew = contareceberrec.getCodempresa();
            if (codbancoocorrenciaNew != null) {
                codbancoocorrenciaNew = em.getReference(codbancoocorrenciaNew.getClass(), codbancoocorrenciaNew.getCodbancoocorrencia());
                contareceberrec.setCodbancoocorrencia(codbancoocorrenciaNew);
            }
            if (codcaixaNew != null) {
                codcaixaNew = em.getReference(codcaixaNew.getClass(), codcaixaNew.getCodcaixa());
                contareceberrec.setCodcaixa(codcaixaNew);
            }
            if (codcrNew != null) {
                codcrNew = em.getReference(codcrNew.getClass(), codcrNew.getCodcr());
                contareceberrec.setCodcr(codcrNew);
            }
            if (coddocumentocaixaNew != null) {
                coddocumentocaixaNew = em.getReference(coddocumentocaixaNew.getClass(), coddocumentocaixaNew.getCoddocumentocaixa());
                contareceberrec.setCoddocumentocaixa(coddocumentocaixaNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contareceberrec.setCodempresa(codempresaNew);
            }
            contareceberrec = em.merge(contareceberrec);
            if (codbancoocorrenciaOld != null && !codbancoocorrenciaOld.equals(codbancoocorrenciaNew)) {
                codbancoocorrenciaOld.getContareceberrecCollection().remove(contareceberrec);
                codbancoocorrenciaOld = em.merge(codbancoocorrenciaOld);
            }
            if (codbancoocorrenciaNew != null && !codbancoocorrenciaNew.equals(codbancoocorrenciaOld)) {
                codbancoocorrenciaNew.getContareceberrecCollection().add(contareceberrec);
                codbancoocorrenciaNew = em.merge(codbancoocorrenciaNew);
            }
            if (codcaixaOld != null && !codcaixaOld.equals(codcaixaNew)) {
                codcaixaOld.getContareceberrecCollection().remove(contareceberrec);
                codcaixaOld = em.merge(codcaixaOld);
            }
            if (codcaixaNew != null && !codcaixaNew.equals(codcaixaOld)) {
                codcaixaNew.getContareceberrecCollection().add(contareceberrec);
                codcaixaNew = em.merge(codcaixaNew);
            }
            if (codcrOld != null && !codcrOld.equals(codcrNew)) {
                codcrOld.getContareceberrecCollection().remove(contareceberrec);
                codcrOld = em.merge(codcrOld);
            }
            if (codcrNew != null && !codcrNew.equals(codcrOld)) {
                codcrNew.getContareceberrecCollection().add(contareceberrec);
                codcrNew = em.merge(codcrNew);
            }
            if (coddocumentocaixaOld != null && !coddocumentocaixaOld.equals(coddocumentocaixaNew)) {
                coddocumentocaixaOld.getContareceberrecCollection().remove(contareceberrec);
                coddocumentocaixaOld = em.merge(coddocumentocaixaOld);
            }
            if (coddocumentocaixaNew != null && !coddocumentocaixaNew.equals(coddocumentocaixaOld)) {
                coddocumentocaixaNew.getContareceberrecCollection().add(contareceberrec);
                coddocumentocaixaNew = em.merge(coddocumentocaixaNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContareceberrecCollection().remove(contareceberrec);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContareceberrecCollection().add(contareceberrec);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contareceberrec.getId();
                if (findContareceberrec(id) == null) {
                    throw new NonexistentEntityException("The contareceberrec with id " + id + " no longer exists.");
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
            Contareceberrec contareceberrec;
            try {
                contareceberrec = em.getReference(Contareceberrec.class, id);
                contareceberrec.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contareceberrec with id " + id + " no longer exists.", enfe);
            }
            Bancoocorrencia codbancoocorrencia = contareceberrec.getCodbancoocorrencia();
            if (codbancoocorrencia != null) {
                codbancoocorrencia.getContareceberrecCollection().remove(contareceberrec);
                codbancoocorrencia = em.merge(codbancoocorrencia);
            }
            Caixa codcaixa = contareceberrec.getCodcaixa();
            if (codcaixa != null) {
                codcaixa.getContareceberrecCollection().remove(contareceberrec);
                codcaixa = em.merge(codcaixa);
            }
            Contareceber codcr = contareceberrec.getCodcr();
            if (codcr != null) {
                codcr.getContareceberrecCollection().remove(contareceberrec);
                codcr = em.merge(codcr);
            }
            Documentocaixa coddocumentocaixa = contareceberrec.getCoddocumentocaixa();
            if (coddocumentocaixa != null) {
                coddocumentocaixa.getContareceberrecCollection().remove(contareceberrec);
                coddocumentocaixa = em.merge(coddocumentocaixa);
            }
            Empresa codempresa = contareceberrec.getCodempresa();
            if (codempresa != null) {
                codempresa.getContareceberrecCollection().remove(contareceberrec);
                codempresa = em.merge(codempresa);
            }
            em.remove(contareceberrec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contareceberrec> findContareceberrecEntities() {
        return findContareceberrecEntities(true, -1, -1);
    }

    public List<Contareceberrec> findContareceberrecEntities(int maxResults, int firstResult) {
        return findContareceberrecEntities(false, maxResults, firstResult);
    }

    private List<Contareceberrec> findContareceberrecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contareceberrec.class));
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

    public Contareceberrec findContareceberrec(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contareceberrec.class, id);
        } finally {
            em.close();
        }
    }

    public int getContareceberrecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contareceberrec> rt = cq.from(Contareceberrec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
