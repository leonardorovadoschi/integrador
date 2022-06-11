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
import entidade.cplus.Orcamento;
import entidade.cplus.Orcamentorec;
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
public class OrcamentorecJpaController implements Serializable {

    public OrcamentorecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentorec orcamentorec) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamento codorc = orcamentorec.getCodorc();
            if (codorc != null) {
                codorc = em.getReference(codorc.getClass(), codorc.getCodorc());
                orcamentorec.setCodorc(codorc);
            }
            Recebimento codrec = orcamentorec.getCodrec();
            if (codrec != null) {
                codrec = em.getReference(codrec.getClass(), codrec.getCodrec());
                orcamentorec.setCodrec(codrec);
            }
            em.persist(orcamentorec);
            if (codorc != null) {
                codorc.getOrcamentorecCollection().add(orcamentorec);
                codorc = em.merge(codorc);
            }
            if (codrec != null) {
                codrec.getOrcamentorecCollection().add(orcamentorec);
                codrec = em.merge(codrec);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentorec(orcamentorec.getCodorcamentorec()) != null) {
                throw new PreexistingEntityException("Orcamentorec " + orcamentorec + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentorec orcamentorec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentorec persistentOrcamentorec = em.find(Orcamentorec.class, orcamentorec.getCodorcamentorec());
            Orcamento codorcOld = persistentOrcamentorec.getCodorc();
            Orcamento codorcNew = orcamentorec.getCodorc();
            Recebimento codrecOld = persistentOrcamentorec.getCodrec();
            Recebimento codrecNew = orcamentorec.getCodrec();
            if (codorcNew != null) {
                codorcNew = em.getReference(codorcNew.getClass(), codorcNew.getCodorc());
                orcamentorec.setCodorc(codorcNew);
            }
            if (codrecNew != null) {
                codrecNew = em.getReference(codrecNew.getClass(), codrecNew.getCodrec());
                orcamentorec.setCodrec(codrecNew);
            }
            orcamentorec = em.merge(orcamentorec);
            if (codorcOld != null && !codorcOld.equals(codorcNew)) {
                codorcOld.getOrcamentorecCollection().remove(orcamentorec);
                codorcOld = em.merge(codorcOld);
            }
            if (codorcNew != null && !codorcNew.equals(codorcOld)) {
                codorcNew.getOrcamentorecCollection().add(orcamentorec);
                codorcNew = em.merge(codorcNew);
            }
            if (codrecOld != null && !codrecOld.equals(codrecNew)) {
                codrecOld.getOrcamentorecCollection().remove(orcamentorec);
                codrecOld = em.merge(codrecOld);
            }
            if (codrecNew != null && !codrecNew.equals(codrecOld)) {
                codrecNew.getOrcamentorecCollection().add(orcamentorec);
                codrecNew = em.merge(codrecNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentorec.getCodorcamentorec();
                if (findOrcamentorec(id) == null) {
                    throw new NonexistentEntityException("The orcamentorec with id " + id + " no longer exists.");
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
            Orcamentorec orcamentorec;
            try {
                orcamentorec = em.getReference(Orcamentorec.class, id);
                orcamentorec.getCodorcamentorec();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentorec with id " + id + " no longer exists.", enfe);
            }
            Orcamento codorc = orcamentorec.getCodorc();
            if (codorc != null) {
                codorc.getOrcamentorecCollection().remove(orcamentorec);
                codorc = em.merge(codorc);
            }
            Recebimento codrec = orcamentorec.getCodrec();
            if (codrec != null) {
                codrec.getOrcamentorecCollection().remove(orcamentorec);
                codrec = em.merge(codrec);
            }
            em.remove(orcamentorec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentorec> findOrcamentorecEntities() {
        return findOrcamentorecEntities(true, -1, -1);
    }

    public List<Orcamentorec> findOrcamentorecEntities(int maxResults, int firstResult) {
        return findOrcamentorecEntities(false, maxResults, firstResult);
    }

    private List<Orcamentorec> findOrcamentorecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentorec.class));
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

    public Orcamentorec findOrcamentorec(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentorec.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentorecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentorec> rt = cq.from(Orcamentorec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
