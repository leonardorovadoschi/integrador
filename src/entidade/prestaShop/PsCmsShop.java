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
 * @author leo
 */
@Entity
@Table(name = "ps_cms_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsShop.findAll", query = "SELECT p FROM PsCmsShop p")
    , @NamedQuery(name = "PsCmsShop.findByIdCms", query = "SELECT p FROM PsCmsShop p WHERE p.psCmsShopPK.idCms = :idCms")
    , @NamedQuery(name = "PsCmsShop.findByIdShop", query = "SELECT p FROM PsCmsShop p WHERE p.psCmsShopPK.idShop = :idShop")})
public class PsCmsShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsShopPK psCmsShopPK;

    public PsCmsShop() {
    }

    public PsCmsShop(PsCmsShopPK psCmsShopPK) {
        this.psCmsShopPK = psCmsShopPK;
    }

    public PsCmsShop(int idCms, int idShop) {
        this.psCmsShopPK = new PsCmsShopPK(idCms, idShop);
    }

    public PsCmsShopPK getPsCmsShopPK() {
        return psCmsShopPK;
    }

    public void setPsCmsShopPK(PsCmsShopPK psCmsShopPK) {
        this.psCmsShopPK = psCmsShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCmsShopPK != null ? psCmsShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsShop)) {
            return false;
        }
        PsCmsShop other = (PsCmsShop) object;
        if ((this.psCmsShopPK == null && other.psCmsShopPK != null) || (this.psCmsShopPK != null && !this.psCmsShopPK.equals(other.psCmsShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsShop[ psCmsShopPK=" + psCmsShopPK + " ]";
    }
    
}
