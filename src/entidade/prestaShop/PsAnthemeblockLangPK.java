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
public class PsAnthemeblockLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anthemeblock")
    private int idAnthemeblock;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnthemeblockLangPK() {
    }

    public PsAnthemeblockLangPK(int idAnthemeblock, int idLang) {
        this.idAnthemeblock = idAnthemeblock;
        this.idLang = idLang;
    }

    public int getIdAnthemeblock() {
        return idAnthemeblock;
    }

    public void setIdAnthemeblock(int idAnthemeblock) {
        this.idAnthemeblock = idAnthemeblock;
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
        hash += (int) idAnthemeblock;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockLangPK)) {
            return false;
        }
        PsAnthemeblockLangPK other = (PsAnthemeblockLangPK) object;
        if (this.idAnthemeblock != other.idAnthemeblock) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockLangPK[ idAnthemeblock=" + idAnthemeblock + ", idLang=" + idLang + " ]";
    }
    
}
