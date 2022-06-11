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
public class PsCategoryLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsCategoryLangPK() {
    }

    public PsCategoryLangPK(int idCategory, int idShop, int idLang) {
        this.idCategory = idCategory;
        this.idShop = idShop;
        this.idLang = idLang;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash += (int) idCategory;
        hash += (int) idShop;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryLangPK)) {
            return false;
        }
        PsCategoryLangPK other = (PsCategoryLangPK) object;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryLangPK[ idCategory=" + idCategory + ", idShop=" + idShop + ", idLang=" + idLang + " ]";
    }
    
}
