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
public class PsProductCommentCriterionCategoryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion")
    private int idProductCommentCriterion;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;

    public PsProductCommentCriterionCategoryPK() {
    }

    public PsProductCommentCriterionCategoryPK(int idProductCommentCriterion, int idCategory) {
        this.idProductCommentCriterion = idProductCommentCriterion;
        this.idCategory = idCategory;
    }

    public int getIdProductCommentCriterion() {
        return idProductCommentCriterion;
    }

    public void setIdProductCommentCriterion(int idProductCommentCriterion) {
        this.idProductCommentCriterion = idProductCommentCriterion;
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
        hash += (int) idProductCommentCriterion;
        hash += (int) idCategory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionCategoryPK)) {
            return false;
        }
        PsProductCommentCriterionCategoryPK other = (PsProductCommentCriterionCategoryPK) object;
        if (this.idProductCommentCriterion != other.idProductCommentCriterion) {
            return false;
        }
        if (this.idCategory != other.idCategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionCategoryPK[ idProductCommentCriterion=" + idProductCommentCriterion + ", idCategory=" + idCategory + " ]";
    }
    
}
