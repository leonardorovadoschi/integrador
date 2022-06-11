/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Banco;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Montagemarquivo;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Contapagar;
import entidade.cplus.Contabancaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class BancoJpaController implements Serializable {

    public BancoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Banco banco) throws PreexistingEntityException, Exception {
        if (banco.getMontagemarquivoCollection() == null) {
            banco.setMontagemarquivoCollection(new ArrayList<Montagemarquivo>());
        }
        if (banco.getContapagarCollection() == null) {
            banco.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (banco.getContabancariaCollection() == null) {
            banco.setContabancariaCollection(new ArrayList<Contabancaria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Montagemarquivo> attachedMontagemarquivoCollection = new ArrayList<Montagemarquivo>();
            for (Montagemarquivo montagemarquivoCollectionMontagemarquivoToAttach : banco.getMontagemarquivoCollection()) {
                montagemarquivoCollectionMontagemarquivoToAttach = em.getReference(montagemarquivoCollectionMontagemarquivoToAttach.getClass(), montagemarquivoCollectionMontagemarquivoToAttach.getCodmontagemarquivo());
                attachedMontagemarquivoCollection.add(montagemarquivoCollectionMontagemarquivoToAttach);
            }
            banco.setMontagemarquivoCollection(attachedMontagemarquivoCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : banco.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            banco.setContapagarCollection(attachedContapagarCollection);
            Collection<Contabancaria> attachedContabancariaCollection = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionContabancariaToAttach : banco.getContabancariaCollection()) {
                contabancariaCollectionContabancariaToAttach = em.getReference(contabancariaCollectionContabancariaToAttach.getClass(), contabancariaCollectionContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollection.add(contabancariaCollectionContabancariaToAttach);
            }
            banco.setContabancariaCollection(attachedContabancariaCollection);
            em.persist(banco);
            for (Montagemarquivo montagemarquivoCollectionMontagemarquivo : banco.getMontagemarquivoCollection()) {
                Banco oldCodbancoOfMontagemarquivoCollectionMontagemarquivo = montagemarquivoCollectionMontagemarquivo.getCodbanco();
                montagemarquivoCollectionMontagemarquivo.setCodbanco(banco);
                montagemarquivoCollectionMontagemarquivo = em.merge(montagemarquivoCollectionMontagemarquivo);
                if (oldCodbancoOfMontagemarquivoCollectionMontagemarquivo != null) {
                    oldCodbancoOfMontagemarquivoCollectionMontagemarquivo.getMontagemarquivoCollection().remove(montagemarquivoCollectionMontagemarquivo);
                    oldCodbancoOfMontagemarquivoCollectionMontagemarquivo = em.merge(oldCodbancoOfMontagemarquivoCollectionMontagemarquivo);
                }
            }
            for (Contapagar contapagarCollectionContapagar : banco.getContapagarCollection()) {
                Banco oldCodbancoOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodbanco();
                contapagarCollectionContapagar.setCodbanco(banco);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodbancoOfContapagarCollectionContapagar != null) {
                    oldCodbancoOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodbancoOfContapagarCollectionContapagar = em.merge(oldCodbancoOfContapagarCollectionContapagar);
                }
            }
            for (Contabancaria contabancariaCollectionContabancaria : banco.getContabancariaCollection()) {
                Banco oldCodbancoOfContabancariaCollectionContabancaria = contabancariaCollectionContabancaria.getCodbanco();
                contabancariaCollectionContabancaria.setCodbanco(banco);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
                if (oldCodbancoOfContabancariaCollectionContabancaria != null) {
                    oldCodbancoOfContabancariaCollectionContabancaria.getContabancariaCollection().remove(contabancariaCollectionContabancaria);
                    oldCodbancoOfContabancariaCollectionContabancaria = em.merge(oldCodbancoOfContabancariaCollectionContabancaria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBanco(banco.getCodbanco()) != null) {
                throw new PreexistingEntityException("Banco " + banco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Banco banco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco persistentBanco = em.find(Banco.class, banco.getCodbanco());
            Collection<Montagemarquivo> montagemarquivoCollectionOld = persistentBanco.getMontagemarquivoCollection();
            Collection<Montagemarquivo> montagemarquivoCollectionNew = banco.getMontagemarquivoCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentBanco.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = banco.getContapagarCollection();
            Collection<Contabancaria> contabancariaCollectionOld = persistentBanco.getContabancariaCollection();
            Collection<Contabancaria> contabancariaCollectionNew = banco.getContabancariaCollection();
            Collection<Montagemarquivo> attachedMontagemarquivoCollectionNew = new ArrayList<Montagemarquivo>();
            for (Montagemarquivo montagemarquivoCollectionNewMontagemarquivoToAttach : montagemarquivoCollectionNew) {
                montagemarquivoCollectionNewMontagemarquivoToAttach = em.getReference(montagemarquivoCollectionNewMontagemarquivoToAttach.getClass(), montagemarquivoCollectionNewMontagemarquivoToAttach.getCodmontagemarquivo());
                attachedMontagemarquivoCollectionNew.add(montagemarquivoCollectionNewMontagemarquivoToAttach);
            }
            montagemarquivoCollectionNew = attachedMontagemarquivoCollectionNew;
            banco.setMontagemarquivoCollection(montagemarquivoCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            banco.setContapagarCollection(contapagarCollectionNew);
            Collection<Contabancaria> attachedContabancariaCollectionNew = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionNewContabancariaToAttach : contabancariaCollectionNew) {
                contabancariaCollectionNewContabancariaToAttach = em.getReference(contabancariaCollectionNewContabancariaToAttach.getClass(), contabancariaCollectionNewContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollectionNew.add(contabancariaCollectionNewContabancariaToAttach);
            }
            contabancariaCollectionNew = attachedContabancariaCollectionNew;
            banco.setContabancariaCollection(contabancariaCollectionNew);
            banco = em.merge(banco);
            for (Montagemarquivo montagemarquivoCollectionOldMontagemarquivo : montagemarquivoCollectionOld) {
                if (!montagemarquivoCollectionNew.contains(montagemarquivoCollectionOldMontagemarquivo)) {
                    montagemarquivoCollectionOldMontagemarquivo.setCodbanco(null);
                    montagemarquivoCollectionOldMontagemarquivo = em.merge(montagemarquivoCollectionOldMontagemarquivo);
                }
            }
            for (Montagemarquivo montagemarquivoCollectionNewMontagemarquivo : montagemarquivoCollectionNew) {
                if (!montagemarquivoCollectionOld.contains(montagemarquivoCollectionNewMontagemarquivo)) {
                    Banco oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo = montagemarquivoCollectionNewMontagemarquivo.getCodbanco();
                    montagemarquivoCollectionNewMontagemarquivo.setCodbanco(banco);
                    montagemarquivoCollectionNewMontagemarquivo = em.merge(montagemarquivoCollectionNewMontagemarquivo);
                    if (oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo != null && !oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo.equals(banco)) {
                        oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo.getMontagemarquivoCollection().remove(montagemarquivoCollectionNewMontagemarquivo);
                        oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo = em.merge(oldCodbancoOfMontagemarquivoCollectionNewMontagemarquivo);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodbanco(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Banco oldCodbancoOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodbanco();
                    contapagarCollectionNewContapagar.setCodbanco(banco);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodbancoOfContapagarCollectionNewContapagar != null && !oldCodbancoOfContapagarCollectionNewContapagar.equals(banco)) {
                        oldCodbancoOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodbancoOfContapagarCollectionNewContapagar = em.merge(oldCodbancoOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Contabancaria contabancariaCollectionOldContabancaria : contabancariaCollectionOld) {
                if (!contabancariaCollectionNew.contains(contabancariaCollectionOldContabancaria)) {
                    contabancariaCollectionOldContabancaria.setCodbanco(null);
                    contabancariaCollectionOldContabancaria = em.merge(contabancariaCollectionOldContabancaria);
                }
            }
            for (Contabancaria contabancariaCollectionNewContabancaria : contabancariaCollectionNew) {
                if (!contabancariaCollectionOld.contains(contabancariaCollectionNewContabancaria)) {
                    Banco oldCodbancoOfContabancariaCollectionNewContabancaria = contabancariaCollectionNewContabancaria.getCodbanco();
                    contabancariaCollectionNewContabancaria.setCodbanco(banco);
                    contabancariaCollectionNewContabancaria = em.merge(contabancariaCollectionNewContabancaria);
                    if (oldCodbancoOfContabancariaCollectionNewContabancaria != null && !oldCodbancoOfContabancariaCollectionNewContabancaria.equals(banco)) {
                        oldCodbancoOfContabancariaCollectionNewContabancaria.getContabancariaCollection().remove(contabancariaCollectionNewContabancaria);
                        oldCodbancoOfContabancariaCollectionNewContabancaria = em.merge(oldCodbancoOfContabancariaCollectionNewContabancaria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = banco.getCodbanco();
                if (findBanco(id) == null) {
                    throw new NonexistentEntityException("The banco with id " + id + " no longer exists.");
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
            Banco banco;
            try {
                banco = em.getReference(Banco.class, id);
                banco.getCodbanco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The banco with id " + id + " no longer exists.", enfe);
            }
            Collection<Montagemarquivo> montagemarquivoCollection = banco.getMontagemarquivoCollection();
            for (Montagemarquivo montagemarquivoCollectionMontagemarquivo : montagemarquivoCollection) {
                montagemarquivoCollectionMontagemarquivo.setCodbanco(null);
                montagemarquivoCollectionMontagemarquivo = em.merge(montagemarquivoCollectionMontagemarquivo);
            }
            Collection<Contapagar> contapagarCollection = banco.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodbanco(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Contabancaria> contabancariaCollection = banco.getContabancariaCollection();
            for (Contabancaria contabancariaCollectionContabancaria : contabancariaCollection) {
                contabancariaCollectionContabancaria.setCodbanco(null);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
            }
            em.remove(banco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Banco> findBancoEntities() {
        return findBancoEntities(true, -1, -1);
    }

    public List<Banco> findBancoEntities(int maxResults, int firstResult) {
        return findBancoEntities(false, maxResults, firstResult);
    }

    private List<Banco> findBancoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Banco.class));
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

    public Banco findBanco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Banco.class, id);
        } finally {
            em.close();
        }
    }

    public int getBancoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Banco> rt = cq.from(Banco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
