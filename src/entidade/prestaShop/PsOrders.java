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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_orders")

public class PsOrders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_address_delivery")
    private int idAddressDelivery;
    @Basic(optional = false)
    @Column(name = "id_address_invoice")
    private int idAddressInvoice;
    @Basic(optional = false)
    @Column(name = "current_state")
    private int currentState;
    @Basic(optional = false)
    @Column(name = "secure_key")
    private String secureKey;
    @Basic(optional = false)
    @Column(name = "payment")
    private String payment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;
    @Column(name = "module")
    private String module;
    @Basic(optional = false)
    @Column(name = "recyclable")
    private boolean recyclable;
    @Basic(optional = false)
    @Column(name = "gift")
    private boolean gift;
    @Lob
    @Column(name = "gift_message")
    private String giftMessage;
    @Basic(optional = false)
    @Column(name = "mobile_theme")
    private boolean mobileTheme;
    @Column(name = "shipping_number")
    private String shippingNumber;
    @Basic(optional = false)
    @Column(name = "total_discounts")
    private BigDecimal totalDiscounts;
    @Basic(optional = false)
    @Column(name = "total_discounts_tax_incl")
    private BigDecimal totalDiscountsTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_discounts_tax_excl")
    private BigDecimal totalDiscountsTaxExcl;
    @Basic(optional = false)
    @Column(name = "total_paid")
    private BigDecimal totalPaid;
    @Basic(optional = false)
    @Column(name = "total_paid_tax_incl")
    private BigDecimal totalPaidTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_paid_tax_excl")
    private BigDecimal totalPaidTaxExcl;
    @Basic(optional = false)
    @Column(name = "total_paid_real")
    private BigDecimal totalPaidReal;
    @Basic(optional = false)
    @Column(name = "total_products")
    private BigDecimal totalProducts;
    @Basic(optional = false)
    @Column(name = "total_products_wt")
    private BigDecimal totalProductsWt;
    @Basic(optional = false)
    @Column(name = "total_shipping")
    private BigDecimal totalShipping;
    @Basic(optional = false)
    @Column(name = "total_shipping_tax_incl")
    private BigDecimal totalShippingTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_shipping_tax_excl")
    private BigDecimal totalShippingTaxExcl;
    @Basic(optional = false)
    @Column(name = "carrier_tax_rate")
    private BigDecimal carrierTaxRate;
    @Basic(optional = false)
    @Column(name = "total_wrapping")
    private BigDecimal totalWrapping;
    @Basic(optional = false)
    @Column(name = "total_wrapping_tax_incl")
    private BigDecimal totalWrappingTaxIncl;
    @Basic(optional = false)
    @Column(name = "total_wrapping_tax_excl")
    private BigDecimal totalWrappingTaxExcl;
    @Basic(optional = false)
    @Column(name = "round_mode")
    private boolean roundMode;
    @Basic(optional = false)
    @Column(name = "round_type")
    private boolean roundType;
    @Basic(optional = false)
    @Column(name = "invoice_number")
    private int invoiceNumber;
    @Basic(optional = false)
    @Column(name = "delivery_number")
    private int deliveryNumber;
    @Basic(optional = false)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Basic(optional = false)
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Basic(optional = false)
    @Column(name = "valid")
    private int valid;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsOrders() {
    }

    public PsOrders(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public PsOrders(Integer idOrder, int idShopGroup, int idShop, int idCarrier, int idLang, int idCustomer, int idCart, int idCurrency, int idAddressDelivery, int idAddressInvoice, int currentState, String secureKey, String payment, BigDecimal conversionRate, boolean recyclable, boolean gift, boolean mobileTheme, BigDecimal totalDiscounts, BigDecimal totalDiscountsTaxIncl, BigDecimal totalDiscountsTaxExcl, BigDecimal totalPaid, BigDecimal totalPaidTaxIncl, BigDecimal totalPaidTaxExcl, BigDecimal totalPaidReal, BigDecimal totalProducts, BigDecimal totalProductsWt, BigDecimal totalShipping, BigDecimal totalShippingTaxIncl, BigDecimal totalShippingTaxExcl, BigDecimal carrierTaxRate, BigDecimal totalWrapping, BigDecimal totalWrappingTaxIncl, BigDecimal totalWrappingTaxExcl, boolean roundMode, boolean roundType, int invoiceNumber, int deliveryNumber, Date invoiceDate, Date deliveryDate, int valid, Date dateAdd, Date dateUpd) {
        this.idOrder = idOrder;
        this.idShopGroup = idShopGroup;
        this.idShop = idShop;
        this.idCarrier = idCarrier;
        this.idLang = idLang;
        this.idCustomer = idCustomer;
        this.idCart = idCart;
        this.idCurrency = idCurrency;
        this.idAddressDelivery = idAddressDelivery;
        this.idAddressInvoice = idAddressInvoice;
        this.currentState = currentState;
        this.secureKey = secureKey;
        this.payment = payment;
        this.conversionRate = conversionRate;
        this.recyclable = recyclable;
        this.gift = gift;
        this.mobileTheme = mobileTheme;
        this.totalDiscounts = totalDiscounts;
        this.totalDiscountsTaxIncl = totalDiscountsTaxIncl;
        this.totalDiscountsTaxExcl = totalDiscountsTaxExcl;
        this.totalPaid = totalPaid;
        this.totalPaidTaxIncl = totalPaidTaxIncl;
        this.totalPaidTaxExcl = totalPaidTaxExcl;
        this.totalPaidReal = totalPaidReal;
        this.totalProducts = totalProducts;
        this.totalProductsWt = totalProductsWt;
        this.totalShipping = totalShipping;
        this.totalShippingTaxIncl = totalShippingTaxIncl;
        this.totalShippingTaxExcl = totalShippingTaxExcl;
        this.carrierTaxRate = carrierTaxRate;
        this.totalWrapping = totalWrapping;
        this.totalWrappingTaxIncl = totalWrappingTaxIncl;
        this.totalWrappingTaxExcl = totalWrappingTaxExcl;
        this.roundMode = roundMode;
        this.roundType = roundType;
        this.invoiceNumber = invoiceNumber;
        this.deliveryNumber = deliveryNumber;
        this.invoiceDate = invoiceDate;
        this.deliveryDate = deliveryDate;
        this.valid = valid;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        Integer oldIdOrder = this.idOrder;
        this.idOrder = idOrder;
        changeSupport.firePropertyChange("idOrder", oldIdOrder, idOrder);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        String oldReference = this.reference;
        this.reference = reference;
        changeSupport.firePropertyChange("reference", oldReference, reference);
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        int oldIdShopGroup = this.idShopGroup;
        this.idShopGroup = idShopGroup;
        changeSupport.firePropertyChange("idShopGroup", oldIdShopGroup, idShopGroup);
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        int oldIdShop = this.idShop;
        this.idShop = idShop;
        changeSupport.firePropertyChange("idShop", oldIdShop, idShop);
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        int oldIdCarrier = this.idCarrier;
        this.idCarrier = idCarrier;
        changeSupport.firePropertyChange("idCarrier", oldIdCarrier, idCarrier);
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        int oldIdLang = this.idLang;
        this.idLang = idLang;
        changeSupport.firePropertyChange("idLang", oldIdLang, idLang);
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        int oldIdCustomer = this.idCustomer;
        this.idCustomer = idCustomer;
        changeSupport.firePropertyChange("idCustomer", oldIdCustomer, idCustomer);
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        int oldIdCart = this.idCart;
        this.idCart = idCart;
        changeSupport.firePropertyChange("idCart", oldIdCart, idCart);
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        int oldIdCurrency = this.idCurrency;
        this.idCurrency = idCurrency;
        changeSupport.firePropertyChange("idCurrency", oldIdCurrency, idCurrency);
    }

    public int getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(int idAddressDelivery) {
        int oldIdAddressDelivery = this.idAddressDelivery;
        this.idAddressDelivery = idAddressDelivery;
        changeSupport.firePropertyChange("idAddressDelivery", oldIdAddressDelivery, idAddressDelivery);
    }

    public int getIdAddressInvoice() {
        return idAddressInvoice;
    }

    public void setIdAddressInvoice(int idAddressInvoice) {
        int oldIdAddressInvoice = this.idAddressInvoice;
        this.idAddressInvoice = idAddressInvoice;
        changeSupport.firePropertyChange("idAddressInvoice", oldIdAddressInvoice, idAddressInvoice);
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        int oldCurrentState = this.currentState;
        this.currentState = currentState;
        changeSupport.firePropertyChange("currentState", oldCurrentState, currentState);
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        String oldSecureKey = this.secureKey;
        this.secureKey = secureKey;
        changeSupport.firePropertyChange("secureKey", oldSecureKey, secureKey);
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        String oldPayment = this.payment;
        this.payment = payment;
        changeSupport.firePropertyChange("payment", oldPayment, payment);
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        BigDecimal oldConversionRate = this.conversionRate;
        this.conversionRate = conversionRate;
        changeSupport.firePropertyChange("conversionRate", oldConversionRate, conversionRate);
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        String oldModule = this.module;
        this.module = module;
        changeSupport.firePropertyChange("module", oldModule, module);
    }

    public boolean getRecyclable() {
        return recyclable;
    }

    public void setRecyclable(boolean recyclable) {
        boolean oldRecyclable = this.recyclable;
        this.recyclable = recyclable;
        changeSupport.firePropertyChange("recyclable", oldRecyclable, recyclable);
    }

    public boolean getGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        boolean oldGift = this.gift;
        this.gift = gift;
        changeSupport.firePropertyChange("gift", oldGift, gift);
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        String oldGiftMessage = this.giftMessage;
        this.giftMessage = giftMessage;
        changeSupport.firePropertyChange("giftMessage", oldGiftMessage, giftMessage);
    }

    public boolean getMobileTheme() {
        return mobileTheme;
    }

    public void setMobileTheme(boolean mobileTheme) {
        boolean oldMobileTheme = this.mobileTheme;
        this.mobileTheme = mobileTheme;
        changeSupport.firePropertyChange("mobileTheme", oldMobileTheme, mobileTheme);
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        String oldShippingNumber = this.shippingNumber;
        this.shippingNumber = shippingNumber;
        changeSupport.firePropertyChange("shippingNumber", oldShippingNumber, shippingNumber);
    }

    public BigDecimal getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setTotalDiscounts(BigDecimal totalDiscounts) {
        BigDecimal oldTotalDiscounts = this.totalDiscounts;
        this.totalDiscounts = totalDiscounts;
        changeSupport.firePropertyChange("totalDiscounts", oldTotalDiscounts, totalDiscounts);
    }

    public BigDecimal getTotalDiscountsTaxIncl() {
        return totalDiscountsTaxIncl;
    }

    public void setTotalDiscountsTaxIncl(BigDecimal totalDiscountsTaxIncl) {
        BigDecimal oldTotalDiscountsTaxIncl = this.totalDiscountsTaxIncl;
        this.totalDiscountsTaxIncl = totalDiscountsTaxIncl;
        changeSupport.firePropertyChange("totalDiscountsTaxIncl", oldTotalDiscountsTaxIncl, totalDiscountsTaxIncl);
    }

    public BigDecimal getTotalDiscountsTaxExcl() {
        return totalDiscountsTaxExcl;
    }

    public void setTotalDiscountsTaxExcl(BigDecimal totalDiscountsTaxExcl) {
        BigDecimal oldTotalDiscountsTaxExcl = this.totalDiscountsTaxExcl;
        this.totalDiscountsTaxExcl = totalDiscountsTaxExcl;
        changeSupport.firePropertyChange("totalDiscountsTaxExcl", oldTotalDiscountsTaxExcl, totalDiscountsTaxExcl);
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        BigDecimal oldTotalPaid = this.totalPaid;
        this.totalPaid = totalPaid;
        changeSupport.firePropertyChange("totalPaid", oldTotalPaid, totalPaid);
    }

    public BigDecimal getTotalPaidTaxIncl() {
        return totalPaidTaxIncl;
    }

    public void setTotalPaidTaxIncl(BigDecimal totalPaidTaxIncl) {
        BigDecimal oldTotalPaidTaxIncl = this.totalPaidTaxIncl;
        this.totalPaidTaxIncl = totalPaidTaxIncl;
        changeSupport.firePropertyChange("totalPaidTaxIncl", oldTotalPaidTaxIncl, totalPaidTaxIncl);
    }

    public BigDecimal getTotalPaidTaxExcl() {
        return totalPaidTaxExcl;
    }

    public void setTotalPaidTaxExcl(BigDecimal totalPaidTaxExcl) {
        BigDecimal oldTotalPaidTaxExcl = this.totalPaidTaxExcl;
        this.totalPaidTaxExcl = totalPaidTaxExcl;
        changeSupport.firePropertyChange("totalPaidTaxExcl", oldTotalPaidTaxExcl, totalPaidTaxExcl);
    }

    public BigDecimal getTotalPaidReal() {
        return totalPaidReal;
    }

    public void setTotalPaidReal(BigDecimal totalPaidReal) {
        BigDecimal oldTotalPaidReal = this.totalPaidReal;
        this.totalPaidReal = totalPaidReal;
        changeSupport.firePropertyChange("totalPaidReal", oldTotalPaidReal, totalPaidReal);
    }

    public BigDecimal getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(BigDecimal totalProducts) {
        BigDecimal oldTotalProducts = this.totalProducts;
        this.totalProducts = totalProducts;
        changeSupport.firePropertyChange("totalProducts", oldTotalProducts, totalProducts);
    }

    public BigDecimal getTotalProductsWt() {
        return totalProductsWt;
    }

    public void setTotalProductsWt(BigDecimal totalProductsWt) {
        BigDecimal oldTotalProductsWt = this.totalProductsWt;
        this.totalProductsWt = totalProductsWt;
        changeSupport.firePropertyChange("totalProductsWt", oldTotalProductsWt, totalProductsWt);
    }

    public BigDecimal getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(BigDecimal totalShipping) {
        BigDecimal oldTotalShipping = this.totalShipping;
        this.totalShipping = totalShipping;
        changeSupport.firePropertyChange("totalShipping", oldTotalShipping, totalShipping);
    }

    public BigDecimal getTotalShippingTaxIncl() {
        return totalShippingTaxIncl;
    }

    public void setTotalShippingTaxIncl(BigDecimal totalShippingTaxIncl) {
        BigDecimal oldTotalShippingTaxIncl = this.totalShippingTaxIncl;
        this.totalShippingTaxIncl = totalShippingTaxIncl;
        changeSupport.firePropertyChange("totalShippingTaxIncl", oldTotalShippingTaxIncl, totalShippingTaxIncl);
    }

    public BigDecimal getTotalShippingTaxExcl() {
        return totalShippingTaxExcl;
    }

    public void setTotalShippingTaxExcl(BigDecimal totalShippingTaxExcl) {
        BigDecimal oldTotalShippingTaxExcl = this.totalShippingTaxExcl;
        this.totalShippingTaxExcl = totalShippingTaxExcl;
        changeSupport.firePropertyChange("totalShippingTaxExcl", oldTotalShippingTaxExcl, totalShippingTaxExcl);
    }

    public BigDecimal getCarrierTaxRate() {
        return carrierTaxRate;
    }

    public void setCarrierTaxRate(BigDecimal carrierTaxRate) {
        BigDecimal oldCarrierTaxRate = this.carrierTaxRate;
        this.carrierTaxRate = carrierTaxRate;
        changeSupport.firePropertyChange("carrierTaxRate", oldCarrierTaxRate, carrierTaxRate);
    }

    public BigDecimal getTotalWrapping() {
        return totalWrapping;
    }

    public void setTotalWrapping(BigDecimal totalWrapping) {
        BigDecimal oldTotalWrapping = this.totalWrapping;
        this.totalWrapping = totalWrapping;
        changeSupport.firePropertyChange("totalWrapping", oldTotalWrapping, totalWrapping);
    }

    public BigDecimal getTotalWrappingTaxIncl() {
        return totalWrappingTaxIncl;
    }

    public void setTotalWrappingTaxIncl(BigDecimal totalWrappingTaxIncl) {
        BigDecimal oldTotalWrappingTaxIncl = this.totalWrappingTaxIncl;
        this.totalWrappingTaxIncl = totalWrappingTaxIncl;
        changeSupport.firePropertyChange("totalWrappingTaxIncl", oldTotalWrappingTaxIncl, totalWrappingTaxIncl);
    }

    public BigDecimal getTotalWrappingTaxExcl() {
        return totalWrappingTaxExcl;
    }

    public void setTotalWrappingTaxExcl(BigDecimal totalWrappingTaxExcl) {
        BigDecimal oldTotalWrappingTaxExcl = this.totalWrappingTaxExcl;
        this.totalWrappingTaxExcl = totalWrappingTaxExcl;
        changeSupport.firePropertyChange("totalWrappingTaxExcl", oldTotalWrappingTaxExcl, totalWrappingTaxExcl);
    }

    public boolean getRoundMode() {
        return roundMode;
    }

    public void setRoundMode(boolean roundMode) {
        boolean oldRoundMode = this.roundMode;
        this.roundMode = roundMode;
        changeSupport.firePropertyChange("roundMode", oldRoundMode, roundMode);
    }

    public boolean getRoundType() {
        return roundType;
    }

    public void setRoundType(boolean roundType) {
        boolean oldRoundType = this.roundType;
        this.roundType = roundType;
        changeSupport.firePropertyChange("roundType", oldRoundType, roundType);
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        int oldInvoiceNumber = this.invoiceNumber;
        this.invoiceNumber = invoiceNumber;
        changeSupport.firePropertyChange("invoiceNumber", oldInvoiceNumber, invoiceNumber);
    }

    public int getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(int deliveryNumber) {
        int oldDeliveryNumber = this.deliveryNumber;
        this.deliveryNumber = deliveryNumber;
        changeSupport.firePropertyChange("deliveryNumber", oldDeliveryNumber, deliveryNumber);
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        Date oldInvoiceDate = this.invoiceDate;
        this.invoiceDate = invoiceDate;
        changeSupport.firePropertyChange("invoiceDate", oldInvoiceDate, invoiceDate);
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        Date oldDeliveryDate = this.deliveryDate;
        this.deliveryDate = deliveryDate;
        changeSupport.firePropertyChange("deliveryDate", oldDeliveryDate, deliveryDate);
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        int oldValid = this.valid;
        this.valid = valid;
        changeSupport.firePropertyChange("valid", oldValid, valid);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrders)) {
            return false;
        }
        PsOrders other = (PsOrders) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrders[ idOrder=" + idOrder + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
