/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_address_format")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAddressFormat.findAll", query = "SELECT p FROM PsAddressFormat p")
    , @NamedQuery(name = "PsAddressFormat.findByIdCountry", query = "SELECT p FROM PsAddressFormat p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsAddressFormat.findByFormat", query = "SELECT p FROM PsAddressFormat p WHERE p.format = :format")})
public class PsAddressFormat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_country")
    private Integer idCountry;
    @Basic(optional = false)
    @Column(name = "format")
    private String format;

    public PsAddressFormat() {
    }

    public PsAddressFormat(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public PsAddressFormat(Integer idCountry, String format) {
        this.idCountry = idCountry;
        this.format = format;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCountry != null ? idCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAddressFormat)) {
            return false;
        }
        PsAddressFormat other = (PsAddressFormat) object;
        if ((this.idCountry == null && other.idCountry != null) || (this.idCountry != null && !this.idCountry.equals(other.idCountry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAddressFormat[ idCountry=" + idCountry + " ]";
    }
    
}
