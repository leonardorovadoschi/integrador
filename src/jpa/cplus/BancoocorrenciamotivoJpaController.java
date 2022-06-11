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
import entidade.cplus.Bancoocorrencia;
import entidade.cplus.Bancoocorrenciamotivo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class BancoocorrenciamotivoJpaController implements Serializable {

    public BancoocorrenciamotivoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bancoocorrenciamotivo bancoocorrenciamotivo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancoocorrencia codbancoocorrencia = bancoocorrenciamotivo.getCodbancoocorrencia();
            if (codbancoocorrencia != null) {
                codbancoocorrencia = em.getReference(codbancoocorrencia.getClass(), codbancoocorrencia.getCodbancoocorrencia());
                bancoocorrenciamotivo.setCodbancoocorrencia(codbancoocorrencia);
            }
            em.persist(bancoocorrenciamotivo);
            if (codbancoocorrencia != null) {
                codbancoocorrencia.getBancoocorrenciamotivoCollection().add(bancoocorrenciamotivo);
                codbancoocorrencia = em.merge(codbancoocorrencia);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBancoocorrenciamotivo(bancoocorrenciamotivo.getCodbancoocorrenciamotivo()) != null) {
                throw new PreexistingEntityException("Bancoocorrenciamotivo " + bancoocorrenciamotivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bancoocorrenciamotivo bancoocorrenciamotivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bancoocorrenciamotivo persistentBancoocorrenciamotivo = em.find(Bancoocorrenciamotivo.class, bancoocorrenciamotivo.getCodbancoocorrenciamotivo());
            Bancoocorrencia codbancoocorrenciaOld = persistentBancoocorrenciamotivo.getCodbancoocorrencia();
            Bancoocorrencia codbancoocorrenciaNew = bancoocorrenciamotivo.getCodbancoocorrencia();
            if (codbancoocorrenciaNew != null) {
                codbancoocorrenciaNew = em.getReference(codbancoocorrenciaNew.getClass(), codbancoocorrenciaNew.getCodbancoocorrencia());
                bancoocorrenciamotivo.setCodbancoocorrencia(codbancoocorrenciaNew);
            }
            bancoocorrenciamotivo = em.merge(bancoocorrenciamotivo);
            if (codbancoocorrenciaOld != null && !codbancoocorrenciaOld.equals(codbancoocorrenciaNew)) {
                codbancoocorrenciaOld.getBancoocorrenciamotivoCollection().remove(bancoocorrenciamotivo);
                codbancoocorrenciaOld = em.merge(codbancoocorrenciaOld);
            }
            if (codbancoocorrenciaNew != null && !codbancoocorrenciaNew.equals(codbancoocorrenciaOld)) {
                codbancoocorrenciaNew.getBancoocorrenciamotivoCollection().add(bancoocorrenciamotivo);
                codbancoocorrenciaNew = em.merge(codbancoocorrenciaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bancoocorrenciamotivo.getCodbancoocorrenciamotivo();
                if (findBancoocorrenciamotivo(id) == null) {
                    throw new NonexistentEntityException("The bancoocorrenciamotivo with id " + id + " no longer exists.");
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
            Bancoocorrenciamotivo bancoocorrenciamotivo;
            try {
                bancoocorrenciamotivo = em.getReference(Bancoocorrenciamotivo.class, id);
                bancoocorrenciamotivo.getCodbancoocorrenciamotivo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bancoocorrenciamotivo with id " + id + " no longer exists.", enfe);
            }
            Bancoocorrencia codbancoocorrencia = bancoocorrenciamotivo.getCodbancoocorrencia();
            if (codbancoocorrencia != null) {
                codbancoocorrencia.getBancoocorrenciamotivoCollection().remove(bancoocorrenciamotivo);
                codbancoocorrencia = em.merge(codbancoocorrencia);
            }
            em.remove(bancoocorrenciamotivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bancoocorrenciamotivo> findBancoocorrenciamotivoEntities() {
        return findBancoocorrenciamotivoEntities(true, -1, -1);
    }

    public List<Bancoocorrenciamotivo> findBancoocorrenciamotivoEntities(int maxResults, int firstResult) {
        return findBancoocorrenciamotivoEntities(false, maxResults, firstResult);
    }

    private List<Bancoocorrenciamotivo> findBancoocorrenciamotivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bancoocorrenciamotivo.class));
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

    public Bancoocorrenciamotivo findBancoocorrenciamotivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bancoocorrenciamotivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getBancoocorrenciamotivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bancoocorrenciamotivo> rt = cq.from(Bancoocorrenciamotivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
