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
import entidade.cplus.Cidade;
import entidade.cplus.Regiao;
import entidade.cplus.Regiaocidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RegiaocidadeJpaController implements Serializable {

    public RegiaocidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Regiaocidade regiaocidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidade codcidade = regiaocidade.getCodcidade();
            if (codcidade != null) {
                codcidade = em.getReference(codcidade.getClass(), codcidade.getCodcidade());
                regiaocidade.setCodcidade(codcidade);
            }
            Regiao codregiao = regiaocidade.getCodregiao();
            if (codregiao != null) {
                codregiao = em.getReference(codregiao.getClass(), codregiao.getCodregiao());
                regiaocidade.setCodregiao(codregiao);
            }
            em.persist(regiaocidade);
            if (codcidade != null) {
                codcidade.getRegiaocidadeCollection().add(regiaocidade);
                codcidade = em.merge(codcidade);
            }
            if (codregiao != null) {
                codregiao.getRegiaocidadeCollection().add(regiaocidade);
                codregiao = em.merge(codregiao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegiaocidade(regiaocidade.getCodregiaocidade()) != null) {
                throw new PreexistingEntityException("Regiaocidade " + regiaocidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Regiaocidade regiaocidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Regiaocidade persistentRegiaocidade = em.find(Regiaocidade.class, regiaocidade.getCodregiaocidade());
            Cidade codcidadeOld = persistentRegiaocidade.getCodcidade();
            Cidade codcidadeNew = regiaocidade.getCodcidade();
            Regiao codregiaoOld = persistentRegiaocidade.getCodregiao();
            Regiao codregiaoNew = regiaocidade.getCodregiao();
            if (codcidadeNew != null) {
                codcidadeNew = em.getReference(codcidadeNew.getClass(), codcidadeNew.getCodcidade());
                regiaocidade.setCodcidade(codcidadeNew);
            }
            if (codregiaoNew != null) {
                codregiaoNew = em.getReference(codregiaoNew.getClass(), codregiaoNew.getCodregiao());
                regiaocidade.setCodregiao(codregiaoNew);
            }
            regiaocidade = em.merge(regiaocidade);
            if (codcidadeOld != null && !codcidadeOld.equals(codcidadeNew)) {
                codcidadeOld.getRegiaocidadeCollection().remove(regiaocidade);
                codcidadeOld = em.merge(codcidadeOld);
            }
            if (codcidadeNew != null && !codcidadeNew.equals(codcidadeOld)) {
                codcidadeNew.getRegiaocidadeCollection().add(regiaocidade);
                codcidadeNew = em.merge(codcidadeNew);
            }
            if (codregiaoOld != null && !codregiaoOld.equals(codregiaoNew)) {
                codregiaoOld.getRegiaocidadeCollection().remove(regiaocidade);
                codregiaoOld = em.merge(codregiaoOld);
            }
            if (codregiaoNew != null && !codregiaoNew.equals(codregiaoOld)) {
                codregiaoNew.getRegiaocidadeCollection().add(regiaocidade);
                codregiaoNew = em.merge(codregiaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = regiaocidade.getCodregiaocidade();
                if (findRegiaocidade(id) == null) {
                    throw new NonexistentEntityException("The regiaocidade with id " + id + " no longer exists.");
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
            Regiaocidade regiaocidade;
            try {
                regiaocidade = em.getReference(Regiaocidade.class, id);
                regiaocidade.getCodregiaocidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The regiaocidade with id " + id + " no longer exists.", enfe);
            }
            Cidade codcidade = regiaocidade.getCodcidade();
            if (codcidade != null) {
                codcidade.getRegiaocidadeCollection().remove(regiaocidade);
                codcidade = em.merge(codcidade);
            }
            Regiao codregiao = regiaocidade.getCodregiao();
            if (codregiao != null) {
                codregiao.getRegiaocidadeCollection().remove(regiaocidade);
                codregiao = em.merge(codregiao);
            }
            em.remove(regiaocidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Regiaocidade> findRegiaocidadeEntities() {
        return findRegiaocidadeEntities(true, -1, -1);
    }

    public List<Regiaocidade> findRegiaocidadeEntities(int maxResults, int firstResult) {
        return findRegiaocidadeEntities(false, maxResults, firstResult);
    }

    private List<Regiaocidade> findRegiaocidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Regiaocidade.class));
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

    public Regiaocidade findRegiaocidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Regiaocidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegiaocidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Regiaocidade> rt = cq.from(Regiaocidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
