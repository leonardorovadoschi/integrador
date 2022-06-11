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
@Table(name = "ps_attribute_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttributeShop.findAll", query = "SELECT p FROM PsAttributeShop p")
    , @NamedQuery(name = "PsAttributeShop.findByIdAttribute", query = "SELECT p FROM PsAttributeShop p WHERE p.psAttributeShopPK.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsAttributeShop.findByIdShop", query = "SELECT p FROM PsAttributeShop p WHERE p.psAttributeShopPK.idShop = :idShop")})
public class PsAttributeShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAttributeShopPK psAttributeShopPK;

    public PsAttributeShop() {
    }

    public PsAttributeShop(PsAttributeShopPK psAttributeShopPK) {
        this.psAttributeShopPK = psAttributeShopPK;
    }

    public PsAttributeShop(int idAttribute, int idShop) {
        this.psAttributeShopPK = new PsAttributeShopPK(idAttribute, idShop);
    }

    public PsAttributeShopPK getPsAttributeShopPK() {
        return psAttributeShopPK;
    }

    public void setPsAttributeShopPK(PsAttributeShopPK psAttributeShopPK) {
        this.psAttributeShopPK = psAttributeShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAttributeShopPK != null ? psAttributeShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeShop)) {
            return false;
        }
        PsAttributeShop other = (PsAttributeShop) object;
        if ((this.psAttributeShopPK == null && other.psAttributeShopPK != null) || (this.psAttributeShopPK != null && !this.psAttributeShopPK.equals(other.psAttributeShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeShop[ psAttributeShopPK=" + psAttributeShopPK + " ]";
    }
    
}
