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
@Table(name = "ps_cart_rule_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCartRuleLang.findAll", query = "SELECT p FROM PsCartRuleLang p")
    , @NamedQuery(name = "PsCartRuleLang.findByIdCartRule", query = "SELECT p FROM PsCartRuleLang p WHERE p.psCartRuleLangPK.idCartRule = :idCartRule")
    , @NamedQuery(name = "PsCartRuleLang.findByIdLang", query = "SELECT p FROM PsCartRuleLang p WHERE p.psCartRuleLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCartRuleLang.findByName", query = "SELECT p FROM PsCartRuleLang p WHERE p.name = :name")})
public class PsCartRuleLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartRuleLangPK psCartRuleLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsCartRuleLang() {
    }

    public PsCartRuleLang(PsCartRuleLangPK psCartRuleLangPK) {
        this.psCartRuleLangPK = psCartRuleLangPK;
    }

    public PsCartRuleLang(PsCartRuleLangPK psCartRuleLangPK, String name) {
        this.psCartRuleLangPK = psCartRuleLangPK;
        this.name = name;
    }

    public PsCartRuleLang(int idCartRule, int idLang) {
        this.psCartRuleLangPK = new PsCartRuleLangPK(idCartRule, idLang);
    }

    public PsCartRuleLangPK getPsCartRuleLangPK() {
        return psCartRuleLangPK;
    }

    public void setPsCartRuleLangPK(PsCartRuleLangPK psCartRuleLangPK) {
        this.psCartRuleLangPK = psCartRuleLangPK;
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
        hash += (psCartRuleLangPK != null ? psCartRuleLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleLang)) {
            return false;
        }
        PsCartRuleLang other = (PsCartRuleLang) object;
        if ((this.psCartRuleLangPK == null && other.psCartRuleLangPK != null) || (this.psCartRuleLangPK != null && !this.psCartRuleLangPK.equals(other.psCartRuleLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleLang[ psCartRuleLangPK=" + psCartRuleLangPK + " ]";
    }
    
}
