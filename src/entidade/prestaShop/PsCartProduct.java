/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_cart_product")
@XmlRootElement

public class PsCartProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCartProductPK psCartProductPK;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsCartProduct() {
    }

    public PsCartProduct(PsCartProductPK psCartProductPK) {
        this.psCartProductPK = psCartProductPK;
    }

    public PsCartProduct(PsCartProductPK psCartProductPK, int idShop, int quantity, Date dateAdd) {
        this.psCartProductPK = psCartProductPK;
        this.idShop = idShop;
        this.quantity = quantity;
        this.dateAdd = dateAdd;
    }

    public PsCartProduct(int idCart, int idProduct, int idAddressDelivery, int idProductAttribute, int idCustomization) {
        this.psCartProductPK = new PsCartProductPK(idCart, idProduct, idAddressDelivery, idProductAttribute, idCustomization);
    }

    public PsCartProductPK getPsCartProductPK() {
        return psCartProductPK;
    }

    public void setPsCartProductPK(PsCartProductPK psCartProductPK) {
        this.psCartProductPK = psCartProductPK;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCartProductPK != null ? psCartProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCartProduct)) {
            return false;
        }
        PsCartProduct other = (PsCartProduct) object;
        if ((this.psCartProductPK == null && other.psCartProductPK != null) || (this.psCartProductPK != null && !this.psCartProductPK.equals(other.psCartProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCartProduct[ psCartProductPK=" + psCartProductPK + " ]";
    }
    
}
