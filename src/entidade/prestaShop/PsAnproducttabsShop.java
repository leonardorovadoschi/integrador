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
@Table(name = "ps_anproducttabs_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabsShop.findAll", query = "SELECT p FROM PsAnproducttabsShop p")})
public class PsAnproducttabsShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnproducttabsShopPK psAnproducttabsShopPK;

    public PsAnproducttabsShop() {
    }

    public PsAnproducttabsShop(PsAnproducttabsShopPK psAnproducttabsShopPK) {
        this.psAnproducttabsShopPK = psAnproducttabsShopPK;
    }

    public PsAnproducttabsShop(int idAnproducttabs, int idShop) {
        this.psAnproducttabsShopPK = new PsAnproducttabsShopPK(idAnproducttabs, idShop);
    }

    public PsAnproducttabsShopPK getPsAnproducttabsShopPK() {
        return psAnproducttabsShopPK;
    }

    public void setPsAnproducttabsShopPK(PsAnproducttabsShopPK psAnproducttabsShopPK) {
        this.psAnproducttabsShopPK = psAnproducttabsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnproducttabsShopPK != null ? psAnproducttabsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsShop)) {
            return false;
        }
        PsAnproducttabsShop other = (PsAnproducttabsShop) object;
        if ((this.psAnproducttabsShopPK == null && other.psAnproducttabsShopPK != null) || (this.psAnproducttabsShopPK != null && !this.psAnproducttabsShopPK.equals(other.psAnproducttabsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsShop[ psAnproducttabsShopPK=" + psAnproducttabsShopPK + " ]";
    }
    
}
