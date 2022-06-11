/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ATENDIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atendimento.findAll", query = "SELECT a FROM Atendimento a")
    , @NamedQuery(name = "Atendimento.findByCodatend", query = "SELECT a FROM Atendimento a WHERE a.codatend = :codatend")
    , @NamedQuery(name = "Atendimento.findByDatatend", query = "SELECT a FROM Atendimento a WHERE a.datatend = :datatend")
    , @NamedQuery(name = "Atendimento.findByHoratend", query = "SELECT a FROM Atendimento a WHERE a.horatend = :horatend")
    , @NamedQuery(name = "Atendimento.findByCoduser", query = "SELECT a FROM Atendimento a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Atendimento.findByCoduserinicial", query = "SELECT a FROM Atendimento a WHERE a.coduserinicial = :coduserinicial")
    , @NamedQuery(name = "Atendimento.findByCoduserinterno", query = "SELECT a FROM Atendimento a WHERE a.coduserinterno = :coduserinterno")
    , @NamedQuery(name = "Atendimento.findByCodcolor", query = "SELECT a FROM Atendimento a WHERE a.codcolor = :codcolor")
    , @NamedQuery(name = "Atendimento.findByNome", query = "SELECT a FROM Atendimento a WHERE a.nome = :nome")
    , @NamedQuery(name = "Atendimento.findByTelefone", query = "SELECT a FROM Atendimento a WHERE a.telefone = :telefone")
    , @NamedQuery(name = "Atendimento.findByEmail", query = "SELECT a FROM Atendimento a WHERE a.email = :email")
    , @NamedQuery(name = "Atendimento.findByDuracao", query = "SELECT a FROM Atendimento a WHERE a.duracao = :duracao")
    , @NamedQuery(name = "Atendimento.findByPendente", query = "SELECT a FROM Atendimento a WHERE a.pendente = :pendente")
    , @NamedQuery(name = "Atendimento.findByDataentradacr", query = "SELECT a FROM Atendimento a WHERE a.dataentradacr = :dataentradacr")
    , @NamedQuery(name = "Atendimento.findByDataproximoatendimento", query = "SELECT a FROM Atendimento a WHERE a.dataproximoatendimento = :dataproximoatendimento")
    , @NamedQuery(name = "Atendimento.findByDatacontatointerno", query = "SELECT a FROM Atendimento a WHERE a.datacontatointerno = :datacontatointerno")
    , @NamedQuery(name = "Atendimento.findByDataultimaatualizacao", query = "SELECT a FROM Atendimento a WHERE a.dataultimaatualizacao = :dataultimaatualizacao")
    , @NamedQuery(name = "Atendimento.findByDataencerramento", query = "SELECT a FROM Atendimento a WHERE a.dataencerramento = :dataencerramento")
    , @NamedQuery(name = "Atendimento.findByDataentrega", query = "SELECT a FROM Atendimento a WHERE a.dataentrega = :dataentrega")
    , @NamedQuery(name = "Atendimento.findByFlagbloqueiaencerramento", query = "SELECT a FROM Atendimento a WHERE a.flagbloqueiaencerramento = :flagbloqueiaencerramento")
    , @NamedQuery(name = "Atendimento.findByNumversao", query = "SELECT a FROM Atendimento a WHERE a.numversao = :numversao")
    , @NamedQuery(name = "Atendimento.findByNumeroligacoesatendidas", query = "SELECT a FROM Atendimento a WHERE a.numeroligacoesatendidas = :numeroligacoesatendidas")
    , @NamedQuery(name = "Atendimento.findByDataultimaligacaoatendida", query = "SELECT a FROM Atendimento a WHERE a.dataultimaligacaoatendida = :dataultimaligacaoatendida")
    , @NamedQuery(name = "Atendimento.findByNumerocontatosefetuados", query = "SELECT a FROM Atendimento a WHERE a.numerocontatosefetuados = :numerocontatosefetuados")
    , @NamedQuery(name = "Atendimento.findByDataprevista", query = "SELECT a FROM Atendimento a WHERE a.dataprevista = :dataprevista")
    , @NamedQuery(name = "Atendimento.findByPrioridade", query = "SELECT a FROM Atendimento a WHERE a.prioridade = :prioridade")
    , @NamedQuery(name = "Atendimento.findByNumeroatendimento", query = "SELECT a FROM Atendimento a WHERE a.numeroatendimento = :numeroatendimento")
    , @NamedQuery(name = "Atendimento.findByCodprod", query = "SELECT a FROM Atendimento a WHERE a.codprod = :codprod")
    , @NamedQuery(name = "Atendimento.findByVotacao", query = "SELECT a FROM Atendimento a WHERE a.votacao = :votacao")
    , @NamedQuery(name = "Atendimento.findByGuid", query = "SELECT a FROM Atendimento a WHERE a.guid = :guid")
    , @NamedQuery(name = "Atendimento.findByFlagsomarelatorio", query = "SELECT a FROM Atendimento a WHERE a.flagsomarelatorio = :flagsomarelatorio")
    , @NamedQuery(name = "Atendimento.findByTitulo", query = "SELECT a FROM Atendimento a WHERE a.titulo = :titulo")
    , @NamedQuery(name = "Atendimento.findByFlaglido", query = "SELECT a FROM Atendimento a WHERE a.flaglido = :flaglido")})
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODATEND")
    private String codatend;
    @Column(name = "DATATEND")
    @Temporal(TemporalType.DATE)
    private Date datatend;
    @Column(name = "HORATEND")
    @Temporal(TemporalType.TIME)
    private Date horatend;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODUSERINICIAL")
    private String coduserinicial;
    @Column(name = "CODUSERINTERNO")
    private String coduserinterno;
    @Column(name = "CODCOLOR")
    private Integer codcolor;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "EMAIL")
    private String email;
    @Lob
    @Column(name = "ASSUNTO")
    private String assunto;
    @Column(name = "DURACAO")
    @Temporal(TemporalType.TIME)
    private Date duracao;
    @Column(name = "PENDENTE")
    private Character pendente;
    @Column(name = "DATAENTRADACR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataentradacr;
    @Column(name = "DATAPROXIMOATENDIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataproximoatendimento;
    @Column(name = "DATACONTATOINTERNO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacontatointerno;
    @Column(name = "DATAULTIMAATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimaatualizacao;
    @Column(name = "DATAENCERRAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataencerramento;
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataentrega;
    @Column(name = "FLAGBLOQUEIAENCERRAMENTO")
    private Character flagbloqueiaencerramento;
    @Column(name = "NUMVERSAO")
    private String numversao;
    @Column(name = "NUMEROLIGACOESATENDIDAS")
    private Integer numeroligacoesatendidas;
    @Column(name = "DATAULTIMALIGACAOATENDIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimaligacaoatendida;
    @Column(name = "NUMEROCONTATOSEFETUADOS")
    private Integer numerocontatosefetuados;
    @Column(name = "DATAPREVISTA")
    @Temporal(TemporalType.DATE)
    private Date dataprevista;
    @Column(name = "PRIORIDADE")
    private Integer prioridade;
    @Basic(optional = false)
    @Column(name = "NUMEROATENDIMENTO")
    private int numeroatendimento;
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "VOTACAO")
    private Integer votacao;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGSOMARELATORIO")
    private Character flagsomarelatorio;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "FLAGLIDO")
    private Character flaglido;
    @JoinColumn(name = "CODCENTRORESPONSABILIDADE", referencedColumnName = "CODCENTRORESPONSABILIDADE")
    @ManyToOne
    private Centroresponsabilidade codcentroresponsabilidade;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVENDAPRODSERIAL", referencedColumnName = "CODMOVENDAPRODSERIAL")
    @ManyToOne
    private Movendaprodserial codmovendaprodserial;
    @JoinColumn(name = "CODTIPOATEND", referencedColumnName = "CODTIPOATEND")
    @ManyToOne
    private Tipoatendimento codtipoatend;
    @OneToMany(mappedBy = "codatend")
    private Collection<Contareceber> contareceberCollection;

    public Atendimento() {
    }

    public Atendimento(String codatend) {
        this.codatend = codatend;
    }

    public Atendimento(String codatend, int numeroatendimento) {
        this.codatend = codatend;
        this.numeroatendimento = numeroatendimento;
    }

    public String getCodatend() {
        return codatend;
    }

    public void setCodatend(String codatend) {
        this.codatend = codatend;
    }

    public Date getDatatend() {
        return datatend;
    }

    public void setDatatend(Date datatend) {
        this.datatend = datatend;
    }

    public Date getHoratend() {
        return horatend;
    }

    public void setHoratend(Date horatend) {
        this.horatend = horatend;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCoduserinicial() {
        return coduserinicial;
    }

    public void setCoduserinicial(String coduserinicial) {
        this.coduserinicial = coduserinicial;
    }

    public String getCoduserinterno() {
        return coduserinterno;
    }

    public void setCoduserinterno(String coduserinterno) {
        this.coduserinterno = coduserinterno;
    }

    public Integer getCodcolor() {
        return codcolor;
    }

    public void setCodcolor(Integer codcolor) {
        this.codcolor = codcolor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public Character getPendente() {
        return pendente;
    }

    public void setPendente(Character pendente) {
        this.pendente = pendente;
    }

    public Date getDataentradacr() {
        return dataentradacr;
    }

    public void setDataentradacr(Date dataentradacr) {
        this.dataentradacr = dataentradacr;
    }

    public Date getDataproximoatendimento() {
        return dataproximoatendimento;
    }

    public void setDataproximoatendimento(Date dataproximoatendimento) {
        this.dataproximoatendimento = dataproximoatendimento;
    }

    public Date getDatacontatointerno() {
        return datacontatointerno;
    }

    public void setDatacontatointerno(Date datacontatointerno) {
        this.datacontatointerno = datacontatointerno;
    }

    public Date getDataultimaatualizacao() {
        return dataultimaatualizacao;
    }

    public void setDataultimaatualizacao(Date dataultimaatualizacao) {
        this.dataultimaatualizacao = dataultimaatualizacao;
    }

    public Date getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(Date dataencerramento) {
        this.dataencerramento = dataencerramento;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public Character getFlagbloqueiaencerramento() {
        return flagbloqueiaencerramento;
    }

    public void setFlagbloqueiaencerramento(Character flagbloqueiaencerramento) {
        this.flagbloqueiaencerramento = flagbloqueiaencerramento;
    }

    public String getNumversao() {
        return numversao;
    }

    public void setNumversao(String numversao) {
        this.numversao = numversao;
    }

    public Integer getNumeroligacoesatendidas() {
        return numeroligacoesatendidas;
    }

    public void setNumeroligacoesatendidas(Integer numeroligacoesatendidas) {
        this.numeroligacoesatendidas = numeroligacoesatendidas;
    }

    public Date getDataultimaligacaoatendida() {
        return dataultimaligacaoatendida;
    }

    public void setDataultimaligacaoatendida(Date dataultimaligacaoatendida) {
        this.dataultimaligacaoatendida = dataultimaligacaoatendida;
    }

    public Integer getNumerocontatosefetuados() {
        return numerocontatosefetuados;
    }

    public void setNumerocontatosefetuados(Integer numerocontatosefetuados) {
        this.numerocontatosefetuados = numerocontatosefetuados;
    }

    public Date getDataprevista() {
        return dataprevista;
    }

    public void setDataprevista(Date dataprevista) {
        this.dataprevista = dataprevista;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public int getNumeroatendimento() {
        return numeroatendimento;
    }

    public void setNumeroatendimento(int numeroatendimento) {
        this.numeroatendimento = numeroatendimento;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public Integer getVotacao() {
        return votacao;
    }

    public void setVotacao(Integer votacao) {
        this.votacao = votacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagsomarelatorio() {
        return flagsomarelatorio;
    }

    public void setFlagsomarelatorio(Character flagsomarelatorio) {
        this.flagsomarelatorio = flagsomarelatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Character getFlaglido() {
        return flaglido;
    }

    public void setFlaglido(Character flaglido) {
        this.flaglido = flaglido;
    }

    public Centroresponsabilidade getCodcentroresponsabilidade() {
        return codcentroresponsabilidade;
    }

    public void setCodcentroresponsabilidade(Centroresponsabilidade codcentroresponsabilidade) {
        this.codcentroresponsabilidade = codcentroresponsabilidade;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Movendaprodserial getCodmovendaprodserial() {
        return codmovendaprodserial;
    }

    public void setCodmovendaprodserial(Movendaprodserial codmovendaprodserial) {
        this.codmovendaprodserial = codmovendaprodserial;
    }

    public Tipoatendimento getCodtipoatend() {
        return codtipoatend;
    }

    public void setCodtipoatend(Tipoatendimento codtipoatend) {
        this.codtipoatend = codtipoatend;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codatend != null ? codatend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.codatend == null && other.codatend != null) || (this.codatend != null && !this.codatend.equals(other.codatend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Atendimento[ codatend=" + codatend + " ]";
    }
    
}
