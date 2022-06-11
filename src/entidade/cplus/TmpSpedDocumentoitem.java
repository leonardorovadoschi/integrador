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
@Table(name = "TMP_SPED_DOCUMENTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedDocumentoitem.findAll", query = "SELECT t FROM TmpSpedDocumentoitem t")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCodtmpSpedDocumentoitem", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.codtmpSpedDocumentoitem = :codtmpSpedDocumentoitem")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByNumItem", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.numItem = :numItem")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCodItem", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByDescrCompl", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.descrCompl = :descrCompl")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByQtd", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.qtd = :qtd")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByUnid", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.unid = :unid")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlItem", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlDesc", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlDesc = :vlDesc")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByIndMov", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.indMov = :indMov")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCstIcms", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.cstIcms = :cstIcms")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCfop", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCodNat", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.codNat = :codNat")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlBcIcms", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlBcIcms = :vlBcIcms")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqIcms", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqIcms = :aliqIcms")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlIcms", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlIcms = :vlIcms")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlBcIcmsSt", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlBcIcmsSt = :vlBcIcmsSt")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqSt", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqSt = :aliqSt")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlIcmsSt", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlIcmsSt = :vlIcmsSt")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByIndApur", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.indApur = :indApur")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCstIpi", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.cstIpi = :cstIpi")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCodEnq", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.codEnq = :codEnq")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlBcIpi", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlBcIpi = :vlBcIpi")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqIpi", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqIpi = :aliqIpi")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlIpi", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlIpi = :vlIpi")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCstPis", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlBcPis", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqPis", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByQuantBcPis", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.quantBcPis = :quantBcPis")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqPisQuant", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqPisQuant = :aliqPisQuant")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlPis", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCstCofins", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlBcCofins", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqCofins", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByQuantBcCofins", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.quantBcCofins = :quantBcCofins")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByAliqCofinsQuant", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.aliqCofinsQuant = :aliqCofinsQuant")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByVlCofins", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByCodCta", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByNomeentidade", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "TmpSpedDocumentoitem.findByIdentidade", query = "SELECT t FROM TmpSpedDocumentoitem t WHERE t.identidade = :identidade")})
public class TmpSpedDocumentoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_DOCUMENTOITEM")
    private Integer codtmpSpedDocumentoitem;
    @Column(name = "NUM_ITEM")
    private Integer numItem;
    @Column(name = "COD_ITEM")
    private String codItem;
    @Column(name = "DESCR_COMPL")
    private String descrCompl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTD")
    private BigDecimal qtd;
    @Column(name = "UNID")
    private String unid;
    @Column(name = "VL_ITEM")
    private BigDecimal vlItem;
    @Column(name = "VL_DESC")
    private BigDecimal vlDesc;
    @Column(name = "IND_MOV")
    private Character indMov;
    @Column(name = "CST_ICMS")
    private String cstIcms;
    @Column(name = "CFOP")
    private String cfop;
    @Column(name = "COD_NAT")
    private String codNat;
    @Column(name = "VL_BC_ICMS")
    private BigDecimal vlBcIcms;
    @Column(name = "ALIQ_ICMS")
    private BigDecimal aliqIcms;
    @Column(name = "VL_ICMS")
    private BigDecimal vlIcms;
    @Column(name = "VL_BC_ICMS_ST")
    private BigDecimal vlBcIcmsSt;
    @Column(name = "ALIQ_ST")
    private BigDecimal aliqSt;
    @Column(name = "VL_ICMS_ST")
    private BigDecimal vlIcmsSt;
    @Column(name = "IND_APUR")
    private Character indApur;
    @Column(name = "CST_IPI")
    private String cstIpi;
    @Column(name = "COD_ENQ")
    private String codEnq;
    @Column(name = "VL_BC_IPI")
    private BigDecimal vlBcIpi;
    @Column(name = "ALIQ_IPI")
    private BigDecimal aliqIpi;
    @Column(name = "VL_IPI")
    private BigDecimal vlIpi;
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
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @JoinColumn(name = "CODTMP_SPED_DOCUMENTO", referencedColumnName = "CODTMP_SPED_DOCUMENTO")
    @ManyToOne(optional = false)
    private TmpSpedDocumento codtmpSpedDocumento;

    public TmpSpedDocumentoitem() {
    }

    public TmpSpedDocumentoitem(Integer codtmpSpedDocumentoitem) {
        this.codtmpSpedDocumentoitem = codtmpSpedDocumentoitem;
    }

    public Integer getCodtmpSpedDocumentoitem() {
        return codtmpSpedDocumentoitem;
    }

    public void setCodtmpSpedDocumentoitem(Integer codtmpSpedDocumentoitem) {
        this.codtmpSpedDocumentoitem = codtmpSpedDocumentoitem;
    }

    public Integer getNumItem() {
        return numItem;
    }

    public void setNumItem(Integer numItem) {
        this.numItem = numItem;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getDescrCompl() {
        return descrCompl;
    }

    public void setDescrCompl(String descrCompl) {
        this.descrCompl = descrCompl;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public BigDecimal getVlItem() {
        return vlItem;
    }

    public void setVlItem(BigDecimal vlItem) {
        this.vlItem = vlItem;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
    }

    public Character getIndMov() {
        return indMov;
    }

    public void setIndMov(Character indMov) {
        this.indMov = indMov;
    }

    public String getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCodNat() {
        return codNat;
    }

    public void setCodNat(String codNat) {
        this.codNat = codNat;
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

    public BigDecimal getVlBcIcmsSt() {
        return vlBcIcmsSt;
    }

    public void setVlBcIcmsSt(BigDecimal vlBcIcmsSt) {
        this.vlBcIcmsSt = vlBcIcmsSt;
    }

    public BigDecimal getAliqSt() {
        return aliqSt;
    }

    public void setAliqSt(BigDecimal aliqSt) {
        this.aliqSt = aliqSt;
    }

    public BigDecimal getVlIcmsSt() {
        return vlIcmsSt;
    }

    public void setVlIcmsSt(BigDecimal vlIcmsSt) {
        this.vlIcmsSt = vlIcmsSt;
    }

    public Character getIndApur() {
        return indApur;
    }

    public void setIndApur(Character indApur) {
        this.indApur = indApur;
    }

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public String getCodEnq() {
        return codEnq;
    }

    public void setCodEnq(String codEnq) {
        this.codEnq = codEnq;
    }

    public BigDecimal getVlBcIpi() {
        return vlBcIpi;
    }

    public void setVlBcIpi(BigDecimal vlBcIpi) {
        this.vlBcIpi = vlBcIpi;
    }

    public BigDecimal getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(BigDecimal aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    public BigDecimal getVlIpi() {
        return vlIpi;
    }

    public void setVlIpi(BigDecimal vlIpi) {
        this.vlIpi = vlIpi;
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

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public TmpSpedDocumento getCodtmpSpedDocumento() {
        return codtmpSpedDocumento;
    }

    public void setCodtmpSpedDocumento(TmpSpedDocumento codtmpSpedDocumento) {
        this.codtmpSpedDocumento = codtmpSpedDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedDocumentoitem != null ? codtmpSpedDocumentoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedDocumentoitem)) {
            return false;
        }
        TmpSpedDocumentoitem other = (TmpSpedDocumentoitem) object;
        if ((this.codtmpSpedDocumentoitem == null && other.codtmpSpedDocumentoitem != null) || (this.codtmpSpedDocumentoitem != null && !this.codtmpSpedDocumentoitem.equals(other.codtmpSpedDocumentoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedDocumentoitem[ codtmpSpedDocumentoitem=" + codtmpSpedDocumentoitem + " ]";
    }
    
}
