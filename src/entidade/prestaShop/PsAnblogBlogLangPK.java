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
public class PsAnblogBlogLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblog_blog")
    private int idAnblogBlog;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnblogBlogLangPK() {
    }

    public PsAnblogBlogLangPK(int idAnblogBlog, int idLang) {
        this.idAnblogBlog = idAnblogBlog;
        this.idLang = idLang;
    }

    public int getIdAnblogBlog() {
        return idAnblogBlog;
    }

    public void setIdAnblogBlog(int idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnblogBlog;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogLangPK)) {
            return false;
        }
        PsAnblogBlogLangPK other = (PsAnblogBlogLangPK) object;
        if (this.idAnblogBlog != other.idAnblogBlog) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogLangPK[ idAnblogBlog=" + idAnblogBlog + ", idLang=" + idLang + " ]";
    }
    
}
