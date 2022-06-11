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
@Table(name = "ps_product")

public class PsProduct implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;
    @Column(name = "id_supplier")
    private Integer idSupplier;
    @Column(name = "id_manufacturer")
    private Integer idManufacturer;
    @Column(name = "id_category_default")
    private Integer idCategoryDefault;
    @Basic(optional = false)
    @Column(name = "id_shop_default")
    private int idShopDefault;
    @Basic(optional = false)
    @Column(name = "id_tax_rules_group")
    private int idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "on_sale")
    private boolean onSale;
    @Basic(optional = false)
    @Column(name = "online_only")
    private boolean onlineOnly;
    @Column(name = "ean13")
    private String ean13;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "upc")
    private String upc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "minimal_quantity")
    private int minimalQuantity;
    @Column(name = "low_stock_threshold")
    private Integer lowStockThreshold;
    @Basic(optional = false)
    @Column(name = "low_stock_alert")
    private boolean lowStockAlert;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    @Column(name = "unity")
    private String unity;
    @Basic(optional = false)
    @Column(name = "unit_price_ratio")
    private BigDecimal unitPriceRatio;
    @Basic(optional = false)
    @Column(name = "additional_shipping_cost")
    private BigDecimal additionalShippingCost;
    @Column(name = "reference")
    private String reference;
    @Column(name = "supplier_reference")
    private String supplierReference;
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "width")
    private BigDecimal width;
    @Basic(optional = false)
    @Column(name = "height")
    private BigDecimal height;
    @Basic(optional = false)
    @Column(name = "\"depth\"")
    private BigDecimal depth;
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @Column(name = "out_of_stock")
    private int outOfStock;
    @Basic(optional = false)
    @Column(name = "additional_delivery_times")
    private boolean additionalDeliveryTimes;
    @Column(name = "quantity_discount")
    private Boolean quantityDiscount;
    @Basic(optional = false)
    @Column(name = "customizable")
    private short customizable;
    @Basic(optional = false)
    @Column(name = "uploadable_files")
    private short uploadableFiles;
    @Basic(optional = false)
    @Column(name = "text_fields")
    private short textFields;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "redirect_type")
    private String redirectType;
    @Basic(optional = false)
    @Column(name = "id_type_redirected")
    private int idTypeRedirected;
    @Basic(optional = false)
    @Column(name = "available_for_order")
    private boolean availableForOrder;
    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;
    @Basic(optional = false)
    @Column(name = "show_condition")
    private boolean showCondition;
    @Basic(optional = false)
    @Column(name = "\"condition\"")
    private String condition;
    @Basic(optional = false)
    @Column(name = "show_price")
    private boolean showPrice;
    @Basic(optional = false)
    @Column(name = "indexed")
    private boolean indexed;
    @Basic(optional = false)
    @Column(name = "visibility")
    private String visibility;
    @Basic(optional = false)
    @Column(name = "cache_is_pack")
    private boolean cacheIsPack;
    @Basic(optional = false)
    @Column(name = "cache_has_attachments")
    private boolean cacheHasAttachments;
    @Basic(optional = false)
    @Column(name = "is_virtual")
    private boolean isVirtual;
    @Column(name = "cache_default_attribute")
    private Integer cacheDefaultAttribute;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "advanced_stock_management")
    private boolean advancedStockManagement;
    @Basic(optional = false)
    @Column(name = "pack_stock_type")
    private int packStockType;
    @Basic(optional = false)
    @Column(name = "\"state\"")
    private int state;

    public PsProduct() {
    }

    public PsProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public PsProduct(Integer idProduct, int idShopDefault, int idTaxRulesGroup, boolean onSale, boolean onlineOnly, BigDecimal ecotax, int quantity, int minimalQuantity, boolean lowStockAlert, BigDecimal price, BigDecimal wholesalePrice, BigDecimal unitPriceRatio, BigDecimal additionalShippingCost, BigDecimal width, BigDecimal height, BigDecimal depth, BigDecimal weight, int outOfStock, boolean additionalDeliveryTimes, short customizable, short uploadableFiles, short textFields, boolean active, String redirectType, int idTypeRedirected, boolean availableForOrder, boolean showCondition, String condition, boolean showPrice, boolean indexed, String visibility, boolean cacheIsPack, boolean cacheHasAttachments, boolean isVirtual, Date dateAdd, Date dateUpd, boolean advancedStockManagement, int packStockType, int state) {
        this.idProduct = idProduct;
        this.idShopDefault = idShopDefault;
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.onSale = onSale;
        this.onlineOnly = onlineOnly;
        this.ecotax = ecotax;
        this.quantity = quantity;
        this.minimalQuantity = minimalQuantity;
        this.lowStockAlert = lowStockAlert;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        this.unitPriceRatio = unitPriceRatio;
        this.additionalShippingCost = additionalShippingCost;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
        this.outOfStock = outOfStock;
        this.additionalDeliveryTimes = additionalDeliveryTimes;
        this.customizable = customizable;
        this.uploadableFiles = uploadableFiles;
        this.textFields = textFields;
        this.active = active;
        this.redirectType = redirectType;
        this.idTypeRedirected = idTypeRedirected;
        this.availableForOrder = availableForOrder;
        this.showCondition = showCondition;
        this.condition = condition;
        this.showPrice = showPrice;
        this.indexed = indexed;
        this.visibility = visibility;
        this.cacheIsPack = cacheIsPack;
        this.cacheHasAttachments = cacheHasAttachments;
        this.isVirtual = isVirtual;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.advancedStockManagement = advancedStockManagement;
        this.packStockType = packStockType;
        this.state = state;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        Integer oldIdProduct = this.idProduct;
        this.idProduct = idProduct;
        changeSupport.firePropertyChange("idProduct", oldIdProduct, idProduct);
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        Integer oldIdSupplier = this.idSupplier;
        this.idSupplier = idSupplier;
        changeSupport.firePropertyChange("idSupplier", oldIdSupplier, idSupplier);
    }

    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        Integer oldIdManufacturer = this.idManufacturer;
        this.idManufacturer = idManufacturer;
        changeSupport.firePropertyChange("idManufacturer", oldIdManufacturer, idManufacturer);
    }

    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        Integer oldIdCategoryDefault = this.idCategoryDefault;
        this.idCategoryDefault = idCategoryDefault;
        changeSupport.firePropertyChange("idCategoryDefault", oldIdCategoryDefault, idCategoryDefault);
    }

    public int getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(int idShopDefault) {
        int oldIdShopDefault = this.idShopDefault;
        this.idShopDefault = idShopDefault;
        changeSupport.firePropertyChange("idShopDefault", oldIdShopDefault, idShopDefault);
    }

    public int getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(int idTaxRulesGroup) {
        int oldIdTaxRulesGroup = this.idTaxRulesGroup;
        this.idTaxRulesGroup = idTaxRulesGroup;
        changeSupport.firePropertyChange("idTaxRulesGroup", oldIdTaxRulesGroup, idTaxRulesGroup);
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        boolean oldOnSale = this.onSale;
        this.onSale = onSale;
        changeSupport.firePropertyChange("onSale", oldOnSale, onSale);
    }

    public boolean getOnlineOnly() {
        return onlineOnly;
    }

    public void setOnlineOnly(boolean onlineOnly) {
        boolean oldOnlineOnly = this.onlineOnly;
        this.onlineOnly = onlineOnly;
        changeSupport.firePropertyChange("onlineOnly", oldOnlineOnly, onlineOnly);
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        String oldEan13 = this.ean13;
        this.ean13 = ean13;
        changeSupport.firePropertyChange("ean13", oldEan13, ean13);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        String oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        String oldUpc = this.upc;
        this.upc = upc;
        changeSupport.firePropertyChange("upc", oldUpc, upc);
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        BigDecimal oldEcotax = this.ecotax;
        this.ecotax = ecotax;
        changeSupport.firePropertyChange("ecotax", oldEcotax, ecotax);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(int minimalQuantity) {
        int oldMinimalQuantity = this.minimalQuantity;
        this.minimalQuantity = minimalQuantity;
        changeSupport.firePropertyChange("minimalQuantity", oldMinimalQuantity, minimalQuantity);
    }

    public Integer getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Integer lowStockThreshold) {
        Integer oldLowStockThreshold = this.lowStockThreshold;
        this.lowStockThreshold = lowStockThreshold;
        changeSupport.firePropertyChange("lowStockThreshold", oldLowStockThreshold, lowStockThreshold);
    }

    public boolean getLowStockAlert() {
        return lowStockAlert;
    }

    public void setLowStockAlert(boolean lowStockAlert) {
        boolean oldLowStockAlert = this.lowStockAlert;
        this.lowStockAlert = lowStockAlert;
        changeSupport.firePropertyChange("lowStockAlert", oldLowStockAlert, lowStockAlert);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        BigDecimal oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        BigDecimal oldWholesalePrice = this.wholesalePrice;
        this.wholesalePrice = wholesalePrice;
        changeSupport.firePropertyChange("wholesalePrice", oldWholesalePrice, wholesalePrice);
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        String oldUnity = this.unity;
        this.unity = unity;
        changeSupport.firePropertyChange("unity", oldUnity, unity);
    }

    public BigDecimal getUnitPriceRatio() {
        return unitPriceRatio;
    }

    public void setUnitPriceRatio(BigDecimal unitPriceRatio) {
        BigDecimal oldUnitPriceRatio = this.unitPriceRatio;
        this.unitPriceRatio = unitPriceRatio;
        changeSupport.firePropertyChange("unitPriceRatio", oldUnitPriceRatio, unitPriceRatio);
    }

    public BigDecimal getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(BigDecimal additionalShippingCost) {
        BigDecimal oldAdditionalShippingCost = this.additionalShippingCost;
        this.additionalShippingCost = additionalShippingCost;
        changeSupport.firePropertyChange("additionalShippingCost", oldAdditionalShippingCost, additionalShippingCost);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        String oldReference = this.reference;
        this.reference = reference;
        changeSupport.firePropertyChange("reference", oldReference, reference);
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        String oldSupplierReference = this.supplierReference;
        this.supplierReference = supplierReference;
        changeSupport.firePropertyChange("supplierReference", oldSupplierReference, supplierReference);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        BigDecimal oldWidth = this.width;
        this.width = width;
        changeSupport.firePropertyChange("width", oldWidth, width);
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        BigDecimal oldHeight = this.height;
        this.height = height;
        changeSupport.firePropertyChange("height", oldHeight, height);
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        BigDecimal oldDepth = this.depth;
        this.depth = depth;
        changeSupport.firePropertyChange("depth", oldDepth, depth);
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        BigDecimal oldWeight = this.weight;
        this.weight = weight;
        changeSupport.firePropertyChange("weight", oldWeight, weight);
    }

    public int getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(int outOfStock) {
        int oldOutOfStock = this.outOfStock;
        this.outOfStock = outOfStock;
        changeSupport.firePropertyChange("outOfStock", oldOutOfStock, outOfStock);
    }

    public boolean getAdditionalDeliveryTimes() {
        return additionalDeliveryTimes;
    }

    public void setAdditionalDeliveryTimes(boolean additionalDeliveryTimes) {
        boolean oldAdditionalDeliveryTimes = this.additionalDeliveryTimes;
        this.additionalDeliveryTimes = additionalDeliveryTimes;
        changeSupport.firePropertyChange("additionalDeliveryTimes", oldAdditionalDeliveryTimes, additionalDeliveryTimes);
    }

    public Boolean getQuantityDiscount() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(Boolean quantityDiscount) {
        Boolean oldQuantityDiscount = this.quantityDiscount;
        this.quantityDiscount = quantityDiscount;
        changeSupport.firePropertyChange("quantityDiscount", oldQuantityDiscount, quantityDiscount);
    }

    public short getCustomizable() {
        return customizable;
    }

    public void setCustomizable(short customizable) {
        short oldCustomizable = this.customizable;
        this.customizable = customizable;
        changeSupport.firePropertyChange("customizable", oldCustomizable, customizable);
    }

    public short getUploadableFiles() {
        return uploadableFiles;
    }

    public void setUploadableFiles(short uploadableFiles) {
        short oldUploadableFiles = this.uploadableFiles;
        this.uploadableFiles = uploadableFiles;
        changeSupport.firePropertyChange("uploadableFiles", oldUploadableFiles, uploadableFiles);
    }

    public short getTextFields() {
        return textFields;
    }

    public void setTextFields(short textFields) {
        short oldTextFields = this.textFields;
        this.textFields = textFields;
        changeSupport.firePropertyChange("textFields", oldTextFields, textFields);
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        boolean oldActive = this.active;
        this.active = active;
        changeSupport.firePropertyChange("active", oldActive, active);
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        String oldRedirectType = this.redirectType;
        this.redirectType = redirectType;
        changeSupport.firePropertyChange("redirectType", oldRedirectType, redirectType);
    }

    public int getIdTypeRedirected() {
        return idTypeRedirected;
    }

    public void setIdTypeRedirected(int idTypeRedirected) {
        int oldIdTypeRedirected = this.idTypeRedirected;
        this.idTypeRedirected = idTypeRedirected;
        changeSupport.firePropertyChange("idTypeRedirected", oldIdTypeRedirected, idTypeRedirected);
    }

    public boolean getAvailableForOrder() {
        return availableForOrder;
    }

    public void setAvailableForOrder(boolean availableForOrder) {
        boolean oldAvailableForOrder = this.availableForOrder;
        this.availableForOrder = availableForOrder;
        changeSupport.firePropertyChange("availableForOrder", oldAvailableForOrder, availableForOrder);
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        Date oldAvailableDate = this.availableDate;
        this.availableDate = availableDate;
        changeSupport.firePropertyChange("availableDate", oldAvailableDate, availableDate);
    }

    public boolean getShowCondition() {
        return showCondition;
    }

    public void setShowCondition(boolean showCondition) {
        boolean oldShowCondition = this.showCondition;
        this.showCondition = showCondition;
        changeSupport.firePropertyChange("showCondition", oldShowCondition, showCondition);
    }

    public String getCondition1() {
        return condition;
    }

    public void setCondition1(String condition1) {
        this.condition = condition1;
    }

    public boolean getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(boolean showPrice) {
        boolean oldShowPrice = this.showPrice;
        this.showPrice = showPrice;
        changeSupport.firePropertyChange("showPrice", oldShowPrice, showPrice);
    }

    public boolean getIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        boolean oldIndexed = this.indexed;
        this.indexed = indexed;
        changeSupport.firePropertyChange("indexed", oldIndexed, indexed);
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        String oldVisibility = this.visibility;
        this.visibility = visibility;
        changeSupport.firePropertyChange("visibility", oldVisibility, visibility);
    }

    public boolean getCacheIsPack() {
        return cacheIsPack;
    }

    public void setCacheIsPack(boolean cacheIsPack) {
        boolean oldCacheIsPack = this.cacheIsPack;
        this.cacheIsPack = cacheIsPack;
        changeSupport.firePropertyChange("cacheIsPack", oldCacheIsPack, cacheIsPack);
    }

    public boolean getCacheHasAttachments() {
        return cacheHasAttachments;
    }

    public void setCacheHasAttachments(boolean cacheHasAttachments) {
        boolean oldCacheHasAttachments = this.cacheHasAttachments;
        this.cacheHasAttachments = cacheHasAttachments;
        changeSupport.firePropertyChange("cacheHasAttachments", oldCacheHasAttachments, cacheHasAttachments);
    }

    public boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(boolean isVirtual) {
        boolean oldIsVirtual = this.isVirtual;
        this.isVirtual = isVirtual;
        changeSupport.firePropertyChange("isVirtual", oldIsVirtual, isVirtual);
    }

    public Integer getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(Integer cacheDefaultAttribute) {
        Integer oldCacheDefaultAttribute = this.cacheDefaultAttribute;
        this.cacheDefaultAttribute = cacheDefaultAttribute;
        changeSupport.firePropertyChange("cacheDefaultAttribute", oldCacheDefaultAttribute, cacheDefaultAttribute);
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        Date oldDateAdd = this.dateAdd;
        this.dateAdd = dateAdd;
        changeSupport.firePropertyChange("dateAdd", oldDateAdd, dateAdd);
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        Date oldDateUpd = this.dateUpd;
        this.dateUpd = dateUpd;
        changeSupport.firePropertyChange("dateUpd", oldDateUpd, dateUpd);
    }

    public boolean getAdvancedStockManagement() {
        return advancedStockManagement;
    }

    public void setAdvancedStockManagement(boolean advancedStockManagement) {
        boolean oldAdvancedStockManagement = this.advancedStockManagement;
        this.advancedStockManagement = advancedStockManagement;
        changeSupport.firePropertyChange("advancedStockManagement", oldAdvancedStockManagement, advancedStockManagement);
    }

    public int getPackStockType() {
        return packStockType;
    }

    public void setPackStockType(int packStockType) {
        int oldPackStockType = this.packStockType;
        this.packStockType = packStockType;
        changeSupport.firePropertyChange("packStockType", oldPackStockType, packStockType);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        int oldState = this.state;
        this.state = state;
        changeSupport.firePropertyChange("state", oldState, state);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProduct)) {
            return false;
        }
        PsProduct other = (PsProduct) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProduct[ idProduct=" + idProduct + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
