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
public class PsManufacturerShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_manufacturer")
    private int idManufacturer;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsManufacturerShopPK() {
    }

    public PsManufacturerShopPK(int idManufacturer, int idShop) {
        this.idManufacturer = idManufacturer;
        this.idShop = idShop;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
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
        hash += (int) idManufacturer;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsManufacturerShopPK)) {
            return false;
        }
        PsManufacturerShopPK other = (PsManufacturerShopPK) object;
        if (this.idManufacturer != other.idManufacturer) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsManufacturerShopPK[ idManufacturer=" + idManufacturer + ", idShop=" + idShop + " ]";
    }
    
}
