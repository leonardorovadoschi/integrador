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
import entidade.cplus.Caixas;
import entidade.cplus.Planoconta;
import entidade.cplus.Movenda;
import entidade.cplus.Terminal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TerminalJpaController implements Serializable {

    public TerminalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Terminal terminal) throws PreexistingEntityException, Exception {
        if (terminal.getMovendaCollection() == null) {
            terminal.setMovendaCollection(new ArrayList<Movenda>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixas codcaixas = terminal.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                terminal.setCodcaixas(codcaixas);
            }
            Planoconta codpc = terminal.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                terminal.setCodpc(codpc);
            }
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : terminal.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            terminal.setMovendaCollection(attachedMovendaCollection);
            em.persist(terminal);
            if (codcaixas != null) {
                codcaixas.getTerminalCollection().add(terminal);
                codcaixas = em.merge(codcaixas);
            }
            if (codpc != null) {
                codpc.getTerminalCollection().add(terminal);
                codpc = em.merge(codpc);
            }
            for (Movenda movendaCollectionMovenda : terminal.getMovendaCollection()) {
                Terminal oldCodterminalOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodterminal();
                movendaCollectionMovenda.setCodterminal(terminal);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodterminalOfMovendaCollectionMovenda != null) {
                    oldCodterminalOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodterminalOfMovendaCollectionMovenda = em.merge(oldCodterminalOfMovendaCollectionMovenda);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTerminal(terminal.getCodterminal()) != null) {
                throw new PreexistingEntityException("Terminal " + terminal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Terminal terminal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Terminal persistentTerminal = em.find(Terminal.class, terminal.getCodterminal());
            Caixas codcaixasOld = persistentTerminal.getCodcaixas();
            Caixas codcaixasNew = terminal.getCodcaixas();
            Planoconta codpcOld = persistentTerminal.getCodpc();
            Planoconta codpcNew = terminal.getCodpc();
            Collection<Movenda> movendaCollectionOld = persistentTerminal.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = terminal.getMovendaCollection();
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                terminal.setCodcaixas(codcaixasNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                terminal.setCodpc(codpcNew);
            }
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            terminal.setMovendaCollection(movendaCollectionNew);
            terminal = em.merge(terminal);
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getTerminalCollection().remove(terminal);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getTerminalCollection().add(terminal);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getTerminalCollection().remove(terminal);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getTerminalCollection().add(terminal);
                codpcNew = em.merge(codpcNew);
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodterminal(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Terminal oldCodterminalOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodterminal();
                    movendaCollectionNewMovenda.setCodterminal(terminal);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodterminalOfMovendaCollectionNewMovenda != null && !oldCodterminalOfMovendaCollectionNewMovenda.equals(terminal)) {
                        oldCodterminalOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodterminalOfMovendaCollectionNewMovenda = em.merge(oldCodterminalOfMovendaCollectionNewMovenda);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = terminal.getCodterminal();
                if (findTerminal(id) == null) {
                    throw new NonexistentEntityException("The terminal with id " + id + " no longer exists.");
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
            Terminal terminal;
            try {
                terminal = em.getReference(Terminal.class, id);
                terminal.getCodterminal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The terminal with id " + id + " no longer exists.", enfe);
            }
            Caixas codcaixas = terminal.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getTerminalCollection().remove(terminal);
                codcaixas = em.merge(codcaixas);
            }
            Planoconta codpc = terminal.getCodpc();
            if (codpc != null) {
                codpc.getTerminalCollection().remove(terminal);
                codpc = em.merge(codpc);
            }
            Collection<Movenda> movendaCollection = terminal.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodterminal(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            em.remove(terminal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Terminal> findTerminalEntities() {
        return findTerminalEntities(true, -1, -1);
    }

    public List<Terminal> findTerminalEntities(int maxResults, int firstResult) {
        return findTerminalEntities(false, maxResults, firstResult);
    }

    private List<Terminal> findTerminalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Terminal.class));
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

    public Terminal findTerminal(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Terminal.class, id);
        } finally {
            em.close();
        }
    }

    public int getTerminalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Terminal> rt = cq.from(Terminal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
