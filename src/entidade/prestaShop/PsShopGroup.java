/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_shop_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsShopGroup.findAll", query = "SELECT p FROM PsShopGroup p")
    , @NamedQuery(name = "PsShopGroup.findByIdShopGroup", query = "SELECT p FROM PsShopGroup p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsShopGroup.findByName", query = "SELECT p FROM PsShopGroup p WHERE p.name = :name")
    , @NamedQuery(name = "PsShopGroup.findByShareCustomer", query = "SELECT p FROM PsShopGroup p WHERE p.shareCustomer = :shareCustomer")
    , @NamedQuery(name = "PsShopGroup.findByShareOrder", query = "SELECT p FROM PsShopGroup p WHERE p.shareOrder = :shareOrder")
    , @NamedQuery(name = "PsShopGroup.findByShareStock", query = "SELECT p FROM PsShopGroup p WHERE p.shareStock = :shareStock")
    , @NamedQuery(name = "PsShopGroup.findByActive", query = "SELECT p FROM PsShopGroup p WHERE p.active = :active")
    , @NamedQuery(name = "PsShopGroup.findByDeleted", query = "SELECT p FROM PsShopGroup p WHERE p.deleted = :deleted")})
public class PsShopGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private Integer idShopGroup;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "share_customer")
    private boolean shareCustomer;
    @Basic(optional = false)
    @Column(name = "share_order")
    private boolean shareOrder;
    @Basic(optional = false)
    @Column(name = "share_stock")
    private boolean shareStock;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsShopGroup() {
    }

    public PsShopGroup(Integer idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public PsShopGroup(Integer idShopGroup, String name, boolean shareCustomer, boolean shareOrder, boolean shareStock, boolean active, boolean deleted) {
        this.idShopGroup = idShopGroup;
        this.name = name;
        this.shareCustomer = shareCustomer;
        this.shareOrder = shareOrder;
        this.shareStock = shareStock;
        this.active = active;
        this.deleted = deleted;
    }

    public Integer getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(Integer idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getShareCustomer() {
        return shareCustomer;
    }

    public void setShareCustomer(boolean shareCustomer) {
        this.shareCustomer = shareCustomer;
    }

    public boolean getShareOrder() {
        return shareOrder;
    }

    public void setShareOrder(boolean shareOrder) {
        this.shareOrder = shareOrder;
    }

    public boolean getShareStock() {
        return shareStock;
    }

    public void setShareStock(boolean shareStock) {
        this.shareStock = shareStock;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShopGroup != null ? idShopGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsShopGroup)) {
            return false;
        }
        PsShopGroup other = (PsShopGroup) object;
        if ((this.idShopGroup == null && other.idShopGroup != null) || (this.idShopGroup != null && !this.idShopGroup.equals(other.idShopGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsShopGroup[ idShopGroup=" + idShopGroup + " ]";
    }
    
}
