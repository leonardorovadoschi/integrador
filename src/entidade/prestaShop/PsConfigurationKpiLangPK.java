/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsConfigurationKpiLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_configuration_kpi")
    private int idConfigurationKpi;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsConfigurationKpiLangPK() {
    }

    public PsConfigurationKpiLangPK(int idConfigurationKpi, int idLang) {
        this.idConfigurationKpi = idConfigurationKpi;
        this.idLang = idLang;
    }

    public int getIdConfigurationKpi() {
        return idConfigurationKpi;
    }

    public void setIdConfigurationKpi(int idConfigurationKpi) {
        this.idConfigurationKpi = idConfigurationKpi;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idConfigurationKpi;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConfigurationKpiLangPK)) {
            return false;
        }
        PsConfigurationKpiLangPK other = (PsConfigurationKpiLangPK) object;
        if (this.idConfigurationKpi != other.idConfigurationKpi) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConfigurationKpiLangPK[ idConfigurationKpi=" + idConfigurationKpi + ", idLang=" + idLang + " ]";
    }
    
}
