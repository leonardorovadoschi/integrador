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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fazenda
 */
@Entity
@Table(name = "ps_custom_payment_method")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomPaymentMethod.findAll", query = "SELECT p FROM PsCustomPaymentMethod p"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByIdCustomPaymentMethod", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.idCustomPaymentMethod = :idCustomPaymentMethod"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByLogo", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.logo = :logo"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByIdOrderState", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.idOrderState = :idOrderState"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByTypeCommission", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.typeCommission = :typeCommission"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByConfirmationPage", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.confirmationPage = :confirmationPage"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByConfirmationPageAdd", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.confirmationPageAdd = :confirmationPageAdd"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByActive", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.active = :active"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCommissionAmount", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.commissionAmount = :commissionAmount"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCurrencyCommission", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.currencyCommission = :currencyCommission"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCommissionPercent", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.commissionPercent = :commissionPercent"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByApplyCommission", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.applyCommission = :applyCommission"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByTypeDiscount", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.typeDiscount = :typeDiscount"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByDiscountAmount", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.discountAmount = :discountAmount"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCurrencyDiscount", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.currencyDiscount = :currencyDiscount"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByDiscountPercent", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.discountPercent = :discountPercent"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByApplyDiscount", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.applyDiscount = :applyDiscount"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByViewMessageField", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.viewMessageField = :viewMessageField"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByRequiredMessageField", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.requiredMessageField = :requiredMessageField"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByIsSendMail", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.isSendMail = :isSendMail"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCommissionUseTaxOnProducts", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.commissionUseTaxOnProducts = :commissionUseTaxOnProducts"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByDiscountUseTaxOnProducts", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.discountUseTaxOnProducts = :discountUseTaxOnProducts"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCartTotalFrom", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.cartTotalFrom = :cartTotalFrom"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCartTotalTo", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.cartTotalTo = :cartTotalTo"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCommissionTax", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.commissionTax = :commissionTax"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByDiscountTax", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.discountTax = :discountTax"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByPosition", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.position = :position"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByIdCms", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.idCms = :idCms"),
    @NamedQuery(name = "PsCustomPaymentMethod.findByCommissionSwitch", query = "SELECT p FROM PsCustomPaymentMethod p WHERE p.commissionSwitch = :commissionSwitch")})
