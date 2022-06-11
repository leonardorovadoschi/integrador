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
@Table(name = "ps_product_carrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCarrier.findAll", query = "SELECT p FROM PsProductCarrier p")
    , @NamedQuery(name = "PsProductCarrier.findByIdProduct", query = "SELECT p FROM PsProductCarrier p WHERE p.psProductCarrierPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductCarrier.findByIdCarrierReference", query = "SELECT p FROM PsProductCarrier p WHERE p.psProductCarrierPK.idCarrierReference = :idCarrierReference")
    , @NamedQuery(name = "PsProductCarrier.findByIdShop", query = "SELECT p FROM PsProductCarrier p WHERE p.psProductCarrierPK.idShop = :idShop")})
public class PsProductCarrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCarrierPK psProductCarrierPK;

    public PsProductCarrier() {
    }

    public PsProductCarrier(PsProductCarrierPK psProductCarrierPK) {
        this.psProductCarrierPK = psProductCarrierPK;
    }

    public PsProductCarrier(int idProduct, int idCarrierReference, int idShop) {
        this.psProductCarrierPK = new PsProductCarrierPK(idProduct, idCarrierReference, idShop);
    }

    public PsProductCarrierPK getPsProductCarrierPK() {
        return psProductCarrierPK;
    }

    public void setPsProductCarrierPK(PsProductCarrierPK psProductCarrierPK) {
        this.psProductCarrierPK = psProductCarrierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCarrierPK != null ? psProductCarrierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCarrier)) {
            return false;
        }
        PsProductCarrier other = (PsProductCarrier) object;
        if ((this.psProductCarrierPK == null && other.psProductCarrierPK != null) || (this.psProductCarrierPK != null && !this.psProductCarrierPK.equals(other.psProductCarrierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCarrier[ psProductCarrierPK=" + psProductCarrierPK + " ]";
    }
    
}
