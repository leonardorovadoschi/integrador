/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_attachment_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttachmentLang.findAll", query = "SELECT p FROM PsAttachmentLang p")
    , @NamedQuery(name = "PsAttachmentLang.findByIdAttachment", query = "SELECT p FROM PsAttachmentLang p WHERE p.psAttachmentLangPK.idAttachment = :idAttachment")
    , @NamedQuery(name = "PsAttachmentLang.findByIdLang", query = "SELECT p FROM PsAttachmentLang p WHERE p.psAttachmentLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsAttachmentLang.findByName", query = "SELECT p FROM PsAttachmentLang p WHERE p.name = :name")})
public class PsAttachmentLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAttachmentLangPK psAttachmentLangPK;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;

    public PsAttachmentLang() {
    }

    public PsAttachmentLang(PsAttachmentLangPK psAttachmentLangPK) {
        this.psAttachmentLangPK = psAttachmentLangPK;
    }

    public PsAttachmentLang(int idAttachment, int idLang) {
        this.psAttachmentLangPK = new PsAttachmentLangPK(idAttachment, idLang);
    }

    public PsAttachmentLangPK getPsAttachmentLangPK() {
        return psAttachmentLangPK;
    }

    public void setPsAttachmentLangPK(PsAttachmentLangPK psAttachmentLangPK) {
        this.psAttachmentLangPK = psAttachmentLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAttachmentLangPK != null ? psAttachmentLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttachmentLang)) {
            return false;
        }
        PsAttachmentLang other = (PsAttachmentLang) object;
        if ((this.psAttachmentLangPK == null && other.psAttachmentLangPK != null) || (this.psAttachmentLangPK != null && !this.psAttachmentLangPK.equals(other.psAttachmentLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttachmentLang[ psAttachmentLangPK=" + psAttachmentLangPK + " ]";
    }
    
}
