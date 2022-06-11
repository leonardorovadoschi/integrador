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
@Table(name = "ps_tax_rules_group_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTaxRulesGroupShop.findAll", query = "SELECT p FROM PsTaxRulesGroupShop p")
    , @NamedQuery(name = "PsTaxRulesGroupShop.findByIdTaxRulesGroup", query = "SELECT p FROM PsTaxRulesGroupShop p WHERE p.psTaxRulesGroupShopPK.idTaxRulesGroup = :idTaxRulesGroup")
    , @NamedQuery(name = "PsTaxRulesGroupShop.findByIdShop", query = "SELECT p FROM PsTaxRulesGroupShop p WHERE p.psTaxRulesGroupShopPK.idShop = :idShop")})
public class PsTaxRulesGroupShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsTaxRulesGroupShopPK psTaxRulesGroupShopPK;

    public PsTaxRulesGroupShop() {
    }

    public PsTaxRulesGroupShop(PsTaxRulesGroupShopPK psTaxRulesGroupShopPK) {
        this.psTaxRulesGroupShopPK = psTaxRulesGroupShopPK;
    }

    public PsTaxRulesGroupShop(int idTaxRulesGroup, int idShop) {
        this.psTaxRulesGroupShopPK = new PsTaxRulesGroupShopPK(idTaxRulesGroup, idShop);
    }

    public PsTaxRulesGroupShopPK getPsTaxRulesGroupShopPK() {
        return psTaxRulesGroupShopPK;
    }

    public void setPsTaxRulesGroupShopPK(PsTaxRulesGroupShopPK psTaxRulesGroupShopPK) {
        this.psTaxRulesGroupShopPK = psTaxRulesGroupShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psTaxRulesGroupShopPK != null ? psTaxRulesGroupShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTaxRulesGroupShop)) {
            return false;
        }
        PsTaxRulesGroupShop other = (PsTaxRulesGroupShop) object;
        if ((this.psTaxRulesGroupShopPK == null && other.psTaxRulesGroupShopPK != null) || (this.psTaxRulesGroupShopPK != null && !this.psTaxRulesGroupShopPK.equals(other.psTaxRulesGroupShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTaxRulesGroupShop[ psTaxRulesGroupShopPK=" + psTaxRulesGroupShopPK + " ]";
    }
    
}
