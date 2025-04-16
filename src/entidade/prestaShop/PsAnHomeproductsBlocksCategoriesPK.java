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
public class PsAnHomeproductsBlocksCategoriesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_block")
    private int idBlock;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;

    public PsAnHomeproductsBlocksCategoriesPK() {
    }

    public PsAnHomeproductsBlocksCategoriesPK(int idBlock, int idCategory) {
        this.idBlock = idBlock;
        this.idCategory = idCategory;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBlock;
        hash += (int) idCategory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksCategoriesPK)) {
            return false;
        }
        PsAnHomeproductsBlocksCategoriesPK other = (PsAnHomeproductsBlocksCategoriesPK) object;
        if (this.idBlock != other.idBlock) {
            return false;
        }
        if (this.idCategory != other.idCategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksCategoriesPK[ idBlock=" + idBlock + ", idCategory=" + idCategory + " ]";
    }
    
}
