/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ps_connections")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConnections.findAll", query = "SELECT p FROM PsConnections p")
    , @NamedQuery(name = "PsConnections.findByIdConnections", query = "SELECT p FROM PsConnections p WHERE p.idConnections = :idConnections")
    , @NamedQuery(name = "PsConnections.findByIdShopGroup", query = "SELECT p FROM PsConnections p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsConnections.findByIdShop", query = "SELECT p FROM PsConnections p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsConnections.findByIdGuest", query = "SELECT p FROM PsConnections p WHERE p.idGuest = :idGuest")
    , @NamedQuery(name = "PsConnections.findByIdPage", query = "SELECT p FROM PsConnections p WHERE p.idPage = :idPage")
    , @NamedQuery(name = "PsConnections.findByIpAddress", query = "SELECT p FROM PsConnections p WHERE p.ipAddress = :ipAddress")
    , @NamedQuery(name = "PsConnections.findByDateAdd", query = "SELECT p FROM PsConnections p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsConnections.findByHttpReferer", query = "SELECT p FROM PsConnections p WHERE p.httpReferer = :httpReferer")})
public class PsConnections implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_connections")
    private Integer idConnections;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_guest")
    private int idGuest;
    @Basic(optional = false)
    @Column(name = "id_page")
    private int idPage;
    @Column(name = "ip_address")
    private BigInteger ipAddress;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Column(name = "http_referer")
    private String httpReferer;

    public PsConnections() {
    }

    public PsConnections(Integer idConnections) {
        this.idConnections = idConnections;
    }

    public PsConnections(Integer idConnections, int idShopGroup, int idShop, int idGuest, int idPage, Date dateAdd) {
        this.idConnections = idConnections;
        this.idShopGroup = idShopGroup;
        this.idShop = idShop;
        this.idGuest = idGuest;
        this.idPage = idPage;
        this.dateAdd = dateAdd;
    }

    public Integer getIdConnections() {
        return idConnections;
    }

    public void setIdConnections(Integer idConnections) {
        this.idConnections = idConnections;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public BigInteger getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(BigInteger ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConnections != null ? idConnections.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConnections)) {
            return false;
        }
        PsConnections other = (PsConnections) object;
        if ((this.idConnections == null && other.idConnections != null) || (this.idConnections != null && !this.idConnections.equals(other.idConnections))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConnections[ idConnections=" + idConnections + " ]";
    }
    
}
