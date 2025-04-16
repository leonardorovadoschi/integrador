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
@Table(name = "ps_an_trust_badges_icons_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnTrustBadgesIconsShop.findAll", query = "SELECT p FROM PsAnTrustBadgesIconsShop p")})
public class PsAnTrustBadgesIconsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnTrustBadgesIconsShopPK psAnTrustBadgesIconsShopPK;

    public PsAnTrustBadgesIconsShop() {
    }

    public PsAnTrustBadgesIconsShop(PsAnTrustBadgesIconsShopPK psAnTrustBadgesIconsShopPK) {
        this.psAnTrustBadgesIconsShopPK = psAnTrustBadgesIconsShopPK;
    }

    public PsAnTrustBadgesIconsShop(int iconId, int idShop) {
        this.psAnTrustBadgesIconsShopPK = new PsAnTrustBadgesIconsShopPK(iconId, idShop);
    }

    public PsAnTrustBadgesIconsShopPK getPsAnTrustBadgesIconsShopPK() {
        return psAnTrustBadgesIconsShopPK;
    }

    public void setPsAnTrustBadgesIconsShopPK(PsAnTrustBadgesIconsShopPK psAnTrustBadgesIconsShopPK) {
        this.psAnTrustBadgesIconsShopPK = psAnTrustBadgesIconsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnTrustBadgesIconsShopPK != null ? psAnTrustBadgesIconsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesIconsShop)) {
            return false;
        }
        PsAnTrustBadgesIconsShop other = (PsAnTrustBadgesIconsShop) object;
        if ((this.psAnTrustBadgesIconsShopPK == null && other.psAnTrustBadgesIconsShopPK != null) || (this.psAnTrustBadgesIconsShopPK != null && !this.psAnTrustBadgesIconsShopPK.equals(other.psAnTrustBadgesIconsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesIconsShop[ psAnTrustBadgesIconsShopPK=" + psAnTrustBadgesIconsShopPK + " ]";
    }
    
}
