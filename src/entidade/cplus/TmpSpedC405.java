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
@Table(name = "TMP_SPED_C405", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC405.findAll", query = "SELECT t FROM TmpSpedC405 t")
    , @NamedQuery(name = "TmpSpedC405.findByCodtmpSpedC405", query = "SELECT t FROM TmpSpedC405 t WHERE t.codtmpSpedC405 = :codtmpSpedC405")
    , @NamedQuery(name = "TmpSpedC405.findByDtDoc", query = "SELECT t FROM TmpSpedC405 t WHERE t.dtDoc = :dtDoc")
    , @NamedQuery(name = "TmpSpedC405.findByCro", query = "SELECT t FROM TmpSpedC405 t WHERE t.cro = :cro")
    , @NamedQuery(name = "TmpSpedC405.findByCrz", query = "SELECT t FROM TmpSpedC405 t WHERE t.crz = :crz")
    , @NamedQuery(name = "TmpSpedC405.findByNumCooFin", query = "SELECT t FROM TmpSpedC405 t WHERE t.numCooFin = :numCooFin")
    , @NamedQuery(name = "TmpSpedC405.findByGtFin", query = "SELECT t FROM TmpSpedC405 t WHERE t.gtFin = :gtFin")
    , @NamedQuery(name = "TmpSpedC405.findByVlBrt", query = "SELECT t FROM TmpSpedC405 t WHERE t.vlBrt = :vlBrt")
    , @NamedQuery(name = "TmpSpedC405.findByCodempresa", query = "SELECT t FROM TmpSpedC405 t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpSpedC405.findByNumeroserie", query = "SELECT t FROM TmpSpedC405 t WHERE t.numeroserie = :numeroserie")})
public class TmpSpedC405 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C405")
    private Integer codtmpSpedC405;
    @Basic(optional = false)
    @Column(name = "DT_DOC")
    @Temporal(TemporalType.DATE)
    private Date dtDoc;
    @Basic(optional = false)
    @Column(name = "CRO")
    private int cro;
    @Basic(optional = false)
    @Column(name = "CRZ")
    private int crz;
    @Basic(optional = false)
    @Column(name = "NUM_COO_FIN")
    private int numCooFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "GT_FIN")
    private BigDecimal gtFin;
    @Basic(optional = false)
    @Column(name = "VL_BRT")
    private BigDecimal vlBrt;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "NUMEROSERIE")
    private String numeroserie;

    public TmpSpedC405() {
    }

    public TmpSpedC405(Integer codtmpSpedC405) {
        this.codtmpSpedC405 = codtmpSpedC405;
    }

    public TmpSpedC405(Integer codtmpSpedC405, Date dtDoc, int cro, int crz, int numCooFin, BigDecimal gtFin, BigDecimal vlBrt, int codempresa, String numeroserie) {
        this.codtmpSpedC405 = codtmpSpedC405;
        this.dtDoc = dtDoc;
        this.cro = cro;
        this.crz = crz;
        this.numCooFin = numCooFin;
        this.gtFin = gtFin;
        this.vlBrt = vlBrt;
        this.codempresa = codempresa;
        this.numeroserie = numeroserie;
    }

    public Integer getCodtmpSpedC405() {
        return codtmpSpedC405;
    }

    public void setCodtmpSpedC405(Integer codtmpSpedC405) {
        this.codtmpSpedC405 = codtmpSpedC405;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public int getCro() {
        return cro;
    }

    public void setCro(int cro) {
        this.cro = cro;
    }

    public int getCrz() {
        return crz;
    }

    public void setCrz(int crz) {
        this.crz = crz;
    }

    public int getNumCooFin() {
        return numCooFin;
    }

    public void setNumCooFin(int numCooFin) {
        this.numCooFin = numCooFin;
    }

    public BigDecimal getGtFin() {
        return gtFin;
    }

    public void setGtFin(BigDecimal gtFin) {
        this.gtFin = gtFin;
    }

    public BigDecimal getVlBrt() {
        return vlBrt;
    }

    public void setVlBrt(BigDecimal vlBrt) {
        this.vlBrt = vlBrt;
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
        hash += (codtmpSpedC405 != null ? codtmpSpedC405.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC405)) {
            return false;
        }
        TmpSpedC405 other = (TmpSpedC405) object;
        if ((this.codtmpSpedC405 == null && other.codtmpSpedC405 != null) || (this.codtmpSpedC405 != null && !this.codtmpSpedC405.equals(other.codtmpSpedC405))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC405[ codtmpSpedC405=" + codtmpSpedC405 + " ]";
    }
    
}
