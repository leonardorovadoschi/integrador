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
public class PsPscheckoutPurchaseUnitPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_order")
    private String idOrder;
    @Basic(optional = false)
    @Column(name = "reference_id")
    private String referenceId;

    public PsPscheckoutPurchaseUnitPK() {
    }

    public PsPscheckoutPurchaseUnitPK(String idOrder, String referenceId) {
        this.idOrder = idOrder;
        this.referenceId = referenceId;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        hash += (referenceId != null ? referenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutPurchaseUnitPK)) {
            return false;
        }
        PsPscheckoutPurchaseUnitPK other = (PsPscheckoutPurchaseUnitPK) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        if ((this.referenceId == null && other.referenceId != null) || (this.referenceId != null && !this.referenceId.equals(other.referenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutPurchaseUnitPK[ idOrder=" + idOrder + ", referenceId=" + referenceId + " ]";
    }
    
}
