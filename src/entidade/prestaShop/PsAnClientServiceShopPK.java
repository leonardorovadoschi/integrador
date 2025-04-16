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
 * @author leo-note
 */
@Embeddable
public class PsAnClientServiceShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_client_service")
    private int idClientService;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnClientServiceShopPK() {
    }

    public PsAnClientServiceShopPK(int idClientService, int idShop) {
        this.idClientService = idClientService;
        this.idShop = idShop;
    }

    public int getIdClientService() {
        return idClientService;
    }

    public void setIdClientService(int idClientService) {
        this.idClientService = idClientService;
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
        hash += (int) idClientService;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnClientServiceShopPK)) {
            return false;
        }
        PsAnClientServiceShopPK other = (PsAnClientServiceShopPK) object;
        if (this.idClientService != other.idClientService) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnClientServiceShopPK[ idClientService=" + idClientService + ", idShop=" + idShop + " ]";
    }
    
}
