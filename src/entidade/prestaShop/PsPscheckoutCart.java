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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_pscheckout_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutCart.findAll", query = "SELECT p FROM PsPscheckoutCart p")})
public class PsPscheckoutCart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pscheckout_cart")
    private Integer idPscheckoutCart;
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Column(name = "paypal_intent")
    private String paypalIntent;
    @Column(name = "paypal_order")
    private String paypalOrder;
    @Column(name = "paypal_status")
    private String paypalStatus;
    @Column(name = "paypal_funding")
    private String paypalFunding;
    @Lob
    @Column(name = "paypal_token")
    private String paypalToken;
    @Column(name = "paypal_token_expire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paypalTokenExpire;
    @Column(name = "paypal_authorization_expire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paypalAuthorizationExpire;
    @Column(name = "environment")
    private String environment;
    @Basic(optional = false)
    @Column(name = "isExpressCheckout")
    private short isExpressCheckout;
    @Basic(optional = false)
    @Column(name = "isHostedFields")
    private short isHostedFields;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsPscheckoutCart() {
    }

    public PsPscheckoutCart(Integer idPscheckoutCart) {
        this.idPscheckoutCart = idPscheckoutCart;
    }

    public PsPscheckoutCart(Integer idPscheckoutCart, int idCart, short isExpressCheckout, short isHostedFields, Date dateAdd, Date dateUpd) {
        this.idPscheckoutCart = idPscheckoutCart;
        this.idCart = idCart;
        this.isExpressCheckout = isExpressCheckout;
        this.isHostedFields = isHostedFields;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdPscheckoutCart() {
        return idPscheckoutCart;
    }

    public void setIdPscheckoutCart(Integer idPscheckoutCart) {
        this.idPscheckoutCart = idPscheckoutCart;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public String getPaypalIntent() {
        return paypalIntent;
    }

    public void setPaypalIntent(String paypalIntent) {
        this.paypalIntent = paypalIntent;
    }

    public String getPaypalOrder() {
        return paypalOrder;
    }

    public void setPaypalOrder(String paypalOrder) {
        this.paypalOrder = paypalOrder;
    }

    public String getPaypalStatus() {
        return paypalStatus;
    }

    public void setPaypalStatus(String paypalStatus) {
        this.paypalStatus = paypalStatus;
    }

    public String getPaypalFunding() {
        return paypalFunding;
    }

    public void setPaypalFunding(String paypalFunding) {
        this.paypalFunding = paypalFunding;
    }

    public String getPaypalToken() {
        return paypalToken;
    }

    public void setPaypalToken(String paypalToken) {
        this.paypalToken = paypalToken;
    }

    public Date getPaypalTokenExpire() {
        return paypalTokenExpire;
    }

    public void setPaypalTokenExpire(Date paypalTokenExpire) {
        this.paypalTokenExpire = paypalTokenExpire;
    }

    public Date getPaypalAuthorizationExpire() {
        return paypalAuthorizationExpire;
    }

    public void setPaypalAuthorizationExpire(Date paypalAuthorizationExpire) {
        this.paypalAuthorizationExpire = paypalAuthorizationExpire;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public short getIsExpressCheckout() {
        return isExpressCheckout;
    }

    public void setIsExpressCheckout(short isExpressCheckout) {
        this.isExpressCheckout = isExpressCheckout;
    }

    public short getIsHostedFields() {
        return isHostedFields;
    }

    public void setIsHostedFields(short isHostedFields) {
        this.isHostedFields = isHostedFields;
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
        hash += (idPscheckoutCart != null ? idPscheckoutCart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutCart)) {
            return false;
        }
        PsPscheckoutCart other = (PsPscheckoutCart) object;
        if ((this.idPscheckoutCart == null && other.idPscheckoutCart != null) || (this.idPscheckoutCart != null && !this.idPscheckoutCart.equals(other.idPscheckoutCart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutCart[ idPscheckoutCart=" + idPscheckoutCart + " ]";
    }
    
}
