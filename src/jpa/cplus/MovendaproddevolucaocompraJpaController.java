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
import entidade.cplus.Fornecedor;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaproddevolucaocompra;
import entidade.cplus.Produto;
import entidade.cplus.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaproddevolucaocompraJpaController implements Serializable {

    public MovendaproddevolucaocompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaproddevolucaocompra movendaproddevolucaocompra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornecedor codforn = movendaproddevolucaocompra.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                movendaproddevolucaocompra.setCodforn(codforn);
            }
            Movendaprod codmovprod = movendaproddevolucaocompra.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                movendaproddevolucaocompra.setCodmovprod(codmovprod);
            }
            Produto codprod = movendaproddevolucaocompra.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                movendaproddevolucaocompra.setCodprod(codprod);
            }
            Usuario coduser = movendaproddevolucaocompra.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                movendaproddevolucaocompra.setCoduser(coduser);
            }
            em.persist(movendaproddevolucaocompra);
            if (codforn != null) {
                codforn.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codforn = em.merge(codforn);
            }
            if (codmovprod != null) {
                codmovprod.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codmovprod = em.merge(codmovprod);
            }
            if (codprod != null) {
                codprod.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codprod = em.merge(codprod);
            }
            if (coduser != null) {
                coduser.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                coduser = em.merge(coduser);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaproddevolucaocompra(movendaproddevolucaocompra.getCodmovendaproddevolucaocompra()) != null) {
                throw new PreexistingEntityException("Movendaproddevolucaocompra " + movendaproddevolucaocompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaproddevolucaocompra movendaproddevolucaocompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaproddevolucaocompra persistentMovendaproddevolucaocompra = em.find(Movendaproddevolucaocompra.class, movendaproddevolucaocompra.getCodmovendaproddevolucaocompra());
            Fornecedor codfornOld = persistentMovendaproddevolucaocompra.getCodforn();
            Fornecedor codfornNew = movendaproddevolucaocompra.getCodforn();
            Movendaprod codmovprodOld = persistentMovendaproddevolucaocompra.getCodmovprod();
            Movendaprod codmovprodNew = movendaproddevolucaocompra.getCodmovprod();
            Produto codprodOld = persistentMovendaproddevolucaocompra.getCodprod();
            Produto codprodNew = movendaproddevolucaocompra.getCodprod();
            Usuario coduserOld = persistentMovendaproddevolucaocompra.getCoduser();
            Usuario coduserNew = movendaproddevolucaocompra.getCoduser();
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                movendaproddevolucaocompra.setCodforn(codfornNew);
            }
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                movendaproddevolucaocompra.setCodmovprod(codmovprodNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                movendaproddevolucaocompra.setCodprod(codprodNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                movendaproddevolucaocompra.setCoduser(coduserNew);
            }
            movendaproddevolucaocompra = em.merge(movendaproddevolucaocompra);
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codfornNew = em.merge(codfornNew);
            }
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                codprodNew = em.merge(codprodNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getMovendaproddevolucaocompraCollection().add(movendaproddevolucaocompra);
                coduserNew = em.merge(coduserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaproddevolucaocompra.getCodmovendaproddevolucaocompra();
                if (findMovendaproddevolucaocompra(id) == null) {
                    throw new NonexistentEntityException("The movendaproddevolucaocompra with id " + id + " no longer exists.");
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
            Movendaproddevolucaocompra movendaproddevolucaocompra;
            try {
                movendaproddevolucaocompra = em.getReference(Movendaproddevolucaocompra.class, id);
                movendaproddevolucaocompra.getCodmovendaproddevolucaocompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaproddevolucaocompra with id " + id + " no longer exists.", enfe);
            }
            Fornecedor codforn = movendaproddevolucaocompra.getCodforn();
            if (codforn != null) {
                codforn.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codforn = em.merge(codforn);
            }
            Movendaprod codmovprod = movendaproddevolucaocompra.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codmovprod = em.merge(codmovprod);
            }
            Produto codprod = movendaproddevolucaocompra.getCodprod();
            if (codprod != null) {
                codprod.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                codprod = em.merge(codprod);
            }
            Usuario coduser = movendaproddevolucaocompra.getCoduser();
            if (coduser != null) {
                coduser.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompra);
                coduser = em.merge(coduser);
            }
            em.remove(movendaproddevolucaocompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaproddevolucaocompra> findMovendaproddevolucaocompraEntities() {
        return findMovendaproddevolucaocompraEntities(true, -1, -1);
    }

    public List<Movendaproddevolucaocompra> findMovendaproddevolucaocompraEntities(int maxResults, int firstResult) {
        return findMovendaproddevolucaocompraEntities(false, maxResults, firstResult);
    }

    private List<Movendaproddevolucaocompra> findMovendaproddevolucaocompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaproddevolucaocompra.class));
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

    public Movendaproddevolucaocompra findMovendaproddevolucaocompra(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaproddevolucaocompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaproddevolucaocompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaproddevolucaocompra> rt = cq.from(Movendaproddevolucaocompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
