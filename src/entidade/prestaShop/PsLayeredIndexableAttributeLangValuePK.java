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
public class PsLayeredIndexableAttributeLangValuePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_attribute")
    private int idAttribute;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsLayeredIndexableAttributeLangValuePK() {
    }

    public PsLayeredIndexableAttributeLangValuePK(int idAttribute, int idLang) {
        this.idAttribute = idAttribute;
        this.idLang = idLang;
    }

    public int getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
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
        hash += (int) idAttribute;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableAttributeLangValuePK)) {
            return false;
        }
        PsLayeredIndexableAttributeLangValuePK other = (PsLayeredIndexableAttributeLangValuePK) object;
        if (this.idAttribute != other.idAttribute) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableAttributeLangValuePK[ idAttribute=" + idAttribute + ", idLang=" + idLang + " ]";
    }
    
}
