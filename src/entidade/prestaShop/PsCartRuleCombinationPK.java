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
public class PsCartRuleCombinationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart_rule_1")
    private int idCartRule1;
    @Basic(optional = false)
    @Column(name = "id_cart_rule_2")
    private int idCartRule2;

    public PsCartRuleCombinationPK() {
    }

    public PsCartRuleCombinationPK(int idCartRule1, int idCartRule2) {
        this.idCartRule1 = idCartRule1;
        this.idCartRule2 = idCartRule2;
    }

    public int getIdCartRule1() {
        return idCartRule1;
    }

    public void setIdCartRule1(int idCartRule1) {
        this.idCartRule1 = idCartRule1;
    }

    public int getIdCartRule2() {
        return idCartRule2;
    }

    public void setIdCartRule2(int idCartRule2) {
        this.idCartRule2 = idCartRule2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCartRule1;
        hash += (int) idCartRule2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCombinationPK)) {
            return false;
        }
        PsCartRuleCombinationPK other = (PsCartRuleCombinationPK) object;
        if (this.idCartRule1 != other.idCartRule1) {
            return false;
        }
        if (this.idCartRule2 != other.idCartRule2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCombinationPK[ idCartRule1=" + idCartRule1 + ", idCartRule2=" + idCartRule2 + " ]";
    }
    
}
