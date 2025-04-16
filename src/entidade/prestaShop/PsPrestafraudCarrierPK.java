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
public class PsPrestafraudCarrierPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Basic(optional = false)
    @Column(name = "id_prestafraud_carrier_type")
    private int idPrestafraudCarrierType;

    public PsPrestafraudCarrierPK() {
    }

    public PsPrestafraudCarrierPK(int idCarrier, int idPrestafraudCarrierType) {
        this.idCarrier = idCarrier;
        this.idPrestafraudCarrierType = idPrestafraudCarrierType;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdPrestafraudCarrierType() {
        return idPrestafraudCarrierType;
    }

    public void setIdPrestafraudCarrierType(int idPrestafraudCarrierType) {
        this.idPrestafraudCarrierType = idPrestafraudCarrierType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCarrier;
        hash += (int) idPrestafraudCarrierType;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudCarrierPK)) {
            return false;
        }
        PsPrestafraudCarrierPK other = (PsPrestafraudCarrierPK) object;
        if (this.idCarrier != other.idCarrier) {
            return false;
        }
        if (this.idPrestafraudCarrierType != other.idPrestafraudCarrierType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudCarrierPK[ idCarrier=" + idCarrier + ", idPrestafraudCarrierType=" + idPrestafraudCarrierType + " ]";
    }
    
}
