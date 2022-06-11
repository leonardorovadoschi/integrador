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
public class PsMetaLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_meta")
    private int idMeta;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsMetaLangPK() {
    }

    public PsMetaLangPK(int idMeta, int idShop, int idLang) {
        this.idMeta = idMeta;
        this.idShop = idShop;
        this.idLang = idLang;
    }

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash += (int) idMeta;
        hash += (int) idShop;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMetaLangPK)) {
            return false;
        }
        PsMetaLangPK other = (PsMetaLangPK) object;
        if (this.idMeta != other.idMeta) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMetaLangPK[ idMeta=" + idMeta + ", idShop=" + idShop + ", idLang=" + idLang + " ]";
    }
    
}
