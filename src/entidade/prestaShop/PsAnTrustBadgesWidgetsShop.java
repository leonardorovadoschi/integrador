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
@Table(name = "ps_an_trust_badges_widgets_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnTrustBadgesWidgetsShop.findAll", query = "SELECT p FROM PsAnTrustBadgesWidgetsShop p")})
public class PsAnTrustBadgesWidgetsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnTrustBadgesWidgetsShopPK psAnTrustBadgesWidgetsShopPK;

    public PsAnTrustBadgesWidgetsShop() {
    }

    public PsAnTrustBadgesWidgetsShop(PsAnTrustBadgesWidgetsShopPK psAnTrustBadgesWidgetsShopPK) {
        this.psAnTrustBadgesWidgetsShopPK = psAnTrustBadgesWidgetsShopPK;
    }

    public PsAnTrustBadgesWidgetsShop(int idWidget, int idShop) {
        this.psAnTrustBadgesWidgetsShopPK = new PsAnTrustBadgesWidgetsShopPK(idWidget, idShop);
    }

    public PsAnTrustBadgesWidgetsShopPK getPsAnTrustBadgesWidgetsShopPK() {
        return psAnTrustBadgesWidgetsShopPK;
    }

    public void setPsAnTrustBadgesWidgetsShopPK(PsAnTrustBadgesWidgetsShopPK psAnTrustBadgesWidgetsShopPK) {
        this.psAnTrustBadgesWidgetsShopPK = psAnTrustBadgesWidgetsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnTrustBadgesWidgetsShopPK != null ? psAnTrustBadgesWidgetsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesWidgetsShop)) {
            return false;
        }
        PsAnTrustBadgesWidgetsShop other = (PsAnTrustBadgesWidgetsShop) object;
        if ((this.psAnTrustBadgesWidgetsShopPK == null && other.psAnTrustBadgesWidgetsShopPK != null) || (this.psAnTrustBadgesWidgetsShopPK != null && !this.psAnTrustBadgesWidgetsShopPK.equals(other.psAnTrustBadgesWidgetsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesWidgetsShop[ psAnTrustBadgesWidgetsShopPK=" + psAnTrustBadgesWidgetsShopPK + " ]";
    }
    
}
