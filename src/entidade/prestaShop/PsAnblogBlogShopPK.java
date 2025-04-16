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
public class PsAnblogBlogShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblog_blog")
    private int idAnblogBlog;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnblogBlogShopPK() {
    }

    public PsAnblogBlogShopPK(int idAnblogBlog, int idShop) {
        this.idAnblogBlog = idAnblogBlog;
        this.idShop = idShop;
    }

    public int getIdAnblogBlog() {
        return idAnblogBlog;
    }

    public void setIdAnblogBlog(int idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnblogBlog;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogShopPK)) {
            return false;
        }
        PsAnblogBlogShopPK other = (PsAnblogBlogShopPK) object;
        if (this.idAnblogBlog != other.idAnblogBlog) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogShopPK[ idAnblogBlog=" + idAnblogBlog + ", idShop=" + idShop + " ]";
    }
    
}
