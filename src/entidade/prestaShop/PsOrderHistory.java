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
@Table(name = "ps_order_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderHistory.findAll", query = "SELECT p FROM PsOrderHistory p")
    , @NamedQuery(name = "PsOrderHistory.findByIdOrderHistory", query = "SELECT p FROM PsOrderHistory p WHERE p.idOrderHistory = :idOrderHistory")
    , @NamedQuery(name = "PsOrderHistory.findByIdEmployee", query = "SELECT p FROM PsOrderHistory p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsOrderHistory.findByIdOrder", query = "SELECT p FROM PsOrderHistory p WHERE p.idOrder = :idOrder")
    , @NamedQuery(name = "PsOrderHistory.findByIdOrderState", query = "SELECT p FROM PsOrderHistory p WHERE p.idOrderState = :idOrderState")
    , @NamedQuery(name = "PsOrderHistory.findByDateAdd", query = "SELECT p FROM PsOrderHistory p WHERE p.dateAdd = :dateAdd")})
public class PsOrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_history")
    private Integer idOrderHistory;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @Column(name = "id_order_state")
    private int idOrderState;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsOrderHistory() {
    }

    public PsOrderHistory(Integer idOrderHistory) {
        this.idOrderHistory = idOrderHistory;
    }

    public PsOrderHistory(Integer idOrderHistory, int idEmployee, int idOrder, int idOrderState, Date dateAdd) {
        this.idOrderHistory = idOrderHistory;
        this.idEmployee = idEmployee;
        this.idOrder = idOrder;
        this.idOrderState = idOrderState;
        this.dateAdd = dateAdd;
    }

    public Integer getIdOrderHistory() {
        return idOrderHistory;
    }

    public void setIdOrderHistory(Integer idOrderHistory) {
        this.idOrderHistory = idOrderHistory;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(int idOrderState) {
        this.idOrderState = idOrderState;
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
        hash += (idOrderHistory != null ? idOrderHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderHistory)) {
            return false;
        }
        PsOrderHistory other = (PsOrderHistory) object;
        if ((this.idOrderHistory == null && other.idOrderHistory != null) || (this.idOrderHistory != null && !this.idOrderHistory.equals(other.idOrderHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderHistory[ idOrderHistory=" + idOrderHistory + " ]";
    }
    
}
