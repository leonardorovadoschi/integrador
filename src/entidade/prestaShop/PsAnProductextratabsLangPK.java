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
public class PsAnProductextratabsLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idtab")
    private int idtab;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnProductextratabsLangPK() {
    }

    public PsAnProductextratabsLangPK(int idtab, String idLang) {
        this.idtab = idtab;
        this.idLang = idLang;
    }

    public int getIdtab() {
        return idtab;
    }

    public void setIdtab(int idtab) {
        this.idtab = idtab;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtab;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLangPK)) {
            return false;
        }
        PsAnProductextratabsLangPK other = (PsAnProductextratabsLangPK) object;
        if (this.idtab != other.idtab) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLangPK[ idtab=" + idtab + ", idLang=" + idLang + " ]";
    }
    
}
