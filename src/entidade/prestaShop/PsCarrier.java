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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrier.findAll", query = "SELECT p FROM PsCarrier p")
    , @NamedQuery(name = "PsCarrier.findByIdCarrier", query = "SELECT p FROM PsCarrier p WHERE p.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrier.findByIdReference", query = "SELECT p FROM PsCarrier p WHERE p.idReference = :idReference")
    , @NamedQuery(name = "PsCarrier.findByIdTaxRulesGroup", query = "SELECT p FROM PsCarrier p WHERE p.idTaxRulesGroup = :idTaxRulesGroup")
    , @NamedQuery(name = "PsCarrier.findByName", query = "SELECT p FROM PsCarrier p WHERE p.name = :name")
    , @NamedQuery(name = "PsCarrier.findByUrl", query = "SELECT p FROM PsCarrier p WHERE p.url = :url")
    , @NamedQuery(name = "PsCarrier.findByActive", query = "SELECT p FROM PsCarrier p WHERE p.active = :active")
    , @NamedQuery(name = "PsCarrier.findByDeleted", query = "SELECT p FROM PsCarrier p WHERE p.deleted = :deleted")
    , @NamedQuery(name = "PsCarrier.findByShippingHandling", query = "SELECT p FROM PsCarrier p WHERE p.shippingHandling = :shippingHandling")
    , @NamedQuery(name = "PsCarrier.findByRangeBehavior", query = "SELECT p FROM PsCarrier p WHERE p.rangeBehavior = :rangeBehavior")
    , @NamedQuery(name = "PsCarrier.findByIsModule", query = "SELECT p FROM PsCarrier p WHERE p.isModule = :isModule")
    , @NamedQuery(name = "PsCarrier.findByIsFree", query = "SELECT p FROM PsCarrier p WHERE p.isFree = :isFree")
    , @NamedQuery(name = "PsCarrier.findByShippingExternal", query = "SELECT p FROM PsCarrier p WHERE p.shippingExternal = :shippingExternal")
    , @NamedQuery(name = "PsCarrier.findByNeedRange", query = "SELECT p FROM PsCarrier p WHERE p.needRange = :needRange")
    , @NamedQuery(name = "PsCarrier.findByExternalModuleName", query = "SELECT p FROM PsCarrier p WHERE p.externalModuleName = :externalModuleName")
    , @NamedQuery(name = "PsCarrier.findByShippingMethod", query = "SELECT p FROM PsCarrier p WHERE p.shippingMethod = :shippingMethod")
    , @NamedQuery(name = "PsCarrier.findByPosition", query = "SELECT p FROM PsCarrier p WHERE p.position = :position")
    , @NamedQuery(name = "PsCarrier.findByMaxWidth", query = "SELECT p FROM PsCarrier p WHERE p.maxWidth = :maxWidth")
    , @NamedQuery(name = "PsCarrier.findByMaxHeight", query = "SELECT p FROM PsCarrier p WHERE p.maxHeight = :maxHeight")
    , @NamedQuery(name = "PsCarrier.findByMaxDepth", query = "SELECT p FROM PsCarrier p WHERE p.maxDepth = :maxDepth")
    , @NamedQuery(name = "PsCarrier.findByMaxWeight", query = "SELECT p FROM PsCarrier p WHERE p.maxWeight = :maxWeight")
    , @NamedQuery(name = "PsCarrier.findByGrade", query = "SELECT p FROM PsCarrier p WHERE p.grade = :grade")})
public class PsCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private Integer idCarrier;
    @Basic(optional = false)
    @Column(name = "id_reference")
    private int idReference;
    @Column(name = "id_tax_rules_group")
    private Integer idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "shipping_handling")
    private boolean shippingHandling;
    @Basic(optional = false)
    @Column(name = "range_behavior")
    private boolean rangeBehavior;
    @Basic(optional = false)
    @Column(name = "is_module")
    private boolean isModule;
    @Basic(optional = false)
    @Column(name = "is_free")
    private boolean isFree;
    @Basic(optional = false)
    @Column(name = "shipping_external")
    private boolean shippingExternal;
    @Basic(optional = false)
    @Column(name = "need_range")
    private boolean needRange;
    @Column(name = "external_module_name")
    private String externalModuleName;
    @Basic(optional = false)
    @Column(name = "shipping_method")
    private int shippingMethod;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Column(name = "max_width")
    private Integer maxWidth;
    @Column(name = "max_height")
    private Integer maxHeight;
    @Column(name = "max_depth")
    private Integer maxDepth;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "max_weight")
    private BigDecimal maxWeight;
    @Column(name = "grade")
    private Integer grade;

    public PsCarrier() {
    }

    public PsCarrier(Integer idCarrier) {
        this.idCarrier = idCarrier;
    }

    public PsCarrier(Integer idCarrier, int idReference, String name, boolean active, boolean deleted, boolean shippingHandling, boolean rangeBehavior, boolean isModule, boolean isFree, boolean shippingExternal, boolean needRange, int shippingMethod, int position) {
        this.idCarrier = idCarrier;
        this.idReference = idReference;
        this.name = name;
        this.active = active;
        this.deleted = deleted;
        this.shippingHandling = shippingHandling;
        this.rangeBehavior = rangeBehavior;
        this.isModule = isModule;
        this.isFree = isFree;
        this.shippingExternal = shippingExternal;
        this.needRange = needRange;
        this.shippingMethod = shippingMethod;
        this.position = position;
    }

    public Integer getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(Integer idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdReference() {
        return idReference;
    }

    public void setIdReference(int idReference) {
        this.idReference = idReference;
    }

    public Integer getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getShippingHandling() {
        return shippingHandling;
    }

    public void setShippingHandling(boolean shippingHandling) {
        this.shippingHandling = shippingHandling;
    }

    public boolean getRangeBehavior() {
        return rangeBehavior;
    }

    public void setRangeBehavior(boolean rangeBehavior) {
        this.rangeBehavior = rangeBehavior;
    }

    public boolean getIsModule() {
        return isModule;
    }

    public void setIsModule(boolean isModule) {
        this.isModule = isModule;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean getShippingExternal() {
        return shippingExternal;
    }

    public void setShippingExternal(boolean shippingExternal) {
        this.shippingExternal = shippingExternal;
    }

    public boolean getNeedRange() {
        return needRange;
    }

    public void setNeedRange(boolean needRange) {
        this.needRange = needRange;
    }

    public String getExternalModuleName() {
        return externalModuleName;
    }

    public void setExternalModuleName(String externalModuleName) {
        this.externalModuleName = externalModuleName;
    }

    public int getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(int shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrier != null ? idCarrier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrier)) {
            return false;
        }
        PsCarrier other = (PsCarrier) object;
        if ((this.idCarrier == null && other.idCarrier != null) || (this.idCarrier != null && !this.idCarrier.equals(other.idCarrier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrier[ idCarrier=" + idCarrier + " ]";
    }
    
}
