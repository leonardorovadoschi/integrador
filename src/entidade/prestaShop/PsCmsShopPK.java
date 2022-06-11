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
public class PsCmsShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cms")
    private int idCms;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCmsShopPK() {
    }

    public PsCmsShopPK(int idCms, int idShop) {
        this.idCms = idCms;
        this.idShop = idShop;
    }

    public int getIdCms() {
        return idCms;
    }

    public void setIdCms(int idCms) {
        this.idCms = idCms;
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
        hash += (int) idCms;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsShopPK)) {
            return false;
        }
        PsCmsShopPK other = (PsCmsShopPK) object;
        if (this.idCms != other.idCms) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsShopPK[ idCms=" + idCms + ", idShop=" + idShop + " ]";
    }
    
}
