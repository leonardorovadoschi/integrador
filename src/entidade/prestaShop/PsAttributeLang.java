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
@Table(name = "ps_attribute_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttributeLang.findAll", query = "SELECT p FROM PsAttributeLang p")
    , @NamedQuery(name = "PsAttributeLang.findByIdAttribute", query = "SELECT p FROM PsAttributeLang p WHERE p.psAttributeLangPK.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsAttributeLang.findByIdLang", query = "SELECT p FROM PsAttributeLang p WHERE p.psAttributeLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsAttributeLang.findByName", query = "SELECT p FROM PsAttributeLang p WHERE p.name = :name")})
public class PsAttributeLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAttributeLangPK psAttributeLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsAttributeLang() {
    }

    public PsAttributeLang(PsAttributeLangPK psAttributeLangPK) {
        this.psAttributeLangPK = psAttributeLangPK;
    }

    public PsAttributeLang(PsAttributeLangPK psAttributeLangPK, String name) {
        this.psAttributeLangPK = psAttributeLangPK;
        this.name = name;
    }

    public PsAttributeLang(int idAttribute, int idLang) {
        this.psAttributeLangPK = new PsAttributeLangPK(idAttribute, idLang);
    }

    public PsAttributeLangPK getPsAttributeLangPK() {
        return psAttributeLangPK;
    }

    public void setPsAttributeLangPK(PsAttributeLangPK psAttributeLangPK) {
        this.psAttributeLangPK = psAttributeLangPK;
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
        hash += (psAttributeLangPK != null ? psAttributeLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeLang)) {
            return false;
        }
        PsAttributeLang other = (PsAttributeLang) object;
        if ((this.psAttributeLangPK == null && other.psAttributeLangPK != null) || (this.psAttributeLangPK != null && !this.psAttributeLangPK.equals(other.psAttributeLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeLang[ psAttributeLangPK=" + psAttributeLangPK + " ]";
    }
    
}
