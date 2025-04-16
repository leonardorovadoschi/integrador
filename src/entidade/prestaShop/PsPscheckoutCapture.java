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
@Table(name = "ps_pscheckout_capture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutCapture.findAll", query = "SELECT p FROM PsPscheckoutCapture p")})
public class PsPscheckoutCapture implements Serializable {
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
    @Column(name = "final_capture")
    private boolean finalCapture;
    @Basic(optional = false)
    @Column(name = "created_at")
    private String createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    private String updatedAt;
    @Lob
    @Column(name = "seller_protection")
    private String sellerProtection;
    @Lob
    @Column(name = "seller_receivable_breakdown")
    private String sellerReceivableBreakdown;

    public PsPscheckoutCapture() {
    }

    public PsPscheckoutCapture(String id) {
        this.id = id;
    }

    public PsPscheckoutCapture(String id, String idOrder, String status, boolean finalCapture, String createdAt, String updatedAt) {
        this.id = id;
        this.idOrder = idOrder;
        this.status = status;
        this.finalCapture = finalCapture;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public boolean getFinalCapture() {
        return finalCapture;
    }

    public void setFinalCapture(boolean finalCapture) {
        this.finalCapture = finalCapture;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSellerProtection() {
        return sellerProtection;
    }

    public void setSellerProtection(String sellerProtection) {
        this.sellerProtection = sellerProtection;
    }

    public String getSellerReceivableBreakdown() {
        return sellerReceivableBreakdown;
    }

    public void setSellerReceivableBreakdown(String sellerReceivableBreakdown) {
        this.sellerReceivableBreakdown = sellerReceivableBreakdown;
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
        if (!(object instanceof PsPscheckoutCapture)) {
            return false;
        }
        PsPscheckoutCapture other = (PsPscheckoutCapture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutCapture[ id=" + id + " ]";
    }
    
}
