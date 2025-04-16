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
public class PsAnHomeproductsBannersShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_banner")
    private int idBanner;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnHomeproductsBannersShopPK() {
    }

    public PsAnHomeproductsBannersShopPK(int idBanner, int idShop) {
        this.idBanner = idBanner;
        this.idShop = idShop;
    }

    public int getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(int idBanner) {
        this.idBanner = idBanner;
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
        hash += (int) idBanner;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBannersShopPK)) {
            return false;
        }
        PsAnHomeproductsBannersShopPK other = (PsAnHomeproductsBannersShopPK) object;
        if (this.idBanner != other.idBanner) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBannersShopPK[ idBanner=" + idBanner + ", idShop=" + idShop + " ]";
    }
    
}
