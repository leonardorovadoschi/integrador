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
public class PsProductCommentUsefulnessPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product_comment")
    private int idProductComment;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;

    public PsProductCommentUsefulnessPK() {
    }

    public PsProductCommentUsefulnessPK(int idProductComment, int idCustomer) {
        this.idProductComment = idProductComment;
        this.idCustomer = idCustomer;
    }

    public int getIdProductComment() {
        return idProductComment;
    }

    public void setIdProductComment(int idProductComment) {
        this.idProductComment = idProductComment;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductComment;
        hash += (int) idCustomer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentUsefulnessPK)) {
            return false;
        }
        PsProductCommentUsefulnessPK other = (PsProductCommentUsefulnessPK) object;
        if (this.idProductComment != other.idProductComment) {
            return false;
        }
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentUsefulnessPK[ idProductComment=" + idProductComment + ", idCustomer=" + idCustomer + " ]";
    }
    
}
