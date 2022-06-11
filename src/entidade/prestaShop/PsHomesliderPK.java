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
public class PsHomesliderPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_homeslider_slides")
    private int idHomesliderSlides;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsHomesliderPK() {
    }

    public PsHomesliderPK(int idHomesliderSlides, int idShop) {
        this.idHomesliderSlides = idHomesliderSlides;
        this.idShop = idShop;
    }

    public int getIdHomesliderSlides() {
        return idHomesliderSlides;
    }

    public void setIdHomesliderSlides(int idHomesliderSlides) {
        this.idHomesliderSlides = idHomesliderSlides;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idHomesliderSlides;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHomesliderPK)) {
            return false;
        }
        PsHomesliderPK other = (PsHomesliderPK) object;
        if (this.idHomesliderSlides != other.idHomesliderSlides) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHomesliderPK[ idHomesliderSlides=" + idHomesliderSlides + ", idShop=" + idShop + " ]";
    }
    
}
