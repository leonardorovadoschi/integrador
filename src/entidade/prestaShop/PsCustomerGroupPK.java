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
public class PsCustomerGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;

    public PsCustomerGroupPK() {
    }

    public PsCustomerGroupPK(int idCustomer, int idGroup) {
        this.idCustomer = idCustomer;
        this.idGroup = idGroup;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomer;
        hash += (int) idGroup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomerGroupPK)) {
            return false;
        }
        PsCustomerGroupPK other = (PsCustomerGroupPK) object;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomerGroupPK[ idCustomer=" + idCustomer + ", idGroup=" + idGroup + " ]";
    }
    
}
