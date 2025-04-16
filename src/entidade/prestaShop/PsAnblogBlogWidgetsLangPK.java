/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo-note
 */
@Embeddable
public class PsAnblogBlogWidgetsLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblog_blog_widgets")
    private int idAnblogBlogWidgets;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnblogBlogWidgetsLangPK() {
    }

    public PsAnblogBlogWidgetsLangPK(int idAnblogBlogWidgets, String idLang) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
        this.idLang = idLang;
    }

    public int getIdAnblogBlogWidgets() {
        return idAnblogBlogWidgets;
    }

    public void setIdAnblogBlogWidgets(int idAnblogBlogWidgets) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnblogBlogWidgets;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogWidgetsLangPK)) {
            return false;
        }
        PsAnblogBlogWidgetsLangPK other = (PsAnblogBlogWidgetsLangPK) object;
        if (this.idAnblogBlogWidgets != other.idAnblogBlogWidgets) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogWidgetsLangPK[ idAnblogBlogWidgets=" + idAnblogBlogWidgets + ", idLang=" + idLang + " ]";
    }
    
}
