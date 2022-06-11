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
@Table(name = "ps_cart_cart_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartCartRule.findAll", query = "SELECT p FROM PsCartCartRule p")
    , @NamedQuery(name = "PsCartCartRule.findByIdCart", query = "SELECT p FROM PsCartCartRule p WHERE p.psCartCartRulePK.idCart = :idCart")
    , @NamedQuery(name = "PsCartCartRule.findByIdCartRule", query = "SELECT p FROM PsCartCartRule p WHERE p.psCartCartRulePK.idCartRule = :idCartRule")})
public class PsCartCartRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartCartRulePK psCartCartRulePK;

    public PsCartCartRule() {
    }

    public PsCartCartRule(PsCartCartRulePK psCartCartRulePK) {
        this.psCartCartRulePK = psCartCartRulePK;
    }

    public PsCartCartRule(int idCart, int idCartRule) {
        this.psCartCartRulePK = new PsCartCartRulePK(idCart, idCartRule);
    }

    public PsCartCartRulePK getPsCartCartRulePK() {
        return psCartCartRulePK;
    }

    public void setPsCartCartRulePK(PsCartCartRulePK psCartCartRulePK) {
        this.psCartCartRulePK = psCartCartRulePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartCartRulePK != null ? psCartCartRulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartCartRule)) {
            return false;
        }
        PsCartCartRule other = (PsCartCartRule) object;
        if ((this.psCartCartRulePK == null && other.psCartCartRulePK != null) || (this.psCartCartRulePK != null && !this.psCartCartRulePK.equals(other.psCartCartRulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartCartRule[ psCartCartRulePK=" + psCartCartRulePK + " ]";
    }
    
}
