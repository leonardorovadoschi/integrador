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
@Table(name = "TMP_SPED_C100", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC100.findAll", query = "SELECT t FROM TmpSpedC100 t")
    , @NamedQuery(name = "TmpSpedC100.findByCodtmpSpedC100", query = "SELECT t FROM TmpSpedC100 t WHERE t.codtmpSpedC100 = :codtmpSpedC100")
    , @NamedQuery(name = "TmpSpedC100.findByIndOper", query = "SELECT t FROM TmpSpedC100 t WHERE t.indOper = :indOper")
    , @NamedQuery(name = "TmpSpedC100.findByIndEmit", query = "SELECT t FROM TmpSpedC100 t WHERE t.indEmit = :indEmit")
    , @NamedQuery(name = "TmpSpedC100.findByCodPart", query = "SELECT t FROM TmpSpedC100 t WHERE t.codPart = :codPart")
    , @NamedQuery(name = "TmpSpedC100.findByCodMod", query = "SELECT t FROM TmpSpedC100 t WHERE t.codMod = :codMod")
    , @NamedQuery(name = "TmpSpedC100.findByCodSit", query = "SELECT t FROM TmpSpedC100 t WHERE t.codSit = :codSit")
    , @NamedQuery(name = "TmpSpedC100.findBySer", query = "SELECT t FROM TmpSpedC100 t WHERE t.ser = :ser")
    , @NamedQuery(name = "TmpSpedC100.findByNumDoc", query = "SELECT t FROM TmpSpedC100 t WHERE t.numDoc = :numDoc")
    , @NamedQuery(name = "TmpSpedC100.findByChvNfe", query = "SELECT t FROM TmpSpedC100 t WHERE t.chvNfe = :chvNfe")
    , @NamedQuery(name = "TmpSpedC100.findByDtDoc", query = "SELECT t FROM TmpSpedC100 t WHERE t.dtDoc = :dtDoc")
    , @NamedQuery(name = "TmpSpedC100.findByDtES", query = "SELECT t FROM TmpSpedC100 t WHERE t.dtES = :dtES")
    , @NamedQuery(name = "TmpSpedC100.findByVlDoc", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlDoc = :vlDoc")
    , @NamedQuery(name = "TmpSpedC100.findByIndPgto", query = "SELECT t FROM TmpSpedC100 t WHERE t.indPgto = :indPgto")
    , @NamedQuery(name = "TmpSpedC100.findByVlDesc", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlDesc = :vlDesc")
    , @NamedQuery(name = "TmpSpedC100.findByVlAbatNt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlAbatNt = :vlAbatNt")
    , @NamedQuery(name = "TmpSpedC100.findByVlMerc", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlMerc = :vlMerc")
    , @NamedQuery(name = "TmpSpedC100.findByIndFrt", query = "SELECT t FROM TmpSpedC100 t WHERE t.indFrt = :indFrt")
    , @NamedQuery(name = "TmpSpedC100.findByVlFrt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlFrt = :vlFrt")
    , @NamedQuery(name = "TmpSpedC100.findByVlSeg", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlSeg = :vlSeg")
    , @NamedQuery(name = "TmpSpedC100.findByVlOutDa", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlOutDa = :vlOutDa")
    , @NamedQuery(name = "TmpSpedC100.findByVlBcIcms", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlBcIcms = :vlBcIcms")
    , @NamedQuery(name = "TmpSpedC100.findByVlIcms", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlIcms = :vlIcms")
    , @NamedQuery(name = "TmpSpedC100.findByVlBcIcmsSt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlBcIcmsSt = :vlBcIcmsSt")
    , @NamedQuery(name = "TmpSpedC100.findByVlIcmsSt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlIcmsSt = :vlIcmsSt")
    , @NamedQuery(name = "TmpSpedC100.findByVlIpi", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlIpi = :vlIpi")
    , @NamedQuery(name = "TmpSpedC100.findByVlPis", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlPis = :vlPis")
    , @NamedQuery(name = "TmpSpedC100.findByVlCofins", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlCofins = :vlCofins")
    , @NamedQuery(name = "TmpSpedC100.findByVlPisSt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlPisSt = :vlPisSt")
    , @NamedQuery(name = "TmpSpedC100.findByVlCofinsSt", query = "SELECT t FROM TmpSpedC100 t WHERE t.vlCofinsSt = :vlCofinsSt")
    , @NamedQuery(name = "TmpSpedC100.findByCodempresa", query = "SELECT t FROM TmpSpedC100 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC100.findByNomeentidade", query = "SELECT t FROM TmpSpedC100 t WHERE t.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "TmpSpedC100.findByIdentidade", query = "SELECT t FROM TmpSpedC100 t WHERE t.identidade = :identidade")})
public class TmpSpedC100 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C100")
    private Integer codtmpSpedC100;
    @Column(name = "IND_OPER")
    private Character indOper;
    @Column(name = "IND_EMIT")
    private Character indEmit;
    @Column(name = "COD_PART")
    private String codPart;
    @Column(name = "COD_MOD")
    private String codMod;
    @Column(name = "COD_SIT")
    private String codSit;
    @Column(name = "SER")
    private String ser;
    @Column(name = "NUM_DOC")
    private Integer numDoc;
    @Column(name = "CHV_NFE")
    private String chvNfe;
    @Column(name = "DT_DOC")
    @Temporal(TemporalType.DATE)
    private Date dtDoc;
    @Column(name = "DT_E_S")
    @Temporal(TemporalType.DATE)
    private Date dtES;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VL_DOC")
    private BigDecimal vlDoc;
    @Column(name = "IND_PGTO")
    private Character indPgto;
    @Column(name = "VL_DESC")
    private BigDecimal vlDesc;
    @Column(name = "VL_ABAT_NT")
    private BigDecimal vlAbatNt;
    @Column(name = "VL_MERC")
    private BigDecimal vlMerc;
    @Column(name = "IND_FRT")
    private Character indFrt;
    @Column(name = "VL_FRT")
    private BigDecimal vlFrt;
    @Column(name = "VL_SEG")
    private BigDecimal vlSeg;
    @Column(name = "VL_OUT_DA")
    private BigDecimal vlOutDa;
    @Column(name = "VL_BC_ICMS")
    private BigDecimal vlBcIcms;
    @Column(name = "VL_ICMS")
    private BigDecimal vlIcms;
    @Column(name = "VL_BC_ICMS_ST")
    private BigDecimal vlBcIcmsSt;
    @Column(name = "VL_ICMS_ST")
    private BigDecimal vlIcmsSt;
    @Column(name = "VL_IPI")
    private BigDecimal vlIpi;
    @Column(name = "VL_PIS")
    private BigDecimal vlPis;
    @Column(name = "VL_COFINS")
    private BigDecimal vlCofins;
    @Column(name = "VL_PIS_ST")
    private BigDecimal vlPisSt;
    @Column(name = "VL_COFINS_ST")
    private BigDecimal vlCofinsSt;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "IDENTIDADE")
    private String identidade;

    public TmpSpedC100() {
    }

    public TmpSpedC100(Integer codtmpSpedC100) {
        this.codtmpSpedC100 = codtmpSpedC100;
    }

    public Integer getCodtmpSpedC100() {
        return codtmpSpedC100;
    }

    public void setCodtmpSpedC100(Integer codtmpSpedC100) {
        this.codtmpSpedC100 = codtmpSpedC100;
    }

    public Character getIndOper() {
        return indOper;
    }

    public void setIndOper(Character indOper) {
        this.indOper = indOper;
    }

    public Character getIndEmit() {
        return indEmit;
    }

    public void setIndEmit(Character indEmit) {
        this.indEmit = indEmit;
    }

    public String getCodPart() {
        return codPart;
    }

    public void setCodPart(String codPart) {
        this.codPart = codPart;
    }

    public String getCodMod() {
        return codMod;
    }

    public void setCodMod(String codMod) {
        this.codMod = codMod;
    }

    public String getCodSit() {
        return codSit;
    }

    public void setCodSit(String codSit) {
        this.codSit = codSit;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getChvNfe() {
        return chvNfe;
    }

    public void setChvNfe(String chvNfe) {
        this.chvNfe = chvNfe;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public Date getDtES() {
        return dtES;
    }

    public void setDtES(Date dtES) {
        this.dtES = dtES;
    }

    public BigDecimal getVlDoc() {
        return vlDoc;
    }

    public void setVlDoc(BigDecimal vlDoc) {
        this.vlDoc = vlDoc;
    }

    public Character getIndPgto() {
        return indPgto;
    }

    public void setIndPgto(Character indPgto) {
        this.indPgto = indPgto;
    }

    public BigDecimal getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(BigDecimal vlDesc) {
        this.vlDesc = vlDesc;
    }

    public BigDecimal getVlAbatNt() {
        return vlAbatNt;
    }

    public void setVlAbatNt(BigDecimal vlAbatNt) {
        this.vlAbatNt = vlAbatNt;
    }

    public BigDecimal getVlMerc() {
        return vlMerc;
    }

    public void setVlMerc(BigDecimal vlMerc) {
        this.vlMerc = vlMerc;
    }

    public Character getIndFrt() {
        return indFrt;
    }

    public void setIndFrt(Character indFrt) {
        this.indFrt = indFrt;
    }

    public BigDecimal getVlFrt() {
        return vlFrt;
    }

    public void setVlFrt(BigDecimal vlFrt) {
        this.vlFrt = vlFrt;
    }

    public BigDecimal getVlSeg() {
        return vlSeg;
    }

    public void setVlSeg(BigDecimal vlSeg) {
        this.vlSeg = vlSeg;
    }

    public BigDecimal getVlOutDa() {
        return vlOutDa;
    }

    public void setVlOutDa(BigDecimal vlOutDa) {
        this.vlOutDa = vlOutDa;
    }

    public BigDecimal getVlBcIcms() {
        return vlBcIcms;
    }

    public void setVlBcIcms(BigDecimal vlBcIcms) {
        this.vlBcIcms = vlBcIcms;
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

    public BigDecimal getVlIcmsSt() {
        return vlIcmsSt;
    }

    public void setVlIcmsSt(BigDecimal vlIcmsSt) {
        this.vlIcmsSt = vlIcmsSt;
    }

    public BigDecimal getVlIpi() {
        return vlIpi;
    }

    public void setVlIpi(BigDecimal vlIpi) {
        this.vlIpi = vlIpi;
    }

    public BigDecimal getVlPis() {
        return vlPis;
    }

    public void setVlPis(BigDecimal vlPis) {
        this.vlPis = vlPis;
    }

    public BigDecimal getVlCofins() {
        return vlCofins;
    }

    public void setVlCofins(BigDecimal vlCofins) {
        this.vlCofins = vlCofins;
    }

    public BigDecimal getVlPisSt() {
        return vlPisSt;
    }

    public void setVlPisSt(BigDecimal vlPisSt) {
        this.vlPisSt = vlPisSt;
    }

    public BigDecimal getVlCofinsSt() {
        return vlCofinsSt;
    }

    public void setVlCofinsSt(BigDecimal vlCofinsSt) {
        this.vlCofinsSt = vlCofinsSt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC100 != null ? codtmpSpedC100.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC100)) {
            return false;
        }
        TmpSpedC100 other = (TmpSpedC100) object;
        if ((this.codtmpSpedC100 == null && other.codtmpSpedC100 != null) || (this.codtmpSpedC100 != null && !this.codtmpSpedC100.equals(other.codtmpSpedC100))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC100[ codtmpSpedC100=" + codtmpSpedC100 + " ]";
    }
    
}
