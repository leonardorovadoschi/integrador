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
@Table(name = "ps_anblog_likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogLikes.findAll", query = "SELECT p FROM PsAnblogLikes p")})
public class PsAnblogLikes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_like")
    private Integer idLike;
    @Basic(optional = false)
    @Column(name = "id_customer_guest")
    private int idCustomerGuest;
    @Basic(optional = false)
    @Column(name = "id_post")
    private int idPost;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsAnblogLikes() {
    }

    public PsAnblogLikes(Integer idLike) {
        this.idLike = idLike;
    }

    public PsAnblogLikes(Integer idLike, int idCustomerGuest, int idPost, int idShop, Date dateUpd) {
        this.idLike = idLike;
        this.idCustomerGuest = idCustomerGuest;
        this.idPost = idPost;
        this.idShop = idShop;
        this.dateUpd = dateUpd;
    }

    public Integer getIdLike() {
        return idLike;
    }

    public void setIdLike(Integer idLike) {
        this.idLike = idLike;
    }

    public int getIdCustomerGuest() {
        return idCustomerGuest;
    }

    public void setIdCustomerGuest(int idCustomerGuest) {
        this.idCustomerGuest = idCustomerGuest;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
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
        hash += (idLike != null ? idLike.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogLikes)) {
            return false;
        }
        PsAnblogLikes other = (PsAnblogLikes) object;
        if ((this.idLike == null && other.idLike != null) || (this.idLike != null && !this.idLike.equals(other.idLike))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogLikes[ idLike=" + idLike + " ]";
    }
    
}
