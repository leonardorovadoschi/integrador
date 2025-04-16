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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_pscheckout_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutOrder.findAll", query = "SELECT p FROM PsPscheckoutOrder p")})
public class PsPscheckoutOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "intent")
    private String intent;
    @Basic(optional = false)
    @Column(name = "funding_source")
    private String fundingSource;
    @Lob
    @Column(name = "payment_source")
    private String paymentSource;
    @Basic(optional = false)
    @Column(name = "environment")
    private String environment;
    @Basic(optional = false)
    @Column(name = "is_card_fields")
    private boolean isCardFields;
    @Basic(optional = false)
    @Column(name = "is_express_checkout")
    private boolean isExpressCheckout;
    @Column(name = "customer_intent")
    private String customerIntent;
    @Column(name = "payment_token_id")
    private String paymentTokenId;
    @Column(name = "tags")
    private String tags;

    public PsPscheckoutOrder() {
    }

    public PsPscheckoutOrder(String id) {
        this.id = id;
    }

    public PsPscheckoutOrder(String id, int idCart, String status, String fundingSource, String environment, boolean isCardFields, boolean isExpressCheckout) {
        this.id = id;
        this.idCart = idCart;
        this.status = status;
        this.fundingSource = fundingSource;
        this.environment = environment;
        this.isCardFields = isCardFields;
        this.isExpressCheckout = isExpressCheckout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean getIsCardFields() {
        return isCardFields;
    }

    public void setIsCardFields(boolean isCardFields) {
        this.isCardFields = isCardFields;
    }

    public boolean getIsExpressCheckout() {
        return isExpressCheckout;
    }

    public void setIsExpressCheckout(boolean isExpressCheckout) {
        this.isExpressCheckout = isExpressCheckout;
    }

    public String getCustomerIntent() {
        return customerIntent;
    }

    public void setCustomerIntent(String customerIntent) {
        this.customerIntent = customerIntent;
    }

    public String getPaymentTokenId() {
        return paymentTokenId;
    }

    public void setPaymentTokenId(String paymentTokenId) {
        this.paymentTokenId = paymentTokenId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutOrder)) {
            return false;
        }
        PsPscheckoutOrder other = (PsPscheckoutOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutOrder[ id=" + id + " ]";
    }
    
}
