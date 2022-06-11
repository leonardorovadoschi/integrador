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
public class PsCarrierTaxRulesGroupShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Basic(optional = false)
    @Column(name = "id_tax_rules_group")
    private int idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCarrierTaxRulesGroupShopPK() {
    }

    public PsCarrierTaxRulesGroupShopPK(int idCarrier, int idTaxRulesGroup, int idShop) {
        this.idCarrier = idCarrier;
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.idShop = idShop;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(int idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
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
        hash += (int) idCarrier;
        hash += (int) idTaxRulesGroup;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierTaxRulesGroupShopPK)) {
            return false;
        }
        PsCarrierTaxRulesGroupShopPK other = (PsCarrierTaxRulesGroupShopPK) object;
        if (this.idCarrier != other.idCarrier) {
            return false;
        }
        if (this.idTaxRulesGroup != other.idTaxRulesGroup) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierTaxRulesGroupShopPK[ idCarrier=" + idCarrier + ", idTaxRulesGroup=" + idTaxRulesGroup + ", idShop=" + idShop + " ]";
    }
    
}
