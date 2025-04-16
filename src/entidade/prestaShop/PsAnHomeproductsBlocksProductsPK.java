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
public class PsAnHomeproductsBlocksProductsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_block")
    private int idBlock;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;

    public PsAnHomeproductsBlocksProductsPK() {
    }

    public PsAnHomeproductsBlocksProductsPK(int idBlock, int idProduct) {
        this.idBlock = idBlock;
        this.idProduct = idProduct;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBlock;
        hash += (int) idProduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksProductsPK)) {
            return false;
        }
        PsAnHomeproductsBlocksProductsPK other = (PsAnHomeproductsBlocksProductsPK) object;
        if (this.idBlock != other.idBlock) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksProductsPK[ idBlock=" + idBlock + ", idProduct=" + idProduct + " ]";
    }
    
}
