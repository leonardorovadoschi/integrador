/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ps_tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTax.findAll", query = "SELECT p FROM PsTax p")
    , @NamedQuery(name = "PsTax.findByIdTax", query = "SELECT p FROM PsTax p WHERE p.idTax = :idTax")
    , @NamedQuery(name = "PsTax.findByRate", query = "SELECT p FROM PsTax p WHERE p.rate = :rate")
    , @NamedQuery(name = "PsTax.findByActive", query = "SELECT p FROM PsTax p WHERE p.active = :active")
    , @NamedQuery(name = "PsTax.findByDeleted", query = "SELECT p FROM PsTax p WHERE p.deleted = :deleted")})
public class PsTax implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tax")
    private Integer idTax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rate")
    private BigDecimal rate;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsTax() {
    }

    public PsTax(Integer idTax) {
        this.idTax = idTax;
    }

    public PsTax(Integer idTax, BigDecimal rate, boolean active, boolean deleted) {
        this.idTax = idTax;
        this.rate = rate;
        this.active = active;
        this.deleted = deleted;
    }

    public Integer getIdTax() {
        return idTax;
    }

    public void setIdTax(Integer idTax) {
        this.idTax = idTax;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTax != null ? idTax.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTax)) {
            return false;
        }
        PsTax other = (PsTax) object;
        if ((this.idTax == null && other.idTax != null) || (this.idTax != null && !this.idTax.equals(other.idTax))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTax[ idTax=" + idTax + " ]";
    }
    
}
