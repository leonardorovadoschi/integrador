/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_feature_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFeatureLang.findAll", query = "SELECT p FROM PsFeatureLang p")
    , @NamedQuery(name = "PsFeatureLang.findByIdFeature", query = "SELECT p FROM PsFeatureLang p WHERE p.psFeatureLangPK.idFeature = :idFeature")
    , @NamedQuery(name = "PsFeatureLang.findByIdLang", query = "SELECT p FROM PsFeatureLang p WHERE p.psFeatureLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsFeatureLang.findByName", query = "SELECT p FROM PsFeatureLang p WHERE p.name = :name")})
public class PsFeatureLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsFeatureLangPK psFeatureLangPK;
    @Column(name = "name")
    private String name;

    public PsFeatureLang() {
    }

    public PsFeatureLang(PsFeatureLangPK psFeatureLangPK) {
        this.psFeatureLangPK = psFeatureLangPK;
    }

    public PsFeatureLang(int idFeature, int idLang) {
        this.psFeatureLangPK = new PsFeatureLangPK(idFeature, idLang);
    }

    public PsFeatureLangPK getPsFeatureLangPK() {
        return psFeatureLangPK;
    }

    public void setPsFeatureLangPK(PsFeatureLangPK psFeatureLangPK) {
        this.psFeatureLangPK = psFeatureLangPK;
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
        hash += (psFeatureLangPK != null ? psFeatureLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFeatureLang)) {
            return false;
        }
        PsFeatureLang other = (PsFeatureLang) object;
        if ((this.psFeatureLangPK == null && other.psFeatureLangPK != null) || (this.psFeatureLangPK != null && !this.psFeatureLangPK.equals(other.psFeatureLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFeatureLang[ psFeatureLangPK=" + psFeatureLangPK + " ]";
    }
    
}
