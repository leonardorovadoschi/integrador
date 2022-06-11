/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_product_country_tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCountryTax.findAll", query = "SELECT p FROM PsProductCountryTax p")
    , @NamedQuery(name = "PsProductCountryTax.findByIdProduct", query = "SELECT p FROM PsProductCountryTax p WHERE p.psProductCountryTaxPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductCountryTax.findByIdCountry", query = "SELECT p FROM PsProductCountryTax p WHERE p.psProductCountryTaxPK.idCountry = :idCountry")
    , @NamedQuery(name = "PsProductCountryTax.findByIdTax", query = "SELECT p FROM PsProductCountryTax p WHERE p.idTax = :idTax")})
public class PsProductCountryTax implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCountryTaxPK psProductCountryTaxPK;
    @Basic(optional = false)
    @Column(name = "id_tax")
    private int idTax;

    public PsProductCountryTax() {
    }

    public PsProductCountryTax(PsProductCountryTaxPK psProductCountryTaxPK) {
        this.psProductCountryTaxPK = psProductCountryTaxPK;
    }

    public PsProductCountryTax(PsProductCountryTaxPK psProductCountryTaxPK, int idTax) {
        this.psProductCountryTaxPK = psProductCountryTaxPK;
        this.idTax = idTax;
    }

    public PsProductCountryTax(int idProduct, int idCountry) {
        this.psProductCountryTaxPK = new PsProductCountryTaxPK(idProduct, idCountry);
    }

    public PsProductCountryTaxPK getPsProductCountryTaxPK() {
        return psProductCountryTaxPK;
    }

    public void setPsProductCountryTaxPK(PsProductCountryTaxPK psProductCountryTaxPK) {
        this.psProductCountryTaxPK = psProductCountryTaxPK;
    }

    public int getIdTax() {
        return idTax;
    }

    public void setIdTax(int idTax) {
        this.idTax = idTax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCountryTaxPK != null ? psProductCountryTaxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCountryTax)) {
            return false;
        }
        PsProductCountryTax other = (PsProductCountryTax) object;
        if ((this.psProductCountryTaxPK == null && other.psProductCountryTaxPK != null) || (this.psProductCountryTaxPK != null && !this.psProductCountryTaxPK.equals(other.psProductCountryTaxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCountryTax[ psProductCountryTaxPK=" + psProductCountryTaxPK + " ]";
    }
    
}
