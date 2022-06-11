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
public class PsLayeredIndexableAttributeGroupLangValuePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_attribute_group")
    private int idAttributeGroup;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsLayeredIndexableAttributeGroupLangValuePK() {
    }

    public PsLayeredIndexableAttributeGroupLangValuePK(int idAttributeGroup, int idLang) {
        this.idAttributeGroup = idAttributeGroup;
        this.idLang = idLang;
    }

    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
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
        hash += (int) idAttributeGroup;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableAttributeGroupLangValuePK)) {
            return false;
        }
        PsLayeredIndexableAttributeGroupLangValuePK other = (PsLayeredIndexableAttributeGroupLangValuePK) object;
        if (this.idAttributeGroup != other.idAttributeGroup) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableAttributeGroupLangValuePK[ idAttributeGroup=" + idAttributeGroup + ", idLang=" + idLang + " ]";
    }
    
}
