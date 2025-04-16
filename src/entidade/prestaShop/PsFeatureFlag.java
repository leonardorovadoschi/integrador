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
 * @author leo-note
 */
@Entity
@Table(name = "ps_feature_flag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureFlag.findAll", query = "SELECT p FROM PsFeatureFlag p")})
public class PsFeatureFlag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feature_flag")
    private Integer idFeatureFlag;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "state")
    private boolean state;
    @Basic(optional = false)
    @Column(name = "label_wording")
    private String labelWording;
    @Basic(optional = false)
    @Column(name = "label_domain")
    private String labelDomain;
    @Basic(optional = false)
    @Column(name = "description_wording")
    private String descriptionWording;
    @Basic(optional = false)
    @Column(name = "description_domain")
    private String descriptionDomain;
    @Basic(optional = false)
    @Column(name = "stability")
    private String stability;

    public PsFeatureFlag() {
    }

    public PsFeatureFlag(Integer idFeatureFlag) {
        this.idFeatureFlag = idFeatureFlag;
    }

    public PsFeatureFlag(Integer idFeatureFlag, String name, boolean state, String labelWording, String labelDomain, String descriptionWording, String descriptionDomain, String stability) {
        this.idFeatureFlag = idFeatureFlag;
        this.name = name;
        this.state = state;
        this.labelWording = labelWording;
        this.labelDomain = labelDomain;
        this.descriptionWording = descriptionWording;
        this.descriptionDomain = descriptionDomain;
        this.stability = stability;
    }

    public Integer getIdFeatureFlag() {
        return idFeatureFlag;
    }

    public void setIdFeatureFlag(Integer idFeatureFlag) {
        this.idFeatureFlag = idFeatureFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getLabelWording() {
        return labelWording;
    }

    public void setLabelWording(String labelWording) {
        this.labelWording = labelWording;
    }

    public String getLabelDomain() {
        return labelDomain;
    }

    public void setLabelDomain(String labelDomain) {
        this.labelDomain = labelDomain;
    }

    public String getDescriptionWording() {
        return descriptionWording;
    }

    public void setDescriptionWording(String descriptionWording) {
        this.descriptionWording = descriptionWording;
    }

    public String getDescriptionDomain() {
        return descriptionDomain;
    }

    public void setDescriptionDomain(String descriptionDomain) {
        this.descriptionDomain = descriptionDomain;
    }

    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeatureFlag != null ? idFeatureFlag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureFlag)) {
            return false;
        }
        PsFeatureFlag other = (PsFeatureFlag) object;
        if ((this.idFeatureFlag == null && other.idFeatureFlag != null) || (this.idFeatureFlag != null && !this.idFeatureFlag.equals(other.idFeatureFlag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureFlag[ idFeatureFlag=" + idFeatureFlag + " ]";
    }
    
}
