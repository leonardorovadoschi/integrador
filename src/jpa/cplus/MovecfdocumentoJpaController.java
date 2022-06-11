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
import entidade.cplus.Empresa;
import entidade.cplus.Movecfdocumento;
import entidade.cplus.Movenda;
import entidade.cplus.Movecfdocumentoitem;
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
public class MovecfdocumentoJpaController implements Serializable {

    public MovecfdocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfdocumento movecfdocumento) throws PreexistingEntityException, Exception {
        if (movecfdocumento.getMovecfdocumentoitemCollection() == null) {
            movecfdocumento.setMovecfdocumentoitemCollection(new ArrayList<Movecfdocumentoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = movecfdocumento.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                movecfdocumento.setCodcli(codcli);
            }
            Empresa codempresa = movecfdocumento.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                movecfdocumento.setCodempresa(codempresa);
            }
            Movenda codmovenda = movecfdocumento.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                movecfdocumento.setCodmovenda(codmovenda);
            }
            Collection<Movecfdocumentoitem> attachedMovecfdocumentoitemCollection = new ArrayList<Movecfdocumentoitem>();
            for (Movecfdocumentoitem movecfdocumentoitemCollectionMovecfdocumentoitemToAttach : movecfdocumento.getMovecfdocumentoitemCollection()) {
                movecfdocumentoitemCollectionMovecfdocumentoitemToAttach = em.getReference(movecfdocumentoitemCollectionMovecfdocumentoitemToAttach.getClass(), movecfdocumentoitemCollectionMovecfdocumentoitemToAttach.getCodmovecfdocumentoitem());
                attachedMovecfdocumentoitemCollection.add(movecfdocumentoitemCollectionMovecfdocumentoitemToAttach);
            }
            movecfdocumento.setMovecfdocumentoitemCollection(attachedMovecfdocumentoitemCollection);
            em.persist(movecfdocumento);
            if (codcli != null) {
                codcli.getMovecfdocumentoCollection().add(movecfdocumento);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getMovecfdocumentoCollection().add(movecfdocumento);
                codempresa = em.merge(codempresa);
            }
            if (codmovenda != null) {
                codmovenda.getMovecfdocumentoCollection().add(movecfdocumento);
                codmovenda = em.merge(codmovenda);
            }
            for (Movecfdocumentoitem movecfdocumentoitemCollectionMovecfdocumentoitem : movecfdocumento.getMovecfdocumentoitemCollection()) {
                Movecfdocumento oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionMovecfdocumentoitem = movecfdocumentoitemCollectionMovecfdocumentoitem.getCodmovecfdocumento();
                movecfdocumentoitemCollectionMovecfdocumentoitem.setCodmovecfdocumento(movecfdocumento);
                movecfdocumentoitemCollectionMovecfdocumentoitem = em.merge(movecfdocumentoitemCollectionMovecfdocumentoitem);
                if (oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionMovecfdocumentoitem != null) {
                    oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionMovecfdocumentoitem.getMovecfdocumentoitemCollection().remove(movecfdocumentoitemCollectionMovecfdocumentoitem);
                    oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionMovecfdocumentoitem = em.merge(oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionMovecfdocumentoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfdocumento(movecfdocumento.getCodmovecfdocumento()) != null) {
                throw new PreexistingEntityException("Movecfdocumento " + movecfdocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfdocumento movecfdocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfdocumento persistentMovecfdocumento = em.find(Movecfdocumento.class, movecfdocumento.getCodmovecfdocumento());
            Cliente codcliOld = persistentMovecfdocumento.getCodcli();
            Cliente codcliNew = movecfdocumento.getCodcli();
            Empresa codempresaOld = persistentMovecfdocumento.getCodempresa();
            Empresa codempresaNew = movecfdocumento.getCodempresa();
            Movenda codmovendaOld = persistentMovecfdocumento.getCodmovenda();
            Movenda codmovendaNew = movecfdocumento.getCodmovenda();
            Collection<Movecfdocumentoitem> movecfdocumentoitemCollectionOld = persistentMovecfdocumento.getMovecfdocumentoitemCollection();
            Collection<Movecfdocumentoitem> movecfdocumentoitemCollectionNew = movecfdocumento.getMovecfdocumentoitemCollection();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                movecfdocumento.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                movecfdocumento.setCodempresa(codempresaNew);
            }
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                movecfdocumento.setCodmovenda(codmovendaNew);
            }
            Collection<Movecfdocumentoitem> attachedMovecfdocumentoitemCollectionNew = new ArrayList<Movecfdocumentoitem>();
            for (Movecfdocumentoitem movecfdocumentoitemCollectionNewMovecfdocumentoitemToAttach : movecfdocumentoitemCollectionNew) {
                movecfdocumentoitemCollectionNewMovecfdocumentoitemToAttach = em.getReference(movecfdocumentoitemCollectionNewMovecfdocumentoitemToAttach.getClass(), movecfdocumentoitemCollectionNewMovecfdocumentoitemToAttach.getCodmovecfdocumentoitem());
                attachedMovecfdocumentoitemCollectionNew.add(movecfdocumentoitemCollectionNewMovecfdocumentoitemToAttach);
            }
            movecfdocumentoitemCollectionNew = attachedMovecfdocumentoitemCollectionNew;
            movecfdocumento.setMovecfdocumentoitemCollection(movecfdocumentoitemCollectionNew);
            movecfdocumento = em.merge(movecfdocumento);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getMovecfdocumentoCollection().remove(movecfdocumento);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getMovecfdocumentoCollection().add(movecfdocumento);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getMovecfdocumentoCollection().remove(movecfdocumento);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getMovecfdocumentoCollection().add(movecfdocumento);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMovecfdocumentoCollection().remove(movecfdocumento);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMovecfdocumentoCollection().add(movecfdocumento);
                codmovendaNew = em.merge(codmovendaNew);
            }
            for (Movecfdocumentoitem movecfdocumentoitemCollectionOldMovecfdocumentoitem : movecfdocumentoitemCollectionOld) {
                if (!movecfdocumentoitemCollectionNew.contains(movecfdocumentoitemCollectionOldMovecfdocumentoitem)) {
                    movecfdocumentoitemCollectionOldMovecfdocumentoitem.setCodmovecfdocumento(null);
                    movecfdocumentoitemCollectionOldMovecfdocumentoitem = em.merge(movecfdocumentoitemCollectionOldMovecfdocumentoitem);
                }
            }
            for (Movecfdocumentoitem movecfdocumentoitemCollectionNewMovecfdocumentoitem : movecfdocumentoitemCollectionNew) {
                if (!movecfdocumentoitemCollectionOld.contains(movecfdocumentoitemCollectionNewMovecfdocumentoitem)) {
                    Movecfdocumento oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem = movecfdocumentoitemCollectionNewMovecfdocumentoitem.getCodmovecfdocumento();
                    movecfdocumentoitemCollectionNewMovecfdocumentoitem.setCodmovecfdocumento(movecfdocumento);
                    movecfdocumentoitemCollectionNewMovecfdocumentoitem = em.merge(movecfdocumentoitemCollectionNewMovecfdocumentoitem);
                    if (oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem != null && !oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem.equals(movecfdocumento)) {
                        oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem.getMovecfdocumentoitemCollection().remove(movecfdocumentoitemCollectionNewMovecfdocumentoitem);
                        oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem = em.merge(oldCodmovecfdocumentoOfMovecfdocumentoitemCollectionNewMovecfdocumentoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfdocumento.getCodmovecfdocumento();
                if (findMovecfdocumento(id) == null) {
                    throw new NonexistentEntityException("The movecfdocumento with id " + id + " no longer exists.");
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
            Movecfdocumento movecfdocumento;
            try {
                movecfdocumento = em.getReference(Movecfdocumento.class, id);
                movecfdocumento.getCodmovecfdocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfdocumento with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = movecfdocumento.getCodcli();
            if (codcli != null) {
                codcli.getMovecfdocumentoCollection().remove(movecfdocumento);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = movecfdocumento.getCodempresa();
            if (codempresa != null) {
                codempresa.getMovecfdocumentoCollection().remove(movecfdocumento);
                codempresa = em.merge(codempresa);
            }
            Movenda codmovenda = movecfdocumento.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMovecfdocumentoCollection().remove(movecfdocumento);
                codmovenda = em.merge(codmovenda);
            }
            Collection<Movecfdocumentoitem> movecfdocumentoitemCollection = movecfdocumento.getMovecfdocumentoitemCollection();
            for (Movecfdocumentoitem movecfdocumentoitemCollectionMovecfdocumentoitem : movecfdocumentoitemCollection) {
                movecfdocumentoitemCollectionMovecfdocumentoitem.setCodmovecfdocumento(null);
                movecfdocumentoitemCollectionMovecfdocumentoitem = em.merge(movecfdocumentoitemCollectionMovecfdocumentoitem);
            }
            em.remove(movecfdocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfdocumento> findMovecfdocumentoEntities() {
        return findMovecfdocumentoEntities(true, -1, -1);
    }

    public List<Movecfdocumento> findMovecfdocumentoEntities(int maxResults, int firstResult) {
        return findMovecfdocumentoEntities(false, maxResults, firstResult);
    }

    private List<Movecfdocumento> findMovecfdocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfdocumento.class));
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

    public Movecfdocumento findMovecfdocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfdocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfdocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfdocumento> rt = cq.from(Movecfdocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
