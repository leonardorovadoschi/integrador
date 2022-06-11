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
 * @author leo
 */
@Entity
@Table(name = "ps_webservice_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWebserviceAccount.findAll", query = "SELECT p FROM PsWebserviceAccount p")
    , @NamedQuery(name = "PsWebserviceAccount.findByIdWebserviceAccount", query = "SELECT p FROM PsWebserviceAccount p WHERE p.idWebserviceAccount = :idWebserviceAccount")
    , @NamedQuery(name = "PsWebserviceAccount.findByKey", query = "SELECT p FROM PsWebserviceAccount p WHERE p.key = :key")
    , @NamedQuery(name = "PsWebserviceAccount.findByClassName", query = "SELECT p FROM PsWebserviceAccount p WHERE p.className = :className")
    , @NamedQuery(name = "PsWebserviceAccount.findByIsModule", query = "SELECT p FROM PsWebserviceAccount p WHERE p.isModule = :isModule")
    , @NamedQuery(name = "PsWebserviceAccount.findByModuleName", query = "SELECT p FROM PsWebserviceAccount p WHERE p.moduleName = :moduleName")
    , @NamedQuery(name = "PsWebserviceAccount.findByActive", query = "SELECT p FROM PsWebserviceAccount p WHERE p.active = :active")})
public class PsWebserviceAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_webservice_account")
    private Integer idWebserviceAccount;
    @Basic(optional = false)
    @Column(name = "key")
    private String key;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "class_name")
    private String className;
    @Basic(optional = false)
    @Column(name = "is_module")
    private short isModule;
    @Column(name = "module_name")
    private String moduleName;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;

    public PsWebserviceAccount() {
    }

    public PsWebserviceAccount(Integer idWebserviceAccount) {
        this.idWebserviceAccount = idWebserviceAccount;
    }

    public PsWebserviceAccount(Integer idWebserviceAccount, String key, String className, short isModule, short active) {
        this.idWebserviceAccount = idWebserviceAccount;
        this.key = key;
        this.className = className;
        this.isModule = isModule;
        this.active = active;
    }

    public Integer getIdWebserviceAccount() {
        return idWebserviceAccount;
    }

    public void setIdWebserviceAccount(Integer idWebserviceAccount) {
        this.idWebserviceAccount = idWebserviceAccount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public short getIsModule() {
        return isModule;
    }

    public void setIsModule(short isModule) {
        this.isModule = isModule;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWebserviceAccount != null ? idWebserviceAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWebserviceAccount)) {
            return false;
        }
        PsWebserviceAccount other = (PsWebserviceAccount) object;
        if ((this.idWebserviceAccount == null && other.idWebserviceAccount != null) || (this.idWebserviceAccount != null && !this.idWebserviceAccount.equals(other.idWebserviceAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWebserviceAccount[ idWebserviceAccount=" + idWebserviceAccount + " ]";
    }
    
}
