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
 * @author leo
 */
@Entity
@Table(name = "ps_carrier_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrierZone.findAll", query = "SELECT p FROM PsCarrierZone p")
    , @NamedQuery(name = "PsCarrierZone.findByIdCarrier", query = "SELECT p FROM PsCarrierZone p WHERE p.psCarrierZonePK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrierZone.findByIdZone", query = "SELECT p FROM PsCarrierZone p WHERE p.psCarrierZonePK.idZone = :idZone")})
public class PsCarrierZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCarrierZonePK psCarrierZonePK;

    public PsCarrierZone() {
    }

    public PsCarrierZone(PsCarrierZonePK psCarrierZonePK) {
        this.psCarrierZonePK = psCarrierZonePK;
    }

    public PsCarrierZone(int idCarrier, int idZone) {
        this.psCarrierZonePK = new PsCarrierZonePK(idCarrier, idZone);
    }

    public PsCarrierZonePK getPsCarrierZonePK() {
        return psCarrierZonePK;
    }

    public void setPsCarrierZonePK(PsCarrierZonePK psCarrierZonePK) {
        this.psCarrierZonePK = psCarrierZonePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCarrierZonePK != null ? psCarrierZonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierZone)) {
            return false;
        }
        PsCarrierZone other = (PsCarrierZone) object;
        if ((this.psCarrierZonePK == null && other.psCarrierZonePK != null) || (this.psCarrierZonePK != null && !this.psCarrierZonePK.equals(other.psCarrierZonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierZone[ psCarrierZonePK=" + psCarrierZonePK + " ]";
    }
    
}
