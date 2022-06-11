/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_page_viewed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPageViewed.findAll", query = "SELECT p FROM PsPageViewed p")
    , @NamedQuery(name = "PsPageViewed.findByIdPage", query = "SELECT p FROM PsPageViewed p WHERE p.psPageViewedPK.idPage = :idPage")
    , @NamedQuery(name = "PsPageViewed.findByIdShopGroup", query = "SELECT p FROM PsPageViewed p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsPageViewed.findByIdShop", query = "SELECT p FROM PsPageViewed p WHERE p.psPageViewedPK.idShop = :idShop")
    , @NamedQuery(name = "PsPageViewed.findByIdDateRange", query = "SELECT p FROM PsPageViewed p WHERE p.psPageViewedPK.idDateRange = :idDateRange")
    , @NamedQuery(name = "PsPageViewed.findByCounter", query = "SELECT p FROM PsPageViewed p WHERE p.counter = :counter")})
public class PsPageViewed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPageViewedPK psPageViewedPK;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "counter")
    private int counter;

    public PsPageViewed() {
    }

    public PsPageViewed(PsPageViewedPK psPageViewedPK) {
        this.psPageViewedPK = psPageViewedPK;
    }

    public PsPageViewed(PsPageViewedPK psPageViewedPK, int idShopGroup, int counter) {
        this.psPageViewedPK = psPageViewedPK;
        this.idShopGroup = idShopGroup;
        this.counter = counter;
    }

    public PsPageViewed(int idPage, int idShop, int idDateRange) {
        this.psPageViewedPK = new PsPageViewedPK(idPage, idShop, idDateRange);
    }

    public PsPageViewedPK getPsPageViewedPK() {
        return psPageViewedPK;
    }

    public void setPsPageViewedPK(PsPageViewedPK psPageViewedPK) {
        this.psPageViewedPK = psPageViewedPK;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPageViewedPK != null ? psPageViewedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPageViewed)) {
            return false;
        }
        PsPageViewed other = (PsPageViewed) object;
        if ((this.psPageViewedPK == null && other.psPageViewedPK != null) || (this.psPageViewedPK != null && !this.psPageViewedPK.equals(other.psPageViewedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPageViewed[ psPageViewedPK=" + psPageViewedPK + " ]";
    }
    
}
