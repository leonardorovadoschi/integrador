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
public class PsConditionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_condition")
    private int idCondition;
    @Basic(optional = false)
    @Column(name = "id_ps_condition")
    private int idPsCondition;

    public PsConditionPK() {
    }

    public PsConditionPK(int idCondition, int idPsCondition) {
        this.idCondition = idCondition;
        this.idPsCondition = idPsCondition;
    }

    public int getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(int idCondition) {
        this.idCondition = idCondition;
    }

    public int getIdPsCondition() {
        return idPsCondition;
    }

    public void setIdPsCondition(int idPsCondition) {
        this.idPsCondition = idPsCondition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCondition;
        hash += (int) idPsCondition;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConditionPK)) {
            return false;
        }
        PsConditionPK other = (PsConditionPK) object;
        if (this.idCondition != other.idCondition) {
            return false;
        }
        if (this.idPsCondition != other.idPsCondition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConditionPK[ idCondition=" + idCondition + ", idPsCondition=" + idPsCondition + " ]";
    }
    
}
