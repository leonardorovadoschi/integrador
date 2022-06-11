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
@Table(name = "ps_module_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleCarrier.findAll", query = "SELECT p FROM PsModuleCarrier p")
    , @NamedQuery(name = "PsModuleCarrier.findByIdModule", query = "SELECT p FROM PsModuleCarrier p WHERE p.psModuleCarrierPK.idModule = :idModule")
    , @NamedQuery(name = "PsModuleCarrier.findByIdShop", query = "SELECT p FROM PsModuleCarrier p WHERE p.psModuleCarrierPK.idShop = :idShop")
    , @NamedQuery(name = "PsModuleCarrier.findByIdReference", query = "SELECT p FROM PsModuleCarrier p WHERE p.psModuleCarrierPK.idReference = :idReference")})
public class PsModuleCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleCarrierPK psModuleCarrierPK;

    public PsModuleCarrier() {
    }

    public PsModuleCarrier(PsModuleCarrierPK psModuleCarrierPK) {
        this.psModuleCarrierPK = psModuleCarrierPK;
    }

    public PsModuleCarrier(int idModule, int idShop, int idReference) {
        this.psModuleCarrierPK = new PsModuleCarrierPK(idModule, idShop, idReference);
    }

    public PsModuleCarrierPK getPsModuleCarrierPK() {
        return psModuleCarrierPK;
    }

    public void setPsModuleCarrierPK(PsModuleCarrierPK psModuleCarrierPK) {
        this.psModuleCarrierPK = psModuleCarrierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleCarrierPK != null ? psModuleCarrierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleCarrier)) {
            return false;
        }
        PsModuleCarrier other = (PsModuleCarrier) object;
        if ((this.psModuleCarrierPK == null && other.psModuleCarrierPK != null) || (this.psModuleCarrierPK != null && !this.psModuleCarrierPK.equals(other.psModuleCarrierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleCarrier[ psModuleCarrierPK=" + psModuleCarrierPK + " ]";
    }
    
}
