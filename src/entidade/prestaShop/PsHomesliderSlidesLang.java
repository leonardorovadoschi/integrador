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
 * @author leo
 */
@Entity
@Table(name = "ps_homeslider_slides_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHomesliderSlidesLang.findAll", query = "SELECT p FROM PsHomesliderSlidesLang p")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByIdHomesliderSlides", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.psHomesliderSlidesLangPK.idHomesliderSlides = :idHomesliderSlides")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByIdLang", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.psHomesliderSlidesLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByTitle", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.title = :title")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByLegend", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.legend = :legend")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByUrl", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.url = :url")
    , @NamedQuery(name = "PsHomesliderSlidesLang.findByImage", query = "SELECT p FROM PsHomesliderSlidesLang p WHERE p.image = :image")})
public class PsHomesliderSlidesLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsHomesliderSlidesLangPK psHomesliderSlidesLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "legend")
    private String legend;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public PsHomesliderSlidesLang() {
    }

    public PsHomesliderSlidesLang(PsHomesliderSlidesLangPK psHomesliderSlidesLangPK) {
        this.psHomesliderSlidesLangPK = psHomesliderSlidesLangPK;
    }

    public PsHomesliderSlidesLang(PsHomesliderSlidesLangPK psHomesliderSlidesLangPK, String title, String description, String legend, String url, String image) {
        this.psHomesliderSlidesLangPK = psHomesliderSlidesLangPK;
        this.title = title;
        this.description = description;
        this.legend = legend;
        this.url = url;
        this.image = image;
    }

    public PsHomesliderSlidesLang(int idHomesliderSlides, int idLang) {
        this.psHomesliderSlidesLangPK = new PsHomesliderSlidesLangPK(idHomesliderSlides, idLang);
    }

    public PsHomesliderSlidesLangPK getPsHomesliderSlidesLangPK() {
        return psHomesliderSlidesLangPK;
    }

    public void setPsHomesliderSlidesLangPK(PsHomesliderSlidesLangPK psHomesliderSlidesLangPK) {
        this.psHomesliderSlidesLangPK = psHomesliderSlidesLangPK;
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

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psHomesliderSlidesLangPK != null ? psHomesliderSlidesLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHomesliderSlidesLang)) {
            return false;
        }
        PsHomesliderSlidesLang other = (PsHomesliderSlidesLang) object;
        if ((this.psHomesliderSlidesLangPK == null && other.psHomesliderSlidesLangPK != null) || (this.psHomesliderSlidesLangPK != null && !this.psHomesliderSlidesLangPK.equals(other.psHomesliderSlidesLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHomesliderSlidesLang[ psHomesliderSlidesLangPK=" + psHomesliderSlidesLangPK + " ]";
    }
    
}
