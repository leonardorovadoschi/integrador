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
public class PsCmsLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cms")
    private int idCms;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsCmsLangPK() {
    }

    public PsCmsLangPK(int idCms, int idLang, int idShop) {
        this.idCms = idCms;
        this.idLang = idLang;
        this.idShop = idShop;
    }

    public int getIdCms() {
        return idCms;
    }

    public void setIdCms(int idCms) {
        this.idCms = idCms;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCms;
        hash += (int) idLang;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsLangPK)) {
            return false;
        }
        PsCmsLangPK other = (PsCmsLangPK) object;
        if (this.idCms != other.idCms) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsLangPK[ idCms=" + idCms + ", idLang=" + idLang + ", idShop=" + idShop + " ]";
    }
    
}
