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
@Table(name = "ps_profile_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProfileLang.findAll", query = "SELECT p FROM PsProfileLang p")
    , @NamedQuery(name = "PsProfileLang.findByIdLang", query = "SELECT p FROM PsProfileLang p WHERE p.psProfileLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsProfileLang.findByIdProfile", query = "SELECT p FROM PsProfileLang p WHERE p.psProfileLangPK.idProfile = :idProfile")
    , @NamedQuery(name = "PsProfileLang.findByName", query = "SELECT p FROM PsProfileLang p WHERE p.name = :name")})
public class PsProfileLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProfileLangPK psProfileLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsProfileLang() {
    }

    public PsProfileLang(PsProfileLangPK psProfileLangPK) {
        this.psProfileLangPK = psProfileLangPK;
    }

    public PsProfileLang(PsProfileLangPK psProfileLangPK, String name) {
        this.psProfileLangPK = psProfileLangPK;
        this.name = name;
    }

    public PsProfileLang(int idLang, int idProfile) {
        this.psProfileLangPK = new PsProfileLangPK(idLang, idProfile);
    }

    public PsProfileLangPK getPsProfileLangPK() {
        return psProfileLangPK;
    }

    public void setPsProfileLangPK(PsProfileLangPK psProfileLangPK) {
        this.psProfileLangPK = psProfileLangPK;
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
        hash += (psProfileLangPK != null ? psProfileLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProfileLang)) {
            return false;
        }
        PsProfileLang other = (PsProfileLang) object;
        if ((this.psProfileLangPK == null && other.psProfileLangPK != null) || (this.psProfileLangPK != null && !this.psProfileLangPK.equals(other.psProfileLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProfileLang[ psProfileLangPK=" + psProfileLangPK + " ]";
    }
    
}
