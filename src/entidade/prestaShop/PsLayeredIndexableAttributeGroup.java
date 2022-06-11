/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_layered_indexable_attribute_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableAttributeGroup.findAll", query = "SELECT p FROM PsLayeredIndexableAttributeGroup p")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroup.findByIdAttributeGroup", query = "SELECT p FROM PsLayeredIndexableAttributeGroup p WHERE p.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroup.findByIndexable", query = "SELECT p FROM PsLayeredIndexableAttributeGroup p WHERE p.indexable = :indexable")})
public class PsLayeredIndexableAttributeGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private Integer idAttributeGroup;
    @Basic(optional = false)
    @Column(name = "indexable")
    private boolean indexable;

    public PsLayeredIndexableAttributeGroup() {
    }

    public PsLayeredIndexableAttributeGroup(Integer idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public PsLayeredIndexableAttributeGroup(Integer idAttributeGroup, boolean indexable) {
        this.idAttributeGroup = idAttributeGroup;
        this.indexable = indexable;
    }

    public Integer getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(Integer idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public boolean getIndexable() {
        return indexable;
    }

    public void setIndexable(boolean indexable) {
        this.indexable = indexable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttributeGroup != null ? idAttributeGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableAttributeGroup)) {
            return false;
        }
        PsLayeredIndexableAttributeGroup other = (PsLayeredIndexableAttributeGroup) object;
        if ((this.idAttributeGroup == null && other.idAttributeGroup != null) || (this.idAttributeGroup != null && !this.idAttributeGroup.equals(other.idAttributeGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableAttributeGroup[ idAttributeGroup=" + idAttributeGroup + " ]";
    }
    
}
