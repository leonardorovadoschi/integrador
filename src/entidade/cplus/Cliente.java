/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CLIENTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodcli", query = "SELECT c FROM Cliente c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cliente.findByNomecli", query = "SELECT c FROM Cliente c WHERE c.nomecli = :nomecli")
    , @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco")
    , @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro")
    , @NamedQuery(name = "Cliente.findByCidade", query = "SELECT c FROM Cliente c WHERE c.cidade = :cidade")
    , @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cliente.findByCep", query = "SELECT c FROM Cliente c WHERE c.cep = :cep")
    , @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Cliente.findByFax", query = "SELECT c FROM Cliente c WHERE c.fax = :fax")
    , @NamedQuery(name = "Cliente.findByRefban", query = "SELECT c FROM Cliente c WHERE c.refban = :refban")
    , @NamedQuery(name = "Cliente.findByCnpj", query = "SELECT c FROM Cliente c WHERE c.cnpj = :cnpj")
    , @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cliente.findByLimitecred", query = "SELECT c FROM Cliente c WHERE c.limitecred = :limitecred")
    , @NamedQuery(name = "Cliente.findByContato", query = "SELECT c FROM Cliente c WHERE c.contato = :contato")
    , @NamedQuery(name = "Cliente.findByInscr", query = "SELECT c FROM Cliente c WHERE c.inscr = :inscr")
    , @NamedQuery(name = "Cliente.findByAtividade", query = "SELECT c FROM Cliente c WHERE c.atividade = :atividade")
    , @NamedQuery(name = "Cliente.findByRefcom", query = "SELECT c FROM Cliente c WHERE c.refcom = :refcom")
    , @NamedQuery(name = "Cliente.findByFlagfisica", query = "SELECT c FROM Cliente c WHERE c.flagfisica = :flagfisica")
    , @NamedQuery(name = "Cliente.findByIdentidade", query = "SELECT c FROM Cliente c WHERE c.identidade = :identidade")
    , @NamedQuery(name = "Cliente.findByDatnasc", query = "SELECT c FROM Cliente c WHERE c.datnasc = :datnasc")
    , @NamedQuery(name = "Cliente.findByFiliacao", query = "SELECT c FROM Cliente c WHERE c.filiacao = :filiacao")
    , @NamedQuery(name = "Cliente.findByProfissao", query = "SELECT c FROM Cliente c WHERE c.profissao = :profissao")
    , @NamedQuery(name = "Cliente.findByDatcad", query = "SELECT c FROM Cliente c WHERE c.datcad = :datcad")
    , @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")
    , @NamedQuery(name = "Cliente.findByNumcar", query = "SELECT c FROM Cliente c WHERE c.numcar = :numcar")
    , @NamedQuery(name = "Cliente.findByValidade", query = "SELECT c FROM Cliente c WHERE c.validade = :validade")
    , @NamedQuery(name = "Cliente.findByNomecar", query = "SELECT c FROM Cliente c WHERE c.nomecar = :nomecar")
    , @NamedQuery(name = "Cliente.findByFlagnaovender", query = "SELECT c FROM Cliente c WHERE c.flagnaovender = :flagnaovender")
    , @NamedQuery(name = "Cliente.findByWeb", query = "SELECT c FROM Cliente c WHERE c.web = :web")
    , @NamedQuery(name = "Cliente.findByNaturalidade", query = "SELECT c FROM Cliente c WHERE c.naturalidade = :naturalidade")
    , @NamedQuery(name = "Cliente.findByConjfantasia", query = "SELECT c FROM Cliente c WHERE c.conjfantasia = :conjfantasia")
    , @NamedQuery(name = "Cliente.findByInscrmun", query = "SELECT c FROM Cliente c WHERE c.inscrmun = :inscrmun")
    , @NamedQuery(name = "Cliente.findByDatemissao", query = "SELECT c FROM Cliente c WHERE c.datemissao = :datemissao")
    , @NamedQuery(name = "Cliente.findByEstadocivil", query = "SELECT c FROM Cliente c WHERE c.estadocivil = :estadocivil")
    , @NamedQuery(name = "Cliente.findBySexo", query = "SELECT c FROM Cliente c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Cliente.findByLastChange", query = "SELECT c FROM Cliente c WHERE c.lastChange = :lastChange")
    , @NamedQuery(name = "Cliente.findBySenha", query = "SELECT c FROM Cliente c WHERE c.senha = :senha")
    , @NamedQuery(name = "Cliente.findByUltimaversao", query = "SELECT c FROM Cliente c WHERE c.ultimaversao = :ultimaversao")
    , @NamedQuery(name = "Cliente.findByDiavencimento", query = "SELECT c FROM Cliente c WHERE c.diavencimento = :diavencimento")
    , @NamedQuery(name = "Cliente.findByBloqueado", query = "SELECT c FROM Cliente c WHERE c.bloqueado = :bloqueado")
    , @NamedQuery(name = "Cliente.findByMotivobloqueio", query = "SELECT c FROM Cliente c WHERE c.motivobloqueio = :motivobloqueio")
    , @NamedQuery(name = "Cliente.findByLogin", query = "SELECT c FROM Cliente c WHERE c.login = :login")
    , @NamedQuery(name = "Cliente.findByRenda", query = "SELECT c FROM Cliente c WHERE c.renda = :renda")
    , @NamedQuery(name = "Cliente.findByFlaglojavirtual", query = "SELECT c FROM Cliente c WHERE c.flaglojavirtual = :flaglojavirtual")
    , @NamedQuery(name = "Cliente.findByLiberalojavirtual", query = "SELECT c FROM Cliente c WHERE c.liberalojavirtual = :liberalojavirtual")
    , @NamedQuery(name = "Cliente.findByLiberaprecoslojavirtual", query = "SELECT c FROM Cliente c WHERE c.liberaprecoslojavirtual = :liberaprecoslojavirtual")
    , @NamedQuery(name = "Cliente.findByDiaaniversario", query = "SELECT c FROM Cliente c WHERE c.diaaniversario = :diaaniversario")
    , @NamedQuery(name = "Cliente.findBySuframa", query = "SELECT c FROM Cliente c WHERE c.suframa = :suframa")
    , @NamedQuery(name = "Cliente.findByFlagfrete", query = "SELECT c FROM Cliente c WHERE c.flagfrete = :flagfrete")
    , @NamedQuery(name = "Cliente.findByFlagusaaliqicmsdiferenciada", query = "SELECT c FROM Cliente c WHERE c.flagusaaliqicmsdiferenciada = :flagusaaliqicmsdiferenciada")
    , @NamedQuery(name = "Cliente.findByCodcontabancaria", query = "SELECT c FROM Cliente c WHERE c.codcontabancaria = :codcontabancaria")
    , @NamedQuery(name = "Cliente.findByNumerologradouro", query = "SELECT c FROM Cliente c WHERE c.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Cliente.findByComplementologradouro", query = "SELECT c FROM Cliente c WHERE c.complementologradouro = :complementologradouro")
    , @NamedQuery(name = "Cliente.findByCodigointegracaofiscal", query = "SELECT c FROM Cliente c WHERE c.codigointegracaofiscal = :codigointegracaofiscal")
    , @NamedQuery(name = "Cliente.findByFlagrevenda", query = "SELECT c FROM Cliente c WHERE c.flagrevenda = :flagrevenda")
    , @NamedQuery(name = "Cliente.findByAliqcomissaorevenda", query = "SELECT c FROM Cliente c WHERE c.aliqcomissaorevenda = :aliqcomissaorevenda")
    , @NamedQuery(name = "Cliente.findByCodclilojavirtual", query = "SELECT c FROM Cliente c WHERE c.codclilojavirtual = :codclilojavirtual")
    , @NamedQuery(name = "Cliente.findByGuid", query = "SELECT c FROM Cliente c WHERE c.guid = :guid")
    , @NamedQuery(name = "Cliente.findByEmaildanfe", query = "SELECT c FROM Cliente c WHERE c.emaildanfe = :emaildanfe")
    , @NamedQuery(name = "Cliente.findByFlagmercado", query = "SELECT c FROM Cliente c WHERE c.flagmercado = :flagmercado")
    , @NamedQuery(name = "Cliente.findByCei", query = "SELECT c FROM Cliente c WHERE c.cei = :cei")
    , @NamedQuery(name = "Cliente.findByNit", query = "SELECT c FROM Cliente c WHERE c.nit = :nit")
    , @NamedQuery(name = "Cliente.findByBloqtablet", query = "SELECT c FROM Cliente c WHERE c.bloqtablet = :bloqtablet")
    , @NamedQuery(name = "Cliente.findByValorfidelizacao", query = "SELECT c FROM Cliente c WHERE c.valorfidelizacao = :valorfidelizacao")
    , @NamedQuery(name = "Cliente.findByCodclifidelizacao", query = "SELECT c FROM Cliente c WHERE c.codclifidelizacao = :codclifidelizacao")
    , @NamedQuery(name = "Cliente.findByAliqfidelizacao", query = "SELECT c FROM Cliente c WHERE c.aliqfidelizacao = :aliqfidelizacao")
    , @NamedQuery(name = "Cliente.findByIndiedest", query = "SELECT c FROM Cliente c WHERE c.indiedest = :indiedest")
    , @NamedQuery(name = "Cliente.findByFlagrevendamaster", query = "SELECT c FROM Cliente c WHERE c.flagrevendamaster = :flagrevendamaster")
    , @NamedQuery(name = "Cliente.findByMensagemcrm", query = "SELECT c FROM Cliente c WHERE c.mensagemcrm = :mensagemcrm")
    , @NamedQuery(name = "Cliente.findByFlagtransfer", query = "SELECT c FROM Cliente c WHERE c.flagtransfer = :flagtransfer")
    , @NamedQuery(name = "Cliente.findByFlagsimplesnacional", query = "SELECT c FROM Cliente c WHERE c.flagsimplesnacional = :flagsimplesnacional")
    , @NamedQuery(name = "Cliente.findByReferencia", query = "SELECT c FROM Cliente c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "Cliente.findByHorariofuncini", query = "SELECT c FROM Cliente c WHERE c.horariofuncini = :horariofuncini")
    , @NamedQuery(name = "Cliente.findByHorariofuncintervaloini", query = "SELECT c FROM Cliente c WHERE c.horariofuncintervaloini = :horariofuncintervaloini")
    , @NamedQuery(name = "Cliente.findByHorariofuncintervalofin", query = "SELECT c FROM Cliente c WHERE c.horariofuncintervalofin = :horariofuncintervalofin")
    , @NamedQuery(name = "Cliente.findByHorariofuncfin", query = "SELECT c FROM Cliente c WHERE c.horariofuncfin = :horariofuncfin")
    , @NamedQuery(name = "Cliente.findByFlagusaeannfe", query = "SELECT c FROM Cliente c WHERE c.flagusaeannfe = :flagusaeannfe")
    , @NamedQuery(name = "Cliente.findByDatnascconjuge", query = "SELECT c FROM Cliente c WHERE c.datnascconjuge = :datnascconjuge")
    , @NamedQuery(name = "Cliente.findByDatcasamento", query = "SELECT c FROM Cliente c WHERE c.datcasamento = :datcasamento")})
