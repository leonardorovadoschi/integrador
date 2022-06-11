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
import entidade.cplus.Entregapessoa;
import entidade.cplus.Loteentrega;
import entidade.cplus.Veiculos;
import entidade.cplus.Loteentregaitem;
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
public class LoteentregaJpaController implements Serializable {

    public LoteentregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Loteentrega loteentrega) throws PreexistingEntityException, Exception {
        if (loteentrega.getLoteentregaitemCollection() == null) {
            loteentrega.setLoteentregaitemCollection(new ArrayList<Loteentregaitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = loteentrega.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                loteentrega.setCodempresa(codempresa);
            }
            Entregapessoa codmotorista = loteentrega.getCodmotorista();
            if (codmotorista != null) {
                codmotorista = em.getReference(codmotorista.getClass(), codmotorista.getCodentregapessoa());
                loteentrega.setCodmotorista(codmotorista);
            }
            Entregapessoa codajudante = loteentrega.getCodajudante();
            if (codajudante != null) {
                codajudante = em.getReference(codajudante.getClass(), codajudante.getCodentregapessoa());
                loteentrega.setCodajudante(codajudante);
            }
            Entregapessoa codajudante2 = loteentrega.getCodajudante2();
            if (codajudante2 != null) {
                codajudante2 = em.getReference(codajudante2.getClass(), codajudante2.getCodentregapessoa());
                loteentrega.setCodajudante2(codajudante2);
            }
            Veiculos codveiculo = loteentrega.getCodveiculo();
            if (codveiculo != null) {
                codveiculo = em.getReference(codveiculo.getClass(), codveiculo.getCodveiculo());
                loteentrega.setCodveiculo(codveiculo);
            }
            Collection<Loteentregaitem> attachedLoteentregaitemCollection = new ArrayList<Loteentregaitem>();
            for (Loteentregaitem loteentregaitemCollectionLoteentregaitemToAttach : loteentrega.getLoteentregaitemCollection()) {
                loteentregaitemCollectionLoteentregaitemToAttach = em.getReference(loteentregaitemCollectionLoteentregaitemToAttach.getClass(), loteentregaitemCollectionLoteentregaitemToAttach.getCodloteentregaitem());
                attachedLoteentregaitemCollection.add(loteentregaitemCollectionLoteentregaitemToAttach);
            }
            loteentrega.setLoteentregaitemCollection(attachedLoteentregaitemCollection);
            em.persist(loteentrega);
            if (codempresa != null) {
                codempresa.getLoteentregaCollection().add(loteentrega);
                codempresa = em.merge(codempresa);
            }
            if (codmotorista != null) {
                codmotorista.getLoteentregaCollection().add(loteentrega);
                codmotorista = em.merge(codmotorista);
            }
            if (codajudante != null) {
                codajudante.getLoteentregaCollection().add(loteentrega);
                codajudante = em.merge(codajudante);
            }
            if (codajudante2 != null) {
                codajudante2.getLoteentregaCollection().add(loteentrega);
                codajudante2 = em.merge(codajudante2);
            }
            if (codveiculo != null) {
                codveiculo.getLoteentregaCollection().add(loteentrega);
                codveiculo = em.merge(codveiculo);
            }
            for (Loteentregaitem loteentregaitemCollectionLoteentregaitem : loteentrega.getLoteentregaitemCollection()) {
                Loteentrega oldCodloteentregaOfLoteentregaitemCollectionLoteentregaitem = loteentregaitemCollectionLoteentregaitem.getCodloteentrega();
                loteentregaitemCollectionLoteentregaitem.setCodloteentrega(loteentrega);
                loteentregaitemCollectionLoteentregaitem = em.merge(loteentregaitemCollectionLoteentregaitem);
                if (oldCodloteentregaOfLoteentregaitemCollectionLoteentregaitem != null) {
                    oldCodloteentregaOfLoteentregaitemCollectionLoteentregaitem.getLoteentregaitemCollection().remove(loteentregaitemCollectionLoteentregaitem);
                    oldCodloteentregaOfLoteentregaitemCollectionLoteentregaitem = em.merge(oldCodloteentregaOfLoteentregaitemCollectionLoteentregaitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLoteentrega(loteentrega.getCodloteentrega()) != null) {
                throw new PreexistingEntityException("Loteentrega " + loteentrega + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Loteentrega loteentrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loteentrega persistentLoteentrega = em.find(Loteentrega.class, loteentrega.getCodloteentrega());
            Empresa codempresaOld = persistentLoteentrega.getCodempresa();
            Empresa codempresaNew = loteentrega.getCodempresa();
            Entregapessoa codmotoristaOld = persistentLoteentrega.getCodmotorista();
            Entregapessoa codmotoristaNew = loteentrega.getCodmotorista();
            Entregapessoa codajudanteOld = persistentLoteentrega.getCodajudante();
            Entregapessoa codajudanteNew = loteentrega.getCodajudante();
            Entregapessoa codajudante2Old = persistentLoteentrega.getCodajudante2();
            Entregapessoa codajudante2New = loteentrega.getCodajudante2();
            Veiculos codveiculoOld = persistentLoteentrega.getCodveiculo();
            Veiculos codveiculoNew = loteentrega.getCodveiculo();
            Collection<Loteentregaitem> loteentregaitemCollectionOld = persistentLoteentrega.getLoteentregaitemCollection();
            Collection<Loteentregaitem> loteentregaitemCollectionNew = loteentrega.getLoteentregaitemCollection();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                loteentrega.setCodempresa(codempresaNew);
            }
            if (codmotoristaNew != null) {
                codmotoristaNew = em.getReference(codmotoristaNew.getClass(), codmotoristaNew.getCodentregapessoa());
                loteentrega.setCodmotorista(codmotoristaNew);
            }
            if (codajudanteNew != null) {
                codajudanteNew = em.getReference(codajudanteNew.getClass(), codajudanteNew.getCodentregapessoa());
                loteentrega.setCodajudante(codajudanteNew);
            }
            if (codajudante2New != null) {
                codajudante2New = em.getReference(codajudante2New.getClass(), codajudante2New.getCodentregapessoa());
                loteentrega.setCodajudante2(codajudante2New);
            }
            if (codveiculoNew != null) {
                codveiculoNew = em.getReference(codveiculoNew.getClass(), codveiculoNew.getCodveiculo());
                loteentrega.setCodveiculo(codveiculoNew);
            }
            Collection<Loteentregaitem> attachedLoteentregaitemCollectionNew = new ArrayList<Loteentregaitem>();
            for (Loteentregaitem loteentregaitemCollectionNewLoteentregaitemToAttach : loteentregaitemCollectionNew) {
                loteentregaitemCollectionNewLoteentregaitemToAttach = em.getReference(loteentregaitemCollectionNewLoteentregaitemToAttach.getClass(), loteentregaitemCollectionNewLoteentregaitemToAttach.getCodloteentregaitem());
                attachedLoteentregaitemCollectionNew.add(loteentregaitemCollectionNewLoteentregaitemToAttach);
            }
            loteentregaitemCollectionNew = attachedLoteentregaitemCollectionNew;
            loteentrega.setLoteentregaitemCollection(loteentregaitemCollectionNew);
            loteentrega = em.merge(loteentrega);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getLoteentregaCollection().remove(loteentrega);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getLoteentregaCollection().add(loteentrega);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmotoristaOld != null && !codmotoristaOld.equals(codmotoristaNew)) {
                codmotoristaOld.getLoteentregaCollection().remove(loteentrega);
                codmotoristaOld = em.merge(codmotoristaOld);
            }
            if (codmotoristaNew != null && !codmotoristaNew.equals(codmotoristaOld)) {
                codmotoristaNew.getLoteentregaCollection().add(loteentrega);
                codmotoristaNew = em.merge(codmotoristaNew);
            }
            if (codajudanteOld != null && !codajudanteOld.equals(codajudanteNew)) {
                codajudanteOld.getLoteentregaCollection().remove(loteentrega);
                codajudanteOld = em.merge(codajudanteOld);
            }
            if (codajudanteNew != null && !codajudanteNew.equals(codajudanteOld)) {
                codajudanteNew.getLoteentregaCollection().add(loteentrega);
                codajudanteNew = em.merge(codajudanteNew);
            }
            if (codajudante2Old != null && !codajudante2Old.equals(codajudante2New)) {
                codajudante2Old.getLoteentregaCollection().remove(loteentrega);
                codajudante2Old = em.merge(codajudante2Old);
            }
            if (codajudante2New != null && !codajudante2New.equals(codajudante2Old)) {
                codajudante2New.getLoteentregaCollection().add(loteentrega);
                codajudante2New = em.merge(codajudante2New);
            }
            if (codveiculoOld != null && !codveiculoOld.equals(codveiculoNew)) {
                codveiculoOld.getLoteentregaCollection().remove(loteentrega);
                codveiculoOld = em.merge(codveiculoOld);
            }
            if (codveiculoNew != null && !codveiculoNew.equals(codveiculoOld)) {
                codveiculoNew.getLoteentregaCollection().add(loteentrega);
                codveiculoNew = em.merge(codveiculoNew);
            }
            for (Loteentregaitem loteentregaitemCollectionOldLoteentregaitem : loteentregaitemCollectionOld) {
                if (!loteentregaitemCollectionNew.contains(loteentregaitemCollectionOldLoteentregaitem)) {
                    loteentregaitemCollectionOldLoteentregaitem.setCodloteentrega(null);
                    loteentregaitemCollectionOldLoteentregaitem = em.merge(loteentregaitemCollectionOldLoteentregaitem);
                }
            }
            for (Loteentregaitem loteentregaitemCollectionNewLoteentregaitem : loteentregaitemCollectionNew) {
                if (!loteentregaitemCollectionOld.contains(loteentregaitemCollectionNewLoteentregaitem)) {
                    Loteentrega oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem = loteentregaitemCollectionNewLoteentregaitem.getCodloteentrega();
                    loteentregaitemCollectionNewLoteentregaitem.setCodloteentrega(loteentrega);
                    loteentregaitemCollectionNewLoteentregaitem = em.merge(loteentregaitemCollectionNewLoteentregaitem);
                    if (oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem != null && !oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem.equals(loteentrega)) {
                        oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem.getLoteentregaitemCollection().remove(loteentregaitemCollectionNewLoteentregaitem);
                        oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem = em.merge(oldCodloteentregaOfLoteentregaitemCollectionNewLoteentregaitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = loteentrega.getCodloteentrega();
                if (findLoteentrega(id) == null) {
                    throw new NonexistentEntityException("The loteentrega with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loteentrega loteentrega;
            try {
                loteentrega = em.getReference(Loteentrega.class, id);
                loteentrega.getCodloteentrega();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loteentrega with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = loteentrega.getCodempresa();
            if (codempresa != null) {
                codempresa.getLoteentregaCollection().remove(loteentrega);
                codempresa = em.merge(codempresa);
            }
            Entregapessoa codmotorista = loteentrega.getCodmotorista();
            if (codmotorista != null) {
                codmotorista.getLoteentregaCollection().remove(loteentrega);
                codmotorista = em.merge(codmotorista);
            }
            Entregapessoa codajudante = loteentrega.getCodajudante();
            if (codajudante != null) {
                codajudante.getLoteentregaCollection().remove(loteentrega);
                codajudante = em.merge(codajudante);
            }
            Entregapessoa codajudante2 = loteentrega.getCodajudante2();
            if (codajudante2 != null) {
                codajudante2.getLoteentregaCollection().remove(loteentrega);
                codajudante2 = em.merge(codajudante2);
            }
            Veiculos codveiculo = loteentrega.getCodveiculo();
            if (codveiculo != null) {
                codveiculo.getLoteentregaCollection().remove(loteentrega);
                codveiculo = em.merge(codveiculo);
            }
            Collection<Loteentregaitem> loteentregaitemCollection = loteentrega.getLoteentregaitemCollection();
            for (Loteentregaitem loteentregaitemCollectionLoteentregaitem : loteentregaitemCollection) {
                loteentregaitemCollectionLoteentregaitem.setCodloteentrega(null);
                loteentregaitemCollectionLoteentregaitem = em.merge(loteentregaitemCollectionLoteentregaitem);
            }
            em.remove(loteentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Loteentrega> findLoteentregaEntities() {
        return findLoteentregaEntities(true, -1, -1);
    }

    public List<Loteentrega> findLoteentregaEntities(int maxResults, int firstResult) {
        return findLoteentregaEntities(false, maxResults, firstResult);
    }

    private List<Loteentrega> findLoteentregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Loteentrega.class));
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

    public Loteentrega findLoteentrega(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Loteentrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoteentregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Loteentrega> rt = cq.from(Loteentrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
