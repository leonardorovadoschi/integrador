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
@Table(name = "TMP_SPED_C170", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC170.findAll", query = "SELECT t FROM TmpSpedC170 t")
    , @NamedQuery(name = "TmpSpedC170.findByCodtmpSpedC170", query = "SELECT t FROM TmpSpedC170 t WHERE t.codtmpSpedC170 = :codtmpSpedC170")
    , @NamedQuery(name = "TmpSpedC170.findByNumItem", query = "SELECT t FROM TmpSpedC170 t WHERE t.numItem = :numItem")
    , @NamedQuery(name = "TmpSpedC170.findByCodItem", query = "SELECT t FROM TmpSpedC170 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC170.findByDescrCompl", query = "SELECT t FROM TmpSpedC170 t WHERE t.descrCompl = :descrCompl")
    , @NamedQuery(name = "TmpSpedC170.findByQtd", query = "SELECT t FROM TmpSpedC170 t WHERE t.qtd = :qtd")
    , @NamedQuery(name = "TmpSpedC170.findByUnid", query = "SELECT t FROM TmpSpedC170 t WHERE t.unid = :unid")
    , @NamedQuery(name = "TmpSpedC170.findByVlItem", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC170.findByVlDesc", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlDesc = :vlDesc")
    , @NamedQuery(name = "TmpSpedC170.findByIndMov", query = "SELECT t FROM TmpSpedC170 t WHERE t.indMov = :indMov")
    , @NamedQuery(name = "TmpSpedC170.findByCstIcms", query = "SELECT t FROM TmpSpedC170 t WHERE t.cstIcms = :cstIcms")
    , @NamedQuery(name = "TmpSpedC170.findByCfop", query = "SELECT t FROM TmpSpedC170 t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TmpSpedC170.findByCodNat", query = "SELECT t FROM TmpSpedC170 t WHERE t.codNat = :codNat")
    , @NamedQuery(name = "TmpSpedC170.findByVlBcIcms", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlBcIcms = :vlBcIcms")
    , @NamedQuery(name = "TmpSpedC170.findByAliqIcms", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqIcms = :aliqIcms")
    , @NamedQuery(name = "TmpSpedC170.findByVlIcms", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlIcms = :vlIcms")
    , @NamedQuery(name = "TmpSpedC170.findByVlBcIcmsSt", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlBcIcmsSt = :vlBcIcmsSt")
    , @NamedQuery(name = "TmpSpedC170.findByAliqSt", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqSt = :aliqSt")
    , @NamedQuery(name = "TmpSpedC170.findByVlIcmsSt", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlIcmsSt = :vlIcmsSt")
    , @NamedQuery(name = "TmpSpedC170.findByIndApur", query = "SELECT t FROM TmpSpedC170 t WHERE t.indApur = :indApur")
    , @NamedQuery(name = "TmpSpedC170.findByCstIpi", query = "SELECT t FROM TmpSpedC170 t WHERE t.cstIpi = :cstIpi")
    , @NamedQuery(name = "TmpSpedC170.findByCodEnq", query = "SELECT t FROM TmpSpedC170 t WHERE t.codEnq = :codEnq")
    , @NamedQuery(name = "TmpSpedC170.findByVlBcIpi", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlBcIpi = :vlBcIpi")
    , @NamedQuery(name = "TmpSpedC170.findByAliqIpi", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqIpi = :aliqIpi")
    , @NamedQuery(name = "TmpSpedC170.findByVlIpi", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlIpi = :vlIpi")
    , @NamedQuery(name = "TmpSpedC170.findByCstPis", query = "SELECT t FROM TmpSpedC170 t WHERE t.cstPis = :cstPis")
    , @NamedQuery(name = "TmpSpedC170.findByVlBcPis", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlBcPis = :vlBcPis")
    , @NamedQuery(name = "TmpSpedC170.findByAliqPis", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqPis = :aliqPis")
    , @NamedQuery(name = "TmpSpedC170.findByQuantBcPis", query = "SELECT t FROM TmpSpedC170 t WHERE t.quantBcPis = :quantBcPis")
    , @NamedQuery(name = "TmpSpedC170.findByAliqPisQuant", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqPisQuant = :aliqPisQuant")
    , @NamedQuery(name = "TmpSpedC170.findByVlPis", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC170.findByCstCofins", query = "SELECT t FROM TmpSpedC170 t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedC170.findByVlBcCofins", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedC170.findByAliqCofins", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedC170.findByQuantBcCofins", query = "SELECT t FROM TmpSpedC170 t WHERE t.quantBcCofins = :quantBcCofins")
    , @NamedQuery(name = "TmpSpedC170.findByAliqCofinsQuant", query = "SELECT t FROM TmpSpedC170 t WHERE t.aliqCofinsQuant = :aliqCofinsQuant")
    , @NamedQuery(name = "TmpSpedC170.findByVlCofins", query = "SELECT t FROM TmpSpedC170 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC170.findByCodCta", query = "SELECT t FROM TmpSpedC170 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC170.findByCodempresa", query = "SELECT t FROM TmpSpedC170 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC170.findByNomeentidade", query = "SELECT t FROM TmpSpedC170 t WHERE t.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "TmpSpedC170.findByIdentidade", query = "SELECT t FROM TmpSpedC170 t WHERE t.identidade = :identidade")
    , @NamedQuery(name = "TmpSpedC170.findByCodigoItem", query = "SELECT t FROM TmpSpedC170 t WHERE t.codigoItem = :codigoItem")
    , @NamedQuery(name = "TmpSpedC170.findByCodpc", query = "SELECT t FROM TmpSpedC170 t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpSpedC170.findByCodNatCc", query = "SELECT t FROM TmpSpedC170 t WHERE t.codNatCc = :codNatCc")})
public class TmpSpedC170 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C170")
    private Integer codtmpSpedC170;
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
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "CODIGO_ITEM")
    private String codigoItem;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "COD_NAT_CC")
    private String codNatCc;

    public TmpSpedC170() {
    }

    public TmpSpedC170(Integer codtmpSpedC170) {
        this.codtmpSpedC170 = codtmpSpedC170;
    }

    public Integer getCodtmpSpedC170() {
        return codtmpSpedC170;
    }

    public void setCodtmpSpedC170(Integer codtmpSpedC170) {
        this.codtmpSpedC170 = codtmpSpedC170;
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

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
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

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC170 != null ? codtmpSpedC170.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC170)) {
            return false;
        }
        TmpSpedC170 other = (TmpSpedC170) object;
        if ((this.codtmpSpedC170 == null && other.codtmpSpedC170 != null) || (this.codtmpSpedC170 != null && !this.codtmpSpedC170.equals(other.codtmpSpedC170))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC170[ codtmpSpedC170=" + codtmpSpedC170 + " ]";
    }
    
}
