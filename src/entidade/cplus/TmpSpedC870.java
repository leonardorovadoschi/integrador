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
@Table(name = "TMP_SPED_C870", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC870.findAll", query = "SELECT t FROM TmpSpedC870 t")
    , @NamedQuery(name = "TmpSpedC870.findByCodtmpSpedC870", query = "SELECT t FROM TmpSpedC870 t WHERE t.codtmpSpedC870 = :codtmpSpedC870")
    , @NamedQuery(name = "TmpSpedC870.findByNseriesat", query = "SELECT t FROM TmpSpedC870 t WHERE t.nseriesat = :nseriesat")
    , @NamedQuery(name = "TmpSpedC870.findByCodItem", query = "SELECT t FROM TmpSpedC870 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC870.findByCodcfop", query = "SELECT t FROM TmpSpedC870 t WHERE t.codcfop = :codcfop")
    , @NamedQuery(name = "TmpSpedC870.findByVlItem", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC870.findByCstPis", query = "SELECT t FROM TmpSpedC870 t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedC870.findByVlBcPis", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedC870.findByAliqPis", query = "SELECT t FROM TmpSpedC870 t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedC870.findByVlPis", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC870.findByCstCofins", query = "SELECT t FROM TmpSpedC870 t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedC870.findByVlBcCofins", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedC870.findByAliqCofins", query = "SELECT t FROM TmpSpedC870 t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedC870.findByVlCofins", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC870.findByVlDesc", query = "SELECT t FROM TmpSpedC870 t WHERE t.vlDesc = :vlDesc")
    , @NamedQuery(name = "TmpSpedC870.findByCodCta", query = "SELECT t FROM TmpSpedC870 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC870.findByCodpc", query = "SELECT t FROM TmpSpedC870 t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpSpedC870.findByCodNatCc", query = "SELECT t FROM TmpSpedC870 t WHERE t.codNatCc = :codNatCc")
    , @NamedQuery(name = "TmpSpedC870.findByData", query = "SELECT t FROM TmpSpedC870 t WHERE t.data = :data")})
public class TmpSpedC870 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C870")
    private String codtmpSpedC870;
    @Column(name = "NSERIESAT")
    private String nseriesat;
    @Column(name = "COD_ITEM")
    private String codItem;
    @Column(name = "CODCFOP")
    private String codcfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VL_ITEM")
    private BigDecimal vlItem;
    @Column(name = "CST_PIS")
    private String cstPis;
    @Column(name = "VL_BC_PIS")
    private BigDecimal vlBcPis;
    @Column(name = "ALIQ_PIS")
    private BigDecimal aliqPis;
    @Column(name = "VL_PIS")
    private BigDecimal vlPis;
    @Column(name = "CST_COFINS")
    private String cstCofins;
    @Column(name = "VL_BC_COFINS")
    private BigDecimal vlBcCofins;
    @Column(name = "ALIQ_COFINS")
    private BigDecimal aliqCofins;
    @Column(name = "VL_COFINS")
    private BigDecimal vlCofins;
    @Column(name = "VL_DESC")
    private BigDecimal vlDesc;
    @Column(name = "COD_CTA")
    private String codCta;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "COD_NAT_CC")
    private String codNatCc;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    public TmpSpedC870() {
    }

    public TmpSpedC870(String codtmpSpedC870) {
        this.codtmpSpedC870 = codtmpSpedC870;
    }

    public String getCodtmpSpedC870() {
        return codtmpSpedC870;
    }

    public void setCodtmpSpedC870(String codtmpSpedC870) {
        this.codtmpSpedC870 = codtmpSpedC870;
    }

    public String getNseriesat() {
        return nseriesat;
    }

    public void setNseriesat(String nseriesat) {
        this.nseriesat = nseriesat;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getVlItem() {
        return vlItem;
    }

    public void setVlItem(BigDecimal vlItem) {
        this.vlItem = vlItem;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
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

    public BigDecimal getVlPis() {
        return vlPis;
    }

    public void setVlPis(BigDecimal vlPis) {
        this.vlPis = vlPis;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
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

    public BigDecimal getVlCofins() {
        return vlCofins;
    }

    public void setVlCofins(BigDecimal vlCofins) {
        this.vlCofins = vlCofins;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
    }

    public String getCodCta() {
        return codCta;
    }

    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodNatCc() {
        return codNatCc;
    }

    public void setCodNatCc(String codNatCc) {
        this.codNatCc = codNatCc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC870 != null ? codtmpSpedC870.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC870)) {
            return false;
        }
        TmpSpedC870 other = (TmpSpedC870) object;
        if ((this.codtmpSpedC870 == null && other.codtmpSpedC870 != null) || (this.codtmpSpedC870 != null && !this.codtmpSpedC870.equals(other.codtmpSpedC870))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC870[ codtmpSpedC870=" + codtmpSpedC870 + " ]";
    }
    
}
