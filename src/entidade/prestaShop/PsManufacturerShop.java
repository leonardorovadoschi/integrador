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
@Table(name = "ps_manufacturer_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsManufacturerShop.findAll", query = "SELECT p FROM PsManufacturerShop p")
    , @NamedQuery(name = "PsManufacturerShop.findByIdManufacturer", query = "SELECT p FROM PsManufacturerShop p WHERE p.psManufacturerShopPK.idManufacturer = :idManufacturer")
    , @NamedQuery(name = "PsManufacturerShop.findByIdShop", query = "SELECT p FROM PsManufacturerShop p WHERE p.psManufacturerShopPK.idShop = :idShop")})
public class PsManufacturerShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsManufacturerShopPK psManufacturerShopPK;

    public PsManufacturerShop() {
    }

    public PsManufacturerShop(PsManufacturerShopPK psManufacturerShopPK) {
        this.psManufacturerShopPK = psManufacturerShopPK;
    }

    public PsManufacturerShop(int idManufacturer, int idShop) {
        this.psManufacturerShopPK = new PsManufacturerShopPK(idManufacturer, idShop);
    }

    public PsManufacturerShopPK getPsManufacturerShopPK() {
        return psManufacturerShopPK;
    }

    public void setPsManufacturerShopPK(PsManufacturerShopPK psManufacturerShopPK) {
        this.psManufacturerShopPK = psManufacturerShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psManufacturerShopPK != null ? psManufacturerShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsManufacturerShop)) {
            return false;
        }
        PsManufacturerShop other = (PsManufacturerShop) object;
        if ((this.psManufacturerShopPK == null && other.psManufacturerShopPK != null) || (this.psManufacturerShopPK != null && !this.psManufacturerShopPK.equals(other.psManufacturerShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsManufacturerShop[ psManufacturerShopPK=" + psManufacturerShopPK + " ]";
    }
    
}
