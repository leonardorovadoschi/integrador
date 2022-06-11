/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cargo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Funcionario;
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
public class CargoJpaController implements Serializable {

    public CargoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cargo cargo) throws PreexistingEntityException, Exception {
        if (cargo.getFuncionarioCollection() == null) {
            cargo.setFuncionarioCollection(new ArrayList<Funcionario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario codfunc = cargo.getCodfunc();
            if (codfunc != null) {
                codfunc = em.getReference(codfunc.getClass(), codfunc.getCodfuncionario());
                cargo.setCodfunc(codfunc);
            }
            Collection<Funcionario> attachedFuncionarioCollection = new ArrayList<Funcionario>();
            for (Funcionario funcionarioCollectionFuncionarioToAttach : cargo.getFuncionarioCollection()) {
                funcionarioCollectionFuncionarioToAttach = em.getReference(funcionarioCollectionFuncionarioToAttach.getClass(), funcionarioCollectionFuncionarioToAttach.getCodfuncionario());
                attachedFuncionarioCollection.add(funcionarioCollectionFuncionarioToAttach);
            }
            cargo.setFuncionarioCollection(attachedFuncionarioCollection);
            em.persist(cargo);
            if (codfunc != null) {
                codfunc.getCargoCollection().add(cargo);
                codfunc = em.merge(codfunc);
            }
            for (Funcionario funcionarioCollectionFuncionario : cargo.getFuncionarioCollection()) {
                Cargo oldCodcargoOfFuncionarioCollectionFuncionario = funcionarioCollectionFuncionario.getCodcargo();
                funcionarioCollectionFuncionario.setCodcargo(cargo);
                funcionarioCollectionFuncionario = em.merge(funcionarioCollectionFuncionario);
                if (oldCodcargoOfFuncionarioCollectionFuncionario != null) {
                    oldCodcargoOfFuncionarioCollectionFuncionario.getFuncionarioCollection().remove(funcionarioCollectionFuncionario);
                    oldCodcargoOfFuncionarioCollectionFuncionario = em.merge(oldCodcargoOfFuncionarioCollectionFuncionario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargo(cargo.getCodcargo()) != null) {
                throw new PreexistingEntityException("Cargo " + cargo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargo cargo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo persistentCargo = em.find(Cargo.class, cargo.getCodcargo());
            Funcionario codfuncOld = persistentCargo.getCodfunc();
            Funcionario codfuncNew = cargo.getCodfunc();
            Collection<Funcionario> funcionarioCollectionOld = persistentCargo.getFuncionarioCollection();
            Collection<Funcionario> funcionarioCollectionNew = cargo.getFuncionarioCollection();
            if (codfuncNew != null) {
                codfuncNew = em.getReference(codfuncNew.getClass(), codfuncNew.getCodfuncionario());
                cargo.setCodfunc(codfuncNew);
            }
            Collection<Funcionario> attachedFuncionarioCollectionNew = new ArrayList<Funcionario>();
            for (Funcionario funcionarioCollectionNewFuncionarioToAttach : funcionarioCollectionNew) {
                funcionarioCollectionNewFuncionarioToAttach = em.getReference(funcionarioCollectionNewFuncionarioToAttach.getClass(), funcionarioCollectionNewFuncionarioToAttach.getCodfuncionario());
                attachedFuncionarioCollectionNew.add(funcionarioCollectionNewFuncionarioToAttach);
            }
            funcionarioCollectionNew = attachedFuncionarioCollectionNew;
            cargo.setFuncionarioCollection(funcionarioCollectionNew);
            cargo = em.merge(cargo);
            if (codfuncOld != null && !codfuncOld.equals(codfuncNew)) {
                codfuncOld.getCargoCollection().remove(cargo);
                codfuncOld = em.merge(codfuncOld);
            }
            if (codfuncNew != null && !codfuncNew.equals(codfuncOld)) {
                codfuncNew.getCargoCollection().add(cargo);
                codfuncNew = em.merge(codfuncNew);
            }
            for (Funcionario funcionarioCollectionOldFuncionario : funcionarioCollectionOld) {
                if (!funcionarioCollectionNew.contains(funcionarioCollectionOldFuncionario)) {
                    funcionarioCollectionOldFuncionario.setCodcargo(null);
                    funcionarioCollectionOldFuncionario = em.merge(funcionarioCollectionOldFuncionario);
                }
            }
            for (Funcionario funcionarioCollectionNewFuncionario : funcionarioCollectionNew) {
                if (!funcionarioCollectionOld.contains(funcionarioCollectionNewFuncionario)) {
                    Cargo oldCodcargoOfFuncionarioCollectionNewFuncionario = funcionarioCollectionNewFuncionario.getCodcargo();
                    funcionarioCollectionNewFuncionario.setCodcargo(cargo);
                    funcionarioCollectionNewFuncionario = em.merge(funcionarioCollectionNewFuncionario);
                    if (oldCodcargoOfFuncionarioCollectionNewFuncionario != null && !oldCodcargoOfFuncionarioCollectionNewFuncionario.equals(cargo)) {
                        oldCodcargoOfFuncionarioCollectionNewFuncionario.getFuncionarioCollection().remove(funcionarioCollectionNewFuncionario);
                        oldCodcargoOfFuncionarioCollectionNewFuncionario = em.merge(oldCodcargoOfFuncionarioCollectionNewFuncionario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cargo.getCodcargo();
                if (findCargo(id) == null) {
                    throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.");
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
            Cargo cargo;
            try {
                cargo = em.getReference(Cargo.class, id);
                cargo.getCodcargo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.", enfe);
            }
            Funcionario codfunc = cargo.getCodfunc();
            if (codfunc != null) {
                codfunc.getCargoCollection().remove(cargo);
                codfunc = em.merge(codfunc);
            }
            Collection<Funcionario> funcionarioCollection = cargo.getFuncionarioCollection();
            for (Funcionario funcionarioCollectionFuncionario : funcionarioCollection) {
                funcionarioCollectionFuncionario.setCodcargo(null);
                funcionarioCollectionFuncionario = em.merge(funcionarioCollectionFuncionario);
            }
            em.remove(cargo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargo> findCargoEntities() {
        return findCargoEntities(true, -1, -1);
    }

    public List<Cargo> findCargoEntities(int maxResults, int firstResult) {
        return findCargoEntities(false, maxResults, firstResult);
    }

    private List<Cargo> findCargoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargo.class));
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

    public Cargo findCargo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargo> rt = cq.from(Cargo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
