/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ps_store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStore.findAll", query = "SELECT p FROM PsStore p")
    , @NamedQuery(name = "PsStore.findByIdStore", query = "SELECT p FROM PsStore p WHERE p.idStore = :idStore")
    , @NamedQuery(name = "PsStore.findByIdCountry", query = "SELECT p FROM PsStore p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsStore.findByIdState", query = "SELECT p FROM PsStore p WHERE p.idState = :idState")
    , @NamedQuery(name = "PsStore.findByCity", query = "SELECT p FROM PsStore p WHERE p.city = :city")
    , @NamedQuery(name = "PsStore.findByPostcode", query = "SELECT p FROM PsStore p WHERE p.postcode = :postcode")
    , @NamedQuery(name = "PsStore.findByLatitude", query = "SELECT p FROM PsStore p WHERE p.latitude = :latitude")
    , @NamedQuery(name = "PsStore.findByLongitude", query = "SELECT p FROM PsStore p WHERE p.longitude = :longitude")
    , @NamedQuery(name = "PsStore.findByPhone", query = "SELECT p FROM PsStore p WHERE p.phone = :phone")
    , @NamedQuery(name = "PsStore.findByFax", query = "SELECT p FROM PsStore p WHERE p.fax = :fax")
    , @NamedQuery(name = "PsStore.findByEmail", query = "SELECT p FROM PsStore p WHERE p.email = :email")
    , @NamedQuery(name = "PsStore.findByActive", query = "SELECT p FROM PsStore p WHERE p.active = :active")
    , @NamedQuery(name = "PsStore.findByDateAdd", query = "SELECT p FROM PsStore p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsStore.findByDateUpd", query = "SELECT p FROM PsStore p WHERE p.dateUpd = :dateUpd")})
public class PsStore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_store")
    private Integer idStore;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Column(name = "id_state")
    private Integer idState;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "postcode")
    private String postcode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsStore() {
    }

    public PsStore(Integer idStore) {
        this.idStore = idStore;
    }

    public PsStore(Integer idStore, int idCountry, String city, String postcode, boolean active, Date dateAdd, Date dateUpd) {
        this.idStore = idStore;
        this.idCountry = idCountry;
        this.city = city;
        this.postcode = postcode;
        this.active = active;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStore != null ? idStore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStore)) {
            return false;
        }
        PsStore other = (PsStore) object;
        if ((this.idStore == null && other.idStore != null) || (this.idStore != null && !this.idStore.equals(other.idStore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStore[ idStore=" + idStore + " ]";
    }
    
}
