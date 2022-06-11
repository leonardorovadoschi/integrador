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
import javax.persistence.Lob;
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
@Table(name = "ps_cart_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRule.findAll", query = "SELECT p FROM PsCartRule p")
    , @NamedQuery(name = "PsCartRule.findByIdCartRule", query = "SELECT p FROM PsCartRule p WHERE p.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRule.findByIdCustomer", query = "SELECT p FROM PsCartRule p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsCartRule.findByDateFrom", query = "SELECT p FROM PsCartRule p WHERE p.dateFrom = :dateFrom")
    , @NamedQuery(name = "PsCartRule.findByDateTo", query = "SELECT p FROM PsCartRule p WHERE p.dateTo = :dateTo")
    , @NamedQuery(name = "PsCartRule.findByQuantity", query = "SELECT p FROM PsCartRule p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PsCartRule.findByQuantityPerUser", query = "SELECT p FROM PsCartRule p WHERE p.quantityPerUser = :quantityPerUser")
    , @NamedQuery(name = "PsCartRule.findByPriority", query = "SELECT p FROM PsCartRule p WHERE p.priority = :priority")
    , @NamedQuery(name = "PsCartRule.findByPartialUse", query = "SELECT p FROM PsCartRule p WHERE p.partialUse = :partialUse")
    , @NamedQuery(name = "PsCartRule.findByCode", query = "SELECT p FROM PsCartRule p WHERE p.code = :code")
    , @NamedQuery(name = "PsCartRule.findByMinimumAmount", query = "SELECT p FROM PsCartRule p WHERE p.minimumAmount = :minimumAmount")
    , @NamedQuery(name = "PsCartRule.findByMinimumAmountTax", query = "SELECT p FROM PsCartRule p WHERE p.minimumAmountTax = :minimumAmountTax")
    , @NamedQuery(name = "PsCartRule.findByMinimumAmountCurrency", query = "SELECT p FROM PsCartRule p WHERE p.minimumAmountCurrency = :minimumAmountCurrency")
    , @NamedQuery(name = "PsCartRule.findByMinimumAmountShipping", query = "SELECT p FROM PsCartRule p WHERE p.minimumAmountShipping = :minimumAmountShipping")
    , @NamedQuery(name = "PsCartRule.findByCountryRestriction", query = "SELECT p FROM PsCartRule p WHERE p.countryRestriction = :countryRestriction")
    , @NamedQuery(name = "PsCartRule.findByCarrierRestriction", query = "SELECT p FROM PsCartRule p WHERE p.carrierRestriction = :carrierRestriction")
    , @NamedQuery(name = "PsCartRule.findByGroupRestriction", query = "SELECT p FROM PsCartRule p WHERE p.groupRestriction = :groupRestriction")
    , @NamedQuery(name = "PsCartRule.findByCartRuleRestriction", query = "SELECT p FROM PsCartRule p WHERE p.cartRuleRestriction = :cartRuleRestriction")
    , @NamedQuery(name = "PsCartRule.findByProductRestriction", query = "SELECT p FROM PsCartRule p WHERE p.productRestriction = :productRestriction")
    , @NamedQuery(name = "PsCartRule.findByShopRestriction", query = "SELECT p FROM PsCartRule p WHERE p.shopRestriction = :shopRestriction")
    , @NamedQuery(name = "PsCartRule.findByFreeShipping", query = "SELECT p FROM PsCartRule p WHERE p.freeShipping = :freeShipping")
    , @NamedQuery(name = "PsCartRule.findByReductionPercent", query = "SELECT p FROM PsCartRule p WHERE p.reductionPercent = :reductionPercent")
    , @NamedQuery(name = "PsCartRule.findByReductionAmount", query = "SELECT p FROM PsCartRule p WHERE p.reductionAmount = :reductionAmount")
    , @NamedQuery(name = "PsCartRule.findByReductionTax", query = "SELECT p FROM PsCartRule p WHERE p.reductionTax = :reductionTax")
    , @NamedQuery(name = "PsCartRule.findByReductionCurrency", query = "SELECT p FROM PsCartRule p WHERE p.reductionCurrency = :reductionCurrency")
    , @NamedQuery(name = "PsCartRule.findByReductionProduct", query = "SELECT p FROM PsCartRule p WHERE p.reductionProduct = :reductionProduct")
    , @NamedQuery(name = "PsCartRule.findByReductionExcludeSpecial", query = "SELECT p FROM PsCartRule p WHERE p.reductionExcludeSpecial = :reductionExcludeSpecial")
    , @NamedQuery(name = "PsCartRule.findByGiftProduct", query = "SELECT p FROM PsCartRule p WHERE p.giftProduct = :giftProduct")
    , @NamedQuery(name = "PsCartRule.findByGiftProductAttribute", query = "SELECT p FROM PsCartRule p WHERE p.giftProductAttribute = :giftProductAttribute")
    , @NamedQuery(name = "PsCartRule.findByHighlight", query = "SELECT p FROM PsCartRule p WHERE p.highlight = :highlight")
    , @NamedQuery(name = "PsCartRule.findByActive", query = "SELECT p FROM PsCartRule p WHERE p.active = :active")
    , @NamedQuery(name = "PsCartRule.findByDateAdd", query = "SELECT p FROM PsCartRule p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCartRule.findByDateUpd", query = "SELECT p FROM PsCartRule p WHERE p.dateUpd = :dateUpd")})
