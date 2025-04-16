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
 * @author leo
 */
@Entity
@Table(name = "ps_stock_available")
@XmlRootElement

public class PsStockAvailable implements Serializable {
    @Basic(optional = false)
    @Column(name = "depends_on_stock")
    private short dependsOnStock;
    @Basic(optional = false)
    @Column(name = "out_of_stock")
    private short outOfStock;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stock_available")
    private Integer idStockAvailable;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "physical_quantity")
    private int physicalQuantity;
    @Basic(optional = false)
    @Column(name = "reserved_quantity")
    private int reservedQuantity;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;

    public PsStockAvailable() {
    }

    public PsStockAvailable(Integer idStockAvailable) {
        this.idStockAvailable = idStockAvailable;
    }

    public PsStockAvailable(Integer idStockAvailable, int idProduct, int idProductAttribute, int idShop, int idShopGroup, int quantity, int physicalQuantity, int reservedQuantity, short dependsOnStock, short outOfStock, String location) {
        this.idStockAvailable = idStockAvailable;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.quantity = quantity;
        this.physicalQuantity = physicalQuantity;
        this.reservedQuantity = reservedQuantity;
        this.dependsOnStock = dependsOnStock;
        this.outOfStock = outOfStock;
        this.location = location;
    }

    public Integer getIdStockAvailable() {
        return idStockAvailable;
    }

    public void setIdStockAvailable(Integer idStockAvailable) {
        this.idStockAvailable = idStockAvailable;
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

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPhysicalQuantity() {
        return physicalQuantity;
    }

    public void setPhysicalQuantity(int physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStockAvailable != null ? idStockAvailable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStockAvailable)) {
            return false;
        }
        PsStockAvailable other = (PsStockAvailable) object;
        if ((this.idStockAvailable == null && other.idStockAvailable != null) || (this.idStockAvailable != null && !this.idStockAvailable.equals(other.idStockAvailable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStockAvailable[ idStockAvailable=" + idStockAvailable + " ]";
    }

    public short getDependsOnStock() {
        return dependsOnStock;
    }

    public void setDependsOnStock(short dependsOnStock) {
        this.dependsOnStock = dependsOnStock;
    }

    public short getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(short outOfStock) {
        this.outOfStock = outOfStock;
    }
    
}
