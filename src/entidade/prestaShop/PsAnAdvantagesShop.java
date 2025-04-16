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
@Table(name = "ps_an_advantages_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnAdvantagesShop.findAll", query = "SELECT p FROM PsAnAdvantagesShop p")})
public class PsAnAdvantagesShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnAdvantagesShopPK psAnAdvantagesShopPK;

    public PsAnAdvantagesShop() {
    }

    public PsAnAdvantagesShop(PsAnAdvantagesShopPK psAnAdvantagesShopPK) {
        this.psAnAdvantagesShopPK = psAnAdvantagesShopPK;
    }

    public PsAnAdvantagesShop(int idAdvantage, int idShop) {
        this.psAnAdvantagesShopPK = new PsAnAdvantagesShopPK(idAdvantage, idShop);
    }

    public PsAnAdvantagesShopPK getPsAnAdvantagesShopPK() {
        return psAnAdvantagesShopPK;
    }

    public void setPsAnAdvantagesShopPK(PsAnAdvantagesShopPK psAnAdvantagesShopPK) {
        this.psAnAdvantagesShopPK = psAnAdvantagesShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnAdvantagesShopPK != null ? psAnAdvantagesShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnAdvantagesShop)) {
            return false;
        }
        PsAnAdvantagesShop other = (PsAnAdvantagesShop) object;
        if ((this.psAnAdvantagesShopPK == null && other.psAnAdvantagesShopPK != null) || (this.psAnAdvantagesShopPK != null && !this.psAnAdvantagesShopPK.equals(other.psAnAdvantagesShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnAdvantagesShop[ psAnAdvantagesShopPK=" + psAnAdvantagesShopPK + " ]";
    }
    
}