public class PsCartRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private Integer idCartRule;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "date_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    @Basic(optional = false)
    @Column(name = "date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "quantity_per_user")
    private int quantityPerUser;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @Basic(optional = false)
    @Column(name = "partial_use")
    private boolean partialUse;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "minimum_amount")
    private BigDecimal minimumAmount;
    @Basic(optional = false)
    @Column(name = "minimum_amount_tax")
    private boolean minimumAmountTax;
    @Basic(optional = false)
    @Column(name = "minimum_amount_currency")
    private int minimumAmountCurrency;
    @Basic(optional = false)
    @Column(name = "minimum_amount_shipping")
    private boolean minimumAmountShipping;
    @Basic(optional = false)
    @Column(name = "country_restriction")
    private boolean countryRestriction;
    @Basic(optional = false)
    @Column(name = "carrier_restriction")
    private boolean carrierRestriction;
    @Basic(optional = false)
    @Column(name = "group_restriction")
    private boolean groupRestriction;
    @Basic(optional = false)
    @Column(name = "cart_rule_restriction")
    private boolean cartRuleRestriction;
    @Basic(optional = false)
    @Column(name = "product_restriction")
    private boolean productRestriction;
    @Basic(optional = false)
    @Column(name = "shop_restriction")
    private boolean shopRestriction;
    @Basic(optional = false)
    @Column(name = "free_shipping")
    private boolean freeShipping;
    @Basic(optional = false)
    @Column(name = "reduction_percent")
    private BigDecimal reductionPercent;
    @Basic(optional = false)
    @Column(name = "reduction_amount")
    private BigDecimal reductionAmount;
    @Basic(optional = false)
    @Column(name = "reduction_tax")
    private boolean reductionTax;
    @Basic(optional = false)
    @Column(name = "reduction_currency")
    private int reductionCurrency;
    @Basic(optional = false)
    @Column(name = "reduction_product")
    private int reductionProduct;
    @Basic(optional = false)
    @Column(name = "reduction_exclude_special")
    private boolean reductionExcludeSpecial;
    @Basic(optional = false)
    @Column(name = "gift_product")
    private int giftProduct;
    @Basic(optional = false)
    @Column(name = "gift_product_attribute")
    private int giftProductAttribute;
    @Basic(optional = false)
    @Column(name = "highlight")
    private boolean highlight;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsCartRule() {
    }

    public PsCartRule(Integer idCartRule) {
        this.idCartRule = idCartRule;
    }

    public PsCartRule(Integer idCartRule, int idCustomer, Date dateFrom, Date dateTo, int quantity, int quantityPerUser, int priority, boolean partialUse, String code, BigDecimal minimumAmount, boolean minimumAmountTax, int minimumAmountCurrency, boolean minimumAmountShipping, boolean countryRestriction, boolean carrierRestriction, boolean groupRestriction, boolean cartRuleRestriction, boolean productRestriction, boolean shopRestriction, boolean freeShipping, BigDecimal reductionPercent, BigDecimal reductionAmount, boolean reductionTax, int reductionCurrency, int reductionProduct, boolean reductionExcludeSpecial, int giftProduct, int giftProductAttribute, boolean highlight, boolean active, Date dateAdd, Date dateUpd) {
        this.idCartRule = idCartRule;
        this.idCustomer = idCustomer;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.quantity = quantity;
        this.quantityPerUser = quantityPerUser;
        this.priority = priority;
        this.partialUse = partialUse;
        this.code = code;
        this.minimumAmount = minimumAmount;
        this.minimumAmountTax = minimumAmountTax;
        this.minimumAmountCurrency = minimumAmountCurrency;
        this.minimumAmountShipping = minimumAmountShipping;
        this.countryRestriction = countryRestriction;
        this.carrierRestriction = carrierRestriction;
        this.groupRestriction = groupRestriction;
        this.cartRuleRestriction = cartRuleRestriction;
        this.productRestriction = productRestriction;
        this.shopRestriction = shopRestriction;
        this.freeShipping = freeShipping;
        this.reductionPercent = reductionPercent;
        this.reductionAmount = reductionAmount;
        this.reductionTax = reductionTax;
        this.reductionCurrency = reductionCurrency;
        this.reductionProduct = reductionProduct;
        this.reductionExcludeSpecial = reductionExcludeSpecial;
        this.giftProduct = giftProduct;
        this.giftProductAttribute = giftProductAttribute;
        this.highlight = highlight;
        this.active = active;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(Integer idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityPerUser() {
        return quantityPerUser;
    }

    public void setQuantityPerUser(int quantityPerUser) {
        this.quantityPerUser = quantityPerUser;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getPartialUse() {
        return partialUse;
    }

    public void setPartialUse(boolean partialUse) {
        this.partialUse = partialUse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public boolean getMinimumAmountTax() {
        return minimumAmountTax;
    }

    public void setMinimumAmountTax(boolean minimumAmountTax) {
        this.minimumAmountTax = minimumAmountTax;
    }

    public int getMinimumAmountCurrency() {
        return minimumAmountCurrency;
    }

    public void setMinimumAmountCurrency(int minimumAmountCurrency) {
        this.minimumAmountCurrency = minimumAmountCurrency;
    }

    public boolean getMinimumAmountShipping() {
        return minimumAmountShipping;
    }

    public void setMinimumAmountShipping(boolean minimumAmountShipping) {
        this.minimumAmountShipping = minimumAmountShipping;
    }

    public boolean getCountryRestriction() {
        return countryRestriction;
    }

    public void setCountryRestriction(boolean countryRestriction) {
        this.countryRestriction = countryRestriction;
    }

    public boolean getCarrierRestriction() {
        return carrierRestriction;
    }

    public void setCarrierRestriction(boolean carrierRestriction) {
        this.carrierRestriction = carrierRestriction;
    }

    public boolean getGroupRestriction() {
        return groupRestriction;
    }

    public void setGroupRestriction(boolean groupRestriction) {
        this.groupRestriction = groupRestriction;
    }

    public boolean getCartRuleRestriction() {
        return cartRuleRestriction;
    }

    public void setCartRuleRestriction(boolean cartRuleRestriction) {
        this.cartRuleRestriction = cartRuleRestriction;
    }

    public boolean getProductRestriction() {
        return productRestriction;
    }

    public void setProductRestriction(boolean productRestriction) {
        this.productRestriction = productRestriction;
    }

    public boolean getShopRestriction() {
        return shopRestriction;
    }

    public void setShopRestriction(boolean shopRestriction) {
        this.shopRestriction = shopRestriction;
    }

    public boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public BigDecimal getReductionPercent() {
        return reductionPercent;
    }

    public void setReductionPercent(BigDecimal reductionPercent) {
        this.reductionPercent = reductionPercent;
    }

    public BigDecimal getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(BigDecimal reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public boolean getReductionTax() {
        return reductionTax;
    }

    public void setReductionTax(boolean reductionTax) {
        this.reductionTax = reductionTax;
    }

    public int getReductionCurrency() {
        return reductionCurrency;
    }

    public void setReductionCurrency(int reductionCurrency) {
        this.reductionCurrency = reductionCurrency;
    }

    public int getReductionProduct() {
        return reductionProduct;
    }

    public void setReductionProduct(int reductionProduct) {
        this.reductionProduct = reductionProduct;
    }

    public boolean getReductionExcludeSpecial() {
        return reductionExcludeSpecial;
    }

    public void setReductionExcludeSpecial(boolean reductionExcludeSpecial) {
        this.reductionExcludeSpecial = reductionExcludeSpecial;
    }

    public int getGiftProduct() {
        return giftProduct;
    }

    public void setGiftProduct(int giftProduct) {
        this.giftProduct = giftProduct;
    }

    public int getGiftProductAttribute() {
        return giftProductAttribute;
    }

    public void setGiftProductAttribute(int giftProductAttribute) {
        this.giftProductAttribute = giftProductAttribute;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartRule != null ? idCartRule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRule)) {
            return false;
        }
        PsCartRule other = (PsCartRule) object;
        if ((this.idCartRule == null && other.idCartRule != null) || (this.idCartRule != null && !this.idCartRule.equals(other.idCartRule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRule[ idCartRule=" + idCartRule + " ]";
    }
    
}
