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
import entidade.cplus.Cliente;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Recebimento;
import entidade.cplus.Rma;
import entidade.cplus.Usuario;
import entidade.cplus.Vendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RmaJpaController implements Serializable {

    public RmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rma rma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = rma.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                rma.setCodcli(codcli);
            }
            Moventrada codmoventr = rma.getCodmoventr();
            if (codmoventr != null) {
                codmoventr = em.getReference(codmoventr.getClass(), codmoventr.getCodmoventr());
                rma.setCodmoventr(codmoventr);
            }
            Moventradaprod codmoveprod = rma.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                rma.setCodmoveprod(codmoveprod);
            }
            Produto codprod = rma.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                rma.setCodprod(codprod);
            }
            Recebimento codrec = rma.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                rma.setCodrec(codrec);
            }
            Usuario coduser = rma.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                rma.setCoduser(coduser);
            }
            Vendedor codvended = rma.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                rma.setCodvended(codvended);
            }
            em.persist(rma);
            if (codcli != null) {
                codcli.getRmaCollection().add(rma);
                codcli = em.merge(codcli);
            }
            if (codmoventr != null) {
                codmoventr.getRmaCollection().add(rma);
                codmoventr = em.merge(codmoventr);
            }
            if (codmoveprod != null) {
                codmoveprod.getRmaCollection().add(rma);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codprod != null) {
                codprod.getRmaCollection().add(rma);
                codprod = em.merge(codprod);
            }
            if (codrec != null) {
                codrec.getRmaCollection().add(rma);
                codrec = em.merge(codrec);
            }
            if (coduser != null) {
                coduser.getRmaCollection().add(rma);
                coduser = em.merge(coduser);
            }
            if (codvended != null) {
                codvended.getRmaCollection().add(rma);
                codvended = em.merge(codvended);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRma(rma.getCodrma()) != null) {
                throw new PreexistingEntityException("Rma " + rma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rma rma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rma persistentRma = em.find(Rma.class, rma.getCodrma());
            Cliente codcliOld = persistentRma.getCodcli();
            Cliente codcliNew = rma.getCodcli();
            Moventrada codmoventrOld = persistentRma.getCodmoventr();
            Moventrada codmoventrNew = rma.getCodmoventr();
            Moventradaprod codmoveprodOld = persistentRma.getCodmoveprod();
            Moventradaprod codmoveprodNew = rma.getCodmoveprod();
            Produto codprodOld = persistentRma.getCodprod();
            Produto codprodNew = rma.getCodprod();
            Recebimento codrecOld = persistentRma.getCodrec();
            Recebimento codrecNew = rma.getCodrec();
            Usuario coduserOld = persistentRma.getCoduser();
            Usuario coduserNew = rma.getCoduser();
            Vendedor codvendedOld = persistentRma.getCodvended();
            Vendedor codvendedNew = rma.getCodvended();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                rma.setCodcli(codcliNew);
            }
            if (codmoventrNew != null) {
                codmoventrNew = em.getReference(codmoventrNew.getClass(), codmoventrNew.getCodmoventr());
                rma.setCodmoventr(codmoventrNew);
            }
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                rma.setCodmoveprod(codmoveprodNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                rma.setCodprod(codprodNew);
            }
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                rma.setCodrec(codrecNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                rma.setCoduser(coduserNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                rma.setCodvended(codvendedNew);
            }
            rma = em.merge(rma);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getRmaCollection().remove(rma);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getRmaCollection().add(rma);
                codcliNew = em.merge(codcliNew);
            }
            if (codmoventrOld != null && !codmoventrOld.equals(codmoventrNew)) {
                codmoventrOld.getRmaCollection().remove(rma);
                codmoventrOld = em.merge(codmoventrOld);
            }
            if (codmoventrNew != null && !codmoventrNew.equals(codmoventrOld)) {
                codmoventrNew.getRmaCollection().add(rma);
                codmoventrNew = em.merge(codmoventrNew);
            }
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getRmaCollection().remove(rma);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getRmaCollection().add(rma);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getRmaCollection().remove(rma);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getRmaCollection().add(rma);
                codprodNew = em.merge(codprodNew);
            }
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getRmaCollection().remove(rma);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getRmaCollection().add(rma);
                codrecNew = em.merge(codrecNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getRmaCollection().remove(rma);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getRmaCollection().add(rma);
                coduserNew = em.merge(coduserNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getRmaCollection().remove(rma);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getRmaCollection().add(rma);
                codvendedNew = em.merge(codvendedNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rma.getCodrma();
                if (findRma(id) == null) {
                    throw new NonexistentEntityException("The rma with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rma rma;
            try {
                rma = em.getReference(Rma.class, id);
                rma.getCodrma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rma with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = rma.getCodcli();
            if (codcli != null) {
                codcli.getRmaCollection().remove(rma);
                codcli = em.merge(codcli);
            }
            Moventrada codmoventr = rma.getCodmoventr();
            if (codmoventr != null) {
                codmoventr.getRmaCollection().remove(rma);
                codmoventr = em.merge(codmoventr);
            }
            Moventradaprod codmoveprod = rma.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getRmaCollection().remove(rma);
                codmoveprod = em.merge(codmoveprod);
            }
            Produto codprod = rma.getCodprod();
            if (codprod != null) {
                codprod.getRmaCollection().remove(rma);
                codprod = em.merge(codprod);
            }
            Recebimento codrec = rma.getCodrec();
            if (codrec != null) {
                codrec.getRmaCollection().remove(rma);
                codrec = em.merge(codrec);
            }
            Usuario coduser = rma.getCoduser();
            if (coduser != null) {
                coduser.getRmaCollection().remove(rma);
                coduser = em.merge(coduser);
            }
            Vendedor codvended = rma.getCodvended();
            if (codvended != null) {
                codvended.getRmaCollection().remove(rma);
                codvended = em.merge(codvended);
            }
            em.remove(rma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rma> findRmaEntities() {
        return findRmaEntities(true, -1, -1);
    }

    public List<Rma> findRmaEntities(int maxResults, int firstResult) {
        return findRmaEntities(false, maxResults, firstResult);
    }

    private List<Rma> findRmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rma.class));
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

    public Rma findRma(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rma.class, id);
        } finally {
            em.close();
        }
    }

    public int getRmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rma> rt = cq.from(Rma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
