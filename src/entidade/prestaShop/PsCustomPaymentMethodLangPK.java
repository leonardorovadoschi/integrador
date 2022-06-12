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
public class PsCustomPaymentMethodLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_custom_payment_method")
    private int idCustomPaymentMethod;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsCustomPaymentMethodLangPK() {
    }

    public PsCustomPaymentMethodLangPK(int idCustomPaymentMethod, int idLang) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
        this.idLang = idLang;
    }

    public int getIdCustomPaymentMethod() {
        return idCustomPaymentMethod;
    }

    public void setIdCustomPaymentMethod(int idCustomPaymentMethod) {
        this.idCustomPaymentMethod = idCustomPaymentMethod;
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
        hash += (int) idCustomPaymentMethod;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomPaymentMethodLangPK)) {
            return false;
        }
        PsCustomPaymentMethodLangPK other = (PsCustomPaymentMethodLangPK) object;
        if (this.idCustomPaymentMethod != other.idCustomPaymentMethod) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomPaymentMethodLangPK[ idCustomPaymentMethod=" + idCustomPaymentMethod + ", idLang=" + idLang + " ]";
    }
    
}
