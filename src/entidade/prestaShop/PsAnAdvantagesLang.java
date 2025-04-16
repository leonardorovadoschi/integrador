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
@Table(name = "ps_an_advantages_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnAdvantagesLang.findAll", query = "SELECT p FROM PsAnAdvantagesLang p")})
public class PsAnAdvantagesLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnAdvantagesLangPK psAnAdvantagesLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Lob
    @Column(name = "text")
    private String text;

    public PsAnAdvantagesLang() {
    }

    public PsAnAdvantagesLang(PsAnAdvantagesLangPK psAnAdvantagesLangPK) {
        this.psAnAdvantagesLangPK = psAnAdvantagesLangPK;
    }

    public PsAnAdvantagesLang(PsAnAdvantagesLangPK psAnAdvantagesLangPK, String title, String link) {
        this.psAnAdvantagesLangPK = psAnAdvantagesLangPK;
        this.title = title;
        this.link = link;
    }

    public PsAnAdvantagesLang(int idAdvantage, String idLang) {
        this.psAnAdvantagesLangPK = new PsAnAdvantagesLangPK(idAdvantage, idLang);
    }

    public PsAnAdvantagesLangPK getPsAnAdvantagesLangPK() {
        return psAnAdvantagesLangPK;
    }

    public void setPsAnAdvantagesLangPK(PsAnAdvantagesLangPK psAnAdvantagesLangPK) {
        this.psAnAdvantagesLangPK = psAnAdvantagesLangPK;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnAdvantagesLangPK != null ? psAnAdvantagesLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnAdvantagesLang)) {
            return false;
        }
        PsAnAdvantagesLang other = (PsAnAdvantagesLang) object;
        if ((this.psAnAdvantagesLangPK == null && other.psAnAdvantagesLangPK != null) || (this.psAnAdvantagesLangPK != null && !this.psAnAdvantagesLangPK.equals(other.psAnAdvantagesLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnAdvantagesLang[ psAnAdvantagesLangPK=" + psAnAdvantagesLangPK + " ]";
    }
    
}
