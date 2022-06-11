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
public class PsCmsCategoryShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cms_category")
    private int idCmsCategory;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCmsCategoryShopPK() {
    }

    public PsCmsCategoryShopPK(int idCmsCategory, int idShop) {
        this.idCmsCategory = idCmsCategory;
        this.idShop = idShop;
    }

    public int getIdCmsCategory() {
        return idCmsCategory;
    }

    public void setIdCmsCategory(int idCmsCategory) {
        this.idCmsCategory = idCmsCategory;
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
        hash += (int) idCmsCategory;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsCategoryShopPK)) {
            return false;
        }
        PsCmsCategoryShopPK other = (PsCmsCategoryShopPK) object;
        if (this.idCmsCategory != other.idCmsCategory) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsCategoryShopPK[ idCmsCategory=" + idCmsCategory + ", idShop=" + idShop + " ]";
    }
    
}
