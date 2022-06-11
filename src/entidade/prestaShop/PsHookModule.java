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
@Table(name = "ps_hook_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHookModule.findAll", query = "SELECT p FROM PsHookModule p")
    , @NamedQuery(name = "PsHookModule.findByIdModule", query = "SELECT p FROM PsHookModule p WHERE p.psHookModulePK.idModule = :idModule")
    , @NamedQuery(name = "PsHookModule.findByIdShop", query = "SELECT p FROM PsHookModule p WHERE p.psHookModulePK.idShop = :idShop")
    , @NamedQuery(name = "PsHookModule.findByIdHook", query = "SELECT p FROM PsHookModule p WHERE p.psHookModulePK.idHook = :idHook")
    , @NamedQuery(name = "PsHookModule.findByPosition", query = "SELECT p FROM PsHookModule p WHERE p.position = :position")})
public class PsHookModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsHookModulePK psHookModulePK;
    @Basic(optional = false)
    @Column(name = "position")
    private short position;

    public PsHookModule() {
    }

    public PsHookModule(PsHookModulePK psHookModulePK) {
        this.psHookModulePK = psHookModulePK;
    }

    public PsHookModule(PsHookModulePK psHookModulePK, short position) {
        this.psHookModulePK = psHookModulePK;
        this.position = position;
    }

    public PsHookModule(int idModule, int idShop, int idHook) {
        this.psHookModulePK = new PsHookModulePK(idModule, idShop, idHook);
    }

    public PsHookModulePK getPsHookModulePK() {
        return psHookModulePK;
    }

    public void setPsHookModulePK(PsHookModulePK psHookModulePK) {
        this.psHookModulePK = psHookModulePK;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psHookModulePK != null ? psHookModulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHookModule)) {
            return false;
        }
        PsHookModule other = (PsHookModule) object;
        if ((this.psHookModulePK == null && other.psHookModulePK != null) || (this.psHookModulePK != null && !this.psHookModulePK.equals(other.psHookModulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHookModule[ psHookModulePK=" + psHookModulePK + " ]";
    }
    
}
