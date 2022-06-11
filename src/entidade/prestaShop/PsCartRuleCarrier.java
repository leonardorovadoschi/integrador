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
@Table(name = "ps_cart_rule_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleCarrier.findAll", query = "SELECT p FROM PsCartRuleCarrier p")
    , @NamedQuery(name = "PsCartRuleCarrier.findByIdCartRule", query = "SELECT p FROM PsCartRuleCarrier p WHERE p.psCartRuleCarrierPK.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleCarrier.findByIdCarrier", query = "SELECT p FROM PsCartRuleCarrier p WHERE p.psCartRuleCarrierPK.idCarrier = :idCarrier")})
public class PsCartRuleCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleCarrierPK psCartRuleCarrierPK;

    public PsCartRuleCarrier() {
    }

    public PsCartRuleCarrier(PsCartRuleCarrierPK psCartRuleCarrierPK) {
        this.psCartRuleCarrierPK = psCartRuleCarrierPK;
    }

    public PsCartRuleCarrier(int idCartRule, int idCarrier) {
        this.psCartRuleCarrierPK = new PsCartRuleCarrierPK(idCartRule, idCarrier);
    }

    public PsCartRuleCarrierPK getPsCartRuleCarrierPK() {
        return psCartRuleCarrierPK;
    }

    public void setPsCartRuleCarrierPK(PsCartRuleCarrierPK psCartRuleCarrierPK) {
        this.psCartRuleCarrierPK = psCartRuleCarrierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleCarrierPK != null ? psCartRuleCarrierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCarrier)) {
            return false;
        }
        PsCartRuleCarrier other = (PsCartRuleCarrier) object;
        if ((this.psCartRuleCarrierPK == null && other.psCartRuleCarrierPK != null) || (this.psCartRuleCarrierPK != null && !this.psCartRuleCarrierPK.equals(other.psCartRuleCarrierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCarrier[ psCartRuleCarrierPK=" + psCartRuleCarrierPK + " ]";
    }
    
}
