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
@Table(name = "ps_an_homeproducts_banners_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBannersShop.findAll", query = "SELECT p FROM PsAnHomeproductsBannersShop p")})
public class PsAnHomeproductsBannersShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBannersShopPK psAnHomeproductsBannersShopPK;

    public PsAnHomeproductsBannersShop() {
    }

    public PsAnHomeproductsBannersShop(PsAnHomeproductsBannersShopPK psAnHomeproductsBannersShopPK) {
        this.psAnHomeproductsBannersShopPK = psAnHomeproductsBannersShopPK;
    }

    public PsAnHomeproductsBannersShop(int idBanner, int idShop) {
        this.psAnHomeproductsBannersShopPK = new PsAnHomeproductsBannersShopPK(idBanner, idShop);
    }

    public PsAnHomeproductsBannersShopPK getPsAnHomeproductsBannersShopPK() {
        return psAnHomeproductsBannersShopPK;
    }

    public void setPsAnHomeproductsBannersShopPK(PsAnHomeproductsBannersShopPK psAnHomeproductsBannersShopPK) {
        this.psAnHomeproductsBannersShopPK = psAnHomeproductsBannersShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomeproductsBannersShopPK != null ? psAnHomeproductsBannersShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBannersShop)) {
            return false;
        }
        PsAnHomeproductsBannersShop other = (PsAnHomeproductsBannersShop) object;
        if ((this.psAnHomeproductsBannersShopPK == null && other.psAnHomeproductsBannersShopPK != null) || (this.psAnHomeproductsBannersShopPK != null && !this.psAnHomeproductsBannersShopPK.equals(other.psAnHomeproductsBannersShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBannersShop[ psAnHomeproductsBannersShopPK=" + psAnHomeproductsBannersShopPK + " ]";
    }
    
}
