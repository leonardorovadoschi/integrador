/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_slip_detail")

public class PsOrderSlipDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderSlipDetailPK psOrderSlipDetailPK;
    @Basic(optional = false)
    @Column(name = "product_quantity")
    private int productQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unit_price_tax_excl")
    private BigDecimal unitPriceTaxExcl;
    @Column(name = "unit_price_tax_incl")
    private BigDecimal unitPriceTaxIncl;
    @Column(name = "total_price_tax_excl")
    private BigDecimal totalPriceTaxExcl;
    @Column(name = "total_price_tax_incl")
    private BigDecimal totalPriceTaxIncl;
    @Column(name = "amount_tax_excl")
    private BigDecimal amountTaxExcl;
    @Column(name = "amount_tax_incl")
    private BigDecimal amountTaxIncl;

    public PsOrderSlipDetail() {
    }

    public PsOrderSlipDetail(PsOrderSlipDetailPK psOrderSlipDetailPK) {
        this.psOrderSlipDetailPK = psOrderSlipDetailPK;
    }

    public PsOrderSlipDetail(PsOrderSlipDetailPK psOrderSlipDetailPK, int productQuantity) {
        this.psOrderSlipDetailPK = psOrderSlipDetailPK;
        this.productQuantity = productQuantity;
    }

    public PsOrderSlipDetail(int idOrderSlip, int idOrderDetail) {
        this.psOrderSlipDetailPK = new PsOrderSlipDetailPK(idOrderSlip, idOrderDetail);
    }

    public PsOrderSlipDetailPK getPsOrderSlipDetailPK() {
        return psOrderSlipDetailPK;
    }

    public void setPsOrderSlipDetailPK(PsOrderSlipDetailPK psOrderSlipDetailPK) {
        this.psOrderSlipDetailPK = psOrderSlipDetailPK;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getUnitPriceTaxExcl() {
        return unitPriceTaxExcl;
    }

    public void setUnitPriceTaxExcl(BigDecimal unitPriceTaxExcl) {
        this.unitPriceTaxExcl = unitPriceTaxExcl;
    }

    public BigDecimal getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(BigDecimal unitPriceTaxIncl) {
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }

    public BigDecimal getTotalPriceTaxExcl() {
        return totalPriceTaxExcl;
    }

    public void setTotalPriceTaxExcl(BigDecimal totalPriceTaxExcl) {
        this.totalPriceTaxExcl = totalPriceTaxExcl;
    }

    public BigDecimal getTotalPriceTaxIncl() {
        return totalPriceTaxIncl;
    }

    public void setTotalPriceTaxIncl(BigDecimal totalPriceTaxIncl) {
        this.totalPriceTaxIncl = totalPriceTaxIncl;
    }

    public BigDecimal getAmountTaxExcl() {
        return amountTaxExcl;
    }

    public void setAmountTaxExcl(BigDecimal amountTaxExcl) {
        this.amountTaxExcl = amountTaxExcl;
    }

    public BigDecimal getAmountTaxIncl() {
        return amountTaxIncl;
    }

    public void setAmountTaxIncl(BigDecimal amountTaxIncl) {
        this.amountTaxIncl = amountTaxIncl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psOrderSlipDetailPK != null ? psOrderSlipDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderSlipDetail)) {
            return false;
        }
        PsOrderSlipDetail other = (PsOrderSlipDetail) object;
        if ((this.psOrderSlipDetailPK == null && other.psOrderSlipDetailPK != null) || (this.psOrderSlipDetailPK != null && !this.psOrderSlipDetailPK.equals(other.psOrderSlipDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderSlipDetail[ psOrderSlipDetailPK=" + psOrderSlipDetailPK + " ]";
    }
    
}
