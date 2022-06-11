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
@Table(name = "ps_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGroup.findAll", query = "SELECT p FROM PsGroup p")
    , @NamedQuery(name = "PsGroup.findByIdGroup", query = "SELECT p FROM PsGroup p WHERE p.idGroup = :idGroup")
    , @NamedQuery(name = "PsGroup.findByReduction", query = "SELECT p FROM PsGroup p WHERE p.reduction = :reduction")
    , @NamedQuery(name = "PsGroup.findByPriceDisplayMethod", query = "SELECT p FROM PsGroup p WHERE p.priceDisplayMethod = :priceDisplayMethod")
    , @NamedQuery(name = "PsGroup.findByShowPrices", query = "SELECT p FROM PsGroup p WHERE p.showPrices = :showPrices")
    , @NamedQuery(name = "PsGroup.findByDateAdd", query = "SELECT p FROM PsGroup p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsGroup.findByDateUpd", query = "SELECT p FROM PsGroup p WHERE p.dateUpd = :dateUpd")})
public class PsGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group")
    private Integer idGroup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "reduction")
    private BigDecimal reduction;
    @Basic(optional = false)
    @Column(name = "price_display_method")
    private short priceDisplayMethod;
    @Basic(optional = false)
    @Column(name = "show_prices")
    private boolean showPrices;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsGroup() {
    }

    public PsGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public PsGroup(Integer idGroup, BigDecimal reduction, short priceDisplayMethod, boolean showPrices, Date dateAdd, Date dateUpd) {
        this.idGroup = idGroup;
        this.reduction = reduction;
        this.priceDisplayMethod = priceDisplayMethod;
        this.showPrices = showPrices;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    public short getPriceDisplayMethod() {
        return priceDisplayMethod;
    }

    public void setPriceDisplayMethod(short priceDisplayMethod) {
        this.priceDisplayMethod = priceDisplayMethod;
    }

    public boolean getShowPrices() {
        return showPrices;
    }

    public void setShowPrices(boolean showPrices) {
        this.showPrices = showPrices;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroup)) {
            return false;
        }
        PsGroup other = (PsGroup) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroup[ idGroup=" + idGroup + " ]";
    }
    
}
