/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
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
 * @author leo-note
 */
@Entity
@Table(name = "ps_wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWishlist.findAll", query = "SELECT p FROM PsWishlist p")})
public class PsWishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wishlist")
    private Integer idWishlist;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Column(name = "id_shop")
    private Integer idShop;
    @Column(name = "id_shop_group")
    private Integer idShopGroup;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "counter")
    private Integer counter;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Column(name = "default")
    private Integer default1;

    public PsWishlist() {
    }

    public PsWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public PsWishlist(Integer idWishlist, int idCustomer, String token, String name, Date dateAdd, Date dateUpd) {
        this.idWishlist = idWishlist;
        this.idCustomer = idCustomer;
        this.token = token;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
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

    public Integer getDefault1() {
        return default1;
    }

    public void setDefault1(Integer default1) {
        this.default1 = default1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWishlist != null ? idWishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWishlist)) {
            return false;
        }
        PsWishlist other = (PsWishlist) object;
        if ((this.idWishlist == null && other.idWishlist != null) || (this.idWishlist != null && !this.idWishlist.equals(other.idWishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWishlist[ idWishlist=" + idWishlist + " ]";
    }
    
}
