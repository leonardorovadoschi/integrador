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
@Table(name = "ps_attribute_group_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttributeGroupLang.findAll", query = "SELECT p FROM PsAttributeGroupLang p")
    , @NamedQuery(name = "PsAttributeGroupLang.findByIdAttributeGroup", query = "SELECT p FROM PsAttributeGroupLang p WHERE p.psAttributeGroupLangPK.idAttributeGroup = :idAttributeGroup")
    , @NamedQuery(name = "PsAttributeGroupLang.findByIdLang", query = "SELECT p FROM PsAttributeGroupLang p WHERE p.psAttributeGroupLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsAttributeGroupLang.findByName", query = "SELECT p FROM PsAttributeGroupLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsAttributeGroupLang.findByPublicName", query = "SELECT p FROM PsAttributeGroupLang p WHERE p.publicName = :publicName")})
public class PsAttributeGroupLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAttributeGroupLangPK psAttributeGroupLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "public_name")
    private String publicName;

    public PsAttributeGroupLang() {
    }

    public PsAttributeGroupLang(PsAttributeGroupLangPK psAttributeGroupLangPK) {
        this.psAttributeGroupLangPK = psAttributeGroupLangPK;
    }

    public PsAttributeGroupLang(PsAttributeGroupLangPK psAttributeGroupLangPK, String name, String publicName) {
        this.psAttributeGroupLangPK = psAttributeGroupLangPK;
        this.name = name;
        this.publicName = publicName;
    }

    public PsAttributeGroupLang(int idAttributeGroup, int idLang) {
        this.psAttributeGroupLangPK = new PsAttributeGroupLangPK(idAttributeGroup, idLang);
    }

    public PsAttributeGroupLangPK getPsAttributeGroupLangPK() {
        return psAttributeGroupLangPK;
    }

    public void setPsAttributeGroupLangPK(PsAttributeGroupLangPK psAttributeGroupLangPK) {
        this.psAttributeGroupLangPK = psAttributeGroupLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAttributeGroupLangPK != null ? psAttributeGroupLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeGroupLang)) {
            return false;
        }
        PsAttributeGroupLang other = (PsAttributeGroupLang) object;
        if ((this.psAttributeGroupLangPK == null && other.psAttributeGroupLangPK != null) || (this.psAttributeGroupLangPK != null && !this.psAttributeGroupLangPK.equals(other.psAttributeGroupLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeGroupLang[ psAttributeGroupLangPK=" + psAttributeGroupLangPK + " ]";
    }
    
}
