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
@Table(name = "ps_anthemeblock_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnthemeblockShop.findAll", query = "SELECT p FROM PsAnthemeblockShop p")})
public class PsAnthemeblockShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnthemeblockShopPK psAnthemeblockShopPK;

    public PsAnthemeblockShop() {
    }

    public PsAnthemeblockShop(PsAnthemeblockShopPK psAnthemeblockShopPK) {
        this.psAnthemeblockShopPK = psAnthemeblockShopPK;
    }

    public PsAnthemeblockShop(int idAnthemeblock, int idShop) {
        this.psAnthemeblockShopPK = new PsAnthemeblockShopPK(idAnthemeblock, idShop);
    }

    public PsAnthemeblockShopPK getPsAnthemeblockShopPK() {
        return psAnthemeblockShopPK;
    }

    public void setPsAnthemeblockShopPK(PsAnthemeblockShopPK psAnthemeblockShopPK) {
        this.psAnthemeblockShopPK = psAnthemeblockShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnthemeblockShopPK != null ? psAnthemeblockShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockShop)) {
            return false;
        }
        PsAnthemeblockShop other = (PsAnthemeblockShop) object;
        if ((this.psAnthemeblockShopPK == null && other.psAnthemeblockShopPK != null) || (this.psAnthemeblockShopPK != null && !this.psAnthemeblockShopPK.equals(other.psAnthemeblockShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockShop[ psAnthemeblockShopPK=" + psAnthemeblockShopPK + " ]";
    }
    
}
