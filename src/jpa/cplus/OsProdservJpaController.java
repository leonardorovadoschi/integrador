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
import entidade.cplus.OsOrdemservico;
import entidade.cplus.OsProdserv;
import entidade.cplus.Preco;
import entidade.cplus.Produto;
import entidade.cplus.OsProdservserial;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsProdservlote;
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
public class OsProdservJpaController implements Serializable {

    public OsProdservJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsProdserv osProdserv) throws PreexistingEntityException, Exception {
        if (osProdserv.getOsProdservserialCollection() == null) {
            osProdserv.setOsProdservserialCollection(new ArrayList<OsProdservserial>());
        }
        if (osProdserv.getOsProdservloteCollection() == null) {
            osProdserv.setOsProdservloteCollection(new ArrayList<OsProdservlote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico codos = osProdserv.getCodos();
            if (codos != null) {
                codos = em.getReference(codos.getClass(), codos.getCodos());
                osProdserv.setCodos(codos);
            }
            Preco codpreco = osProdserv.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                osProdserv.setCodpreco(codpreco);
            }
            Produto codprod = osProdserv.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                osProdserv.setCodprod(codprod);
            }
            Collection<OsProdservserial> attachedOsProdservserialCollection = new ArrayList<OsProdservserial>();
            for (OsProdservserial osProdservserialCollectionOsProdservserialToAttach : osProdserv.getOsProdservserialCollection()) {
                osProdservserialCollectionOsProdservserialToAttach = em.getReference(osProdservserialCollectionOsProdservserialToAttach.getClass(), osProdservserialCollectionOsProdservserialToAttach.getCodprodservserial());
                attachedOsProdservserialCollection.add(osProdservserialCollectionOsProdservserialToAttach);
            }
            osProdserv.setOsProdservserialCollection(attachedOsProdservserialCollection);
            Collection<OsProdservlote> attachedOsProdservloteCollection = new ArrayList<OsProdservlote>();
            for (OsProdservlote osProdservloteCollectionOsProdservloteToAttach : osProdserv.getOsProdservloteCollection()) {
                osProdservloteCollectionOsProdservloteToAttach = em.getReference(osProdservloteCollectionOsProdservloteToAttach.getClass(), osProdservloteCollectionOsProdservloteToAttach.getCodprodservlote());
                attachedOsProdservloteCollection.add(osProdservloteCollectionOsProdservloteToAttach);
            }
            osProdserv.setOsProdservloteCollection(attachedOsProdservloteCollection);
            em.persist(osProdserv);
            if (codos != null) {
                codos.getOsProdservCollection().add(osProdserv);
                codos = em.merge(codos);
            }
            if (codpreco != null) {
                codpreco.getOsProdservCollection().add(osProdserv);
                codpreco = em.merge(codpreco);
            }
            if (codprod != null) {
                codprod.getOsProdservCollection().add(osProdserv);
                codprod = em.merge(codprod);
            }
            for (OsProdservserial osProdservserialCollectionOsProdservserial : osProdserv.getOsProdservserialCollection()) {
                OsProdserv oldCodprodservOfOsProdservserialCollectionOsProdservserial = osProdservserialCollectionOsProdservserial.getCodprodserv();
                osProdservserialCollectionOsProdservserial.setCodprodserv(osProdserv);
                osProdservserialCollectionOsProdservserial = em.merge(osProdservserialCollectionOsProdservserial);
                if (oldCodprodservOfOsProdservserialCollectionOsProdservserial != null) {
                    oldCodprodservOfOsProdservserialCollectionOsProdservserial.getOsProdservserialCollection().remove(osProdservserialCollectionOsProdservserial);
                    oldCodprodservOfOsProdservserialCollectionOsProdservserial = em.merge(oldCodprodservOfOsProdservserialCollectionOsProdservserial);
                }
            }
            for (OsProdservlote osProdservloteCollectionOsProdservlote : osProdserv.getOsProdservloteCollection()) {
                OsProdserv oldCodprodservOfOsProdservloteCollectionOsProdservlote = osProdservloteCollectionOsProdservlote.getCodprodserv();
                osProdservloteCollectionOsProdservlote.setCodprodserv(osProdserv);
                osProdservloteCollectionOsProdservlote = em.merge(osProdservloteCollectionOsProdservlote);
                if (oldCodprodservOfOsProdservloteCollectionOsProdservlote != null) {
                    oldCodprodservOfOsProdservloteCollectionOsProdservlote.getOsProdservloteCollection().remove(osProdservloteCollectionOsProdservlote);
                    oldCodprodservOfOsProdservloteCollectionOsProdservlote = em.merge(oldCodprodservOfOsProdservloteCollectionOsProdservlote);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsProdserv(osProdserv.getCodprodserv()) != null) {
                throw new PreexistingEntityException("OsProdserv " + osProdserv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsProdserv osProdserv) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsProdserv persistentOsProdserv = em.find(OsProdserv.class, osProdserv.getCodprodserv());
            OsOrdemservico codosOld = persistentOsProdserv.getCodos();
            OsOrdemservico codosNew = osProdserv.getCodos();
            Preco codprecoOld = persistentOsProdserv.getCodpreco();
            Preco codprecoNew = osProdserv.getCodpreco();
            Produto codprodOld = persistentOsProdserv.getCodprod();
            Produto codprodNew = osProdserv.getCodprod();
            Collection<OsProdservserial> osProdservserialCollectionOld = persistentOsProdserv.getOsProdservserialCollection();
            Collection<OsProdservserial> osProdservserialCollectionNew = osProdserv.getOsProdservserialCollection();
            Collection<OsProdservlote> osProdservloteCollectionOld = persistentOsProdserv.getOsProdservloteCollection();
            Collection<OsProdservlote> osProdservloteCollectionNew = osProdserv.getOsProdservloteCollection();
            List<String> illegalOrphanMessages = null;
            for (OsProdservlote osProdservloteCollectionOldOsProdservlote : osProdservloteCollectionOld) {
                if (!osProdservloteCollectionNew.contains(osProdservloteCollectionOldOsProdservlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsProdservlote " + osProdservloteCollectionOldOsProdservlote + " since its codprodserv field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codosNew != null) {
                codosNew = em.getReference(codosNew.getClass(), codosNew.getCodos());
                osProdserv.setCodos(codosNew);
            }
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                osProdserv.setCodpreco(codprecoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                osProdserv.setCodprod(codprodNew);
            }
            Collection<OsProdservserial> attachedOsProdservserialCollectionNew = new ArrayList<OsProdservserial>();
            for (OsProdservserial osProdservserialCollectionNewOsProdservserialToAttach : osProdservserialCollectionNew) {
                osProdservserialCollectionNewOsProdservserialToAttach = em.getReference(osProdservserialCollectionNewOsProdservserialToAttach.getClass(), osProdservserialCollectionNewOsProdservserialToAttach.getCodprodservserial());
                attachedOsProdservserialCollectionNew.add(osProdservserialCollectionNewOsProdservserialToAttach);
            }
            osProdservserialCollectionNew = attachedOsProdservserialCollectionNew;
            osProdserv.setOsProdservserialCollection(osProdservserialCollectionNew);
            Collection<OsProdservlote> attachedOsProdservloteCollectionNew = new ArrayList<OsProdservlote>();
            for (OsProdservlote osProdservloteCollectionNewOsProdservloteToAttach : osProdservloteCollectionNew) {
                osProdservloteCollectionNewOsProdservloteToAttach = em.getReference(osProdservloteCollectionNewOsProdservloteToAttach.getClass(), osProdservloteCollectionNewOsProdservloteToAttach.getCodprodservlote());
                attachedOsProdservloteCollectionNew.add(osProdservloteCollectionNewOsProdservloteToAttach);
            }
            osProdservloteCollectionNew = attachedOsProdservloteCollectionNew;
            osProdserv.setOsProdservloteCollection(osProdservloteCollectionNew);
            osProdserv = em.merge(osProdserv);
            if (codosOld != null && !codosOld.equals(codosNew)) {
                codosOld.getOsProdservCollection().remove(osProdserv);
                codosOld = em.merge(codosOld);
            }
            if (codosNew != null && !codosNew.equals(codosOld)) {
                codosNew.getOsProdservCollection().add(osProdserv);
                codosNew = em.merge(codosNew);
            }
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getOsProdservCollection().remove(osProdserv);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getOsProdservCollection().add(osProdserv);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getOsProdservCollection().remove(osProdserv);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getOsProdservCollection().add(osProdserv);
                codprodNew = em.merge(codprodNew);
            }
            for (OsProdservserial osProdservserialCollectionOldOsProdservserial : osProdservserialCollectionOld) {
                if (!osProdservserialCollectionNew.contains(osProdservserialCollectionOldOsProdservserial)) {
                    osProdservserialCollectionOldOsProdservserial.setCodprodserv(null);
                    osProdservserialCollectionOldOsProdservserial = em.merge(osProdservserialCollectionOldOsProdservserial);
                }
            }
            for (OsProdservserial osProdservserialCollectionNewOsProdservserial : osProdservserialCollectionNew) {
                if (!osProdservserialCollectionOld.contains(osProdservserialCollectionNewOsProdservserial)) {
                    OsProdserv oldCodprodservOfOsProdservserialCollectionNewOsProdservserial = osProdservserialCollectionNewOsProdservserial.getCodprodserv();
                    osProdservserialCollectionNewOsProdservserial.setCodprodserv(osProdserv);
                    osProdservserialCollectionNewOsProdservserial = em.merge(osProdservserialCollectionNewOsProdservserial);
                    if (oldCodprodservOfOsProdservserialCollectionNewOsProdservserial != null && !oldCodprodservOfOsProdservserialCollectionNewOsProdservserial.equals(osProdserv)) {
                        oldCodprodservOfOsProdservserialCollectionNewOsProdservserial.getOsProdservserialCollection().remove(osProdservserialCollectionNewOsProdservserial);
                        oldCodprodservOfOsProdservserialCollectionNewOsProdservserial = em.merge(oldCodprodservOfOsProdservserialCollectionNewOsProdservserial);
                    }
                }
            }
            for (OsProdservlote osProdservloteCollectionNewOsProdservlote : osProdservloteCollectionNew) {
                if (!osProdservloteCollectionOld.contains(osProdservloteCollectionNewOsProdservlote)) {
                    OsProdserv oldCodprodservOfOsProdservloteCollectionNewOsProdservlote = osProdservloteCollectionNewOsProdservlote.getCodprodserv();
                    osProdservloteCollectionNewOsProdservlote.setCodprodserv(osProdserv);
                    osProdservloteCollectionNewOsProdservlote = em.merge(osProdservloteCollectionNewOsProdservlote);
                    if (oldCodprodservOfOsProdservloteCollectionNewOsProdservlote != null && !oldCodprodservOfOsProdservloteCollectionNewOsProdservlote.equals(osProdserv)) {
                        oldCodprodservOfOsProdservloteCollectionNewOsProdservlote.getOsProdservloteCollection().remove(osProdservloteCollectionNewOsProdservlote);
                        oldCodprodservOfOsProdservloteCollectionNewOsProdservlote = em.merge(oldCodprodservOfOsProdservloteCollectionNewOsProdservlote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osProdserv.getCodprodserv();
                if (findOsProdserv(id) == null) {
                    throw new NonexistentEntityException("The osProdserv with id " + id + " no longer exists.");
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
            OsProdserv osProdserv;
            try {
                osProdserv = em.getReference(OsProdserv.class, id);
                osProdserv.getCodprodserv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osProdserv with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<OsProdservlote> osProdservloteCollectionOrphanCheck = osProdserv.getOsProdservloteCollection();
            for (OsProdservlote osProdservloteCollectionOrphanCheckOsProdservlote : osProdservloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsProdserv (" + osProdserv + ") cannot be destroyed since the OsProdservlote " + osProdservloteCollectionOrphanCheckOsProdservlote + " in its osProdservloteCollection field has a non-nullable codprodserv field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            OsOrdemservico codos = osProdserv.getCodos();
            if (codos != null) {
                codos.getOsProdservCollection().remove(osProdserv);
                codos = em.merge(codos);
            }
            Preco codpreco = osProdserv.getCodpreco();
            if (codpreco != null) {
                codpreco.getOsProdservCollection().remove(osProdserv);
                codpreco = em.merge(codpreco);
            }
            Produto codprod = osProdserv.getCodprod();
            if (codprod != null) {
                codprod.getOsProdservCollection().remove(osProdserv);
                codprod = em.merge(codprod);
            }
            Collection<OsProdservserial> osProdservserialCollection = osProdserv.getOsProdservserialCollection();
            for (OsProdservserial osProdservserialCollectionOsProdservserial : osProdservserialCollection) {
                osProdservserialCollectionOsProdservserial.setCodprodserv(null);
                osProdservserialCollectionOsProdservserial = em.merge(osProdservserialCollectionOsProdservserial);
            }
            em.remove(osProdserv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsProdserv> findOsProdservEntities() {
        return findOsProdservEntities(true, -1, -1);
    }

    public List<OsProdserv> findOsProdservEntities(int maxResults, int firstResult) {
        return findOsProdservEntities(false, maxResults, firstResult);
    }

    private List<OsProdserv> findOsProdservEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsProdserv.class));
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

    public OsProdserv findOsProdserv(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsProdserv.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsProdservCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsProdserv> rt = cq.from(OsProdserv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
