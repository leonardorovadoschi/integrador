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
public class PsAnmenuLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anmenu")
    private int idAnmenu;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnmenuLangPK() {
    }

    public PsAnmenuLangPK(int idAnmenu, int idLang) {
        this.idAnmenu = idAnmenu;
        this.idLang = idLang;
    }

    public int getIdAnmenu() {
        return idAnmenu;
    }

    public void setIdAnmenu(int idAnmenu) {
        this.idAnmenu = idAnmenu;
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
        hash += (int) idAnmenu;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnmenuLangPK)) {
            return false;
        }
        PsAnmenuLangPK other = (PsAnmenuLangPK) object;
        if (this.idAnmenu != other.idAnmenu) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnmenuLangPK[ idAnmenu=" + idAnmenu + ", idLang=" + idLang + " ]";
    }
    
}
