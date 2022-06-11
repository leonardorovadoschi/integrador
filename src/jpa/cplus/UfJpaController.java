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
import entidade.cplus.Calculoicmsestado;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Empresauf;
import entidade.cplus.Mdfeletronicopercurso;
import entidade.cplus.Cidade;
import entidade.cplus.Regracfopitem;
import entidade.cplus.Veiculos;
import entidade.cplus.Icmsestado;
import entidade.cplus.Pessoa;
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Uf;
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
public class UfJpaController implements Serializable {

    public UfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Uf uf) throws PreexistingEntityException, Exception {
        if (uf.getCalculoicmsestadoCollection() == null) {
            uf.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (uf.getCalculoicmsestadoCollection1() == null) {
            uf.setCalculoicmsestadoCollection1(new ArrayList<Calculoicmsestado>());
        }
        if (uf.getEmpresaufCollection() == null) {
            uf.setEmpresaufCollection(new ArrayList<Empresauf>());
        }
        if (uf.getMdfeletronicopercursoCollection() == null) {
            uf.setMdfeletronicopercursoCollection(new ArrayList<Mdfeletronicopercurso>());
        }
        if (uf.getCidadeCollection() == null) {
            uf.setCidadeCollection(new ArrayList<Cidade>());
        }
        if (uf.getRegracfopitemCollection() == null) {
            uf.setRegracfopitemCollection(new ArrayList<Regracfopitem>());
        }
        if (uf.getVeiculosCollection() == null) {
            uf.setVeiculosCollection(new ArrayList<Veiculos>());
        }
        if (uf.getIcmsestadoCollection() == null) {
            uf.setIcmsestadoCollection(new ArrayList<Icmsestado>());
        }
        if (uf.getIcmsestadoCollection1() == null) {
            uf.setIcmsestadoCollection1(new ArrayList<Icmsestado>());
        }
        if (uf.getPessoaCollection() == null) {
            uf.setPessoaCollection(new ArrayList<Pessoa>());
        }
        if (uf.getMdfeletronicoCollection() == null) {
            uf.setMdfeletronicoCollection(new ArrayList<Mdfeletronico>());
        }
        if (uf.getMdfeletronicoCollection1() == null) {
            uf.setMdfeletronicoCollection1(new ArrayList<Mdfeletronico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : uf.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            uf.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1 = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1CalculoicmsestadoToAttach : uf.getCalculoicmsestadoCollection1()) {
                calculoicmsestadoCollection1CalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1CalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1CalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1.add(calculoicmsestadoCollection1CalculoicmsestadoToAttach);
            }
            uf.setCalculoicmsestadoCollection1(attachedCalculoicmsestadoCollection1);
            Collection<Empresauf> attachedEmpresaufCollection = new ArrayList<Empresauf>();
            for (Empresauf empresaufCollectionEmpresaufToAttach : uf.getEmpresaufCollection()) {
                empresaufCollectionEmpresaufToAttach = em.getReference(empresaufCollectionEmpresaufToAttach.getClass(), empresaufCollectionEmpresaufToAttach.getCodempresauf());
                attachedEmpresaufCollection.add(empresaufCollectionEmpresaufToAttach);
            }
            uf.setEmpresaufCollection(attachedEmpresaufCollection);
            Collection<Mdfeletronicopercurso> attachedMdfeletronicopercursoCollection = new ArrayList<Mdfeletronicopercurso>();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach : uf.getMdfeletronicopercursoCollection()) {
                mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach = em.getReference(mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach.getClass(), mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach.getCodmdfeletronicopercurso());
                attachedMdfeletronicopercursoCollection.add(mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach);
            }
            uf.setMdfeletronicopercursoCollection(attachedMdfeletronicopercursoCollection);
            Collection<Cidade> attachedCidadeCollection = new ArrayList<Cidade>();
            for (Cidade cidadeCollectionCidadeToAttach : uf.getCidadeCollection()) {
                cidadeCollectionCidadeToAttach = em.getReference(cidadeCollectionCidadeToAttach.getClass(), cidadeCollectionCidadeToAttach.getCodcidade());
                attachedCidadeCollection.add(cidadeCollectionCidadeToAttach);
            }
            uf.setCidadeCollection(attachedCidadeCollection);
            Collection<Regracfopitem> attachedRegracfopitemCollection = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionRegracfopitemToAttach : uf.getRegracfopitemCollection()) {
                regracfopitemCollectionRegracfopitemToAttach = em.getReference(regracfopitemCollectionRegracfopitemToAttach.getClass(), regracfopitemCollectionRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollection.add(regracfopitemCollectionRegracfopitemToAttach);
            }
            uf.setRegracfopitemCollection(attachedRegracfopitemCollection);
            Collection<Veiculos> attachedVeiculosCollection = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionVeiculosToAttach : uf.getVeiculosCollection()) {
                veiculosCollectionVeiculosToAttach = em.getReference(veiculosCollectionVeiculosToAttach.getClass(), veiculosCollectionVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollection.add(veiculosCollectionVeiculosToAttach);
            }
            uf.setVeiculosCollection(attachedVeiculosCollection);
            Collection<Icmsestado> attachedIcmsestadoCollection = new ArrayList<Icmsestado>();
            for (Icmsestado icmsestadoCollectionIcmsestadoToAttach : uf.getIcmsestadoCollection()) {
                icmsestadoCollectionIcmsestadoToAttach = em.getReference(icmsestadoCollectionIcmsestadoToAttach.getClass(), icmsestadoCollectionIcmsestadoToAttach.getIcmsestadoPK());
                attachedIcmsestadoCollection.add(icmsestadoCollectionIcmsestadoToAttach);
            }
            uf.setIcmsestadoCollection(attachedIcmsestadoCollection);
            Collection<Icmsestado> attachedIcmsestadoCollection1 = new ArrayList<Icmsestado>();
            for (Icmsestado icmsestadoCollection1IcmsestadoToAttach : uf.getIcmsestadoCollection1()) {
                icmsestadoCollection1IcmsestadoToAttach = em.getReference(icmsestadoCollection1IcmsestadoToAttach.getClass(), icmsestadoCollection1IcmsestadoToAttach.getIcmsestadoPK());
                attachedIcmsestadoCollection1.add(icmsestadoCollection1IcmsestadoToAttach);
            }
            uf.setIcmsestadoCollection1(attachedIcmsestadoCollection1);
            Collection<Pessoa> attachedPessoaCollection = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionPessoaToAttach : uf.getPessoaCollection()) {
                pessoaCollectionPessoaToAttach = em.getReference(pessoaCollectionPessoaToAttach.getClass(), pessoaCollectionPessoaToAttach.getCodpessoa());
                attachedPessoaCollection.add(pessoaCollectionPessoaToAttach);
            }
            uf.setPessoaCollection(attachedPessoaCollection);
            Collection<Mdfeletronico> attachedMdfeletronicoCollection = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronicoToAttach : uf.getMdfeletronicoCollection()) {
                mdfeletronicoCollectionMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollection.add(mdfeletronicoCollectionMdfeletronicoToAttach);
            }
            uf.setMdfeletronicoCollection(attachedMdfeletronicoCollection);
            Collection<Mdfeletronico> attachedMdfeletronicoCollection1 = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollection1MdfeletronicoToAttach : uf.getMdfeletronicoCollection1()) {
                mdfeletronicoCollection1MdfeletronicoToAttach = em.getReference(mdfeletronicoCollection1MdfeletronicoToAttach.getClass(), mdfeletronicoCollection1MdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollection1.add(mdfeletronicoCollection1MdfeletronicoToAttach);
            }
            uf.setMdfeletronicoCollection1(attachedMdfeletronicoCollection1);
            em.persist(uf);
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : uf.getCalculoicmsestadoCollection()) {
                Uf oldCodufdestinoOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodufdestino();
                calculoicmsestadoCollectionCalculoicmsestado.setCodufdestino(uf);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodufdestinoOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodufdestinoOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodufdestinoOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodufdestinoOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1Calculoicmsestado : uf.getCalculoicmsestadoCollection1()) {
                Uf oldCoduforigemOfCalculoicmsestadoCollection1Calculoicmsestado = calculoicmsestadoCollection1Calculoicmsestado.getCoduforigem();
                calculoicmsestadoCollection1Calculoicmsestado.setCoduforigem(uf);
                calculoicmsestadoCollection1Calculoicmsestado = em.merge(calculoicmsestadoCollection1Calculoicmsestado);
                if (oldCoduforigemOfCalculoicmsestadoCollection1Calculoicmsestado != null) {
                    oldCoduforigemOfCalculoicmsestadoCollection1Calculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1Calculoicmsestado);
                    oldCoduforigemOfCalculoicmsestadoCollection1Calculoicmsestado = em.merge(oldCoduforigemOfCalculoicmsestadoCollection1Calculoicmsestado);
                }
            }
            for (Empresauf empresaufCollectionEmpresauf : uf.getEmpresaufCollection()) {
                Uf oldCodufOfEmpresaufCollectionEmpresauf = empresaufCollectionEmpresauf.getCoduf();
                empresaufCollectionEmpresauf.setCoduf(uf);
                empresaufCollectionEmpresauf = em.merge(empresaufCollectionEmpresauf);
                if (oldCodufOfEmpresaufCollectionEmpresauf != null) {
                    oldCodufOfEmpresaufCollectionEmpresauf.getEmpresaufCollection().remove(empresaufCollectionEmpresauf);
                    oldCodufOfEmpresaufCollectionEmpresauf = em.merge(oldCodufOfEmpresaufCollectionEmpresauf);
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionMdfeletronicopercurso : uf.getMdfeletronicopercursoCollection()) {
                Uf oldCodufOfMdfeletronicopercursoCollectionMdfeletronicopercurso = mdfeletronicopercursoCollectionMdfeletronicopercurso.getCoduf();
                mdfeletronicopercursoCollectionMdfeletronicopercurso.setCoduf(uf);
                mdfeletronicopercursoCollectionMdfeletronicopercurso = em.merge(mdfeletronicopercursoCollectionMdfeletronicopercurso);
                if (oldCodufOfMdfeletronicopercursoCollectionMdfeletronicopercurso != null) {
                    oldCodufOfMdfeletronicopercursoCollectionMdfeletronicopercurso.getMdfeletronicopercursoCollection().remove(mdfeletronicopercursoCollectionMdfeletronicopercurso);
                    oldCodufOfMdfeletronicopercursoCollectionMdfeletronicopercurso = em.merge(oldCodufOfMdfeletronicopercursoCollectionMdfeletronicopercurso);
                }
            }
            for (Cidade cidadeCollectionCidade : uf.getCidadeCollection()) {
                Uf oldCodufOfCidadeCollectionCidade = cidadeCollectionCidade.getCoduf();
                cidadeCollectionCidade.setCoduf(uf);
                cidadeCollectionCidade = em.merge(cidadeCollectionCidade);
                if (oldCodufOfCidadeCollectionCidade != null) {
                    oldCodufOfCidadeCollectionCidade.getCidadeCollection().remove(cidadeCollectionCidade);
                    oldCodufOfCidadeCollectionCidade = em.merge(oldCodufOfCidadeCollectionCidade);
                }
            }
            for (Regracfopitem regracfopitemCollectionRegracfopitem : uf.getRegracfopitemCollection()) {
                Uf oldCodufOfRegracfopitemCollectionRegracfopitem = regracfopitemCollectionRegracfopitem.getCoduf();
                regracfopitemCollectionRegracfopitem.setCoduf(uf);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
                if (oldCodufOfRegracfopitemCollectionRegracfopitem != null) {
                    oldCodufOfRegracfopitemCollectionRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionRegracfopitem);
                    oldCodufOfRegracfopitemCollectionRegracfopitem = em.merge(oldCodufOfRegracfopitemCollectionRegracfopitem);
                }
            }
            for (Veiculos veiculosCollectionVeiculos : uf.getVeiculosCollection()) {
                Uf oldCodufOfVeiculosCollectionVeiculos = veiculosCollectionVeiculos.getCoduf();
                veiculosCollectionVeiculos.setCoduf(uf);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
                if (oldCodufOfVeiculosCollectionVeiculos != null) {
                    oldCodufOfVeiculosCollectionVeiculos.getVeiculosCollection().remove(veiculosCollectionVeiculos);
                    oldCodufOfVeiculosCollectionVeiculos = em.merge(oldCodufOfVeiculosCollectionVeiculos);
                }
            }
            for (Icmsestado icmsestadoCollectionIcmsestado : uf.getIcmsestadoCollection()) {
                Uf oldUfOfIcmsestadoCollectionIcmsestado = icmsestadoCollectionIcmsestado.getUf();
                icmsestadoCollectionIcmsestado.setUf(uf);
                icmsestadoCollectionIcmsestado = em.merge(icmsestadoCollectionIcmsestado);
                if (oldUfOfIcmsestadoCollectionIcmsestado != null) {
                    oldUfOfIcmsestadoCollectionIcmsestado.getIcmsestadoCollection().remove(icmsestadoCollectionIcmsestado);
                    oldUfOfIcmsestadoCollectionIcmsestado = em.merge(oldUfOfIcmsestadoCollectionIcmsestado);
                }
            }
            for (Icmsestado icmsestadoCollection1Icmsestado : uf.getIcmsestadoCollection1()) {
                Uf oldUf1OfIcmsestadoCollection1Icmsestado = icmsestadoCollection1Icmsestado.getUf1();
                icmsestadoCollection1Icmsestado.setUf1(uf);
                icmsestadoCollection1Icmsestado = em.merge(icmsestadoCollection1Icmsestado);
                if (oldUf1OfIcmsestadoCollection1Icmsestado != null) {
                    oldUf1OfIcmsestadoCollection1Icmsestado.getIcmsestadoCollection1().remove(icmsestadoCollection1Icmsestado);
                    oldUf1OfIcmsestadoCollection1Icmsestado = em.merge(oldUf1OfIcmsestadoCollection1Icmsestado);
                }
            }
            for (Pessoa pessoaCollectionPessoa : uf.getPessoaCollection()) {
                Uf oldCodufOfPessoaCollectionPessoa = pessoaCollectionPessoa.getCoduf();
                pessoaCollectionPessoa.setCoduf(uf);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
                if (oldCodufOfPessoaCollectionPessoa != null) {
                    oldCodufOfPessoaCollectionPessoa.getPessoaCollection().remove(pessoaCollectionPessoa);
                    oldCodufOfPessoaCollectionPessoa = em.merge(oldCodufOfPessoaCollectionPessoa);
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronico : uf.getMdfeletronicoCollection()) {
                Uf oldCoduffimOfMdfeletronicoCollectionMdfeletronico = mdfeletronicoCollectionMdfeletronico.getCoduffim();
                mdfeletronicoCollectionMdfeletronico.setCoduffim(uf);
                mdfeletronicoCollectionMdfeletronico = em.merge(mdfeletronicoCollectionMdfeletronico);
                if (oldCoduffimOfMdfeletronicoCollectionMdfeletronico != null) {
                    oldCoduffimOfMdfeletronicoCollectionMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionMdfeletronico);
                    oldCoduffimOfMdfeletronicoCollectionMdfeletronico = em.merge(oldCoduffimOfMdfeletronicoCollectionMdfeletronico);
                }
            }
            for (Mdfeletronico mdfeletronicoCollection1Mdfeletronico : uf.getMdfeletronicoCollection1()) {
                Uf oldCodufinicioOfMdfeletronicoCollection1Mdfeletronico = mdfeletronicoCollection1Mdfeletronico.getCodufinicio();
                mdfeletronicoCollection1Mdfeletronico.setCodufinicio(uf);
                mdfeletronicoCollection1Mdfeletronico = em.merge(mdfeletronicoCollection1Mdfeletronico);
                if (oldCodufinicioOfMdfeletronicoCollection1Mdfeletronico != null) {
                    oldCodufinicioOfMdfeletronicoCollection1Mdfeletronico.getMdfeletronicoCollection1().remove(mdfeletronicoCollection1Mdfeletronico);
                    oldCodufinicioOfMdfeletronicoCollection1Mdfeletronico = em.merge(oldCodufinicioOfMdfeletronicoCollection1Mdfeletronico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUf(uf.getCoduf()) != null) {
                throw new PreexistingEntityException("Uf " + uf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Uf uf) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf persistentUf = em.find(Uf.class, uf.getCoduf());
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentUf.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = uf.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1Old = persistentUf.getCalculoicmsestadoCollection1();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1New = uf.getCalculoicmsestadoCollection1();
            Collection<Empresauf> empresaufCollectionOld = persistentUf.getEmpresaufCollection();
            Collection<Empresauf> empresaufCollectionNew = uf.getEmpresaufCollection();
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionOld = persistentUf.getMdfeletronicopercursoCollection();
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionNew = uf.getMdfeletronicopercursoCollection();
            Collection<Cidade> cidadeCollectionOld = persistentUf.getCidadeCollection();
            Collection<Cidade> cidadeCollectionNew = uf.getCidadeCollection();
            Collection<Regracfopitem> regracfopitemCollectionOld = persistentUf.getRegracfopitemCollection();
            Collection<Regracfopitem> regracfopitemCollectionNew = uf.getRegracfopitemCollection();
            Collection<Veiculos> veiculosCollectionOld = persistentUf.getVeiculosCollection();
            Collection<Veiculos> veiculosCollectionNew = uf.getVeiculosCollection();
            Collection<Icmsestado> icmsestadoCollectionOld = persistentUf.getIcmsestadoCollection();
            Collection<Icmsestado> icmsestadoCollectionNew = uf.getIcmsestadoCollection();
            Collection<Icmsestado> icmsestadoCollection1Old = persistentUf.getIcmsestadoCollection1();
            Collection<Icmsestado> icmsestadoCollection1New = uf.getIcmsestadoCollection1();
            Collection<Pessoa> pessoaCollectionOld = persistentUf.getPessoaCollection();
            Collection<Pessoa> pessoaCollectionNew = uf.getPessoaCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionOld = persistentUf.getMdfeletronicoCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionNew = uf.getMdfeletronicoCollection();
            Collection<Mdfeletronico> mdfeletronicoCollection1Old = persistentUf.getMdfeletronicoCollection1();
            Collection<Mdfeletronico> mdfeletronicoCollection1New = uf.getMdfeletronicoCollection1();
            List<String> illegalOrphanMessages = null;
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calculoicmsestado " + calculoicmsestadoCollectionOldCalculoicmsestado + " since its codufdestino field is not nullable.");
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1OldCalculoicmsestado : calculoicmsestadoCollection1Old) {
                if (!calculoicmsestadoCollection1New.contains(calculoicmsestadoCollection1OldCalculoicmsestado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calculoicmsestado " + calculoicmsestadoCollection1OldCalculoicmsestado + " since its coduforigem field is not nullable.");
                }
            }
            for (Empresauf empresaufCollectionOldEmpresauf : empresaufCollectionOld) {
                if (!empresaufCollectionNew.contains(empresaufCollectionOldEmpresauf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresauf " + empresaufCollectionOldEmpresauf + " since its coduf field is not nullable.");
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionOldMdfeletronicopercurso : mdfeletronicopercursoCollectionOld) {
                if (!mdfeletronicopercursoCollectionNew.contains(mdfeletronicopercursoCollectionOldMdfeletronicopercurso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicopercurso " + mdfeletronicopercursoCollectionOldMdfeletronicopercurso + " since its coduf field is not nullable.");
                }
            }
            for (Regracfopitem regracfopitemCollectionOldRegracfopitem : regracfopitemCollectionOld) {
                if (!regracfopitemCollectionNew.contains(regracfopitemCollectionOldRegracfopitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Regracfopitem " + regracfopitemCollectionOldRegracfopitem + " since its coduf field is not nullable.");
                }
            }
            for (Icmsestado icmsestadoCollectionOldIcmsestado : icmsestadoCollectionOld) {
                if (!icmsestadoCollectionNew.contains(icmsestadoCollectionOldIcmsestado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Icmsestado " + icmsestadoCollectionOldIcmsestado + " since its uf field is not nullable.");
                }
            }
            for (Icmsestado icmsestadoCollection1OldIcmsestado : icmsestadoCollection1Old) {
                if (!icmsestadoCollection1New.contains(icmsestadoCollection1OldIcmsestado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Icmsestado " + icmsestadoCollection1OldIcmsestado + " since its uf1 field is not nullable.");
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionOldMdfeletronico : mdfeletronicoCollectionOld) {
                if (!mdfeletronicoCollectionNew.contains(mdfeletronicoCollectionOldMdfeletronico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronico " + mdfeletronicoCollectionOldMdfeletronico + " since its coduffim field is not nullable.");
                }
            }
            for (Mdfeletronico mdfeletronicoCollection1OldMdfeletronico : mdfeletronicoCollection1Old) {
                if (!mdfeletronicoCollection1New.contains(mdfeletronicoCollection1OldMdfeletronico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronico " + mdfeletronicoCollection1OldMdfeletronico + " since its codufinicio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            uf.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1New = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestadoToAttach : calculoicmsestadoCollection1New) {
                calculoicmsestadoCollection1NewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1New.add(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollection1New = attachedCalculoicmsestadoCollection1New;
            uf.setCalculoicmsestadoCollection1(calculoicmsestadoCollection1New);
            Collection<Empresauf> attachedEmpresaufCollectionNew = new ArrayList<Empresauf>();
            for (Empresauf empresaufCollectionNewEmpresaufToAttach : empresaufCollectionNew) {
                empresaufCollectionNewEmpresaufToAttach = em.getReference(empresaufCollectionNewEmpresaufToAttach.getClass(), empresaufCollectionNewEmpresaufToAttach.getCodempresauf());
                attachedEmpresaufCollectionNew.add(empresaufCollectionNewEmpresaufToAttach);
            }
            empresaufCollectionNew = attachedEmpresaufCollectionNew;
            uf.setEmpresaufCollection(empresaufCollectionNew);
            Collection<Mdfeletronicopercurso> attachedMdfeletronicopercursoCollectionNew = new ArrayList<Mdfeletronicopercurso>();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach : mdfeletronicopercursoCollectionNew) {
                mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach = em.getReference(mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach.getClass(), mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach.getCodmdfeletronicopercurso());
                attachedMdfeletronicopercursoCollectionNew.add(mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach);
            }
            mdfeletronicopercursoCollectionNew = attachedMdfeletronicopercursoCollectionNew;
            uf.setMdfeletronicopercursoCollection(mdfeletronicopercursoCollectionNew);
            Collection<Cidade> attachedCidadeCollectionNew = new ArrayList<Cidade>();
            for (Cidade cidadeCollectionNewCidadeToAttach : cidadeCollectionNew) {
                cidadeCollectionNewCidadeToAttach = em.getReference(cidadeCollectionNewCidadeToAttach.getClass(), cidadeCollectionNewCidadeToAttach.getCodcidade());
                attachedCidadeCollectionNew.add(cidadeCollectionNewCidadeToAttach);
            }
            cidadeCollectionNew = attachedCidadeCollectionNew;
            uf.setCidadeCollection(cidadeCollectionNew);
            Collection<Regracfopitem> attachedRegracfopitemCollectionNew = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionNewRegracfopitemToAttach : regracfopitemCollectionNew) {
                regracfopitemCollectionNewRegracfopitemToAttach = em.getReference(regracfopitemCollectionNewRegracfopitemToAttach.getClass(), regracfopitemCollectionNewRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollectionNew.add(regracfopitemCollectionNewRegracfopitemToAttach);
            }
            regracfopitemCollectionNew = attachedRegracfopitemCollectionNew;
            uf.setRegracfopitemCollection(regracfopitemCollectionNew);
            Collection<Veiculos> attachedVeiculosCollectionNew = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionNewVeiculosToAttach : veiculosCollectionNew) {
                veiculosCollectionNewVeiculosToAttach = em.getReference(veiculosCollectionNewVeiculosToAttach.getClass(), veiculosCollectionNewVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollectionNew.add(veiculosCollectionNewVeiculosToAttach);
            }
            veiculosCollectionNew = attachedVeiculosCollectionNew;
            uf.setVeiculosCollection(veiculosCollectionNew);
            Collection<Icmsestado> attachedIcmsestadoCollectionNew = new ArrayList<Icmsestado>();
            for (Icmsestado icmsestadoCollectionNewIcmsestadoToAttach : icmsestadoCollectionNew) {
                icmsestadoCollectionNewIcmsestadoToAttach = em.getReference(icmsestadoCollectionNewIcmsestadoToAttach.getClass(), icmsestadoCollectionNewIcmsestadoToAttach.getIcmsestadoPK());
                attachedIcmsestadoCollectionNew.add(icmsestadoCollectionNewIcmsestadoToAttach);
            }
            icmsestadoCollectionNew = attachedIcmsestadoCollectionNew;
            uf.setIcmsestadoCollection(icmsestadoCollectionNew);
            Collection<Icmsestado> attachedIcmsestadoCollection1New = new ArrayList<Icmsestado>();
            for (Icmsestado icmsestadoCollection1NewIcmsestadoToAttach : icmsestadoCollection1New) {
                icmsestadoCollection1NewIcmsestadoToAttach = em.getReference(icmsestadoCollection1NewIcmsestadoToAttach.getClass(), icmsestadoCollection1NewIcmsestadoToAttach.getIcmsestadoPK());
                attachedIcmsestadoCollection1New.add(icmsestadoCollection1NewIcmsestadoToAttach);
            }
            icmsestadoCollection1New = attachedIcmsestadoCollection1New;
            uf.setIcmsestadoCollection1(icmsestadoCollection1New);
            Collection<Pessoa> attachedPessoaCollectionNew = new ArrayList<Pessoa>();
            for (Pessoa pessoaCollectionNewPessoaToAttach : pessoaCollectionNew) {
                pessoaCollectionNewPessoaToAttach = em.getReference(pessoaCollectionNewPessoaToAttach.getClass(), pessoaCollectionNewPessoaToAttach.getCodpessoa());
                attachedPessoaCollectionNew.add(pessoaCollectionNewPessoaToAttach);
            }
            pessoaCollectionNew = attachedPessoaCollectionNew;
            uf.setPessoaCollection(pessoaCollectionNew);
            Collection<Mdfeletronico> attachedMdfeletronicoCollectionNew = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronicoToAttach : mdfeletronicoCollectionNew) {
                mdfeletronicoCollectionNewMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionNewMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionNewMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollectionNew.add(mdfeletronicoCollectionNewMdfeletronicoToAttach);
            }
            mdfeletronicoCollectionNew = attachedMdfeletronicoCollectionNew;
            uf.setMdfeletronicoCollection(mdfeletronicoCollectionNew);
            Collection<Mdfeletronico> attachedMdfeletronicoCollection1New = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollection1NewMdfeletronicoToAttach : mdfeletronicoCollection1New) {
                mdfeletronicoCollection1NewMdfeletronicoToAttach = em.getReference(mdfeletronicoCollection1NewMdfeletronicoToAttach.getClass(), mdfeletronicoCollection1NewMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollection1New.add(mdfeletronicoCollection1NewMdfeletronicoToAttach);
            }
            mdfeletronicoCollection1New = attachedMdfeletronicoCollection1New;
            uf.setMdfeletronicoCollection1(mdfeletronicoCollection1New);
            uf = em.merge(uf);
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Uf oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodufdestino();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodufdestino(uf);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(uf)) {
                        oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodufdestinoOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestado : calculoicmsestadoCollection1New) {
                if (!calculoicmsestadoCollection1Old.contains(calculoicmsestadoCollection1NewCalculoicmsestado)) {
                    Uf oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado = calculoicmsestadoCollection1NewCalculoicmsestado.getCoduforigem();
                    calculoicmsestadoCollection1NewCalculoicmsestado.setCoduforigem(uf);
                    calculoicmsestadoCollection1NewCalculoicmsestado = em.merge(calculoicmsestadoCollection1NewCalculoicmsestado);
                    if (oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado != null && !oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado.equals(uf)) {
                        oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1NewCalculoicmsestado);
                        oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado = em.merge(oldCoduforigemOfCalculoicmsestadoCollection1NewCalculoicmsestado);
                    }
                }
            }
            for (Empresauf empresaufCollectionNewEmpresauf : empresaufCollectionNew) {
                if (!empresaufCollectionOld.contains(empresaufCollectionNewEmpresauf)) {
                    Uf oldCodufOfEmpresaufCollectionNewEmpresauf = empresaufCollectionNewEmpresauf.getCoduf();
                    empresaufCollectionNewEmpresauf.setCoduf(uf);
                    empresaufCollectionNewEmpresauf = em.merge(empresaufCollectionNewEmpresauf);
                    if (oldCodufOfEmpresaufCollectionNewEmpresauf != null && !oldCodufOfEmpresaufCollectionNewEmpresauf.equals(uf)) {
                        oldCodufOfEmpresaufCollectionNewEmpresauf.getEmpresaufCollection().remove(empresaufCollectionNewEmpresauf);
                        oldCodufOfEmpresaufCollectionNewEmpresauf = em.merge(oldCodufOfEmpresaufCollectionNewEmpresauf);
                    }
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionNewMdfeletronicopercurso : mdfeletronicopercursoCollectionNew) {
                if (!mdfeletronicopercursoCollectionOld.contains(mdfeletronicopercursoCollectionNewMdfeletronicopercurso)) {
                    Uf oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso = mdfeletronicopercursoCollectionNewMdfeletronicopercurso.getCoduf();
                    mdfeletronicopercursoCollectionNewMdfeletronicopercurso.setCoduf(uf);
                    mdfeletronicopercursoCollectionNewMdfeletronicopercurso = em.merge(mdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                    if (oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso != null && !oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso.equals(uf)) {
                        oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso.getMdfeletronicopercursoCollection().remove(mdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                        oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso = em.merge(oldCodufOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                    }
                }
            }
            for (Cidade cidadeCollectionOldCidade : cidadeCollectionOld) {
                if (!cidadeCollectionNew.contains(cidadeCollectionOldCidade)) {
                    cidadeCollectionOldCidade.setCoduf(null);
                    cidadeCollectionOldCidade = em.merge(cidadeCollectionOldCidade);
                }
            }
            for (Cidade cidadeCollectionNewCidade : cidadeCollectionNew) {
                if (!cidadeCollectionOld.contains(cidadeCollectionNewCidade)) {
                    Uf oldCodufOfCidadeCollectionNewCidade = cidadeCollectionNewCidade.getCoduf();
                    cidadeCollectionNewCidade.setCoduf(uf);
                    cidadeCollectionNewCidade = em.merge(cidadeCollectionNewCidade);
                    if (oldCodufOfCidadeCollectionNewCidade != null && !oldCodufOfCidadeCollectionNewCidade.equals(uf)) {
                        oldCodufOfCidadeCollectionNewCidade.getCidadeCollection().remove(cidadeCollectionNewCidade);
                        oldCodufOfCidadeCollectionNewCidade = em.merge(oldCodufOfCidadeCollectionNewCidade);
                    }
                }
            }
            for (Regracfopitem regracfopitemCollectionNewRegracfopitem : regracfopitemCollectionNew) {
                if (!regracfopitemCollectionOld.contains(regracfopitemCollectionNewRegracfopitem)) {
                    Uf oldCodufOfRegracfopitemCollectionNewRegracfopitem = regracfopitemCollectionNewRegracfopitem.getCoduf();
                    regracfopitemCollectionNewRegracfopitem.setCoduf(uf);
                    regracfopitemCollectionNewRegracfopitem = em.merge(regracfopitemCollectionNewRegracfopitem);
                    if (oldCodufOfRegracfopitemCollectionNewRegracfopitem != null && !oldCodufOfRegracfopitemCollectionNewRegracfopitem.equals(uf)) {
                        oldCodufOfRegracfopitemCollectionNewRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionNewRegracfopitem);
                        oldCodufOfRegracfopitemCollectionNewRegracfopitem = em.merge(oldCodufOfRegracfopitemCollectionNewRegracfopitem);
                    }
                }
            }
            for (Veiculos veiculosCollectionOldVeiculos : veiculosCollectionOld) {
                if (!veiculosCollectionNew.contains(veiculosCollectionOldVeiculos)) {
                    veiculosCollectionOldVeiculos.setCoduf(null);
                    veiculosCollectionOldVeiculos = em.merge(veiculosCollectionOldVeiculos);
                }
            }
            for (Veiculos veiculosCollectionNewVeiculos : veiculosCollectionNew) {
                if (!veiculosCollectionOld.contains(veiculosCollectionNewVeiculos)) {
                    Uf oldCodufOfVeiculosCollectionNewVeiculos = veiculosCollectionNewVeiculos.getCoduf();
                    veiculosCollectionNewVeiculos.setCoduf(uf);
                    veiculosCollectionNewVeiculos = em.merge(veiculosCollectionNewVeiculos);
                    if (oldCodufOfVeiculosCollectionNewVeiculos != null && !oldCodufOfVeiculosCollectionNewVeiculos.equals(uf)) {
                        oldCodufOfVeiculosCollectionNewVeiculos.getVeiculosCollection().remove(veiculosCollectionNewVeiculos);
                        oldCodufOfVeiculosCollectionNewVeiculos = em.merge(oldCodufOfVeiculosCollectionNewVeiculos);
                    }
                }
            }
            for (Icmsestado icmsestadoCollectionNewIcmsestado : icmsestadoCollectionNew) {
                if (!icmsestadoCollectionOld.contains(icmsestadoCollectionNewIcmsestado)) {
                    Uf oldUfOfIcmsestadoCollectionNewIcmsestado = icmsestadoCollectionNewIcmsestado.getUf();
                    icmsestadoCollectionNewIcmsestado.setUf(uf);
                    icmsestadoCollectionNewIcmsestado = em.merge(icmsestadoCollectionNewIcmsestado);
                    if (oldUfOfIcmsestadoCollectionNewIcmsestado != null && !oldUfOfIcmsestadoCollectionNewIcmsestado.equals(uf)) {
                        oldUfOfIcmsestadoCollectionNewIcmsestado.getIcmsestadoCollection().remove(icmsestadoCollectionNewIcmsestado);
                        oldUfOfIcmsestadoCollectionNewIcmsestado = em.merge(oldUfOfIcmsestadoCollectionNewIcmsestado);
                    }
                }
            }
            for (Icmsestado icmsestadoCollection1NewIcmsestado : icmsestadoCollection1New) {
                if (!icmsestadoCollection1Old.contains(icmsestadoCollection1NewIcmsestado)) {
                    Uf oldUf1OfIcmsestadoCollection1NewIcmsestado = icmsestadoCollection1NewIcmsestado.getUf1();
                    icmsestadoCollection1NewIcmsestado.setUf1(uf);
                    icmsestadoCollection1NewIcmsestado = em.merge(icmsestadoCollection1NewIcmsestado);
                    if (oldUf1OfIcmsestadoCollection1NewIcmsestado != null && !oldUf1OfIcmsestadoCollection1NewIcmsestado.equals(uf)) {
                        oldUf1OfIcmsestadoCollection1NewIcmsestado.getIcmsestadoCollection1().remove(icmsestadoCollection1NewIcmsestado);
                        oldUf1OfIcmsestadoCollection1NewIcmsestado = em.merge(oldUf1OfIcmsestadoCollection1NewIcmsestado);
                    }
                }
            }
            for (Pessoa pessoaCollectionOldPessoa : pessoaCollectionOld) {
                if (!pessoaCollectionNew.contains(pessoaCollectionOldPessoa)) {
                    pessoaCollectionOldPessoa.setCoduf(null);
                    pessoaCollectionOldPessoa = em.merge(pessoaCollectionOldPessoa);
                }
            }
            for (Pessoa pessoaCollectionNewPessoa : pessoaCollectionNew) {
                if (!pessoaCollectionOld.contains(pessoaCollectionNewPessoa)) {
                    Uf oldCodufOfPessoaCollectionNewPessoa = pessoaCollectionNewPessoa.getCoduf();
                    pessoaCollectionNewPessoa.setCoduf(uf);
                    pessoaCollectionNewPessoa = em.merge(pessoaCollectionNewPessoa);
                    if (oldCodufOfPessoaCollectionNewPessoa != null && !oldCodufOfPessoaCollectionNewPessoa.equals(uf)) {
                        oldCodufOfPessoaCollectionNewPessoa.getPessoaCollection().remove(pessoaCollectionNewPessoa);
                        oldCodufOfPessoaCollectionNewPessoa = em.merge(oldCodufOfPessoaCollectionNewPessoa);
                    }
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronico : mdfeletronicoCollectionNew) {
                if (!mdfeletronicoCollectionOld.contains(mdfeletronicoCollectionNewMdfeletronico)) {
                    Uf oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico = mdfeletronicoCollectionNewMdfeletronico.getCoduffim();
                    mdfeletronicoCollectionNewMdfeletronico.setCoduffim(uf);
                    mdfeletronicoCollectionNewMdfeletronico = em.merge(mdfeletronicoCollectionNewMdfeletronico);
                    if (oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico != null && !oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico.equals(uf)) {
                        oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionNewMdfeletronico);
                        oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico = em.merge(oldCoduffimOfMdfeletronicoCollectionNewMdfeletronico);
                    }
                }
            }
            for (Mdfeletronico mdfeletronicoCollection1NewMdfeletronico : mdfeletronicoCollection1New) {
                if (!mdfeletronicoCollection1Old.contains(mdfeletronicoCollection1NewMdfeletronico)) {
                    Uf oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico = mdfeletronicoCollection1NewMdfeletronico.getCodufinicio();
                    mdfeletronicoCollection1NewMdfeletronico.setCodufinicio(uf);
                    mdfeletronicoCollection1NewMdfeletronico = em.merge(mdfeletronicoCollection1NewMdfeletronico);
                    if (oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico != null && !oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico.equals(uf)) {
                        oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico.getMdfeletronicoCollection1().remove(mdfeletronicoCollection1NewMdfeletronico);
                        oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico = em.merge(oldCodufinicioOfMdfeletronicoCollection1NewMdfeletronico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = uf.getCoduf();
                if (findUf(id) == null) {
                    throw new NonexistentEntityException("The uf with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf uf;
            try {
                uf = em.getReference(Uf.class, id);
                uf.getCoduf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The uf with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOrphanCheck = uf.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionOrphanCheckCalculoicmsestado : calculoicmsestadoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Calculoicmsestado " + calculoicmsestadoCollectionOrphanCheckCalculoicmsestado + " in its calculoicmsestadoCollection field has a non-nullable codufdestino field.");
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection1OrphanCheck = uf.getCalculoicmsestadoCollection1();
            for (Calculoicmsestado calculoicmsestadoCollection1OrphanCheckCalculoicmsestado : calculoicmsestadoCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Calculoicmsestado " + calculoicmsestadoCollection1OrphanCheckCalculoicmsestado + " in its calculoicmsestadoCollection1 field has a non-nullable coduforigem field.");
            }
            Collection<Empresauf> empresaufCollectionOrphanCheck = uf.getEmpresaufCollection();
            for (Empresauf empresaufCollectionOrphanCheckEmpresauf : empresaufCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Empresauf " + empresaufCollectionOrphanCheckEmpresauf + " in its empresaufCollection field has a non-nullable coduf field.");
            }
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionOrphanCheck = uf.getMdfeletronicopercursoCollection();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionOrphanCheckMdfeletronicopercurso : mdfeletronicopercursoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Mdfeletronicopercurso " + mdfeletronicopercursoCollectionOrphanCheckMdfeletronicopercurso + " in its mdfeletronicopercursoCollection field has a non-nullable coduf field.");
            }
            Collection<Regracfopitem> regracfopitemCollectionOrphanCheck = uf.getRegracfopitemCollection();
            for (Regracfopitem regracfopitemCollectionOrphanCheckRegracfopitem : regracfopitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Regracfopitem " + regracfopitemCollectionOrphanCheckRegracfopitem + " in its regracfopitemCollection field has a non-nullable coduf field.");
            }
            Collection<Icmsestado> icmsestadoCollectionOrphanCheck = uf.getIcmsestadoCollection();
            for (Icmsestado icmsestadoCollectionOrphanCheckIcmsestado : icmsestadoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Icmsestado " + icmsestadoCollectionOrphanCheckIcmsestado + " in its icmsestadoCollection field has a non-nullable uf field.");
            }
            Collection<Icmsestado> icmsestadoCollection1OrphanCheck = uf.getIcmsestadoCollection1();
            for (Icmsestado icmsestadoCollection1OrphanCheckIcmsestado : icmsestadoCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Icmsestado " + icmsestadoCollection1OrphanCheckIcmsestado + " in its icmsestadoCollection1 field has a non-nullable uf1 field.");
            }
            Collection<Mdfeletronico> mdfeletronicoCollectionOrphanCheck = uf.getMdfeletronicoCollection();
            for (Mdfeletronico mdfeletronicoCollectionOrphanCheckMdfeletronico : mdfeletronicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Mdfeletronico " + mdfeletronicoCollectionOrphanCheckMdfeletronico + " in its mdfeletronicoCollection field has a non-nullable coduffim field.");
            }
            Collection<Mdfeletronico> mdfeletronicoCollection1OrphanCheck = uf.getMdfeletronicoCollection1();
            for (Mdfeletronico mdfeletronicoCollection1OrphanCheckMdfeletronico : mdfeletronicoCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Uf (" + uf + ") cannot be destroyed since the Mdfeletronico " + mdfeletronicoCollection1OrphanCheckMdfeletronico + " in its mdfeletronicoCollection1 field has a non-nullable codufinicio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cidade> cidadeCollection = uf.getCidadeCollection();
            for (Cidade cidadeCollectionCidade : cidadeCollection) {
                cidadeCollectionCidade.setCoduf(null);
                cidadeCollectionCidade = em.merge(cidadeCollectionCidade);
            }
            Collection<Veiculos> veiculosCollection = uf.getVeiculosCollection();
            for (Veiculos veiculosCollectionVeiculos : veiculosCollection) {
                veiculosCollectionVeiculos.setCoduf(null);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
            }
            Collection<Pessoa> pessoaCollection = uf.getPessoaCollection();
            for (Pessoa pessoaCollectionPessoa : pessoaCollection) {
                pessoaCollectionPessoa.setCoduf(null);
                pessoaCollectionPessoa = em.merge(pessoaCollectionPessoa);
            }
            em.remove(uf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Uf> findUfEntities() {
        return findUfEntities(true, -1, -1);
    }

    public List<Uf> findUfEntities(int maxResults, int firstResult) {
        return findUfEntities(false, maxResults, firstResult);
    }

    private List<Uf> findUfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Uf.class));
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

    public Uf findUf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Uf.class, id);
        } finally {
            em.close();
        }
    }

    public int getUfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Uf> rt = cq.from(Uf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
