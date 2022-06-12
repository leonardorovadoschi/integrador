/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fazenda
 */
@Embeddable
public class PsCustomPaymentMethodShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_custom_payment_method")
    private int idCustomPaymentMethod;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCustomPaymentMethodShopPK() {
    }

    public PsCustomPaymentMethodShopPK(int idCustomPaymentMethod, int idShop) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
        this.idShop = idShop;
    }

    public int getIdCustomPaymentMethod() {
        return idCustomPaymentMethod;
    }

    public void setIdCustomPaymentMethod(int idCustomPaymentMethod) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomPaymentMethod;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomPaymentMethodShopPK)) {
            return false;
        }
        PsCustomPaymentMethodShopPK other = (PsCustomPaymentMethodShopPK) object;
        if (this.idCustomPaymentMethod != other.idCustomPaymentMethod) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomPaymentMethodShopPK[ idCustomPaymentMethod=" + idCustomPaymentMethod + ", idShop=" + idShop + " ]";
    }
    
}
