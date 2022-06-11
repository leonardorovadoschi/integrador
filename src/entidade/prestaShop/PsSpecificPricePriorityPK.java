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
public class PsSpecificPricePriorityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_specific_price_priority")
    private int idSpecificPricePriority;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;

    public PsSpecificPricePriorityPK() {
    }

    public PsSpecificPricePriorityPK(int idSpecificPricePriority, int idProduct) {
        this.idSpecificPricePriority = idSpecificPricePriority;
        this.idProduct = idProduct;
    }

    public int getIdSpecificPricePriority() {
        return idSpecificPricePriority;
    }

    public void setIdSpecificPricePriority(int idSpecificPricePriority) {
        this.idSpecificPricePriority = idSpecificPricePriority;
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
        hash += (int) idSpecificPricePriority;
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPricePriorityPK)) {
            return false;
        }
        PsSpecificPricePriorityPK other = (PsSpecificPricePriorityPK) object;
        if (this.idSpecificPricePriority != other.idSpecificPricePriority) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPricePriorityPK[ idSpecificPricePriority=" + idSpecificPricePriority + ", idProduct=" + idProduct + " ]";
    }
    
}
