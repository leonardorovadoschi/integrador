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
@Table(name = "ps_zone_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsZoneShop.findAll", query = "SELECT p FROM PsZoneShop p")
    , @NamedQuery(name = "PsZoneShop.findByIdZone", query = "SELECT p FROM PsZoneShop p WHERE p.psZoneShopPK.idZone = :idZone")
    , @NamedQuery(name = "PsZoneShop.findByIdShop", query = "SELECT p FROM PsZoneShop p WHERE p.psZoneShopPK.idShop = :idShop")})
public class PsZoneShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsZoneShopPK psZoneShopPK;

    public PsZoneShop() {
    }

    public PsZoneShop(PsZoneShopPK psZoneShopPK) {
        this.psZoneShopPK = psZoneShopPK;
    }

    public PsZoneShop(int idZone, int idShop) {
        this.psZoneShopPK = new PsZoneShopPK(idZone, idShop);
    }

    public PsZoneShopPK getPsZoneShopPK() {
        return psZoneShopPK;
    }

    public void setPsZoneShopPK(PsZoneShopPK psZoneShopPK) {
        this.psZoneShopPK = psZoneShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psZoneShopPK != null ? psZoneShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsZoneShop)) {
            return false;
        }
        PsZoneShop other = (PsZoneShop) object;
        if ((this.psZoneShopPK == null && other.psZoneShopPK != null) || (this.psZoneShopPK != null && !this.psZoneShopPK.equals(other.psZoneShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsZoneShop[ psZoneShopPK=" + psZoneShopPK + " ]";
    }
    
}
