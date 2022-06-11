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
public class PsStoreLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_store")
    private int idStore;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsStoreLangPK() {
    }

    public PsStoreLangPK(int idStore, int idLang) {
        this.idStore = idStore;
        this.idLang = idLang;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
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
        hash += (int) idStore;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStoreLangPK)) {
            return false;
        }
        PsStoreLangPK other = (PsStoreLangPK) object;
        if (this.idStore != other.idStore) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStoreLangPK[ idStore=" + idStore + ", idLang=" + idLang + " ]";
    }
    
}
