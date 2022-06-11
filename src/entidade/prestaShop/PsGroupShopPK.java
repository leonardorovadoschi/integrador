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
public class PsGroupShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsGroupShopPK() {
    }

    public PsGroupShopPK(int idGroup, int idShop) {
        this.idGroup = idGroup;
        this.idShop = idShop;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
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
        hash += (int) idGroup;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroupShopPK)) {
            return false;
        }
        PsGroupShopPK other = (PsGroupShopPK) object;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroupShopPK[ idGroup=" + idGroup + ", idShop=" + idShop + " ]";
    }
    
}
