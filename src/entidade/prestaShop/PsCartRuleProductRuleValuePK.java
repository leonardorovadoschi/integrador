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
public class PsCartRuleProductRuleValuePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product_rule")
    private int idProductRule;
    @Basic(optional = false)
    @Column(name = "id_item")
    private int idItem;

    public PsCartRuleProductRuleValuePK() {
    }

    public PsCartRuleProductRuleValuePK(int idProductRule, int idItem) {
        this.idProductRule = idProductRule;
        this.idItem = idItem;
    }

    public int getIdProductRule() {
        return idProductRule;
    }

    public void setIdProductRule(int idProductRule) {
        this.idProductRule = idProductRule;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductRule;
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleProductRuleValuePK)) {
            return false;
        }
        PsCartRuleProductRuleValuePK other = (PsCartRuleProductRuleValuePK) object;
        if (this.idProductRule != other.idProductRule) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleProductRuleValuePK[ idProductRule=" + idProductRule + ", idItem=" + idItem + " ]";
    }
    
}
