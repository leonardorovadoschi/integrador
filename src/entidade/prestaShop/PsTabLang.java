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
@Table(name = "ps_tab_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTabLang.findAll", query = "SELECT p FROM PsTabLang p")
    , @NamedQuery(name = "PsTabLang.findByIdTab", query = "SELECT p FROM PsTabLang p WHERE p.psTabLangPK.idTab = :idTab")
    , @NamedQuery(name = "PsTabLang.findByIdLang", query = "SELECT p FROM PsTabLang p WHERE p.psTabLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsTabLang.findByName", query = "SELECT p FROM PsTabLang p WHERE p.name = :name")})
public class PsTabLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsTabLangPK psTabLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsTabLang() {
    }

    public PsTabLang(PsTabLangPK psTabLangPK) {
        this.psTabLangPK = psTabLangPK;
    }

    public PsTabLang(PsTabLangPK psTabLangPK, String name) {
        this.psTabLangPK = psTabLangPK;
        this.name = name;
    }

    public PsTabLang(int idTab, int idLang) {
        this.psTabLangPK = new PsTabLangPK(idTab, idLang);
    }

    public PsTabLangPK getPsTabLangPK() {
        return psTabLangPK;
    }

    public void setPsTabLangPK(PsTabLangPK psTabLangPK) {
        this.psTabLangPK = psTabLangPK;
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
        hash += (psTabLangPK != null ? psTabLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTabLang)) {
            return false;
        }
        PsTabLang other = (PsTabLang) object;
        if ((this.psTabLangPK == null && other.psTabLangPK != null) || (this.psTabLangPK != null && !this.psTabLangPK.equals(other.psTabLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTabLang[ psTabLangPK=" + psTabLangPK + " ]";
    }
    
}
