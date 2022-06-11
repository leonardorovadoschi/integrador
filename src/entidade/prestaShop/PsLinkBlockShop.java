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
@Table(name = "ps_link_block_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLinkBlockShop.findAll", query = "SELECT p FROM PsLinkBlockShop p")
    , @NamedQuery(name = "PsLinkBlockShop.findByIdLinkBlock", query = "SELECT p FROM PsLinkBlockShop p WHERE p.psLinkBlockShopPK.idLinkBlock = :idLinkBlock")
    , @NamedQuery(name = "PsLinkBlockShop.findByIdShop", query = "SELECT p FROM PsLinkBlockShop p WHERE p.psLinkBlockShopPK.idShop = :idShop")})
public class PsLinkBlockShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLinkBlockShopPK psLinkBlockShopPK;

    public PsLinkBlockShop() {
    }

    public PsLinkBlockShop(PsLinkBlockShopPK psLinkBlockShopPK) {
        this.psLinkBlockShopPK = psLinkBlockShopPK;
    }

    public PsLinkBlockShop(int idLinkBlock, int idShop) {
        this.psLinkBlockShopPK = new PsLinkBlockShopPK(idLinkBlock, idShop);
    }

    public PsLinkBlockShopPK getPsLinkBlockShopPK() {
        return psLinkBlockShopPK;
    }

    public void setPsLinkBlockShopPK(PsLinkBlockShopPK psLinkBlockShopPK) {
        this.psLinkBlockShopPK = psLinkBlockShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLinkBlockShopPK != null ? psLinkBlockShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinkBlockShop)) {
            return false;
        }
        PsLinkBlockShop other = (PsLinkBlockShop) object;
        if ((this.psLinkBlockShopPK == null && other.psLinkBlockShopPK != null) || (this.psLinkBlockShopPK != null && !this.psLinkBlockShopPK.equals(other.psLinkBlockShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinkBlockShop[ psLinkBlockShopPK=" + psLinkBlockShopPK + " ]";
    }
    
}
