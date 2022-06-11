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
public class PsSupplierShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsSupplierShopPK() {
    }

    public PsSupplierShopPK(int idSupplier, int idShop) {
        this.idSupplier = idSupplier;
        this.idShop = idShop;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSupplier;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplierShopPK)) {
            return false;
        }
        PsSupplierShopPK other = (PsSupplierShopPK) object;
        if (this.idSupplier != other.idSupplier) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplierShopPK[ idSupplier=" + idSupplier + ", idShop=" + idShop + " ]";
    }
    
}
