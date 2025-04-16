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
@Table(name = "ps_anblogcat_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogcatLang.findAll", query = "SELECT p FROM PsAnblogcatLang p")})
public class PsAnblogcatLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogcatLangPK psAnblogcatLangPK;
    @Column(name = "title")
    private String title;
    @Column(name = "meta_title")
    private String metaTitle;
    @Lob
    @Column(name = "content_text")
    private String contentText;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Basic(optional = false)
    @Column(name = "meta_description")
    private String metaDescription;
    @Basic(optional = false)
    @Column(name = "link_rewrite")
    private String linkRewrite;

    public PsAnblogcatLang() {
    }

    public PsAnblogcatLang(PsAnblogcatLangPK psAnblogcatLangPK) {
        this.psAnblogcatLangPK = psAnblogcatLangPK;
    }

    public PsAnblogcatLang(PsAnblogcatLangPK psAnblogcatLangPK, String description, String metaKeywords, String metaDescription, String linkRewrite) {
        this.psAnblogcatLangPK = psAnblogcatLangPK;
        this.description = description;
        this.metaKeywords = metaKeywords;
        this.metaDescription = metaDescription;
        this.linkRewrite = linkRewrite;
    }

    public PsAnblogcatLang(int idAnblogcat, int idLang) {
        this.psAnblogcatLangPK = new PsAnblogcatLangPK(idAnblogcat, idLang);
    }

    public PsAnblogcatLangPK getPsAnblogcatLangPK() {
        return psAnblogcatLangPK;
    }

    public void setPsAnblogcatLangPK(PsAnblogcatLangPK psAnblogcatLangPK) {
        this.psAnblogcatLangPK = psAnblogcatLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogcatLangPK != null ? psAnblogcatLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogcatLang)) {
            return false;
        }
        PsAnblogcatLang other = (PsAnblogcatLang) object;
        if ((this.psAnblogcatLangPK == null && other.psAnblogcatLangPK != null) || (this.psAnblogcatLangPK != null && !this.psAnblogcatLangPK.equals(other.psAnblogcatLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogcatLang[ psAnblogcatLangPK=" + psAnblogcatLangPK + " ]";
    }
    
}
