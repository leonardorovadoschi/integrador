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
@Table(name = "ps_supply_order_state_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplyOrderStateLang.findAll", query = "SELECT p FROM PsSupplyOrderStateLang p")
    , @NamedQuery(name = "PsSupplyOrderStateLang.findByIdSupplyOrderState", query = "SELECT p FROM PsSupplyOrderStateLang p WHERE p.psSupplyOrderStateLangPK.idSupplyOrderState = :idSupplyOrderState")
    , @NamedQuery(name = "PsSupplyOrderStateLang.findByIdLang", query = "SELECT p FROM PsSupplyOrderStateLang p WHERE p.psSupplyOrderStateLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsSupplyOrderStateLang.findByName", query = "SELECT p FROM PsSupplyOrderStateLang p WHERE p.name = :name")})
public class PsSupplyOrderStateLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSupplyOrderStateLangPK psSupplyOrderStateLangPK;
    @Column(name = "name")
    private String name;

    public PsSupplyOrderStateLang() {
    }

    public PsSupplyOrderStateLang(PsSupplyOrderStateLangPK psSupplyOrderStateLangPK) {
        this.psSupplyOrderStateLangPK = psSupplyOrderStateLangPK;
    }

    public PsSupplyOrderStateLang(int idSupplyOrderState, int idLang) {
        this.psSupplyOrderStateLangPK = new PsSupplyOrderStateLangPK(idSupplyOrderState, idLang);
    }

    public PsSupplyOrderStateLangPK getPsSupplyOrderStateLangPK() {
        return psSupplyOrderStateLangPK;
    }

    public void setPsSupplyOrderStateLangPK(PsSupplyOrderStateLangPK psSupplyOrderStateLangPK) {
        this.psSupplyOrderStateLangPK = psSupplyOrderStateLangPK;
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
        hash += (psSupplyOrderStateLangPK != null ? psSupplyOrderStateLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplyOrderStateLang)) {
            return false;
        }
        PsSupplyOrderStateLang other = (PsSupplyOrderStateLang) object;
        if ((this.psSupplyOrderStateLangPK == null && other.psSupplyOrderStateLangPK != null) || (this.psSupplyOrderStateLangPK != null && !this.psSupplyOrderStateLangPK.equals(other.psSupplyOrderStateLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplyOrderStateLang[ psSupplyOrderStateLangPK=" + psSupplyOrderStateLangPK + " ]";
    }
    
}
