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
 * @author leo-note
 */
@Embeddable
public class PsProductAttributeLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsProductAttributeLangPK() {
    }

    public PsProductAttributeLangPK(int idProductAttribute, int idLang) {
        this.idProductAttribute = idProductAttribute;
        this.idLang = idLang;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
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
        hash += (int) idProductAttribute;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeLangPK)) {
            return false;
        }
        PsProductAttributeLangPK other = (PsProductAttributeLangPK) object;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductAttributeLangPK[ idProductAttribute=" + idProductAttribute + ", idLang=" + idLang + " ]";
    }
    
}
