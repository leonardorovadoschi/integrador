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
@Table(name = "ps_layered_indexable_attribute_group_lang_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredIndexableAttributeGroupLangValue.findAll", query = "SELECT p FROM PsLayeredIndexableAttributeGroupLangValue p")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroupLangValue.findByIdAttributeGroup", query = "SELECT p FROM PsLayeredIndexableAttributeGroupLangValue p WHERE p.psLayeredIndexableAttributeGroupLangValuePK.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroupLangValue.findByIdLang", query = "SELECT p FROM PsLayeredIndexableAttributeGroupLangValue p WHERE p.psLayeredIndexableAttributeGroupLangValuePK.idLang = :idLang")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroupLangValue.findByUrlName", query = "SELECT p FROM PsLayeredIndexableAttributeGroupLangValue p WHERE p.urlName = :urlName")
    , @NamedQuery(name = "PsLayeredIndexableAttributeGroupLangValue.findByMetaTitle", query = "SELECT p FROM PsLayeredIndexableAttributeGroupLangValue p WHERE p.metaTitle = :metaTitle")})
public class PsLayeredIndexableAttributeGroupLangValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredIndexableAttributeGroupLangValuePK psLayeredIndexableAttributeGroupLangValuePK;
    @Column(name = "url_name")
    private String urlName;
    @Column(name = "meta_title")
    private String metaTitle;

    public PsLayeredIndexableAttributeGroupLangValue() {
    }

    public PsLayeredIndexableAttributeGroupLangValue(PsLayeredIndexableAttributeGroupLangValuePK psLayeredIndexableAttributeGroupLangValuePK) {
        this.psLayeredIndexableAttributeGroupLangValuePK = psLayeredIndexableAttributeGroupLangValuePK;
    }

    public PsLayeredIndexableAttributeGroupLangValue(int idAttributeGroup, int idLang) {
        this.psLayeredIndexableAttributeGroupLangValuePK = new PsLayeredIndexableAttributeGroupLangValuePK(idAttributeGroup, idLang);
    }

    public PsLayeredIndexableAttributeGroupLangValuePK getPsLayeredIndexableAttributeGroupLangValuePK() {
        return psLayeredIndexableAttributeGroupLangValuePK;
    }

    public void setPsLayeredIndexableAttributeGroupLangValuePK(PsLayeredIndexableAttributeGroupLangValuePK psLayeredIndexableAttributeGroupLangValuePK) {
        this.psLayeredIndexableAttributeGroupLangValuePK = psLayeredIndexableAttributeGroupLangValuePK;
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
        hash += (psLayeredIndexableAttributeGroupLangValuePK != null ? psLayeredIndexableAttributeGroupLangValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredIndexableAttributeGroupLangValue)) {
            return false;
        }
        PsLayeredIndexableAttributeGroupLangValue other = (PsLayeredIndexableAttributeGroupLangValue) object;
        if ((this.psLayeredIndexableAttributeGroupLangValuePK == null && other.psLayeredIndexableAttributeGroupLangValuePK != null) || (this.psLayeredIndexableAttributeGroupLangValuePK != null && !this.psLayeredIndexableAttributeGroupLangValuePK.equals(other.psLayeredIndexableAttributeGroupLangValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredIndexableAttributeGroupLangValue[ psLayeredIndexableAttributeGroupLangValuePK=" + psLayeredIndexableAttributeGroupLangValuePK + " ]";
    }
    
}
