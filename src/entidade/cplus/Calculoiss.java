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
@Table(name = "CALCULOISS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculoiss.findAll", query = "SELECT c FROM Calculoiss c")
    , @NamedQuery(name = "Calculoiss.findByCodcalculoiss", query = "SELECT c FROM Calculoiss c WHERE c.codcalculoiss = :codcalculoiss")
    , @NamedQuery(name = "Calculoiss.findByCodigo", query = "SELECT c FROM Calculoiss c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Calculoiss.findByNomecalculoiss", query = "SELECT c FROM Calculoiss c WHERE c.nomecalculoiss = :nomecalculoiss")
    , @NamedQuery(name = "Calculoiss.findByAliqiss", query = "SELECT c FROM Calculoiss c WHERE c.aliqiss = :aliqiss")
    , @NamedQuery(name = "Calculoiss.findByCodigotributacao", query = "SELECT c FROM Calculoiss c WHERE c.codigotributacao = :codigotributacao")
    , @NamedQuery(name = "Calculoiss.findByFlagsolicitanaturezaoperacao", query = "SELECT c FROM Calculoiss c WHERE c.flagsolicitanaturezaoperacao = :flagsolicitanaturezaoperacao")
    , @NamedQuery(name = "Calculoiss.findByCodigolistaservico", query = "SELECT c FROM Calculoiss c WHERE c.codigolistaservico = :codigolistaservico")
    , @NamedQuery(name = "Calculoiss.findByCodnaturezaoperacao", query = "SELECT c FROM Calculoiss c WHERE c.codnaturezaoperacao = :codnaturezaoperacao")
    , @NamedQuery(name = "Calculoiss.findByTipotributacao", query = "SELECT c FROM Calculoiss c WHERE c.tipotributacao = :tipotributacao")
    , @NamedQuery(name = "Calculoiss.findByNaturezatributacao", query = "SELECT c FROM Calculoiss c WHERE c.naturezatributacao = :naturezatributacao")
    , @NamedQuery(name = "Calculoiss.findByAliqirrf", query = "SELECT c FROM Calculoiss c WHERE c.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "Calculoiss.findByExigibilidadeiss", query = "SELECT c FROM Calculoiss c WHERE c.exigibilidadeiss = :exigibilidadeiss")
    , @NamedQuery(name = "Calculoiss.findByCodigoincentivofiscal", query = "SELECT c FROM Calculoiss c WHERE c.codigoincentivofiscal = :codigoincentivofiscal")
    , @NamedQuery(name = "Calculoiss.findByNaturezaoperacaoissqnsat", query = "SELECT c FROM Calculoiss c WHERE c.naturezaoperacaoissqnsat = :naturezaoperacaoissqnsat")})
public class Calculoiss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCALCULOISS")
    private String codcalculoiss;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECALCULOISS")
    private String nomecalculoiss;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "CODIGOTRIBUTACAO")
    private String codigotributacao;
    @Column(name = "FLAGSOLICITANATUREZAOPERACAO")
    private Character flagsolicitanaturezaoperacao;
    @Column(name = "CODIGOLISTASERVICO")
    private String codigolistaservico;
    @Column(name = "CODNATUREZAOPERACAO")
    private Integer codnaturezaoperacao;
    @Column(name = "TIPOTRIBUTACAO")
    private Character tipotributacao;
    @Column(name = "NATUREZATRIBUTACAO")
    private Character naturezatributacao;
    @Column(name = "ALIQIRRF")
    private BigDecimal aliqirrf;
    @Column(name = "EXIGIBILIDADEISS")
    private Character exigibilidadeiss;
    @Column(name = "CODIGOINCENTIVOFISCAL")
    private Integer codigoincentivofiscal;
    @Column(name = "NATUREZAOPERACAOISSQNSAT")
    private Character naturezaoperacaoissqnsat;
    @OneToMany(mappedBy = "codcalculoiss")
    private Collection<Produto> produtoCollection;

    public Calculoiss() {
    }

    public Calculoiss(String codcalculoiss) {
        this.codcalculoiss = codcalculoiss;
    }

    public String getCodcalculoiss() {
        return codcalculoiss;
    }

    public void setCodcalculoiss(String codcalculoiss) {
        this.codcalculoiss = codcalculoiss;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecalculoiss() {
        return nomecalculoiss;
    }

    public void setNomecalculoiss(String nomecalculoiss) {
        this.nomecalculoiss = nomecalculoiss;
    }

    public BigDecimal getAliqiss() {
        return aliqiss;
    }

    public void setAliqiss(BigDecimal aliqiss) {
        this.aliqiss = aliqiss;
    }

    public String getCodigotributacao() {
        return codigotributacao;
    }

    public void setCodigotributacao(String codigotributacao) {
        this.codigotributacao = codigotributacao;
    }

    public Character getFlagsolicitanaturezaoperacao() {
        return flagsolicitanaturezaoperacao;
    }

    public void setFlagsolicitanaturezaoperacao(Character flagsolicitanaturezaoperacao) {
        this.flagsolicitanaturezaoperacao = flagsolicitanaturezaoperacao;
    }

    public String getCodigolistaservico() {
        return codigolistaservico;
    }

    public void setCodigolistaservico(String codigolistaservico) {
        this.codigolistaservico = codigolistaservico;
    }

    public Integer getCodnaturezaoperacao() {
        return codnaturezaoperacao;
    }

    public void setCodnaturezaoperacao(Integer codnaturezaoperacao) {
        this.codnaturezaoperacao = codnaturezaoperacao;
    }

    public Character getTipotributacao() {
        return tipotributacao;
    }

    public void setTipotributacao(Character tipotributacao) {
        this.tipotributacao = tipotributacao;
    }

    public Character getNaturezatributacao() {
        return naturezatributacao;
    }

    public void setNaturezatributacao(Character naturezatributacao) {
        this.naturezatributacao = naturezatributacao;
    }

    public BigDecimal getAliqirrf() {
        return aliqirrf;
    }

    public void setAliqirrf(BigDecimal aliqirrf) {
        this.aliqirrf = aliqirrf;
    }

    public Character getExigibilidadeiss() {
        return exigibilidadeiss;
    }

    public void setExigibilidadeiss(Character exigibilidadeiss) {
        this.exigibilidadeiss = exigibilidadeiss;
    }

    public Integer getCodigoincentivofiscal() {
        return codigoincentivofiscal;
    }

    public void setCodigoincentivofiscal(Integer codigoincentivofiscal) {
        this.codigoincentivofiscal = codigoincentivofiscal;
    }

    public Character getNaturezaoperacaoissqnsat() {
        return naturezaoperacaoissqnsat;
    }

    public void setNaturezaoperacaoissqnsat(Character naturezaoperacaoissqnsat) {
        this.naturezaoperacaoissqnsat = naturezaoperacaoissqnsat;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcalculoiss != null ? codcalculoiss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculoiss)) {
            return false;
        }
        Calculoiss other = (Calculoiss) object;
        if ((this.codcalculoiss == null && other.codcalculoiss != null) || (this.codcalculoiss != null && !this.codcalculoiss.equals(other.codcalculoiss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Calculoiss[ codcalculoiss=" + codcalculoiss + " ]";
    }
    
}
