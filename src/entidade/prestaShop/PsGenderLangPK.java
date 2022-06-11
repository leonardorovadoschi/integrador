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
public class PsGenderLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_gender")
    private int idGender;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsGenderLangPK() {
    }

    public PsGenderLangPK(int idGender, int idLang) {
        this.idGender = idGender;
        this.idLang = idLang;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
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
        hash += (int) idGender;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGenderLangPK)) {
            return false;
        }
        PsGenderLangPK other = (PsGenderLangPK) object;
        if (this.idGender != other.idGender) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGenderLangPK[ idGender=" + idGender + ", idLang=" + idLang + " ]";
    }
    
}
