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
public class PsProductCommentCriterionLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion")
    private int idProductCommentCriterion;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsProductCommentCriterionLangPK() {
    }

    public PsProductCommentCriterionLangPK(int idProductCommentCriterion, int idLang) {
        this.idProductCommentCriterion = idProductCommentCriterion;
        this.idLang = idLang;
    }

    public int getIdProductCommentCriterion() {
        return idProductCommentCriterion;
    }

    public void setIdProductCommentCriterion(int idProductCommentCriterion) {
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductCommentCriterion;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionLangPK)) {
            return false;
        }
        PsProductCommentCriterionLangPK other = (PsProductCommentCriterionLangPK) object;
        if (this.idProductCommentCriterion != other.idProductCommentCriterion) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionLangPK[ idProductCommentCriterion=" + idProductCommentCriterion + ", idLang=" + idLang + " ]";
    }
    
}
