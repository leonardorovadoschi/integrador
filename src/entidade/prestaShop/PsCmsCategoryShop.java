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
@Table(name = "ps_cms_category_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsCategoryShop.findAll", query = "SELECT p FROM PsCmsCategoryShop p")
    , @NamedQuery(name = "PsCmsCategoryShop.findByIdCmsCategory", query = "SELECT p FROM PsCmsCategoryShop p WHERE p.psCmsCategoryShopPK.idCmsCategory = :idCmsCategory")
    , @NamedQuery(name = "PsCmsCategoryShop.findByIdShop", query = "SELECT p FROM PsCmsCategoryShop p WHERE p.psCmsCategoryShopPK.idShop = :idShop")})
public class PsCmsCategoryShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCmsCategoryShopPK psCmsCategoryShopPK;

    public PsCmsCategoryShop() {
    }

    public PsCmsCategoryShop(PsCmsCategoryShopPK psCmsCategoryShopPK) {
        this.psCmsCategoryShopPK = psCmsCategoryShopPK;
    }

    public PsCmsCategoryShop(int idCmsCategory, int idShop) {
        this.psCmsCategoryShopPK = new PsCmsCategoryShopPK(idCmsCategory, idShop);
    }

    public PsCmsCategoryShopPK getPsCmsCategoryShopPK() {
        return psCmsCategoryShopPK;
    }

    public void setPsCmsCategoryShopPK(PsCmsCategoryShopPK psCmsCategoryShopPK) {
        this.psCmsCategoryShopPK = psCmsCategoryShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCmsCategoryShopPK != null ? psCmsCategoryShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsCategoryShop)) {
            return false;
        }
        PsCmsCategoryShop other = (PsCmsCategoryShop) object;
        if ((this.psCmsCategoryShopPK == null && other.psCmsCategoryShopPK != null) || (this.psCmsCategoryShopPK != null && !this.psCmsCategoryShopPK.equals(other.psCmsCategoryShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsCategoryShop[ psCmsCategoryShopPK=" + psCmsCategoryShopPK + " ]";
    }
    
}
