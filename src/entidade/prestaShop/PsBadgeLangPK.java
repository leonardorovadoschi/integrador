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
public class PsBadgeLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_badge")
    private int idBadge;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsBadgeLangPK() {
    }

    public PsBadgeLangPK(int idBadge, int idLang) {
        this.idBadge = idBadge;
        this.idLang = idLang;
    }

    public int getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(int idBadge) {
        this.idBadge = idBadge;
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
        hash += (int) idBadge;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBadgeLangPK)) {
            return false;
        }
        PsBadgeLangPK other = (PsBadgeLangPK) object;
        if (this.idBadge != other.idBadge) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsBadgeLangPK[ idBadge=" + idBadge + ", idLang=" + idLang + " ]";
    }
    
}
