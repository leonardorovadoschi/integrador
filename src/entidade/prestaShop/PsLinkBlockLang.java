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
@Table(name = "ps_link_block_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLinkBlockLang.findAll", query = "SELECT p FROM PsLinkBlockLang p")
    , @NamedQuery(name = "PsLinkBlockLang.findByIdLinkBlock", query = "SELECT p FROM PsLinkBlockLang p WHERE p.psLinkBlockLangPK.idLinkBlock = :idLinkBlock")
    , @NamedQuery(name = "PsLinkBlockLang.findByIdLang", query = "SELECT p FROM PsLinkBlockLang p WHERE p.psLinkBlockLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsLinkBlockLang.findByName", query = "SELECT p FROM PsLinkBlockLang p WHERE p.name = :name")})
public class PsLinkBlockLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLinkBlockLangPK psLinkBlockLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "custom_content")
    private String customContent;

    public PsLinkBlockLang() {
    }

    public PsLinkBlockLang(PsLinkBlockLangPK psLinkBlockLangPK) {
        this.psLinkBlockLangPK = psLinkBlockLangPK;
    }

    public PsLinkBlockLang(PsLinkBlockLangPK psLinkBlockLangPK, String name) {
        this.psLinkBlockLangPK = psLinkBlockLangPK;
        this.name = name;
    }

    public PsLinkBlockLang(int idLinkBlock, int idLang) {
        this.psLinkBlockLangPK = new PsLinkBlockLangPK(idLinkBlock, idLang);
    }

    public PsLinkBlockLangPK getPsLinkBlockLangPK() {
        return psLinkBlockLangPK;
    }

    public void setPsLinkBlockLangPK(PsLinkBlockLangPK psLinkBlockLangPK) {
        this.psLinkBlockLangPK = psLinkBlockLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomContent() {
        return customContent;
    }

    public void setCustomContent(String customContent) {
        this.customContent = customContent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLinkBlockLangPK != null ? psLinkBlockLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinkBlockLang)) {
            return false;
        }
        PsLinkBlockLang other = (PsLinkBlockLang) object;
        if ((this.psLinkBlockLangPK == null && other.psLinkBlockLangPK != null) || (this.psLinkBlockLangPK != null && !this.psLinkBlockLangPK.equals(other.psLinkBlockLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinkBlockLang[ psLinkBlockLangPK=" + psLinkBlockLangPK + " ]";
    }
    
}
