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
public class PsModuleCurrencyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;

    public PsModuleCurrencyPK() {
    }

    public PsModuleCurrencyPK(int idModule, int idShop, int idCurrency) {
        this.idModule = idModule;
        this.idShop = idShop;
        this.idCurrency = idCurrency;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idShop;
        hash += (int) idCurrency;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleCurrencyPK)) {
            return false;
        }
        PsModuleCurrencyPK other = (PsModuleCurrencyPK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idCurrency != other.idCurrency) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleCurrencyPK[ idModule=" + idModule + ", idShop=" + idShop + ", idCurrency=" + idCurrency + " ]";
    }
    
}
