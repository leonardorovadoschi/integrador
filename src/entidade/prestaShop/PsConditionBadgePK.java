/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsConditionBadgePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_condition")
    private int idCondition;
    @Basic(optional = false)
    @Column(name = "id_badge")
    private int idBadge;

    public PsConditionBadgePK() {
    }

    public PsConditionBadgePK(int idCondition, int idBadge) {
        this.idCondition = idCondition;
        this.idBadge = idBadge;
    }

    public int getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(int idCondition) {
        this.idCondition = idCondition;
    }

    public int getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(int idBadge) {
        this.idBadge = idBadge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCondition;
        hash += (int) idBadge;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConditionBadgePK)) {
            return false;
        }
        PsConditionBadgePK other = (PsConditionBadgePK) object;
        if (this.idCondition != other.idCondition) {
            return false;
        }
        if (this.idBadge != other.idBadge) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConditionBadgePK[ idCondition=" + idCondition + ", idBadge=" + idBadge + " ]";
    }
    
}
