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
public class PsPsreassuranceLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_psreassurance")
    private int idPsreassurance;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsPsreassuranceLangPK() {
    }

    public PsPsreassuranceLangPK(int idPsreassurance, int idLang) {
        this.idPsreassurance = idPsreassurance;
        this.idLang = idLang;
    }

    public int getIdPsreassurance() {
        return idPsreassurance;
    }

    public void setIdPsreassurance(int idPsreassurance) {
        this.idPsreassurance = idPsreassurance;
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
        hash += (int) idPsreassurance;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsreassuranceLangPK)) {
            return false;
        }
        PsPsreassuranceLangPK other = (PsPsreassuranceLangPK) object;
        if (this.idPsreassurance != other.idPsreassurance) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsreassuranceLangPK[ idPsreassurance=" + idPsreassurance + ", idLang=" + idLang + " ]";
    }
    
}
