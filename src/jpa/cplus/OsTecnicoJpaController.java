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
import entidade.cplus.OsTecnico;
import entidade.cplus.Vendedor;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsLaudo;
import entidade.cplus.Movendaprod;
import entidade.cplus.Orcamentoprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsTecnicoJpaController implements Serializable {

    public OsTecnicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsTecnico osTecnico) throws PreexistingEntityException, Exception {
        if (osTecnico.getOsTecnicoCollection() == null) {
            osTecnico.setOsTecnicoCollection(new ArrayList<OsTecnico>());
        }
        if (osTecnico.getOsLaudoCollection() == null) {
            osTecnico.setOsLaudoCollection(new ArrayList<OsLaudo>());
        }
        if (osTecnico.getMovendaprodCollection() == null) {
            osTecnico.setMovendaprodCollection(new ArrayList<Movendaprod>());
        }
        if (osTecnico.getOrcamentoprodCollection() == null) {
            osTecnico.setOrcamentoprodCollection(new ArrayList<Orcamentoprod>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsTecnico codtecsupervisor = osTecnico.getCodtecsupervisor();
            if (codtecsupervisor != null) {
                codtecsupervisor = em.getReference(codtecsupervisor.getClass(), codtecsupervisor.getCodtec());
                osTecnico.setCodtecsupervisor(codtecsupervisor);
            }
            Vendedor codvended = osTecnico.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                osTecnico.setCodvended(codvended);
            }
            Collection<OsTecnico> attachedOsTecnicoCollection = new ArrayList<OsTecnico>();
            for (OsTecnico osTecnicoCollectionOsTecnicoToAttach : osTecnico.getOsTecnicoCollection()) {
                osTecnicoCollectionOsTecnicoToAttach = em.getReference(osTecnicoCollectionOsTecnicoToAttach.getClass(), osTecnicoCollectionOsTecnicoToAttach.getCodtec());
                attachedOsTecnicoCollection.add(osTecnicoCollectionOsTecnicoToAttach);
            }
            osTecnico.setOsTecnicoCollection(attachedOsTecnicoCollection);
            Collection<OsLaudo> attachedOsLaudoCollection = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionOsLaudoToAttach : osTecnico.getOsLaudoCollection()) {
                osLaudoCollectionOsLaudoToAttach = em.getReference(osLaudoCollectionOsLaudoToAttach.getClass(), osLaudoCollectionOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollection.add(osLaudoCollectionOsLaudoToAttach);
            }
            osTecnico.setOsLaudoCollection(attachedOsLaudoCollection);
            Collection<Movendaprod> attachedMovendaprodCollection = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionMovendaprodToAttach : osTecnico.getMovendaprodCollection()) {
                movendaprodCollectionMovendaprodToAttach = em.getReference(movendaprodCollectionMovendaprodToAttach.getClass(), movendaprodCollectionMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollection.add(movendaprodCollectionMovendaprodToAttach);
            }
            osTecnico.setMovendaprodCollection(attachedMovendaprodCollection);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprodToAttach : osTecnico.getOrcamentoprodCollection()) {
                orcamentoprodCollectionOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionOrcamentoprodToAttach.getClass(), orcamentoprodCollectionOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection.add(orcamentoprodCollectionOrcamentoprodToAttach);
            }
            osTecnico.setOrcamentoprodCollection(attachedOrcamentoprodCollection);
            em.persist(osTecnico);
            if (codtecsupervisor != null) {
                codtecsupervisor.getOsTecnicoCollection().add(osTecnico);
                codtecsupervisor = em.merge(codtecsupervisor);
            }
            if (codvended != null) {
                codvended.getOsTecnicoCollection().add(osTecnico);
                codvended = em.merge(codvended);
            }
            for (OsTecnico osTecnicoCollectionOsTecnico : osTecnico.getOsTecnicoCollection()) {
                OsTecnico oldCodtecsupervisorOfOsTecnicoCollectionOsTecnico = osTecnicoCollectionOsTecnico.getCodtecsupervisor();
                osTecnicoCollectionOsTecnico.setCodtecsupervisor(osTecnico);
                osTecnicoCollectionOsTecnico = em.merge(osTecnicoCollectionOsTecnico);
                if (oldCodtecsupervisorOfOsTecnicoCollectionOsTecnico != null) {
                    oldCodtecsupervisorOfOsTecnicoCollectionOsTecnico.getOsTecnicoCollection().remove(osTecnicoCollectionOsTecnico);
                    oldCodtecsupervisorOfOsTecnicoCollectionOsTecnico = em.merge(oldCodtecsupervisorOfOsTecnicoCollectionOsTecnico);
                }
            }
            for (OsLaudo osLaudoCollectionOsLaudo : osTecnico.getOsLaudoCollection()) {
                OsTecnico oldCodtecOfOsLaudoCollectionOsLaudo = osLaudoCollectionOsLaudo.getCodtec();
                osLaudoCollectionOsLaudo.setCodtec(osTecnico);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
                if (oldCodtecOfOsLaudoCollectionOsLaudo != null) {
                    oldCodtecOfOsLaudoCollectionOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionOsLaudo);
                    oldCodtecOfOsLaudoCollectionOsLaudo = em.merge(oldCodtecOfOsLaudoCollectionOsLaudo);
                }
            }
            for (Movendaprod movendaprodCollectionMovendaprod : osTecnico.getMovendaprodCollection()) {
                OsTecnico oldCodtecOfMovendaprodCollectionMovendaprod = movendaprodCollectionMovendaprod.getCodtec();
                movendaprodCollectionMovendaprod.setCodtec(osTecnico);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
                if (oldCodtecOfMovendaprodCollectionMovendaprod != null) {
                    oldCodtecOfMovendaprodCollectionMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionMovendaprod);
                    oldCodtecOfMovendaprodCollectionMovendaprod = em.merge(oldCodtecOfMovendaprodCollectionMovendaprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : osTecnico.getOrcamentoprodCollection()) {
                OsTecnico oldCodtecOfOrcamentoprodCollectionOrcamentoprod = orcamentoprodCollectionOrcamentoprod.getCodtec();
                orcamentoprodCollectionOrcamentoprod.setCodtec(osTecnico);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
                if (oldCodtecOfOrcamentoprodCollectionOrcamentoprod != null) {
                    oldCodtecOfOrcamentoprodCollectionOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionOrcamentoprod);
                    oldCodtecOfOrcamentoprodCollectionOrcamentoprod = em.merge(oldCodtecOfOrcamentoprodCollectionOrcamentoprod);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsTecnico(osTecnico.getCodtec()) != null) {
                throw new PreexistingEntityException("OsTecnico " + osTecnico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsTecnico osTecnico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsTecnico persistentOsTecnico = em.find(OsTecnico.class, osTecnico.getCodtec());
            OsTecnico codtecsupervisorOld = persistentOsTecnico.getCodtecsupervisor();
            OsTecnico codtecsupervisorNew = osTecnico.getCodtecsupervisor();
            Vendedor codvendedOld = persistentOsTecnico.getCodvended();
            Vendedor codvendedNew = osTecnico.getCodvended();
            Collection<OsTecnico> osTecnicoCollectionOld = persistentOsTecnico.getOsTecnicoCollection();
            Collection<OsTecnico> osTecnicoCollectionNew = osTecnico.getOsTecnicoCollection();
            Collection<OsLaudo> osLaudoCollectionOld = persistentOsTecnico.getOsLaudoCollection();
            Collection<OsLaudo> osLaudoCollectionNew = osTecnico.getOsLaudoCollection();
            Collection<Movendaprod> movendaprodCollectionOld = persistentOsTecnico.getMovendaprodCollection();
            Collection<Movendaprod> movendaprodCollectionNew = osTecnico.getMovendaprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionOld = persistentOsTecnico.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionNew = osTecnico.getOrcamentoprodCollection();
            if (codtecsupervisorNew != null) {
                codtecsupervisorNew = em.getReference(codtecsupervisorNew.getClass(), codtecsupervisorNew.getCodtec());
                osTecnico.setCodtecsupervisor(codtecsupervisorNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                osTecnico.setCodvended(codvendedNew);
            }
            Collection<OsTecnico> attachedOsTecnicoCollectionNew = new ArrayList<OsTecnico>();
            for (OsTecnico osTecnicoCollectionNewOsTecnicoToAttach : osTecnicoCollectionNew) {
                osTecnicoCollectionNewOsTecnicoToAttach = em.getReference(osTecnicoCollectionNewOsTecnicoToAttach.getClass(), osTecnicoCollectionNewOsTecnicoToAttach.getCodtec());
                attachedOsTecnicoCollectionNew.add(osTecnicoCollectionNewOsTecnicoToAttach);
            }
            osTecnicoCollectionNew = attachedOsTecnicoCollectionNew;
            osTecnico.setOsTecnicoCollection(osTecnicoCollectionNew);
            Collection<OsLaudo> attachedOsLaudoCollectionNew = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionNewOsLaudoToAttach : osLaudoCollectionNew) {
                osLaudoCollectionNewOsLaudoToAttach = em.getReference(osLaudoCollectionNewOsLaudoToAttach.getClass(), osLaudoCollectionNewOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollectionNew.add(osLaudoCollectionNewOsLaudoToAttach);
            }
            osLaudoCollectionNew = attachedOsLaudoCollectionNew;
            osTecnico.setOsLaudoCollection(osLaudoCollectionNew);
            Collection<Movendaprod> attachedMovendaprodCollectionNew = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionNewMovendaprodToAttach : movendaprodCollectionNew) {
                movendaprodCollectionNewMovendaprodToAttach = em.getReference(movendaprodCollectionNewMovendaprodToAttach.getClass(), movendaprodCollectionNewMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollectionNew.add(movendaprodCollectionNewMovendaprodToAttach);
            }
            movendaprodCollectionNew = attachedMovendaprodCollectionNew;
            osTecnico.setMovendaprodCollection(movendaprodCollectionNew);
            Collection<Orcamentoprod> attachedOrcamentoprodCollectionNew = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprodToAttach : orcamentoprodCollectionNew) {
                orcamentoprodCollectionNewOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionNewOrcamentoprodToAttach.getClass(), orcamentoprodCollectionNewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollectionNew.add(orcamentoprodCollectionNewOrcamentoprodToAttach);
            }
            orcamentoprodCollectionNew = attachedOrcamentoprodCollectionNew;
            osTecnico.setOrcamentoprodCollection(orcamentoprodCollectionNew);
            osTecnico = em.merge(osTecnico);
            if (codtecsupervisorOld != null && !codtecsupervisorOld.equals(codtecsupervisorNew)) {
                codtecsupervisorOld.getOsTecnicoCollection().remove(osTecnico);
                codtecsupervisorOld = em.merge(codtecsupervisorOld);
            }
            if (codtecsupervisorNew != null && !codtecsupervisorNew.equals(codtecsupervisorOld)) {
                codtecsupervisorNew.getOsTecnicoCollection().add(osTecnico);
                codtecsupervisorNew = em.merge(codtecsupervisorNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getOsTecnicoCollection().remove(osTecnico);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getOsTecnicoCollection().add(osTecnico);
                codvendedNew = em.merge(codvendedNew);
            }
            for (OsTecnico osTecnicoCollectionOldOsTecnico : osTecnicoCollectionOld) {
                if (!osTecnicoCollectionNew.contains(osTecnicoCollectionOldOsTecnico)) {
                    osTecnicoCollectionOldOsTecnico.setCodtecsupervisor(null);
                    osTecnicoCollectionOldOsTecnico = em.merge(osTecnicoCollectionOldOsTecnico);
                }
            }
            for (OsTecnico osTecnicoCollectionNewOsTecnico : osTecnicoCollectionNew) {
                if (!osTecnicoCollectionOld.contains(osTecnicoCollectionNewOsTecnico)) {
                    OsTecnico oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico = osTecnicoCollectionNewOsTecnico.getCodtecsupervisor();
                    osTecnicoCollectionNewOsTecnico.setCodtecsupervisor(osTecnico);
                    osTecnicoCollectionNewOsTecnico = em.merge(osTecnicoCollectionNewOsTecnico);
                    if (oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico != null && !oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico.equals(osTecnico)) {
                        oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico.getOsTecnicoCollection().remove(osTecnicoCollectionNewOsTecnico);
                        oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico = em.merge(oldCodtecsupervisorOfOsTecnicoCollectionNewOsTecnico);
                    }
                }
            }
            for (OsLaudo osLaudoCollectionOldOsLaudo : osLaudoCollectionOld) {
                if (!osLaudoCollectionNew.contains(osLaudoCollectionOldOsLaudo)) {
                    osLaudoCollectionOldOsLaudo.setCodtec(null);
                    osLaudoCollectionOldOsLaudo = em.merge(osLaudoCollectionOldOsLaudo);
                }
            }
            for (OsLaudo osLaudoCollectionNewOsLaudo : osLaudoCollectionNew) {
                if (!osLaudoCollectionOld.contains(osLaudoCollectionNewOsLaudo)) {
                    OsTecnico oldCodtecOfOsLaudoCollectionNewOsLaudo = osLaudoCollectionNewOsLaudo.getCodtec();
                    osLaudoCollectionNewOsLaudo.setCodtec(osTecnico);
                    osLaudoCollectionNewOsLaudo = em.merge(osLaudoCollectionNewOsLaudo);
                    if (oldCodtecOfOsLaudoCollectionNewOsLaudo != null && !oldCodtecOfOsLaudoCollectionNewOsLaudo.equals(osTecnico)) {
                        oldCodtecOfOsLaudoCollectionNewOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionNewOsLaudo);
                        oldCodtecOfOsLaudoCollectionNewOsLaudo = em.merge(oldCodtecOfOsLaudoCollectionNewOsLaudo);
                    }
                }
            }
            for (Movendaprod movendaprodCollectionOldMovendaprod : movendaprodCollectionOld) {
                if (!movendaprodCollectionNew.contains(movendaprodCollectionOldMovendaprod)) {
                    movendaprodCollectionOldMovendaprod.setCodtec(null);
                    movendaprodCollectionOldMovendaprod = em.merge(movendaprodCollectionOldMovendaprod);
                }
            }
            for (Movendaprod movendaprodCollectionNewMovendaprod : movendaprodCollectionNew) {
                if (!movendaprodCollectionOld.contains(movendaprodCollectionNewMovendaprod)) {
                    OsTecnico oldCodtecOfMovendaprodCollectionNewMovendaprod = movendaprodCollectionNewMovendaprod.getCodtec();
                    movendaprodCollectionNewMovendaprod.setCodtec(osTecnico);
                    movendaprodCollectionNewMovendaprod = em.merge(movendaprodCollectionNewMovendaprod);
                    if (oldCodtecOfMovendaprodCollectionNewMovendaprod != null && !oldCodtecOfMovendaprodCollectionNewMovendaprod.equals(osTecnico)) {
                        oldCodtecOfMovendaprodCollectionNewMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionNewMovendaprod);
                        oldCodtecOfMovendaprodCollectionNewMovendaprod = em.merge(oldCodtecOfMovendaprodCollectionNewMovendaprod);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOldOrcamentoprod : orcamentoprodCollectionOld) {
                if (!orcamentoprodCollectionNew.contains(orcamentoprodCollectionOldOrcamentoprod)) {
                    orcamentoprodCollectionOldOrcamentoprod.setCodtec(null);
                    orcamentoprodCollectionOldOrcamentoprod = em.merge(orcamentoprodCollectionOldOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprod : orcamentoprodCollectionNew) {
                if (!orcamentoprodCollectionOld.contains(orcamentoprodCollectionNewOrcamentoprod)) {
                    OsTecnico oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod = orcamentoprodCollectionNewOrcamentoprod.getCodtec();
                    orcamentoprodCollectionNewOrcamentoprod.setCodtec(osTecnico);
                    orcamentoprodCollectionNewOrcamentoprod = em.merge(orcamentoprodCollectionNewOrcamentoprod);
                    if (oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod != null && !oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod.equals(osTecnico)) {
                        oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionNewOrcamentoprod);
                        oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod = em.merge(oldCodtecOfOrcamentoprodCollectionNewOrcamentoprod);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osTecnico.getCodtec();
                if (findOsTecnico(id) == null) {
                    throw new NonexistentEntityException("The osTecnico with id " + id + " no longer exists.");
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
            OsTecnico osTecnico;
            try {
                osTecnico = em.getReference(OsTecnico.class, id);
                osTecnico.getCodtec();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osTecnico with id " + id + " no longer exists.", enfe);
            }
            OsTecnico codtecsupervisor = osTecnico.getCodtecsupervisor();
            if (codtecsupervisor != null) {
                codtecsupervisor.getOsTecnicoCollection().remove(osTecnico);
                codtecsupervisor = em.merge(codtecsupervisor);
            }
            Vendedor codvended = osTecnico.getCodvended();
            if (codvended != null) {
                codvended.getOsTecnicoCollection().remove(osTecnico);
                codvended = em.merge(codvended);
            }
            Collection<OsTecnico> osTecnicoCollection = osTecnico.getOsTecnicoCollection();
            for (OsTecnico osTecnicoCollectionOsTecnico : osTecnicoCollection) {
                osTecnicoCollectionOsTecnico.setCodtecsupervisor(null);
                osTecnicoCollectionOsTecnico = em.merge(osTecnicoCollectionOsTecnico);
            }
            Collection<OsLaudo> osLaudoCollection = osTecnico.getOsLaudoCollection();
            for (OsLaudo osLaudoCollectionOsLaudo : osLaudoCollection) {
                osLaudoCollectionOsLaudo.setCodtec(null);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
            }
            Collection<Movendaprod> movendaprodCollection = osTecnico.getMovendaprodCollection();
            for (Movendaprod movendaprodCollectionMovendaprod : movendaprodCollection) {
                movendaprodCollectionMovendaprod.setCodtec(null);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
            }
            Collection<Orcamentoprod> orcamentoprodCollection = osTecnico.getOrcamentoprodCollection();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : orcamentoprodCollection) {
                orcamentoprodCollectionOrcamentoprod.setCodtec(null);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
            }
            em.remove(osTecnico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsTecnico> findOsTecnicoEntities() {
        return findOsTecnicoEntities(true, -1, -1);
    }

    public List<OsTecnico> findOsTecnicoEntities(int maxResults, int firstResult) {
        return findOsTecnicoEntities(false, maxResults, firstResult);
    }

    private List<OsTecnico> findOsTecnicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsTecnico.class));
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

    public OsTecnico findOsTecnico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsTecnico.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsTecnicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsTecnico> rt = cq.from(OsTecnico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
