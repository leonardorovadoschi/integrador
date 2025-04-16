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
@Table(name = "ps_product_comment_criterion_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentCriterionProduct.findAll", query = "SELECT p FROM PsProductCommentCriterionProduct p")})
public class PsProductCommentCriterionProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentCriterionProductPK psProductCommentCriterionProductPK;

    public PsProductCommentCriterionProduct() {
    }

    public PsProductCommentCriterionProduct(PsProductCommentCriterionProductPK psProductCommentCriterionProductPK) {
        this.psProductCommentCriterionProductPK = psProductCommentCriterionProductPK;
    }

    public PsProductCommentCriterionProduct(int idProduct, int idProductCommentCriterion) {
        this.psProductCommentCriterionProductPK = new PsProductCommentCriterionProductPK(idProduct, idProductCommentCriterion);
    }

    public PsProductCommentCriterionProductPK getPsProductCommentCriterionProductPK() {
        return psProductCommentCriterionProductPK;
    }

    public void setPsProductCommentCriterionProductPK(PsProductCommentCriterionProductPK psProductCommentCriterionProductPK) {
        this.psProductCommentCriterionProductPK = psProductCommentCriterionProductPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentCriterionProductPK != null ? psProductCommentCriterionProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionProduct)) {
            return false;
        }
        PsProductCommentCriterionProduct other = (PsProductCommentCriterionProduct) object;
        if ((this.psProductCommentCriterionProductPK == null && other.psProductCommentCriterionProductPK != null) || (this.psProductCommentCriterionProductPK != null && !this.psProductCommentCriterionProductPK.equals(other.psProductCommentCriterionProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionProduct[ psProductCommentCriterionProductPK=" + psProductCommentCriterionProductPK + " ]";
    }
    
}
