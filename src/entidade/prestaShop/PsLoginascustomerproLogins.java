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
 * @author leo-note
 */
@Entity
@Table(name = "ps_loginascustomerpro_logins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLoginascustomerproLogins.findAll", query = "SELECT p FROM PsLoginascustomerproLogins p")})
public class PsLoginascustomerproLogins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private String idEmployee;
    @Basic(optional = false)
    @Column(name = "ip_address")
    private String ipAddress;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private String idCustomer;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;

    public PsLoginascustomerproLogins() {
    }

    public PsLoginascustomerproLogins(Integer id) {
        this.id = id;
    }

    public PsLoginascustomerproLogins(Integer id, String idEmployee, String ipAddress, String idCustomer, String date) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.ipAddress = ipAddress;
        this.idCustomer = idCustomer;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLoginascustomerproLogins)) {
            return false;
        }
        PsLoginascustomerproLogins other = (PsLoginascustomerproLogins) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLoginascustomerproLogins[ id=" + id + " ]";
    }
    
}
