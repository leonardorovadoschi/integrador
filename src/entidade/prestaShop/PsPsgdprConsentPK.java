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
public class PsPsgdprConsentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_gdpr_consent")
    private int idGdprConsent;
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;

    public PsPsgdprConsentPK() {
    }

    public PsPsgdprConsentPK(int idGdprConsent, int idModule) {
        this.idGdprConsent = idGdprConsent;
        this.idModule = idModule;
    }

    public int getIdGdprConsent() {
        return idGdprConsent;
    }

    public void setIdGdprConsent(int idGdprConsent) {
        this.idGdprConsent = idGdprConsent;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGdprConsent;
        hash += (int) idModule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsgdprConsentPK)) {
            return false;
        }
        PsPsgdprConsentPK other = (PsPsgdprConsentPK) object;
        if (this.idGdprConsent != other.idGdprConsent) {
            return false;
        }
        if (this.idModule != other.idModule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsgdprConsentPK[ idGdprConsent=" + idGdprConsent + ", idModule=" + idModule + " ]";
    }
    
}
