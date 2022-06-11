/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_manufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsManufacturer.findAll", query = "SELECT p FROM PsManufacturer p")
    , @NamedQuery(name = "PsManufacturer.findByIdManufacturer", query = "SELECT p FROM PsManufacturer p WHERE p.idManufacturer = :idManufacturer")
    , @NamedQuery(name = "PsManufacturer.findByName", query = "SELECT p FROM PsManufacturer p WHERE p.name = :name")
    , @NamedQuery(name = "PsManufacturer.findByDateAdd", query = "SELECT p FROM PsManufacturer p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsManufacturer.findByDateUpd", query = "SELECT p FROM PsManufacturer p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsManufacturer.findByActive", query = "SELECT p FROM PsManufacturer p WHERE p.active = :active")})
public class PsManufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_manufacturer")
    private Integer idManufacturer;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsManufacturer() {
    }

    public PsManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public PsManufacturer(Integer idManufacturer, String name, Date dateAdd, Date dateUpd, boolean active) {
        this.idManufacturer = idManufacturer;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.active = active;
    }

    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
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
        hash += (idManufacturer != null ? idManufacturer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsManufacturer)) {
            return false;
        }
        PsManufacturer other = (PsManufacturer) object;
        if ((this.idManufacturer == null && other.idManufacturer != null) || (this.idManufacturer != null && !this.idManufacturer.equals(other.idManufacturer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsManufacturer[ idManufacturer=" + idManufacturer + " ]";
    }
    
}
