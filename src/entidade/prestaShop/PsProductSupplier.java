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
@Table(name = "ps_product_supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductSupplier.findAll", query = "SELECT p FROM PsProductSupplier p")
    , @NamedQuery(name = "PsProductSupplier.findByIdProductSupplier", query = "SELECT p FROM PsProductSupplier p WHERE p.idProductSupplier = :idProductSupplier")
    , @NamedQuery(name = "PsProductSupplier.findByIdProduct", query = "SELECT p FROM PsProductSupplier p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductSupplier.findByIdProductAttribute", query = "SELECT p FROM PsProductSupplier p WHERE p.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsProductSupplier.findByIdSupplier", query = "SELECT p FROM PsProductSupplier p WHERE p.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsProductSupplier.findByProductSupplierReference", query = "SELECT p FROM PsProductSupplier p WHERE p.productSupplierReference = :productSupplierReference")
    , @NamedQuery(name = "PsProductSupplier.findByProductSupplierPriceTe", query = "SELECT p FROM PsProductSupplier p WHERE p.productSupplierPriceTe = :productSupplierPriceTe")
    , @NamedQuery(name = "PsProductSupplier.findByIdCurrency", query = "SELECT p FROM PsProductSupplier p WHERE p.idCurrency = :idCurrency")})
public class PsProductSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_supplier")
    private Integer idProductSupplier;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;
    @Column(name = "product_supplier_reference")
    private String productSupplierReference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "product_supplier_price_te")
    private BigDecimal productSupplierPriceTe;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;

    public PsProductSupplier() {
    }

    public PsProductSupplier(Integer idProductSupplier) {
        this.idProductSupplier = idProductSupplier;
    }

    public PsProductSupplier(Integer idProductSupplier, int idProduct, int idProductAttribute, int idSupplier, BigDecimal productSupplierPriceTe, int idCurrency) {
        this.idProductSupplier = idProductSupplier;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idSupplier = idSupplier;
        this.productSupplierPriceTe = productSupplierPriceTe;
        this.idCurrency = idCurrency;
    }

    public Integer getIdProductSupplier() {
        return idProductSupplier;
    }

    public void setIdProductSupplier(Integer idProductSupplier) {
        this.idProductSupplier = idProductSupplier;
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

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getProductSupplierReference() {
        return productSupplierReference;
    }

    public void setProductSupplierReference(String productSupplierReference) {
        this.productSupplierReference = productSupplierReference;
    }

    public BigDecimal getProductSupplierPriceTe() {
        return productSupplierPriceTe;
    }

    public void setProductSupplierPriceTe(BigDecimal productSupplierPriceTe) {
        this.productSupplierPriceTe = productSupplierPriceTe;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductSupplier != null ? idProductSupplier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductSupplier)) {
            return false;
        }
        PsProductSupplier other = (PsProductSupplier) object;
        if ((this.idProductSupplier == null && other.idProductSupplier != null) || (this.idProductSupplier != null && !this.idProductSupplier.equals(other.idProductSupplier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductSupplier[ idProductSupplier=" + idProductSupplier + " ]";
    }
    
}
