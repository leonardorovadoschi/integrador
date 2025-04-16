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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_client_service_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnClientServiceShop.findAll", query = "SELECT p FROM PsAnClientServiceShop p")})
public class PsAnClientServiceShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnClientServiceShopPK psAnClientServiceShopPK;

    public PsAnClientServiceShop() {
    }

    public PsAnClientServiceShop(PsAnClientServiceShopPK psAnClientServiceShopPK) {
        this.psAnClientServiceShopPK = psAnClientServiceShopPK;
    }

    public PsAnClientServiceShop(int idClientService, int idShop) {
        this.psAnClientServiceShopPK = new PsAnClientServiceShopPK(idClientService, idShop);
    }

    public PsAnClientServiceShopPK getPsAnClientServiceShopPK() {
        return psAnClientServiceShopPK;
    }

    public void setPsAnClientServiceShopPK(PsAnClientServiceShopPK psAnClientServiceShopPK) {
        this.psAnClientServiceShopPK = psAnClientServiceShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnClientServiceShopPK != null ? psAnClientServiceShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnClientServiceShop)) {
            return false;
        }
        PsAnClientServiceShop other = (PsAnClientServiceShop) object;
        if ((this.psAnClientServiceShopPK == null && other.psAnClientServiceShopPK != null) || (this.psAnClientServiceShopPK != null && !this.psAnClientServiceShopPK.equals(other.psAnClientServiceShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnClientServiceShop[ psAnClientServiceShopPK=" + psAnClientServiceShopPK + " ]";
    }
    
}
