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
public class PsOrderSlipDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_order_slip")
    private int idOrderSlip;
    @Basic(optional = false)
    @Column(name = "id_order_detail")
    private int idOrderDetail;

    public PsOrderSlipDetailPK() {
    }

    public PsOrderSlipDetailPK(int idOrderSlip, int idOrderDetail) {
        this.idOrderSlip = idOrderSlip;
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdOrderSlip() {
        return idOrderSlip;
    }

    public void setIdOrderSlip(int idOrderSlip) {
        this.idOrderSlip = idOrderSlip;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrderSlip;
        hash += (int) idOrderDetail;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderSlipDetailPK)) {
            return false;
        }
        PsOrderSlipDetailPK other = (PsOrderSlipDetailPK) object;
        if (this.idOrderSlip != other.idOrderSlip) {
            return false;
        }
        if (this.idOrderDetail != other.idOrderDetail) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderSlipDetailPK[ idOrderSlip=" + idOrderSlip + ", idOrderDetail=" + idOrderDetail + " ]";
    }
    
}
