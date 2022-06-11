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
@Table(name = "ps_cart_rule_combination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleCombination.findAll", query = "SELECT p FROM PsCartRuleCombination p")
    , @NamedQuery(name = "PsCartRuleCombination.findByIdCartRule1", query = "SELECT p FROM PsCartRuleCombination p WHERE p.psCartRuleCombinationPK.idCartRule1 = :idCartRule1")
    , @NamedQuery(name = "PsCartRuleCombination.findByIdCartRule2", query = "SELECT p FROM PsCartRuleCombination p WHERE p.psCartRuleCombinationPK.idCartRule2 = :idCartRule2")})
public class PsCartRuleCombination implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleCombinationPK psCartRuleCombinationPK;

    public PsCartRuleCombination() {
    }

    public PsCartRuleCombination(PsCartRuleCombinationPK psCartRuleCombinationPK) {
        this.psCartRuleCombinationPK = psCartRuleCombinationPK;
    }

    public PsCartRuleCombination(int idCartRule1, int idCartRule2) {
        this.psCartRuleCombinationPK = new PsCartRuleCombinationPK(idCartRule1, idCartRule2);
    }

    public PsCartRuleCombinationPK getPsCartRuleCombinationPK() {
        return psCartRuleCombinationPK;
    }

    public void setPsCartRuleCombinationPK(PsCartRuleCombinationPK psCartRuleCombinationPK) {
        this.psCartRuleCombinationPK = psCartRuleCombinationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartRuleCombinationPK != null ? psCartRuleCombinationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleCombination)) {
            return false;
        }
        PsCartRuleCombination other = (PsCartRuleCombination) object;
        if ((this.psCartRuleCombinationPK == null && other.psCartRuleCombinationPK != null) || (this.psCartRuleCombinationPK != null && !this.psCartRuleCombinationPK.equals(other.psCartRuleCombinationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleCombination[ psCartRuleCombinationPK=" + psCartRuleCombinationPK + " ]";
    }
    
}
