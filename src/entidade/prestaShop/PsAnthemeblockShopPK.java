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
public class PsAnthemeblockShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anthemeblock")
    private int idAnthemeblock;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnthemeblockShopPK() {
    }

    public PsAnthemeblockShopPK(int idAnthemeblock, int idShop) {
        this.idAnthemeblock = idAnthemeblock;
        this.idShop = idShop;
    }

    public int getIdAnthemeblock() {
        return idAnthemeblock;
    }

    public void setIdAnthemeblock(int idAnthemeblock) {
        this.idAnthemeblock = idAnthemeblock;
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
        hash += (int) idAnthemeblock;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockShopPK)) {
            return false;
        }
        PsAnthemeblockShopPK other = (PsAnthemeblockShopPK) object;
        if (this.idAnthemeblock != other.idAnthemeblock) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockShopPK[ idAnthemeblock=" + idAnthemeblock + ", idShop=" + idShop + " ]";
    }
    
}
