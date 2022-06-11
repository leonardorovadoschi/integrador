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
@Table(name = "ps_translation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTranslation.findAll", query = "SELECT p FROM PsTranslation p")
    , @NamedQuery(name = "PsTranslation.findByIdTranslation", query = "SELECT p FROM PsTranslation p WHERE p.idTranslation = :idTranslation")
    , @NamedQuery(name = "PsTranslation.findByIdLang", query = "SELECT p FROM PsTranslation p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsTranslation.findByDomain", query = "SELECT p FROM PsTranslation p WHERE p.domain = :domain")
    , @NamedQuery(name = "PsTranslation.findByTheme", query = "SELECT p FROM PsTranslation p WHERE p.theme = :theme")})
public class PsTranslation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_translation")
    private Integer idTranslation;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Lob
    @Column(name = "key")
    private String key;
    @Basic(optional = false)
    @Lob
    @Column(name = "translation")
    private String translation;
    @Basic(optional = false)
    @Column(name = "domain")
    private String domain;
    @Column(name = "theme")
    private String theme;

    public PsTranslation() {
    }

    public PsTranslation(Integer idTranslation) {
        this.idTranslation = idTranslation;
    }

    public PsTranslation(Integer idTranslation, int idLang, String key, String translation, String domain) {
        this.idTranslation = idTranslation;
        this.idLang = idLang;
        this.key = key;
        this.translation = translation;
        this.domain = domain;
    }

    public Integer getIdTranslation() {
        return idTranslation;
    }

    public void setIdTranslation(Integer idTranslation) {
        this.idTranslation = idTranslation;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTranslation != null ? idTranslation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTranslation)) {
            return false;
        }
        PsTranslation other = (PsTranslation) object;
        if ((this.idTranslation == null && other.idTranslation != null) || (this.idTranslation != null && !this.idTranslation.equals(other.idTranslation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTranslation[ idTranslation=" + idTranslation + " ]";
    }
    
}
