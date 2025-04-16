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
@Table(name = "ps_authorized_application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAuthorizedApplication.findAll", query = "SELECT p FROM PsAuthorizedApplication p")})
public class PsAuthorizedApplication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_authorized_application")
    private Integer idAuthorizedApplication;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;

    public PsAuthorizedApplication() {
    }

    public PsAuthorizedApplication(Integer idAuthorizedApplication) {
        this.idAuthorizedApplication = idAuthorizedApplication;
    }

    public PsAuthorizedApplication(Integer idAuthorizedApplication, String name, String description) {
        this.idAuthorizedApplication = idAuthorizedApplication;
        this.name = name;
        this.description = description;
    }

    public Integer getIdAuthorizedApplication() {
        return idAuthorizedApplication;
    }

    public void setIdAuthorizedApplication(Integer idAuthorizedApplication) {
        this.idAuthorizedApplication = idAuthorizedApplication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthorizedApplication != null ? idAuthorizedApplication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAuthorizedApplication)) {
            return false;
        }
        PsAuthorizedApplication other = (PsAuthorizedApplication) object;
        if ((this.idAuthorizedApplication == null && other.idAuthorizedApplication != null) || (this.idAuthorizedApplication != null && !this.idAuthorizedApplication.equals(other.idAuthorizedApplication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAuthorizedApplication[ idAuthorizedApplication=" + idAuthorizedApplication + " ]";
    }
    
}
