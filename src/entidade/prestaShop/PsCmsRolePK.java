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
public class PsCmsRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cms_role")
    private int idCmsRole;
    @Basic(optional = false)
    @Column(name = "id_cms")
    private int idCms;

    public PsCmsRolePK() {
    }

    public PsCmsRolePK(int idCmsRole, int idCms) {
        this.idCmsRole = idCmsRole;
        this.idCms = idCms;
    }

    public int getIdCmsRole() {
        return idCmsRole;
    }

    public void setIdCmsRole(int idCmsRole) {
        this.idCmsRole = idCmsRole;
    }

    public int getIdCms() {
        return idCms;
    }

    public void setIdCms(int idCms) {
        this.idCms = idCms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCmsRole;
        hash += (int) idCms;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsRolePK)) {
            return false;
        }
        PsCmsRolePK other = (PsCmsRolePK) object;
        if (this.idCmsRole != other.idCmsRole) {
            return false;
        }
        if (this.idCms != other.idCms) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsRolePK[ idCmsRole=" + idCmsRole + ", idCms=" + idCms + " ]";
    }
    
}
