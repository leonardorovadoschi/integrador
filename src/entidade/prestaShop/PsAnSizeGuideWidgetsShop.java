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
@Table(name = "ps_an_size_guide_widgets_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnSizeGuideWidgetsShop.findAll", query = "SELECT p FROM PsAnSizeGuideWidgetsShop p")})
public class PsAnSizeGuideWidgetsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnSizeGuideWidgetsShopPK psAnSizeGuideWidgetsShopPK;

    public PsAnSizeGuideWidgetsShop() {
    }

    public PsAnSizeGuideWidgetsShop(PsAnSizeGuideWidgetsShopPK psAnSizeGuideWidgetsShopPK) {
        this.psAnSizeGuideWidgetsShopPK = psAnSizeGuideWidgetsShopPK;
    }

    public PsAnSizeGuideWidgetsShop(int idWidget, int idShop) {
        this.psAnSizeGuideWidgetsShopPK = new PsAnSizeGuideWidgetsShopPK(idWidget, idShop);
    }

    public PsAnSizeGuideWidgetsShopPK getPsAnSizeGuideWidgetsShopPK() {
        return psAnSizeGuideWidgetsShopPK;
    }

    public void setPsAnSizeGuideWidgetsShopPK(PsAnSizeGuideWidgetsShopPK psAnSizeGuideWidgetsShopPK) {
        this.psAnSizeGuideWidgetsShopPK = psAnSizeGuideWidgetsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnSizeGuideWidgetsShopPK != null ? psAnSizeGuideWidgetsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnSizeGuideWidgetsShop)) {
            return false;
        }
        PsAnSizeGuideWidgetsShop other = (PsAnSizeGuideWidgetsShop) object;
        if ((this.psAnSizeGuideWidgetsShopPK == null && other.psAnSizeGuideWidgetsShopPK != null) || (this.psAnSizeGuideWidgetsShopPK != null && !this.psAnSizeGuideWidgetsShopPK.equals(other.psAnSizeGuideWidgetsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgetsShop[ psAnSizeGuideWidgetsShopPK=" + psAnSizeGuideWidgetsShopPK + " ]";
    }
    
}
