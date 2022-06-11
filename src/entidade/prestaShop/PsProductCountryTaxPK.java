/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsProductCountryTaxPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;

    public PsProductCountryTaxPK() {
    }

    public PsProductCountryTaxPK(int idProduct, int idCountry) {
        this.idProduct = idProduct;
        this.idCountry = idCountry;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idCountry;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCountryTaxPK)) {
            return false;
        }
        PsProductCountryTaxPK other = (PsProductCountryTaxPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idCountry != other.idCountry) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCountryTaxPK[ idProduct=" + idProduct + ", idCountry=" + idCountry + " ]";
    }
    
}
