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
@Table(name = "ps_an_productextratabs_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsLang.findAll", query = "SELECT p FROM PsAnProductextratabsLang p")})
public class PsAnProductextratabsLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductextratabsLangPK psAnProductextratabsLangPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "tab_content")
    private String tabContent;
    @Basic(optional = false)
    @Column(name = "tab_name")
    private String tabName;

    public PsAnProductextratabsLang() {
    }

    public PsAnProductextratabsLang(PsAnProductextratabsLangPK psAnProductextratabsLangPK) {
        this.psAnProductextratabsLangPK = psAnProductextratabsLangPK;
    }

    public PsAnProductextratabsLang(PsAnProductextratabsLangPK psAnProductextratabsLangPK, String tabContent, String tabName) {
        this.psAnProductextratabsLangPK = psAnProductextratabsLangPK;
        this.tabContent = tabContent;
        this.tabName = tabName;
    }

    public PsAnProductextratabsLang(int idtab, String idLang) {
        this.psAnProductextratabsLangPK = new PsAnProductextratabsLangPK(idtab, idLang);
    }

    public PsAnProductextratabsLangPK getPsAnProductextratabsLangPK() {
        return psAnProductextratabsLangPK;
    }

    public void setPsAnProductextratabsLangPK(PsAnProductextratabsLangPK psAnProductextratabsLangPK) {
        this.psAnProductextratabsLangPK = psAnProductextratabsLangPK;
    }

    public String getTabContent() {
        return tabContent;
    }

    public void setTabContent(String tabContent) {
        this.tabContent = tabContent;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductextratabsLangPK != null ? psAnProductextratabsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLang)) {
            return false;
        }
        PsAnProductextratabsLang other = (PsAnProductextratabsLang) object;
        if ((this.psAnProductextratabsLangPK == null && other.psAnProductextratabsLangPK != null) || (this.psAnProductextratabsLangPK != null && !this.psAnProductextratabsLangPK.equals(other.psAnProductextratabsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLang[ psAnProductextratabsLangPK=" + psAnProductextratabsLangPK + " ]";
    }
    
}
