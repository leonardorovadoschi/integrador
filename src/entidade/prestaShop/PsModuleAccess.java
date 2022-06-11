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
@Table(name = "ps_module_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleAccess.findAll", query = "SELECT p FROM PsModuleAccess p")
    , @NamedQuery(name = "PsModuleAccess.findByIdProfile", query = "SELECT p FROM PsModuleAccess p WHERE p.psModuleAccessPK.idProfile = :idProfile")
    , @NamedQuery(name = "PsModuleAccess.findByIdAuthorizationRole", query = "SELECT p FROM PsModuleAccess p WHERE p.psModuleAccessPK.idAuthorizationRole = :idAuthorizationRole")})
public class PsModuleAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleAccessPK psModuleAccessPK;

    public PsModuleAccess() {
    }

    public PsModuleAccess(PsModuleAccessPK psModuleAccessPK) {
        this.psModuleAccessPK = psModuleAccessPK;
    }

    public PsModuleAccess(int idProfile, int idAuthorizationRole) {
        this.psModuleAccessPK = new PsModuleAccessPK(idProfile, idAuthorizationRole);
    }

    public PsModuleAccessPK getPsModuleAccessPK() {
        return psModuleAccessPK;
    }

    public void setPsModuleAccessPK(PsModuleAccessPK psModuleAccessPK) {
        this.psModuleAccessPK = psModuleAccessPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleAccessPK != null ? psModuleAccessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleAccess)) {
            return false;
        }
        PsModuleAccess other = (PsModuleAccess) object;
        if ((this.psModuleAccessPK == null && other.psModuleAccessPK != null) || (this.psModuleAccessPK != null && !this.psModuleAccessPK.equals(other.psModuleAccessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleAccess[ psModuleAccessPK=" + psModuleAccessPK + " ]";
    }
    
}
