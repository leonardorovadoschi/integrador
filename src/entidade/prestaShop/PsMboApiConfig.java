/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_mbo_api_config")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMboApiConfig.findAll", query = "SELECT p FROM PsMboApiConfig p")})
public class PsMboApiConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mbo_api_config")
    private Integer idMboApiConfig;
    @Column(name = "config_key")
    private String configKey;
    @Column(name = "config_value")
    private String configValue;
    @Column(name = "ps_version")
    private String psVersion;
    @Column(name = "mbo_version")
    private String mboVersion;
    @Basic(optional = false)
    @Column(name = "applied")
    private boolean applied;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsMboApiConfig() {
    }

    public PsMboApiConfig(Integer idMboApiConfig) {
        this.idMboApiConfig = idMboApiConfig;
    }

    public PsMboApiConfig(Integer idMboApiConfig, boolean applied, Date dateAdd) {
        this.idMboApiConfig = idMboApiConfig;
        this.applied = applied;
        this.dateAdd = dateAdd;
    }

    public Integer getIdMboApiConfig() {
        return idMboApiConfig;
    }

    public void setIdMboApiConfig(Integer idMboApiConfig) {
        this.idMboApiConfig = idMboApiConfig;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getPsVersion() {
        return psVersion;
    }

    public void setPsVersion(String psVersion) {
        this.psVersion = psVersion;
    }

    public String getMboVersion() {
        return mboVersion;
    }

    public void setMboVersion(String mboVersion) {
        this.mboVersion = mboVersion;
    }

    public boolean getApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMboApiConfig != null ? idMboApiConfig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMboApiConfig)) {
            return false;
        }
        PsMboApiConfig other = (PsMboApiConfig) object;
        if ((this.idMboApiConfig == null && other.idMboApiConfig != null) || (this.idMboApiConfig != null && !this.idMboApiConfig.equals(other.idMboApiConfig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMboApiConfig[ idMboApiConfig=" + idMboApiConfig + " ]";
    }
    
}
