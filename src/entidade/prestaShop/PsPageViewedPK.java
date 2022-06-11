/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsPageViewedPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_page")
    private int idPage;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_date_range")
    private int idDateRange;

    public PsPageViewedPK() {
    }

    public PsPageViewedPK(int idPage, int idShop, int idDateRange) {
        this.idPage = idPage;
        this.idShop = idShop;
        this.idDateRange = idDateRange;
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdDateRange() {
        return idDateRange;
    }

    public void setIdDateRange(int idDateRange) {
        this.idDateRange = idDateRange;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPage;
        hash += (int) idShop;
        hash += (int) idDateRange;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPageViewedPK)) {
            return false;
        }
        PsPageViewedPK other = (PsPageViewedPK) object;
        if (this.idPage != other.idPage) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idDateRange != other.idDateRange) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPageViewedPK[ idPage=" + idPage + ", idShop=" + idShop + ", idDateRange=" + idDateRange + " ]";
    }
    
}
