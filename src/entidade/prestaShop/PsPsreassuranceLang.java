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
@Table(name = "ps_psreassurance_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPsreassuranceLang.findAll", query = "SELECT p FROM PsPsreassuranceLang p")})
public class PsPsreassuranceLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPsreassuranceLangPK psPsreassuranceLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;

    public PsPsreassuranceLang() {
    }

    public PsPsreassuranceLang(PsPsreassuranceLangPK psPsreassuranceLangPK) {
        this.psPsreassuranceLangPK = psPsreassuranceLangPK;
    }

    public PsPsreassuranceLang(PsPsreassuranceLangPK psPsreassuranceLangPK, String title, String description, String link) {
        this.psPsreassuranceLangPK = psPsreassuranceLangPK;
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public PsPsreassuranceLang(int idPsreassurance, int idLang) {
        this.psPsreassuranceLangPK = new PsPsreassuranceLangPK(idPsreassurance, idLang);
    }

    public PsPsreassuranceLangPK getPsPsreassuranceLangPK() {
        return psPsreassuranceLangPK;
    }

    public void setPsPsreassuranceLangPK(PsPsreassuranceLangPK psPsreassuranceLangPK) {
        this.psPsreassuranceLangPK = psPsreassuranceLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPsreassuranceLangPK != null ? psPsreassuranceLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsreassuranceLang)) {
            return false;
        }
        PsPsreassuranceLang other = (PsPsreassuranceLang) object;
        if ((this.psPsreassuranceLangPK == null && other.psPsreassuranceLangPK != null) || (this.psPsreassuranceLangPK != null && !this.psPsreassuranceLangPK.equals(other.psPsreassuranceLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsreassuranceLang[ psPsreassuranceLangPK=" + psPsreassuranceLangPK + " ]";
    }
    
}
