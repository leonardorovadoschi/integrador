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
import entidade.cplus.Ecf;
import entidade.cplus.Empresa;
import entidade.cplus.Movecfdocumentocaixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovecfdocumentocaixaJpaController implements Serializable {

    public MovecfdocumentocaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfdocumentocaixa movecfdocumentocaixa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecf codecf = movecfdocumentocaixa.getCodecf();
            if (codecf != null) {
                codecf = em.getReference(codecf.getClass(), codecf.getCodecf());
                movecfdocumentocaixa.setCodecf(codecf);
            }
            Empresa codempresa = movecfdocumentocaixa.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                movecfdocumentocaixa.setCodempresa(codempresa);
            }
            em.persist(movecfdocumentocaixa);
            if (codecf != null) {
                codecf.getMovecfdocumentocaixaCollection().add(movecfdocumentocaixa);
                codecf = em.merge(codecf);
            }
            if (codempresa != null) {
                codempresa.getMovecfdocumentocaixaCollection().add(movecfdocumentocaixa);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfdocumentocaixa(movecfdocumentocaixa.getCodmovecfdocumentocaixa()) != null) {
                throw new PreexistingEntityException("Movecfdocumentocaixa " + movecfdocumentocaixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfdocumentocaixa movecfdocumentocaixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfdocumentocaixa persistentMovecfdocumentocaixa = em.find(Movecfdocumentocaixa.class, movecfdocumentocaixa.getCodmovecfdocumentocaixa());
            Ecf codecfOld = persistentMovecfdocumentocaixa.getCodecf();
            Ecf codecfNew = movecfdocumentocaixa.getCodecf();
            Empresa codempresaOld = persistentMovecfdocumentocaixa.getCodempresa();
            Empresa codempresaNew = movecfdocumentocaixa.getCodempresa();
            if (codecfNew != null) {
                codecfNew = em.getReference(codecfNew.getClass(), codecfNew.getCodecf());
                movecfdocumentocaixa.setCodecf(codecfNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                movecfdocumentocaixa.setCodempresa(codempresaNew);
            }
            movecfdocumentocaixa = em.merge(movecfdocumentocaixa);
            if (codecfOld != null && !codecfOld.equals(codecfNew)) {
                codecfOld.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixa);
                codecfOld = em.merge(codecfOld);
            }
            if (codecfNew != null && !codecfNew.equals(codecfOld)) {
                codecfNew.getMovecfdocumentocaixaCollection().add(movecfdocumentocaixa);
                codecfNew = em.merge(codecfNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixa);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getMovecfdocumentocaixaCollection().add(movecfdocumentocaixa);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfdocumentocaixa.getCodmovecfdocumentocaixa();
                if (findMovecfdocumentocaixa(id) == null) {
                    throw new NonexistentEntityException("The movecfdocumentocaixa with id " + id + " no longer exists.");
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
            Movecfdocumentocaixa movecfdocumentocaixa;
            try {
                movecfdocumentocaixa = em.getReference(Movecfdocumentocaixa.class, id);
                movecfdocumentocaixa.getCodmovecfdocumentocaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfdocumentocaixa with id " + id + " no longer exists.", enfe);
            }
            Ecf codecf = movecfdocumentocaixa.getCodecf();
            if (codecf != null) {
                codecf.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixa);
                codecf = em.merge(codecf);
            }
            Empresa codempresa = movecfdocumentocaixa.getCodempresa();
            if (codempresa != null) {
                codempresa.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixa);
                codempresa = em.merge(codempresa);
            }
            em.remove(movecfdocumentocaixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfdocumentocaixa> findMovecfdocumentocaixaEntities() {
        return findMovecfdocumentocaixaEntities(true, -1, -1);
    }

    public List<Movecfdocumentocaixa> findMovecfdocumentocaixaEntities(int maxResults, int firstResult) {
        return findMovecfdocumentocaixaEntities(false, maxResults, firstResult);
    }

    private List<Movecfdocumentocaixa> findMovecfdocumentocaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfdocumentocaixa.class));
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

    public Movecfdocumentocaixa findMovecfdocumentocaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfdocumentocaixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfdocumentocaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfdocumentocaixa> rt = cq.from(Movecfdocumentocaixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
