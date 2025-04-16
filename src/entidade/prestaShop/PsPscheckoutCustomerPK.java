/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo-note
 */
@Embeddable
public class PsPscheckoutCustomerPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "paypal_customer_id")
    private String paypalCustomerId;

    public PsPscheckoutCustomerPK() {
    }

    public PsPscheckoutCustomerPK(int idCustomer, String paypalCustomerId) {
        this.idCustomer = idCustomer;
        this.paypalCustomerId = paypalCustomerId;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPaypalCustomerId() {
        return paypalCustomerId;
    }

    public void setPaypalCustomerId(String paypalCustomerId) {
        this.paypalCustomerId = paypalCustomerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomer;
        hash += (paypalCustomerId != null ? paypalCustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutCustomerPK)) {
            return false;
        }
        PsPscheckoutCustomerPK other = (PsPscheckoutCustomerPK) object;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        if ((this.paypalCustomerId == null && other.paypalCustomerId != null) || (this.paypalCustomerId != null && !this.paypalCustomerId.equals(other.paypalCustomerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutCustomerPK[ idCustomer=" + idCustomer + ", paypalCustomerId=" + paypalCustomerId + " ]";
    }
    
}
