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
public class PsWarehouseCarrierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;

    public PsWarehouseCarrierPK() {
    }

    public PsWarehouseCarrierPK(int idCarrier, int idWarehouse) {
        this.idCarrier = idCarrier;
        this.idWarehouse = idWarehouse;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCarrier;
        hash += (int) idWarehouse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouseCarrierPK)) {
            return false;
        }
        PsWarehouseCarrierPK other = (PsWarehouseCarrierPK) object;
        if (this.idCarrier != other.idCarrier) {
            return false;
        }
        if (this.idWarehouse != other.idWarehouse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouseCarrierPK[ idCarrier=" + idCarrier + ", idWarehouse=" + idWarehouse + " ]";
    }
    
}
