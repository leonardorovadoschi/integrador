/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "ps_layered_indexable_feature_lang_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableFeatureLangValue.findAll", query = "SELECT p FROM PsLayeredIndexableFeatureLangValue p")
    , @NamedQuery(name = "PsLayeredIndexableFeatureLangValue.findByIdFeature", query = "SELECT p FROM PsLayeredIndexableFeatureLangValue p WHERE p.psLayeredIndexableFeatureLangValuePK.idFeature = :idFeature")
    , @NamedQuery(name = "PsLayeredIndexableFeatureLangValue.findByIdLang", query = "SELECT p FROM PsLayeredIndexableFeatureLangValue p WHERE p.psLayeredIndexableFeatureLangValuePK.idLang = :idLang")
    , @NamedQuery(name = "PsLayeredIndexableFeatureLangValue.findByUrlName", query = "SELECT p FROM PsLayeredIndexableFeatureLangValue p WHERE p.urlName = :urlName")
    , @NamedQuery(name = "PsLayeredIndexableFeatureLangValue.findByMetaTitle", query = "SELECT p FROM PsLayeredIndexableFeatureLangValue p WHERE p.metaTitle = :metaTitle")})
public class PsLayeredIndexableFeatureLangValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredIndexableFeatureLangValuePK psLayeredIndexableFeatureLangValuePK;
    @Basic(optional = false)
    @Column(name = "url_name")
    private String urlName;
    @Column(name = "meta_title")
    private String metaTitle;

    public PsLayeredIndexableFeatureLangValue() {
    }

    public PsLayeredIndexableFeatureLangValue(PsLayeredIndexableFeatureLangValuePK psLayeredIndexableFeatureLangValuePK) {
        this.psLayeredIndexableFeatureLangValuePK = psLayeredIndexableFeatureLangValuePK;
    }

    public PsLayeredIndexableFeatureLangValue(PsLayeredIndexableFeatureLangValuePK psLayeredIndexableFeatureLangValuePK, String urlName) {
        this.psLayeredIndexableFeatureLangValuePK = psLayeredIndexableFeatureLangValuePK;
        this.urlName = urlName;
    }

    public PsLayeredIndexableFeatureLangValue(int idFeature, int idLang) {
        this.psLayeredIndexableFeatureLangValuePK = new PsLayeredIndexableFeatureLangValuePK(idFeature, idLang);
    }

    public PsLayeredIndexableFeatureLangValuePK getPsLayeredIndexableFeatureLangValuePK() {
        return psLayeredIndexableFeatureLangValuePK;
    }

    public void setPsLayeredIndexableFeatureLangValuePK(PsLayeredIndexableFeatureLangValuePK psLayeredIndexableFeatureLangValuePK) {
        this.psLayeredIndexableFeatureLangValuePK = psLayeredIndexableFeatureLangValuePK;
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
        hash += (psLayeredIndexableFeatureLangValuePK != null ? psLayeredIndexableFeatureLangValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableFeatureLangValue)) {
            return false;
        }
        PsLayeredIndexableFeatureLangValue other = (PsLayeredIndexableFeatureLangValue) object;
        if ((this.psLayeredIndexableFeatureLangValuePK == null && other.psLayeredIndexableFeatureLangValuePK != null) || (this.psLayeredIndexableFeatureLangValuePK != null && !this.psLayeredIndexableFeatureLangValuePK.equals(other.psLayeredIndexableFeatureLangValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableFeatureLangValue[ psLayeredIndexableFeatureLangValuePK=" + psLayeredIndexableFeatureLangValuePK + " ]";
    }
    
}
