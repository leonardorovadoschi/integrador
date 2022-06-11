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
@Table(name = "TMP_SPED_C495", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC495.findAll", query = "SELECT t FROM TmpSpedC495 t")
    , @NamedQuery(name = "TmpSpedC495.findByCodtmpSpedC495", query = "SELECT t FROM TmpSpedC495 t WHERE t.codtmpSpedC495 = :codtmpSpedC495")
    , @NamedQuery(name = "TmpSpedC495.findByCodItem", query = "SELECT t FROM TmpSpedC495 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC495.findByCstCofins", query = "SELECT t FROM TmpSpedC495 t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedC495.findByCfop", query = "SELECT t FROM TmpSpedC495 t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TmpSpedC495.findByVlItem", query = "SELECT t FROM TmpSpedC495 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC495.findByVlBcCofins", query = "SELECT t FROM TmpSpedC495 t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedC495.findByAliqCofins", query = "SELECT t FROM TmpSpedC495 t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedC495.findByQuantBcCofins", query = "SELECT t FROM TmpSpedC495 t WHERE t.quantBcCofins = :quantBcCofins")
    , @NamedQuery(name = "TmpSpedC495.findByAliqCofinsQuant", query = "SELECT t FROM TmpSpedC495 t WHERE t.aliqCofinsQuant = :aliqCofinsQuant")
    , @NamedQuery(name = "TmpSpedC495.findByVlCofins", query = "SELECT t FROM TmpSpedC495 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC495.findByCodCta", query = "SELECT t FROM TmpSpedC495 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC495.findByCodempresa", query = "SELECT t FROM TmpSpedC495 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC495.findByNumeroserie", query = "SELECT t FROM TmpSpedC495 t WHERE t.numeroserie = :numeroserie")})
public class TmpSpedC495 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C495")
    private Integer codtmpSpedC495;
    @Column(name = "COD_ITEM")
    private String codItem;
    @Basic(optional = false)
    @Column(name = "CST_COFINS")
    private String cstCofins;
    @Column(name = "CFOP")
    private String cfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VL_ITEM")
    private BigDecimal vlItem;
    @Column(name = "VL_BC_COFINS")
    private BigDecimal vlBcCofins;
    @Column(name = "ALIQ_COFINS")
    private BigDecimal aliqCofins;
    @Column(name = "QUANT_BC_COFINS")
    private BigDecimal quantBcCofins;
    @Column(name = "ALIQ_COFINS_QUANT")
    private BigDecimal aliqCofinsQuant;
    @Column(name = "VL_COFINS")
    private BigDecimal vlCofins;
    @Column(name = "COD_CTA")
    private String codCta;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "NUMEROSERIE")
    private String numeroserie;

    public TmpSpedC495() {
    }

    public TmpSpedC495(Integer codtmpSpedC495) {
        this.codtmpSpedC495 = codtmpSpedC495;
    }

    public TmpSpedC495(Integer codtmpSpedC495, String cstCofins, BigDecimal vlItem, int codempresa, String numeroserie) {
        this.codtmpSpedC495 = codtmpSpedC495;
        this.cstCofins = cstCofins;
        this.vlItem = vlItem;
        this.codempresa = codempresa;
        this.numeroserie = numeroserie;
    }

    public Integer getCodtmpSpedC495() {
        return codtmpSpedC495;
    }

    public void setCodtmpSpedC495(Integer codtmpSpedC495) {
        this.codtmpSpedC495 = codtmpSpedC495;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
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

    public BigDecimal getVlBcCofins() {
        return vlBcCofins;
    }

    public void setVlBcCofins(BigDecimal vlBcCofins) {
        this.vlBcCofins = vlBcCofins;
    }

    public BigDecimal getAliqCofins() {
        return aliqCofins;
    }

    public void setAliqCofins(BigDecimal aliqCofins) {
        this.aliqCofins = aliqCofins;
    }

    public BigDecimal getQuantBcCofins() {
        return quantBcCofins;
    }

    public void setQuantBcCofins(BigDecimal quantBcCofins) {
        this.quantBcCofins = quantBcCofins;
    }

    public BigDecimal getAliqCofinsQuant() {
        return aliqCofinsQuant;
    }

    public void setAliqCofinsQuant(BigDecimal aliqCofinsQuant) {
        this.aliqCofinsQuant = aliqCofinsQuant;
    }

    public BigDecimal getVlCofins() {
        return vlCofins;
    }

    public void setVlCofins(BigDecimal vlCofins) {
        this.vlCofins = vlCofins;
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
        hash += (codtmpSpedC495 != null ? codtmpSpedC495.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC495)) {
            return false;
        }
        TmpSpedC495 other = (TmpSpedC495) object;
        if ((this.codtmpSpedC495 == null && other.codtmpSpedC495 != null) || (this.codtmpSpedC495 != null && !this.codtmpSpedC495.equals(other.codtmpSpedC495))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC495[ codtmpSpedC495=" + codtmpSpedC495 + " ]";
    }
    
}
