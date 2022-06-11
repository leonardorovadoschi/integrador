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
@Table(name = "ps_customer_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomerMessage.findAll", query = "SELECT p FROM PsCustomerMessage p")
    , @NamedQuery(name = "PsCustomerMessage.findByIdCustomerMessage", query = "SELECT p FROM PsCustomerMessage p WHERE p.idCustomerMessage = :idCustomerMessage")
    , @NamedQuery(name = "PsCustomerMessage.findByIdCustomerThread", query = "SELECT p FROM PsCustomerMessage p WHERE p.idCustomerThread = :idCustomerThread")
    , @NamedQuery(name = "PsCustomerMessage.findByIdEmployee", query = "SELECT p FROM PsCustomerMessage p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsCustomerMessage.findByFileName", query = "SELECT p FROM PsCustomerMessage p WHERE p.fileName = :fileName")
    , @NamedQuery(name = "PsCustomerMessage.findByIpAddress", query = "SELECT p FROM PsCustomerMessage p WHERE p.ipAddress = :ipAddress")
    , @NamedQuery(name = "PsCustomerMessage.findByUserAgent", query = "SELECT p FROM PsCustomerMessage p WHERE p.userAgent = :userAgent")
    , @NamedQuery(name = "PsCustomerMessage.findByDateAdd", query = "SELECT p FROM PsCustomerMessage p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCustomerMessage.findByDateUpd", query = "SELECT p FROM PsCustomerMessage p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsCustomerMessage.findByPrivate1", query = "SELECT p FROM PsCustomerMessage p WHERE p.private1 = :private1")
    , @NamedQuery(name = "PsCustomerMessage.findByRead", query = "SELECT p FROM PsCustomerMessage p WHERE p.read = :read")})
public class PsCustomerMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer_message")
    private Integer idCustomerMessage;
    @Column(name = "id_customer_thread")
    private Integer idCustomerThread;
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "user_agent")
    private String userAgent;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "private")
    private short private1;
    @Basic(optional = false)
    @Column(name = "read")
    private boolean read;

    public PsCustomerMessage() {
    }

    public PsCustomerMessage(Integer idCustomerMessage) {
        this.idCustomerMessage = idCustomerMessage;
    }

    public PsCustomerMessage(Integer idCustomerMessage, String message, Date dateAdd, Date dateUpd, short private1, boolean read) {
        this.idCustomerMessage = idCustomerMessage;
        this.message = message;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.private1 = private1;
        this.read = read;
    }

    public Integer getIdCustomerMessage() {
        return idCustomerMessage;
    }

    public void setIdCustomerMessage(Integer idCustomerMessage) {
        this.idCustomerMessage = idCustomerMessage;
    }

    public Integer getIdCustomerThread() {
        return idCustomerThread;
    }

    public void setIdCustomerThread(Integer idCustomerThread) {
        this.idCustomerThread = idCustomerThread;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

    public short getPrivate1() {
        return private1;
    }

    public void setPrivate1(short private1) {
        this.private1 = private1;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomerMessage != null ? idCustomerMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomerMessage)) {
            return false;
        }
        PsCustomerMessage other = (PsCustomerMessage) object;
        if ((this.idCustomerMessage == null && other.idCustomerMessage != null) || (this.idCustomerMessage != null && !this.idCustomerMessage.equals(other.idCustomerMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomerMessage[ idCustomerMessage=" + idCustomerMessage + " ]";
    }
    
}
