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
@Table(name = "ps_warehouse_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWarehouseCarrier.findAll", query = "SELECT p FROM PsWarehouseCarrier p")
    , @NamedQuery(name = "PsWarehouseCarrier.findByIdCarrier", query = "SELECT p FROM PsWarehouseCarrier p WHERE p.psWarehouseCarrierPK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsWarehouseCarrier.findByIdWarehouse", query = "SELECT p FROM PsWarehouseCarrier p WHERE p.psWarehouseCarrierPK.idWarehouse = :idWarehouse")})
public class PsWarehouseCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsWarehouseCarrierPK psWarehouseCarrierPK;

    public PsWarehouseCarrier() {
    }

    public PsWarehouseCarrier(PsWarehouseCarrierPK psWarehouseCarrierPK) {
        this.psWarehouseCarrierPK = psWarehouseCarrierPK;
    }

    public PsWarehouseCarrier(int idCarrier, int idWarehouse) {
        this.psWarehouseCarrierPK = new PsWarehouseCarrierPK(idCarrier, idWarehouse);
    }

    public PsWarehouseCarrierPK getPsWarehouseCarrierPK() {
        return psWarehouseCarrierPK;
    }

    public void setPsWarehouseCarrierPK(PsWarehouseCarrierPK psWarehouseCarrierPK) {
        this.psWarehouseCarrierPK = psWarehouseCarrierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psWarehouseCarrierPK != null ? psWarehouseCarrierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWarehouseCarrier)) {
            return false;
        }
        PsWarehouseCarrier other = (PsWarehouseCarrier) object;
        if ((this.psWarehouseCarrierPK == null && other.psWarehouseCarrierPK != null) || (this.psWarehouseCarrierPK != null && !this.psWarehouseCarrierPK.equals(other.psWarehouseCarrierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWarehouseCarrier[ psWarehouseCarrierPK=" + psWarehouseCarrierPK + " ]";
    }
    
}
