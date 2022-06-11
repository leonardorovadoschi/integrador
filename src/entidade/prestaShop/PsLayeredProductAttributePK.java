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
public class PsLayeredProductAttributePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_attribute")
    private int idAttribute;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsLayeredProductAttributePK() {
    }

    public PsLayeredProductAttributePK(int idAttribute, int idProduct, int idShop) {
        this.idAttribute = idAttribute;
        this.idProduct = idProduct;
        this.idShop = idShop;
    }

    public int getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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
        hash += (int) idAttribute;
        hash += (int) idProduct;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredProductAttributePK)) {
            return false;
        }
        PsLayeredProductAttributePK other = (PsLayeredProductAttributePK) object;
        if (this.idAttribute != other.idAttribute) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredProductAttributePK[ idAttribute=" + idAttribute + ", idProduct=" + idProduct + ", idShop=" + idShop + " ]";
    }
    
}
