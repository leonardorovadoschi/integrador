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
public class PsLayeredIndexableFeatureLangValuePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_feature")
    private int idFeature;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsLayeredIndexableFeatureLangValuePK() {
    }

    public PsLayeredIndexableFeatureLangValuePK(int idFeature, int idLang) {
        this.idFeature = idFeature;
        this.idLang = idLang;
    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
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
        hash += (int) idFeature;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableFeatureLangValuePK)) {
            return false;
        }
        PsLayeredIndexableFeatureLangValuePK other = (PsLayeredIndexableFeatureLangValuePK) object;
        if (this.idFeature != other.idFeature) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableFeatureLangValuePK[ idFeature=" + idFeature + ", idLang=" + idLang + " ]";
    }
    
}
