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
public class PsAnHomesliderSlidesLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_slide")
    private int idSlide;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnHomesliderSlidesLangPK() {
    }

    public PsAnHomesliderSlidesLangPK(int idSlide, String idLang) {
        this.idSlide = idSlide;
        this.idLang = idLang;
    }

    public int getIdSlide() {
        return idSlide;
    }

    public void setIdSlide(int idSlide) {
        this.idSlide = idSlide;
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
        hash += (int) idSlide;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidesLangPK)) {
            return false;
        }
        PsAnHomesliderSlidesLangPK other = (PsAnHomesliderSlidesLangPK) object;
        if (this.idSlide != other.idSlide) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidesLangPK[ idSlide=" + idSlide + ", idLang=" + idLang + " ]";
    }
    
}
