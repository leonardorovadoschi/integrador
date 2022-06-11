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
public class PsManufacturerLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_manufacturer")
    private int idManufacturer;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsManufacturerLangPK() {
    }

    public PsManufacturerLangPK(int idManufacturer, int idLang) {
        this.idManufacturer = idManufacturer;
        this.idLang = idLang;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
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
        hash += (int) idManufacturer;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsManufacturerLangPK)) {
            return false;
        }
        PsManufacturerLangPK other = (PsManufacturerLangPK) object;
        if (this.idManufacturer != other.idManufacturer) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsManufacturerLangPK[ idManufacturer=" + idManufacturer + ", idLang=" + idLang + " ]";
    }
    
}
