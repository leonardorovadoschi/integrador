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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_supply_order_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrderState.findAll", query = "SELECT p FROM PsSupplyOrderState p")
    , @NamedQuery(name = "PsSupplyOrderState.findByIdSupplyOrderState", query = "SELECT p FROM PsSupplyOrderState p WHERE p.idSupplyOrderState = :idSupplyOrderState")
    , @NamedQuery(name = "PsSupplyOrderState.findByDeliveryNote", query = "SELECT p FROM PsSupplyOrderState p WHERE p.deliveryNote = :deliveryNote")
    , @NamedQuery(name = "PsSupplyOrderState.findByEditable", query = "SELECT p FROM PsSupplyOrderState p WHERE p.editable = :editable")
    , @NamedQuery(name = "PsSupplyOrderState.findByReceiptState", query = "SELECT p FROM PsSupplyOrderState p WHERE p.receiptState = :receiptState")
    , @NamedQuery(name = "PsSupplyOrderState.findByPendingReceipt", query = "SELECT p FROM PsSupplyOrderState p WHERE p.pendingReceipt = :pendingReceipt")
    , @NamedQuery(name = "PsSupplyOrderState.findByEnclosed", query = "SELECT p FROM PsSupplyOrderState p WHERE p.enclosed = :enclosed")
    , @NamedQuery(name = "PsSupplyOrderState.findByColor", query = "SELECT p FROM PsSupplyOrderState p WHERE p.color = :color")})
public class PsSupplyOrderState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supply_order_state")
    private Integer idSupplyOrderState;
    @Basic(optional = false)
    @Column(name = "delivery_note")
    private boolean deliveryNote;
    @Basic(optional = false)
    @Column(name = "editable")
    private boolean editable;
    @Basic(optional = false)
    @Column(name = "receipt_state")
    private boolean receiptState;
    @Basic(optional = false)
    @Column(name = "pending_receipt")
    private boolean pendingReceipt;
    @Basic(optional = false)
    @Column(name = "enclosed")
    private boolean enclosed;
    @Column(name = "color")
    private String color;

    public PsSupplyOrderState() {
    }

    public PsSupplyOrderState(Integer idSupplyOrderState) {
        this.idSupplyOrderState = idSupplyOrderState;
    }

    public PsSupplyOrderState(Integer idSupplyOrderState, boolean deliveryNote, boolean editable, boolean receiptState, boolean pendingReceipt, boolean enclosed) {
        this.idSupplyOrderState = idSupplyOrderState;
        this.deliveryNote = deliveryNote;
        this.editable = editable;
        this.receiptState = receiptState;
        this.pendingReceipt = pendingReceipt;
        this.enclosed = enclosed;
    }

    public Integer getIdSupplyOrderState() {
        return idSupplyOrderState;
    }

    public void setIdSupplyOrderState(Integer idSupplyOrderState) {
        this.idSupplyOrderState = idSupplyOrderState;
    }

    public boolean getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(boolean deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public boolean getEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean getReceiptState() {
        return receiptState;
    }

    public void setReceiptState(boolean receiptState) {
        this.receiptState = receiptState;
    }

    public boolean getPendingReceipt() {
        return pendingReceipt;
    }

    public void setPendingReceipt(boolean pendingReceipt) {
        this.pendingReceipt = pendingReceipt;
    }

    public boolean getEnclosed() {
        return enclosed;
    }

    public void setEnclosed(boolean enclosed) {
        this.enclosed = enclosed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupplyOrderState != null ? idSupplyOrderState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderState)) {
            return false;
        }
        PsSupplyOrderState other = (PsSupplyOrderState) object;
        if ((this.idSupplyOrderState == null && other.idSupplyOrderState != null) || (this.idSupplyOrderState != null && !this.idSupplyOrderState.equals(other.idSupplyOrderState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderState[ idSupplyOrderState=" + idSupplyOrderState + " ]";
    }
    
}
