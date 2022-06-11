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
public class PsLayeredPriceIndexPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;

    public PsLayeredPriceIndexPK() {
    }

    public PsLayeredPriceIndexPK(int idProduct, int idCurrency, int idShop, int idCountry) {
        this.idProduct = idProduct;
        this.idCurrency = idCurrency;
        this.idShop = idShop;
        this.idCountry = idCountry;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash += (int) idCurrency;
        hash += (int) idShop;
        hash += (int) idCountry;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredPriceIndexPK)) {
            return false;
        }
        PsLayeredPriceIndexPK other = (PsLayeredPriceIndexPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idCurrency != other.idCurrency) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idCountry != other.idCountry) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredPriceIndexPK[ idProduct=" + idProduct + ", idCurrency=" + idCurrency + ", idShop=" + idShop + ", idCountry=" + idCountry + " ]";
    }
    
}
