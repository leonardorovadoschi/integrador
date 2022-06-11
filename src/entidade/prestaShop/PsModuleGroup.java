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
@Table(name = "ps_module_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleGroup.findAll", query = "SELECT p FROM PsModuleGroup p")
    , @NamedQuery(name = "PsModuleGroup.findByIdModule", query = "SELECT p FROM PsModuleGroup p WHERE p.psModuleGroupPK.idModule = :idModule")
    , @NamedQuery(name = "PsModuleGroup.findByIdShop", query = "SELECT p FROM PsModuleGroup p WHERE p.psModuleGroupPK.idShop = :idShop")
    , @NamedQuery(name = "PsModuleGroup.findByIdGroup", query = "SELECT p FROM PsModuleGroup p WHERE p.psModuleGroupPK.idGroup = :idGroup")})
public class PsModuleGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleGroupPK psModuleGroupPK;

    public PsModuleGroup() {
    }

    public PsModuleGroup(PsModuleGroupPK psModuleGroupPK) {
        this.psModuleGroupPK = psModuleGroupPK;
    }

    public PsModuleGroup(int idModule, int idShop, int idGroup) {
        this.psModuleGroupPK = new PsModuleGroupPK(idModule, idShop, idGroup);
    }

    public PsModuleGroupPK getPsModuleGroupPK() {
        return psModuleGroupPK;
    }

    public void setPsModuleGroupPK(PsModuleGroupPK psModuleGroupPK) {
        this.psModuleGroupPK = psModuleGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleGroupPK != null ? psModuleGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleGroup)) {
            return false;
        }
        PsModuleGroup other = (PsModuleGroup) object;
        if ((this.psModuleGroupPK == null && other.psModuleGroupPK != null) || (this.psModuleGroupPK != null && !this.psModuleGroupPK.equals(other.psModuleGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleGroup[ psModuleGroupPK=" + psModuleGroupPK + " ]";
    }
    
}
