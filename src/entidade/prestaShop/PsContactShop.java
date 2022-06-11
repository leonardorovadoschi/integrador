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
@Table(name = "ps_contact_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsContactShop.findAll", query = "SELECT p FROM PsContactShop p")
    , @NamedQuery(name = "PsContactShop.findByIdContact", query = "SELECT p FROM PsContactShop p WHERE p.psContactShopPK.idContact = :idContact")
    , @NamedQuery(name = "PsContactShop.findByIdShop", query = "SELECT p FROM PsContactShop p WHERE p.psContactShopPK.idShop = :idShop")})
public class PsContactShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsContactShopPK psContactShopPK;

    public PsContactShop() {
    }

    public PsContactShop(PsContactShopPK psContactShopPK) {
        this.psContactShopPK = psContactShopPK;
    }

    public PsContactShop(int idContact, int idShop) {
        this.psContactShopPK = new PsContactShopPK(idContact, idShop);
    }

    public PsContactShopPK getPsContactShopPK() {
        return psContactShopPK;
    }

    public void setPsContactShopPK(PsContactShopPK psContactShopPK) {
        this.psContactShopPK = psContactShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psContactShopPK != null ? psContactShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsContactShop)) {
            return false;
        }
        PsContactShop other = (PsContactShop) object;
        if ((this.psContactShopPK == null && other.psContactShopPK != null) || (this.psContactShopPK != null && !this.psContactShopPK.equals(other.psContactShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsContactShop[ psContactShopPK=" + psContactShopPK + " ]";
    }
    
}
