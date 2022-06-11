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
@Table(name = "ps_supply_order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrderDetail.findAll", query = "SELECT p FROM PsSupplyOrderDetail p")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIdSupplyOrderDetail", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.idSupplyOrderDetail = :idSupplyOrderDetail")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIdSupplyOrder", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.idSupplyOrder = :idSupplyOrder")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIdCurrency", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIdProduct", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIdProductAttribute", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByReference", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.reference = :reference")
    , @NamedQuery(name = "PsSupplyOrderDetail.findBySupplierReference", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.supplierReference = :supplierReference")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByName", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.name = :name")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByEan13", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.ean13 = :ean13")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByIsbn", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.isbn = :isbn")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByUpc", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.upc = :upc")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByExchangeRate", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.exchangeRate = :exchangeRate")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByUnitPriceTe", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.unitPriceTe = :unitPriceTe")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByQuantityExpected", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.quantityExpected = :quantityExpected")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByQuantityReceived", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.quantityReceived = :quantityReceived")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByPriceTe", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.priceTe = :priceTe")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByDiscountRate", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.discountRate = :discountRate")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByDiscountValueTe", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.discountValueTe = :discountValueTe")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByPriceWithDiscountTe", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.priceWithDiscountTe = :priceWithDiscountTe")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByTaxRate", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.taxRate = :taxRate")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByTaxValue", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.taxValue = :taxValue")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByPriceTi", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.priceTi = :priceTi")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByTaxValueWithOrderDiscount", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.taxValueWithOrderDiscount = :taxValueWithOrderDiscount")
    , @NamedQuery(name = "PsSupplyOrderDetail.findByPriceWithOrderDiscountTe", query = "SELECT p FROM PsSupplyOrderDetail p WHERE p.priceWithOrderDiscountTe = :priceWithOrderDiscountTe")})
public class PsSupplyOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supply_order_detail")
    private Integer idSupplyOrderDetail;
    @Basic(optional = false)
    @Column(name = "id_supply_order")
    private int idSupplyOrder;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "supplier_reference")
    private String supplierReference;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "ean13")
    private String ean13;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "upc")
    private String upc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;
    @Column(name = "unit_price_te")
    private BigDecimal unitPriceTe;
    @Basic(optional = false)
    @Column(name = "quantity_expected")
    private int quantityExpected;
    @Basic(optional = false)
    @Column(name = "quantity_received")
    private int quantityReceived;
    @Column(name = "price_te")
    private BigDecimal priceTe;
    @Column(name = "discount_rate")
    private BigDecimal discountRate;
    @Column(name = "discount_value_te")
    private BigDecimal discountValueTe;
    @Column(name = "price_with_discount_te")
    private BigDecimal priceWithDiscountTe;
    @Column(name = "tax_rate")
    private BigDecimal taxRate;
    @Column(name = "tax_value")
    private BigDecimal taxValue;
    @Column(name = "price_ti")
    private BigDecimal priceTi;
    @Column(name = "tax_value_with_order_discount")
    private BigDecimal taxValueWithOrderDiscount;
    @Column(name = "price_with_order_discount_te")
    private BigDecimal priceWithOrderDiscountTe;

    public PsSupplyOrderDetail() {
    }

    public PsSupplyOrderDetail(Integer idSupplyOrderDetail) {
        this.idSupplyOrderDetail = idSupplyOrderDetail;
    }

    public PsSupplyOrderDetail(Integer idSupplyOrderDetail, int idSupplyOrder, int idCurrency, int idProduct, int idProductAttribute, String reference, String supplierReference, String name, int quantityExpected, int quantityReceived) {
        this.idSupplyOrderDetail = idSupplyOrderDetail;
        this.idSupplyOrder = idSupplyOrder;
        this.idCurrency = idCurrency;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.reference = reference;
        this.supplierReference = supplierReference;
        this.name = name;
        this.quantityExpected = quantityExpected;
        this.quantityReceived = quantityReceived;
    }

    public Integer getIdSupplyOrderDetail() {
        return idSupplyOrderDetail;
    }

    public void setIdSupplyOrderDetail(Integer idSupplyOrderDetail) {
        this.idSupplyOrderDetail = idSupplyOrderDetail;
    }

    public int getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public void setIdSupplyOrder(int idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
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

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getUnitPriceTe() {
        return unitPriceTe;
    }

    public void setUnitPriceTe(BigDecimal unitPriceTe) {
        this.unitPriceTe = unitPriceTe;
    }

    public int getQuantityExpected() {
        return quantityExpected;
    }

    public void setQuantityExpected(int quantityExpected) {
        this.quantityExpected = quantityExpected;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public BigDecimal getPriceTe() {
        return priceTe;
    }

    public void setPriceTe(BigDecimal priceTe) {
        this.priceTe = priceTe;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getDiscountValueTe() {
        return discountValueTe;
    }

    public void setDiscountValueTe(BigDecimal discountValueTe) {
        this.discountValueTe = discountValueTe;
    }

    public BigDecimal getPriceWithDiscountTe() {
        return priceWithDiscountTe;
    }

    public void setPriceWithDiscountTe(BigDecimal priceWithDiscountTe) {
        this.priceWithDiscountTe = priceWithDiscountTe;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getPriceTi() {
        return priceTi;
    }

    public void setPriceTi(BigDecimal priceTi) {
        this.priceTi = priceTi;
    }

    public BigDecimal getTaxValueWithOrderDiscount() {
        return taxValueWithOrderDiscount;
    }

    public void setTaxValueWithOrderDiscount(BigDecimal taxValueWithOrderDiscount) {
        this.taxValueWithOrderDiscount = taxValueWithOrderDiscount;
    }

    public BigDecimal getPriceWithOrderDiscountTe() {
        return priceWithOrderDiscountTe;
    }

    public void setPriceWithOrderDiscountTe(BigDecimal priceWithOrderDiscountTe) {
        this.priceWithOrderDiscountTe = priceWithOrderDiscountTe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupplyOrderDetail != null ? idSupplyOrderDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderDetail)) {
            return false;
        }
        PsSupplyOrderDetail other = (PsSupplyOrderDetail) object;
        if ((this.idSupplyOrderDetail == null && other.idSupplyOrderDetail != null) || (this.idSupplyOrderDetail != null && !this.idSupplyOrderDetail.equals(other.idSupplyOrderDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderDetail[ idSupplyOrderDetail=" + idSupplyOrderDetail + " ]";
    }
    
}
