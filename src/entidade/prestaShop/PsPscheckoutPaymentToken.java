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
 * @author leo-note
 */
@Entity
@Table(name = "ps_pscheckout_payment_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutPaymentToken.findAll", query = "SELECT p FROM PsPscheckoutPaymentToken p")})
public class PsPscheckoutPaymentToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "token_id")
    private String tokenId;
    @Basic(optional = false)
    @Column(name = "paypal_customer_id")
    private String paypalCustomerId;
    @Basic(optional = false)
    @Column(name = "payment_source")
    private String paymentSource;
    @Basic(optional = false)
    @Lob
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @Column(name = "merchant_id")
    private String merchantId;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "is_favorite")
    private short isFavorite;

    public PsPscheckoutPaymentToken() {
    }

    public PsPscheckoutPaymentToken(Integer id) {
        this.id = id;
    }

    public PsPscheckoutPaymentToken(Integer id, String tokenId, String paypalCustomerId, String paymentSource, String data, String merchantId, String status, short isFavorite) {
        this.id = id;
        this.tokenId = tokenId;
        this.paypalCustomerId = paypalCustomerId;
        this.paymentSource = paymentSource;
        this.data = data;
        this.merchantId = merchantId;
        this.status = status;
        this.isFavorite = isFavorite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getPaypalCustomerId() {
        return paypalCustomerId;
    }

    public void setPaypalCustomerId(String paypalCustomerId) {
        this.paypalCustomerId = paypalCustomerId;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(short isFavorite) {
        this.isFavorite = isFavorite;
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
        if (!(object instanceof PsPscheckoutPaymentToken)) {
            return false;
        }
        PsPscheckoutPaymentToken other = (PsPscheckoutPaymentToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutPaymentToken[ id=" + id + " ]";
    }
    
}
