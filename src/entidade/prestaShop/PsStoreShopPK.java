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
public class PsStoreShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_store")
    private int idStore;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsStoreShopPK() {
    }

    public PsStoreShopPK(int idStore, int idShop) {
        this.idStore = idStore;
        this.idShop = idShop;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
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
        hash += (int) idStore;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStoreShopPK)) {
            return false;
        }
        PsStoreShopPK other = (PsStoreShopPK) object;
        if (this.idStore != other.idStore) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStoreShopPK[ idStore=" + idStore + ", idShop=" + idShop + " ]";
    }
    
}
