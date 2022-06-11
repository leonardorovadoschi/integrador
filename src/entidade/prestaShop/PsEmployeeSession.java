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
@Table(name = "ps_employee_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEmployeeSession.findAll", query = "SELECT p FROM PsEmployeeSession p")
    , @NamedQuery(name = "PsEmployeeSession.findByIdEmployeeSession", query = "SELECT p FROM PsEmployeeSession p WHERE p.idEmployeeSession = :idEmployeeSession")
    , @NamedQuery(name = "PsEmployeeSession.findByIdEmployee", query = "SELECT p FROM PsEmployeeSession p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsEmployeeSession.findByToken", query = "SELECT p FROM PsEmployeeSession p WHERE p.token = :token")})
public class PsEmployeeSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee_session")
    private Integer idEmployeeSession;
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Column(name = "token")
    private String token;

    public PsEmployeeSession() {
    }

    public PsEmployeeSession(Integer idEmployeeSession) {
        this.idEmployeeSession = idEmployeeSession;
    }

    public Integer getIdEmployeeSession() {
        return idEmployeeSession;
    }

    public void setIdEmployeeSession(Integer idEmployeeSession) {
        this.idEmployeeSession = idEmployeeSession;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployeeSession != null ? idEmployeeSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmployeeSession)) {
            return false;
        }
        PsEmployeeSession other = (PsEmployeeSession) object;
        if ((this.idEmployeeSession == null && other.idEmployeeSession != null) || (this.idEmployeeSession != null && !this.idEmployeeSession.equals(other.idEmployeeSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmployeeSession[ idEmployeeSession=" + idEmployeeSession + " ]";
    }
    
}
