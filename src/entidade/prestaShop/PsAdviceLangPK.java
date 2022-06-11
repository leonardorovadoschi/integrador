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
public class PsAdviceLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_advice")
    private int idAdvice;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAdviceLangPK() {
    }

    public PsAdviceLangPK(int idAdvice, int idLang) {
        this.idAdvice = idAdvice;
        this.idLang = idLang;
    }

    public int getIdAdvice() {
        return idAdvice;
    }

    public void setIdAdvice(int idAdvice) {
        this.idAdvice = idAdvice;
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
        hash += (int) idAdvice;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAdviceLangPK)) {
            return false;
        }
        PsAdviceLangPK other = (PsAdviceLangPK) object;
        if (this.idAdvice != other.idAdvice) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAdviceLangPK[ idAdvice=" + idAdvice + ", idLang=" + idLang + " ]";
    }
    
}
