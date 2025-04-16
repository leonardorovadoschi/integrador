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
 * @author leo-note
 */
@Embeddable
public class PsAndropdownLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_andropdown")
    private int idAndropdown;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAndropdownLangPK() {
    }

    public PsAndropdownLangPK(int idAndropdown, int idLang) {
        this.idAndropdown = idAndropdown;
        this.idLang = idLang;
    }

    public int getIdAndropdown() {
        return idAndropdown;
    }

    public void setIdAndropdown(int idAndropdown) {
        this.idAndropdown = idAndropdown;
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
        hash += (int) idAndropdown;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAndropdownLangPK)) {
            return false;
        }
        PsAndropdownLangPK other = (PsAndropdownLangPK) object;
        if (this.idAndropdown != other.idAndropdown) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAndropdownLangPK[ idAndropdown=" + idAndropdown + ", idLang=" + idLang + " ]";
    }
    
}
