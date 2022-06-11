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
public class PsInfoShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_info")
    private int idInfo;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsInfoShopPK() {
    }

    public PsInfoShopPK(int idInfo, int idShop) {
        this.idInfo = idInfo;
        this.idShop = idShop;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
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
        hash += (int) idInfo;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsInfoShopPK)) {
            return false;
        }
        PsInfoShopPK other = (PsInfoShopPK) object;
        if (this.idInfo != other.idInfo) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsInfoShopPK[ idInfo=" + idInfo + ", idShop=" + idShop + " ]";
    }
    
}
