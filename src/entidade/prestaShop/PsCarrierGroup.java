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
@Table(name = "ps_carrier_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrierGroup.findAll", query = "SELECT p FROM PsCarrierGroup p")
    , @NamedQuery(name = "PsCarrierGroup.findByIdCarrier", query = "SELECT p FROM PsCarrierGroup p WHERE p.psCarrierGroupPK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrierGroup.findByIdGroup", query = "SELECT p FROM PsCarrierGroup p WHERE p.psCarrierGroupPK.idGroup = :idGroup")})
public class PsCarrierGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCarrierGroupPK psCarrierGroupPK;

    public PsCarrierGroup() {
    }

    public PsCarrierGroup(PsCarrierGroupPK psCarrierGroupPK) {
        this.psCarrierGroupPK = psCarrierGroupPK;
    }

    public PsCarrierGroup(int idCarrier, int idGroup) {
        this.psCarrierGroupPK = new PsCarrierGroupPK(idCarrier, idGroup);
    }

    public PsCarrierGroupPK getPsCarrierGroupPK() {
        return psCarrierGroupPK;
    }

    public void setPsCarrierGroupPK(PsCarrierGroupPK psCarrierGroupPK) {
        this.psCarrierGroupPK = psCarrierGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCarrierGroupPK != null ? psCarrierGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierGroup)) {
            return false;
        }
        PsCarrierGroup other = (PsCarrierGroup) object;
        if ((this.psCarrierGroupPK == null && other.psCarrierGroupPK != null) || (this.psCarrierGroupPK != null && !this.psCarrierGroupPK.equals(other.psCarrierGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierGroup[ psCarrierGroupPK=" + psCarrierGroupPK + " ]";
    }
    
}
