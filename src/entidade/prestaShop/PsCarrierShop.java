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
@Table(name = "ps_carrier_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrierShop.findAll", query = "SELECT p FROM PsCarrierShop p")
    , @NamedQuery(name = "PsCarrierShop.findByIdCarrier", query = "SELECT p FROM PsCarrierShop p WHERE p.psCarrierShopPK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrierShop.findByIdShop", query = "SELECT p FROM PsCarrierShop p WHERE p.psCarrierShopPK.idShop = :idShop")})
public class PsCarrierShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCarrierShopPK psCarrierShopPK;

    public PsCarrierShop() {
    }

    public PsCarrierShop(PsCarrierShopPK psCarrierShopPK) {
        this.psCarrierShopPK = psCarrierShopPK;
    }

    public PsCarrierShop(int idCarrier, int idShop) {
        this.psCarrierShopPK = new PsCarrierShopPK(idCarrier, idShop);
    }

    public PsCarrierShopPK getPsCarrierShopPK() {
        return psCarrierShopPK;
    }

    public void setPsCarrierShopPK(PsCarrierShopPK psCarrierShopPK) {
        this.psCarrierShopPK = psCarrierShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCarrierShopPK != null ? psCarrierShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierShop)) {
            return false;
        }
        PsCarrierShop other = (PsCarrierShop) object;
        if ((this.psCarrierShopPK == null && other.psCarrierShopPK != null) || (this.psCarrierShopPK != null && !this.psCarrierShopPK.equals(other.psCarrierShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierShop[ psCarrierShopPK=" + psCarrierShopPK + " ]";
    }
    
}
