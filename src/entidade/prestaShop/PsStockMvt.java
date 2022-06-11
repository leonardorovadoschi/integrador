/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "ps_stock_mvt")

public class PsStockMvt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stock_mvt")
    private Long idStockMvt;
    @Basic(optional = false)
    @Column(name = "id_stock")
    private int idStock;
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_supply_order")
    private Integer idSupplyOrder;
    @Basic(optional = false)
    @Column(name = "id_stock_mvt_reason")
    private int idStockMvtReason;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @Basic(optional = false)
    @Column(name = "physical_quantity")
    private int physicalQuantity;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "sign")
    private short sign;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_te")
    private BigDecimal priceTe;
    @Column(name = "last_wa")
    private BigDecimal lastWa;
    @Column(name = "current_wa")
    private BigDecimal currentWa;
    @Column(name = "referer")
    private BigInteger referer;

    public PsStockMvt() {
    }

    public PsStockMvt(Long idStockMvt) {
        this.idStockMvt = idStockMvt;
    }

    public PsStockMvt(Long idStockMvt, int idStock, int idStockMvtReason, int idEmployee, int physicalQuantity, Date dateAdd, short sign) {
        this.idStockMvt = idStockMvt;
        this.idStock = idStock;
        this.idStockMvtReason = idStockMvtReason;
        this.idEmployee = idEmployee;
        this.physicalQuantity = physicalQuantity;
        this.dateAdd = dateAdd;
        this.sign = sign;
    }

    public Long getIdStockMvt() {
        return idStockMvt;
    }

    public void setIdStockMvt(Long idStockMvt) {
        this.idStockMvt = idStockMvt;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public void setIdSupplyOrder(Integer idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public int getIdStockMvtReason() {
        return idStockMvtReason;
    }

    public void setIdStockMvtReason(int idStockMvtReason) {
        this.idStockMvtReason = idStockMvtReason;
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

    public int getPhysicalQuantity() {
        return physicalQuantity;
    }

    public void setPhysicalQuantity(int physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public short getSign() {
        return sign;
    }

    public void setSign(short sign) {
        this.sign = sign;
    }

    public BigDecimal getPriceTe() {
        return priceTe;
    }

    public void setPriceTe(BigDecimal priceTe) {
        this.priceTe = priceTe;
    }

    public BigDecimal getLastWa() {
        return lastWa;
    }

    public void setLastWa(BigDecimal lastWa) {
        this.lastWa = lastWa;
    }

    public BigDecimal getCurrentWa() {
        return currentWa;
    }

    public void setCurrentWa(BigDecimal currentWa) {
        this.currentWa = currentWa;
    }

    public BigInteger getReferer() {
        return referer;
    }

    public void setReferer(BigInteger referer) {
        this.referer = referer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStockMvt != null ? idStockMvt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStockMvt)) {
            return false;
        }
        PsStockMvt other = (PsStockMvt) object;
        if ((this.idStockMvt == null && other.idStockMvt != null) || (this.idStockMvt != null && !this.idStockMvt.equals(other.idStockMvt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStockMvt[ idStockMvt=" + idStockMvt + " ]";
    }
    
}
