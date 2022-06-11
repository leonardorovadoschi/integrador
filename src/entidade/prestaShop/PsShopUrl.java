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
@Table(name = "ps_shop_url")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsShopUrl.findAll", query = "SELECT p FROM PsShopUrl p")
    , @NamedQuery(name = "PsShopUrl.findByIdShopUrl", query = "SELECT p FROM PsShopUrl p WHERE p.idShopUrl = :idShopUrl")
    , @NamedQuery(name = "PsShopUrl.findByIdShop", query = "SELECT p FROM PsShopUrl p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsShopUrl.findByDomain", query = "SELECT p FROM PsShopUrl p WHERE p.domain = :domain")
    , @NamedQuery(name = "PsShopUrl.findByDomainSsl", query = "SELECT p FROM PsShopUrl p WHERE p.domainSsl = :domainSsl")
    , @NamedQuery(name = "PsShopUrl.findByPhysicalUri", query = "SELECT p FROM PsShopUrl p WHERE p.physicalUri = :physicalUri")
    , @NamedQuery(name = "PsShopUrl.findByVirtualUri", query = "SELECT p FROM PsShopUrl p WHERE p.virtualUri = :virtualUri")
    , @NamedQuery(name = "PsShopUrl.findByMain", query = "SELECT p FROM PsShopUrl p WHERE p.main = :main")
    , @NamedQuery(name = "PsShopUrl.findByActive", query = "SELECT p FROM PsShopUrl p WHERE p.active = :active")})
public class PsShopUrl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_shop_url")
    private Integer idShopUrl;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "domain")
    private String domain;
    @Basic(optional = false)
    @Column(name = "domain_ssl")
    private String domainSsl;
    @Basic(optional = false)
    @Column(name = "physical_uri")
    private String physicalUri;
    @Basic(optional = false)
    @Column(name = "virtual_uri")
    private String virtualUri;
    @Basic(optional = false)
    @Column(name = "main")
    private boolean main;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsShopUrl() {
    }

    public PsShopUrl(Integer idShopUrl) {
        this.idShopUrl = idShopUrl;
    }

    public PsShopUrl(Integer idShopUrl, int idShop, String domain, String domainSsl, String physicalUri, String virtualUri, boolean main, boolean active) {
        this.idShopUrl = idShopUrl;
        this.idShop = idShop;
        this.domain = domain;
        this.domainSsl = domainSsl;
        this.physicalUri = physicalUri;
        this.virtualUri = virtualUri;
        this.main = main;
        this.active = active;
    }

    public Integer getIdShopUrl() {
        return idShopUrl;
    }

    public void setIdShopUrl(Integer idShopUrl) {
        this.idShopUrl = idShopUrl;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainSsl() {
        return domainSsl;
    }

    public void setDomainSsl(String domainSsl) {
        this.domainSsl = domainSsl;
    }

    public String getPhysicalUri() {
        return physicalUri;
    }

    public void setPhysicalUri(String physicalUri) {
        this.physicalUri = physicalUri;
    }

    public String getVirtualUri() {
        return virtualUri;
    }

    public void setVirtualUri(String virtualUri) {
        this.virtualUri = virtualUri;
    }

    public boolean getMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShopUrl != null ? idShopUrl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsShopUrl)) {
            return false;
        }
        PsShopUrl other = (PsShopUrl) object;
        if ((this.idShopUrl == null && other.idShopUrl != null) || (this.idShopUrl != null && !this.idShopUrl.equals(other.idShopUrl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsShopUrl[ idShopUrl=" + idShopUrl + " ]";
    }
    
}
