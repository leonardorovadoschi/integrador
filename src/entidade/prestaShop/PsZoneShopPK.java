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
public class PsZoneShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsZoneShopPK() {
    }

    public PsZoneShopPK(int idZone, int idShop) {
        this.idZone = idZone;
        this.idShop = idShop;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
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
        hash += (int) idZone;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsZoneShopPK)) {
            return false;
        }
        PsZoneShopPK other = (PsZoneShopPK) object;
        if (this.idZone != other.idZone) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsZoneShopPK[ idZone=" + idZone + ", idShop=" + idShop + " ]";
    }
    
}
