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
public class PsFeatureValueLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_feature_value")
    private int idFeatureValue;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsFeatureValueLangPK() {
    }

    public PsFeatureValueLangPK(int idFeatureValue, int idLang) {
        this.idFeatureValue = idFeatureValue;
        this.idLang = idLang;
    }

    public int getIdFeatureValue() {
        return idFeatureValue;
    }

    public void setIdFeatureValue(int idFeatureValue) {
        this.idFeatureValue = idFeatureValue;
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
        hash += (int) idFeatureValue;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureValueLangPK)) {
            return false;
        }
        PsFeatureValueLangPK other = (PsFeatureValueLangPK) object;
        if (this.idFeatureValue != other.idFeatureValue) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureValueLangPK[ idFeatureValue=" + idFeatureValue + ", idLang=" + idLang + " ]";
    }
    
}
