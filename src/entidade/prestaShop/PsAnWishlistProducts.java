/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_wishlist_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnWishlistProducts.findAll", query = "SELECT p FROM PsAnWishlistProducts p")})
public class PsAnWishlistProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wishlist_products")
    private Integer idWishlistProducts;
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
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsAnWishlistProducts() {
    }

    public PsAnWishlistProducts(Integer idWishlistProducts) {
        this.idWishlistProducts = idWishlistProducts;
    }

    public PsAnWishlistProducts(Integer idWishlistProducts, int idWishlist, int idProduct, int idProductAttribute, Date dateAdd) {
        this.idWishlistProducts = idWishlistProducts;
        this.idWishlist = idWishlist;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.dateAdd = dateAdd;
    }

    public Integer getIdWishlistProducts() {
        return idWishlistProducts;
    }

    public void setIdWishlistProducts(Integer idWishlistProducts) {
        this.idWishlistProducts = idWishlistProducts;
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

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWishlistProducts != null ? idWishlistProducts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnWishlistProducts)) {
            return false;
        }
        PsAnWishlistProducts other = (PsAnWishlistProducts) object;
        if ((this.idWishlistProducts == null && other.idWishlistProducts != null) || (this.idWishlistProducts != null && !this.idWishlistProducts.equals(other.idWishlistProducts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnWishlistProducts[ idWishlistProducts=" + idWishlistProducts + " ]";
    }
    
}
