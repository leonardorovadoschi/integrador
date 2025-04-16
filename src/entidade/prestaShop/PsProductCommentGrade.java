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
@Table(name = "ps_product_comment_grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentGrade.findAll", query = "SELECT p FROM PsProductCommentGrade p")})
public class PsProductCommentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentGradePK psProductCommentGradePK;
    @Basic(optional = false)
    @Column(name = "grade")
    private int grade;

    public PsProductCommentGrade() {
    }

    public PsProductCommentGrade(PsProductCommentGradePK psProductCommentGradePK) {
        this.psProductCommentGradePK = psProductCommentGradePK;
    }

    public PsProductCommentGrade(PsProductCommentGradePK psProductCommentGradePK, int grade) {
        this.psProductCommentGradePK = psProductCommentGradePK;
        this.grade = grade;
    }

    public PsProductCommentGrade(int idProductComment, int idProductCommentCriterion) {
        this.psProductCommentGradePK = new PsProductCommentGradePK(idProductComment, idProductCommentCriterion);
    }

    public PsProductCommentGradePK getPsProductCommentGradePK() {
        return psProductCommentGradePK;
    }

    public void setPsProductCommentGradePK(PsProductCommentGradePK psProductCommentGradePK) {
        this.psProductCommentGradePK = psProductCommentGradePK;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentGradePK != null ? psProductCommentGradePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentGrade)) {
            return false;
        }
        PsProductCommentGrade other = (PsProductCommentGrade) object;
        if ((this.psProductCommentGradePK == null && other.psProductCommentGradePK != null) || (this.psProductCommentGradePK != null && !this.psProductCommentGradePK.equals(other.psProductCommentGradePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentGrade[ psProductCommentGradePK=" + psProductCommentGradePK + " ]";
    }
    
}
