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
public class PsConfigurationLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_configuration")
    private int idConfiguration;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsConfigurationLangPK() {
    }

    public PsConfigurationLangPK(int idConfiguration, int idLang) {
        this.idConfiguration = idConfiguration;
        this.idLang = idLang;
    }

    public int getIdConfiguration() {
        return idConfiguration;
    }

    public void setIdConfiguration(int idConfiguration) {
        this.idConfiguration = idConfiguration;
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
        hash += (int) idConfiguration;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConfigurationLangPK)) {
            return false;
        }
        PsConfigurationLangPK other = (PsConfigurationLangPK) object;
        if (this.idConfiguration != other.idConfiguration) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConfigurationLangPK[ idConfiguration=" + idConfiguration + ", idLang=" + idLang + " ]";
    }
    
}
