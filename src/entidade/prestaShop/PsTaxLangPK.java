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
public class PsTaxLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_tax")
    private int idTax;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsTaxLangPK() {
    }

    public PsTaxLangPK(int idTax, int idLang) {
        this.idTax = idTax;
        this.idLang = idLang;
    }

    public int getIdTax() {
        return idTax;
    }

    public void setIdTax(int idTax) {
        this.idTax = idTax;
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
        hash += (int) idTax;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTaxLangPK)) {
            return false;
        }
        PsTaxLangPK other = (PsTaxLangPK) object;
        if (this.idTax != other.idTax) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTaxLangPK[ idTax=" + idTax + ", idLang=" + idLang + " ]";
    }
    
}
