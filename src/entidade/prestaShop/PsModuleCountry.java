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
@Table(name = "ps_module_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleCountry.findAll", query = "SELECT p FROM PsModuleCountry p")
    , @NamedQuery(name = "PsModuleCountry.findByIdModule", query = "SELECT p FROM PsModuleCountry p WHERE p.psModuleCountryPK.idModule = :idModule")
    , @NamedQuery(name = "PsModuleCountry.findByIdShop", query = "SELECT p FROM PsModuleCountry p WHERE p.psModuleCountryPK.idShop = :idShop")
    , @NamedQuery(name = "PsModuleCountry.findByIdCountry", query = "SELECT p FROM PsModuleCountry p WHERE p.psModuleCountryPK.idCountry = :idCountry")})
public class PsModuleCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleCountryPK psModuleCountryPK;

    public PsModuleCountry() {
    }

    public PsModuleCountry(PsModuleCountryPK psModuleCountryPK) {
        this.psModuleCountryPK = psModuleCountryPK;
    }

    public PsModuleCountry(int idModule, int idShop, int idCountry) {
        this.psModuleCountryPK = new PsModuleCountryPK(idModule, idShop, idCountry);
    }

    public PsModuleCountryPK getPsModuleCountryPK() {
        return psModuleCountryPK;
    }

    public void setPsModuleCountryPK(PsModuleCountryPK psModuleCountryPK) {
        this.psModuleCountryPK = psModuleCountryPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleCountryPK != null ? psModuleCountryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleCountry)) {
            return false;
        }
        PsModuleCountry other = (PsModuleCountry) object;
        if ((this.psModuleCountryPK == null && other.psModuleCountryPK != null) || (this.psModuleCountryPK != null && !this.psModuleCountryPK.equals(other.psModuleCountryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleCountry[ psModuleCountryPK=" + psModuleCountryPK + " ]";
    }
    
}
