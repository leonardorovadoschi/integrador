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
@Table(name = "ps_product_comment_criterion_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentCriterionCategory.findAll", query = "SELECT p FROM PsProductCommentCriterionCategory p")})
public class PsProductCommentCriterionCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentCriterionCategoryPK psProductCommentCriterionCategoryPK;

    public PsProductCommentCriterionCategory() {
    }

    public PsProductCommentCriterionCategory(PsProductCommentCriterionCategoryPK psProductCommentCriterionCategoryPK) {
        this.psProductCommentCriterionCategoryPK = psProductCommentCriterionCategoryPK;
    }

    public PsProductCommentCriterionCategory(int idProductCommentCriterion, int idCategory) {
        this.psProductCommentCriterionCategoryPK = new PsProductCommentCriterionCategoryPK(idProductCommentCriterion, idCategory);
    }

    public PsProductCommentCriterionCategoryPK getPsProductCommentCriterionCategoryPK() {
        return psProductCommentCriterionCategoryPK;
    }

    public void setPsProductCommentCriterionCategoryPK(PsProductCommentCriterionCategoryPK psProductCommentCriterionCategoryPK) {
        this.psProductCommentCriterionCategoryPK = psProductCommentCriterionCategoryPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentCriterionCategoryPK != null ? psProductCommentCriterionCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionCategory)) {
            return false;
        }
        PsProductCommentCriterionCategory other = (PsProductCommentCriterionCategory) object;
        if ((this.psProductCommentCriterionCategoryPK == null && other.psProductCommentCriterionCategoryPK != null) || (this.psProductCommentCriterionCategoryPK != null && !this.psProductCommentCriterionCategoryPK.equals(other.psProductCommentCriterionCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionCategory[ psProductCommentCriterionCategoryPK=" + psProductCommentCriterionCategoryPK + " ]";
    }
    
}
