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
@Table(name = "ps_cart_rule_product_rule_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleProductRuleGroup.findAll", query = "SELECT p FROM PsCartRuleProductRuleGroup p")
    , @NamedQuery(name = "PsCartRuleProductRuleGroup.findByIdProductRuleGroup", query = "SELECT p FROM PsCartRuleProductRuleGroup p WHERE p.idProductRuleGroup = :idProductRuleGroup")
    , @NamedQuery(name = "PsCartRuleProductRuleGroup.findByIdCartRule", query = "SELECT p FROM PsCartRuleProductRuleGroup p WHERE p.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleProductRuleGroup.findByQuantity", query = "SELECT p FROM PsCartRuleProductRuleGroup p WHERE p.quantity = :quantity")})
public class PsCartRuleProductRuleGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_rule_group")
    private Integer idProductRuleGroup;
    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;

    public PsCartRuleProductRuleGroup() {
    }

    public PsCartRuleProductRuleGroup(Integer idProductRuleGroup) {
        this.idProductRuleGroup = idProductRuleGroup;
    }

    public PsCartRuleProductRuleGroup(Integer idProductRuleGroup, int idCartRule, int quantity) {
        this.idProductRuleGroup = idProductRuleGroup;
        this.idCartRule = idCartRule;
        this.quantity = quantity;
    }

    public Integer getIdProductRuleGroup() {
        return idProductRuleGroup;
    }

    public void setIdProductRuleGroup(Integer idProductRuleGroup) {
        this.idProductRuleGroup = idProductRuleGroup;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductRuleGroup != null ? idProductRuleGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleProductRuleGroup)) {
            return false;
        }
        PsCartRuleProductRuleGroup other = (PsCartRuleProductRuleGroup) object;
        if ((this.idProductRuleGroup == null && other.idProductRuleGroup != null) || (this.idProductRuleGroup != null && !this.idProductRuleGroup.equals(other.idProductRuleGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleProductRuleGroup[ idProductRuleGroup=" + idProductRuleGroup + " ]";
    }
    
}
