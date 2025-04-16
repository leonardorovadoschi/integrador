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
@Table(name = "ps_anthemeblock_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnthemeblockLang.findAll", query = "SELECT p FROM PsAnthemeblockLang p")})
public class PsAnthemeblockLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnthemeblockLangPK psAnthemeblockLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Lob
    @Column(name = "content")
    private String content;

    public PsAnthemeblockLang() {
    }

    public PsAnthemeblockLang(PsAnthemeblockLangPK psAnthemeblockLangPK) {
        this.psAnthemeblockLangPK = psAnthemeblockLangPK;
    }

    public PsAnthemeblockLang(PsAnthemeblockLangPK psAnthemeblockLangPK, String title, String link, String image) {
        this.psAnthemeblockLangPK = psAnthemeblockLangPK;
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public PsAnthemeblockLang(int idAnthemeblock, int idLang) {
        this.psAnthemeblockLangPK = new PsAnthemeblockLangPK(idAnthemeblock, idLang);
    }

    public PsAnthemeblockLangPK getPsAnthemeblockLangPK() {
        return psAnthemeblockLangPK;
    }

    public void setPsAnthemeblockLangPK(PsAnthemeblockLangPK psAnthemeblockLangPK) {
        this.psAnthemeblockLangPK = psAnthemeblockLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (psAnthemeblockLangPK != null ? psAnthemeblockLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockLang)) {
            return false;
        }
        PsAnthemeblockLang other = (PsAnthemeblockLang) object;
        if ((this.psAnthemeblockLangPK == null && other.psAnthemeblockLangPK != null) || (this.psAnthemeblockLangPK != null && !this.psAnthemeblockLangPK.equals(other.psAnthemeblockLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockLang[ psAnthemeblockLangPK=" + psAnthemeblockLangPK + " ]";
    }
    
}
