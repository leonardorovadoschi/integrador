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
 * @author leo
 */
@Entity
@Table(name = "ps_pagenotfound")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPagenotfound.findAll", query = "SELECT p FROM PsPagenotfound p")
    , @NamedQuery(name = "PsPagenotfound.findByIdPagenotfound", query = "SELECT p FROM PsPagenotfound p WHERE p.idPagenotfound = :idPagenotfound")
    , @NamedQuery(name = "PsPagenotfound.findByIdShop", query = "SELECT p FROM PsPagenotfound p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsPagenotfound.findByIdShopGroup", query = "SELECT p FROM PsPagenotfound p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsPagenotfound.findByRequestUri", query = "SELECT p FROM PsPagenotfound p WHERE p.requestUri = :requestUri")
    , @NamedQuery(name = "PsPagenotfound.findByHttpReferer", query = "SELECT p FROM PsPagenotfound p WHERE p.httpReferer = :httpReferer")
    , @NamedQuery(name = "PsPagenotfound.findByDateAdd", query = "SELECT p FROM PsPagenotfound p WHERE p.dateAdd = :dateAdd")})
public class PsPagenotfound implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pagenotfound")
    private Integer idPagenotfound;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "request_uri")
    private String requestUri;
    @Basic(optional = false)
    @Column(name = "http_referer")
    private String httpReferer;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsPagenotfound() {
    }

    public PsPagenotfound(Integer idPagenotfound) {
        this.idPagenotfound = idPagenotfound;
    }

    public PsPagenotfound(Integer idPagenotfound, int idShop, int idShopGroup, String requestUri, String httpReferer, Date dateAdd) {
        this.idPagenotfound = idPagenotfound;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.requestUri = requestUri;
        this.httpReferer = httpReferer;
        this.dateAdd = dateAdd;
    }

    public Integer getIdPagenotfound() {
        return idPagenotfound;
    }

    public void setIdPagenotfound(Integer idPagenotfound) {
        this.idPagenotfound = idPagenotfound;
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

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagenotfound != null ? idPagenotfound.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPagenotfound)) {
            return false;
        }
        PsPagenotfound other = (PsPagenotfound) object;
        if ((this.idPagenotfound == null && other.idPagenotfound != null) || (this.idPagenotfound != null && !this.idPagenotfound.equals(other.idPagenotfound))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPagenotfound[ idPagenotfound=" + idPagenotfound + " ]";
    }
    
}
