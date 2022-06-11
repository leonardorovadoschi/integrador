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
@Table(name = "ps_layered_indexable_feature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableFeature.findAll", query = "SELECT p FROM PsLayeredIndexableFeature p")
    , @NamedQuery(name = "PsLayeredIndexableFeature.findByIdFeature", query = "SELECT p FROM PsLayeredIndexableFeature p WHERE p.idFeature = :idFeature")
    , @NamedQuery(name = "PsLayeredIndexableFeature.findByIndexable", query = "SELECT p FROM PsLayeredIndexableFeature p WHERE p.indexable = :indexable")})
public class PsLayeredIndexableFeature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_feature")
    private Integer idFeature;
    @Basic(optional = false)
    @Column(name = "indexable")
    private boolean indexable;

    public PsLayeredIndexableFeature() {
    }

    public PsLayeredIndexableFeature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public PsLayeredIndexableFeature(Integer idFeature, boolean indexable) {
        this.idFeature = idFeature;
        this.indexable = indexable;
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
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
        hash += (idFeature != null ? idFeature.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableFeature)) {
            return false;
        }
        PsLayeredIndexableFeature other = (PsLayeredIndexableFeature) object;
        if ((this.idFeature == null && other.idFeature != null) || (this.idFeature != null && !this.idFeature.equals(other.idFeature))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableFeature[ idFeature=" + idFeature + " ]";
    }
    
}
