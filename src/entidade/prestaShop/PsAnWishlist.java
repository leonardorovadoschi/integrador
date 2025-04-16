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
@Table(name = "ps_an_wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnWishlist.findAll", query = "SELECT p FROM PsAnWishlist p")})
public class PsAnWishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wishlist")
    private Integer idWishlist;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "is_guest")
    private int isGuest;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsAnWishlist() {
    }

    public PsAnWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public PsAnWishlist(Integer idWishlist, int idCustomer, int isGuest, int idShop, Date dateUpd) {
        this.idWishlist = idWishlist;
        this.idCustomer = idCustomer;
        this.isGuest = isGuest;
        this.idShop = idShop;
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

    public int getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(int isGuest) {
        this.isGuest = isGuest;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash += (idWishlist != null ? idWishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnWishlist)) {
            return false;
        }
        PsAnWishlist other = (PsAnWishlist) object;
        if ((this.idWishlist == null && other.idWishlist != null) || (this.idWishlist != null && !this.idWishlist.equals(other.idWishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnWishlist[ idWishlist=" + idWishlist + " ]";
    }
    
}
