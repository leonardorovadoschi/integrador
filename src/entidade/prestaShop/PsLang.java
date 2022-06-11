/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLang.findAll", query = "SELECT p FROM PsLang p")
    , @NamedQuery(name = "PsLang.findByIdLang", query = "SELECT p FROM PsLang p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsLang.findByName", query = "SELECT p FROM PsLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsLang.findByActive", query = "SELECT p FROM PsLang p WHERE p.active = :active")
    , @NamedQuery(name = "PsLang.findByIsoCode", query = "SELECT p FROM PsLang p WHERE p.isoCode = :isoCode")
    , @NamedQuery(name = "PsLang.findByLanguageCode", query = "SELECT p FROM PsLang p WHERE p.languageCode = :languageCode")
    , @NamedQuery(name = "PsLang.findByLocale", query = "SELECT p FROM PsLang p WHERE p.locale = :locale")
    , @NamedQuery(name = "PsLang.findByDateFormatLite", query = "SELECT p FROM PsLang p WHERE p.dateFormatLite = :dateFormatLite")
    , @NamedQuery(name = "PsLang.findByDateFormatFull", query = "SELECT p FROM PsLang p WHERE p.dateFormatFull = :dateFormatFull")
    , @NamedQuery(name = "PsLang.findByIsRtl", query = "SELECT p FROM PsLang p WHERE p.isRtl = :isRtl")})
public class PsLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lang")
    private Integer idLang;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "iso_code")
    private String isoCode;
    @Basic(optional = false)
    @Column(name = "language_code")
    private String languageCode;
    @Basic(optional = false)
    @Column(name = "locale")
    private String locale;
    @Basic(optional = false)
    @Column(name = "date_format_lite")
    private String dateFormatLite;
    @Basic(optional = false)
    @Column(name = "date_format_full")
    private String dateFormatFull;
    @Basic(optional = false)
    @Column(name = "is_rtl")
    private boolean isRtl;

    public PsLang() {
    }

    public PsLang(Integer idLang) {
        this.idLang = idLang;
    }

    public PsLang(Integer idLang, String name, boolean active, String isoCode, String languageCode, String locale, String dateFormatLite, String dateFormatFull, boolean isRtl) {
        this.idLang = idLang;
        this.name = name;
        this.active = active;
        this.isoCode = isoCode;
        this.languageCode = languageCode;
        this.locale = locale;
        this.dateFormatLite = dateFormatLite;
        this.dateFormatFull = dateFormatFull;
        this.isRtl = isRtl;
    }

    public Integer getIdLang() {
        return idLang;
    }

    public void setIdLang(Integer idLang) {
        this.idLang = idLang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormatLite() {
        return dateFormatLite;
    }

    public void setDateFormatLite(String dateFormatLite) {
        this.dateFormatLite = dateFormatLite;
    }

    public String getDateFormatFull() {
        return dateFormatFull;
    }

    public void setDateFormatFull(String dateFormatFull) {
        this.dateFormatFull = dateFormatFull;
    }

    public boolean getIsRtl() {
        return isRtl;
    }

    public void setIsRtl(boolean isRtl) {
        this.isRtl = isRtl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLang)) {
            return false;
        }
        PsLang other = (PsLang) object;
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLang[ idLang=" + idLang + " ]";
    }
    
}
