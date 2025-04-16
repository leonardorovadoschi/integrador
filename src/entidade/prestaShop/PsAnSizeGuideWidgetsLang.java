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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_size_guide_widgets_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnSizeGuideWidgetsLang.findAll", query = "SELECT p FROM PsAnSizeGuideWidgetsLang p")})
public class PsAnSizeGuideWidgetsLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnSizeGuideWidgetsLangPK psAnSizeGuideWidgetsLangPK;
    @Basic(optional = false)
    @Column(name = "sizeguide_title")
    private String sizeguideTitle;
    @Lob
    @Column(name = "sizeguide_content")
    private String sizeguideContent;

    public PsAnSizeGuideWidgetsLang() {
    }

    public PsAnSizeGuideWidgetsLang(PsAnSizeGuideWidgetsLangPK psAnSizeGuideWidgetsLangPK) {
        this.psAnSizeGuideWidgetsLangPK = psAnSizeGuideWidgetsLangPK;
    }

    public PsAnSizeGuideWidgetsLang(PsAnSizeGuideWidgetsLangPK psAnSizeGuideWidgetsLangPK, String sizeguideTitle) {
        this.psAnSizeGuideWidgetsLangPK = psAnSizeGuideWidgetsLangPK;
        this.sizeguideTitle = sizeguideTitle;
    }

    public PsAnSizeGuideWidgetsLang(int idWidget, String idLang) {
        this.psAnSizeGuideWidgetsLangPK = new PsAnSizeGuideWidgetsLangPK(idWidget, idLang);
    }

    public PsAnSizeGuideWidgetsLangPK getPsAnSizeGuideWidgetsLangPK() {
        return psAnSizeGuideWidgetsLangPK;
    }

    public void setPsAnSizeGuideWidgetsLangPK(PsAnSizeGuideWidgetsLangPK psAnSizeGuideWidgetsLangPK) {
        this.psAnSizeGuideWidgetsLangPK = psAnSizeGuideWidgetsLangPK;
    }

    public String getSizeguideTitle() {
        return sizeguideTitle;
    }

    public void setSizeguideTitle(String sizeguideTitle) {
        this.sizeguideTitle = sizeguideTitle;
    }

    public String getSizeguideContent() {
        return sizeguideContent;
    }

    public void setSizeguideContent(String sizeguideContent) {
        this.sizeguideContent = sizeguideContent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnSizeGuideWidgetsLangPK != null ? psAnSizeGuideWidgetsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnSizeGuideWidgetsLang)) {
            return false;
        }
        PsAnSizeGuideWidgetsLang other = (PsAnSizeGuideWidgetsLang) object;
        if ((this.psAnSizeGuideWidgetsLangPK == null && other.psAnSizeGuideWidgetsLangPK != null) || (this.psAnSizeGuideWidgetsLangPK != null && !this.psAnSizeGuideWidgetsLangPK.equals(other.psAnSizeGuideWidgetsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgetsLang[ psAnSizeGuideWidgetsLangPK=" + psAnSizeGuideWidgetsLangPK + " ]";
    }
    
}
