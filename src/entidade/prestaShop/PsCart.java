/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
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

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_cart")

public class PsCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cart")
    private Integer idCart;
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
    @Lob
    @Column(name = "delivery_option")
    private String deliveryOption;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_address_delivery")
    private int idAddressDelivery;
    @Basic(optional = false)
    @Column(name = "id_address_invoice")
    private int idAddressInvoice;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_guest")
    private int idGuest;
    @Basic(optional = false)
    @Column(name = "secure_key")
    private String secureKey;
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
    @Basic(optional = false)
    @Column(name = "allow_seperated_package")
    private boolean allowSeperatedPackage;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Lob
    @Column(name = "checkout_session_data")
    private String checkoutSessionData;

    public PsCart() {
    }

    public PsCart(Integer idCart) {
        this.idCart = idCart;
    }

    public PsCart(Integer idCart, int idShopGroup, int idShop, int idCarrier, String deliveryOption, int idLang, int idAddressDelivery, int idAddressInvoice, int idCurrency, int idCustomer, int idGuest, String secureKey, boolean recyclable, boolean gift, boolean mobileTheme, boolean allowSeperatedPackage, Date dateAdd, Date dateUpd) {
        this.idCart = idCart;
        this.idShopGroup = idShopGroup;
        this.idShop = idShop;
        this.idCarrier = idCarrier;
        this.deliveryOption = deliveryOption;
        this.idLang = idLang;
        this.idAddressDelivery = idAddressDelivery;
        this.idAddressInvoice = idAddressInvoice;
        this.idCurrency = idCurrency;
        this.idCustomer = idCustomer;
        this.idGuest = idGuest;
        this.secureKey = secureKey;
        this.recyclable = recyclable;
        this.gift = gift;
        this.mobileTheme = mobileTheme;
        this.allowSeperatedPackage = allowSeperatedPackage;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(int idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public int getIdAddressInvoice() {
        return idAddressInvoice;
    }

    public void setIdAddressInvoice(int idAddressInvoice) {
        this.idAddressInvoice = idAddressInvoice;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public boolean getRecyclable() {
        return recyclable;
    }

    public void setRecyclable(boolean recyclable) {
        this.recyclable = recyclable;
    }

    public boolean getGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }

    public boolean getMobileTheme() {
        return mobileTheme;
    }

    public void setMobileTheme(boolean mobileTheme) {
        this.mobileTheme = mobileTheme;
    }

    public boolean getAllowSeperatedPackage() {
        return allowSeperatedPackage;
    }

    public void setAllowSeperatedPackage(boolean allowSeperatedPackage) {
        this.allowSeperatedPackage = allowSeperatedPackage;
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

    public String getCheckoutSessionData() {
        return checkoutSessionData;
    }

    public void setCheckoutSessionData(String checkoutSessionData) {
        this.checkoutSessionData = checkoutSessionData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCart != null ? idCart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCart)) {
            return false;
        }
        PsCart other = (PsCart) object;
        if ((this.idCart == null && other.idCart != null) || (this.idCart != null && !this.idCart.equals(other.idCart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCart[ idCart=" + idCart + " ]";
    }
    
}
