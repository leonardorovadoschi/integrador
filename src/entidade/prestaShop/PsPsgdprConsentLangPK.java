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
public class PsPsgdprConsentLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_gdpr_consent")
    private int idGdprConsent;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsPsgdprConsentLangPK() {
    }

    public PsPsgdprConsentLangPK(int idGdprConsent, int idLang, int idShop) {
        this.idGdprConsent = idGdprConsent;
        this.idLang = idLang;
        this.idShop = idShop;
    }

    public int getIdGdprConsent() {
        return idGdprConsent;
    }

    public void setIdGdprConsent(int idGdprConsent) {
        this.idGdprConsent = idGdprConsent;
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
        hash += (int) idGdprConsent;
        hash += (int) idLang;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsgdprConsentLangPK)) {
            return false;
        }
        PsPsgdprConsentLangPK other = (PsPsgdprConsentLangPK) object;
        if (this.idGdprConsent != other.idGdprConsent) {
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
        return "entidade.prestaShop.PsPsgdprConsentLangPK[ idGdprConsent=" + idGdprConsent + ", idLang=" + idLang + ", idShop=" + idShop + " ]";
    }
    
}
