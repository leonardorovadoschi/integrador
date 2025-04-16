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
public class PsAnHomeproductsBlocksShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_block")
    private int idBlock;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnHomeproductsBlocksShopPK() {
    }

    public PsAnHomeproductsBlocksShopPK(int idBlock, int idShop) {
        this.idBlock = idBlock;
        this.idShop = idShop;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
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
        hash += (int) idBlock;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksShopPK)) {
            return false;
        }
        PsAnHomeproductsBlocksShopPK other = (PsAnHomeproductsBlocksShopPK) object;
        if (this.idBlock != other.idBlock) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksShopPK[ idBlock=" + idBlock + ", idShop=" + idShop + " ]";
    }
    
}
