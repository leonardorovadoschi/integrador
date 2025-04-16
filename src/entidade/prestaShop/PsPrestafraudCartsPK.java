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
public class PsPrestafraudCartsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "ip_address")
    private int ipAddress;

    public PsPrestafraudCartsPK() {
    }

    public PsPrestafraudCartsPK(int idCart, int ipAddress) {
        this.idCart = idCart;
        this.ipAddress = ipAddress;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCart;
        hash += (int) ipAddress;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudCartsPK)) {
            return false;
        }
        PsPrestafraudCartsPK other = (PsPrestafraudCartsPK) object;
        if (this.idCart != other.idCart) {
            return false;
        }
        if (this.ipAddress != other.ipAddress) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudCartsPK[ idCart=" + idCart + ", ipAddress=" + ipAddress + " ]";
    }

}
