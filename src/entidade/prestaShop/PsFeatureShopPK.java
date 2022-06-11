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
public class PsFeatureShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_feature")
    private int idFeature;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsFeatureShopPK() {
    }

    public PsFeatureShopPK(int idFeature, int idShop) {
        this.idFeature = idFeature;
        this.idShop = idShop;
    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
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
        hash += (int) idFeature;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureShopPK)) {
            return false;
        }
        PsFeatureShopPK other = (PsFeatureShopPK) object;
        if (this.idFeature != other.idFeature) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureShopPK[ idFeature=" + idFeature + ", idShop=" + idShop + " ]";
    }
    
}
