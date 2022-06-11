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
@Table(name = "ps_webservice_permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWebservicePermission.findAll", query = "SELECT p FROM PsWebservicePermission p")
    , @NamedQuery(name = "PsWebservicePermission.findByIdWebservicePermission", query = "SELECT p FROM PsWebservicePermission p WHERE p.idWebservicePermission = :idWebservicePermission")
    , @NamedQuery(name = "PsWebservicePermission.findByResource", query = "SELECT p FROM PsWebservicePermission p WHERE p.resource = :resource")
    , @NamedQuery(name = "PsWebservicePermission.findByMethod", query = "SELECT p FROM PsWebservicePermission p WHERE p.method = :method")
    , @NamedQuery(name = "PsWebservicePermission.findByIdWebserviceAccount", query = "SELECT p FROM PsWebservicePermission p WHERE p.idWebserviceAccount = :idWebserviceAccount")})
public class PsWebservicePermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_webservice_permission")
    private Integer idWebservicePermission;
    @Basic(optional = false)
    @Column(name = "resource")
    private String resource;
    @Basic(optional = false)
    @Column(name = "method")
    private String method;
    @Basic(optional = false)
    @Column(name = "id_webservice_account")
    private int idWebserviceAccount;

    public PsWebservicePermission() {
    }

    public PsWebservicePermission(Integer idWebservicePermission) {
        this.idWebservicePermission = idWebservicePermission;
    }

    public PsWebservicePermission(Integer idWebservicePermission, String resource, String method, int idWebserviceAccount) {
        this.idWebservicePermission = idWebservicePermission;
        this.resource = resource;
        this.method = method;
        this.idWebserviceAccount = idWebserviceAccount;
    }

    public Integer getIdWebservicePermission() {
        return idWebservicePermission;
    }

    public void setIdWebservicePermission(Integer idWebservicePermission) {
        this.idWebservicePermission = idWebservicePermission;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getIdWebserviceAccount() {
        return idWebserviceAccount;
    }

    public void setIdWebserviceAccount(int idWebserviceAccount) {
        this.idWebserviceAccount = idWebserviceAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWebservicePermission != null ? idWebservicePermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWebservicePermission)) {
            return false;
        }
        PsWebservicePermission other = (PsWebservicePermission) object;
        if ((this.idWebservicePermission == null && other.idWebservicePermission != null) || (this.idWebservicePermission != null && !this.idWebservicePermission.equals(other.idWebservicePermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWebservicePermission[ idWebservicePermission=" + idWebservicePermission + " ]";
    }
    
}
