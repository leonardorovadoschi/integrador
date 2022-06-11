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
public class PsWarehouseShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;

    public PsWarehouseShopPK() {
    }

    public PsWarehouseShopPK(int idShop, int idWarehouse) {
        this.idShop = idShop;
        this.idWarehouse = idWarehouse;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash += (int) idShop;
        hash += (int) idWarehouse;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouseShopPK)) {
            return false;
        }
        PsWarehouseShopPK other = (PsWarehouseShopPK) object;
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idWarehouse != other.idWarehouse) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouseShopPK[ idShop=" + idShop + ", idWarehouse=" + idWarehouse + " ]";
    }
    
}
