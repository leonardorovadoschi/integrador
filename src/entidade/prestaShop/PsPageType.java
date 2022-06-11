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
@Table(name = "ps_page_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPageType.findAll", query = "SELECT p FROM PsPageType p")
    , @NamedQuery(name = "PsPageType.findByIdPageType", query = "SELECT p FROM PsPageType p WHERE p.idPageType = :idPageType")
    , @NamedQuery(name = "PsPageType.findByName", query = "SELECT p FROM PsPageType p WHERE p.name = :name")})
public class PsPageType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_page_type")
    private Integer idPageType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsPageType() {
    }

    public PsPageType(Integer idPageType) {
        this.idPageType = idPageType;
    }

    public PsPageType(Integer idPageType, String name) {
        this.idPageType = idPageType;
        this.name = name;
    }

    public Integer getIdPageType() {
        return idPageType;
    }

    public void setIdPageType(Integer idPageType) {
        this.idPageType = idPageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPageType != null ? idPageType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPageType)) {
            return false;
        }
        PsPageType other = (PsPageType) object;
        if ((this.idPageType == null && other.idPageType != null) || (this.idPageType != null && !this.idPageType.equals(other.idPageType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPageType[ idPageType=" + idPageType + " ]";
    }
    
}
