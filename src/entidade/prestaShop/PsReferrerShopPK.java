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
public class PsReferrerShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_referrer")
    private int idReferrer;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsReferrerShopPK() {
    }

    public PsReferrerShopPK(int idReferrer, int idShop) {
        this.idReferrer = idReferrer;
        this.idShop = idShop;
    }

    public int getIdReferrer() {
        return idReferrer;
    }

    public void setIdReferrer(int idReferrer) {
        this.idReferrer = idReferrer;
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
        hash += (int) idReferrer;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReferrerShopPK)) {
            return false;
        }
        PsReferrerShopPK other = (PsReferrerShopPK) object;
        if (this.idReferrer != other.idReferrer) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReferrerShopPK[ idReferrer=" + idReferrer + ", idShop=" + idShop + " ]";
    }
    
}
