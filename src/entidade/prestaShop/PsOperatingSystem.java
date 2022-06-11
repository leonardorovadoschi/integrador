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
@Table(name = "ps_operating_system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOperatingSystem.findAll", query = "SELECT p FROM PsOperatingSystem p")
    , @NamedQuery(name = "PsOperatingSystem.findByIdOperatingSystem", query = "SELECT p FROM PsOperatingSystem p WHERE p.idOperatingSystem = :idOperatingSystem")
    , @NamedQuery(name = "PsOperatingSystem.findByName", query = "SELECT p FROM PsOperatingSystem p WHERE p.name = :name")})
public class PsOperatingSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operating_system")
    private Integer idOperatingSystem;
    @Column(name = "name")
    private String name;

    public PsOperatingSystem() {
    }

    public PsOperatingSystem(Integer idOperatingSystem) {
        this.idOperatingSystem = idOperatingSystem;
    }

    public Integer getIdOperatingSystem() {
        return idOperatingSystem;
    }

    public void setIdOperatingSystem(Integer idOperatingSystem) {
        this.idOperatingSystem = idOperatingSystem;
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
        hash += (idOperatingSystem != null ? idOperatingSystem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOperatingSystem)) {
            return false;
        }
        PsOperatingSystem other = (PsOperatingSystem) object;
        if ((this.idOperatingSystem == null && other.idOperatingSystem != null) || (this.idOperatingSystem != null && !this.idOperatingSystem.equals(other.idOperatingSystem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOperatingSystem[ idOperatingSystem=" + idOperatingSystem + " ]";
    }
    
}
