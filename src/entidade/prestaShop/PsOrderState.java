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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_state")
    private Integer idOrderState;
    @Column(name = "invoice")
    private Boolean invoice;
    @Basic(optional = false)
    @Column(name = "send_email")
    private boolean sendEmail;
    @Column(name = "module_name")
    private String moduleName;
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "unremovable")
    private boolean unremovable;
    @Basic(optional = false)
    @Column(name = "hidden")
    private boolean hidden;
    @Basic(optional = false)
    @Column(name = "logable")
    private boolean logable;
    @Basic(optional = false)
    @Column(name = "delivery")
    private boolean delivery;
    @Basic(optional = false)
    @Column(name = "shipped")
    private boolean shipped;
    @Basic(optional = false)
    @Column(name = "paid")
    private boolean paid;
    @Basic(optional = false)
    @Column(name = "pdf_invoice")
    private boolean pdfInvoice;
    @Basic(optional = false)
    @Column(name = "pdf_delivery")
    private boolean pdfDelivery;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsOrderState() {
    }

    public PsOrderState(Integer idOrderState) {
        this.idOrderState = idOrderState;
    }

    public PsOrderState(Integer idOrderState, boolean sendEmail, boolean unremovable, boolean hidden, boolean logable, boolean delivery, boolean shipped, boolean paid, boolean pdfInvoice, boolean pdfDelivery, boolean deleted) {
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

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    public boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
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

    public boolean getUnremovable() {
        return unremovable;
    }

    public void setUnremovable(boolean unremovable) {
        this.unremovable = unremovable;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean getLogable() {
        return logable;
    }

    public void setLogable(boolean logable) {
        this.logable = logable;
    }

    public boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean getShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean getPdfInvoice() {
        return pdfInvoice;
    }

    public void setPdfInvoice(boolean pdfInvoice) {
        this.pdfInvoice = pdfInvoice;
    }

    public boolean getPdfDelivery() {
        return pdfDelivery;
    }

    public void setPdfDelivery(boolean pdfDelivery) {
        this.pdfDelivery = pdfDelivery;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
    
}
