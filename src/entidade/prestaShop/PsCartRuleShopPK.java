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
public class PsCartRuleShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCartRuleShopPK() {
    }

    public PsCartRuleShopPK(int idCartRule, int idShop) {
        this.idCartRule = idCartRule;
        this.idShop = idShop;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCartRule;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleShopPK)) {
            return false;
        }
        PsCartRuleShopPK other = (PsCartRuleShopPK) object;
        if (this.idCartRule != other.idCartRule) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleShopPK[ idCartRule=" + idCartRule + ", idShop=" + idShop + " ]";
    }
    
}
