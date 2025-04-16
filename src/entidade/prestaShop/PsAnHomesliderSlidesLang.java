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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_homeslider_slides_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSlidesLang.findAll", query = "SELECT p FROM PsAnHomesliderSlidesLang p")})
public class PsAnHomesliderSlidesLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomesliderSlidesLangPK psAnHomesliderSlidesLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "text_of_button")
    private String textOfButton;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public PsAnHomesliderSlidesLang() {
    }

    public PsAnHomesliderSlidesLang(PsAnHomesliderSlidesLangPK psAnHomesliderSlidesLangPK) {
        this.psAnHomesliderSlidesLangPK = psAnHomesliderSlidesLangPK;
    }

    public PsAnHomesliderSlidesLang(PsAnHomesliderSlidesLangPK psAnHomesliderSlidesLangPK, String title, String textOfButton, String link, String image) {
        this.psAnHomesliderSlidesLangPK = psAnHomesliderSlidesLangPK;
        this.title = title;
        this.textOfButton = textOfButton;
        this.link = link;
        this.image = image;
    }

    public PsAnHomesliderSlidesLang(int idSlide, String idLang) {
        this.psAnHomesliderSlidesLangPK = new PsAnHomesliderSlidesLangPK(idSlide, idLang);
    }

    public PsAnHomesliderSlidesLangPK getPsAnHomesliderSlidesLangPK() {
        return psAnHomesliderSlidesLangPK;
    }

    public void setPsAnHomesliderSlidesLangPK(PsAnHomesliderSlidesLangPK psAnHomesliderSlidesLangPK) {
        this.psAnHomesliderSlidesLangPK = psAnHomesliderSlidesLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextOfButton() {
        return textOfButton;
    }

    public void setTextOfButton(String textOfButton) {
        this.textOfButton = textOfButton;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomesliderSlidesLangPK != null ? psAnHomesliderSlidesLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidesLang)) {
            return false;
        }
        PsAnHomesliderSlidesLang other = (PsAnHomesliderSlidesLang) object;
        if ((this.psAnHomesliderSlidesLangPK == null && other.psAnHomesliderSlidesLangPK != null) || (this.psAnHomesliderSlidesLangPK != null && !this.psAnHomesliderSlidesLangPK.equals(other.psAnHomesliderSlidesLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidesLang[ psAnHomesliderSlidesLangPK=" + psAnHomesliderSlidesLangPK + " ]";
    }
    
}
