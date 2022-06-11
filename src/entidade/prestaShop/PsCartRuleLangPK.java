/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsCartRuleLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cart_rule")
    private int idCartRule;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsCartRuleLangPK() {
    }

    public PsCartRuleLangPK(int idCartRule, int idLang) {
        this.idCartRule = idCartRule;
        this.idLang = idLang;
    }

    public int getIdCartRule() {
        return idCartRule;
    }

    public void setIdCartRule(int idCartRule) {
        this.idCartRule = idCartRule;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCartRule;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartRuleLangPK)) {
            return false;
        }
        PsCartRuleLangPK other = (PsCartRuleLangPK) object;
        if (this.idCartRule != other.idCartRule) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartRuleLangPK[ idCartRule=" + idCartRule + ", idLang=" + idLang + " ]";
    }
    
}
