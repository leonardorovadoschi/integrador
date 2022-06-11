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
@Table(name = "ps_carrier_tax_rules_group_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrierTaxRulesGroupShop.findAll", query = "SELECT p FROM PsCarrierTaxRulesGroupShop p")
    , @NamedQuery(name = "PsCarrierTaxRulesGroupShop.findByIdCarrier", query = "SELECT p FROM PsCarrierTaxRulesGroupShop p WHERE p.psCarrierTaxRulesGroupShopPK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrierTaxRulesGroupShop.findByIdTaxRulesGroup", query = "SELECT p FROM PsCarrierTaxRulesGroupShop p WHERE p.psCarrierTaxRulesGroupShopPK.idTaxRulesGroup = :idTaxRulesGroup")
    , @NamedQuery(name = "PsCarrierTaxRulesGroupShop.findByIdShop", query = "SELECT p FROM PsCarrierTaxRulesGroupShop p WHERE p.psCarrierTaxRulesGroupShopPK.idShop = :idShop")})
public class PsCarrierTaxRulesGroupShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCarrierTaxRulesGroupShopPK psCarrierTaxRulesGroupShopPK;

    public PsCarrierTaxRulesGroupShop() {
    }

    public PsCarrierTaxRulesGroupShop(PsCarrierTaxRulesGroupShopPK psCarrierTaxRulesGroupShopPK) {
        this.psCarrierTaxRulesGroupShopPK = psCarrierTaxRulesGroupShopPK;
    }

    public PsCarrierTaxRulesGroupShop(int idCarrier, int idTaxRulesGroup, int idShop) {
        this.psCarrierTaxRulesGroupShopPK = new PsCarrierTaxRulesGroupShopPK(idCarrier, idTaxRulesGroup, idShop);
    }

    public PsCarrierTaxRulesGroupShopPK getPsCarrierTaxRulesGroupShopPK() {
        return psCarrierTaxRulesGroupShopPK;
    }

    public void setPsCarrierTaxRulesGroupShopPK(PsCarrierTaxRulesGroupShopPK psCarrierTaxRulesGroupShopPK) {
        this.psCarrierTaxRulesGroupShopPK = psCarrierTaxRulesGroupShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCarrierTaxRulesGroupShopPK != null ? psCarrierTaxRulesGroupShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierTaxRulesGroupShop)) {
            return false;
        }
        PsCarrierTaxRulesGroupShop other = (PsCarrierTaxRulesGroupShop) object;
        if ((this.psCarrierTaxRulesGroupShopPK == null && other.psCarrierTaxRulesGroupShopPK != null) || (this.psCarrierTaxRulesGroupShopPK != null && !this.psCarrierTaxRulesGroupShopPK.equals(other.psCarrierTaxRulesGroupShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierTaxRulesGroupShop[ psCarrierTaxRulesGroupShopPK=" + psCarrierTaxRulesGroupShopPK + " ]";
    }
    
}
