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
public class PsSupplyOrderStateLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_supply_order_state")
    private int idSupplyOrderState;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsSupplyOrderStateLangPK() {
    }

    public PsSupplyOrderStateLangPK(int idSupplyOrderState, int idLang) {
        this.idSupplyOrderState = idSupplyOrderState;
        this.idLang = idLang;
    }

    public int getIdSupplyOrderState() {
        return idSupplyOrderState;
    }

    public void setIdSupplyOrderState(int idSupplyOrderState) {
        this.idSupplyOrderState = idSupplyOrderState;
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
        hash += (int) idSupplyOrderState;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderStateLangPK)) {
            return false;
        }
        PsSupplyOrderStateLangPK other = (PsSupplyOrderStateLangPK) object;
        if (this.idSupplyOrderState != other.idSupplyOrderState) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderStateLangPK[ idSupplyOrderState=" + idSupplyOrderState + ", idLang=" + idLang + " ]";
    }
    
}
