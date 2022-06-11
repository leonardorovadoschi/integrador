/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_module_currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleCurrency.findAll", query = "SELECT p FROM PsModuleCurrency p")
    , @NamedQuery(name = "PsModuleCurrency.findByIdModule", query = "SELECT p FROM PsModuleCurrency p WHERE p.psModuleCurrencyPK.idModule = :idModule")
    , @NamedQuery(name = "PsModuleCurrency.findByIdShop", query = "SELECT p FROM PsModuleCurrency p WHERE p.psModuleCurrencyPK.idShop = :idShop")
    , @NamedQuery(name = "PsModuleCurrency.findByIdCurrency", query = "SELECT p FROM PsModuleCurrency p WHERE p.psModuleCurrencyPK.idCurrency = :idCurrency")})
public class PsModuleCurrency implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsModuleCurrencyPK psModuleCurrencyPK;

    public PsModuleCurrency() {
    }

    public PsModuleCurrency(PsModuleCurrencyPK psModuleCurrencyPK) {
        this.psModuleCurrencyPK = psModuleCurrencyPK;
    }

    public PsModuleCurrency(int idModule, int idShop, int idCurrency) {
        this.psModuleCurrencyPK = new PsModuleCurrencyPK(idModule, idShop, idCurrency);
    }

    public PsModuleCurrencyPK getPsModuleCurrencyPK() {
        return psModuleCurrencyPK;
    }

    public void setPsModuleCurrencyPK(PsModuleCurrencyPK psModuleCurrencyPK) {
        this.psModuleCurrencyPK = psModuleCurrencyPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psModuleCurrencyPK != null ? psModuleCurrencyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleCurrency)) {
            return false;
        }
        PsModuleCurrency other = (PsModuleCurrency) object;
        if ((this.psModuleCurrencyPK == null && other.psModuleCurrencyPK != null) || (this.psModuleCurrencyPK != null && !this.psModuleCurrencyPK.equals(other.psModuleCurrencyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleCurrency[ psModuleCurrencyPK=" + psModuleCurrencyPK + " ]";
    }
    
}
