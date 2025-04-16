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
public class PsAnblogBlogCategoriesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblog_blog")
    private int idAnblogBlog;
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private int idAnblogcat;

    public PsAnblogBlogCategoriesPK() {
    }

    public PsAnblogBlogCategoriesPK(int idAnblogBlog, int idAnblogcat) {
        this.idAnblogBlog = idAnblogBlog;
        this.idAnblogcat = idAnblogcat;
    }

    public int getIdAnblogBlog() {
        return idAnblogBlog;
    }

    public void setIdAnblogBlog(int idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public int getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(int idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnblogBlog;
        hash += (int) idAnblogcat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogCategoriesPK)) {
            return false;
        }
        PsAnblogBlogCategoriesPK other = (PsAnblogBlogCategoriesPK) object;
        if (this.idAnblogBlog != other.idAnblogBlog) {
            return false;
        }
        if (this.idAnblogcat != other.idAnblogcat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogCategoriesPK[ idAnblogBlog=" + idAnblogBlog + ", idAnblogcat=" + idAnblogcat + " ]";
    }
    
}
