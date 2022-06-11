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
@Table(name = "ps_feature_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureProduct.findAll", query = "SELECT p FROM PsFeatureProduct p")
    , @NamedQuery(name = "PsFeatureProduct.findByIdFeature", query = "SELECT p FROM PsFeatureProduct p WHERE p.psFeatureProductPK.idFeature = :idFeature")
    , @NamedQuery(name = "PsFeatureProduct.findByIdProduct", query = "SELECT p FROM PsFeatureProduct p WHERE p.psFeatureProductPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsFeatureProduct.findByIdFeatureValue", query = "SELECT p FROM PsFeatureProduct p WHERE p.psFeatureProductPK.idFeatureValue = :idFeatureValue")})
public class PsFeatureProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsFeatureProductPK psFeatureProductPK;

    public PsFeatureProduct() {
    }

    public PsFeatureProduct(PsFeatureProductPK psFeatureProductPK) {
        this.psFeatureProductPK = psFeatureProductPK;
    }

    public PsFeatureProduct(int idFeature, int idProduct, int idFeatureValue) {
        this.psFeatureProductPK = new PsFeatureProductPK(idFeature, idProduct, idFeatureValue);
    }

    public PsFeatureProductPK getPsFeatureProductPK() {
        return psFeatureProductPK;
    }

    public void setPsFeatureProductPK(PsFeatureProductPK psFeatureProductPK) {
        this.psFeatureProductPK = psFeatureProductPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psFeatureProductPK != null ? psFeatureProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureProduct)) {
            return false;
        }
        PsFeatureProduct other = (PsFeatureProduct) object;
        if ((this.psFeatureProductPK == null && other.psFeatureProductPK != null) || (this.psFeatureProductPK != null && !this.psFeatureProductPK.equals(other.psFeatureProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureProduct[ psFeatureProductPK=" + psFeatureProductPK + " ]";
    }
    
}
