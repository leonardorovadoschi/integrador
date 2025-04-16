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
@Table(name = "ps_anproducttabs_content_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabsContentLang.findAll", query = "SELECT p FROM PsAnproducttabsContentLang p")})
public class PsAnproducttabsContentLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnproducttabsContentLangPK psAnproducttabsContentLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;

    public PsAnproducttabsContentLang() {
    }

    public PsAnproducttabsContentLang(PsAnproducttabsContentLangPK psAnproducttabsContentLangPK) {
        this.psAnproducttabsContentLangPK = psAnproducttabsContentLangPK;
    }

    public PsAnproducttabsContentLang(PsAnproducttabsContentLangPK psAnproducttabsContentLangPK, String title, String content) {
        this.psAnproducttabsContentLangPK = psAnproducttabsContentLangPK;
        this.title = title;
        this.content = content;
    }

    public PsAnproducttabsContentLang(int idAnproducttabsContent, int idLang) {
        this.psAnproducttabsContentLangPK = new PsAnproducttabsContentLangPK(idAnproducttabsContent, idLang);
    }

    public PsAnproducttabsContentLangPK getPsAnproducttabsContentLangPK() {
        return psAnproducttabsContentLangPK;
    }

    public void setPsAnproducttabsContentLangPK(PsAnproducttabsContentLangPK psAnproducttabsContentLangPK) {
        this.psAnproducttabsContentLangPK = psAnproducttabsContentLangPK;
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
        hash += (psAnproducttabsContentLangPK != null ? psAnproducttabsContentLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsContentLang)) {
            return false;
        }
        PsAnproducttabsContentLang other = (PsAnproducttabsContentLang) object;
        if ((this.psAnproducttabsContentLangPK == null && other.psAnproducttabsContentLangPK != null) || (this.psAnproducttabsContentLangPK != null && !this.psAnproducttabsContentLangPK.equals(other.psAnproducttabsContentLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsContentLang[ psAnproducttabsContentLangPK=" + psAnproducttabsContentLangPK + " ]";
    }
    
}
