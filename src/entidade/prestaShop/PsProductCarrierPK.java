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
public class PsProductCarrierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_carrier_reference")
    private int idCarrierReference;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsProductCarrierPK() {
    }

    public PsProductCarrierPK(int idProduct, int idCarrierReference, int idShop) {
        this.idProduct = idProduct;
        this.idCarrierReference = idCarrierReference;
        this.idShop = idShop;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCarrierReference() {
        return idCarrierReference;
    }

    public void setIdCarrierReference(int idCarrierReference) {
        this.idCarrierReference = idCarrierReference;
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
        hash += (int) idProduct;
        hash += (int) idCarrierReference;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCarrierPK)) {
            return false;
        }
        PsProductCarrierPK other = (PsProductCarrierPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idCarrierReference != other.idCarrierReference) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCarrierPK[ idProduct=" + idProduct + ", idCarrierReference=" + idCarrierReference + ", idShop=" + idShop + " ]";
    }
    
}
