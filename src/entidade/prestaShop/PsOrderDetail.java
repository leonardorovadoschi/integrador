/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_detail")

public class PsOrderDetail implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_detail")
    private Integer idOrderDetail;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Column(name = "id_order_invoice")
    private Integer idOrderInvoice;
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_attribute_id")
    private Integer productAttributeId;
    @Column(name = "id_customization")
    private Integer idCustomization;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "product_quantity")
    private int productQuantity;
    @Basic(optional = false)
    @Column(name = "product_quantity_in_stock")
    private int productQuantityInStock;
    @Basic(optional = false)
    @Column(name = "product_quantity_refunded")
    private int productQuantityRefunded;
    @Basic(optional = false)
    @Column(name = "product_quantity_return")
    private int productQuantityReturn;
    @Basic(optional = false)
    @Column(name = "product_quantity_reinjected")
    private int productQuantityReinjected;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Basic(optional = false)
    @Column(name = "reduction_percent")
    private BigDecimal reductionPercent;
    @Basic(optional = false)
    @Column(name = "reduction_amount")
    private BigDecimal reductionAmount;
    @Basic(optional = false)
    @Column(name = "reduction_amount_tax_incl")
    private BigDecimal reductionAmountTaxIncl;
    @Basic(optional = false)
    @Column(name = "reduction_amount_tax_excl")
    private BigDecimal reductionAmountTaxExcl;
    @Basic(optional = false)
    @Column(name = "group_reduction")
    private BigDecimal groupReduction;
    @Basic(optional = false)
    @Column(name = "product_quantity_discount")
    private BigDecimal productQuantityDiscount;
    @Column(name = "product_ean13")
    private String productEan13;
    @Column(name = "product_isbn")
    private String productIsbn;
    @Column(name = "product_upc")
    private String productUpc;
    @Column(name = "product_reference")
    private String productReference;
    @Column(name = "product_supplier_reference")
    private String productSupplierReference;
    @Basic(optional = false)
    @Column(name = "product_weight")
    private BigDecimal productWeight;
    @Column(name = "id_tax_rules_group")
    private Integer idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "tax_computation_method")
    private boolean taxComputationMethod;
    @Basic(optional = false)
    @Column(name = "tax_name")
    private String taxName;
    @Basic(optional = false)
    @Column(name = "tax_rate")
    private BigDecimal taxRate;
    @Basic(optional = false)
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @Column(name = "ecotax_tax_rate")
    private BigDecimal ecotaxTaxRate;
    @Basic(optional = false)
    @Column(name = "discount_quantity_applied")
    private boolean discountQuantityApplied;
    @Column(name = "download_hash")
    private String downloadHash;
    @Column(name = "download_nb")
    private Integer downloadNb;
    @Column(name = "download_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadDeadline;
    @Basic(optional = false)
    @Column(name = "total_price_tax_incl")
    private BigDecimal totalPriceTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_price_tax_excl")
    private BigDecimal totalPriceTaxExcl;
    @Basic(optional = false)
    @Column(name = "unit_price_tax_incl")
    private BigDecimal unitPriceTaxIncl;
    @Basic(optional = false)
    @Column(name = "unit_price_tax_excl")
    private BigDecimal unitPriceTaxExcl;
    @Basic(optional = false)
    @Column(name = "total_shipping_price_tax_incl")
    private BigDecimal totalShippingPriceTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_shipping_price_tax_excl")
    private BigDecimal totalShippingPriceTaxExcl;
    @Basic(optional = false)
    @Column(name = "purchase_supplier_price")
    private BigDecimal purchaseSupplierPrice;
    @Basic(optional = false)
    @Column(name = "original_product_price")
    private BigDecimal originalProductPrice;
    @Basic(optional = false)
    @Column(name = "original_wholesale_price")
    private BigDecimal originalWholesalePrice;

    public PsOrderDetail() {
    }

    public PsOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public PsOrderDetail(Integer idOrderDetail, int idOrder, int idShop, int productId, String productName, int productQuantity, int productQuantityInStock, int productQuantityRefunded, int productQuantityReturn, int productQuantityReinjected, BigDecimal productPrice, BigDecimal reductionPercent, BigDecimal reductionAmount, BigDecimal reductionAmountTaxIncl, BigDecimal reductionAmountTaxExcl, BigDecimal groupReduction, BigDecimal productQuantityDiscount, BigDecimal productWeight, boolean taxComputationMethod, String taxName, BigDecimal taxRate, BigDecimal ecotax, BigDecimal ecotaxTaxRate, boolean discountQuantityApplied, BigDecimal totalPriceTaxIncl, BigDecimal totalPriceTaxExcl, BigDecimal unitPriceTaxIncl, BigDecimal unitPriceTaxExcl, BigDecimal totalShippingPriceTaxIncl, BigDecimal totalShippingPriceTaxExcl, BigDecimal purchaseSupplierPrice, BigDecimal originalProductPrice, BigDecimal originalWholesalePrice) {
        this.idOrderDetail = idOrderDetail;
        this.idOrder = idOrder;
        this.idShop = idShop;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productQuantityInStock = productQuantityInStock;
        this.productQuantityRefunded = productQuantityRefunded;
        this.productQuantityReturn = productQuantityReturn;
        this.productQuantityReinjected = productQuantityReinjected;
        this.productPrice = productPrice;
        this.reductionPercent = reductionPercent;
        this.reductionAmount = reductionAmount;
        this.reductionAmountTaxIncl = reductionAmountTaxIncl;
        this.reductionAmountTaxExcl = reductionAmountTaxExcl;
        this.groupReduction = groupReduction;
        this.productQuantityDiscount = productQuantityDiscount;
        this.productWeight = productWeight;
        this.taxComputationMethod = taxComputationMethod;
        this.taxName = taxName;
        this.taxRate = taxRate;
        this.ecotax = ecotax;
        this.ecotaxTaxRate = ecotaxTaxRate;
        this.discountQuantityApplied = discountQuantityApplied;
        this.totalPriceTaxIncl = totalPriceTaxIncl;
        this.totalPriceTaxExcl = totalPriceTaxExcl;
        this.unitPriceTaxIncl = unitPriceTaxIncl;
        this.unitPriceTaxExcl = unitPriceTaxExcl;
        this.totalShippingPriceTaxIncl = totalShippingPriceTaxIncl;
        this.totalShippingPriceTaxExcl = totalShippingPriceTaxExcl;
        this.purchaseSupplierPrice = purchaseSupplierPrice;
        this.originalProductPrice = originalProductPrice;
        this.originalWholesalePrice = originalWholesalePrice;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        Integer oldIdOrderDetail = this.idOrderDetail;
        this.idOrderDetail = idOrderDetail;
        changeSupport.firePropertyChange("idOrderDetail", oldIdOrderDetail, idOrderDetail);
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        int oldIdOrder = this.idOrder;
        this.idOrder = idOrder;
        changeSupport.firePropertyChange("idOrder", oldIdOrder, idOrder);
    }

    public Integer getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(Integer idOrderInvoice) {
        Integer oldIdOrderInvoice = this.idOrderInvoice;
        this.idOrderInvoice = idOrderInvoice;
        changeSupport.firePropertyChange("idOrderInvoice", oldIdOrderInvoice, idOrderInvoice);
    }

    public Integer getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(Integer idWarehouse) {
        Integer oldIdWarehouse = this.idWarehouse;
        this.idWarehouse = idWarehouse;
        changeSupport.firePropertyChange("idWarehouse", oldIdWarehouse, idWarehouse);
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        int oldIdShop = this.idShop;
        this.idShop = idShop;
        changeSupport.firePropertyChange("idShop", oldIdShop, idShop);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        int oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public Integer getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Integer productAttributeId) {
        Integer oldProductAttributeId = this.productAttributeId;
        this.productAttributeId = productAttributeId;
        changeSupport.firePropertyChange("productAttributeId", oldProductAttributeId, productAttributeId);
    }

    public Integer getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(Integer idCustomization) {
        Integer oldIdCustomization = this.idCustomization;
        this.idCustomization = idCustomization;
        changeSupport.firePropertyChange("idCustomization", oldIdCustomization, idCustomization);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        int oldProductQuantity = this.productQuantity;
        this.productQuantity = productQuantity;
        changeSupport.firePropertyChange("productQuantity", oldProductQuantity, productQuantity);
    }

    public int getProductQuantityInStock() {
        return productQuantityInStock;
    }

    public void setProductQuantityInStock(int productQuantityInStock) {
        int oldProductQuantityInStock = this.productQuantityInStock;
        this.productQuantityInStock = productQuantityInStock;
        changeSupport.firePropertyChange("productQuantityInStock", oldProductQuantityInStock, productQuantityInStock);
    }

    public int getProductQuantityRefunded() {
        return productQuantityRefunded;
    }

    public void setProductQuantityRefunded(int productQuantityRefunded) {
        int oldProductQuantityRefunded = this.productQuantityRefunded;
        this.productQuantityRefunded = productQuantityRefunded;
        changeSupport.firePropertyChange("productQuantityRefunded", oldProductQuantityRefunded, productQuantityRefunded);
    }

    public int getProductQuantityReturn() {
        return productQuantityReturn;
    }

    public void setProductQuantityReturn(int productQuantityReturn) {
        int oldProductQuantityReturn = this.productQuantityReturn;
        this.productQuantityReturn = productQuantityReturn;
        changeSupport.firePropertyChange("productQuantityReturn", oldProductQuantityReturn, productQuantityReturn);
    }

    public int getProductQuantityReinjected() {
        return productQuantityReinjected;
    }

    public void setProductQuantityReinjected(int productQuantityReinjected) {
        int oldProductQuantityReinjected = this.productQuantityReinjected;
        this.productQuantityReinjected = productQuantityReinjected;
        changeSupport.firePropertyChange("productQuantityReinjected", oldProductQuantityReinjected, productQuantityReinjected);
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        BigDecimal oldProductPrice = this.productPrice;
        this.productPrice = productPrice;
        changeSupport.firePropertyChange("productPrice", oldProductPrice, productPrice);
    }

    public BigDecimal getReductionPercent() {
        return reductionPercent;
    }

    public void setReductionPercent(BigDecimal reductionPercent) {
        BigDecimal oldReductionPercent = this.reductionPercent;
        this.reductionPercent = reductionPercent;
        changeSupport.firePropertyChange("reductionPercent", oldReductionPercent, reductionPercent);
    }

    public BigDecimal getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(BigDecimal reductionAmount) {
        BigDecimal oldReductionAmount = this.reductionAmount;
        this.reductionAmount = reductionAmount;
        changeSupport.firePropertyChange("reductionAmount", oldReductionAmount, reductionAmount);
    }

    public BigDecimal getReductionAmountTaxIncl() {
        return reductionAmountTaxIncl;
    }

    public void setReductionAmountTaxIncl(BigDecimal reductionAmountTaxIncl) {
        BigDecimal oldReductionAmountTaxIncl = this.reductionAmountTaxIncl;
        this.reductionAmountTaxIncl = reductionAmountTaxIncl;
        changeSupport.firePropertyChange("reductionAmountTaxIncl", oldReductionAmountTaxIncl, reductionAmountTaxIncl);
    }

    public BigDecimal getReductionAmountTaxExcl() {
        return reductionAmountTaxExcl;
    }

    public void setReductionAmountTaxExcl(BigDecimal reductionAmountTaxExcl) {
        BigDecimal oldReductionAmountTaxExcl = this.reductionAmountTaxExcl;
        this.reductionAmountTaxExcl = reductionAmountTaxExcl;
        changeSupport.firePropertyChange("reductionAmountTaxExcl", oldReductionAmountTaxExcl, reductionAmountTaxExcl);
    }

    public BigDecimal getGroupReduction() {
        return groupReduction;
    }

    public void setGroupReduction(BigDecimal groupReduction) {
        BigDecimal oldGroupReduction = this.groupReduction;
        this.groupReduction = groupReduction;
        changeSupport.firePropertyChange("groupReduction", oldGroupReduction, groupReduction);
    }

    public BigDecimal getProductQuantityDiscount() {
        return productQuantityDiscount;
    }

    public void setProductQuantityDiscount(BigDecimal productQuantityDiscount) {
        BigDecimal oldProductQuantityDiscount = this.productQuantityDiscount;
        this.productQuantityDiscount = productQuantityDiscount;
        changeSupport.firePropertyChange("productQuantityDiscount", oldProductQuantityDiscount, productQuantityDiscount);
    }

    public String getProductEan13() {
        return productEan13;
    }

    public void setProductEan13(String productEan13) {
        String oldProductEan13 = this.productEan13;
        this.productEan13 = productEan13;
        changeSupport.firePropertyChange("productEan13", oldProductEan13, productEan13);
    }

    public String getProductIsbn() {
        return productIsbn;
    }

    public void setProductIsbn(String productIsbn) {
        String oldProductIsbn = this.productIsbn;
        this.productIsbn = productIsbn;
        changeSupport.firePropertyChange("productIsbn", oldProductIsbn, productIsbn);
    }

    public String getProductUpc() {
        return productUpc;
    }

    public void setProductUpc(String productUpc) {
        String oldProductUpc = this.productUpc;
        this.productUpc = productUpc;
        changeSupport.firePropertyChange("productUpc", oldProductUpc, productUpc);
    }

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        String oldProductReference = this.productReference;
        this.productReference = productReference;
        changeSupport.firePropertyChange("productReference", oldProductReference, productReference);
    }

    public String getProductSupplierReference() {
        return productSupplierReference;
    }

    public void setProductSupplierReference(String productSupplierReference) {
        String oldProductSupplierReference = this.productSupplierReference;
        this.productSupplierReference = productSupplierReference;
        changeSupport.firePropertyChange("productSupplierReference", oldProductSupplierReference, productSupplierReference);
    }

    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        BigDecimal oldProductWeight = this.productWeight;
        this.productWeight = productWeight;
        changeSupport.firePropertyChange("productWeight", oldProductWeight, productWeight);
    }

    public Integer getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
        Integer oldIdTaxRulesGroup = this.idTaxRulesGroup;
        this.idTaxRulesGroup = idTaxRulesGroup;
        changeSupport.firePropertyChange("idTaxRulesGroup", oldIdTaxRulesGroup, idTaxRulesGroup);
    }

    public boolean getTaxComputationMethod() {
        return taxComputationMethod;
    }

    public void setTaxComputationMethod(boolean taxComputationMethod) {
        boolean oldTaxComputationMethod = this.taxComputationMethod;
        this.taxComputationMethod = taxComputationMethod;
        changeSupport.firePropertyChange("taxComputationMethod", oldTaxComputationMethod, taxComputationMethod);
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        String oldTaxName = this.taxName;
        this.taxName = taxName;
        changeSupport.firePropertyChange("taxName", oldTaxName, taxName);
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        BigDecimal oldTaxRate = this.taxRate;
        this.taxRate = taxRate;
        changeSupport.firePropertyChange("taxRate", oldTaxRate, taxRate);
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        BigDecimal oldEcotax = this.ecotax;
        this.ecotax = ecotax;
        changeSupport.firePropertyChange("ecotax", oldEcotax, ecotax);
    }

    public BigDecimal getEcotaxTaxRate() {
        return ecotaxTaxRate;
    }

    public void setEcotaxTaxRate(BigDecimal ecotaxTaxRate) {
        BigDecimal oldEcotaxTaxRate = this.ecotaxTaxRate;
        this.ecotaxTaxRate = ecotaxTaxRate;
        changeSupport.firePropertyChange("ecotaxTaxRate", oldEcotaxTaxRate, ecotaxTaxRate);
    }

    public boolean getDiscountQuantityApplied() {
        return discountQuantityApplied;
    }

    public void setDiscountQuantityApplied(boolean discountQuantityApplied) {
        boolean oldDiscountQuantityApplied = this.discountQuantityApplied;
        this.discountQuantityApplied = discountQuantityApplied;
        changeSupport.firePropertyChange("discountQuantityApplied", oldDiscountQuantityApplied, discountQuantityApplied);
    }

    public String getDownloadHash() {
        return downloadHash;
    }

    public void setDownloadHash(String downloadHash) {
        String oldDownloadHash = this.downloadHash;
        this.downloadHash = downloadHash;
        changeSupport.firePropertyChange("downloadHash", oldDownloadHash, downloadHash);
    }

    public Integer getDownloadNb() {
        return downloadNb;
    }

    public void setDownloadNb(Integer downloadNb) {
        Integer oldDownloadNb = this.downloadNb;
        this.downloadNb = downloadNb;
        changeSupport.firePropertyChange("downloadNb", oldDownloadNb, downloadNb);
    }

    public Date getDownloadDeadline() {
        return downloadDeadline;
    }

    public void setDownloadDeadline(Date downloadDeadline) {
        Date oldDownloadDeadline = this.downloadDeadline;
        this.downloadDeadline = downloadDeadline;
        changeSupport.firePropertyChange("downloadDeadline", oldDownloadDeadline, downloadDeadline);
    }

    public BigDecimal getTotalPriceTaxIncl() {
        return totalPriceTaxIncl;
    }

    public void setTotalPriceTaxIncl(BigDecimal totalPriceTaxIncl) {
        BigDecimal oldTotalPriceTaxIncl = this.totalPriceTaxIncl;
        this.totalPriceTaxIncl = totalPriceTaxIncl;
        changeSupport.firePropertyChange("totalPriceTaxIncl", oldTotalPriceTaxIncl, totalPriceTaxIncl);
    }

    public BigDecimal getTotalPriceTaxExcl() {
        return totalPriceTaxExcl;
    }

    public void setTotalPriceTaxExcl(BigDecimal totalPriceTaxExcl) {
        BigDecimal oldTotalPriceTaxExcl = this.totalPriceTaxExcl;
        this.totalPriceTaxExcl = totalPriceTaxExcl;
        changeSupport.firePropertyChange("totalPriceTaxExcl", oldTotalPriceTaxExcl, totalPriceTaxExcl);
    }

    public BigDecimal getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(BigDecimal unitPriceTaxIncl) {
        BigDecimal oldUnitPriceTaxIncl = this.unitPriceTaxIncl;
        this.unitPriceTaxIncl = unitPriceTaxIncl;
        changeSupport.firePropertyChange("unitPriceTaxIncl", oldUnitPriceTaxIncl, unitPriceTaxIncl);
    }

    public BigDecimal getUnitPriceTaxExcl() {
        return unitPriceTaxExcl;
    }

    public void setUnitPriceTaxExcl(BigDecimal unitPriceTaxExcl) {
        BigDecimal oldUnitPriceTaxExcl = this.unitPriceTaxExcl;
        this.unitPriceTaxExcl = unitPriceTaxExcl;
        changeSupport.firePropertyChange("unitPriceTaxExcl", oldUnitPriceTaxExcl, unitPriceTaxExcl);
    }

    public BigDecimal getTotalShippingPriceTaxIncl() {
        return totalShippingPriceTaxIncl;
    }

    public void setTotalShippingPriceTaxIncl(BigDecimal totalShippingPriceTaxIncl) {
        BigDecimal oldTotalShippingPriceTaxIncl = this.totalShippingPriceTaxIncl;
        this.totalShippingPriceTaxIncl = totalShippingPriceTaxIncl;
        changeSupport.firePropertyChange("totalShippingPriceTaxIncl", oldTotalShippingPriceTaxIncl, totalShippingPriceTaxIncl);
    }

    public BigDecimal getTotalShippingPriceTaxExcl() {
        return totalShippingPriceTaxExcl;
    }

    public void setTotalShippingPriceTaxExcl(BigDecimal totalShippingPriceTaxExcl) {
        BigDecimal oldTotalShippingPriceTaxExcl = this.totalShippingPriceTaxExcl;
        this.totalShippingPriceTaxExcl = totalShippingPriceTaxExcl;
        changeSupport.firePropertyChange("totalShippingPriceTaxExcl", oldTotalShippingPriceTaxExcl, totalShippingPriceTaxExcl);
    }

    public BigDecimal getPurchaseSupplierPrice() {
        return purchaseSupplierPrice;
    }

    public void setPurchaseSupplierPrice(BigDecimal purchaseSupplierPrice) {
        BigDecimal oldPurchaseSupplierPrice = this.purchaseSupplierPrice;
        this.purchaseSupplierPrice = purchaseSupplierPrice;
        changeSupport.firePropertyChange("purchaseSupplierPrice", oldPurchaseSupplierPrice, purchaseSupplierPrice);
    }

    public BigDecimal getOriginalProductPrice() {
        return originalProductPrice;
    }

    public void setOriginalProductPrice(BigDecimal originalProductPrice) {
        BigDecimal oldOriginalProductPrice = this.originalProductPrice;
        this.originalProductPrice = originalProductPrice;
        changeSupport.firePropertyChange("originalProductPrice", oldOriginalProductPrice, originalProductPrice);
    }

    public BigDecimal getOriginalWholesalePrice() {
        return originalWholesalePrice;
    }

    public void setOriginalWholesalePrice(BigDecimal originalWholesalePrice) {
        BigDecimal oldOriginalWholesalePrice = this.originalWholesalePrice;
        this.originalWholesalePrice = originalWholesalePrice;
        changeSupport.firePropertyChange("originalWholesalePrice", oldOriginalWholesalePrice, originalWholesalePrice);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderDetail != null ? idOrderDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderDetail)) {
            return false;
        }
        PsOrderDetail other = (PsOrderDetail) object;
        if ((this.idOrderDetail == null && other.idOrderDetail != null) || (this.idOrderDetail != null && !this.idOrderDetail.equals(other.idOrderDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderDetail[ idOrderDetail=" + idOrderDetail + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
