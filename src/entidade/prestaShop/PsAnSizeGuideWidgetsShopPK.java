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
public class PsAnSizeGuideWidgetsShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_widget")
    private int idWidget;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnSizeGuideWidgetsShopPK() {
    }

    public PsAnSizeGuideWidgetsShopPK(int idWidget, int idShop) {
        this.idWidget = idWidget;
        this.idShop = idShop;
    }

    public int getIdWidget() {
        return idWidget;
    }

    public void setIdWidget(int idWidget) {
        this.idWidget = idWidget;
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
        hash += (int) idWidget;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnSizeGuideWidgetsShopPK)) {
            return false;
        }
        PsAnSizeGuideWidgetsShopPK other = (PsAnSizeGuideWidgetsShopPK) object;
        if (this.idWidget != other.idWidget) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgetsShopPK[ idWidget=" + idWidget + ", idShop=" + idShop + " ]";
    }
    
}
