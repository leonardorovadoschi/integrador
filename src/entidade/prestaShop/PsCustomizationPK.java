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
public class PsCustomizationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_customization")
    private int idCustomization;
    @Basic(optional = false)
    @Column(name = "id_address_delivery")
    private int idAddressDelivery;
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;

    public PsCustomizationPK() {
    }

    public PsCustomizationPK(int idCustomization, int idAddressDelivery, int idCart, int idProduct) {
        this.idCustomization = idCustomization;
        this.idAddressDelivery = idAddressDelivery;
        this.idCart = idCart;
        this.idProduct = idProduct;
    }

    public int getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(int idCustomization) {
        this.idCustomization = idCustomization;
    }

    public int getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(int idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomization;
        hash += (int) idAddressDelivery;
        hash += (int) idCart;
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizationPK)) {
            return false;
        }
        PsCustomizationPK other = (PsCustomizationPK) object;
        if (this.idCustomization != other.idCustomization) {
            return false;
        }
        if (this.idAddressDelivery != other.idAddressDelivery) {
            return false;
        }
        if (this.idCart != other.idCart) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizationPK[ idCustomization=" + idCustomization + ", idAddressDelivery=" + idAddressDelivery + ", idCart=" + idCart + ", idProduct=" + idProduct + " ]";
    }
    
}
