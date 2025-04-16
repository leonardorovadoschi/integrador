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
public class PsAnblogcatLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private int idAnblogcat;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnblogcatLangPK() {
    }

    public PsAnblogcatLangPK(int idAnblogcat, int idLang) {
        this.idAnblogcat = idAnblogcat;
        this.idLang = idLang;
    }

    public int getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(int idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
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
        hash += (int) idAnblogcat;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogcatLangPK)) {
            return false;
        }
        PsAnblogcatLangPK other = (PsAnblogcatLangPK) object;
        if (this.idAnblogcat != other.idAnblogcat) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogcatLangPK[ idAnblogcat=" + idAnblogcat + ", idLang=" + idLang + " ]";
    }
    
}
