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
public class PsContactShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_contact")
    private int idContact;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsContactShopPK() {
    }

    public PsContactShopPK(int idContact, int idShop) {
        this.idContact = idContact;
        this.idShop = idShop;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
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
        hash += (int) idContact;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsContactShopPK)) {
            return false;
        }
        PsContactShopPK other = (PsContactShopPK) object;
        if (this.idContact != other.idContact) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsContactShopPK[ idContact=" + idContact + ", idShop=" + idShop + " ]";
    }
    
}
