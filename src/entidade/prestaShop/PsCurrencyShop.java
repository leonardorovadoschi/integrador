/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ps_currency_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCurrencyShop.findAll", query = "SELECT p FROM PsCurrencyShop p")
    , @NamedQuery(name = "PsCurrencyShop.findByIdCurrency", query = "SELECT p FROM PsCurrencyShop p WHERE p.psCurrencyShopPK.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsCurrencyShop.findByIdShop", query = "SELECT p FROM PsCurrencyShop p WHERE p.psCurrencyShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsCurrencyShop.findByConversionRate", query = "SELECT p FROM PsCurrencyShop p WHERE p.conversionRate = :conversionRate")})
public class PsCurrencyShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCurrencyShopPK psCurrencyShopPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;

    public PsCurrencyShop() {
    }

    public PsCurrencyShop(PsCurrencyShopPK psCurrencyShopPK) {
        this.psCurrencyShopPK = psCurrencyShopPK;
    }

    public PsCurrencyShop(PsCurrencyShopPK psCurrencyShopPK, BigDecimal conversionRate) {
        this.psCurrencyShopPK = psCurrencyShopPK;
        this.conversionRate = conversionRate;
    }

    public PsCurrencyShop(int idCurrency, int idShop) {
        this.psCurrencyShopPK = new PsCurrencyShopPK(idCurrency, idShop);
    }

    public PsCurrencyShopPK getPsCurrencyShopPK() {
        return psCurrencyShopPK;
    }

    public void setPsCurrencyShopPK(PsCurrencyShopPK psCurrencyShopPK) {
        this.psCurrencyShopPK = psCurrencyShopPK;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCurrencyShopPK != null ? psCurrencyShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCurrencyShop)) {
            return false;
        }
        PsCurrencyShop other = (PsCurrencyShop) object;
        if ((this.psCurrencyShopPK == null && other.psCurrencyShopPK != null) || (this.psCurrencyShopPK != null && !this.psCurrencyShopPK.equals(other.psCurrencyShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCurrencyShop[ psCurrencyShopPK=" + psCurrencyShopPK + " ]";
    }
    
}
