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
public class PsAttributeGroupShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private int idAttributeGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAttributeGroupShopPK() {
    }

    public PsAttributeGroupShopPK(int idAttributeGroup, int idShop) {
        this.idAttributeGroup = idAttributeGroup;
        this.idShop = idShop;
    }

    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
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
        hash += (int) idAttributeGroup;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeGroupShopPK)) {
            return false;
        }
        PsAttributeGroupShopPK other = (PsAttributeGroupShopPK) object;
        if (this.idAttributeGroup != other.idAttributeGroup) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeGroupShopPK[ idAttributeGroup=" + idAttributeGroup + ", idShop=" + idShop + " ]";
    }
    
}
