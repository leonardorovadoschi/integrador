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
class PsAccessoryPK implements Serializable{

    @Basic(optional = false)
    @Column(name = "id_product_1")
    private int idProduct_1;
    @Basic(optional = false)
    @Column(name = "id_product_2")
    private int idProduct_2;

    public PsAccessoryPK() {
    }

    public PsAccessoryPK(int idProfile, int idAuthorizationRole) {
        this.idProduct_1 = idProfile;
        this.idProduct_2 = idAuthorizationRole;
    }

    public int getIdProduct_1() {
        return idProduct_1;
    }

    public void setIdProduct_1(int idProduct_1) {
        this.idProduct_1 = idProduct_1;
    }

    public int getIdProduct_2() {
        return idProduct_2;
    }

    public void setIdProduct_2(int idProduct_2) {
        this.idProduct_2 = idProduct_2;
    }

   @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct_1;
        hash += (int) idProduct_2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAccessoryPK)) {
            return false;
        }
        PsAccessoryPK other = (PsAccessoryPK) object;
        if (this.idProduct_1 != other.idProduct_1) {
            return false;
        }
        if (this.idProduct_2 != other.idProduct_2) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "entidade.prestaShop.PsAccessoryPK[ idProduct_1=" + idProduct_1 + ", idProduct_2=" + idProduct_2 + " ]";
    }
    
    
}
