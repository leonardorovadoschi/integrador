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
import javax.persistence.Lob;
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
@Table(name = "ps_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAddress.findAll", query = "SELECT p FROM PsAddress p")
    , @NamedQuery(name = "PsAddress.findByIdAddress", query = "SELECT p FROM PsAddress p WHERE p.idAddress = :idAddress")
    , @NamedQuery(name = "PsAddress.findByIdCountry", query = "SELECT p FROM PsAddress p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsAddress.findByIdState", query = "SELECT p FROM PsAddress p WHERE p.idState = :idState")
    , @NamedQuery(name = "PsAddress.findByIdCustomer", query = "SELECT p FROM PsAddress p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsAddress.findByIdManufacturer", query = "SELECT p FROM PsAddress p WHERE p.idManufacturer = :idManufacturer")
    , @NamedQuery(name = "PsAddress.findByIdSupplier", query = "SELECT p FROM PsAddress p WHERE p.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsAddress.findByIdWarehouse", query = "SELECT p FROM PsAddress p WHERE p.idWarehouse = :idWarehouse")
    , @NamedQuery(name = "PsAddress.findByAlias", query = "SELECT p FROM PsAddress p WHERE p.alias = :alias")
    , @NamedQuery(name = "PsAddress.findByCompany", query = "SELECT p FROM PsAddress p WHERE p.company = :company")
    , @NamedQuery(name = "PsAddress.findByLastname", query = "SELECT p FROM PsAddress p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "PsAddress.findByFirstname", query = "SELECT p FROM PsAddress p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "PsAddress.findByAddress1", query = "SELECT p FROM PsAddress p WHERE p.address1 = :address1")
    , @NamedQuery(name = "PsAddress.findByAddress2", query = "SELECT p FROM PsAddress p WHERE p.address2 = :address2")
    , @NamedQuery(name = "PsAddress.findByPostcode", query = "SELECT p FROM PsAddress p WHERE p.postcode = :postcode")
    , @NamedQuery(name = "PsAddress.findByCity", query = "SELECT p FROM PsAddress p WHERE p.city = :city")
    , @NamedQuery(name = "PsAddress.findByPhone", query = "SELECT p FROM PsAddress p WHERE p.phone = :phone")
    , @NamedQuery(name = "PsAddress.findByPhoneMobile", query = "SELECT p FROM PsAddress p WHERE p.phoneMobile = :phoneMobile")
    , @NamedQuery(name = "PsAddress.findByVatNumber", query = "SELECT p FROM PsAddress p WHERE p.vatNumber = :vatNumber")
    , @NamedQuery(name = "PsAddress.findByDni", query = "SELECT p FROM PsAddress p WHERE p.dni = :dni")
    , @NamedQuery(name = "PsAddress.findByDateAdd", query = "SELECT p FROM PsAddress p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsAddress.findByDateUpd", query = "SELECT p FROM PsAddress p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsAddress.findByActive", query = "SELECT p FROM PsAddress p WHERE p.active = :active")
    , @NamedQuery(name = "PsAddress.findByDeleted", query = "SELECT p FROM PsAddress p WHERE p.deleted = :deleted")})
public class PsAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_address")
    private Integer idAddress;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Column(name = "id_state")
    private Integer idState;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_manufacturer")
    private int idManufacturer;
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Lob
    @Column(name = "other")
    private String other;
    @Column(name = "phone")
    private String phone;
    @Column(name = "phone_mobile")
    private String phoneMobile;
    @Column(name = "vat_number")
    private String vatNumber;
    @Column(name = "dni")
    private String dni;
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
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsAddress() {
    }

    public PsAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public PsAddress(Integer idAddress, int idCountry, int idCustomer, int idManufacturer, int idSupplier, int idWarehouse, String alias, String lastname, String firstname, String address1, String city, Date dateAdd, Date dateUpd, boolean active, boolean deleted) {
        this.idAddress = idAddress;
        this.idCountry = idCountry;
        this.idCustomer = idCustomer;
        this.idManufacturer = idManufacturer;
        this.idSupplier = idSupplier;
        this.idWarehouse = idWarehouse;
        this.alias = alias;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address1 = address1;
        this.city = city;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.active = active;
        this.deleted = deleted;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAddress)) {
            return false;
        }
        PsAddress other = (PsAddress) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAddress[ idAddress=" + idAddress + " ]";
    }
    
}
