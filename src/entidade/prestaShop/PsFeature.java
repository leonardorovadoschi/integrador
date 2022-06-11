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
@Table(name = "ps_feature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeature.findAll", query = "SELECT p FROM PsFeature p")
    , @NamedQuery(name = "PsFeature.findByIdFeature", query = "SELECT p FROM PsFeature p WHERE p.idFeature = :idFeature")
    , @NamedQuery(name = "PsFeature.findByPosition", query = "SELECT p FROM PsFeature p WHERE p.position = :position")})
public class PsFeature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feature")
    private Integer idFeature;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsFeature() {
    }

    public PsFeature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public PsFeature(Integer idFeature, int position) {
        this.idFeature = idFeature;
        this.position = position;
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
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
        hash += (idFeature != null ? idFeature.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeature)) {
            return false;
        }
        PsFeature other = (PsFeature) object;
        if ((this.idFeature == null && other.idFeature != null) || (this.idFeature != null && !this.idFeature.equals(other.idFeature))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeature[ idFeature=" + idFeature + " ]";
    }
    
}
