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
public class PsHookModulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_hook")
    private int idHook;

    public PsHookModulePK() {
    }

    public PsHookModulePK(int idModule, int idShop, int idHook) {
        this.idModule = idModule;
        this.idShop = idShop;
        this.idHook = idHook;
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

    public int getIdHook() {
        return idHook;
    }

    public void setIdHook(int idHook) {
        this.idHook = idHook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idShop;
        hash += (int) idHook;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHookModulePK)) {
            return false;
        }
        PsHookModulePK other = (PsHookModulePK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idHook != other.idHook) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHookModulePK[ idModule=" + idModule + ", idShop=" + idShop + ", idHook=" + idHook + " ]";
    }
    
}
