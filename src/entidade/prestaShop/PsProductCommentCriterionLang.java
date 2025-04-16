/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ps_product_comment_criterion_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentCriterionLang.findAll", query = "SELECT p FROM PsProductCommentCriterionLang p")})
public class PsProductCommentCriterionLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentCriterionLangPK psProductCommentCriterionLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsProductCommentCriterionLang() {
    }

    public PsProductCommentCriterionLang(PsProductCommentCriterionLangPK psProductCommentCriterionLangPK) {
        this.psProductCommentCriterionLangPK = psProductCommentCriterionLangPK;
    }

    public PsProductCommentCriterionLang(PsProductCommentCriterionLangPK psProductCommentCriterionLangPK, String name) {
        this.psProductCommentCriterionLangPK = psProductCommentCriterionLangPK;
        this.name = name;
    }

    public PsProductCommentCriterionLang(int idProductCommentCriterion, int idLang) {
        this.psProductCommentCriterionLangPK = new PsProductCommentCriterionLangPK(idProductCommentCriterion, idLang);
    }

    public PsProductCommentCriterionLangPK getPsProductCommentCriterionLangPK() {
        return psProductCommentCriterionLangPK;
    }

    public void setPsProductCommentCriterionLangPK(PsProductCommentCriterionLangPK psProductCommentCriterionLangPK) {
        this.psProductCommentCriterionLangPK = psProductCommentCriterionLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentCriterionLangPK != null ? psProductCommentCriterionLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterionLang)) {
            return false;
        }
        PsProductCommentCriterionLang other = (PsProductCommentCriterionLang) object;
        if ((this.psProductCommentCriterionLangPK == null && other.psProductCommentCriterionLangPK != null) || (this.psProductCommentCriterionLangPK != null && !this.psProductCommentCriterionLangPK.equals(other.psProductCommentCriterionLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterionLang[ psProductCommentCriterionLangPK=" + psProductCommentCriterionLangPK + " ]";
    }
    
}
