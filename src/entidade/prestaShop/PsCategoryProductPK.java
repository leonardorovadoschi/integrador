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
public class PsCategoryProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;

    public PsCategoryProductPK() {
    }

    public PsCategoryProductPK(int idCategory, int idProduct) {
        this.idCategory = idCategory;
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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
        hash += (int) idCategory;
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryProductPK)) {
            return false;
        }
        PsCategoryProductPK other = (PsCategoryProductPK) object;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryProductPK[ idCategory=" + idCategory + ", idProduct=" + idProduct + " ]";
    }
    
}
