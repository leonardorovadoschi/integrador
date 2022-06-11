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
public class PsWebserviceAccountShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_webservice_account")
    private int idWebserviceAccount;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsWebserviceAccountShopPK() {
    }

    public PsWebserviceAccountShopPK(int idWebserviceAccount, int idShop) {
        this.idWebserviceAccount = idWebserviceAccount;
        this.idShop = idShop;
    }

    public int getIdWebserviceAccount() {
        return idWebserviceAccount;
    }

    public void setIdWebserviceAccount(int idWebserviceAccount) {
        this.idWebserviceAccount = idWebserviceAccount;
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
        hash += (int) idWebserviceAccount;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWebserviceAccountShopPK)) {
            return false;
        }
        PsWebserviceAccountShopPK other = (PsWebserviceAccountShopPK) object;
        if (this.idWebserviceAccount != other.idWebserviceAccount) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWebserviceAccountShopPK[ idWebserviceAccount=" + idWebserviceAccount + ", idShop=" + idShop + " ]";
    }
    
}
