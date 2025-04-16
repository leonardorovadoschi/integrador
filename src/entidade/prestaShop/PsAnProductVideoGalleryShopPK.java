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
public class PsAnProductVideoGalleryShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_video")
    private int idVideo;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnProductVideoGalleryShopPK() {
    }

    public PsAnProductVideoGalleryShopPK(int idVideo, int idShop) {
        this.idVideo = idVideo;
        this.idShop = idShop;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVideo;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductVideoGalleryShopPK)) {
            return false;
        }
        PsAnProductVideoGalleryShopPK other = (PsAnProductVideoGalleryShopPK) object;
        if (this.idVideo != other.idVideo) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductVideoGalleryShopPK[ idVideo=" + idVideo + ", idShop=" + idShop + " ]";
    }
    
}
