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
@Table(name = "ps_order_return_state_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderReturnStateLang.findAll", query = "SELECT p FROM PsOrderReturnStateLang p")
    , @NamedQuery(name = "PsOrderReturnStateLang.findByIdOrderReturnState", query = "SELECT p FROM PsOrderReturnStateLang p WHERE p.psOrderReturnStateLangPK.idOrderReturnState = :idOrderReturnState")
    , @NamedQuery(name = "PsOrderReturnStateLang.findByIdLang", query = "SELECT p FROM PsOrderReturnStateLang p WHERE p.psOrderReturnStateLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsOrderReturnStateLang.findByName", query = "SELECT p FROM PsOrderReturnStateLang p WHERE p.name = :name")})
public class PsOrderReturnStateLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderReturnStateLangPK psOrderReturnStateLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsOrderReturnStateLang() {
    }

    public PsOrderReturnStateLang(PsOrderReturnStateLangPK psOrderReturnStateLangPK) {
        this.psOrderReturnStateLangPK = psOrderReturnStateLangPK;
    }

    public PsOrderReturnStateLang(PsOrderReturnStateLangPK psOrderReturnStateLangPK, String name) {
        this.psOrderReturnStateLangPK = psOrderReturnStateLangPK;
        this.name = name;
    }

    public PsOrderReturnStateLang(int idOrderReturnState, int idLang) {
        this.psOrderReturnStateLangPK = new PsOrderReturnStateLangPK(idOrderReturnState, idLang);
    }

    public PsOrderReturnStateLangPK getPsOrderReturnStateLangPK() {
        return psOrderReturnStateLangPK;
    }

    public void setPsOrderReturnStateLangPK(PsOrderReturnStateLangPK psOrderReturnStateLangPK) {
        this.psOrderReturnStateLangPK = psOrderReturnStateLangPK;
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
        hash += (psOrderReturnStateLangPK != null ? psOrderReturnStateLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderReturnStateLang)) {
            return false;
        }
        PsOrderReturnStateLang other = (PsOrderReturnStateLang) object;
        if ((this.psOrderReturnStateLangPK == null && other.psOrderReturnStateLangPK != null) || (this.psOrderReturnStateLangPK != null && !this.psOrderReturnStateLangPK.equals(other.psOrderReturnStateLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderReturnStateLang[ psOrderReturnStateLangPK=" + psOrderReturnStateLangPK + " ]";
    }
    
}
