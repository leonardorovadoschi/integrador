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
@Table(name = "ps_specific_price_rule_condition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSpecificPriceRuleCondition.findAll", query = "SELECT p FROM PsSpecificPriceRuleCondition p")
    , @NamedQuery(name = "PsSpecificPriceRuleCondition.findByIdSpecificPriceRuleCondition", query = "SELECT p FROM PsSpecificPriceRuleCondition p WHERE p.idSpecificPriceRuleCondition = :idSpecificPriceRuleCondition")
    , @NamedQuery(name = "PsSpecificPriceRuleCondition.findByIdSpecificPriceRuleConditionGroup", query = "SELECT p FROM PsSpecificPriceRuleCondition p WHERE p.idSpecificPriceRuleConditionGroup = :idSpecificPriceRuleConditionGroup")
    , @NamedQuery(name = "PsSpecificPriceRuleCondition.findByType", query = "SELECT p FROM PsSpecificPriceRuleCondition p WHERE p.type = :type")
    , @NamedQuery(name = "PsSpecificPriceRuleCondition.findByValue", query = "SELECT p FROM PsSpecificPriceRuleCondition p WHERE p.value = :value")})
public class PsSpecificPriceRuleCondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_specific_price_rule_condition")
    private Integer idSpecificPriceRuleCondition;
    @Basic(optional = false)
    @Column(name = "id_specific_price_rule_condition_group")
    private int idSpecificPriceRuleConditionGroup;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;

    public PsSpecificPriceRuleCondition() {
    }

    public PsSpecificPriceRuleCondition(Integer idSpecificPriceRuleCondition) {
        this.idSpecificPriceRuleCondition = idSpecificPriceRuleCondition;
    }

    public PsSpecificPriceRuleCondition(Integer idSpecificPriceRuleCondition, int idSpecificPriceRuleConditionGroup, String type, String value) {
        this.idSpecificPriceRuleCondition = idSpecificPriceRuleCondition;
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
        this.type = type;
        this.value = value;
    }

    public Integer getIdSpecificPriceRuleCondition() {
        return idSpecificPriceRuleCondition;
    }

    public void setIdSpecificPriceRuleCondition(Integer idSpecificPriceRuleCondition) {
        this.idSpecificPriceRuleCondition = idSpecificPriceRuleCondition;
    }

    public int getIdSpecificPriceRuleConditionGroup() {
        return idSpecificPriceRuleConditionGroup;
    }

    public void setIdSpecificPriceRuleConditionGroup(int idSpecificPriceRuleConditionGroup) {
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecificPriceRuleCondition != null ? idSpecificPriceRuleCondition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPriceRuleCondition)) {
            return false;
        }
        PsSpecificPriceRuleCondition other = (PsSpecificPriceRuleCondition) object;
        if ((this.idSpecificPriceRuleCondition == null && other.idSpecificPriceRuleCondition != null) || (this.idSpecificPriceRuleCondition != null && !this.idSpecificPriceRuleCondition.equals(other.idSpecificPriceRuleCondition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPriceRuleCondition[ idSpecificPriceRuleCondition=" + idSpecificPriceRuleCondition + " ]";
    }
    
}
