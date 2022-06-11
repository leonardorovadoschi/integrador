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
@Table(name = "ps_supplier_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplierLang.findAll", query = "SELECT p FROM PsSupplierLang p")
    , @NamedQuery(name = "PsSupplierLang.findByIdSupplier", query = "SELECT p FROM PsSupplierLang p WHERE p.psSupplierLangPK.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsSupplierLang.findByIdLang", query = "SELECT p FROM PsSupplierLang p WHERE p.psSupplierLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsSupplierLang.findByMetaTitle", query = "SELECT p FROM PsSupplierLang p WHERE p.metaTitle = :metaTitle")
    , @NamedQuery(name = "PsSupplierLang.findByMetaKeywords", query = "SELECT p FROM PsSupplierLang p WHERE p.metaKeywords = :metaKeywords")
    , @NamedQuery(name = "PsSupplierLang.findByMetaDescription", query = "SELECT p FROM PsSupplierLang p WHERE p.metaDescription = :metaDescription")})
public class PsSupplierLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSupplierLangPK psSupplierLangPK;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "meta_title")
    private String metaTitle;
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Column(name = "meta_description")
    private String metaDescription;

    public PsSupplierLang() {
    }

    public PsSupplierLang(PsSupplierLangPK psSupplierLangPK) {
        this.psSupplierLangPK = psSupplierLangPK;
    }

    public PsSupplierLang(int idSupplier, int idLang) {
        this.psSupplierLangPK = new PsSupplierLangPK(idSupplier, idLang);
    }

    public PsSupplierLangPK getPsSupplierLangPK() {
        return psSupplierLangPK;
    }

    public void setPsSupplierLangPK(PsSupplierLangPK psSupplierLangPK) {
        this.psSupplierLangPK = psSupplierLangPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSupplierLangPK != null ? psSupplierLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplierLang)) {
            return false;
        }
        PsSupplierLang other = (PsSupplierLang) object;
        if ((this.psSupplierLangPK == null && other.psSupplierLangPK != null) || (this.psSupplierLangPK != null && !this.psSupplierLangPK.equals(other.psSupplierLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplierLang[ psSupplierLangPK=" + psSupplierLangPK + " ]";
    }
    
}
