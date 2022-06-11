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
@Table(name = "ps_category_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCategoryLang.findAll", query = "SELECT p FROM PsCategoryLang p")
    , @NamedQuery(name = "PsCategoryLang.findByIdCategory", query = "SELECT p FROM PsCategoryLang p WHERE p.psCategoryLangPK.idCategory = :idCategory")
    , @NamedQuery(name = "PsCategoryLang.findByIdShop", query = "SELECT p FROM PsCategoryLang p WHERE p.psCategoryLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCategoryLang.findByIdLang", query = "SELECT p FROM PsCategoryLang p WHERE p.psCategoryLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCategoryLang.findByName", query = "SELECT p FROM PsCategoryLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsCategoryLang.findByLinkRewrite", query = "SELECT p FROM PsCategoryLang p WHERE p.linkRewrite = :linkRewrite")
    , @NamedQuery(name = "PsCategoryLang.findByMetaTitle", query = "SELECT p FROM PsCategoryLang p WHERE p.metaTitle = :metaTitle")
    , @NamedQuery(name = "PsCategoryLang.findByMetaKeywords", query = "SELECT p FROM PsCategoryLang p WHERE p.metaKeywords = :metaKeywords")
    , @NamedQuery(name = "PsCategoryLang.findByMetaDescription", query = "SELECT p FROM PsCategoryLang p WHERE p.metaDescription = :metaDescription")})
public class PsCategoryLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCategoryLangPK psCategoryLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "link_rewrite")
    private String linkRewrite;
    @Column(name = "meta_title")
    private String metaTitle;
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Column(name = "meta_description")
    private String metaDescription;

    public PsCategoryLang() {
    }

    public PsCategoryLang(PsCategoryLangPK psCategoryLangPK) {
        this.psCategoryLangPK = psCategoryLangPK;
    }

    public PsCategoryLang(PsCategoryLangPK psCategoryLangPK, String name, String linkRewrite) {
        this.psCategoryLangPK = psCategoryLangPK;
        this.name = name;
        this.linkRewrite = linkRewrite;
    }

    public PsCategoryLang(int idCategory, int idShop, int idLang) {
        this.psCategoryLangPK = new PsCategoryLangPK(idCategory, idShop, idLang);
    }

    public PsCategoryLangPK getPsCategoryLangPK() {
        return psCategoryLangPK;
    }

    public void setPsCategoryLangPK(PsCategoryLangPK psCategoryLangPK) {
        this.psCategoryLangPK = psCategoryLangPK;
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

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
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
        hash += (psCategoryLangPK != null ? psCategoryLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryLang)) {
            return false;
        }
        PsCategoryLang other = (PsCategoryLang) object;
        if ((this.psCategoryLangPK == null && other.psCategoryLangPK != null) || (this.psCategoryLangPK != null && !this.psCategoryLangPK.equals(other.psCategoryLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryLang[ psCategoryLangPK=" + psCategoryLangPK + " ]";
    }
    
}
