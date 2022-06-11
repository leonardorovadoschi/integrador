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
@Table(name = "ps_feature_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureValue.findAll", query = "SELECT p FROM PsFeatureValue p")
    , @NamedQuery(name = "PsFeatureValue.findByIdFeatureValue", query = "SELECT p FROM PsFeatureValue p WHERE p.idFeatureValue = :idFeatureValue")
    , @NamedQuery(name = "PsFeatureValue.findByIdFeature", query = "SELECT p FROM PsFeatureValue p WHERE p.idFeature = :idFeature")
    , @NamedQuery(name = "PsFeatureValue.findByCustom", query = "SELECT p FROM PsFeatureValue p WHERE p.custom = :custom")})
public class PsFeatureValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feature_value")
    private Integer idFeatureValue;
    @Basic(optional = false)
    @Column(name = "id_feature")
    private int idFeature;
    @Column(name = "custom")
    private Short custom;

    public PsFeatureValue() {
    }

    public PsFeatureValue(Integer idFeatureValue) {
        this.idFeatureValue = idFeatureValue;
    }

    public PsFeatureValue(Integer idFeatureValue, int idFeature) {
        this.idFeatureValue = idFeatureValue;
        this.idFeature = idFeature;
    }

    public Integer getIdFeatureValue() {
        return idFeatureValue;
    }

    public void setIdFeatureValue(Integer idFeatureValue) {
        this.idFeatureValue = idFeatureValue;
    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
    }

    public Short getCustom() {
        return custom;
    }

    public void setCustom(Short custom) {
        this.custom = custom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeatureValue != null ? idFeatureValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureValue)) {
            return false;
        }
        PsFeatureValue other = (PsFeatureValue) object;
        if ((this.idFeatureValue == null && other.idFeatureValue != null) || (this.idFeatureValue != null && !this.idFeatureValue.equals(other.idFeatureValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureValue[ idFeatureValue=" + idFeatureValue + " ]";
    }
    
}
