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
 * @author leo
 */
@Embeddable
public class PsCartCartRulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;

    public PsCartCartRulePK() {
    }

    public PsCartCartRulePK(int idCart, int idCartRule) {
        this.idCart = idCart;
        this.idCartRule = idCartRule;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCart;
        hash += (int) idCartRule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartCartRulePK)) {
            return false;
        }
        PsCartCartRulePK other = (PsCartCartRulePK) object;
        if (this.idCart != other.idCart) {
            return false;
        }
        if (this.idCartRule != other.idCartRule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartCartRulePK[ idCart=" + idCart + ", idCartRule=" + idCartRule + " ]";
    }
    
}
