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
@Table(name = "ps_warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWarehouse.findAll", query = "SELECT p FROM PsWarehouse p")
    , @NamedQuery(name = "PsWarehouse.findByIdWarehouse", query = "SELECT p FROM PsWarehouse p WHERE p.idWarehouse = :idWarehouse")
    , @NamedQuery(name = "PsWarehouse.findByIdCurrency", query = "SELECT p FROM PsWarehouse p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsWarehouse.findByIdAddress", query = "SELECT p FROM PsWarehouse p WHERE p.idAddress = :idAddress")
    , @NamedQuery(name = "PsWarehouse.findByIdEmployee", query = "SELECT p FROM PsWarehouse p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsWarehouse.findByReference", query = "SELECT p FROM PsWarehouse p WHERE p.reference = :reference")
    , @NamedQuery(name = "PsWarehouse.findByName", query = "SELECT p FROM PsWarehouse p WHERE p.name = :name")
    , @NamedQuery(name = "PsWarehouse.findByManagementType", query = "SELECT p FROM PsWarehouse p WHERE p.managementType = :managementType")
    , @NamedQuery(name = "PsWarehouse.findByDeleted", query = "SELECT p FROM PsWarehouse p WHERE p.deleted = :deleted")})
public class PsWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_address")
    private int idAddress;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "management_type")
    private String managementType;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsWarehouse() {
    }

    public PsWarehouse(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public PsWarehouse(Integer idWarehouse, int idCurrency, int idAddress, int idEmployee, String name, String managementType, boolean deleted) {
        this.idWarehouse = idWarehouse;
        this.idCurrency = idCurrency;
        this.idAddress = idAddress;
        this.idEmployee = idEmployee;
        this.name = name;
        this.managementType = managementType;
        this.deleted = deleted;
    }

    public Integer getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagementType() {
        return managementType;
    }

    public void setManagementType(String managementType) {
        this.managementType = managementType;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWarehouse != null ? idWarehouse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouse)) {
            return false;
        }
        PsWarehouse other = (PsWarehouse) object;
        if ((this.idWarehouse == null && other.idWarehouse != null) || (this.idWarehouse != null && !this.idWarehouse.equals(other.idWarehouse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouse[ idWarehouse=" + idWarehouse + " ]";
    }
    
}
