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
public class PsAnProductextratabsShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idtab")
    private int idtab;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnProductextratabsShopPK() {
    }

    public PsAnProductextratabsShopPK(int idtab, int idShop) {
        this.idtab = idtab;
        this.idShop = idShop;
    }

    public int getIdtab() {
        return idtab;
    }

    public void setIdtab(int idtab) {
        this.idtab = idtab;
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
        hash += (int) idtab;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsShopPK)) {
            return false;
        }
        PsAnProductextratabsShopPK other = (PsAnProductextratabsShopPK) object;
        if (this.idtab != other.idtab) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsShopPK[ idtab=" + idtab + ", idShop=" + idShop + " ]";
    }
    
}
