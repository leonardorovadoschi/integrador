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
 * @author leo-note
 */
@Embeddable
public class PsAnTrustBadgesIconsShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "icon_id")
    private int iconId;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnTrustBadgesIconsShopPK() {
    }

    public PsAnTrustBadgesIconsShopPK(int iconId, int idShop) {
        this.iconId = iconId;
        this.idShop = idShop;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
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
        hash += (int) iconId;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesIconsShopPK)) {
            return false;
        }
        PsAnTrustBadgesIconsShopPK other = (PsAnTrustBadgesIconsShopPK) object;
        if (this.iconId != other.iconId) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesIconsShopPK[ iconId=" + iconId + ", idShop=" + idShop + " ]";
    }
    
}
