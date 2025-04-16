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
public class PsProductCommentCriterionProductPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion")
    private int idProductCommentCriterion;

    public PsProductCommentCriterionProductPK() {
    }

    public PsProductCommentCriterionProductPK(int idProduct, int idProductCommentCriterion) {
        this.idProduct = idProduct;
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdProductCommentCriterion() {
        return idProductCommentCriterion;
    }

    public void setIdProductCommentCriterion(int idProductCommentCriterion) {
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idProductCommentCriterion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionProductPK)) {
            return false;
        }
        PsProductCommentCriterionProductPK other = (PsProductCommentCriterionProductPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idProductCommentCriterion != other.idProductCommentCriterion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionProductPK[ idProduct=" + idProduct + ", idProductCommentCriterion=" + idProductCommentCriterion + " ]";
    }
    
}
