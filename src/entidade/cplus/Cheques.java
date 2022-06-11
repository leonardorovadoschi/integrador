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
@Table(name = "CHEQUES", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cheques.findAll", query = "SELECT c FROM Cheques c")
    , @NamedQuery(name = "Cheques.findByCodcheque", query = "SELECT c FROM Cheques c WHERE c.codcheque = :codcheque")
    , @NamedQuery(name = "Cheques.findByCodmovenda", query = "SELECT c FROM Cheques c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Cheques.findByCoduser", query = "SELECT c FROM Cheques c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Cheques.findByIdrec", query = "SELECT c FROM Cheques c WHERE c.idrec = :idrec")
    , @NamedQuery(name = "Cheques.findByEntrada", query = "SELECT c FROM Cheques c WHERE c.entrada = :entrada")
    , @NamedQuery(name = "Cheques.findByEmitente", query = "SELECT c FROM Cheques c WHERE c.emitente = :emitente")
    , @NamedQuery(name = "Cheques.findByValor", query = "SELECT c FROM Cheques c WHERE c.valor = :valor")
    , @NamedQuery(name = "Cheques.findByNumcheque", query = "SELECT c FROM Cheques c WHERE c.numcheque = :numcheque")
    , @NamedQuery(name = "Cheques.findByBanco", query = "SELECT c FROM Cheques c WHERE c.banco = :banco")
    , @NamedQuery(name = "Cheques.findByAgencia", query = "SELECT c FROM Cheques c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Cheques.findByDepositar", query = "SELECT c FROM Cheques c WHERE c.depositar = :depositar")
    , @NamedQuery(name = "Cheques.findByDias", query = "SELECT c FROM Cheques c WHERE c.dias = :dias")
    , @NamedQuery(name = "Cheques.findByQuantret", query = "SELECT c FROM Cheques c WHERE c.quantret = :quantret")
    , @NamedQuery(name = "Cheques.findByFlagcli", query = "SELECT c FROM Cheques c WHERE c.flagcli = :flagcli")
    , @NamedQuery(name = "Cheques.findByFlagdepos", query = "SELECT c FROM Cheques c WHERE c.flagdepos = :flagdepos")
    , @NamedQuery(name = "Cheques.findByDeposito", query = "SELECT c FROM Cheques c WHERE c.deposito = :deposito")
    , @NamedQuery(name = "Cheques.findByRetornou", query = "SELECT c FROM Cheques c WHERE c.retornou = :retornou")
    , @NamedQuery(name = "Cheques.findByDestinatario", query = "SELECT c FROM Cheques c WHERE c.destinatario = :destinatario")
    , @NamedQuery(name = "Cheques.findByFlagforn", query = "SELECT c FROM Cheques c WHERE c.flagforn = :flagforn")
    , @NamedQuery(name = "Cheques.findByCodsituacaoadministrativa", query = "SELECT c FROM Cheques c WHERE c.codsituacaoadministrativa = :codsituacaoadministrativa")
    , @NamedQuery(name = "Cheques.findByTaxarepasse", query = "SELECT c FROM Cheques c WHERE c.taxarepasse = :taxarepasse")
    , @NamedQuery(name = "Cheques.findByFlagreapresentar", query = "SELECT c FROM Cheques c WHERE c.flagreapresentar = :flagreapresentar")
    , @NamedQuery(name = "Cheques.findByCoduserrenegociacao", query = "SELECT c FROM Cheques c WHERE c.coduserrenegociacao = :coduserrenegociacao")
    , @NamedQuery(name = "Cheques.findByFlagrenegociado", query = "SELECT c FROM Cheques c WHERE c.flagrenegociado = :flagrenegociado")
    , @NamedQuery(name = "Cheques.findByGuid", query = "SELECT c FROM Cheques c WHERE c.guid = :guid")
    , @NamedQuery(name = "Cheques.findByValordesconto", query = "SELECT c FROM Cheques c WHERE c.valordesconto = :valordesconto")
    , @NamedQuery(name = "Cheques.findByNumeroconta", query = "SELECT c FROM Cheques c WHERE c.numeroconta = :numeroconta")})
