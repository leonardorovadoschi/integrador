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
@Table(name = "ps_pscheckout_refund")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutRefund.findAll", query = "SELECT p FROM PsPscheckoutRefund p")})
public class PsPscheckoutRefund implements Serializable {
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
    @Column(name = "invoice_id")
    private String invoiceId;
    @Basic(optional = false)
    @Column(name = "custom_id")
    private String customId;
    @Basic(optional = false)
    @Column(name = "acquirer_reference_number")
    private String acquirerReferenceNumber;
    @Lob
    @Column(name = "seller_payable_breakdown")
    private String sellerPayableBreakdown;
    @Column(name = "id_order_slip")
    private Integer idOrderSlip;

    public PsPscheckoutRefund() {
    }

    public PsPscheckoutRefund(String id) {
        this.id = id;
    }

    public PsPscheckoutRefund(String id, String idOrder, String status, String invoiceId, String customId, String acquirerReferenceNumber) {
        this.id = id;
        this.idOrder = idOrder;
        this.status = status;
        this.invoiceId = invoiceId;
        this.customId = customId;
        this.acquirerReferenceNumber = acquirerReferenceNumber;
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

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getAcquirerReferenceNumber() {
        return acquirerReferenceNumber;
    }

    public void setAcquirerReferenceNumber(String acquirerReferenceNumber) {
        this.acquirerReferenceNumber = acquirerReferenceNumber;
    }

    public String getSellerPayableBreakdown() {
        return sellerPayableBreakdown;
    }

    public void setSellerPayableBreakdown(String sellerPayableBreakdown) {
        this.sellerPayableBreakdown = sellerPayableBreakdown;
    }

    public Integer getIdOrderSlip() {
        return idOrderSlip;
    }

    public void setIdOrderSlip(Integer idOrderSlip) {
        this.idOrderSlip = idOrderSlip;
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
        if (!(object instanceof PsPscheckoutRefund)) {
            return false;
        }
        PsPscheckoutRefund other = (PsPscheckoutRefund) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutRefund[ id=" + id + " ]";
    }
    
}
