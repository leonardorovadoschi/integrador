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
@Table(name = "ps_anproducttabs_default_content_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabsDefaultContentLang.findAll", query = "SELECT p FROM PsAnproducttabsDefaultContentLang p")})
public class PsAnproducttabsDefaultContentLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnproducttabsDefaultContentLangPK psAnproducttabsDefaultContentLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;

    public PsAnproducttabsDefaultContentLang() {
    }

    public PsAnproducttabsDefaultContentLang(PsAnproducttabsDefaultContentLangPK psAnproducttabsDefaultContentLangPK) {
        this.psAnproducttabsDefaultContentLangPK = psAnproducttabsDefaultContentLangPK;
    }

    public PsAnproducttabsDefaultContentLang(PsAnproducttabsDefaultContentLangPK psAnproducttabsDefaultContentLangPK, String title, String content) {
        this.psAnproducttabsDefaultContentLangPK = psAnproducttabsDefaultContentLangPK;
        this.title = title;
        this.content = content;
    }

    public PsAnproducttabsDefaultContentLang(int idAnproducttabsDefaultContent, int idLang) {
        this.psAnproducttabsDefaultContentLangPK = new PsAnproducttabsDefaultContentLangPK(idAnproducttabsDefaultContent, idLang);
    }

    public PsAnproducttabsDefaultContentLangPK getPsAnproducttabsDefaultContentLangPK() {
        return psAnproducttabsDefaultContentLangPK;
    }

    public void setPsAnproducttabsDefaultContentLangPK(PsAnproducttabsDefaultContentLangPK psAnproducttabsDefaultContentLangPK) {
        this.psAnproducttabsDefaultContentLangPK = psAnproducttabsDefaultContentLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnproducttabsDefaultContentLangPK != null ? psAnproducttabsDefaultContentLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsDefaultContentLang)) {
            return false;
        }
        PsAnproducttabsDefaultContentLang other = (PsAnproducttabsDefaultContentLang) object;
        if ((this.psAnproducttabsDefaultContentLangPK == null && other.psAnproducttabsDefaultContentLangPK != null) || (this.psAnproducttabsDefaultContentLangPK != null && !this.psAnproducttabsDefaultContentLangPK.equals(other.psAnproducttabsDefaultContentLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsDefaultContentLang[ psAnproducttabsDefaultContentLangPK=" + psAnproducttabsDefaultContentLangPK + " ]";
    }
    
}
