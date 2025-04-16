/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_anblog_blog_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogShop.findAll", query = "SELECT p FROM PsAnblogBlogShop p")})
public class PsAnblogBlogShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogBlogShopPK psAnblogBlogShopPK;

    public PsAnblogBlogShop() {
    }

    public PsAnblogBlogShop(PsAnblogBlogShopPK psAnblogBlogShopPK) {
        this.psAnblogBlogShopPK = psAnblogBlogShopPK;
    }

    public PsAnblogBlogShop(int idAnblogBlog, int idShop) {
        this.psAnblogBlogShopPK = new PsAnblogBlogShopPK(idAnblogBlog, idShop);
    }

    public PsAnblogBlogShopPK getPsAnblogBlogShopPK() {
        return psAnblogBlogShopPK;
    }

    public void setPsAnblogBlogShopPK(PsAnblogBlogShopPK psAnblogBlogShopPK) {
        this.psAnblogBlogShopPK = psAnblogBlogShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogBlogShopPK != null ? psAnblogBlogShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogShop)) {
            return false;
        }
        PsAnblogBlogShop other = (PsAnblogBlogShop) object;
        if ((this.psAnblogBlogShopPK == null && other.psAnblogBlogShopPK != null) || (this.psAnblogBlogShopPK != null && !this.psAnblogBlogShopPK.equals(other.psAnblogBlogShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogShop[ psAnblogBlogShopPK=" + psAnblogBlogShopPK + " ]";
    }
    
}
