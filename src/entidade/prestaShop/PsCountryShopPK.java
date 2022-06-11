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
public class PsCountryShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCountryShopPK() {
    }

    public PsCountryShopPK(int idCountry, int idShop) {
        this.idCountry = idCountry;
        this.idShop = idShop;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCountry;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCountryShopPK)) {
            return false;
        }
        PsCountryShopPK other = (PsCountryShopPK) object;
        if (this.idCountry != other.idCountry) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCountryShopPK[ idCountry=" + idCountry + ", idShop=" + idShop + " ]";
    }
    
}
