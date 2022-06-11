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
import entidade.cplus.Classificacaofiscal;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Gtintributavel;
import entidade.cplus.Produto;
import entidade.cplus.Unidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class UnidadeJpaController implements Serializable {

    public UnidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Unidade unidade) throws PreexistingEntityException, Exception {
        if (unidade.getClassificacaofiscalCollection() == null) {
            unidade.setClassificacaofiscalCollection(new ArrayList<Classificacaofiscal>());
        }
        if (unidade.getGtintributavelCollection() == null) {
            unidade.setGtintributavelCollection(new ArrayList<Gtintributavel>());
        }
        if (unidade.getProdutoCollection() == null) {
            unidade.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Classificacaofiscal> attachedClassificacaofiscalCollection = new ArrayList<Classificacaofiscal>();
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscalToAttach : unidade.getClassificacaofiscalCollection()) {
                classificacaofiscalCollectionClassificacaofiscalToAttach = em.getReference(classificacaofiscalCollectionClassificacaofiscalToAttach.getClass(), classificacaofiscalCollectionClassificacaofiscalToAttach.getCodclassificacaofiscal());
                attachedClassificacaofiscalCollection.add(classificacaofiscalCollectionClassificacaofiscalToAttach);
            }
            unidade.setClassificacaofiscalCollection(attachedClassificacaofiscalCollection);
            Collection<Gtintributavel> attachedGtintributavelCollection = new ArrayList<Gtintributavel>();
            for (Gtintributavel gtintributavelCollectionGtintributavelToAttach : unidade.getGtintributavelCollection()) {
                gtintributavelCollectionGtintributavelToAttach = em.getReference(gtintributavelCollectionGtintributavelToAttach.getClass(), gtintributavelCollectionGtintributavelToAttach.getCodgtintributavel());
                attachedGtintributavelCollection.add(gtintributavelCollectionGtintributavelToAttach);
            }
            unidade.setGtintributavelCollection(attachedGtintributavelCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : unidade.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            unidade.setProdutoCollection(attachedProdutoCollection);
            em.persist(unidade);
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscal : unidade.getClassificacaofiscalCollection()) {
                Unidade oldCodunidadeOfClassificacaofiscalCollectionClassificacaofiscal = classificacaofiscalCollectionClassificacaofiscal.getCodunidade();
                classificacaofiscalCollectionClassificacaofiscal.setCodunidade(unidade);
                classificacaofiscalCollectionClassificacaofiscal = em.merge(classificacaofiscalCollectionClassificacaofiscal);
                if (oldCodunidadeOfClassificacaofiscalCollectionClassificacaofiscal != null) {
                    oldCodunidadeOfClassificacaofiscalCollectionClassificacaofiscal.getClassificacaofiscalCollection().remove(classificacaofiscalCollectionClassificacaofiscal);
                    oldCodunidadeOfClassificacaofiscalCollectionClassificacaofiscal = em.merge(oldCodunidadeOfClassificacaofiscalCollectionClassificacaofiscal);
                }
            }
            for (Gtintributavel gtintributavelCollectionGtintributavel : unidade.getGtintributavelCollection()) {
                Unidade oldCodunidadeOfGtintributavelCollectionGtintributavel = gtintributavelCollectionGtintributavel.getCodunidade();
                gtintributavelCollectionGtintributavel.setCodunidade(unidade);
                gtintributavelCollectionGtintributavel = em.merge(gtintributavelCollectionGtintributavel);
                if (oldCodunidadeOfGtintributavelCollectionGtintributavel != null) {
                    oldCodunidadeOfGtintributavelCollectionGtintributavel.getGtintributavelCollection().remove(gtintributavelCollectionGtintributavel);
                    oldCodunidadeOfGtintributavelCollectionGtintributavel = em.merge(oldCodunidadeOfGtintributavelCollectionGtintributavel);
                }
            }
            for (Produto produtoCollectionProduto : unidade.getProdutoCollection()) {
                Unidade oldCodunidadeOfProdutoCollectionProduto = produtoCollectionProduto.getCodunidade();
                produtoCollectionProduto.setCodunidade(unidade);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodunidadeOfProdutoCollectionProduto != null) {
                    oldCodunidadeOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodunidadeOfProdutoCollectionProduto = em.merge(oldCodunidadeOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUnidade(unidade.getCodunidade()) != null) {
                throw new PreexistingEntityException("Unidade " + unidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Unidade unidade) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Unidade persistentUnidade = em.find(Unidade.class, unidade.getCodunidade());
            Collection<Classificacaofiscal> classificacaofiscalCollectionOld = persistentUnidade.getClassificacaofiscalCollection();
            Collection<Classificacaofiscal> classificacaofiscalCollectionNew = unidade.getClassificacaofiscalCollection();
            Collection<Gtintributavel> gtintributavelCollectionOld = persistentUnidade.getGtintributavelCollection();
            Collection<Gtintributavel> gtintributavelCollectionNew = unidade.getGtintributavelCollection();
            Collection<Produto> produtoCollectionOld = persistentUnidade.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = unidade.getProdutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Gtintributavel gtintributavelCollectionOldGtintributavel : gtintributavelCollectionOld) {
                if (!gtintributavelCollectionNew.contains(gtintributavelCollectionOldGtintributavel)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Gtintributavel " + gtintributavelCollectionOldGtintributavel + " since its codunidade field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Classificacaofiscal> attachedClassificacaofiscalCollectionNew = new ArrayList<Classificacaofiscal>();
            for (Classificacaofiscal classificacaofiscalCollectionNewClassificacaofiscalToAttach : classificacaofiscalCollectionNew) {
                classificacaofiscalCollectionNewClassificacaofiscalToAttach = em.getReference(classificacaofiscalCollectionNewClassificacaofiscalToAttach.getClass(), classificacaofiscalCollectionNewClassificacaofiscalToAttach.getCodclassificacaofiscal());
                attachedClassificacaofiscalCollectionNew.add(classificacaofiscalCollectionNewClassificacaofiscalToAttach);
            }
            classificacaofiscalCollectionNew = attachedClassificacaofiscalCollectionNew;
            unidade.setClassificacaofiscalCollection(classificacaofiscalCollectionNew);
            Collection<Gtintributavel> attachedGtintributavelCollectionNew = new ArrayList<Gtintributavel>();
            for (Gtintributavel gtintributavelCollectionNewGtintributavelToAttach : gtintributavelCollectionNew) {
                gtintributavelCollectionNewGtintributavelToAttach = em.getReference(gtintributavelCollectionNewGtintributavelToAttach.getClass(), gtintributavelCollectionNewGtintributavelToAttach.getCodgtintributavel());
                attachedGtintributavelCollectionNew.add(gtintributavelCollectionNewGtintributavelToAttach);
            }
            gtintributavelCollectionNew = attachedGtintributavelCollectionNew;
            unidade.setGtintributavelCollection(gtintributavelCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            unidade.setProdutoCollection(produtoCollectionNew);
            unidade = em.merge(unidade);
            for (Classificacaofiscal classificacaofiscalCollectionOldClassificacaofiscal : classificacaofiscalCollectionOld) {
                if (!classificacaofiscalCollectionNew.contains(classificacaofiscalCollectionOldClassificacaofiscal)) {
                    classificacaofiscalCollectionOldClassificacaofiscal.setCodunidade(null);
                    classificacaofiscalCollectionOldClassificacaofiscal = em.merge(classificacaofiscalCollectionOldClassificacaofiscal);
                }
            }
            for (Classificacaofiscal classificacaofiscalCollectionNewClassificacaofiscal : classificacaofiscalCollectionNew) {
                if (!classificacaofiscalCollectionOld.contains(classificacaofiscalCollectionNewClassificacaofiscal)) {
                    Unidade oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal = classificacaofiscalCollectionNewClassificacaofiscal.getCodunidade();
                    classificacaofiscalCollectionNewClassificacaofiscal.setCodunidade(unidade);
                    classificacaofiscalCollectionNewClassificacaofiscal = em.merge(classificacaofiscalCollectionNewClassificacaofiscal);
                    if (oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal != null && !oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal.equals(unidade)) {
                        oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal.getClassificacaofiscalCollection().remove(classificacaofiscalCollectionNewClassificacaofiscal);
                        oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal = em.merge(oldCodunidadeOfClassificacaofiscalCollectionNewClassificacaofiscal);
                    }
                }
            }
            for (Gtintributavel gtintributavelCollectionNewGtintributavel : gtintributavelCollectionNew) {
                if (!gtintributavelCollectionOld.contains(gtintributavelCollectionNewGtintributavel)) {
                    Unidade oldCodunidadeOfGtintributavelCollectionNewGtintributavel = gtintributavelCollectionNewGtintributavel.getCodunidade();
                    gtintributavelCollectionNewGtintributavel.setCodunidade(unidade);
                    gtintributavelCollectionNewGtintributavel = em.merge(gtintributavelCollectionNewGtintributavel);
                    if (oldCodunidadeOfGtintributavelCollectionNewGtintributavel != null && !oldCodunidadeOfGtintributavelCollectionNewGtintributavel.equals(unidade)) {
                        oldCodunidadeOfGtintributavelCollectionNewGtintributavel.getGtintributavelCollection().remove(gtintributavelCollectionNewGtintributavel);
                        oldCodunidadeOfGtintributavelCollectionNewGtintributavel = em.merge(oldCodunidadeOfGtintributavelCollectionNewGtintributavel);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodunidade(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Unidade oldCodunidadeOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodunidade();
                    produtoCollectionNewProduto.setCodunidade(unidade);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodunidadeOfProdutoCollectionNewProduto != null && !oldCodunidadeOfProdutoCollectionNewProduto.equals(unidade)) {
                        oldCodunidadeOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodunidadeOfProdutoCollectionNewProduto = em.merge(oldCodunidadeOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = unidade.getCodunidade();
                if (findUnidade(id) == null) {
                    throw new NonexistentEntityException("The unidade with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Unidade unidade;
            try {
                unidade = em.getReference(Unidade.class, id);
                unidade.getCodunidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidade with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Gtintributavel> gtintributavelCollectionOrphanCheck = unidade.getGtintributavelCollection();
            for (Gtintributavel gtintributavelCollectionOrphanCheckGtintributavel : gtintributavelCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidade (" + unidade + ") cannot be destroyed since the Gtintributavel " + gtintributavelCollectionOrphanCheckGtintributavel + " in its gtintributavelCollection field has a non-nullable codunidade field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Classificacaofiscal> classificacaofiscalCollection = unidade.getClassificacaofiscalCollection();
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscal : classificacaofiscalCollection) {
                classificacaofiscalCollectionClassificacaofiscal.setCodunidade(null);
                classificacaofiscalCollectionClassificacaofiscal = em.merge(classificacaofiscalCollectionClassificacaofiscal);
            }
            Collection<Produto> produtoCollection = unidade.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodunidade(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(unidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Unidade> findUnidadeEntities() {
        return findUnidadeEntities(true, -1, -1);
    }

    public List<Unidade> findUnidadeEntities(int maxResults, int firstResult) {
        return findUnidadeEntities(false, maxResults, firstResult);
    }

    private List<Unidade> findUnidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Unidade.class));
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

    public Unidade findUnidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Unidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Unidade> rt = cq.from(Unidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
