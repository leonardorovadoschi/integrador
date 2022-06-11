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
public class PsCategoryShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCategoryShopPK() {
    }

    public PsCategoryShopPK(int idCategory, int idShop) {
        this.idCategory = idCategory;
        this.idShop = idShop;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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
        hash += (int) idCategory;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryShopPK)) {
            return false;
        }
        PsCategoryShopPK other = (PsCategoryShopPK) object;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryShopPK[ idCategory=" + idCategory + ", idShop=" + idShop + " ]";
    }
    
}
