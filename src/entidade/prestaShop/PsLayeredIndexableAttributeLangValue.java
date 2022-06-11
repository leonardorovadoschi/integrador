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
@Table(name = "ps_layered_indexable_attribute_lang_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableAttributeLangValue.findAll", query = "SELECT p FROM PsLayeredIndexableAttributeLangValue p")
    , @NamedQuery(name = "PsLayeredIndexableAttributeLangValue.findByIdAttribute", query = "SELECT p FROM PsLayeredIndexableAttributeLangValue p WHERE p.psLayeredIndexableAttributeLangValuePK.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsLayeredIndexableAttributeLangValue.findByIdLang", query = "SELECT p FROM PsLayeredIndexableAttributeLangValue p WHERE p.psLayeredIndexableAttributeLangValuePK.idLang = :idLang")
    , @NamedQuery(name = "PsLayeredIndexableAttributeLangValue.findByUrlName", query = "SELECT p FROM PsLayeredIndexableAttributeLangValue p WHERE p.urlName = :urlName")
    , @NamedQuery(name = "PsLayeredIndexableAttributeLangValue.findByMetaTitle", query = "SELECT p FROM PsLayeredIndexableAttributeLangValue p WHERE p.metaTitle = :metaTitle")})
public class PsLayeredIndexableAttributeLangValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredIndexableAttributeLangValuePK psLayeredIndexableAttributeLangValuePK;
    @Column(name = "url_name")
    private String urlName;
    @Column(name = "meta_title")
    private String metaTitle;

    public PsLayeredIndexableAttributeLangValue() {
    }

    public PsLayeredIndexableAttributeLangValue(PsLayeredIndexableAttributeLangValuePK psLayeredIndexableAttributeLangValuePK) {
        this.psLayeredIndexableAttributeLangValuePK = psLayeredIndexableAttributeLangValuePK;
    }

    public PsLayeredIndexableAttributeLangValue(int idAttribute, int idLang) {
        this.psLayeredIndexableAttributeLangValuePK = new PsLayeredIndexableAttributeLangValuePK(idAttribute, idLang);
    }

    public PsLayeredIndexableAttributeLangValuePK getPsLayeredIndexableAttributeLangValuePK() {
        return psLayeredIndexableAttributeLangValuePK;
    }

    public void setPsLayeredIndexableAttributeLangValuePK(PsLayeredIndexableAttributeLangValuePK psLayeredIndexableAttributeLangValuePK) {
        this.psLayeredIndexableAttributeLangValuePK = psLayeredIndexableAttributeLangValuePK;
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
        hash += (psLayeredIndexableAttributeLangValuePK != null ? psLayeredIndexableAttributeLangValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableAttributeLangValue)) {
            return false;
        }
        PsLayeredIndexableAttributeLangValue other = (PsLayeredIndexableAttributeLangValue) object;
        if ((this.psLayeredIndexableAttributeLangValuePK == null && other.psLayeredIndexableAttributeLangValuePK != null) || (this.psLayeredIndexableAttributeLangValuePK != null && !this.psLayeredIndexableAttributeLangValuePK.equals(other.psLayeredIndexableAttributeLangValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableAttributeLangValue[ psLayeredIndexableAttributeLangValuePK=" + psLayeredIndexableAttributeLangValuePK + " ]";
    }
    
}
