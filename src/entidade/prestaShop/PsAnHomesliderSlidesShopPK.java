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
public class PsAnHomesliderSlidesShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_slide")
    private int idSlide;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnHomesliderSlidesShopPK() {
    }

    public PsAnHomesliderSlidesShopPK(int idSlide, int idShop) {
        this.idSlide = idSlide;
        this.idShop = idShop;
    }

    public int getIdSlide() {
        return idSlide;
    }

    public void setIdSlide(int idSlide) {
        this.idSlide = idSlide;
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
        hash += (int) idSlide;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlidesShopPK)) {
            return false;
        }
        PsAnHomesliderSlidesShopPK other = (PsAnHomesliderSlidesShopPK) object;
        if (this.idSlide != other.idSlide) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlidesShopPK[ idSlide=" + idSlide + ", idShop=" + idShop + " ]";
    }
    
}
