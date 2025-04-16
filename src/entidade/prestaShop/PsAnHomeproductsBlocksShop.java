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
@Table(name = "ps_an_homeproducts_blocks_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBlocksShop.findAll", query = "SELECT p FROM PsAnHomeproductsBlocksShop p")})
public class PsAnHomeproductsBlocksShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBlocksShopPK psAnHomeproductsBlocksShopPK;

    public PsAnHomeproductsBlocksShop() {
    }

    public PsAnHomeproductsBlocksShop(PsAnHomeproductsBlocksShopPK psAnHomeproductsBlocksShopPK) {
        this.psAnHomeproductsBlocksShopPK = psAnHomeproductsBlocksShopPK;
    }

    public PsAnHomeproductsBlocksShop(int idBlock, int idShop) {
        this.psAnHomeproductsBlocksShopPK = new PsAnHomeproductsBlocksShopPK(idBlock, idShop);
    }

    public PsAnHomeproductsBlocksShopPK getPsAnHomeproductsBlocksShopPK() {
        return psAnHomeproductsBlocksShopPK;
    }

    public void setPsAnHomeproductsBlocksShopPK(PsAnHomeproductsBlocksShopPK psAnHomeproductsBlocksShopPK) {
        this.psAnHomeproductsBlocksShopPK = psAnHomeproductsBlocksShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomeproductsBlocksShopPK != null ? psAnHomeproductsBlocksShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksShop)) {
            return false;
        }
        PsAnHomeproductsBlocksShop other = (PsAnHomeproductsBlocksShop) object;
        if ((this.psAnHomeproductsBlocksShopPK == null && other.psAnHomeproductsBlocksShopPK != null) || (this.psAnHomeproductsBlocksShopPK != null && !this.psAnHomeproductsBlocksShopPK.equals(other.psAnHomeproductsBlocksShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksShop[ psAnHomeproductsBlocksShopPK=" + psAnHomeproductsBlocksShopPK + " ]";
    }
    
}
