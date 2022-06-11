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
public class PsGroupLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsGroupLangPK() {
    }

    public PsGroupLangPK(int idGroup, int idLang) {
        this.idGroup = idGroup;
        this.idLang = idLang;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
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
        hash += (int) idGroup;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroupLangPK)) {
            return false;
        }
        PsGroupLangPK other = (PsGroupLangPK) object;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroupLangPK[ idGroup=" + idGroup + ", idLang=" + idLang + " ]";
    }
    
}
