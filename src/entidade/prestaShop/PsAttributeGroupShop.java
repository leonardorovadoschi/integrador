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
@Table(name = "ps_attribute_group_shop")
@XmlRootElement
public class PsAttributeGroupShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAttributeGroupShopPK psAttributeGroupShopPK;

    public PsAttributeGroupShop() {
    }

    public PsAttributeGroupShop(PsAttributeGroupShopPK psAttributeGroupShopPK) {
        this.psAttributeGroupShopPK = psAttributeGroupShopPK;
    }

    public PsAttributeGroupShop(int idAttributeGroup, int idShop) {
        this.psAttributeGroupShopPK = new PsAttributeGroupShopPK(idAttributeGroup, idShop);
    }

    public PsAttributeGroupShopPK getPsAttributeGroupShopPK() {
        return psAttributeGroupShopPK;
    }

    public void setPsAttributeGroupShopPK(PsAttributeGroupShopPK psAttributeGroupShopPK) {
        this.psAttributeGroupShopPK = psAttributeGroupShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAttributeGroupShopPK != null ? psAttributeGroupShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeGroupShop)) {
            return false;
        }
        PsAttributeGroupShop other = (PsAttributeGroupShop) object;
        if ((this.psAttributeGroupShopPK == null && other.psAttributeGroupShopPK != null) || (this.psAttributeGroupShopPK != null && !this.psAttributeGroupShopPK.equals(other.psAttributeGroupShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeGroupShop[ psAttributeGroupShopPK=" + psAttributeGroupShopPK + " ]";
    }
    
}
