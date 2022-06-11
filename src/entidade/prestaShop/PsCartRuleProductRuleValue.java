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
@Table(name = "ps_cart_rule_product_rule_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleProductRuleValue.findAll", query = "SELECT p FROM PsCartRuleProductRuleValue p")
    , @NamedQuery(name = "PsCartRuleProductRuleValue.findByIdProductRule", query = "SELECT p FROM PsCartRuleProductRuleValue p WHERE p.psCartRuleProductRuleValuePK.idProductRule = :idProductRule")
    , @NamedQuery(name = "PsCartRuleProductRuleValue.findByIdItem", query = "SELECT p FROM PsCartRuleProductRuleValue p WHERE p.psCartRuleProductRuleValuePK.idItem = :idItem")})
public class PsCartRuleProductRuleValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleProductRuleValuePK psCartRuleProductRuleValuePK;

    public PsCartRuleProductRuleValue() {
    }

    public PsCartRuleProductRuleValue(PsCartRuleProductRuleValuePK psCartRuleProductRuleValuePK) {
        this.psCartRuleProductRuleValuePK = psCartRuleProductRuleValuePK;
    }

    public PsCartRuleProductRuleValue(int idProductRule, int idItem) {
        this.psCartRuleProductRuleValuePK = new PsCartRuleProductRuleValuePK(idProductRule, idItem);
    }

    public PsCartRuleProductRuleValuePK getPsCartRuleProductRuleValuePK() {
        return psCartRuleProductRuleValuePK;
    }

    public void setPsCartRuleProductRuleValuePK(PsCartRuleProductRuleValuePK psCartRuleProductRuleValuePK) {
        this.psCartRuleProductRuleValuePK = psCartRuleProductRuleValuePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleProductRuleValuePK != null ? psCartRuleProductRuleValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleProductRuleValue)) {
            return false;
        }
        PsCartRuleProductRuleValue other = (PsCartRuleProductRuleValue) object;
        if ((this.psCartRuleProductRuleValuePK == null && other.psCartRuleProductRuleValuePK != null) || (this.psCartRuleProductRuleValuePK != null && !this.psCartRuleProductRuleValuePK.equals(other.psCartRuleProductRuleValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleProductRuleValue[ psCartRuleProductRuleValuePK=" + psCartRuleProductRuleValuePK + " ]";
    }
    
}
