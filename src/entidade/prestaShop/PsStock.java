/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ps_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStock.findAll", query = "SELECT p FROM PsStock p")
    , @NamedQuery(name = "PsStock.findByIdStock", query = "SELECT p FROM PsStock p WHERE p.idStock = :idStock")
    , @NamedQuery(name = "PsStock.findByIdWarehouse", query = "SELECT p FROM PsStock p WHERE p.idWarehouse = :idWarehouse")
    , @NamedQuery(name = "PsStock.findByIdProduct", query = "SELECT p FROM PsStock p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsStock.findByIdProductAttribute", query = "SELECT p FROM PsStock p WHERE p.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsStock.findByReference", query = "SELECT p FROM PsStock p WHERE p.reference = :reference")
    , @NamedQuery(name = "PsStock.findByEan13", query = "SELECT p FROM PsStock p WHERE p.ean13 = :ean13")
    , @NamedQuery(name = "PsStock.findByIsbn", query = "SELECT p FROM PsStock p WHERE p.isbn = :isbn")
    , @NamedQuery(name = "PsStock.findByUpc", query = "SELECT p FROM PsStock p WHERE p.upc = :upc")
    , @NamedQuery(name = "PsStock.findByPhysicalQuantity", query = "SELECT p FROM PsStock p WHERE p.physicalQuantity = :physicalQuantity")
    , @NamedQuery(name = "PsStock.findByUsableQuantity", query = "SELECT p FROM PsStock p WHERE p.usableQuantity = :usableQuantity")
    , @NamedQuery(name = "PsStock.findByPriceTe", query = "SELECT p FROM PsStock p WHERE p.priceTe = :priceTe")})
public class PsStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stock")
    private Integer idStock;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Column(name = "ean13")
    private String ean13;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "upc")
    private String upc;
    @Basic(optional = false)
    @Column(name = "physical_quantity")
    private int physicalQuantity;
    @Basic(optional = false)
    @Column(name = "usable_quantity")
    private int usableQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_te")
    private BigDecimal priceTe;

    public PsStock() {
    }

    public PsStock(Integer idStock) {
        this.idStock = idStock;
    }

    public PsStock(Integer idStock, int idWarehouse, int idProduct, int idProductAttribute, String reference, int physicalQuantity, int usableQuantity) {
        this.idStock = idStock;
        this.idWarehouse = idWarehouse;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.reference = reference;
        this.physicalQuantity = physicalQuantity;
        this.usableQuantity = usableQuantity;
    }

    public Integer getIdStock() {
        return idStock;
    }

    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public int getPhysicalQuantity() {
        return physicalQuantity;
    }

    public void setPhysicalQuantity(int physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public int getUsableQuantity() {
        return usableQuantity;
    }

    public void setUsableQuantity(int usableQuantity) {
        this.usableQuantity = usableQuantity;
    }

    public BigDecimal getPriceTe() {
        return priceTe;
    }

    public void setPriceTe(BigDecimal priceTe) {
        this.priceTe = priceTe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStock != null ? idStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStock)) {
            return false;
        }
        PsStock other = (PsStock) object;
        if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStock[ idStock=" + idStock + " ]";
    }
    
}
