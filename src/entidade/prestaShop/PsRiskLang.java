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
@Table(name = "ps_risk_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsRiskLang.findAll", query = "SELECT p FROM PsRiskLang p")
    , @NamedQuery(name = "PsRiskLang.findByIdRisk", query = "SELECT p FROM PsRiskLang p WHERE p.psRiskLangPK.idRisk = :idRisk")
    , @NamedQuery(name = "PsRiskLang.findByIdLang", query = "SELECT p FROM PsRiskLang p WHERE p.psRiskLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsRiskLang.findByName", query = "SELECT p FROM PsRiskLang p WHERE p.name = :name")})
public class PsRiskLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsRiskLangPK psRiskLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsRiskLang() {
    }

    public PsRiskLang(PsRiskLangPK psRiskLangPK) {
        this.psRiskLangPK = psRiskLangPK;
    }

    public PsRiskLang(PsRiskLangPK psRiskLangPK, String name) {
        this.psRiskLangPK = psRiskLangPK;
        this.name = name;
    }

    public PsRiskLang(int idRisk, int idLang) {
        this.psRiskLangPK = new PsRiskLangPK(idRisk, idLang);
    }

    public PsRiskLangPK getPsRiskLangPK() {
        return psRiskLangPK;
    }

    public void setPsRiskLangPK(PsRiskLangPK psRiskLangPK) {
        this.psRiskLangPK = psRiskLangPK;
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
        hash += (psRiskLangPK != null ? psRiskLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRiskLang)) {
            return false;
        }
        PsRiskLang other = (PsRiskLang) object;
        if ((this.psRiskLangPK == null && other.psRiskLangPK != null) || (this.psRiskLangPK != null && !this.psRiskLangPK.equals(other.psRiskLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRiskLang[ psRiskLangPK=" + psRiskLangPK + " ]";
    }
    
}
