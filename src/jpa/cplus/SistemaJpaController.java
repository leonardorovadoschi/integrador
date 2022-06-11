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
import entidade.cplus.Cfgcenariogrid;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Sistemaacesso;
import entidade.cplus.Caixausuario;
import entidade.cplus.Relatorio;
import entidade.cplus.Sistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class SistemaJpaController implements Serializable {

    public SistemaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sistema sistema) throws PreexistingEntityException, Exception {
        if (sistema.getCfgcenariogridCollection() == null) {
            sistema.setCfgcenariogridCollection(new ArrayList<Cfgcenariogrid>());
        }
        if (sistema.getSistemaacessoCollection() == null) {
            sistema.setSistemaacessoCollection(new ArrayList<Sistemaacesso>());
        }
        if (sistema.getCaixausuarioCollection() == null) {
            sistema.setCaixausuarioCollection(new ArrayList<Caixausuario>());
        }
        if (sistema.getRelatorioCollection() == null) {
            sistema.setRelatorioCollection(new ArrayList<Relatorio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cfgcenariogrid> attachedCfgcenariogridCollection = new ArrayList<Cfgcenariogrid>();
            for (Cfgcenariogrid cfgcenariogridCollectionCfgcenariogridToAttach : sistema.getCfgcenariogridCollection()) {
                cfgcenariogridCollectionCfgcenariogridToAttach = em.getReference(cfgcenariogridCollectionCfgcenariogridToAttach.getClass(), cfgcenariogridCollectionCfgcenariogridToAttach.getCodcfgcenariogrid());
                attachedCfgcenariogridCollection.add(cfgcenariogridCollectionCfgcenariogridToAttach);
            }
            sistema.setCfgcenariogridCollection(attachedCfgcenariogridCollection);
            Collection<Sistemaacesso> attachedSistemaacessoCollection = new ArrayList<Sistemaacesso>();
            for (Sistemaacesso sistemaacessoCollectionSistemaacessoToAttach : sistema.getSistemaacessoCollection()) {
                sistemaacessoCollectionSistemaacessoToAttach = em.getReference(sistemaacessoCollectionSistemaacessoToAttach.getClass(), sistemaacessoCollectionSistemaacessoToAttach.getCodsistemaacesso());
                attachedSistemaacessoCollection.add(sistemaacessoCollectionSistemaacessoToAttach);
            }
            sistema.setSistemaacessoCollection(attachedSistemaacessoCollection);
            Collection<Caixausuario> attachedCaixausuarioCollection = new ArrayList<Caixausuario>();
            for (Caixausuario caixausuarioCollectionCaixausuarioToAttach : sistema.getCaixausuarioCollection()) {
                caixausuarioCollectionCaixausuarioToAttach = em.getReference(caixausuarioCollectionCaixausuarioToAttach.getClass(), caixausuarioCollectionCaixausuarioToAttach.getCodcaixausuario());
                attachedCaixausuarioCollection.add(caixausuarioCollectionCaixausuarioToAttach);
            }
            sistema.setCaixausuarioCollection(attachedCaixausuarioCollection);
            Collection<Relatorio> attachedRelatorioCollection = new ArrayList<Relatorio>();
            for (Relatorio relatorioCollectionRelatorioToAttach : sistema.getRelatorioCollection()) {
                relatorioCollectionRelatorioToAttach = em.getReference(relatorioCollectionRelatorioToAttach.getClass(), relatorioCollectionRelatorioToAttach.getId());
                attachedRelatorioCollection.add(relatorioCollectionRelatorioToAttach);
            }
            sistema.setRelatorioCollection(attachedRelatorioCollection);
            em.persist(sistema);
            for (Cfgcenariogrid cfgcenariogridCollectionCfgcenariogrid : sistema.getCfgcenariogridCollection()) {
                Sistema oldCodsistemaOfCfgcenariogridCollectionCfgcenariogrid = cfgcenariogridCollectionCfgcenariogrid.getCodsistema();
                cfgcenariogridCollectionCfgcenariogrid.setCodsistema(sistema);
                cfgcenariogridCollectionCfgcenariogrid = em.merge(cfgcenariogridCollectionCfgcenariogrid);
                if (oldCodsistemaOfCfgcenariogridCollectionCfgcenariogrid != null) {
                    oldCodsistemaOfCfgcenariogridCollectionCfgcenariogrid.getCfgcenariogridCollection().remove(cfgcenariogridCollectionCfgcenariogrid);
                    oldCodsistemaOfCfgcenariogridCollectionCfgcenariogrid = em.merge(oldCodsistemaOfCfgcenariogridCollectionCfgcenariogrid);
                }
            }
            for (Sistemaacesso sistemaacessoCollectionSistemaacesso : sistema.getSistemaacessoCollection()) {
                Sistema oldCodsistemaOfSistemaacessoCollectionSistemaacesso = sistemaacessoCollectionSistemaacesso.getCodsistema();
                sistemaacessoCollectionSistemaacesso.setCodsistema(sistema);
                sistemaacessoCollectionSistemaacesso = em.merge(sistemaacessoCollectionSistemaacesso);
                if (oldCodsistemaOfSistemaacessoCollectionSistemaacesso != null) {
                    oldCodsistemaOfSistemaacessoCollectionSistemaacesso.getSistemaacessoCollection().remove(sistemaacessoCollectionSistemaacesso);
                    oldCodsistemaOfSistemaacessoCollectionSistemaacesso = em.merge(oldCodsistemaOfSistemaacessoCollectionSistemaacesso);
                }
            }
            for (Caixausuario caixausuarioCollectionCaixausuario : sistema.getCaixausuarioCollection()) {
                Sistema oldCodsistemaOfCaixausuarioCollectionCaixausuario = caixausuarioCollectionCaixausuario.getCodsistema();
                caixausuarioCollectionCaixausuario.setCodsistema(sistema);
                caixausuarioCollectionCaixausuario = em.merge(caixausuarioCollectionCaixausuario);
                if (oldCodsistemaOfCaixausuarioCollectionCaixausuario != null) {
                    oldCodsistemaOfCaixausuarioCollectionCaixausuario.getCaixausuarioCollection().remove(caixausuarioCollectionCaixausuario);
                    oldCodsistemaOfCaixausuarioCollectionCaixausuario = em.merge(oldCodsistemaOfCaixausuarioCollectionCaixausuario);
                }
            }
            for (Relatorio relatorioCollectionRelatorio : sistema.getRelatorioCollection()) {
                Sistema oldCodsistemaOfRelatorioCollectionRelatorio = relatorioCollectionRelatorio.getCodsistema();
                relatorioCollectionRelatorio.setCodsistema(sistema);
                relatorioCollectionRelatorio = em.merge(relatorioCollectionRelatorio);
                if (oldCodsistemaOfRelatorioCollectionRelatorio != null) {
                    oldCodsistemaOfRelatorioCollectionRelatorio.getRelatorioCollection().remove(relatorioCollectionRelatorio);
                    oldCodsistemaOfRelatorioCollectionRelatorio = em.merge(oldCodsistemaOfRelatorioCollectionRelatorio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSistema(sistema.getCodsistema()) != null) {
                throw new PreexistingEntityException("Sistema " + sistema + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sistema sistema) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistema persistentSistema = em.find(Sistema.class, sistema.getCodsistema());
            Collection<Cfgcenariogrid> cfgcenariogridCollectionOld = persistentSistema.getCfgcenariogridCollection();
            Collection<Cfgcenariogrid> cfgcenariogridCollectionNew = sistema.getCfgcenariogridCollection();
            Collection<Sistemaacesso> sistemaacessoCollectionOld = persistentSistema.getSistemaacessoCollection();
            Collection<Sistemaacesso> sistemaacessoCollectionNew = sistema.getSistemaacessoCollection();
            Collection<Caixausuario> caixausuarioCollectionOld = persistentSistema.getCaixausuarioCollection();
            Collection<Caixausuario> caixausuarioCollectionNew = sistema.getCaixausuarioCollection();
            Collection<Relatorio> relatorioCollectionOld = persistentSistema.getRelatorioCollection();
            Collection<Relatorio> relatorioCollectionNew = sistema.getRelatorioCollection();
            Collection<Cfgcenariogrid> attachedCfgcenariogridCollectionNew = new ArrayList<Cfgcenariogrid>();
            for (Cfgcenariogrid cfgcenariogridCollectionNewCfgcenariogridToAttach : cfgcenariogridCollectionNew) {
                cfgcenariogridCollectionNewCfgcenariogridToAttach = em.getReference(cfgcenariogridCollectionNewCfgcenariogridToAttach.getClass(), cfgcenariogridCollectionNewCfgcenariogridToAttach.getCodcfgcenariogrid());
                attachedCfgcenariogridCollectionNew.add(cfgcenariogridCollectionNewCfgcenariogridToAttach);
            }
            cfgcenariogridCollectionNew = attachedCfgcenariogridCollectionNew;
            sistema.setCfgcenariogridCollection(cfgcenariogridCollectionNew);
            Collection<Sistemaacesso> attachedSistemaacessoCollectionNew = new ArrayList<Sistemaacesso>();
            for (Sistemaacesso sistemaacessoCollectionNewSistemaacessoToAttach : sistemaacessoCollectionNew) {
                sistemaacessoCollectionNewSistemaacessoToAttach = em.getReference(sistemaacessoCollectionNewSistemaacessoToAttach.getClass(), sistemaacessoCollectionNewSistemaacessoToAttach.getCodsistemaacesso());
                attachedSistemaacessoCollectionNew.add(sistemaacessoCollectionNewSistemaacessoToAttach);
            }
            sistemaacessoCollectionNew = attachedSistemaacessoCollectionNew;
            sistema.setSistemaacessoCollection(sistemaacessoCollectionNew);
            Collection<Caixausuario> attachedCaixausuarioCollectionNew = new ArrayList<Caixausuario>();
            for (Caixausuario caixausuarioCollectionNewCaixausuarioToAttach : caixausuarioCollectionNew) {
                caixausuarioCollectionNewCaixausuarioToAttach = em.getReference(caixausuarioCollectionNewCaixausuarioToAttach.getClass(), caixausuarioCollectionNewCaixausuarioToAttach.getCodcaixausuario());
                attachedCaixausuarioCollectionNew.add(caixausuarioCollectionNewCaixausuarioToAttach);
            }
            caixausuarioCollectionNew = attachedCaixausuarioCollectionNew;
            sistema.setCaixausuarioCollection(caixausuarioCollectionNew);
            Collection<Relatorio> attachedRelatorioCollectionNew = new ArrayList<Relatorio>();
            for (Relatorio relatorioCollectionNewRelatorioToAttach : relatorioCollectionNew) {
                relatorioCollectionNewRelatorioToAttach = em.getReference(relatorioCollectionNewRelatorioToAttach.getClass(), relatorioCollectionNewRelatorioToAttach.getId());
                attachedRelatorioCollectionNew.add(relatorioCollectionNewRelatorioToAttach);
            }
            relatorioCollectionNew = attachedRelatorioCollectionNew;
            sistema.setRelatorioCollection(relatorioCollectionNew);
            sistema = em.merge(sistema);
            for (Cfgcenariogrid cfgcenariogridCollectionOldCfgcenariogrid : cfgcenariogridCollectionOld) {
                if (!cfgcenariogridCollectionNew.contains(cfgcenariogridCollectionOldCfgcenariogrid)) {
                    cfgcenariogridCollectionOldCfgcenariogrid.setCodsistema(null);
                    cfgcenariogridCollectionOldCfgcenariogrid = em.merge(cfgcenariogridCollectionOldCfgcenariogrid);
                }
            }
            for (Cfgcenariogrid cfgcenariogridCollectionNewCfgcenariogrid : cfgcenariogridCollectionNew) {
                if (!cfgcenariogridCollectionOld.contains(cfgcenariogridCollectionNewCfgcenariogrid)) {
                    Sistema oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid = cfgcenariogridCollectionNewCfgcenariogrid.getCodsistema();
                    cfgcenariogridCollectionNewCfgcenariogrid.setCodsistema(sistema);
                    cfgcenariogridCollectionNewCfgcenariogrid = em.merge(cfgcenariogridCollectionNewCfgcenariogrid);
                    if (oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid != null && !oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid.equals(sistema)) {
                        oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid.getCfgcenariogridCollection().remove(cfgcenariogridCollectionNewCfgcenariogrid);
                        oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid = em.merge(oldCodsistemaOfCfgcenariogridCollectionNewCfgcenariogrid);
                    }
                }
            }
            for (Sistemaacesso sistemaacessoCollectionOldSistemaacesso : sistemaacessoCollectionOld) {
                if (!sistemaacessoCollectionNew.contains(sistemaacessoCollectionOldSistemaacesso)) {
                    sistemaacessoCollectionOldSistemaacesso.setCodsistema(null);
                    sistemaacessoCollectionOldSistemaacesso = em.merge(sistemaacessoCollectionOldSistemaacesso);
                }
            }
            for (Sistemaacesso sistemaacessoCollectionNewSistemaacesso : sistemaacessoCollectionNew) {
                if (!sistemaacessoCollectionOld.contains(sistemaacessoCollectionNewSistemaacesso)) {
                    Sistema oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso = sistemaacessoCollectionNewSistemaacesso.getCodsistema();
                    sistemaacessoCollectionNewSistemaacesso.setCodsistema(sistema);
                    sistemaacessoCollectionNewSistemaacesso = em.merge(sistemaacessoCollectionNewSistemaacesso);
                    if (oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso != null && !oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso.equals(sistema)) {
                        oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso.getSistemaacessoCollection().remove(sistemaacessoCollectionNewSistemaacesso);
                        oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso = em.merge(oldCodsistemaOfSistemaacessoCollectionNewSistemaacesso);
                    }
                }
            }
            for (Caixausuario caixausuarioCollectionOldCaixausuario : caixausuarioCollectionOld) {
                if (!caixausuarioCollectionNew.contains(caixausuarioCollectionOldCaixausuario)) {
                    caixausuarioCollectionOldCaixausuario.setCodsistema(null);
                    caixausuarioCollectionOldCaixausuario = em.merge(caixausuarioCollectionOldCaixausuario);
                }
            }
            for (Caixausuario caixausuarioCollectionNewCaixausuario : caixausuarioCollectionNew) {
                if (!caixausuarioCollectionOld.contains(caixausuarioCollectionNewCaixausuario)) {
                    Sistema oldCodsistemaOfCaixausuarioCollectionNewCaixausuario = caixausuarioCollectionNewCaixausuario.getCodsistema();
                    caixausuarioCollectionNewCaixausuario.setCodsistema(sistema);
                    caixausuarioCollectionNewCaixausuario = em.merge(caixausuarioCollectionNewCaixausuario);
                    if (oldCodsistemaOfCaixausuarioCollectionNewCaixausuario != null && !oldCodsistemaOfCaixausuarioCollectionNewCaixausuario.equals(sistema)) {
                        oldCodsistemaOfCaixausuarioCollectionNewCaixausuario.getCaixausuarioCollection().remove(caixausuarioCollectionNewCaixausuario);
                        oldCodsistemaOfCaixausuarioCollectionNewCaixausuario = em.merge(oldCodsistemaOfCaixausuarioCollectionNewCaixausuario);
                    }
                }
            }
            for (Relatorio relatorioCollectionOldRelatorio : relatorioCollectionOld) {
                if (!relatorioCollectionNew.contains(relatorioCollectionOldRelatorio)) {
                    relatorioCollectionOldRelatorio.setCodsistema(null);
                    relatorioCollectionOldRelatorio = em.merge(relatorioCollectionOldRelatorio);
                }
            }
            for (Relatorio relatorioCollectionNewRelatorio : relatorioCollectionNew) {
                if (!relatorioCollectionOld.contains(relatorioCollectionNewRelatorio)) {
                    Sistema oldCodsistemaOfRelatorioCollectionNewRelatorio = relatorioCollectionNewRelatorio.getCodsistema();
                    relatorioCollectionNewRelatorio.setCodsistema(sistema);
                    relatorioCollectionNewRelatorio = em.merge(relatorioCollectionNewRelatorio);
                    if (oldCodsistemaOfRelatorioCollectionNewRelatorio != null && !oldCodsistemaOfRelatorioCollectionNewRelatorio.equals(sistema)) {
                        oldCodsistemaOfRelatorioCollectionNewRelatorio.getRelatorioCollection().remove(relatorioCollectionNewRelatorio);
                        oldCodsistemaOfRelatorioCollectionNewRelatorio = em.merge(oldCodsistemaOfRelatorioCollectionNewRelatorio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sistema.getCodsistema();
                if (findSistema(id) == null) {
                    throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.");
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
            Sistema sistema;
            try {
                sistema = em.getReference(Sistema.class, id);
                sistema.getCodsistema();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sistema with id " + id + " no longer exists.", enfe);
            }
            Collection<Cfgcenariogrid> cfgcenariogridCollection = sistema.getCfgcenariogridCollection();
            for (Cfgcenariogrid cfgcenariogridCollectionCfgcenariogrid : cfgcenariogridCollection) {
                cfgcenariogridCollectionCfgcenariogrid.setCodsistema(null);
                cfgcenariogridCollectionCfgcenariogrid = em.merge(cfgcenariogridCollectionCfgcenariogrid);
            }
            Collection<Sistemaacesso> sistemaacessoCollection = sistema.getSistemaacessoCollection();
            for (Sistemaacesso sistemaacessoCollectionSistemaacesso : sistemaacessoCollection) {
                sistemaacessoCollectionSistemaacesso.setCodsistema(null);
                sistemaacessoCollectionSistemaacesso = em.merge(sistemaacessoCollectionSistemaacesso);
            }
            Collection<Caixausuario> caixausuarioCollection = sistema.getCaixausuarioCollection();
            for (Caixausuario caixausuarioCollectionCaixausuario : caixausuarioCollection) {
                caixausuarioCollectionCaixausuario.setCodsistema(null);
                caixausuarioCollectionCaixausuario = em.merge(caixausuarioCollectionCaixausuario);
            }
            Collection<Relatorio> relatorioCollection = sistema.getRelatorioCollection();
            for (Relatorio relatorioCollectionRelatorio : relatorioCollection) {
                relatorioCollectionRelatorio.setCodsistema(null);
                relatorioCollectionRelatorio = em.merge(relatorioCollectionRelatorio);
            }
            em.remove(sistema);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sistema> findSistemaEntities() {
        return findSistemaEntities(true, -1, -1);
    }

    public List<Sistema> findSistemaEntities(int maxResults, int firstResult) {
        return findSistemaEntities(false, maxResults, firstResult);
    }

    private List<Sistema> findSistemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sistema.class));
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

    public Sistema findSistema(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sistema.class, id);
        } finally {
            em.close();
        }
    }

    public int getSistemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sistema> rt = cq.from(Sistema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
