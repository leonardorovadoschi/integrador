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
@Table(name = "ps_supplier_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSupplierShop.findAll", query = "SELECT p FROM PsSupplierShop p")
    , @NamedQuery(name = "PsSupplierShop.findByIdSupplier", query = "SELECT p FROM PsSupplierShop p WHERE p.psSupplierShopPK.idSupplier = :idSupplier")
    , @NamedQuery(name = "PsSupplierShop.findByIdShop", query = "SELECT p FROM PsSupplierShop p WHERE p.psSupplierShopPK.idShop = :idShop")})
public class PsSupplierShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSupplierShopPK psSupplierShopPK;

    public PsSupplierShop() {
    }

    public PsSupplierShop(PsSupplierShopPK psSupplierShopPK) {
        this.psSupplierShopPK = psSupplierShopPK;
    }

    public PsSupplierShop(int idSupplier, int idShop) {
        this.psSupplierShopPK = new PsSupplierShopPK(idSupplier, idShop);
    }

    public PsSupplierShopPK getPsSupplierShopPK() {
        return psSupplierShopPK;
    }

    public void setPsSupplierShopPK(PsSupplierShopPK psSupplierShopPK) {
        this.psSupplierShopPK = psSupplierShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSupplierShopPK != null ? psSupplierShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSupplierShop)) {
            return false;
        }
        PsSupplierShop other = (PsSupplierShop) object;
        if ((this.psSupplierShopPK == null && other.psSupplierShopPK != null) || (this.psSupplierShopPK != null && !this.psSupplierShopPK.equals(other.psSupplierShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSupplierShop[ psSupplierShopPK=" + psSupplierShopPK + " ]";
    }
    
}
