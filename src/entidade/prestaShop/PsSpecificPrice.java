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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ps_specific_price")

public class PsSpecificPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_specific_price")
    private Integer idSpecificPrice;
    @Basic(optional = false)
    @Column(name = "id_specific_price_rule")
    private int idSpecificPriceRule;
    @Basic(optional = false)
    @Column(name = "id_cart")
    private int idCart;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "from_quantity")
    private int fromQuantity;
    @Basic(optional = false)
    @Column(name = "reduction")
    private BigDecimal reduction;
    @Basic(optional = false)
    @Column(name = "reduction_tax")
    private boolean reductionTax;
    @Basic(optional = false)
    @Column(name = "reduction_type")
    private String reductionType;
    @Basic(optional = false)
    @Column(name = "\"from\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
    @Basic(optional = false)
    @Column(name = "\"to\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    public PsSpecificPrice() {
    }

    public PsSpecificPrice(Integer idSpecificPrice) {
        this.idSpecificPrice = idSpecificPrice;
    }

    public PsSpecificPrice(Integer idSpecificPrice, int idSpecificPriceRule, int idCart, int idProduct, int idShop, int idShopGroup, int idCurrency, int idCountry, int idGroup, int idCustomer, int idProductAttribute, BigDecimal price, int fromQuantity, BigDecimal reduction, boolean reductionTax, String reductionType, Date from, Date to) {
        this.idSpecificPrice = idSpecificPrice;
        this.idSpecificPriceRule = idSpecificPriceRule;
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.idCurrency = idCurrency;
        this.idCountry = idCountry;
        this.idGroup = idGroup;
        this.idCustomer = idCustomer;
        this.idProductAttribute = idProductAttribute;
        this.price = price;
        this.fromQuantity = fromQuantity;
        this.reduction = reduction;
        this.reductionTax = reductionTax;
        this.reductionType = reductionType;
        this.from = from;
        this.to = to;
    }

    public Integer getIdSpecificPrice() {
        return idSpecificPrice;
    }

    public void setIdSpecificPrice(Integer idSpecificPrice) {
        this.idSpecificPrice = idSpecificPrice;
    }

    public int getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    public void setIdSpecificPriceRule(int idSpecificPriceRule) {
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFromQuantity() {
        return fromQuantity;
    }

    public void setFromQuantity(int fromQuantity) {
        this.fromQuantity = fromQuantity;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    public boolean getReductionTax() {
        return reductionTax;
    }

    public void setReductionTax(boolean reductionTax) {
        this.reductionTax = reductionTax;
    }

    public String getReductionType() {
        return reductionType;
    }

    public void setReductionType(String reductionType) {
        this.reductionType = reductionType;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecificPrice != null ? idSpecificPrice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPrice)) {
            return false;
        }
        PsSpecificPrice other = (PsSpecificPrice) object;
        if ((this.idSpecificPrice == null && other.idSpecificPrice != null) || (this.idSpecificPrice != null && !this.idSpecificPrice.equals(other.idSpecificPrice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPrice[ idSpecificPrice=" + idSpecificPrice + " ]";
    }
    
}
