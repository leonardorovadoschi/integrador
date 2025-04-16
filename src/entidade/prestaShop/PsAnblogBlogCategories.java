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
@Table(name = "ps_anblog_blog_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogCategories.findAll", query = "SELECT p FROM PsAnblogBlogCategories p")})
public class PsAnblogBlogCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogBlogCategoriesPK psAnblogBlogCategoriesPK;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnblogBlogCategories() {
    }

    public PsAnblogBlogCategories(PsAnblogBlogCategoriesPK psAnblogBlogCategoriesPK) {
        this.psAnblogBlogCategoriesPK = psAnblogBlogCategoriesPK;
    }

    public PsAnblogBlogCategories(PsAnblogBlogCategoriesPK psAnblogBlogCategoriesPK, int position) {
        this.psAnblogBlogCategoriesPK = psAnblogBlogCategoriesPK;
        this.position = position;
    }

    public PsAnblogBlogCategories(int idAnblogBlog, int idAnblogcat) {
        this.psAnblogBlogCategoriesPK = new PsAnblogBlogCategoriesPK(idAnblogBlog, idAnblogcat);
    }

    public PsAnblogBlogCategoriesPK getPsAnblogBlogCategoriesPK() {
        return psAnblogBlogCategoriesPK;
    }

    public void setPsAnblogBlogCategoriesPK(PsAnblogBlogCategoriesPK psAnblogBlogCategoriesPK) {
        this.psAnblogBlogCategoriesPK = psAnblogBlogCategoriesPK;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogBlogCategoriesPK != null ? psAnblogBlogCategoriesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogCategories)) {
            return false;
        }
        PsAnblogBlogCategories other = (PsAnblogBlogCategories) object;
        if ((this.psAnblogBlogCategoriesPK == null && other.psAnblogBlogCategoriesPK != null) || (this.psAnblogBlogCategoriesPK != null && !this.psAnblogBlogCategoriesPK.equals(other.psAnblogBlogCategoriesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogCategories[ psAnblogBlogCategoriesPK=" + psAnblogBlogCategoriesPK + " ]";
    }
    
}
