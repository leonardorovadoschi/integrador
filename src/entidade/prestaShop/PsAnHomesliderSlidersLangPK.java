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
public class PsAnHomesliderSlidersLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_slider")
    private int idSlider;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnHomesliderSlidersLangPK() {
    }

    public PsAnHomesliderSlidersLangPK(int idSlider, String idLang) {
        this.idSlider = idSlider;
        this.idLang = idLang;
    }

    public int getIdSlider() {
        return idSlider;
    }

    public void setIdSlider(int idSlider) {
        this.idSlider = idSlider;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSlider;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidersLangPK)) {
            return false;
        }
        PsAnHomesliderSlidersLangPK other = (PsAnHomesliderSlidersLangPK) object;
        if (this.idSlider != other.idSlider) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidersLangPK[ idSlider=" + idSlider + ", idLang=" + idLang + " ]";
    }
    
}
