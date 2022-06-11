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
public class PsRiskLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_risk")
    private int idRisk;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsRiskLangPK() {
    }

    public PsRiskLangPK(int idRisk, int idLang) {
        this.idRisk = idRisk;
        this.idLang = idLang;
    }

    public int getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(int idRisk) {
        this.idRisk = idRisk;
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
        hash += (int) idRisk;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRiskLangPK)) {
            return false;
        }
        PsRiskLangPK other = (PsRiskLangPK) object;
        if (this.idRisk != other.idRisk) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRiskLangPK[ idRisk=" + idRisk + ", idLang=" + idLang + " ]";
    }
    
}
