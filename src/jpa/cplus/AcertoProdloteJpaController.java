/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.AcertoProdlote;
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
public class AcertoProdloteJpaController implements Serializable {

    public AcertoProdloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AcertoProdlote acertoProdlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = acertoProdlote.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                acertoProdlote.setCodempresa(codempresa);
            }
            Setorestoque codsetorestoque = acertoProdlote.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque = em.getReference(codsetorestoque.getClass(), codsetorestoque.getCodsetorestoque());
                acertoProdlote.setCodsetorestoque(codsetorestoque);
            }
            em.persist(acertoProdlote);
            if (codempresa != null) {
                codempresa.getAcertoProdloteCollection().add(acertoProdlote);
                codempresa = em.merge(codempresa);
            }
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoProdloteCollection().add(acertoProdlote);
                codsetorestoque = em.merge(codsetorestoque);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcertoProdlote(acertoProdlote.getCodacertoProdlote()) != null) {
                throw new PreexistingEntityException("AcertoProdlote " + acertoProdlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AcertoProdlote acertoProdlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AcertoProdlote persistentAcertoProdlote = em.find(AcertoProdlote.class, acertoProdlote.getCodacertoProdlote());
            Empresa codempresaOld = persistentAcertoProdlote.getCodempresa();
            Empresa codempresaNew = acertoProdlote.getCodempresa();
            Setorestoque codsetorestoqueOld = persistentAcertoProdlote.getCodsetorestoque();
            Setorestoque codsetorestoqueNew = acertoProdlote.getCodsetorestoque();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                acertoProdlote.setCodempresa(codempresaNew);
            }
            if (codsetorestoqueNew != null) {
                codsetorestoqueNew = em.getReference(codsetorestoqueNew.getClass(), codsetorestoqueNew.getCodsetorestoque());
                acertoProdlote.setCodsetorestoque(codsetorestoqueNew);
            }
            acertoProdlote = em.merge(acertoProdlote);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getAcertoProdloteCollection().remove(acertoProdlote);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getAcertoProdloteCollection().add(acertoProdlote);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codsetorestoqueOld != null && !codsetorestoqueOld.equals(codsetorestoqueNew)) {
                codsetorestoqueOld.getAcertoProdloteCollection().remove(acertoProdlote);
                codsetorestoqueOld = em.merge(codsetorestoqueOld);
            }
            if (codsetorestoqueNew != null && !codsetorestoqueNew.equals(codsetorestoqueOld)) {
                codsetorestoqueNew.getAcertoProdloteCollection().add(acertoProdlote);
                codsetorestoqueNew = em.merge(codsetorestoqueNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acertoProdlote.getCodacertoProdlote();
                if (findAcertoProdlote(id) == null) {
                    throw new NonexistentEntityException("The acertoProdlote with id " + id + " no longer exists.");
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
            AcertoProdlote acertoProdlote;
            try {
                acertoProdlote = em.getReference(AcertoProdlote.class, id);
                acertoProdlote.getCodacertoProdlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acertoProdlote with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = acertoProdlote.getCodempresa();
            if (codempresa != null) {
                codempresa.getAcertoProdloteCollection().remove(acertoProdlote);
                codempresa = em.merge(codempresa);
            }
            Setorestoque codsetorestoque = acertoProdlote.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getAcertoProdloteCollection().remove(acertoProdlote);
                codsetorestoque = em.merge(codsetorestoque);
            }
            em.remove(acertoProdlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AcertoProdlote> findAcertoProdloteEntities() {
        return findAcertoProdloteEntities(true, -1, -1);
    }

    public List<AcertoProdlote> findAcertoProdloteEntities(int maxResults, int firstResult) {
        return findAcertoProdloteEntities(false, maxResults, firstResult);
    }

    private List<AcertoProdlote> findAcertoProdloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AcertoProdlote.class));
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

    public AcertoProdlote findAcertoProdlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AcertoProdlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoProdloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AcertoProdlote> rt = cq.from(AcertoProdlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
