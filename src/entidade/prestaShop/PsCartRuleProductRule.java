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
@Table(name = "ps_cart_rule_product_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleProductRule.findAll", query = "SELECT p FROM PsCartRuleProductRule p")
    , @NamedQuery(name = "PsCartRuleProductRule.findByIdProductRule", query = "SELECT p FROM PsCartRuleProductRule p WHERE p.idProductRule = :idProductRule")
    , @NamedQuery(name = "PsCartRuleProductRule.findByIdProductRuleGroup", query = "SELECT p FROM PsCartRuleProductRule p WHERE p.idProductRuleGroup = :idProductRuleGroup")
    , @NamedQuery(name = "PsCartRuleProductRule.findByType", query = "SELECT p FROM PsCartRuleProductRule p WHERE p.type = :type")})
public class PsCartRuleProductRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_rule")
    private Integer idProductRule;
    @Basic(optional = false)
    @Column(name = "id_product_rule_group")
    private int idProductRuleGroup;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public PsCartRuleProductRule() {
    }

    public PsCartRuleProductRule(Integer idProductRule) {
        this.idProductRule = idProductRule;
    }

    public PsCartRuleProductRule(Integer idProductRule, int idProductRuleGroup, String type) {
        this.idProductRule = idProductRule;
        this.idProductRuleGroup = idProductRuleGroup;
        this.type = type;
    }

    public Integer getIdProductRule() {
        return idProductRule;
    }

    public void setIdProductRule(Integer idProductRule) {
        this.idProductRule = idProductRule;
    }

    public int getIdProductRuleGroup() {
        return idProductRuleGroup;
    }

    public void setIdProductRuleGroup(int idProductRuleGroup) {
        this.idProductRuleGroup = idProductRuleGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductRule != null ? idProductRule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleProductRule)) {
            return false;
        }
        PsCartRuleProductRule other = (PsCartRuleProductRule) object;
        if ((this.idProductRule == null && other.idProductRule != null) || (this.idProductRule != null && !this.idProductRule.equals(other.idProductRule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleProductRule[ idProductRule=" + idProductRule + " ]";
    }
    
}
