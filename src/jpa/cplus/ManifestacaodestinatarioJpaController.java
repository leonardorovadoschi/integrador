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
import entidade.cplus.Empresa;
import entidade.cplus.Manifestacaodestinatario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ManifestacaodestinatarioJpaController implements Serializable {

    public ManifestacaodestinatarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Manifestacaodestinatario manifestacaodestinatario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = manifestacaodestinatario.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                manifestacaodestinatario.setCodempresa(codempresa);
            }
            em.persist(manifestacaodestinatario);
            if (codempresa != null) {
                codempresa.getManifestacaodestinatarioCollection().add(manifestacaodestinatario);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findManifestacaodestinatario(manifestacaodestinatario.getCodmanifestacaodestinatario()) != null) {
                throw new PreexistingEntityException("Manifestacaodestinatario " + manifestacaodestinatario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Manifestacaodestinatario manifestacaodestinatario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Manifestacaodestinatario persistentManifestacaodestinatario = em.find(Manifestacaodestinatario.class, manifestacaodestinatario.getCodmanifestacaodestinatario());
            Empresa codempresaOld = persistentManifestacaodestinatario.getCodempresa();
            Empresa codempresaNew = manifestacaodestinatario.getCodempresa();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                manifestacaodestinatario.setCodempresa(codempresaNew);
            }
            manifestacaodestinatario = em.merge(manifestacaodestinatario);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getManifestacaodestinatarioCollection().remove(manifestacaodestinatario);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getManifestacaodestinatarioCollection().add(manifestacaodestinatario);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = manifestacaodestinatario.getCodmanifestacaodestinatario();
                if (findManifestacaodestinatario(id) == null) {
                    throw new NonexistentEntityException("The manifestacaodestinatario with id " + id + " no longer exists.");
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
            Manifestacaodestinatario manifestacaodestinatario;
            try {
                manifestacaodestinatario = em.getReference(Manifestacaodestinatario.class, id);
                manifestacaodestinatario.getCodmanifestacaodestinatario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The manifestacaodestinatario with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = manifestacaodestinatario.getCodempresa();
            if (codempresa != null) {
                codempresa.getManifestacaodestinatarioCollection().remove(manifestacaodestinatario);
                codempresa = em.merge(codempresa);
            }
            em.remove(manifestacaodestinatario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Manifestacaodestinatario> findManifestacaodestinatarioEntities() {
        return findManifestacaodestinatarioEntities(true, -1, -1);
    }

    public List<Manifestacaodestinatario> findManifestacaodestinatarioEntities(int maxResults, int firstResult) {
        return findManifestacaodestinatarioEntities(false, maxResults, firstResult);
    }

    private List<Manifestacaodestinatario> findManifestacaodestinatarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Manifestacaodestinatario.class));
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

    public Manifestacaodestinatario findManifestacaodestinatario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Manifestacaodestinatario.class, id);
        } finally {
            em.close();
        }
    }

    public int getManifestacaodestinatarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Manifestacaodestinatario> rt = cq.from(Manifestacaodestinatario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
