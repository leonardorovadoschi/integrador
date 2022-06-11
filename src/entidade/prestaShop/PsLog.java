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
@Table(name = "ps_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLog.findAll", query = "SELECT p FROM PsLog p")
    , @NamedQuery(name = "PsLog.findByIdLog", query = "SELECT p FROM PsLog p WHERE p.idLog = :idLog")
    , @NamedQuery(name = "PsLog.findBySeverity", query = "SELECT p FROM PsLog p WHERE p.severity = :severity")
    , @NamedQuery(name = "PsLog.findByErrorCode", query = "SELECT p FROM PsLog p WHERE p.errorCode = :errorCode")
    , @NamedQuery(name = "PsLog.findByObjectType", query = "SELECT p FROM PsLog p WHERE p.objectType = :objectType")
    , @NamedQuery(name = "PsLog.findByObjectId", query = "SELECT p FROM PsLog p WHERE p.objectId = :objectId")
    , @NamedQuery(name = "PsLog.findByIdEmployee", query = "SELECT p FROM PsLog p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsLog.findByDateAdd", query = "SELECT p FROM PsLog p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsLog.findByDateUpd", query = "SELECT p FROM PsLog p WHERE p.dateUpd = :dateUpd")})
public class PsLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;
    @Basic(optional = false)
    @Column(name = "severity")
    private boolean severity;
    @Column(name = "error_code")
    private Integer errorCode;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "object_type")
    private String objectType;
    @Column(name = "object_id")
    private Integer objectId;
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsLog() {
    }

    public PsLog(Integer idLog) {
        this.idLog = idLog;
    }

    public PsLog(Integer idLog, boolean severity, String message, Date dateAdd, Date dateUpd) {
        this.idLog = idLog;
        this.severity = severity;
        this.message = message;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public boolean getSeverity() {
        return severity;
    }

    public void setSeverity(boolean severity) {
        this.severity = severity;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
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
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLog)) {
            return false;
        }
        PsLog other = (PsLog) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLog[ idLog=" + idLog + " ]";
    }
    
}
