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
 * @author leo-note
 */
@Entity
@Table(name = "ps_employee_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEmployeeAccount.findAll", query = "SELECT p FROM PsEmployeeAccount p")})
public class PsEmployeeAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee_account")
    private Integer idEmployeeAccount;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "uid")
    private String uid;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsEmployeeAccount() {
    }

    public PsEmployeeAccount(Integer idEmployeeAccount) {
        this.idEmployeeAccount = idEmployeeAccount;
    }

    public PsEmployeeAccount(Integer idEmployeeAccount, int idEmployee, String email, String uid, Date dateAdd, Date dateUpd) {
        this.idEmployeeAccount = idEmployeeAccount;
        this.idEmployee = idEmployee;
        this.email = email;
        this.uid = uid;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdEmployeeAccount() {
        return idEmployeeAccount;
    }

    public void setIdEmployeeAccount(Integer idEmployeeAccount) {
        this.idEmployeeAccount = idEmployeeAccount;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
        hash += (idEmployeeAccount != null ? idEmployeeAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmployeeAccount)) {
            return false;
        }
        PsEmployeeAccount other = (PsEmployeeAccount) object;
        if ((this.idEmployeeAccount == null && other.idEmployeeAccount != null) || (this.idEmployeeAccount != null && !this.idEmployeeAccount.equals(other.idEmployeeAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmployeeAccount[ idEmployeeAccount=" + idEmployeeAccount + " ]";
    }
    
}
