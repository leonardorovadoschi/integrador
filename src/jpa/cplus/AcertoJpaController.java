/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Acerto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Empresa;
import entidade.cplus.Setorestoque;
import entidade.cplus.Acertoproduto;
import java.util.ArrayList;
import java.util.Collection;
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
public class AcertoJpaController implements Serializable {

    public AcertoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acerto acerto) throws PreexistingEntityException, Exception {
        if (acerto.getAcertoprodutoCollection() == null) {
            acerto.setAcertoprodutoCollection(new ArrayList<Acertoproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = acerto.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                acerto.setCodempresa(codempresa);
            }
            Setorestoque codsetorestoque = acerto.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque = em.getReference(codsetorestoque.getClass(), codsetorestoque.getCodsetorestoque());
                acerto.setCodsetorestoque(codsetorestoque);
            }
            Collection<Acertoproduto> attachedAcertoprodutoCollection = new ArrayList<Acertoproduto>();
            for (Acertoproduto acertoprodutoCollectionAcertoprodutoToAttach : acerto.getAcertoprodutoCollection()) {
                acertoprodutoCollectionAcertoprodutoToAttach = em.getReference(acertoprodutoCollectionAcertoprodutoToAttach.getClass(), acertoprodutoCollectionAcertoprodutoToAttach.getCodacertoproduto());
                attachedAcertoprodutoCollection.add(acertoprodutoCollectionAcertoprodutoToAttach);
            }
            acerto.setAcertoprodutoCollection(attachedAcertoprodutoCollection);
            em.persist(acerto);
            if (codempresa != null) {
                codempresa.getAcertoCollection().add(acerto);
                codempresa = em.merge(codempresa);
            }
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoCollection().add(acerto);
                codsetorestoque = em.merge(codsetorestoque);
            }
            for (Acertoproduto acertoprodutoCollectionAcertoproduto : acerto.getAcertoprodutoCollection()) {
                Acerto oldCodacertoOfAcertoprodutoCollectionAcertoproduto = acertoprodutoCollectionAcertoproduto.getCodacerto();
                acertoprodutoCollectionAcertoproduto.setCodacerto(acerto);
                acertoprodutoCollectionAcertoproduto = em.merge(acertoprodutoCollectionAcertoproduto);
                if (oldCodacertoOfAcertoprodutoCollectionAcertoproduto != null) {
                    oldCodacertoOfAcertoprodutoCollectionAcertoproduto.getAcertoprodutoCollection().remove(acertoprodutoCollectionAcertoproduto);
                    oldCodacertoOfAcertoprodutoCollectionAcertoproduto = em.merge(oldCodacertoOfAcertoprodutoCollectionAcertoproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcerto(acerto.getCodacerto()) != null) {
                throw new PreexistingEntityException("Acerto " + acerto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acerto acerto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acerto persistentAcerto = em.find(Acerto.class, acerto.getCodacerto());
            Empresa codempresaOld = persistentAcerto.getCodempresa();
            Empresa codempresaNew = acerto.getCodempresa();
            Setorestoque codsetorestoqueOld = persistentAcerto.getCodsetorestoque();
            Setorestoque codsetorestoqueNew = acerto.getCodsetorestoque();
            Collection<Acertoproduto> acertoprodutoCollectionOld = persistentAcerto.getAcertoprodutoCollection();
            Collection<Acertoproduto> acertoprodutoCollectionNew = acerto.getAcertoprodutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Acertoproduto acertoprodutoCollectionOldAcertoproduto : acertoprodutoCollectionOld) {
                if (!acertoprodutoCollectionNew.contains(acertoprodutoCollectionOldAcertoproduto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Acertoproduto " + acertoprodutoCollectionOldAcertoproduto + " since its codacerto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                acerto.setCodempresa(codempresaNew);
            }
            if (codsetorestoqueNew != null) {
                codsetorestoqueNew = em.getReference(codsetorestoqueNew.getClass(), codsetorestoqueNew.getCodsetorestoque());
                acerto.setCodsetorestoque(codsetorestoqueNew);
            }
            Collection<Acertoproduto> attachedAcertoprodutoCollectionNew = new ArrayList<Acertoproduto>();
            for (Acertoproduto acertoprodutoCollectionNewAcertoprodutoToAttach : acertoprodutoCollectionNew) {
                acertoprodutoCollectionNewAcertoprodutoToAttach = em.getReference(acertoprodutoCollectionNewAcertoprodutoToAttach.getClass(), acertoprodutoCollectionNewAcertoprodutoToAttach.getCodacertoproduto());
                attachedAcertoprodutoCollectionNew.add(acertoprodutoCollectionNewAcertoprodutoToAttach);
            }
            acertoprodutoCollectionNew = attachedAcertoprodutoCollectionNew;
            acerto.setAcertoprodutoCollection(acertoprodutoCollectionNew);
            acerto = em.merge(acerto);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getAcertoCollection().remove(acerto);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getAcertoCollection().add(acerto);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codsetorestoqueOld != null && !codsetorestoqueOld.equals(codsetorestoqueNew)) {
                codsetorestoqueOld.getAcertoCollection().remove(acerto);
                codsetorestoqueOld = em.merge(codsetorestoqueOld);
            }
            if (codsetorestoqueNew != null && !codsetorestoqueNew.equals(codsetorestoqueOld)) {
                codsetorestoqueNew.getAcertoCollection().add(acerto);
                codsetorestoqueNew = em.merge(codsetorestoqueNew);
            }
            for (Acertoproduto acertoprodutoCollectionNewAcertoproduto : acertoprodutoCollectionNew) {
                if (!acertoprodutoCollectionOld.contains(acertoprodutoCollectionNewAcertoproduto)) {
                    Acerto oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto = acertoprodutoCollectionNewAcertoproduto.getCodacerto();
                    acertoprodutoCollectionNewAcertoproduto.setCodacerto(acerto);
                    acertoprodutoCollectionNewAcertoproduto = em.merge(acertoprodutoCollectionNewAcertoproduto);
                    if (oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto != null && !oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto.equals(acerto)) {
                        oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto.getAcertoprodutoCollection().remove(acertoprodutoCollectionNewAcertoproduto);
                        oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto = em.merge(oldCodacertoOfAcertoprodutoCollectionNewAcertoproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acerto.getCodacerto();
                if (findAcerto(id) == null) {
                    throw new NonexistentEntityException("The acerto with id " + id + " no longer exists.");
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
            Acerto acerto;
            try {
                acerto = em.getReference(Acerto.class, id);
                acerto.getCodacerto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acerto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Acertoproduto> acertoprodutoCollectionOrphanCheck = acerto.getAcertoprodutoCollection();
            for (Acertoproduto acertoprodutoCollectionOrphanCheckAcertoproduto : acertoprodutoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Acerto (" + acerto + ") cannot be destroyed since the Acertoproduto " + acertoprodutoCollectionOrphanCheckAcertoproduto + " in its acertoprodutoCollection field has a non-nullable codacerto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa codempresa = acerto.getCodempresa();
            if (codempresa != null) {
                codempresa.getAcertoCollection().remove(acerto);
                codempresa = em.merge(codempresa);
            }
            Setorestoque codsetorestoque = acerto.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoCollection().remove(acerto);
                codsetorestoque = em.merge(codsetorestoque);
            }
            em.remove(acerto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acerto> findAcertoEntities() {
        return findAcertoEntities(true, -1, -1);
    }

    public List<Acerto> findAcertoEntities(int maxResults, int firstResult) {
        return findAcertoEntities(false, maxResults, firstResult);
    }

    private List<Acerto> findAcertoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acerto.class));
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

    public Acerto findAcerto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acerto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acerto> rt = cq.from(Acerto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
