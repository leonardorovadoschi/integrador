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
public class PsAnProductextratabsLabelsShopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_label")
    private int idLabel;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnProductextratabsLabelsShopPK() {
    }

    public PsAnProductextratabsLabelsShopPK(int idLabel, int idShop) {
        this.idLabel = idLabel;
        this.idShop = idShop;
    }

    public int getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(int idLabel) {
        this.idLabel = idLabel;
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
        hash += (int) idLabel;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLabelsShopPK)) {
            return false;
        }
        PsAnProductextratabsLabelsShopPK other = (PsAnProductextratabsLabelsShopPK) object;
        if (this.idLabel != other.idLabel) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLabelsShopPK[ idLabel=" + idLabel + ", idShop=" + idShop + " ]";
    }
    
}
