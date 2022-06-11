/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Atendimento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Centroresponsabilidade;
import entidade.cplus.Cliente;
import entidade.cplus.Empresa;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Tipoatendimento;
import entidade.cplus.Contareceber;
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
public class AtendimentoJpaController implements Serializable {

    public AtendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Atendimento atendimento) throws PreexistingEntityException, Exception {
        if (atendimento.getContareceberCollection() == null) {
            atendimento.setContareceberCollection(new ArrayList<Contareceber>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centroresponsabilidade codcentroresponsabilidade = atendimento.getCodcentroresponsabilidade();
            if (codcentroresponsabilidade != null) {
                codcentroresponsabilidade = em.getReference(codcentroresponsabilidade.getClass(), codcentroresponsabilidade.getCodcentroresponsabilidade());
                atendimento.setCodcentroresponsabilidade(codcentroresponsabilidade);
            }
            Cliente codcli = atendimento.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                atendimento.setCodcli(codcli);
            }
            Empresa codempresa = atendimento.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                atendimento.setCodempresa(codempresa);
            }
            Movendaprodserial codmovendaprodserial = atendimento.getCodmovendaprodserial();
            if (codmovendaprodserial != null) {
                codmovendaprodserial = em.getReference(codmovendaprodserial.getClass(), codmovendaprodserial.getCodmovendaprodserial());
                atendimento.setCodmovendaprodserial(codmovendaprodserial);
            }
            Tipoatendimento codtipoatend = atendimento.getCodtipoatend();
            if (codtipoatend != null) {
                codtipoatend = em.getReference(codtipoatend.getClass(), codtipoatend.getCodtipoatend());
                atendimento.setCodtipoatend(codtipoatend);
            }
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : atendimento.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            atendimento.setContareceberCollection(attachedContareceberCollection);
            em.persist(atendimento);
            if (codcentroresponsabilidade != null) {
                codcentroresponsabilidade.getAtendimentoCollection().add(atendimento);
                codcentroresponsabilidade = em.merge(codcentroresponsabilidade);
            }
            if (codcli != null) {
                codcli.getAtendimentoCollection().add(atendimento);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getAtendimentoCollection().add(atendimento);
                codempresa = em.merge(codempresa);
            }
            if (codmovendaprodserial != null) {
                codmovendaprodserial.getAtendimentoCollection().add(atendimento);
                codmovendaprodserial = em.merge(codmovendaprodserial);
            }
            if (codtipoatend != null) {
                codtipoatend.getAtendimentoCollection().add(atendimento);
                codtipoatend = em.merge(codtipoatend);
            }
            for (Contareceber contareceberCollectionContareceber : atendimento.getContareceberCollection()) {
                Atendimento oldCodatendOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodatend();
                contareceberCollectionContareceber.setCodatend(atendimento);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodatendOfContareceberCollectionContareceber != null) {
                    oldCodatendOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodatendOfContareceberCollectionContareceber = em.merge(oldCodatendOfContareceberCollectionContareceber);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAtendimento(atendimento.getCodatend()) != null) {
                throw new PreexistingEntityException("Atendimento " + atendimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Atendimento atendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atendimento persistentAtendimento = em.find(Atendimento.class, atendimento.getCodatend());
            Centroresponsabilidade codcentroresponsabilidadeOld = persistentAtendimento.getCodcentroresponsabilidade();
            Centroresponsabilidade codcentroresponsabilidadeNew = atendimento.getCodcentroresponsabilidade();
            Cliente codcliOld = persistentAtendimento.getCodcli();
            Cliente codcliNew = atendimento.getCodcli();
            Empresa codempresaOld = persistentAtendimento.getCodempresa();
            Empresa codempresaNew = atendimento.getCodempresa();
            Movendaprodserial codmovendaprodserialOld = persistentAtendimento.getCodmovendaprodserial();
            Movendaprodserial codmovendaprodserialNew = atendimento.getCodmovendaprodserial();
            Tipoatendimento codtipoatendOld = persistentAtendimento.getCodtipoatend();
            Tipoatendimento codtipoatendNew = atendimento.getCodtipoatend();
            Collection<Contareceber> contareceberCollectionOld = persistentAtendimento.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = atendimento.getContareceberCollection();
            if (codcentroresponsabilidadeNew != null) {
                codcentroresponsabilidadeNew = em.getReference(codcentroresponsabilidadeNew.getClass(), codcentroresponsabilidadeNew.getCodcentroresponsabilidade());
                atendimento.setCodcentroresponsabilidade(codcentroresponsabilidadeNew);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                atendimento.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                atendimento.setCodempresa(codempresaNew);
            }
            if (codmovendaprodserialNew != null) {
                codmovendaprodserialNew = em.getReference(codmovendaprodserialNew.getClass(), codmovendaprodserialNew.getCodmovendaprodserial());
                atendimento.setCodmovendaprodserial(codmovendaprodserialNew);
            }
            if (codtipoatendNew != null) {
                codtipoatendNew = em.getReference(codtipoatendNew.getClass(), codtipoatendNew.getCodtipoatend());
                atendimento.setCodtipoatend(codtipoatendNew);
            }
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            atendimento.setContareceberCollection(contareceberCollectionNew);
            atendimento = em.merge(atendimento);
            if (codcentroresponsabilidadeOld != null && !codcentroresponsabilidadeOld.equals(codcentroresponsabilidadeNew)) {
                codcentroresponsabilidadeOld.getAtendimentoCollection().remove(atendimento);
                codcentroresponsabilidadeOld = em.merge(codcentroresponsabilidadeOld);
            }
            if (codcentroresponsabilidadeNew != null && !codcentroresponsabilidadeNew.equals(codcentroresponsabilidadeOld)) {
                codcentroresponsabilidadeNew.getAtendimentoCollection().add(atendimento);
                codcentroresponsabilidadeNew = em.merge(codcentroresponsabilidadeNew);
            }
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getAtendimentoCollection().remove(atendimento);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getAtendimentoCollection().add(atendimento);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getAtendimentoCollection().remove(atendimento);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getAtendimentoCollection().add(atendimento);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmovendaprodserialOld != null && !codmovendaprodserialOld.equals(codmovendaprodserialNew)) {
                codmovendaprodserialOld.getAtendimentoCollection().remove(atendimento);
                codmovendaprodserialOld = em.merge(codmovendaprodserialOld);
            }
            if (codmovendaprodserialNew != null && !codmovendaprodserialNew.equals(codmovendaprodserialOld)) {
                codmovendaprodserialNew.getAtendimentoCollection().add(atendimento);
                codmovendaprodserialNew = em.merge(codmovendaprodserialNew);
            }
            if (codtipoatendOld != null && !codtipoatendOld.equals(codtipoatendNew)) {
                codtipoatendOld.getAtendimentoCollection().remove(atendimento);
                codtipoatendOld = em.merge(codtipoatendOld);
            }
            if (codtipoatendNew != null && !codtipoatendNew.equals(codtipoatendOld)) {
                codtipoatendNew.getAtendimentoCollection().add(atendimento);
                codtipoatendNew = em.merge(codtipoatendNew);
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodatend(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Atendimento oldCodatendOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodatend();
                    contareceberCollectionNewContareceber.setCodatend(atendimento);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodatendOfContareceberCollectionNewContareceber != null && !oldCodatendOfContareceberCollectionNewContareceber.equals(atendimento)) {
                        oldCodatendOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodatendOfContareceberCollectionNewContareceber = em.merge(oldCodatendOfContareceberCollectionNewContareceber);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = atendimento.getCodatend();
                if (findAtendimento(id) == null) {
                    throw new NonexistentEntityException("The atendimento with id " + id + " no longer exists.");
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
            Atendimento atendimento;
            try {
                atendimento = em.getReference(Atendimento.class, id);
                atendimento.getCodatend();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atendimento with id " + id + " no longer exists.", enfe);
            }
            Centroresponsabilidade codcentroresponsabilidade = atendimento.getCodcentroresponsabilidade();
            if (codcentroresponsabilidade != null) {
                codcentroresponsabilidade.getAtendimentoCollection().remove(atendimento);
                codcentroresponsabilidade = em.merge(codcentroresponsabilidade);
            }
            Cliente codcli = atendimento.getCodcli();
            if (codcli != null) {
                codcli.getAtendimentoCollection().remove(atendimento);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = atendimento.getCodempresa();
            if (codempresa != null) {
                codempresa.getAtendimentoCollection().remove(atendimento);
                codempresa = em.merge(codempresa);
            }
            Movendaprodserial codmovendaprodserial = atendimento.getCodmovendaprodserial();
            if (codmovendaprodserial != null) {
                codmovendaprodserial.getAtendimentoCollection().remove(atendimento);
                codmovendaprodserial = em.merge(codmovendaprodserial);
            }
            Tipoatendimento codtipoatend = atendimento.getCodtipoatend();
            if (codtipoatend != null) {
                codtipoatend.getAtendimentoCollection().remove(atendimento);
                codtipoatend = em.merge(codtipoatend);
            }
            Collection<Contareceber> contareceberCollection = atendimento.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodatend(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            em.remove(atendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Atendimento> findAtendimentoEntities() {
        return findAtendimentoEntities(true, -1, -1);
    }

    public List<Atendimento> findAtendimentoEntities(int maxResults, int firstResult) {
        return findAtendimentoEntities(false, maxResults, firstResult);
    }

    private List<Atendimento> findAtendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atendimento.class));
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

    public Atendimento findAtendimento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atendimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atendimento> rt = cq.from(Atendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
