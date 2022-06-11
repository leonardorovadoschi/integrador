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
 * @author leo
 */
@Entity
@Table(name = "ps_country_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCountryLang.findAll", query = "SELECT p FROM PsCountryLang p")
    , @NamedQuery(name = "PsCountryLang.findByIdCountry", query = "SELECT p FROM PsCountryLang p WHERE p.psCountryLangPK.idCountry = :idCountry")
    , @NamedQuery(name = "PsCountryLang.findByIdLang", query = "SELECT p FROM PsCountryLang p WHERE p.psCountryLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCountryLang.findByName", query = "SELECT p FROM PsCountryLang p WHERE p.name = :name")})
public class PsCountryLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCountryLangPK psCountryLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsCountryLang() {
    }

    public PsCountryLang(PsCountryLangPK psCountryLangPK) {
        this.psCountryLangPK = psCountryLangPK;
    }

    public PsCountryLang(PsCountryLangPK psCountryLangPK, String name) {
        this.psCountryLangPK = psCountryLangPK;
        this.name = name;
    }

    public PsCountryLang(int idCountry, int idLang) {
        this.psCountryLangPK = new PsCountryLangPK(idCountry, idLang);
    }

    public PsCountryLangPK getPsCountryLangPK() {
        return psCountryLangPK;
    }

    public void setPsCountryLangPK(PsCountryLangPK psCountryLangPK) {
        this.psCountryLangPK = psCountryLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCountryLangPK != null ? psCountryLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCountryLang)) {
            return false;
        }
        PsCountryLang other = (PsCountryLang) object;
        if ((this.psCountryLangPK == null && other.psCountryLangPK != null) || (this.psCountryLangPK != null && !this.psCountryLangPK.equals(other.psCountryLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCountryLang[ psCountryLangPK=" + psCountryLangPK + " ]";
    }
    
}
