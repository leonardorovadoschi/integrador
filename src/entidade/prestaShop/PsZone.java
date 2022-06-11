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
@Table(name = "ps_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsZone.findAll", query = "SELECT p FROM PsZone p")
    , @NamedQuery(name = "PsZone.findByIdZone", query = "SELECT p FROM PsZone p WHERE p.idZone = :idZone")
    , @NamedQuery(name = "PsZone.findByName", query = "SELECT p FROM PsZone p WHERE p.name = :name")
    , @NamedQuery(name = "PsZone.findByActive", query = "SELECT p FROM PsZone p WHERE p.active = :active")})
public class PsZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zone")
    private Integer idZone;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsZone() {
    }

    public PsZone(Integer idZone) {
        this.idZone = idZone;
    }

    public PsZone(Integer idZone, String name, boolean active) {
        this.idZone = idZone;
        this.name = name;
        this.active = active;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZone != null ? idZone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsZone)) {
            return false;
        }
        PsZone other = (PsZone) object;
        if ((this.idZone == null && other.idZone != null) || (this.idZone != null && !this.idZone.equals(other.idZone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsZone[ idZone=" + idZone + " ]";
    }
    
}
