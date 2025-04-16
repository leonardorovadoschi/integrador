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
public class PsAnAdvantagesShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_advantage")
    private int idAdvantage;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnAdvantagesShopPK() {
    }

    public PsAnAdvantagesShopPK(int idAdvantage, int idShop) {
        this.idAdvantage = idAdvantage;
        this.idShop = idShop;
    }

    public int getIdAdvantage() {
        return idAdvantage;
    }

    public void setIdAdvantage(int idAdvantage) {
        this.idAdvantage = idAdvantage;
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
        hash += (int) idAdvantage;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnAdvantagesShopPK)) {
            return false;
        }
        PsAnAdvantagesShopPK other = (PsAnAdvantagesShopPK) object;
        if (this.idAdvantage != other.idAdvantage) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnAdvantagesShopPK[ idAdvantage=" + idAdvantage + ", idShop=" + idShop + " ]";
    }
    
}
