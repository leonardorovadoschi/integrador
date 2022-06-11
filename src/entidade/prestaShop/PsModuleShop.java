/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ps_module_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleShop.findAll", query = "SELECT p FROM PsModuleShop p")
    , @NamedQuery(name = "PsModuleShop.findByIdModule", query = "SELECT p FROM PsModuleShop p WHERE p.psModuleShopPK.idModule = :idModule")
    , @NamedQuery(name = "PsModuleShop.findByIdShop", query = "SELECT p FROM PsModuleShop p WHERE p.psModuleShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsModuleShop.findByEnableDevice", query = "SELECT p FROM PsModuleShop p WHERE p.enableDevice = :enableDevice")})
public class PsModuleShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleShopPK psModuleShopPK;
    @Basic(optional = false)
    @Column(name = "enable_device")
    private boolean enableDevice;

    public PsModuleShop() {
    }

    public PsModuleShop(PsModuleShopPK psModuleShopPK) {
        this.psModuleShopPK = psModuleShopPK;
    }

    public PsModuleShop(PsModuleShopPK psModuleShopPK, boolean enableDevice) {
        this.psModuleShopPK = psModuleShopPK;
        this.enableDevice = enableDevice;
    }

    public PsModuleShop(int idModule, int idShop) {
        this.psModuleShopPK = new PsModuleShopPK(idModule, idShop);
    }

    public PsModuleShopPK getPsModuleShopPK() {
        return psModuleShopPK;
    }

    public void setPsModuleShopPK(PsModuleShopPK psModuleShopPK) {
        this.psModuleShopPK = psModuleShopPK;
    }

    public boolean getEnableDevice() {
        return enableDevice;
    }

    public void setEnableDevice(boolean enableDevice) {
        this.enableDevice = enableDevice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleShopPK != null ? psModuleShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleShop)) {
            return false;
        }
        PsModuleShop other = (PsModuleShop) object;
        if ((this.psModuleShopPK == null && other.psModuleShopPK != null) || (this.psModuleShopPK != null && !this.psModuleShopPK.equals(other.psModuleShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleShop[ psModuleShopPK=" + psModuleShopPK + " ]";
    }
    
}
