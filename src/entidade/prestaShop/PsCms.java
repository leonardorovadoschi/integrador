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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_cms")
@XmlRootElement

public class PsCms implements Serializable {
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "indexation")
    private short indexation;

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

    public PsCms() {
    }

    public PsCms(Integer idCms) {
        this.idCms = idCms;
    }

    public PsCms(Integer idCms, int idCmsCategory, int position, short active, short indexation) {
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

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getIndexation() {
        return indexation;
    }

    public void setIndexation(short indexation) {
        this.indexation = indexation;
    }
    
}
