/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TRIBUTACAOECFUF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tributacaoecfuf.findAll", query = "SELECT t FROM Tributacaoecfuf t")
    , @NamedQuery(name = "Tributacaoecfuf.findByCodtributacaoecfuf", query = "SELECT t FROM Tributacaoecfuf t WHERE t.codtributacaoecfuf = :codtributacaoecfuf")
    , @NamedQuery(name = "Tributacaoecfuf.findByCoduf", query = "SELECT t FROM Tributacaoecfuf t WHERE t.coduf = :coduf")
    , @NamedQuery(name = "Tributacaoecfuf.findByFlagsimplesnacional", query = "SELECT t FROM Tributacaoecfuf t WHERE t.flagsimplesnacional = :flagsimplesnacional")
    , @NamedQuery(name = "Tributacaoecfuf.findByTipotributacao", query = "SELECT t FROM Tributacaoecfuf t WHERE t.tipotributacao = :tipotributacao")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqtributacao", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqtributacao = :aliqtributacao")
    , @NamedQuery(name = "Tributacaoecfuf.findByCodsituacaotributaria", query = "SELECT t FROM Tributacaoecfuf t WHERE t.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Tributacaoecfuf.findByTipotributacaodif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.tipotributacaodif = :tipotributacaodif")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqtributacaodif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqtributacaodif = :aliqtributacaodif")
    , @NamedQuery(name = "Tributacaoecfuf.findByCodsituacaotributariadif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.codsituacaotributariadif = :codsituacaotributariadif")
    , @NamedQuery(name = "Tributacaoecfuf.findByCsosn", query = "SELECT t FROM Tributacaoecfuf t WHERE t.csosn = :csosn")
    , @NamedQuery(name = "Tributacaoecfuf.findByCsosndiferenciada", query = "SELECT t FROM Tributacaoecfuf t WHERE t.csosndiferenciada = :csosndiferenciada")
    , @NamedQuery(name = "Tributacaoecfuf.findByCstpis", query = "SELECT t FROM Tributacaoecfuf t WHERE t.cstpis = :cstpis")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqpis", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqpis = :aliqpis")
    , @NamedQuery(name = "Tributacaoecfuf.findByCstcofins", query = "SELECT t FROM Tributacaoecfuf t WHERE t.cstcofins = :cstcofins")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqcofins", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Tributacaoecfuf.findByCstpisdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.cstpisdif = :cstpisdif")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqpisdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqpisdif = :aliqpisdif")
    , @NamedQuery(name = "Tributacaoecfuf.findByCstcofinsdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.cstcofinsdif = :cstcofinsdif")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqcofinsdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqcofinsdif = :aliqcofinsdif")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqreducaobaseicms", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqreducaobaseicmsdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqreducaobaseicmsdif = :aliqreducaobaseicmsdif")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqfcp", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Tributacaoecfuf.findByAliqfcpdif", query = "SELECT t FROM Tributacaoecfuf t WHERE t.aliqfcpdif = :aliqfcpdif")})
