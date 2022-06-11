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
@Table(name = "ps_currency_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCurrencyLang.findAll", query = "SELECT p FROM PsCurrencyLang p")
    , @NamedQuery(name = "PsCurrencyLang.findByIdCurrency", query = "SELECT p FROM PsCurrencyLang p WHERE p.psCurrencyLangPK.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsCurrencyLang.findByIdLang", query = "SELECT p FROM PsCurrencyLang p WHERE p.psCurrencyLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCurrencyLang.findByName", query = "SELECT p FROM PsCurrencyLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsCurrencyLang.findBySymbol", query = "SELECT p FROM PsCurrencyLang p WHERE p.symbol = :symbol")})
public class PsCurrencyLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCurrencyLangPK psCurrencyLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "symbol")
    private String symbol;

    public PsCurrencyLang() {
    }

    public PsCurrencyLang(PsCurrencyLangPK psCurrencyLangPK) {
        this.psCurrencyLangPK = psCurrencyLangPK;
    }

    public PsCurrencyLang(PsCurrencyLangPK psCurrencyLangPK, String name, String symbol) {
        this.psCurrencyLangPK = psCurrencyLangPK;
        this.name = name;
        this.symbol = symbol;
    }

    public PsCurrencyLang(int idCurrency, int idLang) {
        this.psCurrencyLangPK = new PsCurrencyLangPK(idCurrency, idLang);
    }

    public PsCurrencyLangPK getPsCurrencyLangPK() {
        return psCurrencyLangPK;
    }

    public void setPsCurrencyLangPK(PsCurrencyLangPK psCurrencyLangPK) {
        this.psCurrencyLangPK = psCurrencyLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCurrencyLangPK != null ? psCurrencyLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCurrencyLang)) {
            return false;
        }
        PsCurrencyLang other = (PsCurrencyLang) object;
        if ((this.psCurrencyLangPK == null && other.psCurrencyLangPK != null) || (this.psCurrencyLangPK != null && !this.psCurrencyLangPK.equals(other.psCurrencyLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCurrencyLang[ psCurrencyLangPK=" + psCurrencyLangPK + " ]";
    }
    
}
