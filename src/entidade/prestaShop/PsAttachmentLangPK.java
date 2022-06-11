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
public class PsAttachmentLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_attachment")
    private int idAttachment;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAttachmentLangPK() {
    }

    public PsAttachmentLangPK(int idAttachment, int idLang) {
        this.idAttachment = idAttachment;
        this.idLang = idLang;
    }

    public int getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(int idAttachment) {
        this.idAttachment = idAttachment;
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
        hash += (int) idAttachment;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttachmentLangPK)) {
            return false;
        }
        PsAttachmentLangPK other = (PsAttachmentLangPK) object;
        if (this.idAttachment != other.idAttachment) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttachmentLangPK[ idAttachment=" + idAttachment + ", idLang=" + idLang + " ]";
    }
    
}
