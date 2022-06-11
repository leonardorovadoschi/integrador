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
import entidade.cplus.Cargo;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Especializacao;
import entidade.cplus.Usuario;
import entidade.cplus.Advertencia;
import entidade.cplus.Funcionariodesconto;
import entidade.cplus.Avaliacao;
import entidade.cplus.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class FuncionarioJpaController implements Serializable {

    public FuncionarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) throws PreexistingEntityException, Exception {
        if (funcionario.getCargoCollection() == null) {
            funcionario.setCargoCollection(new ArrayList<Cargo>());
        }
        if (funcionario.getEspecializacaoCollection() == null) {
            funcionario.setEspecializacaoCollection(new ArrayList<Especializacao>());
        }
        if (funcionario.getUsuarioCollection() == null) {
            funcionario.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (funcionario.getAdvertenciaCollection() == null) {
            funcionario.setAdvertenciaCollection(new ArrayList<Advertencia>());
        }
        if (funcionario.getAdvertenciaCollection1() == null) {
            funcionario.setAdvertenciaCollection1(new ArrayList<Advertencia>());
        }
        if (funcionario.getFuncionariodescontoCollection() == null) {
            funcionario.setFuncionariodescontoCollection(new ArrayList<Funcionariodesconto>());
        }
        if (funcionario.getAvaliacaoCollection() == null) {
            funcionario.setAvaliacaoCollection(new ArrayList<Avaliacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo codcargo = funcionario.getCodcargo();
            if (codcargo != null) {
                codcargo = em.getReference(codcargo.getClass(), codcargo.getCodcargo());
                funcionario.setCodcargo(codcargo);
            }
            Collection<Cargo> attachedCargoCollection = new ArrayList<Cargo>();
            for (Cargo cargoCollectionCargoToAttach : funcionario.getCargoCollection()) {
                cargoCollectionCargoToAttach = em.getReference(cargoCollectionCargoToAttach.getClass(), cargoCollectionCargoToAttach.getCodcargo());
                attachedCargoCollection.add(cargoCollectionCargoToAttach);
            }
            funcionario.setCargoCollection(attachedCargoCollection);
            Collection<Especializacao> attachedEspecializacaoCollection = new ArrayList<Especializacao>();
            for (Especializacao especializacaoCollectionEspecializacaoToAttach : funcionario.getEspecializacaoCollection()) {
                especializacaoCollectionEspecializacaoToAttach = em.getReference(especializacaoCollectionEspecializacaoToAttach.getClass(), especializacaoCollectionEspecializacaoToAttach.getCodespecializacao());
                attachedEspecializacaoCollection.add(especializacaoCollectionEspecializacaoToAttach);
            }
            funcionario.setEspecializacaoCollection(attachedEspecializacaoCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : funcionario.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getCoduser());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            funcionario.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Advertencia> attachedAdvertenciaCollection = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollectionAdvertenciaToAttach : funcionario.getAdvertenciaCollection()) {
                advertenciaCollectionAdvertenciaToAttach = em.getReference(advertenciaCollectionAdvertenciaToAttach.getClass(), advertenciaCollectionAdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollection.add(advertenciaCollectionAdvertenciaToAttach);
            }
            funcionario.setAdvertenciaCollection(attachedAdvertenciaCollection);
            Collection<Advertencia> attachedAdvertenciaCollection1 = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollection1AdvertenciaToAttach : funcionario.getAdvertenciaCollection1()) {
                advertenciaCollection1AdvertenciaToAttach = em.getReference(advertenciaCollection1AdvertenciaToAttach.getClass(), advertenciaCollection1AdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollection1.add(advertenciaCollection1AdvertenciaToAttach);
            }
            funcionario.setAdvertenciaCollection1(attachedAdvertenciaCollection1);
            Collection<Funcionariodesconto> attachedFuncionariodescontoCollection = new ArrayList<Funcionariodesconto>();
            for (Funcionariodesconto funcionariodescontoCollectionFuncionariodescontoToAttach : funcionario.getFuncionariodescontoCollection()) {
                funcionariodescontoCollectionFuncionariodescontoToAttach = em.getReference(funcionariodescontoCollectionFuncionariodescontoToAttach.getClass(), funcionariodescontoCollectionFuncionariodescontoToAttach.getCodfuncionariodesconto());
                attachedFuncionariodescontoCollection.add(funcionariodescontoCollectionFuncionariodescontoToAttach);
            }
            funcionario.setFuncionariodescontoCollection(attachedFuncionariodescontoCollection);
            Collection<Avaliacao> attachedAvaliacaoCollection = new ArrayList<Avaliacao>();
            for (Avaliacao avaliacaoCollectionAvaliacaoToAttach : funcionario.getAvaliacaoCollection()) {
                avaliacaoCollectionAvaliacaoToAttach = em.getReference(avaliacaoCollectionAvaliacaoToAttach.getClass(), avaliacaoCollectionAvaliacaoToAttach.getCodavaliacao());
                attachedAvaliacaoCollection.add(avaliacaoCollectionAvaliacaoToAttach);
            }
            funcionario.setAvaliacaoCollection(attachedAvaliacaoCollection);
            em.persist(funcionario);
            if (codcargo != null) {
                Funcionario oldCodfuncOfCodcargo = codcargo.getCodfunc();
                if (oldCodfuncOfCodcargo != null) {
                    oldCodfuncOfCodcargo.setCodcargo(null);
                    oldCodfuncOfCodcargo = em.merge(oldCodfuncOfCodcargo);
                }
                codcargo.setCodfunc(funcionario);
                codcargo = em.merge(codcargo);
            }
            for (Cargo cargoCollectionCargo : funcionario.getCargoCollection()) {
                Funcionario oldCodfuncOfCargoCollectionCargo = cargoCollectionCargo.getCodfunc();
                cargoCollectionCargo.setCodfunc(funcionario);
                cargoCollectionCargo = em.merge(cargoCollectionCargo);
                if (oldCodfuncOfCargoCollectionCargo != null) {
                    oldCodfuncOfCargoCollectionCargo.getCargoCollection().remove(cargoCollectionCargo);
                    oldCodfuncOfCargoCollectionCargo = em.merge(oldCodfuncOfCargoCollectionCargo);
                }
            }
            for (Especializacao especializacaoCollectionEspecializacao : funcionario.getEspecializacaoCollection()) {
                Funcionario oldCodfuncOfEspecializacaoCollectionEspecializacao = especializacaoCollectionEspecializacao.getCodfunc();
                especializacaoCollectionEspecializacao.setCodfunc(funcionario);
                especializacaoCollectionEspecializacao = em.merge(especializacaoCollectionEspecializacao);
                if (oldCodfuncOfEspecializacaoCollectionEspecializacao != null) {
                    oldCodfuncOfEspecializacaoCollectionEspecializacao.getEspecializacaoCollection().remove(especializacaoCollectionEspecializacao);
                    oldCodfuncOfEspecializacaoCollectionEspecializacao = em.merge(oldCodfuncOfEspecializacaoCollectionEspecializacao);
                }
            }
            for (Usuario usuarioCollectionUsuario : funcionario.getUsuarioCollection()) {
                Funcionario oldCodfuncionarioOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getCodfuncionario();
                usuarioCollectionUsuario.setCodfuncionario(funcionario);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldCodfuncionarioOfUsuarioCollectionUsuario != null) {
                    oldCodfuncionarioOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldCodfuncionarioOfUsuarioCollectionUsuario = em.merge(oldCodfuncionarioOfUsuarioCollectionUsuario);
                }
            }
            for (Advertencia advertenciaCollectionAdvertencia : funcionario.getAdvertenciaCollection()) {
                Funcionario oldCodfuncOfAdvertenciaCollectionAdvertencia = advertenciaCollectionAdvertencia.getCodfunc();
                advertenciaCollectionAdvertencia.setCodfunc(funcionario);
                advertenciaCollectionAdvertencia = em.merge(advertenciaCollectionAdvertencia);
                if (oldCodfuncOfAdvertenciaCollectionAdvertencia != null) {
                    oldCodfuncOfAdvertenciaCollectionAdvertencia.getAdvertenciaCollection().remove(advertenciaCollectionAdvertencia);
                    oldCodfuncOfAdvertenciaCollectionAdvertencia = em.merge(oldCodfuncOfAdvertenciaCollectionAdvertencia);
                }
            }
            for (Advertencia advertenciaCollection1Advertencia : funcionario.getAdvertenciaCollection1()) {
                Funcionario oldCodfuncadvertenciaOfAdvertenciaCollection1Advertencia = advertenciaCollection1Advertencia.getCodfuncadvertencia();
                advertenciaCollection1Advertencia.setCodfuncadvertencia(funcionario);
                advertenciaCollection1Advertencia = em.merge(advertenciaCollection1Advertencia);
                if (oldCodfuncadvertenciaOfAdvertenciaCollection1Advertencia != null) {
                    oldCodfuncadvertenciaOfAdvertenciaCollection1Advertencia.getAdvertenciaCollection1().remove(advertenciaCollection1Advertencia);
                    oldCodfuncadvertenciaOfAdvertenciaCollection1Advertencia = em.merge(oldCodfuncadvertenciaOfAdvertenciaCollection1Advertencia);
                }
            }
            for (Funcionariodesconto funcionariodescontoCollectionFuncionariodesconto : funcionario.getFuncionariodescontoCollection()) {
                Funcionario oldCodfuncionarioOfFuncionariodescontoCollectionFuncionariodesconto = funcionariodescontoCollectionFuncionariodesconto.getCodfuncionario();
                funcionariodescontoCollectionFuncionariodesconto.setCodfuncionario(funcionario);
                funcionariodescontoCollectionFuncionariodesconto = em.merge(funcionariodescontoCollectionFuncionariodesconto);
                if (oldCodfuncionarioOfFuncionariodescontoCollectionFuncionariodesconto != null) {
                    oldCodfuncionarioOfFuncionariodescontoCollectionFuncionariodesconto.getFuncionariodescontoCollection().remove(funcionariodescontoCollectionFuncionariodesconto);
                    oldCodfuncionarioOfFuncionariodescontoCollectionFuncionariodesconto = em.merge(oldCodfuncionarioOfFuncionariodescontoCollectionFuncionariodesconto);
                }
            }
            for (Avaliacao avaliacaoCollectionAvaliacao : funcionario.getAvaliacaoCollection()) {
                Funcionario oldCodfuncOfAvaliacaoCollectionAvaliacao = avaliacaoCollectionAvaliacao.getCodfunc();
                avaliacaoCollectionAvaliacao.setCodfunc(funcionario);
                avaliacaoCollectionAvaliacao = em.merge(avaliacaoCollectionAvaliacao);
                if (oldCodfuncOfAvaliacaoCollectionAvaliacao != null) {
                    oldCodfuncOfAvaliacaoCollectionAvaliacao.getAvaliacaoCollection().remove(avaliacaoCollectionAvaliacao);
                    oldCodfuncOfAvaliacaoCollectionAvaliacao = em.merge(oldCodfuncOfAvaliacaoCollectionAvaliacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionario(funcionario.getCodfuncionario()) != null) {
                throw new PreexistingEntityException("Funcionario " + funcionario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario persistentFuncionario = em.find(Funcionario.class, funcionario.getCodfuncionario());
            Cargo codcargoOld = persistentFuncionario.getCodcargo();
            Cargo codcargoNew = funcionario.getCodcargo();
            Collection<Cargo> cargoCollectionOld = persistentFuncionario.getCargoCollection();
            Collection<Cargo> cargoCollectionNew = funcionario.getCargoCollection();
            Collection<Especializacao> especializacaoCollectionOld = persistentFuncionario.getEspecializacaoCollection();
            Collection<Especializacao> especializacaoCollectionNew = funcionario.getEspecializacaoCollection();
            Collection<Usuario> usuarioCollectionOld = persistentFuncionario.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = funcionario.getUsuarioCollection();
            Collection<Advertencia> advertenciaCollectionOld = persistentFuncionario.getAdvertenciaCollection();
            Collection<Advertencia> advertenciaCollectionNew = funcionario.getAdvertenciaCollection();
            Collection<Advertencia> advertenciaCollection1Old = persistentFuncionario.getAdvertenciaCollection1();
            Collection<Advertencia> advertenciaCollection1New = funcionario.getAdvertenciaCollection1();
            Collection<Funcionariodesconto> funcionariodescontoCollectionOld = persistentFuncionario.getFuncionariodescontoCollection();
            Collection<Funcionariodesconto> funcionariodescontoCollectionNew = funcionario.getFuncionariodescontoCollection();
            Collection<Avaliacao> avaliacaoCollectionOld = persistentFuncionario.getAvaliacaoCollection();
            Collection<Avaliacao> avaliacaoCollectionNew = funcionario.getAvaliacaoCollection();
            if (codcargoNew != null) {
                codcargoNew = em.getReference(codcargoNew.getClass(), codcargoNew.getCodcargo());
                funcionario.setCodcargo(codcargoNew);
            }
            Collection<Cargo> attachedCargoCollectionNew = new ArrayList<Cargo>();
            for (Cargo cargoCollectionNewCargoToAttach : cargoCollectionNew) {
                cargoCollectionNewCargoToAttach = em.getReference(cargoCollectionNewCargoToAttach.getClass(), cargoCollectionNewCargoToAttach.getCodcargo());
                attachedCargoCollectionNew.add(cargoCollectionNewCargoToAttach);
            }
            cargoCollectionNew = attachedCargoCollectionNew;
            funcionario.setCargoCollection(cargoCollectionNew);
            Collection<Especializacao> attachedEspecializacaoCollectionNew = new ArrayList<Especializacao>();
            for (Especializacao especializacaoCollectionNewEspecializacaoToAttach : especializacaoCollectionNew) {
                especializacaoCollectionNewEspecializacaoToAttach = em.getReference(especializacaoCollectionNewEspecializacaoToAttach.getClass(), especializacaoCollectionNewEspecializacaoToAttach.getCodespecializacao());
                attachedEspecializacaoCollectionNew.add(especializacaoCollectionNewEspecializacaoToAttach);
            }
            especializacaoCollectionNew = attachedEspecializacaoCollectionNew;
            funcionario.setEspecializacaoCollection(especializacaoCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getCoduser());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            funcionario.setUsuarioCollection(usuarioCollectionNew);
            Collection<Advertencia> attachedAdvertenciaCollectionNew = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollectionNewAdvertenciaToAttach : advertenciaCollectionNew) {
                advertenciaCollectionNewAdvertenciaToAttach = em.getReference(advertenciaCollectionNewAdvertenciaToAttach.getClass(), advertenciaCollectionNewAdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollectionNew.add(advertenciaCollectionNewAdvertenciaToAttach);
            }
            advertenciaCollectionNew = attachedAdvertenciaCollectionNew;
            funcionario.setAdvertenciaCollection(advertenciaCollectionNew);
            Collection<Advertencia> attachedAdvertenciaCollection1New = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollection1NewAdvertenciaToAttach : advertenciaCollection1New) {
                advertenciaCollection1NewAdvertenciaToAttach = em.getReference(advertenciaCollection1NewAdvertenciaToAttach.getClass(), advertenciaCollection1NewAdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollection1New.add(advertenciaCollection1NewAdvertenciaToAttach);
            }
            advertenciaCollection1New = attachedAdvertenciaCollection1New;
            funcionario.setAdvertenciaCollection1(advertenciaCollection1New);
            Collection<Funcionariodesconto> attachedFuncionariodescontoCollectionNew = new ArrayList<Funcionariodesconto>();
            for (Funcionariodesconto funcionariodescontoCollectionNewFuncionariodescontoToAttach : funcionariodescontoCollectionNew) {
                funcionariodescontoCollectionNewFuncionariodescontoToAttach = em.getReference(funcionariodescontoCollectionNewFuncionariodescontoToAttach.getClass(), funcionariodescontoCollectionNewFuncionariodescontoToAttach.getCodfuncionariodesconto());
                attachedFuncionariodescontoCollectionNew.add(funcionariodescontoCollectionNewFuncionariodescontoToAttach);
            }
            funcionariodescontoCollectionNew = attachedFuncionariodescontoCollectionNew;
            funcionario.setFuncionariodescontoCollection(funcionariodescontoCollectionNew);
            Collection<Avaliacao> attachedAvaliacaoCollectionNew = new ArrayList<Avaliacao>();
            for (Avaliacao avaliacaoCollectionNewAvaliacaoToAttach : avaliacaoCollectionNew) {
                avaliacaoCollectionNewAvaliacaoToAttach = em.getReference(avaliacaoCollectionNewAvaliacaoToAttach.getClass(), avaliacaoCollectionNewAvaliacaoToAttach.getCodavaliacao());
                attachedAvaliacaoCollectionNew.add(avaliacaoCollectionNewAvaliacaoToAttach);
            }
            avaliacaoCollectionNew = attachedAvaliacaoCollectionNew;
            funcionario.setAvaliacaoCollection(avaliacaoCollectionNew);
            funcionario = em.merge(funcionario);
            if (codcargoOld != null && !codcargoOld.equals(codcargoNew)) {
                codcargoOld.setCodfunc(null);
                codcargoOld = em.merge(codcargoOld);
            }
            if (codcargoNew != null && !codcargoNew.equals(codcargoOld)) {
                Funcionario oldCodfuncOfCodcargo = codcargoNew.getCodfunc();
                if (oldCodfuncOfCodcargo != null) {
                    oldCodfuncOfCodcargo.setCodcargo(null);
                    oldCodfuncOfCodcargo = em.merge(oldCodfuncOfCodcargo);
                }
                codcargoNew.setCodfunc(funcionario);
                codcargoNew = em.merge(codcargoNew);
            }
            for (Cargo cargoCollectionOldCargo : cargoCollectionOld) {
                if (!cargoCollectionNew.contains(cargoCollectionOldCargo)) {
                    cargoCollectionOldCargo.setCodfunc(null);
                    cargoCollectionOldCargo = em.merge(cargoCollectionOldCargo);
                }
            }
            for (Cargo cargoCollectionNewCargo : cargoCollectionNew) {
                if (!cargoCollectionOld.contains(cargoCollectionNewCargo)) {
                    Funcionario oldCodfuncOfCargoCollectionNewCargo = cargoCollectionNewCargo.getCodfunc();
                    cargoCollectionNewCargo.setCodfunc(funcionario);
                    cargoCollectionNewCargo = em.merge(cargoCollectionNewCargo);
                    if (oldCodfuncOfCargoCollectionNewCargo != null && !oldCodfuncOfCargoCollectionNewCargo.equals(funcionario)) {
                        oldCodfuncOfCargoCollectionNewCargo.getCargoCollection().remove(cargoCollectionNewCargo);
                        oldCodfuncOfCargoCollectionNewCargo = em.merge(oldCodfuncOfCargoCollectionNewCargo);
                    }
                }
            }
            for (Especializacao especializacaoCollectionOldEspecializacao : especializacaoCollectionOld) {
                if (!especializacaoCollectionNew.contains(especializacaoCollectionOldEspecializacao)) {
                    especializacaoCollectionOldEspecializacao.setCodfunc(null);
                    especializacaoCollectionOldEspecializacao = em.merge(especializacaoCollectionOldEspecializacao);
                }
            }
            for (Especializacao especializacaoCollectionNewEspecializacao : especializacaoCollectionNew) {
                if (!especializacaoCollectionOld.contains(especializacaoCollectionNewEspecializacao)) {
                    Funcionario oldCodfuncOfEspecializacaoCollectionNewEspecializacao = especializacaoCollectionNewEspecializacao.getCodfunc();
                    especializacaoCollectionNewEspecializacao.setCodfunc(funcionario);
                    especializacaoCollectionNewEspecializacao = em.merge(especializacaoCollectionNewEspecializacao);
                    if (oldCodfuncOfEspecializacaoCollectionNewEspecializacao != null && !oldCodfuncOfEspecializacaoCollectionNewEspecializacao.equals(funcionario)) {
                        oldCodfuncOfEspecializacaoCollectionNewEspecializacao.getEspecializacaoCollection().remove(especializacaoCollectionNewEspecializacao);
                        oldCodfuncOfEspecializacaoCollectionNewEspecializacao = em.merge(oldCodfuncOfEspecializacaoCollectionNewEspecializacao);
                    }
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setCodfuncionario(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Funcionario oldCodfuncionarioOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getCodfuncionario();
                    usuarioCollectionNewUsuario.setCodfuncionario(funcionario);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldCodfuncionarioOfUsuarioCollectionNewUsuario != null && !oldCodfuncionarioOfUsuarioCollectionNewUsuario.equals(funcionario)) {
                        oldCodfuncionarioOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldCodfuncionarioOfUsuarioCollectionNewUsuario = em.merge(oldCodfuncionarioOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Advertencia advertenciaCollectionOldAdvertencia : advertenciaCollectionOld) {
                if (!advertenciaCollectionNew.contains(advertenciaCollectionOldAdvertencia)) {
                    advertenciaCollectionOldAdvertencia.setCodfunc(null);
                    advertenciaCollectionOldAdvertencia = em.merge(advertenciaCollectionOldAdvertencia);
                }
            }
            for (Advertencia advertenciaCollectionNewAdvertencia : advertenciaCollectionNew) {
                if (!advertenciaCollectionOld.contains(advertenciaCollectionNewAdvertencia)) {
                    Funcionario oldCodfuncOfAdvertenciaCollectionNewAdvertencia = advertenciaCollectionNewAdvertencia.getCodfunc();
                    advertenciaCollectionNewAdvertencia.setCodfunc(funcionario);
                    advertenciaCollectionNewAdvertencia = em.merge(advertenciaCollectionNewAdvertencia);
                    if (oldCodfuncOfAdvertenciaCollectionNewAdvertencia != null && !oldCodfuncOfAdvertenciaCollectionNewAdvertencia.equals(funcionario)) {
                        oldCodfuncOfAdvertenciaCollectionNewAdvertencia.getAdvertenciaCollection().remove(advertenciaCollectionNewAdvertencia);
                        oldCodfuncOfAdvertenciaCollectionNewAdvertencia = em.merge(oldCodfuncOfAdvertenciaCollectionNewAdvertencia);
                    }
                }
            }
            for (Advertencia advertenciaCollection1OldAdvertencia : advertenciaCollection1Old) {
                if (!advertenciaCollection1New.contains(advertenciaCollection1OldAdvertencia)) {
                    advertenciaCollection1OldAdvertencia.setCodfuncadvertencia(null);
                    advertenciaCollection1OldAdvertencia = em.merge(advertenciaCollection1OldAdvertencia);
                }
            }
            for (Advertencia advertenciaCollection1NewAdvertencia : advertenciaCollection1New) {
                if (!advertenciaCollection1Old.contains(advertenciaCollection1NewAdvertencia)) {
                    Funcionario oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia = advertenciaCollection1NewAdvertencia.getCodfuncadvertencia();
                    advertenciaCollection1NewAdvertencia.setCodfuncadvertencia(funcionario);
                    advertenciaCollection1NewAdvertencia = em.merge(advertenciaCollection1NewAdvertencia);
                    if (oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia != null && !oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia.equals(funcionario)) {
                        oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia.getAdvertenciaCollection1().remove(advertenciaCollection1NewAdvertencia);
                        oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia = em.merge(oldCodfuncadvertenciaOfAdvertenciaCollection1NewAdvertencia);
                    }
                }
            }
            for (Funcionariodesconto funcionariodescontoCollectionOldFuncionariodesconto : funcionariodescontoCollectionOld) {
                if (!funcionariodescontoCollectionNew.contains(funcionariodescontoCollectionOldFuncionariodesconto)) {
                    funcionariodescontoCollectionOldFuncionariodesconto.setCodfuncionario(null);
                    funcionariodescontoCollectionOldFuncionariodesconto = em.merge(funcionariodescontoCollectionOldFuncionariodesconto);
                }
            }
            for (Funcionariodesconto funcionariodescontoCollectionNewFuncionariodesconto : funcionariodescontoCollectionNew) {
                if (!funcionariodescontoCollectionOld.contains(funcionariodescontoCollectionNewFuncionariodesconto)) {
                    Funcionario oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto = funcionariodescontoCollectionNewFuncionariodesconto.getCodfuncionario();
                    funcionariodescontoCollectionNewFuncionariodesconto.setCodfuncionario(funcionario);
                    funcionariodescontoCollectionNewFuncionariodesconto = em.merge(funcionariodescontoCollectionNewFuncionariodesconto);
                    if (oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto != null && !oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto.equals(funcionario)) {
                        oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto.getFuncionariodescontoCollection().remove(funcionariodescontoCollectionNewFuncionariodesconto);
                        oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto = em.merge(oldCodfuncionarioOfFuncionariodescontoCollectionNewFuncionariodesconto);
                    }
                }
            }
            for (Avaliacao avaliacaoCollectionOldAvaliacao : avaliacaoCollectionOld) {
                if (!avaliacaoCollectionNew.contains(avaliacaoCollectionOldAvaliacao)) {
                    avaliacaoCollectionOldAvaliacao.setCodfunc(null);
                    avaliacaoCollectionOldAvaliacao = em.merge(avaliacaoCollectionOldAvaliacao);
                }
            }
            for (Avaliacao avaliacaoCollectionNewAvaliacao : avaliacaoCollectionNew) {
                if (!avaliacaoCollectionOld.contains(avaliacaoCollectionNewAvaliacao)) {
                    Funcionario oldCodfuncOfAvaliacaoCollectionNewAvaliacao = avaliacaoCollectionNewAvaliacao.getCodfunc();
                    avaliacaoCollectionNewAvaliacao.setCodfunc(funcionario);
                    avaliacaoCollectionNewAvaliacao = em.merge(avaliacaoCollectionNewAvaliacao);
                    if (oldCodfuncOfAvaliacaoCollectionNewAvaliacao != null && !oldCodfuncOfAvaliacaoCollectionNewAvaliacao.equals(funcionario)) {
                        oldCodfuncOfAvaliacaoCollectionNewAvaliacao.getAvaliacaoCollection().remove(avaliacaoCollectionNewAvaliacao);
                        oldCodfuncOfAvaliacaoCollectionNewAvaliacao = em.merge(oldCodfuncOfAvaliacaoCollectionNewAvaliacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funcionario.getCodfuncionario();
                if (findFuncionario(id) == null) {
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
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
            Funcionario funcionario;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getCodfuncionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            Cargo codcargo = funcionario.getCodcargo();
            if (codcargo != null) {
                codcargo.setCodfunc(null);
                codcargo = em.merge(codcargo);
            }
            Collection<Cargo> cargoCollection = funcionario.getCargoCollection();
            for (Cargo cargoCollectionCargo : cargoCollection) {
                cargoCollectionCargo.setCodfunc(null);
                cargoCollectionCargo = em.merge(cargoCollectionCargo);
            }
            Collection<Especializacao> especializacaoCollection = funcionario.getEspecializacaoCollection();
            for (Especializacao especializacaoCollectionEspecializacao : especializacaoCollection) {
                especializacaoCollectionEspecializacao.setCodfunc(null);
                especializacaoCollectionEspecializacao = em.merge(especializacaoCollectionEspecializacao);
            }
            Collection<Usuario> usuarioCollection = funcionario.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setCodfuncionario(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            Collection<Advertencia> advertenciaCollection = funcionario.getAdvertenciaCollection();
            for (Advertencia advertenciaCollectionAdvertencia : advertenciaCollection) {
                advertenciaCollectionAdvertencia.setCodfunc(null);
                advertenciaCollectionAdvertencia = em.merge(advertenciaCollectionAdvertencia);
            }
            Collection<Advertencia> advertenciaCollection1 = funcionario.getAdvertenciaCollection1();
            for (Advertencia advertenciaCollection1Advertencia : advertenciaCollection1) {
                advertenciaCollection1Advertencia.setCodfuncadvertencia(null);
                advertenciaCollection1Advertencia = em.merge(advertenciaCollection1Advertencia);
            }
            Collection<Funcionariodesconto> funcionariodescontoCollection = funcionario.getFuncionariodescontoCollection();
            for (Funcionariodesconto funcionariodescontoCollectionFuncionariodesconto : funcionariodescontoCollection) {
                funcionariodescontoCollectionFuncionariodesconto.setCodfuncionario(null);
                funcionariodescontoCollectionFuncionariodesconto = em.merge(funcionariodescontoCollectionFuncionariodesconto);
            }
            Collection<Avaliacao> avaliacaoCollection = funcionario.getAvaliacaoCollection();
            for (Avaliacao avaliacaoCollectionAvaliacao : avaliacaoCollection) {
                avaliacaoCollectionAvaliacao.setCodfunc(null);
                avaliacaoCollectionAvaliacao = em.merge(avaliacaoCollectionAvaliacao);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
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

    public Funcionario findFuncionario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
