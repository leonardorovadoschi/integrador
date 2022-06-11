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
public class PsSpecificPriceRuleConditionGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_specific_price_rule_condition_group")
    private int idSpecificPriceRuleConditionGroup;
    @Basic(optional = false)
    @Column(name = "id_specific_price_rule")
    private int idSpecificPriceRule;

    public PsSpecificPriceRuleConditionGroupPK() {
    }

    public PsSpecificPriceRuleConditionGroupPK(int idSpecificPriceRuleConditionGroup, int idSpecificPriceRule) {
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    public int getIdSpecificPriceRuleConditionGroup() {
        return idSpecificPriceRuleConditionGroup;
    }

    public void setIdSpecificPriceRuleConditionGroup(int idSpecificPriceRuleConditionGroup) {
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
    }

    public int getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    public void setIdSpecificPriceRule(int idSpecificPriceRule) {
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSpecificPriceRuleConditionGroup;
        hash += (int) idSpecificPriceRule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPriceRuleConditionGroupPK)) {
            return false;
        }
        PsSpecificPriceRuleConditionGroupPK other = (PsSpecificPriceRuleConditionGroupPK) object;
        if (this.idSpecificPriceRuleConditionGroup != other.idSpecificPriceRuleConditionGroup) {
            return false;
        }
        if (this.idSpecificPriceRule != other.idSpecificPriceRule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPriceRuleConditionGroupPK[ idSpecificPriceRuleConditionGroup=" + idSpecificPriceRuleConditionGroup + ", idSpecificPriceRule=" + idSpecificPriceRule + " ]";
    }
    
}
