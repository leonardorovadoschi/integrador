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
public class PsCartRuleCarrierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;

    public PsCartRuleCarrierPK() {
    }

    public PsCartRuleCarrierPK(int idCartRule, int idCarrier) {
        this.idCartRule = idCartRule;
        this.idCarrier = idCarrier;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCartRule;
        hash += (int) idCarrier;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCarrierPK)) {
            return false;
        }
        PsCartRuleCarrierPK other = (PsCartRuleCarrierPK) object;
        if (this.idCartRule != other.idCartRule) {
            return false;
        }
        if (this.idCarrier != other.idCarrier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCarrierPK[ idCartRule=" + idCartRule + ", idCarrier=" + idCarrier + " ]";
    }
    
}
