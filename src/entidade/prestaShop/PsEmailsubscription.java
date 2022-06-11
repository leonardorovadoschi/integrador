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
@Table(name = "ps_emailsubscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEmailsubscription.findAll", query = "SELECT p FROM PsEmailsubscription p")
    , @NamedQuery(name = "PsEmailsubscription.findById", query = "SELECT p FROM PsEmailsubscription p WHERE p.id = :id")
    , @NamedQuery(name = "PsEmailsubscription.findByIdShop", query = "SELECT p FROM PsEmailsubscription p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsEmailsubscription.findByIdShopGroup", query = "SELECT p FROM PsEmailsubscription p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsEmailsubscription.findByEmail", query = "SELECT p FROM PsEmailsubscription p WHERE p.email = :email")
    , @NamedQuery(name = "PsEmailsubscription.findByNewsletterDateAdd", query = "SELECT p FROM PsEmailsubscription p WHERE p.newsletterDateAdd = :newsletterDateAdd")
    , @NamedQuery(name = "PsEmailsubscription.findByIpRegistrationNewsletter", query = "SELECT p FROM PsEmailsubscription p WHERE p.ipRegistrationNewsletter = :ipRegistrationNewsletter")
    , @NamedQuery(name = "PsEmailsubscription.findByHttpReferer", query = "SELECT p FROM PsEmailsubscription p WHERE p.httpReferer = :httpReferer")
    , @NamedQuery(name = "PsEmailsubscription.findByActive", query = "SELECT p FROM PsEmailsubscription p WHERE p.active = :active")
    , @NamedQuery(name = "PsEmailsubscription.findByIdLang", query = "SELECT p FROM PsEmailsubscription p WHERE p.idLang = :idLang")})
public class PsEmailsubscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "newsletter_date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newsletterDateAdd;
    @Basic(optional = false)
    @Column(name = "ip_registration_newsletter")
    private String ipRegistrationNewsletter;
    @Column(name = "http_referer")
    private String httpReferer;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsEmailsubscription() {
    }

    public PsEmailsubscription(Integer id) {
        this.id = id;
    }

    public PsEmailsubscription(Integer id, int idShop, int idShopGroup, String email, String ipRegistrationNewsletter, boolean active, int idLang) {
        this.id = id;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.email = email;
        this.ipRegistrationNewsletter = ipRegistrationNewsletter;
        this.active = active;
        this.idLang = idLang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNewsletterDateAdd() {
        return newsletterDateAdd;
    }

    public void setNewsletterDateAdd(Date newsletterDateAdd) {
        this.newsletterDateAdd = newsletterDateAdd;
    }

    public String getIpRegistrationNewsletter() {
        return ipRegistrationNewsletter;
    }

    public void setIpRegistrationNewsletter(String ipRegistrationNewsletter) {
        this.ipRegistrationNewsletter = ipRegistrationNewsletter;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmailsubscription)) {
            return false;
        }
        PsEmailsubscription other = (PsEmailsubscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmailsubscription[ id=" + id + " ]";
    }
    
}
