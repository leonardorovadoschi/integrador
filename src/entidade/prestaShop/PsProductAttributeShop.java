/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_product_attribute_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttributeShop.findAll", query = "SELECT p FROM PsProductAttributeShop p")
    , @NamedQuery(name = "PsProductAttributeShop.findByIdProduct", query = "SELECT p FROM PsProductAttributeShop p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductAttributeShop.findByIdProductAttribute", query = "SELECT p FROM PsProductAttributeShop p WHERE p.psProductAttributeShopPK.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsProductAttributeShop.findByIdShop", query = "SELECT p FROM PsProductAttributeShop p WHERE p.psProductAttributeShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsProductAttributeShop.findByWholesalePrice", query = "SELECT p FROM PsProductAttributeShop p WHERE p.wholesalePrice = :wholesalePrice")
    , @NamedQuery(name = "PsProductAttributeShop.findByPrice", query = "SELECT p FROM PsProductAttributeShop p WHERE p.price = :price")
    , @NamedQuery(name = "PsProductAttributeShop.findByEcotax", query = "SELECT p FROM PsProductAttributeShop p WHERE p.ecotax = :ecotax")
    , @NamedQuery(name = "PsProductAttributeShop.findByWeight", query = "SELECT p FROM PsProductAttributeShop p WHERE p.weight = :weight")
    , @NamedQuery(name = "PsProductAttributeShop.findByUnitPriceImpact", query = "SELECT p FROM PsProductAttributeShop p WHERE p.unitPriceImpact = :unitPriceImpact")
    , @NamedQuery(name = "PsProductAttributeShop.findByDefaultOn", query = "SELECT p FROM PsProductAttributeShop p WHERE p.defaultOn = :defaultOn")
    , @NamedQuery(name = "PsProductAttributeShop.findByMinimalQuantity", query = "SELECT p FROM PsProductAttributeShop p WHERE p.minimalQuantity = :minimalQuantity")
    , @NamedQuery(name = "PsProductAttributeShop.findByLowStockThreshold", query = "SELECT p FROM PsProductAttributeShop p WHERE p.lowStockThreshold = :lowStockThreshold")
    , @NamedQuery(name = "PsProductAttributeShop.findByLowStockAlert", query = "SELECT p FROM PsProductAttributeShop p WHERE p.lowStockAlert = :lowStockAlert")
    , @NamedQuery(name = "PsProductAttributeShop.findByAvailableDate", query = "SELECT p FROM PsProductAttributeShop p WHERE p.availableDate = :availableDate")})
public class PsProductAttributeShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductAttributeShopPK psProductAttributeShopPK;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @Column(name = "unit_price_impact")
    private BigDecimal unitPriceImpact;
    @Column(name = "default_on")
    private Boolean defaultOn;
    @Basic(optional = false)
    @Column(name = "minimal_quantity")
    private int minimalQuantity;
    @Column(name = "low_stock_threshold")
    private Integer lowStockThreshold;
    @Basic(optional = false)
    @Column(name = "low_stock_alert")
    private boolean lowStockAlert;
    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;

    public PsProductAttributeShop() {
    }

    public PsProductAttributeShop(PsProductAttributeShopPK psProductAttributeShopPK) {
        this.psProductAttributeShopPK = psProductAttributeShopPK;
    }

    public PsProductAttributeShop(PsProductAttributeShopPK psProductAttributeShopPK, int idProduct, BigDecimal wholesalePrice, BigDecimal price, BigDecimal ecotax, BigDecimal weight, BigDecimal unitPriceImpact, int minimalQuantity, boolean lowStockAlert) {
        this.psProductAttributeShopPK = psProductAttributeShopPK;
        this.idProduct = idProduct;
        this.wholesalePrice = wholesalePrice;
        this.price = price;
        this.ecotax = ecotax;
        this.weight = weight;
        this.unitPriceImpact = unitPriceImpact;
        this.minimalQuantity = minimalQuantity;
        this.lowStockAlert = lowStockAlert;
    }

    public PsProductAttributeShop(int idProductAttribute, int idShop) {
        this.psProductAttributeShopPK = new PsProductAttributeShopPK(idProductAttribute, idShop);
    }

    public PsProductAttributeShopPK getPsProductAttributeShopPK() {
        return psProductAttributeShopPK;
    }

    public void setPsProductAttributeShopPK(PsProductAttributeShopPK psProductAttributeShopPK) {
        this.psProductAttributeShopPK = psProductAttributeShopPK;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        this.ecotax = ecotax;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getUnitPriceImpact() {
        return unitPriceImpact;
    }

    public void setUnitPriceImpact(BigDecimal unitPriceImpact) {
        this.unitPriceImpact = unitPriceImpact;
    }

    public Boolean getDefaultOn() {
        return defaultOn;
    }

    public void setDefaultOn(Boolean defaultOn) {
        this.defaultOn = defaultOn;
    }

    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(int minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public Integer getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Integer lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    public boolean getLowStockAlert() {
        return lowStockAlert;
    }

    public void setLowStockAlert(boolean lowStockAlert) {
        this.lowStockAlert = lowStockAlert;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductAttributeShopPK != null ? psProductAttributeShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeShop)) {
            return false;
        }
        PsProductAttributeShop other = (PsProductAttributeShop) object;
        if ((this.psProductAttributeShopPK == null && other.psProductAttributeShopPK != null) || (this.psProductAttributeShopPK != null && !this.psProductAttributeShopPK.equals(other.psProductAttributeShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductAttributeShop[ psProductAttributeShopPK=" + psProductAttributeShopPK + " ]";
    }
    
}
