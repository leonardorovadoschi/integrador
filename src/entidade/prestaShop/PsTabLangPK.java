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
public class PsTabLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_tab")
    private int idTab;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsTabLangPK() {
    }

    public PsTabLangPK(int idTab, int idLang) {
        this.idTab = idTab;
        this.idLang = idLang;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTab;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTabLangPK)) {
            return false;
        }
        PsTabLangPK other = (PsTabLangPK) object;
        if (this.idTab != other.idTab) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTabLangPK[ idTab=" + idTab + ", idLang=" + idLang + " ]";
    }
    
}
