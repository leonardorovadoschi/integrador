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
public class PsModuleAccessPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_profile")
    private int idProfile;
    @Basic(optional = false)
    @Column(name = "id_authorization_role")
    private int idAuthorizationRole;

    public PsModuleAccessPK() {
    }

    public PsModuleAccessPK(int idProfile, int idAuthorizationRole) {
        this.idProfile = idProfile;
        this.idAuthorizationRole = idAuthorizationRole;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdAuthorizationRole() {
        return idAuthorizationRole;
    }

    public void setIdAuthorizationRole(int idAuthorizationRole) {
        this.idAuthorizationRole = idAuthorizationRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProfile;
        hash += (int) idAuthorizationRole;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleAccessPK)) {
            return false;
        }
        PsModuleAccessPK other = (PsModuleAccessPK) object;
        if (this.idProfile != other.idProfile) {
            return false;
        }
        if (this.idAuthorizationRole != other.idAuthorizationRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleAccessPK[ idProfile=" + idProfile + ", idAuthorizationRole=" + idAuthorizationRole + " ]";
    }
    
}
