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
public class PsAnProductVideoGalleryLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_video")
    private int idVideo;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnProductVideoGalleryLangPK() {
    }

    public PsAnProductVideoGalleryLangPK(int idVideo, String idLang) {
        this.idVideo = idVideo;
        this.idLang = idLang;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
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
        hash += (int) idVideo;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductVideoGalleryLangPK)) {
            return false;
        }
        PsAnProductVideoGalleryLangPK other = (PsAnProductVideoGalleryLangPK) object;
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductVideoGalleryLangPK[ idVideo=" + idVideo + ", idLang=" + idLang + " ]";
    }
    
}
