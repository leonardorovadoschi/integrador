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
import entidade.cplus.Entregapessoa;
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicocondutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletronicocondutorJpaController implements Serializable {

    public MdfeletronicocondutorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicocondutor mdfeletronicocondutor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entregapessoa codentregapessoa = mdfeletronicocondutor.getCodentregapessoa();
            if (codentregapessoa != null) {
                codentregapessoa = em.getReference(codentregapessoa.getClass(), codentregapessoa.getCodentregapessoa());
                mdfeletronicocondutor.setCodentregapessoa(codentregapessoa);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicocondutor.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicocondutor.setCodmdfeletronico(codmdfeletronico);
            }
            em.persist(mdfeletronicocondutor);
            if (codentregapessoa != null) {
                codentregapessoa.getMdfeletronicocondutorCollection().add(mdfeletronicocondutor);
                codentregapessoa = em.merge(codentregapessoa);
            }
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicocondutorCollection().add(mdfeletronicocondutor);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicocondutor(mdfeletronicocondutor.getCodmdfeletronicocondutor()) != null) {
                throw new PreexistingEntityException("Mdfeletronicocondutor " + mdfeletronicocondutor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicocondutor mdfeletronicocondutor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicocondutor persistentMdfeletronicocondutor = em.find(Mdfeletronicocondutor.class, mdfeletronicocondutor.getCodmdfeletronicocondutor());
            Entregapessoa codentregapessoaOld = persistentMdfeletronicocondutor.getCodentregapessoa();
            Entregapessoa codentregapessoaNew = mdfeletronicocondutor.getCodentregapessoa();
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicocondutor.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicocondutor.getCodmdfeletronico();
            if (codentregapessoaNew != null) {
                codentregapessoaNew = em.getReference(codentregapessoaNew.getClass(), codentregapessoaNew.getCodentregapessoa());
                mdfeletronicocondutor.setCodentregapessoa(codentregapessoaNew);
            }
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicocondutor.setCodmdfeletronico(codmdfeletronicoNew);
            }
            mdfeletronicocondutor = em.merge(mdfeletronicocondutor);
            if (codentregapessoaOld != null && !codentregapessoaOld.equals(codentregapessoaNew)) {
                codentregapessoaOld.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutor);
                codentregapessoaOld = em.merge(codentregapessoaOld);
            }
            if (codentregapessoaNew != null && !codentregapessoaNew.equals(codentregapessoaOld)) {
                codentregapessoaNew.getMdfeletronicocondutorCollection().add(mdfeletronicocondutor);
                codentregapessoaNew = em.merge(codentregapessoaNew);
            }
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutor);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicocondutorCollection().add(mdfeletronicocondutor);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicocondutor.getCodmdfeletronicocondutor();
                if (findMdfeletronicocondutor(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicocondutor with id " + id + " no longer exists.");
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
            Mdfeletronicocondutor mdfeletronicocondutor;
            try {
                mdfeletronicocondutor = em.getReference(Mdfeletronicocondutor.class, id);
                mdfeletronicocondutor.getCodmdfeletronicocondutor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicocondutor with id " + id + " no longer exists.", enfe);
            }
            Entregapessoa codentregapessoa = mdfeletronicocondutor.getCodentregapessoa();
            if (codentregapessoa != null) {
                codentregapessoa.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutor);
                codentregapessoa = em.merge(codentregapessoa);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicocondutor.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutor);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.remove(mdfeletronicocondutor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicocondutor> findMdfeletronicocondutorEntities() {
        return findMdfeletronicocondutorEntities(true, -1, -1);
    }

    public List<Mdfeletronicocondutor> findMdfeletronicocondutorEntities(int maxResults, int firstResult) {
        return findMdfeletronicocondutorEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicocondutor> findMdfeletronicocondutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicocondutor.class));
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

    public Mdfeletronicocondutor findMdfeletronicocondutor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicocondutor.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicocondutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicocondutor> rt = cq.from(Mdfeletronicocondutor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
