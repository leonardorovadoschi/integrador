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
public class PsTabAdvicePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_tab")
    private int idTab;
    @Basic(optional = false)
    @Column(name = "id_advice")
    private int idAdvice;

    public PsTabAdvicePK() {
    }

    public PsTabAdvicePK(int idTab, int idAdvice) {
        this.idTab = idTab;
        this.idAdvice = idAdvice;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public int getIdAdvice() {
        return idAdvice;
    }

    public void setIdAdvice(int idAdvice) {
        this.idAdvice = idAdvice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTab;
        hash += (int) idAdvice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTabAdvicePK)) {
            return false;
        }
        PsTabAdvicePK other = (PsTabAdvicePK) object;
        if (this.idTab != other.idTab) {
            return false;
        }
        if (this.idAdvice != other.idAdvice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTabAdvicePK[ idTab=" + idTab + ", idAdvice=" + idAdvice + " ]";
    }
    
}
