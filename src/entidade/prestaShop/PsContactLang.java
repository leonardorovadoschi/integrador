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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_contact_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsContactLang.findAll", query = "SELECT p FROM PsContactLang p")
    , @NamedQuery(name = "PsContactLang.findByIdContact", query = "SELECT p FROM PsContactLang p WHERE p.psContactLangPK.idContact = :idContact")
    , @NamedQuery(name = "PsContactLang.findByIdLang", query = "SELECT p FROM PsContactLang p WHERE p.psContactLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsContactLang.findByName", query = "SELECT p FROM PsContactLang p WHERE p.name = :name")})
public class PsContactLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsContactLangPK psContactLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;

    public PsContactLang() {
    }

    public PsContactLang(PsContactLangPK psContactLangPK) {
        this.psContactLangPK = psContactLangPK;
    }

    public PsContactLang(PsContactLangPK psContactLangPK, String name) {
        this.psContactLangPK = psContactLangPK;
        this.name = name;
    }

    public PsContactLang(int idContact, int idLang) {
        this.psContactLangPK = new PsContactLangPK(idContact, idLang);
    }

    public PsContactLangPK getPsContactLangPK() {
        return psContactLangPK;
    }

    public void setPsContactLangPK(PsContactLangPK psContactLangPK) {
        this.psContactLangPK = psContactLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psContactLangPK != null ? psContactLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsContactLang)) {
            return false;
        }
        PsContactLang other = (PsContactLang) object;
        if ((this.psContactLangPK == null && other.psContactLangPK != null) || (this.psContactLangPK != null && !this.psContactLangPK.equals(other.psContactLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsContactLang[ psContactLangPK=" + psContactLangPK + " ]";
    }
    
}
