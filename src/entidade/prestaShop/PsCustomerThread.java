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
@Table(name = "ps_customer_thread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomerThread.findAll", query = "SELECT p FROM PsCustomerThread p")
    , @NamedQuery(name = "PsCustomerThread.findByIdCustomerThread", query = "SELECT p FROM PsCustomerThread p WHERE p.idCustomerThread = :idCustomerThread")
    , @NamedQuery(name = "PsCustomerThread.findByIdShop", query = "SELECT p FROM PsCustomerThread p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsCustomerThread.findByIdLang", query = "SELECT p FROM PsCustomerThread p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsCustomerThread.findByIdContact", query = "SELECT p FROM PsCustomerThread p WHERE p.idContact = :idContact")
    , @NamedQuery(name = "PsCustomerThread.findByIdCustomer", query = "SELECT p FROM PsCustomerThread p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsCustomerThread.findByIdOrder", query = "SELECT p FROM PsCustomerThread p WHERE p.idOrder = :idOrder")
    , @NamedQuery(name = "PsCustomerThread.findByIdProduct", query = "SELECT p FROM PsCustomerThread p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsCustomerThread.findByStatus", query = "SELECT p FROM PsCustomerThread p WHERE p.status = :status")
    , @NamedQuery(name = "PsCustomerThread.findByEmail", query = "SELECT p FROM PsCustomerThread p WHERE p.email = :email")
    , @NamedQuery(name = "PsCustomerThread.findByToken", query = "SELECT p FROM PsCustomerThread p WHERE p.token = :token")
    , @NamedQuery(name = "PsCustomerThread.findByDateAdd", query = "SELECT p FROM PsCustomerThread p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCustomerThread.findByDateUpd", query = "SELECT p FROM PsCustomerThread p WHERE p.dateUpd = :dateUpd")})
public class PsCustomerThread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer_thread")
    private Integer idCustomerThread;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_contact")
    private int idContact;
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsCustomerThread() {
    }

    public PsCustomerThread(Integer idCustomerThread) {
        this.idCustomerThread = idCustomerThread;
    }

    public PsCustomerThread(Integer idCustomerThread, int idShop, int idLang, int idContact, String status, String email, Date dateAdd, Date dateUpd) {
        this.idCustomerThread = idCustomerThread;
        this.idShop = idShop;
        this.idLang = idLang;
        this.idContact = idContact;
        this.status = status;
        this.email = email;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdCustomerThread() {
        return idCustomerThread;
    }

    public void setIdCustomerThread(Integer idCustomerThread) {
        this.idCustomerThread = idCustomerThread;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        hash += (idCustomerThread != null ? idCustomerThread.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomerThread)) {
            return false;
        }
        PsCustomerThread other = (PsCustomerThread) object;
        if ((this.idCustomerThread == null && other.idCustomerThread != null) || (this.idCustomerThread != null && !this.idCustomerThread.equals(other.idCustomerThread))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomerThread[ idCustomerThread=" + idCustomerThread + " ]";
    }
    
}
