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
@Table(name = "ps_store_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStoreShop.findAll", query = "SELECT p FROM PsStoreShop p")
    , @NamedQuery(name = "PsStoreShop.findByIdStore", query = "SELECT p FROM PsStoreShop p WHERE p.psStoreShopPK.idStore = :idStore")
    , @NamedQuery(name = "PsStoreShop.findByIdShop", query = "SELECT p FROM PsStoreShop p WHERE p.psStoreShopPK.idShop = :idShop")})
public class PsStoreShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsStoreShopPK psStoreShopPK;

    public PsStoreShop() {
    }

    public PsStoreShop(PsStoreShopPK psStoreShopPK) {
        this.psStoreShopPK = psStoreShopPK;
    }

    public PsStoreShop(int idStore, int idShop) {
        this.psStoreShopPK = new PsStoreShopPK(idStore, idShop);
    }

    public PsStoreShopPK getPsStoreShopPK() {
        return psStoreShopPK;
    }

    public void setPsStoreShopPK(PsStoreShopPK psStoreShopPK) {
        this.psStoreShopPK = psStoreShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psStoreShopPK != null ? psStoreShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStoreShop)) {
            return false;
        }
        PsStoreShop other = (PsStoreShop) object;
        if ((this.psStoreShopPK == null && other.psStoreShopPK != null) || (this.psStoreShopPK != null && !this.psStoreShopPK.equals(other.psStoreShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStoreShop[ psStoreShopPK=" + psStoreShopPK + " ]";
    }
    
}
