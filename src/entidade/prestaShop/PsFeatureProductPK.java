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
public class PsFeatureProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_feature")
    private int idFeature;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_feature_value")
    private int idFeatureValue;

    public PsFeatureProductPK() {
    }

    public PsFeatureProductPK(int idFeature, int idProduct, int idFeatureValue) {
        this.idFeature = idFeature;
        this.idProduct = idProduct;
        this.idFeatureValue = idFeatureValue;
    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdFeatureValue() {
        return idFeatureValue;
    }

    public void setIdFeatureValue(int idFeatureValue) {
        this.idFeatureValue = idFeatureValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFeature;
        hash += (int) idProduct;
        hash += (int) idFeatureValue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureProductPK)) {
            return false;
        }
        PsFeatureProductPK other = (PsFeatureProductPK) object;
        if (this.idFeature != other.idFeature) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idFeatureValue != other.idFeatureValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureProductPK[ idFeature=" + idFeature + ", idProduct=" + idProduct + ", idFeatureValue=" + idFeatureValue + " ]";
    }
    
}