public class Cliente implements Serializable {

    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLI")
    private String codcli;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMECLI")
    private String nomecli;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "REFBAN")
    private String refban;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "CPF")
    private String cpf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LIMITECRED")
    private BigDecimal limitecred;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "INSCR")
    private String inscr;
    @Column(name = "ATIVIDADE")
    private String atividade;
    @Column(name = "REFCOM")
    private String refcom;
    @Column(name = "FLAGFISICA")
    private Character flagfisica;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "DATNASC")
    @Temporal(TemporalType.DATE)
    private Date datnasc;
    @Column(name = "FILIACAO")
    private String filiacao;
    @Column(name = "PROFISSAO")
    private String profissao;
    @Column(name = "DATCAD")
    @Temporal(TemporalType.DATE)
    private Date datcad;
    @Column(name = "EMAIL")
    private String email;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "NUMCAR")
    private String numcar;
    @Column(name = "VALIDADE")
    private String validade;
    @Column(name = "NOMECAR")
    private String nomecar;
    @Column(name = "FLAGNAOVENDER")
    private Character flagnaovender;
    @Column(name = "WEB")
    private String web;
    @Column(name = "NATURALIDADE")
    private String naturalidade;
    @Column(name = "CONJFANTASIA")
    private String conjfantasia;
    @Column(name = "INSCRMUN")
    private String inscrmun;
    @Column(name = "DATEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date datemissao;
    @Column(name = "ESTADOCIVIL")
    private Character estadocivil;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "ULTIMAVERSAO")
    private String ultimaversao;
    @Column(name = "DIAVENCIMENTO")
    private Integer diavencimento;
    @Column(name = "BLOQUEADO")
    private Character bloqueado;
    @Column(name = "MOTIVOBLOQUEIO")
    private String motivobloqueio;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "RENDA")
    private BigDecimal renda;
    @Column(name = "FLAGLOJAVIRTUAL")
    private Character flaglojavirtual;
    @Column(name = "LIBERALOJAVIRTUAL")
    private Character liberalojavirtual;
    @Column(name = "LIBERAPRECOSLOJAVIRTUAL")
    private Character liberaprecoslojavirtual;
    @Column(name = "DIAANIVERSARIO")
    private String diaaniversario;
    @Column(name = "SUFRAMA")
    private String suframa;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "FLAGUSAALIQICMSDIFERENCIADA")
    private Character flagusaaliqicmsdiferenciada;
    @Column(name = "CODCONTABANCARIA")
    private String codcontabancaria;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @Column(name = "CODIGOINTEGRACAOFISCAL")
    private String codigointegracaofiscal;
    @Column(name = "FLAGREVENDA")
    private Character flagrevenda;
    @Column(name = "ALIQCOMISSAOREVENDA")
    private BigDecimal aliqcomissaorevenda;
    @Column(name = "CODCLILOJAVIRTUAL")
    private String codclilojavirtual;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "EMAILDANFE")
    private String emaildanfe;
    @Column(name = "FLAGMERCADO")
    private Character flagmercado;
    @Column(name = "CEI")
    private String cei;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "BLOQTABLET")
    private Character bloqtablet;
    @Column(name = "VALORFIDELIZACAO")
    private BigDecimal valorfidelizacao;
    @Column(name = "CODCLIFIDELIZACAO")
    private String codclifidelizacao;
    @Column(name = "ALIQFIDELIZACAO")
    private BigDecimal aliqfidelizacao;
    @Lob
    @Column(name = "EMAILCCDANFE")
    private String emailccdanfe;
    @Column(name = "INDIEDEST")
    private Character indiedest;
    @Column(name = "FLAGREVENDAMASTER")
    private Character flagrevendamaster;
    @Column(name = "MENSAGEMCRM")
    private String mensagemcrm;
    @Column(name = "FLAGTRANSFER")
    private Character flagtransfer;
    @Column(name = "FLAGSIMPLESNACIONAL")
    private Character flagsimplesnacional;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "HORARIOFUNCINI")
    @Temporal(TemporalType.TIME)
    private Date horariofuncini;
    @Column(name = "HORARIOFUNCINTERVALOINI")
    @Temporal(TemporalType.TIME)
    private Date horariofuncintervaloini;
    @Column(name = "HORARIOFUNCINTERVALOFIN")
    @Temporal(TemporalType.TIME)
    private Date horariofuncintervalofin;
    @Column(name = "HORARIOFUNCFIN")
    @Temporal(TemporalType.TIME)
    private Date horariofuncfin;
    @Column(name = "FLAGUSAEANNFE")
    private Character flagusaeannfe;
    @Column(name = "DATNASCCONJUGE")
    @Temporal(TemporalType.DATE)
    private Date datnascconjuge;
    @Column(name = "DATCASAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datcasamento;
    @OneToMany(mappedBy = "codcli")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Caixa> caixaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Email> emailCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Lancafinanceira> lancafinanceiraCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codclirevenda")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Atendimento> atendimentoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Clientecaracteristica> clientecaracteristicaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Clienteendereco> clienteenderecoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Contareceberfixa> contareceberfixaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Vale> valeCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Rma> rmaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<OsEquipamento> osEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcli")
    private Collection<Clienteequipamento> clienteequipamentoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codclivenda")
    private Collection<Contareceber> contareceberCollection1;
    @OneToMany(mappedBy = "codcli")
    private Collection<Lancacartao> lancacartaoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Clienteabc clienteabc;
    @OneToMany(mappedBy = "codcli")
    private Collection<Movecfdocumento> movecfdocumentoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Contratocobranca> contratocobrancaCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<OsOrdemservico> osOrdemservicoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codcli")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codclirevenda")
    private Collection<Movenda> movendaCollection1;
    @OneToMany(mappedBy = "codcli")
    private Collection<Contatoscli> contatoscliCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcli")
    private Collection<Clienteproduto> clienteprodutoCollection;
    @OneToMany(mappedBy = "codcliassociado")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "CODCLIASSOCIADO", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcliassociado;
    @OneToMany(mappedBy = "codclirevenda")
    private Collection<Cliente> clienteCollection1;
    @JoinColumn(name = "CODCLIREVENDA", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclirevenda;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(mappedBy = "codclirevendamaster")
    private Collection<Cliente> clienteCollection2;
    @JoinColumn(name = "CODCLIREVENDAMASTER", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclirevendamaster;
    @OneToMany(mappedBy = "codclifaturamento")
    private Collection<Cliente> clienteCollection3;
    @JoinColumn(name = "CODCLIFATURAMENTO", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclifaturamento;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @JoinColumn(name = "CODVENDEDEXT", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedext;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODCAR", referencedColumnName = "CODCAR")
    @ManyToOne
    private Tipocartao codcar;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne
    private Usuario coduser;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;

    public Cliente() {
    }

    public Cliente(String codcli) {
        this.codcli = codcli;
    }

    public Cliente(String codcli, String codigo, String nomecli) {
        this.codcli = codcli;
        this.codigo = codigo;
        this.nomecli = nomecli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRefban() {
        return refban;
    }

    public void setRefban(String refban) {
        this.refban = refban;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getLimitecred() {
        return limitecred;
    }

    public void setLimitecred(BigDecimal limitecred) {
        this.limitecred = limitecred;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getInscr() {
        return inscr;
    }

    public void setInscr(String inscr) {
        this.inscr = inscr;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getRefcom() {
        return refcom;
    }

    public void setRefcom(String refcom) {
        this.refcom = refcom;
    }

    public Character getFlagfisica() {
        return flagfisica;
    }

    public void setFlagfisica(Character flagfisica) {
        this.flagfisica = flagfisica;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Date getDatnasc() {
        return datnasc;
    }

    public void setDatnasc(Date datnasc) {
        this.datnasc = datnasc;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Date getDatcad() {
        return datcad;
    }

    public void setDatcad(Date datcad) {
        this.datcad = datcad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNumcar() {
        return numcar;
    }

    public void setNumcar(String numcar) {
        this.numcar = numcar;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getNomecar() {
        return nomecar;
    }

    public void setNomecar(String nomecar) {
        this.nomecar = nomecar;
    }

    public Character getFlagnaovender() {
        return flagnaovender;
    }

    public void setFlagnaovender(Character flagnaovender) {
        this.flagnaovender = flagnaovender;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getConjfantasia() {
        return conjfantasia;
    }

    public void setConjfantasia(String conjfantasia) {
        this.conjfantasia = conjfantasia;
    }

    public String getInscrmun() {
        return inscrmun;
    }

    public void setInscrmun(String inscrmun) {
        this.inscrmun = inscrmun;
    }

    public Date getDatemissao() {
        return datemissao;
    }

    public void setDatemissao(Date datemissao) {
        this.datemissao = datemissao;
    }

    public Character getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Character estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUltimaversao() {
        return ultimaversao;
    }

    public void setUltimaversao(String ultimaversao) {
        this.ultimaversao = ultimaversao;
    }

    public Integer getDiavencimento() {
        return diavencimento;
    }

    public void setDiavencimento(Integer diavencimento) {
        this.diavencimento = diavencimento;
    }

    public Character getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Character bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getMotivobloqueio() {
        return motivobloqueio;
    }

    public void setMotivobloqueio(String motivobloqueio) {
        this.motivobloqueio = motivobloqueio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Character getFlaglojavirtual() {
        return flaglojavirtual;
    }

    public void setFlaglojavirtual(Character flaglojavirtual) {
        this.flaglojavirtual = flaglojavirtual;
    }

    public Character getLiberalojavirtual() {
        return liberalojavirtual;
    }

    public void setLiberalojavirtual(Character liberalojavirtual) {
        this.liberalojavirtual = liberalojavirtual;
    }

    public Character getLiberaprecoslojavirtual() {
        return liberaprecoslojavirtual;
    }

    public void setLiberaprecoslojavirtual(Character liberaprecoslojavirtual) {
        this.liberaprecoslojavirtual = liberaprecoslojavirtual;
    }

    public String getDiaaniversario() {
        return diaaniversario;
    }

    public void setDiaaniversario(String diaaniversario) {
        this.diaaniversario = diaaniversario;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public Character getFlagusaaliqicmsdiferenciada() {
        return flagusaaliqicmsdiferenciada;
    }

    public void setFlagusaaliqicmsdiferenciada(Character flagusaaliqicmsdiferenciada) {
        this.flagusaaliqicmsdiferenciada = flagusaaliqicmsdiferenciada;
    }

    public String getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public String getNumerologradouro() {
        return numerologradouro;
    }

    public void setNumerologradouro(String numerologradouro) {
        this.numerologradouro = numerologradouro;
    }

    public String getComplementologradouro() {
        return complementologradouro;
    }

    public void setComplementologradouro(String complementologradouro) {
        this.complementologradouro = complementologradouro;
    }

    public String getCodigointegracaofiscal() {
        return codigointegracaofiscal;
    }

    public void setCodigointegracaofiscal(String codigointegracaofiscal) {
        this.codigointegracaofiscal = codigointegracaofiscal;
    }

    public Character getFlagrevenda() {
        return flagrevenda;
    }

    public void setFlagrevenda(Character flagrevenda) {
        this.flagrevenda = flagrevenda;
    }

    public BigDecimal getAliqcomissaorevenda() {
        return aliqcomissaorevenda;
    }

    public void setAliqcomissaorevenda(BigDecimal aliqcomissaorevenda) {
        this.aliqcomissaorevenda = aliqcomissaorevenda;
    }

    public String getCodclilojavirtual() {
        return codclilojavirtual;
    }

    public void setCodclilojavirtual(String codclilojavirtual) {
        this.codclilojavirtual = codclilojavirtual;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEmaildanfe() {
        return emaildanfe;
    }

    public void setEmaildanfe(String emaildanfe) {
        this.emaildanfe = emaildanfe;
    }

    public Character getFlagmercado() {
        return flagmercado;
    }

    public void setFlagmercado(Character flagmercado) {
        this.flagmercado = flagmercado;
    }

    public String getCei() {
        return cei;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Character getBloqtablet() {
        return bloqtablet;
    }

    public void setBloqtablet(Character bloqtablet) {
        this.bloqtablet = bloqtablet;
    }

    public BigDecimal getValorfidelizacao() {
        return valorfidelizacao;
    }

    public void setValorfidelizacao(BigDecimal valorfidelizacao) {
        this.valorfidelizacao = valorfidelizacao;
    }

    public String getCodclifidelizacao() {
        return codclifidelizacao;
    }

    public void setCodclifidelizacao(String codclifidelizacao) {
        this.codclifidelizacao = codclifidelizacao;
    }

    public BigDecimal getAliqfidelizacao() {
        return aliqfidelizacao;
    }

    public void setAliqfidelizacao(BigDecimal aliqfidelizacao) {
        this.aliqfidelizacao = aliqfidelizacao;
    }

    public String getEmailccdanfe() {
        return emailccdanfe;
    }

    public void setEmailccdanfe(String emailccdanfe) {
        this.emailccdanfe = emailccdanfe;
    }

    public Character getIndiedest() {
        return indiedest;
    }

    public void setIndiedest(Character indiedest) {
        this.indiedest = indiedest;
    }

    public Character getFlagrevendamaster() {
        return flagrevendamaster;
    }

    public void setFlagrevendamaster(Character flagrevendamaster) {
        this.flagrevendamaster = flagrevendamaster;
    }

    public String getMensagemcrm() {
        return mensagemcrm;
    }

    public void setMensagemcrm(String mensagemcrm) {
        this.mensagemcrm = mensagemcrm;
    }

    public Character getFlagtransfer() {
        return flagtransfer;
    }

    public void setFlagtransfer(Character flagtransfer) {
        this.flagtransfer = flagtransfer;
    }

    public Character getFlagsimplesnacional() {
        return flagsimplesnacional;
    }

    public void setFlagsimplesnacional(Character flagsimplesnacional) {
        this.flagsimplesnacional = flagsimplesnacional;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getHorariofuncini() {
        return horariofuncini;
    }

    public void setHorariofuncini(Date horariofuncini) {
        this.horariofuncini = horariofuncini;
    }

    public Date getHorariofuncintervaloini() {
        return horariofuncintervaloini;
    }

    public void setHorariofuncintervaloini(Date horariofuncintervaloini) {
        this.horariofuncintervaloini = horariofuncintervaloini;
    }

    public Date getHorariofuncintervalofin() {
        return horariofuncintervalofin;
    }

    public void setHorariofuncintervalofin(Date horariofuncintervalofin) {
        this.horariofuncintervalofin = horariofuncintervalofin;
    }

    public Date getHorariofuncfin() {
        return horariofuncfin;
    }

    public void setHorariofuncfin(Date horariofuncfin) {
        this.horariofuncfin = horariofuncfin;
    }

    public Character getFlagusaeannfe() {
        return flagusaeannfe;
    }

    public void setFlagusaeannfe(Character flagusaeannfe) {
        this.flagusaeannfe = flagusaeannfe;
    }

    public Date getDatnascconjuge() {
        return datnascconjuge;
    }

    public void setDatnascconjuge(Date datnascconjuge) {
        this.datnascconjuge = datnascconjuge;
    }

    public Date getDatcasamento() {
        return datcasamento;
    }

    public void setDatcasamento(Date datcasamento) {
        this.datcasamento = datcasamento;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    @XmlTransient
    public Collection<Lancafinanceira> getLancafinanceiraCollection() {
        return lancafinanceiraCollection;
    }

    public void setLancafinanceiraCollection(Collection<Lancafinanceira> lancafinanceiraCollection) {
        this.lancafinanceiraCollection = lancafinanceiraCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    @XmlTransient
    public Collection<Clientecaracteristica> getClientecaracteristicaCollection() {
        return clientecaracteristicaCollection;
    }

    public void setClientecaracteristicaCollection(Collection<Clientecaracteristica> clientecaracteristicaCollection) {
        this.clientecaracteristicaCollection = clientecaracteristicaCollection;
    }

    @XmlTransient
    public Collection<Clienteendereco> getClienteenderecoCollection() {
        return clienteenderecoCollection;
    }

    public void setClienteenderecoCollection(Collection<Clienteendereco> clienteenderecoCollection) {
        this.clienteenderecoCollection = clienteenderecoCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Contareceberfixa> getContareceberfixaCollection() {
        return contareceberfixaCollection;
    }

    public void setContareceberfixaCollection(Collection<Contareceberfixa> contareceberfixaCollection) {
        this.contareceberfixaCollection = contareceberfixaCollection;
    }

    @XmlTransient
    public Collection<Vale> getValeCollection() {
        return valeCollection;
    }

    public void setValeCollection(Collection<Vale> valeCollection) {
        this.valeCollection = valeCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<OsEquipamento> getOsEquipamentoCollection() {
        return osEquipamentoCollection;
    }

    public void setOsEquipamentoCollection(Collection<OsEquipamento> osEquipamentoCollection) {
        this.osEquipamentoCollection = osEquipamentoCollection;
    }

    @XmlTransient
    public Collection<Clienteequipamento> getClienteequipamentoCollection() {
        return clienteequipamentoCollection;
    }

    public void setClienteequipamentoCollection(Collection<Clienteequipamento> clienteequipamentoCollection) {
        this.clienteequipamentoCollection = clienteequipamentoCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection1() {
        return contareceberCollection1;
    }

    public void setContareceberCollection1(Collection<Contareceber> contareceberCollection1) {
        this.contareceberCollection1 = contareceberCollection1;
    }

    @XmlTransient
    public Collection<Lancacartao> getLancacartaoCollection() {
        return lancacartaoCollection;
    }

    public void setLancacartaoCollection(Collection<Lancacartao> lancacartaoCollection) {
        this.lancacartaoCollection = lancacartaoCollection;
    }

    public Clienteabc getClienteabc() {
        return clienteabc;
    }

    public void setClienteabc(Clienteabc clienteabc) {
        this.clienteabc = clienteabc;
    }

    @XmlTransient
    public Collection<Movecfdocumento> getMovecfdocumentoCollection() {
        return movecfdocumentoCollection;
    }

    public void setMovecfdocumentoCollection(Collection<Movecfdocumento> movecfdocumentoCollection) {
        this.movecfdocumentoCollection = movecfdocumentoCollection;
    }

    @XmlTransient
    public Collection<Contratocobranca> getContratocobrancaCollection() {
        return contratocobrancaCollection;
    }

    public void setContratocobrancaCollection(Collection<Contratocobranca> contratocobrancaCollection) {
        this.contratocobrancaCollection = contratocobrancaCollection;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection1() {
        return movendaCollection1;
    }

    public void setMovendaCollection1(Collection<Movenda> movendaCollection1) {
        this.movendaCollection1 = movendaCollection1;
    }

    @XmlTransient
    public Collection<Contatoscli> getContatoscliCollection() {
        return contatoscliCollection;
    }

    public void setContatoscliCollection(Collection<Contatoscli> contatoscliCollection) {
        this.contatoscliCollection = contatoscliCollection;
    }

    @XmlTransient
    public Collection<Clienteproduto> getClienteprodutoCollection() {
        return clienteprodutoCollection;
    }

    public void setClienteprodutoCollection(Collection<Clienteproduto> clienteprodutoCollection) {
        this.clienteprodutoCollection = clienteprodutoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Cliente getCodcliassociado() {
        return codcliassociado;
    }

    public void setCodcliassociado(Cliente codcliassociado) {
        this.codcliassociado = codcliassociado;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection1() {
        return clienteCollection1;
    }

    public void setClienteCollection1(Collection<Cliente> clienteCollection1) {
        this.clienteCollection1 = clienteCollection1;
    }

    public Cliente getCodclirevenda() {
        return codclirevenda;
    }

    public void setCodclirevenda(Cliente codclirevenda) {
        this.codclirevenda = codclirevenda;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection2() {
        return clienteCollection2;
    }

    public void setClienteCollection2(Collection<Cliente> clienteCollection2) {
        this.clienteCollection2 = clienteCollection2;
    }

    public Cliente getCodclirevendamaster() {
        return codclirevendamaster;
    }

    public void setCodclirevendamaster(Cliente codclirevendamaster) {
        this.codclirevendamaster = codclirevendamaster;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection3() {
        return clienteCollection3;
    }

    public void setClienteCollection3(Collection<Cliente> clienteCollection3) {
        this.clienteCollection3 = clienteCollection3;
    }

    public Cliente getCodclifaturamento() {
        return codclifaturamento;
    }

    public void setCodclifaturamento(Cliente codclifaturamento) {
        this.codclifaturamento = codclifaturamento;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    public Vendedor getCodvendedext() {
        return codvendedext;
    }

    public void setCodvendedext(Vendedor codvendedext) {
        this.codvendedext = codvendedext;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Tipocartao getCodcar() {
        return codcar;
    }

    public void setCodcar(Tipocartao codcar) {
        this.codcar = codcar;
    }

    public Tipomovimento getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(Tipomovimento codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcli != null ? codcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codcli == null && other.codcli != null) || (this.codcli != null && !this.codcli.equals(other.codcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cliente[ codcli=" + codcli + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
