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
@Table(name = "ps_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModule.findAll", query = "SELECT p FROM PsModule p")
    , @NamedQuery(name = "PsModule.findByIdModule", query = "SELECT p FROM PsModule p WHERE p.idModule = :idModule")
    , @NamedQuery(name = "PsModule.findByName", query = "SELECT p FROM PsModule p WHERE p.name = :name")
    , @NamedQuery(name = "PsModule.findByActive", query = "SELECT p FROM PsModule p WHERE p.active = :active")
    , @NamedQuery(name = "PsModule.findByVersion", query = "SELECT p FROM PsModule p WHERE p.version = :version")})
public class PsModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_module")
    private Integer idModule;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "version")
    private String version;

    public PsModule() {
    }

    public PsModule(Integer idModule) {
        this.idModule = idModule;
    }

    public PsModule(Integer idModule, String name, boolean active, String version) {
        this.idModule = idModule;
        this.name = name;
        this.active = active;
        this.version = version;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModule != null ? idModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModule)) {
            return false;
        }
        PsModule other = (PsModule) object;
        if ((this.idModule == null && other.idModule != null) || (this.idModule != null && !this.idModule.equals(other.idModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModule[ idModule=" + idModule + " ]";
    }
    
}
