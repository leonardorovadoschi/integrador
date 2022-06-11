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
 * @author leo
 */
@Embeddable
public class PsProductAttachmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_attachment")
    private int idAttachment;

    public PsProductAttachmentPK() {
    }

    public PsProductAttachmentPK(int idProduct, int idAttachment) {
        this.idProduct = idProduct;
        this.idAttachment = idAttachment;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(int idAttachment) {
        this.idAttachment = idAttachment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idAttachment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttachmentPK)) {
            return false;
        }
        PsProductAttachmentPK other = (PsProductAttachmentPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idAttachment != other.idAttachment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductAttachmentPK[ idProduct=" + idProduct + ", idAttachment=" + idAttachment + " ]";
    }
    
}
