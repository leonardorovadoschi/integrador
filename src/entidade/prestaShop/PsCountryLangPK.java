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
public class PsCountryLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsCountryLangPK() {
    }

    public PsCountryLangPK(int idCountry, int idLang) {
        this.idCountry = idCountry;
        this.idLang = idLang;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
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
        hash += (int) idCountry;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCountryLangPK)) {
            return false;
        }
        PsCountryLangPK other = (PsCountryLangPK) object;
        if (this.idCountry != other.idCountry) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCountryLangPK[ idCountry=" + idCountry + ", idLang=" + idLang + " ]";
    }
    
}
