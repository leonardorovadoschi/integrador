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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_meta_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMetaLang.findAll", query = "SELECT p FROM PsMetaLang p")
    , @NamedQuery(name = "PsMetaLang.findByIdMeta", query = "SELECT p FROM PsMetaLang p WHERE p.psMetaLangPK.idMeta = :idMeta")
    , @NamedQuery(name = "PsMetaLang.findByIdShop", query = "SELECT p FROM PsMetaLang p WHERE p.psMetaLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsMetaLang.findByIdLang", query = "SELECT p FROM PsMetaLang p WHERE p.psMetaLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsMetaLang.findByTitle", query = "SELECT p FROM PsMetaLang p WHERE p.title = :title")
    , @NamedQuery(name = "PsMetaLang.findByDescription", query = "SELECT p FROM PsMetaLang p WHERE p.description = :description")
    , @NamedQuery(name = "PsMetaLang.findByKeywords", query = "SELECT p FROM PsMetaLang p WHERE p.keywords = :keywords")
    , @NamedQuery(name = "PsMetaLang.findByUrlRewrite", query = "SELECT p FROM PsMetaLang p WHERE p.urlRewrite = :urlRewrite")})
public class PsMetaLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsMetaLangPK psMetaLangPK;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "keywords")
    private String keywords;
    @Basic(optional = false)
    @Column(name = "url_rewrite")
    private String urlRewrite;

    public PsMetaLang() {
    }

    public PsMetaLang(PsMetaLangPK psMetaLangPK) {
        this.psMetaLangPK = psMetaLangPK;
    }

    public PsMetaLang(PsMetaLangPK psMetaLangPK, String urlRewrite) {
        this.psMetaLangPK = psMetaLangPK;
        this.urlRewrite = urlRewrite;
    }

    public PsMetaLang(int idMeta, int idShop, int idLang) {
        this.psMetaLangPK = new PsMetaLangPK(idMeta, idShop, idLang);
    }

    public PsMetaLangPK getPsMetaLangPK() {
        return psMetaLangPK;
    }

    public void setPsMetaLangPK(PsMetaLangPK psMetaLangPK) {
        this.psMetaLangPK = psMetaLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUrlRewrite() {
        return urlRewrite;
    }

    public void setUrlRewrite(String urlRewrite) {
        this.urlRewrite = urlRewrite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psMetaLangPK != null ? psMetaLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMetaLang)) {
            return false;
        }
        PsMetaLang other = (PsMetaLang) object;
        if ((this.psMetaLangPK == null && other.psMetaLangPK != null) || (this.psMetaLangPK != null && !this.psMetaLangPK.equals(other.psMetaLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMetaLang[ psMetaLangPK=" + psMetaLangPK + " ]";
    }
    
}
