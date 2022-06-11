/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_specific_price_rule_condition_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSpecificPriceRuleConditionGroup.findAll", query = "SELECT p FROM PsSpecificPriceRuleConditionGroup p")
    , @NamedQuery(name = "PsSpecificPriceRuleConditionGroup.findByIdSpecificPriceRuleConditionGroup", query = "SELECT p FROM PsSpecificPriceRuleConditionGroup p WHERE p.psSpecificPriceRuleConditionGroupPK.idSpecificPriceRuleConditionGroup = :idSpecificPriceRuleConditionGroup")
    , @NamedQuery(name = "PsSpecificPriceRuleConditionGroup.findByIdSpecificPriceRule", query = "SELECT p FROM PsSpecificPriceRuleConditionGroup p WHERE p.psSpecificPriceRuleConditionGroupPK.idSpecificPriceRule = :idSpecificPriceRule")})
public class PsSpecificPriceRuleConditionGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSpecificPriceRuleConditionGroupPK psSpecificPriceRuleConditionGroupPK;

    public PsSpecificPriceRuleConditionGroup() {
    }

    public PsSpecificPriceRuleConditionGroup(PsSpecificPriceRuleConditionGroupPK psSpecificPriceRuleConditionGroupPK) {
        this.psSpecificPriceRuleConditionGroupPK = psSpecificPriceRuleConditionGroupPK;
    }

    public PsSpecificPriceRuleConditionGroup(int idSpecificPriceRuleConditionGroup, int idSpecificPriceRule) {
        this.psSpecificPriceRuleConditionGroupPK = new PsSpecificPriceRuleConditionGroupPK(idSpecificPriceRuleConditionGroup, idSpecificPriceRule);
    }

    public PsSpecificPriceRuleConditionGroupPK getPsSpecificPriceRuleConditionGroupPK() {
        return psSpecificPriceRuleConditionGroupPK;
    }

    public void setPsSpecificPriceRuleConditionGroupPK(PsSpecificPriceRuleConditionGroupPK psSpecificPriceRuleConditionGroupPK) {
        this.psSpecificPriceRuleConditionGroupPK = psSpecificPriceRuleConditionGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSpecificPriceRuleConditionGroupPK != null ? psSpecificPriceRuleConditionGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPriceRuleConditionGroup)) {
            return false;
        }
        PsSpecificPriceRuleConditionGroup other = (PsSpecificPriceRuleConditionGroup) object;
        if ((this.psSpecificPriceRuleConditionGroupPK == null && other.psSpecificPriceRuleConditionGroupPK != null) || (this.psSpecificPriceRuleConditionGroupPK != null && !this.psSpecificPriceRuleConditionGroupPK.equals(other.psSpecificPriceRuleConditionGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPriceRuleConditionGroup[ psSpecificPriceRuleConditionGroupPK=" + psSpecificPriceRuleConditionGroupPK + " ]";
    }
    
}
