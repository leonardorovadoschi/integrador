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
@Table(name = "TMP_SPED_C175", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC175.findAll", query = "SELECT t FROM TmpSpedC175 t")
    , @NamedQuery(name = "TmpSpedC175.findByCodtmpSpedC175", query = "SELECT t FROM TmpSpedC175 t WHERE t.codtmpSpedC175 = :codtmpSpedC175")
    , @NamedQuery(name = "TmpSpedC175.findByCfop", query = "SELECT t FROM TmpSpedC175 t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TmpSpedC175.findByVlOpr", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlOpr = :vlOpr")
    , @NamedQuery(name = "TmpSpedC175.findByVlDesc", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlDesc = :vlDesc")
    , @NamedQuery(name = "TmpSpedC175.findByCstPis", query = "SELECT t FROM TmpSpedC175 t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedC175.findByVlBcPis", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedC175.findByAliqPis", query = "SELECT t FROM TmpSpedC175 t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedC175.findByQuantBcPis", query = "SELECT t FROM TmpSpedC175 t WHERE t.quantBcPis = :quantBcPis")
    , @NamedQuery(name = "TmpSpedC175.findByAliqPisQuant", query = "SELECT t FROM TmpSpedC175 t WHERE t.aliqPisQuant = :aliqPisQuant")
    , @NamedQuery(name = "TmpSpedC175.findByVlPis", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC175.findByCstCofins", query = "SELECT t FROM TmpSpedC175 t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedC175.findByVlBcCofins", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedC175.findByAliqCofins", query = "SELECT t FROM TmpSpedC175 t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedC175.findByQuantBcCofins", query = "SELECT t FROM TmpSpedC175 t WHERE t.quantBcCofins = :quantBcCofins")
    , @NamedQuery(name = "TmpSpedC175.findByAliqCofinsQuant", query = "SELECT t FROM TmpSpedC175 t WHERE t.aliqCofinsQuant = :aliqCofinsQuant")
    , @NamedQuery(name = "TmpSpedC175.findByVlCofins", query = "SELECT t FROM TmpSpedC175 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC175.findByCodCta", query = "SELECT t FROM TmpSpedC175 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC175.findByInfoCompl", query = "SELECT t FROM TmpSpedC175 t WHERE t.infoCompl = :infoCompl")
    , @NamedQuery(name = "TmpSpedC175.findByCodmovenda", query = "SELECT t FROM TmpSpedC175 t WHERE t.codmovenda = :codmovenda")
    , @NamedQuery(name = "TmpSpedC175.findByNumDoc", query = "SELECT t FROM TmpSpedC175 t WHERE t.numDoc = :numDoc")
    , @NamedQuery(name = "TmpSpedC175.findByCodpc", query = "SELECT t FROM TmpSpedC175 t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpSpedC175.findByCodempresa", query = "SELECT t FROM TmpSpedC175 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC175.findBySer", query = "SELECT t FROM TmpSpedC175 t WHERE t.ser = :ser")
    , @NamedQuery(name = "TmpSpedC175.findByCodNatCc", query = "SELECT t FROM TmpSpedC175 t WHERE t.codNatCc = :codNatCc")})
public class TmpSpedC175 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C175")
    private Integer codtmpSpedC175;
    @Column(name = "CFOP")
    private String cfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VL_OPR")
    private BigDecimal vlOpr;
    @Column(name = "VL_DESC")
    private BigDecimal vlDesc;
    @Column(name = "CST_PIS")
    private String cstPis;
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
    @Column(name = "CST_COFINS")
    private String cstCofins;
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
    @Column(name = "INFO_COMPL")
    private String infoCompl;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "NUM_DOC")
    private Integer numDoc;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "SER")
    private String ser;
    @Column(name = "COD_NAT_CC")
    private String codNatCc;

    public TmpSpedC175() {
    }

    public TmpSpedC175(Integer codtmpSpedC175) {
        this.codtmpSpedC175 = codtmpSpedC175;
    }

    public Integer getCodtmpSpedC175() {
        return codtmpSpedC175;
    }

    public void setCodtmpSpedC175(Integer codtmpSpedC175) {
        this.codtmpSpedC175 = codtmpSpedC175;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getVlOpr() {
        return vlOpr;
    }

    public void setVlOpr(BigDecimal vlOpr) {
        this.vlOpr = vlOpr;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
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

    public String getInfoCompl() {
        return infoCompl;
    }

    public void setInfoCompl(String infoCompl) {
        this.infoCompl = infoCompl;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getCodNatCc() {
        return codNatCc;
    }

    public void setCodNatCc(String codNatCc) {
        this.codNatCc = codNatCc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC175 != null ? codtmpSpedC175.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC175)) {
            return false;
        }
        TmpSpedC175 other = (TmpSpedC175) object;
        if ((this.codtmpSpedC175 == null && other.codtmpSpedC175 != null) || (this.codtmpSpedC175 != null && !this.codtmpSpedC175.equals(other.codtmpSpedC175))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC175[ codtmpSpedC175=" + codtmpSpedC175 + " ]";
    }
    
}
