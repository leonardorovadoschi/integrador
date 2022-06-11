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
@Table(name = "ps_cms_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsLang.findAll", query = "SELECT p FROM PsCmsLang p")
    , @NamedQuery(name = "PsCmsLang.findByIdCms", query = "SELECT p FROM PsCmsLang p WHERE p.psCmsLangPK.idCms = :idCms")
    , @NamedQuery(name = "PsCmsLang.findByIdLang", query = "SELECT p FROM PsCmsLang p WHERE p.psCmsLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCmsLang.findByIdShop", query = "SELECT p FROM PsCmsLang p WHERE p.psCmsLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCmsLang.findByMetaTitle", query = "SELECT p FROM PsCmsLang p WHERE p.metaTitle = :metaTitle")
    , @NamedQuery(name = "PsCmsLang.findByHeadSeoTitle", query = "SELECT p FROM PsCmsLang p WHERE p.headSeoTitle = :headSeoTitle")
    , @NamedQuery(name = "PsCmsLang.findByMetaDescription", query = "SELECT p FROM PsCmsLang p WHERE p.metaDescription = :metaDescription")
    , @NamedQuery(name = "PsCmsLang.findByMetaKeywords", query = "SELECT p FROM PsCmsLang p WHERE p.metaKeywords = :metaKeywords")
    , @NamedQuery(name = "PsCmsLang.findByLinkRewrite", query = "SELECT p FROM PsCmsLang p WHERE p.linkRewrite = :linkRewrite")})
public class PsCmsLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsLangPK psCmsLangPK;
    @Basic(optional = false)
    @Column(name = "meta_title")
    private String metaTitle;
    @Column(name = "head_seo_title")
    private String headSeoTitle;
    @Column(name = "meta_description")
    private String metaDescription;
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "link_rewrite")
    private String linkRewrite;

    public PsCmsLang() {
    }

    public PsCmsLang(PsCmsLangPK psCmsLangPK) {
        this.psCmsLangPK = psCmsLangPK;
    }

    public PsCmsLang(PsCmsLangPK psCmsLangPK, String metaTitle, String linkRewrite) {
        this.psCmsLangPK = psCmsLangPK;
        this.metaTitle = metaTitle;
        this.linkRewrite = linkRewrite;
    }

    public PsCmsLang(int idCms, int idLang, int idShop) {
        this.psCmsLangPK = new PsCmsLangPK(idCms, idLang, idShop);
    }

    public PsCmsLangPK getPsCmsLangPK() {
        return psCmsLangPK;
    }

    public void setPsCmsLangPK(PsCmsLangPK psCmsLangPK) {
        this.psCmsLangPK = psCmsLangPK;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getHeadSeoTitle() {
        return headSeoTitle;
    }

    public void setHeadSeoTitle(String headSeoTitle) {
        this.headSeoTitle = headSeoTitle;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash += (psCmsLangPK != null ? psCmsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsLang)) {
            return false;
        }
        PsCmsLang other = (PsCmsLang) object;
        if ((this.psCmsLangPK == null && other.psCmsLangPK != null) || (this.psCmsLangPK != null && !this.psCmsLangPK.equals(other.psCmsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsLang[ psCmsLangPK=" + psCmsLangPK + " ]";
    }
    
}
