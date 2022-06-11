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
public class PsEmployeeShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsEmployeeShopPK() {
    }

    public PsEmployeeShopPK(int idEmployee, int idShop) {
        this.idEmployee = idEmployee;
        this.idShop = idShop;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
        hash += (int) idEmployee;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmployeeShopPK)) {
            return false;
        }
        PsEmployeeShopPK other = (PsEmployeeShopPK) object;
        if (this.idEmployee != other.idEmployee) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmployeeShopPK[ idEmployee=" + idEmployee + ", idShop=" + idShop + " ]";
    }
    
}
