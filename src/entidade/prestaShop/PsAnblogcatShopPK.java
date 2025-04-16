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
 * @author leo-note
 */
@Embeddable
public class PsAnblogcatShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private int idAnblogcat;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnblogcatShopPK() {
    }

    public PsAnblogcatShopPK(int idAnblogcat, int idShop) {
        this.idAnblogcat = idAnblogcat;
        this.idShop = idShop;
    }

    public int getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(int idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
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
        hash += (int) idAnblogcat;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogcatShopPK)) {
            return false;
        }
        PsAnblogcatShopPK other = (PsAnblogcatShopPK) object;
        if (this.idAnblogcat != other.idAnblogcat) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogcatShopPK[ idAnblogcat=" + idAnblogcat + ", idShop=" + idShop + " ]";
    }
    
}
