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
@Table(name = "ps_an_homeproducts_banners_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBannersLang.findAll", query = "SELECT p FROM PsAnHomeproductsBannersLang p")})
public class PsAnHomeproductsBannersLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBannersLangPK psAnHomeproductsBannersLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public PsAnHomeproductsBannersLang() {
    }

    public PsAnHomeproductsBannersLang(PsAnHomeproductsBannersLangPK psAnHomeproductsBannersLangPK) {
        this.psAnHomeproductsBannersLangPK = psAnHomeproductsBannersLangPK;
    }

    public PsAnHomeproductsBannersLang(PsAnHomeproductsBannersLangPK psAnHomeproductsBannersLangPK, String title, String link, String image) {
        this.psAnHomeproductsBannersLangPK = psAnHomeproductsBannersLangPK;
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public PsAnHomeproductsBannersLang(int idBanner, String idLang) {
        this.psAnHomeproductsBannersLangPK = new PsAnHomeproductsBannersLangPK(idBanner, idLang);
    }

    public PsAnHomeproductsBannersLangPK getPsAnHomeproductsBannersLangPK() {
        return psAnHomeproductsBannersLangPK;
    }

    public void setPsAnHomeproductsBannersLangPK(PsAnHomeproductsBannersLangPK psAnHomeproductsBannersLangPK) {
        this.psAnHomeproductsBannersLangPK = psAnHomeproductsBannersLangPK;
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
        hash += (psAnHomeproductsBannersLangPK != null ? psAnHomeproductsBannersLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBannersLang)) {
            return false;
        }
        PsAnHomeproductsBannersLang other = (PsAnHomeproductsBannersLang) object;
        if ((this.psAnHomeproductsBannersLangPK == null && other.psAnHomeproductsBannersLangPK != null) || (this.psAnHomeproductsBannersLangPK != null && !this.psAnHomeproductsBannersLangPK.equals(other.psAnHomeproductsBannersLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBannersLang[ psAnHomeproductsBannersLangPK=" + psAnHomeproductsBannersLangPK + " ]";
    }
    
}
