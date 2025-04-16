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
@Table(name = "ps_blockwishlist_statistics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsBlockwishlistStatistics.findAll", query = "SELECT p FROM PsBlockwishlistStatistics p")})
public class PsBlockwishlistStatistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_statistics")
    private Integer idStatistics;
    @Column(name = "id_cart")
    private Integer idCart;
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
    @Column(name = "id_shop")
    private Integer idShop;

    public PsBlockwishlistStatistics() {
    }

    public PsBlockwishlistStatistics(Integer idStatistics) {
        this.idStatistics = idStatistics;
    }

    public PsBlockwishlistStatistics(Integer idStatistics, int idProduct, int idProductAttribute, Date dateAdd) {
        this.idStatistics = idStatistics;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.dateAdd = dateAdd;
    }

    public Integer getIdStatistics() {
        return idStatistics;
    }

    public void setIdStatistics(Integer idStatistics) {
        this.idStatistics = idStatistics;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
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

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatistics != null ? idStatistics.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBlockwishlistStatistics)) {
            return false;
        }
        PsBlockwishlistStatistics other = (PsBlockwishlistStatistics) object;
        if ((this.idStatistics == null && other.idStatistics != null) || (this.idStatistics != null && !this.idStatistics.equals(other.idStatistics))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsBlockwishlistStatistics[ idStatistics=" + idStatistics + " ]";
    }
    
}
