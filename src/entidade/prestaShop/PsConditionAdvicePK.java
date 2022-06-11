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
public class PsConditionAdvicePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_condition")
    private int idCondition;
    @Basic(optional = false)
    @Column(name = "id_advice")
    private int idAdvice;

    public PsConditionAdvicePK() {
    }

    public PsConditionAdvicePK(int idCondition, int idAdvice) {
        this.idCondition = idCondition;
        this.idAdvice = idAdvice;
    }

    public int getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(int idCondition) {
        this.idCondition = idCondition;
    }

    public int getIdAdvice() {
        return idAdvice;
    }

    public void setIdAdvice(int idAdvice) {
        this.idAdvice = idAdvice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCondition;
        hash += (int) idAdvice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConditionAdvicePK)) {
            return false;
        }
        PsConditionAdvicePK other = (PsConditionAdvicePK) object;
        if (this.idCondition != other.idCondition) {
            return false;
        }
        if (this.idAdvice != other.idAdvice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConditionAdvicePK[ idCondition=" + idCondition + ", idAdvice=" + idAdvice + " ]";
    }
    
}
