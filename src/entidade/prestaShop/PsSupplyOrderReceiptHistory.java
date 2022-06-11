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
@Table(name = "ps_supply_order_receipt_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrderReceiptHistory.findAll", query = "SELECT p FROM PsSupplyOrderReceiptHistory p")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByIdSupplyOrderReceiptHistory", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.idSupplyOrderReceiptHistory = :idSupplyOrderReceiptHistory")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByIdSupplyOrderDetail", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.idSupplyOrderDetail = :idSupplyOrderDetail")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByIdEmployee", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByEmployeeLastname", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.employeeLastname = :employeeLastname")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByEmployeeFirstname", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.employeeFirstname = :employeeFirstname")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByIdSupplyOrderState", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.idSupplyOrderState = :idSupplyOrderState")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByQuantity", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PsSupplyOrderReceiptHistory.findByDateAdd", query = "SELECT p FROM PsSupplyOrderReceiptHistory p WHERE p.dateAdd = :dateAdd")})
public class PsSupplyOrderReceiptHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_supply_order_receipt_history")
    private Integer idSupplyOrderReceiptHistory;
    @Basic(optional = false)
    @Column(name = "id_supply_order_detail")
    private int idSupplyOrderDetail;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @Basic(optional = false)
    @Column(name = "id_supply_order_state")
    private int idSupplyOrderState;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsSupplyOrderReceiptHistory() {
    }

    public PsSupplyOrderReceiptHistory(Integer idSupplyOrderReceiptHistory) {
        this.idSupplyOrderReceiptHistory = idSupplyOrderReceiptHistory;
    }

    public PsSupplyOrderReceiptHistory(Integer idSupplyOrderReceiptHistory, int idSupplyOrderDetail, int idEmployee, int idSupplyOrderState, int quantity, Date dateAdd) {
        this.idSupplyOrderReceiptHistory = idSupplyOrderReceiptHistory;
        this.idSupplyOrderDetail = idSupplyOrderDetail;
        this.idEmployee = idEmployee;
        this.idSupplyOrderState = idSupplyOrderState;
        this.quantity = quantity;
        this.dateAdd = dateAdd;
    }

    public Integer getIdSupplyOrderReceiptHistory() {
        return idSupplyOrderReceiptHistory;
    }

    public void setIdSupplyOrderReceiptHistory(Integer idSupplyOrderReceiptHistory) {
        this.idSupplyOrderReceiptHistory = idSupplyOrderReceiptHistory;
    }

    public int getIdSupplyOrderDetail() {
        return idSupplyOrderDetail;
    }

    public void setIdSupplyOrderDetail(int idSupplyOrderDetail) {
        this.idSupplyOrderDetail = idSupplyOrderDetail;
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

    public int getIdSupplyOrderState() {
        return idSupplyOrderState;
    }

    public void setIdSupplyOrderState(int idSupplyOrderState) {
        this.idSupplyOrderState = idSupplyOrderState;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        hash += (idSupplyOrderReceiptHistory != null ? idSupplyOrderReceiptHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderReceiptHistory)) {
            return false;
        }
        PsSupplyOrderReceiptHistory other = (PsSupplyOrderReceiptHistory) object;
        if ((this.idSupplyOrderReceiptHistory == null && other.idSupplyOrderReceiptHistory != null) || (this.idSupplyOrderReceiptHistory != null && !this.idSupplyOrderReceiptHistory.equals(other.idSupplyOrderReceiptHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderReceiptHistory[ idSupplyOrderReceiptHistory=" + idSupplyOrderReceiptHistory + " ]";
    }
    
}
