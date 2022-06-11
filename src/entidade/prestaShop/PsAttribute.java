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
@Table(name = "ps_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttribute.findAll", query = "SELECT p FROM PsAttribute p")
    , @NamedQuery(name = "PsAttribute.findByIdAttribute", query = "SELECT p FROM PsAttribute p WHERE p.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsAttribute.findByIdAttributeGroup", query = "SELECT p FROM PsAttribute p WHERE p.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsAttribute.findByColor", query = "SELECT p FROM PsAttribute p WHERE p.color = :color")
    , @NamedQuery(name = "PsAttribute.findByPosition", query = "SELECT p FROM PsAttribute p WHERE p.position = :position")})
public class PsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_attribute")
    private Integer idAttribute;
    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private int idAttributeGroup;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAttribute() {
    }

    public PsAttribute(Integer idAttribute) {
        this.idAttribute = idAttribute;
    }

    public PsAttribute(Integer idAttribute, int idAttributeGroup, String color, int position) {
        this.idAttribute = idAttribute;
        this.idAttributeGroup = idAttributeGroup;
        this.color = color;
        this.position = position;
    }

    public Integer getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Integer idAttribute) {
        this.idAttribute = idAttribute;
    }

    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash += (idAttribute != null ? idAttribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttribute)) {
            return false;
        }
        PsAttribute other = (PsAttribute) object;
        if ((this.idAttribute == null && other.idAttribute != null) || (this.idAttribute != null && !this.idAttribute.equals(other.idAttribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttribute[ idAttribute=" + idAttribute + " ]";
    }
    
}
