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
@Table(name = "ps_an_homeslider_slides_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSlidesShop.findAll", query = "SELECT p FROM PsAnHomesliderSlidesShop p")})
public class PsAnHomesliderSlidesShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomesliderSlidesShopPK psAnHomesliderSlidesShopPK;

    public PsAnHomesliderSlidesShop() {
    }

    public PsAnHomesliderSlidesShop(PsAnHomesliderSlidesShopPK psAnHomesliderSlidesShopPK) {
        this.psAnHomesliderSlidesShopPK = psAnHomesliderSlidesShopPK;
    }

    public PsAnHomesliderSlidesShop(int idSlide, int idShop) {
        this.psAnHomesliderSlidesShopPK = new PsAnHomesliderSlidesShopPK(idSlide, idShop);
    }

    public PsAnHomesliderSlidesShopPK getPsAnHomesliderSlidesShopPK() {
        return psAnHomesliderSlidesShopPK;
    }

    public void setPsAnHomesliderSlidesShopPK(PsAnHomesliderSlidesShopPK psAnHomesliderSlidesShopPK) {
        this.psAnHomesliderSlidesShopPK = psAnHomesliderSlidesShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomesliderSlidesShopPK != null ? psAnHomesliderSlidesShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidesShop)) {
            return false;
        }
        PsAnHomesliderSlidesShop other = (PsAnHomesliderSlidesShop) object;
        if ((this.psAnHomesliderSlidesShopPK == null && other.psAnHomesliderSlidesShopPK != null) || (this.psAnHomesliderSlidesShopPK != null && !this.psAnHomesliderSlidesShopPK.equals(other.psAnHomesliderSlidesShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidesShop[ psAnHomesliderSlidesShopPK=" + psAnHomesliderSlidesShopPK + " ]";
    }
    
}
