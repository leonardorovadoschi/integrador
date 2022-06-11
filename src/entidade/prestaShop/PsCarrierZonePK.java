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
public class PsCarrierZonePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;

    public PsCarrierZonePK() {
    }

    public PsCarrierZonePK(int idCarrier, int idZone) {
        this.idCarrier = idCarrier;
        this.idZone = idZone;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCarrier;
        hash += (int) idZone;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierZonePK)) {
            return false;
        }
        PsCarrierZonePK other = (PsCarrierZonePK) object;
        if (this.idCarrier != other.idCarrier) {
            return false;
        }
        if (this.idZone != other.idZone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierZonePK[ idCarrier=" + idCarrier + ", idZone=" + idZone + " ]";
    }
    
}
