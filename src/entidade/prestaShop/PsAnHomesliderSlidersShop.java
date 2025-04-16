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
@Table(name = "ps_an_homeslider_sliders_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSlidersShop.findAll", query = "SELECT p FROM PsAnHomesliderSlidersShop p")})
public class PsAnHomesliderSlidersShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomesliderSlidersShopPK psAnHomesliderSlidersShopPK;

    public PsAnHomesliderSlidersShop() {
    }

    public PsAnHomesliderSlidersShop(PsAnHomesliderSlidersShopPK psAnHomesliderSlidersShopPK) {
        this.psAnHomesliderSlidersShopPK = psAnHomesliderSlidersShopPK;
    }

    public PsAnHomesliderSlidersShop(int idSlider, int idShop) {
        this.psAnHomesliderSlidersShopPK = new PsAnHomesliderSlidersShopPK(idSlider, idShop);
    }

    public PsAnHomesliderSlidersShopPK getPsAnHomesliderSlidersShopPK() {
        return psAnHomesliderSlidersShopPK;
    }

    public void setPsAnHomesliderSlidersShopPK(PsAnHomesliderSlidersShopPK psAnHomesliderSlidersShopPK) {
        this.psAnHomesliderSlidersShopPK = psAnHomesliderSlidersShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomesliderSlidersShopPK != null ? psAnHomesliderSlidersShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidersShop)) {
            return false;
        }
        PsAnHomesliderSlidersShop other = (PsAnHomesliderSlidersShop) object;
        if ((this.psAnHomesliderSlidersShopPK == null && other.psAnHomesliderSlidersShopPK != null) || (this.psAnHomesliderSlidersShopPK != null && !this.psAnHomesliderSlidersShopPK.equals(other.psAnHomesliderSlidersShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidersShop[ psAnHomesliderSlidersShopPK=" + psAnHomesliderSlidersShopPK + " ]";
    }
    
}
