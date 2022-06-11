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
import entidade.cplus.Cfop;
import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Regracfop;
import entidade.cplus.Regracfopitem;
import entidade.cplus.Tipomovimento;
import entidade.cplus.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RegracfopitemJpaController implements Serializable {

    public RegracfopitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Regracfopitem regracfopitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop codcfop = regracfopitem.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                regracfopitem.setCodcfop(codcfop);
            }
            Classificacaofiscal codclassificacaofiscal = regracfopitem.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal = em.getReference(codclassificacaofiscal.getClass(), codclassificacaofiscal.getCodclassificacaofiscal());
                regracfopitem.setCodclassificacaofiscal(codclassificacaofiscal);
            }
            Regracfop codregracfop = regracfopitem.getCodregracfop();
            if (codregracfop != null) {
                codregracfop = em.getReference(codregracfop.getClass(), codregracfop.getCodregracfop());
                regracfopitem.setCodregracfop(codregracfop);
            }
            Tipomovimento codtipomovimento = regracfopitem.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento = em.getReference(codtipomovimento.getClass(), codtipomovimento.getCodtipomovimento());
                regracfopitem.setCodtipomovimento(codtipomovimento);
            }
            Uf coduf = regracfopitem.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                regracfopitem.setCoduf(coduf);
            }
            em.persist(regracfopitem);
            if (codcfop != null) {
                codcfop.getRegracfopitemCollection().add(regracfopitem);
                codcfop = em.merge(codcfop);
            }
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getRegracfopitemCollection().add(regracfopitem);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            if (codregracfop != null) {
                codregracfop.getRegracfopitemCollection().add(regracfopitem);
                codregracfop = em.merge(codregracfop);
            }
            if (codtipomovimento != null) {
                codtipomovimento.getRegracfopitemCollection().add(regracfopitem);
                codtipomovimento = em.merge(codtipomovimento);
            }
            if (coduf != null) {
                coduf.getRegracfopitemCollection().add(regracfopitem);
                coduf = em.merge(coduf);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegracfopitem(regracfopitem.getCodregracfopitem()) != null) {
                throw new PreexistingEntityException("Regracfopitem " + regracfopitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Regracfopitem regracfopitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Regracfopitem persistentRegracfopitem = em.find(Regracfopitem.class, regracfopitem.getCodregracfopitem());
            Cfop codcfopOld = persistentRegracfopitem.getCodcfop();
            Cfop codcfopNew = regracfopitem.getCodcfop();
            Classificacaofiscal codclassificacaofiscalOld = persistentRegracfopitem.getCodclassificacaofiscal();
            Classificacaofiscal codclassificacaofiscalNew = regracfopitem.getCodclassificacaofiscal();
            Regracfop codregracfopOld = persistentRegracfopitem.getCodregracfop();
            Regracfop codregracfopNew = regracfopitem.getCodregracfop();
            Tipomovimento codtipomovimentoOld = persistentRegracfopitem.getCodtipomovimento();
            Tipomovimento codtipomovimentoNew = regracfopitem.getCodtipomovimento();
            Uf codufOld = persistentRegracfopitem.getCoduf();
            Uf codufNew = regracfopitem.getCoduf();
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                regracfopitem.setCodcfop(codcfopNew);
            }
            if (codclassificacaofiscalNew != null) {
                codclassificacaofiscalNew = em.getReference(codclassificacaofiscalNew.getClass(), codclassificacaofiscalNew.getCodclassificacaofiscal());
                regracfopitem.setCodclassificacaofiscal(codclassificacaofiscalNew);
            }
            if (codregracfopNew != null) {
                codregracfopNew = em.getReference(codregracfopNew.getClass(), codregracfopNew.getCodregracfop());
                regracfopitem.setCodregracfop(codregracfopNew);
            }
            if (codtipomovimentoNew != null) {
                codtipomovimentoNew = em.getReference(codtipomovimentoNew.getClass(), codtipomovimentoNew.getCodtipomovimento());
                regracfopitem.setCodtipomovimento(codtipomovimentoNew);
            }
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                regracfopitem.setCoduf(codufNew);
            }
            regracfopitem = em.merge(regracfopitem);
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getRegracfopitemCollection().remove(regracfopitem);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getRegracfopitemCollection().add(regracfopitem);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codclassificacaofiscalOld != null && !codclassificacaofiscalOld.equals(codclassificacaofiscalNew)) {
                codclassificacaofiscalOld.getRegracfopitemCollection().remove(regracfopitem);
                codclassificacaofiscalOld = em.merge(codclassificacaofiscalOld);
            }
            if (codclassificacaofiscalNew != null && !codclassificacaofiscalNew.equals(codclassificacaofiscalOld)) {
                codclassificacaofiscalNew.getRegracfopitemCollection().add(regracfopitem);
                codclassificacaofiscalNew = em.merge(codclassificacaofiscalNew);
            }
            if (codregracfopOld != null && !codregracfopOld.equals(codregracfopNew)) {
                codregracfopOld.getRegracfopitemCollection().remove(regracfopitem);
                codregracfopOld = em.merge(codregracfopOld);
            }
            if (codregracfopNew != null && !codregracfopNew.equals(codregracfopOld)) {
                codregracfopNew.getRegracfopitemCollection().add(regracfopitem);
                codregracfopNew = em.merge(codregracfopNew);
            }
            if (codtipomovimentoOld != null && !codtipomovimentoOld.equals(codtipomovimentoNew)) {
                codtipomovimentoOld.getRegracfopitemCollection().remove(regracfopitem);
                codtipomovimentoOld = em.merge(codtipomovimentoOld);
            }
            if (codtipomovimentoNew != null && !codtipomovimentoNew.equals(codtipomovimentoOld)) {
                codtipomovimentoNew.getRegracfopitemCollection().add(regracfopitem);
                codtipomovimentoNew = em.merge(codtipomovimentoNew);
            }
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getRegracfopitemCollection().remove(regracfopitem);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getRegracfopitemCollection().add(regracfopitem);
                codufNew = em.merge(codufNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = regracfopitem.getCodregracfopitem();
                if (findRegracfopitem(id) == null) {
                    throw new NonexistentEntityException("The regracfopitem with id " + id + " no longer exists.");
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
            Regracfopitem regracfopitem;
            try {
                regracfopitem = em.getReference(Regracfopitem.class, id);
                regracfopitem.getCodregracfopitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The regracfopitem with id " + id + " no longer exists.", enfe);
            }
            Cfop codcfop = regracfopitem.getCodcfop();
            if (codcfop != null) {
                codcfop.getRegracfopitemCollection().remove(regracfopitem);
                codcfop = em.merge(codcfop);
            }
            Classificacaofiscal codclassificacaofiscal = regracfopitem.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getRegracfopitemCollection().remove(regracfopitem);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            Regracfop codregracfop = regracfopitem.getCodregracfop();
            if (codregracfop != null) {
                codregracfop.getRegracfopitemCollection().remove(regracfopitem);
                codregracfop = em.merge(codregracfop);
            }
            Tipomovimento codtipomovimento = regracfopitem.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento.getRegracfopitemCollection().remove(regracfopitem);
                codtipomovimento = em.merge(codtipomovimento);
            }
            Uf coduf = regracfopitem.getCoduf();
            if (coduf != null) {
                coduf.getRegracfopitemCollection().remove(regracfopitem);
                coduf = em.merge(coduf);
            }
            em.remove(regracfopitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Regracfopitem> findRegracfopitemEntities() {
        return findRegracfopitemEntities(true, -1, -1);
    }

    public List<Regracfopitem> findRegracfopitemEntities(int maxResults, int firstResult) {
        return findRegracfopitemEntities(false, maxResults, firstResult);
    }

    private List<Regracfopitem> findRegracfopitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Regracfopitem.class));
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

    public Regracfopitem findRegracfopitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Regracfopitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegracfopitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Regracfopitem> rt = cq.from(Regracfopitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
