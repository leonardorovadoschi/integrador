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
public class PsProfileLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_profile")
    private int idProfile;

    public PsProfileLangPK() {
    }

    public PsProfileLangPK(int idLang, int idProfile) {
        this.idLang = idLang;
        this.idProfile = idProfile;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLang;
        hash += (int) idProfile;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProfileLangPK)) {
            return false;
        }
        PsProfileLangPK other = (PsProfileLangPK) object;
        if (this.idLang != other.idLang) {
            return false;
        }
        if (this.idProfile != other.idProfile) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProfileLangPK[ idLang=" + idLang + ", idProfile=" + idProfile + " ]";
    }
    
}
