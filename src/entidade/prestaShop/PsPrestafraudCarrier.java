/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_prestafraud_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPrestafraudCarrier.findAll", query = "SELECT p FROM PsPrestafraudCarrier p")})
public class PsPrestafraudCarrier implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPrestafraudCarrierPK psPrestafraudCarrierPK;

    public PsPrestafraudCarrier() {
    }

    public PsPrestafraudCarrier(PsPrestafraudCarrierPK psPrestafraudCarrierPK) {
        this.psPrestafraudCarrierPK = psPrestafraudCarrierPK;
    }

    public PsPrestafraudCarrier(int idCarrier, int idPrestafraudCarrierType) {
        this.psPrestafraudCarrierPK = new PsPrestafraudCarrierPK(idCarrier, idPrestafraudCarrierType);
    }

    public PsPrestafraudCarrierPK getPsPrestafraudCarrierPK() {
        return psPrestafraudCarrierPK;
    }

    public void setPsPrestafraudCarrierPK(PsPrestafraudCarrierPK psPrestafraudCarrierPK) {
        this.psPrestafraudCarrierPK = psPrestafraudCarrierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPrestafraudCarrierPK != null ? psPrestafraudCarrierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudCarrier)) {
            return false;
        }
        PsPrestafraudCarrier other = (PsPrestafraudCarrier) object;
        if ((this.psPrestafraudCarrierPK == null && other.psPrestafraudCarrierPK != null) || (this.psPrestafraudCarrierPK != null && !this.psPrestafraudCarrierPK.equals(other.psPrestafraudCarrierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudCarrier[ psPrestafraudCarrierPK=" + psPrestafraudCarrierPK + " ]";
    }
    
}
