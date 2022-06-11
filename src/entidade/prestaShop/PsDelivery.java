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
@Table(name = "ps_delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsDelivery.findAll", query = "SELECT p FROM PsDelivery p")
    , @NamedQuery(name = "PsDelivery.findByIdDelivery", query = "SELECT p FROM PsDelivery p WHERE p.idDelivery = :idDelivery")
    , @NamedQuery(name = "PsDelivery.findByIdShop", query = "SELECT p FROM PsDelivery p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsDelivery.findByIdShopGroup", query = "SELECT p FROM PsDelivery p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsDelivery.findByIdCarrier", query = "SELECT p FROM PsDelivery p WHERE p.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsDelivery.findByIdRangePrice", query = "SELECT p FROM PsDelivery p WHERE p.idRangePrice = :idRangePrice")
    , @NamedQuery(name = "PsDelivery.findByIdRangeWeight", query = "SELECT p FROM PsDelivery p WHERE p.idRangeWeight = :idRangeWeight")
    , @NamedQuery(name = "PsDelivery.findByIdZone", query = "SELECT p FROM PsDelivery p WHERE p.idZone = :idZone")
    , @NamedQuery(name = "PsDelivery.findByPrice", query = "SELECT p FROM PsDelivery p WHERE p.price = :price")})
public class PsDelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_delivery")
    private Integer idDelivery;
    @Column(name = "id_shop")
    private Integer idShop;
    @Column(name = "id_shop_group")
    private Integer idShopGroup;
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    @Column(name = "id_range_price")
    private Integer idRangePrice;
    @Column(name = "id_range_weight")
    private Integer idRangeWeight;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;

    public PsDelivery() {
    }

    public PsDelivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public PsDelivery(Integer idDelivery, int idCarrier, int idZone, BigDecimal price) {
        this.idDelivery = idDelivery;
        this.idCarrier = idCarrier;
        this.idZone = idZone;
        this.price = price;
    }

    public Integer getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(Integer idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public Integer getIdRangePrice() {
        return idRangePrice;
    }

    public void setIdRangePrice(Integer idRangePrice) {
        this.idRangePrice = idRangePrice;
    }

    public Integer getIdRangeWeight() {
        return idRangeWeight;
    }

    public void setIdRangeWeight(Integer idRangeWeight) {
        this.idRangeWeight = idRangeWeight;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelivery != null ? idDelivery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsDelivery)) {
            return false;
        }
        PsDelivery other = (PsDelivery) object;
        if ((this.idDelivery == null && other.idDelivery != null) || (this.idDelivery != null && !this.idDelivery.equals(other.idDelivery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsDelivery[ idDelivery=" + idDelivery + " ]";
    }
    
}
