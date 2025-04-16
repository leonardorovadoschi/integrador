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
public class PsAnblogCommentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblog_comment")
    private int idAnblogComment;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnblogCommentPK() {
    }

    public PsAnblogCommentPK(int idAnblogComment, int idShop) {
        this.idAnblogComment = idAnblogComment;
        this.idShop = idShop;
    }

    public int getIdAnblogComment() {
        return idAnblogComment;
    }

    public void setIdAnblogComment(int idAnblogComment) {
        this.idAnblogComment = idAnblogComment;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnblogComment;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogCommentPK)) {
            return false;
        }
        PsAnblogCommentPK other = (PsAnblogCommentPK) object;
        if (this.idAnblogComment != other.idAnblogComment) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogCommentPK[ idAnblogComment=" + idAnblogComment + ", idShop=" + idShop + " ]";
    }
    
}
