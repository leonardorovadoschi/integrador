/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ps_referrer_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsReferrerShop.findAll", query = "SELECT p FROM PsReferrerShop p")
    , @NamedQuery(name = "PsReferrerShop.findByIdReferrer", query = "SELECT p FROM PsReferrerShop p WHERE p.psReferrerShopPK.idReferrer = :idReferrer")
    , @NamedQuery(name = "PsReferrerShop.findByIdShop", query = "SELECT p FROM PsReferrerShop p WHERE p.psReferrerShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsReferrerShop.findByCacheVisitors", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheVisitors = :cacheVisitors")
    , @NamedQuery(name = "PsReferrerShop.findByCacheVisits", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheVisits = :cacheVisits")
    , @NamedQuery(name = "PsReferrerShop.findByCachePages", query = "SELECT p FROM PsReferrerShop p WHERE p.cachePages = :cachePages")
    , @NamedQuery(name = "PsReferrerShop.findByCacheRegistrations", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheRegistrations = :cacheRegistrations")
    , @NamedQuery(name = "PsReferrerShop.findByCacheOrders", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheOrders = :cacheOrders")
    , @NamedQuery(name = "PsReferrerShop.findByCacheSales", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheSales = :cacheSales")
    , @NamedQuery(name = "PsReferrerShop.findByCacheRegRate", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheRegRate = :cacheRegRate")
    , @NamedQuery(name = "PsReferrerShop.findByCacheOrderRate", query = "SELECT p FROM PsReferrerShop p WHERE p.cacheOrderRate = :cacheOrderRate")})
public class PsReferrerShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsReferrerShopPK psReferrerShopPK;
    @Column(name = "cache_visitors")
    private Integer cacheVisitors;
    @Column(name = "cache_visits")
    private Integer cacheVisits;
    @Column(name = "cache_pages")
    private Integer cachePages;
    @Column(name = "cache_registrations")
    private Integer cacheRegistrations;
    @Column(name = "cache_orders")
    private Integer cacheOrders;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cache_sales")
    private BigDecimal cacheSales;
    @Column(name = "cache_reg_rate")
    private BigDecimal cacheRegRate;
    @Column(name = "cache_order_rate")
    private BigDecimal cacheOrderRate;

    public PsReferrerShop() {
    }

    public PsReferrerShop(PsReferrerShopPK psReferrerShopPK) {
        this.psReferrerShopPK = psReferrerShopPK;
    }

    public PsReferrerShop(int idReferrer, int idShop) {
        this.psReferrerShopPK = new PsReferrerShopPK(idReferrer, idShop);
    }

    public PsReferrerShopPK getPsReferrerShopPK() {
        return psReferrerShopPK;
    }

    public void setPsReferrerShopPK(PsReferrerShopPK psReferrerShopPK) {
        this.psReferrerShopPK = psReferrerShopPK;
    }

    public Integer getCacheVisitors() {
        return cacheVisitors;
    }

    public void setCacheVisitors(Integer cacheVisitors) {
        this.cacheVisitors = cacheVisitors;
    }

    public Integer getCacheVisits() {
        return cacheVisits;
    }

    public void setCacheVisits(Integer cacheVisits) {
        this.cacheVisits = cacheVisits;
    }

    public Integer getCachePages() {
        return cachePages;
    }

    public void setCachePages(Integer cachePages) {
        this.cachePages = cachePages;
    }

    public Integer getCacheRegistrations() {
        return cacheRegistrations;
    }

    public void setCacheRegistrations(Integer cacheRegistrations) {
        this.cacheRegistrations = cacheRegistrations;
    }

    public Integer getCacheOrders() {
        return cacheOrders;
    }

    public void setCacheOrders(Integer cacheOrders) {
        this.cacheOrders = cacheOrders;
    }

    public BigDecimal getCacheSales() {
        return cacheSales;
    }

    public void setCacheSales(BigDecimal cacheSales) {
        this.cacheSales = cacheSales;
    }

    public BigDecimal getCacheRegRate() {
        return cacheRegRate;
    }

    public void setCacheRegRate(BigDecimal cacheRegRate) {
        this.cacheRegRate = cacheRegRate;
    }

    public BigDecimal getCacheOrderRate() {
        return cacheOrderRate;
    }

    public void setCacheOrderRate(BigDecimal cacheOrderRate) {
        this.cacheOrderRate = cacheOrderRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psReferrerShopPK != null ? psReferrerShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReferrerShop)) {
            return false;
        }
        PsReferrerShop other = (PsReferrerShop) object;
        if ((this.psReferrerShopPK == null && other.psReferrerShopPK != null) || (this.psReferrerShopPK != null && !this.psReferrerShopPK.equals(other.psReferrerShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReferrerShop[ psReferrerShopPK=" + psReferrerShopPK + " ]";
    }
    
}
