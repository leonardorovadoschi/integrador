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
@Table(name = "ps_warehouse_product_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWarehouseProductLocation.findAll", query = "SELECT p FROM PsWarehouseProductLocation p")
    , @NamedQuery(name = "PsWarehouseProductLocation.findByIdWarehouseProductLocation", query = "SELECT p FROM PsWarehouseProductLocation p WHERE p.idWarehouseProductLocation = :idWarehouseProductLocation")
    , @NamedQuery(name = "PsWarehouseProductLocation.findByIdProduct", query = "SELECT p FROM PsWarehouseProductLocation p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsWarehouseProductLocation.findByIdProductAttribute", query = "SELECT p FROM PsWarehouseProductLocation p WHERE p.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsWarehouseProductLocation.findByIdWarehouse", query = "SELECT p FROM PsWarehouseProductLocation p WHERE p.idWarehouse = :idWarehouse")
    , @NamedQuery(name = "PsWarehouseProductLocation.findByLocation", query = "SELECT p FROM PsWarehouseProductLocation p WHERE p.location = :location")})
public class PsWarehouseProductLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_warehouse_product_location")
    private Integer idWarehouseProductLocation;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Column(name = "location")
    private String location;

    public PsWarehouseProductLocation() {
    }

    public PsWarehouseProductLocation(Integer idWarehouseProductLocation) {
        this.idWarehouseProductLocation = idWarehouseProductLocation;
    }

    public PsWarehouseProductLocation(Integer idWarehouseProductLocation, int idProduct, int idProductAttribute, int idWarehouse) {
        this.idWarehouseProductLocation = idWarehouseProductLocation;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idWarehouse = idWarehouse;
    }

    public Integer getIdWarehouseProductLocation() {
        return idWarehouseProductLocation;
    }

    public void setIdWarehouseProductLocation(Integer idWarehouseProductLocation) {
        this.idWarehouseProductLocation = idWarehouseProductLocation;
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

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
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
        hash += (idWarehouseProductLocation != null ? idWarehouseProductLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouseProductLocation)) {
            return false;
        }
        PsWarehouseProductLocation other = (PsWarehouseProductLocation) object;
        if ((this.idWarehouseProductLocation == null && other.idWarehouseProductLocation != null) || (this.idWarehouseProductLocation != null && !this.idWarehouseProductLocation.equals(other.idWarehouseProductLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouseProductLocation[ idWarehouseProductLocation=" + idWarehouseProductLocation + " ]";
    }
    
}
