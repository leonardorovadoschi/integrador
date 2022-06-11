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
@Table(name = "ps_configuration_kpi_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConfigurationKpiLang.findAll", query = "SELECT p FROM PsConfigurationKpiLang p")
    , @NamedQuery(name = "PsConfigurationKpiLang.findByIdConfigurationKpi", query = "SELECT p FROM PsConfigurationKpiLang p WHERE p.psConfigurationKpiLangPK.idConfigurationKpi = :idConfigurationKpi")
    , @NamedQuery(name = "PsConfigurationKpiLang.findByIdLang", query = "SELECT p FROM PsConfigurationKpiLang p WHERE p.psConfigurationKpiLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsConfigurationKpiLang.findByDateUpd", query = "SELECT p FROM PsConfigurationKpiLang p WHERE p.dateUpd = :dateUpd")})
public class PsConfigurationKpiLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConfigurationKpiLangPK psConfigurationKpiLangPK;
    @Lob
    @Column(name = "value")
    private String value;
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsConfigurationKpiLang() {
    }

    public PsConfigurationKpiLang(PsConfigurationKpiLangPK psConfigurationKpiLangPK) {
        this.psConfigurationKpiLangPK = psConfigurationKpiLangPK;
    }

    public PsConfigurationKpiLang(int idConfigurationKpi, int idLang) {
        this.psConfigurationKpiLangPK = new PsConfigurationKpiLangPK(idConfigurationKpi, idLang);
    }

    public PsConfigurationKpiLangPK getPsConfigurationKpiLangPK() {
        return psConfigurationKpiLangPK;
    }

    public void setPsConfigurationKpiLangPK(PsConfigurationKpiLangPK psConfigurationKpiLangPK) {
        this.psConfigurationKpiLangPK = psConfigurationKpiLangPK;
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
        hash += (psConfigurationKpiLangPK != null ? psConfigurationKpiLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConfigurationKpiLang)) {
            return false;
        }
        PsConfigurationKpiLang other = (PsConfigurationKpiLang) object;
        if ((this.psConfigurationKpiLangPK == null && other.psConfigurationKpiLangPK != null) || (this.psConfigurationKpiLangPK != null && !this.psConfigurationKpiLangPK.equals(other.psConfigurationKpiLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConfigurationKpiLang[ psConfigurationKpiLangPK=" + psConfigurationKpiLangPK + " ]";
    }
    
}
