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
@Table(name = "ps_specific_price_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSpecificPriceRule.findAll", query = "SELECT p FROM PsSpecificPriceRule p")
    , @NamedQuery(name = "PsSpecificPriceRule.findByIdSpecificPriceRule", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.idSpecificPriceRule = :idSpecificPriceRule")
    , @NamedQuery(name = "PsSpecificPriceRule.findByName", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.name = :name")
    , @NamedQuery(name = "PsSpecificPriceRule.findByIdShop", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsSpecificPriceRule.findByIdCurrency", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsSpecificPriceRule.findByIdCountry", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsSpecificPriceRule.findByIdGroup", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.idGroup = :idGroup")
    , @NamedQuery(name = "PsSpecificPriceRule.findByFromQuantity", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.fromQuantity = :fromQuantity")
    , @NamedQuery(name = "PsSpecificPriceRule.findByPrice", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.price = :price")
    , @NamedQuery(name = "PsSpecificPriceRule.findByReduction", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.reduction = :reduction")
    , @NamedQuery(name = "PsSpecificPriceRule.findByReductionTax", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.reductionTax = :reductionTax")
    , @NamedQuery(name = "PsSpecificPriceRule.findByReductionType", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.reductionType = :reductionType")
    , @NamedQuery(name = "PsSpecificPriceRule.findByFrom", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.from = :from")
    , @NamedQuery(name = "PsSpecificPriceRule.findByTo", query = "SELECT p FROM PsSpecificPriceRule p WHERE p.to = :to")})
public class PsSpecificPriceRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_specific_price_rule")
    private Integer idSpecificPriceRule;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
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
    @Column(name = "from_quantity")
    private int fromQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
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
    @Column(name = "from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
    @Basic(optional = false)
    @Column(name = "to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    public PsSpecificPriceRule() {
    }

    public PsSpecificPriceRule(Integer idSpecificPriceRule) {
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    public PsSpecificPriceRule(Integer idSpecificPriceRule, String name, int idShop, int idCurrency, int idCountry, int idGroup, int fromQuantity, BigDecimal reduction, boolean reductionTax, String reductionType, Date from, Date to) {
        this.idSpecificPriceRule = idSpecificPriceRule;
        this.name = name;
        this.idShop = idShop;
        this.idCurrency = idCurrency;
        this.idCountry = idCountry;
        this.idGroup = idGroup;
        this.fromQuantity = fromQuantity;
        this.reduction = reduction;
        this.reductionTax = reductionTax;
        this.reductionType = reductionType;
        this.from = from;
        this.to = to;
    }

    public Integer getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    public void setIdSpecificPriceRule(Integer idSpecificPriceRule) {
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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

    public int getFromQuantity() {
        return fromQuantity;
    }

    public void setFromQuantity(int fromQuantity) {
        this.fromQuantity = fromQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        hash += (idSpecificPriceRule != null ? idSpecificPriceRule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPriceRule)) {
            return false;
        }
        PsSpecificPriceRule other = (PsSpecificPriceRule) object;
        if ((this.idSpecificPriceRule == null && other.idSpecificPriceRule != null) || (this.idSpecificPriceRule != null && !this.idSpecificPriceRule.equals(other.idSpecificPriceRule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPriceRule[ idSpecificPriceRule=" + idSpecificPriceRule + " ]";
    }
    
}
