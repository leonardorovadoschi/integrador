/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VALE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vale.findAll", query = "SELECT v FROM Vale v")
    , @NamedQuery(name = "Vale.findByNumvale", query = "SELECT v FROM Vale v WHERE v.numvale = :numvale")
    , @NamedQuery(name = "Vale.findByCodmovenda", query = "SELECT v FROM Vale v WHERE v.codmovenda = :codmovenda")
    , @NamedQuery(name = "Vale.findByValor", query = "SELECT v FROM Vale v WHERE v.valor = :valor")
    , @NamedQuery(name = "Vale.findByDatpag", query = "SELECT v FROM Vale v WHERE v.datpag = :datpag")
    , @NamedQuery(name = "Vale.findByHorapag", query = "SELECT v FROM Vale v WHERE v.horapag = :horapag")
    , @NamedQuery(name = "Vale.findByCodmovendapag", query = "SELECT v FROM Vale v WHERE v.codmovendapag = :codmovendapag")
    , @NamedQuery(name = "Vale.findByDatvale", query = "SELECT v FROM Vale v WHERE v.datvale = :datvale")
    , @NamedQuery(name = "Vale.findByCodmoventr", query = "SELECT v FROM Vale v WHERE v.codmoventr = :codmoventr")
    , @NamedQuery(name = "Vale.findByCoduserquitacao", query = "SELECT v FROM Vale v WHERE v.coduserquitacao = :coduserquitacao")
    , @NamedQuery(name = "Vale.findByCoduser", query = "SELECT v FROM Vale v WHERE v.coduser = :coduser")
    , @NamedQuery(name = "Vale.findByHoravale", query = "SELECT v FROM Vale v WHERE v.horavale = :horavale")
    , @NamedQuery(name = "Vale.findByFlagdesconto", query = "SELECT v FROM Vale v WHERE v.flagdesconto = :flagdesconto")
    , @NamedQuery(name = "Vale.findByCodvended", query = "SELECT v FROM Vale v WHERE v.codvended = :codvended")
    , @NamedQuery(name = "Vale.findByIdentidadeorigem", query = "SELECT v FROM Vale v WHERE v.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Vale.findByNomeentidadeorigem", query = "SELECT v FROM Vale v WHERE v.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Vale.findByCodvale", query = "SELECT v FROM Vale v WHERE v.codvale = :codvale")
    , @NamedQuery(name = "Vale.findByCodcr", query = "SELECT v FROM Vale v WHERE v.codcr = :codcr")
    , @NamedQuery(name = "Vale.findByCodos", query = "SELECT v FROM Vale v WHERE v.codos = :codos")
    , @NamedQuery(name = "Vale.findByFlagtipo", query = "SELECT v FROM Vale v WHERE v.flagtipo = :flagtipo")
    , @NamedQuery(name = "Vale.findByAliqdesconto", query = "SELECT v FROM Vale v WHERE v.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "Vale.findByTipoquitacao", query = "SELECT v FROM Vale v WHERE v.tipoquitacao = :tipoquitacao")
    , @NamedQuery(name = "Vale.findByGuid", query = "SELECT v FROM Vale v WHERE v.guid = :guid")})
public class Vale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NUMVALE")
    private int numvale;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DATPAG")
    @Temporal(TemporalType.DATE)
    private Date datpag;
    @Column(name = "HORAPAG")
    @Temporal(TemporalType.TIME)
    private Date horapag;
    @Column(name = "CODMOVENDAPAG")
    private String codmovendapag;
    @Column(name = "DATVALE")
    @Temporal(TemporalType.DATE)
    private Date datvale;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CODMOVENTR")
    private String codmoventr;
    @Column(name = "CODUSERQUITACAO")
    private String coduserquitacao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "HORAVALE")
    @Temporal(TemporalType.TIME)
    private Date horavale;
    @Column(name = "FLAGDESCONTO")
    private Character flagdesconto;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVALE")
    private String codvale;
    @Column(name = "CODCR")
    private String codcr;
    @Column(name = "CODOS")
    private String codos;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "TIPOQUITACAO")
    private String tipoquitacao;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODDOCUMENTOCAIXA", referencedColumnName = "CODDOCUMENTOCAIXA")
    @ManyToOne
    private Documentocaixa coddocumentocaixa;
    @JoinColumn(name = "CODDOCUMENTOCAIXABAIXA", referencedColumnName = "CODDOCUMENTOCAIXA")
    @ManyToOne
    private Documentocaixa coddocumentocaixabaixa;

    public Vale() {
    }

    public Vale(String codvale) {
        this.codvale = codvale;
    }

    public Vale(String codvale, int numvale) {
        this.codvale = codvale;
        this.numvale = numvale;
    }

    public int getNumvale() {
        return numvale;
    }

    public void setNumvale(int numvale) {
        this.numvale = numvale;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatpag() {
        return datpag;
    }

    public void setDatpag(Date datpag) {
        this.datpag = datpag;
    }

    public Date getHorapag() {
        return horapag;
    }

    public void setHorapag(Date horapag) {
        this.horapag = horapag;
    }

    public String getCodmovendapag() {
        return codmovendapag;
    }

    public void setCodmovendapag(String codmovendapag) {
        this.codmovendapag = codmovendapag;
    }

    public Date getDatvale() {
        return datvale;
    }

    public void setDatvale(Date datvale) {
        this.datvale = datvale;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(String codmoventr) {
        this.codmoventr = codmoventr;
    }

    public String getCoduserquitacao() {
        return coduserquitacao;
    }

    public void setCoduserquitacao(String coduserquitacao) {
        this.coduserquitacao = coduserquitacao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getHoravale() {
        return horavale;
    }

    public void setHoravale(Date horavale) {
        this.horavale = horavale;
    }

    public Character getFlagdesconto() {
        return flagdesconto;
    }

    public void setFlagdesconto(Character flagdesconto) {
        this.flagdesconto = flagdesconto;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getCodvale() {
        return codvale;
    }

    public void setCodvale(String codvale) {
        this.codvale = codvale;
    }

    public String getCodcr() {
        return codcr;
    }

    public void setCodcr(String codcr) {
        this.codcr = codcr;
    }

    public String getCodos() {
        return codos;
    }

    public void setCodos(String codos) {
        this.codos = codos;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public String getTipoquitacao() {
        return tipoquitacao;
    }

    public void setTipoquitacao(String tipoquitacao) {
        this.tipoquitacao = tipoquitacao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Documentocaixa getCoddocumentocaixa() {
        return coddocumentocaixa;
    }

    public void setCoddocumentocaixa(Documentocaixa coddocumentocaixa) {
        this.coddocumentocaixa = coddocumentocaixa;
    }

    public Documentocaixa getCoddocumentocaixabaixa() {
        return coddocumentocaixabaixa;
    }

    public void setCoddocumentocaixabaixa(Documentocaixa coddocumentocaixabaixa) {
        this.coddocumentocaixabaixa = coddocumentocaixabaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvale != null ? codvale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vale)) {
            return false;
        }
        Vale other = (Vale) object;
        if ((this.codvale == null && other.codvale != null) || (this.codvale != null && !this.codvale.equals(other.codvale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vale[ codvale=" + codvale + " ]";
    }
    
}
