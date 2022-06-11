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
@Table(name = "ps_customer_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomerSession.findAll", query = "SELECT p FROM PsCustomerSession p")
    , @NamedQuery(name = "PsCustomerSession.findByIdCustomerSession", query = "SELECT p FROM PsCustomerSession p WHERE p.idCustomerSession = :idCustomerSession")
    , @NamedQuery(name = "PsCustomerSession.findByIdCustomer", query = "SELECT p FROM PsCustomerSession p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsCustomerSession.findByToken", query = "SELECT p FROM PsCustomerSession p WHERE p.token = :token")})
public class PsCustomerSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer_session")
    private Integer idCustomerSession;
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "token")
    private String token;

    public PsCustomerSession() {
    }

    public PsCustomerSession(Integer idCustomerSession) {
        this.idCustomerSession = idCustomerSession;
    }

    public Integer getIdCustomerSession() {
        return idCustomerSession;
    }

    public void setIdCustomerSession(Integer idCustomerSession) {
        this.idCustomerSession = idCustomerSession;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
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
        hash += (idCustomerSession != null ? idCustomerSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomerSession)) {
            return false;
        }
        PsCustomerSession other = (PsCustomerSession) object;
        if ((this.idCustomerSession == null && other.idCustomerSession != null) || (this.idCustomerSession != null && !this.idCustomerSession.equals(other.idCustomerSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomerSession[ idCustomerSession=" + idCustomerSession + " ]";
    }
    
}
