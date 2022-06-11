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
@Table(name = "ps_badge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsBadge.findAll", query = "SELECT p FROM PsBadge p")
    , @NamedQuery(name = "PsBadge.findByIdBadge", query = "SELECT p FROM PsBadge p WHERE p.idBadge = :idBadge")
    , @NamedQuery(name = "PsBadge.findByIdPsBadge", query = "SELECT p FROM PsBadge p WHERE p.idPsBadge = :idPsBadge")
    , @NamedQuery(name = "PsBadge.findByType", query = "SELECT p FROM PsBadge p WHERE p.type = :type")
    , @NamedQuery(name = "PsBadge.findByIdGroup", query = "SELECT p FROM PsBadge p WHERE p.idGroup = :idGroup")
    , @NamedQuery(name = "PsBadge.findByGroupPosition", query = "SELECT p FROM PsBadge p WHERE p.groupPosition = :groupPosition")
    , @NamedQuery(name = "PsBadge.findByScoring", query = "SELECT p FROM PsBadge p WHERE p.scoring = :scoring")
    , @NamedQuery(name = "PsBadge.findByAwb", query = "SELECT p FROM PsBadge p WHERE p.awb = :awb")
    , @NamedQuery(name = "PsBadge.findByValidated", query = "SELECT p FROM PsBadge p WHERE p.validated = :validated")})
public class PsBadge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_badge")
    private Integer idBadge;
    @Basic(optional = false)
    @Column(name = "id_ps_badge")
    private int idPsBadge;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "group_position")
    private int groupPosition;
    @Basic(optional = false)
    @Column(name = "scoring")
    private int scoring;
    @Column(name = "awb")
    private Integer awb;
    @Basic(optional = false)
    @Column(name = "validated")
    private boolean validated;

    public PsBadge() {
    }

    public PsBadge(Integer idBadge) {
        this.idBadge = idBadge;
    }

    public PsBadge(Integer idBadge, int idPsBadge, String type, int idGroup, int groupPosition, int scoring, boolean validated) {
        this.idBadge = idBadge;
        this.idPsBadge = idPsBadge;
        this.type = type;
        this.idGroup = idGroup;
        this.groupPosition = groupPosition;
        this.scoring = scoring;
        this.validated = validated;
    }

    public Integer getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(Integer idBadge) {
        this.idBadge = idBadge;
    }

    public int getIdPsBadge() {
        return idPsBadge;
    }

    public void setIdPsBadge(int idPsBadge) {
        this.idPsBadge = idPsBadge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getGroupPosition() {
        return groupPosition;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    public Integer getAwb() {
        return awb;
    }

    public void setAwb(Integer awb) {
        this.awb = awb;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBadge != null ? idBadge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBadge)) {
            return false;
        }
        PsBadge other = (PsBadge) object;
        if ((this.idBadge == null && other.idBadge != null) || (this.idBadge != null && !this.idBadge.equals(other.idBadge))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsBadge[ idBadge=" + idBadge + " ]";
    }
    
}
