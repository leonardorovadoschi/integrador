/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_an_product_video_gallery_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductVideoGalleryShop.findAll", query = "SELECT p FROM PsAnProductVideoGalleryShop p")})
public class PsAnProductVideoGalleryShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductVideoGalleryShopPK psAnProductVideoGalleryShopPK;

    public PsAnProductVideoGalleryShop() {
    }

    public PsAnProductVideoGalleryShop(PsAnProductVideoGalleryShopPK psAnProductVideoGalleryShopPK) {
        this.psAnProductVideoGalleryShopPK = psAnProductVideoGalleryShopPK;
    }

    public PsAnProductVideoGalleryShop(int idVideo, int idShop) {
        this.psAnProductVideoGalleryShopPK = new PsAnProductVideoGalleryShopPK(idVideo, idShop);
    }

    public PsAnProductVideoGalleryShopPK getPsAnProductVideoGalleryShopPK() {
        return psAnProductVideoGalleryShopPK;
    }

    public void setPsAnProductVideoGalleryShopPK(PsAnProductVideoGalleryShopPK psAnProductVideoGalleryShopPK) {
        this.psAnProductVideoGalleryShopPK = psAnProductVideoGalleryShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductVideoGalleryShopPK != null ? psAnProductVideoGalleryShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductVideoGalleryShop)) {
            return false;
        }
        PsAnProductVideoGalleryShop other = (PsAnProductVideoGalleryShop) object;
        if ((this.psAnProductVideoGalleryShopPK == null && other.psAnProductVideoGalleryShopPK != null) || (this.psAnProductVideoGalleryShopPK != null && !this.psAnProductVideoGalleryShopPK.equals(other.psAnProductVideoGalleryShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductVideoGalleryShop[ psAnProductVideoGalleryShopPK=" + psAnProductVideoGalleryShopPK + " ]";
    }
    
}
