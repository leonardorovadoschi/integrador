/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_productextratabs_labels_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsLabelsShop.findAll", query = "SELECT p FROM PsAnProductextratabsLabelsShop p")})
public class PsAnProductextratabsLabelsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductextratabsLabelsShopPK psAnProductextratabsLabelsShopPK;

    public PsAnProductextratabsLabelsShop() {
    }

    public PsAnProductextratabsLabelsShop(PsAnProductextratabsLabelsShopPK psAnProductextratabsLabelsShopPK) {
        this.psAnProductextratabsLabelsShopPK = psAnProductextratabsLabelsShopPK;
    }

    public PsAnProductextratabsLabelsShop(int idLabel, int idShop) {
        this.psAnProductextratabsLabelsShopPK = new PsAnProductextratabsLabelsShopPK(idLabel, idShop);
    }

    public PsAnProductextratabsLabelsShopPK getPsAnProductextratabsLabelsShopPK() {
        return psAnProductextratabsLabelsShopPK;
    }

    public void setPsAnProductextratabsLabelsShopPK(PsAnProductextratabsLabelsShopPK psAnProductextratabsLabelsShopPK) {
        this.psAnProductextratabsLabelsShopPK = psAnProductextratabsLabelsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductextratabsLabelsShopPK != null ? psAnProductextratabsLabelsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLabelsShop)) {
            return false;
        }
        PsAnProductextratabsLabelsShop other = (PsAnProductextratabsLabelsShop) object;
        if ((this.psAnProductextratabsLabelsShopPK == null && other.psAnProductextratabsLabelsShopPK != null) || (this.psAnProductextratabsLabelsShopPK != null && !this.psAnProductextratabsLabelsShopPK.equals(other.psAnProductextratabsLabelsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLabelsShop[ psAnProductextratabsLabelsShopPK=" + psAnProductextratabsLabelsShopPK + " ]";
    }
    
}
