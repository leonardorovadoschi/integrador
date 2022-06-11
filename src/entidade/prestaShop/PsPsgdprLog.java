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
@Table(name = "ps_psgdpr_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPsgdprLog.findAll", query = "SELECT p FROM PsPsgdprLog p")
    , @NamedQuery(name = "PsPsgdprLog.findByIdGdprLog", query = "SELECT p FROM PsPsgdprLog p WHERE p.idGdprLog = :idGdprLog")
    , @NamedQuery(name = "PsPsgdprLog.findByIdCustomer", query = "SELECT p FROM PsPsgdprLog p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsPsgdprLog.findByIdGuest", query = "SELECT p FROM PsPsgdprLog p WHERE p.idGuest = :idGuest")
    , @NamedQuery(name = "PsPsgdprLog.findByClientName", query = "SELECT p FROM PsPsgdprLog p WHERE p.clientName = :clientName")
    , @NamedQuery(name = "PsPsgdprLog.findByIdModule", query = "SELECT p FROM PsPsgdprLog p WHERE p.idModule = :idModule")
    , @NamedQuery(name = "PsPsgdprLog.findByRequestType", query = "SELECT p FROM PsPsgdprLog p WHERE p.requestType = :requestType")
    , @NamedQuery(name = "PsPsgdprLog.findByDateAdd", query = "SELECT p FROM PsPsgdprLog p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsPsgdprLog.findByDateUpd", query = "SELECT p FROM PsPsgdprLog p WHERE p.dateUpd = :dateUpd")})
public class PsPsgdprLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gdpr_log")
    private Integer idGdprLog;
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "id_guest")
    private Integer idGuest;
    @Column(name = "client_name")
    private String clientName;
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "request_type")
    private int requestType;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsPsgdprLog() {
    }

    public PsPsgdprLog(Integer idGdprLog) {
        this.idGdprLog = idGdprLog;
    }

    public PsPsgdprLog(Integer idGdprLog, int idModule, int requestType, Date dateAdd, Date dateUpd) {
        this.idGdprLog = idGdprLog;
        this.idModule = idModule;
        this.requestType = requestType;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdGdprLog() {
        return idGdprLog;
    }

    public void setIdGdprLog(Integer idGdprLog) {
        this.idGdprLog = idGdprLog;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
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
        hash += (idGdprLog != null ? idGdprLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsgdprLog)) {
            return false;
        }
        PsPsgdprLog other = (PsPsgdprLog) object;
        if ((this.idGdprLog == null && other.idGdprLog != null) || (this.idGdprLog != null && !this.idGdprLog.equals(other.idGdprLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsgdprLog[ idGdprLog=" + idGdprLog + " ]";
    }
    
}
