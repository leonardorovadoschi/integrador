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
@Table(name = "ps_cart_rule_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleCountry.findAll", query = "SELECT p FROM PsCartRuleCountry p")
    , @NamedQuery(name = "PsCartRuleCountry.findByIdCartRule", query = "SELECT p FROM PsCartRuleCountry p WHERE p.psCartRuleCountryPK.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleCountry.findByIdCountry", query = "SELECT p FROM PsCartRuleCountry p WHERE p.psCartRuleCountryPK.idCountry = :idCountry")})
public class PsCartRuleCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleCountryPK psCartRuleCountryPK;

    public PsCartRuleCountry() {
    }

    public PsCartRuleCountry(PsCartRuleCountryPK psCartRuleCountryPK) {
        this.psCartRuleCountryPK = psCartRuleCountryPK;
    }

    public PsCartRuleCountry(int idCartRule, int idCountry) {
        this.psCartRuleCountryPK = new PsCartRuleCountryPK(idCartRule, idCountry);
    }

    public PsCartRuleCountryPK getPsCartRuleCountryPK() {
        return psCartRuleCountryPK;
    }

    public void setPsCartRuleCountryPK(PsCartRuleCountryPK psCartRuleCountryPK) {
        this.psCartRuleCountryPK = psCartRuleCountryPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleCountryPK != null ? psCartRuleCountryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCountry)) {
            return false;
        }
        PsCartRuleCountry other = (PsCartRuleCountry) object;
        if ((this.psCartRuleCountryPK == null && other.psCartRuleCountryPK != null) || (this.psCartRuleCountryPK != null && !this.psCartRuleCountryPK.equals(other.psCartRuleCountryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCountry[ psCartRuleCountryPK=" + psCartRuleCountryPK + " ]";
    }
    
}
