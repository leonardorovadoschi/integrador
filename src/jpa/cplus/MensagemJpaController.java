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
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Mensagem;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MensagemJpaController implements Serializable {

    public MensagemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mensagem mensagem) throws PreexistingEntityException, Exception {
        if (mensagem.getCalculoicmsestadoCollection() == null) {
            mensagem.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (mensagem.getProdutoCollection() == null) {
            mensagem.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : mensagem.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            mensagem.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : mensagem.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            mensagem.setProdutoCollection(attachedProdutoCollection);
            em.persist(mensagem);
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : mensagem.getCalculoicmsestadoCollection()) {
                Mensagem oldCodmensagemOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodmensagem();
                calculoicmsestadoCollectionCalculoicmsestado.setCodmensagem(mensagem);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodmensagemOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodmensagemOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodmensagemOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodmensagemOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Produto produtoCollectionProduto : mensagem.getProdutoCollection()) {
                Mensagem oldCodmensagemOfProdutoCollectionProduto = produtoCollectionProduto.getCodmensagem();
                produtoCollectionProduto.setCodmensagem(mensagem);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodmensagemOfProdutoCollectionProduto != null) {
                    oldCodmensagemOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodmensagemOfProdutoCollectionProduto = em.merge(oldCodmensagemOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMensagem(mensagem.getCodmensagem()) != null) {
                throw new PreexistingEntityException("Mensagem " + mensagem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mensagem mensagem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mensagem persistentMensagem = em.find(Mensagem.class, mensagem.getCodmensagem());
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentMensagem.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = mensagem.getCalculoicmsestadoCollection();
            Collection<Produto> produtoCollectionOld = persistentMensagem.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = mensagem.getProdutoCollection();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            mensagem.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            mensagem.setProdutoCollection(produtoCollectionNew);
            mensagem = em.merge(mensagem);
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    calculoicmsestadoCollectionOldCalculoicmsestado.setCodmensagem(null);
                    calculoicmsestadoCollectionOldCalculoicmsestado = em.merge(calculoicmsestadoCollectionOldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Mensagem oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodmensagem();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodmensagem(mensagem);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(mensagem)) {
                        oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodmensagemOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodmensagem(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Mensagem oldCodmensagemOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodmensagem();
                    produtoCollectionNewProduto.setCodmensagem(mensagem);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodmensagemOfProdutoCollectionNewProduto != null && !oldCodmensagemOfProdutoCollectionNewProduto.equals(mensagem)) {
                        oldCodmensagemOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodmensagemOfProdutoCollectionNewProduto = em.merge(oldCodmensagemOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mensagem.getCodmensagem();
                if (findMensagem(id) == null) {
                    throw new NonexistentEntityException("The mensagem with id " + id + " no longer exists.");
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
            Mensagem mensagem;
            try {
                mensagem = em.getReference(Mensagem.class, id);
                mensagem.getCodmensagem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mensagem with id " + id + " no longer exists.", enfe);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection = mensagem.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : calculoicmsestadoCollection) {
                calculoicmsestadoCollectionCalculoicmsestado.setCodmensagem(null);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
            }
            Collection<Produto> produtoCollection = mensagem.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodmensagem(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(mensagem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mensagem> findMensagemEntities() {
        return findMensagemEntities(true, -1, -1);
    }

    public List<Mensagem> findMensagemEntities(int maxResults, int firstResult) {
        return findMensagemEntities(false, maxResults, firstResult);
    }

    private List<Mensagem> findMensagemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mensagem.class));
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

    public Mensagem findMensagem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mensagem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMensagemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mensagem> rt = cq.from(Mensagem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
