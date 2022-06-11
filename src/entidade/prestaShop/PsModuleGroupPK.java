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
public class PsModuleGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;

    public PsModuleGroupPK() {
    }

    public PsModuleGroupPK(int idModule, int idShop, int idGroup) {
        this.idModule = idModule;
        this.idShop = idShop;
        this.idGroup = idGroup;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idShop;
        hash += (int) idGroup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleGroupPK)) {
            return false;
        }
        PsModuleGroupPK other = (PsModuleGroupPK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleGroupPK[ idModule=" + idModule + ", idShop=" + idShop + ", idGroup=" + idGroup + " ]";
    }
    
}
