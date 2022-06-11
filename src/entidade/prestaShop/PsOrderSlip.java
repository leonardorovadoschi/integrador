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
@Table(name = "ps_order_slip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderSlip.findAll", query = "SELECT p FROM PsOrderSlip p")
    , @NamedQuery(name = "PsOrderSlip.findByIdOrderSlip", query = "SELECT p FROM PsOrderSlip p WHERE p.idOrderSlip = :idOrderSlip")
    , @NamedQuery(name = "PsOrderSlip.findByConversionRate", query = "SELECT p FROM PsOrderSlip p WHERE p.conversionRate = :conversionRate")
    , @NamedQuery(name = "PsOrderSlip.findByIdCustomer", query = "SELECT p FROM PsOrderSlip p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsOrderSlip.findByIdOrder", query = "SELECT p FROM PsOrderSlip p WHERE p.idOrder = :idOrder")
    , @NamedQuery(name = "PsOrderSlip.findByTotalProductsTaxExcl", query = "SELECT p FROM PsOrderSlip p WHERE p.totalProductsTaxExcl = :totalProductsTaxExcl")
    , @NamedQuery(name = "PsOrderSlip.findByTotalProductsTaxIncl", query = "SELECT p FROM PsOrderSlip p WHERE p.totalProductsTaxIncl = :totalProductsTaxIncl")
    , @NamedQuery(name = "PsOrderSlip.findByTotalShippingTaxExcl", query = "SELECT p FROM PsOrderSlip p WHERE p.totalShippingTaxExcl = :totalShippingTaxExcl")
    , @NamedQuery(name = "PsOrderSlip.findByTotalShippingTaxIncl", query = "SELECT p FROM PsOrderSlip p WHERE p.totalShippingTaxIncl = :totalShippingTaxIncl")
    , @NamedQuery(name = "PsOrderSlip.findByShippingCost", query = "SELECT p FROM PsOrderSlip p WHERE p.shippingCost = :shippingCost")
    , @NamedQuery(name = "PsOrderSlip.findByAmount", query = "SELECT p FROM PsOrderSlip p WHERE p.amount = :amount")
    , @NamedQuery(name = "PsOrderSlip.findByShippingCostAmount", query = "SELECT p FROM PsOrderSlip p WHERE p.shippingCostAmount = :shippingCostAmount")
    , @NamedQuery(name = "PsOrderSlip.findByPartial", query = "SELECT p FROM PsOrderSlip p WHERE p.partial = :partial")
    , @NamedQuery(name = "PsOrderSlip.findByOrderSlipType", query = "SELECT p FROM PsOrderSlip p WHERE p.orderSlipType = :orderSlipType")
    , @NamedQuery(name = "PsOrderSlip.findByDateAdd", query = "SELECT p FROM PsOrderSlip p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsOrderSlip.findByDateUpd", query = "SELECT p FROM PsOrderSlip p WHERE p.dateUpd = :dateUpd")})
public class PsOrderSlip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_slip")
    private Integer idOrderSlip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Column(name = "total_products_tax_excl")
    private BigDecimal totalProductsTaxExcl;
    @Column(name = "total_products_tax_incl")
    private BigDecimal totalProductsTaxIncl;
    @Column(name = "total_shipping_tax_excl")
    private BigDecimal totalShippingTaxExcl;
    @Column(name = "total_shipping_tax_incl")
    private BigDecimal totalShippingTaxIncl;
    @Basic(optional = false)
    @Column(name = "shipping_cost")
    private short shippingCost;
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "shipping_cost_amount")
    private BigDecimal shippingCostAmount;
    @Basic(optional = false)
    @Column(name = "partial")
    private boolean partial;
    @Basic(optional = false)
    @Column(name = "order_slip_type")
    private boolean orderSlipType;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsOrderSlip() {
    }

    public PsOrderSlip(Integer idOrderSlip) {
        this.idOrderSlip = idOrderSlip;
    }

    public PsOrderSlip(Integer idOrderSlip, BigDecimal conversionRate, int idCustomer, int idOrder, short shippingCost, BigDecimal amount, BigDecimal shippingCostAmount, boolean partial, boolean orderSlipType, Date dateAdd, Date dateUpd) {
        this.idOrderSlip = idOrderSlip;
        this.conversionRate = conversionRate;
        this.idCustomer = idCustomer;
        this.idOrder = idOrder;
        this.shippingCost = shippingCost;
        this.amount = amount;
        this.shippingCostAmount = shippingCostAmount;
        this.partial = partial;
        this.orderSlipType = orderSlipType;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdOrderSlip() {
        return idOrderSlip;
    }

    public void setIdOrderSlip(Integer idOrderSlip) {
        this.idOrderSlip = idOrderSlip;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public BigDecimal getTotalProductsTaxExcl() {
        return totalProductsTaxExcl;
    }

    public void setTotalProductsTaxExcl(BigDecimal totalProductsTaxExcl) {
        this.totalProductsTaxExcl = totalProductsTaxExcl;
    }

    public BigDecimal getTotalProductsTaxIncl() {
        return totalProductsTaxIncl;
    }

    public void setTotalProductsTaxIncl(BigDecimal totalProductsTaxIncl) {
        this.totalProductsTaxIncl = totalProductsTaxIncl;
    }

    public BigDecimal getTotalShippingTaxExcl() {
        return totalShippingTaxExcl;
    }

    public void setTotalShippingTaxExcl(BigDecimal totalShippingTaxExcl) {
        this.totalShippingTaxExcl = totalShippingTaxExcl;
    }

    public BigDecimal getTotalShippingTaxIncl() {
        return totalShippingTaxIncl;
    }

    public void setTotalShippingTaxIncl(BigDecimal totalShippingTaxIncl) {
        this.totalShippingTaxIncl = totalShippingTaxIncl;
    }

    public short getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(short shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getShippingCostAmount() {
        return shippingCostAmount;
    }

    public void setShippingCostAmount(BigDecimal shippingCostAmount) {
        this.shippingCostAmount = shippingCostAmount;
    }

    public boolean getPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public boolean getOrderSlipType() {
        return orderSlipType;
    }

    public void setOrderSlipType(boolean orderSlipType) {
        this.orderSlipType = orderSlipType;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderSlip != null ? idOrderSlip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderSlip)) {
            return false;
        }
        PsOrderSlip other = (PsOrderSlip) object;
        if ((this.idOrderSlip == null && other.idOrderSlip != null) || (this.idOrderSlip != null && !this.idOrderSlip.equals(other.idOrderSlip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderSlip[ idOrderSlip=" + idOrderSlip + " ]";
    }
    
}
