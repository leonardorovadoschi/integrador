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
public class PsCartRuleCountryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;

    public PsCartRuleCountryPK() {
    }

    public PsCartRuleCountryPK(int idCartRule, int idCountry) {
        this.idCartRule = idCartRule;
        this.idCountry = idCountry;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCartRule;
        hash += (int) idCountry;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCountryPK)) {
            return false;
        }
        PsCartRuleCountryPK other = (PsCartRuleCountryPK) object;
        if (this.idCartRule != other.idCartRule) {
            return false;
        }
        if (this.idCountry != other.idCountry) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCountryPK[ idCartRule=" + idCartRule + ", idCountry=" + idCountry + " ]";
    }
    
}
