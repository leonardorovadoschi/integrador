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
@Table(name = "ps_tab_advice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTabAdvice.findAll", query = "SELECT p FROM PsTabAdvice p")
    , @NamedQuery(name = "PsTabAdvice.findByIdTab", query = "SELECT p FROM PsTabAdvice p WHERE p.psTabAdvicePK.idTab = :idTab")
    , @NamedQuery(name = "PsTabAdvice.findByIdAdvice", query = "SELECT p FROM PsTabAdvice p WHERE p.psTabAdvicePK.idAdvice = :idAdvice")})
public class PsTabAdvice implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsTabAdvicePK psTabAdvicePK;

    public PsTabAdvice() {
    }

    public PsTabAdvice(PsTabAdvicePK psTabAdvicePK) {
        this.psTabAdvicePK = psTabAdvicePK;
    }

    public PsTabAdvice(int idTab, int idAdvice) {
        this.psTabAdvicePK = new PsTabAdvicePK(idTab, idAdvice);
    }

    public PsTabAdvicePK getPsTabAdvicePK() {
        return psTabAdvicePK;
    }

    public void setPsTabAdvicePK(PsTabAdvicePK psTabAdvicePK) {
        this.psTabAdvicePK = psTabAdvicePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psTabAdvicePK != null ? psTabAdvicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTabAdvice)) {
            return false;
        }
        PsTabAdvice other = (PsTabAdvice) object;
        if ((this.psTabAdvicePK == null && other.psTabAdvicePK != null) || (this.psTabAdvicePK != null && !this.psTabAdvicePK.equals(other.psTabAdvicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTabAdvice[ psTabAdvicePK=" + psTabAdvicePK + " ]";
    }
    
}
