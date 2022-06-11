/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Entregapessoa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Mdfeletronicocondutor;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Loteentrega;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EntregapessoaJpaController implements Serializable {

    public EntregapessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entregapessoa entregapessoa) throws PreexistingEntityException, Exception {
        if (entregapessoa.getMdfeletronicocondutorCollection() == null) {
            entregapessoa.setMdfeletronicocondutorCollection(new ArrayList<Mdfeletronicocondutor>());
        }
        if (entregapessoa.getLoteentregaCollection() == null) {
            entregapessoa.setLoteentregaCollection(new ArrayList<Loteentrega>());
        }
        if (entregapessoa.getLoteentregaCollection1() == null) {
            entregapessoa.setLoteentregaCollection1(new ArrayList<Loteentrega>());
        }
        if (entregapessoa.getLoteentregaCollection2() == null) {
            entregapessoa.setLoteentregaCollection2(new ArrayList<Loteentrega>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Mdfeletronicocondutor> attachedMdfeletronicocondutorCollection = new ArrayList<Mdfeletronicocondutor>();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach : entregapessoa.getMdfeletronicocondutorCollection()) {
                mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach = em.getReference(mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach.getClass(), mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach.getCodmdfeletronicocondutor());
                attachedMdfeletronicocondutorCollection.add(mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach);
            }
            entregapessoa.setMdfeletronicocondutorCollection(attachedMdfeletronicocondutorCollection);
            Collection<Loteentrega> attachedLoteentregaCollection = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionLoteentregaToAttach : entregapessoa.getLoteentregaCollection()) {
                loteentregaCollectionLoteentregaToAttach = em.getReference(loteentregaCollectionLoteentregaToAttach.getClass(), loteentregaCollectionLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection.add(loteentregaCollectionLoteentregaToAttach);
            }
            entregapessoa.setLoteentregaCollection(attachedLoteentregaCollection);
            Collection<Loteentrega> attachedLoteentregaCollection1 = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollection1LoteentregaToAttach : entregapessoa.getLoteentregaCollection1()) {
                loteentregaCollection1LoteentregaToAttach = em.getReference(loteentregaCollection1LoteentregaToAttach.getClass(), loteentregaCollection1LoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection1.add(loteentregaCollection1LoteentregaToAttach);
            }
            entregapessoa.setLoteentregaCollection1(attachedLoteentregaCollection1);
            Collection<Loteentrega> attachedLoteentregaCollection2 = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollection2LoteentregaToAttach : entregapessoa.getLoteentregaCollection2()) {
                loteentregaCollection2LoteentregaToAttach = em.getReference(loteentregaCollection2LoteentregaToAttach.getClass(), loteentregaCollection2LoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection2.add(loteentregaCollection2LoteentregaToAttach);
            }
            entregapessoa.setLoteentregaCollection2(attachedLoteentregaCollection2);
            em.persist(entregapessoa);
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionMdfeletronicocondutor : entregapessoa.getMdfeletronicocondutorCollection()) {
                Entregapessoa oldCodentregapessoaOfMdfeletronicocondutorCollectionMdfeletronicocondutor = mdfeletronicocondutorCollectionMdfeletronicocondutor.getCodentregapessoa();
                mdfeletronicocondutorCollectionMdfeletronicocondutor.setCodentregapessoa(entregapessoa);
                mdfeletronicocondutorCollectionMdfeletronicocondutor = em.merge(mdfeletronicocondutorCollectionMdfeletronicocondutor);
                if (oldCodentregapessoaOfMdfeletronicocondutorCollectionMdfeletronicocondutor != null) {
                    oldCodentregapessoaOfMdfeletronicocondutorCollectionMdfeletronicocondutor.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutorCollectionMdfeletronicocondutor);
                    oldCodentregapessoaOfMdfeletronicocondutorCollectionMdfeletronicocondutor = em.merge(oldCodentregapessoaOfMdfeletronicocondutorCollectionMdfeletronicocondutor);
                }
            }
            for (Loteentrega loteentregaCollectionLoteentrega : entregapessoa.getLoteentregaCollection()) {
                Entregapessoa oldCodmotoristaOfLoteentregaCollectionLoteentrega = loteentregaCollectionLoteentrega.getCodmotorista();
                loteentregaCollectionLoteentrega.setCodmotorista(entregapessoa);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
                if (oldCodmotoristaOfLoteentregaCollectionLoteentrega != null) {
                    oldCodmotoristaOfLoteentregaCollectionLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionLoteentrega);
                    oldCodmotoristaOfLoteentregaCollectionLoteentrega = em.merge(oldCodmotoristaOfLoteentregaCollectionLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollection1Loteentrega : entregapessoa.getLoteentregaCollection1()) {
                Entregapessoa oldCodajudanteOfLoteentregaCollection1Loteentrega = loteentregaCollection1Loteentrega.getCodajudante();
                loteentregaCollection1Loteentrega.setCodajudante(entregapessoa);
                loteentregaCollection1Loteentrega = em.merge(loteentregaCollection1Loteentrega);
                if (oldCodajudanteOfLoteentregaCollection1Loteentrega != null) {
                    oldCodajudanteOfLoteentregaCollection1Loteentrega.getLoteentregaCollection1().remove(loteentregaCollection1Loteentrega);
                    oldCodajudanteOfLoteentregaCollection1Loteentrega = em.merge(oldCodajudanteOfLoteentregaCollection1Loteentrega);
                }
            }
            for (Loteentrega loteentregaCollection2Loteentrega : entregapessoa.getLoteentregaCollection2()) {
                Entregapessoa oldCodajudante2OfLoteentregaCollection2Loteentrega = loteentregaCollection2Loteentrega.getCodajudante2();
                loteentregaCollection2Loteentrega.setCodajudante2(entregapessoa);
                loteentregaCollection2Loteentrega = em.merge(loteentregaCollection2Loteentrega);
                if (oldCodajudante2OfLoteentregaCollection2Loteentrega != null) {
                    oldCodajudante2OfLoteentregaCollection2Loteentrega.getLoteentregaCollection2().remove(loteentregaCollection2Loteentrega);
                    oldCodajudante2OfLoteentregaCollection2Loteentrega = em.merge(oldCodajudante2OfLoteentregaCollection2Loteentrega);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntregapessoa(entregapessoa.getCodentregapessoa()) != null) {
                throw new PreexistingEntityException("Entregapessoa " + entregapessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entregapessoa entregapessoa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entregapessoa persistentEntregapessoa = em.find(Entregapessoa.class, entregapessoa.getCodentregapessoa());
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionOld = persistentEntregapessoa.getMdfeletronicocondutorCollection();
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionNew = entregapessoa.getMdfeletronicocondutorCollection();
            Collection<Loteentrega> loteentregaCollectionOld = persistentEntregapessoa.getLoteentregaCollection();
            Collection<Loteentrega> loteentregaCollectionNew = entregapessoa.getLoteentregaCollection();
            Collection<Loteentrega> loteentregaCollection1Old = persistentEntregapessoa.getLoteentregaCollection1();
            Collection<Loteentrega> loteentregaCollection1New = entregapessoa.getLoteentregaCollection1();
            Collection<Loteentrega> loteentregaCollection2Old = persistentEntregapessoa.getLoteentregaCollection2();
            Collection<Loteentrega> loteentregaCollection2New = entregapessoa.getLoteentregaCollection2();
            List<String> illegalOrphanMessages = null;
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionOldMdfeletronicocondutor : mdfeletronicocondutorCollectionOld) {
                if (!mdfeletronicocondutorCollectionNew.contains(mdfeletronicocondutorCollectionOldMdfeletronicocondutor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicocondutor " + mdfeletronicocondutorCollectionOldMdfeletronicocondutor + " since its codentregapessoa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Mdfeletronicocondutor> attachedMdfeletronicocondutorCollectionNew = new ArrayList<Mdfeletronicocondutor>();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach : mdfeletronicocondutorCollectionNew) {
                mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach = em.getReference(mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach.getClass(), mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach.getCodmdfeletronicocondutor());
                attachedMdfeletronicocondutorCollectionNew.add(mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach);
            }
            mdfeletronicocondutorCollectionNew = attachedMdfeletronicocondutorCollectionNew;
            entregapessoa.setMdfeletronicocondutorCollection(mdfeletronicocondutorCollectionNew);
            Collection<Loteentrega> attachedLoteentregaCollectionNew = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionNewLoteentregaToAttach : loteentregaCollectionNew) {
                loteentregaCollectionNewLoteentregaToAttach = em.getReference(loteentregaCollectionNewLoteentregaToAttach.getClass(), loteentregaCollectionNewLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollectionNew.add(loteentregaCollectionNewLoteentregaToAttach);
            }
            loteentregaCollectionNew = attachedLoteentregaCollectionNew;
            entregapessoa.setLoteentregaCollection(loteentregaCollectionNew);
            Collection<Loteentrega> attachedLoteentregaCollection1New = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollection1NewLoteentregaToAttach : loteentregaCollection1New) {
                loteentregaCollection1NewLoteentregaToAttach = em.getReference(loteentregaCollection1NewLoteentregaToAttach.getClass(), loteentregaCollection1NewLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection1New.add(loteentregaCollection1NewLoteentregaToAttach);
            }
            loteentregaCollection1New = attachedLoteentregaCollection1New;
            entregapessoa.setLoteentregaCollection1(loteentregaCollection1New);
            Collection<Loteentrega> attachedLoteentregaCollection2New = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollection2NewLoteentregaToAttach : loteentregaCollection2New) {
                loteentregaCollection2NewLoteentregaToAttach = em.getReference(loteentregaCollection2NewLoteentregaToAttach.getClass(), loteentregaCollection2NewLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection2New.add(loteentregaCollection2NewLoteentregaToAttach);
            }
            loteentregaCollection2New = attachedLoteentregaCollection2New;
            entregapessoa.setLoteentregaCollection2(loteentregaCollection2New);
            entregapessoa = em.merge(entregapessoa);
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionNewMdfeletronicocondutor : mdfeletronicocondutorCollectionNew) {
                if (!mdfeletronicocondutorCollectionOld.contains(mdfeletronicocondutorCollectionNewMdfeletronicocondutor)) {
                    Entregapessoa oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor = mdfeletronicocondutorCollectionNewMdfeletronicocondutor.getCodentregapessoa();
                    mdfeletronicocondutorCollectionNewMdfeletronicocondutor.setCodentregapessoa(entregapessoa);
                    mdfeletronicocondutorCollectionNewMdfeletronicocondutor = em.merge(mdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                    if (oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor != null && !oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor.equals(entregapessoa)) {
                        oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                        oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor = em.merge(oldCodentregapessoaOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                    }
                }
            }
            for (Loteentrega loteentregaCollectionOldLoteentrega : loteentregaCollectionOld) {
                if (!loteentregaCollectionNew.contains(loteentregaCollectionOldLoteentrega)) {
                    loteentregaCollectionOldLoteentrega.setCodmotorista(null);
                    loteentregaCollectionOldLoteentrega = em.merge(loteentregaCollectionOldLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollectionNewLoteentrega : loteentregaCollectionNew) {
                if (!loteentregaCollectionOld.contains(loteentregaCollectionNewLoteentrega)) {
                    Entregapessoa oldCodmotoristaOfLoteentregaCollectionNewLoteentrega = loteentregaCollectionNewLoteentrega.getCodmotorista();
                    loteentregaCollectionNewLoteentrega.setCodmotorista(entregapessoa);
                    loteentregaCollectionNewLoteentrega = em.merge(loteentregaCollectionNewLoteentrega);
                    if (oldCodmotoristaOfLoteentregaCollectionNewLoteentrega != null && !oldCodmotoristaOfLoteentregaCollectionNewLoteentrega.equals(entregapessoa)) {
                        oldCodmotoristaOfLoteentregaCollectionNewLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionNewLoteentrega);
                        oldCodmotoristaOfLoteentregaCollectionNewLoteentrega = em.merge(oldCodmotoristaOfLoteentregaCollectionNewLoteentrega);
                    }
                }
            }
            for (Loteentrega loteentregaCollection1OldLoteentrega : loteentregaCollection1Old) {
                if (!loteentregaCollection1New.contains(loteentregaCollection1OldLoteentrega)) {
                    loteentregaCollection1OldLoteentrega.setCodajudante(null);
                    loteentregaCollection1OldLoteentrega = em.merge(loteentregaCollection1OldLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollection1NewLoteentrega : loteentregaCollection1New) {
                if (!loteentregaCollection1Old.contains(loteentregaCollection1NewLoteentrega)) {
                    Entregapessoa oldCodajudanteOfLoteentregaCollection1NewLoteentrega = loteentregaCollection1NewLoteentrega.getCodajudante();
                    loteentregaCollection1NewLoteentrega.setCodajudante(entregapessoa);
                    loteentregaCollection1NewLoteentrega = em.merge(loteentregaCollection1NewLoteentrega);
                    if (oldCodajudanteOfLoteentregaCollection1NewLoteentrega != null && !oldCodajudanteOfLoteentregaCollection1NewLoteentrega.equals(entregapessoa)) {
                        oldCodajudanteOfLoteentregaCollection1NewLoteentrega.getLoteentregaCollection1().remove(loteentregaCollection1NewLoteentrega);
                        oldCodajudanteOfLoteentregaCollection1NewLoteentrega = em.merge(oldCodajudanteOfLoteentregaCollection1NewLoteentrega);
                    }
                }
            }
            for (Loteentrega loteentregaCollection2OldLoteentrega : loteentregaCollection2Old) {
                if (!loteentregaCollection2New.contains(loteentregaCollection2OldLoteentrega)) {
                    loteentregaCollection2OldLoteentrega.setCodajudante2(null);
                    loteentregaCollection2OldLoteentrega = em.merge(loteentregaCollection2OldLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollection2NewLoteentrega : loteentregaCollection2New) {
                if (!loteentregaCollection2Old.contains(loteentregaCollection2NewLoteentrega)) {
                    Entregapessoa oldCodajudante2OfLoteentregaCollection2NewLoteentrega = loteentregaCollection2NewLoteentrega.getCodajudante2();
                    loteentregaCollection2NewLoteentrega.setCodajudante2(entregapessoa);
                    loteentregaCollection2NewLoteentrega = em.merge(loteentregaCollection2NewLoteentrega);
                    if (oldCodajudante2OfLoteentregaCollection2NewLoteentrega != null && !oldCodajudante2OfLoteentregaCollection2NewLoteentrega.equals(entregapessoa)) {
                        oldCodajudante2OfLoteentregaCollection2NewLoteentrega.getLoteentregaCollection2().remove(loteentregaCollection2NewLoteentrega);
                        oldCodajudante2OfLoteentregaCollection2NewLoteentrega = em.merge(oldCodajudante2OfLoteentregaCollection2NewLoteentrega);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entregapessoa.getCodentregapessoa();
                if (findEntregapessoa(id) == null) {
                    throw new NonexistentEntityException("The entregapessoa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entregapessoa entregapessoa;
            try {
                entregapessoa = em.getReference(Entregapessoa.class, id);
                entregapessoa.getCodentregapessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entregapessoa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionOrphanCheck = entregapessoa.getMdfeletronicocondutorCollection();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionOrphanCheckMdfeletronicocondutor : mdfeletronicocondutorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Entregapessoa (" + entregapessoa + ") cannot be destroyed since the Mdfeletronicocondutor " + mdfeletronicocondutorCollectionOrphanCheckMdfeletronicocondutor + " in its mdfeletronicocondutorCollection field has a non-nullable codentregapessoa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Loteentrega> loteentregaCollection = entregapessoa.getLoteentregaCollection();
            for (Loteentrega loteentregaCollectionLoteentrega : loteentregaCollection) {
                loteentregaCollectionLoteentrega.setCodmotorista(null);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
            }
            Collection<Loteentrega> loteentregaCollection1 = entregapessoa.getLoteentregaCollection1();
            for (Loteentrega loteentregaCollection1Loteentrega : loteentregaCollection1) {
                loteentregaCollection1Loteentrega.setCodajudante(null);
                loteentregaCollection1Loteentrega = em.merge(loteentregaCollection1Loteentrega);
            }
            Collection<Loteentrega> loteentregaCollection2 = entregapessoa.getLoteentregaCollection2();
            for (Loteentrega loteentregaCollection2Loteentrega : loteentregaCollection2) {
                loteentregaCollection2Loteentrega.setCodajudante2(null);
                loteentregaCollection2Loteentrega = em.merge(loteentregaCollection2Loteentrega);
            }
            em.remove(entregapessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entregapessoa> findEntregapessoaEntities() {
        return findEntregapessoaEntities(true, -1, -1);
    }

    public List<Entregapessoa> findEntregapessoaEntities(int maxResults, int firstResult) {
        return findEntregapessoaEntities(false, maxResults, firstResult);
    }

    private List<Entregapessoa> findEntregapessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entregapessoa.class));
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

    public Entregapessoa findEntregapessoa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entregapessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntregapessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entregapessoa> rt = cq.from(Entregapessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
