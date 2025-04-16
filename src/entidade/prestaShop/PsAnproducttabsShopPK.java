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
public class PsAnproducttabsShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anproducttabs")
    private int idAnproducttabs;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnproducttabsShopPK() {
    }

    public PsAnproducttabsShopPK(int idAnproducttabs, int idShop) {
        this.idAnproducttabs = idAnproducttabs;
        this.idShop = idShop;
    }

    public int getIdAnproducttabs() {
        return idAnproducttabs;
    }

    public void setIdAnproducttabs(int idAnproducttabs) {
        this.idAnproducttabs = idAnproducttabs;
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
        hash += (int) idAnproducttabs;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsShopPK)) {
            return false;
        }
        PsAnproducttabsShopPK other = (PsAnproducttabsShopPK) object;
        if (this.idAnproducttabs != other.idAnproducttabs) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsShopPK[ idAnproducttabs=" + idAnproducttabs + ", idShop=" + idShop + " ]";
    }
    
}
