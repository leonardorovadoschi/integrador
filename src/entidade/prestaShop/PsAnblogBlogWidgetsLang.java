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
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblog_blog_widgets_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogWidgetsLang.findAll", query = "SELECT p FROM PsAnblogBlogWidgetsLang p")})
public class PsAnblogBlogWidgetsLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogBlogWidgetsLangPK psAnblogBlogWidgetsLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    public PsAnblogBlogWidgetsLang() {
    }

    public PsAnblogBlogWidgetsLang(PsAnblogBlogWidgetsLangPK psAnblogBlogWidgetsLangPK) {
        this.psAnblogBlogWidgetsLangPK = psAnblogBlogWidgetsLangPK;
    }

    public PsAnblogBlogWidgetsLang(PsAnblogBlogWidgetsLangPK psAnblogBlogWidgetsLangPK, String title) {
        this.psAnblogBlogWidgetsLangPK = psAnblogBlogWidgetsLangPK;
        this.title = title;
    }

    public PsAnblogBlogWidgetsLang(int idAnblogBlogWidgets, String idLang) {
        this.psAnblogBlogWidgetsLangPK = new PsAnblogBlogWidgetsLangPK(idAnblogBlogWidgets, idLang);
    }

    public PsAnblogBlogWidgetsLangPK getPsAnblogBlogWidgetsLangPK() {
        return psAnblogBlogWidgetsLangPK;
    }

    public void setPsAnblogBlogWidgetsLangPK(PsAnblogBlogWidgetsLangPK psAnblogBlogWidgetsLangPK) {
        this.psAnblogBlogWidgetsLangPK = psAnblogBlogWidgetsLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogBlogWidgetsLangPK != null ? psAnblogBlogWidgetsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogWidgetsLang)) {
            return false;
        }
        PsAnblogBlogWidgetsLang other = (PsAnblogBlogWidgetsLang) object;
        if ((this.psAnblogBlogWidgetsLangPK == null && other.psAnblogBlogWidgetsLangPK != null) || (this.psAnblogBlogWidgetsLangPK != null && !this.psAnblogBlogWidgetsLangPK.equals(other.psAnblogBlogWidgetsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogWidgetsLang[ psAnblogBlogWidgetsLangPK=" + psAnblogBlogWidgetsLangPK + " ]";
    }
    
}
