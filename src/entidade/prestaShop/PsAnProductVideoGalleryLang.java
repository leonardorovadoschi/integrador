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
@Table(name = "ps_an_product_video_gallery_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductVideoGalleryLang.findAll", query = "SELECT p FROM PsAnProductVideoGalleryLang p")})
public class PsAnProductVideoGalleryLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductVideoGalleryLangPK psAnProductVideoGalleryLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "video")
    private String video;
    @Basic(optional = false)
    @Column(name = "youtube")
    private String youtube;

    public PsAnProductVideoGalleryLang() {
    }

    public PsAnProductVideoGalleryLang(PsAnProductVideoGalleryLangPK psAnProductVideoGalleryLangPK) {
        this.psAnProductVideoGalleryLangPK = psAnProductVideoGalleryLangPK;
    }

    public PsAnProductVideoGalleryLang(PsAnProductVideoGalleryLangPK psAnProductVideoGalleryLangPK, String title, String video, String youtube) {
        this.psAnProductVideoGalleryLangPK = psAnProductVideoGalleryLangPK;
        this.title = title;
        this.video = video;
        this.youtube = youtube;
    }

    public PsAnProductVideoGalleryLang(int idVideo, String idLang) {
        this.psAnProductVideoGalleryLangPK = new PsAnProductVideoGalleryLangPK(idVideo, idLang);
    }

    public PsAnProductVideoGalleryLangPK getPsAnProductVideoGalleryLangPK() {
        return psAnProductVideoGalleryLangPK;
    }

    public void setPsAnProductVideoGalleryLangPK(PsAnProductVideoGalleryLangPK psAnProductVideoGalleryLangPK) {
        this.psAnProductVideoGalleryLangPK = psAnProductVideoGalleryLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductVideoGalleryLangPK != null ? psAnProductVideoGalleryLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductVideoGalleryLang)) {
            return false;
        }
        PsAnProductVideoGalleryLang other = (PsAnProductVideoGalleryLang) object;
        if ((this.psAnProductVideoGalleryLangPK == null && other.psAnProductVideoGalleryLangPK != null) || (this.psAnProductVideoGalleryLangPK != null && !this.psAnProductVideoGalleryLangPK.equals(other.psAnProductVideoGalleryLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductVideoGalleryLang[ psAnProductVideoGalleryLangPK=" + psAnProductVideoGalleryLangPK + " ]";
    }
    
}
