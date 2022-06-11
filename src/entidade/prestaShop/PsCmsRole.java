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
@Table(name = "ps_cms_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsRole.findAll", query = "SELECT p FROM PsCmsRole p")
    , @NamedQuery(name = "PsCmsRole.findByIdCmsRole", query = "SELECT p FROM PsCmsRole p WHERE p.psCmsRolePK.idCmsRole = :idCmsRole")
    , @NamedQuery(name = "PsCmsRole.findByName", query = "SELECT p FROM PsCmsRole p WHERE p.name = :name")
    , @NamedQuery(name = "PsCmsRole.findByIdCms", query = "SELECT p FROM PsCmsRole p WHERE p.psCmsRolePK.idCms = :idCms")})
public class PsCmsRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsRolePK psCmsRolePK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsCmsRole() {
    }

    public PsCmsRole(PsCmsRolePK psCmsRolePK) {
        this.psCmsRolePK = psCmsRolePK;
    }

    public PsCmsRole(PsCmsRolePK psCmsRolePK, String name) {
        this.psCmsRolePK = psCmsRolePK;
        this.name = name;
    }

    public PsCmsRole(int idCmsRole, int idCms) {
        this.psCmsRolePK = new PsCmsRolePK(idCmsRole, idCms);
    }

    public PsCmsRolePK getPsCmsRolePK() {
        return psCmsRolePK;
    }

    public void setPsCmsRolePK(PsCmsRolePK psCmsRolePK) {
        this.psCmsRolePK = psCmsRolePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCmsRolePK != null ? psCmsRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsRole)) {
            return false;
        }
        PsCmsRole other = (PsCmsRole) object;
        if ((this.psCmsRolePK == null && other.psCmsRolePK != null) || (this.psCmsRolePK != null && !this.psCmsRolePK.equals(other.psCmsRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsRole[ psCmsRolePK=" + psCmsRolePK + " ]";
    }
    
}
