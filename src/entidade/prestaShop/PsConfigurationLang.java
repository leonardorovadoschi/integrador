/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_configuration_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConfigurationLang.findAll", query = "SELECT p FROM PsConfigurationLang p")
    , @NamedQuery(name = "PsConfigurationLang.findByIdConfiguration", query = "SELECT p FROM PsConfigurationLang p WHERE p.psConfigurationLangPK.idConfiguration = :idConfiguration")
    , @NamedQuery(name = "PsConfigurationLang.findByIdLang", query = "SELECT p FROM PsConfigurationLang p WHERE p.psConfigurationLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsConfigurationLang.findByDateUpd", query = "SELECT p FROM PsConfigurationLang p WHERE p.dateUpd = :dateUpd")})
public class PsConfigurationLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConfigurationLangPK psConfigurationLangPK;
    @Lob
    @Column(name = "value")
    private String value;
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsConfigurationLang() {
    }

    public PsConfigurationLang(PsConfigurationLangPK psConfigurationLangPK) {
        this.psConfigurationLangPK = psConfigurationLangPK;
    }

    public PsConfigurationLang(int idConfiguration, int idLang) {
        this.psConfigurationLangPK = new PsConfigurationLangPK(idConfiguration, idLang);
    }

    public PsConfigurationLangPK getPsConfigurationLangPK() {
        return psConfigurationLangPK;
    }

    public void setPsConfigurationLangPK(PsConfigurationLangPK psConfigurationLangPK) {
        this.psConfigurationLangPK = psConfigurationLangPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psConfigurationLangPK != null ? psConfigurationLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConfigurationLang)) {
            return false;
        }
        PsConfigurationLang other = (PsConfigurationLang) object;
        if ((this.psConfigurationLangPK == null && other.psConfigurationLangPK != null) || (this.psConfigurationLangPK != null && !this.psConfigurationLangPK.equals(other.psConfigurationLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConfigurationLang[ psConfigurationLangPK=" + psConfigurationLangPK + " ]";
    }
    
}
