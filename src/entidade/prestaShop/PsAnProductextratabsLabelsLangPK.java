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
public class PsAnProductextratabsLabelsLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_label")
    private int idLabel;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnProductextratabsLabelsLangPK() {
    }

    public PsAnProductextratabsLabelsLangPK(int idLabel, String idLang) {
        this.idLabel = idLabel;
        this.idLang = idLang;
    }

    public int getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(int idLabel) {
        this.idLabel = idLabel;
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
        hash += (int) idLabel;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLabelsLangPK)) {
            return false;
        }
        PsAnProductextratabsLabelsLangPK other = (PsAnProductextratabsLabelsLangPK) object;
        if (this.idLabel != other.idLabel) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLabelsLangPK[ idLabel=" + idLabel + ", idLang=" + idLang + " ]";
    }
    
}
