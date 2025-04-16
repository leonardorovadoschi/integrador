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
@Table(name = "ps_andropdown_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAndropdownLang.findAll", query = "SELECT p FROM PsAndropdownLang p")})
public class PsAndropdownLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAndropdownLangPK psAndropdownLangPK;
    @Lob
    @Column(name = "static_content")
    private String staticContent;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    public PsAndropdownLang() {
    }

    public PsAndropdownLang(PsAndropdownLangPK psAndropdownLangPK) {
        this.psAndropdownLangPK = psAndropdownLangPK;
    }

    public PsAndropdownLang(PsAndropdownLangPK psAndropdownLangPK, String title) {
        this.psAndropdownLangPK = psAndropdownLangPK;
        this.title = title;
    }

    public PsAndropdownLang(int idAndropdown, int idLang) {
        this.psAndropdownLangPK = new PsAndropdownLangPK(idAndropdown, idLang);
    }

    public PsAndropdownLangPK getPsAndropdownLangPK() {
        return psAndropdownLangPK;
    }

    public void setPsAndropdownLangPK(PsAndropdownLangPK psAndropdownLangPK) {
        this.psAndropdownLangPK = psAndropdownLangPK;
    }

    public String getStaticContent() {
        return staticContent;
    }

    public void setStaticContent(String staticContent) {
        this.staticContent = staticContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAndropdownLangPK != null ? psAndropdownLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAndropdownLang)) {
            return false;
        }
        PsAndropdownLang other = (PsAndropdownLang) object;
        if ((this.psAndropdownLangPK == null && other.psAndropdownLangPK != null) || (this.psAndropdownLangPK != null && !this.psAndropdownLangPK.equals(other.psAndropdownLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAndropdownLang[ psAndropdownLangPK=" + psAndropdownLangPK + " ]";
    }
    
}
