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
public class PsSearchIndexPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_word")
    private int idWord;

    public PsSearchIndexPK() {
    }

    public PsSearchIndexPK(int idProduct, int idWord) {
        this.idProduct = idProduct;
        this.idWord = idWord;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idWord;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSearchIndexPK)) {
            return false;
        }
        PsSearchIndexPK other = (PsSearchIndexPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idWord != other.idWord) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSearchIndexPK[ idProduct=" + idProduct + ", idWord=" + idWord + " ]";
    }
    
}
