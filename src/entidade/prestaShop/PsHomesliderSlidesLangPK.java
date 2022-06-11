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
public class PsHomesliderSlidesLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_homeslider_slides")
    private int idHomesliderSlides;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsHomesliderSlidesLangPK() {
    }

    public PsHomesliderSlidesLangPK(int idHomesliderSlides, int idLang) {
        this.idHomesliderSlides = idHomesliderSlides;
        this.idLang = idLang;
    }

    public int getIdHomesliderSlides() {
        return idHomesliderSlides;
    }

    public void setIdHomesliderSlides(int idHomesliderSlides) {
        this.idHomesliderSlides = idHomesliderSlides;
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
        hash += (int) idHomesliderSlides;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHomesliderSlidesLangPK)) {
            return false;
        }
        PsHomesliderSlidesLangPK other = (PsHomesliderSlidesLangPK) object;
        if (this.idHomesliderSlides != other.idHomesliderSlides) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHomesliderSlidesLangPK[ idHomesliderSlides=" + idHomesliderSlides + ", idLang=" + idLang + " ]";
    }
    
}
