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
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_state_lang")

public class PsOrderStateLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderStateLangPK psOrderStateLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "template")
    private String template;

    public PsOrderStateLang() {
    }

    public PsOrderStateLang(PsOrderStateLangPK psOrderStateLangPK) {
        this.psOrderStateLangPK = psOrderStateLangPK;
    }

    public PsOrderStateLang(PsOrderStateLangPK psOrderStateLangPK, String name, String template) {
        this.psOrderStateLangPK = psOrderStateLangPK;
        this.name = name;
        this.template = template;
    }

    public PsOrderStateLang(int idOrderState, int idLang) {
        this.psOrderStateLangPK = new PsOrderStateLangPK(idOrderState, idLang);
    }

    public PsOrderStateLangPK getPsOrderStateLangPK() {
        return psOrderStateLangPK;
    }

    public void setPsOrderStateLangPK(PsOrderStateLangPK psOrderStateLangPK) {
        this.psOrderStateLangPK = psOrderStateLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psOrderStateLangPK != null ? psOrderStateLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderStateLang)) {
            return false;
        }
        PsOrderStateLang other = (PsOrderStateLang) object;
        if ((this.psOrderStateLangPK == null && other.psOrderStateLangPK != null) || (this.psOrderStateLangPK != null && !this.psOrderStateLangPK.equals(other.psOrderStateLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderStateLang[ psOrderStateLangPK=" + psOrderStateLangPK + " ]";
    }
    
}