public class Tributacaoecfuf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTRIBUTACAOECFUF")
    private String codtributacaoecfuf;
    @Column(name = "CODUF")
    private String coduf;
    @Column(name = "FLAGSIMPLESNACIONAL")
    private Character flagsimplesnacional;
    @Column(name = "TIPOTRIBUTACAO")
    private Character tipotributacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQTRIBUTACAO")
    private BigDecimal aliqtributacao;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @Column(name = "TIPOTRIBUTACAODIF")
    private Character tipotributacaodif;
    @Column(name = "ALIQTRIBUTACAODIF")
    private BigDecimal aliqtributacaodif;
    @Column(name = "CODSITUACAOTRIBUTARIADIF")
    private String codsituacaotributariadif;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "CSOSNDIFERENCIADA")
    private String csosndiferenciada;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "CSTPISDIF")
    private String cstpisdif;
    @Column(name = "ALIQPISDIF")
    private BigDecimal aliqpisdif;
    @Column(name = "CSTCOFINSDIF")
    private String cstcofinsdif;
    @Column(name = "ALIQCOFINSDIF")
    private BigDecimal aliqcofinsdif;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "ALIQREDUCAOBASEICMSDIF")
    private BigDecimal aliqreducaobaseicmsdif;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "ALIQFCPDIF")
    private BigDecimal aliqfcpdif;
    @JoinColumn(name = "CODTRIBUTACAOECF", referencedColumnName = "CODTRIBUTACAOECF")
    @ManyToOne
    private Tributacaoecf codtributacaoecf;

    public Tributacaoecfuf() {
    }

    public Tributacaoecfuf(String codtributacaoecfuf) {
        this.codtributacaoecfuf = codtributacaoecfuf;
    }

    public String getCodtributacaoecfuf() {
        return codtributacaoecfuf;
    }

    public void setCodtributacaoecfuf(String codtributacaoecfuf) {
        this.codtributacaoecfuf = codtributacaoecfuf;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public Character getFlagsimplesnacional() {
        return flagsimplesnacional;
    }

    public void setFlagsimplesnacional(Character flagsimplesnacional) {
        this.flagsimplesnacional = flagsimplesnacional;
    }

    public Character getTipotributacao() {
        return tipotributacao;
    }

    public void setTipotributacao(Character tipotributacao) {
        this.tipotributacao = tipotributacao;
    }

    public BigDecimal getAliqtributacao() {
        return aliqtributacao;
    }

    public void setAliqtributacao(BigDecimal aliqtributacao) {
        this.aliqtributacao = aliqtributacao;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    public Character getTipotributacaodif() {
        return tipotributacaodif;
    }

    public void setTipotributacaodif(Character tipotributacaodif) {
        this.tipotributacaodif = tipotributacaodif;
    }

    public BigDecimal getAliqtributacaodif() {
        return aliqtributacaodif;
    }

    public void setAliqtributacaodif(BigDecimal aliqtributacaodif) {
        this.aliqtributacaodif = aliqtributacaodif;
    }

    public String getCodsituacaotributariadif() {
        return codsituacaotributariadif;
    }

    public void setCodsituacaotributariadif(String codsituacaotributariadif) {
        this.codsituacaotributariadif = codsituacaotributariadif;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCsosndiferenciada() {
        return csosndiferenciada;
    }

    public void setCsosndiferenciada(String csosndiferenciada) {
        this.csosndiferenciada = csosndiferenciada;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public String getCstpisdif() {
        return cstpisdif;
    }

    public void setCstpisdif(String cstpisdif) {
        this.cstpisdif = cstpisdif;
    }

    public BigDecimal getAliqpisdif() {
        return aliqpisdif;
    }

    public void setAliqpisdif(BigDecimal aliqpisdif) {
        this.aliqpisdif = aliqpisdif;
    }

    public String getCstcofinsdif() {
        return cstcofinsdif;
    }

    public void setCstcofinsdif(String cstcofinsdif) {
        this.cstcofinsdif = cstcofinsdif;
    }

    public BigDecimal getAliqcofinsdif() {
        return aliqcofinsdif;
    }

    public void setAliqcofinsdif(BigDecimal aliqcofinsdif) {
        this.aliqcofinsdif = aliqcofinsdif;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
    }

    public BigDecimal getAliqreducaobaseicmsdif() {
        return aliqreducaobaseicmsdif;
    }

    public void setAliqreducaobaseicmsdif(BigDecimal aliqreducaobaseicmsdif) {
        this.aliqreducaobaseicmsdif = aliqreducaobaseicmsdif;
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        this.aliqfcp = aliqfcp;
    }

    public BigDecimal getAliqfcpdif() {
        return aliqfcpdif;
    }

    public void setAliqfcpdif(BigDecimal aliqfcpdif) {
        this.aliqfcpdif = aliqfcpdif;
    }

    public Tributacaoecf getCodtributacaoecf() {
        return codtributacaoecf;
    }

    public void setCodtributacaoecf(Tributacaoecf codtributacaoecf) {
        this.codtributacaoecf = codtributacaoecf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtributacaoecfuf != null ? codtributacaoecfuf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tributacaoecfuf)) {
            return false;
        }
        Tributacaoecfuf other = (Tributacaoecfuf) object;
        if ((this.codtributacaoecfuf == null && other.codtributacaoecfuf != null) || (this.codtributacaoecfuf != null && !this.codtributacaoecfuf.equals(other.codtributacaoecfuf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tributacaoecfuf[ codtributacaoecfuf=" + codtributacaoecfuf + " ]";
    }
    
}
