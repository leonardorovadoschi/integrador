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
public class PsCustomizationFieldLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_customization_field")
    private int idCustomizationField;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCustomizationFieldLangPK() {
    }

    public PsCustomizationFieldLangPK(int idCustomizationField, int idLang, int idShop) {
        this.idCustomizationField = idCustomizationField;
        this.idLang = idLang;
        this.idShop = idShop;
    }

    public int getIdCustomizationField() {
        return idCustomizationField;
    }

    public void setIdCustomizationField(int idCustomizationField) {
        this.idCustomizationField = idCustomizationField;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomizationField;
        hash += (int) idLang;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizationFieldLangPK)) {
            return false;
        }
        PsCustomizationFieldLangPK other = (PsCustomizationFieldLangPK) object;
        if (this.idCustomizationField != other.idCustomizationField) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizationFieldLangPK[ idCustomizationField=" + idCustomizationField + ", idLang=" + idLang + ", idShop=" + idShop + " ]";
    }
    
}
