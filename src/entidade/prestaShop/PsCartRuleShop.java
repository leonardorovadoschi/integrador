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
@Table(name = "ps_cart_rule_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleShop.findAll", query = "SELECT p FROM PsCartRuleShop p")
    , @NamedQuery(name = "PsCartRuleShop.findByIdCartRule", query = "SELECT p FROM PsCartRuleShop p WHERE p.psCartRuleShopPK.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleShop.findByIdShop", query = "SELECT p FROM PsCartRuleShop p WHERE p.psCartRuleShopPK.idShop = :idShop")})
public class PsCartRuleShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleShopPK psCartRuleShopPK;

    public PsCartRuleShop() {
    }

    public PsCartRuleShop(PsCartRuleShopPK psCartRuleShopPK) {
        this.psCartRuleShopPK = psCartRuleShopPK;
    }

    public PsCartRuleShop(int idCartRule, int idShop) {
        this.psCartRuleShopPK = new PsCartRuleShopPK(idCartRule, idShop);
    }

    public PsCartRuleShopPK getPsCartRuleShopPK() {
        return psCartRuleShopPK;
    }

    public void setPsCartRuleShopPK(PsCartRuleShopPK psCartRuleShopPK) {
        this.psCartRuleShopPK = psCartRuleShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleShopPK != null ? psCartRuleShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleShop)) {
            return false;
        }
        PsCartRuleShop other = (PsCartRuleShop) object;
        if ((this.psCartRuleShopPK == null && other.psCartRuleShopPK != null) || (this.psCartRuleShopPK != null && !this.psCartRuleShopPK.equals(other.psCartRuleShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleShop[ psCartRuleShopPK=" + psCartRuleShopPK + " ]";
    }
    
}
