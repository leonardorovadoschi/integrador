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
@Table(name = "ps_customization_field_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomizationFieldLang.findAll", query = "SELECT p FROM PsCustomizationFieldLang p")
    , @NamedQuery(name = "PsCustomizationFieldLang.findByIdCustomizationField", query = "SELECT p FROM PsCustomizationFieldLang p WHERE p.psCustomizationFieldLangPK.idCustomizationField = :idCustomizationField")
    , @NamedQuery(name = "PsCustomizationFieldLang.findByIdLang", query = "SELECT p FROM PsCustomizationFieldLang p WHERE p.psCustomizationFieldLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCustomizationFieldLang.findByIdShop", query = "SELECT p FROM PsCustomizationFieldLang p WHERE p.psCustomizationFieldLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCustomizationFieldLang.findByName", query = "SELECT p FROM PsCustomizationFieldLang p WHERE p.name = :name")})
public class PsCustomizationFieldLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomizationFieldLangPK psCustomizationFieldLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsCustomizationFieldLang() {
    }

    public PsCustomizationFieldLang(PsCustomizationFieldLangPK psCustomizationFieldLangPK) {
        this.psCustomizationFieldLangPK = psCustomizationFieldLangPK;
    }

    public PsCustomizationFieldLang(PsCustomizationFieldLangPK psCustomizationFieldLangPK, String name) {
        this.psCustomizationFieldLangPK = psCustomizationFieldLangPK;
        this.name = name;
    }

    public PsCustomizationFieldLang(int idCustomizationField, int idLang, int idShop) {
        this.psCustomizationFieldLangPK = new PsCustomizationFieldLangPK(idCustomizationField, idLang, idShop);
    }

    public PsCustomizationFieldLangPK getPsCustomizationFieldLangPK() {
        return psCustomizationFieldLangPK;
    }

    public void setPsCustomizationFieldLangPK(PsCustomizationFieldLangPK psCustomizationFieldLangPK) {
        this.psCustomizationFieldLangPK = psCustomizationFieldLangPK;
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
        hash += (psCustomizationFieldLangPK != null ? psCustomizationFieldLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizationFieldLang)) {
            return false;
        }
        PsCustomizationFieldLang other = (PsCustomizationFieldLang) object;
        if ((this.psCustomizationFieldLangPK == null && other.psCustomizationFieldLangPK != null) || (this.psCustomizationFieldLangPK != null && !this.psCustomizationFieldLangPK.equals(other.psCustomizationFieldLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizationFieldLang[ psCustomizationFieldLangPK=" + psCustomizationFieldLangPK + " ]";
    }
    
}