public class Cheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCHEQUE")
    private String codcheque;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "IDREC")
    private Integer idrec;
    @Column(name = "ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "EMITENTE")
    private String emitente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "NUMCHEQUE")
    private String numcheque;
    @Column(name = "BANCO")
    private String banco;
    @Column(name = "AGENCIA")
    private String agencia;
    @Column(name = "DEPOSITAR")
    @Temporal(TemporalType.DATE)
    private Date depositar;
    @Basic(optional = false)
    @Column(name = "DIAS")
    private short dias;
    @Basic(optional = false)
    @Column(name = "QUANTRET")
    private short quantret;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Basic(optional = false)
    @Column(name = "FLAGDEPOS")
    private Character flagdepos;
    @Column(name = "DEPOSITO")
    @Temporal(TemporalType.DATE)
    private Date deposito;
    @Column(name = "RETORNOU")
    private Character retornou;
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @Basic(optional = false)
    @Column(name = "FLAGFORN")
    private Character flagforn;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CODSITUACAOADMINISTRATIVA")
    private String codsituacaoadministrativa;
    @Column(name = "TAXAREPASSE")
    private BigDecimal taxarepasse;
    @Column(name = "FLAGREAPRESENTAR")
    private Character flagreapresentar;
    @Column(name = "CODUSERRENEGOCIACAO")
    private String coduserrenegociacao;
    @Column(name = "FLAGRENEGOCIADO")
    private Character flagrenegociado;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "NUMEROCONTA")
    private String numeroconta;
    @JoinColumn(name = "CODALINEA", referencedColumnName = "CODALINEA")
    @ManyToOne
    private Alinea codalinea;
    @JoinColumn(name = "CODCAIXA", referencedColumnName = "CODCAIXA")
    @ManyToOne
    private Caixa codcaixa;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @JoinColumn(name = "CODVENDEDRENEGOCIACAO", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedrenegociacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcheque")
    private Collection<Chequeshistorico> chequeshistoricoCollection;

    public Cheques() {
    }

    public Cheques(String codcheque) {
        this.codcheque = codcheque;
    }

    public Cheques(String codcheque, String numcheque, short dias, short quantret, Character flagdepos, Character flagforn) {
        this.codcheque = codcheque;
        this.numcheque = numcheque;
        this.dias = dias;
        this.quantret = quantret;
        this.flagdepos = flagdepos;
        this.flagforn = flagforn;
    }

    public String getCodcheque() {
        return codcheque;
    }

    public void setCodcheque(String codcheque) {
        this.codcheque = codcheque;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Integer getIdrec() {
        return idrec;
    }

    public void setIdrec(Integer idrec) {
        this.idrec = idrec;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public String getEmitente() {
        return emitente;
    }

    public void setEmitente(String emitente) {
        this.emitente = emitente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumcheque() {
        return numcheque;
    }

    public void setNumcheque(String numcheque) {
        this.numcheque = numcheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDepositar() {
        return depositar;
    }

    public void setDepositar(Date depositar) {
        this.depositar = depositar;
    }

    public short getDias() {
        return dias;
    }

    public void setDias(short dias) {
        this.dias = dias;
    }

    public short getQuantret() {
        return quantret;
    }

    public void setQuantret(short quantret) {
        this.quantret = quantret;
    }

    public Character getFlagcli() {
        return flagcli;
    }

    public void setFlagcli(Character flagcli) {
        this.flagcli = flagcli;
    }

    public Character getFlagdepos() {
        return flagdepos;
    }

    public void setFlagdepos(Character flagdepos) {
        this.flagdepos = flagdepos;
    }

    public Date getDeposito() {
        return deposito;
    }

    public void setDeposito(Date deposito) {
        this.deposito = deposito;
    }

    public Character getRetornou() {
        return retornou;
    }

    public void setRetornou(Character retornou) {
        this.retornou = retornou;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Character getFlagforn() {
        return flagforn;
    }

    public void setFlagforn(Character flagforn) {
        this.flagforn = flagforn;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public BigDecimal getTaxarepasse() {
        return taxarepasse;
    }

    public void setTaxarepasse(BigDecimal taxarepasse) {
        this.taxarepasse = taxarepasse;
    }

    public Character getFlagreapresentar() {
        return flagreapresentar;
    }

    public void setFlagreapresentar(Character flagreapresentar) {
        this.flagreapresentar = flagreapresentar;
    }

    public String getCoduserrenegociacao() {
        return coduserrenegociacao;
    }

    public void setCoduserrenegociacao(String coduserrenegociacao) {
        this.coduserrenegociacao = coduserrenegociacao;
    }

    public Character getFlagrenegociado() {
        return flagrenegociado;
    }

    public void setFlagrenegociado(Character flagrenegociado) {
        this.flagrenegociado = flagrenegociado;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public String getNumeroconta() {
        return numeroconta;
    }

    public void setNumeroconta(String numeroconta) {
        this.numeroconta = numeroconta;
    }

    public Alinea getCodalinea() {
        return codalinea;
    }

    public void setCodalinea(Alinea codalinea) {
        this.codalinea = codalinea;
    }

    public Caixa getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(Caixa codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
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

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    public Vendedor getCodvendedrenegociacao() {
        return codvendedrenegociacao;
    }

    public void setCodvendedrenegociacao(Vendedor codvendedrenegociacao) {
        this.codvendedrenegociacao = codvendedrenegociacao;
    }

    @XmlTransient
    public Collection<Chequeshistorico> getChequeshistoricoCollection() {
        return chequeshistoricoCollection;
    }

    public void setChequeshistoricoCollection(Collection<Chequeshistorico> chequeshistoricoCollection) {
        this.chequeshistoricoCollection = chequeshistoricoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcheque != null ? codcheque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cheques)) {
            return false;
        }
        Cheques other = (Cheques) object;
        if ((this.codcheque == null && other.codcheque != null) || (this.codcheque != null && !this.codcheque.equals(other.codcheque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cheques[ codcheque=" + codcheque + " ]";
    }
    
}
