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
public class PsAnHomesliderSlidersShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_slider")
    private int idSlider;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnHomesliderSlidersShopPK() {
    }

    public PsAnHomesliderSlidersShopPK(int idSlider, int idShop) {
        this.idSlider = idSlider;
        this.idShop = idShop;
    }

    public int getIdSlider() {
        return idSlider;
    }

    public void setIdSlider(int idSlider) {
        this.idSlider = idSlider;
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
        hash += (int) idSlider;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidersShopPK)) {
            return false;
        }
        PsAnHomesliderSlidersShopPK other = (PsAnHomesliderSlidersShopPK) object;
        if (this.idSlider != other.idSlider) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidersShopPK[ idSlider=" + idSlider + ", idShop=" + idShop + " ]";
    }
    
}
