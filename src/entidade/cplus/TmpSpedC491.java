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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TMP_SPED_C491", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC491.findAll", query = "SELECT t FROM TmpSpedC491 t")
    , @NamedQuery(name = "TmpSpedC491.findByCodtmpSpedC491", query = "SELECT t FROM TmpSpedC491 t WHERE t.codtmpSpedC491 = :codtmpSpedC491")
    , @NamedQuery(name = "TmpSpedC491.findByCodItem", query = "SELECT t FROM TmpSpedC491 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC491.findByCstPis", query = "SELECT t FROM TmpSpedC491 t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedC491.findByCfop", query = "SELECT t FROM TmpSpedC491 t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TmpSpedC491.findByVlItem", query = "SELECT t FROM TmpSpedC491 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC491.findByVlBcPis", query = "SELECT t FROM TmpSpedC491 t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedC491.findByAliqPis", query = "SELECT t FROM TmpSpedC491 t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedC491.findByQuantBcPis", query = "SELECT t FROM TmpSpedC491 t WHERE t.quantBcPis = :quantBcPis")
    , @NamedQuery(name = "TmpSpedC491.findByAliqPisQuant", query = "SELECT t FROM TmpSpedC491 t WHERE t.aliqPisQuant = :aliqPisQuant")
    , @NamedQuery(name = "TmpSpedC491.findByVlPis", query = "SELECT t FROM TmpSpedC491 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC491.findByCodCta", query = "SELECT t FROM TmpSpedC491 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC491.findByCodempresa", query = "SELECT t FROM TmpSpedC491 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC491.findByNumeroserie", query = "SELECT t FROM TmpSpedC491 t WHERE t.numeroserie = :numeroserie")})
public class TmpSpedC491 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C491")
    private Integer codtmpSpedC491;
    @Column(name = "COD_ITEM")
    private String codItem;
    @Basic(optional = false)
    @Column(name = "CST_PIS")
    private String cstPis;
    @Column(name = "CFOP")
    private String cfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VL_ITEM")
    private BigDecimal vlItem;
    @Column(name = "VL_BC_PIS")
    private BigDecimal vlBcPis;
    @Column(name = "ALIQ_PIS")
    private BigDecimal aliqPis;
    @Column(name = "QUANT_BC_PIS")
    private BigDecimal quantBcPis;
    @Column(name = "ALIQ_PIS_QUANT")
    private BigDecimal aliqPisQuant;
    @Column(name = "VL_PIS")
    private BigDecimal vlPis;
    @Column(name = "COD_CTA")
    private String codCta;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "NUMEROSERIE")
    private String numeroserie;

    public TmpSpedC491() {
    }

    public TmpSpedC491(Integer codtmpSpedC491) {
        this.codtmpSpedC491 = codtmpSpedC491;
    }

    public TmpSpedC491(Integer codtmpSpedC491, String cstPis, BigDecimal vlItem, int codempresa, String numeroserie) {
        this.codtmpSpedC491 = codtmpSpedC491;
        this.cstPis = cstPis;
        this.vlItem = vlItem;
        this.codempresa = codempresa;
        this.numeroserie = numeroserie;
    }

    public Integer getCodtmpSpedC491() {
        return codtmpSpedC491;
    }

    public void setCodtmpSpedC491(Integer codtmpSpedC491) {
        this.codtmpSpedC491 = codtmpSpedC491;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getVlItem() {
        return vlItem;
    }

    public void setVlItem(BigDecimal vlItem) {
        this.vlItem = vlItem;
    }

    public BigDecimal getVlBcPis() {
        return vlBcPis;
    }

    public void setVlBcPis(BigDecimal vlBcPis) {
        this.vlBcPis = vlBcPis;
    }

    public BigDecimal getAliqPis() {
        return aliqPis;
    }

    public void setAliqPis(BigDecimal aliqPis) {
        this.aliqPis = aliqPis;
    }

    public BigDecimal getQuantBcPis() {
        return quantBcPis;
    }

    public void setQuantBcPis(BigDecimal quantBcPis) {
        this.quantBcPis = quantBcPis;
    }

    public BigDecimal getAliqPisQuant() {
        return aliqPisQuant;
    }

    public void setAliqPisQuant(BigDecimal aliqPisQuant) {
        this.aliqPisQuant = aliqPisQuant;
    }

    public BigDecimal getVlPis() {
        return vlPis;
    }

    public void setVlPis(BigDecimal vlPis) {
        this.vlPis = vlPis;
    }

    public String getCodCta() {
        return codCta;
    }

    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC491 != null ? codtmpSpedC491.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC491)) {
            return false;
        }
        TmpSpedC491 other = (TmpSpedC491) object;
        if ((this.codtmpSpedC491 == null && other.codtmpSpedC491 != null) || (this.codtmpSpedC491 != null && !this.codtmpSpedC491.equals(other.codtmpSpedC491))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC491[ codtmpSpedC491=" + codtmpSpedC491 + " ]";
    }
    
}
