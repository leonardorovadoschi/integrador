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
public class PsProductGroupReductionCachePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;

    public PsProductGroupReductionCachePK() {
    }

    public PsProductGroupReductionCachePK(int idProduct, int idGroup) {
        this.idProduct = idProduct;
        this.idGroup = idGroup;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idGroup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductGroupReductionCachePK)) {
            return false;
        }
        PsProductGroupReductionCachePK other = (PsProductGroupReductionCachePK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductGroupReductionCachePK[ idProduct=" + idProduct + ", idGroup=" + idGroup + " ]";
    }
    
}
