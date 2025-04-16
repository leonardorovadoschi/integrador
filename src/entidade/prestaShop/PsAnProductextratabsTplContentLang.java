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
@Table(name = "ps_an_productextratabs_tpl_content_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsTplContentLang.findAll", query = "SELECT p FROM PsAnProductextratabsTplContentLang p")})
public class PsAnProductextratabsTplContentLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductextratabsTplContentLangPK psAnProductextratabsTplContentLangPK;
    @Basic(optional = false)
    @Column(name = "content_name")
    private String contentName;
    @Basic(optional = false)
    @Lob
    @Column(name = "content_content")
    private String contentContent;

    public PsAnProductextratabsTplContentLang() {
    }

    public PsAnProductextratabsTplContentLang(PsAnProductextratabsTplContentLangPK psAnProductextratabsTplContentLangPK) {
        this.psAnProductextratabsTplContentLangPK = psAnProductextratabsTplContentLangPK;
    }

    public PsAnProductextratabsTplContentLang(PsAnProductextratabsTplContentLangPK psAnProductextratabsTplContentLangPK, String contentName, String contentContent) {
        this.psAnProductextratabsTplContentLangPK = psAnProductextratabsTplContentLangPK;
        this.contentName = contentName;
        this.contentContent = contentContent;
    }

    public PsAnProductextratabsTplContentLang(int idContent, String idLang) {
        this.psAnProductextratabsTplContentLangPK = new PsAnProductextratabsTplContentLangPK(idContent, idLang);
    }

    public PsAnProductextratabsTplContentLangPK getPsAnProductextratabsTplContentLangPK() {
        return psAnProductextratabsTplContentLangPK;
    }

    public void setPsAnProductextratabsTplContentLangPK(PsAnProductextratabsTplContentLangPK psAnProductextratabsTplContentLangPK) {
        this.psAnProductextratabsTplContentLangPK = psAnProductextratabsTplContentLangPK;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentContent() {
        return contentContent;
    }

    public void setContentContent(String contentContent) {
        this.contentContent = contentContent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductextratabsTplContentLangPK != null ? psAnProductextratabsTplContentLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsTplContentLang)) {
            return false;
        }
        PsAnProductextratabsTplContentLang other = (PsAnProductextratabsTplContentLang) object;
        if ((this.psAnProductextratabsTplContentLangPK == null && other.psAnProductextratabsTplContentLangPK != null) || (this.psAnProductextratabsTplContentLangPK != null && !this.psAnProductextratabsTplContentLangPK.equals(other.psAnProductextratabsTplContentLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsTplContentLang[ psAnProductextratabsTplContentLangPK=" + psAnProductextratabsTplContentLangPK + " ]";
    }
    
}
