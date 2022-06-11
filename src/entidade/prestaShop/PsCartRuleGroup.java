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
@Table(name = "ps_cart_rule_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleGroup.findAll", query = "SELECT p FROM PsCartRuleGroup p")
    , @NamedQuery(name = "PsCartRuleGroup.findByIdCartRule", query = "SELECT p FROM PsCartRuleGroup p WHERE p.psCartRuleGroupPK.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleGroup.findByIdGroup", query = "SELECT p FROM PsCartRuleGroup p WHERE p.psCartRuleGroupPK.idGroup = :idGroup")})
public class PsCartRuleGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleGroupPK psCartRuleGroupPK;

    public PsCartRuleGroup() {
    }

    public PsCartRuleGroup(PsCartRuleGroupPK psCartRuleGroupPK) {
        this.psCartRuleGroupPK = psCartRuleGroupPK;
    }

    public PsCartRuleGroup(int idCartRule, int idGroup) {
        this.psCartRuleGroupPK = new PsCartRuleGroupPK(idCartRule, idGroup);
    }

    public PsCartRuleGroupPK getPsCartRuleGroupPK() {
        return psCartRuleGroupPK;
    }

    public void setPsCartRuleGroupPK(PsCartRuleGroupPK psCartRuleGroupPK) {
        this.psCartRuleGroupPK = psCartRuleGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleGroupPK != null ? psCartRuleGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleGroup)) {
            return false;
        }
        PsCartRuleGroup other = (PsCartRuleGroup) object;
        if ((this.psCartRuleGroupPK == null && other.psCartRuleGroupPK != null) || (this.psCartRuleGroupPK != null && !this.psCartRuleGroupPK.equals(other.psCartRuleGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleGroup[ psCartRuleGroupPK=" + psCartRuleGroupPK + " ]";
    }
    
}
