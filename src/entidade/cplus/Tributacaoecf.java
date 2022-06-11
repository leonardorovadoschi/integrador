/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TRIBUTACAOECF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tributacaoecf.findAll", query = "SELECT t FROM Tributacaoecf t")
    , @NamedQuery(name = "Tributacaoecf.findByCodtributacaoecf", query = "SELECT t FROM Tributacaoecf t WHERE t.codtributacaoecf = :codtributacaoecf")
    , @NamedQuery(name = "Tributacaoecf.findByCodigo", query = "SELECT t FROM Tributacaoecf t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tributacaoecf.findByNometributacaoecf", query = "SELECT t FROM Tributacaoecf t WHERE t.nometributacaoecf = :nometributacaoecf")
    , @NamedQuery(name = "Tributacaoecf.findByTipotributacao", query = "SELECT t FROM Tributacaoecf t WHERE t.tipotributacao = :tipotributacao")
    , @NamedQuery(name = "Tributacaoecf.findByAliqtributacao", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqtributacao = :aliqtributacao")
    , @NamedQuery(name = "Tributacaoecf.findByCodsituacaotributaria", query = "SELECT t FROM Tributacaoecf t WHERE t.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Tributacaoecf.findByTipotributacaodif", query = "SELECT t FROM Tributacaoecf t WHERE t.tipotributacaodif = :tipotributacaodif")
    , @NamedQuery(name = "Tributacaoecf.findByAliqtributacaodif", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqtributacaodif = :aliqtributacaodif")
    , @NamedQuery(name = "Tributacaoecf.findByCodsituacaotributariadif", query = "SELECT t FROM Tributacaoecf t WHERE t.codsituacaotributariadif = :codsituacaotributariadif")
    , @NamedQuery(name = "Tributacaoecf.findByCsosn", query = "SELECT t FROM Tributacaoecf t WHERE t.csosn = :csosn")
    , @NamedQuery(name = "Tributacaoecf.findByCsosndiferenciada", query = "SELECT t FROM Tributacaoecf t WHERE t.csosndiferenciada = :csosndiferenciada")
    , @NamedQuery(name = "Tributacaoecf.findByCstpis", query = "SELECT t FROM Tributacaoecf t WHERE t.cstpis = :cstpis")
    , @NamedQuery(name = "Tributacaoecf.findByAliqpis", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqpis = :aliqpis")
    , @NamedQuery(name = "Tributacaoecf.findByCstcofins", query = "SELECT t FROM Tributacaoecf t WHERE t.cstcofins = :cstcofins")
    , @NamedQuery(name = "Tributacaoecf.findByAliqcofins", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Tributacaoecf.findByCstpisdif", query = "SELECT t FROM Tributacaoecf t WHERE t.cstpisdif = :cstpisdif")
    , @NamedQuery(name = "Tributacaoecf.findByAliqpisdif", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqpisdif = :aliqpisdif")
    , @NamedQuery(name = "Tributacaoecf.findByCstcofinsdif", query = "SELECT t FROM Tributacaoecf t WHERE t.cstcofinsdif = :cstcofinsdif")
    , @NamedQuery(name = "Tributacaoecf.findByAliqcofinsdif", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqcofinsdif = :aliqcofinsdif")
    , @NamedQuery(name = "Tributacaoecf.findByCodcalculoicms", query = "SELECT t FROM Tributacaoecf t WHERE t.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "Tributacaoecf.findByCodcalculoiss", query = "SELECT t FROM Tributacaoecf t WHERE t.codcalculoiss = :codcalculoiss")
    , @NamedQuery(name = "Tributacaoecf.findByAliqreducaobaseicms", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "Tributacaoecf.findByAliqreducaobaseicmsdif", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqreducaobaseicmsdif = :aliqreducaobaseicmsdif")
    , @NamedQuery(name = "Tributacaoecf.findByAliqfcp", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Tributacaoecf.findByAliqfcpdif", query = "SELECT t FROM Tributacaoecf t WHERE t.aliqfcpdif = :aliqfcpdif")})
public class Tributacaoecf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTRIBUTACAOECF")
    private String codtributacaoecf;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMETRIBUTACAOECF")
    private String nometributacaoecf;
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
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "CODCALCULOISS")
    private String codcalculoiss;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "ALIQREDUCAOBASEICMSDIF")
    private BigDecimal aliqreducaobaseicmsdif;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "ALIQFCPDIF")
    private BigDecimal aliqfcpdif;
    @OneToMany(mappedBy = "codtributacaoecf")
    private Collection<Produto> produtoCollection;
    @OneToMany(mappedBy = "codtributacaoecf")
    private Collection<Tributacaoecfuf> tributacaoecfufCollection;

    public Tributacaoecf() {
    }

    public Tributacaoecf(String codtributacaoecf) {
        this.codtributacaoecf = codtributacaoecf;
    }

    public Tributacaoecf(String codtributacaoecf, String codigo, String nometributacaoecf) {
        this.codtributacaoecf = codtributacaoecf;
        this.codigo = codigo;
        this.nometributacaoecf = nometributacaoecf;
    }

    public String getCodtributacaoecf() {
        return codtributacaoecf;
    }

    public void setCodtributacaoecf(String codtributacaoecf) {
        this.codtributacaoecf = codtributacaoecf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometributacaoecf() {
        return nometributacaoecf;
    }

    public void setNometributacaoecf(String nometributacaoecf) {
        this.nometributacaoecf = nometributacaoecf;
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

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public String getCodcalculoiss() {
        return codcalculoiss;
    }

    public void setCodcalculoiss(String codcalculoiss) {
        this.codcalculoiss = codcalculoiss;
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

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<Tributacaoecfuf> getTributacaoecfufCollection() {
        return tributacaoecfufCollection;
    }

    public void setTributacaoecfufCollection(Collection<Tributacaoecfuf> tributacaoecfufCollection) {
        this.tributacaoecfufCollection = tributacaoecfufCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtributacaoecf != null ? codtributacaoecf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tributacaoecf)) {
            return false;
        }
        Tributacaoecf other = (Tributacaoecf) object;
        if ((this.codtributacaoecf == null && other.codtributacaoecf != null) || (this.codtributacaoecf != null && !this.codtributacaoecf.equals(other.codtributacaoecf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tributacaoecf[ codtributacaoecf=" + codtributacaoecf + " ]";
    }
    
}
