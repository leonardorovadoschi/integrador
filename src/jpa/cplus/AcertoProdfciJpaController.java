/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.AcertoProdfci;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Empresa;
import entidade.cplus.Setorestoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class AcertoProdfciJpaController implements Serializable {

    public AcertoProdfciJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AcertoProdfci acertoProdfci) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = acertoProdfci.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                acertoProdfci.setCodempresa(codempresa);
            }
            Setorestoque codsetorestoque = acertoProdfci.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque = em.getReference(codsetorestoque.getClass(), codsetorestoque.getCodsetorestoque());
                acertoProdfci.setCodsetorestoque(codsetorestoque);
            }
            em.persist(acertoProdfci);
            if (codempresa != null) {
                codempresa.getAcertoProdfciCollection().add(acertoProdfci);
                codempresa = em.merge(codempresa);
            }
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoProdfciCollection().add(acertoProdfci);
                codsetorestoque = em.merge(codsetorestoque);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcertoProdfci(acertoProdfci.getCodacertoProdfci()) != null) {
                throw new PreexistingEntityException("AcertoProdfci " + acertoProdfci + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AcertoProdfci acertoProdfci) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AcertoProdfci persistentAcertoProdfci = em.find(AcertoProdfci.class, acertoProdfci.getCodacertoProdfci());
            Empresa codempresaOld = persistentAcertoProdfci.getCodempresa();
            Empresa codempresaNew = acertoProdfci.getCodempresa();
            Setorestoque codsetorestoqueOld = persistentAcertoProdfci.getCodsetorestoque();
            Setorestoque codsetorestoqueNew = acertoProdfci.getCodsetorestoque();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                acertoProdfci.setCodempresa(codempresaNew);
            }
            if (codsetorestoqueNew != null) {
                codsetorestoqueNew = em.getReference(codsetorestoqueNew.getClass(), codsetorestoqueNew.getCodsetorestoque());
                acertoProdfci.setCodsetorestoque(codsetorestoqueNew);
            }
            acertoProdfci = em.merge(acertoProdfci);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getAcertoProdfciCollection().remove(acertoProdfci);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getAcertoProdfciCollection().add(acertoProdfci);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codsetorestoqueOld != null && !codsetorestoqueOld.equals(codsetorestoqueNew)) {
                codsetorestoqueOld.getAcertoProdfciCollection().remove(acertoProdfci);
                codsetorestoqueOld = em.merge(codsetorestoqueOld);
            }
            if (codsetorestoqueNew != null && !codsetorestoqueNew.equals(codsetorestoqueOld)) {
                codsetorestoqueNew.getAcertoProdfciCollection().add(acertoProdfci);
                codsetorestoqueNew = em.merge(codsetorestoqueNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acertoProdfci.getCodacertoProdfci();
                if (findAcertoProdfci(id) == null) {
                    throw new NonexistentEntityException("The acertoProdfci with id " + id + " no longer exists.");
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
            AcertoProdfci acertoProdfci;
            try {
                acertoProdfci = em.getReference(AcertoProdfci.class, id);
                acertoProdfci.getCodacertoProdfci();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acertoProdfci with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = acertoProdfci.getCodempresa();
            if (codempresa != null) {
                codempresa.getAcertoProdfciCollection().remove(acertoProdfci);
                codempresa = em.merge(codempresa);
            }
            Setorestoque codsetorestoque = acertoProdfci.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoProdfciCollection().remove(acertoProdfci);
                codsetorestoque = em.merge(codsetorestoque);
            }
            em.remove(acertoProdfci);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AcertoProdfci> findAcertoProdfciEntities() {
        return findAcertoProdfciEntities(true, -1, -1);
    }

    public List<AcertoProdfci> findAcertoProdfciEntities(int maxResults, int firstResult) {
        return findAcertoProdfciEntities(false, maxResults, firstResult);
    }

    private List<AcertoProdfci> findAcertoProdfciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AcertoProdfci.class));
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

    public AcertoProdfci findAcertoProdfci(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AcertoProdfci.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoProdfciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AcertoProdfci> rt = cq.from(AcertoProdfci.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
