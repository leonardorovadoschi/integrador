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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_homeslider_sliders_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSlidersLang.findAll", query = "SELECT p FROM PsAnHomesliderSlidersLang p")})
public class PsAnHomesliderSlidersLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomesliderSlidersLangPK psAnHomesliderSlidersLangPK;
    @Basic(optional = false)
    @Column(name = "title_slider")
    private String titleSlider;

    public PsAnHomesliderSlidersLang() {
    }

    public PsAnHomesliderSlidersLang(PsAnHomesliderSlidersLangPK psAnHomesliderSlidersLangPK) {
        this.psAnHomesliderSlidersLangPK = psAnHomesliderSlidersLangPK;
    }

    public PsAnHomesliderSlidersLang(PsAnHomesliderSlidersLangPK psAnHomesliderSlidersLangPK, String titleSlider) {
        this.psAnHomesliderSlidersLangPK = psAnHomesliderSlidersLangPK;
        this.titleSlider = titleSlider;
    }

    public PsAnHomesliderSlidersLang(int idSlider, String idLang) {
        this.psAnHomesliderSlidersLangPK = new PsAnHomesliderSlidersLangPK(idSlider, idLang);
    }

    public PsAnHomesliderSlidersLangPK getPsAnHomesliderSlidersLangPK() {
        return psAnHomesliderSlidersLangPK;
    }

    public void setPsAnHomesliderSlidersLangPK(PsAnHomesliderSlidersLangPK psAnHomesliderSlidersLangPK) {
        this.psAnHomesliderSlidersLangPK = psAnHomesliderSlidersLangPK;
    }

    public String getTitleSlider() {
        return titleSlider;
    }

    public void setTitleSlider(String titleSlider) {
        this.titleSlider = titleSlider;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomesliderSlidersLangPK != null ? psAnHomesliderSlidersLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidersLang)) {
            return false;
        }
        PsAnHomesliderSlidersLang other = (PsAnHomesliderSlidersLang) object;
        if ((this.psAnHomesliderSlidersLangPK == null && other.psAnHomesliderSlidersLangPK != null) || (this.psAnHomesliderSlidersLangPK != null && !this.psAnHomesliderSlidersLangPK.equals(other.psAnHomesliderSlidersLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidersLang[ psAnHomesliderSlidersLangPK=" + psAnHomesliderSlidersLangPK + " ]";
    }
    
}
