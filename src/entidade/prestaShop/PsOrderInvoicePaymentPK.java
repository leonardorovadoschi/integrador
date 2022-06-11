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
 * @author leo
 */
@Embeddable
public class PsOrderInvoicePaymentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_order_invoice")
    private int idOrderInvoice;
    @Basic(optional = false)
    @Column(name = "id_order_payment")
    private int idOrderPayment;

    public PsOrderInvoicePaymentPK() {
    }

    public PsOrderInvoicePaymentPK(int idOrderInvoice, int idOrderPayment) {
        this.idOrderInvoice = idOrderInvoice;
        this.idOrderPayment = idOrderPayment;
    }

    public int getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(int idOrderInvoice) {
        this.idOrderInvoice = idOrderInvoice;
    }

    public int getIdOrderPayment() {
        return idOrderPayment;
    }

    public void setIdOrderPayment(int idOrderPayment) {
        this.idOrderPayment = idOrderPayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrderInvoice;
        hash += (int) idOrderPayment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderInvoicePaymentPK)) {
            return false;
        }
        PsOrderInvoicePaymentPK other = (PsOrderInvoicePaymentPK) object;
        if (this.idOrderInvoice != other.idOrderInvoice) {
            return false;
        }
        if (this.idOrderPayment != other.idOrderPayment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderInvoicePaymentPK[ idOrderInvoice=" + idOrderInvoice + ", idOrderPayment=" + idOrderPayment + " ]";
    }
    
}
