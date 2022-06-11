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
@Table(name = "ps_badge_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsBadgeLang.findAll", query = "SELECT p FROM PsBadgeLang p")
    , @NamedQuery(name = "PsBadgeLang.findByIdBadge", query = "SELECT p FROM PsBadgeLang p WHERE p.psBadgeLangPK.idBadge = :idBadge")
    , @NamedQuery(name = "PsBadgeLang.findByIdLang", query = "SELECT p FROM PsBadgeLang p WHERE p.psBadgeLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsBadgeLang.findByName", query = "SELECT p FROM PsBadgeLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsBadgeLang.findByDescription", query = "SELECT p FROM PsBadgeLang p WHERE p.description = :description")
    , @NamedQuery(name = "PsBadgeLang.findByGroupName", query = "SELECT p FROM PsBadgeLang p WHERE p.groupName = :groupName")})
public class PsBadgeLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsBadgeLangPK psBadgeLangPK;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "group_name")
    private String groupName;

    public PsBadgeLang() {
    }

    public PsBadgeLang(PsBadgeLangPK psBadgeLangPK) {
        this.psBadgeLangPK = psBadgeLangPK;
    }

    public PsBadgeLang(int idBadge, int idLang) {
        this.psBadgeLangPK = new PsBadgeLangPK(idBadge, idLang);
    }

    public PsBadgeLangPK getPsBadgeLangPK() {
        return psBadgeLangPK;
    }

    public void setPsBadgeLangPK(PsBadgeLangPK psBadgeLangPK) {
        this.psBadgeLangPK = psBadgeLangPK;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psBadgeLangPK != null ? psBadgeLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsBadgeLang)) {
            return false;
        }
        PsBadgeLang other = (PsBadgeLang) object;
        if ((this.psBadgeLangPK == null && other.psBadgeLangPK != null) || (this.psBadgeLangPK != null && !this.psBadgeLangPK.equals(other.psBadgeLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsBadgeLang[ psBadgeLangPK=" + psBadgeLangPK + " ]";
    }
    
}
