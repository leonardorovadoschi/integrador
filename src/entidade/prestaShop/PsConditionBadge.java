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
@Table(name = "ps_condition_badge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConditionBadge.findAll", query = "SELECT p FROM PsConditionBadge p")
    , @NamedQuery(name = "PsConditionBadge.findByIdCondition", query = "SELECT p FROM PsConditionBadge p WHERE p.psConditionBadgePK.idCondition = :idCondition")
    , @NamedQuery(name = "PsConditionBadge.findByIdBadge", query = "SELECT p FROM PsConditionBadge p WHERE p.psConditionBadgePK.idBadge = :idBadge")})
public class PsConditionBadge implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConditionBadgePK psConditionBadgePK;

    public PsConditionBadge() {
    }

    public PsConditionBadge(PsConditionBadgePK psConditionBadgePK) {
        this.psConditionBadgePK = psConditionBadgePK;
    }

    public PsConditionBadge(int idCondition, int idBadge) {
        this.psConditionBadgePK = new PsConditionBadgePK(idCondition, idBadge);
    }

    public PsConditionBadgePK getPsConditionBadgePK() {
        return psConditionBadgePK;
    }

    public void setPsConditionBadgePK(PsConditionBadgePK psConditionBadgePK) {
        this.psConditionBadgePK = psConditionBadgePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psConditionBadgePK != null ? psConditionBadgePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConditionBadge)) {
            return false;
        }
        PsConditionBadge other = (PsConditionBadge) object;
        if ((this.psConditionBadgePK == null && other.psConditionBadgePK != null) || (this.psConditionBadgePK != null && !this.psConditionBadgePK.equals(other.psConditionBadgePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConditionBadge[ psConditionBadgePK=" + psConditionBadgePK + " ]";
    }
    
}
