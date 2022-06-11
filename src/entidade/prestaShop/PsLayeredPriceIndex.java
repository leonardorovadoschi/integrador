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
@Table(name = "ps_layered_price_index")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredPriceIndex.findAll", query = "SELECT p FROM PsLayeredPriceIndex p")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByIdProduct", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.psLayeredPriceIndexPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByIdCurrency", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.psLayeredPriceIndexPK.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByIdShop", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.psLayeredPriceIndexPK.idShop = :idShop")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByPriceMin", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.priceMin = :priceMin")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByPriceMax", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.priceMax = :priceMax")
    , @NamedQuery(name = "PsLayeredPriceIndex.findByIdCountry", query = "SELECT p FROM PsLayeredPriceIndex p WHERE p.psLayeredPriceIndexPK.idCountry = :idCountry")})
public class PsLayeredPriceIndex implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredPriceIndexPK psLayeredPriceIndexPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price_min")
    private BigDecimal priceMin;
    @Basic(optional = false)
    @Column(name = "price_max")
    private BigDecimal priceMax;

    public PsLayeredPriceIndex() {
    }

    public PsLayeredPriceIndex(PsLayeredPriceIndexPK psLayeredPriceIndexPK) {
        this.psLayeredPriceIndexPK = psLayeredPriceIndexPK;
    }

    public PsLayeredPriceIndex(PsLayeredPriceIndexPK psLayeredPriceIndexPK, BigDecimal priceMin, BigDecimal priceMax) {
        this.psLayeredPriceIndexPK = psLayeredPriceIndexPK;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
    }

    public PsLayeredPriceIndex(int idProduct, int idCurrency, int idShop, int idCountry) {
        this.psLayeredPriceIndexPK = new PsLayeredPriceIndexPK(idProduct, idCurrency, idShop, idCountry);
    }

    public PsLayeredPriceIndexPK getPsLayeredPriceIndexPK() {
        return psLayeredPriceIndexPK;
    }

    public void setPsLayeredPriceIndexPK(PsLayeredPriceIndexPK psLayeredPriceIndexPK) {
        this.psLayeredPriceIndexPK = psLayeredPriceIndexPK;
    }

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public BigDecimal getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceMax = priceMax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLayeredPriceIndexPK != null ? psLayeredPriceIndexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredPriceIndex)) {
            return false;
        }
        PsLayeredPriceIndex other = (PsLayeredPriceIndex) object;
        if ((this.psLayeredPriceIndexPK == null && other.psLayeredPriceIndexPK != null) || (this.psLayeredPriceIndexPK != null && !this.psLayeredPriceIndexPK.equals(other.psLayeredPriceIndexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredPriceIndex[ psLayeredPriceIndexPK=" + psLayeredPriceIndexPK + " ]";
    }
    
}
