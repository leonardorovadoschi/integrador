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
@Table(name = "TMP_SPED_C485", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC485.findAll", query = "SELECT t FROM TmpSpedC485 t")
    , @NamedQuery(name = "TmpSpedC485.findByCodtmpSpedC485", query = "SELECT t FROM TmpSpedC485 t WHERE t.codtmpSpedC485 = :codtmpSpedC485")
    , @NamedQuery(name = "TmpSpedC485.findByCstCofins", query = "SELECT t FROM TmpSpedC485 t WHERE t.cstCofins = :cstCofins")
    , @NamedQuery(name = "TmpSpedC485.findByVlItem", query = "SELECT t FROM TmpSpedC485 t WHERE t.vlItem = :vlItem")
    , @NamedQuery(name = "TmpSpedC485.findByVlBcCofins", query = "SELECT t FROM TmpSpedC485 t WHERE t.vlBcCofins = :vlBcCofins")
    , @NamedQuery(name = "TmpSpedC485.findByAliqCofins", query = "SELECT t FROM TmpSpedC485 t WHERE t.aliqCofins = :aliqCofins")
    , @NamedQuery(name = "TmpSpedC485.findByQuantBcCofins", query = "SELECT t FROM TmpSpedC485 t WHERE t.quantBcCofins = :quantBcCofins")
    , @NamedQuery(name = "TmpSpedC485.findByAliqCofinsQuant", query = "SELECT t FROM TmpSpedC485 t WHERE t.aliqCofinsQuant = :aliqCofinsQuant")
    , @NamedQuery(name = "TmpSpedC485.findByVlCofins", query = "SELECT t FROM TmpSpedC485 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC485.findByCodItem", query = "SELECT t FROM TmpSpedC485 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSpedC485.findByCodCta", query = "SELECT t FROM TmpSpedC485 t WHERE t.codCta = :codCta")
    , @NamedQuery(name = "TmpSpedC485.findByCodempresa", query = "SELECT t FROM TmpSpedC485 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC485.findByNumeroserie", query = "SELECT t FROM TmpSpedC485 t WHERE t.numeroserie = :numeroserie")
    , @NamedQuery(name = "TmpSpedC485.findByDtDoc", query = "SELECT t FROM TmpSpedC485 t WHERE t.dtDoc = :dtDoc")
    , @NamedQuery(name = "TmpSpedC485.findByCodItemSeq", query = "SELECT t FROM TmpSpedC485 t WHERE t.codItemSeq = :codItemSeq")
    , @NamedQuery(name = "TmpSpedC485.findByCodCfop", query = "SELECT t FROM TmpSpedC485 t WHERE t.codCfop = :codCfop")
    , @NamedQuery(name = "TmpSpedC485.findByCodpc", query = "SELECT t FROM TmpSpedC485 t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpSpedC485.findByEntidadeorigem", query = "SELECT t FROM TmpSpedC485 t WHERE t.entidadeorigem = :entidadeorigem")
    , @NamedQuery(name = "TmpSpedC485.findByIdentidadeorigem", query = "SELECT t FROM TmpSpedC485 t WHERE t.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "TmpSpedC485.findByCodNatCc", query = "SELECT t FROM TmpSpedC485 t WHERE t.codNatCc = :codNatCc")})
public class TmpSpedC485 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C485")
    private Integer codtmpSpedC485;
    @Column(name = "CST_COFINS")
    private String cstCofins;
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

    public TmpSpedC485() {
    }

    public TmpSpedC485(Integer codtmpSpedC485) {
        this.codtmpSpedC485 = codtmpSpedC485;
    }

    public TmpSpedC485(Integer codtmpSpedC485, BigDecimal vlItem) {
        this.codtmpSpedC485 = codtmpSpedC485;
        this.vlItem = vlItem;
    }

    public Integer getCodtmpSpedC485() {
        return codtmpSpedC485;
    }

    public void setCodtmpSpedC485(Integer codtmpSpedC485) {
        this.codtmpSpedC485 = codtmpSpedC485;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
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
        hash += (codtmpSpedC485 != null ? codtmpSpedC485.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC485)) {
            return false;
        }
        TmpSpedC485 other = (TmpSpedC485) object;
        if ((this.codtmpSpedC485 == null && other.codtmpSpedC485 != null) || (this.codtmpSpedC485 != null && !this.codtmpSpedC485.equals(other.codtmpSpedC485))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC485[ codtmpSpedC485=" + codtmpSpedC485 + " ]";
    }
    
}
