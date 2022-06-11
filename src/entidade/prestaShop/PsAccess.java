/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_access")
public class PsAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAccessPK psAccessPK;

    public PsAccess() {
    }

    public PsAccess(PsAccessPK psAccessPK) {
        this.psAccessPK = psAccessPK;
    }

    public PsAccess(int idProfile, int idAuthorizationRole) {
        this.psAccessPK = new PsAccessPK(idProfile, idAuthorizationRole);
    }

    public PsAccessPK getPsAccessPK() {
        return psAccessPK;
    }

    public void setPsAccessPK(PsAccessPK psAccessPK) {
        this.psAccessPK = psAccessPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAccessPK != null ? psAccessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAccess)) {
            return false;
        }
        PsAccess other = (PsAccess) object;
        if ((this.psAccessPK == null && other.psAccessPK != null) || (this.psAccessPK != null && !this.psAccessPK.equals(other.psAccessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAccess[ psAccessPK=" + psAccessPK + " ]";
    }
    
}
