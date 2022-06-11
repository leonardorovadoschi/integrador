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
public class PsOrderReturnStateLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_order_return_state")
    private int idOrderReturnState;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsOrderReturnStateLangPK() {
    }

    public PsOrderReturnStateLangPK(int idOrderReturnState, int idLang) {
        this.idOrderReturnState = idOrderReturnState;
        this.idLang = idLang;
    }

    public int getIdOrderReturnState() {
        return idOrderReturnState;
    }

    public void setIdOrderReturnState(int idOrderReturnState) {
        this.idOrderReturnState = idOrderReturnState;
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
        hash += (int) idOrderReturnState;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderReturnStateLangPK)) {
            return false;
        }
        PsOrderReturnStateLangPK other = (PsOrderReturnStateLangPK) object;
        if (this.idOrderReturnState != other.idOrderReturnState) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderReturnStateLangPK[ idOrderReturnState=" + idOrderReturnState + ", idLang=" + idLang + " ]";
    }
    
}
