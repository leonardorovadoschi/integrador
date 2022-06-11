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
public class PsStockMvtReasonLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_stock_mvt_reason")
    private int idStockMvtReason;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsStockMvtReasonLangPK() {
    }

    public PsStockMvtReasonLangPK(int idStockMvtReason, int idLang) {
        this.idStockMvtReason = idStockMvtReason;
        this.idLang = idLang;
    }

    public int getIdStockMvtReason() {
        return idStockMvtReason;
    }

    public void setIdStockMvtReason(int idStockMvtReason) {
        this.idStockMvtReason = idStockMvtReason;
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
        hash += (int) idStockMvtReason;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStockMvtReasonLangPK)) {
            return false;
        }
        PsStockMvtReasonLangPK other = (PsStockMvtReasonLangPK) object;
        if (this.idStockMvtReason != other.idStockMvtReason) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStockMvtReasonLangPK[ idStockMvtReason=" + idStockMvtReason + ", idLang=" + idLang + " ]";
    }
    
}
