/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author leo
 */
@Entity
@Table(name = "ps_supply_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrder.findAll", query = "SELECT p FROM PsSupplyOrder p")
    , @NamedQuery(name = "PsSupplyOrder.findByIdSupplyOrder", query = "SELECT p FROM PsSupplyOrder p WHERE p.idSupplyOrder = :idSupplyOrder")
    , @NamedQuery(name = "PsSupplyOrder.findByIdSupplier", query = "SELECT p FROM PsSupplyOrder p WHERE p.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsSupplyOrder.findBySupplierName", query = "SELECT p FROM PsSupplyOrder p WHERE p.supplierName = :supplierName")
    , @NamedQuery(name = "PsSupplyOrder.findByIdLang", query = "SELECT p FROM PsSupplyOrder p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsSupplyOrder.findByIdWarehouse", query = "SELECT p FROM PsSupplyOrder p WHERE p.idWarehouse = :idWarehouse")
    , @NamedQuery(name = "PsSupplyOrder.findByIdSupplyOrderState", query = "SELECT p FROM PsSupplyOrder p WHERE p.idSupplyOrderState = :idSupplyOrderState")
    , @NamedQuery(name = "PsSupplyOrder.findByIdCurrency", query = "SELECT p FROM PsSupplyOrder p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsSupplyOrder.findByIdRefCurrency", query = "SELECT p FROM PsSupplyOrder p WHERE p.idRefCurrency = :idRefCurrency")
    , @NamedQuery(name = "PsSupplyOrder.findByReference", query = "SELECT p FROM PsSupplyOrder p WHERE p.reference = :reference")
    , @NamedQuery(name = "PsSupplyOrder.findByDateAdd", query = "SELECT p FROM PsSupplyOrder p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsSupplyOrder.findByDateUpd", query = "SELECT p FROM PsSupplyOrder p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsSupplyOrder.findByDateDeliveryExpected", query = "SELECT p FROM PsSupplyOrder p WHERE p.dateDeliveryExpected = :dateDeliveryExpected")
    , @NamedQuery(name = "PsSupplyOrder.findByTotalTe", query = "SELECT p FROM PsSupplyOrder p WHERE p.totalTe = :totalTe")
    , @NamedQuery(name = "PsSupplyOrder.findByTotalWithDiscountTe", query = "SELECT p FROM PsSupplyOrder p WHERE p.totalWithDiscountTe = :totalWithDiscountTe")
    , @NamedQuery(name = "PsSupplyOrder.findByTotalTax", query = "SELECT p FROM PsSupplyOrder p WHERE p.totalTax = :totalTax")
    , @NamedQuery(name = "PsSupplyOrder.findByTotalTi", query = "SELECT p FROM PsSupplyOrder p WHERE p.totalTi = :totalTi")
    , @NamedQuery(name = "PsSupplyOrder.findByDiscountRate", query = "SELECT p FROM PsSupplyOrder p WHERE p.discountRate = :discountRate")
    , @NamedQuery(name = "PsSupplyOrder.findByDiscountValueTe", query = "SELECT p FROM PsSupplyOrder p WHERE p.discountValueTe = :discountValueTe")
    , @NamedQuery(name = "PsSupplyOrder.findByIsTemplate", query = "SELECT p FROM PsSupplyOrder p WHERE p.isTemplate = :isTemplate")})
public class PsSupplyOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supply_order")
    private Integer idSupplyOrder;
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;
    @Basic(optional = false)
    @Column(name = "supplier_name")
    private String supplierName;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Basic(optional = false)
    @Column(name = "id_supply_order_state")
    private int idSupplyOrderState;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_ref_currency")
    private int idRefCurrency;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Column(name = "date_delivery_expected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeliveryExpected;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_te")
    private BigDecimal totalTe;
    @Column(name = "total_with_discount_te")
    private BigDecimal totalWithDiscountTe;
    @Column(name = "total_tax")
    private BigDecimal totalTax;
    @Column(name = "total_ti")
    private BigDecimal totalTi;
    @Column(name = "discount_rate")
    private BigDecimal discountRate;
    @Column(name = "discount_value_te")
    private BigDecimal discountValueTe;
    @Column(name = "is_template")
    private Boolean isTemplate;

    public PsSupplyOrder() {
    }

    public PsSupplyOrder(Integer idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public PsSupplyOrder(Integer idSupplyOrder, int idSupplier, String supplierName, int idLang, int idWarehouse, int idSupplyOrderState, int idCurrency, int idRefCurrency, String reference, Date dateAdd, Date dateUpd) {
        this.idSupplyOrder = idSupplyOrder;
        this.idSupplier = idSupplier;
        this.supplierName = supplierName;
        this.idLang = idLang;
        this.idWarehouse = idWarehouse;
        this.idSupplyOrderState = idSupplyOrderState;
        this.idCurrency = idCurrency;
        this.idRefCurrency = idRefCurrency;
        this.reference = reference;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public void setIdSupplyOrder(Integer idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getIdSupplyOrderState() {
        return idSupplyOrderState;
    }

    public void setIdSupplyOrderState(int idSupplyOrderState) {
        this.idSupplyOrderState = idSupplyOrderState;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdRefCurrency() {
        return idRefCurrency;
    }

    public void setIdRefCurrency(int idRefCurrency) {
        this.idRefCurrency = idRefCurrency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public Date getDateDeliveryExpected() {
        return dateDeliveryExpected;
    }

    public void setDateDeliveryExpected(Date dateDeliveryExpected) {
        this.dateDeliveryExpected = dateDeliveryExpected;
    }

    public BigDecimal getTotalTe() {
        return totalTe;
    }

    public void setTotalTe(BigDecimal totalTe) {
        this.totalTe = totalTe;
    }

    public BigDecimal getTotalWithDiscountTe() {
        return totalWithDiscountTe;
    }

    public void setTotalWithDiscountTe(BigDecimal totalWithDiscountTe) {
        this.totalWithDiscountTe = totalWithDiscountTe;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalTi() {
        return totalTi;
    }

    public void setTotalTi(BigDecimal totalTi) {
        this.totalTi = totalTi;
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

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupplyOrder != null ? idSupplyOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrder)) {
            return false;
        }
        PsSupplyOrder other = (PsSupplyOrder) object;
        if ((this.idSupplyOrder == null && other.idSupplyOrder != null) || (this.idSupplyOrder != null && !this.idSupplyOrder.equals(other.idSupplyOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrder[ idSupplyOrder=" + idSupplyOrder + " ]";
    }
    
}
