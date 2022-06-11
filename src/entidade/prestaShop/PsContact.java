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
@Table(name = "ps_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsContact.findAll", query = "SELECT p FROM PsContact p")
    , @NamedQuery(name = "PsContact.findByIdContact", query = "SELECT p FROM PsContact p WHERE p.idContact = :idContact")
    , @NamedQuery(name = "PsContact.findByEmail", query = "SELECT p FROM PsContact p WHERE p.email = :email")
    , @NamedQuery(name = "PsContact.findByCustomerService", query = "SELECT p FROM PsContact p WHERE p.customerService = :customerService")
    , @NamedQuery(name = "PsContact.findByPosition", query = "SELECT p FROM PsContact p WHERE p.position = :position")})
public class PsContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contact")
    private Integer idContact;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "customer_service")
    private boolean customerService;
    @Basic(optional = false)
    @Column(name = "position")
    private short position;

    public PsContact() {
    }

    public PsContact(Integer idContact) {
        this.idContact = idContact;
    }

    public PsContact(Integer idContact, String email, boolean customerService, short position) {
        this.idContact = idContact;
        this.email = email;
        this.customerService = customerService;
        this.position = position;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getCustomerService() {
        return customerService;
    }

    public void setCustomerService(boolean customerService) {
        this.customerService = customerService;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContact != null ? idContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsContact)) {
            return false;
        }
        PsContact other = (PsContact) object;
        if ((this.idContact == null && other.idContact != null) || (this.idContact != null && !this.idContact.equals(other.idContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsContact[ idContact=" + idContact + " ]";
    }
    
}
