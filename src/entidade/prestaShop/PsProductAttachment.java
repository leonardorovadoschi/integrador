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
 * @author leo
 */
@Entity
@Table(name = "ps_product_attachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttachment.findAll", query = "SELECT p FROM PsProductAttachment p")
    , @NamedQuery(name = "PsProductAttachment.findByIdProduct", query = "SELECT p FROM PsProductAttachment p WHERE p.psProductAttachmentPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductAttachment.findByIdAttachment", query = "SELECT p FROM PsProductAttachment p WHERE p.psProductAttachmentPK.idAttachment = :idAttachment")})
public class PsProductAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductAttachmentPK psProductAttachmentPK;

    public PsProductAttachment() {
    }

    public PsProductAttachment(PsProductAttachmentPK psProductAttachmentPK) {
        this.psProductAttachmentPK = psProductAttachmentPK;
    }

    public PsProductAttachment(int idProduct, int idAttachment) {
        this.psProductAttachmentPK = new PsProductAttachmentPK(idProduct, idAttachment);
    }

    public PsProductAttachmentPK getPsProductAttachmentPK() {
        return psProductAttachmentPK;
    }

    public void setPsProductAttachmentPK(PsProductAttachmentPK psProductAttachmentPK) {
        this.psProductAttachmentPK = psProductAttachmentPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductAttachmentPK != null ? psProductAttachmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttachment)) {
            return false;
        }
        PsProductAttachment other = (PsProductAttachment) object;
        if ((this.psProductAttachmentPK == null && other.psProductAttachmentPK != null) || (this.psProductAttachmentPK != null && !this.psProductAttachmentPK.equals(other.psProductAttachmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductAttachment[ psProductAttachmentPK=" + psProductAttachmentPK + " ]";
    }
    
}
