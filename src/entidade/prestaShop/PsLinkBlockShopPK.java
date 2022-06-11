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
 * @author leo
 */
@Embeddable
public class PsLinkBlockShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_link_block")
    private int idLinkBlock;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsLinkBlockShopPK() {
    }

    public PsLinkBlockShopPK(int idLinkBlock, int idShop) {
        this.idLinkBlock = idLinkBlock;
        this.idShop = idShop;
    }

    public int getIdLinkBlock() {
        return idLinkBlock;
    }

    public void setIdLinkBlock(int idLinkBlock) {
        this.idLinkBlock = idLinkBlock;
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
        hash += (int) idLinkBlock;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinkBlockShopPK)) {
            return false;
        }
        PsLinkBlockShopPK other = (PsLinkBlockShopPK) object;
        if (this.idLinkBlock != other.idLinkBlock) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinkBlockShopPK[ idLinkBlock=" + idLinkBlock + ", idShop=" + idShop + " ]";
    }
    
}
