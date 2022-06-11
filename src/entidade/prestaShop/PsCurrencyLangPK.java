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
public class PsCurrencyLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsCurrencyLangPK() {
    }

    public PsCurrencyLangPK(int idCurrency, int idLang) {
        this.idCurrency = idCurrency;
        this.idLang = idLang;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCurrency;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCurrencyLangPK)) {
            return false;
        }
        PsCurrencyLangPK other = (PsCurrencyLangPK) object;
        if (this.idCurrency != other.idCurrency) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCurrencyLangPK[ idCurrency=" + idCurrency + ", idLang=" + idLang + " ]";
    }
    
}
