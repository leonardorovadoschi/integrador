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
@Table(name = "TMP_SPED_0200", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSped0200.findAll", query = "SELECT t FROM TmpSped0200 t")
    , @NamedQuery(name = "TmpSped0200.findByCodtmpSped0200", query = "SELECT t FROM TmpSped0200 t WHERE t.codtmpSped0200 = :codtmpSped0200")
    , @NamedQuery(name = "TmpSped0200.findByCodItem", query = "SELECT t FROM TmpSped0200 t WHERE t.codItem = :codItem")
    , @NamedQuery(name = "TmpSped0200.findByDescrItem", query = "SELECT t FROM TmpSped0200 t WHERE t.descrItem = :descrItem")
    , @NamedQuery(name = "TmpSped0200.findByCodBarra", query = "SELECT t FROM TmpSped0200 t WHERE t.codBarra = :codBarra")
    , @NamedQuery(name = "TmpSped0200.findByCodAntItem", query = "SELECT t FROM TmpSped0200 t WHERE t.codAntItem = :codAntItem")
    , @NamedQuery(name = "TmpSped0200.findByUnidInv", query = "SELECT t FROM TmpSped0200 t WHERE t.unidInv = :unidInv")
    , @NamedQuery(name = "TmpSped0200.findByTipoItem", query = "SELECT t FROM TmpSped0200 t WHERE t.tipoItem = :tipoItem")
    , @NamedQuery(name = "TmpSped0200.findByCodNcm", query = "SELECT t FROM TmpSped0200 t WHERE t.codNcm = :codNcm")
    , @NamedQuery(name = "TmpSped0200.findByExIpi", query = "SELECT t FROM TmpSped0200 t WHERE t.exIpi = :exIpi")
    , @NamedQuery(name = "TmpSped0200.findByCodGen", query = "SELECT t FROM TmpSped0200 t WHERE t.codGen = :codGen")
    , @NamedQuery(name = "TmpSped0200.findByCodLst", query = "SELECT t FROM TmpSped0200 t WHERE t.codLst = :codLst")
    , @NamedQuery(name = "TmpSped0200.findByAliqIcms", query = "SELECT t FROM TmpSped0200 t WHERE t.aliqIcms = :aliqIcms")
    , @NamedQuery(name = "TmpSped0200.findByCodProd", query = "SELECT t FROM TmpSped0200 t WHERE t.codProd = :codProd")})
public class TmpSped0200 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_0200")
    private Integer codtmpSped0200;
    @Column(name = "COD_ITEM")
    private String codItem;
    @Column(name = "DESCR_ITEM")
    private String descrItem;
    @Column(name = "COD_BARRA")
    private String codBarra;
    @Column(name = "COD_ANT_ITEM")
    private String codAntItem;
    @Column(name = "UNID_INV")
    private String unidInv;
    @Column(name = "TIPO_ITEM")
    private String tipoItem;
    @Column(name = "COD_NCM")
    private String codNcm;
    @Column(name = "EX_IPI")
    private String exIpi;
    @Column(name = "COD_GEN")
    private String codGen;
    @Column(name = "COD_LST")
    private Integer codLst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQ_ICMS")
    private BigDecimal aliqIcms;
    @Column(name = "COD_PROD")
    private String codProd;

    public TmpSped0200() {
    }

    public TmpSped0200(Integer codtmpSped0200) {
        this.codtmpSped0200 = codtmpSped0200;
    }

    public Integer getCodtmpSped0200() {
        return codtmpSped0200;
    }

    public void setCodtmpSped0200(Integer codtmpSped0200) {
        this.codtmpSped0200 = codtmpSped0200;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    public String getDescrItem() {
        return descrItem;
    }

    public void setDescrItem(String descrItem) {
        this.descrItem = descrItem;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getCodAntItem() {
        return codAntItem;
    }

    public void setCodAntItem(String codAntItem) {
        this.codAntItem = codAntItem;
    }

    public String getUnidInv() {
        return unidInv;
    }

    public void setUnidInv(String unidInv) {
        this.unidInv = unidInv;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getCodNcm() {
        return codNcm;
    }

    public void setCodNcm(String codNcm) {
        this.codNcm = codNcm;
    }

    public String getExIpi() {
        return exIpi;
    }

    public void setExIpi(String exIpi) {
        this.exIpi = exIpi;
    }

    public String getCodGen() {
        return codGen;
    }

    public void setCodGen(String codGen) {
        this.codGen = codGen;
    }

    public Integer getCodLst() {
        return codLst;
    }

    public void setCodLst(Integer codLst) {
        this.codLst = codLst;
    }

    public BigDecimal getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSped0200 != null ? codtmpSped0200.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSped0200)) {
            return false;
        }
        TmpSped0200 other = (TmpSped0200) object;
        if ((this.codtmpSped0200 == null && other.codtmpSped0200 != null) || (this.codtmpSped0200 != null && !this.codtmpSped0200.equals(other.codtmpSped0200))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSped0200[ codtmpSped0200=" + codtmpSped0200 + " ]";
    }
    
}
