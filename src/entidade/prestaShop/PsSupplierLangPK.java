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
public class PsSupplierLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsSupplierLangPK() {
    }

    public PsSupplierLangPK(int idSupplier, int idLang) {
        this.idSupplier = idSupplier;
        this.idLang = idLang;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
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
        hash += (int) idSupplier;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplierLangPK)) {
            return false;
        }
        PsSupplierLangPK other = (PsSupplierLangPK) object;
        if (this.idSupplier != other.idSupplier) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplierLangPK[ idSupplier=" + idSupplier + ", idLang=" + idLang + " ]";
    }
    
}
