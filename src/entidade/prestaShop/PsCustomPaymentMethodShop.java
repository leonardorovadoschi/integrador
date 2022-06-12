/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fazenda
 */
@Entity
@Table(name = "ps_custom_payment_method_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomPaymentMethodShop.findAll", query = "SELECT p FROM PsCustomPaymentMethodShop p"),
    @NamedQuery(name = "PsCustomPaymentMethodShop.findByIdCustomPaymentMethod", query = "SELECT p FROM PsCustomPaymentMethodShop p WHERE p.psCustomPaymentMethodShopPK.idCustomPaymentMethod = :idCustomPaymentMethod"),
    @NamedQuery(name = "PsCustomPaymentMethodShop.findByIdShop", query = "SELECT p FROM PsCustomPaymentMethodShop p WHERE p.psCustomPaymentMethodShopPK.idShop = :idShop"),
    @NamedQuery(name = "PsCustomPaymentMethodShop.findByActive", query = "SELECT p FROM PsCustomPaymentMethodShop p WHERE p.active = :active")})
public class PsCustomPaymentMethodShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomPaymentMethodShopPK psCustomPaymentMethodShopPK;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;

    public PsCustomPaymentMethodShop() {
    }

    public PsCustomPaymentMethodShop(PsCustomPaymentMethodShopPK psCustomPaymentMethodShopPK) {
        this.psCustomPaymentMethodShopPK = psCustomPaymentMethodShopPK;
    }

    public PsCustomPaymentMethodShop(PsCustomPaymentMethodShopPK psCustomPaymentMethodShopPK, short active) {
        this.psCustomPaymentMethodShopPK = psCustomPaymentMethodShopPK;
        this.active = active;
    }

    public PsCustomPaymentMethodShop(int idCustomPaymentMethod, int idShop) {
        this.psCustomPaymentMethodShopPK = new PsCustomPaymentMethodShopPK(idCustomPaymentMethod, idShop);
    }

    public PsCustomPaymentMethodShopPK getPsCustomPaymentMethodShopPK() {
        return psCustomPaymentMethodShopPK;
    }

    public void setPsCustomPaymentMethodShopPK(PsCustomPaymentMethodShopPK psCustomPaymentMethodShopPK) {
        this.psCustomPaymentMethodShopPK = psCustomPaymentMethodShopPK;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCustomPaymentMethodShopPK != null ? psCustomPaymentMethodShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomPaymentMethodShop)) {
            return false;
        }
        PsCustomPaymentMethodShop other = (PsCustomPaymentMethodShop) object;
        if ((this.psCustomPaymentMethodShopPK == null && other.psCustomPaymentMethodShopPK != null) || (this.psCustomPaymentMethodShopPK != null && !this.psCustomPaymentMethodShopPK.equals(other.psCustomPaymentMethodShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomPaymentMethodShop[ psCustomPaymentMethodShopPK=" + psCustomPaymentMethodShopPK + " ]";
    }
    
}
