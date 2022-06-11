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
public class PsPackPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product_pack")
    private int idProductPack;
    @Basic(optional = false)
    @Column(name = "id_product_item")
    private int idProductItem;
    @Basic(optional = false)
    @Column(name = "id_product_attribute_item")
    private int idProductAttributeItem;

    public PsPackPK() {
    }

    public PsPackPK(int idProductPack, int idProductItem, int idProductAttributeItem) {
        this.idProductPack = idProductPack;
        this.idProductItem = idProductItem;
        this.idProductAttributeItem = idProductAttributeItem;
    }

    public int getIdProductPack() {
        return idProductPack;
    }

    public void setIdProductPack(int idProductPack) {
        this.idProductPack = idProductPack;
    }

    public int getIdProductItem() {
        return idProductItem;
    }

    public void setIdProductItem(int idProductItem) {
        this.idProductItem = idProductItem;
    }

    public int getIdProductAttributeItem() {
        return idProductAttributeItem;
    }

    public void setIdProductAttributeItem(int idProductAttributeItem) {
        this.idProductAttributeItem = idProductAttributeItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductPack;
        hash += (int) idProductItem;
        hash += (int) idProductAttributeItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPackPK)) {
            return false;
        }
        PsPackPK other = (PsPackPK) object;
        if (this.idProductPack != other.idProductPack) {
            return false;
        }
        if (this.idProductItem != other.idProductItem) {
            return false;
        }
        if (this.idProductAttributeItem != other.idProductAttributeItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPackPK[ idProductPack=" + idProductPack + ", idProductItem=" + idProductItem + ", idProductAttributeItem=" + idProductAttributeItem + " ]";
    }
    
}
