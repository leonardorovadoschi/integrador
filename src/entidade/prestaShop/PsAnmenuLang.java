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
@Table(name = "ps_anmenu_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnmenuLang.findAll", query = "SELECT p FROM PsAnmenuLang p")})
public class PsAnmenuLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnmenuLangPK psAnmenuLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Column(name = "label")
    private String label;

    public PsAnmenuLang() {
    }

    public PsAnmenuLang(PsAnmenuLangPK psAnmenuLangPK) {
        this.psAnmenuLangPK = psAnmenuLangPK;
    }

    public PsAnmenuLang(PsAnmenuLangPK psAnmenuLangPK, String name, String link) {
        this.psAnmenuLangPK = psAnmenuLangPK;
        this.name = name;
        this.link = link;
    }

    public PsAnmenuLang(int idAnmenu, int idLang) {
        this.psAnmenuLangPK = new PsAnmenuLangPK(idAnmenu, idLang);
    }

    public PsAnmenuLangPK getPsAnmenuLangPK() {
        return psAnmenuLangPK;
    }

    public void setPsAnmenuLangPK(PsAnmenuLangPK psAnmenuLangPK) {
        this.psAnmenuLangPK = psAnmenuLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnmenuLangPK != null ? psAnmenuLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnmenuLang)) {
            return false;
        }
        PsAnmenuLang other = (PsAnmenuLang) object;
        if ((this.psAnmenuLangPK == null && other.psAnmenuLangPK != null) || (this.psAnmenuLangPK != null && !this.psAnmenuLangPK.equals(other.psAnmenuLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnmenuLang[ psAnmenuLangPK=" + psAnmenuLangPK + " ]";
    }
    
}
