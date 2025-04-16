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
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblog_blog_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogLang.findAll", query = "SELECT p FROM PsAnblogBlogLang p")})
public class PsAnblogBlogLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogBlogLangPK psAnblogBlogLangPK;
    @Basic(optional = false)
    @Column(name = "meta_description")
    private String metaDescription;
    @Basic(optional = false)
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Basic(optional = false)
    @Column(name = "meta_title")
    private String metaTitle;
    @Basic(optional = false)
    @Column(name = "link_rewrite")
    private String linkRewrite;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "tags")
    private String tags;

    public PsAnblogBlogLang() {
    }

    public PsAnblogBlogLang(PsAnblogBlogLangPK psAnblogBlogLangPK) {
        this.psAnblogBlogLangPK = psAnblogBlogLangPK;
    }

    public PsAnblogBlogLang(PsAnblogBlogLangPK psAnblogBlogLangPK, String metaDescription, String metaKeywords, String metaTitle, String linkRewrite, String content, String description, String tags) {
        this.psAnblogBlogLangPK = psAnblogBlogLangPK;
        this.metaDescription = metaDescription;
        this.metaKeywords = metaKeywords;
        this.metaTitle = metaTitle;
        this.linkRewrite = linkRewrite;
        this.content = content;
        this.description = description;
        this.tags = tags;
    }

    public PsAnblogBlogLang(int idAnblogBlog, int idLang) {
        this.psAnblogBlogLangPK = new PsAnblogBlogLangPK(idAnblogBlog, idLang);
    }

    public PsAnblogBlogLangPK getPsAnblogBlogLangPK() {
        return psAnblogBlogLangPK;
    }

    public void setPsAnblogBlogLangPK(PsAnblogBlogLangPK psAnblogBlogLangPK) {
        this.psAnblogBlogLangPK = psAnblogBlogLangPK;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogBlogLangPK != null ? psAnblogBlogLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogLang)) {
            return false;
        }
        PsAnblogBlogLang other = (PsAnblogBlogLang) object;
        if ((this.psAnblogBlogLangPK == null && other.psAnblogBlogLangPK != null) || (this.psAnblogBlogLangPK != null && !this.psAnblogBlogLangPK.equals(other.psAnblogBlogLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogLang[ psAnblogBlogLangPK=" + psAnblogBlogLangPK + " ]";
    }
    
}
