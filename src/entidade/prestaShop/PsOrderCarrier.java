/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_carrier")

public class PsOrderCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_carrier")
    private Integer idOrderCarrier;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Column(name = "id_order_invoice")
    private Integer idOrderInvoice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private BigDecimal weight;
    @Column(name = "shipping_cost_tax_excl")
    private BigDecimal shippingCostTaxExcl;
    @Column(name = "shipping_cost_tax_incl")
    private BigDecimal shippingCostTaxIncl;
    @Column(name = "tracking_number")
    private String trackingNumber;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsOrderCarrier() {
    }

    public PsOrderCarrier(Integer idOrderCarrier) {
        this.idOrderCarrier = idOrderCarrier;
    }

    public PsOrderCarrier(Integer idOrderCarrier, int idOrder, int idCarrier, Date dateAdd) {
        this.idOrderCarrier = idOrderCarrier;
        this.idOrder = idOrder;
        this.idCarrier = idCarrier;
        this.dateAdd = dateAdd;
    }

    public Integer getIdOrderCarrier() {
        return idOrderCarrier;
    }

    public void setIdOrderCarrier(Integer idOrderCarrier) {
        this.idOrderCarrier = idOrderCarrier;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public Integer getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(Integer idOrderInvoice) {
        this.idOrderInvoice = idOrderInvoice;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getShippingCostTaxExcl() {
        return shippingCostTaxExcl;
    }

    public void setShippingCostTaxExcl(BigDecimal shippingCostTaxExcl) {
        this.shippingCostTaxExcl = shippingCostTaxExcl;
    }

    public BigDecimal getShippingCostTaxIncl() {
        return shippingCostTaxIncl;
    }

    public void setShippingCostTaxIncl(BigDecimal shippingCostTaxIncl) {
        this.shippingCostTaxIncl = shippingCostTaxIncl;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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
        hash += (idOrderCarrier != null ? idOrderCarrier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderCarrier)) {
            return false;
        }
        PsOrderCarrier other = (PsOrderCarrier) object;
        if ((this.idOrderCarrier == null && other.idOrderCarrier != null) || (this.idOrderCarrier != null && !this.idOrderCarrier.equals(other.idOrderCarrier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderCarrier[ idOrderCarrier=" + idOrderCarrier + " ]";
    }
    
}
