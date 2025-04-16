/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_wishlist_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWishlistProduct.findAll", query = "SELECT p FROM PsWishlistProduct p")})
public class PsWishlistProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wishlist_product")
    private Integer idWishlistProduct;
    @Basic(optional = false)
    @Column(name = "id_wishlist")
    private int idWishlist;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;

    public PsWishlistProduct() {
    }

    public PsWishlistProduct(Integer idWishlistProduct) {
        this.idWishlistProduct = idWishlistProduct;
    }

    public PsWishlistProduct(Integer idWishlistProduct, int idWishlist, int idProduct, int idProductAttribute, int quantity, int priority) {
        this.idWishlistProduct = idWishlistProduct;
        this.idWishlist = idWishlist;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.quantity = quantity;
        this.priority = priority;
    }

    public Integer getIdWishlistProduct() {
        return idWishlistProduct;
    }

    public void setIdWishlistProduct(Integer idWishlistProduct) {
        this.idWishlistProduct = idWishlistProduct;
    }

    public int getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(int idWishlist) {
        this.idWishlist = idWishlist;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWishlistProduct != null ? idWishlistProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWishlistProduct)) {
            return false;
        }
        PsWishlistProduct other = (PsWishlistProduct) object;
        if ((this.idWishlistProduct == null && other.idWishlistProduct != null) || (this.idWishlistProduct != null && !this.idWishlistProduct.equals(other.idWishlistProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWishlistProduct[ idWishlistProduct=" + idWishlistProduct + " ]";
    }
    
}
