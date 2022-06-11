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
import entidade.cplus.Conferenciacaixa;
import entidade.cplus.Conferenciacaixaitem;
import entidade.cplus.Recebimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConferenciacaixaitemJpaController implements Serializable {

    public ConferenciacaixaitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conferenciacaixaitem conferenciacaixaitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciacaixa codconferenciacaixa = conferenciacaixaitem.getCodconferenciacaixa();
            if (codconferenciacaixa != null) {
                codconferenciacaixa = em.getReference(codconferenciacaixa.getClass(), codconferenciacaixa.getCodconferenciacaixa());
                conferenciacaixaitem.setCodconferenciacaixa(codconferenciacaixa);
            }
            Recebimento codrec = conferenciacaixaitem.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                conferenciacaixaitem.setCodrec(codrec);
            }
            em.persist(conferenciacaixaitem);
            if (codconferenciacaixa != null) {
                codconferenciacaixa.getConferenciacaixaitemCollection().add(conferenciacaixaitem);
                codconferenciacaixa = em.merge(codconferenciacaixa);
            }
            if (codrec != null) {
                codrec.getConferenciacaixaitemCollection().add(conferenciacaixaitem);
                codrec = em.merge(codrec);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConferenciacaixaitem(conferenciacaixaitem.getCodconferenciacaixaitem()) != null) {
                throw new PreexistingEntityException("Conferenciacaixaitem " + conferenciacaixaitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conferenciacaixaitem conferenciacaixaitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conferenciacaixaitem persistentConferenciacaixaitem = em.find(Conferenciacaixaitem.class, conferenciacaixaitem.getCodconferenciacaixaitem());
            Conferenciacaixa codconferenciacaixaOld = persistentConferenciacaixaitem.getCodconferenciacaixa();
            Conferenciacaixa codconferenciacaixaNew = conferenciacaixaitem.getCodconferenciacaixa();
            Recebimento codrecOld = persistentConferenciacaixaitem.getCodrec();
            Recebimento codrecNew = conferenciacaixaitem.getCodrec();
            if (codconferenciacaixaNew != null) {
                codconferenciacaixaNew = em.getReference(codconferenciacaixaNew.getClass(), codconferenciacaixaNew.getCodconferenciacaixa());
                conferenciacaixaitem.setCodconferenciacaixa(codconferenciacaixaNew);
            }
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                conferenciacaixaitem.setCodrec(codrecNew);
            }
            conferenciacaixaitem = em.merge(conferenciacaixaitem);
            if (codconferenciacaixaOld != null && !codconferenciacaixaOld.equals(codconferenciacaixaNew)) {
                codconferenciacaixaOld.getConferenciacaixaitemCollection().remove(conferenciacaixaitem);
                codconferenciacaixaOld = em.merge(codconferenciacaixaOld);
            }
            if (codconferenciacaixaNew != null && !codconferenciacaixaNew.equals(codconferenciacaixaOld)) {
                codconferenciacaixaNew.getConferenciacaixaitemCollection().add(conferenciacaixaitem);
                codconferenciacaixaNew = em.merge(codconferenciacaixaNew);
            }
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getConferenciacaixaitemCollection().remove(conferenciacaixaitem);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getConferenciacaixaitemCollection().add(conferenciacaixaitem);
                codrecNew = em.merge(codrecNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conferenciacaixaitem.getCodconferenciacaixaitem();
                if (findConferenciacaixaitem(id) == null) {
                    throw new NonexistentEntityException("The conferenciacaixaitem with id " + id + " no longer exists.");
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
            Conferenciacaixaitem conferenciacaixaitem;
            try {
                conferenciacaixaitem = em.getReference(Conferenciacaixaitem.class, id);
                conferenciacaixaitem.getCodconferenciacaixaitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conferenciacaixaitem with id " + id + " no longer exists.", enfe);
            }
            Conferenciacaixa codconferenciacaixa = conferenciacaixaitem.getCodconferenciacaixa();
            if (codconferenciacaixa != null) {
                codconferenciacaixa.getConferenciacaixaitemCollection().remove(conferenciacaixaitem);
                codconferenciacaixa = em.merge(codconferenciacaixa);
            }
            Recebimento codrec = conferenciacaixaitem.getCodrec();
            if (codrec != null) {
                codrec.getConferenciacaixaitemCollection().remove(conferenciacaixaitem);
                codrec = em.merge(codrec);
            }
            em.remove(conferenciacaixaitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conferenciacaixaitem> findConferenciacaixaitemEntities() {
        return findConferenciacaixaitemEntities(true, -1, -1);
    }

    public List<Conferenciacaixaitem> findConferenciacaixaitemEntities(int maxResults, int firstResult) {
        return findConferenciacaixaitemEntities(false, maxResults, firstResult);
    }

    private List<Conferenciacaixaitem> findConferenciacaixaitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conferenciacaixaitem.class));
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

    public Conferenciacaixaitem findConferenciacaixaitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conferenciacaixaitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getConferenciacaixaitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conferenciacaixaitem> rt = cq.from(Conferenciacaixaitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
