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
@Table(name = "ps_supply_order_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrderHistory.findAll", query = "SELECT p FROM PsSupplyOrderHistory p")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByIdSupplyOrderHistory", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.idSupplyOrderHistory = :idSupplyOrderHistory")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByIdSupplyOrder", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.idSupplyOrder = :idSupplyOrder")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByIdEmployee", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByEmployeeLastname", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.employeeLastname = :employeeLastname")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByEmployeeFirstname", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.employeeFirstname = :employeeFirstname")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByIdState", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.idState = :idState")
    , @NamedQuery(name = "PsSupplyOrderHistory.findByDateAdd", query = "SELECT p FROM PsSupplyOrderHistory p WHERE p.dateAdd = :dateAdd")})
public class PsSupplyOrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supply_order_history")
    private Integer idSupplyOrderHistory;
    @Basic(optional = false)
    @Column(name = "id_supply_order")
    private int idSupplyOrder;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @Basic(optional = false)
    @Column(name = "id_state")
    private int idState;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsSupplyOrderHistory() {
    }

    public PsSupplyOrderHistory(Integer idSupplyOrderHistory) {
        this.idSupplyOrderHistory = idSupplyOrderHistory;
    }

    public PsSupplyOrderHistory(Integer idSupplyOrderHistory, int idSupplyOrder, int idEmployee, int idState, Date dateAdd) {
        this.idSupplyOrderHistory = idSupplyOrderHistory;
        this.idSupplyOrder = idSupplyOrder;
        this.idEmployee = idEmployee;
        this.idState = idState;
        this.dateAdd = dateAdd;
    }

    public Integer getIdSupplyOrderHistory() {
        return idSupplyOrderHistory;
    }

    public void setIdSupplyOrderHistory(Integer idSupplyOrderHistory) {
        this.idSupplyOrderHistory = idSupplyOrderHistory;
    }

    public int getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public void setIdSupplyOrder(int idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
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
        hash += (idSupplyOrderHistory != null ? idSupplyOrderHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderHistory)) {
            return false;
        }
        PsSupplyOrderHistory other = (PsSupplyOrderHistory) object;
        if ((this.idSupplyOrderHistory == null && other.idSupplyOrderHistory != null) || (this.idSupplyOrderHistory != null && !this.idSupplyOrderHistory.equals(other.idSupplyOrderHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderHistory[ idSupplyOrderHistory=" + idSupplyOrderHistory + " ]";
    }
    
}
