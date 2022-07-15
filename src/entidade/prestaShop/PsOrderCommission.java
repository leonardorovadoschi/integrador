/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

/**
 *
 * @author Fazenda
 */
public class PsOrderCommission {
    private int idOrder;
    private int idCurrency;
    private double commission;
    private double commissionTaxExcl;
    private double discount;
    private double discountTaxExcl;   

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getCommissionTaxExcl() {
        return commissionTaxExcl;
    }

    public void setCommissionTaxExcl(double commissionTaxExcl) {
        this.commissionTaxExcl = commissionTaxExcl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountTaxExcl() {
        return discountTaxExcl;
    }

    public void setDiscountTaxExcl(double discountTaxExcl) {
        this.discountTaxExcl = discountTaxExcl;
    }
    
    
    
}
