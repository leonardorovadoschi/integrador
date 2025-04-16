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
public class PsAnthemeblockDataLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anthemeblock_data")
    private int idAnthemeblockData;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnthemeblockDataLangPK() {
    }

    public PsAnthemeblockDataLangPK(int idAnthemeblockData, int idLang) {
        this.idAnthemeblockData = idAnthemeblockData;
        this.idLang = idLang;
    }

    public int getIdAnthemeblockData() {
        return idAnthemeblockData;
    }

    public void setIdAnthemeblockData(int idAnthemeblockData) {
        this.idAnthemeblockData = idAnthemeblockData;
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
        hash += (int) idAnthemeblockData;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockDataLangPK)) {
            return false;
        }
        PsAnthemeblockDataLangPK other = (PsAnthemeblockDataLangPK) object;
        if (this.idAnthemeblockData != other.idAnthemeblockData) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockDataLangPK[ idAnthemeblockData=" + idAnthemeblockData + ", idLang=" + idLang + " ]";
    }
    
}
