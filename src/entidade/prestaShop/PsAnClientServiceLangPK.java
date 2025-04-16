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
 * @author leo-note
 */
@Embeddable
public class PsAnClientServiceLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_client_service")
    private int idClientService;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnClientServiceLangPK() {
    }

    public PsAnClientServiceLangPK(int idClientService, String idLang) {
        this.idClientService = idClientService;
        this.idLang = idLang;
    }

    public int getIdClientService() {
        return idClientService;
    }

    public void setIdClientService(int idClientService) {
        this.idClientService = idClientService;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idClientService;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnClientServiceLangPK)) {
            return false;
        }
        PsAnClientServiceLangPK other = (PsAnClientServiceLangPK) object;
        if (this.idClientService != other.idClientService) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnClientServiceLangPK[ idClientService=" + idClientService + ", idLang=" + idLang + " ]";
    }
    
}
