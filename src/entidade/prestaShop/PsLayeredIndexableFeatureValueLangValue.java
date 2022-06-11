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
@Table(name = "ps_layered_indexable_feature_value_lang_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableFeatureValueLangValue.findAll", query = "SELECT p FROM PsLayeredIndexableFeatureValueLangValue p")
    , @NamedQuery(name = "PsLayeredIndexableFeatureValueLangValue.findByIdFeatureValue", query = "SELECT p FROM PsLayeredIndexableFeatureValueLangValue p WHERE p.psLayeredIndexableFeatureValueLangValuePK.idFeatureValue = :idFeatureValue")
    , @NamedQuery(name = "PsLayeredIndexableFeatureValueLangValue.findByIdLang", query = "SELECT p FROM PsLayeredIndexableFeatureValueLangValue p WHERE p.psLayeredIndexableFeatureValueLangValuePK.idLang = :idLang")
    , @NamedQuery(name = "PsLayeredIndexableFeatureValueLangValue.findByUrlName", query = "SELECT p FROM PsLayeredIndexableFeatureValueLangValue p WHERE p.urlName = :urlName")
    , @NamedQuery(name = "PsLayeredIndexableFeatureValueLangValue.findByMetaTitle", query = "SELECT p FROM PsLayeredIndexableFeatureValueLangValue p WHERE p.metaTitle = :metaTitle")})
public class PsLayeredIndexableFeatureValueLangValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredIndexableFeatureValueLangValuePK psLayeredIndexableFeatureValueLangValuePK;
    @Column(name = "url_name")
    private String urlName;
    @Column(name = "meta_title")
    private String metaTitle;

    public PsLayeredIndexableFeatureValueLangValue() {
    }

    public PsLayeredIndexableFeatureValueLangValue(PsLayeredIndexableFeatureValueLangValuePK psLayeredIndexableFeatureValueLangValuePK) {
        this.psLayeredIndexableFeatureValueLangValuePK = psLayeredIndexableFeatureValueLangValuePK;
    }

    public PsLayeredIndexableFeatureValueLangValue(int idFeatureValue, int idLang) {
        this.psLayeredIndexableFeatureValueLangValuePK = new PsLayeredIndexableFeatureValueLangValuePK(idFeatureValue, idLang);
    }

    public PsLayeredIndexableFeatureValueLangValuePK getPsLayeredIndexableFeatureValueLangValuePK() {
        return psLayeredIndexableFeatureValueLangValuePK;
    }

    public void setPsLayeredIndexableFeatureValueLangValuePK(PsLayeredIndexableFeatureValueLangValuePK psLayeredIndexableFeatureValueLangValuePK) {
        this.psLayeredIndexableFeatureValueLangValuePK = psLayeredIndexableFeatureValueLangValuePK;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLayeredIndexableFeatureValueLangValuePK != null ? psLayeredIndexableFeatureValueLangValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableFeatureValueLangValue)) {
            return false;
        }
        PsLayeredIndexableFeatureValueLangValue other = (PsLayeredIndexableFeatureValueLangValue) object;
        if ((this.psLayeredIndexableFeatureValueLangValuePK == null && other.psLayeredIndexableFeatureValueLangValuePK != null) || (this.psLayeredIndexableFeatureValueLangValuePK != null && !this.psLayeredIndexableFeatureValueLangValuePK.equals(other.psLayeredIndexableFeatureValueLangValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableFeatureValueLangValue[ psLayeredIndexableFeatureValueLangValuePK=" + psLayeredIndexableFeatureValueLangValuePK + " ]";
    }
    
}
