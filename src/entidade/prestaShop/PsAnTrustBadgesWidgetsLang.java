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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_trust_badges_widgets_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnTrustBadgesWidgetsLang.findAll", query = "SELECT p FROM PsAnTrustBadgesWidgetsLang p")})
public class PsAnTrustBadgesWidgetsLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnTrustBadgesWidgetsLangPK psAnTrustBadgesWidgetsLangPK;
    @Basic(optional = false)
    @Column(name = "widget_title")
    private String widgetTitle;

    public PsAnTrustBadgesWidgetsLang() {
    }

    public PsAnTrustBadgesWidgetsLang(PsAnTrustBadgesWidgetsLangPK psAnTrustBadgesWidgetsLangPK) {
        this.psAnTrustBadgesWidgetsLangPK = psAnTrustBadgesWidgetsLangPK;
    }

    public PsAnTrustBadgesWidgetsLang(PsAnTrustBadgesWidgetsLangPK psAnTrustBadgesWidgetsLangPK, String widgetTitle) {
        this.psAnTrustBadgesWidgetsLangPK = psAnTrustBadgesWidgetsLangPK;
        this.widgetTitle = widgetTitle;
    }

    public PsAnTrustBadgesWidgetsLang(int idWidget, String idLang) {
        this.psAnTrustBadgesWidgetsLangPK = new PsAnTrustBadgesWidgetsLangPK(idWidget, idLang);
    }

    public PsAnTrustBadgesWidgetsLangPK getPsAnTrustBadgesWidgetsLangPK() {
        return psAnTrustBadgesWidgetsLangPK;
    }

    public void setPsAnTrustBadgesWidgetsLangPK(PsAnTrustBadgesWidgetsLangPK psAnTrustBadgesWidgetsLangPK) {
        this.psAnTrustBadgesWidgetsLangPK = psAnTrustBadgesWidgetsLangPK;
    }

    public String getWidgetTitle() {
        return widgetTitle;
    }

    public void setWidgetTitle(String widgetTitle) {
        this.widgetTitle = widgetTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnTrustBadgesWidgetsLangPK != null ? psAnTrustBadgesWidgetsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesWidgetsLang)) {
            return false;
        }
        PsAnTrustBadgesWidgetsLang other = (PsAnTrustBadgesWidgetsLang) object;
        if ((this.psAnTrustBadgesWidgetsLangPK == null && other.psAnTrustBadgesWidgetsLangPK != null) || (this.psAnTrustBadgesWidgetsLangPK != null && !this.psAnTrustBadgesWidgetsLangPK.equals(other.psAnTrustBadgesWidgetsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesWidgetsLang[ psAnTrustBadgesWidgetsLangPK=" + psAnTrustBadgesWidgetsLangPK + " ]";
    }
    
}
