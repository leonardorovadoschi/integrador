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
@Table(name = "ps_cms_category_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsCategoryLang.findAll", query = "SELECT p FROM PsCmsCategoryLang p")
    , @NamedQuery(name = "PsCmsCategoryLang.findByIdCmsCategory", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.psCmsCategoryLangPK.idCmsCategory = :idCmsCategory")
    , @NamedQuery(name = "PsCmsCategoryLang.findByIdLang", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.psCmsCategoryLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCmsCategoryLang.findByIdShop", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.psCmsCategoryLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCmsCategoryLang.findByName", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsCmsCategoryLang.findByLinkRewrite", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.linkRewrite = :linkRewrite")
    , @NamedQuery(name = "PsCmsCategoryLang.findByMetaTitle", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.metaTitle = :metaTitle")
    , @NamedQuery(name = "PsCmsCategoryLang.findByMetaKeywords", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.metaKeywords = :metaKeywords")
    , @NamedQuery(name = "PsCmsCategoryLang.findByMetaDescription", query = "SELECT p FROM PsCmsCategoryLang p WHERE p.metaDescription = :metaDescription")})
public class PsCmsCategoryLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsCategoryLangPK psCmsCategoryLangPK;
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

    public PsCmsCategoryLang() {
    }

    public PsCmsCategoryLang(PsCmsCategoryLangPK psCmsCategoryLangPK) {
        this.psCmsCategoryLangPK = psCmsCategoryLangPK;
    }

    public PsCmsCategoryLang(PsCmsCategoryLangPK psCmsCategoryLangPK, String name, String linkRewrite) {
        this.psCmsCategoryLangPK = psCmsCategoryLangPK;
        this.name = name;
        this.linkRewrite = linkRewrite;
    }

    public PsCmsCategoryLang(int idCmsCategory, int idLang, int idShop) {
        this.psCmsCategoryLangPK = new PsCmsCategoryLangPK(idCmsCategory, idLang, idShop);
    }

    public PsCmsCategoryLangPK getPsCmsCategoryLangPK() {
        return psCmsCategoryLangPK;
    }

    public void setPsCmsCategoryLangPK(PsCmsCategoryLangPK psCmsCategoryLangPK) {
        this.psCmsCategoryLangPK = psCmsCategoryLangPK;
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
        hash += (psCmsCategoryLangPK != null ? psCmsCategoryLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsCategoryLang)) {
            return false;
        }
        PsCmsCategoryLang other = (PsCmsCategoryLang) object;
        if ((this.psCmsCategoryLangPK == null && other.psCmsCategoryLangPK != null) || (this.psCmsCategoryLangPK != null && !this.psCmsCategoryLangPK.equals(other.psCmsCategoryLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsCategoryLang[ psCmsCategoryLangPK=" + psCmsCategoryLangPK + " ]";
    }
    
}
