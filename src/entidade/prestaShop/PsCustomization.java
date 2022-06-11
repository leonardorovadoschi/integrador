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
 * @author leo
 */
@Entity
@Table(name = "ps_customization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomization.findAll", query = "SELECT p FROM PsCustomization p")
    , @NamedQuery(name = "PsCustomization.findByIdCustomization", query = "SELECT p FROM PsCustomization p WHERE p.psCustomizationPK.idCustomization = :idCustomization")
    , @NamedQuery(name = "PsCustomization.findByIdProductAttribute", query = "SELECT p FROM PsCustomization p WHERE p.idProductAttribute = :idProductAttribute")
    , @NamedQuery(name = "PsCustomization.findByIdAddressDelivery", query = "SELECT p FROM PsCustomization p WHERE p.psCustomizationPK.idAddressDelivery = :idAddressDelivery")
    , @NamedQuery(name = "PsCustomization.findByIdCart", query = "SELECT p FROM PsCustomization p WHERE p.psCustomizationPK.idCart = :idCart")
    , @NamedQuery(name = "PsCustomization.findByIdProduct", query = "SELECT p FROM PsCustomization p WHERE p.psCustomizationPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsCustomization.findByQuantity", query = "SELECT p FROM PsCustomization p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PsCustomization.findByQuantityRefunded", query = "SELECT p FROM PsCustomization p WHERE p.quantityRefunded = :quantityRefunded")
    , @NamedQuery(name = "PsCustomization.findByQuantityReturned", query = "SELECT p FROM PsCustomization p WHERE p.quantityReturned = :quantityReturned")
    , @NamedQuery(name = "PsCustomization.findByInCart", query = "SELECT p FROM PsCustomization p WHERE p.inCart = :inCart")})
public class PsCustomization implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomizationPK psCustomizationPK;
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "quantity_refunded")
    private int quantityRefunded;
    @Basic(optional = false)
    @Column(name = "quantity_returned")
    private int quantityReturned;
    @Basic(optional = false)
    @Column(name = "in_cart")
    private boolean inCart;

    public PsCustomization() {
    }

    public PsCustomization(PsCustomizationPK psCustomizationPK) {
        this.psCustomizationPK = psCustomizationPK;
    }

    public PsCustomization(PsCustomizationPK psCustomizationPK, int idProductAttribute, int quantity, int quantityRefunded, int quantityReturned, boolean inCart) {
        this.psCustomizationPK = psCustomizationPK;
        this.idProductAttribute = idProductAttribute;
        this.quantity = quantity;
        this.quantityRefunded = quantityRefunded;
        this.quantityReturned = quantityReturned;
        this.inCart = inCart;
    }

    public PsCustomization(int idCustomization, int idAddressDelivery, int idCart, int idProduct) {
        this.psCustomizationPK = new PsCustomizationPK(idCustomization, idAddressDelivery, idCart, idProduct);
    }

    public PsCustomizationPK getPsCustomizationPK() {
        return psCustomizationPK;
    }

    public void setPsCustomizationPK(PsCustomizationPK psCustomizationPK) {
        this.psCustomizationPK = psCustomizationPK;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityRefunded() {
        return quantityRefunded;
    }

    public void setQuantityRefunded(int quantityRefunded) {
        this.quantityRefunded = quantityRefunded;
    }

    public int getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(int quantityReturned) {
        this.quantityReturned = quantityReturned;
    }

    public boolean getInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCustomizationPK != null ? psCustomizationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomization)) {
            return false;
        }
        PsCustomization other = (PsCustomization) object;
        if ((this.psCustomizationPK == null && other.psCustomizationPK != null) || (this.psCustomizationPK != null && !this.psCustomizationPK.equals(other.psCustomizationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomization[ psCustomizationPK=" + psCustomizationPK + " ]";
    }
    
}
