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
public class PsOrderReturnDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_order_return")
    private int idOrderReturn;
    @Basic(optional = false)
    @Column(name = "id_order_detail")
    private int idOrderDetail;
    @Basic(optional = false)
    @Column(name = "id_customization")
    private int idCustomization;

    public PsOrderReturnDetailPK() {
    }

    public PsOrderReturnDetailPK(int idOrderReturn, int idOrderDetail, int idCustomization) {
        this.idOrderReturn = idOrderReturn;
        this.idOrderDetail = idOrderDetail;
        this.idCustomization = idCustomization;
    }

    public int getIdOrderReturn() {
        return idOrderReturn;
    }

    public void setIdOrderReturn(int idOrderReturn) {
        this.idOrderReturn = idOrderReturn;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(int idCustomization) {
        this.idCustomization = idCustomization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrderReturn;
        hash += (int) idOrderDetail;
        hash += (int) idCustomization;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderReturnDetailPK)) {
            return false;
        }
        PsOrderReturnDetailPK other = (PsOrderReturnDetailPK) object;
        if (this.idOrderReturn != other.idOrderReturn) {
            return false;
        }
        if (this.idOrderDetail != other.idOrderDetail) {
            return false;
        }
        if (this.idCustomization != other.idCustomization) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderReturnDetailPK[ idOrderReturn=" + idOrderReturn + ", idOrderDetail=" + idOrderDetail + ", idCustomization=" + idCustomization + " ]";
    }
    
}
