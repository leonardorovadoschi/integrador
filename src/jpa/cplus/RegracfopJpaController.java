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
import entidade.cplus.Regracfopitem;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Produto;
import entidade.cplus.Regracfop;
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
public class RegracfopJpaController implements Serializable {

    public RegracfopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Regracfop regracfop) throws PreexistingEntityException, Exception {
        if (regracfop.getRegracfopitemCollection() == null) {
            regracfop.setRegracfopitemCollection(new ArrayList<Regracfopitem>());
        }
        if (regracfop.getProdutoCollection() == null) {
            regracfop.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Regracfopitem> attachedRegracfopitemCollection = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionRegracfopitemToAttach : regracfop.getRegracfopitemCollection()) {
                regracfopitemCollectionRegracfopitemToAttach = em.getReference(regracfopitemCollectionRegracfopitemToAttach.getClass(), regracfopitemCollectionRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollection.add(regracfopitemCollectionRegracfopitemToAttach);
            }
            regracfop.setRegracfopitemCollection(attachedRegracfopitemCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : regracfop.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            regracfop.setProdutoCollection(attachedProdutoCollection);
            em.persist(regracfop);
            for (Regracfopitem regracfopitemCollectionRegracfopitem : regracfop.getRegracfopitemCollection()) {
                Regracfop oldCodregracfopOfRegracfopitemCollectionRegracfopitem = regracfopitemCollectionRegracfopitem.getCodregracfop();
                regracfopitemCollectionRegracfopitem.setCodregracfop(regracfop);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
                if (oldCodregracfopOfRegracfopitemCollectionRegracfopitem != null) {
                    oldCodregracfopOfRegracfopitemCollectionRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionRegracfopitem);
                    oldCodregracfopOfRegracfopitemCollectionRegracfopitem = em.merge(oldCodregracfopOfRegracfopitemCollectionRegracfopitem);
                }
            }
            for (Produto produtoCollectionProduto : regracfop.getProdutoCollection()) {
                Regracfop oldCodregracfopOfProdutoCollectionProduto = produtoCollectionProduto.getCodregracfop();
                produtoCollectionProduto.setCodregracfop(regracfop);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodregracfopOfProdutoCollectionProduto != null) {
                    oldCodregracfopOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodregracfopOfProdutoCollectionProduto = em.merge(oldCodregracfopOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegracfop(regracfop.getCodregracfop()) != null) {
                throw new PreexistingEntityException("Regracfop " + regracfop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Regracfop regracfop) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Regracfop persistentRegracfop = em.find(Regracfop.class, regracfop.getCodregracfop());
            Collection<Regracfopitem> regracfopitemCollectionOld = persistentRegracfop.getRegracfopitemCollection();
            Collection<Regracfopitem> regracfopitemCollectionNew = regracfop.getRegracfopitemCollection();
            Collection<Produto> produtoCollectionOld = persistentRegracfop.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = regracfop.getProdutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Regracfopitem regracfopitemCollectionOldRegracfopitem : regracfopitemCollectionOld) {
                if (!regracfopitemCollectionNew.contains(regracfopitemCollectionOldRegracfopitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Regracfopitem " + regracfopitemCollectionOldRegracfopitem + " since its codregracfop field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Regracfopitem> attachedRegracfopitemCollectionNew = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionNewRegracfopitemToAttach : regracfopitemCollectionNew) {
                regracfopitemCollectionNewRegracfopitemToAttach = em.getReference(regracfopitemCollectionNewRegracfopitemToAttach.getClass(), regracfopitemCollectionNewRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollectionNew.add(regracfopitemCollectionNewRegracfopitemToAttach);
            }
            regracfopitemCollectionNew = attachedRegracfopitemCollectionNew;
            regracfop.setRegracfopitemCollection(regracfopitemCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            regracfop.setProdutoCollection(produtoCollectionNew);
            regracfop = em.merge(regracfop);
            for (Regracfopitem regracfopitemCollectionNewRegracfopitem : regracfopitemCollectionNew) {
                if (!regracfopitemCollectionOld.contains(regracfopitemCollectionNewRegracfopitem)) {
                    Regracfop oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem = regracfopitemCollectionNewRegracfopitem.getCodregracfop();
                    regracfopitemCollectionNewRegracfopitem.setCodregracfop(regracfop);
                    regracfopitemCollectionNewRegracfopitem = em.merge(regracfopitemCollectionNewRegracfopitem);
                    if (oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem != null && !oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem.equals(regracfop)) {
                        oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionNewRegracfopitem);
                        oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem = em.merge(oldCodregracfopOfRegracfopitemCollectionNewRegracfopitem);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodregracfop(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Regracfop oldCodregracfopOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodregracfop();
                    produtoCollectionNewProduto.setCodregracfop(regracfop);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodregracfopOfProdutoCollectionNewProduto != null && !oldCodregracfopOfProdutoCollectionNewProduto.equals(regracfop)) {
                        oldCodregracfopOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodregracfopOfProdutoCollectionNewProduto = em.merge(oldCodregracfopOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = regracfop.getCodregracfop();
                if (findRegracfop(id) == null) {
                    throw new NonexistentEntityException("The regracfop with id " + id + " no longer exists.");
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
            Regracfop regracfop;
            try {
                regracfop = em.getReference(Regracfop.class, id);
                regracfop.getCodregracfop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The regracfop with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Regracfopitem> regracfopitemCollectionOrphanCheck = regracfop.getRegracfopitemCollection();
            for (Regracfopitem regracfopitemCollectionOrphanCheckRegracfopitem : regracfopitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Regracfop (" + regracfop + ") cannot be destroyed since the Regracfopitem " + regracfopitemCollectionOrphanCheckRegracfopitem + " in its regracfopitemCollection field has a non-nullable codregracfop field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Produto> produtoCollection = regracfop.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodregracfop(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(regracfop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Regracfop> findRegracfopEntities() {
        return findRegracfopEntities(true, -1, -1);
    }

    public List<Regracfop> findRegracfopEntities(int maxResults, int firstResult) {
        return findRegracfopEntities(false, maxResults, firstResult);
    }

    private List<Regracfop> findRegracfopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Regracfop.class));
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

    public Regracfop findRegracfop(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Regracfop.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegracfopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Regracfop> rt = cq.from(Regracfop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
