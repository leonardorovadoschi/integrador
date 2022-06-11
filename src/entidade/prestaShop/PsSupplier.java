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
@Table(name = "ps_supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplier.findAll", query = "SELECT p FROM PsSupplier p")
    , @NamedQuery(name = "PsSupplier.findByIdSupplier", query = "SELECT p FROM PsSupplier p WHERE p.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsSupplier.findByName", query = "SELECT p FROM PsSupplier p WHERE p.name = :name")
    , @NamedQuery(name = "PsSupplier.findByDateAdd", query = "SELECT p FROM PsSupplier p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsSupplier.findByDateUpd", query = "SELECT p FROM PsSupplier p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsSupplier.findByActive", query = "SELECT p FROM PsSupplier p WHERE p.active = :active")})
public class PsSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private Integer idSupplier;
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

    public PsSupplier() {
    }

    public PsSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public PsSupplier(Integer idSupplier, String name, Date dateAdd, Date dateUpd, boolean active) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.active = active;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
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
        hash += (idSupplier != null ? idSupplier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplier)) {
            return false;
        }
        PsSupplier other = (PsSupplier) object;
        if ((this.idSupplier == null && other.idSupplier != null) || (this.idSupplier != null && !this.idSupplier.equals(other.idSupplier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplier[ idSupplier=" + idSupplier + " ]";
    }
    
}
