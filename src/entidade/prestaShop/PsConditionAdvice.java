/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ps_condition_advice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConditionAdvice.findAll", query = "SELECT p FROM PsConditionAdvice p")
    , @NamedQuery(name = "PsConditionAdvice.findByIdCondition", query = "SELECT p FROM PsConditionAdvice p WHERE p.psConditionAdvicePK.idCondition = :idCondition")
    , @NamedQuery(name = "PsConditionAdvice.findByIdAdvice", query = "SELECT p FROM PsConditionAdvice p WHERE p.psConditionAdvicePK.idAdvice = :idAdvice")
    , @NamedQuery(name = "PsConditionAdvice.findByDisplay", query = "SELECT p FROM PsConditionAdvice p WHERE p.display = :display")})
public class PsConditionAdvice implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConditionAdvicePK psConditionAdvicePK;
    @Basic(optional = false)
    @Column(name = "display")
    private boolean display;

    public PsConditionAdvice() {
    }

    public PsConditionAdvice(PsConditionAdvicePK psConditionAdvicePK) {
        this.psConditionAdvicePK = psConditionAdvicePK;
    }

    public PsConditionAdvice(PsConditionAdvicePK psConditionAdvicePK, boolean display) {
        this.psConditionAdvicePK = psConditionAdvicePK;
        this.display = display;
    }

    public PsConditionAdvice(int idCondition, int idAdvice) {
        this.psConditionAdvicePK = new PsConditionAdvicePK(idCondition, idAdvice);
    }

    public PsConditionAdvicePK getPsConditionAdvicePK() {
        return psConditionAdvicePK;
    }

    public void setPsConditionAdvicePK(PsConditionAdvicePK psConditionAdvicePK) {
        this.psConditionAdvicePK = psConditionAdvicePK;
    }

    public boolean getDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psConditionAdvicePK != null ? psConditionAdvicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConditionAdvice)) {
            return false;
        }
        PsConditionAdvice other = (PsConditionAdvice) object;
        if ((this.psConditionAdvicePK == null && other.psConditionAdvicePK != null) || (this.psConditionAdvicePK != null && !this.psConditionAdvicePK.equals(other.psConditionAdvicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConditionAdvice[ psConditionAdvicePK=" + psConditionAdvicePK + " ]";
    }
    
}
