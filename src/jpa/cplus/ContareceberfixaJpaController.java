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
import entidade.cplus.Cliente;
import entidade.cplus.Contabancaria;
import entidade.cplus.Planoconta;
import entidade.cplus.Contareceber;
import entidade.cplus.Contareceberfixa;
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
public class ContareceberfixaJpaController implements Serializable {

    public ContareceberfixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contareceberfixa contareceberfixa) throws PreexistingEntityException, Exception {
        if (contareceberfixa.getContareceberCollection() == null) {
            contareceberfixa.setContareceberCollection(new ArrayList<Contareceber>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = contareceberfixa.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                contareceberfixa.setCodcli(codcli);
            }
            Contabancaria codcontabancaria = contareceberfixa.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                contareceberfixa.setCodcontabancaria(codcontabancaria);
            }
            Planoconta codpc = contareceberfixa.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                contareceberfixa.setCodpc(codpc);
            }
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : contareceberfixa.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            contareceberfixa.setContareceberCollection(attachedContareceberCollection);
            em.persist(contareceberfixa);
            if (codcli != null) {
                codcli.getContareceberfixaCollection().add(contareceberfixa);
                codcli = em.merge(codcli);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getContareceberfixaCollection().add(contareceberfixa);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codpc != null) {
                codpc.getContareceberfixaCollection().add(contareceberfixa);
                codpc = em.merge(codpc);
            }
            for (Contareceber contareceberCollectionContareceber : contareceberfixa.getContareceberCollection()) {
                Contareceberfixa oldCodcrfixaOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodcrfixa();
                contareceberCollectionContareceber.setCodcrfixa(contareceberfixa);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodcrfixaOfContareceberCollectionContareceber != null) {
                    oldCodcrfixaOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodcrfixaOfContareceberCollectionContareceber = em.merge(oldCodcrfixaOfContareceberCollectionContareceber);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContareceberfixa(contareceberfixa.getCodcrfixa()) != null) {
                throw new PreexistingEntityException("Contareceberfixa " + contareceberfixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contareceberfixa contareceberfixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contareceberfixa persistentContareceberfixa = em.find(Contareceberfixa.class, contareceberfixa.getCodcrfixa());
            Cliente codcliOld = persistentContareceberfixa.getCodcli();
            Cliente codcliNew = contareceberfixa.getCodcli();
            Contabancaria codcontabancariaOld = persistentContareceberfixa.getCodcontabancaria();
            Contabancaria codcontabancariaNew = contareceberfixa.getCodcontabancaria();
            Planoconta codpcOld = persistentContareceberfixa.getCodpc();
            Planoconta codpcNew = contareceberfixa.getCodpc();
            Collection<Contareceber> contareceberCollectionOld = persistentContareceberfixa.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = contareceberfixa.getContareceberCollection();
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                contareceberfixa.setCodcli(codcliNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                contareceberfixa.setCodcontabancaria(codcontabancariaNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                contareceberfixa.setCodpc(codpcNew);
            }
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            contareceberfixa.setContareceberCollection(contareceberCollectionNew);
            contareceberfixa = em.merge(contareceberfixa);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getContareceberfixaCollection().remove(contareceberfixa);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getContareceberfixaCollection().add(contareceberfixa);
                codcliNew = em.merge(codcliNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getContareceberfixaCollection().remove(contareceberfixa);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getContareceberfixaCollection().add(contareceberfixa);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getContareceberfixaCollection().remove(contareceberfixa);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getContareceberfixaCollection().add(contareceberfixa);
                codpcNew = em.merge(codpcNew);
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodcrfixa(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Contareceberfixa oldCodcrfixaOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodcrfixa();
                    contareceberCollectionNewContareceber.setCodcrfixa(contareceberfixa);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodcrfixaOfContareceberCollectionNewContareceber != null && !oldCodcrfixaOfContareceberCollectionNewContareceber.equals(contareceberfixa)) {
                        oldCodcrfixaOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodcrfixaOfContareceberCollectionNewContareceber = em.merge(oldCodcrfixaOfContareceberCollectionNewContareceber);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contareceberfixa.getCodcrfixa();
                if (findContareceberfixa(id) == null) {
                    throw new NonexistentEntityException("The contareceberfixa with id " + id + " no longer exists.");
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
            Contareceberfixa contareceberfixa;
            try {
                contareceberfixa = em.getReference(Contareceberfixa.class, id);
                contareceberfixa.getCodcrfixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contareceberfixa with id " + id + " no longer exists.", enfe);
            }
            Cliente codcli = contareceberfixa.getCodcli();
            if (codcli != null) {
                codcli.getContareceberfixaCollection().remove(contareceberfixa);
                codcli = em.merge(codcli);
            }
            Contabancaria codcontabancaria = contareceberfixa.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getContareceberfixaCollection().remove(contareceberfixa);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Planoconta codpc = contareceberfixa.getCodpc();
            if (codpc != null) {
                codpc.getContareceberfixaCollection().remove(contareceberfixa);
                codpc = em.merge(codpc);
            }
            Collection<Contareceber> contareceberCollection = contareceberfixa.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodcrfixa(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            em.remove(contareceberfixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contareceberfixa> findContareceberfixaEntities() {
        return findContareceberfixaEntities(true, -1, -1);
    }

    public List<Contareceberfixa> findContareceberfixaEntities(int maxResults, int firstResult) {
        return findContareceberfixaEntities(false, maxResults, firstResult);
    }

    private List<Contareceberfixa> findContareceberfixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contareceberfixa.class));
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

    public Contareceberfixa findContareceberfixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contareceberfixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getContareceberfixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contareceberfixa> rt = cq.from(Contareceberfixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
