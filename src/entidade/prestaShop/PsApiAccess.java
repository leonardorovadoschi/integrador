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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_api_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsApiAccess.findAll", query = "SELECT p FROM PsApiAccess p")})
public class PsApiAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_api_access")
    private Integer idApiAccess;
    @Basic(optional = false)
    @Column(name = "id_authorized_application")
    private int idAuthorizedApplication;
    @Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;
    @Basic(optional = false)
    @Column(name = "client_secret")
    private String clientSecret;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Lob
    @Column(name = "scopes")
    private String scopes;

    public PsApiAccess() {
    }

    public PsApiAccess(Integer idApiAccess) {
        this.idApiAccess = idApiAccess;
    }

    public PsApiAccess(Integer idApiAccess, int idAuthorizedApplication, String clientId, String clientSecret, boolean active, String scopes) {
        this.idApiAccess = idApiAccess;
        this.idAuthorizedApplication = idAuthorizedApplication;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.active = active;
        this.scopes = scopes;
    }

    public Integer getIdApiAccess() {
        return idApiAccess;
    }

    public void setIdApiAccess(Integer idApiAccess) {
        this.idApiAccess = idApiAccess;
    }

    public int getIdAuthorizedApplication() {
        return idAuthorizedApplication;
    }

    public void setIdAuthorizedApplication(int idAuthorizedApplication) {
        this.idAuthorizedApplication = idAuthorizedApplication;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApiAccess != null ? idApiAccess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsApiAccess)) {
            return false;
        }
        PsApiAccess other = (PsApiAccess) object;
        if ((this.idApiAccess == null && other.idApiAccess != null) || (this.idApiAccess != null && !this.idApiAccess.equals(other.idApiAccess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsApiAccess[ idApiAccess=" + idApiAccess + " ]";
    }
    
}
