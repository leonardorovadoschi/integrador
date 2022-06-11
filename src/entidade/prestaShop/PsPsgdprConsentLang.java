/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_psgdpr_consent_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPsgdprConsentLang.findAll", query = "SELECT p FROM PsPsgdprConsentLang p")
    , @NamedQuery(name = "PsPsgdprConsentLang.findByIdGdprConsent", query = "SELECT p FROM PsPsgdprConsentLang p WHERE p.psPsgdprConsentLangPK.idGdprConsent = :idGdprConsent")
    , @NamedQuery(name = "PsPsgdprConsentLang.findByIdLang", query = "SELECT p FROM PsPsgdprConsentLang p WHERE p.psPsgdprConsentLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsPsgdprConsentLang.findByIdShop", query = "SELECT p FROM PsPsgdprConsentLang p WHERE p.psPsgdprConsentLangPK.idShop = :idShop")})
public class PsPsgdprConsentLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPsgdprConsentLangPK psPsgdprConsentLangPK;
    @Lob
    @Column(name = "message")
    private String message;

    public PsPsgdprConsentLang() {
    }

    public PsPsgdprConsentLang(PsPsgdprConsentLangPK psPsgdprConsentLangPK) {
        this.psPsgdprConsentLangPK = psPsgdprConsentLangPK;
    }

    public PsPsgdprConsentLang(int idGdprConsent, int idLang, int idShop) {
        this.psPsgdprConsentLangPK = new PsPsgdprConsentLangPK(idGdprConsent, idLang, idShop);
    }

    public PsPsgdprConsentLangPK getPsPsgdprConsentLangPK() {
        return psPsgdprConsentLangPK;
    }

    public void setPsPsgdprConsentLangPK(PsPsgdprConsentLangPK psPsgdprConsentLangPK) {
        this.psPsgdprConsentLangPK = psPsgdprConsentLangPK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPsgdprConsentLangPK != null ? psPsgdprConsentLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsgdprConsentLang)) {
            return false;
        }
        PsPsgdprConsentLang other = (PsPsgdprConsentLang) object;
        if ((this.psPsgdprConsentLangPK == null && other.psPsgdprConsentLangPK != null) || (this.psPsgdprConsentLangPK != null && !this.psPsgdprConsentLangPK.equals(other.psPsgdprConsentLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsgdprConsentLang[ psPsgdprConsentLangPK=" + psPsgdprConsentLangPK + " ]";
    }
    
}
