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
public class PsLayeredFilterShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_layered_filter")
    private int idLayeredFilter;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsLayeredFilterShopPK() {
    }

    public PsLayeredFilterShopPK(int idLayeredFilter, int idShop) {
        this.idLayeredFilter = idLayeredFilter;
        this.idShop = idShop;
    }

    public int getIdLayeredFilter() {
        return idLayeredFilter;
    }

    public void setIdLayeredFilter(int idLayeredFilter) {
        this.idLayeredFilter = idLayeredFilter;
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
        hash += (int) idLayeredFilter;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredFilterShopPK)) {
            return false;
        }
        PsLayeredFilterShopPK other = (PsLayeredFilterShopPK) object;
        if (this.idLayeredFilter != other.idLayeredFilter) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredFilterShopPK[ idLayeredFilter=" + idLayeredFilter + ", idShop=" + idShop + " ]";
    }
    
}
