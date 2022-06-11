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
@Table(name = "ps_tax_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTaxLang.findAll", query = "SELECT p FROM PsTaxLang p")
    , @NamedQuery(name = "PsTaxLang.findByIdTax", query = "SELECT p FROM PsTaxLang p WHERE p.psTaxLangPK.idTax = :idTax")
    , @NamedQuery(name = "PsTaxLang.findByIdLang", query = "SELECT p FROM PsTaxLang p WHERE p.psTaxLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsTaxLang.findByName", query = "SELECT p FROM PsTaxLang p WHERE p.name = :name")})
public class PsTaxLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsTaxLangPK psTaxLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsTaxLang() {
    }

    public PsTaxLang(PsTaxLangPK psTaxLangPK) {
        this.psTaxLangPK = psTaxLangPK;
    }

    public PsTaxLang(PsTaxLangPK psTaxLangPK, String name) {
        this.psTaxLangPK = psTaxLangPK;
        this.name = name;
    }

    public PsTaxLang(int idTax, int idLang) {
        this.psTaxLangPK = new PsTaxLangPK(idTax, idLang);
    }

    public PsTaxLangPK getPsTaxLangPK() {
        return psTaxLangPK;
    }

    public void setPsTaxLangPK(PsTaxLangPK psTaxLangPK) {
        this.psTaxLangPK = psTaxLangPK;
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
        hash += (psTaxLangPK != null ? psTaxLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTaxLang)) {
            return false;
        }
        PsTaxLang other = (PsTaxLang) object;
        if ((this.psTaxLangPK == null && other.psTaxLangPK != null) || (this.psTaxLangPK != null && !this.psTaxLangPK.equals(other.psTaxLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTaxLang[ psTaxLangPK=" + psTaxLangPK + " ]";
    }
    
}
