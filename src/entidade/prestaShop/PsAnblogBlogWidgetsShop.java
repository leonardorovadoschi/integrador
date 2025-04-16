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
@Table(name = "ps_anblog_blog_widgets_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogWidgetsShop.findAll", query = "SELECT p FROM PsAnblogBlogWidgetsShop p")})
public class PsAnblogBlogWidgetsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogBlogWidgetsShopPK psAnblogBlogWidgetsShopPK;

    public PsAnblogBlogWidgetsShop() {
    }

    public PsAnblogBlogWidgetsShop(PsAnblogBlogWidgetsShopPK psAnblogBlogWidgetsShopPK) {
        this.psAnblogBlogWidgetsShopPK = psAnblogBlogWidgetsShopPK;
    }

    public PsAnblogBlogWidgetsShop(int idAnblogBlogWidgets, int idShop) {
        this.psAnblogBlogWidgetsShopPK = new PsAnblogBlogWidgetsShopPK(idAnblogBlogWidgets, idShop);
    }

    public PsAnblogBlogWidgetsShopPK getPsAnblogBlogWidgetsShopPK() {
        return psAnblogBlogWidgetsShopPK;
    }

    public void setPsAnblogBlogWidgetsShopPK(PsAnblogBlogWidgetsShopPK psAnblogBlogWidgetsShopPK) {
        this.psAnblogBlogWidgetsShopPK = psAnblogBlogWidgetsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogBlogWidgetsShopPK != null ? psAnblogBlogWidgetsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogWidgetsShop)) {
            return false;
        }
        PsAnblogBlogWidgetsShop other = (PsAnblogBlogWidgetsShop) object;
        if ((this.psAnblogBlogWidgetsShopPK == null && other.psAnblogBlogWidgetsShopPK != null) || (this.psAnblogBlogWidgetsShopPK != null && !this.psAnblogBlogWidgetsShopPK.equals(other.psAnblogBlogWidgetsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogWidgetsShop[ psAnblogBlogWidgetsShopPK=" + psAnblogBlogWidgetsShopPK + " ]";
    }
    
}
