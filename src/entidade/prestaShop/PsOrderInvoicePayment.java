/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_invoice_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderInvoicePayment.findAll", query = "SELECT p FROM PsOrderInvoicePayment p")
    , @NamedQuery(name = "PsOrderInvoicePayment.findByIdOrderInvoice", query = "SELECT p FROM PsOrderInvoicePayment p WHERE p.psOrderInvoicePaymentPK.idOrderInvoice = :idOrderInvoice")
    , @NamedQuery(name = "PsOrderInvoicePayment.findByIdOrderPayment", query = "SELECT p FROM PsOrderInvoicePayment p WHERE p.psOrderInvoicePaymentPK.idOrderPayment = :idOrderPayment")
    , @NamedQuery(name = "PsOrderInvoicePayment.findByIdOrder", query = "SELECT p FROM PsOrderInvoicePayment p WHERE p.idOrder = :idOrder")})
public class PsOrderInvoicePayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderInvoicePaymentPK psOrderInvoicePaymentPK;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;

    public PsOrderInvoicePayment() {
    }

    public PsOrderInvoicePayment(PsOrderInvoicePaymentPK psOrderInvoicePaymentPK) {
        this.psOrderInvoicePaymentPK = psOrderInvoicePaymentPK;
    }

    public PsOrderInvoicePayment(PsOrderInvoicePaymentPK psOrderInvoicePaymentPK, int idOrder) {
        this.psOrderInvoicePaymentPK = psOrderInvoicePaymentPK;
        this.idOrder = idOrder;
    }

    public PsOrderInvoicePayment(int idOrderInvoice, int idOrderPayment) {
        this.psOrderInvoicePaymentPK = new PsOrderInvoicePaymentPK(idOrderInvoice, idOrderPayment);
    }

    public PsOrderInvoicePaymentPK getPsOrderInvoicePaymentPK() {
        return psOrderInvoicePaymentPK;
    }

    public void setPsOrderInvoicePaymentPK(PsOrderInvoicePaymentPK psOrderInvoicePaymentPK) {
        this.psOrderInvoicePaymentPK = psOrderInvoicePaymentPK;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psOrderInvoicePaymentPK != null ? psOrderInvoicePaymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderInvoicePayment)) {
            return false;
        }
        PsOrderInvoicePayment other = (PsOrderInvoicePayment) object;
        if ((this.psOrderInvoicePaymentPK == null && other.psOrderInvoicePaymentPK != null) || (this.psOrderInvoicePaymentPK != null && !this.psOrderInvoicePaymentPK.equals(other.psOrderInvoicePaymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderInvoicePayment[ psOrderInvoicePaymentPK=" + psOrderInvoicePaymentPK + " ]";
    }
    
}
