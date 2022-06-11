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
@Table(name = "ps_group_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGroupLang.findAll", query = "SELECT p FROM PsGroupLang p")
    , @NamedQuery(name = "PsGroupLang.findByIdGroup", query = "SELECT p FROM PsGroupLang p WHERE p.psGroupLangPK.idGroup = :idGroup")
    , @NamedQuery(name = "PsGroupLang.findByIdLang", query = "SELECT p FROM PsGroupLang p WHERE p.psGroupLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsGroupLang.findByName", query = "SELECT p FROM PsGroupLang p WHERE p.name = :name")})
public class PsGroupLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsGroupLangPK psGroupLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsGroupLang() {
    }

    public PsGroupLang(PsGroupLangPK psGroupLangPK) {
        this.psGroupLangPK = psGroupLangPK;
    }

    public PsGroupLang(PsGroupLangPK psGroupLangPK, String name) {
        this.psGroupLangPK = psGroupLangPK;
        this.name = name;
    }

    public PsGroupLang(int idGroup, int idLang) {
        this.psGroupLangPK = new PsGroupLangPK(idGroup, idLang);
    }

    public PsGroupLangPK getPsGroupLangPK() {
        return psGroupLangPK;
    }

    public void setPsGroupLangPK(PsGroupLangPK psGroupLangPK) {
        this.psGroupLangPK = psGroupLangPK;
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
        hash += (psGroupLangPK != null ? psGroupLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroupLang)) {
            return false;
        }
        PsGroupLang other = (PsGroupLang) object;
        if ((this.psGroupLangPK == null && other.psGroupLangPK != null) || (this.psGroupLangPK != null && !this.psGroupLangPK.equals(other.psGroupLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroupLang[ psGroupLangPK=" + psGroupLangPK + " ]";
    }
    
}
