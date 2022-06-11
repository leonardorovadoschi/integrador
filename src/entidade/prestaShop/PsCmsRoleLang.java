/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_cms_role_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsRoleLang.findAll", query = "SELECT p FROM PsCmsRoleLang p")
    , @NamedQuery(name = "PsCmsRoleLang.findByIdCmsRole", query = "SELECT p FROM PsCmsRoleLang p WHERE p.psCmsRoleLangPK.idCmsRole = :idCmsRole")
    , @NamedQuery(name = "PsCmsRoleLang.findByIdLang", query = "SELECT p FROM PsCmsRoleLang p WHERE p.psCmsRoleLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCmsRoleLang.findByIdShop", query = "SELECT p FROM PsCmsRoleLang p WHERE p.psCmsRoleLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCmsRoleLang.findByName", query = "SELECT p FROM PsCmsRoleLang p WHERE p.name = :name")})
public class PsCmsRoleLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsRoleLangPK psCmsRoleLangPK;
    @Column(name = "name")
    private String name;

    public PsCmsRoleLang() {
    }

    public PsCmsRoleLang(PsCmsRoleLangPK psCmsRoleLangPK) {
        this.psCmsRoleLangPK = psCmsRoleLangPK;
    }

    public PsCmsRoleLang(int idCmsRole, int idLang, int idShop) {
        this.psCmsRoleLangPK = new PsCmsRoleLangPK(idCmsRole, idLang, idShop);
    }

    public PsCmsRoleLangPK getPsCmsRoleLangPK() {
        return psCmsRoleLangPK;
    }

    public void setPsCmsRoleLangPK(PsCmsRoleLangPK psCmsRoleLangPK) {
        this.psCmsRoleLangPK = psCmsRoleLangPK;
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
        hash += (psCmsRoleLangPK != null ? psCmsRoleLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsRoleLang)) {
            return false;
        }
        PsCmsRoleLang other = (PsCmsRoleLang) object;
        if ((this.psCmsRoleLangPK == null && other.psCmsRoleLangPK != null) || (this.psCmsRoleLangPK != null && !this.psCmsRoleLangPK.equals(other.psCmsRoleLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsRoleLang[ psCmsRoleLangPK=" + psCmsRoleLangPK + " ]";
    }
    
}
