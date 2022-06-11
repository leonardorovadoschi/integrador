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
@Table(name = "ps_pack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPack.findAll", query = "SELECT p FROM PsPack p")
    , @NamedQuery(name = "PsPack.findByIdProductPack", query = "SELECT p FROM PsPack p WHERE p.psPackPK.idProductPack = :idProductPack")
    , @NamedQuery(name = "PsPack.findByIdProductItem", query = "SELECT p FROM PsPack p WHERE p.psPackPK.idProductItem = :idProductItem")
    , @NamedQuery(name = "PsPack.findByIdProductAttributeItem", query = "SELECT p FROM PsPack p WHERE p.psPackPK.idProductAttributeItem = :idProductAttributeItem")
    , @NamedQuery(name = "PsPack.findByQuantity", query = "SELECT p FROM PsPack p WHERE p.quantity = :quantity")})
public class PsPack implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPackPK psPackPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;

    public PsPack() {
    }

    public PsPack(PsPackPK psPackPK) {
        this.psPackPK = psPackPK;
    }

    public PsPack(PsPackPK psPackPK, int quantity) {
        this.psPackPK = psPackPK;
        this.quantity = quantity;
    }

    public PsPack(int idProductPack, int idProductItem, int idProductAttributeItem) {
        this.psPackPK = new PsPackPK(idProductPack, idProductItem, idProductAttributeItem);
    }

    public PsPackPK getPsPackPK() {
        return psPackPK;
    }

    public void setPsPackPK(PsPackPK psPackPK) {
        this.psPackPK = psPackPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPackPK != null ? psPackPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPack)) {
            return false;
        }
        PsPack other = (PsPack) object;
        if ((this.psPackPK == null && other.psPackPK != null) || (this.psPackPK != null && !this.psPackPK.equals(other.psPackPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPack[ psPackPK=" + psPackPK + " ]";
    }
    
}