public class PsCustomPaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_custom_payment_method")
    private Integer idCustomPaymentMethod;
    @Basic(optional = false)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @Column(name = "id_order_state")
    private int idOrderState;
    @Basic(optional = false)
    @Column(name = "type_commission")
    private int typeCommission;
    @Basic(optional = false)
    @Column(name = "confirmation_page")
    private short confirmationPage;
    @Basic(optional = false)
    @Column(name = "confirmation_page_add")
    private short confirmationPageAdd;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "commission_amount")
    private double commissionAmount;
    @Basic(optional = false)
    @Column(name = "currency_commission")
    private int currencyCommission;
    @Basic(optional = false)
    @Column(name = "commission_percent")
    private double commissionPercent;
    @Basic(optional = false)
    @Column(name = "apply_commission")
    private int applyCommission;
    @Basic(optional = false)
    @Column(name = "type_discount")
    private int typeDiscount;
    @Basic(optional = false)
    @Column(name = "discount_amount")
    private double discountAmount;
    @Basic(optional = false)
    @Column(name = "currency_discount")
    private int currencyDiscount;
    @Basic(optional = false)
    @Column(name = "discount_percent")
    private double discountPercent;
    @Basic(optional = false)
    @Column(name = "apply_discount")
    private int applyDiscount;
    @Basic(optional = false)
    @Lob
    @Column(name = "available_groups")
    private String availableGroups;
    @Basic(optional = false)
    @Lob
    @Column(name = "available_carriers")
    private String availableCarriers;
    @Basic(optional = false)
    @Lob
    @Column(name = "available_currencies")
    private String availableCurrencies;
    @Basic(optional = false)
    @Lob
    @Column(name = "available_countries")
    private String availableCountries;
    @Basic(optional = false)
    @Column(name = "view_message_field")
    private short viewMessageField;
    @Basic(optional = false)
    @Column(name = "required_message_field")
    private short requiredMessageField;
    @Basic(optional = false)
    @Column(name = "is_send_mail")
    private short isSendMail;
    @Basic(optional = false)
    @Column(name = "commission_use_tax_on_products")
    private short commissionUseTaxOnProducts;
    @Basic(optional = false)
    @Column(name = "discount_use_tax_on_products")
    private short discountUseTaxOnProducts;
    @Basic(optional = false)
    @Column(name = "cart_total_from")
    private double cartTotalFrom;
    @Basic(optional = false)
    @Column(name = "cart_total_to")
    private double cartTotalTo;
    @Basic(optional = false)
    @Column(name = "commission_tax")
    private double commissionTax;
    @Basic(optional = false)
    @Column(name = "discount_tax")
    private double discountTax;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "id_cms")
    private int idCms;
    @Basic(optional = false)
    @Column(name = "commission_switch")
    private int commissionSwitch;

    public PsCustomPaymentMethod() {
    }

    public PsCustomPaymentMethod(Integer idCustomPaymentMethod) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
    }

    public PsCustomPaymentMethod(Integer idCustomPaymentMethod, String logo, int idOrderState, int typeCommission, short confirmationPage, short confirmationPageAdd, short active, double commissionAmount, int currencyCommission, double commissionPercent, int applyCommission, int typeDiscount, double discountAmount, int currencyDiscount, double discountPercent, int applyDiscount, String availableGroups, String availableCarriers, String availableCurrencies, String availableCountries, short viewMessageField, short requiredMessageField, short isSendMail, short commissionUseTaxOnProducts, short discountUseTaxOnProducts, double cartTotalFrom, double cartTotalTo, double commissionTax, double discountTax, int position, int idCms, int commissionSwitch) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
        this.logo = logo;
        this.idOrderState = idOrderState;
        this.typeCommission = typeCommission;
        this.confirmationPage = confirmationPage;
        this.confirmationPageAdd = confirmationPageAdd;
        this.active = active;
        this.commissionAmount = commissionAmount;
        this.currencyCommission = currencyCommission;
        this.commissionPercent = commissionPercent;
        this.applyCommission = applyCommission;
        this.typeDiscount = typeDiscount;
        this.discountAmount = discountAmount;
        this.currencyDiscount = currencyDiscount;
        this.discountPercent = discountPercent;
        this.applyDiscount = applyDiscount;
        this.availableGroups = availableGroups;
        this.availableCarriers = availableCarriers;
        this.availableCurrencies = availableCurrencies;
        this.availableCountries = availableCountries;
        this.viewMessageField = viewMessageField;
        this.requiredMessageField = requiredMessageField;
        this.isSendMail = isSendMail;
        this.commissionUseTaxOnProducts = commissionUseTaxOnProducts;
        this.discountUseTaxOnProducts = discountUseTaxOnProducts;
        this.cartTotalFrom = cartTotalFrom;
        this.cartTotalTo = cartTotalTo;
        this.commissionTax = commissionTax;
        this.discountTax = discountTax;
        this.position = position;
        this.idCms = idCms;
        this.commissionSwitch = commissionSwitch;
    }

    public Integer getIdCustomPaymentMethod() {
        return idCustomPaymentMethod;
    }

    public void setIdCustomPaymentMethod(Integer idCustomPaymentMethod) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(int idOrderState) {
        this.idOrderState = idOrderState;
    }

    public int getTypeCommission() {
        return typeCommission;
    }

    public void setTypeCommission(int typeCommission) {
        this.typeCommission = typeCommission;
    }

    public short getConfirmationPage() {
        return confirmationPage;
    }

    public void setConfirmationPage(short confirmationPage) {
        this.confirmationPage = confirmationPage;
    }

    public short getConfirmationPageAdd() {
        return confirmationPageAdd;
    }

    public void setConfirmationPageAdd(short confirmationPageAdd) {
        this.confirmationPageAdd = confirmationPageAdd;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public int getCurrencyCommission() {
        return currencyCommission;
    }

    public void setCurrencyCommission(int currencyCommission) {
        this.currencyCommission = currencyCommission;
    }

    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public int getApplyCommission() {
        return applyCommission;
    }

    public void setApplyCommission(int applyCommission) {
        this.applyCommission = applyCommission;
    }

    public int getTypeDiscount() {
        return typeDiscount;
    }

    public void setTypeDiscount(int typeDiscount) {
        this.typeDiscount = typeDiscount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getCurrencyDiscount() {
        return currencyDiscount;
    }

    public void setCurrencyDiscount(int currencyDiscount) {
        this.currencyDiscount = currencyDiscount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(int applyDiscount) {
        this.applyDiscount = applyDiscount;
    }

    public String getAvailableGroups() {
        return availableGroups;
    }

    public void setAvailableGroups(String availableGroups) {
        this.availableGroups = availableGroups;
    }

    public String getAvailableCarriers() {
        return availableCarriers;
    }

    public void setAvailableCarriers(String availableCarriers) {
        this.availableCarriers = availableCarriers;
    }

    public String getAvailableCurrencies() {
        return availableCurrencies;
    }

    public void setAvailableCurrencies(String availableCurrencies) {
        this.availableCurrencies = availableCurrencies;
    }

    public String getAvailableCountries() {
        return availableCountries;
    }

    public void setAvailableCountries(String availableCountries) {
        this.availableCountries = availableCountries;
    }

    public short getViewMessageField() {
        return viewMessageField;
    }

    public void setViewMessageField(short viewMessageField) {
        this.viewMessageField = viewMessageField;
    }

    public short getRequiredMessageField() {
        return requiredMessageField;
    }

    public void setRequiredMessageField(short requiredMessageField) {
        this.requiredMessageField = requiredMessageField;
    }

    public short getIsSendMail() {
        return isSendMail;
    }

    public void setIsSendMail(short isSendMail) {
        this.isSendMail = isSendMail;
    }

    public short getCommissionUseTaxOnProducts() {
        return commissionUseTaxOnProducts;
    }

    public void setCommissionUseTaxOnProducts(short commissionUseTaxOnProducts) {
        this.commissionUseTaxOnProducts = commissionUseTaxOnProducts;
    }

    public short getDiscountUseTaxOnProducts() {
        return discountUseTaxOnProducts;
    }

    public void setDiscountUseTaxOnProducts(short discountUseTaxOnProducts) {
        this.discountUseTaxOnProducts = discountUseTaxOnProducts;
    }

    public double getCartTotalFrom() {
        return cartTotalFrom;
    }

    public void setCartTotalFrom(double cartTotalFrom) {
        this.cartTotalFrom = cartTotalFrom;
    }

    public double getCartTotalTo() {
        return cartTotalTo;
    }

    public void setCartTotalTo(double cartTotalTo) {
        this.cartTotalTo = cartTotalTo;
    }

    public double getCommissionTax() {
        return commissionTax;
    }

    public void setCommissionTax(double commissionTax) {
        this.commissionTax = commissionTax;
    }

    public double getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(double discountTax) {
        this.discountTax = discountTax;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getIdCms() {
        return idCms;
    }

    public void setIdCms(int idCms) {
        this.idCms = idCms;
    }

    public int getCommissionSwitch() {
        return commissionSwitch;
    }

    public void setCommissionSwitch(int commissionSwitch) {
        this.commissionSwitch = commissionSwitch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomPaymentMethod != null ? idCustomPaymentMethod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomPaymentMethod)) {
            return false;
        }
        PsCustomPaymentMethod other = (PsCustomPaymentMethod) object;
        if ((this.idCustomPaymentMethod == null && other.idCustomPaymentMethod != null) || (this.idCustomPaymentMethod != null && !this.idCustomPaymentMethod.equals(other.idCustomPaymentMethod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomPaymentMethod[ idCustomPaymentMethod=" + idCustomPaymentMethod + " ]";
    }
    
}
