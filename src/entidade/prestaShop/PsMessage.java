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
@Table(name = "ps_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMessage.findAll", query = "SELECT p FROM PsMessage p")
    , @NamedQuery(name = "PsMessage.findByIdMessage", query = "SELECT p FROM PsMessage p WHERE p.idMessage = :idMessage")
    , @NamedQuery(name = "PsMessage.findByIdCart", query = "SELECT p FROM PsMessage p WHERE p.idCart = :idCart")
    , @NamedQuery(name = "PsMessage.findByIdCustomer", query = "SELECT p FROM PsMessage p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsMessage.findByIdEmployee", query = "SELECT p FROM PsMessage p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsMessage.findByIdOrder", query = "SELECT p FROM PsMessage p WHERE p.idOrder = :idOrder")
    , @NamedQuery(name = "PsMessage.findByPrivate1", query = "SELECT p FROM PsMessage p WHERE p.private1 = :private1")
    , @NamedQuery(name = "PsMessage.findByDateAdd", query = "SELECT p FROM PsMessage p WHERE p.dateAdd = :dateAdd")})
public class PsMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "id_cart")
    private Integer idCart;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "private")
    private boolean private1;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsMessage() {
    }

    public PsMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public PsMessage(Integer idMessage, int idCustomer, int idOrder, String message, boolean private1, Date dateAdd) {
        this.idMessage = idMessage;
        this.idCustomer = idCustomer;
        this.idOrder = idOrder;
        this.message = message;
        this.private1 = private1;
        this.dateAdd = dateAdd;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getPrivate1() {
        return private1;
    }

    public void setPrivate1(boolean private1) {
        this.private1 = private1;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMessage)) {
            return false;
        }
        PsMessage other = (PsMessage) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMessage[ idMessage=" + idMessage + " ]";
    }
    
}
