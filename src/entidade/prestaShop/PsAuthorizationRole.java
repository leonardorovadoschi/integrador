/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_authorization_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAuthorizationRole.findAll", query = "SELECT p FROM PsAuthorizationRole p")
    , @NamedQuery(name = "PsAuthorizationRole.findByIdAuthorizationRole", query = "SELECT p FROM PsAuthorizationRole p WHERE p.idAuthorizationRole = :idAuthorizationRole")
    , @NamedQuery(name = "PsAuthorizationRole.findBySlug", query = "SELECT p FROM PsAuthorizationRole p WHERE p.slug = :slug")})
public class PsAuthorizationRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_authorization_role")
    private Integer idAuthorizationRole;
    @Basic(optional = false)
    @Column(name = "slug")
    private String slug;

    public PsAuthorizationRole() {
    }

    public PsAuthorizationRole(Integer idAuthorizationRole) {
        this.idAuthorizationRole = idAuthorizationRole;
    }

    public PsAuthorizationRole(Integer idAuthorizationRole, String slug) {
        this.idAuthorizationRole = idAuthorizationRole;
        this.slug = slug;
    }

    public Integer getIdAuthorizationRole() {
        return idAuthorizationRole;
    }

    public void setIdAuthorizationRole(Integer idAuthorizationRole) {
        this.idAuthorizationRole = idAuthorizationRole;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthorizationRole != null ? idAuthorizationRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAuthorizationRole)) {
            return false;
        }
        PsAuthorizationRole other = (PsAuthorizationRole) object;
        if ((this.idAuthorizationRole == null && other.idAuthorizationRole != null) || (this.idAuthorizationRole != null && !this.idAuthorizationRole.equals(other.idAuthorizationRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAuthorizationRole[ idAuthorizationRole=" + idAuthorizationRole + " ]";
    }
    
}
