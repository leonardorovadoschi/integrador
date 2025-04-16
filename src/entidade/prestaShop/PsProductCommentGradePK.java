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
public class PsProductCommentGradePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product_comment")
    private int idProductComment;
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion")
    private int idProductCommentCriterion;

    public PsProductCommentGradePK() {
    }

    public PsProductCommentGradePK(int idProductComment, int idProductCommentCriterion) {
        this.idProductComment = idProductComment;
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    public int getIdProductComment() {
        return idProductComment;
    }

    public void setIdProductComment(int idProductComment) {
        this.idProductComment = idProductComment;
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
        hash += (int) idProductComment;
        hash += (int) idProductCommentCriterion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentGradePK)) {
            return false;
        }
        PsProductCommentGradePK other = (PsProductCommentGradePK) object;
        if (this.idProductComment != other.idProductComment) {
            return false;
        }
        if (this.idProductCommentCriterion != other.idProductCommentCriterion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentGradePK[ idProductComment=" + idProductComment + ", idProductCommentCriterion=" + idProductCommentCriterion + " ]";
    }
    
}
