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
@Table(name = "ps_quick_access_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsQuickAccessLang.findAll", query = "SELECT p FROM PsQuickAccessLang p")
    , @NamedQuery(name = "PsQuickAccessLang.findByIdQuickAccess", query = "SELECT p FROM PsQuickAccessLang p WHERE p.psQuickAccessLangPK.idQuickAccess = :idQuickAccess")
    , @NamedQuery(name = "PsQuickAccessLang.findByIdLang", query = "SELECT p FROM PsQuickAccessLang p WHERE p.psQuickAccessLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsQuickAccessLang.findByName", query = "SELECT p FROM PsQuickAccessLang p WHERE p.name = :name")})
public class PsQuickAccessLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsQuickAccessLangPK psQuickAccessLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsQuickAccessLang() {
    }

    public PsQuickAccessLang(PsQuickAccessLangPK psQuickAccessLangPK) {
        this.psQuickAccessLangPK = psQuickAccessLangPK;
    }

    public PsQuickAccessLang(PsQuickAccessLangPK psQuickAccessLangPK, String name) {
        this.psQuickAccessLangPK = psQuickAccessLangPK;
        this.name = name;
    }

    public PsQuickAccessLang(int idQuickAccess, int idLang) {
        this.psQuickAccessLangPK = new PsQuickAccessLangPK(idQuickAccess, idLang);
    }

    public PsQuickAccessLangPK getPsQuickAccessLangPK() {
        return psQuickAccessLangPK;
    }

    public void setPsQuickAccessLangPK(PsQuickAccessLangPK psQuickAccessLangPK) {
        this.psQuickAccessLangPK = psQuickAccessLangPK;
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
        hash += (psQuickAccessLangPK != null ? psQuickAccessLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsQuickAccessLang)) {
            return false;
        }
        PsQuickAccessLang other = (PsQuickAccessLang) object;
        if ((this.psQuickAccessLangPK == null && other.psQuickAccessLangPK != null) || (this.psQuickAccessLangPK != null && !this.psQuickAccessLangPK.equals(other.psQuickAccessLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsQuickAccessLang[ psQuickAccessLangPK=" + psQuickAccessLangPK + " ]";
    }
    
}
