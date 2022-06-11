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
public class PsCartProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_address_delivery")
    private int idAddressDelivery;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "id_customization")
    private int idCustomization;

    public PsCartProductPK() {
    }

    public PsCartProductPK(int idCart, int idProduct, int idAddressDelivery, int idProductAttribute, int idCustomization) {
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.idAddressDelivery = idAddressDelivery;
        this.idProductAttribute = idProductAttribute;
        this.idCustomization = idCustomization;
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

    public int getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(int idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(int idCustomization) {
        this.idCustomization = idCustomization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCart;
        hash += (int) idProduct;
        hash += (int) idAddressDelivery;
        hash += (int) idProductAttribute;
        hash += (int) idCustomization;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartProductPK)) {
            return false;
        }
        PsCartProductPK other = (PsCartProductPK) object;
        if (this.idCart != other.idCart) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idAddressDelivery != other.idAddressDelivery) {
            return false;
        }
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idCustomization != other.idCustomization) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartProductPK[ idCart=" + idCart + ", idProduct=" + idProduct + ", idAddressDelivery=" + idAddressDelivery + ", idProductAttribute=" + idProductAttribute + ", idCustomization=" + idCustomization + " ]";
    }
    
}
