/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ps_layered_product_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredProductAttribute.findAll", query = "SELECT p FROM PsLayeredProductAttribute p")
    , @NamedQuery(name = "PsLayeredProductAttribute.findByIdAttribute", query = "SELECT p FROM PsLayeredProductAttribute p WHERE p.psLayeredProductAttributePK.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsLayeredProductAttribute.findByIdProduct", query = "SELECT p FROM PsLayeredProductAttribute p WHERE p.psLayeredProductAttributePK.idProduct = :idProduct")
    , @NamedQuery(name = "PsLayeredProductAttribute.findByIdAttributeGroup", query = "SELECT p FROM PsLayeredProductAttribute p WHERE p.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsLayeredProductAttribute.findByIdShop", query = "SELECT p FROM PsLayeredProductAttribute p WHERE p.psLayeredProductAttributePK.idShop = :idShop")})
public class PsLayeredProductAttribute implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredProductAttributePK psLayeredProductAttributePK;
    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private int idAttributeGroup;

    public PsLayeredProductAttribute() {
    }

    public PsLayeredProductAttribute(PsLayeredProductAttributePK psLayeredProductAttributePK) {
        this.psLayeredProductAttributePK = psLayeredProductAttributePK;
    }

    public PsLayeredProductAttribute(PsLayeredProductAttributePK psLayeredProductAttributePK, int idAttributeGroup) {
        this.psLayeredProductAttributePK = psLayeredProductAttributePK;
        this.idAttributeGroup = idAttributeGroup;
    }

    public PsLayeredProductAttribute(int idAttribute, int idProduct, int idShop) {
        this.psLayeredProductAttributePK = new PsLayeredProductAttributePK(idAttribute, idProduct, idShop);
    }

    public PsLayeredProductAttributePK getPsLayeredProductAttributePK() {
        return psLayeredProductAttributePK;
    }

    public void setPsLayeredProductAttributePK(PsLayeredProductAttributePK psLayeredProductAttributePK) {
        this.psLayeredProductAttributePK = psLayeredProductAttributePK;
    }

    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLayeredProductAttributePK != null ? psLayeredProductAttributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredProductAttribute)) {
            return false;
        }
        PsLayeredProductAttribute other = (PsLayeredProductAttribute) object;
        if ((this.psLayeredProductAttributePK == null && other.psLayeredProductAttributePK != null) || (this.psLayeredProductAttributePK != null && !this.psLayeredProductAttributePK.equals(other.psLayeredProductAttributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredProductAttribute[ psLayeredProductAttributePK=" + psLayeredProductAttributePK + " ]";
    }
    
}
