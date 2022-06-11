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
@Table(name = "ps_order_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderPayment.findAll", query = "SELECT p FROM PsOrderPayment p")
    , @NamedQuery(name = "PsOrderPayment.findByIdOrderPayment", query = "SELECT p FROM PsOrderPayment p WHERE p.idOrderPayment = :idOrderPayment")
    , @NamedQuery(name = "PsOrderPayment.findByOrderReference", query = "SELECT p FROM PsOrderPayment p WHERE p.orderReference = :orderReference")
    , @NamedQuery(name = "PsOrderPayment.findByIdCurrency", query = "SELECT p FROM PsOrderPayment p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsOrderPayment.findByAmount", query = "SELECT p FROM PsOrderPayment p WHERE p.amount = :amount")
    , @NamedQuery(name = "PsOrderPayment.findByPaymentMethod", query = "SELECT p FROM PsOrderPayment p WHERE p.paymentMethod = :paymentMethod")
    , @NamedQuery(name = "PsOrderPayment.findByConversionRate", query = "SELECT p FROM PsOrderPayment p WHERE p.conversionRate = :conversionRate")
    , @NamedQuery(name = "PsOrderPayment.findByTransactionId", query = "SELECT p FROM PsOrderPayment p WHERE p.transactionId = :transactionId")
    , @NamedQuery(name = "PsOrderPayment.findByCardNumber", query = "SELECT p FROM PsOrderPayment p WHERE p.cardNumber = :cardNumber")
    , @NamedQuery(name = "PsOrderPayment.findByCardBrand", query = "SELECT p FROM PsOrderPayment p WHERE p.cardBrand = :cardBrand")
    , @NamedQuery(name = "PsOrderPayment.findByCardExpiration", query = "SELECT p FROM PsOrderPayment p WHERE p.cardExpiration = :cardExpiration")
    , @NamedQuery(name = "PsOrderPayment.findByCardHolder", query = "SELECT p FROM PsOrderPayment p WHERE p.cardHolder = :cardHolder")
    , @NamedQuery(name = "PsOrderPayment.findByDateAdd", query = "SELECT p FROM PsOrderPayment p WHERE p.dateAdd = :dateAdd")})
public class PsOrderPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_payment")
    private Integer idOrderPayment;
    @Column(name = "order_reference")
    private String orderReference;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic(optional = false)
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_brand")
    private String cardBrand;
    @Column(name = "card_expiration")
    private String cardExpiration;
    @Column(name = "card_holder")
    private String cardHolder;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsOrderPayment() {
    }

    public PsOrderPayment(Integer idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    public PsOrderPayment(Integer idOrderPayment, int idCurrency, BigDecimal amount, String paymentMethod, BigDecimal conversionRate, Date dateAdd) {
        this.idOrderPayment = idOrderPayment;
        this.idCurrency = idCurrency;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.conversionRate = conversionRate;
        this.dateAdd = dateAdd;
    }

    public Integer getIdOrderPayment() {
        return idOrderPayment;
    }

    public void setIdOrderPayment(Integer idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderPayment != null ? idOrderPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderPayment)) {
            return false;
        }
        PsOrderPayment other = (PsOrderPayment) object;
        if ((this.idOrderPayment == null && other.idOrderPayment != null) || (this.idOrderPayment != null && !this.idOrderPayment.equals(other.idOrderPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderPayment[ idOrderPayment=" + idOrderPayment + " ]";
    }
    
}
