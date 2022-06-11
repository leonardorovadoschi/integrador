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
@Table(name = "TMP_WMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpWms.findAll", query = "SELECT t FROM TmpWms t")
    , @NamedQuery(name = "TmpWms.findByCodprod", query = "SELECT t FROM TmpWms t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "TmpWms.findByMedia", query = "SELECT t FROM TmpWms t WHERE t.media = :media")})
public class TmpWms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MEDIA")
    private BigDecimal media;

    public TmpWms() {
    }

    public TmpWms(String codprod) {
        this.codprod = codprod;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpWms)) {
            return false;
        }
        TmpWms other = (TmpWms) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpWms[ codprod=" + codprod + " ]";
    }
    
}
