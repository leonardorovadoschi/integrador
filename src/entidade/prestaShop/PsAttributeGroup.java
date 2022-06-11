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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ps_attribute_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttributeGroup.findAll", query = "SELECT p FROM PsAttributeGroup p")
    , @NamedQuery(name = "PsAttributeGroup.findByIdAttributeGroup", query = "SELECT p FROM PsAttributeGroup p WHERE p.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsAttributeGroup.findByIsColorGroup", query = "SELECT p FROM PsAttributeGroup p WHERE p.isColorGroup = :isColorGroup")
    , @NamedQuery(name = "PsAttributeGroup.findByGroupType", query = "SELECT p FROM PsAttributeGroup p WHERE p.groupType = :groupType")
    , @NamedQuery(name = "PsAttributeGroup.findByPosition", query = "SELECT p FROM PsAttributeGroup p WHERE p.position = :position")})
public class PsAttributeGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private Integer idAttributeGroup;
    @Basic(optional = false)
    @Column(name = "is_color_group")
    private boolean isColorGroup;
    @Basic(optional = false)
    @Column(name = "group_type")
    private String groupType;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAttributeGroup() {
    }

    public PsAttributeGroup(Integer idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public PsAttributeGroup(Integer idAttributeGroup, boolean isColorGroup, String groupType, int position) {
        this.idAttributeGroup = idAttributeGroup;
        this.isColorGroup = isColorGroup;
        this.groupType = groupType;
        this.position = position;
    }

    public Integer getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(Integer idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public boolean getIsColorGroup() {
        return isColorGroup;
    }

    public void setIsColorGroup(boolean isColorGroup) {
        this.isColorGroup = isColorGroup;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
        if (!(object instanceof PsAttributeGroup)) {
            return false;
        }
        PsAttributeGroup other = (PsAttributeGroup) object;
        if ((this.idAttributeGroup == null && other.idAttributeGroup != null) || (this.idAttributeGroup != null && !this.idAttributeGroup.equals(other.idAttributeGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeGroup[ idAttributeGroup=" + idAttributeGroup + " ]";
    }
    
}
