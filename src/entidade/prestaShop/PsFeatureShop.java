/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_feature_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureShop.findAll", query = "SELECT p FROM PsFeatureShop p")
    , @NamedQuery(name = "PsFeatureShop.findByIdFeature", query = "SELECT p FROM PsFeatureShop p WHERE p.psFeatureShopPK.idFeature = :idFeature")
    , @NamedQuery(name = "PsFeatureShop.findByIdShop", query = "SELECT p FROM PsFeatureShop p WHERE p.psFeatureShopPK.idShop = :idShop")})
public class PsFeatureShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsFeatureShopPK psFeatureShopPK;

    public PsFeatureShop() {
    }

    public PsFeatureShop(PsFeatureShopPK psFeatureShopPK) {
        this.psFeatureShopPK = psFeatureShopPK;
    }

    public PsFeatureShop(int idFeature, int idShop) {
        this.psFeatureShopPK = new PsFeatureShopPK(idFeature, idShop);
    }

    public PsFeatureShopPK getPsFeatureShopPK() {
        return psFeatureShopPK;
    }

    public void setPsFeatureShopPK(PsFeatureShopPK psFeatureShopPK) {
        this.psFeatureShopPK = psFeatureShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psFeatureShopPK != null ? psFeatureShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureShop)) {
            return false;
        }
        PsFeatureShop other = (PsFeatureShop) object;
        if ((this.psFeatureShopPK == null && other.psFeatureShopPK != null) || (this.psFeatureShopPK != null && !this.psFeatureShopPK.equals(other.psFeatureShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureShop[ psFeatureShopPK=" + psFeatureShopPK + " ]";
    }
    
}
