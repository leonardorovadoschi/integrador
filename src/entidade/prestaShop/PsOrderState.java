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
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_state")

public class PsOrderState implements Serializable {
    @Column(name = "invoice")
    private Short invoice;
    @Basic(optional = false)
    @Column(name = "send_email")
    private short sendEmail;
    @Basic(optional = false)
    @Column(name = "unremovable")
    private short unremovable;
    @Basic(optional = false)
    @Column(name = "hidden")
    private short hidden;
    @Basic(optional = false)
    @Column(name = "delivery")
    private short delivery;
    @Basic(optional = false)
    @Column(name = "shipped")
    private short shipped;
    @Basic(optional = false)
    @Column(name = "paid")
    private short paid;
    @Basic(optional = false)
    @Column(name = "pdf_invoice")
    private short pdfInvoice;
    @Basic(optional = false)
    @Column(name = "pdf_delivery")
    private short pdfDelivery;
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_state")
    private Integer idOrderState;
    @Column(name = "module_name")
    private String moduleName;
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "logable")
    private boolean logable;

    public PsOrderState() {
    }

    public PsOrderState(Integer idOrderState) {
        this.idOrderState = idOrderState;
    }

    public PsOrderState(Integer idOrderState, short sendEmail, short unremovable, short hidden, boolean logable, short delivery, short shipped, short paid, short pdfInvoice, short pdfDelivery, short deleted) {
        this.idOrderState = idOrderState;
        this.sendEmail = sendEmail;
        this.unremovable = unremovable;
        this.hidden = hidden;
        this.logable = logable;
        this.delivery = delivery;
        this.shipped = shipped;
        this.paid = paid;
        this.pdfInvoice = pdfInvoice;
        this.pdfDelivery = pdfDelivery;
        this.deleted = deleted;
    }

    public Integer getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(Integer idOrderState) {
        this.idOrderState = idOrderState;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public boolean getLogable() {
        return logable;
    }

    public void setLogable(boolean logable) {
        this.logable = logable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderState != null ? idOrderState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderState)) {
            return false;
        }
        PsOrderState other = (PsOrderState) object;
        if ((this.idOrderState == null && other.idOrderState != null) || (this.idOrderState != null && !this.idOrderState.equals(other.idOrderState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderState[ idOrderState=" + idOrderState + " ]";
    }

    public Short getInvoice() {
        return invoice;
    }

    public void setInvoice(Short invoice) {
        this.invoice = invoice;
    }

    public short getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(short sendEmail) {
        this.sendEmail = sendEmail;
    }

    public short getUnremovable() {
        return unremovable;
    }

    public void setUnremovable(short unremovable) {
        this.unremovable = unremovable;
    }

    public short getHidden() {
        return hidden;
    }

    public void setHidden(short hidden) {
        this.hidden = hidden;
    }

    public short getDelivery() {
        return delivery;
    }

    public void setDelivery(short delivery) {
        this.delivery = delivery;
    }

    public short getShipped() {
        return shipped;
    }

    public void setShipped(short shipped) {
        this.shipped = shipped;
    }

    public short getPaid() {
        return paid;
    }

    public void setPaid(short paid) {
        this.paid = paid;
    }

    public short getPdfInvoice() {
        return pdfInvoice;
    }

    public void setPdfInvoice(short pdfInvoice) {
        this.pdfInvoice = pdfInvoice;
    }

    public short getPdfDelivery() {
        return pdfDelivery;
    }

    public void setPdfDelivery(short pdfDelivery) {
        this.pdfDelivery = pdfDelivery;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }
    
}
