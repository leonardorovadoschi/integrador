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
public class PsReassuranceLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_reassurance")
    private int idReassurance;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsReassuranceLangPK() {
    }

    public PsReassuranceLangPK(int idReassurance, int idLang) {
        this.idReassurance = idReassurance;
        this.idLang = idLang;
    }

    public int getIdReassurance() {
        return idReassurance;
    }

    public void setIdReassurance(int idReassurance) {
        this.idReassurance = idReassurance;
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
        hash += (int) idReassurance;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReassuranceLangPK)) {
            return false;
        }
        PsReassuranceLangPK other = (PsReassuranceLangPK) object;
        if (this.idReassurance != other.idReassurance) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReassuranceLangPK[ idReassurance=" + idReassurance + ", idLang=" + idLang + " ]";
    }
    
}
