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
@Table(name = "TMP_SPED_C481", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC481.findAll", query = "SELECT t FROM TmpSpedC481 t")
    , @NamedQuery(name = "TmpSpedC481.findByCodtmpSpedC481", query = "SELECT t FROM TmpSpedC481 t WHERE t.codtmpSpedC481 = :codtmpSpedC481")
    , @NamedQuery(name = "TmpSpedC481.findByCstPis", query = "SELECT t FROM TmpSpedC481 t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedC481.findByVlItem", query = "SELECT t FROM TmpSpedC481 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC481.findByVlBcPis", query = "SELECT t FROM TmpSpedC481 t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedC481.findByAliqPis", query = "SELECT t FROM TmpSpedC481 t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedC481.findByQuantBcPis", query = "SELECT t FROM TmpSpedC481 t WHERE t.quantBcPis = :quantBcPis")
    , @NamedQuery(name = "TmpSpedC481.findByAliqPisQuant", query = "SELECT t FROM TmpSpedC481 t WHERE t.aliqPisQuant = :aliqPisQuant")
    , @NamedQuery(name = "TmpSpedC481.findByVlPis", query = "SELECT t FROM TmpSpedC481 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC481.findByCodItem", query = "SELECT t FROM TmpSpedC481 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC481.findByCodCta", query = "SELECT t FROM TmpSpedC481 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC481.findByCodempresa", query = "SELECT t FROM TmpSpedC481 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC481.findByNumeroserie", query = "SELECT t FROM TmpSpedC481 t WHERE t.numeroserie = :numeroserie")
    , @NamedQuery(name = "TmpSpedC481.findByDtDoc", query = "SELECT t FROM TmpSpedC481 t WHERE t.dtDoc = :dtDoc")
    , @NamedQuery(name = "TmpSpedC481.findByCodItemSeq", query = "SELECT t FROM TmpSpedC481 t WHERE t.codItemSeq = :codItemSeq")
    , @NamedQuery(name = "TmpSpedC481.findByVlBcIcms", query = "SELECT t FROM TmpSpedC481 t WHERE t.vlBcIcms = :vlBcIcms")
    , @NamedQuery(name = "TmpSpedC481.findByAliqIcms", query = "SELECT t FROM TmpSpedC481 t WHERE t.aliqIcms = :aliqIcms")
    , @NamedQuery(name = "TmpSpedC481.findByVlIcms", query = "SELECT t FROM TmpSpedC481 t WHERE t.vlIcms = :vlIcms")
    , @NamedQuery(name = "TmpSpedC481.findByCodCfop", query = "SELECT t FROM TmpSpedC481 t WHERE t.codCfop = :codCfop")
    , @NamedQuery(name = "TmpSpedC481.findByCodpc", query = "SELECT t FROM TmpSpedC481 t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpSpedC481.findByEntidadeorigem", query = "SELECT t FROM TmpSpedC481 t WHERE t.entidadeorigem = :entidadeorigem")
    , @NamedQuery(name = "TmpSpedC481.findByIdentidadeorigem", query = "SELECT t FROM TmpSpedC481 t WHERE t.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "TmpSpedC481.findByCodNatCc", query = "SELECT t FROM TmpSpedC481 t WHERE t.codNatCc = :codNatCc")})
public class TmpSpedC481 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C481")
    private Integer codtmpSpedC481;
    @Column(name = "CST_PIS")
    private String cstPis;
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
    @Column(name = "COD_ITEM")
    private String codItem;
    @Column(name = "COD_CTA")
    private String codCta;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "DT_DOC")
    @Temporal(TemporalType.DATE)
    private Date dtDoc;
    @Column(name = "COD_ITEM_SEQ")
    private String codItemSeq;
    @Column(name = "VL_BC_ICMS")
    private BigDecimal vlBcIcms;
    @Column(name = "ALIQ_ICMS")
    private BigDecimal aliqIcms;
    @Column(name = "VL_ICMS")
    private BigDecimal vlIcms;
    @Column(name = "COD_CFOP")
    private String codCfop;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "ENTIDADEORIGEM")
    private String entidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "COD_NAT_CC")
    private String codNatCc;

    public TmpSpedC481() {
    }

    public TmpSpedC481(Integer codtmpSpedC481) {
        this.codtmpSpedC481 = codtmpSpedC481;
    }

    public TmpSpedC481(Integer codtmpSpedC481, BigDecimal vlItem) {
        this.codtmpSpedC481 = codtmpSpedC481;
        this.vlItem = vlItem;
    }

    public Integer getCodtmpSpedC481() {
        return codtmpSpedC481;
    }

    public void setCodtmpSpedC481(Integer codtmpSpedC481) {
        this.codtmpSpedC481 = codtmpSpedC481;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
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

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getCodCta() {
        return codCta;
    }

    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public String getCodItemSeq() {
        return codItemSeq;
    }

    public void setCodItemSeq(String codItemSeq) {
        this.codItemSeq = codItemSeq;
    }

    public BigDecimal getVlBcIcms() {
        return vlBcIcms;
    }

    public void setVlBcIcms(BigDecimal vlBcIcms) {
        this.vlBcIcms = vlBcIcms;
    }

    public BigDecimal getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public BigDecimal getVlIcms() {
        return vlIcms;
    }

    public void setVlIcms(BigDecimal vlIcms) {
        this.vlIcms = vlIcms;
    }

    public String getCodCfop() {
        return codCfop;
    }

    public void setCodCfop(String codCfop) {
        this.codCfop = codCfop;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getEntidadeorigem() {
        return entidadeorigem;
    }

    public void setEntidadeorigem(String entidadeorigem) {
        this.entidadeorigem = entidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
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
        hash += (codtmpSpedC481 != null ? codtmpSpedC481.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC481)) {
            return false;
        }
        TmpSpedC481 other = (TmpSpedC481) object;
        if ((this.codtmpSpedC481 == null && other.codtmpSpedC481 != null) || (this.codtmpSpedC481 != null && !this.codtmpSpedC481.equals(other.codtmpSpedC481))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC481[ codtmpSpedC481=" + codtmpSpedC481 + " ]";
    }
    
}
