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
@Table(name = "ps_pscheckout_authorization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutAuthorization.findAll", query = "SELECT p FROM PsPscheckoutAuthorization p")})
public class PsPscheckoutAuthorization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "id_order")
    private String idOrder;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "expiration_time")
    private String expirationTime;
    @Lob
    @Column(name = "seller_protection")
    private String sellerProtection;

    public PsPscheckoutAuthorization() {
    }

    public PsPscheckoutAuthorization(String id) {
        this.id = id;
    }

    public PsPscheckoutAuthorization(String id, String idOrder, String status, String expirationTime) {
        this.id = id;
        this.idOrder = idOrder;
        this.status = status;
        this.expirationTime = expirationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getSellerProtection() {
        return sellerProtection;
    }

    public void setSellerProtection(String sellerProtection) {
        this.sellerProtection = sellerProtection;
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
        if (!(object instanceof PsPscheckoutAuthorization)) {
            return false;
        }
        PsPscheckoutAuthorization other = (PsPscheckoutAuthorization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutAuthorization[ id=" + id + " ]";
    }
    
}
