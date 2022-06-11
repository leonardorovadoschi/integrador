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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_feature_value_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureValueLang.findAll", query = "SELECT p FROM PsFeatureValueLang p")
    , @NamedQuery(name = "PsFeatureValueLang.findByIdFeatureValue", query = "SELECT p FROM PsFeatureValueLang p WHERE p.psFeatureValueLangPK.idFeatureValue = :idFeatureValue")
    , @NamedQuery(name = "PsFeatureValueLang.findByIdLang", query = "SELECT p FROM PsFeatureValueLang p WHERE p.psFeatureValueLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsFeatureValueLang.findByValue", query = "SELECT p FROM PsFeatureValueLang p WHERE p.value = :value")})
public class PsFeatureValueLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsFeatureValueLangPK psFeatureValueLangPK;
    @Column(name = "value")
    private String value;

    public PsFeatureValueLang() {
    }

    public PsFeatureValueLang(PsFeatureValueLangPK psFeatureValueLangPK) {
        this.psFeatureValueLangPK = psFeatureValueLangPK;
    }

    public PsFeatureValueLang(int idFeatureValue, int idLang) {
        this.psFeatureValueLangPK = new PsFeatureValueLangPK(idFeatureValue, idLang);
    }

    public PsFeatureValueLangPK getPsFeatureValueLangPK() {
        return psFeatureValueLangPK;
    }

    public void setPsFeatureValueLangPK(PsFeatureValueLangPK psFeatureValueLangPK) {
        this.psFeatureValueLangPK = psFeatureValueLangPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psFeatureValueLangPK != null ? psFeatureValueLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureValueLang)) {
            return false;
        }
        PsFeatureValueLang other = (PsFeatureValueLang) object;
        if ((this.psFeatureValueLangPK == null && other.psFeatureValueLangPK != null) || (this.psFeatureValueLangPK != null && !this.psFeatureValueLangPK.equals(other.psFeatureValueLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureValueLang[ psFeatureValueLangPK=" + psFeatureValueLangPK + " ]";
    }
    
}
