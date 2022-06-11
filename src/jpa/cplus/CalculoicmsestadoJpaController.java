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
import entidade.cplus.Calculoicms;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Cfop;
import entidade.cplus.Mensagem;
import entidade.cplus.Motivodesoneracao;
import entidade.cplus.Preco;
import entidade.cplus.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CalculoicmsestadoJpaController implements Serializable {

    public CalculoicmsestadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calculoicmsestado calculoicmsestado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calculoicms codcalculoicms = calculoicmsestado.getCodcalculoicms();
            if (codcalculoicms != null) {
                codcalculoicms = em.getReference(codcalculoicms.getClass(), codcalculoicms.getCodcalculoicms());
                calculoicmsestado.setCodcalculoicms(codcalculoicms);
            }
            Cfop codcfop = calculoicmsestado.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                calculoicmsestado.setCodcfop(codcfop);
            }
            Mensagem codmensagem = calculoicmsestado.getCodmensagem();
            if (codmensagem != null) {
                codmensagem = em.getReference(codmensagem.getClass(), codmensagem.getCodmensagem());
                calculoicmsestado.setCodmensagem(codmensagem);
            }
            Motivodesoneracao codigomotivodeso = calculoicmsestado.getCodigomotivodeso();
            if (codigomotivodeso != null) {
                codigomotivodeso = em.getReference(codigomotivodeso.getClass(), codigomotivodeso.getCodigomotivo());
                calculoicmsestado.setCodigomotivodeso(codigomotivodeso);
            }
            Motivodesoneracao codigomotivodesodif = calculoicmsestado.getCodigomotivodesodif();
            if (codigomotivodesodif != null) {
                codigomotivodesodif = em.getReference(codigomotivodesodif.getClass(), codigomotivodesodif.getCodigomotivo());
                calculoicmsestado.setCodigomotivodesodif(codigomotivodesodif);
            }
            Preco codpreco = calculoicmsestado.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                calculoicmsestado.setCodpreco(codpreco);
            }
            Preco codprecodistribuidor = calculoicmsestado.getCodprecodistribuidor();
            if (codprecodistribuidor != null) {
                codprecodistribuidor = em.getReference(codprecodistribuidor.getClass(), codprecodistribuidor.getCodpreco());
                calculoicmsestado.setCodprecodistribuidor(codprecodistribuidor);
            }
            Uf codufdestino = calculoicmsestado.getCodufdestino();
            if (codufdestino != null) {
                codufdestino = em.getReference(codufdestino.getClass(), codufdestino.getCoduf());
                calculoicmsestado.setCodufdestino(codufdestino);
            }
            Uf coduforigem = calculoicmsestado.getCoduforigem();
            if (coduforigem != null) {
                coduforigem = em.getReference(coduforigem.getClass(), coduforigem.getCoduf());
                calculoicmsestado.setCoduforigem(coduforigem);
            }
            em.persist(calculoicmsestado);
            if (codcalculoicms != null) {
                codcalculoicms.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codcalculoicms = em.merge(codcalculoicms);
            }
            if (codcfop != null) {
                codcfop.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codcfop = em.merge(codcfop);
            }
            if (codmensagem != null) {
                codmensagem.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codmensagem = em.merge(codmensagem);
            }
            if (codigomotivodeso != null) {
                codigomotivodeso.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codigomotivodeso = em.merge(codigomotivodeso);
            }
            if (codigomotivodesodif != null) {
                codigomotivodesodif.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codigomotivodesodif = em.merge(codigomotivodesodif);
            }
            if (codpreco != null) {
                codpreco.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codpreco = em.merge(codpreco);
            }
            if (codprecodistribuidor != null) {
                codprecodistribuidor.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codprecodistribuidor = em.merge(codprecodistribuidor);
            }
            if (codufdestino != null) {
                codufdestino.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codufdestino = em.merge(codufdestino);
            }
            if (coduforigem != null) {
                coduforigem.getCalculoicmsestadoCollection().add(calculoicmsestado);
                coduforigem = em.merge(coduforigem);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalculoicmsestado(calculoicmsestado.getCodcalculoicmsestado()) != null) {
                throw new PreexistingEntityException("Calculoicmsestado " + calculoicmsestado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calculoicmsestado calculoicmsestado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calculoicmsestado persistentCalculoicmsestado = em.find(Calculoicmsestado.class, calculoicmsestado.getCodcalculoicmsestado());
            Calculoicms codcalculoicmsOld = persistentCalculoicmsestado.getCodcalculoicms();
            Calculoicms codcalculoicmsNew = calculoicmsestado.getCodcalculoicms();
            Cfop codcfopOld = persistentCalculoicmsestado.getCodcfop();
            Cfop codcfopNew = calculoicmsestado.getCodcfop();
            Mensagem codmensagemOld = persistentCalculoicmsestado.getCodmensagem();
            Mensagem codmensagemNew = calculoicmsestado.getCodmensagem();
            Motivodesoneracao codigomotivodesoOld = persistentCalculoicmsestado.getCodigomotivodeso();
            Motivodesoneracao codigomotivodesoNew = calculoicmsestado.getCodigomotivodeso();
            Motivodesoneracao codigomotivodesodifOld = persistentCalculoicmsestado.getCodigomotivodesodif();
            Motivodesoneracao codigomotivodesodifNew = calculoicmsestado.getCodigomotivodesodif();
            Preco codprecoOld = persistentCalculoicmsestado.getCodpreco();
            Preco codprecoNew = calculoicmsestado.getCodpreco();
            Preco codprecodistribuidorOld = persistentCalculoicmsestado.getCodprecodistribuidor();
            Preco codprecodistribuidorNew = calculoicmsestado.getCodprecodistribuidor();
            Uf codufdestinoOld = persistentCalculoicmsestado.getCodufdestino();
            Uf codufdestinoNew = calculoicmsestado.getCodufdestino();
            Uf coduforigemOld = persistentCalculoicmsestado.getCoduforigem();
            Uf coduforigemNew = calculoicmsestado.getCoduforigem();
            if (codcalculoicmsNew != null) {
                codcalculoicmsNew = em.getReference(codcalculoicmsNew.getClass(), codcalculoicmsNew.getCodcalculoicms());
                calculoicmsestado.setCodcalculoicms(codcalculoicmsNew);
            }
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                calculoicmsestado.setCodcfop(codcfopNew);
            }
            if (codmensagemNew != null) {
                codmensagemNew = em.getReference(codmensagemNew.getClass(), codmensagemNew.getCodmensagem());
                calculoicmsestado.setCodmensagem(codmensagemNew);
            }
            if (codigomotivodesoNew != null) {
                codigomotivodesoNew = em.getReference(codigomotivodesoNew.getClass(), codigomotivodesoNew.getCodigomotivo());
                calculoicmsestado.setCodigomotivodeso(codigomotivodesoNew);
            }
            if (codigomotivodesodifNew != null) {
                codigomotivodesodifNew = em.getReference(codigomotivodesodifNew.getClass(), codigomotivodesodifNew.getCodigomotivo());
                calculoicmsestado.setCodigomotivodesodif(codigomotivodesodifNew);
            }
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                calculoicmsestado.setCodpreco(codprecoNew);
            }
            if (codprecodistribuidorNew != null) {
                codprecodistribuidorNew = em.getReference(codprecodistribuidorNew.getClass(), codprecodistribuidorNew.getCodpreco());
                calculoicmsestado.setCodprecodistribuidor(codprecodistribuidorNew);
            }
            if (codufdestinoNew != null) {
                codufdestinoNew = em.getReference(codufdestinoNew.getClass(), codufdestinoNew.getCoduf());
                calculoicmsestado.setCodufdestino(codufdestinoNew);
            }
            if (coduforigemNew != null) {
                coduforigemNew = em.getReference(coduforigemNew.getClass(), coduforigemNew.getCoduf());
                calculoicmsestado.setCoduforigem(coduforigemNew);
            }
            calculoicmsestado = em.merge(calculoicmsestado);
            if (codcalculoicmsOld != null && !codcalculoicmsOld.equals(codcalculoicmsNew)) {
                codcalculoicmsOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codcalculoicmsOld = em.merge(codcalculoicmsOld);
            }
            if (codcalculoicmsNew != null && !codcalculoicmsNew.equals(codcalculoicmsOld)) {
                codcalculoicmsNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codcalculoicmsNew = em.merge(codcalculoicmsNew);
            }
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codmensagemOld != null && !codmensagemOld.equals(codmensagemNew)) {
                codmensagemOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codmensagemOld = em.merge(codmensagemOld);
            }
            if (codmensagemNew != null && !codmensagemNew.equals(codmensagemOld)) {
                codmensagemNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codmensagemNew = em.merge(codmensagemNew);
            }
            if (codigomotivodesoOld != null && !codigomotivodesoOld.equals(codigomotivodesoNew)) {
                codigomotivodesoOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codigomotivodesoOld = em.merge(codigomotivodesoOld);
            }
            if (codigomotivodesoNew != null && !codigomotivodesoNew.equals(codigomotivodesoOld)) {
                codigomotivodesoNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codigomotivodesoNew = em.merge(codigomotivodesoNew);
            }
            if (codigomotivodesodifOld != null && !codigomotivodesodifOld.equals(codigomotivodesodifNew)) {
                codigomotivodesodifOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codigomotivodesodifOld = em.merge(codigomotivodesodifOld);
            }
            if (codigomotivodesodifNew != null && !codigomotivodesodifNew.equals(codigomotivodesodifOld)) {
                codigomotivodesodifNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codigomotivodesodifNew = em.merge(codigomotivodesodifNew);
            }
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codprecodistribuidorOld != null && !codprecodistribuidorOld.equals(codprecodistribuidorNew)) {
                codprecodistribuidorOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codprecodistribuidorOld = em.merge(codprecodistribuidorOld);
            }
            if (codprecodistribuidorNew != null && !codprecodistribuidorNew.equals(codprecodistribuidorOld)) {
                codprecodistribuidorNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codprecodistribuidorNew = em.merge(codprecodistribuidorNew);
            }
            if (codufdestinoOld != null && !codufdestinoOld.equals(codufdestinoNew)) {
                codufdestinoOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codufdestinoOld = em.merge(codufdestinoOld);
            }
            if (codufdestinoNew != null && !codufdestinoNew.equals(codufdestinoOld)) {
                codufdestinoNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                codufdestinoNew = em.merge(codufdestinoNew);
            }
            if (coduforigemOld != null && !coduforigemOld.equals(coduforigemNew)) {
                coduforigemOld.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                coduforigemOld = em.merge(coduforigemOld);
            }
            if (coduforigemNew != null && !coduforigemNew.equals(coduforigemOld)) {
                coduforigemNew.getCalculoicmsestadoCollection().add(calculoicmsestado);
                coduforigemNew = em.merge(coduforigemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = calculoicmsestado.getCodcalculoicmsestado();
                if (findCalculoicmsestado(id) == null) {
                    throw new NonexistentEntityException("The calculoicmsestado with id " + id + " no longer exists.");
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
            Calculoicmsestado calculoicmsestado;
            try {
                calculoicmsestado = em.getReference(Calculoicmsestado.class, id);
                calculoicmsestado.getCodcalculoicmsestado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calculoicmsestado with id " + id + " no longer exists.", enfe);
            }
            Calculoicms codcalculoicms = calculoicmsestado.getCodcalculoicms();
            if (codcalculoicms != null) {
                codcalculoicms.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codcalculoicms = em.merge(codcalculoicms);
            }
            Cfop codcfop = calculoicmsestado.getCodcfop();
            if (codcfop != null) {
                codcfop.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codcfop = em.merge(codcfop);
            }
            Mensagem codmensagem = calculoicmsestado.getCodmensagem();
            if (codmensagem != null) {
                codmensagem.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codmensagem = em.merge(codmensagem);
            }
            Motivodesoneracao codigomotivodeso = calculoicmsestado.getCodigomotivodeso();
            if (codigomotivodeso != null) {
                codigomotivodeso.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codigomotivodeso = em.merge(codigomotivodeso);
            }
            Motivodesoneracao codigomotivodesodif = calculoicmsestado.getCodigomotivodesodif();
            if (codigomotivodesodif != null) {
                codigomotivodesodif.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codigomotivodesodif = em.merge(codigomotivodesodif);
            }
            Preco codpreco = calculoicmsestado.getCodpreco();
            if (codpreco != null) {
                codpreco.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codpreco = em.merge(codpreco);
            }
            Preco codprecodistribuidor = calculoicmsestado.getCodprecodistribuidor();
            if (codprecodistribuidor != null) {
                codprecodistribuidor.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codprecodistribuidor = em.merge(codprecodistribuidor);
            }
            Uf codufdestino = calculoicmsestado.getCodufdestino();
            if (codufdestino != null) {
                codufdestino.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                codufdestino = em.merge(codufdestino);
            }
            Uf coduforigem = calculoicmsestado.getCoduforigem();
            if (coduforigem != null) {
                coduforigem.getCalculoicmsestadoCollection().remove(calculoicmsestado);
                coduforigem = em.merge(coduforigem);
            }
            em.remove(calculoicmsestado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calculoicmsestado> findCalculoicmsestadoEntities() {
        return findCalculoicmsestadoEntities(true, -1, -1);
    }

    public List<Calculoicmsestado> findCalculoicmsestadoEntities(int maxResults, int firstResult) {
        return findCalculoicmsestadoEntities(false, maxResults, firstResult);
    }

    private List<Calculoicmsestado> findCalculoicmsestadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calculoicmsestado.class));
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

    public Calculoicmsestado findCalculoicmsestado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calculoicmsestado.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalculoicmsestadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calculoicmsestado> rt = cq.from(Calculoicmsestado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
