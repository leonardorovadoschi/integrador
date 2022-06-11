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
@Table(name = "ps_cms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCms.findAll", query = "SELECT p FROM PsCms p")
    , @NamedQuery(name = "PsCms.findByIdCms", query = "SELECT p FROM PsCms p WHERE p.idCms = :idCms")
    , @NamedQuery(name = "PsCms.findByIdCmsCategory", query = "SELECT p FROM PsCms p WHERE p.idCmsCategory = :idCmsCategory")
    , @NamedQuery(name = "PsCms.findByPosition", query = "SELECT p FROM PsCms p WHERE p.position = :position")
    , @NamedQuery(name = "PsCms.findByActive", query = "SELECT p FROM PsCms p WHERE p.active = :active")
    , @NamedQuery(name = "PsCms.findByIndexation", query = "SELECT p FROM PsCms p WHERE p.indexation = :indexation")})
public class PsCms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cms")
    private Integer idCms;
    @Basic(optional = false)
    @Column(name = "id_cms_category")
    private int idCmsCategory;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "indexation")
    private boolean indexation;

    public PsCms() {
    }

    public PsCms(Integer idCms) {
        this.idCms = idCms;
    }

    public PsCms(Integer idCms, int idCmsCategory, int position, boolean active, boolean indexation) {
        this.idCms = idCms;
        this.idCmsCategory = idCmsCategory;
        this.position = position;
        this.active = active;
        this.indexation = indexation;
    }

    public Integer getIdCms() {
        return idCms;
    }

    public void setIdCms(Integer idCms) {
        this.idCms = idCms;
    }

    public int getIdCmsCategory() {
        return idCmsCategory;
    }

    public void setIdCmsCategory(int idCmsCategory) {
        this.idCmsCategory = idCmsCategory;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getIndexation() {
        return indexation;
    }

    public void setIndexation(boolean indexation) {
        this.indexation = indexation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCms != null ? idCms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCms)) {
            return false;
        }
        PsCms other = (PsCms) object;
        if ((this.idCms == null && other.idCms != null) || (this.idCms != null && !this.idCms.equals(other.idCms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCms[ idCms=" + idCms + " ]";
    }
    
}
