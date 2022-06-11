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
@Table(name = "ps_warehouse_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWarehouseShop.findAll", query = "SELECT p FROM PsWarehouseShop p")
    , @NamedQuery(name = "PsWarehouseShop.findByIdShop", query = "SELECT p FROM PsWarehouseShop p WHERE p.psWarehouseShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsWarehouseShop.findByIdWarehouse", query = "SELECT p FROM PsWarehouseShop p WHERE p.psWarehouseShopPK.idWarehouse = :idWarehouse")})
public class PsWarehouseShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsWarehouseShopPK psWarehouseShopPK;

    public PsWarehouseShop() {
    }

    public PsWarehouseShop(PsWarehouseShopPK psWarehouseShopPK) {
        this.psWarehouseShopPK = psWarehouseShopPK;
    }

    public PsWarehouseShop(int idShop, int idWarehouse) {
        this.psWarehouseShopPK = new PsWarehouseShopPK(idShop, idWarehouse);
    }

    public PsWarehouseShopPK getPsWarehouseShopPK() {
        return psWarehouseShopPK;
    }

    public void setPsWarehouseShopPK(PsWarehouseShopPK psWarehouseShopPK) {
        this.psWarehouseShopPK = psWarehouseShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psWarehouseShopPK != null ? psWarehouseShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouseShop)) {
            return false;
        }
        PsWarehouseShop other = (PsWarehouseShop) object;
        if ((this.psWarehouseShopPK == null && other.psWarehouseShopPK != null) || (this.psWarehouseShopPK != null && !this.psWarehouseShopPK.equals(other.psWarehouseShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouseShop[ psWarehouseShopPK=" + psWarehouseShopPK + " ]";
    }
    
}
