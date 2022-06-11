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
@Table(name = "ps_gender_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGenderLang.findAll", query = "SELECT p FROM PsGenderLang p")
    , @NamedQuery(name = "PsGenderLang.findByIdGender", query = "SELECT p FROM PsGenderLang p WHERE p.psGenderLangPK.idGender = :idGender")
    , @NamedQuery(name = "PsGenderLang.findByIdLang", query = "SELECT p FROM PsGenderLang p WHERE p.psGenderLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsGenderLang.findByName", query = "SELECT p FROM PsGenderLang p WHERE p.name = :name")})
public class PsGenderLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsGenderLangPK psGenderLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsGenderLang() {
    }

    public PsGenderLang(PsGenderLangPK psGenderLangPK) {
        this.psGenderLangPK = psGenderLangPK;
    }

    public PsGenderLang(PsGenderLangPK psGenderLangPK, String name) {
        this.psGenderLangPK = psGenderLangPK;
        this.name = name;
    }

    public PsGenderLang(int idGender, int idLang) {
        this.psGenderLangPK = new PsGenderLangPK(idGender, idLang);
    }

    public PsGenderLangPK getPsGenderLangPK() {
        return psGenderLangPK;
    }

    public void setPsGenderLangPK(PsGenderLangPK psGenderLangPK) {
        this.psGenderLangPK = psGenderLangPK;
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
        hash += (psGenderLangPK != null ? psGenderLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGenderLang)) {
            return false;
        }
        PsGenderLang other = (PsGenderLang) object;
        if ((this.psGenderLangPK == null && other.psGenderLangPK != null) || (this.psGenderLangPK != null && !this.psGenderLangPK.equals(other.psGenderLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGenderLang[ psGenderLangPK=" + psGenderLangPK + " ]";
    }
    
}
